package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes3.dex */
public class MultiClassKey {
    private Class<?> first;
    private Class<?> second;
    private Class<?> third;

    public MultiClassKey() {
    }

    public MultiClassKey(Class<?> r1, Class<?> r2) {
        set(r1, r2);
    }

    public MultiClassKey(Class<?> r1, Class<?> r2, Class<?> r3) {
        set(r1, r2, r3);
    }

    public void set(Class<?> r2, Class<?> r3) {
        set(r2, r3, null);
    }

    public void set(Class<?> r1, Class<?> r2, Class<?> r3) {
        this.first = r1;
        this.second = r2;
        this.third = r3;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.first + ", second=" + this.second + '}';
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L20;
        MultiClassKey r6 = (MultiClassKey) r5;
        if (this.first.equals(r6.first) == true) goto L14;
        return false;
    L14:
        if (this.second.equals(r6.second) == true) goto L17;
        return false;
    L17:
        if (Util.bothNullOrEqual(this.third, r6.third) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.first.hashCode() * 31) + this.second.hashCode()) * 31;
        Class<?> r2 = this.third;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r0 + r3;
    L5:
        r3 = 0;
        goto L7
    }
}
