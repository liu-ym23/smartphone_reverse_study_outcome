package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HashedWeakRef<T> extends WeakReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f394a;

    public HashedWeakRef(Object r1, ReferenceQueue r2) {
        super(r1, r2);
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        this.f394a = r3;
        return;
    L5:
        r3 = 0;
        goto L6
    }
}
