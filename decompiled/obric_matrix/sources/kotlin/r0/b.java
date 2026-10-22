package kotlin.r0;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.i0.j0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class b implements Iterable<Integer>, kotlin.n0.d.l0.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f18459i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f18461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f18462h;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final b a(int r1, int r2, int r3) {
            return new b(r1, r2, r3);
        }
    }

    static {
        f18459i = new a(null);
    }

    public b(int r2, int r3, int r4) {
        if (r4 == 0) goto L11;
        if (r4 == Integer.MIN_VALUE) goto L9;
        this.f18460f = r2;
        this.f18461g = kotlin.l0.c.b(r2, r3, r4);
        this.f18462h = r4;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final int a() {
        return this.f18460f;
    }

    public final int b() {
        return this.f18461g;
    }

    public final int c() {
        return this.f18462h;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof b) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        b r4 = (b) r3;
        if (this.f18460f != r4.f18460f) goto L15;
        if (this.f18461g != r4.f18461g) goto L15;
        if (this.f18462h != r4.f18462h) goto L15;
    L14:
        return true;
    L7:
        if (((b) r3).isEmpty() == true) goto L14;
        goto L8
    }

    public j0 g() {
        return new c(this.f18460f, this.f18461g, this.f18462h);
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = ((this.f18460f * 31) + this.f18461g) * 31;
        return this.f18462h + r0;
    }

    public boolean isEmpty() {
        if (this.f18462h <= 0) goto L8;
        if (this.f18460f <= this.f18461g) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (this.f18460f >= this.f18461g) goto L11;
        return true;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Integer> iterator() {
        return g();
    }

    public String toString() {
        if (this.f18462h <= 0) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f18460f);
        r0.append("..");
        r0.append(this.f18461g);
        r0.append(" step ");
        int r3 = this.f18462h;
    L6:
        r0.append(r3);
        return r0.toString();
    L5:
        r0 = new StringBuilder();
        r0.append(this.f18460f);
        r0.append(" downTo ");
        r0.append(this.f18461g);
        r0.append(" step ");
        r3 = -this.f18462h;
        goto L6
    }
}
