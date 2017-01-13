

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class J48IterationModel {
	public J48IterationModel(){}
	
	public static double j48(Instances train, Instances test) throws Exception{
		J48 j48 = new J48();
		j48.buildClassifier(train);
		
		Evaluation eval =  new Evaluation(train);
		eval.evaluateModel(j48, test);
		
		return eval.pctCorrect();
	}
	
public double[][] j48Run(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek, double esikDegeri) throws Exception{
		
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
		    J48 tree = new J48();
					
			Instances deneme = new Instances(train, 0, yariEgitim);
							
				int a = 1,b=1,c = 1;
				while((a>0||b>0||c>0)&&unknown.numInstances()>0){
					a=0; b=0; c=0;
					tree.buildClassifier(deneme);
					for(int i=0; i<unknown.numInstances(); i++){
						double[] distribution = tree.distributionForInstance(unknown.instance(i));
						if(distribution[0]>esikDegeri){
							a++;
							unknown.instance(i).setClassValue(0.0);
							deneme.add(unknown.instance(i));
							unknown.delete(i);
						
						}
						if(distribution[1]>esikDegeri){
							b++;
							unknown.instance(i).setClassValue(1.0);
							deneme.add(unknown.instance(i));
							unknown.delete(i);
							
						}
						if(distribution[2]>esikDegeri){
							c++;
							unknown.instance(i).setClassValue(2.0);
							deneme.add(unknown.instance(i));
							unknown.delete(i);
							
						}
		
					}
					
				}
				sonuc[k][0]=J48IterationModel.j48(train, test1);
				sonuc[k][1]=J48IterationModel.j48(deneme, test1);
				sonuc[k][2]=J48IterationModel.j48(classified, test1);
				sonuc[k][3]=deneme.numInstances(); //egitilmis verinin buyuklugu 
				
				System.out.println("deneme count: " +sonuc[k][3]);
				System.out.println("it-max: " +sonuc[k][0]);
				System.out.println("sem: " +sonuc[k][1]);
				System.out.println("min: " +sonuc[k][2]);
			}
			
			
			return sonuc;			
		}

}
