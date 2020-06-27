package org.jwr.model;

/**
 *
 * @author yracnet
 */
@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Filter<T> {

    @lombok.Getter
    public static enum Expr {
        none("", -1),
        eq("=", 1),
        neq("!=", 1),
        lt("<", 1),
        lte("<=", 1),
        gt(">", 1),
        gte(">=", 1),
        like("like", 1),
        isNull("is null", 0),
        notNull("is not null", 0);

        private final String oper;
        private final int params;

        Expr(String oper, int params) {
            this.oper = oper;
            this.params = params;
        }

        public boolean isSkip() {
            return params == -1;
        }

    }

    private Expr expr;
    private T value;
    private T other;

    public Expr getExpr() {
        if (expr == null) {
            expr = Expr.none;
        }
        return expr;
    }

//    public boolean isWithParam() {
//        return expr != null && expr.isWithParam();
//    }
}
