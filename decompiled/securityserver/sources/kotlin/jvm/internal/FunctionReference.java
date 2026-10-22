package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes2.dex */
public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    public final int b;
    public final int c;

    public FunctionReference(int r9, Object r10, Class r11, String r12, String r13, int r14) {
        if ((r14 & 1) != 1) goto L5;
        boolean r7 = true;
    L6:
        super(r10, r11, r12, r13, r7);
        this.b = r9;
        this.c = 0;
        return;
    L5:
        r7 = false;
        goto L6
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KCallable computeReflected() {
        Reflection.f343a.getClass();
        return this;
    }

    public KFunction e() {
        return (KFunction) super.getReflected();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof FunctionReference) == false) goto L23;
        FunctionReference r6 = (FunctionReference) r5;
        if (getName().equals(r6.getName()) == false) goto L21;
        if (getSignature().equals(r6.getSignature()) == false) goto L21;
        if (this.c != r6.c) goto L21;
        if (this.b != r6.b) goto L21;
        if (Intrinsics.a(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L21;
        if (Intrinsics.a(getOwner(), r6.getOwner()) == false) goto L21;
        return true;
    L21:
        return false;
    L23:
        if ((r5 instanceof KFunction) == true) goto L25;
        return false;
    L25:
        return r5.equals(compute());
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public final int getArity() {
        return this.b;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return e();
    }

    public int hashCode() {
        if (getOwner() != null) goto L5;
        int r0 = 0;
    L6:
        int r1 = (getName().hashCode() + r0) * 31;
        return getSignature().hashCode() + r1;
    L5:
        r0 = getOwner().hashCode() * 31;
        goto L6
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final boolean isSuspend() {
        return e().isSuspend();
    }

    public String toString() {
        KCallable r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        if ("<init>".equals(getName()) == false) goto L10;
        return "constructor (Kotlin reflection is not available)";
    L10:
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
