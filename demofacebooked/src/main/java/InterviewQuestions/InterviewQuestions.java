package InterviewQuestions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InterviewQuestions {
    public static void main(String[] args) {
        List<String> list1 = List.of("A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N");
        List<String> list2 = List.of("1", "2", "3", "4");

        List<String> mergedList = mergeLists(list1, list2);

        // Print the merged list in the desired format
        printMergedList(mergedList);
    }

    private static List<String> mergeLists(List<String> list1, List<String> list2) {
        List<String> mergedList = new ArrayList<>();

        Iterator<String> iterator1 = list1.iterator();
        Iterator<String> iterator2 = list2.iterator();

        while (iterator1.hasNext() || iterator2.hasNext()) {
            StringBuilder mergedElement = new StringBuilder();

            if (iterator1.hasNext()) {
                mergedElement.append(iterator1.next());
            }

            if (iterator1.hasNext()) {
                mergedElement.append(",");
                mergedElement.append(iterator1.next());
            }

            if (iterator2.hasNext()) {
                mergedElement.append(",");
                mergedElement.append(iterator2.next());
            }

            mergedList.add(mergedElement.toString());
        }

        return mergedList;
    }

    private static void printMergedList(List<String> mergedList) {
        for (String element : mergedList) {
            System.out.println(element);
        }
    }
}
