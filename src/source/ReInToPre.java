/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;


/**
 *
 * @author mahdi
 */
public class ReInToPre {
    
    private static final CustomStack stack = new CustomStack();
    
    public String[] ReverseInfixToPrefix(String Input){
        InToReIn re = new InToReIn();
        String[] reinfix = re.InfixToReverseInfix(Input);
        int n = reinfix.length;
        String[] prefix = new String[n];
        
        int k = n-1;
        for (int i=0 ; i<n ; i++){
            prefix[k] = "";
            
            String c = reinfix[i];
//            System.out.println(c);

            if(Character.isDigit(c.charAt(0))){
                prefix[k] = reinfix[i];
                k--;
            }
            else if (c.equals(")")){
                stack.push(c);
            }
            else if (c.equals("(")) {
                while (!String.valueOf(stack.peek()).equals(")")) {
                    prefix[k] = String.valueOf(stack.pop());
                    k--;
                }
                stack.pop();
            }
            else if (c.equals("-") || c.equals("+") || c.equals("×") || c.equals("÷") || c.equals("^") || c.equals("sin") || c.equals("cos") || c.equals("tan") || c.equals("log") || c.equals("ln")){
                while (stack.size() > 0 && !String.valueOf(stack.peek()).equals(")") && Priority(c) < Priority(String.valueOf(stack.peek()))) {
                    prefix[k] = String.valueOf(stack.pop());
                    k--;
                }
                stack.push(c);
            }
        }
        
        while (stack.size() > 0) {
            prefix[k] = String.valueOf(stack.pop());
            k--;
        }
        
        
        return prefix;
    }
    
    
    public String InToPoText(String Input){
        String[] prefix = ReverseInfixToPrefix(Input);
        String p="";
        
        for (String prefix1 : prefix) {
            if (null != prefix1) {
                p = p + prefix1;
            }
        }
        

        return "Prefix = " + p;
    }
    
    
    private static int Priority(String c) {
        switch (c) {
            case "+":
            case "-":
                return 0;
            case "×":
            case "÷":
                return 1;
            case "^":
                return 2;
            case "log":
            case "sin":
            case "ln":
            case "sqrt":
            case "cos":
            case "tan":
                return 3;
            default:
                break;
        }
        return -1;
    }
}
