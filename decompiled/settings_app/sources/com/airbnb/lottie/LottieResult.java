package com.airbnb.lottie;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LottieResult<V> {
    private final Throwable exception;
    private final V value;

    public LottieResult(V r1) {
        this.value = r1;
        this.exception = null;
    }

    public LottieResult(Throwable r1) {
        this.exception = r1;
        this.value = null;
    }

    public V getValue() {
        return this.value;
    }

    public Throwable getException() {
        return this.exception;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LottieResult) == true) goto L8;
        return false;
    L8:
        LottieResult r6 = (LottieResult) r5;
        if (getValue() == null) goto L14;
        if (getValue().equals(r6.getValue()) == false) goto L14;
        return true;
    L14:
        if (getException() != null) goto L16;
    L19:
        return false;
    L16:
        if (r6.getException() == null) goto L19;
        return getException().toString().equals(getException().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }
}
