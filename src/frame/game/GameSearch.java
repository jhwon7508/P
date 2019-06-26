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

public class GameSearch extends JFrame {
	JPanel p;
	JLabel l1, l2, l3, l4, l5, l6, image;
	JTextField t1, t2, t3, t4, t5;
	JTextArea area;
	String num;

	public GameSearch(String num) throws Exception {

		Db2DAO dao = new Db2DAO();
		Db2DTO dto = dao.select(num);

		this.num = num;
		setTitle("경기 정보");
		setSize(600, 1000);

		p = new JPanel();

		l1 = new JLabel("<날짜>>");
		l2 = new JLabel("<<상대팀>>");
		l3 = new JLabel("<<구장>>");
		l4 = new JLabel("<<라인업>>");
		l5 = new JLabel("<<수비포지션>>");
		l6 = new JLabel("<<비고>>");
		image = new JLabel();

		Font font = new Font("고딕", Font.BOLD, 15);

		ImageIcon img = new ImageIcon("search.jpg");
		image.setIcon(img);

		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		l6.setFont(font);

		t1 = new JTextField(50);
		t2 = new JTextField(50);
		t3 = new JTextField(50);
		t4 = new JTextField(50);
		t5 = new JTextField(50);
		area = new JTextArea(20, 50);

		t1.setText(dto.getDate());
		t2.setText(dto.getCompetor());
		t3.setText(dto.getStadium());
		t4.setText(dto.getOffense());
		t5.setText(dto.getDefense());
		area.setText(dto.getNote());

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

		p.setBackground(Color.lightGray);

		add(p);
		setVisible(true);
	}

}