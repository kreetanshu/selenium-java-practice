package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDiff {
	
	static int getDiagonalDiff(List<List<Integer>> list) {
	   int leftDiagonal=0;
	   int rightDiagonal=0;
	   int m=list.size();
	   
	   //For diagonals the rule is i==j and i+j=m-1
	   for(int i=0;i<m;i++) {
		   leftDiagonal+=list.get(i).get(i);
		   rightDiagonal+=list.get(i).get(m-1-i);
	   }
	   System.out.println(leftDiagonal+""+rightDiagonal);
	   return Math.abs(leftDiagonal-rightDiagonal);
	}
	
	

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		//Watch the Array List declerations
		List<List<Integer>> matrix = new ArrayList<>();
		
		matrix.add(Arrays.asList(1,2,3));
		matrix.add(Arrays.asList(4,5,6));
		matrix.add(Arrays.asList(9,8,9));
		
		System.out.println(matrix);
		System.out.println(getDiagonalDiff(matrix));
	}

}
