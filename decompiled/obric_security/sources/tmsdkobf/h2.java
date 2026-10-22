package tmsdkobf;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class h2 extends i3 {
    public static ArrayList e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f236a;
    public int b;
    public ArrayList c;
    public int d;

    public h2() {
        this.f236a = 0;
        this.b = 0;
        this.c = null;
        this.d = 0;
    }

    @Override // tmsdkobf.i3
    public void a(i2 r4) {
        r4.a(this.f236a, 0);
        r4.a(this.b, 1);
        r4.a(this.c, 2);
    }

    @Override // tmsdkobf.i3
    public void a(y1 r5) {
        this.f236a = r5.a(this.f236a, 0, true);
        this.b = r5.a(this.b, 1, true);
        if (e != null) goto L5;
        ArrayList r0 = new ArrayList();
        e = r0;
        r0.add(new f3());
    L5:
        this.c = (ArrayList) r5.a(e, 2, true);
    }
}
