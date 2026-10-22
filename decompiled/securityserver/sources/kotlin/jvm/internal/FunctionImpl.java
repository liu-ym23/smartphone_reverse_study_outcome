package kotlin.jvm.internal;

import a.a;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Deprecated
public abstract class FunctionImpl implements Function, Serializable, Function0, Function1, Function2, Function3, Function4, Function5, Function6, Function7, Function8, Function9, Function10, Function11, Function12, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function20, Function21, Function22 {
    @Override // kotlin.jvm.functions.Function9
    public final Object a() {
        c(9);
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r1, Object r2, Object r3) {
        c(3);
        throw new UnsupportedOperationException();
    }

    public final void c(int r4) {
        if (getArity() != r4) goto L5;
        return;
    L5:
        StringBuilder r5 = a.p(r4, "Wrong function arity, expected: ", ", actual: ");
        r5.append(getArity());
        throw new IllegalStateException(r5.toString());
    }

    public abstract int getArity();

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        c(0);
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        c(1);
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        c(2);
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object r1, Object r2, Object r3, Object r4) {
        c(4);
        throw new UnsupportedOperationException();
    }
}
