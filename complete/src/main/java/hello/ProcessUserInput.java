package hello;

import java.lang.String;


class EndWordsLengthDoseNotMatchException extends RuntimeException {
    public EndWordsLengthDoseNotMatchException(String message) {
        super(message);
    }
}

class EnterInputted extends RuntimeException {
    public EnterInputted(String message) {
        super(message);
    }
}

public class ProcessUserInput {

    private String dictName;
    private String start;
    private String end;



    public ProcessUserInput(String start, String end, String dictName) {

            this.start=toLower(start);
            this.end=toLower(end);
            this.dictName=dictName;

            legitimateWord();

    }

    public String toLower(String word){
        if(!word.isEmpty())
            return word.toLowerCase();
        else
            return word;
    }

    public String showDictName(){
        return this.dictName;
    }
    public String showStartName(){
        return this.start;
    }
    public String showEndName(){
        return this.end;
    }


    public void legitimateWord(){


            if (this.start.isEmpty() || this.end.isEmpty()) {
                throw new  EnterInputted("Have a Nice day.");
            }

            if (this.start.length() != this.end.length()) {
                throw new  EndWordsLengthDoseNotMatchException("ERROR! Word with different length.");
            }

            if (this.start.equals(this.end)) {
                throw new  EndWordsLengthDoseNotMatchException("ERROR! Same end word.");
            }
            char[] temp = this.start.toCharArray();
            for (int i = 0; i < temp.length; ++i) {
                if (!(temp[i] >= 'a' && temp[i] <= 'z')) {
                    throw new  EndWordsLengthDoseNotMatchException("ERROR! Invalid character contained.");
                }
            }

    }



}