package com.ebookstore.restservice.wordladder;

        import org.springframework.stereotype.Component;

        import java.io.File;
        import java.io.FileReader;
        import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.util.*;
        import java.lang.String;


public class Lexicon {

    private Set<String> dict = new HashSet<String>();

    public Lexicon(String filename){
        try{
            File file = new File(filename);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str = br.readLine();
            dict.add(str);
            while(str != null){
                //System.out.println(str);
                str = br.readLine();
                dict.add(str);
            }

            br.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());

        }
    }

    public void addNewWord(String word){
        dict.add(word);
    }

    public Set<String>getDictionary(){
        return dict;
    }

}