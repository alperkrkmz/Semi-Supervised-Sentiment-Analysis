

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class RandomForestIterationModel {
	public RandomForestIterationModel(){}



	public static double randomForest(Instances train, Instances test) throws Exception{
		RandomForest rf = new RandomForest();
		rf.buildClassifier(train);
		
		Evaluation eval =  new Evaluation(train);
		eval.evaluateModel(rf, test);
		
		return eval.pctCorrect();
	}
	
	public double[][] rfRun(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek, double esikDegeri) throws Exception{
		
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
		    RandomForest tree = new RandomForest();
					
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
				sonuc[k][0]=RandomForestIterationModel.randomForest(train, test1);
				sonuc[k][1]=RandomForestIterationModel.randomForest(deneme, test1);
				sonuc[k][2]=RandomForestIterationModel.randomForest(classified, test1);
				sonuc[k][3]=deneme.numInstances(); //egitilmis verinin buyuklugu 
				
								
				System.out.println("deneme count: " +sonuc[k][3]);
				System.out.println("it-max: " +sonuc[k][0]);
				System.out.println("sem: " +sonuc[k][1]);
				System.out.println("min: " +sonuc[k][2]);
				
			}
			
			
			return sonuc;			
		}
}
