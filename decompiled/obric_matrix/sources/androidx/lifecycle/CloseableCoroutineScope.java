package androidx.lifecycle;

import h.a.b2;
import h.a.m0;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.k0.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "close", "", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CloseableCoroutineScope implements Closeable, m0 {
    private final g coroutineContext;

    public CloseableCoroutineScope(g r2) {
        o.f(r2, "context");
        this.coroutineContext = r2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b2.d(getCoroutineContext(), null, 1, null);
    }

    @Override // h.a.m0
    public g getCoroutineContext() {
        return this.coroutineContext;
    }
}
