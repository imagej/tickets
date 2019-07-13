import com.apple.eawt.Application;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class DefaultMacMenuBar {

	public static void main(final String[] args) {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		final JMenuBar menuBar = new JMenuBar();
		final JMenu file = new JMenu("File");
		menuBar.add(file);
		final JMenuItem fileExit = new JMenuItem("Exit");
		fileExit.setAccelerator(makeKeyStroke(KeyEvent.VK_X));
		file.add(fileExit);
		menuBar.add(file);
//		makeFrame("Click me", menuBar);
//		makeFrame("Click me too", menuBar);
		Application.getApplication().setDefaultMenuBar(menuBar);
		makeFrame("Click me", null);
		makeFrame("Click me too", null);
	}

	private static KeyStroke makeKeyStroke(final int key) {
		return KeyStroke.getKeyStroke(key, Toolkit.getDefaultToolkit()
			.getMenuShortcutKeyMask());
	}

	private static void
		makeFrame(final String buttonLabel, final JMenuBar menuBar)
	{
		final JFrame frame = new JFrame();
		frame.getContentPane().add(new JButton(buttonLabel));
		if (menuBar != null) frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation((int) (300 * Math.random()), (int) (300 * Math.random()));
		frame.pack();
		frame.setVisible(true);
	}

}
