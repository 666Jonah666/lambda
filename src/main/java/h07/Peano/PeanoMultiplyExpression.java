package h07.Peano;

public class PeanoMultiplyExpression implements PeanoArithmeticExpression {

    @Override
    public PeanoNumberExpression evaluate(PeanoNumberExpression left, PeanoNumberExpression right) {
        return () -> multiply(left.evaluate(), right.evaluate());
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

    private NaturalNumber multiply(NaturalNumber left, NaturalNumber right) {
        if (right instanceof Zero) {
            return new Zero();
        } else if (right instanceof Successor) {
            return add(left, multiply(left, ((Successor) right).predecessor));
        }

        return null;
    }
}
