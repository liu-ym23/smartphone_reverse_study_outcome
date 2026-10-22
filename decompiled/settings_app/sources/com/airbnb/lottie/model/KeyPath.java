package com.airbnb.lottie.model;

import com.android.settings.ApnEditor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KeyPath {
    private final List<String> keys;
    private KeyPathElement resolvedElement;

    public KeyPath(String... r1) {
        this.keys = Arrays.asList(r1);
    }

    private KeyPath(KeyPath r3) {
        this.keys = new ArrayList(r3.keys);
        this.resolvedElement = r3.resolvedElement;
    }

    public KeyPath addKey(String r2) {
        KeyPath r0 = new KeyPath(this);
        r0.keys.add(r2);
        return r0;
    }

    public KeyPath resolve(KeyPathElement r2) {
        KeyPath r0 = new KeyPath(this);
        r0.resolvedElement = r2;
        return r0;
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public boolean matches(String r4, int r5) {
        if (isContainer(r4) == false) goto L6;
        return true;
    L6:
        if (r5 < this.keys.size()) goto L9;
        return false;
    L9:
        if (this.keys.get(r5).equals(r4) == false) goto L11;
    L16:
        return true;
    L11:
        if (this.keys.get(r5).equals("**") == true) goto L16;
        if (this.keys.get(r5).equals(ApnEditor.APN_TYPE_ALL) == true) goto L16;
        return false;
    }

    public int incrementDepthBy(String r4, int r5) {
        if (isContainer(r4) == false) goto L6;
        return 0;
    L6:
        if (this.keys.get(r5).equals("**") == true) goto L9;
        return 1;
    L9:
        if (r5 != (this.keys.size() - 1)) goto L12;
        return 0;
    L12:
        if (this.keys.get(r5 + 1).equals(r4) == false) goto L15;
        return 2;
    L15:
        return 0;
    }

    public boolean fullyResolvesTo(String r6, int r7) {
        if (r7 < this.keys.size()) goto L6;
        return false;
    L6:
        if (r7 != (this.keys.size() - 1)) goto L8;
        boolean r0 = true;
    L9:
        String r3 = this.keys.get(r7);
        if (r3.equals("**") == false) goto L12;
        if (r0 == false) goto L28;
    L30:
        boolean r4 = false;
    L31:
        if (r4 == true) goto L33;
        if (r0 == false) goto L42;
        return true;
    L42:
        int r8 = r7 + 1;
        if (r8 >= (this.keys.size() - 1)) goto L46;
        return false;
    L46:
        return this.keys.get(r8).equals(r6);
    L33:
        if (r7 == (this.keys.size() - 2)) goto L39;
        if (r7 == (this.keys.size() - 3)) goto L37;
        return false;
    L37:
        if (endsWithGlobstar() == true) goto L39;
        return false;
    L39:
        return true;
    L28:
        if (this.keys.get(r7 + 1).equals(r6) == false) goto L30;
        r4 = true;
        goto L31
    L12:
        if (r3.equals(r6) == false) goto L14;
    L17:
        boolean r9 = true;
    L18:
        if (r0 == false) goto L20;
    L23:
        if (r9 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        if (r7 == (this.keys.size() - 2)) goto L22;
        return false;
    L22:
        if (endsWithGlobstar() == true) goto L23;
        return false;
    L14:
        if (r3.equals(ApnEditor.APN_TYPE_ALL) == true) goto L17;
        r9 = false;
        goto L18
    L8:
        r0 = false;
        goto L9
    }

    public boolean propagateToChildren(String r2, int r3) {
        if ("__container".equals(r2) == false) goto L6;
        return true;
    L6:
        if (r3 >= (this.keys.size() - 1)) goto L8;
        return true;
    L8:
        if (this.keys.get(r3).equals("**") == true) goto L13;
        return false;
    L13:
        return true;
    }

    private boolean isContainer(String r1) {
        return "__container".equals(r1);
    }

    private boolean endsWithGlobstar() {
        List<String> r1 = this.keys;
        return r1.get(r1.size() - 1).equals("**");
    }

    public String keysToString() {
        return this.keys.toString();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("KeyPath{keys=").append(this.keys).append(",resolved=");
        if (this.resolvedElement == null) goto L5;
        boolean r2 = true;
    L7:
        return r0.append(r2).append('}').toString();
    L5:
        r2 = false;
        goto L7
    }
}
