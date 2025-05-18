package calculator;

public class AddExpression extends BinaryExpression
   implements Expression
{

   public AddExpression(final Expression lft, final Expression rht)
   {
      super(lft, rht, "+");
   }

   public double applyOperator(double lft, double rht){
      return lft + rht;
   }
}
