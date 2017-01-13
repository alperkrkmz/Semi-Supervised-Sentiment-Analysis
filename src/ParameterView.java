import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class ParameterView extends JPanel {
	public JTextField textEgitimKumesi;
	public JTextField textYariEgitimKumesi;
	public JTextField textTotalData;

	JLabel lblMinimumEgitim;
	public NaiveBayesView naiveBayesView;
	public RandomForestView randomForestView;
	public J48View j48View;
	private JTextField textFieldNB;
	private JTextField textFieldRF;
	private JTextField textFieldJ48;
	public JLabel lblFilePath;
	String filePath = "";
	JLabel lblMinimum;
	JLabel lblTestSayisi;
	JLabel lblEgitilecekVeriSayisi;
	JLabel lblMinimumEgitimSayisi;
	JRadioButton rdbtnIterasyonIlemiUygulansn;
    JRadioButton rdbtnNormalIlemUygula;
    JRadioButton rdbtnNewRadioButton;
    JRadioButton rdbtnNewRadioButton_1 ;
    JRadioButton rdbtnNewRadioButton_2 ;
	public ParameterView() {
		setLayout(null);

		naiveBayesView = new NaiveBayesView();
		randomForestView = new RandomForestView();
		j48View = new J48View();
		
		JLabel lblEgitimSayisi = new JLabel("Eðitim Kümesi Sayýsýný Girininiz");
		lblEgitimSayisi.setBounds(18, 191, 220, 16);
		add(lblEgitimSayisi);

		textEgitimKumesi = new JTextField();
		textEgitimKumesi.setBounds(250, 186, 48, 26);
		add(textEgitimKumesi);

		JLabel lblEitimKmesiSaysn = new JLabel("Eðitim Kümesi Sayýsýný Girininiz");
		lblEitimKmesiSaysn.setBounds(18, 224, 220, 16);
		add(lblEitimKmesiSaysn);

		textYariEgitimKumesi = new JTextField();
		textYariEgitimKumesi.setBounds(250, 219, 48, 26);
		add(textYariEgitimKumesi);

		lblMinimum = new JLabel("Minimum Egitim Kumesi");
		lblMinimum.setBounds(18, 252, 181, 16);
		add(lblMinimum);
		
		lblMinimumEgitimSayisi = new JLabel("");
		lblMinimumEgitimSayisi.setBounds(250, 252, 51, 16);
		add(lblMinimumEgitimSayisi);
		lblMinimumEgitimSayisi.setBackground(Color.GRAY);
		lblMinimumEgitimSayisi.setOpaque(true);
		
		JLabel lblTest = new JLabel("Test Kumesi Sayisi");
		lblTest.setBounds(18, 280, 152, 16);
		add(lblTest);
		
		lblTestSayisi = new JLabel("");
		lblTestSayisi.setBounds(250, 280, 61, 16);
		add(lblTestSayisi);
		lblTestSayisi.setBackground(Color.GRAY);
		lblTestSayisi.setOpaque(true);
		
		
		JLabel lblEgitilecek = new JLabel("Egitilecek Veri Sayisi");
		lblEgitilecek.setBounds(310, 224, 143, 16);
		add(lblEgitilecek);
		
		lblEgitilecekVeriSayisi = new JLabel("");
		lblEgitilecekVeriSayisi.setBounds(465, 224, 61, 16);
		add(lblEgitilecekVeriSayisi);
		lblEgitilecekVeriSayisi.setBackground(Color.GRAY);
		lblEgitilecekVeriSayisi.setOpaque(true);

		JLabel lblToplamVeriSayisini = new JLabel("Toplam Veri Sayisini Giriniz");
		lblToplamVeriSayisini.setBounds(18, 163, 194, 16);
		add(lblToplamVeriSayisini);
		
		textTotalData = new JTextField();
		textTotalData.setBounds(250, 158, 48, 26);
		add(textTotalData);
		
		JButton btnOnayla = new JButton("Onayla");
		btnOnayla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total = Integer.parseInt(textTotalData.getText());
				int egitimSayisi = Integer.parseInt(textEgitimKumesi.getText());
				int test = total-egitimSayisi;
				int yariEgitim = Integer.parseInt(textYariEgitimKumesi.getText());
				int egitilecek = egitimSayisi - yariEgitim;
				
				lblTestSayisi.setText(Integer.toString(test));
				lblEgitilecekVeriSayisi.setText(Integer.toString(egitilecek));
				lblMinimumEgitimSayisi.setText(Integer.toString(yariEgitim));
				
			}
		});
		btnOnayla.setBounds(18, 369, 117, 29);
		add(btnOnayla);
		
		JButton btnCalistir = new JButton("Calistir");
		btnCalistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total = Integer.parseInt(textTotalData.getText());
				int egitimSayisi = Integer.parseInt(textEgitimKumesi.getText());
				int test = total-egitimSayisi;
				int yariEgitim = Integer.parseInt(textYariEgitimKumesi.getText());
				int egitilecek = egitimSayisi - yariEgitim;
				double nbEsik = Double.parseDouble(textFieldNB.getText())/100;
				double rfEsik = Double.parseDouble(textFieldNB.getText())/100;
				double j48Esik = Double.parseDouble(textFieldNB.getText())/100;
				try {
					if(rdbtnNormalIlemUygula.isSelected()){
				
						if(rdbtnNewRadioButton.isSelected()){
							rffunc(filePath, total, egitimSayisi, test, yariEgitim, egitilecek);

						}
						if(rdbtnNewRadioButton_1.isSelected()){
							nbfunc(filePath, total, egitimSayisi, test, yariEgitim, egitilecek);	

						}
						if(rdbtnNewRadioButton_2.isSelected()){
							j48func(filePath, total, egitimSayisi, test, yariEgitim, egitilecek);
						}
					}
					if(rdbtnIterasyonIlemiUygulansn.isSelected()){
						if(rdbtnNewRadioButton.isSelected()){
							rfIterfunc(filePath, total, egitimSayisi, test, yariEgitim, egitilecek, nbEsik);

						}
						if(rdbtnNewRadioButton_1.isSelected()){
							nbIterfunc(filePath, total, egitimSayisi, test, yariEgitim, egitilecek, nbEsik);

						}
						if(rdbtnNewRadioButton_2.isSelected()){
							j48Iterfunc(filePath, total, egitimSayisi, test, yariEgitim, egitilecek, j48Esik);
						}
					

					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		btnCalistir.setBounds(250, 369, 117, 29);
		add(btnCalistir);
		
		JLabel lblEsikDegeriNb = new JLabel("Esik Degeri NB");
		lblEsikDegeriNb.setBounds(18, 313, 99, 16);
		add(lblEsikDegeriNb);
		
		textFieldNB = new JTextField();
		textFieldNB.setBounds(16, 341, 40, 26);
		add(textFieldNB);
		textFieldNB.setColumns(10);
		
		JLabel lblEsikDegerRf = new JLabel("Esik Deger RF");
		lblEsikDegerRf.setBounds(143, 313, 95, 16);
		add(lblEsikDegerRf);
		
		JLabel lblEsikDegeriJ = new JLabel("Esik Degeri J48");
		lblEsikDegeriJ.setBounds(250, 313, 117, 16);
		add(lblEsikDegeriJ);
		
		textFieldRF = new JTextField();
		textFieldRF.setBounds(143, 341, 40, 26);
		add(textFieldRF);
		
		textFieldJ48 = new JTextField();
		textFieldJ48.setBounds(250, 341, 48, 26);
		add(textFieldJ48);
		
		lblFilePath = new JLabel("File Path");
		lblFilePath.setBounds(250, 122, 295, 16);
		add(lblFilePath);
		
		JButton btnFilePath = new JButton("Dosya Ac");
		btnFilePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		          System.out.println(selectedFile.getPath());
		          filePath = selectedFile.getPath();
		          lblFilePath.setText(filePath);
		        }
		      
			}
		});
		btnFilePath.setBounds(18, 122, 117, 29);
		add(btnFilePath);
		
		 rdbtnIterasyonIlemiUygulansn = new JRadioButton("\u0130terasyon \u0130\u015Flemi Uygulans\u0131n m\u0131 ?");
		rdbtnIterasyonIlemiUygulansn.setBounds(18, 407, 220, 25);
		add(rdbtnIterasyonIlemiUygulansn);
		
		rdbtnNormalIlemUygula = new JRadioButton("Normal \u0130\u015Flem Uygula");
		rdbtnNormalIlemUygula.setBounds(18, 438, 200, 25);
		add(rdbtnNormalIlemUygula);
		 rdbtnNewRadioButton = new JRadioButton("RandomForest");
		rdbtnNewRadioButton.setBounds(253, 409, 127, 25);
		add(rdbtnNewRadioButton);
		
	  rdbtnNewRadioButton_1 = new JRadioButton("NaiveBayes");
		rdbtnNewRadioButton_1.setBounds(399, 409, 127, 25);
		add(rdbtnNewRadioButton_1);
		
		  rdbtnNewRadioButton_2 = new JRadioButton("J48");
		rdbtnNewRadioButton_2.setBounds(541, 409, 127, 25);
		add(rdbtnNewRadioButton_2);

	}
	
	public void nbfunc(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek) throws Exception{
		//this.naiveBayesView.nbModel.nbRun(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek);
		this.naiveBayesView.nbCalistir(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek);
	}
	
	public void nbIterfunc(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek, double esik) throws Exception{
		this.naiveBayesView.nbIterCalistir(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek,esik);
	}
	
	public void rffunc(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek) throws Exception{
		this.randomForestView.rfCalistir(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek);
	}
	
	public void rfIterfunc(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek, double esik) throws Exception{
		this.randomForestView.rfIterCalistir(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek, esik);
	}
	
	public void j48func(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek) throws Exception{
		this.j48View.j48Calistir(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek);
	}
	
	public void j48Iterfunc(String dataYolu,int total, int egitimSayisi, int test, int yariEgitim, int egitilecek, double esik) throws Exception{
		this.j48View.j48IterCalistir(dataYolu, total, egitimSayisi, test, yariEgitim, egitilecek, esik);
	}
}