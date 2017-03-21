package huawei;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 请注意不要修改包名、类名，否则将导致考试成绩失效
 */
public class JavaTest {
	public static class JavaTestException extends Exception {
		private static final long serialVersionUID = 1584895723070259373L;
	}

	/**
	 * 逆波兰表达式中存在语法错误
	 */
	public static class RPNSyntaxErrorException extends JavaTestException {
		private static final long serialVersionUID = 9109750478481891787L;

		public RPNSyntaxErrorException() {
		}
		
		public RPNSyntaxErrorException(String warning) {
		}
	}

	/**
	 * 逆波兰表达式计算中出现除零错误
	 */
	public static class DevideByZeroException extends JavaTestException {
		private static final long serialVersionUID = 2599554592065887836L;

		public DevideByZeroException() {
		}
	}

	/**
	 * 请实现calculate函数，来计算逆波兰表达式，
	 * 可以根据需要增加变量和函数， 但是注意不要修改calculate函数的原型
	 * 
	 * @param rpn
	 *            逆波兰表达式字符串
	 * @return 结果字符串
	 */
	public double calculate(String rpn) throws JavaTestException {
		Stack<Double> stack = new Stack<Double>();
		String[] items = rpn.split(" ");
		double num1=0, num2=0;
		
		for(String item : items)
		{
			boolean isOperation = item.equals("+")||item.equals("-")||item.equals("*")||item.equals("%");
			if(isOperation)
			{
				if(stack.size()<2)
				{
					throw new RPNSyntaxErrorException();
				}else
				{
					num1 = stack.pop();
					num2 = stack.pop();
				}
			}
			
			switch(item)
			{
			case "+":
				num1 += num2;
				stack.push(num1);
				break;
			case "-":
				num1 = num2 - num1;
				stack.push(num1);
				break;
			case "*":
				num1 *= num2;
				stack.push(num1);
				break;
			case "/":
				BigDecimal n = new BigDecimal(num1);
				if(n.compareTo(new BigDecimal(0.0d)) == 0)
				{
					throw new DevideByZeroException();
				}
				else
				{
					num1 = num2 / num1;
					stack.push(num1);
				}
				break;
			default:
				try
				{
					double num = Double.valueOf(item);
					stack.push(num);
				}catch(NumberFormatException e)
				{
					throw new RPNSyntaxErrorException("Number format exception");
				}
				break;
			}
		}
		
		if(stack.size() == 1)
		{
			return stack.pop();
		}
		else
		{
			throw new RPNSyntaxErrorException();
		}
	}

	
	public static void main(String[] args) {
		try {
			JavaTest c = new JavaTest();

			if (args.length == 0) {
				System.out.print(c.calculate("1 2 2 - /"));
			}
		} catch (JavaTestException e) {
			e.printStackTrace();
		}
	}
}