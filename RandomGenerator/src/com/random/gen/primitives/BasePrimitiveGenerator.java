package com.random.gen.primitives;

public interface BasePrimitiveGenerator<T> {
	/**
	 * 
	 * @return random b/w start and end
	 */
	T between();
	
	/**
	 * 
	 * @return random with some bound like 3.7685 bound=2 --> 3.76 
	 */
	
	T betweenWithBound();
	/**
	 * 
	 * @return random less than give value
	 */
	T lesser();
	/**
	 * 
	 * @return random greater than than given value 
	 */
	T greater();
	/**
	 * if digit=2 return random b/w 10 to 99
	 * digit =3 return random b/w 100 to 999
	 * digit =4 return random b/e  1000 to 9999
	 * @return 
	 */
	T betweenDigit();
}
