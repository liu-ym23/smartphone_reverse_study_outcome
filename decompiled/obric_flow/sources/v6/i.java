package v6;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22549c;
    public int d;
    public long e;

    public i(long r5, String r10, String r11) {
        this.f22547a = r10;
        this.f22549c = r5;
        this.e = System.currentTimeMillis();
        this.d = 1;
        this.f22548b = r11;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r5) {
        long r10 = ((i) r5).f22549c;
        long r11 = this.f22549c;
        if (r11 != r10) goto L7;
        return 0;
    L7:
        if (r11 <= r10) goto L10;
        return 1;
    L10:
        return -1;
    }
}
