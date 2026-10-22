package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class TimedRunnableObsolete implements Comparable<TimedRunnableObsolete>, Runnable, ThreadSafeHeapNode {
    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public final void a(ThreadSafeHeap r1) {
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public final void b(int r1) {
    }

    @Override // java.lang.Comparable
    public final int compareTo(TimedRunnableObsolete r1) {
        r1.getClass();
        return 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw null;
    }

    public final String toString() {
        throw null;
    }
}
