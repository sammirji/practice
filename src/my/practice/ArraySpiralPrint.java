package my.practice;

public class ArraySpiralPrint {

	public static void main(String[] args) {
		int rows = 3;
		int cols = 5;
		int a[][] = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15}
		};
		spiralPrint(rows, cols, a);
	}

	static void spiralPrint(int rows, int cols, int a[][]) {
		int rowIt = 0, colIt = 0;
		while (rowIt < rows && colIt < cols) {
			for (int i=0; i<cols; i++) {
				System.out.print(a[colIt][i] + " ");
			}
			colIt++;
			for (int j=rowIt; j<rows; j++) {
				System.out.print(a[j][cols] + " ");
			}
			cols--;
		}
	}
}
