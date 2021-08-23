package com.random.gen.indexs;

import com.random.gen.base.RandomGenerator;

public class RandomFloat{
	
	private static final float DEFAULT_START=Float.MIN_VALUE;
	private static final float DEFAULT_END=Float.MAX_VALUE;

	private float start;
	private float end;
	private int bound;

	private RandomFloat(RandomFloatBuilder builder) {
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

	public static class RandomFloatBuilder{
		private float start;
		private float end;
		private int bound;

		public RandomFloatBuilder start(float start) {
			this.start = start;
			return this;
		}

		public RandomFloatBuilder end(float end) {
			this.end = end;
			return this;
		}

		public RandomFloatBuilder bound(int bound) {
			this.bound = bound;
			return this;
		}

		public RandomFloat build() {
			return new RandomFloat(this);
		}
	}

	public float betweenFloat() {
		return start+RandomGenerator.RANDOM.nextFloat()*Math.abs(this.end-this.start);
	}

	public float betweenFloatWithBound() {
		return Float.parseFloat(String.format("%."+(this.bound)+"f" ,
				this.start+RandomGenerator.RANDOM
				.nextFloat()*Math.abs(this.end-this.start)));
	}

	public float lesserFloat() {
		return RandomGenerator.RANDOM.nextFloat()%this.end;
	}

	public float greaterFloat() {
		return this.start+RandomGenerator.RANDOM.nextFloat();
	}
	
	public static RandomFloatBuilder builder() {
		return new RandomFloatBuilder();
	}
}
