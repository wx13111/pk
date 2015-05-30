package Library;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import bookmodel.Money;
import control.MoneyControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class Recharge {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recharge window = new Recharge();
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
	public Recharge() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 295, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(133, 58, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 132, 66, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblid = new JLabel("\u7528\u6237ID");
		lblid.setBounds(37, 61, 54, 15);
		layeredPane.add(lblid);
		
		JLabel label = new JLabel("\u5145\u503C\u91D1\u989D");
		label.setBounds(37, 135, 54, 15);
		layeredPane.add(label);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id =Integer.parseInt(textField.getText());
				int Money =Integer.parseInt(textField_1.getText());
				int qian = 0;
				for(int i= 0 ; i<MoneyControl.getMoneyControl().findMoney(id).size(); i++){
				qian=( (Money) MoneyControl.getMoneyControl().findMoney(id).get(i)).getMoney(); 
				 MoneyControl.getMoneyControl().deleteMoney(id);
				}
				 MoneyControl.getMoneyControl(). saveMoney(id ,Money+qian);
				 //此money需要加上原来的money
			}
		});
		button.setBounds(37, 211, 78, 23);
		layeredPane.add(button);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(145, 211, 78, 23);
		layeredPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 279, 263);
		layeredPane.add(panel);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
