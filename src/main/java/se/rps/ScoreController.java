package se.rps;


import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
	
	private int wins;
	private int losses;
	private int ties;
	

// Score section
	/*
	 * @RequestMapping(value = "/score/wins", method = RequestMethod.GET) public int
	 * getWins() { return wins; }
	 * 
	 * 
	 * @RequestMapping(value = "/score/loss", method = RequestMethod.GET) public int
	 * getLoss() { return losses; }
	 * 
	 * 
	 * @RequestMapping(value = "/score/ties", method = RequestMethod.GET) public int
	 * getTie() { return ties; }
	 */
	 
	

	@RequestMapping(value = "/score/wins", method = RequestMethod.POST)
	public int increaseWins() {  
		ScoreBean.wins++;
		return wins;
	}
	
	@RequestMapping(value = "/score/loss", method = RequestMethod.POST)
	public int increaseLoss() {
		ScoreBean.loss++;
		return losses;
	}
	
	@RequestMapping(value = "/score/ties", method = RequestMethod.POST)
	public int increaseTies() {
		ScoreBean.ties++;
		return ties;
	
}
	@RequestMapping(value = "/ties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateTie() {
		String pattern = "{ \"ties\": \"%s\"}"; 
		String json = String.format(pattern,ScoreBean.ties );
		return json;
	}
	@RequestMapping(value = "/wins", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateWins() {
		String pattern = "{ \"wins\": \"%s\"}"; 
		String json = String.format(pattern, ScoreBean.wins );
		return json;
	}
	@RequestMapping(value = "/losses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateLoss() {
		String pattern = "{ \"losses\": \"%s\"}"; 
		String json = String.format(pattern, ScoreBean.loss );
		return json;
	}
	@RequestMapping(value = "/score", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getScoreBean(){ 
		String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}"; 
		String json = String.format(pattern, ScoreBean.wins,ScoreBean.loss,ScoreBean.ties );
		return json;
		
}	@RequestMapping(value = "/score", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateScore(int wins, int losses, int ties) {
		ScoreBean.wins = wins;
		ScoreBean.loss = losses;
		ScoreBean.ties = ties;
		String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}"; 
		String json = String.format(pattern, ScoreBean.wins,ScoreBean.loss,ScoreBean.ties );
		return json;
	}


// Game mechanics section

@RequestMapping(path = "/cpuGame", method = RequestMethod.POST)
public static void playerVsComputer(String player) throws IOException {
	
	Game.playerVsComputer(player);
	
}
@RequestMapping(path = "/pvpGame", method = RequestMethod.POST)
public static void playerVsPlayer(String playerOne, String playerTwo) throws IOException {
	
	Game.playerVsPlayer(playerOne, playerTwo);
	
}

}
