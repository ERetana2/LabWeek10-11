/*************************************************************************
 * In this file, you get to use the blueprints you have participated in
 * creating (BTNode, BTree). 
 * Namely, in this file, you are going to manipulate binary trees. 
 * Most of the code is given to you. 
 *      - The main method is given to you. 
 *      - A set of helper methods are also provided to you: you may or 
 *        may not elect to use them, it is fine. 
 * There is 1 TODO in this file: TODO 6.
 * Note: You can only add code in the TODOs. You are not allowed to modify 
 * anything else in the code. 
 *************************************************************************/ 

import jdk.dynalink.linker.LinkerServices;

import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Execute {

    /* TODO 6: 
     * Method readFamilyIntoTree: 
     * Takes a file name and reads this file with family information, 
     * creates and fills a linked-list-based tree with family member information.
     * Note: Father-line nodes go to the left and Mother-line nodes go to the right
     ****************************************************************************************/
    public static BTree<FamilyMember> readFamilyIntoTree(String filename) throws FileNotFoundException, IOException {
        
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        // Create an empty binary tree of Family Members
        BTree<FamilyMember> Tree = new BTree<>();

        FamilyMember newMember = new FamilyMember();
        String [] processedInfo;
        while (textReader.ready()){
            String lineRead = textReader.readLine();
            String [] member = lineRead.split(" "); // splits string into each individual family member

            //split each member's attributes --> create new family Members -- > insert to tree
            for(int i  = 0 ; i < member.length; i++){
                processedInfo = processLine(member[i]);
                newMember = new FamilyMember(processedInfo[0],processedInfo[1],Integer.parseInt(processedInfo[2]));
                Tree.insertDataAtLocation(processedInfo[3],newMember);
            }
        }
        textReader.close();
        // NOTE: Make sure that your tree has an updated size and height
        //Tree.resetHeight();
        //Tree.resetSize();
        // Return the resulting filled tree
        return Tree;

    }
            
    
    /****************************************************************************************   
     * Main Method: DO NOT MODIFY THE MAIN METHOD
     ****************************************************************************************/    
	public static void main(String[] args) throws FileNotFoundException, IOException {
        String filename = args[0];

        // Creates a linked-list-based tree directly from reading the file:
        BTree<FamilyMember> Tree = readFamilyIntoTree(filename);

        // Prints out the content of the linked-list-based tree:
        Tree.print();
        
        System.out.println("Tree size = " + Tree.getSize());
        System.out.println("Tree height = " + Tree.getHeight());
        System.out.println();
        System.out.println();
    }

    
    
    /************************************************************************************
     * HELPER METHODS: ******************************************************************
     ************************************************************************************/

    /* Method processLine:
     * This method is given a String that is one element of the line in the text file for be read.
     * The element is of the following form: <String>-<String>,<int>,<String>
     * Example of such an element: John-Doe,3,LLR
     * It processes this element and produces an array of 4 strings: 
     * [first name, last name, number of siblings, location in the array where it should be stored]
     * In the case of the above example, we would produce the following array: [John, Doe, 3, LLR]
     */
    public static String[] processLine(String element) {
        String[] result = new String[4];

        String[] member = element.split(",");
        String[] name = member[0].split("-");
        result[0] = name[0];
        result[1] = name[1];
        result[2] = member[1];
        result[3] = member[2];

        return result;
    }

    /* Method countLines: 
     * This method takes a file name as a parameter and 
     * returns the number of lines in this file (an int)
     */
    public static int countLines(String filename) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int counter = 0;
        // As long as there is something to read in the file...
        while (textReader.ready()) {
            // we increase our line counter
            counter++;
            // read the line and move to the next to check if there is something to read (the while condition)
            textReader.readLine();   
        }
        
        textReader.close();
        return counter;
    }


}