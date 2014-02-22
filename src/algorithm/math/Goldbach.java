package algorithm.math;

/**
 * 写出一个程序以显示每个大于2的偶整数，比如1000，是两个质数之和。
 * 
 * @author EricTan
 * 
 */
public class Goldbach {

	public boolean prove(int evenNumber) {
		
		if(evenNumber<2){
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < evenNumber; i++) {
			int number1 = i;
			int number2 = evenNumber - i;
			if (MathUtil.isPrime(number1) && MathUtil.isPrime(number2)) {
				System.out.println(evenNumber + "=" + number1 + "+" + number2);
				return true;
			}
		}

		return false;
	}

}
