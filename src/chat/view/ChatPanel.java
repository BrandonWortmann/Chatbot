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


/**
 * sets up the JPanel
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
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		checkerButton = new JButton("Test");
		chatButton= new JButton("chat");
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		
		
		
		
		
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		
	}

	/**
	 * adds everything to the Panel
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		this.add(checkerButton);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}

	/**
	 * Sets the layout for all of the panel components
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 20, SpringLayout.SOUTH, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -20, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -20, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 0, SpringLayout.SOUTH, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, -60, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 10, SpringLayout.SOUTH, checkerButton);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 20, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, -100, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
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
	            public void actionPerformed(ActionEvent enter)
	            {
	            		
	            }
	        });

	}
	
	
	
	
}
