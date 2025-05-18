package calculator;

public class DivideExpression extends BinaryExpression
   implements Expression
{
   public DivideExpression(final Expression lft, final Expression rht)
   {
      super(lft, rht, "/");
   }

   public double applyOperator(double lft, double rht){
      return lft / rht;
   }
}

