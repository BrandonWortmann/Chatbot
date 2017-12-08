
package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * this is the chatbot object it holds all of the information that has to do with chatbot
 * @author Brandon Wortmann
 *
 */
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
	
	/**
	 * this is the constructor for the chatbot
	 * @param username
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String[10];
		this.username = username;
		this.content = "content";
		this.intro = "";
		this.currentTime = LocalTime.now();
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
	
	
	/**
	 *  Creates the topics the chatbot talks about
	 */
	private void buildTopics()
	{
		topics[0] = "Video Games.";
		topics[1] = "Math";
		topics[2] = "Animals";
	}
	
	/**
	 * Creates the topics the chatbot talks about
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalet about";
		verbs[3] = "am thinking about";
	}
	
	/**
	 * Adds the movie to the movie list
	 */
	private void buildMovieList()
	{
		movieList.add(new Movie("Zombie Land", "Comedy"));
		movieList.add(new Movie("The Avengers", "Action"));
		movieList.add(new Movie("Jigsaw", "Thriller"));
		movieList.add(new Movie("Spiderman", "Spiderman"));
		movieList.add(new Movie("Hidden Figures", "Drama"));
		movieList.add(new Movie("Life", "Horror"));
		movieList.add(new Movie("Born in China", "Documentary"));
		
		
	}
	
	/**
	 *  Creates the List of item to buy
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("steak");
		shoppingList.add("pizza");
		shoppingList.add("soda");
		shoppingList.add("ice cream");
		shoppingList.add("protein");
		shoppingList.add("veggies");
		shoppingList.add("chips");
		shoppingList.add("queso");
		shoppingList.add("salsa");
		shoppingList.add("milk");
		shoppingList.add("bread");
		shoppingList.add("eggs");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanut butter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
			
		
	}
	
	/**
	 * adds animals to the cute Animals list
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
	}

	/**
	 * A list of questions the chatbot asks
	 */
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
	
	/**
	 *  The output for the chatbot
	 * @param input
	 * @return String
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		
		if(currentTime.getMinute() < 10)
		{
			chatbotResponse += currentTime.getHour() + ":0" + currentTime.getMinute() + " ";
		}
		else
		{
			chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
		}
		
		chatbotResponse += "You said:" + "\n"+ input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 *  Builds the output
	 * @return String
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int)(Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int)(Math.random()* topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int)(Math.random() * questions.length);
		response += questions[random] + "\n";
		
		random = (int)(Math.random() * 2);
		
		if(random % 2==0)
		{
			random = (int) (Math.random() * movieList.size());
			response +=  movieList.get(random).getTitle() + " is a great Movie!\n";
		}
		
		int followup = (int)(Math.random() * 5);
		
		switch(followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		
		
		return response;
	}

	/**
	 *  Makes sure the input length if valid
	 * @param input
	 * @return boolean
	 */
	public boolean lengthChecker(String input)
	{
		boolean pass = false;
		
		if(input != null && input.length() > 2)
		{
			pass = true;
		}
		
		
		return pass;
	}
	/**
	 * Checks to make sure it is a valid html tag
	 * @param input
	 * @return boolean
	 */
	public boolean htmlTagChecker(String input)
	{
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">");
		int secondOpen = input.indexOf("<", firstOpen);
		int secondClose = input.indexOf(">", firstClose);
		
		
		
		if(!input.contains("<") || !input.contains(">"))
		{
			return false;
		}
		if(input.equals("<>") || input.equals("< >"))
		{
			return false;
		}
		if(input.toLowerCase().contains("<p>") || input.toLowerCase().contains("<br"))
		{
			return true;
		}
		if(secondOpen == -1 || secondClose == -1 || firstOpen == -1|| firstClose == -1)
		{
			return false;
		}
		if(!input.contains("/"))
		{
			return false;
		}
		if(input.substring(firstOpen + 1, firstClose).equalsIgnoreCase(input.substring(secondOpen + 2 , secondClose)))
		{
			return true;
		}
		if(input.toLowerCase().contains("a href") && !input.toLowerCase().contains("="))
		{
			return false;
		}
		
		
		
		return true;
	}
	
	/**
	 * Makes sure the user name has correct format
	 * @param input
	 * @return boolean
	 */
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
	
	/** 
	 * detects what they are talking about
	 * @param contentCheck
	 * @return boolean
	 */
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
	
	/**
	 * Checks their input for animals
	 * @param input
	 * @return boolean
	 */
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
	
	/**
	 *  Sees if they want something on the shopping list
	 * @param shoppingItem
	 * @return boolean
	 */
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
	
	/**
	 * Checks if they mention a movie in their text
	 * @param title
	 * @return
	 */
	public boolean movieTitleChecker(String title)
	{
		for(Movie movieTitle: movieList)
		{
			if(title.toLowerCase().contains(movieTitle.getTitle().toLowerCase()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if they mention a genre in their text
	 * @param genre
	 * @return
	 */
	public boolean movieGenreChecker(String genre)
	{
		for(Movie movieGenre: movieList)
		{
			if(genre.toLowerCase().contains(movieGenre.getGenre().toLowerCase()))
			{
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 *  Checks if they want to end
	 * @param exitString
	 * @return
	 */
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
	
	/**
	 *  Checks to see if they mashed he keyboard
	 * @param sample
	 * @return
	 */
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

	/**
	 * Creates the toString for the chatbot
	 */
	public String toString()
	{
		return "";
	}
	
	/**
	 * a getter for the movies
	 * @return
	 */
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	/**
	 * a getter for the shopping list
	 * @return
	 */
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	/**
	 * a getter for the animal memes
	 * @return
	 */
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	/**
	 * a getter for the questions
	 * @return
	 */
	public String [] getQuestions()
	{
		return questions;
	}
	
	/**
	 * a getter for the questions
	 * @return
	 */
	public String[] getVerbs()
	{
		return verbs;
	}

	/**
	 * a geetter for the topics
	 * @return
	 */
	public String[] getTopics()
	{
		return topics;
	}

	/**
	 * a getter for the followups
	 * @return
	 */
	public String[] getFollowUps()
	{
		return followUps;
	}

	/**
	 * a getter for the username
	 * @return
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * a getter for the content
	 * @return
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * a getter for the Intro
	 * @return
	 */
	public String getIntro()
	{
		return intro;
	}
	
	/**
	 * a getter for the current time
	 * @return
	 */
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	/**
	 * sets the user name
	 * @param username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * sets the content
	 * @param content
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
