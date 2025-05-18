public class Main
{
    public static void main(String[] args)
    {
        node node1 = new node("5");
        node node2 = new node("10");

        node1.setNext(node2);
        System.out.println(node1.value);

        linkedList myList = new linkedList();
        myList.setHead(node1);
    }
}
