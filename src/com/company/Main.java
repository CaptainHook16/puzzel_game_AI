package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //System.out.println("hi");
        BufferedReader buff;
        int pazzel_size = 0;
        int pazzel[][] = null;

        //set algo user choice
        Enum.Algorithm algo = null;//not define yet
        try (FileReader input_file = new FileReader(args[0])) {
            buff = new BufferedReader(input_file);
            int count_lines = 0;
            String read_line;
            //as long as we didnt read an empty line
            while ((read_line = buff.readLine()) != null) {
                if (count_lines == 0) {
                    //switch algo according to user input
                    System.out.println(Integer.valueOf(read_line.trim()));
                } else if (count_lines == 1) {
                    pazzel_size = Integer.valueOf(read_line.trim());
                    System.out.println(Integer.valueOf(read_line.trim()));
                } else if ((count_lines == 2)) {
                    pazzel = new int[pazzel_size][pazzel_size];

                    //System.out.println((read_line.trim()));
                    String s =read_line.trim();
                    initFirstPazelBoard(s,pazzel_size,pazzel);
                    System.out.println(Arrays.deepToString(pazzel));

                }
                count_lines++;
            }
        } catch (FileNotFoundException error) {
            error.printStackTrace();
        } catch (IOException error) {
            error.printStackTrace();
        }

        //create first board
        BoardGame first_board = new BoardGame(pazzel_size,pazzel,null,null);
        first_board.printBoard();


    }

    //static methods in Java can be called without creating an object of the class.
    // a program execution begins from main and no object has been created yet
    public static void initFirstPazelBoard(String pazelNumber, int size,int arr[][]) {
        //int[][] pazzel = new int[size][size];
        //Array.ConvertAll<string, int>(value.Split(','), Convert.ToInt32);
        List<String> nums = Arrays.asList(pazelNumber.split("-"));
        for (int i=0;i<size;++i){
            for (int j=0;j<size;++j){
                int pos = j+i*size;
                arr[i][j] = Integer.parseInt(nums.get(pos));
            }
        }

    }
}
