public class linkedList
{
    node head;
    int length;

    linkedList()
    {
        this.head = null;
        this.length = 0;
    }

    public void setHead(node head)
    {
        this.head = head;
    }

    public int add(node node){
        if(this.head == null){
            this.setHead(node);
            length++;
            return 0;
        }
        node old_head = this.head;
        this.head = node;
        this.head.next = old_head;
        this.length++;

        return 0;
    }

    public int addBehind(String value){
        if(this.head == null){
            this.setHead(new node(value));
            length++;
            return 0;
        }
        node current = this.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new node(value);
        this.length++;

        return 0;
    }

    public node pop(){
        node remove = this.head;
        this.head = this.head.next;
        this.length--;
        return remove;
    }

    public linkedList clone(){
        node current = this.head;
        linkedList newList = new linkedList();
        while(current != null){
            newList.addBehind(current.value);
            current = current.next;
        }
        return newList;
    }

    public void printList(){
        node current = this.head;
        String result = "";
        while(current != null){
            result += "[" + current.value + "]";
            current = current.next;
        }
        System.out.println(result);
    }

    public int atIndex(int index){
        int count = 0;
        node current = this.head;
        while(current != null){
            if(count == index){
                return Integer.parseInt(current.value);
            }
            count++;
            current = current.next;
        }
        return 0;
    }

}
