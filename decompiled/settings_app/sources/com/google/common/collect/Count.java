package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Count implements Serializable {
    private int value;

    Count(int r1) {
        this.value = r1;
    }

    public int get() {
        return this.value;
    }

    public void add(int r2) {
        this.value += r2;
    }

    public int addAndGet(int r2) {
        int r0 = this.value + r2;
        this.value = r0;
        return r0;
    }

    public void set(int r1) {
        this.value = r1;
    }

    public int getAndSet(int r2) {
        int r0 = this.value;
        this.value = r2;
        return r0;
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(@CheckForNull Object r2) {
        if ((r2 instanceof Count) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Count) r2).value != this.value) goto L7;
        return true;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
