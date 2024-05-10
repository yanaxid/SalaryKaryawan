package service;

import java.util.Scanner;

public class UserInputValidation {


	public int validateUserInputNumber( String sign, String message) {
		Scanner sc = new Scanner(System.in);
		boolean isValid = false;
		String x = "";
		
		while (isValid == false) {

			if (sc.hasNext()) {
				x = sc.nextLine();

				if (x.matches("[0-9]+")) {
					isValid = true;
				} else {
					isValid = false;
					System.out.println(String.valueOf("\u001B[31m") + message + String.valueOf("\u001B[0m"));
					System.out.print(sign);
				}
			} else {
				sc.close();
			}
		}

		return Integer.valueOf(x);
	}

}
