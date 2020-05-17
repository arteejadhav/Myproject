package com.shop.mini_business.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.shop.mini_business.model.Customer;
import com.shop.mini_business.util.JSonReaderWriterUtils;

public class AddCustomer {

	public JFrame customerFrame;
	private JTextField textCustId;
	private JTextField textCustName;
	private JTextField textMobNo;
	private JTextField textCity;

	private JButton btnSubmit;
	private JButton btnReset;
	private JButton btnMainForm;
	/**
	 * 
	 * Create the application.
	 */
	public AddCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		customerFrame = new JFrame();
		customerFrame.setBounds(100, 100, 552, 568);
		customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		customerFrame.getContentPane().setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel(":  Customer Details  : ");
		lblCustomerDetails.setBounds(209, 41, 174, 20);
		customerFrame.getContentPane().add(lblCustomerDetails);
		
		JLabel lblCustomerId = new JLabel("Customer ID : ");
		lblCustomerId.setBounds(74, 103, 106, 20);
		customerFrame.getContentPane().add(lblCustomerId);
		
		textCustId = new JTextField();
		textCustId.setBounds(263, 100, 146, 26);
		customerFrame.getContentPane().add(textCustId);
		textCustId.setColumns(10);
		
		JLabel lblCustName = new JLabel("Cust Name :");
		lblCustName.setBounds(74, 189, 106, 20);
		customerFrame.getContentPane().add(lblCustName);
		
		textCustName = new JTextField();
		textCustName.setBounds(263, 186, 146, 26);
		customerFrame.getContentPane().add(textCustName);
		textCustName.setColumns(10);
		
		JLabel lblMobNo = new JLabel("Mob No. :");
		lblMobNo.setBounds(74, 269, 106, 20);
		customerFrame.getContentPane().add(lblMobNo);
		
		textMobNo = new JTextField();
		textMobNo.setBounds(263, 266, 146, 26);
		customerFrame.getContentPane().add(textMobNo);
		textMobNo.setColumns(10);
		
		JLabel lblCity = new JLabel("City       :");
		lblCity.setBounds(74, 346, 69, 20);
		customerFrame.getContentPane().add(lblCity);
		
		textCity = new JTextField();
		textCity.setBounds(263, 343, 146, 26);
		customerFrame.getContentPane().add(textCity);
		textCity.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(btnSubmit.getText().equals("Submit")) {
					Customer ct = new Customer();
					
					String givenId =  textCustId.getText(); // read from form field
					int id = Integer.parseInt(givenId);		// convert to int
					ct.setCustID(id);						// assign to object
					ct.setCustName(textCustName.getText());
					ct.setMobNo(Long.parseLong(textMobNo.getText()));
					ct.setCity(textCity.getText());
					
					JSonReaderWriterUtils.writeCustomerToFile(ct);
					resetfields();
				}
				
				else if(btnSubmit.getText().equals("Search")) {
					Customer cust = JSonReaderWriterUtils.searchCustomer(textCustId.getText());
				
					textCustId.setText(""+cust.getCustID());
					textCustName.setText(cust.getCustName());
					textMobNo.setText(""+cust.getMobNo());
					textCity.setText(cust.getCity());
				}
				else if(btnSubmit.getText().equals("Search for Update")) {
					String cid =  textCustId.getText();
					Customer cust = JSonReaderWriterUtils.searchCustomer(cid);
					
					textCustId.setText(""+cust.getCustID());
					textCustId.setEditable(true);
					
					textCity.setText(cust.getCity());
					textCity.setEditable(true);
					
					textCustName.setText(cust.getCustName());
					textCustName.setEditable(true);
					
					textMobNo.setText(""+cust.getMobNo());
					textMobNo.setEditable(true);
					
					btnSubmit.setText("Update");
				}
				else if(btnSubmit.getText().equals("Update")) {
					
					Customer ct =  new Customer();
					ct.setCity(textCity.getText());
					ct.setCustID(Integer.parseInt(textCustId.getText()));
					ct.setCustName(textCustName.getText());
					ct.setMobNo(Long.parseLong(textMobNo.getText()));
					
					JSonReaderWriterUtils.writeCustomerToFile(ct);
					
					
					resetfields();
					updateCustomer();
					
				}
			}
			
		});
		btnSubmit.setBounds(91, 438, 115, 29);
		customerFrame.getContentPane().add(btnSubmit);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetfields();
			}

			
		});
		btnReset.setBounds(268, 438, 115, 29);
		customerFrame.getContentPane().add(btnReset);
		
		btnMainForm = new JButton("Main Form");
		btnMainForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminWindow admin = new AdminWindow();
				admin.adminFrame.setVisible(true);
				
				customerFrame.setVisible(false);
			}
		});
		btnMainForm.setBounds(398, 16, 115, 29);
		customerFrame.getContentPane().add(btnMainForm);
	}
	
	public void searchCustomer() {
		
		textCustId.setFocusable(true);
		textCity.setEditable(false);
		textCustName.setEditable(false);
		textMobNo.setEditable(false);
		
		btnSubmit.setText("Search");
	}
	private void resetfields() {
		textCustId.setText("");
		textCustName.setText("");
		textMobNo.setText("");
		textCity.setText("");
	}
	
	public void updateCustomer() {
		searchCustomer();
		btnSubmit.setText("Search for Update");
	}
}
