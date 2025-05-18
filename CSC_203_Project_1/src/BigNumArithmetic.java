public class BigNumArithmetic {

    /**
     * The entry point of the program.
     * @param args Command line arguments. Should have exactly one argument: a file name.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Expected exactly 1 argument: a file name.");
        }
        String filePath = args[0];
        FileProcessor.processFile(filePath);
    }

    public static linkedList getLineList(String line){
        String trimmedLine = line.replaceAll("\\s+", "");
        String[] lineArray = trimmedLine.split("");

        linkedList lineList = new linkedList();
        int i;

        for(i = lineArray.length - 1; i > -1; i--){
            lineList.add(new node(lineArray[i]));
        }
        return lineList;
    }

    public static int multiply(linkedList LL){
        node current = LL.head;
        linkedList first = new linkedList();
        linkedList second = new linkedList();

        boolean afterOperator = false;

        while(current != null){
            if(!(current.value.equals("*")) && !afterOperator){
                second.add(new node(current.value));
            }
            else if(!(current.value.equals("*")) && afterOperator){
                first.add(new node(current.value));
            }
            else{
                afterOperator = true;
            }
            current = current.next;
        }

        int result = 0;
        int i, j;
        for(i = 0; i < second.length; i++){
            int x = 1;
            int temp = 0;
            int carry = 0;
            int temp_result = 0;
            for(j = 0; j < first.length; j++){

                temp = ((second.atIndex(i) * first.atIndex(j)) + carry) * x;
                carry = temp / (10 * x);

                if((j + 1) < first.length){
                    temp = temp % (10 * x);

                    if(x == 10){
                        temp = temp/10;
                    }
                    x = 1;

                    if(temp == 0){
                        x = 10;
                    }
                }
                else if(x == 10){
                    temp = temp/10;
                    x = 1;
                }

                int value3 = power(j);
                temp_result += temp * value3;
            }
            int value4 = power(i);
            result = result + (temp_result * value4);
        }
        return result;
    }

    public static int myAdd(linkedList list){
        node current = list.head;
        linkedList first = new linkedList();
        linkedList second = new linkedList();

        boolean afterOperator = false;

        while(current != null){
            if(!(current.value.equals("+")) && !afterOperator){
                second.add(new node(current.value));
            }
            else if(!(current.value.equals("+")) && afterOperator){
                first.add(new node(current.value));
            }
            else{
                afterOperator = true;
            }
            current = current.next;
        }

        if(first.length > second.length) {
            int difference = first.length - second.length;
            int i;
            for (i = 0; i < difference; i++) {
                second.addBehind("0");
            }
        }
        else if(first.length < second.length){
            int difference = second.length - first.length;
            int i;
            for (i = 0; i < difference; i++) {
                first.addBehind("0");
            }
        }

        int result = 0;
        int temp_result = 0;
        int carry = 0;
        int k;
        for(k = 0; k < first.length; k++){
            int value1 = first.atIndex(k);
            int value2 = second.atIndex(k);

            int temp = first.atIndex(k) + second.atIndex(k) + carry;
            carry = temp / 10;
            temp_result += (temp % 10) * power(k);
        }
        result = temp_result + (carry * power(k));

        return result; //temp_result;
    }

    public static int exponentiate(linkedList list){

        node current = list.head;
        linkedList first = new linkedList();
        linkedList second = new linkedList();

        boolean afterOperator = false;
        while(current != null){
            if(!(current.value.equals("^")) && !afterOperator){

                first.add(new node(current.value));
            }
            else if(!(current.value.equals("^")) && afterOperator){
                second.add(new node(current.value));
            }
            else{
                afterOperator = true;
            }
            current = current.next;
        }

        int one = 1;
        int two = 1;
        int firstNum = 0;
        int secondNum = 0;

        node digit = first.head;
        while(digit != null){
            firstNum += Integer.parseInt(digit.value) * one;
            one *= 10;
            digit = digit.next;
        }
        digit = second.head;
        while(digit != null){
            secondNum += Integer.parseInt(digit.value) * two;
            two *= 10;
            digit = digit.next;
        }

        if(secondNum % 2 == 0){
            // (x ^2) ^ (n / 2);

            linkedList temp1 = new linkedList();
            temp1.add(new node(Integer.toString(firstNum)));
            temp1.add(new node("*"));
            temp1.add(new node(Integer.toString(firstNum)));

            int firstSquared = multiply(temp1);

            int count = secondNum / 2;
            int power = firstSquared;
            int i;

            for(i = 1; i < count; i++){
                linkedList temp2 = new linkedList();
                temp2.add(new node(Integer.toString(firstSquared)));
                temp2.add(new node("*"));
                temp2.add(new node(Integer.toString(power)));

                power = multiply(temp2);
            }
            return power;
        }
        else{
            // x ((x ^2) ^ (n-1 / 2));
            linkedList temp3 = new linkedList();
            temp3.add(new node(Integer.toString(firstNum)));
            temp3.add(new node("*"));
            temp3.add(new node(Integer.toString(firstNum)));

            int firstSquared = multiply(temp3);

            int count = (secondNum-1) / 2;
            int power = firstSquared;
            int i;

            for(i = 1; i < count; i++){
                linkedList temp2 = new linkedList();
                temp2.add(new node(Integer.toString(firstSquared)));
                temp2.add(new node("*"));
                temp2.add(new node(Integer.toString(power)));

                power = multiply(temp2);
            }
            power *= firstNum;
            return power;
        }
    }

    public static String checkOperator(linkedList list){
        String output = "";
        node head = list.head;
        while(head != null){
            output += head.value;
            head = head.next;
        }
        output += " = ";

        String element = "";
        node current = list.head;

        while(current != null){
            if(current.value.equals("+") | current.value.equals("*") | current.value.equals("^")){
                element = current.value;
                break;
            }
            current = current.next;
        }
        switch(element) {
            case "+":
                int result_add = myAdd(list);
                output += result_add;
                return output;
            case "*":
                int result_multiply = multiply(list);
                output += result_multiply;
                return output;
            case "^":
                int result_power = exponentiate(list);
                output += result_power;
                return output;
        }
        return "failed";
    }

    public static int power(int value){
        int i;
        int result = 1;
        for(i = 0; i < value; i++){
            result *= 10;
        }
        return result;
    }
}