package orderedStructures;

public class Fibonacci extends Progression {

	private double prev; 
	private int runs = 0;
	
	public Fibonacci() { 
		this(1); 
		prev = 0; 
	}
	private Fibonacci(double first) {
		super(first);
	}

	@Override
	public double nextValue()  throws IllegalStateException{
		
		if (runs < 0) 
			throw new IllegalStateException ("firstValue method has not run yet"); 
		double orig = prev; 
		prev = current; 
		current += orig; 
		
		
		return current;
	}
	
	@Override	
	public double firstValue() {  
		double value = super.firstValue(); 
		prev = 0; 
		runs += 1; 
		return value; 
	}

}
