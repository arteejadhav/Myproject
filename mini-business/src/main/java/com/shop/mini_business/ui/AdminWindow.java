package com.shop.mini_business.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AdminWindow {

	public JFrame adminFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow window = new AdminWindow();
					window.adminFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminFrame = new JFrame();
		adminFrame.setBounds(100, 100, 478, 711);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.getContentPane().setLayout(null);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddProduct pt =  new AddProduct();
				pt.productpFrame.setVisible(true);
				adminFrame.setVisible(false);
			}
		});
		btnAddProduct.setBounds(154, 105, 161, 29);
		adminFrame.getContentPane().add(btnAddProduct);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer cust =  new AddCustomer();
				cust.customerFrame.setVisible(true);
				
				adminFrame.setVisible(false);
			}
		});
		btnAddCustomer.setBounds(154, 198, 161, 29);
		adminFrame.getContentPane().add(btnAddCustomer);
		
		JButton btnSearchProduct = new JButton("Search Product");
		btnSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddProduct pr = new AddProduct();
				pr.searchProduct();
				pr.productpFrame.setVisible(true);
				
				adminFrame.setVisible(false);
			}
		});
		btnSearchProduct.setBounds(154, 293, 161, 29);
		adminFrame.getContentPane().add(btnSearchProduct);
		
		JButton btnSearchCustomer = new JButton("Search Customer");
		btnSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddCustomer cust =  new AddCustomer();
				cust.searchCustomer();
				cust.customerFrame.setVisible(true);
				
				adminFrame.setVisible(false);
			}
		});
		btnSearchCustomer.setBounds(154, 389, 161, 29);
		adminFrame.getContentPane().add(btnSearchCustomer);
		
		JButton btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct pt =  new AddProduct();
				pt.updateProduct();
				pt.productpFrame.setVisible(true);
				
				adminFrame.setVisible(false);
			}
		});
		btnUpdateProduct.setBounds(154, 468, 161, 29);
		adminFrame.getContentPane().add(btnUpdateProduct);
		
		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddCustomer cust = new AddCustomer();
				cust.updateCustomer();
				cust.customerFrame.setVisible(true);
				
				adminFrame.setVisible(false);
				
			}
		});
		btnUpdateCustomer.setBounds(154, 557, 161, 29);
		adminFrame.getContentPane().add(btnUpdateCustomer);
	}

}
