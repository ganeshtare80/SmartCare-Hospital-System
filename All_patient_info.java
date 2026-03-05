package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class All_patient_info extends JFrame {

	All_patient_info(){
		
		JPanel panel = new JPanel();
		panel.setBounds(5,5,890,540);
		panel.setBackground(new Color(210, 218, 230));
		panel.setLayout(null);
		add(panel);
		
		JTable table = new JTable();
		table.setBackground(new Color(225, 232, 242));
		table.setForeground(new Color(55, 65, 81));
		table.setBounds(10,40,880,350);
		table.setFont(new Font("Tahoma",Font.BOLD,12));
		panel.add(table);
		
		try {
			Conn c = new Conn();
			String q = "select * from patient_info";
			ResultSet resultSet = c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel label = new JLabel("ID");
		label.setBounds(31,11,100,14);
		label.setFont(new Font("Tahoma",Font.BOLD,14));
		label.setForeground(new Color(55, 65, 81));
		panel.add(label);
		
		JLabel label1 = new JLabel("Number");
		label1.setBounds(130,11,100,14);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		label1.setForeground(new Color(55, 65, 81));
		panel.add(label1);
		
		JLabel label2 = new JLabel("Name");
		label2.setBounds(240,11,100,14);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		label2.setForeground(new Color(55, 65, 81));
		panel.add(label2);
		
		JLabel label3 = new JLabel("Gender");
		label3.setBounds(340,11,100,14);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		label3.setForeground(new Color(55, 65, 81));
		panel.add(label3);
		
		JLabel label4 = new JLabel("Disease");
		label4.setBounds(450,11,100,14);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		label4.setForeground(new Color(55, 65, 81));
		panel.add(label4);
		
		JLabel label5 = new JLabel("Room ");
		label5.setBounds(565,11,100,14);
		label5.setFont(new Font("Tahoma",Font.BOLD,14));
		label5.setForeground(new Color(55, 65, 81));
		panel.add(label5);
		
		JLabel label6 = new JLabel("Time");
		label6.setBounds(690,11,100,14);
		label6.setFont(new Font("Tahoma",Font.BOLD,14));
		label6.setForeground(new Color(55, 65, 81));
		panel.add(label6);
		
		JLabel label7 = new JLabel("Deposite");
		label7.setBounds(790,11,100,14);
		label7.setFont(new Font("Tahoma",Font.BOLD,14));
		label7.setForeground(new Color(55, 65, 81));
		panel.add(label7);
		
		JButton b1 = new JButton("BACK");
		b1.setBounds(370,450,120,30);
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
		getContentPane().setBackground(Color.black);
		setLocation(339,250);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[]args) {
		new All_patient_info();
	}
}
