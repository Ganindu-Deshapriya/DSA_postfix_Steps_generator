/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsapostfixsteps;
import java.util.*;


/**
 *
 * @author ganin
 */
public class DSAPostfixSteps {
    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter the postfix expression :\n");
        String expression = scanner.nextLine();
//        String expression = "ABC*+DE-/";
        printInstructions(expression);
        // TODO code application logic here
    }
    
    public static boolean isAnOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    public static void printInstructions(String expression){
        int tempcounter = 1;
        Stack<String> stack = new Stack<>();
        
        for (char c : expression.toCharArray() ){
            String ch = String.valueOf(c);
            
            if (isAnOperator(c)){
                if (stack.size() < 2) {
                System.out.println("Invalid postfix expression");
                return; // Exit the method if there are not enough operands for the operator
            }
                stepsIfAnOperator(c, stack.pop(), stack.pop(), "TEMP"+tempcounter);
                stack.push("TEMP"+tempcounter);
                tempcounter++;
            }else{
                stack.push(ch);
            }
        }
    }
    
    public static void stepsIfAnOperator(char op, String operand1, String operand2, String temp){
        switch (op) {
            case '+':
                System.out.println("LD "+ operand2);
                System.out.println("AD "+ operand1);
                System.out.println("ST "+ temp);
                break;
            case '-':
                System.out.println("LD "+ operand2);
                System.out.println("SB "+ operand1);
                System.out.println("ST "+ temp);
                break;
            case '*':
                System.out.println("LD "+ operand2);
                System.out.println("ML "+ operand1);
                System.out.println("ST "+ temp);
                break;
            case '/':
                System.out.println("LD "+ operand2);
                System.out.println("DV "+ operand1);
                System.out.println("ST "+ temp);
                break;
            default:
                throw new AssertionError();
        }
    }
    
}
