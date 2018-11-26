package newPackage;

public abstract class NeuronLayer {

	double[] vals;
	NeuronLayer next;
	NeuronLayer prev;
	
	NeuronLayer(NeuronLayer prev, NeuronLayer next, int size) {
		this.next = next;
		this.prev = prev;
		vals = new double[size];
	}
	
	public double[] getVals() {
		return vals;
	}

	public void setVals(double[] vals) {
		this.vals = vals;
	}
	
	public void setVal(double val, int index) {
		if(index >= vals.length || index < 0) {
			System.out.println("Index out of bounds: " + index);
		} else {
			vals[index] = val;
		}
	}
	
	public int getValsSize() {
		return vals.length;
	}
	
	public double[] multMatrixVector (double[][] matrix, double[] vector) {
		
		if(matrix.length > 0) {
			if(matrix[0].length == vector.length) {
				
				double[] outVect = new double[matrix.length];
								
				for(int k = 0; k < matrix.length; k++) {
					for(int i = 0; i < vector.length; i++) {
						
						outVect[k] += vector[i] * matrix[k][i];
						
					}
				}
				
				return outVect;
				
			}
		} else { 
			System.out.println("Error, matrix is empty");
		}
		
		return vector;
		
	}
	
	public void valsSimplify() {
		for(double val:vals) {
			if(val < 0.0) {val = 0;}
		}
	}
}
