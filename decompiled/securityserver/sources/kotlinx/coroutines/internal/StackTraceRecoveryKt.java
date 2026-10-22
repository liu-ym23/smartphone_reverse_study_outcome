package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StackTraceRecoveryKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f425a = null;
    public static final String b = null;

    static {
        Object r0 = BaseContinuationImpl.class.getCanonicalName();     // Catch: Throwable -> L4
    L7:
        if (Result.a(r0) == null) goto L10;
        r0 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    L10:
        f425a = (String) r0;
        Object r1 = StackTraceRecoveryKt.class.getCanonicalName();     // Catch: Throwable -> L13
    L16:
        if (Result.a(r1) == null) goto L19;
        r1 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    L19:
        b = (String) r1;
        return;
    L13:
        th = move-exception;
        r1 = ResultKt.a(th);
    L4:
        th = move-exception;
        r0 = ResultKt.a(th);
        goto L7
    }

    public static final Throwable a(Throwable r10, CoroutineStackFrame r11) {
        Throwable r0 = r10.getCause();
        int r2 = 0;
        if (r0 != null) goto L5;
    L13:
        Pair r4 = new Pair(r10, new StackTraceElement[0]);
    L14:
        Throwable r1 = (Throwable) r4.b;
        StackTraceElement[] r3 = (StackTraceElement[]) r4.c;
        Throwable r5 = ExceptionsConstuctorKt.b(r1);
        if (r5 != null) goto L17;
        return r10;
    L17:
        if ((!Intrinsics.a(r5.getMessage(), r1.getMessage())) == true) goto L84;
        ArrayDeque r6 = new ArrayDeque();
        StackTraceElement r7 = r11.w();
        if (r7 == null) goto L22;
        r6.add(r7);
    L22:
        r11 = r11.e();
        if (r11 == null) goto L28;
        StackTraceElement r8 = r11.w();
        if (r8 == null) goto L22;
        r6.add(r8);
        goto L22
    L28:
        if (r6.isEmpty() == false) goto L31;
        return r10;
    L31:
        if (r1 == r10) goto L53;
        int r12 = r3.length;
        int r9 = 0;
    L33:
        if (r9 >= r12) goto L38;
        if (StringsKt.F(r3[r9].getClassName(), "\b\b\b", false) == true) goto L39;
        r9 = r9 + 1;
    L39:
        int r13 = r9 + 1;
        int r14 = r3.length - 1;
        if (r14 < r13) goto L53;
    L41:
        StackTraceElement r15 = r3[r14];
        StackTraceElement r16 = (StackTraceElement) r6.getLast();
        if (r15.getLineNumber() == r16.getLineNumber()) goto L44;
    L50:
        r6.addFirst(r3[r14]);
        if (r14 == r13) goto L53;
        r14 = r14 - 1;
        goto L41
    L44:
        if (Intrinsics.a(r15.getMethodName(), r16.getMethodName()) == false) goto L50;
        if (Intrinsics.a(r15.getFileName(), r16.getFileName()) == false) goto L50;
        if (Intrinsics.a(r15.getClassName(), r16.getClassName()) == false) goto L50;
        r6.removeLast();
        goto L50
    L38:
        r9 = -1;
    L53:
        r6.addFirst(new StackTraceElement("\b\b\b(Coroutine boundary", "\b", "\b", -1));
        StackTraceElement[] r17 = r1.getStackTrace();
        int r18 = b(r17, f425a);
        if (r18 != (-1)) goto L60;
        Object[] r19 = r6.toArray(new StackTraceElement[0]);
        if (r19 == null) goto L59;
        r5.setStackTrace((StackTraceElement[]) r19);
    L69:
        return r5;
    L59:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L60:
        StackTraceElement[] r110 = new StackTraceElement[r6.size() + r18];
        int r20 = 0;
    L61:
        if (r20 >= r18) goto L63;
        r110[r20] = r17[r20];
        r20 = r20 + 1;
        goto L61
    L63:
        Iterator r111 = r6.iterator();
    L65:
        if (r111.hasNext() == false) goto L67;
        r110[r18 + r2] = (StackTraceElement) r111.next();
        r2 = r2 + 1;
        goto L65
    L67:
        r5.setStackTrace(r110);
        goto L69
    L84:
        return r10;
    L5:
        if (r0.getClass().equals(r10.getClass()) == false) goto L13;
        StackTraceElement[] r21 = r10.getStackTrace();
        int r22 = r21.length;
        int r23 = 0;
    L7:
        if (r23 >= r22) goto L12;
        if (StringsKt.F(r21[r23].getClassName(), "\b\b\b", false) == true) goto L10;
        r23 = r23 + 1;
        goto L7
    L10:
        r4 = new Pair(r0, r21);
        goto L14
    L12:
        r4 = new Pair(r10, new StackTraceElement[0]);
        goto L14
    }

    public static final int b(StackTraceElement[] r3, String r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (Intrinsics.a(r4, r3[r1].getClassName()) == true) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r1;
    L8:
        return -1;
    }

    public static final Throwable c(Throwable r9) {
        if (DebugKt.b == true) goto L5;
        return r9;
    L5:
        Throwable r0 = ExceptionsConstuctorKt.b(r9);
        if (r0 == null) goto L19;
        StackTraceElement[] r10 = r0.getStackTrace();
        int r1 = r10.length;
        int r2 = b(r10, b);
        int r3 = r2 + 1;
        int r4 = b(r10, f425a);
        int r6 = 0;
        if (r4 != (-1)) goto L10;
        int r5 = 0;
    L11:
        int r7 = (r1 - r2) - r5;
        StackTraceElement[] r8 = new StackTraceElement[r7];
    L12:
        if (r6 >= r7) goto L17;
        if (r6 != 0) goto L15;
        StackTraceElement r11 = new StackTraceElement("\b\b\b(Coroutine boundary", "\b", "\b", -1);
    L16:
        r8[r6] = r11;
        r6 = r6 + 1;
        goto L12
    L15:
        r11 = r10[(r3 + r6) - 1];
        goto L16
    L17:
        r0.setStackTrace(r8);
        return r0;
    L10:
        r5 = r1 - r4;
        goto L11
    L19:
        return r9;
    }

    public static final Throwable d(Throwable r7) {
        Throwable r0 = r7.getCause();
        if (r0 != null) goto L5;
    L13:
        return r7;
    L5:
        if ((!r0.getClass().equals(r7.getClass())) == true) goto L13;
        StackTraceElement[] r1 = r7.getStackTrace();
        int r2 = r1.length;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L13;
        if (StringsKt.F(r1[r4].getClassName(), "\b\b\b", false) == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        return r0;
    }
}
