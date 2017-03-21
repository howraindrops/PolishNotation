package huawei;

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
		for(String item : items)
		{
			switch(item)
			{
			case "+":
				if(stack.size()<2) return -1;
				else
				{
					double num1 = stack.pop();
					double num2 = stack.pop();
					num1 += num2;
					stack.push(num1);
				}
				break;
			case "-":
				break;
			case "*":
				break;
			case "/":
				break;
			default:
				double num = Double.valueOf(item);
				stack.push(num);
				break;
			}
		}
		
		return 3.0;
	}

	public static void main(String[] args) {
		try {
			JavaTest c = new JavaTest();

			if (args.length == 1) {
				System.out.print(c.calculate(args[0]));
			}
		} catch (JavaTestException e) {
		}
	}
}