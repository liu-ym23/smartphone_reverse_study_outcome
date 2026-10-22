package com.bytedance.apm.util;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final byte[] f2058l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RandomAccessFile f2060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f2061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f2064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f2065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f2066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f2067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f2068j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f2069k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2072c;

        a(String r1, int r2) {
            this.f2070a = r1;
            this.f2071b = (r2 >> 4) & 15;
            this.f2072c = r2 & 15;
        }

        private String a() {
            int r0 = this.f2071b;
            if (r0 != 0) goto L5;
            return "LOCAL";
        L5:
            if (r0 != 1) goto L7;
            return "GLOBAL";
        L7:
            if (r0 != 2) goto L9;
            return "WEAK";
        L9:
            return "STB_??? (" + this.f2071b + ")";
        }

        private String b() {
            switch(this.f2072c) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            return "TLS";
        L8:
            return "COMMON";
        L10:
            return "FILE";
        L12:
            return "SECTION";
        L14:
            return "FUNC";
        L16:
            return "OBJECT";
        L18:
            return "NOTYPE";
        L5:
            return "STT_??? (" + this.f2072c + ")";
        }

        public String toString() {
            return "Symbol[" + this.f2070a + "," + a() + "," + b() + "]";
        }
    }

    static {
        f2058l = new byte[]{127, 69, 76, 70};
    }

    private r(File r5) {
        this.f2061c = new byte[512];
        this.f2059a = r5.getPath();
        RandomAccessFile r0 = new RandomAccessFile(r5, "r");
        this.f2060b = r0;
        if (r0.length() < 16) goto L7;
        j();
        return;
    L7:
        throw new IllegalArgumentException("Too small to be an ELF file: " + r5);
    }

    private boolean b(String r9) {
        this.f2060b.seek(this.f2064f);
    L4:
        if (this.f2060b.getFilePointer() >= (this.f2064f + this.f2065g)) goto L18;
        long r6 = p();
        if (this.f2063e != 8) goto L8;
        int r0 = g();
        g();
        i();
        f();
        r(this.f2063e);
    L10:
        if (r6 == 0) goto L4;
        String r1 = n(this.f2068j, this.f2069k, r6);
        if (TextUtils.equals(r9, r1) == false) goto L4;
        if (new a(r1, r0).f2072c != 2) goto L4;
        return true;
    L8:
        f();
        p();
        r0 = g();
        g();
        i();
        goto L10
    L18:
        return false;
    }

    public static boolean c(File r4, String r5) {
        r r6 = e(r4);
        if (Math.max(r6.f2065g, r6.f2069k) > 200000) goto L5;
        boolean r7 = r6.d(r5);
    L6:
        r6.a();
        return r7;
    L5:
        r7 = r6.b(r5);
        goto L6
    }

    private boolean d(String r13) {
        HashSet r0 = new HashSet();
        byte[] r1 = new byte[(int) Math.max(this.f2065g, this.f2069k)];
        this.f2060b.seek(this.f2064f);
        this.f2060b.readFully(r1, 0, (int) this.f2065g);
        int r2 = 0;
    L4:
        if (r2 >= this.f2065g) goto L16;
        long r6 = q(r1, r2);
        int r3 = r2 + 4;
        int r4 = this.f2063e;
        if (r4 != 8) goto L8;
        int r5 = h(r1, r3);
        int r7 = this.f2063e;
        r2 = (r3 + 1) + ((r7 + 3) + r7);
    L10:
        if (r6 == 0) goto L4;
        if ((r5 & 15) != 2) goto L4;
        r0.add(Long.valueOf(r6));
        goto L4
    L8:
        int r8 = r3 + (r4 + 4);
        r5 = h(r1, r8);
        r2 = (r8 + 1) + 3;
        goto L10
    L16:
        this.f2060b.seek(this.f2068j);
        this.f2060b.readFully(r1, 0, (int) this.f2069k);
        byte[] r14 = r13.getBytes();
        int r9 = r14.length;
        Iterator r10 = r0.iterator();
    L18:
        if (r10.hasNext() == false) goto L31;
        Long r11 = (Long) r10.next();
        int r12 = 0;
    L20:
        if (r12 >= r9) goto L27;
        int r15 = (int) (((long) r12) + r11.longValue());
        if (r15 >= this.f2069k) goto L27;
        if (r1[r15] != r14[r12]) goto L27;
        r12 = r12 + 1;
    L27:
        if (r12 != r9) goto L18;
        if (r1[(int) (((long) r12) + r11.longValue())] != 0) goto L18;
        return true;
    L31:
        return false;
    }

    public static r e(File r1) {
        return new r(r1);
    }

    private long f() {
        return r(this.f2063e);
    }

    private int g() {
        return this.f2060b.read() & 255;
    }

    private int h(byte[] r1, int r2) {
        return r1[r2] & 255;
    }

    private int i() {
        return (int) r(2);
    }

    private void j() {
        this.f2060b.seek(0);
        this.f2060b.readFully(this.f2061c, 0, 16);
        byte[] r0 = this.f2061c;
        byte r1 = r0[0];
        byte[] r3 = f2058l;
        if (r1 != r3[0]) goto L54;
        if (r0[1] != r3[1]) goto L54;
        if (r0[2] != r3[2]) goto L54;
        if (r0[3] != r3[3]) goto L54;
        byte r5 = r0[4];
        if (r5 != 1) goto L13;
        this.f2063e = 4;
    L15:
        byte r2 = r0[5];
        this.f2062d = r2;
        if (r2 != 1) goto L46;
        i();
        int r4 = i();
        if (r4 == 3) goto L27;
        if (r4 == 62) goto L27;
        if (r4 == 183) goto L27;
        if (r4 == 40) goto L27;
        if (r4 == 8) goto L27;
        if (r4 == 164) goto L27;
        throw new IOException("Invalid ELF e_machine: " + r4 + ": " + this.f2059a);
    L27:
        if (r4 != 3) goto L29;
        if (r5 == 1) goto L29;
    L39:
        throw new IOException("Invalid e_machine/EI_CLASS ELF combination: " + r4 + "/" + r5 + ": " + this.f2059a);
    L29:
        if (r4 != 62) goto L31;
        if (r5 != 2) goto L39;
    L31:
        if (r4 != 183) goto L33;
        if (r5 != 2) goto L39;
    L33:
        if (r4 != 40) goto L35;
        if (r5 != 1) goto L39;
    L35:
        if (r4 != 164) goto L40;
        if (r5 != 1) goto L39;
    L40:
        long r6 = p();
        if (r6 != 1) goto L45;
        f();
        k();
        long r9 = k();
        p();
        i();
        i();
        i();
        l(r9, i(), i(), i());
        return;
    L45:
        throw new IOException("Invalid e_version: " + r6 + ": " + this.f2059a);
    L46:
        if (r2 != 2) goto L50;
        throw new IOException("Unsupported ELFDATA2MSB file: " + this.f2059a);
    L50:
        throw new IOException("Invalid ELF EI_DATA: " + this.f2062d + ": " + this.f2059a);
    L13:
        if (r5 != 2) goto L52;
        this.f2063e = 8;
        goto L15
    L52:
        throw new IOException("Invalid ELF EI_CLASS: " + r5 + ": " + this.f2059a);
    L54:
        throw new IllegalArgumentException("Invalid ELF file: " + this.f2059a);
    }

    private long k() {
        return r(this.f2063e);
    }

    private void l(long r17, int r19, int r20, int r21) {
        this.f2060b.seek(r17 + ((long) (r21 * r20)));
        p();
        long r2 = p();
        r(this.f2063e);
        f();
        long r4 = k();
        long r6 = r(this.f2063e);
        if (r2 != 3) goto L5;
        this.f2066h = r4;
        this.f2067i = r6;
    L5:
        int r3 = 0;
    L6:
        if (r3 >= r19) goto L27;
        if (r3 == r21) goto L26;
        this.f2060b.seek(r17 + ((long) (r3 * r20)));
        long r5 = p();
        long r7 = p();
        r(this.f2063e);
        f();
        long r10 = k();
        long r12 = r(this.f2063e);
        if (r7 != 2) goto L12;
    L22:
        String r8 = m(r5);
        if (".symtab".equals(r8) == false) goto L25;
        this.f2064f = r10;
        this.f2065g = r12;
        goto L26
    L25:
        String r9 = ".dynsym";
    L20:
        r9.equals(r8);
        goto L26
    L12:
        if (r7 == 11) goto L22;
        if (r7 != 3) goto L21;
        r8 = m(r5);
        if (".strtab".equals(r8) == false) goto L19;
        this.f2068j = r10;
        this.f2069k = r12;
        goto L26
    L19:
        r9 = ".dynstr";
        goto L20
    L21:
        int r11 = (r7 > 6 ? 1 : (r7 == 6 ? 0 : -1));
    L26:
        r3 = r3 + 1;
        goto L6
    }

    private String m(long r6) {
        long r0 = this.f2066h;
        if (r0 != 0) goto L5;
        return null;
    L5:
        if (r6 >= 0) goto L7;
        return null;
    L7:
        if (r6 < this.f2067i) goto L10;
        return null;
    L10:
        return o(r0 + r6);
    }

    private String n(long r4, long r6, long r8) {
        if (r4 != 0) goto L5;
        return null;
    L5:
        if (r8 >= 0) goto L7;
        return null;
    L7:
        if (r8 < r6) goto L10;
        return null;
    L10:
        return o(r4 + r8);
    }

    private String o(long r9) {
        long r0 = this.f2060b.getFilePointer();
        this.f2060b.seek(r9);
        RandomAccessFile r2 = this.f2060b;
        byte[] r3 = this.f2061c;
        r2.readFully(r3, 0, (int) Math.min(r3.length, r2.length() - r9));
        this.f2060b.seek(r0);
        int r10 = 0;
    L3:
        byte[] r1 = this.f2061c;
        if (r10 >= r1.length) goto L10;
        if (r1[r10] == 0) goto L8;
        r10 = r10 + 1;
        goto L3
    L8:
        return new String(this.f2061c, 0, r10);
    L10:
        return null;
    }

    private long p() {
        return r(4);
    }

    private long q(byte[] r2, int r3) {
        return s(4, r2, r3);
    }

    private long r(int r4) {
        int r2 = 0;
        this.f2060b.readFully(this.f2061c, 0, r4);
        int r5 = r4 - 1;
        if (this.f2062d != 1) goto L6;
    L4:
        if (r5 < 0) goto L11;
        r2 = (r2 << 8) | (this.f2061c[r5] & 255);
        r5 = r5 - 1;
    L11:
        return r2;
    L6:
        int r0 = 0;
    L7:
        if (r2 > r5) goto L9;
        r0 = (r0 << 8) | (this.f2061c[r2] & 255);
        r2 = r2 + 1;
        goto L7
    L9:
        r2 = r0;
        goto L11
    }

    private long s(int r3, byte[] r4, int r5) {
        int r0 = 0;
        int r6 = r3 - 1;
        if (this.f2062d != 1) goto L6;
    L4:
        if (r6 < 0) goto L11;
        r0 = (r4[r6 + r5] & 255) | (r0 << 8);
        r6 = r6 - 1;
    L11:
        return r0;
    L6:
        int r2 = 0;
    L7:
        if (r0 > r6) goto L9;
        r2 = (r2 << 8) | (r4[r0 + r5] & 255);
        r0 = r0 + 1;
        goto L7
    L9:
        r0 = r2;
        goto L11
    }

    public void a() {
        this.f2060b.close();     // Catch: IOException -> L4
        return;
    }

    protected void finalize() {
        a();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }
}
