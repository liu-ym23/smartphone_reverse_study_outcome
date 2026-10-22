package org.lsposed.hiddenapibypass;

import android.icu.text.DateFormat;
import android.util.Log;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes6.dex */
public final class HiddenApiBypass {
    private static final Unsafe a = null;
    private static final long b = 0;
    private static final long c = 0;
    private static final long d = 0;
    private static final long e = 0;
    private static final long f = 0;
    private static final long g = 0;
    private static final long h = 0;
    private static final long i = 0;
    private static final long j = 0;
    private static final long k = 0;
    private static final long l = 0;
    private static final long m = 0;
    private static final Set n = null;

    static {
        n = new HashSet();
        Unsafe r0 = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);     // Catch: ReflectiveOperationException -> L5
        a = r0;     // Catch: ReflectiveOperationException -> L5
        b = r0.objectFieldOffset(Helper$Executable.class.getDeclaredField("artMethod"));     // Catch: ReflectiveOperationException -> L5
        c = r0.objectFieldOffset(Helper$Executable.class.getDeclaredField("declaringClass"));     // Catch: ReflectiveOperationException -> L5
        long r3 = r0.objectFieldOffset(Helper$MethodHandle.class.getDeclaredField("artFieldOrMethod"));     // Catch: ReflectiveOperationException -> L5
        d = r3;     // Catch: ReflectiveOperationException -> L5
        e = r0.objectFieldOffset(Helper$MethodHandleImpl.class.getDeclaredField("info"));     // Catch: ReflectiveOperationException -> L5
        long r5 = r0.objectFieldOffset(Helper$Class.class.getDeclaredField("methods"));     // Catch: ReflectiveOperationException -> L5
        f = r5;     // Catch: ReflectiveOperationException -> L5
        long r7 = r0.objectFieldOffset(Helper$Class.class.getDeclaredField("iFields"));     // Catch: ReflectiveOperationException -> L5
        g = r7;     // Catch: ReflectiveOperationException -> L5
        h = r0.objectFieldOffset(Helper$Class.class.getDeclaredField("sFields"));     // Catch: ReflectiveOperationException -> L5
        i = r0.objectFieldOffset(Helper$HandleInfo.class.getDeclaredField("member"));     // Catch: ReflectiveOperationException -> L5
        Method r1 = Helper$NeverCall.class.getDeclaredMethod("a", new Class[0]);     // Catch: ReflectiveOperationException -> L5
        Method r2 = Helper$NeverCall.class.getDeclaredMethod("b", new Class[0]);     // Catch: ReflectiveOperationException -> L5
        r1.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        r2.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r4 = MethodHandles.lookup().unreflect(r1);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r6 = MethodHandles.lookup().unreflect(r2);     // Catch: ReflectiveOperationException -> L5
        long r10 = r0.getLong(r4, r3);     // Catch: ReflectiveOperationException -> L5
        long r8 = r0.getLong(r6, r3);     // Catch: ReflectiveOperationException -> L5
        long r9 = r0.getLong(Helper$NeverCall.class, r5);     // Catch: ReflectiveOperationException -> L5
        long r11 = r8 - r10;     // Catch: ReflectiveOperationException -> L5
        j = r11;     // Catch: ReflectiveOperationException -> L5
        k = (r10 - r9) - r11;     // Catch: ReflectiveOperationException -> L5
        Field r12 = Helper$NeverCall.class.getDeclaredField("i");     // Catch: ReflectiveOperationException -> L5
        Field r13 = Helper$NeverCall.class.getDeclaredField(DateFormat.HOUR);     // Catch: ReflectiveOperationException -> L5
        r12.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        r13.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r14 = MethodHandles.lookup().unreflectGetter(r12);     // Catch: ReflectiveOperationException -> L5
        MethodHandle r15 = MethodHandles.lookup().unreflectGetter(r13);     // Catch: ReflectiveOperationException -> L5
        long r16 = r0.getLong(r14, r3);     // Catch: ReflectiveOperationException -> L5
        long r17 = r0.getLong(r15, r3);     // Catch: ReflectiveOperationException -> L5
        long r18 = r0.getLong(Helper$NeverCall.class, r7);     // Catch: ReflectiveOperationException -> L5
        l = r17 - r16;     // Catch: ReflectiveOperationException -> L5
        m = r16 - r18;     // Catch: ReflectiveOperationException -> L5
        return;
    L5:
        e = move-exception;
        Log.e("HiddenApiBypass", "Initialize error", e);
        throw new ExceptionInInitializerError(e);
    }

    public HiddenApiBypass() {
    }

    static boolean a(Class[] r4, Object[] r5) {
        if (r4.length == r5.length) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r4.length) goto L56;
        if (r4[r0].isPrimitive() == true) goto L11;
        Object r1 = r5[r0];
        if (r1 == null) goto L55;
        if (r4[r0].isInstance(r1) == true) goto L55;
        return false;
    L55:
        r0 = r0 + 1;
        goto L7
    L11:
        if (r4[r0] != Integer.TYPE) goto L16;
        if ((r5[r0] instanceof Integer) == true) goto L16;
        return false;
    L16:
        if (r4[r0] != Byte.TYPE) goto L21;
        if ((r5[r0] instanceof Byte) == true) goto L21;
        return false;
    L21:
        if (r4[r0] != Character.TYPE) goto L26;
        if ((r5[r0] instanceof Character) == true) goto L26;
        return false;
    L26:
        if (r4[r0] != Boolean.TYPE) goto L31;
        if ((r5[r0] instanceof Boolean) == true) goto L31;
        return false;
    L31:
        if (r4[r0] != Double.TYPE) goto L36;
        if ((r5[r0] instanceof Double) == true) goto L36;
        return false;
    L36:
        if (r4[r0] != Float.TYPE) goto L41;
        if ((r5[r0] instanceof Float) == true) goto L41;
        return false;
    L41:
        if (r4[r0] != Long.TYPE) goto L46;
        if ((r5[r0] instanceof Long) == true) goto L46;
        return false;
    L46:
        if (r4[r0] != Short.TYPE) goto L55;
        if ((r5[r0] instanceof Short) == true) goto L55;
        return false;
    L56:
        return true;
    }

    public static boolean addHiddenApiExemptions(String... r1) {
        Set r0 = n;
        r0.addAll(Arrays.asList(r1));
        String[] r2 = new String[((HashSet) r0).size()];
        r0.toArray(r2);
        return setHiddenApiExemptions(r2);
    }

    public static boolean clearHiddenApiExemptions() {
        ((HashSet) n).clear();
        return setHiddenApiExemptions(new String[0]);
    }

    public static Constructor getDeclaredConstructor(Class r5, Class... r6) {
        Iterator r7 = getDeclaredMethods(r5).iterator();
    L4:
        if (r7.hasNext() == false) goto L21;
        Executable r0 = (Executable) r7.next();
        if ((r0 instanceof Constructor) == false) goto L4;
        Class<?>[] r1 = r0.getParameterTypes();
        if (r1.length != r6.length) goto L4;
        int r2 = 0;
    L13:
        if (r2 >= r6.length) goto L19;
        if (r6[r2] != r1[r2]) goto L4;
        r2 = r2 + 1;
        goto L13
    L19:
        return (Constructor) r0;
    L21:
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Method getDeclaredMethod(Class r5, String r6, Class... r7) {
        Iterator r8 = getDeclaredMethods(r5).iterator();
    L4:
        if (r8.hasNext() == false) goto L24;
        Executable r0 = (Executable) r8.next();
        if (r0.getName().equals(r6) == false) goto L4;
        if ((r0 instanceof Method) == false) goto L4;
        Class<?>[] r1 = r0.getParameterTypes();
        if (r1.length != r7.length) goto L4;
        int r2 = 0;
    L16:
        if (r2 >= r7.length) goto L22;
        if (r7[r2] != r1[r2]) goto L4;
        r2 = r2 + 1;
        goto L16
    L22:
        return (Method) r0;
    L24:
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static List getDeclaredMethods(Class r12) {
        ArrayList r0 = new ArrayList();
        if (r12.isPrimitive() == false) goto L5;
    L16:
        return r0;
    L5:
        if (r12.isArray() == true) goto L16;
        int r3 = 0;
        Method r1 = Helper$NeverCall.class.getDeclaredMethod("a", new Class[0]);     // Catch: Throwable -> L18
        r1.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r2 = MethodHandles.lookup().unreflect(r1);     // Catch: Throwable -> L18
        Unsafe r4 = a;
        long r10 = r4.getLong(r12, f);
        if (r10 != 0) goto L11;
        return r0;
    L11:
        int r13 = r4.getInt(r10);
    L12:
        if (r3 >= r13) goto L16;
        long r8 = ((((long) r3) * j) + r10) + k;
        Unsafe r5 = a;
        r5.putLong(r2, d, r8);
        r5.putObject(r2, e, null);
        MethodHandles.lookup().revealDirect(r2);     // Catch: Throwable -> L17
    L15:
        Unsafe r6 = a;
        r0.add((Executable) r6.getObject((MethodHandleInfo) r6.getObject(r2, e), i));
        r3 = r3 + 1;
        goto L12
    }

    public static List getInstanceFields(Class r12) {
        ArrayList r0 = new ArrayList();
        if (r12.isPrimitive() == false) goto L5;
    L16:
        return r0;
    L5:
        if (r12.isArray() == true) goto L16;
        Field r1 = Helper$NeverCall.class.getDeclaredField("i");     // Catch: Throwable -> L18
        r1.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r2 = MethodHandles.lookup().unreflectGetter(r1);     // Catch: Throwable -> L18
        Unsafe r3 = a;
        long r9 = r3.getLong(r12, g);
        if (r9 != 0) goto L11;
        return r0;
    L11:
        int r13 = r3.getInt(r9);
        int r4 = 0;
    L12:
        if (r4 >= r13) goto L16;
        long r7 = ((((long) r4) * l) + r9) + m;
        Unsafe r11 = a;
        r11.putLong(r2, d, r7);
        r11.putObject(r2, e, null);
        MethodHandles.lookup().revealDirect(r2);     // Catch: Throwable -> L17
    L15:
        Unsafe r5 = a;
        r0.add((Field) r5.getObject((MethodHandleInfo) r5.getObject(r2, e), i));
        r4 = r4 + 1;
        goto L12
    }

    public static List getStaticFields(Class r12) {
        ArrayList r0 = new ArrayList();
        if (r12.isPrimitive() == false) goto L5;
    L16:
        return r0;
    L5:
        if (r12.isArray() == true) goto L16;
        Field r1 = Helper$NeverCall.class.getDeclaredField(DateFormat.SECOND);     // Catch: Throwable -> L18
        r1.setAccessible(true);     // Catch: Throwable -> L18
        MethodHandle r2 = MethodHandles.lookup().unreflectGetter(r1);     // Catch: Throwable -> L18
        Unsafe r3 = a;
        long r9 = r3.getLong(r12, h);
        if (r9 != 0) goto L11;
        return r0;
    L11:
        int r13 = r3.getInt(r9);
        int r4 = 0;
    L12:
        if (r4 >= r13) goto L16;
        long r7 = ((((long) r4) * l) + r9) + m;
        Unsafe r11 = a;
        r11.putLong(r2, d, r7);
        r11.putObject(r2, e, null);
        MethodHandles.lookup().revealDirect(r2);     // Catch: Throwable -> L17
    L15:
        Unsafe r5 = a;
        r0.add((Field) r5.getObject((MethodHandleInfo) r5.getObject(r2, e), i));
        r4 = r4 + 1;
        goto L12
    }

    public static Object invoke(Class r15, Object r16, String r17, Object... r18) {
        if (r16 != null) goto L5;
    L9:
        int r5 = 0;
        Method r3 = Helper$InvokeStub.class.getDeclaredMethod("invoke", new Class[]{Object[].class});
        r3.setAccessible(true);
        Unsafe r2 = a;
        long r13 = r2.getLong(r15, f);
        if (r13 == 0) goto L23;
        int r4 = r2.getInt(r13);
    L12:
        if (r5 >= r4) goto L21;
        a.putLong(r3, b, ((((long) r5) * j) + r13) + k);
        if (r17.equals(r3.getName()) == false) goto L19;
        if (a(r3.getParameterTypes(), r18) == false) goto L19;
        return r3.invoke(r16, r18);
    L19:
        r5 = r5 + 1;
        goto L12
    L21:
        throw new NoSuchMethodException("Cannot find matching method");
    L23:
        throw new NoSuchMethodException("Cannot find matching method");
    L5:
        if (r15.isInstance(r16) == true) goto L9;
        throw new IllegalArgumentException("this object is not an instance of the given class");
    }

    public static Object newInstance(Class r20, Object... r21) {
        int r5 = 0;
        Method r3 = Helper$InvokeStub.class.getDeclaredMethod("invoke", new Class[]{Object[].class});
        Constructor r4 = Helper$InvokeStub.class.getDeclaredConstructor(new Class[]{Object[].class});
        r4.setAccessible(true);
        Unsafe r2 = a;
        long r13 = r2.getLong(r20, f);
        if (r13 == 0) goto L16;
        int r6 = r2.getInt(r13);
    L5:
        if (r5 >= r6) goto L14;
        long r16 = ((((long) r5) * j) + r13) + k;
        Unsafe r7 = a;
        long r18 = b;
        r7.putLong(r3, r18, r16);
        if ("<init>".equals(r3.getName()) == false) goto L12;
        r7.putLong(r4, r18, r16);
        r7.putObject(r4, c, r20);
        if (a(r4.getParameterTypes(), r21) == false) goto L12;
        return r4.newInstance(r21);
    L12:
        r5 = r5 + 1;
        goto L5
    L14:
        throw new NoSuchMethodException("Cannot find matching constructor");
    L16:
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static boolean setHiddenApiExemptions(String... r6) {
        invoke(VMRuntime.class, invoke(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", new Object[]{r6});     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        Log.w("HiddenApiBypass", "setHiddenApiExemptions", th);
        return false;
    }
}
