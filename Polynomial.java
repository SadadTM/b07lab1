import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

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

        int texp = this.exponents[this.exponents.length - 1];
        int pexp = poly.exponents[poly.exponents.length - 1];

        int maxExp = Math.max(texp,pexp);

        double[] newList = new double[maxExp + 1];

        for(int i=0;i<this.exponents.length;i++){
            int e = this.exponents[i];
            newList[e]=newList[e]+this.coefficients[i];
        }

        for(int i=0; i<poly.exponents.length; i++){
            int e = poly.exponents[i];
            newList[e]=newList[e]+poly.coefficients[i];
        }

        int count = 0;
        for(int i=0; i<newList.length;i++){
            if (newList[i]!=0){
                count++;
            }
        }

        if(count==0){
            return new Polynomial();
        }

        double[] coeffs = new double[count];
        int[] exps = new int[count];

        int idx=0;
        for(int i=0; i<newList.length; i++){
            if(newList[i]!=0){
                coeffs[idx]=newList[i];
                exps[idx]=i;
                idx++;
            }
        }
        return new Polynomial(coeffs, exps);

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

        int texp = this.exponents[this.exponents.length - 1];
        int pexp = poly.exponents[poly.exponents.length - 1];

        int maxExp = texp + pexp;

        double[] newList = new double[maxExp + 1];

        for(int i=0;i<this.exponents.length;i++){
            for(int j=0; j<poly.exponents.length;j++){
                double c = this.coefficients[i]*poly.coefficients[j];
                int e = this.exponents[i]+poly.exponents[j];

                newList[e]=newList[e]+c;
            }
        }

        int count = 0;
        for(int i=0; i<newList.length;i++){
            if (newList[i]!=0){
                count++;
            }
        }

        if(count==0){
            return new Polynomial();
        }

        double[] coeffs = new double[count];
        int[] exps = new int[count];

        int idx=0;
        for(int i=0; i<newList.length; i++){
            if(newList[i]!=0){
                coeffs[idx]=newList[i];
                exps[idx]=i;
                idx++;
            }
        }
        return new Polynomial(coeffs, exps);
    }

    public Polynomial(File f) throws FileNotFoundException{
        Scanner scanner = new Scanner(f);
        String line = scanner.nextLine();
        String [] polystr = line.split("[+]|(?=-)");
        double[] coeffs = new double[polystr.length];
        int[] exps = new int[polystr.length];

        for (int i=0;i<polystr.length;i++){
            if (polystr[i].isEmpty()){
                continue;
            }

            if(!(polystr[i].contains("x"))){
                coeffs[i]=Double.parseDouble(polystr[i]);
                exps[i]=0;
            }
            else{
                String[] parts = polystr[i].split("x");
                coeffs[i]=Double.parseDouble(parts[0]);
                if (parts.length==1){
                    exps[i]=1;
                }
                else{
                    exps[i]=Integer.parseInt(parts[1]);
                }
            }
        }

        this.coefficients=coeffs;
        this.exponents=exps;

        scanner.close();
    }

    public void saveToFile(String f) throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(f);
        for (int i=0; i<this.coefficients.length; i++){
            if(i!=0 && this.coefficients[i]>0){
                writer.print("+");
            }
            if(this.exponents[i]==0){
                writer.print(this.coefficients[i]);
            }
            else if(this.exponents[i]==1){
                writer.print(this.coefficients[i]);
                writer.print("x");
            }
            else{
                writer.print(this.coefficients[i]);
                writer.print("x");
                writer.print(this.exponents[i]);
            }
        }
        writer.close();
    }
    
}
