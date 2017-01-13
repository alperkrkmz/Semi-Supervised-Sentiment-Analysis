
import javax.swing.JPanel;
import javax.swing.JLabel;

public class NaiveBayesView extends JPanel {
	public NaiveBayesModel nbModel = new NaiveBayesModel();
	public NaiveBayesIterationModel nbIterModel = new NaiveBayesIterationModel();
	JLabel labelMaxValue;
	JLabel labelSemValue;
	JLabel labelMinValue;
	JLabel lblIterMax ;
	JLabel lblIterMin;
	JLabel lblIterSem;
	
	public NaiveBayesView() {
		setLayout(null);

		JLabel lblNaiveBayesIterasyonsuz = new JLabel("Naive Bayes Iterasyonsuz");
		lblNaiveBayesIterasyonsuz.setBounds(6, 31, 175, 16);
		add(lblNaiveBayesIterasyonsuz);
		
		JLabel lblSem = new JLabel("Sem");
		lblSem.setBounds(12, 332, 61, 16);
		add(lblSem);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setBounds(6, 499, 61, 16);
		add(lblMin);
		
		 labelMaxValue = new JLabel("0.0");
		labelMaxValue.setBounds(79, 82, 126, 170);
		add(labelMaxValue);
		
		 labelSemValue = new JLabel("1.0");
		labelSemValue.setBounds(79, 265, 151, 150);
		add(labelSemValue);
		
		 labelMinValue = new JLabel("2.0");
		labelMinValue.setBounds(78, 428, 139, 158);
		add(labelMinValue);
		
		JLabel lblNaiveBayesIterasyonlu = new JLabel("Naive Bayes Iterasyonlu");
		lblNaiveBayesIterasyonlu.setBounds(237, 31, 151, 16);
		add(lblNaiveBayesIterasyonlu);
		
		JLabel lblMax_1 = new JLabel("Max");
		lblMax_1.setBounds(237, 150, 61, 16);
		add(lblMax_1);
		
		JLabel lblSem_1 = new JLabel("Sem");
		lblSem_1.setBounds(237, 332, 61, 16);
		add(lblSem_1);
		
		JLabel lblMin_1 = new JLabel("Min");
		lblMin_1.setBounds(247, 499, 61, 16);
		add(lblMin_1);
		
		lblIterMax= new JLabel("0.0");
		lblIterMax.setBounds(324, 95, 153, 157);
		add(lblIterMax);
		
		 lblIterSem = new JLabel("1.0");
		 lblIterSem.setBounds(310, 265, 166, 150);
		add(lblIterSem);
		
		lblIterMin = new JLabel("2.0");
		lblIterMin.setBounds(320, 399, 166, 188);
		add(lblIterMin);
		
		JLabel lblMax = new JLabel("Max");
		lblMax.setBounds(6, 144, 61, 16);
		add(lblMax);
		
		JLabel lblYeniEtikletliVeri = new JLabel("Yeni Etikletli Veri Sayisi");
		lblYeniEtikletliVeri.setBounds(237, 603, 151, 16);
		add(lblYeniEtikletliVeri);
		
		JLabel lblEtiketValue = new JLabel("Etiket");
		lblEtiketValue.setBounds(400, 603, 61, 16);
		add(lblEtiketValue);
		
		JLabel lblKalanEtiketsizVeri = new JLabel("Kalan Etiketsiz Veri Sayisi");
		lblKalanEtiketsizVeri.setBounds(237, 632, 153, 16);
		add(lblKalanEtiketsizVeri);
		
		JLabel lblEtiketsizValue = new JLabel("Etiketsiz");
		lblEtiketsizValue.setBounds(397, 632, 61, 16);
		add(lblEtiketsizValue);

	}
	public void nbCalistir(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek) throws Exception{
		double[][] sonuc = new double[5][3]; 
		sonuc=	this.nbModel.nbRun(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek);
		labelMaxValue.setText("<html> 1- "+sonuc[0][0]+"<br/>2- "+sonuc[1][0]+"<br/>3- "+sonuc[2][0]+"<br/>4- "+sonuc[3][0]+"<br/>5- "+sonuc[4][0]+"<br/></html>");
		labelSemValue.setText("<html> 1- "+sonuc[0][1]+"<br/>2- "+sonuc[1][1]+"<br/>3- "+sonuc[2][1]+"<br/>4- "+sonuc[3][1]+"<br/>5- "+sonuc[4][1]+"<br/></html>");
		labelMinValue.setText("<html> 1- "+sonuc[0][2]+"<br/>2- "+sonuc[1][2]+"<br/>3- "+sonuc[2][2]+"<br/>4- "+sonuc[3][2]+"<br/>5- "+sonuc[4][2]+"<br/></html>");

	}
	public void nbIterCalistir(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek,double esik) throws Exception{
		double[][] sonuc = new double[5][4]; 
		sonuc=	this.nbIterModel.nbRun(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek,esik);
		lblIterMax.setText("<html> 1- "+sonuc[0][0]+"<br/>2- "+sonuc[1][0]+"<br/>3- "+sonuc[2][0]+"<br/>4- "+sonuc[3][0]+"<br/>5- "+sonuc[4][0]+"<br/></html>");
		lblIterSem.setText("<html> 1- "+sonuc[0][1]+"<br/>2- "+sonuc[1][1]+"<br/>3- "+sonuc[2][1]+"<br/>4- "+sonuc[3][1]+"<br/>5- "+sonuc[4][1]+"<br/></html>");
		lblIterMin.setText("<html> 1- "+sonuc[0][2]+"<br/>2- "+sonuc[1][2]+"<br/>3- "+sonuc[2][2]+"<br/>4- "+sonuc[3][2]+"<br/>5- "+sonuc[4][2]+"<br/></html>");

	}
}