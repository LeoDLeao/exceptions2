package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter the account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.next();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account acc = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amouth for withdraw: ");
			double amouth = sc.nextDouble();
			acc.withdraw(amouth);
			System.out.print("New balance: " + String.format("%.2f", acc.getBalance()));
		} catch (InputMismatchException e) {
			System.out.println("Error: Invalid data");
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} finally {
			sc.close();
		}

	}

}
