package com.challenges.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Vertex {
	int id;
	int color = 0;
	Set<Integer> adjacents = new HashSet<>();

	public Vertex(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

public class RoadsAndLibraries {

	static int roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		if (c_lib < c_road)
			return n * c_lib;
		List<Vertex> graph = new ArrayList<>(n);
		for (int i = 0; i < cities.length; i++) {

		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int c_lib = in.nextInt();
			int c_road = in.nextInt();
			int[][] cities = new int[m][2];
			for (int cities_i = 0; cities_i < m; cities_i++) {
				for (int cities_j = 0; cities_j < 2; cities_j++) {
					cities[cities_i][cities_j] = in.nextInt();
				}
			}
			int result = roadsAndLibraries(n, c_lib, c_road, cities);
			System.out.println(result);
		}
		in.close();
	}

}
