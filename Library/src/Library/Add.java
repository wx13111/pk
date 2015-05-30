package Library;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import bookmodel.Num;
import control.BooknameControl;
import control.NumControl;
import control.PressControl;
import control.PriceControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.Color;

public class Add {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
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
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u4E66\u53F7");
		label.setBounds(53, 39, 54, 15);
		layeredPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(121, 36, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4E66\u540D");
		label_1.setBounds(230, 39, 54, 15);
		layeredPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(324, 36, 66, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u793E");
		label_2.setBounds(53, 77, 54, 15);
		layeredPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 74, 66, 21);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4EF7\u683C");
		label_3.setBounds(230, 77, 54, 15);
		layeredPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(324, 74, 66, 21);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u603B\u6570");
		label_4.setBounds(53, 121, 54, 15);
		layeredPane.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(121, 118, 66, 21);
		layeredPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("\u5165\u5E93");
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0&textField_1.getText().length()>0&textField_2.getText().length()>0&textField_3.getText().length()>0&
						textField_4.getText().length()>0)
				{
				int id =Integer.parseInt(textField.getText());
				String name =textField_1.getText();
				String Press =textField_2.getText();
				int Price =Integer.parseInt(textField_3.getText());
				int num =Integer.parseInt(textField_4.getText());
				BooknameControl.getBooknameControl(). saveBookname(id ,name);
				PressControl.getPressControl(). savePress(name ,Press);
				PriceControl.getPriceControl(). savePrice(name ,Price);
				 int Num = 0;
				 int Num2 = 0;
				for(int i= 0 ; i<NumControl.getNumControl().findNum(id).size(); i++){
		  		Num = ((Num)NumControl.getNumControl().findNum(id).get(i)).getSurNum();}
				for(int i= 0 ; i<NumControl.getNumControl().findNum(id).size(); i++){
		  		Num2 = ((Num)NumControl.getNumControl().findNum(id).get(i)).getLendNum();}
				for(int i= 0 ; i<NumControl.getNumControl().findNum(id).size(); i++){
				NumControl.getNumControl().deleteNum(id);}
				int i =num+Num;
				NumControl.getNumControl(). saveNum(id ,i,Num2);//num+lalala,lalalala
				}
				else{
					JOptionPane.showMessageDialog(frame, "\n 信息不能为空\n" +"","", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		button.setBounds(124, 205, 93, 23);
		layeredPane.add(button);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(280, 205, 93, 23);
		layeredPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 262);
		layeredPane.add(panel);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}
