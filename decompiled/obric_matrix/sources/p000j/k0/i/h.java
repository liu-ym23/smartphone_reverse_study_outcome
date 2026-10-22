package p000j.k0.i;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.a0;
import k.e;
import k.g;
import k.z;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
final class h implements Closeable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final Logger f18026j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f18027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f18028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f18029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final d.a f18030i;

    static final class a implements z {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final g f18031f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f18032g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        byte f18033h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f18034i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f18035j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        short f18036k;

        a(g r1) {
            this.f18031f = r1;
        }

        private void a() {
            int r0 = this.f18034i;
            int r1 = h.C(this.f18031f);
            this.f18035j = r1;
            this.f18032g = r1;
            byte r2 = (byte) (this.f18031f.readByte() & 255);
            this.f18033h = (byte) (this.f18031f.readByte() & 255);
            Logger r3 = h.f18026j;
            if (r3.isLoggable(Level.FINE) == false) goto L5;
            r3.fine(e.b(true, this.f18034i, this.f18032g, r2, this.f18033h));
        L5:
            int r4 = this.f18031f.readInt() & Integer.MAX_VALUE;
            this.f18034i = r4;
            if (r2 != 9) goto L11;
            if (r4 != r0) goto L9;
            return;
        L9:
            e.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        L11:
            e.d("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(r2)});
            throw null;
        }

        @Override // k.z
        public long Z(e r7, long r8) {
        L2:
            int r0 = this.f18035j;
            if (r0 != 0) goto L8;
            this.f18031f.skip(this.f18036k);
            this.f18036k = 0;
            if ((this.f18033h & 4) != 0) goto L6;
            a();
            goto L2
        L6:
            return -1;
        L8:
            long r9 = this.f18031f.Z(r7, Math.min(r8, r0));
            if (r9 != (-1)) goto L11;
            return -1;
        L11:
            this.f18035j = (int) (((long) this.f18035j) - r9);
            return r9;
        }

        @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // k.z
        public a0 e() {
            return this.f18031f.e();
        }
    }

    interface b {
        void b();

        void c(boolean r1, m r2);

        void d(boolean r1, int r2, int r3, List<c> r4);

        void e(int r1, long r2);

        void f(boolean r1, int r2, g r3, int r4);

        void g(boolean r1, int r2, int r3);

        void h(int r1, int r2, int r3, boolean r4);

        void i(int r1, p000j.k0.i.b r2);

        void j(int r1, int r2, List<c> r3);

        void k(int r1, p000j.k0.i.b r2, k.h r3);
    }

    static {
        f18026j = Logger.getLogger(e.class.getName());
    }

    h(g r2, boolean r3) {
        this.f18027f = r2;
        this.f18029h = r3;
        a r4 = new a(r2);
        this.f18028g = r4;
        this.f18030i = new d.a(4096, r4);
    }

    private void A(b r4, int r5, byte r6, int r7) {
        short r0 = 0;
        if (r7 != 0) goto L5;
        e.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    L5:
        if ((r6 & 1) == 0) goto L7;
        boolean r1 = true;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r0 = (short) (this.f18027f.readByte() & 255);
    L12:
        if ((r6 & 32) == 0) goto L14;
        F(r4, r7);
        r5 = r5 - 5;
    L14:
        r4.d(r1, r7, -1, x(a(r5, r6, r0), r0, r6, r7));
        return;
    L7:
        r1 = false;
        goto L9
    }

    static int C(g r2) {
        int r0 = ((r2.readByte() & 255) << 16) | ((r2.readByte() & 255) << 8);
        return (r2.readByte() & 255) | r0;
    }

    private void E(b r5, int r6, byte r7, int r8) {
        boolean r1 = false;
        if (r6 != 8) goto L12;
        if (r8 != 0) goto L10;
        int r9 = this.f18027f.readInt();
        int r4 = this.f18027f.readInt();
        if ((r7 & 1) == 0) goto L8;
        r1 = true;
    L8:
        r5.g(r1, r9, r4);
        return;
    L10:
        e.d("TYPE_PING streamId != 0", new Object[0]);
        throw null;
    L12:
        e.d("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(r6)});
        throw null;
    }

    private void F(b r5, int r6) {
        int r0 = this.f18027f.readInt();
        if ((Integer.MIN_VALUE & r0) == 0) goto L5;
        boolean r1 = true;
    L6:
        r5.h(r6, r0 & Integer.MAX_VALUE, (this.f18027f.readByte() & 255) + 1, r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void L(b r3, int r4, byte r5, int r6) {
        if (r4 != 5) goto L9;
        if (r6 == 0) goto L7;
        F(r3, r6);
        return;
    L7:
        e.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        throw null;
    L9:
        e.d("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(r4)});
        throw null;
    }

    private void M(b r4, int r5, byte r6, int r7) {
        short r0 = 0;
        if (r7 != 0) goto L5;
        e.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        throw null;
    L5:
        if ((r6 & 8) == 0) goto L7;
        r0 = (short) (this.f18027f.readByte() & 255);
    L7:
        r4.j(r7, this.f18027f.readInt() & Integer.MAX_VALUE, x(a(r5 - 4, r6, r0), r0, r6, r7));
    }

    private void N(b r4, int r5, byte r6, int r7) {
        if (r5 != 4) goto L13;
        if (r7 == 0) goto L11;
        int r3 = this.f18027f.readInt();
        p000j.k0.i.b r8 = p000j.k0.i.b.a(r3);
        if (r8 == null) goto L9;
        r4.i(r7, r8);
        return;
    L9:
        e.d("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(r3)});
        throw null;
    L11:
        e.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        throw null;
    L13:
        e.d("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(r5)});
        throw null;
    }

    private void O(b r8, int r9, byte r10, int r11) {
        if (r11 == 0) goto L5;
        e.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        throw null;
    L5:
        if ((r10 & 1) == 0) goto L12;
        if (r9 != 0) goto L9;
        r8.b();
        return;
    L9:
        e.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        throw null;
    L12:
        if ((r9 % 6) != 0) goto L44;
        m r12 = new m();
        int r2 = 0;
    L14:
        if (r2 >= r9) goto L42;
        int r3 = this.f18027f.readShort() & 65535;
        int r4 = this.f18027f.readInt();
        if (r3 != 2) goto L18;
        if (r4 == 0) goto L41;
        if (r4 == 1) goto L41;
        e.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
        throw null;
    L41:
        r12.i(r3, r4);
        r2 = r2 + 6;
        goto L14
    L18:
        if (r3 == 3) goto L35;
        if (r3 != 4) goto L21;
        r3 = 7;
        if (r4 >= 0) goto L41;
        e.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
        throw null;
    L21:
        if (r3 != 5) goto L41;
        if (r4 < 16384) goto L28;
        if (r4 <= 16777215) goto L41;
    L28:
        e.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(r4)});
        throw null;
    L35:
        r3 = 4;
        goto L41
    L42:
        r8.c(false, r12);
        return;
    L44:
        e.d("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(r9)});
        throw null;
    }

    private void Q(b r7, int r8, byte r9, int r10) {
        if (r8 != 4) goto L10;
        long r2 = ((long) this.f18027f.readInt()) & 2147483647L;
        if (r2 == 0) goto L8;
        r7.e(r10, r2);
        return;
    L8:
        e.d("windowSizeIncrement was 0", new Object[]{Long.valueOf(r2)});
        throw null;
    L10:
        e.d("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(r8)});
        throw null;
    }

    static int a(int r1, byte r2, short r3) {
        if ((r2 & 8) == 0) goto L5;
        r1 = r1 - 1;
    L5:
        if (r3 <= r1) goto L7;
        e.d("PROTOCOL_ERROR padding %s > remaining length %s", new Object[]{Short.valueOf(r3), Integer.valueOf(r1)});
        throw null;
    L7:
        return (short) (r1 - r3);
    }

    private void l(b r6, int r7, byte r8, int r9) {
        short r1 = 0;
        if (r9 == 0) goto L20;
        boolean r3 = true;
        if ((r8 & 1) == 0) goto L7;
        boolean r2 = true;
    L9:
        if ((r8 & 32) != 0) goto L12;
        r3 = false;
    L12:
        if (r3 == false) goto L14;
        e.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    L14:
        if ((r8 & 8) == 0) goto L16;
        r1 = (short) (this.f18027f.readByte() & 255);
    L16:
        r6.f(r2, r9, this.f18027f, a(r7, r8, r1));
        this.f18027f.skip(r1);
        return;
    L7:
        r2 = false;
        goto L9
    L20:
        e.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        throw null;
    }

    private void s(b r5, int r6, byte r7, int r8) {
        if (r6 < 8) goto L16;
        if (r8 != 0) goto L14;
        int r9 = this.f18027f.readInt();
        int r3 = this.f18027f.readInt();
        int r10 = r6 - 8;
        p000j.k0.i.b r0 = p000j.k0.i.b.a(r3);
        if (r0 == null) goto L12;
        k.h r11 = k.h.f18266i;
        if (r10 <= 0) goto L10;
        r11 = this.f18027f.n(r10);
    L10:
        r5.k(r9, r0, r11);
        return;
    L12:
        e.d("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(r3)});
        throw null;
    L14:
        e.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        throw null;
    L16:
        e.d("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(r6)});
        throw null;
    }

    private List<c> x(int r2, short r3, byte r4, int r5) {
        a r0 = this.f18028g;
        r0.f18035j = r2;
        r0.f18032g = r2;
        r0.f18036k = r3;
        r0.f18033h = r4;
        r0.f18034i = r5;
        this.f18030i.k();
        return this.f18030i.e();
    }

    public boolean b(boolean r7, b r8) {
        this.f18027f.b0(9);     // Catch: IOException -> L32
        int r1 = C(this.f18027f);
        if (r1 >= 0) goto L7;
    L30:
        e.d("FRAME_SIZE_ERROR: %s", new Object[]{Integer.valueOf(r1)});
        throw null;
    L7:
        if (r1 > 16384) goto L30;
        byte r4 = (byte) (this.f18027f.readByte() & 255);
        if (r7 == true) goto L11;
    L15:
        byte r9 = (byte) (this.f18027f.readByte() & 255);
        int r0 = this.f18027f.readInt() & Integer.MAX_VALUE;
        Logger r2 = f18026j;
        if (r2.isLoggable(Level.FINE) == false) goto L18;
        r2.fine(e.b(true, r0, r1, r4, r9));
    L18:
        switch(r4) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            default: goto L19;
        };
    L19:
        this.f18027f.skip(r1);
    L29:
        return true;
    L20:
        Q(r8, r1, r9, r0);
        goto L29
    L21:
        s(r8, r1, r9, r0);
        goto L29
    L22:
        E(r8, r1, r9, r0);
        goto L29
    L23:
        M(r8, r1, r9, r0);
        goto L29
    L24:
        O(r8, r1, r9, r0);
        goto L29
    L25:
        N(r8, r1, r9, r0);
        goto L29
    L26:
        L(r8, r1, r9, r0);
        goto L29
    L27:
        A(r8, r1, r9, r0);
        goto L29
    L28:
        l(r8, r1, r9, r0);
        goto L29
    L11:
        if (r4 == 4) goto L15;
        e.d("Expected a SETTINGS frame but was %s", new Object[]{Byte.valueOf(r4)});
        throw null;
    L32:
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18027f.close();
    }

    public void g(b r7) {
        if (this.f18029h == true) goto L5;
        g r6 = this.f18027f;
        k.h r8 = e.f17961a;
        k.h r9 = r6.n(r8.size());
        Logger r0 = f18026j;
        if (r0.isLoggable(Level.FINE) == false) goto L13;
        r0.fine(c.r("<< CONNECTION %s", new Object[]{r9.q()}));
    L13:
        if (r8.equals(r9) == false) goto L15;
        return;
    L15:
        e.d("Expected a connection header but was %s", new Object[]{r9.F()});
        throw null;
    L5:
        if (b(true, r7) == true) goto L17;
        e.d("Required SETTINGS preface not received", new Object[0]);
        throw null;
    }
}
