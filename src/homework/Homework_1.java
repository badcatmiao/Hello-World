package homework;
import java.util.*;
 
public class Homework_1 {
	public static void main(String[] args) {
		int s=1;
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("方格的层数:");
		int n=input.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=s;
				s++;
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
