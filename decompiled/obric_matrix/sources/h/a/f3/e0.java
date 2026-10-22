package h.a.f3;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\t\u001a\u00020\u0001H\u0007\u001a9\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a1\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00192\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0010H\u0002¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a+\u0010\u001f\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\"\u001a,\u0010!\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030#H\u0080\b¢\u0006\u0002\u0010$\u001a!\u0010%\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\"\u001a \u0010&\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0080\b¢\u0006\u0002\u0010\"\u001a\u001f\u0010'\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\"\u001a1\u0010(\u001a\u0018\u0012\u0004\u0012\u0002H\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00190)\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0002¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020,*\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\bH\u0002\u001a#\u0010.\u001a\u00020/*\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00192\u0006\u00100\u001a\u00020\u0001H\u0002¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0017*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000\u001a\u0010\u00103\u001a\u00020,*\u00060\u0007j\u0002`\bH\u0000\u001a\u001b\u00104\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0002¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u00105\"\u00020\u00142\u00020\u0014*\f\b\u0000\u00106\"\u00020\u00072\u00020\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "message", "createFinalException", "E", "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "tryCopyAndVerify", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f17365a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17366b = null;

    static {
        kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L4
        Object r1 = Class.forName("kotlin.k0.j.a.a").getCanonicalName();     // Catch: Throwable -> L4
        kotlin.v.b(r1);     // Catch: Throwable -> L4
    L7:
        if (kotlin.v.d(r1) == null) goto L10;
        r1 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    L10:
        f17365a = (String) r1;
        kotlin.v.a r2 = kotlin.v.f21457g;     // Catch: Throwable -> L13
        Object r3 = Class.forName("h.a.f3.e0").getCanonicalName();     // Catch: Throwable -> L13
        kotlin.v.b(r3);     // Catch: Throwable -> L13
    L16:
        if (kotlin.v.d(r3) == null) goto L19;
        r3 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    L19:
        f17366b = (String) r3;
        return;
    L13:
        th = move-exception;
        kotlin.v.a r4 = kotlin.v.f21457g;
        r3 = kotlin.w.a(th);
        kotlin.v.b(r3);
    L4:
        th = move-exception;
        kotlin.v.a r5 = kotlin.v.f21457g;
        r1 = kotlin.w.a(th);
        kotlin.v.b(r1);
        goto L7
    }

    public static final /* synthetic */ Throwable a(Throwable r0, kotlin.k0.j.a.e r1) {
        return j(r0, r1);
    }

    public static final StackTraceElement b(String r3) {
        return new StackTraceElement(kotlin.n0.d.o.m("\b\b\b(", r3), "\b", "\b", -1);
    }

    private static final <E extends Throwable> kotlin.u<E, StackTraceElement[]> c(E r6) {
        Throwable r0 = r6.getCause();
        if (r0 == null) goto L16;
        if (kotlin.n0.d.o.a(r0.getClass(), r6.getClass()) == false) goto L16;
        StackTraceElement[] r2 = r6.getStackTrace();
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L11;
        StackTraceElement r5 = r2[r4];
        r4 = r4 + 1;
        if (h(r5) == false) goto L7;
        boolean r7 = true;
    L12:
        if (r7 == false) goto L21;
        return kotlin.a0.a(r0, r2);
    L21:
        return kotlin.a0.a(r6, new StackTraceElement[0]);
    L11:
        r7 = false;
    L16:
        return kotlin.a0.a(r6, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E d(E r6, E r7, ArrayDeque<StackTraceElement> r8) {
        r8.addFirst(b("Coroutine boundary"));
        StackTraceElement[] r9 = r6.getStackTrace();
        int r0 = g(r9, f17365a);
        int r1 = 0;
        if (r0 != (-1)) goto L6;
        Object[] r10 = r8.toArray(new StackTraceElement[0]);
        Objects.requireNonNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        r7.setStackTrace((StackTraceElement[]) r10);
        return r7;
    L6:
        StackTraceElement[] r2 = new StackTraceElement[r8.size() + r0];
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r2[r3] = r9[r3];
        r3 = r3 + 1;
        goto L7
    L9:
        Iterator<StackTraceElement> r11 = r8.iterator();
    L11:
        if (r11.hasNext() == false) goto L13;
        int r12 = r1 + 1;
        r2[r1 + r0] = r11.next();
        r1 = r12;
        goto L11
    L13:
        r7.setStackTrace(r2);
        return r7;
    }

    private static final ArrayDeque<StackTraceElement> e(kotlin.k0.j.a.e r3) {
        ArrayDeque<StackTraceElement> r0 = new ArrayDeque();
        StackTraceElement r1 = r3.getStackTraceElement();
        if (r1 == null) goto L7;
        r0.add(r1);
    L7:
        if ((r3 instanceof kotlin.k0.j.a.e) == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L12;
        r3 = null;
    L13:
        if (r3 == null) goto L14;
        StackTraceElement r2 = r3.getStackTraceElement();
        if (r2 == null) goto L7;
        r0.add(r2);
        goto L7
    L14:
        return r0;
    L12:
        r3 = r3.getCallerFrame();
        goto L13
    }

    private static final boolean f(StackTraceElement r2, StackTraceElement r3) {
        if (r2.getLineNumber() == r3.getLineNumber()) goto L5;
    L11:
        return false;
    L5:
        if (kotlin.n0.d.o.a(r2.getMethodName(), r3.getMethodName()) == false) goto L11;
        if (kotlin.n0.d.o.a(r2.getFileName(), r3.getFileName()) == false) goto L11;
        if (kotlin.n0.d.o.a(r2.getClassName(), r3.getClassName()) == false) goto L11;
        return true;
    }

    private static final int g(StackTraceElement[] r4, String r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r1 + 1;
        if (kotlin.n0.d.o.a(r5, r4[r1].getClassName()) == true) goto L12;
        r1 = r2;
        goto L3
    L12:
        return r1;
    L8:
        return -1;
    }

    public static final boolean h(StackTraceElement r4) {
        return kotlin.u0.k.A(r4.getClassName(), "\b\b\b", false, 2, null);
    }

    private static final void i(StackTraceElement[] r5, ArrayDeque<StackTraceElement> r6) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r1 + 1;
        if (h(r5[r1]) == true) goto L9;
        r1 = r2;
    L9:
        int r3 = r1 + 1;
        int r4 = r5.length - 1;
        if (r3 > r4) goto L18;
    L11:
        int r7 = r4 - 1;
        if (f(r5[r4], r6.getLast()) == false) goto L14;
        r6.removeLast();
    L14:
        r6.addFirst(r5[r4]);
        if (r4 == r3) goto L22;
        r4 = r7;
        goto L11
    L22:
        return;
    L18:
        return;
    L8:
        r1 = -1;
        goto L9
    }

    private static final <E extends Throwable> E j(E r4, kotlin.k0.j.a.e r5) {
        kotlin.u r0 = c(r4);
        Throwable r1 = (Throwable) r0.a();
        StackTraceElement[] r2 = (StackTraceElement[]) r0.b();
        E r3 = (E) m(r1);
        if (r3 != null) goto L5;
        return r4;
    L5:
        ArrayDeque<StackTraceElement> r6 = e(r5);
        if (r6.isEmpty() == false) goto L8;
        return r4;
    L8:
        if (r1 == r4) goto L10;
        i(r2, r6);
    L10:
        d(r1, r3, r6);
        return r3;
    }

    public static final <E extends Throwable> E k(E r1) {
        if (h.a.q0.d() == true) goto L5;
        return r1;
    L5:
        E r0 = (E) m(r1);
        if (r0 != null) goto L8;
        return r1;
    L8:
        l(r0);
        return r0;
    }

    private static final <E extends Throwable> E l(E r7) {
        StackTraceElement[] r0 = r7.getStackTrace();
        int r1 = r0.length;
        int r2 = g(r0, f17366b);
        int r3 = r2 + 1;
        int r4 = g(r0, f17365a);
        int r5 = 0;
        if (r4 != (-1)) goto L5;
        int r6 = 0;
    L6:
        int r8 = (r1 - r2) - r6;
        StackTraceElement[] r9 = new StackTraceElement[r8];
    L7:
        if (r5 >= r8) goto L12;
        if (r5 != 0) goto L10;
        StackTraceElement r10 = b("Coroutine boundary");
    L11:
        r9[r5] = r10;
        r5 = r5 + 1;
        goto L7
    L10:
        r10 = r0[(r3 + r5) - 1];
        goto L11
    L12:
        r7.setStackTrace(r9);
        return r7;
    L5:
        r6 = r1 - r4;
        goto L6
    }

    private static final <E extends Throwable> E m(E r3) {
        E r0 = (E) k.g(r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof h.a.e0) == false) goto L8;
    L10:
        return r0;
    L8:
        if (kotlin.n0.d.o.a(r0.getMessage(), r3.getMessage()) == true) goto L10;
        return null;
    }

    public static final <E extends Throwable> E n(E r6) {
        E r0 = (E) r6.getCause();
        if (r0 != null) goto L5;
    L14:
        return r6;
    L5:
        if (kotlin.n0.d.o.a(r0.getClass(), r6.getClass()) == false) goto L14;
        StackTraceElement[] r1 = r6.getStackTrace();
        int r2 = r1.length;
        boolean r3 = false;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L12;
        StackTraceElement r5 = r1[r4];
        r4 = r4 + 1;
        if (h(r5) == false) goto L8;
        r3 = true;
    L12:
        if (r3 == false) goto L14;
        return r0;
    }
}
