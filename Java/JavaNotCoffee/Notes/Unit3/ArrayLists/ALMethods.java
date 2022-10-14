import java.util.ArrayList;
public class ALMethods {
    public static void main(String[] args) {
        //1,5,9,7,4,8,2,3,6,0,9
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        int[] ia = {1,5,9,7,4,8,2,3,6,0,9};
        arrList=createArrayList(ia);
        System.out.println(arrList);

        arrList=removeDuplicates(arrList);

        System.out.println(arrList);
    }

    public static ArrayList<Integer> createArrayList(int[] iarr) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < iarr.length; i++) {
            arrList.add(iarr[i]);
        }
        return arrList;
    }

    public static int maxIntAL(ArrayList<Integer> al) {
        int max = Integer.MIN_VALUE;
        
        for (int i =0; i < al.size(); i++) {
            if (max < al.get(i)) {
                max = al.get(i);
            }
        }

        return max;
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> al) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i =0; i<al.size(); i++) {
            if (!arrList.contains(al.get(i))) {
                arrList.add(al.get(i));
            }
        }

        return arrList;
    }

    public static int count(ArrayList<Integer> arrList, int item){
        int count = 0;
        for(int i=0;i<arrList.size();i++){
            if(item == arrList.get(i)){
                count+=1;
            }
        } 
        return count;

    public static int mode(ArrayList<Integer> al) {
        ArrayList<Integer> uniqueList = new ArrayList<Integer>();
        uniqueList = removeDuplicates(al);

        ArrayList<Integer> countList = new ArrayList<Integer>();
        countList = createArrayList(new int[uniqueList.size()]);

        for (int n: uniqueList) {
            int c = count(al, n);
            countList.set(uniqueList.indexOf(n)+1, c);
        }

        int modeValue = maxIntAL(al);

        int mode = uniqueList.get(countList.get(modeValue));



        return mode;
    }
}