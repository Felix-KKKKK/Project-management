public class Question{
private String question;
private String answer;
public Question(){
 question = "";
  answer = "";
}
public Patron(String question, String answer){
  
}

public boolean isCorrect(String answer){
  if (this.answer.equals(answer)){
    return true;
  } else{
    return false;
  }
}
public String getAnswer(){
 return answer;
}

public void setAnswer(String answer){
this.answer = answer;
}

public String getQuestion(){
 return question;
}

public void setQuestion(){
 this.question = question;
}

public String toString(){
  
  return str;
}
}
