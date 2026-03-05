package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class update_patient_details extends JFrame {

	update_patient_details(){
		
		JPanel panel = new JPanel();
		panel.setBounds(5,5,890,490);
		panel.setBackground(new Color(210, 218, 230));
		panel.setLayout(null);
		add(panel);
		
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
		Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon imageIcon1 = new ImageIcon(image);
		JLabel label = new JLabel(imageIcon1);
		label.setBounds(500,60,300,300);
		panel.add(label);
		
		JLabel label1 = new JLabel("Update Patient Details");
		label1.setBounds(124,11,250,25);
		label1.setFont(new Font("Tahoma",Font.BOLD,20));
		label1.setForeground(new Color(30, 64, 175));
		panel.add(label1);
		
		JLabel label2 = new JLabel("Name :");
		label2.setBounds(25,88,100,14);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		label2.setForeground(new Color(55, 65, 81));
		panel.add(label2);
		
		Choice choice = new Choice();
		choice.setBounds(230,85,140,25);
		panel.add(choice);
		
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
			while(resultSet.next()) {
				choice.add(resultSet.getString("Name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel label3 = new JLabel("Room Number :");
		label3.setBounds(25,129,150,14);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		label3.setForeground(new Color(55, 65, 81));
		panel.add(label3);
		
		JTextField textField = new JTextField();
		textField.setBounds(230,129,140,20);
		panel.add(textField);
		
		JLabel label4 = new JLabel("In-Time :");
		label4.setBounds(25,174,100,14);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		label4.setForeground(new Color(55, 65, 81));
		panel.add(label4);
		
		JTextField intime = new JTextField();
		intime.setBounds(230,174,140,20);
		panel.add(intime);
		
		JLabel label5 = new JLabel("Amount Paid (Rs) :");
		label5.setBounds(25,216,150,14);
		label5.setForeground(new Color(55, 65, 81));
		label5.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label5);
		
		JTextField textRs = new JTextField();
		textRs.setBounds(230,216,140,20);
		panel.add(textRs);
		
		JLabel label6 = new JLabel("Pending Amount (Rs) :");
		label6.setBounds(25,261,180,18);
		label6.setFont(new Font("Tahoma",Font.BOLD,14));
		label6.setForeground(new Color(55, 65, 81));
		panel.add(label6);
		
		JTextField pendingAmt = new JTextField();
		pendingAmt.setBounds(230,261,140,20);
		panel.add(pendingAmt);
		
		JButton check = new JButton("CHECK");
		check.setBounds(281,378,89,23);
		check.setBackground(new Color(37, 99, 235));
		check.setForeground(Color.white);
		panel.add(check);
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = choice.getSelectedItem();
				String q = "select * from patient_info where Name = '"+id+"'";
				try {
					Conn c = new Conn();
					ResultSet resultSet = c.statement.executeQuery(q);
					while(resultSet.next()) {
						textField.setText(resultSet.getString("Room_Number"));
						intime.setText(resultSet.getString("Time"));
						textRs.setText(resultSet.getString("Deposite"));
					}
					
					ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '"+textField.getText()+"'");
					while(resultSet1.next()) {
						String price = resultSet1.getString("Price");
						int amountPaid = Integer.parseInt(price) - Integer.parseInt(textRs.getText());
						pendingAmt.setText(""+amountPaid);
					}
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		
		JButton update = new JButton("Update");
		update.setBounds(56,378,89,23);
		update.setBackground(new Color(37, 99, 235));
		update.setForeground(Color.white);
		panel.add(update);
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Conn c = new Conn();
					String q = choice.getSelectedItem();
					String room = textField.getText();
					String time = intime.getText();
					String amount = textRs.getText();
					c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"',Time = '"+time+"',Deposite = '"+amount+"',name = '"+q+"'");
					JOptionPane.showMessageDialog(null, "Update Successfully");
					setVisible(false);
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		
		JButton back = new JButton("BACK");
		back.setBounds(169,378,89,23);
		back.setBackground(new Color(37, 99, 235));
		back.setForeground(Color.white);
		panel.add(back);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setUndecorated(true);
		setSize(900,500);
		getContentPane().setBackground(Color.black);
		setLayout(null);
		setLocation(339,250);
		setVisible(true);
	}
	
	public static void main(String[]args) {
		new update_patient_details();
	}
}
