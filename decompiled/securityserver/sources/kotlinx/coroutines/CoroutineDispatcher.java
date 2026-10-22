package kotlinx.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements ContinuationInterceptor {
    public static final Key c = null;

    @Metadata
    @ExperimentalStdlibApi
    public static final class Key extends AbstractCoroutineContextKey<ContinuationInterceptor, CoroutineDispatcher> {

        /* JADX INFO: renamed from: kotlinx.coroutines.CoroutineDispatcher$Key$1, reason: invalid class name */
        @Metadata
        final class AnonymousClass1 extends Lambda implements Function1<CoroutineContext.Element, CoroutineDispatcher> {
            public static final AnonymousClass1 b = null;

            static {
                b = new AnonymousClass1(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object r1) {
                CoroutineContext.Element r2 = (CoroutineContext.Element) r1;
                if ((r2 instanceof CoroutineDispatcher) == true) goto L6;
                r2 = null;
            L6:
                return (CoroutineDispatcher) r2;
            }
        }
    }

    static {
        c = new Key(ContinuationInterceptor.Key.f336a, Key.AnonymousClass1.b);
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key.f336a);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final DispatchedContinuation C(ContinuationImpl r2) {
        return new DispatchedContinuation(this, r2);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void b(Continuation r1) {
        if (r1 == null) goto L8;
        CancellableContinuationImpl r0 = ((DispatchedContinuation) r1).n();
        if (r0 == null) goto L9;
        r0.p();
        return;
    L9:
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.CoroutineContext$Element] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element f(CoroutineContext.Key r4) {
        Intrinsics.f(r4, "key");
        if ((r4 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r5 = (AbstractCoroutineContextKey) r4;
        CoroutineContext.Key r1 = this.b;
        Intrinsics.f(r1, "key");
        if (r1 != r5) goto L7;
    L8:
        CoroutineContext.Element r3 = (CoroutineContext.Element) r5.f334a.invoke(this);
        boolean r6 = r3 instanceof CoroutineContext.Element;
        ?? r7 = r3;
        if (r6 == true) goto L16;
        return null;
    L16:
        return r7;
    L7:
        if (r5.b == r1) goto L8;
        return null;
    L11:
        this = this;
        if (ContinuationInterceptor.Key.f336a == r4) goto L16;
        r7 = 0;
        goto L16
    }

    public abstract void j(CoroutineContext r1, Runnable r2);

    public void k(CoroutineContext r1, Runnable r2) {
        j(r1, r2);
    }

    public boolean l() {
        return !(this instanceof Unconfined);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext v(CoroutineContext.Key r4) {
        Intrinsics.f(r4, "key");
        boolean r1 = r4 instanceof AbstractCoroutineContextKey;
        EmptyCoroutineContext r2 = EmptyCoroutineContext.b;
        if (r1 == false) goto L12;
        AbstractCoroutineContextKey r5 = (AbstractCoroutineContextKey) r4;
        CoroutineContext.Key r3 = this.b;
        Intrinsics.f(r3, "key");
        if (r3 == r5) goto L9;
        if (r5.b == r3) goto L9;
        return this;
    L9:
        if (((CoroutineContext.Element) r5.f334a.invoke(this)) != null) goto L16;
        return this;
    L16:
        return r2;
    L12:
        if (ContinuationInterceptor.Key.f336a == r4) goto L16;
        return this;
    }
}
