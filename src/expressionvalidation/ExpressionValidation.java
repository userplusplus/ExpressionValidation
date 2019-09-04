/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expressionvalidation;

import java.util.Scanner;
import java.util.Stack;


public class ExpressionValidation {

    
    public static void main(String[] args) {
        System.out.println("Welcome to the expression validating program.");
        Scanner sc = new Scanner(System.in);
        //Set up a scanner
        
        System.out.println("\nEnter your expression:");
        String expression = sc.nextLine();
        //Get the expression through user input
        
        System.out.println("\nEnter the opening character to validate:");
        char openingChar = sc.nextLine().charAt(0);
        //Pull the char out of the user input
        
        System.out.println("\nEnter the closing character to validate:");
        char closingChar = sc.nextLine().charAt(0);
        //Pull the char out of the user input
        
        Stack charStack = new Stack();
        
        for (int i = 0; i < expression.length(); i++) {
            
            if(expression.charAt(i) == openingChar){
                //If there is a match, add an entry to the stack
                charStack.push(expression.charAt(i));
                
            } else if(expression.charAt(i) == closingChar){
                
                if(!charStack.isEmpty()){
                    charStack.pop();
                    
                } else {
                    //Stack is empty and there is a closing char
                    System.out.println("\nExpression invalid. Error:"
                            + " Closing char");
                    return;
                }
                
            }  
        }
        
        if(!charStack.isEmpty()){
            //If the stack is not empty and all of the string has been checked
            // - means there are too many opening chars
            System.out.println("\nExpression invalid. Error: Opening char");
            
        } else {
            System.out.println("\nThe expression is validated.");
        }
    }
    
}
