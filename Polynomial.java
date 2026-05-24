public class Polynomial {
    double[] coefficients;

    public Polynomial() {
        this.coefficients=new double[]{0};
    }

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public Polynomial add(Polynomial poly){
        int length=Math.max(poly.coefficients.length, this.coefficients.length);

        double[] newList = new double[length];

        for (int i =0; i<length; i++){
            double val1=0;
            double val2=0;

            if (i<this.coefficients.length){
                val1=this.coefficients[i];
            }

            if (i<poly.coefficients.length){
                val2=poly.coefficients[i];
            }

            newList[i]=val1+val2;
        }

        return new Polynomial(newList);
    }
    
    public double evaluate(double x){
        double sum=0;

        for (int i = 0; i<this.coefficients.length; i++){
            sum = sum + Math.pow(x, i)*this.coefficients[i];
        }

        return sum;
    }

    public boolean hasRoot(double value){

        double val=this.evaluate(value);
        return val==0;
    }
}
