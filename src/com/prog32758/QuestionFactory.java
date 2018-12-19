package com.prog32758;
import java.util.ArrayList;


/* 
 * singleton object to handle all question objects 
 */
public class QuestionFactory {
	private ArrayList<Question> questions = new ArrayList<Question>();
	
	private static QuestionFactory instance = null;
	
	private QuestionFactory() {
		loadQuestions();
	}
	
	public static synchronized QuestionFactory getInstance() {
		if (instance == null) 
			instance = new QuestionFactory();
		return instance;
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public ArrayList<Question> getSportsCategory() {
		ArrayList<Question> sportsQuestions = new ArrayList<Question>();
		for(int i = 0; i < 5; i++) {
			sportsQuestions.add(questions.get(i));
		}
		return sportsQuestions;
	}
	
	public ArrayList<Question> getVideoGamesCategory() {
		ArrayList<Question> videoGamesQuestions = new ArrayList<Question>();
		for(int i = 5; i < 10; i++) {
			videoGamesQuestions.add(questions.get(i));
		}
		return videoGamesQuestions;
	}
	
	public ArrayList<Question> getDogsCategory() {
		ArrayList<Question> dogQuestions = new ArrayList<Question>();
		for(int i = 15; i < 20; i++) {
			dogQuestions.add(questions.get(i));
		}
		return dogQuestions;
	}
	
	public ArrayList<Question> getMoviesCategory() {
		ArrayList<Question> movieQuestions = new ArrayList<Question>();
		for(int i = 10; i < 15; i++) {
			movieQuestions.add(questions.get(i));
		}
		return movieQuestions;
	}
	
	public ArrayList<Question> getBeersCategory() {
		ArrayList<Question> beerQuestions = new ArrayList<Question>();
		for(int i = 20; i < 25; i++) {
			beerQuestions.add(questions.get(i));
		}
		return beerQuestions;
	}
	
	private void loadQuestions() {
		// category 'Sports' questions
		questions.add(new Question(
				"Sports", 
				200, 
				"This team won the 2018 Super Bowl", 
				"Philadelphia Eagles", 
				"New England Patriots", 
				"Cleveland Browns", 
				"Dallas Cowboys", 
				"Philadelphia Eagles"));
		questions.add(new Question(
				"Sports", 
				400, 
				"This team won the 2018 Stanley Cup", 
				"Toronto Maple Leafs", 
				"Washington Capitals", 
				"Vancouver Canucks",
				"Las Vegas Golden Knights", 
				"Washington Capitals"));
		questions.add(new Question(
				"Sports", 
				600, 
				"This team won the 2018 NBA finals", 
				"Cleveland Cavaliers", 
				"Toronto Raptors", 
				"Golden State Warriors", 
				"Boston Celtics", 
				"Golden State Warriors"));
		questions.add(new Question(
				"Sports", 
				800, 
				"This team won the 2018 World Cup", 
				"France", 
				"Germany", 
				"Brazil", 
				"England", 
				"France"));
		questions.add(new Question(
				"Sports",
				1000, 
				"He won the KSI vs Logan boxing match in 2018", 
				"KSI", 
				"Dude Perfect", 
				"Logan Paul", 
				"Mr.Beast", 
				"KSI"));
		
		// category 'Video Games' questions
		questions.add(new Question(
				"Video Games", 
				200, 
				"This game is the first game ever made", 
				"Pong", 
				"Nim", 
				"OXO",
				"Mouse in the Maze",
				"Nim"));
		questions.add(new Question(
				"Video Games", 
				400, 
				"The first video game console", 
				"Magnavox Odyssey", 
				"Atari 2600", 
				"Ping-O-Tronic",
				"TV Master Series",
				"Magnavox Odyssey"));
		questions.add(new Question(
				"Video Games", 
				600, 
				"The first known video game with a competition", 
				"Periscope", 
				"Space Invaders", 
				"Spacewar",
				"Quake",
				"Spacewar"));
		questions.add(new Question(
				"Video Games", 
				800, 
				"This video game is the first sports video game", 
				"Tennis For Two", 
				"Crown Soccer Special", 
				"Speedway",
				"Grand Prix",
				"Tennis For Two"));
		questions.add(new Question(
				"Video Games", 
				1000, 
				"This video game franchise has the highest grossing of all time", 
				"Sonic the Hedgehog", 
				"Grand Theft Auto", 
				"Pokemon", 
				"Mario", 
				"Mario"));
		
		// category 'Movies' questions
		questions.add(new Question(
				"Movies", 
				200, 
				"The actor who played Terminator T-800", 
				"Sylvester Stallone", 
				"Arnold Schwarzenegger", 
				"Matt Damon",
				"Will Smith",
				"Arnold Schwarzenegger"));
		questions.add(new Question(
				"Movies", 
				400, 
				"This fictional city is the home of Batman", 
				"Mega City", 
				"Emerald City", 
				"Zion",
				"Arkham",
				"Arkham"));
		questions.add(new Question(
				"Movies", 
				600, 
				"This year is first year the Oscar's Academy Awards was held", 
				"1921", 
				"1940", 
				"1929",
				"1942",
				"1929"));
		questions.add(new Question(
				"Movies", 
				800, 
				"This is the first movie ever made", 
				"Roundhay Garden Scene", 
				"Arrival of a Train", 
				"A Trip to the Moon",
				"The Kiss",
				"Roundhay Garden Scene"));
		questions.add(new Question(
				"Movies", 
				1000, 
				"The highest grossing movie of all time", 
				"Avatar", 
				"Star Wars: The Force Awakens", 
				"Titanic", 
				"Avengers: Infinity War", 
				"Avatar"));
		
		// category 'Dogs' questions
		questions.add(new Question(
				"Dogs", 
				200, 
				"This breed is the most family oriented", 
				"Labrador Retreiver", 
				"Golden Retreiver", 
				"Poodle",
				"Irish Setter",
				"Golden Retreiver"));
		questions.add(new Question(
				"Dogs", 
				400, 
				"The odds of a man with a dog getting a girls number is multiplied", 
				"3 times", 
				"2 times", 
				"10 times",
				"7 times",
				"3 times"));
		questions.add(new Question(
				"Dogs", 
				600, 
				"Corgi is welsh for this description", 
				"Puffy dog", 
				"Dwarf dog", 
				"Minature dog",
				"Goofy dog",
				"Dwarf dog"));
		questions.add(new Question(
				"Dogs", 
				800, 
				"This dog breed is the most expensive in the world", 
				"English Bulldog", 
				"Samoyed", 
				"Canadian Eskimo",
				"Lowchen",
				"Lowchen"));
		questions.add(new Question(
				"Dogs", 
				1000, 
				"This dog is the most dangerous in the world", 
				"Rottweiler", 
				"Pitbull", 
				"German Shepherd", 
				"Chihuahua", 
				"Pitbull"));
		
		// category 'Beers' questions
		questions.add(new Question(
				"Beers", 
				200, 
				"This country has the most individual beer brands", 
				"Belgium", 
				"Germany", 
				"Ireland",
				"Russia",
				"Belgium"));
		questions.add(new Question(
				"Beers", 
				400, 
				"This word refers to the fear of an empty beer glass", 
				"Cenosillicphobia", 
				"Agoraphobia", 
				"Triskaidekaphobia",
				"Bufonophobia",
				"Cenosillicphobia"));
		questions.add(new Question(
				"Beers", 
				600, 
				"This country drinks the most beer per capita", 
				"Ireland", 
				"Austria", 
				"Czech Republic",
				"Germany",
				"Czech Republic"));
		questions.add(new Question(
				"Beers", 
				800, 
				"This beer was the first beer to win a blue ribbon at the Chicago World's Fair", 
				"Coors", 
				"Pabst Blue Ribbon", 
				"Samuel Adams",
				"Budweiser",
				"Pabst Blue Ribbon"));
		questions.add(new Question(
				"Beers", 
				1000, 
				"This beer is the most expensive beer in the world", 
				"Brew-Dog the End of History", 
				"Cantillon Loerik 1998", 
				"Nail Brewing's Antarctic Nail Ale", 
				"Allsop's Arctic Ale", 
				"Allsop's Arctic Ale"));
	}
	
}
