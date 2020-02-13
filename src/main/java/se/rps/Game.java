package se.rps;

import java.io.IOException;

public class Game {
	
	public static int playerVsComputer(String player) throws IOException {
		
		String playerOne = player.toLowerCase().strip();
		String computer = Computer.computer();
		int result;
		
		result = playerOne.equals(computer) ? ScoreBean.ties++ : 
				 playerOne.equals("rock") && computer.equals("scissor") ? ScoreBean.wins++ :
				 playerOne.equals("paper") && computer.equals("rock") ? ScoreBean.wins++ : 
				 playerOne.equals("scissor") && computer.equals("paper") ? ScoreBean.wins++ : ScoreBean.loss++;
		return result;
		}
	
	public static int playerVsPlayer(String playerOne, String PlayerTwo) throws IOException {
		
		int result;
		
		result = playerOne.equals(PlayerTwo) ? ScoreBean.ties++ : 
			 playerOne.equals("rock") && PlayerTwo.equals("scissor") ? ScoreBean.wins++ :
			 playerOne.equals("paper") && PlayerTwo.equals("rock") ? ScoreBean.wins++ : 
			 playerOne.equals("scissor") && PlayerTwo.equals("paper") ? ScoreBean.wins++ : ScoreBean.loss++;
		return result;
		
	}

}
