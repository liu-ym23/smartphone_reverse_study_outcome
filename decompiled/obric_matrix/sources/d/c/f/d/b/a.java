package d.c.f.d.b;

import android.graphics.drawable.Animatable;
import d.c.f.c.c;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f15609d;

    public a(b r3) {
        this.f15607b = -1;
        this.f15608c = -1;
        this.f15609d = r3;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void b(String r3, Object r4, Animatable r5) {
        long r6 = System.currentTimeMillis();
        this.f15608c = r6;
        b r7 = this.f15609d;
        if (r7 == null) goto L6;
        r7.a(r6 - this.f15607b);
        return;
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void e(String r1, Object r2) {
        this.f15607b = System.currentTimeMillis();
    }
}
