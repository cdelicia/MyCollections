import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.TreeSet;

public class MyCollections {
    private static final int VARIETY = 70;
    private static final int SIZE = 20;
    public static final String RED_COLOR = "\033[1;31m";
    public static final String GREEN_COLOR = "\033[1;32m";
    private static final Collection<Integer> hashSet = new HashSet<>();
    private static final List<Integer> arrayList = new ArrayList<>();
    private static final Collection<Integer> treeSet = new TreeSet<>();


    public static void main(String[] args) {

        initializationOfHashSetByValues();
        printResult(hashSet, "Original HashSet in the very beginning", RED_COLOR);

        initializationOfArrayListByRandomValues();
        printResult(arrayList, "Original ArrayList in the very beginning", RED_COLOR);

        hashSet.addAll(arrayList);
        printResult(hashSet, "HashSet after merging with ArrayList", RED_COLOR);
        arrayList.clear();

        /**
         * First solution
         */
        Object[] newArray = hashSet.toArray();
        Arrays.sort(newArray);
        printResult(newArray);

        /**
         * Second solution
         */
        treeSet.addAll(hashSet);
        printResult(treeSet, "Solution #2: TreeSet after instantiation", GREEN_COLOR);
    }


    /**
     * Method Overloading
     */
    private static void printResult(Collection<Integer> collection, String comment, String color) {
        System.out.println(color + comment + ", size=" + collection.size() + "\033[0m");
        for (Integer element : collection)
            System.out.print(element + " ");
        System.out.println('\n');
    }

    private static void printResult(Object[] array) {
        System.out.println("\033[1;32mSolution #1: New array after sorting, size=" + array.length + "\033[0m");
        for (Object i : array)
            System.out.print(i + " ");
        System.out.println('\n');
    }


    private static void initializationOfArrayListByRandomValues() {
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            arrayList.add(random.nextInt(VARIETY));
        }
    }

    private static void initializationOfHashSetByValues() {
        for (int i = 95; i > 0; i -= 5) {
            hashSet.add(i);
        }
    }
}
