package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    public final Continuation b;

    public BaseContinuationImpl(Continuation r1) {
        this.b = r1;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame e() {
        Continuation r1 = this.b;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r1;
    }

    public Continuation f(Object r1, Continuation r2) {
        Intrinsics.f(r2, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public Continuation h(Continuation r1) {
        Intrinsics.f(r1, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public abstract Object i(Object r1);

    public void j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // kotlin.coroutines.Continuation
    public final void k(Object r3) {
    L2:
        BaseContinuationImpl r2 = (BaseContinuationImpl) r2;
        Continuation r0 = r2.b;
        Intrinsics.c(r0);
        r3 = r2.i(r3);     // Catch: Throwable -> L6
        if (r3 == CoroutineSingletons.b) goto L5;
    L8:
        r2.j();
        if ((r0 instanceof BaseContinuationImpl) == false) goto L11;
        ?? r4 = r0;
        goto L2
    L11:
        r0.k(r3);
        return;
    L5:
        return;
    L6:
        th = move-exception;
        r3 = ResultKt.a(th);
        goto L8
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Continuation at ");
        Object r1 = w();
        if (r1 != null) goto L6;
        r1 = getClass().getName();
    L6:
        r0.append(r1);
        return r0.toString();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement w() {
        DebugMetadata r0 = (DebugMetadata) getClass().getAnnotation(DebugMetadata.class);
        String r1 = null;
        if (r0 == null) goto L58;
        int r2 = r0.v();
        if (r2 > 1) goto L53;
        int r3 = -1;
        Field r4 = getClass().getDeclaredField("label");     // Catch: Exception -> L17
        r4.setAccessible(true);     // Catch: Exception -> L17
        Object r5 = r4.get(this);     // Catch: Exception -> L17
        if ((r5 instanceof Integer) == false) goto L11;
        Integer r6 = (Integer) r5;     // Catch: Exception -> L17
    L12:
        if (r6 == null) goto L15;
        int r7 = r6.intValue();     // Catch: Exception -> L17
    L16:
        int r8 = r7 - 1;
    L18:
        if (r8 < 0) goto L21;
        r3 = r0.l()[r8];
    L21:
        ModuleNameRetriever.Cache r9 = ModuleNameRetriever.b;
        ModuleNameRetriever.Cache r10 = ModuleNameRetriever.f337a;
        if (r9 == null) goto L56;
    L26:
        if (r9 == r10) goto L47;
        Method r11 = r9.f338a;
        if (r11 == null) goto L31;
        Object r12 = r11.invoke(getClass(), null);
    L32:
        if (r12 == null) goto L47;
        Method r13 = r9.b;
        if (r13 == null) goto L37;
        Object r14 = r13.invoke(r12, null);
    L38:
        if (r14 == null) goto L47;
        Method r15 = r9.c;
        if (r15 == null) goto L43;
        Object r16 = r15.invoke(r14, null);
    L45:
        if ((r16 instanceof String) == false) goto L47;
        r1 = (String) r16;
        goto L47
    L43:
        r16 = null;
        goto L45
    L37:
        r14 = null;
        goto L38
    L31:
        r12 = null;
    L47:
        if (r1 != null) goto L49;
        String r17 = r0.c();
    L51:
        return new StackTraceElement(r17, r0.m(), r0.f(), r3);
    L49:
        r17 = r1 + '/' + r0.c();
        goto L51
    L56:
        ModuleNameRetriever.Cache r18 = new ModuleNameRetriever.Cache(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));     // Catch: Exception -> L25
        ModuleNameRetriever.b = r18;     // Catch: Exception -> L25
        r9 = r18;
    L25:
        ModuleNameRetriever.b = r10;
        r9 = r10;
        goto L26
    L15:
        r7 = 0;
        goto L16
    L11:
        r6 = null;
    L17:
        r8 = -1;
        goto L18
    L53:
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + r2 + ". Please update the Kotlin standard library.").toString());
    L58:
        return null;
    }
}
