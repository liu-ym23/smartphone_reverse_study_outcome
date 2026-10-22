package kotlin;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f implements Comparable<f> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f18319j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f18321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f18322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f18323i;

    static {
        f18319j = g.a();
    }

    public f(int r2, int r3) {
        this(r2, r3, 0);
    }

    public f(int r1, int r2, int r3) {
        this.f18320f = r1;
        this.f18321g = r2;
        this.f18322h = r3;
        this.f18323i = b(r1, r2, r3);
    }

    private final int b(int r3, int r4, int r5) {
        boolean r0 = false;
        if (new kotlin.r0.d(0, 255).m(r3) == true) goto L5;
    L9:
        if (r0 == false) goto L13;
        return ((r3 << 16) + (r4 << 8)) + r5;
    L13:
        throw new IllegalArgumentException(("Version components are out of range: " + r3 + '.' + r4 + '.' + r5).toString());
    L5:
        if (new kotlin.r0.d(0, 255).m(r4) == false) goto L9;
        if (new kotlin.r0.d(0, 255).m(r5) == false) goto L9;
        r0 = true;
        goto L9
    }

    public int a(f r2) {
        kotlin.n0.d.o.f(r2, "other");
        return this.f18323i - r2.f18323i;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(f r1) {
        return a(r1);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof f) == false) goto L8;
        f r4 = (f) r3;
    L10:
        if (r4 != null) goto L13;
        return false;
    L13:
        if (this.f18323i != r4.f18323i) goto L16;
        return true;
    L16:
        return false;
    L8:
        r4 = null;
        goto L10
    }

    public int hashCode() {
        return this.f18323i;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f18320f);
        r0.append('.');
        r0.append(this.f18321g);
        r0.append('.');
        r0.append(this.f18322h);
        return r0.toString();
    }
}
