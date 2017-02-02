/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Feb 1, 2017
 */
package chat;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * @author Ethan
 *
 */
public class ChatWindow extends JFrame {
	
	JPanel contentPane;
	JTextArea chatPanel;
	JScrollPane scroll;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5205465820795150208L;

	/**
	 * @throws HeadlessException
	 */
	public ChatWindow() throws HeadlessException {
		
		JPanel contentPane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		chatPanel = new JTextArea("TEST TEST TEST TEST TEST TEST TEST TEST TEST\n TEST\n TEST TEST ");
	    chatPanel.setEditable(false); 
	    scroll = new JScrollPane(chatPanel);
//	    scroll.setSize(40, 40);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
	    
	    contentPane.add(scroll);
		contentPane.setVisible(true);
		this.add(contentPane);
		
		
		setSize(new Dimension(600, 600));
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChatWindow();
	}

}
