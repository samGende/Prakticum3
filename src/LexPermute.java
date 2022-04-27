import java.util.Arrays;

class LexPermute
{

    // A utility function two swap two characters a and b
    static void swap(int[] str, int i, int j)
    {
        int t = str[i];
        str[i] = str[j];
        str[j] = t;
    }

    // A utility function to reverse a string str[l..h]
    static void reverse(int str[], int l, int h)
    {
        while (l < h) {
            swap(str, l, h);
            l++;
            h--;
        }
    }

    // This function finds the index of the smallest
    // character which is greater than 'first' and is
    // present in str[l..h]
    static int findCeil(int str[], int first, int l,
                        int h)
    {
        // initialize index of ceiling element
        int ceilIndex = l;

        // Now iterate through rest of the elements and find
        // the smallest character greater than 'first'
        for (int i = l + 1; i <= h; i++)
            if (str[i] > first && str[i] < str[ceilIndex])
                ceilIndex = i;

        return ceilIndex;
    }

    // Print all permutations of str in sorted order
    static int[] sortedPermutations(int str[], int k)
    {
        // Get size of string
        int size = str.length;

        int count = 1;
        // Sort the string in increasing order
        Arrays.sort(str);

        // Print permutations one by one
        boolean isFinished = false;
        while (!isFinished) {
            // print this permutation
            if(k == count){
                return str;
            }
            count++;

            // Find the rightmost character which is
            // smaller than its next character.
            // Let us call it 'first char'
            int i;
            for (i = size - 2; i >= 0; --i)
                if (str[i] < str[i + 1])
                    break;

            // If there is no such character, all are
            // sorted in decreasing order, means we
            // just printed the last permutation and we are
            // done.
            if (i == -1)
                isFinished = true;
            else {
                // Find the ceil of 'first char' in
                // right of first character.
                // Ceil of a character is the smallest
                // character greater than it
                int ceilIndex = findCeil(str, str[i], i + 1,
                        size - 1);

                // Swap first and second characters
                swap(str, i, ceilIndex);

                // reverse the string on right of 'first
                // char'
                reverse(str, i + 1, size - 1);
            }
        }
        return new int[] {};
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        int[] arr = new int[] {1, 2, 3, 4};
        int[] smallest = sortedPermutations(arr, 4);
        System.out.println(Arrays.toString(smallest));
    }
}