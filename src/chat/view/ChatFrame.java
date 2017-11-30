package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;
/**
 * sets up the Jframe for the project
 * @author brandon Wortman
 *
 */
public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPane;
	
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPane = new ChatPanel(appController);
		setupFrame();
	}
	
	/** 
	 * sets up the frame
	 */
	private void setupFrame()
	{
		this.setContentPane(appPane);
		this.setTitle("Chatting with the chatbot");
		this.setResizable(false);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public ChatbotController getAppController()
	{
		return appController;
	}

}
