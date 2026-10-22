package org.apache.commons.math3.util;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class Incrementor {
    private int count;
    private final MaxCountExceededCallback maxCountCallback;
    private int maximalCount;

    public interface MaxCountExceededCallback {
        void trigger(int r1) throws MaxCountExceededException;
    }

    public Incrementor() {
        this(0);
    }

    public Incrementor(int r2) {
        this(r2, new AnonymousClass1());
    }

    public Incrementor(int r2, MaxCountExceededCallback r3) throws NullArgumentException {
        this.count = 0;
        if (r3 == null) goto L7;
        this.maximalCount = r2;
        this.maxCountCallback = r3;
        return;
    L7:
        throw new NullArgumentException();
    }

    public void setMaximalCount(int r1) {
        this.maximalCount = r1;
    }

    public int getMaximalCount() {
        return this.maximalCount;
    }

    public int getCount() {
        return this.count;
    }

    public boolean canIncrement() {
        if (this.count >= this.maximalCount) goto L5;
        return true;
    L5:
        return false;
    }

    public void incrementCount(int r2) throws MaxCountExceededException {
        int r0 = 0;
    L3:
        if (r0 >= r2) goto L5;
        incrementCount();
        r0 = r0 + 1;
        goto L3
    }

    public void incrementCount() throws MaxCountExceededException {
        int r0 = this.count + 1;
        this.count = r0;
        int r1 = this.maximalCount;
        if (r0 <= r1) goto L6;
        this.maxCountCallback.trigger(r1);
        return;
    }

    public void resetCount() {
        this.count = 0;
    }

    public static Incrementor wrap(final IntegerSequence.Incrementor r1) {
        return new AnonymousClass2(r1);
    }
}
