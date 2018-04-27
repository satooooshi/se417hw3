package hello;

import java.util.LinkedList;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;


public class WordLadder {

    //
    //Create an empty queue of stacks.
    Queue<Stack<String>> children = new ArrayDeque<Stack<String>>();

    String start;
    String end;
    Set<String>dict;
    Stack<String>foundLadder;

    public WordLadder(String start, String end, Set<String>dict){
        this.start=start;
        this.end=end;
        this.dict=dict;


        Stack<String> child=new Stack<String>();

        //
        //Create/add a stack containing {w1} to the queue
        child.push(this.start);
        children.add(child);

        //
        //While the queue is not empty:
        while(!children.isEmpty()){

            //
            //Dequeue the partial-ladder stack from the front
            //of the queue.
            Stack<String>temp_child=children.poll();
            String topWord=temp_child.peek();
            //
            //For each valid English word
            char[] arr = topWord.toCharArray();
            for(int i=0; i<arr.length; i++){
                char temp=arr[i];//if apAle, temp=arr[2], temp='p'
                for(char c='a'; c<='z'; c++){
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
                    String newWord = new String(arr);

                    //"valid" English word
                    if(!this.dict.contains(newWord))
                        continue;
                    //
                    //If that neighbor word has not already been
                    //used in a ladder before:
                    if(!temp_child.contains(newWord)) {

                        //
                        //delete generatedWord
                        dict.remove(newWord);


                        //
                        //If the neighbor word is w2:
                        if (newWord.equals(this.end)){
                             temp_child.push(newWord);
                             //while (!temp_child.isEmpty())
                             //{
                             //    System.out.println("/"+temp_child.pop());

                             //}
                              foundLadder=(Stack<String>)temp_child.clone();
                             return;//FOUND!!
                        //
                        //Create a copy of the current partial-
                        //ladder stack.
                        }else{
                             Stack<String> copy_child = (Stack<String>)temp_child.clone();
                             //
                             //Put the neighbor word on top of the copied stack
                             copy_child.push(newWord);
                             //
                             //Add the copy stack to the end of the queue
                             children.add(copy_child);
                        }
                    }
                }
            arr[i]=temp;
            }
        }
    }

    public ArrayList<String>getFoundLadder(){
        ArrayList<String> ladder = new ArrayList<String>();
        if(!(foundLadder==null)) {
            while (!foundLadder.empty()) {
                ladder.add(foundLadder.pop());
            }
            return ladder;
        }else{
            return null;
        }
    }

}
