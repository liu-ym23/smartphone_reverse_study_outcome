package d.b.j.e;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f13973g;

    public g(boolean r4, i r5) {
        this.f13962a = r4;
        this.f13973g = r5;
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r4 == false) goto L5;
        ByteOrder r6 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r6);
        r5.x(r0, 16);
        this.f13963b = r5.E(r0, 28);
        this.f13964c = r5.E(r0, 32);
        this.f13965d = r5.x(r0, 42);
        this.f13966e = r5.x(r0, 44);
        this.f13967f = r5.x(r0, 46);
        r5.x(r0, 48);
        r5.x(r0, 50);
        return;
    L5:
        r6 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // d.b.j.e.d
    public c a(long r8, int r10) {
        return new a(this.f13973g, this, r8, r10);
    }

    @Override // d.b.j.e.d
    public e b(long r3) {
        return new j(this.f13973g, this, r3);
    }

    @Override // d.b.j.e.d
    public f c(int r3) {
        return new l(this.f13973g, this, r3);
    }
}
