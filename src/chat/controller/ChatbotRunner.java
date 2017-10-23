package chat.controller;

import chat.view.PopupDisplay;

public class ChatbotRunner
{
	public static void main(String[] args)
	{
		PopupDisplay test = new PopupDisplay();
		test.displayText("Hi Im a penguin");
		test.collectResponse("ask a question");
		
		
		
		
		///ChatController app = new ChatController();
		//app.start();
	}
}
