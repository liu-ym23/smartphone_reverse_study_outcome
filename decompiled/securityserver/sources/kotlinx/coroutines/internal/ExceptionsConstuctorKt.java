package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ExceptionsConstuctorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f412a = 0;
    public static final ReentrantReadWriteLock b = null;
    public static final WeakHashMap c = null;

    static {
        f412a = a(Throwable.class, -1);
        b = new ReentrantReadWriteLock();
        c = new WeakHashMap();
    }

    public static final int a(Class r7, int r8) {
        Reflection.a(r7);
        int r1 = 0;
    L21:
        Field[] r2 = r7.getDeclaredFields();     // Catch: Throwable -> L14
        int r3 = r2.length;     // Catch: Throwable -> L14
        int r4 = 0;
        int r5 = 0;
    L4:
        if (r4 >= r3) goto L9;
        if ((!Modifier.isStatic(r2[r4].getModifiers())) == false) goto L8;
        r5 = r5 + 1;     // Catch: Throwable -> L14
    L8:
        r4 = r4 + 1;     // Catch: Throwable -> L14
        goto L4
    L9:
        r1 = r1 + r5;     // Catch: Throwable -> L14
        r7 = r7.getSuperclass();     // Catch: Throwable -> L14
        if (r7 != null) goto L21;
        Object r9 = Integer.valueOf(r1);     // Catch: Throwable -> L14
    L16:
        Object r10 = Integer.valueOf(r8);
        if ((r9 instanceof Result.Failure) == false) goto L20;
        r9 = r10;
    L20:
        return ((Number) r9).intValue();
    L14:
        th = move-exception;
        r9 = ResultKt.a(th);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Throwable b(Throwable r12) {
        Object r1 = null;
        if ((r12 instanceof CopyableThrowable) == true) goto L101;
        ReentrantReadWriteLock r0 = b;
        ReentrantReadWriteLock.ReadLock r2 = r0.readLock();
        r2.lock();
        WeakHashMap r3 = c;
        Function1 r4 = (Function1) r3.get(r12.getClass());     // Catch: Throwable -> L94
        r2.unlock();
        if (r4 != null) goto L19;
        int r5 = 0;
        if (f412a == a(r12.getClass(), 0)) goto L40;
        ReentrantReadWriteLock.ReadLock r6 = r0.readLock();
        if (r0.getWriteHoldCount() != 0) goto L25;
        int r7 = r0.getReadHoldCount();
    L26:
        int r8 = 0;
    L27:
        if (r8 >= r7) goto L29;
        r6.unlock();
        r8 = r8 + 1;
        goto L27
    L29:
        ReentrantReadWriteLock.WriteLock r9 = r0.writeLock();
        r9.lock();
        r3.put(r12.getClass(), ExceptionsConstuctorKt$tryCopyException$4$1.b);     // Catch: Throwable -> L35
    L31:
        if (r5 >= r7) goto L33;
        r6.lock();
        r5 = r5 + 1;
        goto L31
    L33:
        r9.unlock();
        return null;
    L35:
        th = move-exception;
    L36:
        if (r5 >= r7) goto L38;
        r6.lock();
        r5 = r5 + 1;
        goto L36
    L38:
        r9.unlock();
        throw th;
    L25:
        r7 = 0;
        goto L26
    L40:
        Object[] r10 = r12.getClass().getConstructors();
        ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1 r11 = new ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1();
        Intrinsics.f(r10, "<this>");
        if (r10.length == 0) goto L46;
        r10 = Arrays.copyOf(r10, r10.length);
        Intrinsics.e(r10, "copyOf(this, size)");
        if (r10.length <= 1) goto L46;
        Arrays.sort(r10, r11);
    L46:
        Iterator r13 = ArraysKt.b(r10).iterator();
        Function1<Throwable, Throwable> r14 = null;
    L48:
        if (r13.hasNext() == false) goto L70;
        final Constructor r15 = (Constructor) r13.next();
        Class<?>[] r16 = r15.getParameterTypes();
        int r17 = r16.length;
        if (r17 != 0) goto L52;
        Function1<Throwable, Throwable> r18 = new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(r15);
    L61:
        r14 = r18;
    L69:
        if (r14 == null) goto L48;
    L52:
        if (r17 != 1) goto L54;
        Class<?> r19 = r16[0];
        if (Intrinsics.a(r19, Throwable.class) == false) goto L66;
        r18 = new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(r15);
        goto L61
    L66:
        if (Intrinsics.a(r19, String.class) == true) goto L67;
    L55:
        r14 = null;
        goto L69
    L67:
        r18 = new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(r15);
        goto L61
    L54:
        if (r17 != 2) goto L55;
        if (Intrinsics.a(r16[0], String.class) == false) goto L55;
        if (Intrinsics.a(r16[1], Throwable.class) == false) goto L55;
        r18 = new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(r15);
    L70:
        ReentrantReadWriteLock.ReadLock r20 = r0.readLock();
        if (r0.getWriteHoldCount() != 0) goto L73;
        int r21 = r0.getReadHoldCount();
    L74:
        int r22 = 0;
    L75:
        if (r22 >= r21) goto L77;
        r20.unlock();
        r22 = r22 + 1;
        goto L75
    L77:
        ReentrantReadWriteLock.WriteLock r23 = r0.writeLock();
        r23.lock();
        Class<?> r24 = r12.getClass();     // Catch: Throwable -> L89
        if (r14 == null) goto L81;
        Function1<Throwable, Throwable> r25 = r14;
    L82:
        r3.put(r24, r25);     // Catch: Throwable -> L89
    L83:
        if (r5 >= r21) goto L85;
        r20.lock();
        r5 = r5 + 1;
        goto L83
    L85:
        r23.unlock();
        if (r14 != null) goto L88;
        return null;
    L88:
        return (Throwable) r14.invoke(r12);
    L81:
        r25 = ExceptionsConstuctorKt$tryCopyException$5$1.b;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
    L90:
        if (r5 >= r21) goto L92;
        r20.lock();
        r5 = r5 + 1;
        goto L90
    L92:
        r23.unlock();
        throw th;
    L73:
        r21 = 0;
        goto L74
    L19:
        return (Throwable) r4.invoke(r12);
    L94:
        th = move-exception;
        r2.unlock();
        throw th;
    L101:
        Object r110 = ((CopyableThrowable) r12).a();     // Catch: Throwable -> L6
    L9:
        if ((r110 instanceof Result.Failure) == true) goto L13;
        r1 = r110;
    L13:
        return (Throwable) r1;
    L6:
        th = move-exception;
        r110 = ResultKt.a(th);
        goto L9
    }
}
