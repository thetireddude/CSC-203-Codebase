public class testMultiply
{
    public static void main(String[] args){
        linkedList list1 = new linkedList();
        list1.add(new node("8"));
        list1.add(new node("1"));
        list1.add(new node("*"));
        list1.add(new node("3"));
        list1.add(new node("1"));

        int result = BigNumArithmetic.multiply(list1);
        System.out.println(result);
    }
}
