package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame {

	
	Choice choice;
	JTable table;
	
	SearchRoom(){
		
		JPanel panel = new JPanel();
		panel.setBounds(5,5,890,490);
		panel.setBackground(new Color(210, 218, 230));
		panel.setLayout(null);
		add(panel);
		
		JLabel For = new JLabel("Search For Room");
		For.setBounds(250,11,186,31);
		For.setForeground(new Color(30, 64, 175));
		For.setFont(new Font("Tahoma",Font.BOLD,20));
		panel.add(For);
		
		JLabel status = new JLabel("Status :");
		status.setBounds(70,70,80,20);
		status.setForeground(new Color(55, 65, 81));
		status.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(status);
		
		choice = new Choice();
		choice.setBounds(170,70,120,20);
		choice.add("Available");
		choice.add("Occupied");
		panel.add(choice);
		
		table = new JTable();
		table.setBounds(10,187,700,210);
		table.setBackground(new Color(225, 232, 242));
		table.setForeground(new Color(37, 99, 235));
		panel.add(table);
		
		try {
			Conn c = new Conn();
			String q = "select * from room";
			ResultSet resultSet = c.statement.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel Roomno = new JLabel("Room Number");
		Roomno.setBounds(23,162,150,20);
		Roomno.setForeground(new Color(55, 65, 81));
		Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(Roomno);
		
		JLabel available = new JLabel("Availability");
		available.setBounds(195,162,150,20);
		available.setForeground(new Color(55, 65, 81));
		available.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(available);
		
		JLabel price = new JLabel("Price");
		price.setBounds(408,162,150,20);
		price.setForeground(new Color(55, 65, 81));
		price.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(price);
		
		JLabel bed = new JLabel("Bed Type");
		bed.setBounds(540,162,150,20);
		bed.setForeground(new Color(55, 65, 81));
		bed.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(bed);
		
		JButton search = new JButton("Search");
		search.setBounds(380,420,120,25);
		search.setBackground(new Color(37, 99, 235));
		search.setForeground(Color.white);
		panel.add(search);
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
				try {
					Conn c = new Conn();
					ResultSet resultSet = c.statement.executeQuery(q);
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		
		JButton back = new JButton("Back");
		back.setBounds(200,420,120,25);
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
		new SearchRoom();
	}
}
