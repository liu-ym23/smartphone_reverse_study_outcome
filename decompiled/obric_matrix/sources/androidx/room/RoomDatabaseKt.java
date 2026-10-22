package androidx.room;

import h.a.b2;
import h.a.m0;
import h.a.t2;
import h.a.u2;
import h.a.w;
import h.a.x1;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.e;
import kotlin.k0.g;
import kotlin.k0.i.b;
import kotlin.k0.j.a.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.h;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b*\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "Lkotlin/k0/d;", "", "block", "withTransaction", "(Landroidx/room/RoomDatabase;Lkotlin/n0/c/l;Lkotlin/k0/d;)Ljava/lang/Object;", "Lkotlin/k0/g;", "createTransactionContext", "(Landroidx/room/RoomDatabase;Lkotlin/k0/d;)Ljava/lang/Object;", "Ljava/util/concurrent/Executor;", "Lh/a/x1;", "controlJob", "Lkotlin/k0/e;", "acquireTransactionThread", "(Ljava/util/concurrent/Executor;Lh/a/x1;Lkotlin/k0/d;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class RoomDatabaseKt {

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$1, reason: invalid class name */
    @f(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabase.kt", l = {99}, m = "createTransactionContext")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0082@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/room/RoomDatabase;", "Lkotlin/k0/d;", "Lkotlin/k0/g;", "continuation", "", "createTransactionContext", "(Landroidx/room/RoomDatabase;Lkotlin/k0/d;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(kotlin.k0.d r1) {
            super(r1);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.createTransactionContext(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/f0;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class AnonymousClass2 extends q implements l<Throwable, f0> {
        final /* synthetic */ w $controlJob;

        AnonymousClass2(w r1) {
            this.$controlJob = r1;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r2) {
            x1.a.a(this.$controlJob, null, 1, null);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabase.kt", l = {50, 51}, m = "withTransaction")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0007\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "Lkotlin/k0/d;", "", "block", "continuation", "withTransaction", "(Landroidx/room/RoomDatabase;Lkotlin/n0/c/l;Lkotlin/k0/d;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    static final class C06371 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C06371(kotlin.k0.d r1) {
            super(r1);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.withTransaction(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$2, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabase.kt", l = {58}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lh/a/m0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    static final class C06382<R> extends kotlin.k0.j.a.l implements p<m0, kotlin.k0.d<? super R>, Object> {
        final /* synthetic */ l $block;
        final /* synthetic */ RoomDatabase $this_withTransaction;
        Object L$0;
        Object L$1;
        int label;
        private m0 p$;

        C06382(RoomDatabase r1, l r2, kotlin.k0.d r3) {
            this.$this_withTransaction = r1;
            this.$block = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r3, kotlin.k0.d<?> r4) {
            o.g(r4, "completion");
            C06382 r0 = new C06382(this.$this_withTransaction, this.$block, r4);
            r0.p$ = (m0) r3;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public final Object invoke(m0 r1, Object r2) {
            return ((C06382) create(r1, (kotlin.k0.d) r2)).invokeSuspend(f0.f18324a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.c();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            TransactionElement r2 = (TransactionElement) this.L$1;
            m0 r3 = (m0) this.L$0;
            kotlin.w.b(r5);     // Catch: Throwable -> L8
            TransactionElement r4 = r2;
        L20:
            this.$this_withTransaction.setTransactionSuccessful();     // Catch: Throwable -> L8
            this.$this_withTransaction.endTransaction();     // Catch: Throwable -> L28
            r4.release();
            return r5;
        L8:
            th = th;
        L26:
            this.$this_withTransaction.endTransaction();     // Catch: Throwable -> L28
            throw th;     // Catch: Throwable -> L28
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            kotlin.w.b(r5);
            m0 r6 = this.p$;
            g.b r7 = r6.getCoroutineContext().get(TransactionElement.Key);
            if (r7 == null) goto L33;
            TransactionElement r8 = (TransactionElement) r7;
            r8.acquire();
            this.$this_withTransaction.beginTransaction();     // Catch: Throwable -> L30
            l r9 = this.$block;     // Catch: Throwable -> L24
            this.L$0 = r6;     // Catch: Throwable -> L24
            this.L$1 = r8;     // Catch: Throwable -> L24
            this.label = 1;     // Catch: Throwable -> L24
            r5 = r9.invoke(this);     // Catch: Throwable -> L24
            if (r5 != r0) goto L19;
            return r0;
        L19:
            r4 = r8;
        L24:
            th = th;
        L30:
            th = th;
        L31:
            r8.release();
            throw th;
        L33:
            o.p();
            throw null;
        L28:
            th = th;
            r8 = r0;
            goto L31
        }
    }

    static final /* synthetic */ Object acquireTransactionThread(final Executor r3, final x1 r4, kotlin.k0.d<? super e> r5) {
        final h.a.o r0 = new h.a.o(b.b(r5), 1);
        r0.h(new RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1(r3, r4));
        r3.execute(new RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2(r0, r3, r4));     // Catch: RejectedExecutionException -> L5
    L7:
        Object r6 = r0.x();
        if (r6 != b.c()) goto L10;
        h.c(r5);
    L10:
        return r6;
    L5:
        e = move-exception;
        r0.o(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        goto L7
    }

    static final /* synthetic */ Object createTransactionContext(RoomDatabase r6, kotlin.k0.d<? super g> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = b.c();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        w r9 = (w) r0.L$1;
        RoomDatabase r4 = (RoomDatabase) r0.L$0;
        kotlin.w.b(r8);
    L21:
        e r10 = (e) r8;
        TransactionElement r5 = new TransactionElement(r9, r10);
        ThreadLocal<Integer> r11 = r4.getSuspendingTransactionId();
        o.b(r11, "suspendingTransactionId");
        t2 r12 = u2.a(r11, kotlin.k0.j.a.b.b(System.identityHashCode(r9)));
        return r10.plus(r5).plus(r12);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.w.b(r8);
        w r13 = b2.b(null, 1, null);
        x1 r14 = (x1) r0.getContext().get(x1.f17584d);
        if (r14 == null) goto L17;
        r14.L(new AnonymousClass2(r13));
    L17:
        Executor r15 = r6.getTransactionExecutor();
        o.b(r15, "transactionExecutor");
        r0.L$0 = r6;
        r0.L$1 = r13;
        r0.label = 1;
        Object r16 = acquireTransactionThread(r15, r13, r0);
        if (r16 != r2) goto L20;
        return r2;
    L20:
        r4 = r6;
        r9 = r13;
        r8 = r16;
    L7:
        r0 = new AnonymousClass1(r7);
        goto L8
    }

    public static final <R> Object withTransaction(RoomDatabase r5, l<? super kotlin.k0.d<? super R>, ? extends Object> r6, kotlin.k0.d<? super R> r7) {
        if ((r7 instanceof C06371) == false) goto L7;
        C06371 r0 = (C06371) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = b.c();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        g r9 = (g) r0.L$2;
        l r10 = (l) r0.L$1;
        RoomDatabase r11 = (RoomDatabase) r0.L$0;
        kotlin.w.b(r8);
    L28:
        return r8;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (l) r0.L$1;
        r5 = (RoomDatabase) r0.L$0;
        kotlin.w.b(r8);
    L24:
        g r12 = (g) r8;
    L25:
        C06382 r4 = new C06382(r5, r6, null);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.L$2 = r12;
        r0.label = 2;
        r8 = h.a.h.e(r12, r4, r0);
        if (r8 != r2) goto L28;
        return r2;
    L16:
        kotlin.w.b(r8);
        TransactionElement r13 = (TransactionElement) r0.getContext().get(TransactionElement.Key);
        if (r13 == null) goto L21;
        r12 = r13.getTransactionDispatcher$room_ktx_release();
        if (r12 != null) goto L25;
    L21:
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        r8 = createTransactionContext(r5, r0);
        if (r8 != r2) goto L24;
        return r2;
    L7:
        r0 = new C06371(r7);
        goto L8
    }
}
