package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SegmentPool.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\b\u0010\u0014\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001e\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0015"}, d2 = {"Lokio/SegmentPool;", "", "()V", "HASH_BUCKET_COUNT", "", "LOCK", "Lokio/Segment;", "MAX_SIZE", "getMAX_SIZE", "()I", "byteCount", "getByteCount", "hashBuckets", "", "Ljava/util/concurrent/atomic/AtomicReference;", "[Ljava/util/concurrent/atomic/AtomicReference;", "firstRef", "recycle", "", "segment", "take", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT = 0;
    public static final SegmentPool INSTANCE = null;
    private static final Segment LOCK = null;
    private static final int MAX_SIZE = 0;
    private static final AtomicReference<Segment>[] hashBuckets = null;

    private SegmentPool() {
    }

    static {
        INSTANCE = new SegmentPool();
        MAX_SIZE = 65536;
        int r7 = 0;
        LOCK = new Segment(new byte[0], 0, 0, false, false);
        int r0 = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = r0;
        AtomicReference<Segment>[] r1 = new AtomicReference[r0];
    L3:
        if (r7 >= r0) goto L5;
        r1[r7] = new AtomicReference();
        r7 = r7 + 1;
        goto L3
    L5:
        hashBuckets = r1;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public final int getByteCount() {
        Segment r0 = firstRef().get();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.limit;
    }

    @JvmStatic
    public static final Segment take() {
        AtomicReference<Segment> r0 = INSTANCE.firstRef();
        Segment r1 = LOCK;
        Segment r2 = r0.getAndSet(r1);
        if (r2 != r1) goto L7;
        return new Segment();
    L7:
        if (r2 != null) goto L10;
        r0.set(null);
        return new Segment();
    L10:
        r0.set(r2.next);
        r2.next = null;
        r2.limit = 0;
        return r2;
    }

    @JvmStatic
    public static final void recycle(Segment r5) {
        Intrinsics.checkNotNullParameter(r5, "segment");
        if (r5.next == null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L25;
        if (r5.shared == false) goto L12;
        return;
    L12:
        AtomicReference<Segment> r1 = INSTANCE.firstRef();
        Segment r2 = LOCK;
        Segment r3 = r1.getAndSet(r2);
        if (r3 != r2) goto L15;
        return;
    L15:
        if (r3 == null) goto L17;
        int r4 = r3.limit;
    L19:
        if (r4 < MAX_SIZE) goto L22;
        r1.set(r3);
        return;
    L22:
        r5.next = r3;
        r5.pos = 0;
        r5.limit = r4 + 8192;
        r1.set(r5);
        return;
    L17:
        r4 = 0;
        goto L19
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r5.prev != null) goto L7;
        r0 = true;
        goto L8
    }

    private final AtomicReference<Segment> firstRef() {
        int r6 = (int) (Thread.currentThread().getId() & (((long) HASH_BUCKET_COUNT) - 1));
        return hashBuckets[r6];
    }
}
