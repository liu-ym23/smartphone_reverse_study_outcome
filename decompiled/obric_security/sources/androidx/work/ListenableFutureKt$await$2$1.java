package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "run"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ CancellableContinuation<R> $cancellableContinuation;
    final /* synthetic */ ListenableFuture<R> $this_await;

    /* JADX WARN: Multi-variable type inference failed */
    public ListenableFutureKt$await$2$1(CancellableContinuation<? super R> r1, ListenableFuture<R> r2) {
        this.$cancellableContinuation = r1;
        this.$this_await = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Continuation r0 = this.$cancellableContinuation;     // Catch: Throwable -> L4
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L4
        r0.resumeWith(Result.m774constructorimpl(this.$this_await.get()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Throwable r2 = th.getCause();
        if (r2 != null) goto L9;
        r2 = th;
    L9:
        if ((th instanceof CancellationException) == false) goto L11;
        this.$cancellableContinuation.cancel(r2);
        return;
    L11:
        Continuation r3 = this.$cancellableContinuation;
        Result.Companion r4 = Result.Companion;
        r3.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r2)));
    }
}
