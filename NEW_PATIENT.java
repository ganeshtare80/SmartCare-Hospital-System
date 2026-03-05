package hospital.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class NEW_PATIENT extends JFrame implements ActionListener {

		JComboBox comboBox;
		
		JTextField textfieldNumber, textName, textfieldDisease, textfieldDeposite;
		JRadioButton r1,r2;
		Choice c1;
		JLabel date;
		JButton b1,b2;
		
	NEW_PATIENT(){	
		JPanel panel = new JPanel();
		panel.setBounds(5,5,890,540);
		panel.setBackground(new Color(210, 218, 230));
		panel.setLayout(null);
		add(panel);
		
		ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
		Image image = imageicon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon imageicon1 = new ImageIcon(image);
		JLabel label = new JLabel(imageicon1);
		label.setBounds(550,150,200,200);
		panel.add(label);
		
		JLabel labelname = new JLabel("New Patient Form");
		labelname.setBounds(118,11,200,53);
		labelname.setFont(new Font("Tahoma",Font.BOLD,20));
		labelname.setForeground(new Color(55, 65, 81));
		panel.add(labelname);
		
		JLabel labelId = new JLabel("ID :");
		labelId.setBounds(40,70,200,20);
		labelId.setFont(new Font("Tahoma",Font.BOLD,14));
		labelId.setForeground(new Color(55, 65, 81));
		panel.add(labelId);
		
		comboBox = new JComboBox(new String[] {"Aadhar card","Voter Id","Driving License"});
		comboBox.setBounds(140,70,170,20);
		comboBox.setBackground(new Color(96,96,96));
		comboBox.setForeground(Color.white);
		comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(comboBox);
		
		JLabel labelnumber = new JLabel("Number :");
		labelnumber.setBounds(40,110,200,20);
		labelnumber.setFont(new Font("Tahoma",Font.BOLD,14));
		labelnumber.setForeground(new Color(55, 65, 81));
		panel.add(labelnumber);
		
		textfieldNumber = new JTextField();
		textfieldNumber.setBounds(140,110,170,20);
		panel.add(textfieldNumber);
		
		JLabel labelname1 = new JLabel("Name :");
		labelname1.setBounds(40,150,200,20);
		labelname1.setFont(new Font("Tahoma",Font.BOLD,14));
		labelname1.setForeground(new Color(55, 65, 81));
		panel.add(labelname1);		
		
		textName = new JTextField();
		textName.setBounds(140,150,170,20);
		panel.add(textName);
		
		JLabel labelGender = new JLabel("Gender :");
		labelGender.setBounds(40,190,200,20);
		labelGender.setForeground(new Color(55, 65, 81));
		labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(labelGender);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma",Font.BOLD,14));
		r1.setForeground(new Color(55, 65, 81));
		r1.setBounds(140,190,70,20);
		r1.setBackground(new Color(210, 218, 230));
		panel.add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(210,190,100,20);
		r2.setForeground(new Color(55, 65, 81));
		r2.setFont(new Font("Tahom",Font.BOLD,14));
		r2.setBackground(new Color(210, 218, 230));
		panel.add(r2);
		
		JLabel labelDisease = new JLabel("Disease :");
		labelDisease.setBounds(40,230,200,20);
		labelDisease.setForeground(new Color(55, 65, 81));
		labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(labelDisease);
		
		textfieldDisease = new JTextField();
		textfieldDisease.setBounds(140,230,170,20);
		panel.add(textfieldDisease);
		
		JLabel labelroom = new JLabel("Room: ");
		labelroom.setBounds(40,270,100,20);
		labelroom.setForeground(new Color(55, 65, 81));
		labelroom.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(labelroom);
		
		c1 = new Choice();
		try {
			Conn c = new Conn();
			ResultSet resultSet = c.statement.executeQuery("select * from Room ");
			while(resultSet.next()) {
				c1.add(resultSet.getString("room_no"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		c1.setBounds(140,270,170,20);
		c1.setFont(new Font("Tahoma",Font.BOLD,15));
		c1.setForeground(Color.white);
		c1.setBackground(Color.black);
		panel.add(c1);
		
		JLabel labelDate = new JLabel("Time: ");
		labelDate.setBounds(40,310,200,20);
		labelDate.setForeground(new Color(55, 65, 81));
		labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(labelDate);
		
		Date date1 = new Date();
		
		date = new JLabel(""+date1);
		date.setBounds(140,310,250,20);
		date.setFont(new Font("Tahoma",Font.BOLD,14));
		date.setForeground(new Color(55, 65, 81));
		panel.add(date);
		
		JLabel labelDeposite = new JLabel("Deposite: ");
		labelDeposite.setBounds(40,350,200,20);
		labelDeposite.setForeground(new Color(55, 65, 81));
		labelDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(labelDeposite);
		
		textfieldDeposite = new JTextField();
		textfieldDeposite.setBounds(140,350,170,20);
		panel.add(textfieldDeposite);
		
		b1 = new JButton("Add");
		b1.setBounds(140,410,150,30);
		b1.setFont(new Font("Tahoma",Font.BOLD,15));
		b1.setForeground(Color.white);
		b1.setBackground(new Color(37, 99, 235));
		b1.addActionListener(this);
		panel.add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(310,410,150,30);
		b2.setFont(new Font("Tahoma",Font.BOLD,15));
		b2.setForeground(Color.white);
		b2.setBackground(new Color(37, 99, 235));
		b2.addActionListener(this);
		panel.add(b2);
		
		setUndecorated(true);
		setSize(900,550);
		getContentPane().setBackground(Color.black);
		setLayout(null);
		setLocation(339,250);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			Conn c = new Conn();
			String radioBTN = null;
			if(r1.isSelected()) {
				radioBTN = "Male";
			}else if (r2.isSelected()) {
				radioBTN = "Female";
			}
			
			String s1 = (String)comboBox.getSelectedItem();
			String s2 = textfieldNumber.getText();
			String s3 = textName.getText();
			String s4 = radioBTN;
			String s5 = textfieldDisease.getText();
			String s6 = c1.getSelectedItem();
			String s7 = date.getText();
			String s8 = textfieldDeposite.getText();
			
			try {
				String q = "insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
				String q1 = "update room set Availability = 'Occupied' where room_no = "+s6;
				c.statement.executeUpdate(q);
				c.statement.executeUpdate(q1);
				JOptionPane.showMessageDialog(null,"Added Successfully");
				
				setVisible(false);
			}catch (Exception E) {
				E.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new NEW_PATIENT();
	}
}
