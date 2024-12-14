package h07.Peano;

public class PeanoAddExpression implements PeanoArithmeticExpression {

    @Override
    public PeanoNumberExpression evaluate(PeanoNumberExpression left, PeanoNumberExpression right) {

        return () -> {
            return add(left.evaluate(), right.evaluate());
        };

    }

    private NaturalNumber add(NaturalNumber left, NaturalNumber right) {
        if (right instanceof Zero) {
            // a + Z = a
            return left;
        } else if (right instanceof Successor) {
            // a + S(b) = S(a + P(b))
            NaturalNumber predecessor = ((Successor) right).predecessor;
            return new Successor(add(left, predecessor));
        }

        return null;
    }
}
