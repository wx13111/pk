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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bookmodel.Bookname;
import bookmodel.Money;
import bookmodel.Num;
import bookmodel.Press;
import bookmodel.Price;
import control.BooknameControl;
import control.MoneyControl;
import control.NumControl;
import control.PressControl;
import control.PriceControl;

import javax.swing.JPanel;

import java.awt.Color;

public class Query {


	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField textField_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query window = new Query();
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
	public Query() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 299, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(141, 33, 66, 21);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u4E66\u540D");
		label.setBounds(60, 36, 54, 15);
		layeredPane.add(label);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				String bookname = textField.getText();
				
				 Integer bookid = null;
				 Integer Num = null;
				 String Press1 = null;
				 Integer Price = null;
				for(int i= 0 ; i<BooknameControl.getBooknameControl().findBookname(bookname).size(); i++){
		  			  bookid = ((Bookname) BooknameControl.getBooknameControl().findBookname(bookname).get(i)).getBookId();}
		  			
					for(int i= 0 ; i<PressControl.getPressControl().findPress(bookname).size(); i++){
			  			  Press1 = ((Press) PressControl.getPressControl().findPress(bookname).get(i)).getPress();}
		  			
					for(int i= 0 ; i<PriceControl.getPriceControl().findPrice(bookname).size(); i++){
			  			  Price = ((Price) PriceControl.getPriceControl().findPrice(bookname).get(i)).getPrice();}
		  		
					for(int i= 0 ; i<NumControl.getNumControl().findNum(bookid).size(); i++){
			  			  Num = ((Num)NumControl.getNumControl().findNum(bookid).get(i)).getSurNum();}
		
		
					
			if(bookid!=null){
					table_1 = new JTable();
					table_1.setModel(new DefaultTableModel(
						new Object[][] {
								{"书名",bookname},
								{"书号", bookid},
								{"出版社", Press1},
								{"价格（元）", Price},
								{"库存数目", Num},
						},
						new String[] {
							"New column", "New column"
						}
					));
					table_1.setBounds(60, 97, 130, 80);
					layeredPane.add(table_1);
			}
			else{
				JOptionPane.showMessageDialog(frame, "\n 此书不存在\n" +"","", JOptionPane.PLAIN_MESSAGE);
			}
					
					int id =Integer.parseInt(textField_1.getText());
				
					int money=0;
					for(int i= 0 ; i<MoneyControl.getMoneyControl().findMoney(id).size(); i++){
						money = ((Money) MoneyControl.getMoneyControl().findMoney(id).get(i)).getMoney();}
					if(money!=0){
					table_2 = new JTable();
					table_2.setModel(new DefaultTableModel(
						new Object[][] {
							{"顾客ID", id},
							{"余额", money},
						},
						new String[] {
							"New column", "New column"
						}
					));
					table_2.setBounds(61, 180, 128, 31);
					layeredPane.add(table_2);
					}
					else{
						JOptionPane.showMessageDialog(frame, "\n 此ID不存在\n" +"","", JOptionPane.PLAIN_MESSAGE);
					}
				
					if(money<0)
					{
						
					}
				
			}
		});
		button.setBounds(23, 246, 71, 23);
		layeredPane.add(button);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(141, 246, 76, 23);
		layeredPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 59, 66, 21);
		layeredPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblid = new JLabel("\u987E\u5BA2ID");
		lblid.setBounds(60, 61, 54, 15);
		layeredPane.add(lblid);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 283, 297);
		layeredPane.add(panel);

		

		
	
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
