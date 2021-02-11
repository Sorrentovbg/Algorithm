package lesson3;


import java.util.Scanner;

public class StringReverse {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new StringReverse();
        readLine();

    }
    public static void readLine(){
        while (true) {
            System.out.println("Введите строку : " + "\n");
            String takeLine = sc.nextLine().trim();
            workWithLine(takeLine);
        }

    }
    public static void workWithLine(String takeLine){
        if(takeLine.length() == 0){
            System.out.println("Error: empty string");
        }else{
            IStack<Character> stringToChar = new StackImpl<>(takeLine.length());
            for(int i = 0; i < takeLine.length(); i++){
                Character charLetter = takeLine.charAt(i);
                stringToChar.push(charLetter);
            }
            while(stringToChar.size() != 0){
                System.out.print(stringToChar.peek());
                stringToChar.pop();
            }
        }
        System.out.println("\n");

    }
}
