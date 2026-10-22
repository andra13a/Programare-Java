public class DoubleChainedList implements MyList
{
    private DoubleChainedNode head;

    @Override
    public void addValue(int value)
    {
        DoubleChainedNode newNode = new DoubleChainedNode(value);
        if (head == null)
        {
            head = newNode;
        } else
        {
            DoubleChainedNode temp = head;
            while (temp.getNextNode() != null)
            {
                temp = temp.getNextNode();
            }
            temp.setNextNode(newNode);
            newNode.setPrevNode(temp);
        }
    }

    @Override
    public void listNodes()
    {
        DoubleChainedNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNextNode();
        }
        System.out.println();
    }

    @Override
    public Node getNodeByValue(int value)
    {
        return null;
    }

    @Override
    public void removeNodeByValue(int value)
    {

    }

    @Override
    public boolean isSorted()
    {
        DoubleChainedNode temp = head;
        while (temp != null && temp.getNextNode() != null)
        {
            if (temp.getValue() > temp.getNextNode().getValue())
            {
                return false;
            }
            temp = temp.getNextNode();
        }
        return true;
    }
}
