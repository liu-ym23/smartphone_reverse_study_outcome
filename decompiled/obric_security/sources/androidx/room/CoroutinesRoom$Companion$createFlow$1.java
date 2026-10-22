package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: CoroutinesRoom.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\r\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/jvm/JvmSuppressWildcards;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesRoom$Companion$createFlow$1<R> extends SuspendLambda implements Function2<FlowCollector<R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutinesRoom.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<R> $$this$flow;
        final /* synthetic */ Callable<R> $callable;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CoroutinesRoom.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", i = {}, l = {127, 129}, m = "invokeSuspend", n = {}, s = {})
        static final class C00131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Callable<R> $callable;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$1$observer$1 $observer;
            final /* synthetic */ Channel<Unit> $observerChannel;
            final /* synthetic */ Channel<R> $resultChannel;
            Object L$0;
            int label;

            C00131(RoomDatabase r1, CoroutinesRoom$Companion$createFlow$1$1$observer$1 r2, Channel<Unit> r3, Callable<R> r4, Channel<R> r5, Continuation<? super C00131> r6) {
                this.$db = r1;
                this.$observer = r2;
                this.$observerChannel = r3;
                this.$callable = r4;
                this.$resultChannel = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                return new C00131(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, r9);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00131) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006c -> B:8:0x0015). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r8) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L11;
                if (r1 != 2) goto L10;
                ChannelIterator<Unit> r2 = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L27
            L8:
                ChannelIterator<Unit> r9 = r2;
            L16:
                this.L$0 = r9;     // Catch: Throwable -> L27
                this.label = 1;     // Catch: Throwable -> L27
                Object r3 = r9.hasNext(this);     // Catch: Throwable -> L27
                if (r3 != r0) goto L19;
                return r0;
            L19:
                r2 = r9;
                r8 = r3;
            L21:
                if (((Boolean) r8).booleanValue() == false) goto L25;
                r2.next();     // Catch: Throwable -> L27
                R r10 = this.$callable.call();     // Catch: Throwable -> L27
                this.L$0 = r2;     // Catch: Throwable -> L27
                this.label = 2;     // Catch: Throwable -> L27
                if (this.$resultChannel.send(r10, this) != r0) goto L8;
                return r0;
            L25:
                this.$db.getInvalidationTracker().removeObserver(this.$observer);
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                r2 = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L27
                goto L21
            L14:
                ResultKt.throwOnFailure(r8);
                this.$db.getInvalidationTracker().addObserver(this.$observer);
                r9 = this.$observerChannel.iterator();     // Catch: Throwable -> L27
            L27:
                th = move-exception;
                this.$db.getInvalidationTracker().removeObserver(this.$observer);
                throw th;
            }
        }

        AnonymousClass1(boolean r1, RoomDatabase r2, FlowCollector<R> r3, String[] r4, Callable<R> r5, Continuation<? super AnonymousClass1> r6) {
            this.$inTransaction = r1;
            this.$db = r2;
            this.$$this$flow = r3;
            this.$tableNames = r4;
            this.$callable = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, r10);
            r7.L$0 = r9;
            return r7;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L21:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            final Channel r8 = ChannelKt.Channel$default(-1, null, null, 6, null);
            final String[] r15 = this.$tableNames;
            ?? r7 = new CoroutinesRoom$Companion$createFlow$1$1$observer$1(r15, r8);
            r8.mo2281trySendJP2dKIU(Unit.INSTANCE);
            TransactionElement r16 = (TransactionElement) r3.getCoroutineContext().get(TransactionElement.Key);
            if (r16 == null) goto L13;
            CoroutineDispatcher r17 = r16.getTransactionDispatcher$room_ktx_release();
            if (r17 == null) goto L13;
        L17:
            Channel r2 = ChannelKt.Channel$default(0, null, null, 7, null);
            BuildersKt.launch$default(r3, r17, null, new C00131(this.$db, r7, r8, this.$callable, r2, null), 2, null);
            this.label = 1;
            if (FlowKt.emitAll(this.$$this$flow, r2, this) != r0) goto L21;
            return r0;
        L13:
            if (this.$inTransaction == false) goto L15;
            CoroutineDispatcher r18 = CoroutinesRoomKt.getTransactionDispatcher(this.$db);
        L16:
            r17 = r18;
            goto L17
        L15:
            r18 = CoroutinesRoomKt.getQueryDispatcher(this.$db);
            goto L16
        }
    }

    CoroutinesRoom$Companion$createFlow$1(boolean r1, RoomDatabase r2, String[] r3, Callable<R> r4, Continuation<? super CoroutinesRoom$Companion$createFlow$1> r5) {
        this.$inTransaction = r1;
        this.$db = r2;
        this.$tableNames = r3;
        this.$callable = r4;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CoroutinesRoom$Companion$createFlow$1 r6 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, r9);
        r6.L$0 = r8;
        return r6;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
        return invoke((FlowCollector) r1, r2);
    }

    public final Object invoke(FlowCollector<R> r1, Continuation<? super Unit> r2) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        FlowCollector r6 = (FlowCollector) this.L$0;
        this.label = 1;
        if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.$inTransaction, this.$db, r6, this.$tableNames, this.$callable, null), this) != r0) goto L12;
        return r0;
    }
}
