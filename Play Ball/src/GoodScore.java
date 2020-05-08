import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GoodScore extends JFrame {
	private static final long serialVersionUID = 1L;
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	public JLabel label = new JLabel("On your marks...");
	Font font = new Font("Monospaced", Font.BOLD, 50);
	Container c = this.getContentPane();
	
	public GoodScore() {
		setTitle("Play Ball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setUndecorated(false);
		setIconImage(new ImageIcon(getClass().getResource("/resources/AP.png")).getImage());
		setBackground(new Color(1f, 1f, 1f, 1.0f));
//		JLabel text = new JLabel("Score: 10");
//		Font font = new Font("Monospaced", Font.BOLD, 50);
		label.setFont(font);
		label.setForeground(new Color(220, 0, 0));
		
//		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(label);
		
		pack();
		center();
		setVisible(true);
	}
	
	public void text(String text) {
		label.setText(text);
		pack();
		center();
	}
	
	public void center() {
		setLocation((screen.width/2)-getWidth()/2,34);
	}
	
}
