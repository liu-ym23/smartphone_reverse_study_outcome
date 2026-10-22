package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class JobKt {
    public static final CompletableJob Job(Job r0) {
        return JobKt__JobKt.Job(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* JADX INFO: renamed from: Job, reason: collision with other method in class */
    public static final /* synthetic */ Job m3001Job(Job r0) {
        return JobKt__JobKt.m3003Job(r0);
    }

    public static /* synthetic */ CompletableJob Job$default(Job r0, int r1, Object r2) {
        return JobKt__JobKt.Job$default(r0, r1, r2);
    }

    /* JADX INFO: renamed from: Job$default, reason: collision with other method in class */
    public static /* synthetic */ Job m3002Job$default(Job r0, int r1, Object r2) {
        return JobKt__JobKt.m3004Job$default(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancel(CoroutineContext r0) {
        JobKt__JobKt.cancel(r0);
    }

    public static final void cancel(CoroutineContext r0, CancellationException r1) {
        JobKt__JobKt.cancel(r0, r1);
    }

    public static final void cancel(Job r0, String r1, Throwable r2) {
        JobKt__JobKt.cancel(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext r0, Throwable r1) {
        return JobKt__JobKt.cancel(r0, r1);
    }

    public static /* synthetic */ void cancel$default(CoroutineContext r0, CancellationException r1, int r2, Object r3) {
        JobKt__JobKt.cancel$default(r0, r1, r2, r3);
    }

    public static /* synthetic */ void cancel$default(Job r0, String r1, Throwable r2, int r3, Object r4) {
        JobKt__JobKt.cancel$default(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext r0, Throwable r1, int r2, Object r3) {
        return JobKt__JobKt.cancel$default(r0, r1, r2, r3);
    }

    public static final Object cancelAndJoin(Job r0, Continuation<? super Unit> r1) {
        return JobKt__JobKt.cancelAndJoin(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext r0) {
        JobKt__JobKt.cancelChildren(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext r0, Throwable r1) {
        JobKt__JobKt.cancelChildren(r0, r1);
    }

    public static final void cancelChildren(CoroutineContext r0, CancellationException r1) {
        JobKt__JobKt.cancelChildren(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job r0) {
        JobKt__JobKt.cancelChildren(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job r0, Throwable r1) {
        JobKt__JobKt.cancelChildren(r0, r1);
    }

    public static final void cancelChildren(Job r0, CancellationException r1) {
        JobKt__JobKt.cancelChildren(r0, r1);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext r0, Throwable r1, int r2, Object r3) {
        JobKt__JobKt.cancelChildren$default(r0, r1, r2, r3);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext r0, CancellationException r1, int r2, Object r3) {
        JobKt__JobKt.cancelChildren$default(r0, r1, r2, r3);
    }

    public static /* synthetic */ void cancelChildren$default(Job r0, Throwable r1, int r2, Object r3) {
        JobKt__JobKt.cancelChildren$default(r0, r1, r2, r3);
    }

    public static /* synthetic */ void cancelChildren$default(Job r0, CancellationException r1, int r2, Object r3) {
        JobKt__JobKt.cancelChildren$default(r0, r1, r2, r3);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> r0, Future<?> r1) {
        JobKt__FutureKt.cancelFutureOnCancellation(r0, r1);
    }

    public static final DisposableHandle cancelFutureOnCompletion(Job r0, Future<?> r1) {
        return JobKt__FutureKt.cancelFutureOnCompletion(r0, r1);
    }

    public static final DisposableHandle disposeOnCompletion(Job r0, DisposableHandle r1) {
        return JobKt__JobKt.disposeOnCompletion(r0, r1);
    }

    public static final void ensureActive(CoroutineContext r0) {
        JobKt__JobKt.ensureActive(r0);
    }

    public static final void ensureActive(Job r0) {
        JobKt__JobKt.ensureActive(r0);
    }

    public static final Job getJob(CoroutineContext r0) {
        return JobKt__JobKt.getJob(r0);
    }

    public static final boolean isActive(CoroutineContext r0) {
        return JobKt__JobKt.isActive(r0);
    }
}
