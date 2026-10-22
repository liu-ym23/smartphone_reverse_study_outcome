package kotlinx.coroutines.internal;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f424d = null;
    public final long c;
    private volatile int cleanedAndPointers;

    static {
        f424d = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");
    }

    public Segment(long r1, Segment r3, int r4) {
        super(r3);
        this.c = r1;
        this.cleanedAndPointers = r4 << 16;
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public final boolean b() {
        if (this.cleanedAndPointers == f()) goto L5;
    L7:
        return false;
    L5:
        if (c() == true) goto L7;
        return true;
    }

    public final boolean e() {
        if (f424d.addAndGet(this, SupportMenu.CATEGORY_MASK) == f()) goto L5;
    L7:
        return false;
    L5:
        if (c() == true) goto L7;
        return true;
    }

    public abstract int f();

    public final boolean g() {
    L2:
        int r0 = this.cleanedAndPointers;
        if (r0 != f()) goto L9;
        if (c() == true) goto L9;
        return false;
    L9:
        if (f424d.compareAndSet(this, r0, 65536 + r0) == false) goto L2;
        return true;
    }
}
