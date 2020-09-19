import java.util.Arrays;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {

        System.out.println("Validate insertSorted method:");

        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 4, 6, 8, 10));
        LinkedListUtils.insertSorted(list1, 5);
        LinkedListUtils.insertSorted(list1, 3);
        LinkedListUtils.insertSorted(list1, 5);
        LinkedListUtils.insertSorted(list1, 9);
        LinkedListUtils.printlist1(list1);

//        papas = 112
//        casa = 99
//        marraqueta = 109
//        andamios = 97
//        entendimiento = 101

        System.out.println("Validate removeMaximumValues method:");

        LinkedList<String> list2 = new LinkedList<>(Arrays.asList("papas", "casa", "marraqueta", "andamios", "marraqueta","entendimiento", "papas", "papas"));
        LinkedListUtils.removeMaximumValues(list2, 2);
        LinkedListUtils.printlist2(list2);

        System.out.println("Validate containsSubsequence method:");

        LinkedList<Integer> list3 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10));

        LinkedList<Integer> list4 = new LinkedList<>(Arrays.asList(1, 2, 3, 4)); //true
        LinkedList<Integer> list5 = new LinkedList<>(Arrays.asList(6, 7, 5, 9)); //false
        LinkedList<Integer> list6 = new LinkedList<>(Arrays.asList(4, 5, 6, 7)); //true
        LinkedList<Integer> list7 = new LinkedList<>(Arrays.asList(7, 8, 9, 10)); //false
        LinkedList<Integer> list8 = new LinkedList<>(Arrays.asList(15, 24, 71, 87)); //false
        LinkedList<Integer> list9 = new LinkedList<>(); //false

        boolean validate = LinkedListUtils.containsSubsequence(list3, list4);
        System.out.println(validate);
        validate = LinkedListUtils.containsSubsequence(list3, list5);
        System.out.println(validate);
        validate = LinkedListUtils.containsSubsequence(list3, list6);
        System.out.println(validate);
        validate = LinkedListUtils.containsSubsequence(list3, list7);
        System.out.println(validate);
        validate = LinkedListUtils.containsSubsequence(list3, list8);
        System.out.println(validate);
        validate = LinkedListUtils.containsSubsequence(list9, list8);
        System.out.println(validate);
        validate = LinkedListUtils.containsSubsequence(list3, list9);
        System.out.println(validate);
    }
}