package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Ambulance extends JFrame{

	Ambulance(){
		JPanel panel = new JPanel();
		panel.setBounds(5,5,890,540);
		panel.setBackground(new Color(210, 218, 230));
		panel.setLayout(null);
		add(panel);
		
		JTable table = new JTable();
		table.setBackground(new Color(225, 232, 242));
		table.setBounds(10,40,880,350);
		table.setForeground(new Color(55, 65, 81));
		table.setFont(new Font("Tahoma",Font.BOLD,12));
		panel.add(table);
		
		try {
			Conn c = new Conn();
			String q = "select * from Ambulance";
			ResultSet resultSet = c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel label = new JLabel("Name");
		label.setBounds(31,11,100,14);
		label.setFont(new Font("Tahoma",Font.BOLD,14));
		label.setForeground(new Color(55, 65, 81));
		panel.add(label);
		
		JLabel label1 = new JLabel("Gender");
		label1.setBounds(234,11,100,14);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		label1.setForeground(new Color(55, 65, 81));
		panel.add(label1);
		
		JLabel label2 = new JLabel("Car name");
		label2.setBounds(386,11,100,14);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		label2.setForeground(new Color(55, 65, 81));
		panel.add(label2);
		
		JLabel label3 = new JLabel("Available");
		label3.setBounds(580,11,100,14);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		label3.setForeground(new Color(55, 65, 81));
		panel.add(label3);
		
		JLabel label4 = new JLabel("Location");
		label4.setBounds(735,11,100,14);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		label4.setForeground(new Color(55, 65, 81));
		panel.add(label4);
		
		
		JButton b1 = new JButton("BACK");
		b1.setBounds(370,420,120,30);
		b1.setBackground(new Color(37, 99, 235));
		b1.setForeground(Color.white);
		panel.add(b1);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setUndecorated(true);
		setSize(900,550);
		setLocation(339,250);
		getContentPane().setBackground(Color.black);
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String[]args) {
		new Ambulance();
	}
}
