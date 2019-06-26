package frame.game;

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

public class GameOutput extends JFrame implements ActionListener {
	JPanel p;
	JButton b1, b2, b3;
	JLabel l1, l2, l3, image;
	JTextField t1, t2, t3;

	public GameOutput() {

		setTitle("경기 정보 확인");
		setSize(600, 700);

		p = new JPanel();

		image = new JLabel();
		l1 = new JLabel("검색할 경기 입력");
		l2 = new JLabel("삭제할 경기 입력");
		l3 = new JLabel("   경기정보 수정");

		ImageIcon img = new ImageIcon("game.jpg");
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

		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		b3.setForeground(Color.white);

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

		p.setBackground(Color.lightGray);

		add(p);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

			try {
				GameSearch search = new GameSearch(t1.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (e.getSource() == b2) {

			Db2DAO dao = new Db2DAO();
			Db2DTO dto = new Db2DTO();
			String date = t2.getText();

			dto.setDate(date);

			GameDelete delete = new GameDelete();
			try {
				delete.GDelete(dto);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "삭제 되었습니다.");

		}
		if (e.getSource() == b3) {

			Db2DAO dao = new Db2DAO();
			Db2DTO dto = new Db2DTO();

			GameUpdate update = new GameUpdate();
		}
	}

}
