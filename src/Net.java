import java.util.List;

public class Net {

    private Neuron layer0;
    private Matrix out0;

    public Net(Neuron layer0) {
        this.layer0 = layer0;
    }

    public void think(Matrix inputs) {
        out0 = inputs.multiply(this.layer0.weights).tanh();
    }

    public void train(Matrix inputs, Matrix outputs, int numIterations) {
        for (int i = 0; i < numIterations; i++) {
            // Pass through training layer(s)
            think(inputs);

            //adjust weights for layer(s) output
            Matrix errorLayer0 = outputs.sub(out0);
            Matrix adjuster = errorLayer0.tanhDerivative(); //Activation Function Derivative
            Matrix delta0 = errorLayer0.scalarMultiply(adjuster);
            //calculate weight adjustments
            Matrix adjustmentLayer0 = inputs.transpose().multiply(delta0);
            //adjust the weights
            this.layer0.adjustWeights(adjustmentLayer0);
        }
    }

    public Matrix getOutput() {
        return out0;
    }

}
