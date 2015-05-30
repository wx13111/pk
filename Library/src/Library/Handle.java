package Library;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import control.CusnameControl;
import control.CusphoneControl;
import control.MoneyControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.Color;

public class Handle {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Handle window = new Handle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Handle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 292, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(145, 43, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 96, 66, 21);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 151, 66, 21);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblid = new JLabel("\u7528\u6237ID");
		lblid.setBounds(46, 46, 54, 15);
		layeredPane.add(lblid);
		
		JLabel label_1 = new JLabel("\u7535\u8BDD");
		label_1.setBounds(46, 99, 54, 15);
		layeredPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u91D1\u989D");
		label_2.setBounds(46, 154, 54, 15);
		layeredPane.add(label_2);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0&textField_2.getText().length()==11&textField_3.getText().length()>0)
				{
				int id =Integer.parseInt(textField.getText());
			//	String name =textField_1.getText();
				String Phone =textField_2.getText();
				int Money =Integer.parseInt(textField_3.getText());
				
				CusphoneControl.getCusphoneControl(). saveCusphone(id ,Phone);
			    MoneyControl.getMoneyControl(). saveMoney(id ,Money);
			//    CusnameControl.getCusnameControl(). saveCusname(id ,name);
				}
				else{
					JOptionPane.showMessageDialog(frame, "\n 请输入正确的信息\n" +"","", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		button.setBounds(43, 212, 72, 23);
		layeredPane.add(button);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(156, 212, 77, 23);
		layeredPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 276, 261);
		layeredPane.add(panel);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}
