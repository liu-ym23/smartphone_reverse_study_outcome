package k;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.n0.d.i0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements g, f, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f18255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f18256g;

    public static final class a implements Closeable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e f18257f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f18258g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private u f18259h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f18260i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte[] f18261j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f18262k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f18263l;

        public a() {
            this.f18260i = -1;
            this.f18262k = -1;
            this.f18263l = -1;
        }

        public final int a() {
            long r0 = this.f18260i;
            e r2 = this.f18257f;
            if (r2 != null) goto L5;
            kotlin.n0.d.o.p();
            throw null;
        L5:
            if (r0 == r2.k0()) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == false) goto L16;
            long r3 = this.f18260i;
            if (r3 != (-1)) goto L12;
            long r4 = 0;
        L14:
            return b(r4);
        L12:
            r4 = r3 + ((long) (this.f18263l - this.f18262k));
            goto L14
        L16:
            throw new IllegalStateException("no more bytes".toString());
        L7:
            r1 = false;
            goto L8
        }

        public final int b(long r14) {
            e r0 = this.f18257f;
            if (r0 == null) goto L69;
            if (r14 >= (-1)) goto L7;
        L66:
            i0 r13 = i0.f18445a;
            String r15 = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(r14), Long.valueOf(r0.k0())}, 2));
            kotlin.n0.d.o.b(r15, "java.lang.String.format(format, *args)");
            throw new ArrayIndexOutOfBoundsException(r15);
        L7:
            if (r14 > r0.k0()) goto L66;
            if (r14 != (-1)) goto L11;
        L64:
            this.f18259h = null;
            this.f18260i = r14;
            this.f18261j = null;
            this.f18262k = -1;
            this.f18263l = -1;
            return -1;
        L11:
            if (r14 == r0.k0()) goto L64;
            long r1 = 0;
            long r4 = r0.k0();
            u r6 = r0.f18255f;
            u r7 = this.f18259h;
            if (r7 == null) goto L23;
            long r8 = this.f18260i;
            int r10 = this.f18262k;
            if (r7 == null) goto L21;
            long r9 = r8 - ((long) (r10 - r7.f18304b));
            if (r9 <= r14) goto L20;
            r4 = r9;
            r7 = r6;
            r6 = r7;
        L25:
            if ((r4 - r14) <= (r14 - r1)) goto L33;
        L26:
            if (r7 == null) goto L30;
            int r5 = r7.f18305c;
            int r11 = r7.f18304b;
            if (r14 < (((long) (r5 - r11)) + r1)) goto L44;
            r1 = r1 + ((long) (r5 - r11));
            r7 = r7.f18308f;
        L44:
            if (this.f18258g == false) goto L58;
            if (r7 != null) goto L47;
            kotlin.n0.d.o.p();
            throw null;
        L47:
            if (r7.f18306d == false) goto L58;
            u r12 = r7.f();
            if (r0.f18255f != r7) goto L51;
            r0.f18255f = r12;
        L51:
            r7.c(r12);
            u r2 = r12.f18309g;
            if (r2 == null) goto L54;
            r2.b();
            r7 = r12;
            goto L58
        L54:
            kotlin.n0.d.o.p();
            throw null;
        L58:
            this.f18259h = r7;
            this.f18260i = r14;
            if (r7 == null) goto L62;
            this.f18261j = r7.f18303a;
            int r3 = r7.f18304b + ((int) (r14 - r1));
            this.f18262k = r3;
            int r16 = r7.f18305c;
            this.f18263l = r16;
            return r16 - r3;
        L62:
            kotlin.n0.d.o.p();
            throw null;
        L30:
            kotlin.n0.d.o.p();
            throw null;
        L33:
            if (r4 <= r14) goto L42;
            if (r6 == null) goto L40;
            r6 = r6.f18309g;
            if (r6 == null) goto L38;
            r4 = r4 - ((long) (r6.f18305c - r6.f18304b));
            goto L33
        L38:
            kotlin.n0.d.o.p();
            throw null;
        L40:
            kotlin.n0.d.o.p();
            throw null;
        L42:
            r1 = r4;
            r7 = r6;
            goto L44
        L20:
            r1 = r9;
            goto L25
        L21:
            kotlin.n0.d.o.p();
            throw null;
        L23:
            r7 = r6;
            goto L25
        L69:
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f18257f == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.f18257f = null;
            this.f18259h = null;
            this.f18260i = -1;
            this.f18261j = null;
            this.f18262k = -1;
            this.f18263l = -1;
            return;
        L10:
            throw new IllegalStateException("not attached to a buffer".toString());
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class b extends InputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f18264f;

        b(e r1) {
            this.f18264f = r1;
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(this.f18264f.k0(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f18264f.k0() > 0) goto L7;
            return -1;
        L7:
            return this.f18264f.readByte() & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            kotlin.n0.d.o.g(r2, "sink");
            return this.f18264f.read(r2, r3, r4);
        }

        public String toString() {
            return this.f18264f + ".inputStream()";
        }
    }

    public static final class c extends OutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f18265f;

        c(e r1) {
            this.f18265f = r1;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return this.f18265f + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int r1) {
            this.f18265f.s0(r1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r2, int r3, int r4) {
            kotlin.n0.d.o.g(r2, "data");
            this.f18265f.q0(r2, r3, r4);
        }
    }

    public e() {
    }

    public e A0(String r4, int r5, int r6, Charset r7) {
        kotlin.n0.d.o.g(r4, TypedValues.Custom.S_STRING);
        kotlin.n0.d.o.g(r7, "charset");
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L31;
        if (r6 < r5) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L29;
        if (r6 <= r4.length()) goto L15;
        r0 = false;
    L15:
        if (r0 == false) goto L27;
        if (kotlin.n0.d.o.a(r7, kotlin.u0.d.f21429a) == false) goto L20;
        C0(r4, r5, r6);
        return this;
    L20:
        String r8 = r4.substring(r5, r6);
        kotlin.n0.d.o.b(r8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (r8 == null) goto L25;
        byte[] r9 = r8.getBytes(r7);
        kotlin.n0.d.o.b(r9, "(this as java.lang.String).getBytes(charset)");
        q0(r9, 0, r9.length);
        return this;
    L25:
        throw new kotlin.b0("null cannot be cast to non-null type java.lang.String");
    L27:
        throw new IllegalArgumentException(("endIndex > string.length: " + r6 + " > " + r4.length()).toString());
    L29:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r6 + " < " + r5).toString());
    L9:
        r3 = false;
        goto L10
    L31:
        throw new IllegalArgumentException(("beginIndex < 0: " + r5).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // k.g
    public String B(long r12) {
        if (r12 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        long r1 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (r12 == LocationRequestCompat.PASSIVE_INTERVAL) goto L11;
        r1 = r12 + 1;
    L11:
        byte r2 = (byte) 10;
        long r5 = Q(r2, 0, r1);
        if (r5 == (-1)) goto L15;
        return k.c0.a.b(this, r5);
    L15:
        if (r1 < k0()) goto L17;
    L22:
        e r6 = new e();
        L(r6, 0, Math.min(32, k0()));
        throw new EOFException("\\n not found: limit=" + Math.min(k0(), r12) + " content=" + r6.d0().q() + 8230);
    L17:
        if (O(r1 - 1) != ((byte) 13)) goto L22;
        if (O(r1) != r2) goto L22;
        return k.c0.a.b(this, r1);
    L25:
        throw new IllegalArgumentException(("limit < 0: " + r12).toString());
    L5:
        r0 = false;
        goto L6
    }

    public e B0(String r3) {
        kotlin.n0.d.o.g(r3, TypedValues.Custom.S_STRING);
        C0(r3, 0, r3.length());
        return this;
    }

    public e C() {
        return F();
    }

    public e C0(String r12, int r13, int r14) {
        kotlin.n0.d.o.g(r12, TypedValues.Custom.S_STRING);
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L54;
        if (r14 < r13) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L52;
        if (r14 > r12.length()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L50;
    L16:
        if (r13 >= r14) goto L48;
        char r5 = r12.charAt(r13);
        if (r5 < 128) goto L19;
        if (r5 < 2048) goto L28;
        if (r5 < 55296) goto L47;
        if (r5 > 57343) goto L47;
        int r6 = r13 + 1;
        if (r6 >= r14) goto L38;
        char r7 = r12.charAt(r6);
    L40:
        if (r5 > 56319) goto L46;
        if (56320 > r7) goto L46;
        if (57343 < r7) goto L46;
        int r8 = (((r5 & 1023) << 10) | (r7 & 1023)) + 65536;
        u r9 = n0(4);
        byte[] r10 = r9.f18303a;
        int r11 = r9.f18305c;
        r10[r11] = (byte) ((r8 >> 18) | 240);
        r10[r11 + 1] = (byte) (((r8 >> 12) & 63) | 128);
        r10[r11 + 2] = (byte) (((r8 >> 6) & 63) | 128);
        r10[r11 + 3] = (byte) ((r8 & 63) | 128);
        r9.f18305c = r11 + 4;
        j0(k0() + 4);
        r13 = r13 + 2;
    L46:
        s0(63);
        r13 = r6;
        goto L16
    L38:
        r7 = 0;
    L47:
        u r15 = n0(3);
        byte[] r16 = r15.f18303a;
        int r17 = r15.f18305c;
        r16[r17] = (byte) ((r5 >> '\f') | 224);
        r16[r17 + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r16[r17 + 2] = (byte) ((r5 & '?') | 128);
        r15.f18305c = r17 + 3;
        long r18 = k0();
        long r19 = 3;
    L29:
        j0(r18 + r19);
        r13 = r13 + 1;
        goto L16
    L28:
        u r20 = n0(2);
        byte[] r21 = r20.f18303a;
        int r22 = r20.f18305c;
        r21[r22] = (byte) ((r5 >> 6) | 192);
        r21[r22 + 1] = (byte) ((r5 & '?') | 128);
        r20.f18305c = r22 + 2;
        r18 = k0();
        r19 = 2;
        goto L29
    L19:
        u r23 = n0(1);
        byte[] r24 = r23.f18303a;
        int r25 = r23.f18305c - r13;
        int r26 = Math.min(r14, 8192 - r25);
        int r27 = r13 + 1;
        r24[r13 + r25] = (byte) r5;
    L20:
        if (r27 >= r26) goto L25;
        char r110 = r12.charAt(r27);
        if (r110 >= 128) goto L25;
        r24[r27 + r25] = (byte) r110;
        r27 = r27 + 1;
    L25:
        int r111 = r23.f18305c;
        int r28 = (r25 + r27) - r111;
        r23.f18305c = r111 + r28;
        j0(k0() + ((long) r28));
        r13 = r27;
        goto L16
    L48:
        return this;
    L50:
        throw new IllegalArgumentException(("endIndex > string.length: " + r14 + " > " + r12.length()).toString());
    L14:
        r4 = false;
        goto L15
    L52:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r14 + " < " + r13).toString());
    L9:
        r3 = false;
        goto L10
    L54:
        throw new IllegalArgumentException(("beginIndex < 0: " + r13).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f D(String r1) {
        B0(r1);
        return this;
    }

    public e D0(int r9) {
        if (r9 >= 128) goto L6;
        s0(r9);
    L20:
        return this;
    L6:
        if (r9 >= 2048) goto L10;
        u r3 = n0(2);
        byte[] r4 = r3.f18303a;
        int r5 = r3.f18305c;
        r4[r5] = (byte) ((r9 >> 6) | 192);
        r4[r5 + 1] = (byte) ((r9 & 63) | 128);
        r3.f18305c = r5 + 2;
        long r0 = k0();
        long r2 = 2;
    L8:
        j0(r0 + r2);
        goto L20
    L10:
        if (55296 > r9) goto L15;
        if (57343 < r9) goto L15;
        s0(63);
    L15:
        if (r9 >= 65536) goto L18;
        u r6 = n0(3);
        byte[] r7 = r6.f18303a;
        int r8 = r6.f18305c;
        r7[r8] = (byte) ((r9 >> 12) | 224);
        r7[r8 + 1] = (byte) (((r9 >> 6) & 63) | 128);
        r7[r8 + 2] = (byte) ((r9 & 63) | 128);
        r6.f18305c = r8 + 3;
        r0 = k0();
        r2 = 3;
        goto L8
    L18:
        if (r9 > 1114111) goto L22;
        u r10 = n0(4);
        byte[] r11 = r10.f18303a;
        int r12 = r10.f18305c;
        r11[r12] = (byte) ((r9 >> 18) | 240);
        r11[r12 + 1] = (byte) (((r9 >> 12) & 63) | 128);
        r11[r12 + 2] = (byte) (((r9 >> 6) & 63) | 128);
        r11[r12 + 3] = (byte) ((r9 & 63) | 128);
        r10.f18305c = r12 + 4;
        r0 = k0();
        r2 = 4;
        goto L8
    L22:
        throw new IllegalArgumentException("Unexpected code point: 0x" + k.c.g(r9));
    }

    public final long E() {
        long r0 = k0();
        if (r0 == 0) goto L20;
        u r5 = this.f18255f;
        if (r5 == null) goto L18;
        u r6 = r5.f18309g;
        if (r6 == null) goto L16;
        int r2 = r6.f18305c;
        if (r2 >= 8192) goto L15;
        if (r6.f18307e == false) goto L15;
        r0 = r0 - ((long) (r2 - r6.f18304b));
    L15:
        return r0;
    L16:
        kotlin.n0.d.o.p();
        throw null;
    L18:
        kotlin.n0.d.o.p();
        throw null;
    L20:
        return 0;
    }

    public final e F() {
        e r0 = new e();
        if (k0() == 0) goto L18;
        u r1 = this.f18255f;
        if (r1 == null) goto L19;
        u r3 = r1.d();
        r0.f18255f = r3;
        r3.f18309g = r3;
        r3.f18308f = r3;
        u r4 = r1.f18308f;
    L8:
        if (r4 == r1) goto L17;
        u r5 = r3.f18309g;
        if (r5 == null) goto L15;
        if (r4 == null) goto L13;
        r5.c(r4.d());
        r4 = r4.f18308f;
        goto L8
    L13:
        kotlin.n0.d.o.p();
        throw null;
    L15:
        kotlin.n0.d.o.p();
        throw null;
    L17:
        r0.j0(k0());
        goto L18
    L19:
        kotlin.n0.d.o.p();
        throw null;
    L18:
        return r0;
    }

    @Override // k.g
    public boolean G(long r8, h r10) {
        kotlin.n0.d.o.g(r10, "bytes");
        return X(r8, r10, 0, r10.size());
    }

    @Override // k.g
    public String H(Charset r3) {
        kotlin.n0.d.o.g(r3, "charset");
        return h0(this.f18256g, r3);
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f I(byte[] r1, int r2, int r3) {
        q0(r1, r2, r3);
        return this;
    }

    @Override // k.x
    public void J(e r9, long r10) {
        kotlin.n0.d.o.g(r9, "source");
        if (r9 == this) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L62;
        k.c.b(r9.k0(), 0, r10);
    L9:
        if (r10 <= 0) goto L74;
        u r2 = r9.f18255f;
        if (r2 == null) goto L58;
        int r3 = r2.f18305c;
        if (r2 == null) goto L56;
        if (r10 >= (r3 - r2.f18304b)) goto L40;
        u r4 = this.f18255f;
        if (r4 == null) goto L22;
        if (r4 == null) goto L20;
        u r5 = r4.f18309g;
    L23:
        if (r5 != null) goto L25;
    L36:
        if (r2 == null) goto L38;
        r9.f18255f = r2.e((int) r10);
        goto L40
    L38:
        kotlin.n0.d.o.p();
        throw null;
    L25:
        if (r5.f18307e == false) goto L36;
        long r6 = ((long) r5.f18305c) + r10;
        if (r5.f18306d == false) goto L29;
        int r7 = 0;
    L31:
        if ((r6 - ((long) r7)) > 8192) goto L36;
        if (r2 == null) goto L34;
        r2.g(r5, (int) r10);
        r9.j0(r9.k0() - r10);
        j0(k0() + r10);
        return;
    L34:
        kotlin.n0.d.o.p();
        throw null;
    L29:
        r7 = r5.f18304b;
        goto L31
    L20:
        kotlin.n0.d.o.p();
        throw null;
    L22:
        r5 = null;
    L40:
        u r8 = r9.f18255f;
        if (r8 == null) goto L54;
        long r11 = r8.f18305c - r8.f18304b;
        r9.f18255f = r8.b();
        u r12 = this.f18255f;
        if (r12 != null) goto L45;
        this.f18255f = r8;
        r8.f18309g = r8;
        r8.f18308f = r8;
    L49:
        r9.j0(r9.k0() - r11);
        j0(k0() + r11);
        r10 = r10 - r11;
        goto L9
    L45:
        if (r12 == null) goto L52;
        u r13 = r12.f18309g;
        if (r13 == null) goto L50;
        r13.c(r8);
        r8.a();
        goto L49
    L50:
        kotlin.n0.d.o.p();
        throw null;
    L52:
        kotlin.n0.d.o.p();
        throw null;
    L54:
        kotlin.n0.d.o.p();
        throw null;
    L56:
        kotlin.n0.d.o.p();
        throw null;
    L58:
        kotlin.n0.d.o.p();
        throw null;
    L74:
        return;
    L62:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f K(long r1) {
        u0(r1);
        return this;
    }

    public final e L(e r9, long r10, long r12) {
        kotlin.n0.d.o.g(r9, "out");
        k.c.b(k0(), r10, r12);
        if (r12 == 0) goto L28;
        r9.j0(r9.k0() + r12);
        u r2 = this.f18255f;
    L7:
        if (r2 == null) goto L29;
        int r4 = r2.f18305c;
        int r5 = r2.f18304b;
        if (r10 < (r4 - r5)) goto L12;
        r10 = r10 - ((long) (r4 - r5));
        r2 = r2.f18308f;
    L12:
        if (r12 <= 0) goto L28;
        if (r2 == null) goto L26;
        u r6 = r2.d();
        int r7 = r6.f18304b + ((int) r10);
        r6.f18304b = r7;
        r6.f18305c = Math.min(r7 + ((int) r12), r6.f18305c);
        u r11 = r9.f18255f;
        if (r11 != null) goto L17;
        r6.f18309g = r6;
        r6.f18308f = r6;
        r9.f18255f = r6;
    L21:
        r12 = r12 - ((long) (r6.f18305c - r6.f18304b));
        r2 = r2.f18308f;
        r10 = 0;
        goto L12
    L17:
        if (r11 == null) goto L24;
        u r13 = r11.f18309g;
        if (r13 == null) goto L22;
        r13.c(r6);
        goto L21
    L22:
        kotlin.n0.d.o.p();
        throw null;
    L24:
        kotlin.n0.d.o.p();
        throw null;
    L26:
        kotlin.n0.d.o.p();
        throw null;
    L29:
        kotlin.n0.d.o.p();
        throw null;
    L28:
        return this;
    }

    public e M() {
        return this;
    }

    public e N() {
        return this;
    }

    public final byte O(long r8) {
        k.c.b(k0(), r8, 1);
        u r0 = this.f18255f;
        if (r0 != null) goto L5;
        kotlin.n0.d.o.p();
        throw null;
    L5:
        if ((k0() - r8) >= r8) goto L18;
        long r2 = k0();
    L8:
        if (r2 <= r8) goto L14;
        r0 = r0.f18309g;
        if (r0 == null) goto L12;
        r2 = r2 - ((long) (r0.f18305c - r0.f18304b));
        goto L8
    L12:
        kotlin.n0.d.o.p();
        throw null;
    L14:
        if (r0 != null) goto L37;
        kotlin.n0.d.o.p();
        throw null;
    L37:
        return r0.f18303a[(int) ((((long) r0.f18304b) + r8) - r2)];
    L18:
        long r3 = 0;
    L19:
        int r7 = r0.f18305c;
        int r4 = r0.f18304b;
        long r5 = ((long) (r7 - r4)) + r3;
        if (r5 > r8) goto L21;
        r0 = r0.f18308f;
        if (r0 == null) goto L29;
        r3 = r5;
        goto L19
    L29:
        kotlin.n0.d.o.p();
        throw null;
    L21:
        if (r0 != null) goto L23;
        kotlin.n0.d.o.p();
        throw null;
    L23:
        return r0.f18303a[(int) ((((long) r4) + r8) - r3)];
    }

    @Override // k.g
    public String P() {
        return B(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long Q(byte r16, long r17, long r19) {
        long r1 = r17;
        long r3 = r19;
        long r5 = 0;
        if (0 <= r1) goto L6;
    L8:
        boolean r7 = false;
    L9:
        if (r7 == false) goto L65;
        if (r3 <= k0()) goto L14;
        r3 = k0();
    L14:
        if (r1 != r3) goto L16;
    L15:
        return -1;
    L16:
        u r10 = this.f18255f;
        if (r10 == null) goto L15;
        if ((k0() - r1) >= r1) goto L42;
        r5 = k0();
    L22:
        if (r5 <= r1) goto L28;
        r10 = r10.f18309g;
        if (r10 == null) goto L26;
        r5 = r5 - ((long) (r10.f18305c - r10.f18304b));
        goto L22
    L26:
        kotlin.n0.d.o.p();
        throw null;
    L28:
        if (r10 == null) goto L15;
    L30:
        if (r5 >= r3) goto L15;
        byte[] r8 = r10.f18303a;
        int r9 = (int) Math.min(r10.f18305c, (((long) r10.f18304b) + r3) - r5);
        int r2 = (int) ((((long) r10.f18304b) + r1) - r5);
    L32:
        if (r2 >= r9) goto L37;
        if (r8[r2] == r16) goto L78;
        r2 = r2 + 1;
    L78:
        return ((long) (r2 - r10.f18304b)) + r5;
    L37:
        r5 = r5 + ((long) (r10.f18305c - r10.f18304b));
        r10 = r10.f18308f;
        if (r10 == null) goto L40;
        r1 = r5;
        goto L30
    L40:
        kotlin.n0.d.o.p();
        throw null;
    L42:
        long r11 = ((long) (r10.f18305c - r10.f18304b)) + r5;
        if (r11 > r1) goto L44;
        r10 = r10.f18308f;
        if (r10 == null) goto L61;
        r5 = r11;
        goto L42
    L61:
        kotlin.n0.d.o.p();
        throw null;
    L44:
        if (r10 == null) goto L15;
    L46:
        if (r5 >= r3) goto L15;
        byte[] r12 = r10.f18303a;
        int r13 = (int) Math.min(r10.f18305c, (((long) r10.f18304b) + r3) - r5);
        r2 = (int) ((((long) r10.f18304b) + r1) - r5);
    L48:
        if (r2 >= r13) goto L53;
        if (r12[r2] == r16) goto L78;
        r2 = r2 + 1;
        goto L48
    L53:
        r5 = r5 + ((long) (r10.f18305c - r10.f18304b));
        r10 = r10.f18308f;
        if (r10 == null) goto L56;
        r1 = r5;
        goto L46
    L56:
        kotlin.n0.d.o.p();
        throw null;
    L65:
        throw new IllegalArgumentException(("size=" + k0() + " fromIndex=" + r1 + " toIndex=" + r3).toString());
    L6:
        if (r3 < r1) goto L8;
        r7 = true;
        goto L9
    }

    @Override // k.g
    public int R() {
        return k.c.c(readInt());
    }

    public long S(h r3) {
        kotlin.n0.d.o.g(r3, "targetBytes");
        return V(r3, 0);
    }

    @Override // k.g
    public byte[] T(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L16;
        if (k0() < r3) goto L14;
        byte[] r4 = new byte[(int) r3];
        readFully(r4);
        return r4;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(("byteCount: " + r3).toString());
    L5:
        if (r3 > Integer.MAX_VALUE) goto L7;
        r0 = true;
        goto L8
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f U(byte[] r1) {
        p0(r1);
        return this;
    }

    public long V(h r13, long r14) {
        kotlin.n0.d.o.g(r13, "targetBytes");
        long r0 = 0;
        if (r14 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L99;
        u r3 = this.f18255f;
        if (r3 != null) goto L10;
        return -1;
    L10:
        if ((k0() - r14) >= r14) goto L55;
        r0 = k0();
    L13:
        if (r0 <= r14) goto L19;
        r3 = r3.f18309g;
        if (r3 == null) goto L17;
        r0 = r0 - ((long) (r3.f18305c - r3.f18304b));
        goto L13
    L17:
        kotlin.n0.d.o.p();
        throw null;
    L19:
        if (r3 != null) goto L21;
        return -1;
    L21:
        if (r13.size() != 2) goto L38;
        byte r4 = r13.l(0);
        byte r15 = r13.l(1);
    L24:
        if (r0 >= k0()) goto L127;
        byte[] r5 = r3.f18303a;
        int r16 = (int) ((((long) r3.f18304b) + r14) - r0);
        int r17 = r3.f18305c;
    L26:
        if (r16 >= r17) goto L33;
        byte r7 = r5[r16];
        if (r7 == r4) goto L125;
        if (r7 == r15) goto L125;
        r16 = r16 + 1;
    L125:
        return ((long) (r16 - r3.f18304b)) + r0;
    L33:
        r0 = r0 + ((long) (r3.f18305c - r3.f18304b));
        r3 = r3.f18308f;
        if (r3 == null) goto L36;
        r14 = r0;
        goto L24
    L36:
        kotlin.n0.d.o.p();
        throw null;
    L127:
        return -1;
    L38:
        byte[] r18 = r13.r();
    L40:
        if (r0 >= k0()) goto L128;
        byte[] r6 = r3.f18303a;
        r16 = (int) ((((long) r3.f18304b) + r14) - r0);
        int r19 = r3.f18305c;
    L42:
        if (r16 >= r19) goto L50;
        byte r8 = r6[r16];
        int r9 = r18.length;
        int r10 = 0;
    L44:
        if (r10 >= r9) goto L49;
        if (r8 == r18[r10]) goto L125;
        r10 = r10 + 1;
        goto L44
    L49:
        r16 = r16 + 1;
        goto L42
    L50:
        r0 = r0 + ((long) (r3.f18305c - r3.f18304b));
        r3 = r3.f18308f;
        if (r3 == null) goto L53;
        r14 = r0;
        goto L40
    L53:
        kotlin.n0.d.o.p();
        throw null;
    L128:
        return -1;
    L55:
        long r11 = ((long) (r3.f18305c - r3.f18304b)) + r0;
        if (r11 > r14) goto L57;
        r3 = r3.f18308f;
        if (r3 == null) goto L95;
        r0 = r11;
        goto L55
    L95:
        kotlin.n0.d.o.p();
        throw null;
    L57:
        if (r3 != null) goto L59;
        return -1;
    L59:
        if (r13.size() != 2) goto L75;
        byte r12 = r13.l(0);
        byte r110 = r13.l(1);
    L62:
        if (r0 >= k0()) goto L129;
        byte[] r20 = r3.f18303a;
        r16 = (int) ((((long) r3.f18304b) + r14) - r0);
        int r111 = r3.f18305c;
    L64:
        if (r16 >= r111) goto L70;
        byte r21 = r20[r16];
        if (r21 == r12) goto L125;
        if (r21 == r110) goto L125;
        r16 = r16 + 1;
        goto L64
    L70:
        r0 = r0 + ((long) (r3.f18305c - r3.f18304b));
        r3 = r3.f18308f;
        if (r3 == null) goto L73;
        r14 = r0;
        goto L62
    L73:
        kotlin.n0.d.o.p();
        throw null;
    L129:
        return -1;
    L75:
        byte[] r112 = r13.r();
    L77:
        if (r0 >= k0()) goto L130;
        byte[] r22 = r3.f18303a;
        r16 = (int) ((((long) r3.f18304b) + r14) - r0);
        int r113 = r3.f18305c;
    L79:
        if (r16 >= r113) goto L87;
        byte r23 = r22[r16];
        int r24 = r112.length;
        int r114 = 0;
    L81:
        if (r114 >= r24) goto L86;
        if (r23 == r112[r114]) goto L125;
        r114 = r114 + 1;
        goto L81
    L86:
        r16 = r16 + 1;
        goto L79
    L87:
        r0 = r0 + ((long) (r3.f18305c - r3.f18304b));
        r3 = r3.f18308f;
        if (r3 == null) goto L90;
        r14 = r0;
        goto L77
    L90:
        kotlin.n0.d.o.p();
        throw null;
    L130:
        return -1;
    L99:
        throw new IllegalArgumentException(("fromIndex < 0: " + r14).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f W(h r1) {
        o0(r1);
        return this;
    }

    public boolean X(long r7, h r9, int r10, int r11) {
        kotlin.n0.d.o.g(r9, "bytes");
        if (r7 < 0) goto L21;
        if (r10 < 0) goto L22;
        if (r11 >= 0) goto L7;
        return false;
    L7:
        if ((k0() - r7) >= r11) goto L9;
        return false;
    L9:
        if ((r9.size() - r10) < r11) goto L25;
        int r0 = 0;
    L12:
        if (r0 >= r11) goto L17;
        if (O(((long) r0) + r7) != r9.l(r10 + r0)) goto L26;
        r0 = r0 + 1;
        goto L12
    L26:
        return false;
    L17:
        return true;
    L25:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    public final a Y(a r3) {
        kotlin.n0.d.o.g(r3, "unsafeCursor");
        if (r3.f18257f != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r3.f18257f = this;
        r3.f18258g = true;
        return r3;
    L10:
        throw new IllegalStateException("already attached to a buffer".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // k.z
    public long Z(e r5, long r6) {
        kotlin.n0.d.o.g(r5, "sink");
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L16;
        if (k0() != 0) goto L11;
        return -1;
    L11:
        if (r6 <= k0()) goto L13;
        r6 = k0();
    L13:
        r5.J(this, r6);
        return r6;
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    public final void a() {
        skip(k0());
    }

    @Override // k.g
    public long a0() {
        return k.c.d(readLong());
    }

    @Override // k.g
    public void b0(long r3) {
        if (this.f18256g < r3) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // k.g, k.f
    public e c() {
        return this;
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f c0(long r1) {
        t0(r1);
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return C();
    }

    @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // k.g, k.f
    public e d() {
        return this;
    }

    public h d0() {
        return n(k0());
    }

    @Override // k.z
    public a0 e() {
        return a0.f18238d;
    }

    @Override // k.f
    public OutputStream e0() {
        return new c(this);
    }

    public boolean equals(Object r20) {
        if (this != r20) goto L6;
    L43:
        return true;
    L6:
        if ((r20 instanceof e) == true) goto L8;
    L7:
        return false;
    L8:
        e r1 = (e) r20;
        if (k0() != r1.k0()) goto L7;
        if (k0() == 0) goto L43;
        u r4 = this.f18255f;
        if (r4 == null) goto L46;
        u r2 = r1.f18255f;
        if (r2 == null) goto L44;
        int r8 = r4.f18304b;
        int r9 = r2.f18304b;
        long r10 = 0;
    L20:
        if (r10 >= k0()) goto L43;
        long r12 = Math.min(r4.f18305c - r8, r2.f18305c - r9);
        long r14 = 0;
    L23:
        if (r14 >= r12) goto L29;
        int r17 = r8 + 1;
        int r18 = r9 + 1;
        if (r4.f18303a[r8] != r2.f18303a[r9]) goto L7;
        r14 = r14 + 1;
        r8 = r17;
        r9 = r18;
        goto L23
    L29:
        if (r8 != r4.f18305c) goto L36;
        u r3 = r4.f18308f;
        if (r3 == null) goto L33;
        r8 = r3.f18304b;
        r4 = r3;
        goto L36
    L33:
        kotlin.n0.d.o.p();
        throw null;
    L36:
        if (r9 != r2.f18305c) goto L42;
        r2 = r2.f18308f;
        if (r2 == null) goto L40;
        r9 = r2.f18304b;
        goto L42
    L40:
        kotlin.n0.d.o.p();
        throw null;
    L42:
        r10 = r10 + r12;
        goto L20
    L44:
        kotlin.n0.d.o.p();
        throw null;
    L46:
        kotlin.n0.d.o.p();
        throw null;
    }

    @Override // k.g
    public long f0() {
        if (k0() == 0) goto L44;
        int r0 = 0;
        boolean r1 = false;
        long r4 = 0;
    L5:
        u r6 = this.f18255f;
        if (r6 == null) goto L41;
        byte[] r7 = r6.f18303a;
        int r8 = r6.f18304b;
        int r9 = r6.f18305c;
    L8:
        if (r8 >= r9) goto L33;
        byte r10 = r7[r8];
        byte r11 = (byte) 48;
        if (r10 >= r11) goto L12;
    L14:
        byte r12 = (byte) 97;
        if (r10 >= r12) goto L17;
    L19:
        r12 = (byte) 65;
        if (r10 < r12) goto L29;
        if (r10 > ((byte) 70)) goto L29;
    L18:
        int r13 = (r10 - r12) + 10;
    L25:
        if (((-1152921504606846976L) & r4) != 0) goto L27;
        r4 = (r4 << 4) | ((long) r13);
        r8 = r8 + 1;
        r0 = r0 + 1;
        goto L8
    L27:
        e r14 = new e();
        r14.u0(r4);
        r14.s0(r10);
        throw new NumberFormatException("Number too large: " + r14.i0());
    L29:
        if (r0 == 0) goto L32;
        r1 = true;
        goto L33
    L32:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + k.c.f(r10));
    L17:
        if (r10 > ((byte) 102)) goto L19;
    L12:
        if (r10 > ((byte) 57)) goto L14;
        r13 = r10 - r11;
    L33:
        if (r8 != r9) goto L35;
        this.f18255f = r6.b();
        v.f18312c.a(r6);
    L36:
        if (r1 == true) goto L39;
        if (this.f18255f != null) goto L5;
    L39:
        j0(k0() - ((long) r0));
        return r4;
    L35:
        r6.f18304b = r8;
        goto L36
    L41:
        kotlin.n0.d.o.p();
        throw null;
    L44:
        throw new EOFException();
    }

    @Override // k.f, k.x, java.io.Flushable
    public void flush() {
    }

    public short g0() {
        return k.c.e(readShort());
    }

    public String h0(long r7, Charset r9) {
        kotlin.n0.d.o.g(r9, "charset");
        if (r7 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L29;
        if (this.f18256g < r7) goto L27;
        if (r7 != 0) goto L14;
        return "";
    L14:
        u r0 = this.f18255f;
        if (r0 == null) goto L24;
        int r2 = r0.f18304b;
        if ((((long) r2) + r7) > r0.f18305c) goto L19;
        int r3 = (int) r7;
        String r4 = new String(r0.f18303a, r2, r3, r9);
        int r10 = r0.f18304b + r3;
        r0.f18304b = r10;
        this.f18256g -= r7;
        if (r10 != r0.f18305c) goto L23;
        this.f18255f = r0.b();
        v.f18312c.a(r0);
    L23:
        return r4;
    L19:
        return new String(T(r7), r9);
    L24:
        kotlin.n0.d.o.p();
        throw null;
    L27:
        throw new EOFException();
    L29:
        throw new IllegalArgumentException(("byteCount: " + r7).toString());
    L5:
        if (r7 > Integer.MAX_VALUE) goto L7;
        r1 = true;
        goto L8
    }

    public int hashCode() {
        u r0 = this.f18255f;
        if (r0 == null) goto L15;
        int r1 = 1;
    L5:
        int r2 = r0.f18304b;
        int r3 = r0.f18305c;
    L6:
        if (r2 >= r3) goto L8;
        r1 = (r1 * 31) + r0.f18303a[r2];
        r2 = r2 + 1;
        goto L6
    L8:
        r0 = r0.f18308f;
        if (r0 == null) goto L13;
        if (r0 != this.f18255f) goto L5;
        return r1;
    L13:
        kotlin.n0.d.o.p();
        throw null;
    L15:
        return 0;
    }

    public String i0() {
        return h0(this.f18256g, kotlin.u0.d.f21429a);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final void j0(long r1) {
        this.f18256g = r1;
    }

    @Override // k.g
    public InputStream k() {
        return new b(this);
    }

    public final long k0() {
        return this.f18256g;
    }

    public final h l0() {
        if (k0() > Integer.MAX_VALUE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return m0((int) k0());
    L10:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + k0()).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // k.g
    public String m(long r2) {
        return h0(r2, kotlin.u0.d.f21429a);
    }

    public final h m0(int r9) {
        if (r9 == 0) goto L28;
        k.c.b(k0(), 0, r9);
        u r0 = this.f18255f;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r9) goto L15;
        if (r0 == null) goto L13;
        int r4 = r0.f18305c;
        int r5 = r0.f18304b;
        if (r4 == r5) goto L12;
        r2 = r2 + (r4 - r5);
        r3 = r3 + 1;
        r0 = r0.f18308f;
        goto L6
    L12:
        throw new AssertionError("s.limit == s.pos");
    L13:
        kotlin.n0.d.o.p();
        throw null;
    L15:
        byte[][] r6 = new byte[r3][];
        int[] r7 = new int[r3 * 2];
        u r8 = this.f18255f;
        int r10 = 0;
    L16:
        if (r1 >= r9) goto L22;
        if (r8 == null) goto L19;
        r6[r10] = r8.f18303a;
        r1 = r1 + (r8.f18305c - r8.f18304b);
        r7[r10] = Math.min(r1, r9);
        r7[r10 + r3] = r8.f18304b;
        r8.f18306d = true;
        r10 = r10 + 1;
        r8 = r8.f18308f;
        goto L16
    L19:
        kotlin.n0.d.o.p();
        throw null;
    L22:
        return new w(r6, r7);
    L28:
        return h.f18266i;
    }

    @Override // k.g
    public h n(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L19;
        if (k0() < r3) goto L17;
        if (r3 < 4096) goto L15;
        h r1 = m0((int) r3);
        skip(r3);
        return r1;
    L15:
        return new h(T(r3));
    L17:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException(("byteCount: " + r3).toString());
    L5:
        if (r3 > Integer.MAX_VALUE) goto L7;
        r0 = true;
        goto L8
    }

    public final u n0(int r3) {
        boolean r1 = true;
        if (r3 < 1) goto L6;
        if (r3 > 8192) goto L6;
    L7:
        if (r1 == false) goto L28;
        u r2 = this.f18255f;
        if (r2 != null) goto L12;
        u r4 = v.f18312c.b();
        this.f18255f = r4;
        r4.f18309g = r4;
        r4.f18308f = r4;
        return r4;
    L12:
        if (r2 == null) goto L25;
        u r5 = r2.f18309g;
        if (r5 != null) goto L16;
        kotlin.n0.d.o.p();
        throw null;
    L16:
        if ((r5.f18305c + r3) <= 8192) goto L18;
    L21:
        u r6 = v.f18312c.b();
        r5.c(r6);
        return r6;
    L18:
        if (r5.f18307e == false) goto L21;
        return r5;
    L25:
        kotlin.n0.d.o.p();
        throw null;
    L28:
        throw new IllegalArgumentException("unexpected capacity".toString());
    L6:
        r1 = false;
        goto L7
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f o() {
        M();
        return this;
    }

    public e o0(h r3) {
        kotlin.n0.d.o.g(r3, "byteString");
        r3.G(this, 0, r3.size());
        return this;
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f p(int r1) {
        z0(r1);
        return this;
    }

    public e p0(byte[] r3) {
        kotlin.n0.d.o.g(r3, "source");
        q0(r3, 0, r3.length);
        return this;
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f q(int r1) {
        v0(r1);
        return this;
    }

    public e q0(byte[] r10, int r11, int r12) {
        kotlin.n0.d.o.g(r10, "source");
        long r7 = r12;
        k.c.b(r10.length, r11, r7);
        int r13 = r12 + r11;
    L3:
        if (r11 >= r13) goto L5;
        u r0 = n0(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.f18305c);
        int r4 = r11 + r1;
        kotlin.i0.i.e(r10, r0.f18303a, r0.f18305c, r11, r4);
        r0.f18305c += r1;
        r11 = r4;
        goto L3
    L5:
        j0(k0() + r7);
        return this;
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f r(long r1) {
        y0(r1);
        return this;
    }

    public long r0(z r7) {
        kotlin.n0.d.o.g(r7, "source");
        long r0 = 0;
    L3:
        long r2 = r7.Z(this, 8192);
        if (r2 == (-1)) goto L5;
        r0 = r0 + r2;
        goto L3
    L5:
        return r0;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r7) {
        kotlin.n0.d.o.g(r7, "sink");
        u r0 = this.f18255f;
        if (r0 == null) goto L8;
        int r1 = Math.min(r7.remaining(), r0.f18305c - r0.f18304b);
        r7.put(r0.f18303a, r0.f18304b, r1);
        int r8 = r0.f18304b + r1;
        r0.f18304b = r8;
        this.f18256g -= (long) r1;
        if (r8 != r0.f18305c) goto L7;
        this.f18255f = r0.b();
        v.f18312c.a(r0);
    L7:
        return r1;
    L8:
        return -1;
    }

    public int read(byte[] r8, int r9, int r10) {
        kotlin.n0.d.o.g(r8, "sink");
        k.c.b(r8.length, r9, r10);
        u r0 = this.f18255f;
        if (r0 == null) goto L7;
        int r11 = Math.min(r10, r0.f18305c - r0.f18304b);
        byte[] r1 = r0.f18303a;
        int r2 = r0.f18304b;
        kotlin.i0.i.e(r1, r8, r9, r2, r2 + r11);
        r0.f18304b += r11;
        j0(k0() - ((long) r11));
        if (r0.f18304b != r0.f18305c) goto L9;
        this.f18255f = r0.b();
        v.f18312c.a(r0);
        return r11;
    L9:
        return r11;
    L7:
        return -1;
    }

    @Override // k.g
    public byte readByte() {
        if (k0() == 0) goto L14;
        u r0 = this.f18255f;
        if (r0 == null) goto L11;
        int r1 = r0.f18304b;
        int r2 = r0.f18305c;
        int r4 = r1 + 1;
        byte r3 = r0.f18303a[r1];
        j0(k0() - 1);
        if (r4 != r2) goto L9;
        this.f18255f = r0.b();
        v.f18312c.a(r0);
    L10:
        return r3;
    L9:
        r0.f18304b = r4;
        goto L10
    L11:
        kotlin.n0.d.o.p();
        throw null;
    L14:
        throw new EOFException();
    }

    @Override // k.g
    public void readFully(byte[] r4) {
        kotlin.n0.d.o.g(r4, "sink");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        int r1 = read(r4, r0, r4.length - r0);
        if (r1 == (-1)) goto L9;
        r0 = r0 + r1;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // k.g
    public int readInt() {
        if (k0() < 4) goto L18;
        u r0 = this.f18255f;
        if (r0 == null) goto L15;
        int r1 = r0.f18304b;
        int r4 = r0.f18305c;
        if ((r4 - r1) < 4) goto L19;
        byte[] r5 = r0.f18303a;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & 255) << 24) | ((r5[r6] & 255) << 16);
        int r8 = r7 + 1;
        int r3 = r2 | ((r5[r7] & 255) << 8);
        int r9 = r8 + 1;
        int r10 = r3 | (r5[r8] & 255);
        j0(k0() - 4);
        if (r9 != r4) goto L12;
        this.f18255f = r0.b();
        v.f18312c.a(r0);
    L14:
        return r10;
    L12:
        r0.f18304b = r9;
        goto L14
    L19:
        return (readByte() & 255) | ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8));
    L15:
        kotlin.n0.d.o.p();
        throw null;
    L18:
        throw new EOFException();
    }

    @Override // k.g
    public long readLong() {
        if (k0() < 8) goto L18;
        u r0 = this.f18255f;
        if (r0 == null) goto L15;
        int r1 = r0.f18304b;
        int r4 = r0.f18305c;
        if ((r4 - r1) < 8) goto L19;
        byte[] r5 = r0.f18303a;
        int r7 = r1 + 1;
        long r8 = (((long) r5[r1]) & 255) << 56;
        int r2 = r7 + 1;
        int r9 = r2 + 1;
        long r10 = (r8 | ((((long) r5[r7]) & 255) << 48)) | ((((long) r5[r2]) & 255) << 40);
        int r3 = r9 + 1;
        int r11 = r3 + 1;
        long r6 = (r10 | ((((long) r5[r9]) & 255) << 32)) | ((((long) r5[r3]) & 255) << 24);
        int r12 = r11 + 1;
        long r13 = r6 | ((((long) r5[r11]) & 255) << 16);
        int r14 = r12 + 1;
        long r15 = r13 | ((((long) r5[r12]) & 255) << 8);
        int r16 = r14 + 1;
        long r17 = r15 | (((long) r5[r14]) & 255);
        j0(k0() - 8);
        if (r16 != r4) goto L12;
        this.f18255f = r0.b();
        v.f18312c.a(r0);
    L14:
        return r17;
    L12:
        r0.f18304b = r16;
        goto L14
    L19:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L15:
        kotlin.n0.d.o.p();
        throw null;
    L18:
        throw new EOFException();
    }

    @Override // k.g
    public short readShort() {
        if (k0() < 2) goto L18;
        u r0 = this.f18255f;
        if (r0 == null) goto L15;
        int r1 = r0.f18304b;
        int r4 = r0.f18305c;
        if ((r4 - r1) >= 2) goto L9;
        int r2 = (readByte() & 255) << 8;
        return (short) ((readByte() & 255) | r2);
    L9:
        byte[] r5 = r0.f18303a;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r3 = ((r5[r1] & 255) << 8) | (r5[r6] & 255);
        j0(k0() - 2);
        if (r7 != r4) goto L12;
        this.f18255f = r0.b();
        v.f18312c.a(r0);
    L14:
        return (short) r3;
    L12:
        r0.f18304b = r7;
        goto L14
    L15:
        kotlin.n0.d.o.p();
        throw null;
    L18:
        throw new EOFException();
    }

    public e s0(int r5) {
        u r0 = n0(1);
        byte[] r1 = r0.f18303a;
        int r2 = r0.f18305c;
        r0.f18305c = r2 + 1;
        r1[r2] = (byte) r5;
        j0(k0() + 1);
        return this;
    }

    @Override // k.g
    public void skip(long r7) {
    L3:
        if (r7 <= 0) goto L11;
        u r0 = this.f18255f;
        if (r0 == null) goto L10;
        int r1 = (int) Math.min(r7, r0.f18305c - r0.f18304b);
        long r4 = r1;
        j0(k0() - r4);
        r7 = r7 - r4;
        int r2 = r0.f18304b + r1;
        r0.f18304b = r2;
        if (r2 != r0.f18305c) goto L3;
        this.f18255f = r0.b();
        v.f18312c.a(r0);
        goto L3
    L10:
        throw new EOFException();
    }

    @Override // k.g
    public byte[] t() {
        return T(k0());
    }

    public e t0(long r13) {
        if (r13 != 0) goto L5;
        s0(48);
    L76:
        return this;
    L5:
        boolean r3 = false;
        int r4 = 1;
        if (r13 >= 0) goto L12;
        r13 = -r13;
        if (r13 >= 0) goto L10;
        B0("-9223372036854775808");
        goto L76
    L10:
        r3 = true;
    L12:
        if (r13 >= 100000000) goto L37;
        if (r13 >= BDLocationConfig.sScanBleMaxInterval) goto L27;
        if (r13 >= 100) goto L22;
        if (r13 < 10) goto L67;
        r4 = 2;
    L67:
        if (r3 == false) goto L69;
        r4 = r4 + 1;
    L69:
        u r2 = n0(r4);
        byte[] r6 = r2.f18303a;
        int r7 = r2.f18305c + r4;
    L71:
        if (r13 == 0) goto L73;
        long r8 = 10;
        r7 = r7 - 1;
        r6[r7] = k.c0.a.a()[(int) (r13 % r8)];
        r13 = r13 / r8;
        goto L71
    L73:
        if (r3 == false) goto L75;
        r6[r7 - 1] = (byte) 45;
    L75:
        r2.f18305c += r4;
        j0(k0() + ((long) r4));
        goto L76
    L22:
        if (r13 >= 1000) goto L24;
        int r5 = 3;
    L25:
        r4 = r5;
        goto L67
    L24:
        r5 = 4;
        goto L25
    L27:
        if (r13 >= TimeUtils.NANOSECONDS_PER_MILLISECOND) goto L33;
        if (r13 >= 100000) goto L31;
        r5 = 5;
        goto L25
    L31:
        r5 = 6;
        goto L25
    L33:
        if (r13 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L35;
        r5 = 7;
        goto L25
    L35:
        r5 = 8;
        goto L25
    L37:
        if (r13 >= 1000000000000L) goto L49;
        if (r13 >= 10000000000L) goto L45;
        if (r13 >= 1000000000) goto L43;
        r4 = 9;
        goto L67
    L43:
        r4 = 10;
        goto L67
    L45:
        if (r13 >= 100000000000L) goto L47;
        r5 = 11;
        goto L25
    L47:
        r5 = 12;
        goto L25
    L49:
        if (r13 >= 1000000000000000L) goto L58;
        if (r13 >= 10000000000000L) goto L54;
        r4 = 13;
        goto L67
    L54:
        if (r13 >= 100000000000000L) goto L56;
        r5 = 14;
        goto L25
    L56:
        r5 = 15;
        goto L25
    L58:
        if (r13 >= 100000000000000000L) goto L64;
        if (r13 >= 10000000000000000L) goto L62;
        r4 = 16;
        goto L67
    L62:
        r4 = 17;
        goto L67
    L64:
        if (r13 >= 1000000000000000000L) goto L66;
        r4 = 18;
        goto L67
    L66:
        r4 = 19;
        goto L67
    }

    public String toString() {
        return l0().toString();
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f u(int r1) {
        w0(r1);
        return this;
    }

    public e u0(long r13) {
        if (r13 != 0) goto L5;
        s0(48);
    L9:
        return this;
    L5:
        long r1 = (r13 >>> 1) | r13;
        long r2 = r1 | (r1 >>> 2);
        long r3 = r2 | (r2 >>> 4);
        long r4 = r3 | (r3 >>> 8);
        long r5 = r4 | (r4 >>> 16);
        long r6 = r5 | (r5 >>> 32);
        long r7 = r6 - ((r6 >>> 1) & 6148914691236517205L);
        long r8 = ((r7 >>> 2) & 3689348814741910323L) + (r7 & 3689348814741910323L);
        long r9 = ((r8 >>> 4) + r8) & 1085102592571150095L;
        long r10 = r9 + (r9 >>> 8);
        long r11 = r10 + (r10 >>> 16);
        int r12 = (int) ((((r11 & 63) + ((r11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        u r14 = n0(r12);
        byte[] r15 = r14.f18303a;
        int r16 = r14.f18305c;
        int r17 = (r16 + r12) - 1;
    L6:
        if (r17 < r16) goto L8;
        r15[r17] = k.c0.a.a()[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r17 = r17 - 1;
        goto L6
    L8:
        r14.f18305c += r12;
        j0(k0() + ((long) r12));
        goto L9
    }

    @Override // k.g
    public boolean v() {
        if (this.f18256g != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public e v0(int r6) {
        u r0 = n0(4);
        byte[] r1 = r0.f18303a;
        int r2 = r0.f18305c;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 24) & 255);
        int r4 = r3 + 1;
        r1[r3] = (byte) ((r6 >>> 16) & 255);
        int r5 = r4 + 1;
        r1[r4] = (byte) ((r6 >>> 8) & 255);
        r1[r5] = (byte) (r6 & 255);
        r0.f18305c = r5 + 1;
        j0(k0() + 4);
        return this;
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f w(int r1) {
        s0(r1);
        return this;
    }

    public e w0(int r1) {
        v0(k.c.c(r1));
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r7) {
        kotlin.n0.d.o.g(r7, "source");
        int r0 = r7.remaining();
        int r1 = r0;
    L3:
        if (r1 <= 0) goto L5;
        u r2 = n0(1);
        int r3 = Math.min(r1, 8192 - r2.f18305c);
        r7.get(r2.f18303a, r2.f18305c, r3);
        r1 = r1 - r3;
        r2.f18305c += r3;
        goto L3
    L5:
        this.f18256g += (long) r0;
        return r0;
    }

    public e x0(long r10) {
        u r1 = n0(8);
        byte[] r2 = r1.f18303a;
        int r3 = r1.f18305c;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r10 >>> 56) & 255);
        int r5 = r4 + 1;
        r2[r4] = (byte) ((r10 >>> 48) & 255);
        int r6 = r5 + 1;
        r2[r5] = (byte) ((r10 >>> 40) & 255);
        int r7 = r6 + 1;
        r2[r6] = (byte) ((r10 >>> 32) & 255);
        int r8 = r7 + 1;
        r2[r7] = (byte) ((r10 >>> 24) & 255);
        int r9 = r8 + 1;
        r2[r8] = (byte) ((r10 >>> 16) & 255);
        int r11 = r9 + 1;
        r2[r9] = (byte) ((r10 >>> 8) & 255);
        r2[r11] = (byte) (r10 & 255);
        r1.f18305c = r11 + 1;
        j0(k0() + 8);
        return this;
    }

    @Override // k.g
    public void y(e r3, long r4) {
        kotlin.n0.d.o.g(r3, "sink");
        if (k0() < r4) goto L6;
        r3.J(this, r4);
        return;
    L6:
        r3.J(this, k0());
        throw new EOFException();
    }

    public e y0(long r1) {
        x0(k.c.d(r1));
        return this;
    }

    @Override // k.f
    public /* bridge */ /* synthetic */ f z() {
        N();
        return this;
    }

    public e z0(int r6) {
        u r0 = n0(2);
        byte[] r1 = r0.f18303a;
        int r2 = r0.f18305c;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 8) & 255);
        r1[r3] = (byte) (r6 & 255);
        r0.f18305c = r3 + 1;
        j0(k0() + 2);
        return this;
    }
}
