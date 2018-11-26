package newPackage;

public class IntermediateNeuronLayer extends NeuronLayer{
	
	double[] modifiers;
	double[][] inputMultipliers;
	
	IntermediateNeuronLayer(NeuronLayer prev,NeuronLayer next, int size) {
		super(prev, next, size); // Generates a standard neuron layer that can store data. 
		modifiers = new double[size];
		inputMultipliers = new double[prev.getValsSize()][size];
	}
	
	public void calcVals() {
		vals = multMatrixVector(inputMultipliers, prev.vals);
		valsSimplify();
	}
	
}
