package com.bytedance.common.wschannel.channel.c.a.g;

import com.bytedance.common.utility.Logger;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k.g;
import k.h;

/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f3464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f3465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final g f3466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final a f3467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f3468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f3470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f3471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f3472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final k.e f3473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final k.e f3474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final byte[] f3475l;
    private final k.e.a m;

    public interface a {
        void a(h r1);

        void c(String r1);

        void d(h r1);

        void f(h r1);

        void g(int r1, String r2);
    }

    e(boolean r2, g r3, a r4, long r5) {
        this.f3473j = new k.e();
        this.f3474k = new k.e();
        Objects.requireNonNull(r3, "source == null");
        Objects.requireNonNull(r4, "frameCallback == null");
        this.f3465b = r2;
        this.f3466c = r3;
        this.f3467d = r4;
        this.f3464a = r5;
        k.e.a r6 = null;
        if (r2 == false) goto L5;
        byte[] r7 = null;
    L6:
        this.f3475l = r7;
        if (r2 == true) goto L10;
        r6 = new k.e.a();
    L10:
        this.m = r6;
        return;
    L5:
        r7 = new byte[4];
        goto L6
    }

    private void b() {
        long r0 = this.f3470g;
        if (r0 <= 0) goto L7;
        this.f3466c.y(this.f3473j, r0);
        if (this.f3465b == true) goto L7;
        this.f3473j.Y(this.m);
        this.m.b(0);
        d.b(this.m, this.f3475l);
        this.m.close();
    L7:
        int r1 = this.f3469f;
        if (r1 != 9) goto L11;
        this.f3467d.d(this.f3473j.d0());
        return;
    L11:
        if (r1 != 10) goto L14;
        this.f3467d.f(this.f3473j.d0());
        return;
    L14:
        if (r1 != 8) goto L30;
        short r2 = 1005;
        long r4 = this.f3473j.k0();
        if (r4 == 1) goto L28;
        if (r4 == 0) goto L24;
        r2 = this.f3473j.readShort();
        String r3 = this.f3473j.i0();
        String r5 = d.a(r2);
        if (r5 != null) goto L23;
    L25:
        this.f3467d.g(r2, r3);
        this.f3468e = true;
        return;
    L23:
        throw new ProtocolException(r5);
    L24:
        r3 = "";
        goto L25
    L28:
        throw new ProtocolException("Malformed close payload length of 1.");
    L30:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f3469f));
    }

    private void c() {
        if (this.f3468e == true) goto L73;
        long r0 = this.f3466c.e().h();
        this.f3466c.e().b();
        int r2 = this.f3466c.readByte() & 255;
        this.f3466c.e().g(r0, TimeUnit.NANOSECONDS);
        this.f3469f = r2 & 15;
        boolean r1 = true;
        if ((r2 & 128) == 0) goto L9;
        boolean r3 = true;
    L10:
        this.f3471h = r3;
        if ((r2 & 8) == 0) goto L13;
        boolean r4 = true;
    L14:
        this.f3472i = r4;
        if (r4 == false) goto L21;
        if (r3 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r2 & 64) == 0) goto L23;
        boolean r5 = true;
    L25:
        if ((r2 & 32) == 0) goto L27;
        boolean r6 = true;
    L29:
        if ((r2 & 16) == 0) goto L31;
        boolean r7 = true;
    L32:
        if (r5 == true) goto L68;
        if (r6 == true) goto L68;
        if (r7 == true) goto L68;
        int r8 = this.f3466c.readByte() & 255;
        if ((r8 & 128) != 0) goto L40;
        r1 = false;
    L40:
        if (r1 == this.f3465b) goto L42;
        long r9 = r8 & 127;
        this.f3470g = r9;
        if (r9 != 126) goto L51;
        this.f3470g = ((long) this.f3466c.readShort()) & 65535;
    L58:
        if (this.f3472i == true) goto L60;
    L64:
        if (r1 == false) goto L76;
        this.f3466c.readFully(this.f3475l);
        return;
    L76:
        return;
    L60:
        if (this.f3470g <= 125) goto L64;
        throw new ProtocolException("Control frame must be less than 125B.");
    L51:
        if (r9 != 127) goto L58;
        long r10 = this.f3466c.readLong();
        this.f3470g = r10;
        if (r10 >= 0) goto L58;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f3470g) + " > 0x7FFFFFFFFFFFFFFF");
    L42:
        if (this.f3465b == false) goto L44;
        String r11 = "Server-sent frames must not be masked.";
    L46:
        throw new ProtocolException(r11);
    L44:
        r11 = "Client-sent frames must be masked.";
    L68:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r7 = false;
        goto L32
    L27:
        r6 = false;
        goto L29
    L23:
        r5 = false;
        goto L25
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
    L69:
        th = move-exception;
        this.f3466c.e().g(r0, TimeUnit.NANOSECONDS);
        throw th;
    L73:
        throw new IOException("closed");
    }

    private void d() {
    L3:
        if (this.f3468e == true) goto L18;
        long r0 = this.f3470g;
        if (r0 <= 0) goto L10;
        this.f3466c.y(this.f3474k, r0);
        if (this.f3465b == true) goto L10;
        this.f3474k.Y(this.m);
        this.m.b(this.f3474k.k0() - this.f3470g);
        d.b(this.m, this.f3475l);
        this.m.close();
    L10:
        if (this.f3471h == true) goto L11;
        f();
        if (this.f3469f == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f3469f));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }

    private void e() {
        int r0 = this.f3469f;
        if (r0 != 1) goto L5;
    L9:
        d();
        if (r0 != 1) goto L12;
        this.f3467d.c(this.f3474k.i0());
        return;
    L12:
        this.f3467d.a(this.f3474k.d0());
        return;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r0));
    }

    private void f() {
    L3:
        if (this.f3468e == true) goto L12;
        c();
        if (this.f3470g > this.f3464a) goto L6;
        if (this.f3472i == false) goto L16;
        b();
        goto L3
    L16:
        return;
    L6:
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        g(this.f3470g);
        return;
    }

    private void g(long r1) {
        this.f3466c.skip(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    void a() {
        c();
        if (this.f3470g <= this.f3464a) goto L7;
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        g(this.f3470g);
        return;
    L7:
        if (this.f3472i == false) goto L9;
        b();
        return;
    L9:
        e();
    }
}
