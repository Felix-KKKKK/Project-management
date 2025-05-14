
package yiprojectmanagement;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
public class YiProjectManagement {
    //add two arrays to store the definition and their name
    static String[] term = new String[10];
    static String[] def = new String[10];
    static String studyMaterial = "";

    public static void readFile(){
        //read the file
        try{
            //create the file and scanner for reading the file
            File f = new File("src/yiprojectmanagement/notes.txt");
            Scanner s = new Scanner(f);

            //add a counter to keep up the index in the arrays
            int counter = 0;
            
            //run until the text has no more information to store
            while(s.hasNextLine()){
                //get the next line
                String defTerm = s.nextLine();

                //add it to the studying material
                studyMaterial += defTerm + "\n";

                //get the terms and definitions, store them in two arrays
                String[] defTermArray = defTerm.split(": ");

                //store the first item in the term array, the second one in the def array for designing the quiz
                term[counter] = defTermArray[0];
                def[counter] = defTermArray[1];
            }
        }catch(FileNotFoundException e){
            System.out.println("Error: " + e);
        }    
    }
    
    public static void main(String[] args) {
        //first read the file from the text
        readFile();

        //set the boolean variable to detect when to quit
        boolean end = false;

        //run until the user enters quit
        while(end == false){
            //show the welcome page
        JOptionPane.showMessageDialog(null, "Welcome to the study program for SDLC!");

        //show the choices for the user to choose
        int ans = Integer.parseInt(JOptionPane.showInputDialog("Please enter the choice that help you review SDLC: \n" 
                                                               + "1. Read the studying material\n" 
                                                               + "2. Do the quiz for self-evaluation\n"
                                                               + "3. Quit");

            
        }    
            
        //do the action that the user asks us to do
        if(ans == 3){
            //if the user asks to quit, end the while loop
            end = true;
        }
        else if(ans == 1){
            //show the studying material
            JOptionPane.showMessageDialog(null, studyMaterial);
        }
        else if(ans == 2){
            //do the quiz for them
        }else if(ans == 2){
            //do the quiz for them
        }else (ans == 2){
            //do the quiz for them
        }
    }
    
}
