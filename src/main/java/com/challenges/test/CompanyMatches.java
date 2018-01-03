package com.challenges.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompanyMatches {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();

		Set<String> periodicElements = new HashSet<>(n);
		while (n-- > 0) {
			periodicElements.add(scanner.nextLine());
		}

		while (m-- > 0) {
			boolean replaced = false;
			String company = scanner.nextLine();
			for (String element : periodicElements) {
				if (company.contains(element)) {
					company = company.replaceAll(element, "[" + element + "]");
					replaced = true;
				}
			}
			if (!replaced) {
				for (String element : periodicElements) {
					String lowerCaseCompany = company.toLowerCase();
					String replacement = "[" + element + "]";
					int indexOf = lowerCaseCompany.lastIndexOf(element.toLowerCase());
					while (indexOf > -1) {
						if (indexOf + element.length() < company.length()) {
							company = company.substring(0, indexOf) + replacement
									+ company.substring(indexOf + element.length());
						} else {
							company = company.substring(0, indexOf) + replacement;
						}
						indexOf = lowerCaseCompany.lastIndexOf(element.toLowerCase(), indexOf - 1);
						replaced = true;
					}
				}
			}
			if (replaced) {
				System.out.println(company);
			}
		}
		scanner.close();
	}
}
