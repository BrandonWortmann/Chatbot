package chat.view;


import chat.controller.ChatbotController;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JLabel titleLabel;
	private JScrollPane chatScrollPane;
	
	/**
	 * this is the constructor for the panel
	 * @param appController
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;

		checkerButton = new JButton("Test");
		chatButton = new JButton("Chat" , new ImageIcon(getClass().getResource("/chat/view/images/chatImage.png")));
		searchButton = new JButton("Search" , new ImageIcon(getClass().getResource("/chat/view/images/searchImage.png")));
		loadButton = new JButton("Load" , new ImageIcon(getClass().getResource("/chat/view/images/loadImage.png")));
		saveButton = new JButton("Save" , new ImageIcon(getClass().getResource("/chat/view/images/saveImage.png")));
		tweetButton = new JButton("Tweet" , new ImageIcon(getClass().getResource("/chat/view/images/tweetImage.png")));
		
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		infoLabel = new JLabel("Type to chat with the chatbot");
		titleLabel = new JLabel("Welcome to Chatbot");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		appLayout = new SpringLayout();
		
		
		chatScrollPane = new JScrollPane();
		appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -200, SpringLayout.SOUTH, this);
		
		
		
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		

	}
	/**
	 * sets up the scroll pane
	 */
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
		this.add(infoLabel);
		this.add(titleLabel);
		infoLabel.setForeground(Color.BLACK);
		titleLabel.setForeground(Color.BLACK);
		
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
		this.add(loadButton);
		this.add(saveButton);
		this.add(tweetButton);
		this.add(searchButton);

	}

	/**
	 * Sets the layout for all of the panel components
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, titleLabel, 150, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, titleLabel, -150, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 21, SpringLayout.SOUTH, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 150, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, infoLabel, -150, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 10, SpringLayout.EAST, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, 0, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 10, SpringLayout.EAST, loadButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 10, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 10, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 10, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 10, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 10, SpringLayout.SOUTH, infoLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -122, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, infoLabel, 10, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, chatScrollPane, -200, SpringLayout.SOUTH, this);
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
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				

			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				

			}
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String usernameToSearch = inputField.getText();
				chatArea.setText(appController.search(usernameToSearch));
				

			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.tweet(inputField.getText());

			}
		});
		

	}
	
	

}
