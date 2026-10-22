package h.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020\u000fB0\u0012'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR5\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class v1 extends z1 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17571k = null;
    private volatile /* synthetic */ int _invoked;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.n0.c.l<Throwable, kotlin.f0> f17572j;

    static {
        f17571k = AtomicIntegerFieldUpdater.newUpdater(v1.class, "_invoked");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v1(kotlin.n0.c.l<? super Throwable, kotlin.f0> r1) {
        this.f17572j = r1;
        this._invoked = 0;
    }

    @Override // h.a.a0
    public void C(Throwable r4) {
        if (f17571k.compareAndSet(this, 0, 1) == false) goto L6;
        this.f17572j.invoke(r4);
        return;
    }

    @Override // kotlin.n0.c.l
    public /* bridge */ /* synthetic */ kotlin.f0 invoke(Throwable r1) {
        C(r1);
        return kotlin.f0.f18324a;
    }
}
