package l.b.g.b.h;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f22135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f22139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l.b.a.o f22141g;

    protected m(l.b.a.o r7) {
        Objects.requireNonNull(r7, "treeDigest == null");
        this.f22141g = r7;
        l.b.b.a r8 = f.a(r7);
        int r0 = a0.h(r8);
        this.f22136b = r0;
        this.f22137c = 16;
        int r2 = (int) Math.ceil(((double) (r0 * 8)) / ((double) a0.o(16)));
        this.f22139e = r2;
        int r4 = ((int) Math.floor(a0.o((16 - 1) * r2) / a0.o(16))) + 1;
        this.f22140f = r4;
        int r3 = r2 + r4;
        this.f22138d = r3;
        l r1 = l.c(r8.e(), r0, 16, r3);
        this.f22135a = r1;
        if (r1 == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("cannot find OID for digest algorithm: " + r8.e());
    }

    protected int a() {
        return this.f22138d;
    }

    public l.b.a.o b() {
        return this.f22141g;
    }

    protected int c() {
        return this.f22136b;
    }

    protected int d() {
        return this.f22137c;
    }
}
