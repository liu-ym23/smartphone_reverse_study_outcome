package d.b.h.a.a.g;

import com.bytedance.common.utility.k;
import d.b.r.e0;
import d.b.r.y;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f13301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d.a f13302j;

    public a(String r1, d.a r2, int r3, Runnable r4, boolean r5) {
        this.f13302j = r2;
        if (k.c(r1) == true) goto L5;
    L5:
        this.f13304g = r3;
        this.f13301i = r4;
    }

    @Override // d.b.h.a.a.g.d
    public d.a b() {
        return this.f13302j;
    }

    @Override // d.b.h.a.a.g.d
    public int c() {
        return this.f13305h;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d r1) {
        return n(r1);
    }

    @Override // d.b.h.a.a.g.c
    public /* bridge */ /* synthetic */ c m(int r1) {
        p(r1);
        return this;
    }

    public int n(d r3) {
        d.a r0 = b();
        d.a r1 = r3.b();
        if (r0 != null) goto L5;
        r0 = d.a.f13308h;
    L5:
        if (r1 != null) goto L7;
        r1 = d.a.f13308h;
    L7:
        if (r0 != r1) goto L9;
        int r2 = c();
        int r4 = r3.c();
    L11:
        return r2 - r4;
    L9:
        r2 = r1.ordinal();
        r4 = r0.ordinal();
        goto L11
    }

    public void o(int r2) {
        Runnable r1 = this.f13301i;
        if ((r1 instanceof e0) == false) goto L8;
        y r3 = ((e0) r1).E();
        if (r3 == null) goto L9;
        r3.I0 = r2;
        return;
    L9:
        return;
    }

    public a p(int r1) {
        this.f13305h = r1;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f13301i != null) goto L5;
        return;
    L5:
        if (j() == true) goto L9;
        this.f13301i.run();
        return;
    }
}
