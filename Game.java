import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private String hidden;
    private String guess;
    private String hint;
    public ArrayList <String> word = new ArrayList<>();
    public ArrayList <String> output = new ArrayList<>();
    Scanner kb = new Scanner(System.in);
    String hiddenWord = "aiden";
    //how to make a list
    //ArrayList <String> listName = new ArrayList<>();
    //listName.add(thing)
    public static void main(String[] args){
        boolean playerWonGame = false;
        Game game = new Game();
        game.setOriginalWord();
        while(playerWonGame == false){
           playerWonGame = game.checkInput();

        }
        System.out.println("You won the game!!!");
    }
    public void setOriginalWord(){
        for(int r = 0; r < hiddenWord.length(); r++){
            word.add(hiddenWord.substring(r,r+1));
        }
        System.out.println(word);

    }
    //have it a return boolean to help the while loop end
    public boolean checkInput(){
        boolean wonGame = false;
        System.out.println("Enter a guess that is " + word.size() + " letters long");
        String guess = kb.nextLine();
        //Validates user input to make sure it is the same length
        while(guess.length() != word.size()) {
            System.out.println("Enter a guess that is " + word.size() + " letters long");
            guess = kb.nextLine();
        }

        //This appends either the correct letter to the output list, or a + or a * depending on the user guess.
        for(int r = 0; r < word.size(); r++){
            if(word.get(r).equals(guess.substring(r,r+1))){
                output.add(word.get(r));
            }else if(word.contains(guess.substring(r,r+1))){
                output.add("+");
            }else{
                output.add("*");
            }
        }
        if(hiddenWord.equals(guess)){
            wonGame = true;
        }

        //System.out.println(output);

        for(String temp: output) {
            System.out.print(temp);
        }
        System.out.println();
        output.clear();
        return wonGame;
    }
}

