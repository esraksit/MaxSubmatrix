import java.util.Scanner;

public class Submatrix {
	
	public static void main(String[] args) {
		
		
		System.out.println("Enter the number of rows in the matrix: ");
		Scanner scan = new Scanner(System.in);
		int rows= scan.nextInt();
		int [][] matrix = new int[rows][rows];
		
		System.out.println("Enter the matrix row by row: ");
		for(int i=0;i<rows;i++) {
			for(int j=0;j<rows;j++) {
				matrix[i][j]= scan.nextInt();				
			}			
		}
		
		 findLargestBlock(matrix);			
	}
	public static int[] findLargestBlock(int[][] matrix) {
		
		int [][] maxMatrix = new int[matrix.length][matrix.length];	
		int posX=0,posY=0,size=0;
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				if(i==0 || j==0) {
					maxMatrix[i][j]=matrix[i][j];
					
				}
				else  {
					maxMatrix[i][j]=matrix[i][j]+ Math.min(Math.min(maxMatrix[i][j-1],maxMatrix[i-1][j-1]),maxMatrix[i-1][j]);
				}
				if(maxMatrix[i][j]>=size) {
					size=maxMatrix[i][j];
						posX =i;
						posY=j;
							
				}				
			}
			}

		System.out.println("The maximum square submatrix is at (" + (posX-size+1) + ","+ ((posY-size+1) + ") with size	"+ size  ));	
		int []result= {(posX-size+1),(posY-size+1),size	};
		
		
		
		return result ;
	}
	
	
}
