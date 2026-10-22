package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f520a;
    public int b;
    public long c;
    public String d;
    public int e;
    public int f;

    public t0(int r1, int r2, long r3, String r5, int r6, int r7) {
        this.f520a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public static t0 a(int r9) {
        return new t0(r9, 100, -1, "", -1, -2);
    }

    public String toString() {
        return this.f520a + "_" + this.b + "_" + this.c + "_" + this.e + "_" + this.d + "_" + this.f;
    }

    public static t0 a(int r9, int r10) {
        return new t0(r9, 200, -1, "", -1, r10);
    }
}
