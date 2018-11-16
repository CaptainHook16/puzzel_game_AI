package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.println("hi");
        BufferedReader buff;

        try ( FileReader input_file = new FileReader(args[0])){
            buff = new BufferedReader(input_file);
            int count_lines=0;
            String read_line;
            //as long as we didnt read an empty line
            while ((read_line=buff.readLine()) != null){
                if (count_lines == 0){
                    //switch algo according to user input
                    System.out.println(Integer.valueOf(read_line.trim()));
                }
                else if (count_lines == 1){
                    System.out.println(Integer.valueOf(read_line.trim()));
                }else if ((count_lines == 2)){
                    System.out.println(Integer.valueOf(read_line.trim()));
                }
            }
        }
        catch (FileNotFoundException error){
            error.printStackTrace();
        }catch (IOException error){
            error.printStackTrace();
        }

    }
}
