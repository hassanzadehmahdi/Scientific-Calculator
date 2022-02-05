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
public class InToReIn {
    
    private static final CustomStack stack = new CustomStack();
    
    public String[] InfixToReverseInfix(String Input){
        
        int j=0;
        for (int i=0 ; i<Input.length() ; i++){

            String c = String.valueOf(Input.charAt(i));
            
            if (Character.isDigit(Input.charAt(i))) {
                String r = "";
                //baraye test chand ragam bodan adad 
                while (Character.isDigit(Input.charAt(i)) || Input.charAt(i) == '.') {
                    
                    r = r + String.valueOf(Input.charAt(i));
                    
                    i++;
                    
                    if (i == Input.length()) {
                        break;
                    }
                }
                i--;
                stack.push(r);
                j++;
            }
            else if (c.equals("(") || c.equals(")")){
                stack.push(c);
                j++;
            }
            else if (c.equals("-") || c.equals("+") || c.equals("×") || c.equals("÷") || c.equals("^") || c.equals("s") || c.equals("c") || c.equals("t") || c.equals("l")) {
                String operator = "";
                int count = 0;
                while (Character.isLetter(Input.charAt(i))) {
                    operator += String.valueOf(Input.charAt(i));
                    i++;
                    count++;
                }
                if (count > 0) {
                    stack.push(operator);
                    i--;
                    j++;
                } else if (count == 0) {
                    stack.push(c);
                    j++;
                }
            }
        }

        int k=0;
        String[] reInfix = new String[j];
        
        while (stack.size() > 0) {
            reInfix[k] = "";
            reInfix[k] = String.valueOf(stack.pop());
            k++;
        }
        
        return reInfix;
    }
      
}
