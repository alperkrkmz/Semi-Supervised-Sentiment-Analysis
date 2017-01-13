

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class NaiveBayesModel {
	public NaiveBayesModel(){}
	
	
	public static double naiveBayes(Instances train, Instances test) throws Exception{
		NaiveBayes nb = new NaiveBayes();
		nb.buildClassifier(train);
		
		Evaluation eval =  new Evaluation(train);
		eval.evaluateModel(nb, test);
		
		
		return eval.pctCorrect();
		
	}
	
	public double[][] nbRun(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek) throws Exception{
		
		double[][] sonuc = new double[5][3];
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
		    tree.buildClassifier(classified);
			Instances newunknown = new Instances(unknown);
			Instances newtrain = new Instances(classified);
			
			for(int i=0; i<unknown.numInstances(); i++){
				double clsLabel = tree.classifyInstance(unknown.instance(i));
				newunknown.instance(i).setClassValue(clsLabel);
				newtrain.add(newunknown.instance(i));
			}
			
			sonuc[k][0]=NaiveBayesModel.naiveBayes(train, test1);
			sonuc[k][1]=NaiveBayesModel.naiveBayes(newtrain, test1);
			sonuc[k][2]=NaiveBayesModel.naiveBayes(classified, test1);
			
			System.out.println("max: " +sonuc[k][0]);
			System.out.println("sem: " +sonuc[k][1]);
			System.out.println("min: " +sonuc[k][2]);
			
			
						
			}
		return sonuc;
		}
}
