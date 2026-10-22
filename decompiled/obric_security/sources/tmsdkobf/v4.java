package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f569a;
    public int b;
    public byte[] c;

    public v4() {
        this.f569a = 0;
        this.b = 0;
        byte[] r1 = new byte[16];
        int r2 = 0;
    L4:
        if (r2 >= 15) goto L6;
        r1[r2] = 0;
        r2 = r2 + 1;
        goto L4
    L6:
        this.c = r1;
    }
}
