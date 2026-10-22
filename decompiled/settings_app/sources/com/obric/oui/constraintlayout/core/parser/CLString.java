package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes4.dex */
public class CLString extends CLElement {
    public CLString(char[] r1) {
        super(r1);
    }

    public static CLElement allocate(char[] r1) {
        return new CLString(r1);
    }

    public static CLString from(String r3) {
        CLString r0 = new CLString(r3.toCharArray());
        r0.setStart(0);
        r0.setEnd(r3.length() - 1);
        return r0;
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        return "'" + content() + "'";
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r1, int r2) {
        StringBuilder r3 = new StringBuilder();
        addIndent(r3, r1);
        r3.append("'");
        r3.append(content());
        r3.append("'");
        return r3.toString();
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CLString) == false) goto L11;
        if (content().equals(((CLString) r4).content()) == false) goto L11;
        return true;
    L11:
        return super.equals(r4);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return super.hashCode();
    }
}
