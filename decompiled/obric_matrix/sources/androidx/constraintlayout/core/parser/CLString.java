package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class CLString extends CLElement {
    public CLString(char[] r1) {
        super(r1);
    }

    public static CLElement allocate(char[] r1) {
        return new CLString(r1);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r1, int r2) {
        StringBuilder r3 = new StringBuilder();
        addIndent(r3, r1);
        r3.append("'");
        r3.append(content());
        r3.append("'");
        return r3.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        return "'" + content() + "'";
    }
}
