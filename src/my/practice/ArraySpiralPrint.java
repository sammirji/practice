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
			// Print top row
			for (int i=colIt; i<cols; ++i) {
				System.out.print(a[rowIt][i] + " ");
			}
			rowIt++;
			
			// Print last column
			for (int i=rowIt; i<rows; ++i) {
				System.out.print(a[i][cols-1] + " ");
			}
			cols--;
			
			// Print bottom row
			if (rowIt < rows) {
				for (int i=cols-1; i>=colIt; i--) {
					System.out.print(a[rows-1][i] + " ");
				}
				rows--;
			}
			
			// Print first column
			if (colIt < cols) {
				for (int i=rows-1; i>=rowIt; i--) {
					System.out.print(a[i][colIt] + " ");
				}
				colIt++;
			}
		}
	}
}
