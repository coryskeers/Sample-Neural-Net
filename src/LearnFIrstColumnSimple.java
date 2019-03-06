public class LearnFIrstColumnSimple {

    public static void main(String[] args) {

        Neuron layer0 = new Neuron(1, 3);
        Net net = new Net(layer0);

        Matrix inputs = new Matrix(new double[][]{
                {0,0,1},
                {1,1,1},
                {1,0,1},
                {0,1,1},
                {1,1,0}
        });

        Matrix outputs = new Matrix(new double[][]{
                {0},
                {1},
                {0},
                {1},
                {1}
        });

        System.out.println("Training the neural net...");
        net.train(inputs, outputs, 100);
        System.out.println("Finished training");

        System.out.println("Layer 0 weights");
        layer0.weights.toPrint();

        predict(new double[][]{{1,0,0}}, net);
    }
    public static void predict(double[][] testInput, Net net) {
        Matrix inputs = new Matrix(testInput);
        net.think(inputs);

        System.out.println("Prediction on data "
            + inputs.data[0][0] + " "
            + inputs.data[0][1] + " "
            + inputs.data[0][2] + " -> "
            + net.getOutput().data[0][0] + ", expected -> " + inputs.data[0][1]);

    }

}
