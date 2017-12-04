package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatbotController;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

/**
 * sets up the JPanel
 * 
 * @author Brandon Wortmann
 *
 */
public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JLabel titleLabel;
	private JScrollPane chatScrollPane;

	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;

		checkerButton = new JButton("Test");
		chatButton = new JButton("Chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		infoLabel = new JLabel("Type to chat with the chatbot");
		titleLabel = new JLabel("Welcome to Chatbot");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		appLayout = new SpringLayout();
		chatScrollPane = new JScrollPane();
		
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		

	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
	}

	/**
	 * adds everything to the Panel
	 */
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(checkerButton);
		this.add(infoLabel);
		this.add(titleLabel);
		infoLabel.setForeground(Color.BLACK);
		titleLabel.setForeground(Color.BLACK);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);

	}

	/**
	 * Sets the layout for all of the panel components
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -20, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -100, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, infoLabel, 10, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 30, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 30, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 20, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -20, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, titleLabel, 150, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, titleLabel, -150, SpringLayout.EAST, this);
	}

	/**
	 * The listeners for the buttons and text field
	 */
	private void setupListeners()
	{

		inputField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent enter)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");

			}
		});

		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent enter)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");

			}
		});

		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String  userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");

			}
		});

	}
	
	

}
