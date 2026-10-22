package kotlinx.coroutines;

import android.security.bytedance.guard.BDSecurityGuardStub;
import com.android.settingslib.mobile.dataservice.DataServiceUtils;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u001a\u0019\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\b\b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0002H\u0007\u001a\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u001e\u0010\f\u001a\u00020\r*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\f\u0010\u0016\u001a\u00020\r*\u00020\u0002H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\r*\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\f\u0010\u0016\u001a\u00020\r*\u00020\u0005H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\r*\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001a\u001c\u0010\u0016\u001a\u00020\r*\u00020\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u001a\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0000\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0002\u001a\n\u0010\u001a\u001a\u00020\r*\u00020\u0005\u001a\u001b\u0010\u001b\u001a\u00020\u000f*\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\u001c\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {DataServiceUtils.UiccInfoData.COLUMN_IS_ACTIVE, "", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "job", "Lkotlinx/coroutines/Job;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "disposeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handle", "ensureActive", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/JobKt")
final /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob Job(Job r1) {
        return new JobImpl(r1);
    }

    public static /* synthetic */ CompletableJob Job$default(Job r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = null;
    L6:
        return JobKt.Job(r0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* JADX INFO: renamed from: Job, reason: collision with other method in class */
    public static final /* synthetic */ Job m3003Job(Job r0) {
        return JobKt.Job(r0);
    }

    /* JADX INFO: renamed from: Job$default, reason: collision with other method in class */
    public static /* synthetic */ Job m3004Job$default(Job r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = null;
    L6:
        return JobKt.m3001Job(r0);
    }

    public static final DisposableHandle disposeOnCompletion(Job r1, DisposableHandle r2) {
        return r1.invokeOnCompletion(new DisposeOnCompletion(r2));
    }

    public static final Object cancelAndJoin(Job r2, Continuation<? super Unit> r3) {
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        Object r4 = r2.join(r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void cancelChildren$default(Job r0, CancellationException r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        JobKt.cancelChildren(r0, r1);
    }

    public static final void cancelChildren(Job r1, CancellationException r2) {
        Iterator<Job> r3 = r1.getChildren().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().cancel(r2);
        goto L4
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job r1) {
        JobKt.cancelChildren(r1, null);
    }

    public static /* synthetic */ void cancelChildren$default(Job r0, Throwable r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        JobKt.cancelChildren(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job r3, Throwable r4) {
        Iterator<Job> r0 = r3.getChildren().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Job r1 = r0.next();
        if ((r1 instanceof JobSupport) == false) goto L8;
        JobSupport r2 = (JobSupport) r1;
    L9:
        if (r2 == null) goto L4;
        r2.cancelInternal(orCancellation$JobKt__JobKt(r4, r3));
        goto L4
    L8:
        r2 = null;
        goto L9
    }

    public static final boolean isActive(CoroutineContext r1) {
        Job r2 = (Job) r1.get(Job.Key);
        if (r2 != null) goto L7;
        return true;
    L7:
        return r2.isActive();
    }

    public static /* synthetic */ void cancel$default(CoroutineContext r0, CancellationException r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        JobKt.cancel(r0, r1);
    }

    public static final void cancel(CoroutineContext r1, CancellationException r2) {
        Job r3 = (Job) r1.get(Job.Key);
        if (r3 == null) goto L6;
        r3.cancel(r2);
        return;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancel(CoroutineContext r1) {
        JobKt.cancel(r1, null);
    }

    public static final void ensureActive(Job r1) {
        if (r1.isActive() == false) goto L6;
        return;
    L6:
        throw r1.getCancellationException();
    }

    public static final void ensureActive(CoroutineContext r1) {
        Job r2 = (Job) r1.get(Job.Key);
        if (r2 == null) goto L6;
        JobKt.ensureActive(r2);
        return;
    }

    public static final void cancel(Job r0, String r1, Throwable r2) {
        r0.cancel(ExceptionsKt.CancellationException(r1, r2));
    }

    public static /* synthetic */ void cancel$default(Job r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        JobKt.cancel(r0, r1, r2);
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext r0, Throwable r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return JobKt.cancel(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext r1, Throwable r2) {
        CoroutineContext.Element r3 = r1.get(Job.Key);
        if ((r3 instanceof JobSupport) == false) goto L5;
        JobSupport r4 = (JobSupport) r3;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        r4.cancelInternal(orCancellation$JobKt__JobKt(r2, r4));
        return true;
    L5:
        r4 = null;
        goto L6
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext r0, CancellationException r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        JobKt.cancelChildren(r0, r1);
    }

    public static final void cancelChildren(CoroutineContext r1, CancellationException r2) {
        Job r3 = (Job) r1.get(Job.Key);
        if (r3 == null) goto L10;
        Sequence<Job> r4 = r3.getChildren();
        if (r4 == null) goto L12;
        Iterator<Job> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        r5.next().cancel(r2);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext r1) {
        JobKt.cancelChildren(r1, null);
    }

    public static final Job getJob(CoroutineContext r3) {
        Job r0 = (Job) r3.get(Job.Key);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + r3).toString());
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext r0, Throwable r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        JobKt.cancelChildren(r0, r1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext r3, Throwable r4) {
        Job r5 = (Job) r3.get(Job.Key);
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<Job> r0 = r5.getChildren().iterator();
    L7:
        if (r0.hasNext() == false) goto L14;
        Job r1 = r0.next();
        if ((r1 instanceof JobSupport) == false) goto L11;
        JobSupport r2 = (JobSupport) r1;
    L12:
        if (r2 == null) goto L7;
        r2.cancelInternal(orCancellation$JobKt__JobKt(r4, r5));
        goto L7
    L11:
        r2 = null;
        goto L12
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable r2, Job r3) {
        if (r2 == null) goto L4;
        return r2;
    L4:
        return new JobCancellationException("Job was cancelled", null, r3);
    }
}
