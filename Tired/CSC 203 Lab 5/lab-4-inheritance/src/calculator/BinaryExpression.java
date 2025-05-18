package calculator;

public abstract class BinaryExpression implements Expression {

    private final Expression lft;
    private final Expression rht;
    private final String operator;

    public BinaryExpression(final Expression lft, final Expression rht, final String operator)
    {
        this.lft = lft;
        this.rht = rht;
        this.operator = operator;
    }

    public String toString()
    {
        return "(" + lft + " " + operator + " " + rht + ")";
    }

    public double evaluate(final Bindings bindings)
    {
        return applyOperator(lft.evaluate(bindings), rht.evaluate(bindings));
    }

    protected abstract double applyOperator(double lft, double rht);
}
