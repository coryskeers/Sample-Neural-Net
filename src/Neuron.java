public class Neuron {

    public Matrix weights;

    public Neuron(int numNeurons, int numInputsPerNeuron) {
        weights = new Matrix(numInputsPerNeuron, numNeurons);

        for (int i = 0; i < numInputsPerNeuron; i++) {
            for (int j = 0; j < numNeurons; j++) {
                weights.data[i][j] = (2 * Math.random()) - 1;
            }
        }

        //activation/derivative functions
    }

    public void adjustWeights(Matrix adjustment) {
        this.weights = this.weights.add(adjustment);
    }

    /////////////////////////////////
    //Neuron Mathematical Functions//
    /////////////////////////////////
    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    public static Matrix sigmoid(Matrix X) {
        Matrix results = new Matrix(X.nrows, X.ncols);
        for (int i = 0; i < X.nrows; i++) {
            for (int j = 0; j < X.ncols; j++) {
                results.data[i][j] = sigmoid(X.data[i][j]);
            }
        }
        return results;
    }

    public static double sigmoidDerivative(double x) {
        return x * (1 - x);
    }

    public static Matrix sigmoidDerivative(Matrix X) {
        Matrix results = new Matrix(X.nrows, X.ncols);
        for (int i = 0; i < X.nrows; i++) {
            for (int j = 0; j < X.ncols; j++) {
                results.data[i][j] = sigmoidDerivative(X.data[i][j]);
            }
        }
        return results;
    }

    public static double tanh(double x) {
        return Math.tanh(x);
    }

    public static Matrix tanh(Matrix X) {
        Matrix results = new Matrix(X.data.length, X.data[0].length);
        for (int i = 0; i < X.nrows; i++) {
            for (int j = 0; j < X.ncols; j++) {
                results.data[i][j] = tanh(X.data[i][j]);
            }
        }
        return results;
    }

    public static double tanhDerivative(double x) {
        return 1 - Math.tanh(x) * Math.tanh(x);
    }

    public static Matrix tanhDerivative(Matrix X) {
        Matrix results = new Matrix(X.nrows, X.ncols);
        for (int i = 0; i < X.nrows; i++) {
            for (int j = 0; j < X.ncols; j++) {
                results.data[i][j] = tanhDerivative(X.data[i][j]);
            }
        }
        return results;
    }

    public static double[] normalize(double[] vector) {
        double sum = 0.0;
        double[] result = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];
        }
        for (int i = 0; i < vector.length; i++) {
            result[i] = vector[i] / sum;
        }
        return result;
    }


}
