package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String[10];
		this.username = username;
		this.content = "";
		this.intro = "";
		this.currentTime = null;
		this.topics = new String [3];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildShoppingList();
		buildQuestions();
		buildTopics();
	}
	
	private void buildTopics()
	{
		topics[0] = "Video Games.";
		topics[1] = "Math";
		topics[2] = "Animals";
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalet about";
		verbs[3] = "am thinking about";
	}

	private void buildMovieList()
	{
		
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("Steak");
		shoppingList.add("pizza");
		shoppingList.add("soda");
		shoppingList.add("ice cream");
		shoppingList.add("protein");
		shoppingList.add("veggies");
		
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "How old are you?";
		questions[2] = "What do you like to do?";
		questions[3] = "What is your favorite food?";
		questions[4] = "What is your favorit sport?";
		questions[5] = "What is your favorite movie?";
		questions[6] = "What is your favorite video game?";
		questions[7] = "Do you like apple, android, or neither?";
		questions[8] = "Where is your favorite place to visit?";
		questions[9] = "What is your job?";
				
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n"+ input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int)(Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int)(Math.random()* topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int)(Math.random() * questions.length);
		response += questions[random];
		
		
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean pass = false;
		
		if(input != null && input.length() > 2)
		{
			pass = true;
		}
		
		
		return pass;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean pass = false;
		
		for(int i = 0; i<shoppingList.size(); i++)
		{
			if (shoppingItem.contains(shoppingList.get(i)))
			{
				pass = true;
			}
		}
		
		return pass;
		
		
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if(exitString == null)
		{
			return false;
		}

		if(exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		String[] mash = new String[9];
		
		mash[0] = "sdf";
		mash[1] = "SDF";
		mash[2] = "dfg";
		mash[3] = "cvb";
		mash[4] = ",./";
		mash[5] = "kjh";
		mash[6] = "DFG";
		mash[7] = "CVB";
		mash[8] = "KJH";
		
		for(String letters: mash)
		{
			if(sample.contains(letters))
			{
				return true;
			}
		}
		
			
		return false;
	}

	public String toString()
	{
		return "";
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
