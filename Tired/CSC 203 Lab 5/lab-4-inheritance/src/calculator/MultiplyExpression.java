package calculator;
public class MultiplyExpression extends BinaryExpression
   implements Expression
{
   public MultiplyExpression(final Expression lft, final Expression rht)
   {
      super(lft, rht, "*");
   }

   public double applyOperator(double lft, double rht){
      return lft * rht;
   }
}

