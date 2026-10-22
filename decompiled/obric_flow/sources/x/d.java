package x;

import ai.j0;
import android.util.Log;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f22925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f22926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f22927c;
    public int d;

    public d() {
        this.f22925a = new byte[256];
        this.d = 0;
    }

    public final boolean a() {
        if (this.f22927c.f22918b == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final c b() {
        if (this.f22926b == null) goto L102;
        if (a() == true) goto L7;
        StringBuilder r5 = new StringBuilder();
        int r10 = 0;
    L10:
        if (r10 >= 6) goto L13;
        r5.append((char) c());
        r10 = r10 + 1;
        goto L10
    L13:
        if (r5.toString().startsWith("GIF") == true) goto L15;
        this.f22927c.f22918b = 1;
    L25:
        if (a() == true) goto L100;
        boolean r11 = false;
    L27:
        if (r11 == true) goto L96;
        if (a() == true) goto L96;
        if (this.f22927c.f22919c > Integer.MAX_VALUE) goto L96;
        int r12 = c();
        if (r12 != 33) goto L35;
        int r13 = c();
        if (r13 != 1) goto L62;
        f();
        goto L27
    L62:
        if (r13 != 249) goto L64;
        this.f22927c.d = new b();
        c();
        int r14 = c();
        b r15 = this.f22927c.d;
        int r16 = (r14 & 28) >> 2;
        r15.g = r16;
        if (r16 != 0) goto L88;
        r15.g = 1;
    L88:
        if ((r14 & 1) == 0) goto L90;
        boolean r17 = true;
    L91:
        r15.f = r17;
        short r18 = this.f22926b.getShort();
        if (r18 >= 2) goto L94;
        r18 = 10;
    L94:
        b r19 = this.f22927c.d;
        r19.f22914i = r18 * 10;
        r19.f22913h = c();
        c();
        goto L27
    L90:
        r17 = false;
        goto L91
    L64:
        if (r13 != 254) goto L66;
        f();
        goto L27
    L66:
        if (r13 != 255) goto L67;
        d();
        StringBuilder r20 = new StringBuilder();
        int r21 = 0;
    L69:
        byte[] r22 = this.f22925a;
        if (r21 >= 11) goto L73;
        r20.append((char) r22[r21]);
        r21 = r21 + 1;
        goto L69
    L73:
        if (r20.toString().equals("NETSCAPE2.0") == true) goto L74;
        f();
    L74:
        d();
        if (r22[0] != 1) goto L78;
        this.f22927c.f22924l = (r22[1] & UByte.MAX_VALUE) | ((r22[2] & UByte.MAX_VALUE) << 8);
    L78:
        if (this.d <= 0) goto L27;
        if (a() == false) goto L74;
    L67:
        f();
        goto L27
    L35:
        if (r12 != 44) goto L37;
        c r23 = this.f22927c;
        if (r23.d != null) goto L43;
        r23.d = new b();
    L43:
        r23.d.f22910a = this.f22926b.getShort();
        this.f22927c.d.f22911b = this.f22926b.getShort();
        this.f22927c.d.f22912c = this.f22926b.getShort();
        this.f22927c.d.d = this.f22926b.getShort();
        int r24 = c();
        if ((r24 & 128) == 0) goto L46;
        boolean r25 = true;
    L47:
        int r26 = (int) Math.pow(2.0d, (r24 & 7) + 1);
        b r27 = this.f22927c.d;
        if ((r24 & 64) == 0) goto L50;
        boolean r28 = true;
    L51:
        r27.e = r28;
        if (r25 == false) goto L54;
        r27.f22916k = e(r26);
    L55:
        this.f22927c.d.f22915j = this.f22926b.position();
        c();
        f();
        if (a() == true) goto L27;
        c r29 = this.f22927c;
        r29.f22919c++;
        r29.e.add(r29.d);
        goto L27
    L54:
        r27.f22916k = null;
        goto L55
    L50:
        r28 = false;
        goto L51
    L46:
        r25 = false;
        goto L47
    L37:
        if (r12 != 59) goto L38;
        r11 = true;
        goto L27
    L38:
        this.f22927c.f22918b = 1;
    L96:
        c r30 = this.f22927c;
        if (r30.f22919c >= 0) goto L100;
        r30.f22918b = 1;
    L100:
        return this.f22927c;
    L15:
        this.f22927c.f = this.f22926b.getShort();
        this.f22927c.g = this.f22926b.getShort();
        int r31 = c();
        c r32 = this.f22927c;
        if ((r31 & 128) == 0) goto L18;
        boolean r33 = true;
    L19:
        r32.f22920h = r33;
        r32.f22921i = (int) Math.pow(2.0d, (r31 & 7) + 1);
        this.f22927c.f22922j = c();
        c r34 = this.f22927c;
        c();
        r34.getClass();
        if (this.f22927c.f22920h == false) goto L25;
        if (a() == true) goto L25;
        c r35 = this.f22927c;
        r35.f22917a = e(r35.f22921i);
        c r36 = this.f22927c;
        r36.f22923k = r36.f22917a[r36.f22922j];
        goto L25
    L18:
        r33 = false;
        goto L19
    L7:
        return this.f22927c;
    L102:
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final int c() {
        return this.f22926b.get() & UByte.MAX_VALUE;
    L4:
        this.f22927c.f22918b = 1;
        return 0;
    }

    public final void d() {
        int r5 = c();
        this.d = r5;
        if (r5 <= 0) goto L18;
        int r10 = 0;
        int r11 = 0;
    L15:
        int r12 = this.d;     // Catch: Exception -> L9
        if (r10 >= r12) goto L19;
        r11 = r12 - r10;     // Catch: Exception -> L9
        this.f22926b.get(this.f22925a, r10, r11);     // Catch: Exception -> L9
        r10 = r10 + r11;
        goto L15
    L19:
        return;
    L9:
        e = move-exception;
        if (Log.isLoggable("GifHeaderParser", 3) == false) goto L13;
        StringBuilder r13 = j0.v("Error Reading Block n: ", r10, r11, " count: ", " blockSize: ");
        r13.append(this.d);
        Log.d("GifHeaderParser", r13.toString(), e);
    L13:
        this.f22927c.f22918b = 1;
        return;
    }

    public final int[] e(int r10) {
        byte[] r5 = new byte[r10 * 3];
        int[] r11 = null;
        this.f22926b.get(r5);     // Catch: BufferUnderflowException -> L7
        r11 = new int[256];     // Catch: BufferUnderflowException -> L7
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10) goto L12;
        int r14 = r5[r13] & UByte.MAX_VALUE;     // Catch: BufferUnderflowException -> L7
        int r15 = r13 + 2;     // Catch: BufferUnderflowException -> L7
        int r16 = r5[r13 + 1] & UByte.MAX_VALUE;     // Catch: BufferUnderflowException -> L7
        r13 = r13 + 3;     // Catch: BufferUnderflowException -> L7
        int r17 = r12 + 1;     // Catch: BufferUnderflowException -> L7
        r11[r12] = ((r16 << 8) | ((r14 << 16) | ViewCompat.MEASURED_STATE_MASK)) | (r5[r15] & UByte.MAX_VALUE);     // Catch: BufferUnderflowException -> L7
        r12 = r17;
    L12:
        return r11;
    L7:
        e = move-exception;
        if (Log.isLoggable("GifHeaderParser", 3) == false) goto L11;
        Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
    L11:
        this.f22927c.f22918b = 1;
        goto L12
    }

    public final void f() {
    L2:
        int r5 = c();
        int r10 = Math.min(this.f22926b.position() + r5, this.f22926b.limit());
        this.f22926b.position(r10);
        if (r5 > 0) goto L2;
    }
}
