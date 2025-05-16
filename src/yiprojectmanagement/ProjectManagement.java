/*
 * Felix Yi, Wilson Xie, Emma Tsai
 * May 15th
 * The purpose of this program is to help students prepare for the SDLC test by 
 * providing both quizzes and study materials. By delivering the information in 
 * these two forms, the system ensures self-evaluation and effective learning.
 * The program will start by reading two external files: study materials and 
 * quizzes. It will display all the notes in an user-friendly format. 
 * After that, the user is required to answer a ten-question quiz. 
 * After the user submits its answer, the system will automatically grade the 
 * quiz and give feedback. The user can redo the quiz or exit the program after 
 * that.
 */
package yiprojectmanagement;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
public class YiProjectManagement {
    //add two arrays to store the study material
    static String studyMaterial = "";
    
    public static void readFile(Question[] questionList){
        //read the file
        //create the file and scanner for reading the file
        InputStream f = YiProjectManagement.class.getResourceAsStream("notes.txt");
        Scanner s = new Scanner(f);

        //add a counter to keep up the index in the arrays
        int counter = 0;

        //run until the text has no more information to store
        while(s.hasNextLine()){
            //get the next line
            String defTerm = s.nextLine();

            //get the terms and definitions, store them in two arrays
            String[] defTermArray = defTerm.split(": ");

            //store the first item in the term array, the second one in the def array for designing the quiz
            String term = defTermArray[0];
            String def = "Which of the following is corresponding to: " + defTermArray[1];

            //add it to the studying material
            studyMaterial += term + ": \n" + defTermArray[1] + "\n\n";

            //create the question
            Question question = new Question(def, term);

            //add the question to the question list
            questionList[counter] = question;

            //add one to the counter
            counter ++;

        }
    }
    
    public static void quiz(Question[] questionList){
        //initialize the score to be 0
        int score = 0;
        
        //create an arrayList to store the wrong concept to remind the user
        ArrayList<String> wrongConcept = new ArrayList<>();
        
        //run the ten questions
        for(int i = 0; i < 10; i++){
            //get the question in the question list
            Question question = questionList[i];
            
            //set the three wrong answer by randomly getting terms in the questionList
            int wrongAns1Index = (int)(Math.random() * 10);
            int wrongAns2Index = (int)(Math.random() * 10);
            int wrongAns3Index = (int)(Math.random() * 10);
            
            //check if they are the same or not
            while(wrongAns1Index == i || wrongAns2Index == i || wrongAns3Index == i || wrongAns1Index == wrongAns2Index || wrongAns1Index == wrongAns3Index || wrongAns3Index == wrongAns2Index){
                wrongAns1Index = (int)(Math.random() * 10);
                wrongAns2Index = (int)(Math.random() * 10);
                wrongAns3Index = (int)(Math.random() * 10);
            }
            
            //get the string for these wrong answers
            String wrongAns1 = questionList[wrongAns1Index].getAnswer();
            String wrongAns2 = questionList[wrongAns2Index].getAnswer();
            String wrongAns3 = questionList[wrongAns3Index].getAnswer();
            
            //get the random ABCD for the correct answer and the wrong one
            //add the four answers to an arrayList
            ArrayList<String> choiceList = new ArrayList<>();
            choiceList.add(wrongAns1);
            choiceList.add(question.getAnswer());
            choiceList.add(wrongAns2);
            choiceList.add(wrongAns3);
            
            //shuffle them
            Collections.shuffle(choiceList);
            
            //set the ans for ABCD
            String ansProblem = "";
            
            //get where is the correct answer in the list by comparing all the answers
            for(int x = 0; x < 4; x++){
                if(choiceList.get(x).equals(question.getAnswer())){
                    if(x == 0){
                        ansProblem = "A";
                    }
                    if(x == 1){
                        ansProblem = "B";
                    }
                    if(x == 2){
                        ansProblem = "C";
                    }
                    if(x == 3){
                        ansProblem = "D";
                    }
                }
            }
            
            
            //add the ABCD in front of the answers
            choiceList.set(0, "A. " + choiceList.get(0));
            choiceList.set(1, "B. " + choiceList.get(1));
            choiceList.set(2, "C. " + choiceList.get(2));
            choiceList.set(3, "D. " + choiceList.get(3));
            
            
            //show this to the user
            String userAns = JOptionPane.showInputDialog((i + 1) + ". " +question.getQuestion() + "\n" 
                    + choiceList.get(0) + "\n" 
                    + choiceList.get(1) + "\n" 
                    + choiceList.get(2) + "\n" 
                    + choiceList.get(3));
            
            //if the user gets it correct, add one to the score
            if(userAns == null){
                i--;
            }
            else if(userAns.equalsIgnoreCase(ansProblem)){
                score += 1;
                JOptionPane.showMessageDialog(null, "You are correct! Keep working!");
            }
            //if the user gets it incorrect, 
            else if(userAns.equalsIgnoreCase("A") || userAns.equalsIgnoreCase("B") || userAns.equalsIgnoreCase("C") || userAns.equalsIgnoreCase("D")){
                wrongConcept.add(question.getAnswer());
                JOptionPane.showMessageDialog(null, "You are wrong! The correct answer is " + ansProblem + ". " + question.getAnswer());
            }
            //if the user input is invalid, minus one to the i so that it doesn't skip the question
            else{
                JOptionPane.showMessageDialog(null, "Invalid input!");
                i--;
            }
        }
        
        //get the feedback
        String output = "Your final score is " + score + " score\n";
        if(score >= 8){
            output += "Very nice work! It seems that you have already get the knowledge required for the SDLC test! :)";
        }
        else if (score >= 5){
            output += "Great work overall! Keep trying this quiz until you get above 8! :)";
        }
        else{
            output += "Please check the studying materials before you do this quiz :(";
        }
        JOptionPane.showMessageDialog(null, output);
        
        //show their error concepts
        if(!wrongConcept.isEmpty()){
            String wrongConceptText = "Topics to be improved: \n";
            for(String topic : wrongConcept){
                wrongConceptText += topic + "\n";
            }
            
            //show the result
            JOptionPane.showMessageDialog(null, wrongConceptText);
        }
    }
    public static void main(String[] args) {
        //create the question list to store all the question in it
        Question[] questionList = new Question[10];
        
        //first read the file from the text
        readFile(questionList);
        
        //show the welcome page
        JOptionPane.showMessageDialog(null, "Welcome to the study program for SDLC!");
        //set the boolean variable to detect when to quit
        boolean end = false;

        //run until the user enters quit
        while(end == false){

            //show the choices for the user to choose
            String ans = JOptionPane.showInputDialog("Please enter the choice that help you review SDLC: \n" 
                                                               + "1. Read the studying material\n" 
                                                               + "2. Do the quiz for self-evaluation\n"
                                                               + "3. Quit");
            
            //do the action that the user asks us to do
            if(ans == null){
                end = true;
            }
            else if(ans.equals("3")){
                //if the user asks to quit, end the while loop
                end = true;
            }
            else if(ans.equals("1")){
                //show the studying material
                JOptionPane.showMessageDialog(null, studyMaterial);
            }
            else if(ans.equals("2")){
                quiz(questionList);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
            
        }    
            
        
    }
    
}
