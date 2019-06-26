package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frame.game.Games;
import frame.player.Players;

public class Home extends JFrame implements ActionListener {

	public static void main(String[] args) {
		Home h = new Home();
	}

	JPanel p;
	JLabel text, image;
	JButton b1, b2;

	public Home() {

		setTitle("LG Twins 홈");
		setSize(600, 750);

		p = new JPanel();

		text = new JLabel("엘지 트윈스 경기정보 홈페이지 입니다");

		image = new JLabel();

		b1 = new JButton("선수정보");
		b2 = new JButton("경기정보");

		Font font = new Font("고딕", Font.BOLD, 20);
		text.setFont(font);

		ImageIcon img = new ImageIcon("logo.jpg");
		image.setIcon(img);
		image.setSize(500, 500);

		b1.addActionListener(this);
		b2.addActionListener(this);

		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b2.setBackground(Color.lightGray);

		p.add(text);
		p.add(image);
		p.add(b1);
		p.add(b2);

		add(p);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			Players players = new Players();
		}
		if (e.getSource() == b2) {
			Games games = new Games();
		}
	}

}
