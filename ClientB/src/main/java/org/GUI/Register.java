package org.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.models.User;

import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class Register extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField name;
	public static User newUser;
	private JButton btnexit, btnRegister;
	public static User j = null;
	private JLabel lblPassword;
	private JTextField password;
	private JLabel lblSurname;
	private JTextField surname;
	private JTextField email;

	public Register() {
		newUser = new User();


		BackgroundLogin background = new BackgroundLogin();
		background.setLayout(null);
		getContentPane().add(background, BorderLayout.CENTER);

		JLabel lblName = new JLabel("Name");
		lblName.setBackground(new Color(240, 240, 240));
		lblName.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(229, 81, 272, 81);
		background.add(lblName);

		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setForeground(Color.BLACK);
		name.setBounds(596, 118, 249, 32);

		background.add(name);
		KeyListener keylistener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnRegister.doClick();
				}
			}
		};

		btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.addActionListener(this);
		btnRegister.setFont(new Font("Yu Gothic Light", Font.PLAIN, 50));
		btnRegister.setBounds(406, 508, 340, 92);
		btnRegister.requestFocus();
		background.add(btnRegister);

		

		btnexit = new JButton("Exit");
		btnexit.setFont(new Font("Yu Gothic", Font.PLAIN, 24));
		btnexit.setBounds(33, 652, 200, 50);
		background.add(btnexit);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblPassword.setBackground(SystemColor.menu);
		lblPassword.setBounds(229, 357, 272, 81);
		background.add(lblPassword);
		
		password = new JTextField();
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(596, 394, 249, 32);
		background.add(password);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblSurname.setBackground(SystemColor.menu);
		lblSurname.setBounds(229, 175, 272, 81);
		background.add(lblSurname);
		
		surname = new JTextField();
		surname.setForeground(Color.BLACK);
		surname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		surname.setBounds(596, 212, 249, 32);
		background.add(surname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblEmail.setBackground(SystemColor.menu);
		lblEmail.setBounds(229, 263, 272, 81);
		background.add(lblEmail);
		
		email = new JTextField();
		email.setForeground(Color.BLACK);
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setBounds(596, 300, 249, 32);
		background.add(email);
		btnexit.addActionListener(this);

		this.setSize(1200, 800);
		this.setResizable(false);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = getSize();
		setLocation((pantalla.width - ventana.width) / 2,
				(pantalla.height - ventana.height) / 2);

		this.setVisible(true);
	}



	public static void main(String[] args) {
		Register x = new Register();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnexit) {
			System.exit(0);
		} else if (botonPulsado == btnRegister) {
			String u = name.getText();

					if (name.getText().equals("")||surname.getText().equals("")||email.getText().equals("")||(password.getText().equals(""))) {
						JOptionPane.showMessageDialog(null,
								"You have to complete everything!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} else if (!name.getText().equals("")){
						this.dispose();
					//Introduce in the database the new user and he/she should log in in the previous window
				} 
			
		} 
	}
}