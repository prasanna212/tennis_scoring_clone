
public class Match {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String scoringList = "AAAAAAAA";
		ScoreBoard sb = new ScoreBoard();
		sb.updateScoreBoard(scoringList);
	}

}

class Score {
	private int set;
	private int game;
	private int points;
	private boolean advantage;
	private boolean match;
	
	public Score(){
		this.set = 0;
		this.game = 0;
		this.points = 0;
		this.advantage = false;
		this.match = false;
	}
	
	public boolean isMatch() {
		return match;
	}
	public void setMatch(boolean match) {
		this.match = match;
	}
	public int getSet() {
		return set;
	}
	public void setSet(int set) {
		this.set = set;
	}
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String toString(){
		return set+","+game+","+points;
	}
	public boolean isAdvantage() {
		return advantage;
	}
	public void setAdvantage(boolean advantage) {
		this.advantage = advantage;
	}
}

class ScoreBoard{
	Score playerA;
	Score playerB;
	
	public ScoreBoard(){
		this.playerA = new Score();
		this.playerB = new Score();
	}
	
	public void updateScoreBoard(String scoringList)
	{
		for(int i=0;i<scoringList.length();i++)
		{
			if(scoringList.charAt(i) == 'A')
			{
				changeScore(playerA,playerB);
			}
			else
			{
				changeScore(playerB,playerA);
			}
			display(playerA, playerB);
		}
	}

	private void display(Score playerA, Score playerB) {
		// TODO Auto-generated method stub
		
		System.out.println("Sets: "+playerA.getSet()+" - "+playerB.getSet());
		System.out.println("Games: "+playerA.getGame()+" - "+playerB.getGame());
		System.out.println("Points: "+playerA.getPoints()+" - "+playerB.getPoints());
		
		if((playerA.getPoints() == 4)&&(playerB.getPoints() == 4))
			System.out.println("Advantage: "+playerA.isAdvantage()+" - "+playerB.isAdvantage());
		if(playerA.isMatch())
			System.out.println("Player A won");
		else if(playerB.isMatch())
			System.out.println("Player B won");
		System.out.println("------------");
	}

	private void changeScore(Score first, Score second) {
		// TODO Auto-generated method stub
		if(first.getPoints() < 4 )
			first.setPoints(first.getPoints()+1);
		if(first.getPoints() == 4)
		{
			if(first.isAdvantage())
			{
				incrementGame(first,second);
			}
			else if(second.isAdvantage())
			{
				second.setAdvantage(false);
			}
			else
			{
				first.setAdvantage(true);
			}
		}
	}

	private void incrementGame(Score first, Score second) {
		// TODO Auto-generated method stub
		first.setPoints(0);
		first.setAdvantage(false);
		second.setPoints(0);
		second.setAdvantage(false);
		
		first.setGame(first.getGame()+1);
		
		if((first.getGame()>5)&&(first.getGame()-second.getGame() >= 2))
			incrementSet(first,second);
	}

	private void incrementSet(Score first, Score second) {
		// TODO Auto-generated method stub
		first.setGame(0);
		second.setGame(0);
		
		first.setSet(first.getSet()+1);
		
		if(first.getSet() == 2)
		{
			first.setMatch(true);
		}
	}
	
	
}
