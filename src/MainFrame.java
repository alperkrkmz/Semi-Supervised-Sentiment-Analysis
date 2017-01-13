import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public ParameterView parameterView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);

		
		JTabbedPane jtp = new JTabbedPane();
		getContentPane().add(jtp);
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		
		JLabel label1 = new JLabel();
		label1.setText("Parametre");
		JLabel label2 = new JLabel();
		label2.setText("RandomForest");
		JLabel label3 = new JLabel();
		label3.setText("NaiveBayes");
		JLabel label4 = new JLabel();
		label4.setText("J48");
		jp1.add(label1);
		jp2.add(label2);
		jp3.add(label3);
		jp4.add(label4);
		parameterView = new ParameterView();
		
		jtp.addTab("Parametre Ekrani", parameterView);
		jtp.addTab("RandomForest", parameterView.randomForestView);
		jtp.addTab("NaiveBayes", parameterView.naiveBayesView);
		jtp.addTab("J48", parameterView.j48View);
		
		

	}

}
