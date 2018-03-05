package orderedStructures;

import java.util.Objects;

import interfaces.Combinable;

public class Geometric extends Progression implements Combinable{

	private double commonFactor; 
	
	public Geometric(double firstValue, double commonFactor) { 
		super(firstValue); 
		this.commonFactor = commonFactor; 
	}
	
	@Override
	public double nextValue() {
		current = current * commonFactor; 
		return current;
	}

	public String toString() {
		String str = " Geom(" + this.firstValue() + "," + this.commonFactor + ")"; 	
		return str; 
	}
	
	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 
		return this.firstValue() + Math.pow(this.commonFactor, (n-1));  
	}
	
	public boolean equals(Object o) {
		if (o == this) { return true; }
		
		if (getClass() != o.getClass() || o == null) { return false; }
		
		Geometric geometric = (Geometric) o; 
		
		return Objects.equals(this.firstValue(), geometric.firstValue()) && 
				Objects.equals(this.commonFactor, geometric.commonFactor);
	}

	/** 
	 * Returns a new geometric progression that is the product of the summation of the first term and the common factor
	 * of both independent progressions upon the method is invoked on. 
	 * 
	 * @param prog is the geometric progression desired to be added to the progression on which the method is invoked on. 
	 * @throws NullPointerExcepton when one or both objects are null. 
	 */
	
	@Override
	public Progression addProgression(Progression prog) throws NullPointerException{	
		if ((Geometric)prog == null) { 
			throw new NullPointerException("The object upon which this method is invoked on contains a null pointer."); 
			}
		
		double commonFactor = (prog.getTerm(2)/prog.getTerm(1)); 
		
		return new Geometric(this.firstValue() + prog.firstValue(), this.commonFactor + commonFactor); 
		}

	/** 
	 * Returns a new geometric progression that is the product of the subtraction of the first term and the common factor
	 * of both independent progressions upon the method is invoked on. 
	 * 
	 * @param prog is the geometric progression desired to be subtracted to the progression on which the method is invoked on.
	 * @throws NullPointerExcepton when one or both objects are null. 
	 */
	
	@Override
	public Progression substractProgression(Progression prog) throws NullPointerException{
		if ((Geometric)prog == null) { 
			throw new NullPointerException("The object upon which this method is invoked on contains a null pointer."); 
			}
		
		double commonFactor = (prog.getTerm(2)/prog.getTerm(1)); 
		
		return new Geometric(this.firstValue() - prog.firstValue(), this.commonFactor - commonFactor); 
	}

	
}
