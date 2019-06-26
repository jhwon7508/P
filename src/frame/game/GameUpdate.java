package frame.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GameUpdate extends JFrame implements ActionListener {
	JPanel p;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6, image;
	JTextField t1,t2,t3,t4,t5;
	JTextArea area;
	
	public GameUpdate() {
		
		setTitle("경기 정보 수정");
		setSize(600,1000);
		
		p = new JPanel();
		
		l1= new JLabel("<날짜>>");
		l2= new JLabel("<<상대팀>>");
		l3= new JLabel("<<구장>>");
		l4= new JLabel("<<라인업>>");
		l5= new JLabel("<<수비포지션>>");
		l6= new JLabel("<<비고>>");
		image = new JLabel();
		
		Font font= new Font("고딕", Font.BOLD, 15);

		ImageIcon img = new ImageIcon("input.jpg");
		image.setIcon(img);
	
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		l6.setFont(font);
		
		t1= new JTextField(50);
		t2= new JTextField(50);
		t3= new JTextField(50);
		t4= new JTextField(50);
		t5= new JTextField(50);
		area = new JTextArea(20,50);
		
		b1 = new JButton("수정");
		b2 = new JButton("다시쓰기");
				
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		b1.setForeground(Color.white);
		b1.setBackground(Color.darkGray);
		
		p.add(image);
		
		p.add(l1);
		p.add(t1);

		p.add(l2);
		p.add(t2);

		p.add(l3);
		p.add(t3);

		p.add(l4);
		p.add(t4);

		p.add(l5);
		p.add(t5);

		p.add(l6);
		p.add(area);
		
		p.add(b1);
		p.add(b2);
		
		p.setBackground(Color.lightGray);
				
		add(p);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			Db2DAO dao = new Db2DAO();
			Db2DTO dto = new Db2DTO();
			
			String date = t1.getText();
			String competor = t2.getText();
			String stadium = t3.getText();
			String offense = t4.getText();
			String defense = t5.getText();
			String note = area.getText();
			
			dto.setDate(date);
			dto.setCompetor(competor);
			dto.setStadium(stadium);
			dto.setOffense(offense);
			dto.setDefense(defense);
			dto.setNote(note);
		
			GameUpdate2 pu = new GameUpdate2();
			
			try {
				pu.GUpdate(dto);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
			
		}
		if (e.getSource() == b2) {
			t1.setText(null);
			t2.setText(null);
			t3.setText(null);
			t4.setText(null);
			t5.setText(null);
			area.setText(null);
		}
		
	}
	
}