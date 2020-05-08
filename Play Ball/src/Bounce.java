import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bounce extends JFrame {
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	public int width = screen.width;
	public int height = screen.height;
	public int r = 150;

	Bounce(String name, int radius, int X, int Y) throws IOException {
		r = radius;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(r<150) setName(name + " (Easy)");
		else setName(name + " (Challenging)");
		setUndecorated(true);
		setAlwaysOnTop(true);
		setIconImage(new ImageIcon(getClass().getResource("/resources/AP.png")).getImage());
		setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(r*2, r*2));
		
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/newball.png"));
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(r*2, r*2,  java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);  // transform it back
		JLabel picLabel = new JLabel(imageIcon);
		
		getContentPane().add(picLabel, BorderLayout.CENTER);
		setLocation(X, Y);
		
		//Display
		pack();
		setVisible(true);
		
	}
	
	private static final long serialVersionUID = 42L;
	
}