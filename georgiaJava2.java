import java.util.Scanner;
import java.util.Arrays;

public class georgiaJava2 {

    public static void main(String[] args) {
        /*double[] revenues = {150.00, 200.00, 154.98, 335.01, 475.12, 555.87, 216.38};
        selectionSort(revenues);*/
        /*int[] nums = {34, 2, 10, 6, 7, 5, 1, 5};
        bubbleSort(nums);*/
        int[] ages = {17, 21, 97, 66, 55, 30, 33, 45, 58, 67, 38, 39, 41, 19, 23};
        //insertionSort(ages);
        int[] selectedAges = insertionSort(ages);
        thirtyFortyCustomers(selectedAges);

    }
    /*This method performs selection sort on an array of doubles and outputs the largest value in that array.*/
    public static void selectionSort(double array1[]) {
        int len = array1.length;
        //double[] arrSorted = new double[len];
        //double largestValue = 0;
        for (int i = 0; i < len; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (array1[maxIndex] < array1[j]) {
                    maxIndex = j;

                    double temp = array1[maxIndex];
                    array1[maxIndex] = array1[i];
                    array1[i] = temp;
                }
            }
        }
        System.out.println("Largest value is: " + array1[0]);
    }
    /*This method takes in an array of integers as a parameter then performs the bubble sort method
    on the array to sort it in ascending order. It then asks the user to enter a number and checks
     if and how many times the number appears in the array.*/
    public static void bubbleSort(int array2[]) {

        int len = array2.length;

        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - 1; j++)
                if (array2[j] > array2[j + 1]) {
                    int temp = array2[j];
                    array2[j] = array2[j + 1];
                    array2[j + 1] = temp;

                }
        Scanner userNumber = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = userNumber.nextInt();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array2[i] == number) {
                count++;
            }
        }
        System.out.println("We found " + count + " counts of " + number + " in: " + Arrays.toString(array2));

    }
    //This method takes in an array of integers as a parameter and returns the array sorted in ascending order.
    public static int[] insertionSort(int[] array3) {
        int len = array3.length;
        for (int i = 1; i < len; i++) {
            int key = array3[i]; //initialising key to index i
            int j = i - 1;
            while (j >= 0 && array3[j] > key)//when j ==0 then the loop stops && key value is no longer smaller
            {
                array3[j + 1] = array3[j];
                j = j - 1;
            }
            array3[j + 1] = key;
        }
        return array3;
    }
    /*This method takes in an array of integers and outputs the array sorted in ascending order. If
    any of the integers are >= 30 and <= 49 they are added to a second array, which is also printed
     to the console.*/
    public static void thirtyFortyCustomers(int[] array4) {
        int len = array4.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array4[i] >= 30 && array4[i] <= 49) {
                count++;
            }
        }
        int[] thirty40 = new int[count];
        int newCount = 0;
        for (int i = 0; i < len; i++) {
            if (array4[i] >= 30 && array4[i] <= 49) {
                thirty40[newCount] = array4[i];
                newCount++;
            }
        }
        System.out.println("Sorted customer age list: " + Arrays.toString(array4));
        System.out.println("Customers aged 30-49: " + Arrays.toString(thirty40));
    }
}
