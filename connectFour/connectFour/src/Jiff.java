import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Jiff extends JFrame{

	public static void main(String[] args) {
		new Jiff();
		

	}
	public Jiff(){
		super("connectFour");
		this.setSize(700,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint(Graphics g){
		BufferedImage img = null;
	    try {
	        img = ImageIO.read(new File("Connect4Board.png"));
	    } catch (IOException e) {
	    }
	    //g = img.getGraphics();
	    g.drawImage(img,0, 0,null );
		
		//BufferedImage boardPic= new BufferedImage(new Image());
		g.drawString("Welcome to Connect Four!!!!!",10,35);
		g.drawString("player 1 starts, click on a column to play in it",10 ,50);
		g.drawRect(100, 100, 400, 400);
		//g.drawImage(Connect4Board.png, 100, 100, null);
		
	}
}
