package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CLKey extends CLContainer {
    private static ArrayList<String> sections;

    static {
        ArrayList<String> r0 = new ArrayList();
        sections = r0;
        r0.add("ConstraintSets");
        sections.add("Variables");
        sections.add("Generate");
        sections.add(TypedValues.TransitionType.NAME);
        sections.add("KeyFrames");
        sections.add(TypedValues.AttributesType.NAME);
        sections.add("KeyPositions");
        sections.add("KeyCycles");
    }

    public CLKey(char[] r1) {
        super(r1);
    }

    public static CLElement allocate(String r3, CLElement r4) {
        CLKey r0 = new CLKey(r3.toCharArray());
        r0.setStart(0);
        r0.setEnd(r3.length() - 1);
        r0.set(r4);
        return r0;
    }

    public static CLElement allocate(char[] r1) {
        return new CLKey(r1);
    }

    public String getName() {
        return content();
    }

    public CLElement getValue() {
        if (this.mElements.size() > 0) goto L5;
        return null;
    L5:
        return this.mElements.get(0);
    }

    public void set(CLElement r2) {
        int r0 = this.mElements.size();
        ArrayList<CLElement> r1 = this.mElements;
        if (r0 <= 0) goto L5;
        r1.set(0, r2);
        return;
    L5:
        r1.add(r2);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r6, int r7) {
        StringBuilder r0 = new StringBuilder(getDebugName());
        addIndent(r0, r6);
        String r1 = content();
        if (this.mElements.size() <= 0) goto L16;
        r0.append(r1);
        r0.append(": ");
        if (sections.contains(r1) == false) goto L8;
        r7 = 3;
    L8:
        if (r7 <= 0) goto L10;
    L9:
        r0.append(this.mElements.get(0).toFormattedJSON(r6, r7 - 1));
    L14:
        return r0.toString();
    L10:
        String r2 = this.mElements.get(0).toJSON();
        if ((r2.length() + r6) >= CLElement.MAX_LINE) goto L9;
        r0.append(r2);
        goto L14
    L16:
        return r1 + ": <> ";
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (this.mElements.size() <= 0) goto L7;
        StringBuilder r0 = new StringBuilder();
        r0.append(getDebugName());
        r0.append(content());
        r0.append(": ");
        String r2 = this.mElements.get(0).toJSON();
    L5:
        r0.append(r2);
        return r0.toString();
    L7:
        r0 = new StringBuilder();
        r0.append(getDebugName());
        r0.append(content());
        r2 = ": <> ";
        goto L5
    }
}
