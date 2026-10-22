package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {
    public static final Key e = null;
    public final long c;

    @Metadata
    public static final class Key implements CoroutineContext.Key<CoroutineId> {
    }

    static {
        e = new Key();
    }

    public CoroutineId(long r2) {
        super(e);
        this.c = r2;
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final void D(Object r1) {
        Thread r0 = Thread.currentThread();
        r0.setName((String) r1);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final Object H(Object r1, Function2 r2) {
        return r2.mo7invoke(r1, this);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final Object K(CoroutineContext r5) {
        CoroutineName r6 = (CoroutineName) r5.f(CoroutineName.c);
        Thread r7 = Thread.currentThread();
        String r0 = r7.getName();
        int r1 = StringsKt.u(6, r0, " @");
        if (r1 >= 0) goto L5;
        r1 = r0.length();
    L5:
        StringBuilder r3 = new StringBuilder(r1 + 19);
        String r2 = r0.substring(0, r1);
        Intrinsics.e(r2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        r3.append(r2);
        r3.append(" @coroutine#");
        r3.append(this.c);
        String r4 = r3.toString();
        Intrinsics.e(r4, "StringBuilder(capacity).…builderAction).toString()");
        r7.setName(r4);
        return r0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CoroutineId) == true) goto L6;
        return false;
    L6:
        if (this.c == ((CoroutineId) r3).c) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element f(CoroutineContext.Key r1) {
        return CoroutineContext.Element.DefaultImpls.a(this, r1);
    }

    public final int hashCode() {
        long r1 = this.c;
        return (int) (r1 ^ (r1 >>> 32));
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext i(CoroutineContext r1) {
        return CoroutineContext.Element.DefaultImpls.c(this, r1);
    }

    public final String toString() {
        return "CoroutineId(" + this.c + ')';
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext v(CoroutineContext.Key r1) {
        return CoroutineContext.Element.DefaultImpls.b(this, r1);
    }
}
