package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

/**
 * This is the controller of the program. It tells it what to do.
 * 
 * @author Brandon Wortmann
 * @version 21.11.17 Added Frame 1.3
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

	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";

		if (chatbot.quitChecker(input))
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

	public String useCheckers(String text)
	{
		String response = "";

		if (chatbot.contentChecker(text))
		{

		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			
		}
		if(chatbot.htmlTagChecker(text))
		{
		
		}
		if(chatbot.userNameChecker(text)) 
		{
			
		}
		if(chatbot.keyboardMashChecker(text))
		{
			
		}
		if(chatbot.shoppingListChecker(text))
		{
			
		}
		if(chatbot.movieTitleChecker(text))
		{
			
		}
		if(chatbot.movieGenreChecker(text))
		{
			
		}
		
		return response;
	}
}
