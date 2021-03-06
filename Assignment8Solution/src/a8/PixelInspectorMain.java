package a8;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixelInspectorMain {

	public static void main(String[] args) throws IOException {
		Picture picture = A8Helper.readFromURL("http://www.cs.unc.edu/~kmp/kmp.jpg");
		PixelInspectorWidget inspector = new PixelInspectorWidget(picture);

		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 8 Pixel Inspector");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel main_panel = new JPanel();
		main_panel.setLayout(new BorderLayout());
		main_panel.add(inspector, BorderLayout.CENTER);
		main_frame.setContentPane(main_panel);

		main_frame.pack();
		main_frame.setVisible(true);

	}

}
