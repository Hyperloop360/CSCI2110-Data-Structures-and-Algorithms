import java.io.*;
import java.util.*;
public class Merge {

    /* METHOD 1:
    Input arguments are two ordered lists; the method creates and
    returns a new list that contains the merger of list1 and list2, using the two-finger walking algorithm.
    */
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> result = new OrderedList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            T a = list1.get(i);
            T b = list2.get(j);

            int cmp = a.compareTo(b);

            if (cmp == 0) { // same → add one, move both
                result.add(a);
                i++;
                j++;
            } else if (cmp < 0) {
                result.add(a);
                i++;
            } else {
                result.add(b);
                j++;
            }
        }

        // append leftovers
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }

    /* METHOD 2:
     Input arguments are two ordered lists; the method creates and returns a new list
     that contains the common items in list1 and list2.
     */
    public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> result = new OrderedList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            T a = list1.get(i);
            T b = list2.get(j);

            int cmp = a.compareTo(b);

            if (cmp == 0) { // only add when equal
                result.add(a);
                i++;
                j++;
            } else if (cmp < 0) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    /* METHOD 3:
     Input arguments are two ordered lists; the method creates and returns a new list
     that contains the items in list1 but not in list2.
     */
    public static <T extends Comparable<T>> OrderedList<T> difference(OrderedList<T> list1, OrderedList<T> list2) {
        OrderedList<T> result = new OrderedList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            T a = list1.get(i);
            T b = list2.get(j);

            int cmp = a.compareTo(b);

            if (cmp == 0) { // same → skip
                i++;
                j++;
            } else if (cmp < 0) {
                result.add(a); // item in list1 not in list2
                i++;
            } else {
                j++;           // list2 element is smaller; move j forward
            }
        }

        // remaining items in list1 that were not in list2
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        // ---- Read RandomNames.txt into an ArrayList ----
        Scanner fileScanner = new Scanner(new File("A4\\src\\RandomNames.txt"));
        ArrayList<String> allNames = new ArrayList<>();

        while (fileScanner.hasNextLine()) {
            allNames.add(fileScanner.nextLine().trim());
        }
        fileScanner.close();

        Scanner kb = new Scanner(System.in);

        // --- create list1 ---
        System.out.print("Enter size for list1 (1000–1500): ");
        int n1 = kb.nextInt();

        OrderedList<String> list1 = new OrderedList<>();
        Collections.shuffle(allNames);
        HashSet<String> used1 = new HashSet<>();

        int index1 = 0;
        while (list1.size() < n1 && index1 < allNames.size()) {
            String name = allNames.get(index1++);
            if (!used1.contains(name)) {
                list1.insert(name);
                used1.add(name);
            }
        }

        // --- create list2 ---
        System.out.print("Enter size for list2 (1000–1500): ");
        int n2 = kb.nextInt();

        OrderedList<String> list2 = new OrderedList<>();
        Collections.shuffle(allNames);
        HashSet<String> used2 = new HashSet<>();

        int index2 = 0;
        while (list2.size() < n2 && index2 < allNames.size()) {
            String name = allNames.get(index2++);
            if (!used2.contains(name)) {
                list2.insert(name);
                used2.add(name);
            }
        }

        // ---- Perform operations ----
        OrderedList<String> merged = merge(list1, list2);
        OrderedList<String> commonList = common(list1, list2);
        OrderedList<String> diffList = difference(list1, list2);

        // ---- Write output files ----
        writeToFile("merged.txt", merged);
        writeToFile("common.txt", commonList);
        writeToFile("difference.txt", diffList);

        System.out.println("Files written: merged.txt, common.txt, difference.txt");
    }

    // helper to write lists to text files
    private static void writeToFile(String filename, OrderedList<String> list) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(filename));
        for (int i = 0; i < list.size(); i++) {
            pw.println(list.get(i));
        }
        pw.close();
    }



}