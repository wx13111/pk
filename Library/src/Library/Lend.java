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

import bookmodel.Bookname;
import bookmodel.Num;
import control.BooknameControl;
import control.LendControl;
import control.NumControl;
import control.TimeControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.Color;

public class Lend {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lend window = new Lend();
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
	public Lend() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 294, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(148, 44, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u4E66\u540D");
		label.setBounds(46, 47, 54, 15);
		layeredPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 89, 66, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6570\u76EE");
		label_1.setBounds(46, 92, 54, 15);
		layeredPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 139, 66, 21);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u501F\u4E66\u65E5\u671F");
		label_2.setBounds(46, 142, 54, 15);
		layeredPane.add(label_2);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0&textField_1.getText().length()>0&textField_2.getText().length()==8&textField_3.getText().length()>0
						)
				{
				String name =textField.getText();
				int num =Integer.parseInt(textField_1.getText());
				int time =Integer.parseInt(textField_2.getText());
				int id =Integer.parseInt(textField_3.getText());
				
				Integer bookid = null;
				for(int i= 0 ; i<BooknameControl.getBooknameControl().findBookname(name).size(); i++){
		  			  bookid = ((Bookname) BooknameControl.getBooknameControl().findBookname(name).get(i)).getBookId();}
				LendControl.getLendControl(). saveLend(id ,bookid);//后者ID为BOOKID  需要通过BOOKname查找
				int Num2 = 0;
				for(int i= 0 ; i<NumControl.getNumControl().findNum(bookid).size(); i++){
		  			  Num2 = ((Num)NumControl.getNumControl().findNum(bookid).get(i)).getSurNum();}
				for(int i= 0 ; i<NumControl.getNumControl().findNum(bookid).size(); i++){
				NumControl.getNumControl().deleteNum(bookid);}
				NumControl.getNumControl(). saveNum(bookid ,Num2-num,num);//此ID为BOOKID  需要通过BOOKname查找
			    TimeControl.getTimeControl(). saveTime(id ,time,null);
			    
			    
			    
				}
				else{
					JOptionPane.showMessageDialog(frame, "\n 请输入正确的信息\n" +"","", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		button.setBounds(46, 211, 78, 23);
		layeredPane.add(button);
		
		textField_3 = new JTextField();
		textField_3.setBounds(148, 179, 66, 21);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblid = new JLabel("\u501F\u4E66\u4EBAID");
		lblid.setBounds(46, 185, 54, 15);
		layeredPane.add(lblid);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(158, 211, 78, 23);
		layeredPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 278, 262);
		layeredPane.add(panel);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
