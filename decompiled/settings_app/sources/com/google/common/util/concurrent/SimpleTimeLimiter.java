package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class SimpleTimeLimiter implements TimeLimiter {
    private final ExecutorService executor;

    static /* synthetic */ Exception access$000(Exception r0, boolean r1) throws Exception {
        return throwCause(r0, r1);
    }

    static /* synthetic */ Object access$100(SimpleTimeLimiter r0, Callable r1, long r2, TimeUnit r4, boolean r5) throws Exception {
        return r0.callWithTimeout(r1, r2, r4, r5);
    }

    private SimpleTimeLimiter(ExecutorService r1) {
        this.executor = (ExecutorService) Preconditions.checkNotNull(r1);
    }

    public static SimpleTimeLimiter create(ExecutorService r1) {
        return new SimpleTimeLimiter(r1);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(final T r10, Class<T> r11, final long r12, final TimeUnit r14) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r14);
        checkPositiveTimeout(r12);
        Preconditions.checkArgument(r11.isInterface(), "interfaceType must be an interface type");
        final Set<Method> r8 = findInterruptibleMethods(r11);
        return (T) newProxy(r11, new AnonymousClass1(this, r10, r12, r14, r8));
    }

    private static <T> T newProxy(Class<T> r3, InvocationHandler r4) {
        return r3.cast(Proxy.newProxyInstance(r3.getClassLoader(), new Class[]{r3}, r4));
    }

    private <T> T callWithTimeout(Callable<T> r1, long r2, TimeUnit r4, boolean r5) throws Exception {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r4);
        checkPositiveTimeout(r2);
        Future<T> r0 = this.executor.submit(r1);
        if (r5 == false) goto L10;
        return r0.get(r2, r4);
    L6:
        e = move-exception;
        r0.cancel(true);     // Catch: TimeoutException -> L11 ExecutionException -> L14
        throw e;     // Catch: TimeoutException -> L11 ExecutionException -> L14
    L10:
        return (T) Uninterruptibles.getUninterruptibly(r0, r2, r4);
    L14:
        e = move-exception;
        throw throwCause(e, true);
    L11:
        e = move-exception;
        r0.cancel(true);
        throw new UncheckedTimeoutException(e);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callWithTimeout(Callable<T> r2, long r3, TimeUnit r5) throws TimeoutException, InterruptedException, ExecutionException {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r5);
        checkPositiveTimeout(r3);
        Future<T> r4 = this.executor.submit(r2);
        return r4.get(r3, r5);
    L8:
        e = move-exception;
        r4.cancel(true);
        throw e;
    L5:
        e = move-exception;
        wrapAndThrowExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callUninterruptiblyWithTimeout(Callable<T> r2, long r3, TimeUnit r5) throws TimeoutException, ExecutionException {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r5);
        checkPositiveTimeout(r3);
        Future<T> r4 = this.executor.submit(r2);
        return (T) Uninterruptibles.getUninterruptibly(r4, r3, r5);
    L5:
        e = move-exception;
        wrapAndThrowExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    L8:
        e = move-exception;
        r4.cancel(true);
        throw e;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable r2, long r3, TimeUnit r5) throws TimeoutException, InterruptedException {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r5);
        checkPositiveTimeout(r3);
        Future<?> r4 = this.executor.submit(r2);
        r4.get(r3, r5);     // Catch: ExecutionException -> L5 Throwable -> L8
        return;
    L8:
        e = move-exception;
        r4.cancel(true);
        throw e;
    L5:
        e = move-exception;
        wrapAndThrowRuntimeExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable r2, long r3, TimeUnit r5) throws TimeoutException {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r5);
        checkPositiveTimeout(r3);
        Future<?> r4 = this.executor.submit(r2);
        Uninterruptibles.getUninterruptibly(r4, r3, r5);     // Catch: ExecutionException -> L5 TimeoutException -> L8
        return;
    L5:
        e = move-exception;
        wrapAndThrowRuntimeExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    L8:
        e = move-exception;
        r4.cancel(true);
        throw e;
    }

    private static Exception throwCause(Exception r3, boolean r4) throws Exception {
        Throwable r0 = r3.getCause();
        if (r0 == null) goto L15;
        if (r4 == false) goto L7;
        r0.setStackTrace((StackTraceElement[]) ObjectArrays.concat(r0.getStackTrace(), r3.getStackTrace(), StackTraceElement.class));
    L7:
        if ((r0 instanceof Exception) == true) goto L14;
        if ((r0 instanceof Error) == true) goto L11;
        throw r3;
    L11:
        throw ((Error) r0);
    L14:
        throw ((Exception) r0);
    L15:
        throw r3;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> r5) {
        HashSet r0 = Sets.newHashSet();
        Method[] r6 = r5.getMethods();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Method r3 = r6[r2];
        if (declaresInterruptedEx(r3) == false) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    private static boolean declaresInterruptedEx(Method r5) {
        Class<?>[] r6 = r5.getExceptionTypes();
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r6[r2] == InterruptedException.class) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable r1) throws ExecutionException {
        if ((r1 instanceof Error) == true) goto L11;
        if ((r1 instanceof RuntimeException) == false) goto L9;
        throw new UncheckedExecutionException(r1);
    L9:
        throw new ExecutionException(r1);
    L11:
        throw new ExecutionError((Error) r1);
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable r1) {
        if ((r1 instanceof Error) == false) goto L7;
        throw new ExecutionError((Error) r1);
    L7:
        throw new UncheckedExecutionException(r1);
    }

    private static void checkPositiveTimeout(long r2) {
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "timeout must be positive: %s", r2);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
