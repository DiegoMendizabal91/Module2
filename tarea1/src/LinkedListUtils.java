import java.util.LinkedList;

/**
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

	/**
	 * This method assumes the input LinkedList is already sorted in non-descending order (i.e.,such that each
	 * element is greater than or equal to the one that is before it, and inserts the input int value into the
	 * correct location of the list. Note that the method does not return anything, but rather modifies the
	 * input LinkedList as a side effect. If the input LinkedList is null, this method should simply terminate.
	 * @param list
	 * @param value
	 */
	public static void insertSorted(LinkedList<Integer> list, int value) {
		int cont = 0;
		int previousIndex = 0;

		for (Integer node : list) {
			if (value > node) {
				previousIndex = cont;
			}
			cont = cont + 1;
		}
		list.add(previousIndex + 1 , value);
	}

	/**
	 * This method removes all instances of the N largest values in the LinkedList. Because the values are Strings,
	 * you will need to use the String class’ compareTo method to find the largest elements; see the Java API for
	 * help with that method. If the input LinkedList is null or if N is non-positive, this method should simply
	 * return without any modifications to the input LinkedList. Keep in mind that if any of the N largest values
	 * appear more than once in the LinkedList, this method should return remove all instances, so it may remove
	 * more than N elements overall. The other elements in the LinkedList should not be modified and their order
	 * must not be changed.
	 * papas = 112
	 * casa = 99
	 * marraqueta = 109
	 * andamios = 97
	 * entendimiento = 101
	 * @param list
	 * @param N
	 */
	public static void removeMaximumValues(LinkedList<String> list, int N) {
		if (list != null && N > 0){
			String previous = "";
			int indexLargest = 0;

			for (int i = 0; i < N; i++) {
				int cont = 0;
				for (String node : list) {
					if (node.compareTo(previous) > 0){
						indexLargest = cont;
						previous = node;
					}
					cont = cont +1;
				}
				list.remove(indexLargest);
				for (String node : list) {
					if (node.equals(previous)){
						N = N +1;
						break;
					}
				}
				previous="";
			}
		}
	}

	/**
	 * This method determines whether any part of the first LinkedList contains all elements of the second
	 * in the same order with no other elements in the sequence, i.e. it should return true if the second
	 * LinkedList is a subsequence of the first, and false if it is not. The method should return false
	 * if either input is null or empty.
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		boolean validate = false;
		if(one != null && !(one.isEmpty()) && two != null && !(two.isEmpty())) {
			for (int i = 0; i < one.size(); i++) {
				int saveI = i;
				for (int j = 0; j < two.size(); j++) {
					int valOne = one.get(i);
					int valTwo = two.get(j);
					if (valOne == valTwo) {
						validate = true;
						i++;
					} else {
						validate = false;
						i = saveI;
						break;
					}
				}
				if (validate) {
					return true;
				}
			}
		}

		return false;
	}

	public static void printlist1(LinkedList<Integer> list) {
		for (Integer node : list) {
			System.out.println(node);
		}
	}

	public static void printlist2(LinkedList<String> list) {

		for (String node : list) {
			System.out.println(node);
		}
	}
}
