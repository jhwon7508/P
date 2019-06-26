package frame.player;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayerOutput extends JFrame implements ActionListener {
	JPanel p;
	JButton b1, b2, b3;
	JLabel l1, l2, l3, image;
	JTextField t1, t2;

	public PlayerOutput() {

		setTitle("선수 정보 확인");
		setSize(600, 650);

		p = new JPanel();

		image = new JLabel();
		l1 = new JLabel("검색할 선수 입력");
		l2 = new JLabel("삭제할 선수 입력");
		l3 = new JLabel("   선수 정보 수정");

		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);

		ImageIcon img = new ImageIcon("Player.jpg");
		image.setIcon(img);

		b1 = new JButton("검색");
		b2 = new JButton("삭제");
		b3 = new JButton("수정");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		b1.setBackground(Color.darkGray);
		b2.setBackground(Color.darkGray);
		b3.setBackground(Color.darkGray);

		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);
		b3.setForeground(Color.WHITE);

		t1 = new JTextField(30);
		t2 = new JTextField(15);

		p.add(l1);
		p.add(t1);
		p.add(b1);

		p.add(image);

		p.add(l2);
		p.add(t2);
		p.add(b2);

		p.add(l3);
		p.add(b3);

		p.setBackground(Color.black);

		add(p);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

			try {
				PlayerSearch search = new PlayerSearch(t1.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (e.getSource() == b2) {

			Db1DAO dao = new Db1DAO();
			Db1DTO dto = new Db1DTO();
			String num = t2.getText();

			dto.setNum(num);

			PlayerDelete delete = new PlayerDelete();
			try {
				delete.PDelete(dto);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
		}

		if (e.getSource() == b3) {

			Db1DAO dao = new Db1DAO();
			Db1DTO dto = new Db1DTO();

			PlayerUpdate update = new PlayerUpdate();
		}
	}

}
