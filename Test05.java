package lesson5;

public class Test05 {
    public static void main(String[] args) {
        int number = 3;
        int expo = 3;
        double res = exponentiation(number,expo,number);
        printDoubleOrInt(res);


    }

    private static void printDoubleOrInt(double res) {
        String[] splitter = String.valueOf(res).split("\\.");
        if(splitter[1].length() == 1 && splitter[1].equals("0")){
            System.out.println((int)res);
        }else{
            System.out.println(res);
        }
    }

    public static double exponentiation(int num, int exp, double res){
        boolean negativeNumber = false;
        if(exp < 0){
          exp = exp * -1;
          negativeNumber = true;
        }
        double result = res;
        if(num == 0){
            result = 0;
        }else if(exp == 0 && num == res){
            result = 1;
        }else if(exp == 1){
            result = res;
        }else if(exp > 0){
            result = result * num;
            result = exponentiation(num, --exp, result);
        }
        if(negativeNumber){
            result = 1 / result;
        }
        return result;
    }

}
