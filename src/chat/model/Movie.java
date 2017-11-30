package chat.model;

import java.time.LocalDate;

public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;
	
	public Movie(String title)
	{
		if(title.length()<4)
		{
			this.title = "Movie";
		}
		else
		{
			this.title = title;
		}
		
		this.genre = "generic";
		this.ratingMPAA = "G"; ;
		this.review = "It was a great movie";
		this.length = 11;
		this.releaseDate = LocalDate.now();
		this.starScore = 0.0;
	}
	
	public Movie(String title, String genre)
	{
		if(title.length()<4)
		{
			this.title = "Movie";
		}
		else
		{
			this.title = title;
		}
		
		if(genre.length()<5)
		{
			this.genre = "Genre";
		}
		else
		{
			this.genre = genre;
		}
		
		
		this.genre = genre;
		this.ratingMPAA = ""; ;
		this.review = "";
		this.length = 5;
		this.releaseDate = LocalDate.now();
		this.starScore = 0.0;
	}

	public String getTitle()
	{
		return title;
	}

	public String getGenre()
	{
		return genre;
	}

	public String getRatingMPAA()
	{
		return ratingMPAA;
	}

	public String getReview()
	{
		return review;
	}

	public int getLength()
	{
		return length;
	}

	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	public double getStarScore()
	{
		return starScore;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
	}

	public void setReview(String review)
	{
		this.review = review;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}
	
	public String toString()
	{
		return "";
	}
}
