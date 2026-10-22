package androidx.constraintlayout.core.parser;

import a.a;
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
        if (this.mElements.size() <= 0) goto L5;
        this.mElements.set(0, r2);
        return;
    L5:
        this.mElements.add(r2);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int r6, int r7) {
        StringBuilder r0 = new StringBuilder(getDebugName());
        addIndent(r0, r6);
        String r1 = content();
        if (this.mElements.size() <= 0) goto L17;
        r0.append(r1);
        r0.append(": ");
        if (sections.contains(r1) == false) goto L8;
        r7 = 3;
    L8:
        if (r7 <= 0) goto L10;
        r0.append(this.mElements.get(0).toFormattedJSON(r6, r7 - 1));
    L15:
        return r0.toString();
    L10:
        String r2 = this.mElements.get(0).toJSON();
        if ((r2.length() + r6) >= CLElement.MAX_LINE) goto L13;
        r0.append(r2);
        goto L15
    L13:
        r0.append(this.mElements.get(0).toFormattedJSON(r6, r7 - 1));
        goto L15
    L17:
        return a.j(r1, ": <> ");
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (this.mElements.size() <= 0) goto L7;
        return getDebugName() + content() + ": " + this.mElements.get(0).toJSON();
    L7:
        return getDebugName() + content() + ": <> ";
    }

    public static CLElement allocate(String r3, CLElement r4) {
        CLKey r0 = new CLKey(r3.toCharArray());
        r0.setStart(0);
        r0.setEnd(r3.length() - 1);
        r0.set(r4);
        return r0;
    }
}
