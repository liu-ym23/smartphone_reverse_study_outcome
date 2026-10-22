package com.google.common.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Throwables {
    private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
    static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";

    @CheckForNull
    private static final Method getStackTraceDepthMethod = null;

    @CheckForNull
    private static final Method getStackTraceElementMethod = null;

    @CheckForNull
    private static final Object jla = null;

    static /* synthetic */ Method access$000() {
        return getStackTraceElementMethod;
    }

    static /* synthetic */ Object access$100() {
        return jla;
    }

    static /* synthetic */ Object access$200(Method r0, Object r1, Object[] r2) {
        return invokeAccessibleNonThrowingMethod(r0, r1, r2);
    }

    static /* synthetic */ Method access$300() {
        return getStackTraceDepthMethod;
    }

    private Throwables() {
    }

    public static <X extends Throwable> void throwIfInstanceOf(Throwable r1, Class<X> r2) throws Throwable {
        Preconditions.checkNotNull(r1);
        if (r2.isInstance(r1) == true) goto L6;
        return;
    L6:
        throw r2.cast(r1);
    }

    @Deprecated
    public static <X extends Throwable> void propagateIfInstanceOf(@CheckForNull Throwable r0, Class<X> r1) throws Throwable {
        if (r0 == null) goto L5;
        throwIfInstanceOf(r0, r1);
        return;
    }

    public static void throwIfUnchecked(Throwable r1) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof RuntimeException) == true) goto L10;
        if ((r1 instanceof Error) == true) goto L8;
        return;
    L8:
        throw ((Error) r1);
    L10:
        throw ((RuntimeException) r1);
    }

    @Deprecated
    public static void propagateIfPossible(@CheckForNull Throwable r0) {
        if (r0 == null) goto L5;
        throwIfUnchecked(r0);
        return;
    }

    public static <X extends Throwable> void propagateIfPossible(@CheckForNull Throwable r0, Class<X> r1) throws Throwable {
        propagateIfInstanceOf(r0, r1);
        propagateIfPossible(r0);
    }

    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@CheckForNull Throwable r0, Class<X1> r1, Class<X2> r2) throws Throwable, Throwable {
        Preconditions.checkNotNull(r2);
        propagateIfInstanceOf(r0, r1);
        propagateIfPossible(r0, r2);
    }

    @Deprecated
    public static RuntimeException propagate(Throwable r1) {
        throwIfUnchecked(r1);
        throw new RuntimeException(r1);
    }

    public static Throwable getRootCause(Throwable r3) {
        boolean r1 = false;
        Throwable r0 = r3;
    L3:
        Throwable r2 = r3.getCause();
        if (r2 == null) goto L11;
        if (r2 == r0) goto L10;
        if (r1 == false) goto L8;
        r0 = r0.getCause();
    L8:
        r1 = !r1;
        r3 = r2;
        goto L3
    L10:
        throw new IllegalArgumentException("Loop in causal chain detected.", r2);
    L11:
        return r3;
    }

    public static List<Throwable> getCausalChain(Throwable r3) {
        Preconditions.checkNotNull(r3);
        ArrayList r0 = new ArrayList(4);
        r0.add(r3);
        boolean r2 = false;
        Throwable r1 = r3;
    L3:
        r3 = r3.getCause();
        if (r3 == null) goto L13;
        r0.add(r3);
        if (r3 == r1) goto L11;
        if (r2 == false) goto L9;
        r1 = r1.getCause();
    L9:
        r2 = !r2;
        goto L3
    L11:
        throw new IllegalArgumentException("Loop in causal chain detected.", r3);
    L13:
        return Collections.unmodifiableList(r0);
    }

    @CheckForNull
    public static <X extends Throwable> X getCauseAs(Throwable r1, Class<X> r2) {
        return r2.cast(r1.getCause());
    L4:
        e = move-exception;
        e.initCause(r1);
        throw e;
    }

    public static String getStackTraceAsString(Throwable r2) {
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }

    public static List<StackTraceElement> lazyStackTrace(Throwable r1) {
        if (lazyStackTraceIsLazy() == false) goto L6;
        return jlaStackTrace(r1);
    L6:
        return Collections.unmodifiableList(Arrays.asList(r1.getStackTrace()));
    }

    public static boolean lazyStackTraceIsLazy() {
        if (getStackTraceElementMethod != null) goto L5;
    L7:
        return false;
    L5:
        if (getStackTraceDepthMethod == null) goto L7;
        return true;
    }

    private static List<StackTraceElement> jlaStackTrace(final Throwable r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass1(r1);
    }

    private static Object invokeAccessibleNonThrowingMethod(Method r0, Object r1, Object... r2) {
        return r0.invoke(r1, r2);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw propagate(e.getCause());
    }

    static {
        Object r0 = getJLA();
        jla = r0;
        Method r1 = null;
        if (r0 != null) goto L5;
        Method r2 = null;
    L6:
        getStackTraceElementMethod = r2;
        if (r0 == null) goto L10;
        r1 = getSizeMethod(r0);
    L10:
        getStackTraceDepthMethod = r1;
        return;
    L5:
        r2 = getGetMethod();
        goto L6
    }

    @CheckForNull
    private static Object getJLA() {
        return Class.forName(SHARED_SECRETS_CLASSNAME, false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
    L5:
        e = move-exception;
        throw e;
    L10:
        return null;
    }

    @CheckForNull
    private static Method getGetMethod() {
        return getJlaMethod("getStackTraceElement", new Class[]{Throwable.class, Integer.TYPE});
    }

    @CheckForNull
    private static Method getSizeMethod(Object r6) {
        Method r1 = getJlaMethod("getStackTraceDepth", new Class[]{Throwable.class});     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        r1.invoke(r6, new Object[]{new Throwable()});     // Catch: Throwable -> L8
        return r1;
    L8:
        return null;
    }

    @CheckForNull
    private static Method getJlaMethod(String r3, Class<?>... r4) throws ThreadDeath {
        return Class.forName(JAVA_LANG_ACCESS_CLASSNAME, false, null).getMethod(r3, r4);
    L6:
        e = move-exception;
        throw e;
    L5:
        return null;
    }
}
