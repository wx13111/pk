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
import bookmodel.Money;
import bookmodel.Num;
import control.BooknameControl;
import control.LendControl;
import control.MoneyControl;
import control.NumControl;
import control.TimeControl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class Return {

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
					Return window = new Return();
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
	public Return() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 295, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(146, 48, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u4E66\u540D");
		label.setBounds(54, 51, 54, 15);
		layeredPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 79, 66, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6570\u76EE");
		label_1.setBounds(54, 82, 54, 15);
		layeredPane.add(label_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =textField.getText();
				int num =Integer.parseInt(textField_1.getText());
				int time =Integer.parseInt(textField_3.getText());
				int id =Integer.parseInt(textField_2.getText());
				Integer bookid = null;
				if(textField.getText().length()>0&textField_2.getText().length()>0&textField_3.getText().length()>0&textField_1.getText().length()>0)
				{
				for(int i= 0 ; i<BooknameControl.getBooknameControl().findBookname(name).size(); i++){
		  			  bookid = ((Bookname) BooknameControl.getBooknameControl().findBookname(name).get(i)).getBookId();}
				for(int i= 0 ; i<LendControl.getLendControl().findLend(bookid).size(); i++){
				LendControl.getLendControl(). deleteLend(bookid);//后者ID为BOOKID  需要通过BOOKname查找	
				}
				int Num2 = 0;
				for(int i= 0 ; i<NumControl.getNumControl().findNum(bookid).size(); i++){
		  			  Num2 = ((Num)NumControl.getNumControl().findNum(bookid).get(i)).getSurNum();}
				int Num3 = 0;
				for(int i= 0; i<NumControl.getNumControl().findNum(bookid).size(); i++){
		  			  Num3 = ((Num)NumControl.getNumControl().findNum(bookid).get(i)).getLendNum();}
				for(int i= 0 ; i<NumControl.getNumControl().findNum(bookid).size(); i++){
				NumControl.getNumControl().deleteNum(bookid);}
				NumControl.getNumControl(). saveNum(bookid ,num+Num2,Num3-num);//此ID为BOOKID  需要通过BOOKname查找，第一个NUM需要和原来的相加  第二个需要和原来的相减
			    TimeControl.getTimeControl(). saveTime(id ,null,time);
			    
			    
				int money=0;
				for(int i= 0 ; i<MoneyControl.getMoneyControl().findMoney(id).size(); i++){
					money = ((Money) MoneyControl.getMoneyControl().findMoney(id).get(i)).getMoney();
					 MoneyControl.getMoneyControl().deleteMoney(id);}
				money=money-(time*num);
				 MoneyControl.getMoneyControl(). saveMoney(id ,money);
				if(money<0){JOptionPane.showMessageDialog(frame, "\n 余额不足\n" +"","", JOptionPane.PLAIN_MESSAGE);}
			}
				
				else{
					JOptionPane.showMessageDialog(frame, "\n 输入信息错误\n" +"","", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		button.setBounds(54, 197, 66, 23);
		layeredPane.add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 122, 66, 21);
		layeredPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblid = new JLabel("\u987E\u5BA2ID");
		lblid.setBounds(54, 125, 54, 15);
		layeredPane.add(lblid);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 162, 66, 21);
		layeredPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u501F\u4E66\u5929\u6570");
		label_2.setBounds(54, 165, 54, 15);
		layeredPane.add(label_2);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(156, 197, 66, 23);
		layeredPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 279, 264);
		layeredPane.add(panel);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}
