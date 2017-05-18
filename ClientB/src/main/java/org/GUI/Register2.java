package org.GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import org.ClientP.Application;
import org.apache.http.client.ClientProtocolException;
import org.models.User;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Register2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField countrycode;
	public static User newUser;
	private JButton btnexit, btnConfirm;
	private JLabel lblPhone;
	private JTextField phone;
	private JPasswordField password;
	private JDatePickerImpl datePicker;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;

	public Register2() {
		


		BackgroundLogin background = new BackgroundLogin();
		background.setLayout(null);
		getContentPane().add(background, BorderLayout.CENTER);
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(596, 200, 249, 25);
		background.add(datePicker);
		
		
		JLabel lblCountryCode = new JLabel("Country Code");
		lblCountryCode.setBackground(new Color(240, 240, 240));
		lblCountryCode.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblCountryCode.setForeground(Color.WHITE);
		lblCountryCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountryCode.setBounds(124, 81, 377, 81);
		background.add(lblCountryCode);

		countrycode = new JTextField();
		countrycode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		countrycode.setForeground(Color.BLACK);
		countrycode.setBounds(596, 118, 249, 32);

		background.add(countrycode);
		KeyListener keylistener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnConfirm.doClick();
				}
			}
		};

		btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(Color.BLACK);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.addActionListener(this);
		btnConfirm.setFont(new Font("Yu Gothic Light", Font.PLAIN, 50));
		btnConfirm.setBounds(406, 508, 340, 92);
		btnConfirm.requestFocus();
		background.add(btnConfirm);

		

		btnexit = new JButton("Exit");
		btnexit.setFont(new Font("Yu Gothic", Font.PLAIN, 24));
		btnexit.setBounds(33, 652, 200, 50);
		background.add(btnexit);
		
		lblPhone = new JLabel("Phone number");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblPhone.setBackground(SystemColor.menu);
		lblPhone.setBounds(114, 272, 387, 81);
		background.add(lblPhone);
		
		phone = new JTextField();
		phone.setForeground(Color.BLACK);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phone.setBounds(596, 309, 249, 32);
		background.add(phone);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblPassword.setBackground(SystemColor.menu);
		lblPassword.setBounds(232, 375, 272, 81);
		background.add(lblPassword);
		
		password = new JPasswordField();
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(596, 412, 249, 32);
		background.add(password);
		
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthDate.setForeground(Color.WHITE);
		lblBirthDate.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblBirthDate.setBackground(SystemColor.menu);
		lblBirthDate.setBounds(124, 173, 377, 81);
		background.add(lblBirthDate);
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
		Register2 x = new Register2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnexit) {
			System.exit(0);
		} else if (botonPulsado == btnConfirm) {
			
			Register.newUser.setBirthDate(datePicker.getJFormattedTextField().getText());
			Register.newUser.setCountryCode(countrycode.getText());
			Register.newUser.setPassword(password.getText());
			Register.newUser.setPhone(Integer.parseInt(phone.getText()));
//			System.out.println(Register.newUser.getBirthDate());
//			System.out.println(Register.newUser.getCountryCode());
//			System.out.println(Register.newUser.getPassword());
//			System.out.println(Register.newUser.getPhone());
//			System.out.println(Register.newUser.getEmail());
			Application app = new Application();
			try {
				app.registr2(Register.newUser);
			} catch (ClientProtocolException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

					
		} 
	}
}
