import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator.StreamableGenerator;

import javax.print.event.PrintEvent;

import java.io.File;
import java.io.FileNotFoundException;

public class BubbleSort {

    public static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            Random random = new Random();
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String fileName) throws Exception {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (int a : array) {
                fileWriter.write(a + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An IOExpection has been encountered");
            e.printStackTrace();
        }

    }

    public static int[] readArrayFromFile(String fileName) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                int a = Integer.parseInt(str);
                arrayList.add(a);
            }
            int[] array = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                array[i] = (int) arrayList.get(i);
            }
            scanner.close();
            return array;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void bubleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1])
                    ;
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            printArray(array);
        }
    }

    public static void main(String[] args) throws Exception {
        String answer;
        String yes = "Yes"; 
        String no = "No";
        String str; 
        String fileName; 
         
        Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to use a file? Please answer Yes or No.");
     
            while (true) {
             answer = scanner.nextLine(); 
             if (answer.equals("No")){
                System.out.println("Would you like to randomly sort an array? Please input Yes or No.");
                System.out.println("Type EXIT to leave.");
                 String randomArrayAnswer; 
                Scanner scanner3 = new Scanner(System.in); 
                        randomArrayAnswer = scanner3.nextLine();
                        scanner3.close(); 
                        while (true) {
                            if (randomArrayAnswer.equals("Yes")){
                                int arrayLength = 5;
                                int[] array = createRandomArray(arrayLength);
                                printArray(array);
                                bubleSort(array);
                                System.out.println("Thank you! Have a nice day!");
                                break;
                            }
                            if (randomArrayAnswer.equals("EXIT")){
                                System.out.println("Thank you! Have a nice day!");
                                break; 
                            }
                                if (randomArrayAnswer.equals("No")){
                                    System.out.println("Have a nice day!");
                                    break;
                                } else {
                                        System.out.println("Your input it invaild please try again. ");
                                        break; 
                                    }
                                

                                
                            }
                        }
               
                 

         if (answer.equals("Yes")){
            Scanner scanner2 = new Scanner(System.in); 
            System.out.println("Please input a filename"); 
            fileName = scanner.nextLine(); 
            int [] array = readArrayFromFile(fileName); 
            printArray(array); 
            bubleSort(array);
            writeArrayToFile(array, "sorted.txt");
            scanner2.close(); 
            System.out.println("Thank you have a nice day"); 
            break;
            
        } else {
            scanner.close(); 
                 break; 
            
        }
        
        } 
         
         
        }
    

            
        

       
        
         
        
        

        

    }

