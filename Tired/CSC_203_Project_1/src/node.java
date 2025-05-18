public class node
{

    public String value;
    public node next;

    public node(String value)
    {
        this.value = value;
        this.next = null;
    }

    public void setNext(node next) {
        this.next = next;
    }

}


