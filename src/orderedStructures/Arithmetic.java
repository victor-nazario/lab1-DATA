package orderedStructures;

import java.util.Objects;

import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable{
	private double commonDifference; 
	Arithmetic returned; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() {
		current = current + commonDifference; 
		return current;
	}

	@Override
	public String toString() {
		String str = " Arith(" + this.firstValue() + "," + this.commonDifference + ")"; 
		
		return str; 
	}
	
	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 
		return this.firstValue() + (n-1)*this.commonDifference; 
	}
	
	
	public boolean equals(Object o) {
		if (o == this) { return true; }
		
		if (getClass() != o.getClass() || o == null) { return false; }
		
		Arithmetic arithmetic = (Arithmetic) o; 
		
		return Objects.equals(this.firstValue(), arithmetic.firstValue()) && 
				Objects.equals(this.commonDifference, arithmetic.commonDifference);
	}

	/** 
	 * Returns a new arithmetic progression that is the product of the summation of the first term and the common difference
	 * of both independent progressions upon the method is invoked on. 
	 * 
	 * @param prog is the arithmetic progression desired to be added to the progression on which the method is invoked on.
	 * @throws NullPointerExcepton when one or both objects are null. 
	 */
	
	@Override
	public Progression addProgression(Progression prog) throws NullPointerException{	 
		if (this == null || prog == null) { 
			throw new NullPointerException("The object upon which this method is invoked on contains a null pointer."); 
			}
		
		double commonDiff = prog.getTerm(1) - prog.getTerm(0); 
		
		return new Arithmetic(this.firstValue() + prog.firstValue(), this.commonDifference + commonDiff); 
		}
	

	/** 
	 * Returns a new arithmetic progression that is the product of the subtraction of the first term and the common difference
	 * of both independent progressions upon the method is invoked on. 
	 * 
	 * @param prog is the arithmetic progression desired to be subtracted to the progression on which the method is invoked on.
	 * @throws NullPointerExcepton when one or both objects are null. 
	 */
	
	@Override
	public Progression substractProgression(Progression prog) throws NullPointerException{
		if (this == null || prog == null) { 
			throw new NullPointerException("The object upon which this method is invoked on contains a null pointer."); 
			}
		
		double commonDiff = prog.getTerm(1) - prog.getTerm(0); 
		
		return new Arithmetic(this.firstValue() - prog.firstValue(), this.commonDifference - commonDiff); 
	}

	
}
