import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class LexPermute
{

    static void swap(int[] str, int i, int j)
    {
        int t = str[i];
        str[i] = str[j];
        str[j] = t;
    }

    static void reverse(int str[], int l, int h)
    {
        while (l < h) {
            swap(str, l, h);
            l++;
            h--;
        }
    }


    static int findeKleinste(int str[], int first, int l,
                        int h)
    {
        int ceilIndex = l;

        // Now iterate through rest of the elements and find
        // the smallest character greater than 'first'
        for (int i = l + 1; i <= h; i++)
            if (str[i] > first && str[i] < str[ceilIndex])
                ceilIndex = i;

        return ceilIndex;
    }

    static int[] sortedPermutations(int str[], int k)
    {
        int size = str.length;

        int count = 1; //k kleinste permutation initializieren
        // array sortieren
        Arrays.sort(str);
        System.out.println("Sortiertes Array: " + Arrays.toString(str));

        boolean isFinished = false;
        while (!isFinished) {
            //wenn count ist gleich k array zuruck geben
            if(k == count){
                return str;
            }
            count++;

            // index von die kleinste Zahl finden
            int i;
            for (i = size - 2; i >= 0; --i) {
                if (str[i] < str[i + 1])
                    break;
            }

            // wenn i == -1 dann war k zu gross
            if (i == -1)
                isFinished = true;
            else {
                //kleinste zahl nach rechts finden
                int kleinste = findeKleinste(str, str[i], i + 1,
                        size - 1);

                //kleinste und i tauschen
                swap(str, i, kleinste);

                //rechts von i in die richtige reihen folge setzen
                reverse(str, i + 1, size - 1);
            }
        }
        return new int[] {};
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<Integer>();
        while (input.hasNext()) {
            try {
                list.add(input.nextInt());
            } catch (NumberFormatException e) {
                System.err.println("Input list contains a non-number.");
                return;
            }
        }
        int[]arr= new int[list.size()];
        for (int i=0; i<list.size(); i++){
            arr[i]=list.get(i);
        }
        int k = Integer.parseInt(args[0]);
        int[] smallest = sortedPermutations(arr, k);
        System.out.println(Arrays.toString(smallest) + " is the " + k + " kleinste Zahl");
    }
}