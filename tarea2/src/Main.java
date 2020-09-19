import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void printResult(Stack<HtmlTag> pila) {
        if (pila == null) {
            System.out.println("null return: bad format more close tags than open tags");
        } else {
            if (pila.size() > 0) {
                Iterator<HtmlTag> itr = pila.iterator();

                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
            } else {
                System.out.println("stack empty");
            }
        }
    }
    public static void main(String[] args) throws IOException {

        Queue<HtmlTag> cola1;
        Stack<HtmlTag> pila1;
        Queue<HtmlTag> cola2;
        Stack<HtmlTag> pila2;
        Queue<HtmlTag> cola3;
        Stack<HtmlTag> pila3;
        Queue<HtmlTag> cola4;
        Stack<HtmlTag> pila4;

        System.out.println("*****example1*********");

        cola1 = HtmlReader.getTagsFromHtmlFile("src/example1.html");
        pila1 = HtmlValidator.isValidHtml(cola1);
        printResult(pila1);

        System.out.println("*****example2*********");

        cola2 = HtmlReader.getTagsFromHtmlFile("src/example2.html");
        pila2 = HtmlValidator.isValidHtml(cola2);
        printResult(pila2);

        System.out.println("*****example3*********");

        cola3 = HtmlReader.getTagsFromHtmlFile("src/example3.html");
        pila3 = HtmlValidator.isValidHtml(cola3);
        printResult(pila3);

        System.out.println("*****example4*********");

        cola4 = HtmlReader.getTagsFromHtmlFile("src/example4.html");
        pila4 = HtmlValidator.isValidHtml(cola4);
        printResult(pila4);

    }
}