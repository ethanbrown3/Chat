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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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

	private static final long serialVersionUID = -4248589752453598110L;
	
	private JTextArea chatArea;
	private JTextArea chatInputArea;
	private Socket socket1;
	private BufferedReader input;
	private PrintWriter output;
	private String userName;


	/**
	 * @throws HeadlessException
	 * @throws IOException 
	 */
	public ChatWindow(Socket socket1, String user) throws HeadlessException, IOException {
		this.socket1 = socket1;
		output = new PrintWriter(socket1.getOutputStream(), true);
		userName = user;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 400));
		this.setResizable(true);
		
		// center panel
		JPanel contentPane = new JPanel(new BorderLayout());
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		JScrollPane chatScroll = new JScrollPane(chatArea);
		chatScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(chatScroll, "Center");

		// south panel
		JPanel inputPanel = new JPanel(new FlowLayout());
		chatInputArea = new JTextArea(3, 25);
		chatInputArea.setEditable(true);
		chatInputArea.setLineWrap(true);
		chatInputArea.setWrapStyleWord(true);
		JScrollPane inputScroll = new JScrollPane(chatInputArea);
		inputScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		inputPanel.add(inputScroll);
		chatInputArea.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == KeyEvent.CTRL_MASK) {
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

		// send button setup
		JButton send = new JButton("Send");
		inputPanel.add(send);
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendText();
			}
		});
		
		contentPane.add(inputPanel, "South");
		getContentPane().add(contentPane);
		contentPane.setVisible(true);
		setVisible(true);
		chatInputArea.requestFocusInWindow();

	}

	/**
	 * transfers text from input box to chat pane.
	 * will eventually send text through the chat client.
	 */
	private void sendText() {
		String chatSend;
		chatSend = chatInputArea.getText();
		chatInputArea.setText("");
		output.println(userName + ": " + chatSend);
		
		
	}
	
	public void addText(String chat) {
		chatArea.append(chat + "\n\n");
		chatArea.setCaretPosition(chatArea.getDocument().getLength());

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new ChatWindow();
	}

}
