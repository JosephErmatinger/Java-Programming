package program9;
/*
 * Programmer .: Isaac Oxendale & Joe Ermatinger
 * Date . . . .: 2019-03-31
 * Program Name: Essay.java
 */

public class Essay extends GradedActivity {
	private double grammar, spelling, correctLength, content;

	// no-arg constructor
	public Essay() {
		content = 0;
		grammar = 0;
		spelling = 0;
		correctLength = 0;
	}

	// getters and setters for grammar
	public double getGrammar() {
		return grammar;
	}

	public void setGrammar(double grammar) {
		this.grammar = grammar;
	}

	// getters and setters for spelling
	public double getSpelling() {
		return spelling;
	}

	public void setSpelling(double spelling) {
		this.spelling = spelling;
	}

	// getters and setters for correct length
	public double getCorrectLength() {
		return correctLength;
	}

	public void setCorrectLength(double correctLength) {
		this.correctLength = correctLength;
	}

	// getters and setters for content
	public double getContent() {
		return content;
	}

	public void setContent(double content) {
		this.content = content;
	}

	// sets the score for the Graded Activity class
	public void setScore() {
		super.setScore(grammar + spelling + correctLength + content);
	}

	// returns a nicely formatted string
	@Override
	public String toString() {
		StringBuilder message = new StringBuilder();
		message.append("Grammar. . . .:\t");
		message.append(grammar);
		message.append("\nSpelling . . .:\t");
		message.append(spelling);
		message.append("\nCorrect Length:\t");
		message.append(correctLength);
		message.append("\nContent. . . .:\t");
		message.append(content);
		message.append("\nScore. . . . .:\t");
		message.append(super.getScore());
		message.append("\nGrade. . . . .:\t");
		message.append(super.getGrade());

		return message.toString();
	}

}