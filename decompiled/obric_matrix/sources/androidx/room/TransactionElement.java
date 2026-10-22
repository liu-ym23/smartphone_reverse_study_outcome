package androidx.room;

import androidx.annotation.RestrictTo;
import h.a.x1;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.k0.e;
import kotlin.k0.g;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Landroidx/room/TransactionElement;", "Lkotlin/k0/g$b;", "Lkotlin/f0;", "acquire", "()V", "release", "Ljava/util/concurrent/atomic/AtomicInteger;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlin/k0/g$c;", "getKey", "()Lkotlin/k0/g$c;", "key", "Lkotlin/k0/e;", "transactionDispatcher", "Lkotlin/k0/e;", "getTransactionDispatcher$room_ktx_release", "()Lkotlin/k0/e;", "Lh/a/x1;", "transactionThreadControlJob", "Lh/a/x1;", "<init>", "(Lh/a/x1;Lkotlin/k0/e;)V", "Key", "room-ktx_release"}, k = 1, mv = {1, 1, 15})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TransactionElement implements g.b {
    public static final Key Key = null;
    private final AtomicInteger referenceCount;
    private final e transactionDispatcher;
    private final x1 transactionThreadControlJob;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/TransactionElement$Key;", "Lkotlin/k0/g$c;", "Landroidx/room/TransactionElement;", "<init>", "()V", "room-ktx_release"}, k = 1, mv = {1, 1, 15})
    public static final class Key implements g.c<TransactionElement> {
        private Key() {
        }

        public /* synthetic */ Key(kotlin.n0.d.g r1) {
            this();
        }
    }

    static {
        Key = new Key(null);
    }

    public TransactionElement(x1 r2, e r3) {
        o.g(r2, "transactionThreadControlJob");
        o.g(r3, "transactionDispatcher");
        this.transactionThreadControlJob = r2;
        this.transactionDispatcher = r3;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // kotlin.k0.g
    public <R> R fold(R r2, p<? super R, ? super g.b, ? extends R> r3) {
        o.g(r3, "operation");
        return (R) g.b.a.a(this, r2, r3);
    }

    @Override // kotlin.k0.g.b, kotlin.k0.g
    public <E extends g.b> E get(g.c<E> r2) {
        o.g(r2, "key");
        return (E) g.b.a.b(this, r2);
    }

    @Override // kotlin.k0.g.b
    public g.c<TransactionElement> getKey() {
        return Key;
    }

    public final e getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    @Override // kotlin.k0.g
    public g minusKey(g.c<?> r2) {
        o.g(r2, "key");
        return g.b.a.c(this, r2);
    }

    @Override // kotlin.k0.g
    public g plus(g r2) {
        o.g(r2, "context");
        return g.b.a.d(this, r2);
    }

    public final void release() {
        int r0 = this.referenceCount.decrementAndGet();
        if (r0 < 0) goto L8;
        if (r0 != 0) goto L9;
        x1.a.a(this.transactionThreadControlJob, null, 1, null);
        return;
    L9:
        return;
    L8:
        throw new IllegalStateException("Transaction was never started or was already released.");
    }
}
