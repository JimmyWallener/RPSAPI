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
	
	public static int playerVsPlayer(String pOne, String pTwo) throws IOException {
		String playerTwo = pTwo.toLowerCase().strip();
		String playerOne = pOne.toLowerCase().strip();
		int result;
		
		result = playerOne.equals(playerTwo) ? ScoreBean.ties++ : 
			 playerOne.equals("rock") && playerTwo.equals("scissor") ? ScoreBean.wins++ :
			 playerOne.equals("paper") && playerTwo.equals("rock") ? ScoreBean.wins++ : 
			 playerOne.equals("scissor") && playerTwo.equals("paper") ? ScoreBean.wins++ : ScoreBean.loss++;
		return result;
		
	}

}
