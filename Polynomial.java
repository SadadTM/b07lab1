public class Polynomial {
    double[] coefficients;
    int[] exponents;

    public Polynomial() {
        this.coefficients=new double[]{0};
        this.exponents=new int[]{0};
    }

    public Polynomial(double[] coefficients, int[] exponents) {
        this.coefficients = coefficients;
        this.exponents = exponents;
    }

    public Polynomial add(Polynomial poly){

        int length=Math.max(poly.coefficients.length, this.coefficients.length);

        double[] newList = new double[length];

        for (int i=0; i<length; i++){
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


        int [] placeholder = new int[10]; // so code does not break
        return new Polynomial(newList, placeholder);
    }
    
    public double evaluate(double x){
        double sum=0;

        for (int i = 0; i<this.coefficients.length; i++){
            sum = sum + Math.pow(x, this.exponents[i])*this.coefficients[i];
        }

        return sum;
    }

    public boolean hasRoot(double value){

        double val=this.evaluate(value);
        return val==0;
    }

    public Polynomial multiply(Polynomial poly){

        int texp = 0;
        for(int i=0;i<this.exponents.length;i++){
            if(this.exponents[i]>texp){
                texp=this.exponents[i];
            }
        }

        int pexp = 0;
        for(int i=0;i<poly.exponents.length;i++){
            if(poly.exponents[i]>pexp){
                pexp=poly.exponents[i];
            }
        }

        int maxExp = texp + pexp;

        double[] newList = new double[maxExp + 1];

        for(int i=0;i<this.exponents.length;i++){
            for(int j=0; i<poly.exponents.length;j++){
                double c = this.coefficients[i]*poly.coefficients[j];
                int e = this.exponents[i]+poly.exponents[j];
            }
        }

        return poly;
    }
}
