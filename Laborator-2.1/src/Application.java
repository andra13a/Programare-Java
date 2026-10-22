public class Application
{
    public static void main(String[] args)
    {
        MyList simpleList = new SimpleChainedList();
        for (int i = 1; i <= 10; i++) {
            simpleList.addValue(i);
        }

        simpleList.removeNodeByValue(4);
        simpleList.removeNodeByValue(6);
        simpleList.removeNodeByValue(8);
        simpleList.removeNodeByValue(10);

        System.out.print("Lista simplu inalantuita: ");
        simpleList.listNodes();
        System.out.println("Suma nodurilor din lista simplu inlantuita: " + sumNodes(simpleList));
        System.out.println("Lista simplu înlănțuită este sortata ? " + simpleList.isSorted());

        MyList doubleList = new DoubleChainedList();
        for (int i = 1; i <= 10; i++)
        {
            doubleList.addValue(i);
        }


        doubleList.removeNodeByValue(1);
        doubleList.removeNodeByValue(2);
        doubleList.removeNodeByValue(3);

        System.out.print("Lista dublu inlantuita: ");
        doubleList.listNodes();
        System.out.println("Suma nodurilor din lista dublu înlantuita: " + sumNodes(doubleList));
        System.out.println("Lista dublu înlănțuită este sortata? " + doubleList.isSorted());
    }
    private static int sumNodes(MyList list)
    {
        int sum = 0;
        for (int i = 1; i <= 10; i++)
        {
            if (list.getNodeByValue(i) != null)
            {
                sum += i;
            }
        }
        return sum;
    }
}
