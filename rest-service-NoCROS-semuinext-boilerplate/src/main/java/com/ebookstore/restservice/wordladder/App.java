package com.ebookstore.restservice.wordladder;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;

public class App {
    public static void main( String[] args ) {

        String dictName;
        String start;
        String end;
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("Dictionary file name? ");
        dictName = reader.nextLine();
        try {
            File file = new File(dictName);
            FileReader fileReader = new FileReader(dictName);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return ;
        }

        while(true) {
            try{
            System.out.println("Word #1 (or Enter to quit): ");
            start = reader.nextLine();
            System.out.println("Word #2 (or Enter to quit): ");
            end = reader.nextLine();


            ProcessUserInput processuserinput = new ProcessUserInput(start, end, dictName);
            Lexicon lexicon = new Lexicon(processuserinput.showDictName());
            lexicon.addNewWord(processuserinput.showStartName());
            lexicon.addNewWord(processuserinput.showEndName());
            WordLadder wordladder = new WordLadder(processuserinput.showStartName(),
                    processuserinput.showEndName(),
                    lexicon.getDictionary());
            ArrayList<String> ladder = wordladder.getFoundLadder();
            //for(String word : ladder)
            //System.out.println(word);
            System.out.println(ladder);

            }catch(EnterInputted e){
               //System.out.println(e);
                System.out.println(e.getMessage());
               return ;
            }catch(Exception e){
                //e.printStackTrace();
                System.out.println(e.getMessage());
                continue;

            }

        }

    }
}
