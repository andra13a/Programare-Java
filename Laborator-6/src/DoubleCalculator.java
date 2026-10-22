class DoubleCalculator extends ACalculator<Double>
{
    public DoubleCalculator(Double initialValue)
    {
        super(initialValue);
    }

    protected Double init() {
        return 0.0;
    }

    public DoubleCalculator add(double value)
    {
        this.state += value;
        return this;
    }

    public DoubleCalculator subtract(double value)
    {
        this.state -= value;
        return this;
    }

    public DoubleCalculator multiply(double value)
    {
        this.state *= value;
        return this;
    }
}