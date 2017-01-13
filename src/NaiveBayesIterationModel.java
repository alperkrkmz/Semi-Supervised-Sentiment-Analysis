

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class NaiveBayesIterationModel {
	public NaiveBayesIterationModel(){}
	
	
	
	public static double naiveBayes(Instances train, Instances test) throws Exception{
		NaiveBayes nb = new NaiveBayes();
		nb.buildClassifier(train);
		
		Evaluation eval =  new Evaluation(train);
		eval.evaluateModel(nb, test);
		
		
		return eval.pctCorrect();
		
	}
	
	public double[][] nbRun(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek, double esikDegeri) throws Exception{
		
		double[][] sonuc = new double[5][4];
		Random rnd = new Random(12);
		DataSource source = new DataSource(dataYolu);
		Instances data = source.getDataSet();
		
		data.setClassIndex(data.numAttributes()-1);	
		
		
		Instances train=null;
		Instances test1=null;
		
		for(int k=0; k<5; k++){
			data.randomize(rnd);
			train = new Instances(data, 0, egitimSayisi);
			train.setClassIndex(train.numAttributes()-1);
		

			test1 = new Instances(data, egitimSayisi, test-1);
	
			
			train.randomize(rnd);
			Instances classified = new Instances(train, 0, yariEgitim);
			Instances unknown = new Instances(train, yariEgitim, egitilecek);
		    NaiveBayes tree = new NaiveBayes();
					
			Instances deneme = new Instances(train, 0, yariEgitim);
							
				int a = 1,b=1,c = 1;
				while((a>0||b>0||c>0)&&unknown.numInstances()>0){
					a=0; b=0; c=0;
					tree.buildClassifier(deneme);
					for(int i=0; i<unknown.numInstances(); i++){
						double clsLabel = tree.classifyInstance(unknown.instance(i));
						double[] distribution = tree.distributionForInstance(unknown.instance(i));
						if(distribution[0]>esikDegeri){
							a++;
							unknown.instance(i).setClassValue(clsLabel);
							deneme.add(unknown.instance(i));
							unknown.delete(i);
						
						}
						if(distribution[1]>esikDegeri){
							b++;
							unknown.instance(i).setClassValue(clsLabel);
							deneme.add(unknown.instance(i));
							unknown.delete(i);
							
						}
						if(distribution[2]>esikDegeri){
							c++;
							unknown.instance(i).setClassValue(clsLabel);
							deneme.add(unknown.instance(i));
							unknown.delete(i);
							
						}
		
					}
					
				}
				sonuc[k][0]=NaiveBayesIterationModel.naiveBayes(train, test1);
				sonuc[k][1]=NaiveBayesIterationModel.naiveBayes(deneme, test1);
				sonuc[k][2]=NaiveBayesIterationModel.naiveBayes(classified, test1);
				sonuc[k][3]=deneme.numInstances(); //egitilmis verinin buyuklugu 
				
				System.out.println("deneme count: " +sonuc[k][3]);
				System.out.println("it-max: " +sonuc[k][0]);
				System.out.println("sem: " +sonuc[k][1]);
				System.out.println("min: " +sonuc[k][2]);
				
			}
			
			
			return sonuc;			
		}
}
