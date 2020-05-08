import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class Application {

	public static int radius = 150;
	public static int score = 10;
	public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = screen.width;
	public static int height = screen.height;
	public static Bounce ball;
	public static GoodScore scoreField = new GoodScore();
	
	// Location
	static float X = 0;
	static float Y = 0;
	
	// Direction
	static float dx = 3;
	static float dy = 3;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Thread.sleep(2000);
		scoreField.text("Get set....");
		
		X = (float)Math.random()*(width-radius*2);
		Y = (float)Math.random()*(height-radius*2);
		ball = new Bounce("Bouncy Ball", radius, (int)X ,(int)Y);
		
		Thread.sleep(2000);
		scoreField.text("Go! (Score: " + score + ")");
		
		addMouseListener();
		
		while(true) {

			X = X + dx;
			Y = Y + dy;
			
			float random1 = (int)(Math.random()*10) < 5 ? -(int)(Math.random()*6) : (int)(Math.random()*6);
			float random2 = (int)(Math.random()*10) < 5 ? -(int)(Math.random()*6) : (int)(Math.random()*6);
			
			if (X < 0) {
				dx=-dx;
				dy=random1; //
				X = 0; 
			} else if (X + radius*2 > width) {
				dx=-dx;;
				dy=random1; //
				X = width - radius*2;
			}

			if (Y < 0) {
				dy=-dy;
				dx=random1; //
				Y = 0;
			} else if (Y + radius*2 > height) {
				dy=-dy;
				dx=random1; //
				Y = height - radius*2;
			}
			
			if((int)dx==0) dx=random2;
			if((int)dy==0) dy=random2;
			
			ball.setLocation((int)X, (int)Y);
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException ex) {
			}
					
			
			if(score <= 0) { 
				ball.removeMouseListener(ball.getMouseListeners()[0]);
				break;
			}
		}
		
		scoreField.text("Aww, you lost!");
		ball.setVisible(false);
		scoreField.repaint();
		scoreField.pack();
		scoreField.center();
		return;
	}

	public static void addMouseListener() {
		ball.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(score>0) {
					score--;
					scoreField.text("Score: " + score);
					scoreField.center();
				}
			}
			public void mouseExited(MouseEvent e) {
				System.out.println("Out");
			}
		} );
	}

}