
/**
 * Write a description of class trssssssst here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    public static void main()
    {
        Queue<Integer> queue1 = new Queue<Integer>();
        Queue<String> queue2 = new Queue<String>();
        queue1.add(8);
        queue1.add(18);
        queue2.add("abcde");
        System.out.println(queue1.peek());
        System.out.println(queue1.poll()/2);
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue2.poll().toUpperCase());
    }
}
