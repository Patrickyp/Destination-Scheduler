import javax.swing.*;
import java.awt.*;
import java.net.URLEncoder;
import java.net.*;

public class SWDA1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Tour Schedule");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tour app = new tour();
		frame.setContentPane(app.container);
		frame.pack();
		frame.setVisible(true);

		
	}

}
