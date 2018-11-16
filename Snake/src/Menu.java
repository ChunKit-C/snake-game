/*
 * Author: Chun-Kit Chung
 * Description: menu frame for game
 * Date: 05/23/2018
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.JCheckBox;

public class Menu {

	public static JLabel lblSnake;
	public static JLabel lblPlay;
	public static JLabel lblInstructions;
	public static JLabel lblRainbowMode;
	public static JLabel lblExit;
	public static String power = "off";
	public static String rain = null;
	private JFrame menu;
	boolean colourSwitch = false;
	int change = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//creates frame
		menu = new JFrame();
		menu.getContentPane().setBackground(Color.BLACK);
		menu.setBounds(50, 30, 805, 700);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);

		//label for title
		JLabel lblSnake = new JLabel("SNAKE");
		lblSnake.setForeground(Color.WHITE);
		lblSnake.setFont(new Font("Early GameBoy", Font.PLAIN, 40));
		lblSnake.setBounds(142, 21, 217, 72);
		menu.getContentPane().add(lblSnake);

		//label for play button
		JLabel lblPlay = new JLabel(") Play )");
		lblPlay.setForeground(Color.WHITE);
		lblPlay.setFont(new Font("Early GameBoy", Font.PLAIN, 30));
		lblPlay.setBounds(149, 98, 210, 38);
		menu.getContentPane().add(lblPlay);

		//label for Instructions button
		JLabel lblInstructions = new JLabel("  Instructions");
		lblInstructions.setForeground(Color.WHITE);
		lblInstructions.setFont(new Font("Early GameBoy", Font.PLAIN, 30));
		lblInstructions.setBounds(145, 135, 488, 38);
		menu.getContentPane().add(lblInstructions);

		//label for Exit button
		JLabel lblExit = new JLabel("  Exit");
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Early GameBoy", Font.PLAIN, 30));
		lblExit.setBounds(149, 212, 319, 38);
		menu.getContentPane().add(lblExit);

		menu.getContentPane().setFocusable(true);

		//label for Rainbow Mode button
		JLabel lblRainbowMode = new JLabel("  Rainbow Mode {off}");
		lblRainbowMode.setFont(new Font("Early GameBoy", Font.PLAIN, 30));
		lblRainbowMode.setForeground(Color.WHITE);
		lblRainbowMode.setBounds(150, 176, 694, 38);
		menu.getContentPane().add(lblRainbowMode);
		
		//label for navigation instructions
		JLabel lblNavigation = new JLabel("Use arrow keys and enter to navigate");
		lblNavigation.setForeground(Color.WHITE);
		lblNavigation.setFont(new Font("Early GameBoy", Font.PLAIN, 23));
		lblNavigation.setBounds(10, 612, 769, 38);
		menu.getContentPane().add(lblNavigation);

		menu.getContentPane().addKeyListener(new KeyAdapter() {
			String play = null;
			String inst = null;
			String exit = null;

			@SuppressWarnings("static-access")
			public void keyPressed(KeyEvent e) {

				//////////////////// Down Arrow or S Key Pressed\\\\\\\\\\\\\\\\\\\

				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) { //if statement for moving down in the menu
					play = lblPlay.getText();
					inst = lblInstructions.getText();
					rain = lblRainbowMode.getText();
					exit = lblExit.getText();

					//if statements create animation to show which button the player is selecting
					if (play.contains(") Play )")) {
						lblInstructions.setText(") Instructions )");
						lblPlay.setText("Play");
					} else if (inst.contains(") Instructions )")) {
						lblRainbowMode.setText(") Rainbow Mode {" + power + "} )");
						lblInstructions.setText("Instructions");
					} else if (rain.contains(") Rainbow Mode {off} )")) {
						lblExit.setText(") Exit )");
						lblRainbowMode.setText("Rainbow Mode {off}");
					} else if (rain.contains(") Rainbow Mode {on} )")) {
						lblExit.setText(") Exit )");
						lblRainbowMode.setText("Rainbow Mode {on}");
					} else if (exit.contains(") Exit )")) {
						lblPlay.setText(") Play )");
						lblExit.setText("Exit");
					}

				}

				//////////////////// Up Arrow or W Key Pressed\\\\\\\\\\\\\\\\\\\

				if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {//if statement for moving up in the menu
					play = lblPlay.getText();
					inst = lblInstructions.getText();
					rain = lblRainbowMode.getText();
					exit = lblExit.getText();

					//if statements create animation to show which button the player is selecting
					if (play.contains(") Play )")) {
						lblExit.setText(") Exit )");
						lblPlay.setText("Play");
					} else if (exit.contains(") Exit )")) {
						lblRainbowMode.setText(") Rainbow Mode {" + power + "} )");
						lblExit.setText("Exit");
					} else if (rain.contains(") Rainbow Mode {off} )")) {
						lblInstructions.setText(") Instructions )");
						lblRainbowMode.setText("Rainbow Mode {off}");
					} else if (rain.contains(") Rainbow Mode {on} )")) {
						lblInstructions.setText(") Instructions )");
						lblRainbowMode.setText("Rainbow Mode {on}");
					} else if (inst.contains(") Instructions )")) {
						lblPlay.setText(") Play )");
						lblInstructions.setText("Instructions");
					}
				}
				//////////////////// Enter Key or Right Arrow or D Key \\\\\\\\\\\\\\\\\\\\\
				//////////////////// Pressed \\\\\\\\\\\\\\\\\\\\\

				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_RIGHT
						|| e.getKeyCode() == KeyEvent.VK_D) {//if statement for hitting enter or right for a label in the menu
					play = lblPlay.getText();
					inst = lblInstructions.getText();
					rain = lblRainbowMode.getText();
					exit = lblExit.getText();
					
					if (play.contains(") Play )")) { //if you enter the play label, it starts the game
						Snake game = new Snake();
						game.main(null);
						menu.setVisible(false);
					} else if (inst.contains(") Instructions )")) {//if you enter the Instructions label, it displays how to play snake
						Instructions instructions = new Instructions();
						instructions.main(null);
						menu.setVisible(false);
					} else if (rain.contains(") Rainbow Mode {off} )")) {//if you turn on the Rainbow Mode label, it makes all the text rainbow colours
						power = "on";
						lblRainbowMode.setText(") Rainbow Mode {" + power + "} )");
						colourSwitch = true;
						change = 1;
							ActionListener color = new ActionListener() {
								
								public void actionPerformed(ActionEvent ae) {
									
									switch (change) {
									case 1:
										lblSnake.setForeground(Color.RED);
										lblPlay.setForeground(Color.RED);
										lblInstructions.setForeground(Color.RED);
										lblRainbowMode.setForeground(Color.RED);
										lblExit.setForeground(Color.RED);
										lblNavigation.setForeground(Color.RED);
										change++;
										break;
									case 2:
										lblSnake.setForeground(Color.ORANGE);
										lblPlay.setForeground(Color.ORANGE);
										lblInstructions.setForeground(Color.ORANGE);
										lblRainbowMode.setForeground(Color.ORANGE);
										lblExit.setForeground(Color.ORANGE);
										lblNavigation.setForeground(Color.ORANGE);
										change++;
										break;
									case 3:
										lblSnake.setForeground(Color.YELLOW);
										lblPlay.setForeground(Color.YELLOW);
										lblInstructions.setForeground(Color.YELLOW);
										lblRainbowMode.setForeground(Color.YELLOW);
										lblExit.setForeground(Color.YELLOW);
										lblNavigation.setForeground(Color.YELLOW);
										change++;
										break;
									case 4:
										lblSnake.setForeground(Color.GREEN);
										lblPlay.setForeground(Color.GREEN);
										lblInstructions.setForeground(Color.GREEN);
										lblRainbowMode.setForeground(Color.GREEN);
										lblExit.setForeground(Color.GREEN);
										lblNavigation.setForeground(Color.GREEN);
										change++;
										break;
									case 5:
										lblSnake.setForeground(Color.BLUE);
										lblPlay.setForeground(Color.BLUE);
										lblInstructions.setForeground(Color.BLUE);
										lblRainbowMode.setForeground(Color.BLUE);
										lblExit.setForeground(Color.BLUE);
										lblNavigation.setForeground(Color.BLUE);
										change++;
										break;
									case 6:
										lblSnake.setForeground(Color.MAGENTA);
										lblPlay.setForeground(Color.MAGENTA);
										lblInstructions.setForeground(Color.MAGENTA);
										lblRainbowMode.setForeground(Color.MAGENTA);
										lblExit.setForeground(Color.MAGENTA);
										lblNavigation.setForeground(Color.MAGENTA);
										change++;
										break;
									case 7:
										lblSnake.setForeground(Color.CYAN);
										lblPlay.setForeground(Color.CYAN);
										lblInstructions.setForeground(Color.CYAN);
										lblRainbowMode.setForeground(Color.CYAN);
										lblExit.setForeground(Color.CYAN);
										lblNavigation.setForeground(Color.CYAN);
										change++;
										break;
									case 8:
										lblSnake.setForeground(Color.MAGENTA);
										lblPlay.setForeground(Color.MAGENTA);
										lblInstructions.setForeground(Color.MAGENTA);
										lblRainbowMode.setForeground(Color.MAGENTA);
										lblExit.setForeground(Color.MAGENTA);
										lblNavigation.setForeground(Color.MAGENTA);
										change++;
										break;
									case 9:
										lblSnake.setForeground(Color.BLUE);
										lblPlay.setForeground(Color.BLUE);
										lblInstructions.setForeground(Color.BLUE);
										lblRainbowMode.setForeground(Color.BLUE);
										lblExit.setForeground(Color.BLUE);
										lblNavigation.setForeground(Color.BLUE);
										change++;
										break;
									case 10:
										lblSnake.setForeground(Color.GREEN);
										lblPlay.setForeground(Color.GREEN);
										lblInstructions.setForeground(Color.GREEN);
										lblRainbowMode.setForeground(Color.GREEN);
										lblExit.setForeground(Color.GREEN);
										lblNavigation.setForeground(Color.GREEN);
										change++;
										break;
									case 11:
										lblSnake.setForeground(Color.YELLOW);
										lblPlay.setForeground(Color.YELLOW);
										lblInstructions.setForeground(Color.YELLOW);
										lblRainbowMode.setForeground(Color.YELLOW);
										lblExit.setForeground(Color.YELLOW);
										lblNavigation.setForeground(Color.YELLOW);
										change++;
										break;
									case 12:
										lblSnake.setForeground(Color.ORANGE);
										lblPlay.setForeground(Color.ORANGE);
										lblInstructions.setForeground(Color.ORANGE);
										lblRainbowMode.setForeground(Color.ORANGE);
										lblExit.setForeground(Color.ORANGE);
										lblNavigation.setForeground(Color.ORANGE);
										change++;
										break;
									case 13:
										lblSnake.setForeground(Color.RED);
										lblPlay.setForeground(Color.RED);
										lblInstructions.setForeground(Color.RED);
										lblRainbowMode.setForeground(Color.RED);
										lblExit.setForeground(Color.RED);
										lblNavigation.setForeground(Color.RED);
										change = 2;
										break; 
									}// end of switch
								}// end of action performed
							};// end of action listener
							Timer timer = new Timer(100, color);
							timer.start();
						
					} else if (rain.contains(") Rainbow Mode {on} )")) {//if you turn off the Rainbow Mode label, it makes all the text back to white
						power = "off";
						colourSwitch = false;
						change = 0;
						lblSnake.setForeground(Color.WHITE);
						lblPlay.setForeground(Color.WHITE);
						lblInstructions.setForeground(Color.WHITE);
						lblRainbowMode.setForeground(Color.WHITE);
						lblExit.setForeground(Color.WHITE);
						lblExit.setForeground(Color.WHITE);
						lblNavigation.setForeground(Color.WHITE);
						lblRainbowMode.setText(") Rainbow Mode {" + power + "} )");
					} else if (exit.contains(") Exit )")) {
						menu.setVisible(false);
						menu.getContentPane().setFocusable(false);
					}
				}
			}// end of user inputs

		});// end of user control
	}
}
