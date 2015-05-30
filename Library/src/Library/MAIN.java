package Library;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class MAIN {

	private JFrame frame;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN window = new MAIN();
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
	public MAIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 648, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JButton button = new JButton("\u5145\u503C");
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recharge Recharge = new Recharge();
				Recharge.getFrame().setVisible(true);

				
			}
		});
		button.setBounds(10, 10, 72, 50);
		layeredPane.add(button);
		
		JButton button_1 = new JButton("\u529E\u7406");
		button_1.setBackground(Color.GREEN);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Handle Handle = new Handle();
				Handle.getFrame().setVisible(true);

			}
		});
		button_1.setBounds(114, 10, 77, 50);
		layeredPane.add(button_1);
		
		JButton button_2 = new JButton("\u501F\u4E66");
		button_2.setBackground(Color.GREEN);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lend Lend = new Lend();
				Lend.getFrame().setVisible(true);
			}
		});
		button_2.setBounds(330, 10, 72, 50);
		layeredPane.add(button_2);
		
		JButton button_3 = new JButton("\u8FD8\u4E66");
		button_3.setBackground(Color.GREEN);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return Return = new Return();
				Return.getFrame().setVisible(true);
			}
		});
		button_3.setBounds(226, 10, 72, 50);
		layeredPane.add(button_3);
		
		JButton button_4 = new JButton("\u67E5\u8BE2");
		button_4.setBackground(Color.GREEN);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Query Query = new Query();
				Query.getFrame().setVisible(true);
			}
		});
		button_4.setBounds(434, 10, 77, 50);
		layeredPane.add(button_4);
		
		JButton button_5 = new JButton("\u589E\u4E66");
		button_5.setBackground(Color.GREEN);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add Add = new Add();
				Add.getFrame().setVisible(true);
			}
		});
		button_5.setBounds(545, 10, 77, 50);
		layeredPane.add(button_5);
		 ImageIcon icon1 = new ImageIcon("1.jpg");
		JButton btnNewButton = new JButton(icon1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 77, 612, 195);
		layeredPane.add(btnNewButton);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 632, 282);
		layeredPane.add(panel);
	}
}
