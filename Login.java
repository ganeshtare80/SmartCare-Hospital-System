package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	JTextField textfield;
	JPasswordField jPasswordfield;
	
	JButton b1,b2;
	
	Login(){
		
		JLabel namelabel = new JLabel("Username");
		namelabel.setBounds(40,20,100,30);
		namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
		add(namelabel);
		
		JLabel password = new JLabel("Password");
		password.setBounds(40,70,100,30);
		password.setFont(new Font("Tahoma",Font.BOLD,16));
		add(password);
		
		textfield = new JTextField();
		textfield.setBounds(150,20,200,27);
		textfield.setFont(new Font("Tahoma",Font.PLAIN,15));
		textfield.setBackground(new Color(154,255,232));
		add(textfield);
		
		jPasswordfield = new JPasswordField();
		jPasswordfield.setBounds(150,70,200,27);
		jPasswordfield.setFont(new Font("Tahoma",Font.PLAIN,15));
		jPasswordfield.setBackground(new Color(154,255,232));
		add(jPasswordfield);
		
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i1 = imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon imageIcon1 = new ImageIcon(i1);		//Creates a new ImageIcon from the resized image
														//Wraps the scaled Image back into an ImageIcon
														//Swing components like JLabel can only display icons, not raw images
		JLabel label = new JLabel(imageIcon1);
		label.setBounds(340,-30,400,300);
		add(label);
		
		b1 = new JButton("Login");
		b1.setBounds(40,115,150,27);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(200,115,150,27);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		JLabel id = new JLabel("ID: GTlogin");
		id.setBounds(40,220,150,30);
		add(id);
		JLabel pass = new JLabel("Pass: GT123");
		pass.setBounds(40,235,150,30);
		add(pass);
		
		getContentPane().setBackground (new Color(109, 164, 170));
		setSize(750,300);
		setLocation(400,270);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			try {
				Conn c = new Conn();
				String user = textfield.getText();
				String pass = jPasswordfield.getText();
				
				String q = "select * from login where ID = '"+user+"' and PW = '"+pass+"'";
				ResultSet resultset = c.statement.executeQuery(q);
				
				if(resultset.next()) {
					new Reception();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid");
				}
			}catch(Exception E) {
				E.printStackTrace();
			}
		}else {
			System.exit(10);
		}
	}
	
	public static void main(String[] args) {
		new Login();
//		System.out.println("hello");
	}
}
