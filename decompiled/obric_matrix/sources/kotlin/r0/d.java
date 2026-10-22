package kotlin.r0;

import kotlin.Metadata;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<java.lang.Integer>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u0019B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\b\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(II)V", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "()Ljava/lang/Integer;", "getEndInclusive", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d extends b implements kotlin.r0.a<Integer> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f18467j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final d f18468k = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final d a() {
            return d.l();
        }
    }

    static {
        f18467j = new a(null);
        f18468k = new d(1, 0);
    }

    public d(int r2, int r3) {
        super(r2, r3, 1);
    }

    public static final /* synthetic */ d l() {
        return f18468k;
    }

    @Override // kotlin.r0.b
    public boolean equals(Object r3) {
        if ((r3 instanceof d) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        d r4 = (d) r3;
        if (a() != r4.a()) goto L13;
        if (b() != r4.b()) goto L13;
    L12:
        return true;
    L7:
        if (((d) r3).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.r0.a
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return n();
    }

    @Override // kotlin.r0.a
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return o();
    }

    @Override // kotlin.r0.b
    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r0 = a() * 31;
        return b() + r0;
    }

    @Override // kotlin.r0.b
    public boolean isEmpty() {
        if (a() <= b()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean m(int r2) {
        if (a() <= r2) goto L5;
    L7:
        return false;
    L5:
        if (r2 > b()) goto L7;
        return true;
    }

    public Integer n() {
        return Integer.valueOf(b());
    }

    public Integer o() {
        return Integer.valueOf(a());
    }

    @Override // kotlin.r0.b
    public String toString() {
        return a() + ".." + b();
    }
}
