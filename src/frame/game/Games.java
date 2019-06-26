package frame.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Games extends JFrame implements ActionListener {

	JPanel p;
	JLabel image;
	JButton b1, b2;

	public Games() {

		setTitle("경기정보");
		setSize(700, 900);

		p = new JPanel();

		image = new JLabel();

		b1 = new JButton("경기 정보 입력");
		b2 = new JButton("경기 정보 확인");

		b1.setBackground(Color.red);
		b2.setBackground(Color.darkGray);

		b1.setForeground(Color.white);
		b2.setForeground(Color.white);

		ImageIcon img = new ImageIcon("Gray.jpg");
		image.setIcon(img);

		b1.addActionListener(this);
		b2.addActionListener(this);

		p.add(b1);
		p.add(b2);
		p.add(image);

		p.setBackground(Color.darkGray);

		add(p);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			GameInput input = new GameInput();
		}
		if (e.getSource() == b2) {
			GameOutput output = new GameOutput();
		}
	}

}
