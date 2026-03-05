package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame {

	Department(){
		
		JPanel panel = new JPanel();
		panel.setBounds(5,5,890,490);
		panel.setBackground(new Color(210, 218, 230));
		panel.setLayout(null);
		add(panel);
		
		JTable table = new JTable();
		table.setBounds(10,40,880,350);
		table.setBackground(new Color(225, 232, 242));
		table.setForeground(new Color(55, 65, 81));
		table.setFont(new Font("Tahoma",Font.BOLD,12));
		panel.add(table);
		
		try {
			Conn c = new Conn();
			String q = "select * from department";
			ResultSet resultSet = c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
		JLabel label = new JLabel("Department");
		label.setBounds(145,11,105,20);
		label.setFont(new Font("Tahoma",Font.BOLD,14));
		label.setForeground(new Color(55, 65, 81));
		panel.add(label);
		
		JLabel label1 = new JLabel("Phone Number");
		label1.setBounds(580,11,150,20);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		label1.setForeground(new Color(55, 65, 81));
		panel.add(label1);
		
		JButton b1 = new JButton("BACK");
		b1.setBounds(370,400,120,30);
		b1.setBackground(new Color(37, 99, 235));
		b1.setForeground(Color.white);
		panel.add(b1);
		b1.addActionListener(new ActionListener(){
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
	public static void main(String[] args) {
		new Department();
	}
}
