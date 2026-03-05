package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class Patient_discharge extends JFrame {

	Patient_discharge(){
		
		JPanel panel = new JPanel();
		panel.setBounds(5,5,890,490);
		panel.setBackground(new Color(210, 218, 230));
		panel.setLayout(null);
		add(panel);
		
		JLabel label = new JLabel("CHECK_OUT");
		label.setBounds(100,20,150,20);
		label.setFont(new Font("Tahoma",Font.BOLD,20));
		label.setForeground(new Color(30, 64, 175));
		panel.add(label);
		
		JLabel label1 = new JLabel("Customer ID :");
		label1.setBounds(30,80,150,20);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		label1.setForeground(new Color(55, 65, 81));
		panel.add(label1);
		
		Choice choice = new Choice();
		choice.setBounds(200,80,150,25);
		panel.add(choice);
		
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
			while(resultSet.next()) {
				choice.add(resultSet.getString("number"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel label2 = new JLabel("Room No :");
		label2.setBounds(30,130,150,20);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		label2.setForeground(new Color(55, 65, 81));
		panel.add(label2);
		
		JLabel RNo = new JLabel();
		RNo.setBounds(200,130,150,20);
		RNo.setFont(new Font("Tahoma",Font.BOLD,14));
		RNo.setForeground(new Color(55, 65, 81));
		panel.add(RNo);
		
		JLabel label3 = new JLabel("In Time:");
		label3.setBounds(30,180,150,20);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		label3.setForeground(new Color(55, 65, 81));
		panel.add(label3);
		
		JLabel INTime = new JLabel();
		INTime.setBounds(200,180,250,20);
		INTime.setFont(new Font("Tahoma",Font.BOLD,14));
		INTime.setForeground(new Color(55, 65, 81));
		panel.add(INTime);
		
		JLabel label4 = new JLabel("Out Time :");
		label4.setBounds(30,230,150,20);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		label4.setForeground(new Color(55, 65, 81));
		panel.add(label4);
		
		Date date = new Date();
		
		JLabel OUTTime = new JLabel(""+date);
		OUTTime.setBounds(200,230,250,20);
		OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
		OUTTime.setForeground(new Color(55, 65, 81));
		panel.add(OUTTime);
		
		JButton discharge = new JButton("Discharge");
		discharge.setBounds(30,350,120,30);
		discharge.setBackground(new Color(37, 99, 235));
		discharge.setForeground(Color.white);
		panel.add(discharge);
		discharge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
					c.statement.executeUpdate("update Room set Availability = 'Available' where room_no = '"+RNo.getText()+"'");
					JOptionPane.showMessageDialog(null,"Done");
					setVisible(false);
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		
		JButton check = new JButton("Check");
		check.setBounds(165,350,120,30);
		check.setBackground(new Color(37, 99, 235));
		check.setForeground(Color.white);
		panel.add(check);
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try {
					ResultSet resultSet = c.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
					while(resultSet.next()) {
						RNo.setText(resultSet.getString("Room_Number"));
						INTime.setText(resultSet.getString("Time"));
					}
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		
		JButton back = new JButton("Back");
		back.setBounds(300,350,120,30);
		back.setBackground(new Color(37, 99, 235));
		back.setForeground(Color.white);
		panel.add(back);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent E) {
				setVisible(false);
			}
		});
		
		setUndecorated(true);
		setSize(900,500);
		setLayout(null);
		setLocation(339,250);
		getContentPane().setBackground(Color.black);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Patient_discharge();
	}
}
