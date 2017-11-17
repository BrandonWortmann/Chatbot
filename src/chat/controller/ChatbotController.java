package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

/**
 * This is the controller of the program.  It tells it what to do.
 * @author brandon Wortmann
 *
 */
public class ChatbotController
{
	
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Brandon Wortmann");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		display.displayText("Welcome to Chatbot");
		
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
		
	}
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);

	}
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}

	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
}
