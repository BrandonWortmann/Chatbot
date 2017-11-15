package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatbotController;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import java.awt.Color;



public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		chatButton= new JButton("chat");
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		
		
		
		
		
		
		
		setupPanel();
		setupLayout();
		setupLiseners();
		
		
	}

	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}

	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 20, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 20, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -20, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -20, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -20, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -64, SpringLayout.SOUTH, this);
	}
	
	private void setupLiseners()
	{
		
	}
	
	
}
