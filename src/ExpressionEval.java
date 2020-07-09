import java.util.Scanner;
import java.util.Stack;

public class ExpressionEval {

	public static void main(String[] args) {
		
		String exp;
		final int SIZE = 100;
		char expression[] = new char[SIZE];
		int start = 0, end = 0, dollar = 0, len;
		
		System.out.println("Enter the expression : ");
		Scanner scanner = new Scanner(System.in);
		exp = scanner.next();
		expression = exp.toCharArray();
		
		System.out.println("User Entered expression is: " + exp);
		len = expression.length;
		
		for(int i = 0; i < len; i++)
		{
			if(expression[i] == '[') start++;
			else if(expression[i] == ']') end++;
			else if(expression[i] == '$') dollar++;
		}
		if((start != end) && ((start+dollar) != end) && (start != (end+dollar)))
		{
		  System.out.println("Expression is NOT Balanced ");
		}
		else if(start == end)
		{
			for(int i = 0; i < len; i++) if(expression[i] == '$') expression[i] = ' ';
		}
		else if(start+dollar == end)
		{
			for(int i = 0; i < len; i++) if(expression[i] == '$') expression[i] = '[';
		}
		else if(start == end+dollar)
		{
			for(int i = 0; i < len; i++) if(expression[i] == '$') expression[i] = ']';
		}
				
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < len; i++)
		{
			try
			{
			  if(expression[i] == '[') st.push('[');
			  else if(expression[i] == ']') { st.pop(); }
			}
			catch(Exception e)
			{
			  System.out.println("Expression is NOT Balanced");
			  System.exit(0);
			}
			
		}
		if(st.isEmpty()) System.out.println("Expression is  BALANCED ");
		else System.out.println("Expression is NOT Balanced ");

	}

}
