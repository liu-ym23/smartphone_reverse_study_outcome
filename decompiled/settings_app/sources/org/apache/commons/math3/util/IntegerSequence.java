package org.apache.commons.math3.util;

import java.util.Iterator;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;

/* JADX INFO: loaded from: classes6.dex */
public class IntegerSequence {

    public static class Incrementor implements Iterator<Integer> {
        private static final MaxCountExceededCallback CALLBACK = null;
        private int count;
        private final int increment;
        private final int init;
        private final MaxCountExceededCallback maxCountCallback;
        private final int maximalCount;

        public interface MaxCountExceededCallback {
            void trigger(int r1) throws MaxCountExceededException;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Integer next() {
            return next();
        }

        static {
            CALLBACK = new AnonymousClass1();
        }

        private Incrementor(int r2, int r3, int r4, MaxCountExceededCallback r5) throws NullArgumentException {
            this.count = 0;
            if (r5 == null) goto L7;
            this.init = r2;
            this.maximalCount = r3;
            this.increment = r4;
            this.maxCountCallback = r5;
            this.count = r2;
            return;
        L7:
            throw new NullArgumentException();
        }

        public static Incrementor create() {
            return new Incrementor(0, 0, 1, CALLBACK);
        }

        public Incrementor withStart(int r4) {
            return new Incrementor(r4, this.maximalCount, this.increment, this.maxCountCallback);
        }

        public Incrementor withMaximalCount(int r4) {
            return new Incrementor(this.init, r4, this.increment, this.maxCountCallback);
        }

        public Incrementor withIncrement(int r4) {
            if (r4 == 0) goto L6;
            return new Incrementor(this.init, this.maximalCount, r4, this.maxCountCallback);
        L6:
            throw new ZeroException();
        }

        public Incrementor withCallback(MaxCountExceededCallback r4) {
            return new Incrementor(this.init, this.maximalCount, this.increment, r4);
        }

        public int getMaximalCount() {
            return this.maximalCount;
        }

        public int getCount() {
            return this.count;
        }

        public boolean canIncrement() {
            return canIncrement(1);
        }

        public boolean canIncrement(int r4) {
            int r0 = this.count;
            int r1 = this.increment;
            int r2 = r0 + (r4 * r1);
            int r3 = this.maximalCount;
            if (r1 >= 0) goto L6;
            if (r2 <= r3) goto L9;
            return true;
        L9:
            return false;
        L6:
            if (r2 >= r3) goto L9;
            return true;
        }

        public void increment(int r3) throws MaxCountExceededException {
            if (r3 <= 0) goto L9;
            if (canIncrement(0) == true) goto L6;
            this.maxCountCallback.trigger(this.maximalCount);
        L6:
            this.count += r3 * this.increment;
            return;
        L9:
            throw new NotStrictlyPositiveException(Integer.valueOf(r3));
        }

        public void increment() throws MaxCountExceededException {
            increment(1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return canIncrement(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            int r0 = this.count;
            increment();
            return Integer.valueOf(r0);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new MathUnsupportedOperationException();
        }
    }

    public static class Range implements Iterable<Integer> {
        private final int max;
        private final int size;
        private final int start;
        private final int step;

        public Range(int r1, int r2, int r3) {
            this.start = r1;
            this.max = r2;
            this.step = r3;
            int r4 = ((r2 - r1) / r3) + 1;
            if (r4 >= 0) goto L5;
            r4 = 0;
        L5:
            this.size = r4;
        }

        public int size() {
            return this.size;
        }

        @Override // java.lang.Iterable
        public Iterator<Integer> iterator() {
            Incrementor r0 = Incrementor.create().withStart(this.start);
            int r1 = this.max;
            if (this.step <= 0) goto L5;
            int r2 = 1;
        L7:
            return r0.withMaximalCount(r1 + r2).withIncrement(this.step);
        L5:
            r2 = -1;
            goto L7
        }
    }

    private IntegerSequence() {
    }

    public static Range range(int r1, int r2) {
        return range(r1, r2, 1);
    }

    public static Range range(int r1, int r2, int r3) {
        return new Range(r1, r2, r3);
    }
}
