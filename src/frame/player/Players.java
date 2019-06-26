package frame.player;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Players extends JFrame implements ActionListener {

	JPanel p;
	JLabel image;
	JButton b1, b2;

	public Players() {

		setTitle("선수정보");
		setSize(700, 900);

		p = new JPanel();

		image = new JLabel();

		b1 = new JButton("선수 정보 추가");
		b2 = new JButton("선수 정보 확인");

		ImageIcon img = new ImageIcon("Black.jpg");

		image.setIcon(img);

		b1.addActionListener(this);
		b2.addActionListener(this);

		b1.setBackground(Color.red);
		b2.setBackground(Color.darkGray);
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);

		p.add(b1);
		p.add(b2);
		p.add(image);

		p.setBackground(Color.black);

		add(p);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			PlayerInput input = new PlayerInput();
		}
		if (e.getSource() == b2) {
			PlayerOutput name = new PlayerOutput();
		}
	}

}
