class NewIntCalculator extends ACalculator<Integer>
{
    public NewIntCalculator(Integer initialValue)
    {
        super(initialValue);
    }

    protected Integer init()
    {
        return 0;
    }

    public NewIntCalculator add(int value)
    {
        this.state += value;
        return this;
    }

    public NewIntCalculator subtract(int value)
    {
        this.state -= value;
        return this;
    }

    public NewIntCalculator multiply(int value)
    {
        this.state *= value;
        return this;
    }
}