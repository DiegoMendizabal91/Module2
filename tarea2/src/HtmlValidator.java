import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
        Stack<HtmlTag> pilaOpen = new Stack<HtmlTag>();
        Queue<HtmlTag> colaClose = new LinkedList<HtmlTag>();

        Iterator<HtmlTag> itr = tags.iterator();

        while (itr.hasNext()) {

            HtmlTag tag = tags.poll();

            if(tag.isOpenTag()) {

                pilaOpen.push(tag);
            }else {
                colaClose.add(tag);
            }
        }

        Iterator<HtmlTag> itrOpen = pilaOpen.iterator();
        Iterator<HtmlTag> itrClose = colaClose.iterator();

        while (itrOpen.hasNext() && itrClose.hasNext()) {
            HtmlTag tagClose = colaClose.poll();
            if (!(tagClose.isSelfClosing())){
                HtmlTag tagOpen = pilaOpen.pop();

                if (!(tagOpen.matches(tagClose))) {
                    pilaOpen.push(tagOpen);
                    return pilaOpen;
                }
            }
        }

        if (!(colaClose.isEmpty())){
            return null;
        }

		/* IMPLEMENT THIS METHOD! */
		
		return pilaOpen; // this line is here only so this code will compile if you don't modify it
	}
	

}

