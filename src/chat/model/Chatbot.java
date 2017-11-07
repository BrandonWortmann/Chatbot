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
		this.content = "content";
		this.intro = "";
		this.currentTime = null;
		this.topics = new String [3];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildShoppingList();
		buildQuestions();
		buildTopics();
		buildCuteAnimals();
		buildMovieList();
	}
	// Creates the topics the chatbot talks about
	private void buildTopics()
	{
		topics[0] = "Video Games.";
		topics[1] = "Math";
		topics[2] = "Animals";
	}
	// Creates the topics the chatbot talks about
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalet about";
		verbs[3] = "am thinking about";
	}

	private void buildMovieList()
	{
		movieList.add(new Movie("Zombie Land"));
		movieList.add(new Movie("The Advengers"));
		movieList.add(new Movie("Jigsaw"));
		movieList.add(new Movie("Spiderman"));
		movieList.add(new Movie("Hidden Figures"));
		
		
	}
	// Creates the List of item to buy
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
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
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
	// The output for the chatbot
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n"+ input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	// Builds the output
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int)(Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int)(Math.random()* topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int)(Math.random() * questions.length);
		response += questions[random];
		
		random = (int)(Math.random() * 2);
		
		if(random % 2==0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great Movie!";
		}
		
		
		
		return response;
	}
	// Makes sure the input length if valid
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
		if(input == null)
		{
			return false;
		}
		if(input.length() < 2)
		{
			return false;
		}
		
		
		if(input.charAt(0) == '@' && !input.substring(1,input.length()).contains("@") )
		{
			return true;
		}
		
		
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		if(contentCheck.length() > 5)
		{
			return true;
		}
		
		if(contentCheck.contains(content))
		{
			return true;
		}
		
		
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		for(int i=0; i<cuteAnimalMemes.size(); i++)
		{
			if(input.contains(cuteAnimalMemes.get(i)))
			{
				return true;
			}
		}
		
		return false;
	}
	// Sees if they want something on the shopping list
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
		if(title.length() < 1)
		{
			return false;
		}
		
		return true;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}
	// Checks if they want to end
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
	// Checks to see if they mashed he keyboard
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
