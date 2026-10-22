package com.google.gson.a0;

import com.google.gson.internal.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Reader f6862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final char[] f6864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6868l;
    int m;
    private long n;
    private int o;
    private String p;
    private int[] q;
    private int r;
    private String[] s;
    private int[] t;

    /* JADX INFO: renamed from: com.google.gson.a0.a$a, reason: collision with other inner class name */
    class C0208a extends e {
        C0208a() {
        }

        @Override // com.google.gson.internal.e
        public void a(a r3) {
            if ((r3 instanceof com.google.gson.internal.bind.a) == false) goto L6;
            ((com.google.gson.internal.bind.a) r3).B0();
            return;
        L6:
            int r2 = r3.m;
            if (r2 != 0) goto L10;
            r2 = r3.s();
        L10:
            if (r2 != 13) goto L14;
            int r4 = 9;
        L12:
            r3.m = r4;
            return;
        L14:
            if (r2 != 12) goto L17;
            r4 = 8;
            goto L12
        L17:
            if (r2 != 14) goto L21;
            r4 = 10;
            goto L12
        L21:
            throw new IllegalStateException("Expected a name but was " + r3.k0() + r3.O());
        }
    }

    static {
        e.f7042a = new C0208a();
    }

    public a(Reader r5) {
        this.f6863g = false;
        this.f6864h = new char[1024];
        this.f6865i = 0;
        this.f6866j = 0;
        this.f6867k = 0;
        this.f6868l = 0;
        this.m = 0;
        int[] r2 = new int[32];
        this.q = r2;
        this.r = 0;
        this.r = 0 + 1;
        r2[0] = 6;
        this.s = new String[32];
        this.t = new int[32];
        Objects.requireNonNull(r5, "in == null");
        this.f6862f = r5;
    }

    private boolean C(int r8) {
        char[] r0 = this.f6864h;
        int r1 = this.f6868l;
        int r2 = this.f6865i;
        this.f6868l = r1 - r2;
        int r3 = this.f6866j;
        if (r3 == r2) goto L5;
        int r4 = r3 - r2;
        this.f6866j = r4;
        System.arraycopy(r0, r2, r0, 0, r4);
    L6:
        this.f6865i = 0;
    L7:
        Reader r5 = this.f6862f;
        int r6 = this.f6866j;
        int r7 = r5.read(r0, r6, r0.length - r6);
        if (r7 == (-1)) goto L19;
        int r9 = this.f6866j + r7;
        this.f6866j = r9;
        if (this.f6867k != 0) goto L17;
        int r10 = this.f6868l;
        if (r10 != 0) goto L17;
        if (r9 <= 0) goto L17;
        if (r0[0] != 65279) goto L17;
        this.f6865i++;
        this.f6868l = r10 + 1;
        r8 = r8 + 1;
    L17:
        if (r9 < r8) goto L7;
        return true;
    L19:
        return false;
    L5:
        this.f6866j = 0;
        goto L6
    }

    private String E(boolean r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append('$');
        int r1 = 0;
    L3:
        int r2 = this.r;
        if (r1 >= r2) goto L28;
        int r3 = this.q[r1];
        if (r3 != 1) goto L8;
    L19:
        int r4 = this.t[r1];
        if (r6 == false) goto L25;
        if (r4 <= 0) goto L25;
        if (r1 != (r2 - 1)) goto L25;
        r4 = r4 - 1;
    L25:
        r0.append('[');
        r0.append(r4);
        r0.append(']');
    L26:
        r1 = r1 + 1;
        goto L3
    L8:
        if (r3 == 2) goto L19;
        if (r3 != 3) goto L12;
    L16:
        r0.append('.');
        String[] r5 = this.s;
        if (r5[r1] == null) goto L26;
        r0.append(r5[r1]);
        goto L26
    L12:
        if (r3 == 4) goto L16;
        if (r3 == 5) goto L16;
    L28:
        return r0.toString();
    }

    private boolean N(char r2) {
        if (r2 != '\t') goto L5;
        return false;
    L5:
        if (r2 != '\n') goto L7;
        return false;
    L7:
        if (r2 != '\f') goto L9;
        return false;
    L9:
        if (r2 != '\r') goto L11;
        return false;
    L11:
        if (r2 != ' ') goto L13;
        return false;
    L13:
        if (r2 != '#') goto L15;
    L31:
        g();
        return false;
    L15:
        if (r2 != ',') goto L17;
        return false;
    L17:
        if (r2 == '/') goto L31;
        if (r2 == '=') goto L31;
        if (r2 != '{') goto L23;
        return false;
    L23:
        if (r2 != '}') goto L25;
        return false;
    L25:
        if (r2 != ':') goto L27;
        return false;
    L27:
        if (r2 == ';') goto L31;
        switch(r2) {
            case 91: goto L43;
            case 92: goto L31;
            case 93: goto L43;
            default: goto L29;
        };
    L29:
        return true;
    L43:
        return false;
    }

    private int d0(boolean r8) {
        char[] r0 = this.f6864h;
    L3:
        int r1 = this.f6865i;
    L4:
        int r2 = this.f6866j;
    L6:
        if (r1 != r2) goto L15;
        this.f6865i = r1;
        if (C(1) == false) goto L9;
        r1 = this.f6865i;
        r2 = this.f6866j;
        goto L15
    L9:
        if (r8 == true) goto L13;
        return -1;
    L13:
        throw new EOFException("End of input" + O());
    L15:
        int r4 = r1 + 1;
        char r3 = r0[r1];
        if (r3 != '\n') goto L19;
        this.f6867k++;
        this.f6868l = r4;
    L47:
        r1 = r4;
        goto L6
    L19:
        if (r3 == ' ') goto L47;
        if (r3 == '\r') goto L47;
        if (r3 == '\t') goto L47;
        if (r3 != '/') goto L43;
        this.f6865i = r4;
        if (r4 != r2) goto L32;
        this.f6865i = r4 - 1;
        boolean r5 = C(2);
        this.f6865i++;
        if (r5 == true) goto L32;
        return r3;
    L32:
        g();
        int r6 = this.f6865i;
        char r7 = r0[r6];
        if (r7 != '*') goto L34;
        this.f6865i = r6 + 1;
        if (r0("*/") == false) goto L41;
        r1 = this.f6865i + 2;
        goto L4
    L41:
        v0("Unterminated comment");
        throw null;
    L34:
        if (r7 != '/') goto L35;
        this.f6865i = r6 + 1;
    L37:
        s0();
        goto L3
    L35:
        return r3;
    L43:
        this.f6865i = r4;
        if (r3 != '#') goto L46;
        g();
        goto L37
    L46:
        return r3;
    }

    private void g() {
        if (this.f6863g == false) goto L5;
        return;
    L5:
        v0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    private String h0(char r11) {
        char[] r0 = this.f6864h;
        StringBuilder r2 = null;
    L3:
        int r3 = this.f6865i;
        int r4 = this.f6866j;
    L5:
        if (r3 >= r4) goto L24;
        int r8 = r3 + 1;
        char r5 = r0[r3];
        if (r5 == r11) goto L8;
        if (r5 == '\\') goto L16;
        if (r5 != '\n') goto L23;
        this.f6867k++;
        this.f6868l = r8;
    L23:
        r3 = r8;
        goto L5
    L16:
        this.f6865i = r8;
        int r9 = (r8 - r3) - 1;
        if (r2 != null) goto L19;
        r2 = new StringBuilder(Math.max((r9 + 1) * 2, 16));
    L19:
        r2.append(r0, r3, r9);
        r2.append(o0());
        goto L3
    L8:
        this.f6865i = r8;
        int r10 = (r8 - r3) - 1;
        if (r2 == null) goto L11;
        r2.append(r0, r3, r10);
        return r2.toString();
    L11:
        return new String(r0, r3, r10);
    L24:
        if (r2 != null) goto L26;
        r2 = new StringBuilder(Math.max((r3 - r3) * 2, 16));
    L26:
        r2.append(r0, r3, r3 - r3);
        this.f6865i = r3;
        if (C(1) == true) goto L3;
        v0("Unterminated string");
        throw null;
    }

    private String j0() {
        int r0 = 0;
        StringBuilder r1 = null;
    L3:
        int r2 = 0;
    L4:
        int r3 = this.f6865i;
        if ((r3 + r2) < this.f6866j) goto L6;
        if (r2 >= this.f6864h.length) goto L41;
        if (C(r2 + 1) == true) goto L4;
    L40:
        r0 = r2;
    L45:
        if (r1 != null) goto L47;
        String r4 = new String(this.f6864h, this.f6865i, r0);
    L48:
        this.f6865i += r0;
        return r4;
    L47:
        r1.append(this.f6864h, this.f6865i, r0);
        r4 = r1.toString();
        goto L48
    L41:
        if (r1 != null) goto L43;
        r1 = new StringBuilder(Math.max(r2, 16));
    L43:
        r1.append(this.f6864h, this.f6865i, r2);
        this.f6865i += r2;
        if (C(1) == true) goto L3;
    L6:
        char r5 = this.f6864h[r3 + r2];
        if (r5 == '\t') goto L40;
        if (r5 == '\n') goto L40;
        if (r5 == '\f') goto L40;
        if (r5 == '\r') goto L40;
        if (r5 == ' ') goto L40;
        if (r5 == '#') goto L34;
        if (r5 == ',') goto L40;
        if (r5 == '/') goto L34;
        if (r5 == '=') goto L34;
        if (r5 == '{') goto L40;
        if (r5 == '}') goto L40;
        if (r5 == ':') goto L40;
        if (r5 == ';') goto L34;
        switch(r5) {
            case 91: goto L40;
            case 92: goto L34;
            case 93: goto L40;
            default: goto L33;
        };
    L33:
        r2 = r2 + 1;
    L34:
        g();
        goto L40
    }

    private void l() {
        d0(true);
        int r1 = this.f6865i - 1;
        this.f6865i = r1;
        if ((r1 + 5) > this.f6866j) goto L5;
    L7:
        int r2 = this.f6865i;
        char[] r3 = this.f6864h;
        if (r3[r2] == ')') goto L10;
        return;
    L10:
        if (r3[r2 + 1] == ']') goto L12;
        return;
    L12:
        if (r3[r2 + 2] == '}') goto L14;
        return;
    L14:
        if (r3[r2 + 3] == '\'') goto L16;
        return;
    L16:
        if (r3[r2 + 4] != '\n') goto L24;
        this.f6865i = r2 + 5;
        return;
    L24:
        return;
    L5:
        if (C(5) == true) goto L7;
    }

    private int l0() {
        char r0 = this.f6864h[this.f6865i];
        if (r0 != 't') goto L5;
    L20:
        int r1 = 5;
        String r2 = "true";
        String r3 = "TRUE";
    L21:
        int r4 = r2.length();
        int r5 = 1;
    L22:
        if (r5 >= r4) goto L35;
        if ((this.f6865i + r5) >= this.f6866j) goto L26;
    L28:
        char r6 = this.f6864h[this.f6865i + r5];
        if (r6 == r2.charAt(r5)) goto L33;
        if (r6 == r3.charAt(r5)) goto L33;
        return 0;
    L33:
        r5 = r5 + 1;
        goto L22
    L26:
        if (C(r5 + 1) == true) goto L28;
        return 0;
    L35:
        if ((this.f6865i + r4) < this.f6866j) goto L39;
        if (C(r4 + 1) == true) goto L39;
    L41:
        this.f6865i += r4;
        this.m = r1;
        return r1;
    L39:
        if (N(this.f6864h[this.f6865i + r4]) == false) goto L41;
        return 0;
    L5:
        if (r0 == 'T') goto L20;
        if (r0 != 'f') goto L10;
    L19:
        r1 = 6;
        r2 = "false";
        r3 = "FALSE";
        goto L21
    L10:
        if (r0 == 'F') goto L19;
        if (r0 != 'n') goto L15;
    L18:
        r1 = 7;
        r2 = "null";
        r3 = "NULL";
        goto L21
    L15:
        if (r0 == 'N') goto L18;
        return 0;
    }

    private int m0() {
        char[] r1 = this.f6864h;
        int r2 = this.f6865i;
        int r3 = this.f6866j;
        int r7 = 0;
        boolean r10 = true;
        int r8 = 0;
        char r9 = 0;
        boolean r13 = false;
        long r11 = 0;
    L4:
        if ((r2 + r8) == r3) goto L6;
    L12:
        char r14 = r1[r2 + r8];
        char r4 = 3;
        if (r14 != '+') goto L15;
        r4 = 6;
        r7 = 0;
        if (r9 != 5) goto L101;
    L99:
        r9 = r4;
    L100:
        r8 = r8 + 1;
        goto L4
    L101:
        return 0;
    L15:
        if (r14 != 'E') goto L17;
    L90:
        r7 = 0;
        if (r9 != 2) goto L93;
    L96:
        r9 = 5;
        goto L100
    L93:
        if (r9 == 4) goto L96;
        return 0;
    L17:
        if (r14 == 'e') goto L90;
        if (r14 != '-') goto L21;
        r4 = 6;
        r7 = 0;
        if (r9 != 0) goto L87;
        r9 = 1;
        r13 = true;
        goto L100
    L87:
        if (r9 == 5) goto L99;
        return 0;
    L21:
        if (r14 != '.') goto L23;
        r7 = 0;
        if (r9 == 2) goto L99;
        return 0;
    L23:
        if (r14 < '0') goto L54;
        if (r14 > '9') goto L54;
        if (r9 == 1) goto L50;
        if (r9 == 0) goto L50;
        if (r9 == 2) goto L32;
        if (r9 != 3) goto L46;
        r7 = 0;
        r9 = 4;
        goto L100
    L46:
        if (r9 != 5) goto L48;
    L49:
        r7 = 0;
        r9 = 7;
        goto L100
    L48:
        if (r9 == 6) goto L49;
    L51:
        r7 = 0;
        goto L100
    L32:
        if (r11 == 0) goto L33;
        long r5 = (10 * r11) - ((long) (r14 - '0'));
        if (r11 > (-922337203685477580L)) goto L42;
        if (r11 == (-922337203685477580L)) goto L39;
    L41:
        boolean r12 = false;
    L43:
        r10 = r10 & r12;
        r11 = r5;
        goto L51
    L39:
        if (r5 >= r11) goto L41;
    L42:
        r12 = true;
        goto L43
    L33:
        return 0;
    L50:
        r11 = -(r14 - '0');
        r9 = 2;
    L54:
        if (N(r14) == true) goto L78;
    L55:
        if (r9 != 2) goto L69;
        if (r10 == false) goto L69;
        if (r11 != Long.MIN_VALUE) goto L61;
        if (r13 == false) goto L69;
    L61:
        if (r11 != 0) goto L63;
        if (r13 == true) goto L69;
    L63:
        if (r13 == true) goto L66;
        r11 = -r11;
    L66:
        this.n = r11;
        this.f6865i += r8;
        int r6 = 15;
    L67:
        this.m = r6;
        return r6;
    L69:
        if (r9 != 2) goto L71;
    L77:
        this.o = r8;
        r6 = 16;
        goto L67
    L71:
        if (r9 == 4) goto L77;
        if (r9 == 7) goto L77;
        return 0;
    L78:
        return 0;
    L6:
        if (r8 == r1.length) goto L7;
        if (C(r8 + 1) == false) goto L55;
        r2 = this.f6865i;
        r3 = this.f6866j;
        goto L12
    L7:
        return r7;
    }

    private void n0(int r4) {
        int r0 = this.r;
        int[] r1 = this.q;
        if (r0 != r1.length) goto L5;
        int r2 = r0 * 2;
        this.q = Arrays.copyOf(r1, r2);
        this.t = Arrays.copyOf(this.t, r2);
        this.s = (String[]) Arrays.copyOf(this.s, r2);
    L5:
        int[] r3 = this.q;
        int r5 = this.r;
        this.r = r5 + 1;
        r3[r5] = r4;
    }

    private char o0() {
        if (this.f6865i == this.f6866j) goto L5;
    L9:
        char[] r0 = this.f6864h;
        int r1 = this.f6865i;
        int r5 = r1 + 1;
        this.f6865i = r5;
        char r2 = r0[r1];
        if (r2 != '\n') goto L12;
        this.f6867k++;
        this.f6868l = r5;
    L73:
        return r2;
    L12:
        if (r2 == '\"') goto L73;
        if (r2 == '\'') goto L73;
        if (r2 == '/') goto L73;
        if (r2 == '\\') goto L73;
        if (r2 != 'b') goto L22;
        return '\b';
    L22:
        if (r2 != 'f') goto L24;
        return '\f';
    L24:
        if (r2 != 'n') goto L26;
        return '\n';
    L26:
        if (r2 != 'r') goto L28;
        return '\r';
    L28:
        if (r2 != 't') goto L30;
        return '\t';
    L30:
        if (r2 == 'u') goto L32;
        v0("Invalid escape sequence");
        throw null;
    L32:
        if ((r5 + 4) > this.f6866j) goto L34;
    L38:
        char r3 = 0;
        int r4 = this.f6865i;
        int r6 = r4 + 4;
    L39:
        if (r4 >= r6) goto L59;
        char r7 = this.f6864h[r4];
        char r8 = (char) (r3 << 4);
        if (r7 < '0') goto L47;
        if (r7 > '9') goto L47;
        int r9 = r7 - '0';
    L45:
        r3 = (char) (r8 + r9);
        r4 = r4 + 1;
    L47:
        if (r7 < 'a') goto L52;
        if (r7 > 'f') goto L52;
        int r10 = r7 - 'a';
    L50:
        r9 = r10 + 10;
    L52:
        if (r7 < 'A') goto L58;
        if (r7 > 'F') goto L58;
        r10 = r7 - 'A';
    L58:
        throw new NumberFormatException("\\u" + new String(this.f6864h, this.f6865i, 4));
    L59:
        this.f6865i += 4;
        return r3;
    L34:
        if (C(4) == true) goto L38;
        v0("Unterminated escape sequence");
        throw null;
    L5:
        if (C(1) == true) goto L9;
        v0("Unterminated escape sequence");
        throw null;
    }

    private void q0(char r7) {
        char[] r0 = this.f6864h;
    L3:
        int r1 = this.f6865i;
        int r2 = this.f6866j;
    L5:
        if (r1 >= r2) goto L17;
        int r4 = r1 + 1;
        char r3 = r0[r1];
        if (r3 == r7) goto L8;
        if (r3 == '\\') goto L12;
        if (r3 != '\n') goto L16;
        this.f6867k++;
        this.f6868l = r4;
    L16:
        r1 = r4;
        goto L5
    L12:
        this.f6865i = r4;
        o0();
        goto L3
    L8:
        this.f6865i = r4;
        return;
    L17:
        this.f6865i = r1;
        if (C(1) == true) goto L3;
        v0("Unterminated string");
        throw null;
    }

    private boolean r0(String r7) {
        int r0 = r7.length();
    L3:
        int r3 = 0;
        if ((this.f6865i + r0) > this.f6866j) goto L6;
    L9:
        char[] r1 = this.f6864h;
        int r2 = this.f6865i;
        if (r1[r2] != '\n') goto L12;
        this.f6867k++;
        this.f6868l = r2 + 1;
    L15:
        this.f6865i++;
    L12:
        if (r3 >= r0) goto L17;
        if (this.f6864h[this.f6865i + r3] != r7.charAt(r3)) goto L15;
        r3 = r3 + 1;
        goto L12
    L17:
        return true;
    L6:
        if (C(r0) == true) goto L9;
        return false;
    }

    private void s0() {
    L3:
        if (this.f6865i >= this.f6866j) goto L5;
    L6:
        char[] r0 = this.f6864h;
        int r1 = this.f6865i;
        int r3 = r1 + 1;
        this.f6865i = r3;
        char r2 = r0[r1];
        if (r2 == '\n') goto L8;
        if (r2 != '\r') goto L3;
        return;
    L8:
        this.f6867k++;
        this.f6868l = r3;
        return;
    L5:
        if (C(1) == true) goto L6;
    }

    private void t0() {
    L2:
        int r0 = 0;
    L3:
        int r1 = this.f6865i;
        if ((r1 + r0) >= this.f6866j) goto L36;
        char r2 = this.f6864h[r1 + r0];
        if (r2 == '\t') goto L34;
        if (r2 == '\n') goto L34;
        if (r2 == '\f') goto L34;
        if (r2 == '\r') goto L34;
        if (r2 == ' ') goto L34;
        if (r2 == '#') goto L33;
        if (r2 == ',') goto L34;
        if (r2 == '/') goto L33;
        if (r2 == '=') goto L33;
        if (r2 == '{') goto L34;
        if (r2 == '}') goto L34;
        if (r2 == ':') goto L34;
        if (r2 == ';') goto L33;
        switch(r2) {
            case 91: goto L34;
            case 92: goto L33;
            case 93: goto L34;
            default: goto L32;
        };
    L32:
        r0 = r0 + 1;
    L33:
        g();
    L34:
        this.f6865i += r0;
        return;
    L36:
        this.f6865i = r1 + r0;
        if (C(1) == true) goto L2;
    }

    private IOException v0(String r3) {
        throw new d(r3 + O());
    }

    public void A() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 2) goto L10;
        int r1 = this.r - 1;
        this.r = r1;
        this.s[r1] = null;
        int[] r2 = this.t;
        int r3 = r1 - 1;
        r2[r3] = r2[r3] + 1;
        this.m = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_OBJECT but was " + k0() + O());
    }

    public String F() {
        return E(true);
    }

    public boolean L() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 2) goto L8;
    L12:
        return false;
    L8:
        if (r0 == 4) goto L12;
        if (r0 == 17) goto L12;
        return true;
    }

    public final boolean M() {
        return this.f6863g;
    }

    String O() {
        return " at line " + (this.f6867k + 1) + " column " + ((this.f6865i - this.f6868l) + 1) + " path " + getPath();
    }

    public boolean Q() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 5) goto L10;
        this.m = 0;
        int[] r1 = this.t;
        int r4 = this.r - 1;
        r1[r4] = r1[r4] + 1;
        return true;
    L10:
        if (r0 != 6) goto L14;
        this.m = 0;
        int[] r2 = this.t;
        int r5 = this.r - 1;
        r2[r5] = r2[r5] + 1;
        return false;
    L14:
        throw new IllegalStateException("Expected a boolean but was " + k0() + O());
    }

    public double S() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 15) goto L10;
        this.m = 0;
        int[] r1 = this.t;
        int r2 = this.r - 1;
        r1[r2] = r1[r2] + 1;
        return this.n;
    L10:
        if (r0 != 16) goto L13;
        this.p = new String(this.f6864h, this.f6865i, this.o);
        this.f6865i += this.o;
    L29:
        this.m = 11;
        double r3 = Double.parseDouble(this.p);
        if (this.f6863g == false) goto L32;
    L38:
        this.p = null;
        this.m = 0;
        int[] r4 = this.t;
        int r6 = this.r - 1;
        r4[r6] = r4[r6] + 1;
        return r3;
    L32:
        if (Double.isNaN(r3) == true) goto L37;
        if (Double.isInfinite(r3) == false) goto L38;
    L37:
        throw new d("JSON forbids NaN and infinities: " + r3 + O());
    L13:
        if (r0 != 8) goto L15;
    L24:
        if (r0 != 8) goto L26;
        char r5 = '\'';
    L27:
        String r7 = h0(r5);
    L28:
        this.p = r7;
        goto L29
    L26:
        r5 = '\"';
        goto L27
    L15:
        if (r0 == 9) goto L24;
        if (r0 != 10) goto L20;
        r7 = j0();
        goto L28
    L20:
        if (r0 == 11) goto L29;
        throw new IllegalStateException("Expected a double but was " + k0() + O());
    }

    public int V() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 15) goto L14;
        long r1 = this.n;
        int r4 = (int) r1;
        if (r1 != r4) goto L12;
        this.m = 0;
        int[] r2 = this.t;
        int r7 = this.r - 1;
        r2[r7] = r2[r7] + 1;
        return r4;
    L12:
        throw new NumberFormatException("Expected an int but was " + this.n + O());
    L14:
        if (r0 != 16) goto L17;
        this.p = new String(this.f6864h, this.f6865i, this.o);
        this.f6865i += this.o;
    L33:
        this.m = 11;
        double r3 = Double.parseDouble(this.p);
        int r5 = (int) r3;
        if (r5 != r3) goto L38;
        this.p = null;
        this.m = 0;
        int[] r6 = this.t;
        int r8 = this.r - 1;
        r6[r8] = r6[r8] + 1;
        return r5;
    L38:
        throw new NumberFormatException("Expected an int but was " + this.p + O());
    L17:
        if (r0 != 8) goto L19;
    L24:
        if (r0 != 10) goto L27;
        String r9 = j0();
    L26:
        this.p = r9;
        int r10 = Integer.parseInt(this.p);     // Catch: NumberFormatException -> L39
        this.m = 0;     // Catch: NumberFormatException -> L39
        int[] r11 = this.t;     // Catch: NumberFormatException -> L39
        int r12 = this.r - 1;     // Catch: NumberFormatException -> L39
        r11[r12] = r11[r12] + 1;     // Catch: NumberFormatException -> L39
        return r10;
    L27:
        if (r0 != 8) goto L29;
        char r13 = '\'';
    L30:
        r9 = h0(r13);
        goto L26
    L29:
        r13 = '\"';
        goto L30
    L19:
        if (r0 == 9) goto L24;
        if (r0 == 10) goto L24;
        throw new IllegalStateException("Expected an int but was " + k0() + O());
    }

    public long X() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 15) goto L10;
        this.m = 0;
        int[] r1 = this.t;
        int r2 = this.r - 1;
        r1[r2] = r1[r2] + 1;
        return this.n;
    L10:
        if (r0 != 16) goto L13;
        this.p = new String(this.f6864h, this.f6865i, this.o);
        this.f6865i += this.o;
    L29:
        this.m = 11;
        double r3 = Double.parseDouble(this.p);
        long r4 = (long) r3;
        if (r4 != r3) goto L34;
        this.p = null;
        this.m = 0;
        int[] r5 = this.t;
        int r8 = this.r - 1;
        r5[r8] = r5[r8] + 1;
        return r4;
    L34:
        throw new NumberFormatException("Expected a long but was " + this.p + O());
    L13:
        if (r0 != 8) goto L15;
    L20:
        if (r0 != 10) goto L23;
        String r6 = j0();
    L22:
        this.p = r6;
        long r7 = Long.parseLong(this.p);     // Catch: NumberFormatException -> L35
        this.m = 0;     // Catch: NumberFormatException -> L35
        int[] r9 = this.t;     // Catch: NumberFormatException -> L35
        int r10 = this.r - 1;     // Catch: NumberFormatException -> L35
        r9[r10] = r9[r10] + 1;     // Catch: NumberFormatException -> L35
        return r7;
    L23:
        if (r0 != 8) goto L25;
        char r11 = '\'';
    L26:
        r6 = h0(r11);
        goto L22
    L25:
        r11 = '\"';
        goto L26
    L15:
        if (r0 == 9) goto L20;
        if (r0 == 10) goto L20;
        throw new IllegalStateException("Expected a long but was " + k0() + O());
    }

    public String Y() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 14) goto L9;
        String r1 = j0();
    L15:
        this.m = 0;
        this.s[this.r - 1] = r1;
        return r1;
    L9:
        if (r0 != 12) goto L13;
        char r2 = '\'';
    L11:
        r1 = h0(r2);
        goto L15
    L13:
        if (r0 != 13) goto L18;
        r2 = '\"';
        goto L11
    L18:
        throw new IllegalStateException("Expected a name but was " + k0() + O());
    }

    public void a() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 3) goto L10;
        n0(1);
        this.t[this.r - 1] = 0;
        this.m = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + k0() + O());
    }

    public void b() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 1) goto L10;
        n0(3);
        this.m = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + k0() + O());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.m = 0;
        this.q[0] = 8;
        this.r = 1;
        this.f6862f.close();
    }

    public void g0() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 7) goto L10;
        this.m = 0;
        int[] r1 = this.t;
        int r3 = this.r - 1;
        r1[r3] = r1[r3] + 1;
        return;
    L10:
        throw new IllegalStateException("Expected null but was " + k0() + O());
    }

    public String getPath() {
        return E(false);
    }

    public String i0() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 10) goto L9;
        String r1 = j0();
    L24:
        this.m = 0;
        int[] r2 = this.t;
        int r4 = this.r - 1;
        r2[r4] = r2[r4] + 1;
        return r1;
    L9:
        if (r0 != 8) goto L13;
        char r3 = '\'';
    L11:
        r1 = h0(r3);
        goto L24
    L13:
        if (r0 != 9) goto L16;
        r3 = '\"';
        goto L11
    L16:
        if (r0 != 11) goto L19;
        r1 = this.p;
        this.p = null;
        goto L24
    L19:
        if (r0 != 15) goto L22;
        r1 = Long.toString(this.n);
        goto L24
    L22:
        if (r0 != 16) goto L27;
        r1 = new String(this.f6864h, this.f6865i, this.o);
        this.f6865i += this.o;
        goto L24
    L27:
        throw new IllegalStateException("Expected a string but was " + k0() + O());
    }

    public b k0() {
        int r0 = this.m;
        if (r0 != 0) goto L5;
        r0 = s();
    L5:
        switch(r0) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L11;
            case 17: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return b.o;
    L11:
        return b.f6875l;
    L13:
        return b.f6873j;
    L15:
        return b.f6874k;
    L17:
        return b.n;
    L19:
        return b.m;
    L21:
        return b.f6870g;
    L23:
        return b.f6869f;
    L25:
        return b.f6872i;
    L27:
        return b.f6871h;
    }

    public final void p0(boolean r1) {
        this.f6863g = r1;
    }

    int s() {
        int[] r1 = this.q;
        int r2 = this.r;
        int r3 = r1[r2 - 1];
        if (r3 != 1) goto L5;
        r1[r2 - 1] = 2;
    L47:
        int r4 = d0(true);
        if (r4 == 34) goto L85;
        if (r4 == 39) goto L83;
        if (r4 == 44) goto L75;
        if (r4 == 59) goto L75;
        if (r4 == 91) goto L73;
        if (r4 != 93) goto L56;
        if (r3 != 1) goto L75;
        this.m = 4;
        return 4;
    L56:
        if (r4 == 123) goto L68;
        this.f6865i--;
        int r5 = l0();
        if (r5 == 0) goto L60;
        return r5;
    L60:
        int r6 = m0();
        if (r6 == 0) goto L64;
        return r6;
    L64:
        if (N(this.f6864h[this.f6865i]) == false) goto L66;
        g();
        int r7 = 10;
    L43:
        this.m = r7;
        return r7;
    L66:
        v0("Expected value");
        throw null;
    L68:
        this.m = 1;
        return 1;
    L73:
        this.m = 3;
        return 3;
    L75:
        if (r3 != 1) goto L77;
    L81:
        g();
        this.f6865i--;
        this.m = 7;
        return 7;
    L77:
        if (r3 == 2) goto L81;
        v0("Unexpected value");
        throw null;
    L83:
        g();
        this.m = 8;
        return 8;
    L85:
        r7 = 9;
        goto L43
    L5:
        if (r3 != 2) goto L16;
        int r8 = d0(true);
        if (r8 == 44) goto L47;
        if (r8 == 59) goto L14;
        if (r8 != 93) goto L12;
        this.m = 4;
        return 4;
    L12:
        v0("Unterminated array");
        throw null;
    L14:
        g();
        goto L47
    L16:
        if (r3 == 3) goto L88;
        if (r3 == 5) goto L88;
        if (r3 != 4) goto L34;
        r1[r2 - 1] = 5;
        int r9 = d0(true);
        if (r9 == 58) goto L47;
        if (r9 != 61) goto L31;
        g();
        if (this.f6865i >= this.f6866j) goto L27;
    L28:
        char[] r10 = this.f6864h;
        int r11 = this.f6865i;
        if (r10[r11] != '>') goto L47;
        this.f6865i = r11 + 1;
        goto L47
    L27:
        if (C(1) == false) goto L47;
    L31:
        v0("Expected ':'");
        throw null;
    L34:
        if (r3 == 6) goto L36;
        if (r3 == 7) goto L41;
        if (r3 != 8) goto L47;
        throw new IllegalStateException("JsonReader is closed");
    L41:
        if (d0(false) != (-1)) goto L45;
        r7 = 17;
        goto L43
    L45:
        g();
        this.f6865i--;
        goto L47
    L36:
        if (this.f6863g == false) goto L38;
        l();
    L38:
        this.q[this.r - 1] = 7;
    L88:
        r1[r2 - 1] = 4;
        if (r3 != 5) goto L98;
        int r12 = d0(true);
        if (r12 == 44) goto L98;
        if (r12 == 59) goto L97;
        if (r12 != 125) goto L95;
    L94:
        r7 = 2;
        goto L43
    L95:
        v0("Unterminated object");
        throw null;
    L97:
        g();
    L98:
        int r13 = d0(true);
        if (r13 == 34) goto L113;
        if (r13 != 39) goto L102;
        g();
        r7 = 12;
        goto L43
    L102:
        if (r13 == 125) goto L108;
        g();
        this.f6865i--;
        if (N((char) r13) == false) goto L106;
        r7 = 14;
        goto L43
    L106:
        v0("Expected name");
        throw null;
    L108:
        if (r3 != 5) goto L94;
        v0("Expected name");
        throw null;
    L113:
        r7 = 13;
        goto L43
    }

    public String toString() {
        return getClass().getSimpleName() + O();
    }

    public void u0() {
        int r1 = 0;
    L3:
        int r2 = this.m;
        if (r2 != 0) goto L7;
        r2 = s();
    L7:
        switch(r2) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L29;
            case 6: goto L29;
            case 7: goto L29;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L29;
            case 12: goto L17;
            case 13: goto L14;
            case 14: goto L11;
            case 15: goto L29;
            case 16: goto L10;
            case 17: goto L9;
            default: goto L29;
        };
    L10:
        this.f6865i += this.o;
        goto L29
    L11:
        t0();
        if (r1 != 0) goto L29;
        this.s[this.r - 1] = "<skipped>";
        goto L29
    L14:
        q0('\"');
        if (r1 != 0) goto L29;
        this.s[this.r - 1] = "<skipped>";
        goto L29
    L17:
        q0('\'');
        if (r1 != 0) goto L29;
        this.s[this.r - 1] = "<skipped>";
        goto L29
    L20:
        t0();
        goto L29
    L21:
        q0('\"');
        goto L29
    L22:
        q0('\'');
    L23:
        this.r--;
        r1 = r1 - 1;
        goto L29
    L24:
        n0(1);
    L28:
        r1 = r1 + 1;
        goto L29
    L25:
        if (r1 != 0) goto L23;
        this.s[this.r - 1] = null;
        goto L23
    L27:
        n0(3);
    L29:
        this.m = 0;
        if (r1 > 0) goto L3;
        int[] r0 = this.t;
        int r7 = this.r - 1;
        r0[r7] = r0[r7] + 1;
        return;
    }

    public void x() {
        int r0 = this.m;
        if (r0 != 0) goto L6;
        r0 = s();
    L6:
        if (r0 != 4) goto L10;
        int r1 = this.r - 1;
        this.r = r1;
        int[] r2 = this.t;
        int r3 = r1 - 1;
        r2[r3] = r2[r3] + 1;
        this.m = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_ARRAY but was " + k0() + O());
    }
}
