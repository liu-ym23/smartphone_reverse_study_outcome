package com.obric.oui.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class KeyFrames {
    ArrayList<Keys> mKeys;

    public KeyFrames() {
        this.mKeys = new ArrayList();
    }

    public void add(Keys r1) {
        this.mKeys.add(r1);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.mKeys.isEmpty() == true) goto L10;
        r0.append("keyFrames:{\n");
        Iterator<Keys> r2 = this.mKeys.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r0.append(r2.next().toString());
        goto L6
    L8:
        r0.append("},\n");
    L10:
        return r0.toString();
    }
}
