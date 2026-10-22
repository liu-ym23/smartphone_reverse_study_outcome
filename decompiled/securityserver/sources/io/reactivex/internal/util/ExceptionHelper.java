package io.reactivex.internal.util;

import a.a;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class ExceptionHelper {
    public static final Throwable TERMINATED = null;

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        TERMINATED = new Termination();
    }

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean addThrowable(AtomicReference<Throwable> r3, Throwable r4) {
    L2:
        Throwable r0 = r3.get();
        if (r0 == TERMINATED) goto L4;
        if (r0 != null) goto L8;
        Throwable r1 = r4;
    L10:
        if (r3.compareAndSet(r0, r1) == false) goto L2;
        return true;
    L8:
        r1 = new CompositeException(new Throwable[]{r0, r4});
        goto L10
    L4:
        return false;
    }

    public static List<Throwable> flatten(Throwable r4) {
        ArrayList r0 = new ArrayList();
        ArrayDeque r1 = new ArrayDeque();
        r1.offer(r4);
    L4:
        if (r1.isEmpty() == true) goto L11;
        Throwable r5 = (Throwable) r1.removeFirst();
        if ((r5 instanceof CompositeException) == true) goto L7;
        r0.add(r5);
        goto L4
    L7:
        List<Throwable> r6 = ((CompositeException) r5).getExceptions();
        int r2 = r6.size() - 1;
    L8:
        if (r2 < 0) goto L4;
        r1.offerFirst(r6.get(r2));
        r2 = r2 - 1;
        goto L8
    L11:
        return r0;
    }

    public static <T> Throwable terminate(AtomicReference<Throwable> r2) {
        Throwable r0 = r2.get();
        Throwable r1 = TERMINATED;
        if (r0 != r1) goto L5;
        return r0;
    L5:
        return r2.getAndSet(r1);
    }

    public static <E extends Throwable> Exception throwIfThrowable(Throwable r1) {
        if ((r1 instanceof Exception) == true) goto L5;
        throw r1;
    L5:
        return (Exception) r1;
    }

    public static String timeoutMessage(long r2, TimeUnit r4) {
        StringBuilder r3 = a.s("The source did not signal an event for ", r2, " ");
        r3.append(r4.toString().toLowerCase());
        r3.append(" and has been terminated.");
        return r3.toString();
    }

    public static RuntimeException wrapOrThrow(Throwable r1) {
        if ((r1 instanceof Error) == true) goto L11;
        if ((r1 instanceof RuntimeException) == false) goto L9;
        return (RuntimeException) r1;
    L9:
        return new RuntimeException(r1);
    L11:
        throw ((Error) r1);
    }
}
