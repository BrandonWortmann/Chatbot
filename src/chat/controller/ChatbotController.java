package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;

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
	private CTECTwitter myTwitter;

	/** 
	 * this is the constructor for the controller
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Brandon Wortmann");
		myTwitter = new CTECTwitter(this);
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}

	/**
	 * this starts the class
	 */
	public void start()
	{
		display.displayText("Welcome to Chatbot");

	}

	/**
	 * this tells the gui what to output
	 * @param input
	 * @return
	 */
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

	/**
	 * this closes the program
	 */
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);

	}

	/** 
	 * this returns the chatbot
	 * @return
	 */
	public Chatbot getChatbot()
	{
		return chatbot;
	}

	/** 
	 * this returns the display
	 * @return
	 */
	public PopupDisplay getDisplay()
	{
		return display;
	}

	/**
	 * this returns the frame
	 * @return
	 */
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}

	/** 
	 * this is used for all of the checkers
	 * @param text
	 * @return
	 */
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
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
}
