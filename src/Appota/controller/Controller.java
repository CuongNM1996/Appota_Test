package Appota.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;





public class Controller {
    //this function calulation sum of all digit in a number
    public int sumOfDigit(int num) {
        int sum = 0;
        int temp = 0;
        while (num > 0) {
            temp = num % 10;
            sum = sum + temp;
            num = num / 10;
        }
        return sum;
    }    
    
    //Openfile with a filename user input
    public String openFile(String fileName) throws IOException {
        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String data = "";
        while ((line = br.readLine()) != null){
            data+=line+"\n";
        }
        fr.close();
        br.close();
        return data;
    }
    //this function return a string contain tittle 
    public String getTittle(String data) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(data));
        String result = "";
        String line;
        while ((line = reader.readLine()) != null){
            if(isAllUpper(line))
                result += line+"\n";
        }
        return result;
    }
    
    //this function get all content of a poem
    public String getContent(String tittle) throws IOException {
        String result = "";
        String data = openFile("book1.txt");
        HashMap hm = new HashMap<>(); //create hashmap: HashMap<tittle, content>
        String value = "";
        String temp = "";
        BufferedReader reader = new BufferedReader(new StringReader(data));
        String line;
        while ((line = reader.readLine()) != null){
            if(isAllUpper(line)) {
                    temp = line;
                    hm.put(temp, value);//put a value of a poem
                    value = "";
                }else {
                    value += line+"\n"; //put all line to the poem content
                    hm.put(temp, value);
            }
        }
        result = (String) hm.get(tittle);
        return result;
    }
    
    //this functin get all text with uppercase character
    public boolean isAllUpper(String line) {
        //return false if that string is empty
        if(line.trim().isEmpty()) {
            return false;
        }
        //return false if a character in string is lowercase, digit or *
        for(char c : line.toCharArray()) {
            if(Character.isLowerCase(c) || c == '*' || Character.isDigit(c)) 
                return false;
        }
        return true;
    } 
    
    
}
