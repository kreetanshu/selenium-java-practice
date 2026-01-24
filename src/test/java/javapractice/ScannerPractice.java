package javapractice;

import java.util.ArrayList;
import java.util.Scanner;


//Reference to this problem https://www.hackerrank.com/challenges/java-arraylist/problem
public class ScannerPractice {
    static ArrayList<ArrayList<Integer>> getData(){
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        ArrayList<Integer> line = new ArrayList<>();
        System.out.println("Enter the lines");
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();

        while(lines>0){
            sc.nextLine();
            line.clear();
            System.out.println("Enter number of elements in line");
            int elements = sc.nextInt();
            for(int i=0;i<elements;i++){
                int num= sc.nextInt();
                line.add(num);
            }
            data.add(line);
            lines--;
        }
        return data;
    }

    static ArrayList<String> checkData(ArrayList<ArrayList<Integer>> data) {
        ArrayList<String> results = new ArrayList<>();
        System.out.println("Enter total query lines");
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();

        while (lines > 0) {
            sc.nextLine();
            System.out.println("Enter the line followed by space the index of element");
            int line = sc.nextInt();
            int index = sc.nextInt();
            try {
                results.add(String.valueOf(data.get(line).get(index)));
            } catch (Exception e) {
                results.add("ERROR!");
            }
            lines--;
        }
        return results;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> data = getData();
        System.out.println(data);

        ArrayList<String> result = checkData(data);
        System.out.println(result);
    }
    
}
