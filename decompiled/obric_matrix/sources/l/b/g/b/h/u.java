package l.b.g.b.h;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f22183g;

    protected u(int r1, byte[] r2) {
        this.f22182f = r1;
        this.f22183g = r2;
    }

    public int a() {
        return this.f22182f;
    }

    public byte[] b() {
        return a0.c(this.f22183g);
    }
}
