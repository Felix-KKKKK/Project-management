/**
 * Question class that asks or stores questions towards the user and gives answers
 */
public class Question {

    private String question;
    private String answer;
    /**
     * Basic constructor
     */
    public Question() {
        question = "";
        answer = "";
    }
    /**
     * Constructor to set the variables values
     * @param question the question that is going to be asked
     * @param answer the answer to that question
     */
    public Question(String question, String answer) {
        this();
        this.question = question;
        this.answer = answer;
    }
    /**
     * Method to check if the answer is correct and return true or false if its wrong
     * @param answer the answer that the user gives to the program
     * @return if the users answer is the same as the provided answer
     */
    public boolean isCorrect(String answer) {
        return this.answer.equals(answer);
    }
    /**
     * Accessor for the answer attribute
     * @return the answer to the question
     */
    public String getAnswer() {
        return answer;
    }
    /**
     * Mutator for the answer attribute
     * @param answer Sets the answer to another answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    /**
     * Accessor for the question attribute
     * @return gets the question from the program
     */
    public String getQuestion() {
        return question;
    }
    /**
     * Mutator for the question attribute
     * @param question sets the question to a new question
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    /**
     * Standard toString method 
     * @return the string that contains all the information
     */
    public String toString() {

        return "Question: What is a " + question + "\nAnswer: " + answer;
    }
}
