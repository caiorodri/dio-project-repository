package backaccount;

import exception.InvalidParamException;

import java.util.Scanner;

public class BankAccount {

    String name;
    String agency;
    int number;
    double balance;

    public static void main(String[] args) throws InvalidParamException {

        try {

            Scanner scan = new Scanner(System.in);

            System.out.print("Digite seu nome: ");
            String name = scan.nextLine();

            if (name.isEmpty()){
                throw new InvalidParamException();
            }

            System.out.print("Digite a agência: ");
            String agency = scan.nextLine();

            if (agency.isEmpty()){
                throw new InvalidParamException();
            }

            System.out.print("Digite o número da conta: ");
            int number = scan.nextInt();

            if (number == 0){
                throw new InvalidParamException();
            }

            System.out.print("Digite o saldo: ");
            double balance = scan.nextDouble();

            if (balance <= 0){
                throw new InvalidParamException();
            }

            BankAccount bankAccount = new BankAccount(name, agency, number, balance);
            bankAccount.describe();

        } catch (InvalidParamException e){
            System.err.println("Parâmetros invalídos");
        }
    }

    public BankAccount(String name, String agency, int number, double balance) {
        this.name = name;
        this.agency = agency;
        this.number = number;
        this.balance = balance;
    }

    public void describe(){

        System.out.println("\nDESCRIÇÃO\n\nTitular: " + this.name + "\nNumero: " + this.number + "\nAgencia: " + this.agency + "\nSaldo: " + this.balance);

    }


}
