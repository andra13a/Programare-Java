abstract class ACalculator<T extends Number>
{
    protected T state;

    public ACalculator(T initialValue)
    {
        this.state = initialValue;
    }

    public T result()
    {
        return this.state;
    }

    public void clear()
    {
        this.state = init();
    }

    protected abstract T init();
}