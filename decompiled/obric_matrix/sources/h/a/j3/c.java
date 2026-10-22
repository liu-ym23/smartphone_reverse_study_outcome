package h.a.j3;

import h.a.d1;
import h.a.f3.a0;
import h.a.f3.s;
import h.a.n;
import h.a.o;
import h.a.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.h;
import kotlin.n0.c.l;
import kotlin.n0.d.q;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<java.lang.Object, h.a.j3.b>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJT\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\"\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c implements h.a.j3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f17515a = null;
    volatile /* synthetic */ Object _state;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class a extends b {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final n<f0> f17516k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ c f17517l;

        /* JADX INFO: renamed from: h.a.j3.c$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C0462a extends q implements l<Throwable, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f17518f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ a f17519g;

            C0462a(c r1, a r2) {
                this.f17518f = r1;
                this.f17519g = r2;
                super(1);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
                invoke2(r1);
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable r1) {
                this.f17518f.b(this.f17519g.f17521i);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(c r1, Object r2, n<? super f0> r3) {
            this.f17517l = r1;
            super(r1, r2);
            this.f17516k = r3;
        }

        @Override // h.a.j3.c.b
        public void C() {
            this.f17516k.q(p.f17553a);
        }

        @Override // h.a.j3.c.b
        public boolean E() {
            if (D() == true) goto L6;
            return false;
        L6:
            if (this.f17516k.l(f0.f18324a, null, new C0462a(this.f17517l, this)) == null) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // h.a.f3.s
        public String toString() {
            return "LockCont[" + this.f17521i + ", " + this.f17516k + "] for " + this.f17517l;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b¢\u0004\u0018\u00002\u00020\u000f2\u00020\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "", "completeResumeLockWaiter", "()V", "dispose", "", "take", "()Z", "tryResumeLockWaiter", "Ljava/lang/Object;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private abstract class b extends s implements d1 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f17520j = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Object f17521i;
        private volatile /* synthetic */ int isTaken;

        static {
            f17520j = AtomicIntegerFieldUpdater.newUpdater(b.class, "isTaken");
        }

        public b(c r1, Object r2) {
            this.f17521i = r2;
            this.isTaken = 0;
        }

        public abstract void C();

        public final boolean D() {
            return f17520j.compareAndSet(this, 0, 1);
        }

        public abstract boolean E();

        @Override // h.a.d1
        public final void dispose() {
            x();
        }
    }

    /* JADX INFO: renamed from: h.a.j3.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0463c extends h.a.f3.q {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Object f17522i;

        public C0463c(Object r1) {
            this.f17522i = r1;
        }

        @Override // h.a.f3.s
        public String toString() {
            return "LockedQueue[" + this.f17522i + ']';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", "", "affected", "failure", "", "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class d extends h.a.f3.d<c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C0463c f17523b;

        public d(C0463c r1) {
            this.f17523b = r1;
        }

        @Override // h.a.f3.d
        public /* bridge */ /* synthetic */ void d(c r1, Object r2) {
            h(r1, r2);
        }

        @Override // h.a.f3.d
        public /* bridge */ /* synthetic */ Object g(c r1) {
            return i(r1);
        }

        public void h(c r2, Object r3) {
            if (r3 != null) goto L4;
            Object r4 = h.a.j3.d.d();
        L5:
            c.f17515a.compareAndSet(r2, this, r4);
            return;
        L4:
            r4 = this.f17523b;
            goto L5
        }

        public Object i(c r1) {
            if (this.f17523b.C() == false) goto L6;
            return null;
        L6:
            return h.a.j3.d.g();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class e extends q implements l<Throwable, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f17524f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f17525g;

        e(c r1, Object r2) {
            this.f17524f = r1;
            this.f17525g = r2;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Throwable r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r1) {
            this.f17524f.b(this.f17525g);
        }
    }

    static {
        f17515a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_state");
    }

    public c(boolean r1) {
        if (r1 == false) goto L5;
        h.a.j3.a r2 = h.a.j3.d.c();
    L6:
        this._state = r2;
        return;
    L5:
        r2 = h.a.j3.d.d();
        goto L6
    }

    private final Object c(Object r7, kotlin.k0.d<? super f0> r8) {
        o r0 = h.a.q.b(kotlin.k0.i.b.b(r8));
        a r1 = new a(this, r7, r0);
    L3:
        Object r2 = this._state;
        if ((r2 instanceof h.a.j3.a) == true) goto L5;
        if ((r2 instanceof C0463c) == true) goto L16;
        if ((r2 instanceof a0) == false) goto L42;
        ((a0) r2).c(this);
        goto L3
    L42:
        throw new IllegalStateException(kotlin.n0.d.o.m("Illegal state ", r2).toString());
    L16:
        C0463c r3 = (C0463c) r2;
        if (r3.f17522i == r7) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L37;
        r3.l(r1);
        if (this._state == r2) goto L27;
        if (r1.D() == false) goto L27;
        r1 = new a(this, r7, r0);
    L27:
        h.a.q.c(r0, r1);
    L28:
        Object r6 = r0.x();
        if (r6 != kotlin.k0.i.b.c()) goto L32;
        h.c(r8);
    L32:
        if (r6 != kotlin.k0.i.b.c()) goto L35;
        return r6;
    L35:
        return f0.f18324a;
    L37:
        throw new IllegalStateException(kotlin.n0.d.o.m("Already locked by ", r7).toString());
    L19:
        r4 = false;
        goto L20
    L5:
        h.a.j3.a r5 = (h.a.j3.a) r2;
        if (r5.f17514a != h.a.j3.d.f()) goto L7;
        if (r7 != null) goto L10;
        h.a.j3.a r9 = h.a.j3.d.c();
    L12:
        if (f17515a.compareAndSet(this, r2, r9) == false) goto L3;
        r0.n(f0.f18324a, new e(this, r7));
        goto L28
    L10:
        r9 = new h.a.j3.a(r7);
        goto L12
    L7:
        f17515a.compareAndSet(this, r2, new C0463c(r5.f17514a));
        goto L3
    }

    @Override // h.a.j3.b
    public Object a(Object r2, kotlin.k0.d<? super f0> r3) {
        if (d(r2) == true) goto L5;
        Object r1 = c(r2, r3);
        if (r1 != kotlin.k0.i.b.c()) goto L10;
        return r1;
    L10:
        return f0.f18324a;
    L5:
        return f0.f18324a;
    }

    @Override // h.a.j3.b
    public void b(Object r8) {
    L2:
        Object r0 = this._state;
        boolean r4 = true;
        if ((r0 instanceof h.a.j3.a) == true) goto L4;
        if ((r0 instanceof a0) == true) goto L26;
        if ((r0 instanceof C0463c) == false) goto L53;
        if (r8 == null) goto L38;
        C0463c r1 = (C0463c) r0;
        if (r1.f17522i == r8) goto L34;
        r4 = false;
    L34:
        if (r4 == true) goto L38;
        throw new IllegalStateException(("Mutex is locked by " + r1.f17522i + " but expected " + r8).toString());
    L38:
        C0463c r2 = (C0463c) r0;
        s r3 = r2.y();
        if (r3 == null) goto L40;
        b r5 = (b) r3;
        if (r5.E() == false) goto L2;
        Object r7 = r5.f17521i;
        if (r7 != null) goto L50;
        r7 = h.a.j3.d.e();
    L50:
        r2.f17522i = r7;
        r5.C();
        return;
    L40:
        d r6 = new d(r2);
        if (f17515a.compareAndSet(this, r0, r6) == false) goto L2;
        if (r6.c(this) != null) goto L2;
        return;
    L53:
        throw new IllegalStateException(kotlin.n0.d.o.m("Illegal state ", r0).toString());
    L26:
        ((a0) r0).c(this);
        goto L2
    L4:
        h.a.j3.a r9 = (h.a.j3.a) r0;
        if (r8 != null) goto L15;
        if (r9.f17514a != h.a.j3.d.f()) goto L10;
        r4 = false;
    L10:
        if (r4 == false) goto L13;
    L20:
        if (f17515a.compareAndSet(this, r0, h.a.j3.d.d()) == false) goto L2;
        return;
    L13:
        throw new IllegalStateException("Mutex is not locked".toString());
    L15:
        if (r9.f17514a == r8) goto L18;
        r4 = false;
    L18:
        if (r4 == true) goto L20;
        throw new IllegalStateException(("Mutex is locked by " + r9.f17514a + " but expected " + r8).toString());
    }

    public boolean d(Object r6) {
    L2:
        Object r0 = this._state;
        boolean r2 = true;
        if ((r0 instanceof h.a.j3.a) == true) goto L5;
        if ((r0 instanceof C0463c) == true) goto L16;
        if ((r0 instanceof a0) == false) goto L27;
        ((a0) r0).c(this);
        goto L2
    L27:
        throw new IllegalStateException(kotlin.n0.d.o.m("Illegal state ", r0).toString());
    L16:
        if (((C0463c) r0).f17522i != r6) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L22;
        return false;
    L22:
        throw new IllegalStateException(kotlin.n0.d.o.m("Already locked by ", r6).toString());
    L5:
        if (((h.a.j3.a) r0).f17514a != h.a.j3.d.f()) goto L6;
        if (r6 != null) goto L9;
        h.a.j3.a r1 = h.a.j3.d.c();
    L11:
        if (f17515a.compareAndSet(this, r0, r1) == false) goto L2;
        return true;
    L9:
        r1 = new h.a.j3.a(r6);
        goto L11
    L6:
        return false;
    }

    public String toString() {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof h.a.j3.a) == true) goto L4;
        if ((r0 instanceof a0) == false) goto L11;
        ((a0) r0).c(this);
        goto L2
    L11:
        if ((r0 instanceof C0463c) == false) goto L14;
        StringBuilder r4 = new StringBuilder();
        r4.append("Mutex[");
        Object r1 = ((C0463c) r0).f17522i;
    L5:
        r4.append(r1);
        r4.append(']');
        return r4.toString();
    L14:
        throw new IllegalStateException(kotlin.n0.d.o.m("Illegal state ", r0).toString());
    L4:
        r4 = new StringBuilder();
        r4.append("Mutex[");
        r1 = ((h.a.j3.a) r0).f17514a;
        goto L5
    }
}
