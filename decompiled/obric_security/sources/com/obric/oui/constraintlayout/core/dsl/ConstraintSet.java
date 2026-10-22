package com.obric.oui.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ConstraintSet {
    ArrayList<Constraint> mConstraints;
    ArrayList<Helper> mHelpers;
    private final String mName;

    public ConstraintSet(String r2) {
        this.mConstraints = new ArrayList();
        this.mHelpers = new ArrayList();
        this.mName = r2;
    }

    public void add(Constraint r1) {
        this.mConstraints.add(r1);
    }

    public void add(Helper r1) {
        this.mHelpers.add(r1);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.mName + ":{\n");
        if (this.mConstraints.isEmpty() == true) goto L9;
        Iterator<Constraint> r1 = this.mConstraints.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r0.append(r1.next().toString());
    L9:
        if (this.mHelpers.isEmpty() == true) goto L14;
        Iterator<Helper> r3 = this.mHelpers.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        r0.append(r3.next().toString());
    L14:
        r0.append("},\n");
        return r0.toString();
    }
}
