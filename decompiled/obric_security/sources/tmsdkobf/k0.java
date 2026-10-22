package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public final class k0 extends i3 implements Cloneable {
    public static fi d = null;
    public static final /* synthetic */ boolean e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f297a;
    public fi b;
    public long c;

    public k0() {
        this.f297a = 0;
        this.b = null;
        this.c = 0;
    }

    @Override // tmsdkobf.i3
    public void a(i2 r3) {
        r3.a(this.f297a, 0);
        fi r0 = this.b;
        if (r0 == null) goto L5;
        r3.a(r0, 1);
    L5:
        r3.a(this.c, 2);
    }

    public Object clone() {
        return super.clone();
    L5:
        if (e == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        k0 r5 = (k0) r4;
        if (n3.a(this.f297a, r5.f297a) == true) goto L8;
        return false;
    L8:
        if (this.b.equals(r5.b) == true) goto L10;
        return false;
    L10:
        if (n3.a(this.c, r5.c) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L3:
        throw new Exception("");     // Catch: Exception -> L4
    }

    @Override // tmsdkobf.i3
    public void a(y1 r5) {
        this.f297a = r5.a(this.f297a, 0, true);
        this.b = (fi) r5.a(d, 1, false);
        this.c = r5.a(this.c, 2, true);
    }

    static {
        d = new fi();
    }
}
