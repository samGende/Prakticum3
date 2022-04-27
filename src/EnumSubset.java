import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class EnumSubset {
    public static void main(String[] args) {
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
        System.out.println("Befor removing duplicates: "+Arrays.toString(arr));
        int dupend =removeDuplicates(arr);
        System.out.print("After removing Duplicates: [");
        for(int i=0; i<dupend; i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("]");
        System.out.println("Array:"+Arrays.toString(arr));
      //  int k = Integer.parseInt(args[0]);
        int[] data = new int[3];
        int a = findSubsets(arr, data, 3, dupend -1, 0, 0);
        System.out.println(a);

    }
    public static int removeDuplicates(int [] data){
        Arrays.sort(data);
        int swap ;
        int i=0;
        if(data.length>1){
            for(int j=1;j<data.length;j++){
                if(data[i]<data[j]){
                    swap=data[i+1];
                    data[i+1]= data[j];
                    data[j]=swap;
                    i++;
                }
            }
        }
        return i+1;
    }
    static int findSubsets(int[] arr,int[] data, int k, int end, int dataIndex, int arrIndex){
        if(dataIndex==k) {
            System.out.println(Arrays.toString(data));
            return 1;
        }
        else{
                if(arrIndex<=end) {


                    data[dataIndex] = arr[arrIndex];
                    return findSubsets(arr, data, k, end, dataIndex + 1, arrIndex + 1) + findSubsets(arr, data, k, end, dataIndex, arrIndex + 1);
                }
                return 0;
        }
        }}


