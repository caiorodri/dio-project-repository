package count;

import count.exception.InvalidParamException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Accountant {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro parâmetro: ");
            int firstParam = scan.nextInt();

            System.out.print("Digite o segundo parâmetro: ");
            int secondParam = scan.nextInt();

            printRange(firstParam, secondParam);

        }catch (InvalidParamException e) {
            System.err.println("\nO segundo parâmetro deve ser maior que o primeiro!");
        } catch (InputMismatchException e){
            System.err.println("\nOs parâmetros devem ser numeros inteiros!");
        }

    }
    static void printRange(int firstParam, int secondParam ) throws InvalidParamException {

        if (firstParam > secondParam){
            throw new InvalidParamException();
        } else {

            int count = secondParam - firstParam;

            System.out.print("\nContando... ");

            for (int i = 0; i < count; i++) {
                System.out.print(i + 1);
                if (i+1 < count){
                    System.out.print(", ");
                }
            }
        }
    }

}
