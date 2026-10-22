package l.b.g.b.b;

import l.b.g.d.a.h;
import l.b.g.d.a.i;
import l.b.g.d.a.k;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l.b.g.d.a.b f22040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f22041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h f22042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l.b.g.d.a.a f22043g;

    public b(int r2, int r3, l.b.g.d.a.b r4, i r5, l.b.g.d.a.a r6, h r7, String r8) {
        super(true, r8);
        this.f22038b = r2;
        this.f22039c = r3;
        this.f22040d = r4;
        this.f22041e = r5;
        this.f22043g = r6;
        this.f22042f = r7;
        new k(r4, r5).c();
    }

    public b(int r9, int r10, l.b.g.d.a.b r11, i r12, h r13, String r14) {
        this(r9, r10, r11, r12, l.b.g.d.a.c.a(r11, r12), r13, r14);
    }

    public l.b.g.d.a.b b() {
        return this.f22040d;
    }

    public i c() {
        return this.f22041e;
    }

    public l.b.g.d.a.a d() {
        return this.f22043g;
    }

    public int e() {
        return this.f22039c;
    }

    public int f() {
        return this.f22038b;
    }

    public h g() {
        return this.f22042f;
    }
}
