import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LexPermute {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (input.hasNext()) {
            try {
                list.add(input.nextInt());
            } catch (NumberFormatException e) {
                System.err.println("Input list contains a non-number.");
                return;
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        //Array sortieren
        Arrays.sort(arr);

       // int k = Integer.parseInt(args[0]);

        printPermutations(arr, 0);


    }
    private static int printPermutations(int[] array, int festgelegt) {
        //break case fuer recursion
        if (array.length == (festgelegt + 1)) {
            System.out.println(Arrays.toString(array));
            return 1;
        } else {
            int sum = 0;

            // jedes permutation von festgelegt - array.length finden
            for (int i = festgelegt; i < array.length; i++) {
                //array[i] und array[festgelegt] werden vertauscht um ein neues permutation zu finden
                int temp = array[i];
                array[i] = array[festgelegt];
                array[festgelegt] = temp;
                int[] copy = new int[array.length];
                sum += printPermutations(array, festgelegt + 1);
                array[festgelegt] = array[i];
                array[i] = temp;

            }
            return sum;
        }
    }
}
