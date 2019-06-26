package frame.player;

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

public class PlayerSearch extends JFrame {
	JPanel p;
	JLabel l1, l2, l3, l4, l5, l6, image;
	JTextField t1, t2, t3, t4, t5;
	JTextArea area;
	String num;

	public PlayerSearch(String num) throws Exception {

		Db1DAO dao = new Db1DAO();
		Db1DTO dto = dao.select(num);

		this.num = num;
		setTitle("선수 정보");
		setSize(600, 1000);

		p = new JPanel();

		l1 = new JLabel("<<등번호>>");
		l2 = new JLabel("<<이름>>");
		l3 = new JLabel("<<포지션>>");
		l4 = new JLabel("<<등록일>>");
		l5 = new JLabel("<<경기 출전 수>>");
		l6 = new JLabel("<<기록>>");
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

		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		l4.setForeground(Color.white);
		l5.setForeground(Color.white);
		l6.setForeground(Color.white);

		t1 = new JTextField(50);
		t2 = new JTextField(50);
		t3 = new JTextField(50);
		t4 = new JTextField(50);
		t5 = new JTextField(50);
		area = new JTextArea(20, 50);

		t1.setText(dto.getNum());
		t2.setText(dto.getName());
		t3.setText(dto.getPosition());
		t4.setText(dto.getRdate());
		t5.setText(dto.getGame());
		area.setText(dto.getScore());

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

		p.setBackground(Color.black);

		add(p);
		setVisible(true);
	}

}