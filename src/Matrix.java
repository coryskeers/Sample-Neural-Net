public class Matrix {
    public int nrows;
    public int ncols;
    public double[][] data;

    public Matrix(int nrows, int ncols) {
        this.nrows = nrows;
        this.ncols = ncols;
        this.data = new double[nrows][ncols];
    }

    public Matrix(double[][] data) {
        this.data = data;
        this.nrows = data.length;
        this.ncols = data[0].length;
    }

    public Matrix transpose() {
        Matrix transposed = new Matrix(this.ncols, this.nrows);
        for (int i = 0; i < this.nrows; i++) {
            for (int j = 0; j < this.ncols; j++) {
                transposed.data[j][i] = this.data[i][j];
            }
        }
        return transposed;
    }

    public Matrix multiply(Matrix other) {
        if (this.ncols != other.nrows) return null;
        Matrix result = new Matrix(this.nrows, other.ncols);
        for (int i = 0; i < this.nrows; i++) {
            for (int j = 0; j < other.ncols; j++) {
                double sum = 0;
                for (int k = 0; k < this.ncols; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    public Matrix scalarMultiply(Matrix other) {
        Matrix result = new Matrix(this.nrows, this.ncols);
        for (int i = 0; i < this.nrows; i++) {
            for (int j = 0; j < this.ncols; j++) {
                result.data[i][j] = this.data[i][j] * other.data[i][j];
            }
        }
        return result;
    }

    public Matrix scalarMultiply(double scalar) {
        Matrix result = new Matrix(this.nrows, this.ncols);
        for (int i = 0; i < this.nrows; i++) {
            for (int j = 0; j < this.ncols; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    public Matrix add(Matrix other) {
//        if (this.ncols != other.ncols || this.nrows != other.nrows) return null;
        Matrix result = new Matrix(this.nrows, this.ncols);
        for (int i = 0; i < this.nrows; i++) {
            for (int j = 0; j < this.ncols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix sub(Matrix other) {
//        if (this.ncols != other.ncols || this.nrows != other.nrows) return null;
        Matrix result = new Matrix(this.nrows, this.ncols);
        for (int i = 0; i < this.nrows; i++) {
            for (int j = 0; j < this.ncols; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    public double tanh(double x) {
        return Math.tanh(x);
    }

    public Matrix tanh() {
        Matrix results = new Matrix(nrows, ncols);
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncols; j++) {
                results.data[i][j] = tanh(data[i][j]);
            }
        }
        return results;
    }
    public static double tanhDerivative(double x) {
        return 1 - Math.tanh(x) * Math.tanh(x);
    }

    public Matrix tanhDerivative() {
        Matrix results = new Matrix(nrows, ncols);
        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncols; j++) {
                results.data[i][j] = tanhDerivative(data[i][j]);
            }
        }
        return results;
    }

    public void toPrint() {
        System.out.print("[ ");
        for (int i = 0; i < this.nrows; i++) {
            for (int j = 0; j < this.ncols; j++) {
                System.out.print(this.data[i][j]);
            }
            System.out.println("");
        }
    System.out.println("]");
    }

}
