package org.GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import org.apache.http.client.ClientProtocolException;
import org.controllers.RegistrController;
import org.models.Address;
import org.models.User;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
	private JLabel lblCountryName;
	private JTextField countryName;
	private JTextField postalCode;
	private JTextField city;
	private JTextField street;
	private JTextField houseNumber;
	private JTextField apartmentNumber;
	
	/**
	 * Creates the GUI for the second part of the Register process
	 */
	public Register2() {
		


		BackgroundLogin background = new BackgroundLogin();
		background.setLayout(null);
		getContentPane().add(background, BorderLayout.CENTER);
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(545, 68, 249, 25);
		background.add(datePicker);
		
		
		JLabel lblCountryCode = new JLabel("Country Code");
		lblCountryCode.setBackground(new Color(240, 240, 240));
		lblCountryCode.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblCountryCode.setForeground(Color.WHITE);
		lblCountryCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountryCode.setBounds(146, 150, 267, 63);
		background.add(lblCountryCode);

		countrycode = new JTextField();
		countrycode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		countrycode.setForeground(Color.BLACK);
		countrycode.setBounds(460, 168, 69, 31);

		background.add(countrycode);
		

		btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(Color.BLACK);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.addActionListener(this);
		btnConfirm.setFont(new Font("Yu Gothic Light", Font.PLAIN, 50));
		btnConfirm.setBounds(404, 532, 340, 92);
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
		lblPhone.setBounds(124, 376, 387, 81);
		background.add(lblPhone);
		
		phone = new JTextField();
		phone.setForeground(Color.BLACK);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phone.setBounds(597, 413, 249, 32);
		background.add(phone);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblPassword.setBackground(SystemColor.menu);
		lblPassword.setBounds(195, 438, 272, 81);
		background.add(lblPassword);
		
		password = new JPasswordField();
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(597, 475, 249, 32);
		background.add(password);
		
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthDate.setForeground(Color.WHITE);
		lblBirthDate.setFont(new Font("Century Schoolbook", Font.PLAIN, 50));
		lblBirthDate.setBackground(SystemColor.menu);
		lblBirthDate.setBounds(251, 32, 282, 81);
		background.add(lblBirthDate);
		
		lblCountryName = new JLabel("Country Name");
		lblCountryName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountryName.setForeground(Color.WHITE);
		lblCountryName.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblCountryName.setBackground(SystemColor.menu);
		lblCountryName.setBounds(580, 149, 282, 63);
		background.add(lblCountryName);
		
		countryName = new JTextField();
		countryName.setForeground(Color.BLACK);
		countryName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		countryName.setBounds(875, 168, 166, 31);
		background.add(countryName);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblCity.setBackground(SystemColor.menu);
		lblCity.setBounds(156, 216, 267, 63);
		background.add(lblCity);
		
		JLabel lblPostalCode = new JLabel("Postal code");
		lblPostalCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblPostalCode.setForeground(Color.WHITE);
		lblPostalCode.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblPostalCode.setBackground(SystemColor.menu);
		lblPostalCode.setBounds(590, 216, 267, 63);
		background.add(lblPostalCode);
		
		postalCode = new JTextField();
		postalCode.setForeground(Color.BLACK);
		postalCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		postalCode.setBounds(925, 240, 69, 31);
		background.add(postalCode);
		
		city = new JTextField();
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.PLAIN, 20));
		city.setBounds(435, 240, 115, 31);
		background.add(city);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreet.setForeground(Color.WHITE);
		lblStreet.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblStreet.setBackground(SystemColor.menu);
		lblStreet.setBounds(166, 273, 267, 63);
		background.add(lblStreet);
		
		street = new JTextField();
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.PLAIN, 20));
		street.setBounds(460, 290, 69, 31);
		background.add(street);
		
		JLabel lblHouseNumber = new JLabel("House number");
		lblHouseNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumber.setForeground(Color.WHITE);
		lblHouseNumber.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblHouseNumber.setBackground(SystemColor.menu);
		lblHouseNumber.setBounds(597, 273, 272, 63);
		background.add(lblHouseNumber);
		
		houseNumber = new JTextField();
		houseNumber.setForeground(Color.BLACK);
		houseNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		houseNumber.setBounds(925, 297, 69, 31);
		background.add(houseNumber);
		
		JLabel lblApartmentNumber = new JLabel("Apartment number");
		lblApartmentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblApartmentNumber.setForeground(Color.WHITE);
		lblApartmentNumber.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblApartmentNumber.setBackground(SystemColor.menu);
		lblApartmentNumber.setBounds(279, 337, 423, 63);
		background.add(lblApartmentNumber);
		
		apartmentNumber = new JTextField();
		apartmentNumber.setForeground(Color.BLACK);
		apartmentNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apartmentNumber.setBounds(714, 361, 69, 31);
		background.add(apartmentNumber);
		btnexit.addActionListener(this);

		password.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					btnConfirm.doClick();
				}
			}

		});
		
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

	
	/** 
	 * Identify which is the JButton that received the action and act accordingly
	 **/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnexit) {
			System.exit(0);
		} else if (botonPulsado == btnConfirm) {
			if (countryName.getText().equals("")||(postalCode.getText().equals(""))||(city.getText().equals(""))||(street.getText().equals(""))||(houseNumber.getText().equals(""))||(apartmentNumber.getText().equals(""))||(postalCode.getText().equals(""))) {
				JOptionPane.showMessageDialog(null,
						"Plase complete all the fileds","Error",
						JOptionPane.ERROR_MESSAGE);

			}	else{
				String birthDate = datePicker.getJFormattedTextField().getText();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				Date date;

				try {
					date = (Date)formatter.parse(birthDate);
					long mills = date.getTime();
					Register.newUser.setBirthDate(mills);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				Register.newUser.setCountryCode(countrycode.getText());
				Register.newUser.setPassword(password.getText());
				Register.newUser.setPhone(Integer.parseInt(phone.getText()));
				Address adr = new Address();
				adr.setStreet(street.getText());
				adr.setApartamentNumber(Integer.parseInt(apartmentNumber.getText()));
				adr.setCity(city.getText());
				adr.setCountry(countryName.getText());
				adr.setHouseNumber(Integer.parseInt(houseNumber.getText()));
				adr.setPostalCode(postalCode.getText());
				Register.newUser.setAddress(adr);
				//			System.out.println(Register.newUser.getBirthDate());
				//			System.out.println(Register.newUser.getCountryCode());
				//			System.out.println(Register.newUser.getPassword());
				//			System.out.println(Register.newUser.getPhone());
				//			System.out.println(Register.newUser.getEmail());
				try {
					RegistrController.registrStep2(Register.newUser);
				} catch (ClientProtocolException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,
						"Registration process finished, please log in.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
		} 
	}
}
