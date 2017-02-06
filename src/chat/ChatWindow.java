/**
 * Chat
 * @author Ethan Brown
 * CS 3230
 * Feb 1, 2017
 */
package chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
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

	private JPanel contentPane;
	private JTextArea chatPane;
	private JTextArea chatInput;
	private JPanel inputPanel;
	private JScrollPane scroll;
	private JButton send;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5205465820795150208L;

	/**
	 * @throws HeadlessException
	 */
	public ChatWindow() throws HeadlessException {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 400));
		this.setResizable(true);

		contentPane = new JPanel(new BorderLayout());

		chatPane = new JTextArea();
		chatPane.setEditable(false);
		chatPane.setLineWrap(true);
		chatPane.setWrapStyleWord(true);
		scroll = new JScrollPane(chatPane);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll, "Center");

		getContentPane().add(contentPane);

		inputPanel = new JPanel(new FlowLayout());
		chatInput = new JTextArea(0,25);
		chatInput.setEditable(true);
		inputPanel.add(chatInput);

		send = new JButton("Send");
		inputPanel.add(send);

		//listeners for button and textArea
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendText();
			}
		});
		
		chatInput.addKeyListener(new KeyListener(){
		    @Override
		    public void keyPressed(KeyEvent e){
		        if(e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == KeyEvent.CTRL_MASK) {
		        sendText();
		        }
		    }

		    @Override
		    public void keyTyped(KeyEvent e) {
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
		    }
		});
		
		contentPane.add(inputPanel, "South");
		contentPane.setVisible(true);
		setVisible(true);
	}
	
	/**
	 * transfers text from input box to chat pane.
	 */
	private void sendText() {
		String chatSend;
		String userName = "Ethan";
		chatSend = chatInput.getText();
		chatPane.append(userName +": " + chatSend + "\n");
		chatInput.setText("");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChatWindow();
	}

}
