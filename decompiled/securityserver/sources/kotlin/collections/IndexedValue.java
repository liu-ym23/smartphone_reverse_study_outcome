package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IndexedValue<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f333a;
    public final Object b;

    public IndexedValue(int r1, Object r2) {
        this.f333a = r1;
        this.b = r2;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IndexedValue) == true) goto L8;
        return false;
    L8:
        IndexedValue r6 = (IndexedValue) r5;
        int r1 = r6.f333a;
        if (this.f333a == r1) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.f333a * 31;
        Object r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f333a + ", value=" + this.b + ')';
    }
}
