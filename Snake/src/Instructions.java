/*
 * Author: Chun-Kit Chung
 * Description: instructions frame for instructions on snake game
 * Date: 05/27/2018
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Instructions {

	private JFrame frame;
	int change = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructions window = new Instructions();
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
	public Instructions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//creates frame
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(50, 30, 805, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//create text area for instructions
		JTextArea instructions = new JTextArea();
		instructions.setEditable(false);
		instructions.setRows(4);
		instructions.setFont(new Font("Early GameBoy", Font.PLAIN, 20));
		instructions.setBackground(Color.BLACK);
		instructions.setForeground(Color.WHITE);
		instructions.setText(
				"Your goal is to move the snake and eat\r\nas many food blocks as possible. There \r\nis only one food block at any given time. \r\nWhen the food is eaten,the snake grows \r\nin length. If you hit the snake itself \r\nor the border of the game, you lose.");
		instructions.setBounds(34, 37, 755, 248);
		frame.getContentPane().add(instructions);

	
		frame.getContentPane().setFocusable(true);
		frame.getContentPane().addKeyListener(new KeyAdapter() {
			
			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {//if you press the left arrow key, it returns you back to the menu
					Menu menu = new Menu();
					menu.main(null);
					frame.setVisible(false);
				}
			}
		});
	}

	public void setForeground(Color red) {
		// TODO Auto-generated method stub
		
	}
}
