package com.airbnb.lottie.model;

import androidx.core.util.Pair;
import com.android.settings.utils.HanziToPinyin;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class MutablePair<T> {
    T first;
    T second;

    public MutablePair() {
    }

    public void set(T r1, T r2) {
        this.first = r1;
        this.second = r2;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof Pair) == true) goto L5;
        return false;
    L5:
        Pair r5 = (Pair) r4;
        if (objectsEqual(r5.first, this.first) == true) goto L8;
        return false;
    L8:
        if (objectsEqual(r5.second, this.second) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean objectsEqual(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public int hashCode() {
        T r0 = this.first;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        T r3 = this.second;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.first) + HanziToPinyin.Token.SEPARATOR + String.valueOf(this.second) + VectorFormat.DEFAULT_SUFFIX;
    }
}
