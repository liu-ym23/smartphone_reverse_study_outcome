package d.b.j.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f13974g;

    public h(boolean r4, i r5) {
        this.f13962a = r4;
        this.f13974g = r5;
        ByteBuffer r0 = ByteBuffer.allocate(8);
        if (r4 == false) goto L5;
        ByteOrder r6 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r6);
        r5.x(r0, 16);
        this.f13963b = r5.A(r0, 32);
        this.f13964c = r5.A(r0, 40);
        this.f13965d = r5.x(r0, 54);
        this.f13966e = r5.x(r0, 56);
        this.f13967f = r5.x(r0, 58);
        r5.x(r0, 60);
        r5.x(r0, 62);
        return;
    L5:
        r6 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // d.b.j.e.d
    public c a(long r8, int r10) {
        return new b(this.f13974g, this, r8, r10);
    }

    @Override // d.b.j.e.d
    public e b(long r3) {
        return new k(this.f13974g, this, r3);
    }

    @Override // d.b.j.e.d
    public f c(int r3) {
        return new m(this.f13974g, this, r3);
    }
}
