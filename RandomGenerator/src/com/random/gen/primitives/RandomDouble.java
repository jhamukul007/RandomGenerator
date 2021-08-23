package com.random.gen.indexs;

import com.random.gen.base.RandomGenerator;
/**
 * 
 * @author Mukul
 *
 */
public class RandomDouble {
	
	//private static final double DEFAULT_START=Double.MIN_VALUE;
	private static final double DEFAULT_END=Double.MAX_VALUE;

	private double start;
	private double end;
	private int bound;

	private RandomDouble(RandomDoubleBuilder builder) {
		this.start=Math.abs(builder.start);
		this.end=Math.abs(builder.end);
		this.bound=Math.abs(builder.bound);
		validate();
	}

	private void validate() {
		if(this.start==this.end)
			this.end=DEFAULT_END;
		if(bound>6)
			bound=6;
	}

	public static class RandomDoubleBuilder{
		private double start;
		private double end;
		private int bound;

		public RandomDoubleBuilder start(double start) {
			this.start = start;
			return this;
		}

		public RandomDoubleBuilder end(double end) {
			this.end = end;
			return this;
		}

		public RandomDoubleBuilder bound(int bound) {
			this.bound = bound;
			return this;
		}

		public RandomDouble build() {
			return new RandomDouble(this);
		}
	}

	public double betweenDouble() {
		return this.start+RandomGenerator.RANDOM.nextDouble()*Math.abs(this.end-this.start);
	}

	public double betweenDoubleWithBound() {
		return Double.parseDouble(String.format("%."+(this.bound)+"f" ,
				this.start+RandomGenerator.RANDOM
				.nextDouble()*Math.abs(this.end-this.start)));
	}

	public double lesserDouble() {
		return RandomGenerator.RANDOM.nextDouble()%this.end;
	}

	public double greaterDouble() {
		return this.start+RandomGenerator.RANDOM.nextDouble();
	}
	
	public static RandomDoubleBuilder builder() {
		return new RandomDoubleBuilder();
	}
}
