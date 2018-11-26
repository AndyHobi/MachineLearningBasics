package newPackage;

public class Test {

	public static void main(String[] args) {
		
		NeuronLayer layer = new InputNeuronLayer(null, 0);
		
		double[][] matrix = {{1,2,3},{3,2,1},{5,3,2},{1,2,4}};
		double[] vector = {1,4,3};

		double[] mult = layer.multMatrixVector(matrix,vector);
		
		for(double val:mult) {
			System.out.println(val);
		}
		
	}

}
