package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ThreadState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f431a;
    public int b;
    public final CoroutineContext c;

    public ThreadState(CoroutineContext r1, int r2) {
        this.c = r1;
        this.f431a = new Object[r2];
    }
}
