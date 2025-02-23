package application;


/**
 * @author Andrew Dietrich
 */
public class Notation {
    /**
     * Convert an infix expression into a postfix expression
     * @param infix the infix expression in string format
     * @return the postfix expression in string format
     * @throws InvalidNotationFormatException if the infix expression format is invalid
     */
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
    {try{
        MyQueue<String> Q = new MyQueue<String>();
        MyStack<String> S = new MyStack<String>();
        while(infix.length()!=0)
        {
            String atZero = ""+infix.charAt(0);
            System.out.println("Queue: "+Q.toString(" "));
            System.out.println("Stack: "+ S);
            System.out.println(infix);
            System.out.println(atZero);
            if("1256789034".contains(atZero))
                Q.enqueue(atZero);
            else if(atZero.equals("("))
                S.push(atZero);
            else if (atZero.equals("+") || atZero.equals("-"))
            {
                while(S.top() != null && (S.top().equals("*") || S.top().equals("/")))
                {
                    Q.enqueue(S.pop());
                }
                S.push(atZero);
            }else if (atZero.equals(")"))
            {
                if(S.top() == null)
                {
                    throw new InvalidNotationFormatException();
                }
                String temp = S.pop();
                while(true)
                {
                    System.out.println(temp);
                    if(temp.equals("("))
                        break;
                    else{
                        Q.enqueue(temp);
                        if(S.top() == null)
                            throw new InvalidNotationFormatException();
                        temp = S.pop();
                    }
                    
                }
            }else if(atZero.equals("*") || atZero.equals("/"))
                {
                    S.push(atZero);
                }
            infix = infix.substring(1);
        }
        while(!S.isEmpty())
        {
            Q.enqueue(S.pop());
        }
        return Q.toString();
    }catch (StackUnderflowException e)
    {
        throw new InvalidNotationFormatException();
    }
    }
    /**
     * Convert the Postfix expression to the Infix expression
     * @param postfix the postfix expression in string format
     * @return the infix expression in string format
     * @throws InvalidNotationFormatException if the postfix expression format is invalid
     */
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
    {try{
        MyStack<String> S = new MyStack<String>() ;
        while(postfix.length()!=0)
        {
            String atZero = ""+postfix.charAt(0);
            if("/-+*".contains(atZero))
            {
                if(S.size()<2)
                    throw new InvalidNotationFormatException();
                String s1 = S.pop();
                String s2 = S.pop();
                S.push("("+s2+atZero+s1+")");
            }
            else if("1234567890".contains(atZero))
            {
                S.push(atZero);
            }
            postfix = postfix.substring(1);
        }
        return S.toString();
    }catch (StackUnderflowException e)
    {
        throw new InvalidNotationFormatException();
    }
}
    /**
     * Evaluates a postfix expression from a string to a double
     * @param infix the postfix expression in String format
     * @return the evaluation of the postfix expression as a double
     * @throws InvalidNotationFormatException if the postfix expression format is invalid
     */    
public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
    {try{
        MyStack<String> S = new MyStack<String>();
        while(!postfixExpr.equals(""))
        {
            String atZero = ""+postfixExpr.charAt(0);
            if("1234567890".contains(atZero))
            {
                S.push(atZero);
            }else if(atZero.equals("+"))
            {
                if(S.size()<2) {throw new InvalidNotationFormatException(); }
                double newval = Double.parseDouble(S.pop()) + Double.parseDouble(S.pop());
                System.err.println(newval);
                S.push("" + newval);
            }else if(atZero.equals("-")){
                if(S.size()<2) {throw new InvalidNotationFormatException(); }
                double num1 = Double.parseDouble(S.pop());
                double num2 = Double.parseDouble(S.pop());
                double newval = num2 - num1;
                System.err.println(newval);
                S.push("" + newval);
            }else if(atZero.equals("*"))
            {if(S.size()<2) {throw new InvalidNotationFormatException(); }
                double newval = Double.parseDouble(S.pop()) * Double.parseDouble(S.pop());
                System.err.println(newval);
                S.push("" + newval);
            }else if(atZero.equals("/"))
            {
                if(S.size()<2) {throw new InvalidNotationFormatException(); }
                double num1 = Double.parseDouble(S.pop());
                double num2 = Double.parseDouble(S.pop());
                double newval = num2 / num1;
                System.err.println(newval);
                S.push("" + newval);
            }
                postfixExpr = postfixExpr.substring(1);
            
            
        }
        return Double.parseDouble(S.pop());
    }catch (StackUnderflowException e)
    {
        throw new InvalidNotationFormatException();
    }
}
}
