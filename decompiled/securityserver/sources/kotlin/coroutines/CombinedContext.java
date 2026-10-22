package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final class CombinedContext implements CoroutineContext, Serializable {
    public final CoroutineContext b;
    public final CoroutineContext.Element c;

    @Metadata
    public static final class Serialized implements Serializable {

        @Metadata
        public static final class Companion {
        }
    }

    /* JADX INFO: renamed from: kotlin.coroutines.CombinedContext$toString$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function2<String, CoroutineContext.Element, String> {
        public static final AnonymousClass1 b = null;

        static {
            b = new AnonymousClass1(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo7invoke(Object r1, Object r2) {
            String r3 = (String) r1;
            CoroutineContext.Element r4 = (CoroutineContext.Element) r2;
            Intrinsics.f(r3, "acc");
            Intrinsics.f(r4, "element");
            if (r3.length() != 0) goto L6;
            return r4.toString();
        L6:
            return r3 + ", " + r4;
        }
    }

    public CombinedContext(CoroutineContext.Element r2, CoroutineContext r3) {
        Intrinsics.f(r3, "left");
        Intrinsics.f(r2, "element");
        this.b = r3;
        this.c = r2;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object H(Object r2, Function2 r3) {
        return r3.mo7invoke(this.b.H(r2, r3), this.c);
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L4;
    L29:
        return true;
    L4:
        if ((r7 instanceof CombinedContext) == false) goto L35;
        CombinedContext r8 = (CombinedContext) r7;
        r8.getClass();
        int r0 = 2;
        CombinedContext r2 = r8;
        int r3 = 2;
    L6:
        CoroutineContext r4 = r2.b;
        if ((r4 instanceof CombinedContext) == false) goto L9;
        r2 = (CombinedContext) r4;
    L10:
        if (r2 == null) goto L11;
        r3 = r3 + 1;
        goto L6
    L11:
        CombinedContext r5 = this;
    L12:
        CoroutineContext r6 = r5.b;
        if ((r6 instanceof CombinedContext) == false) goto L15;
        r5 = (CombinedContext) r6;
    L16:
        if (r5 == null) goto L17;
        r0 = r0 + 1;
        goto L12
    L17:
        if (r3 != r0) goto L36;
    L18:
        CoroutineContext.Element r1 = this.c;
        if (Intrinsics.a(r8.f(r1.getKey()), r1) == false) goto L20;
        CoroutineContext r9 = this.b;
        if ((r9 instanceof CombinedContext) == false) goto L24;
        CombinedContext this = (CombinedContext) r9;
        goto L18
    L24:
        Intrinsics.d(r9, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        CoroutineContext.Element r10 = (CoroutineContext.Element) r9;
        boolean r11 = Intrinsics.a(r8.f(r10.getKey()), r10);
    L25:
        if (r11 == true) goto L29;
        return false;
    L20:
        r11 = false;
        goto L25
    L36:
        return false;
    L15:
        r5 = null;
        goto L16
    L9:
        r2 = null;
        goto L10
    L35:
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element f(CoroutineContext.Key r2) {
        Intrinsics.f(r2, "key");
    L3:
        CoroutineContext.Element r0 = this.c.f(r2);
        if (r0 != null) goto L5;
        CoroutineContext r1 = this.b;
        if ((r1 instanceof CombinedContext) == false) goto L10;
        CombinedContext this = (CombinedContext) r1;
        goto L3
    L10:
        return r1.f(r2);
    L5:
        return r0;
    }

    public final int hashCode() {
        int r0 = this.b.hashCode();
        return this.c.hashCode() + r0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext i(CoroutineContext r1) {
        return CoroutineContext.DefaultImpls.a(this, r1);
    }

    public final String toString() {
        return "[" + ((String) H("", AnonymousClass1.b)) + ']';
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext v(CoroutineContext.Key r4) {
        Intrinsics.f(r4, "key");
        CoroutineContext.Element r0 = this.c;
        CoroutineContext.Element r1 = r0.f(r4);
        CoroutineContext r2 = this.b;
        if (r1 == null) goto L5;
        return r2;
    L5:
        CoroutineContext r5 = r2.v(r4);
        if (r5 != r2) goto L9;
        return this;
    L9:
        if (r5 != EmptyCoroutineContext.b) goto L12;
        return r0;
    L12:
        return new CombinedContext(r0, r5);
    }
}
