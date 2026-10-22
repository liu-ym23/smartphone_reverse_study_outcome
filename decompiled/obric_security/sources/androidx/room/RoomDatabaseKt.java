package androidx.room;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.ThreadContextElementKt;

/* JADX INFO: compiled from: RoomDatabaseExt.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a9\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"acquireTransactionThread", "Lkotlin/coroutines/ContinuationInterceptor;", "Ljava/util/concurrent/Executor;", "controlJob", "Lkotlinx/coroutines/Job;", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RoomDatabaseKt {

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: RoomDatabaseExt.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabaseExt.kt", i = {0, 0}, l = {100}, m = "createTransactionContext", n = {"$this$createTransactionContext", "controlJob"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.access$createTransactionContext(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RoomDatabaseExt.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabaseExt.kt", i = {0, 0}, l = {51, 52}, m = "withTransaction", n = {"$this$withTransaction", "block"}, s = {"L$0", "L$1"})
    static final class C01281<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01281(Continuation<? super C01281> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.withTransaction(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RoomDatabaseExt.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabaseExt.kt", i = {0}, l = {59}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
    static final class C01292<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        final /* synthetic */ RoomDatabase $this_withTransaction;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C01292(RoomDatabase r1, Function1<? super Continuation<? super R>, ? extends Object> r2, Continuation<? super C01292> r3) {
            this.$this_withTransaction = r1;
            this.$block = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01292 r0 = new C01292(this.$this_withTransaction, this.$block, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super R> r2) {
            return ((C01292) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            TransactionElement r2 = (TransactionElement) this.L$0;
            ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L8
            TransactionElement r3 = r2;
        L18:
            this.$this_withTransaction.setTransactionSuccessful();     // Catch: Throwable -> L8
            this.$this_withTransaction.endTransaction();     // Catch: Throwable -> L26
            r3.release();
            return r5;
        L8:
            Throwable th = th;
        L24:
            this.$this_withTransaction.endTransaction();     // Catch: Throwable -> L26
            throw th;     // Catch: Throwable -> L26
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r5);
            CoroutineContext.Element r6 = ((CoroutineScope) this.L$0).getCoroutineContext().get(TransactionElement.Key);
            Intrinsics.checkNotNull(r6);
            TransactionElement r7 = (TransactionElement) r6;
            r7.acquire();
            this.$this_withTransaction.beginTransaction();     // Catch: Throwable -> L28
            Function1<Continuation<? super R>, Object> r4 = this.$block;     // Catch: Throwable -> L22
            this.L$0 = r7;     // Catch: Throwable -> L22
            this.label = 1;     // Catch: Throwable -> L22
            Object r8 = r4.invoke(this);     // Catch: Throwable -> L22
            if (r8 != r0) goto L17;
            return r0;
        L17:
            r3 = r7;
            r5 = r8;
        L22:
            th = move-exception;
            th = th;
        L28:
            th = th;
        L29:
            r7.release();
            throw th;
        L26:
            th = th;
            r7 = r0;
            goto L29
        }
    }

    public static final /* synthetic */ Object access$acquireTransactionThread(Executor r0, Job r1, Continuation r2) {
        return acquireTransactionThread(r0, r1, r2);
    }

    public static final /* synthetic */ Object access$createTransactionContext(RoomDatabase r0, Continuation r1) {
        return createTransactionContext(r0, r1);
    }

    public static final <R> Object withTransaction(RoomDatabase r5, Function1<? super Continuation<? super R>, ? extends Object> r6, Continuation<? super R> r7) {
        if ((r7 instanceof C01281) == false) goto L7;
        C01281 r0 = (C01281) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L28:
        return r8;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (Function1) r0.L$1;
        r5 = (RoomDatabase) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L24:
        ContinuationInterceptor r9 = (CoroutineContext) r8;
    L25:
        C01292 r3 = new C01292(r5, r6, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        r8 = BuildersKt.withContext(r9, r3, r0);
        if (r8 != r1) goto L28;
        return r1;
    L16:
        ResultKt.throwOnFailure(r8);
        TransactionElement r10 = (TransactionElement) r0.getContext().get(TransactionElement.Key);
        if (r10 == null) goto L21;
        ContinuationInterceptor r11 = r10.getTransactionDispatcher$room_ktx_release();
        if (r11 == null) goto L21;
        r9 = r11;
    L21:
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        r8 = createTransactionContext(r5, r0);
        if (r8 != r1) goto L24;
        return r1;
    L7:
        r0 = new C01281(r7);
        goto L8
    }

    private static final Object createTransactionContext(RoomDatabase r6, Continuation<? super CoroutineContext> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        CompletableJob r9 = (CompletableJob) r0.L$1;
        RoomDatabase r3 = (RoomDatabase) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        ContinuationInterceptor r10 = (ContinuationInterceptor) r8;
        TransactionElement r4 = new TransactionElement(r9, r10);
        return r10.plus(r4).plus(ThreadContextElementKt.asContextElement(r3.getSuspendingTransactionId(), Boxing.boxInt(System.identityHashCode(r9))));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        final CompletableJob r11 = JobKt.Job$default(null, 1, null);
        Job r5 = (Job) r0.getContext().get(Job.Key);
        if (r5 == null) goto L17;
        r5.invokeOnCompletion(new AnonymousClass2(r11));
    L17:
        r0.L$0 = r6;
        r0.L$1 = r11;
        r0.label = 1;
        Object r12 = acquireTransactionThread(r6.getTransactionExecutor(), r11, r0);
        if (r12 != r1) goto L20;
        return r1;
    L20:
        r3 = r6;
        r9 = r11;
        r8 = r12;
    L7:
        r0 = new AnonymousClass1(r7);
        goto L8
    }

    private static final Object acquireTransactionThread(Executor r3, final Job r4, Continuation<? super ContinuationInterceptor> r5) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r5), 1);
        r0.initCancellability();
        final CancellableContinuationImpl r1 = r0;
        r1.invokeOnCancellation(new RoomDatabaseKt$acquireTransactionThread$2$1(r4));
        r3.execute(new RoomDatabaseKt$acquireTransactionThread$2$2(r1, r4));     // Catch: RejectedExecutionException -> L5
    L7:
        Object r6 = r0.getResult();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L10:
        return r6;
    L5:
        e = move-exception;
        r1.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        goto L7
    }
}
