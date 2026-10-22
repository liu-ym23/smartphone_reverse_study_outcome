package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class Finalizer implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
    private static final Constructor<Thread> bigThreadConstructor = null;
    private static final Field inheritableThreadLocals = null;
    private static final Logger logger = null;
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue;

    static {
        logger = Logger.getLogger(Finalizer.class.getName());
        Constructor<Thread> r0 = getBigThreadConstructor();
        bigThreadConstructor = r0;
        if (r0 != null) goto L5;
        Field r1 = getInheritableThreadLocalsField();
    L6:
        inheritableThreadLocals = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void startFinalizer(Class<?> r6, ReferenceQueue<Object> r7, PhantomReference<Object> r8) {
        if (r6.getName().equals(FINALIZABLE_REFERENCE) == false) goto L24;
        Finalizer r0 = new Finalizer(r6, r7, r8);
        String r9 = Finalizer.class.getName();
        Constructor<Thread> r10 = bigThreadConstructor;
        if (r10 != null) goto L27;
    L11:
        Thread r11 = null;
    L12:
        if (r11 != null) goto L14;
        ThreadGroup r2 = (ThreadGroup) null;
        r11 = new Thread(null, r0, r9);
    L14:
        r11.setDaemon(true);
        Field r12 = inheritableThreadLocals;     // Catch: Throwable -> L19
        if (r12 == null) goto L21;
        r12.set(r11, null);     // Catch: Throwable -> L19
    L21:
        r11.start();
        return;
    L19:
        th = move-exception;
        logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", th);
        goto L21
    L27:
        ThreadGroup r3 = (ThreadGroup) null;     // Catch: Throwable -> L9
        r11 = r10.newInstance(new Object[]{null, r0, r9, 0L, false});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        logger.log(Level.INFO, "Failed to create a thread without inherited thread-local values", th);
        goto L11
    L24:
        throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    }

    private Finalizer(Class<?> r1, ReferenceQueue<Object> r2, PhantomReference<Object> r3) {
        this.queue = r2;
        this.finalizableReferenceClassReference = new WeakReference(r1);
        this.frqReference = r3;
    }

    @Override // java.lang.Runnable
    public void run() {
    L6:
        if (cleanUp(this.queue.remove()) == true) goto L6;
    }

    private boolean cleanUp(Reference<?> r6) {
        Method r0 = getFinalizeReferentMethod();
        if (r0 != null) goto L5;
        return false;
    L5:
        r6.clear();
        if (r6 == this.frqReference) goto L7;
        r0.invoke(r6, new Object[0]);     // Catch: Throwable -> L10
    L12:
        r6 = this.queue.poll();
        if (r6 != null) goto L5;
        return true;
    L10:
        th = move-exception;
        logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
        goto L12
    L7:
        return false;
    }

    private Method getFinalizeReferentMethod() {
        Class<?> r2 = this.finalizableReferenceClassReference.get();
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getMethod("finalizeReferent", new Class[0]);
    L8:
        e = move-exception;
        throw new AssertionError(e);
    }

    private static Field getInheritableThreadLocalsField() {
        Field r0 = Thread.class.getDeclaredField("inheritableThreadLocals");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return r0;
    L4:
        logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
        return null;
    }

    private static Constructor<Thread> getBigThreadConstructor() {
        return Thread.class.getConstructor(new Class[]{ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE});
    L4:
        return null;
    }
}
