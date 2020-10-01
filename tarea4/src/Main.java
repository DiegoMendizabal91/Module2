public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> arbol = new BinarySearchTree<>();
        arbol.add(8);
        arbol.add(6);
        arbol.add(4);
        arbol.add(2);
        arbol.add(16);
        arbol.add(20);
        arbol.add(10);
        arbol.add(9);
        arbol.add(12);


        BinarySearchTree<Integer> arbolBalanced = new BinarySearchTree<>();
        arbolBalanced.add(8);
        arbolBalanced.add(4);
        arbolBalanced.add(6);
        arbolBalanced.add(2);
        arbolBalanced.add(16);
        arbolBalanced.add(20);
        arbolBalanced.add(10);
        arbolBalanced.add(9);
        arbolBalanced.add(12);

//         Find node Test
        System.out.println("Find Node test:");
        try {
            int prueba = (arbol.findNode(20)).value;
            System.out.println(prueba);

        } catch (NullPointerException e) {
            System.out.println("es null");
        }

        try {
            int prueba = (arbol.findNode(13)).value;
            System.out.println(prueba);

        } catch (NullPointerException e) {
            System.out.println("es null");
        }

        // Depth Test

        System.out.println("Depth test:");

        int pruebaDepht = arbol.depth(9);
        System.out.println(pruebaDepht);

        // Height Test

        System.out.println("Height test:");

        int pruebaHeight = arbol.height(16);
        System.out.println(pruebaHeight);

        int pruebaHeight1 = arbol.height(17);
        System.out.println(pruebaHeight1);

        // is balanced(node) test
        System.out.println("is balanced(node) test:");
        BinarySearchTree.Node node = arbol.findNode(6);
        System.out.println(arbol.isBalanced(node));

        BinarySearchTree.Node node1 = arbol.findNode(16);
        System.out.println(arbol.isBalanced(node1));

        // is balanced() test
        System.out.println("is balanced() test:");

        System.out.println(arbol.isBalanced());
        System.out.println(arbolBalanced.isBalanced());
    }
}
