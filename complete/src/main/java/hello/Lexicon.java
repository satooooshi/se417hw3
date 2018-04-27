package hello;

        import org.springframework.stereotype.Component;

        import java.io.*;
        import java.net.URL;
        import java.util.*;
        import java.lang.String;


public class Lexicon {

    private Set<String> dict = new HashSet<String>();

    public Lexicon(String filename){
        try{

            /*
           File file = new File(filename);
            //File file = new File("./dictionary.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();
            */

            //For file in http
            URL url = new URL(filename);
            InputStream strm = url.openStream();
            InputStreamReader in = new InputStreamReader(strm);
            BufferedReader br = new BufferedReader(in);
            String str=br.readLine();

            dict.add(str);
            while(str != null){
                //System.out.println(str);
                str = br.readLine();
                dict.add(str);
            }

            br.close();
            strm.close();
            in.close();
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