package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes5.dex */
public final class ExceptionHelper {
    public static final Throwable TERMINATED = null;

    static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        Termination() {
            super("No further exceptions");
        }
    }

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
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

    static {
        TERMINATED = new Termination();
    }

    public static <T> boolean addThrowable(AtomicReference<Throwable> r5, Throwable r6) {
    L2:
        Throwable r0 = r5.get();
        if (r0 == TERMINATED) goto L4;
        if (r0 != null) goto L8;
        Throwable r3 = r6;
    L10:
        if (b0$$ExternalSyntheticBackport0.m(r5, r0, r3) == false) goto L2;
        return true;
    L8:
        r3 = new CompositeException(new Throwable[]{r0, r6});
        goto L10
    L4:
        return false;
    }

    public static <T> Throwable terminate(AtomicReference<Throwable> r2) {
        Throwable r0 = r2.get();
        Throwable r1 = TERMINATED;
        if (r0 != r1) goto L5;
        return r0;
    L5:
        return r2.getAndSet(r1);
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

    public static <E extends Throwable> Exception throwIfThrowable(Throwable r1) throws Throwable {
        if ((r1 instanceof Exception) == true) goto L5;
        throw r1;
    L5:
        return (Exception) r1;
    }

    public static String timeoutMessage(long r2, TimeUnit r4) {
        return "The source did not signal an event for " + r2 + " " + r4.toString().toLowerCase() + " and has been terminated.";
    }
}
