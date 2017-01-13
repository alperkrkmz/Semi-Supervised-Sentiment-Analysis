import javax.swing.JPanel;
import javax.swing.JLabel;

public class J48View extends JPanel {

	J48IterationModel j48IterModel = new J48IterationModel();
	J48Model j48Model = new J48Model();
	JLabel labelMaxValue;
	JLabel labelSemValue;
	JLabel labelMinValue;
	JLabel lblIterMax;
	JLabel lblIterMin;
	JLabel lblIterSem;
	public J48View() {
		setLayout(null);
		
		JLabel lblNaiveBayesIterasyonsuz = new JLabel("J48 Iterasyonsuz");
		lblNaiveBayesIterasyonsuz.setBounds(6, 31, 175, 16);
		add(lblNaiveBayesIterasyonsuz);
		
		JLabel lblMax = new JLabel("Max");
		lblMax.setBounds(6, 154, 61, 16);
		add(lblMax);
		
		JLabel lblSem = new JLabel("Sem");
		lblSem.setBounds(6, 301, 61, 16);
		add(lblSem);
		
		JLabel lblMin = new JLabel("Min");
		lblMin.setBounds(6, 464, 61, 16);
		add(lblMin);
		
		 labelMaxValue = new JLabel("0.0");
		labelMaxValue.setBounds(79, 82, 146, 160);
		add(labelMaxValue);
		
		 labelSemValue = new JLabel("1.0");
		labelSemValue.setBounds(79, 262, 129, 134);
		add(labelSemValue);
		
		 labelMinValue = new JLabel("2.0");
		labelMinValue.setBounds(79, 409, 146, 141);
		add(labelMinValue);
		
		JLabel lblNaiveBayesIterasyonlu = new JLabel("J48 \u0130terasyonlu Sonu\u00E7lar");
		lblNaiveBayesIterasyonlu.setBounds(237, 31, 224, 16);
		add(lblNaiveBayesIterasyonlu);
		
		JLabel lblMax_1 = new JLabel("Max");
		lblMax_1.setBounds(237, 154, 61, 16);
		add(lblMax_1);
		
		JLabel lblSem_1 = new JLabel("Sem");
		lblSem_1.setBounds(237, 301, 61, 16);
		add(lblSem_1);
		
		JLabel lblMin_1 = new JLabel("Min");
		lblMin_1.setBounds(237, 464, 61, 16);
		add(lblMin_1);
		
		lblIterMax = new JLabel("0.0");
		lblIterMax.setBounds(310, 99, 247, 126);
		add(lblIterMax);
		
		 lblIterSem = new JLabel("1.0");
		 lblIterSem.setBounds(311, 246, 260, 126);
		add(lblIterSem);
		
		lblIterMin = new JLabel("2.0");
		lblIterMin.setBounds(324, 400, 260, 160);
		add(lblIterMin);
		
		JLabel lblYeniEtikletliVeri = new JLabel("Yeni Etikletli Veri Sayisi");
		lblYeniEtikletliVeri.setBounds(224, 573, 151, 16);
		add(lblYeniEtikletliVeri);
		
		JLabel lblEtiketValue = new JLabel("Etiket");
		lblEtiketValue.setBounds(419, 573, 61, 16);
		add(lblEtiketValue);
		
		JLabel lblKalanEtiketsizVeri = new JLabel("Kalan Etiketsiz Veri Sayisi");
		lblKalanEtiketsizVeri.setBounds(224, 599, 170, 16);
		add(lblKalanEtiketsizVeri);
		
		JLabel lblEtiketsizValue = new JLabel("Etiketsiz");
		lblEtiketsizValue.setBounds(419, 599, 61, 16);
		add(lblEtiketsizValue);

	}
	public void j48Calistir(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek) throws Exception{
		double[][] sonuc = this.j48Model.j48Run(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek);
		labelMaxValue.setText("<html> 1- "+sonuc[0][0]+"<br/>2- "+sonuc[1][0]+"<br/>3- "+sonuc[2][0]+"<br/>4- "+sonuc[3][0]+"<br/>5- "+sonuc[4][0]+"<br/></html>");
		labelSemValue.setText("<html> 1- "+sonuc[0][1]+"<br/>2- "+sonuc[1][1]+"<br/>3- "+sonuc[2][1]+"<br/>4- "+sonuc[3][1]+"<br/>5- "+sonuc[4][1]+"<br/></html>");
		labelMinValue.setText("<html> 1- "+sonuc[0][2]+"<br/>2- "+sonuc[1][2]+"<br/>3- "+sonuc[2][2]+"<br/>4- "+sonuc[3][2]+"<br/>5- "+sonuc[4][2]+"<br/></html>");

	}
	public void j48IterCalistir(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek,double esik) throws Exception{
		double[][] sonuc = this.j48IterModel.j48Run(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek,esik);
		lblIterMax.setText("<html> 1- "+sonuc[0][0]+"<br/>2- "+sonuc[1][0]+"<br/>3- "+sonuc[2][0]+"<br/>4- "+sonuc[3][0]+"<br/>5- "+sonuc[4][0]+"<br/></html>");
		lblIterSem.setText("<html> 1- "+sonuc[0][1]+"<br/>2- "+sonuc[1][1]+"<br/>3- "+sonuc[2][1]+"<br/>4- "+sonuc[3][1]+"<br/>5- "+sonuc[4][1]+"<br/></html>");
		lblIterMin.setText("<html> 1- "+sonuc[0][2]+"<br/>2- "+sonuc[1][2]+"<br/>3- "+sonuc[2][2]+"<br/>4- "+sonuc[3][2]+"<br/>5- "+sonuc[4][2]+"<br/></html>");

	}	
	

}
