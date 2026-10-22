package androidx.constraintlayout.core.parser;

import java.util.Iterator;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] r1) {
        super(r1);
    }

    public static CLElement allocate(char[] r1) {
        return new CLArray(r1);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        StringBuilder r0 = new StringBuilder(getDebugName() + "[");
        boolean r1 = true;
        int r3 = 0;
    L4:
        if (r3 >= this.mElements.size()) goto L10;
        if (r1 == true) goto L7;
        r0.append(", ");
    L8:
        r0.append(this.mElements.get(r3).toJSON());
        r3 = r3 + 1;
        goto L4
    L7:
        r1 = false;
        goto L8
    L10:
        return r0 + "]";
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r8, int r9) {
        StringBuilder r0 = new StringBuilder();
        String r1 = toJSON();
        if (r9 <= 0) goto L5;
    L7:
        r0.append("[\n");
        Iterator<CLElement> r2 = this.mElements.iterator();
        boolean r3 = true;
    L9:
        if (r2.hasNext() == false) goto L15;
        CLElement r4 = r2.next();
        if (r3 == true) goto L13;
        r0.append(",\n");
    L14:
        addIndent(r0, BASE_INDENT + r8);
        r0.append(r4.toFormattedJSON(BASE_INDENT + r8, r9 - 1));
        goto L9
    L13:
        r3 = false;
        goto L14
    L15:
        r0.append(IOUtils.LINE_SEPARATOR_UNIX);
        addIndent(r0, r8);
        r0.append("]");
    L17:
        return r0.toString();
    L5:
        if ((r1.length() + r8) >= MAX_LINE) goto L7;
        r0.append(r1);
        goto L17
    }
}
