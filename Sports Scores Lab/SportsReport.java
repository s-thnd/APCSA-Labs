
public class SportsReport
{
	/** Names of the winning and losing teams */
	private String winner;
	private String loser;

	/** the winning and losing scores */
	private int winningScore;
	private int losingScore;

	/** Constructs a SportsReport using the information in score
	 *  @param score contains winner, loser, and scores in the format:
	 *  <winner> beat <loser> by a score of <winning score> to <losing score>
	 */
	public SportsReport(String score)
	{
		extractInformation(score);
	}

	/** Changes the sports scoring information
	 *  @param score contains winner, loser, and scores in the format:
	 *  <winner> beat <loser> by a score of <winning score> to <losing score>
	 */
	public void changeScoringInfo(String score)
	{
		extractInformation(score);
	}
	
	/**
	 * Returns the winning team name
	 * @return <winner> - the name of the winning team
	 */
	public String getWinner()
	{
		return winner;
	}

	/**
	 * Returns the losing team name
	 * @return <loser> - the name of the losing team
	 */
	public String getLoser()
	{
		return loser;
	}

	/**
	 * Returns the winning score
	 * @return <winningScore> - the score of the winning team
	 */
	public int getWinningScore()
	{
		return winningScore;
	}

	/**
	 * Returns the losing score
	 * @return <losingScore> - the score of the losing team
	 */
	public int getLosingScore()
	{
		return losingScore;
	}

	// write getScoreDifference method HERE!!
	/**
	 * Returns the difference between the winning and losing scores
	 * @return <difference> - the difference between the winning and losing score
	 */
	public int getScoreDifference() {
		int difference = winningScore-losingScore;
		return difference;
	}

	@Override
	/**
	 * Returns the formatted scores
	 * @return <formatted> - the team names left justified to 25 columns and the 
	 * scores right justified to 4 columns
	 */
	public String toString()
	{
		String formatted = String.format("%-25s %4d, %-25s %4d", winner, winningScore, loser, losingScore);
		return formatted;
	}

	// write PRIVATE extractInformation method HERE!!
	/**
	 * Extracts the information from the provided string
	 * @param score - the provided string containing the score information as a full sentence
	 */
	private void extractInformation(String score) {
		final String beat = " beat ";
		final String byScore = " by a score of ";
		final String to = " to ";
		
		winner = score.substring(0, score.indexOf(beat));
		loser = score.substring(score.indexOf(beat) + beat.length(), score.indexOf(byScore));
		winningScore = Integer.parseInt(score.substring(score.indexOf(byScore) + byScore.length(), score.indexOf(to)));
		losingScore = Integer.parseInt(score.substring(score.indexOf(to) + to.length(), score.length()));
	}
}
