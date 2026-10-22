package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT = 0;
    public static final SegmentPool INSTANCE = null;
    private static final Segment LOCK = null;
    private static final int MAX_SIZE = 0;
    private static final AtomicReference<Segment>[] hashBuckets = null;

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

    private SegmentPool() {
    }

    private final AtomicReference<Segment> firstRef() {
        Thread r6 = Thread.currentThread();
        Intrinsics.e(r6, "Thread.currentThread()");
        int r7 = (int) (r6.getId() & (((long) HASH_BUCKET_COUNT) - 1));
        return hashBuckets[r7];
    }

    @JvmStatic
    public static final void recycle(@NotNull Segment r5) {
        Intrinsics.f(r5, "segment");
        if (r5.next == null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L26;
        if (r5.shared == false) goto L12;
        return;
    L12:
        AtomicReference<Segment> r1 = INSTANCE.firstRef();
        Segment r2 = r1.get();
        if (r2 != LOCK) goto L15;
        return;
    L15:
        if (r2 == null) goto L17;
        int r3 = r2.limit;
    L19:
        if (r3 < MAX_SIZE) goto L21;
        return;
    L21:
        r5.next = r2;
        r5.pos = 0;
        r5.limit = r3 + 8192;
        if (r1.compareAndSet(r2, r5) == true) goto L27;
        r5.next = null;
        return;
    L27:
        return;
    L17:
        r3 = 0;
        goto L19
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r5.prev != null) goto L7;
        r0 = true;
        goto L8
    }

    @JvmStatic
    @NotNull
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

    public final int getByteCount() {
        Segment r0 = firstRef().get();
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.limit;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
