package p5;

import java.io.File;
import java.util.Scanner;
/**
 * @author Drew Ditrich
 */
public class MorseCodeConverter {
    /**
     * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
     * @param code the morse code to be converted
     * @return a string with the converted String
     */
    public static String convertToEnglish(String code){
        MorseCodeTree MCT = new MorseCodeTree();
        String out = "";
        for(String i:code.split("/"))
        {
            out += " ";
            for(String j:i.split(" ")){
                if(j.length() != 0 && (j.charAt(0) == '.' || j.charAt(0) == '-'))
                out+= MCT.fetch(j);
            }
        }
        return out.substring(1);
    }
    /**
     * returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree It should return the data in this order:
"h s v i f u e l r a p w j b d x n c k y t z g q m o"
Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal, the root would come between the right most child of the left tree (j) and the left most child of the right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly

     * @return the data in the tree in LNR order separated by a space.
     */
    public static String printTree()
    {
        MorseCodeTree MCT = new MorseCodeTree();
        String out = "";
        for(String s:MCT.toArrayList())
        {
            out += " " + s;
        }
        return  out.substring(1);
    }
    /**
     * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
     * @param codefile name of the File that contains Morse Code
     * @return the English translation of the file
     * @throws java.io.FileNotFoundException
     */
    public static String convertToEnglish(File codefile) throws java.io.FileNotFoundException {
        MorseCodeTree MCT = new MorseCodeTree();
        Scanner scan = new Scanner(codefile);
        String out = "";
        while(scan.hasNext())
        for(String i:scan.nextLine().split("/"))
        {
            out += " ";
            for(String j:i.split(" ")){
                if(j.length() != 0 && (j.charAt(0) == '.' || j.charAt(0) == '-'))
                out+= MCT.fetch(j);
            }
        }
        scan.close();
        return out.substring(1);
    }
}
