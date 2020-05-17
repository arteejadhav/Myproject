package com.shop.mini_business.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.shop.mini_business.model.Product;
import com.shop.mini_business.util.JSonReaderWriterUtils;

public class AddProduct {

	public JFrame productpFrame;
	private JTextField textPID;
	private JTextField textPName;
	private JTextField textPrice;
	private JTextField textCompany;

	private JButton btnSubmitOrSearch;

	/**
	 * Create the application.
	 */
	public AddProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		productpFrame = new JFrame();
		productpFrame.setBounds(100, 100, 545, 523);
		productpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		productpFrame.getContentPane().setLayout(null);

		JLabel lblEnter = new JLabel("- : Enter Product Details : - ");
		lblEnter.setBounds(165, 46, 219, 20);
		productpFrame.getContentPane().add(lblEnter);

		JLabel lblProductId = new JLabel("Product ID : ");
		lblProductId.setBounds(120, 108, 117, 20);
		productpFrame.getContentPane().add(lblProductId);

		JLabel lblName = new JLabel("Name    :");
		lblName.setBounds(120, 179, 69, 20);
		productpFrame.getContentPane().add(lblName);

		JLabel lblPrice = new JLabel("Price    : ");
		lblPrice.setBounds(120, 241, 69, 20);
		productpFrame.getContentPane().add(lblPrice);

		JLabel lblConpany = new JLabel("Company :");
		lblConpany.setBounds(120, 300, 88, 20);
		productpFrame.getContentPane().add(lblConpany);

		textPID = new JTextField();
		textPID.setBounds(264, 105, 146, 26);
		productpFrame.getContentPane().add(textPID);
		textPID.setColumns(10);

		textPName = new JTextField();
		textPName.setBounds(264, 176, 146, 26);
		productpFrame.getContentPane().add(textPName);
		textPName.setColumns(10);

		textPrice = new JTextField();
		textPrice.setBounds(264, 238, 146, 26);
		productpFrame.getContentPane().add(textPrice);
		textPrice.setColumns(10);

		textCompany = new JTextField();
		textCompany.setBounds(264, 297, 146, 26);
		productpFrame.getContentPane().add(textCompany);
		textCompany.setColumns(10);

		btnSubmitOrSearch = new JButton("Submit");
		btnSubmitOrSearch.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("Entered ing action : "+btnSubmitOrSearch.getText());
				if (btnSubmitOrSearch.getText().equals("Submit")) {
					
					Product pt = new Product();
					pt.setpName(textPName.getText());
					pt.setPid(Integer.parseInt(textPID.getText()));
					pt.setCompanyName(textCompany.getText());
					pt.setPrice(Float.parseFloat(textPrice.getText()));

					// write json to file
					JSonReaderWriterUtils.writeProductToFile(pt);

					resetFields();
				}
				else if (btnSubmitOrSearch.getText().equals("Search")) {
					Product p = JSonReaderWriterUtils.searchProduct(textPID.getText());

					textPID.setText("" + p.getPid());
					textPName.setText(p.getpName());
					textPrice.setText("" + p.getPrice());
					textCompany.setText(p.getCompanyName());
				}
				
				else if(btnSubmitOrSearch.getText().equals("Search for Update")) {
					String pid =  textPID.getText();
					
					Product p = JSonReaderWriterUtils.searchProduct(pid);
					textPID.setText("" + p.getPid());
					textPName.setText(p.getpName());
					textPrice.setText("" + p.getPrice());
					textCompany.setText(p.getCompanyName());
					
					textPName.setEditable(true);
					textPrice.setEditable(true);
					textCompany.setEditable(true);
					btnSubmitOrSearch.setText("Update");
				}
				
				else if(btnSubmitOrSearch.getText().equals("Update")) {
					Product p =  new Product();
					
					p.setPid(Integer.parseInt(textPID.getText()));
					p.setpName(textPName.getText());
					p.setPrice(Float.parseFloat(textPrice.getText()));
					p.setCompanyName(textCompany.getText());
					
					JSonReaderWriterUtils.writeProductToFile(p);
					resetFields();
					updateProduct();
				}
			}
		});
		btnSubmitOrSearch.setBounds(76, 380, 204, 29);
		productpFrame.getContentPane().add(btnSubmitOrSearch);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetFields();
			}
			
		});
		btnReset.setBounds(295, 380, 115, 29);
		productpFrame.getContentPane().add(btnReset);
		
		JButton btnMainForm = new JButton("Main Form");
		btnMainForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to open admin frame
				AdminWindow admin = new AdminWindow();
				admin.adminFrame.setVisible(true);

				// code to close current product frame
				productpFrame.setVisible(false);

			}
		});
		btnMainForm.setBounds(393, 16, 115, 29);
		productpFrame.getContentPane().add(btnMainForm);
	}

	public void searchProduct() {
		textPID.setFocusable(true);
		textPName.setEditable(false);
		textPrice.setEditable(false);
		textCompany.setEditable(false);
		btnSubmitOrSearch.setText("Search");
	}
	
	public void updateProduct() {
		searchProduct();
		btnSubmitOrSearch.setText("Search for Update");
	}
	private void resetFields() {
		textPID.setText("");
		textPName.setText("");
		textPrice.setText("");
		textCompany.setText("");
	}
}
