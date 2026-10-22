package d.a.a.i;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final boolean[] A = null;
    public static final boolean[] B = null;
    private static boolean v;
    private static final ThreadLocal<char[]> w = null;
    protected static final int[] x = null;
    public static final char[] y = null;
    static final int[] z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f12404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f12405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected char f12407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f12408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f12409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected char[] f12410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f12411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f12412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f12413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f12414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected boolean f12415l;
    public TimeZone m;
    public Locale n;
    public Calendar o;
    public int p;
    protected final String q;
    protected final int r;
    protected String s;
    public boolean t;
    protected long u;

    static {
        int r1 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);     // Catch: Exception -> L5
    L6:
        char r3 = 0;
        if (r1 < 23) goto L9;
        boolean r2 = true;
    L10:
        v = r2;
        w = new ThreadLocal();
        x = new int[103];
        int r4 = 48;
    L12:
        if (r4 > 57) goto L14;
        x[r4] = r4 - 48;
        r4 = r4 + 1;
        goto L12
    L14:
        int r6 = 97;
    L16:
        if (r6 > 102) goto L18;
        x[r6] = (r6 - 97) + 10;
        r6 = r6 + 1;
        goto L16
    L18:
        int r7 = 65;
    L20:
        if (r7 > 70) goto L22;
        x[r7] = (r7 - 65) + 10;
        r7 = r7 + 1;
        goto L20
    L22:
        char[] r8 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        y = r8;
        int[] r9 = new int[256];
        z = r9;
        Arrays.fill(r9, -1);
        int r0 = r8.length;
        int r10 = 0;
    L23:
        if (r10 >= r0) goto L25;
        z[y[r10]] = r10;
        r10 = r10 + 1;
        goto L23
    L25:
        z[61] = 0;
        A = new boolean[256];
        char r5 = 0;
    L26:
        boolean[] r11 = A;
        if (r5 >= r11.length) goto L37;
        if (r5 < 'A') goto L31;
        if (r5 > 'Z') goto L31;
        r11[r5] = true;
    L36:
        r5 = (char) (r5 + 1);
    L31:
        if (r5 < 'a') goto L34;
        if (r5 > 'z') goto L34;
        r11[r5] = true;
    L34:
        if (r5 != '_') goto L36;
        r11[r5] = true;
        goto L36
    L37:
        B = new boolean[256];
    L38:
        boolean[] r12 = B;
        if (r3 >= r12.length) goto L52;
        if (r3 < 'A') goto L43;
        if (r3 > 'Z') goto L43;
        r12[r3] = true;
    L51:
        r3 = (char) (r3 + 1);
    L43:
        if (r3 < 'a') goto L46;
        if (r3 > 'z') goto L46;
        r12[r3] = true;
    L46:
        if (r3 != '_') goto L48;
        r12[r3] = true;
        goto L51
    L48:
        if (r3 < '0') goto L51;
        if (r3 > '9') goto L51;
        r12[r3] = true;
        goto L51
    L52:
        return;
    L9:
        r2 = false;
    L5:
        r1 = -1;
        goto L6
    }

    public e(String r2) {
        this(r2, d.a.a.a.f12371h);
    }

    public e(String r6, int r7) {
        this.f12406c = d.a.a.a.f12371h;
        boolean r0 = false;
        this.f12412i = false;
        this.f12413j = false;
        this.m = d.a.a.a.f12369f;
        this.n = d.a.a.a.f12370g;
        String r1 = null;
        this.o = null;
        this.p = 0;
        char[] r2 = w.get();
        this.f12410g = r2;
        if (r2 != null) goto L5;
        this.f12410g = new char[512];
    L5:
        this.f12406c = r7;
        this.q = r6;
        int r3 = r6.length();
        this.r = r3;
        this.f12408e = -1;
        int r4 = (-1) + 1;
        this.f12408e = r4;
        if (r4 < r3) goto L8;
        char r8 = 26;
    L9:
        this.f12407d = r8;
        if (r8 != 65279) goto L13;
        q();
    L13:
        if ((d.s.f12403f & r7) == 0) goto L15;
        r1 = "";
    L15:
        this.s = r1;
        if ((d.r.f12403f & r7) == 0) goto L18;
        r0 = true;
    L18:
        this.t = r0;
        return;
    L8:
        r8 = r6.charAt(r4);
        goto L9
    }

    private void L() {
        this.f12414k = this.f12408e - 1;
        this.f12415l = false;
    L3:
        this.f12411h++;
        q();
        if (Character.isLetterOrDigit(this.f12407d) == true) goto L3;
        String r0 = X();
        if (r0.equals("null") == false) goto L11;
        int r1 = 8;
    L9:
        this.f12404a = r1;
        return;
    L11:
        if (r0.equals("true") == false) goto L14;
        r1 = 6;
        goto L9
    L14:
        if (r0.equals("false") == false) goto L17;
        r1 = 7;
        goto L9
    L17:
        if (r0.equals("new") == false) goto L20;
        r1 = 9;
        goto L9
    L20:
        if (r0.equals("undefined") == false) goto L23;
        r1 = 23;
        goto L9
    L23:
        if (r0.equals("Set") == false) goto L26;
        r1 = 21;
        goto L9
    L26:
        if (r0.equals("TreeSet") == false) goto L28;
        r1 = 22;
        goto L9
    L28:
        r1 = 18;
        goto L9
    }

    private void U(char r3, char r4, char r5, char r6, char r7, char r8, char r9, char r10) {
        Calendar r0 = Calendar.getInstance(this.m, this.n);
        this.o = r0;
        r0.set(1, ((((r3 - '0') * 1000) + ((r4 - '0') * 100)) + ((r5 - '0') * 10)) + (r6 - '0'));
        this.o.set(2, (((r7 - '0') * 10) + (r8 - '0')) - 1);
        this.o.set(5, ((r9 - '0') * 10) + (r10 - '0'));
    }

    private final String Y(int r5, int r6) {
        char[] r0 = this.f12410g;
        if (r6 >= r0.length) goto L6;
        this.q.getChars(r5, r5 + r6, r0, 0);
        return new String(this.f12410g, 0, r6);
    L6:
        char[] r1 = new char[r6];
        this.q.getChars(r5, r6 + r5, r1, 0);
        return new String(r1);
    }

    static boolean c(char r4, char r5, char r6, char r7, char r8, char r9, int r10, int r11) {
        if (r4 == '1') goto L7;
        if (r4 == '2') goto L7;
        return false;
    L7:
        if (r5 >= '0') goto L9;
    L43:
        return false;
    L9:
        if (r5 > '9') goto L43;
        if (r6 < '0') goto L43;
        if (r6 > '9') goto L43;
        if (r7 < '0') goto L43;
        if (r7 > '9') goto L43;
        if (r8 != '0') goto L21;
        if (r9 < '1') goto L20;
        if (r9 > '9') goto L20;
    L26:
        if (r10 != 48) goto L30;
        if (r11 < 49) goto L29;
        if (r11 > 57) goto L29;
        return true;
    L29:
        return false;
    L30:
        if (r10 == 49) goto L38;
        if (r10 == 50) goto L38;
        if (r10 != 51) goto L37;
        if (r11 == 48) goto L44;
        if (r11 != 49) goto L37;
        return true;
    L44:
        return true;
    L37:
        return false;
    L38:
        if (r11 < 48) goto L43;
        if (r11 > 57) goto L43;
        return true;
    L20:
        return false;
    L21:
        if (r8 != '1') goto L43;
        if (r9 == '0') goto L26;
        if (r9 == '1') goto L26;
        if (r9 == '2') goto L26;
        return false;
    }

    static boolean d(char r4, char r5, char r6, char r7, char r8, char r9) {
        if (r4 != '0') goto L8;
        if (r5 < '0') goto L6;
        if (r5 > '9') goto L6;
    L19:
        if (r6 < '0') goto L24;
        if (r6 > '5') goto L24;
        if (r7 < '0') goto L23;
        if (r7 > '9') goto L23;
    L27:
        if (r8 < '0') goto L32;
        if (r8 > '5') goto L32;
        if (r9 < '0') goto L31;
        if (r9 > '9') goto L31;
        return true;
    L31:
        return false;
    L32:
        if (r8 != '6') goto L37;
        if (r9 == '0') goto L38;
        return false;
    L38:
        return true;
    L37:
        return false;
    L23:
        return false;
    L24:
        if (r6 != '6') goto L37;
        if (r7 == '0') goto L27;
        return false;
    L6:
        return false;
    L8:
        if (r4 != '1') goto L13;
        if (r5 < '0') goto L11;
        if (r5 <= '9') goto L19;
    L11:
        return false;
    L13:
        if (r4 != '2') goto L37;
        if (r5 < '0') goto L37;
        if (r5 <= '4') goto L19;
        goto L37
    }

    public static final byte[] h(String r12, int r13, int r14) {
        int r0 = 0;
        if (r14 == 0) goto L5;
        int r1 = (r13 + r14) - 1;
    L7:
        if (r13 >= r1) goto L11;
        if (z[r12.charAt(r13)] >= 0) goto L11;
        r13 = r13 + 1;
    L11:
        if (r1 <= 0) goto L16;
        if (z[r12.charAt(r1)] >= 0) goto L16;
        r1 = r1 - 1;
    L16:
        if (r12.charAt(r1) == '=') goto L18;
        int r3 = 0;
    L22:
        int r4 = (r1 - r13) + 1;
        if (r14 > 76) goto L25;
        int r15 = 0;
    L30:
        int r5 = (((r4 - r15) * 6) >> 3) - r3;
        byte[] r6 = new byte[r5];
        int r7 = (r5 / 3) * 3;
        int r8 = 0;
        int r9 = 0;
    L31:
        if (r8 >= r7) goto L38;
        int[] r10 = z;
        int r11 = r13 + 1;
        int r16 = r11 + 1;
        int r17 = (r10[r12.charAt(r13)] << 18) | (r10[r12.charAt(r11)] << 12);
        int r18 = r16 + 1;
        int r19 = r17 | (r10[r12.charAt(r16)] << 6);
        int r110 = r18 + 1;
        int r111 = r19 | r10[r12.charAt(r18)];
        int r20 = r8 + 1;
        r6[r8] = (byte) (r111 >> 16);
        int r21 = r20 + 1;
        r6[r20] = (byte) (r111 >> 8);
        int r22 = r21 + 1;
        r6[r21] = (byte) r111;
        if (r15 <= 0) goto L37;
        r9 = r9 + 1;
        if (r9 != 19) goto L37;
        r110 = r110 + 2;
        r9 = 0;
    L37:
        r13 = r110;
        r8 = r22;
        goto L31
    L38:
        if (r8 >= r5) goto L46;
        int r112 = 0;
    L41:
        if (r13 > (r1 - r3)) goto L43;
        r0 = r0 | (z[r12.charAt(r13)] << (18 - (r112 * 6)));
        r112 = r112 + 1;
        r13 = r13 + 1;
        goto L41
    L43:
        int r113 = 16;
    L44:
        if (r8 >= r5) goto L46;
        r6[r8] = (byte) (r0 >> r113);
        r113 = r113 - 8;
        r8 = r8 + 1;
    L46:
        return r6;
    L25:
        if (r12.charAt(76) != '\r') goto L27;
        int r114 = r4 / 78;
    L28:
        r15 = r114 << 1;
        goto L30
    L27:
        r114 = 0;
        goto L28
    L18:
        if (r12.charAt(r1 - 1) != '=') goto L20;
        r3 = 2;
        goto L22
    L20:
        r3 = 1;
        goto L22
    L5:
        return new byte[0];
    }

    private int p(long r18) {
        char r1 = this.f12407d;
        int r2 = this.f12408e + 1;
        int r4 = 1;
    L4:
        if (r1 == '\"') goto L8;
        if (r1 == '\'') goto L8;
        if (r1 > ' ') goto L62;
        if (r1 == ' ') goto L57;
        if (r1 == '\n') goto L57;
        if (r1 == '\r') goto L57;
        if (r1 == '\t') goto L57;
        if (r1 == '\f') goto L57;
        if (r1 != '\b') goto L62;
    L57:
        int r5 = r4 + 1;
        int r3 = this.f12408e + r4;
        if (r3 < this.r) goto L60;
        r1 = 26;
    L61:
        r4 = r5;
        goto L4
    L60:
        r1 = this.q.charAt(r3);
    L62:
        this.u = 0;
    L18:
        this.p = -2;
        return 0;
    L8:
        long r6 = -2128831035;
        int r15 = r2;
    L10:
        if (r15 >= this.r) goto L16;
        char r7 = this.q.charAt(r15);
        if (r7 == r1) goto L13;
        r6 = (r6 ^ ((long) r7)) * 16777619;
        r15 = r15 + 1;
        goto L10
    L13:
        r4 = r4 + (r15 - r2);
    L16:
        if (r6 == r18) goto L20;
        this.u = r6;
        goto L18
    L20:
        int r8 = r4 + 1;
        int r9 = this.f12408e + r8;
        if (r9 < this.r) goto L23;
        char r10 = 26;
    L25:
        if (r10 == ':') goto L27;
        if (r10 > ' ') goto L45;
        if (r10 == ' ') goto L39;
        if (r10 == '\n') goto L39;
        if (r10 == '\r') goto L39;
        if (r10 == '\t') goto L39;
        if (r10 == '\f') goto L39;
        if (r10 != '\b') goto L45;
    L39:
        int r11 = r8 + 1;
        int r12 = this.f12408e + r8;
        if (r12 < this.r) goto L42;
        r10 = 26;
    L43:
        r8 = r11;
        goto L25
    L42:
        r10 = this.q.charAt(r12);
    L45:
        throw new d.a.a.d("match feild error expect ':'");
    L27:
        return r8 + 1;
    L23:
        r10 = this.q.charAt(r9);
        goto L25
    }

    private static String w(char[] r12, int r13) {
        char[] r0 = new char[r13];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r13) goto L52;
        char r4 = r12[r2];
        if (r4 == '\\') goto L7;
        r0[r3] = r4;
        r3 = r3 + 1;
    L50:
        r2 = r2 + 1;
        goto L3
    L7:
        r2 = r2 + 1;
        char r5 = r12[r2];
        if (r5 != '\"') goto L10;
        int r6 = r3 + 1;
        r0[r3] = '\"';
    L49:
        r3 = r6;
        goto L50
    L10:
        if (r5 != '\'') goto L12;
        r6 = r3 + 1;
        r0[r3] = '\'';
        goto L49
    L12:
        if (r5 == 'F') goto L46;
        if (r5 != '\\') goto L15;
        r6 = r3 + 1;
        r0[r3] = '\\';
        goto L49
    L15:
        if (r5 != 'b') goto L17;
        r6 = r3 + 1;
        r0[r3] = '\b';
        goto L49
    L17:
        if (r5 == 'f') goto L46;
        if (r5 != 'n') goto L21;
        r6 = r3 + 1;
        r0[r3] = '\n';
        goto L49
    L21:
        if (r5 != 'r') goto L23;
        r6 = r3 + 1;
        r0[r3] = '\r';
        goto L49
    L23:
        if (r5 != 'x') goto L25;
        r6 = r3 + 1;
        int[] r7 = x;
        int r8 = r2 + 1;
        int r9 = r7[r12[r8]] * 16;
        r2 = r8 + 1;
        r0[r3] = (char) (r9 + r7[r12[r2]]);
        goto L49
    L25:
        switch(r5) {
            case 47: goto L40;
            case 48: goto L39;
            case 49: goto L38;
            case 50: goto L37;
            case 51: goto L36;
            case 52: goto L35;
            case 53: goto L34;
            case 54: goto L33;
            case 55: goto L32;
            default: goto L26;
        };
    L26:
        switch(r5) {
            case 116: goto L31;
            case 117: goto L30;
            case 118: goto L29;
            default: goto L28;
        };
    L29:
        r6 = r3 + 1;
        r0[r3] = 11;
        goto L49
    L30:
        r6 = r3 + 1;
        int r10 = r2 + 1;
        int r11 = r10 + 1;
        int r14 = r11 + 1;
        r2 = r14 + 1;
        r0[r3] = (char) Integer.parseInt(new String(new char[]{r12[r10], r12[r11], r12[r14], r12[r2]}), 16);
        goto L49
    L31:
        r6 = r3 + 1;
        r0[r3] = '\t';
        goto L49
    L28:
        throw new d.a.a.d("unclosed.str.lit");
    L32:
        r6 = r3 + 1;
        r0[r3] = 7;
        goto L49
    L33:
        r6 = r3 + 1;
        r0[r3] = 6;
        goto L49
    L34:
        r6 = r3 + 1;
        r0[r3] = 5;
        goto L49
    L35:
        r6 = r3 + 1;
        r0[r3] = 4;
        goto L49
    L36:
        r6 = r3 + 1;
        r0[r3] = 3;
        goto L49
    L37:
        r6 = r3 + 1;
        r0[r3] = 2;
        goto L49
    L38:
        r6 = r3 + 1;
        r0[r3] = 1;
        goto L49
    L39:
        r6 = r3 + 1;
        r0[r3] = 0;
        goto L49
    L40:
        r6 = r3 + 1;
        r0[r3] = '/';
    L46:
        r6 = r3 + 1;
        r0[r3] = '\f';
        goto L49
    L52:
        return new String(r0, 0, r3);
    }

    public final double[] A(long r20) {
        boolean r1 = false;
        this.p = 0;
        int r2 = p(r20);
        double[] r3 = null;
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r5 = r2 + 1;
        int r4 = this.f12408e + r2;
        if (r4 < this.r) goto L8;
        char r6 = 26;
    L10:
        if (r6 == '[') goto L13;
        this.p = -1;
        return null;
    L13:
        int r7 = r5 + 1;
        int r8 = this.f12408e + r5;
        if (r8 < this.r) goto L16;
        char r9 = 26;
    L17:
        double[] r10 = new double[16];
        int r11 = 0;
    L18:
        int r12 = this.f12408e;
        int r13 = (r12 + r7) - 1;
        if (r9 != '-') goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L29;
        int r15 = r7 + 1;
        int r16 = r12 + r7;
        if (r16 < this.r) goto L26;
        char r17 = 26;
    L27:
        char r18 = r17;
        r7 = r15;
        r9 = r18;
        goto L29
    L26:
        r17 = this.q.charAt(r16);
    L29:
        if (r9 < '0') goto L142;
        if (r9 > '9') goto L142;
        int r19 = r9 - '0';
    L33:
        int r110 = r7 + 1;
        int r21 = this.f12408e + r7;
        if (r21 < this.r) goto L36;
        char r22 = 26;
    L37:
        if (r22 < '0') goto L41;
        if (r22 > '9') goto L41;
        r19 = (r19 * 10) + (r22 - '0');
        r7 = r110;
    L41:
        if (r22 != '.') goto L43;
        boolean r23 = true;
    L45:
        if (r23 == false) goto L62;
        int r24 = r110 + 1;
        int r25 = this.f12408e + r110;
        if (r25 < this.r) goto L49;
        char r26 = 26;
    L50:
        if (r26 < '0') goto L60;
        if (r26 > '9') goto L60;
        r19 = (r19 * 10) + (r26 - '0');
        int r27 = 10;
    L53:
        r110 = r24 + 1;
        int r28 = this.f12408e + r24;
        if (r28 < this.r) goto L56;
        r22 = 26;
    L57:
        if (r22 < '0') goto L64;
        if (r22 > '9') goto L64;
        r19 = (r19 * 10) + (r22 - '0');
        r27 = r27 * 10;
        r24 = r110;
    L64:
        if (r22 != 'e') goto L66;
    L69:
        boolean r29 = true;
    L70:
        if (r29 == false) goto L90;
        int r111 = r110 + 1;
        int r30 = this.f12408e + r110;
        if (r30 < this.r) goto L74;
        char r31 = 26;
    L76:
        if (r31 == '+') goto L80;
        if (r31 == '-') goto L80;
        r22 = r31;
        r110 = r111;
    L85:
        if (r22 < '0') goto L90;
        if (r22 > '9') goto L90;
        int r32 = r110 + 1;
        int r33 = this.f12408e + r110;
        if (r33 >= this.r) goto L144;
    L84:
        r110 = r32;
        r22 = this.q.charAt(r33);
    L144:
        r110 = r32;
        r22 = 26;
    L80:
        r32 = r111 + 1;
        r33 = this.f12408e + r111;
        if (r33 < this.r) goto L84;
    L74:
        r31 = this.q.charAt(r30);
    L90:
        int r34 = ((this.f12408e + r110) - r13) - 1;
        if (r29 == true) goto L96;
        if (r34 >= 10) goto L96;
        double r35 = ((double) r19) / ((double) r27);
        if (r14 == false) goto L98;
        r35 = -r35;
    L98:
        if (r11 < r10.length) goto L100;
        double[] r36 = new double[(r10.length * 3) / 2];
        System.arraycopy(r10, 0, r36, 0, r11);
        r10 = r36;
    L100:
        int r37 = r11 + 1;
        r10[r11] = r35;
        if (r22 != ',') goto L108;
        int r38 = r110 + 1;
        int r39 = this.f12408e + r110;
        if (r39 < this.r) goto L105;
        char r40 = 26;
    L106:
        r22 = r40;
        r110 = r38;
    L141:
        r3 = null;
        r9 = r22;
        r11 = r37;
        r1 = false;
        r7 = r110;
        goto L18
    L105:
        r40 = this.q.charAt(r39);
        goto L106
    L108:
        if (r22 != ']') goto L141;
        int r41 = r110 + 1;
        int r42 = this.f12408e + r110;
        if (r42 < this.r) goto L112;
        char r43 = 26;
    L114:
        if (r37 == r10.length) goto L116;
        double[] r44 = new double[r37];
        System.arraycopy(r10, 0, r44, 0, r37);
        r10 = r44;
    L116:
        if (r43 != ',') goto L120;
        this.f12408e += r41 - 1;
        q();
        this.p = 3;
        this.f12404a = 16;
        return r10;
    L120:
        if (r43 != '}') goto L139;
        int r45 = r41 + 1;
        int r46 = this.f12408e + r41;
        if (r46 < this.r) goto L124;
        char r47 = 26;
    L125:
        if (r47 != ',') goto L128;
        int r48 = 16;
    L127:
        this.f12404a = r48;
        this.f12408e += r45 - 1;
        q();
    L135:
        this.p = 4;
        return r10;
    L128:
        if (r47 != ']') goto L130;
        r48 = 15;
        goto L127
    L130:
        if (r47 != '}') goto L133;
        r48 = 13;
        goto L127
    L133:
        if (r47 != 26) goto L137;
        this.f12408e += r45 - 1;
        this.f12404a = 20;
        this.f12407d = 26;
        goto L135
    L137:
        this.p = -1;
        return null;
    L124:
        r47 = this.q.charAt(r46);
        goto L125
    L139:
        this.p = -1;
        return null;
    L112:
        r43 = this.q.charAt(r42);
    L96:
        r35 = Double.parseDouble(Y(r13, r34));
        goto L98
    L66:
        if (r22 == 'E') goto L69;
        r29 = false;
        goto L70
    L56:
        r22 = this.q.charAt(r28);
    L60:
        this.p = -1;
        return r3;
    L49:
        r26 = this.q.charAt(r25);
        goto L50
    L62:
        r27 = 1;
        goto L64
    L43:
        r23 = r1;
        goto L45
    L36:
        r22 = this.q.charAt(r21);
    L142:
        this.p = -1;
        return r3;
    L21:
        r14 = r1;
        goto L22
    L16:
        r9 = this.q.charAt(r8);
        goto L17
    L8:
        r6 = this.q.charAt(r4);
        goto L10
    }

    public final double[][] B(long r21) {
        int r1 = 0;
        this.p = 0;
        int r2 = p(r21);
        double[][] r3 = null;
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r5 = r2 + 1;
        int r4 = this.f12408e + r2;
        if (r4 < this.r) goto L8;
        char r6 = 26;
    L9:
        char r7 = '[';
        if (r6 == '[') goto L13;
        this.p = -1;
        return null;
    L13:
        int r8 = r5 + 1;
        int r9 = this.f12408e + r5;
        if (r9 < this.r) goto L16;
        char r10 = 26;
    L17:
        int r11 = 16;
        double[][] r12 = new double[16][];
        int r13 = 0;
    L18:
        if (r10 != r7) goto L18;
        int r14 = r8 + 1;
        int r15 = this.f12408e + r8;
        if (r15 < this.r) goto L22;
        char r16 = 26;
    L23:
        double[] r17 = new double[r11];
        int r18 = r1;
    L24:
        int r19 = this.f12408e;
        int r110 = (r19 + r14) - 1;
        if (r16 != '-') goto L27;
        int r111 = 1;
    L28:
        if (r111 == 0) goto L35;
        int r20 = r14 + 1;
        int r112 = r19 + r14;
        if (r112 < this.r) goto L32;
        char r113 = 26;
    L33:
        char r114 = r113;
        r14 = r20;
        r16 = r114;
        goto L35
    L32:
        r113 = this.q.charAt(r112);
    L35:
        if (r16 < '0') goto L167;
        if (r16 > '9') goto L167;
        int r22 = r16 - '0';
    L39:
        int r115 = r14 + 1;
        int r23 = this.f12408e + r14;
        if (r23 < this.r) goto L42;
        char r24 = 26;
    L43:
        if (r24 < '0') goto L47;
        if (r24 > '9') goto L47;
        r22 = (r22 * 10) + (r24 - '0');
        r14 = r115;
    L47:
        if (r24 != '.') goto L64;
        int r116 = r115 + 1;
        int r25 = this.f12408e + r115;
        if (r25 < this.r) goto L51;
        char r26 = 26;
    L52:
        if (r26 < '0') goto L62;
        if (r26 > '9') goto L62;
        r22 = (r22 * 10) + (r26 - '0');
        int r27 = 10;
    L55:
        r115 = r116 + 1;
        int r28 = this.f12408e + r116;
        if (r28 < this.r) goto L58;
        r24 = 26;
    L59:
        if (r24 < '0') goto L66;
        if (r24 > '9') goto L66;
        r22 = (r22 * 10) + (r24 - '0');
        r27 = r27 * 10;
        r116 = r115;
    L66:
        if (r24 != 'e') goto L68;
    L71:
        boolean r117 = true;
    L72:
        if (r117 == false) goto L94;
        int r118 = r115 + 1;
        int r29 = this.f12408e + r115;
        if (r29 < this.r) goto L76;
        char r30 = 26;
    L78:
        if (r30 == '+') goto L82;
        if (r30 == '-') goto L82;
        r24 = r30;
        r115 = r118;
    L88:
        if (r24 < '0') goto L94;
        if (r24 > '9') goto L94;
        int r31 = r115 + 1;
        int r32 = this.f12408e + r115;
        if (r32 < this.r) goto L93;
        r24 = 26;
        r115 = r31;
        goto L88
    L93:
        char r33 = this.q.charAt(r32);
    L86:
        r24 = r33;
        r115 = r31;
    L82:
        r31 = r118 + 1;
        int r34 = this.f12408e + r118;
        if (r34 < this.r) goto L85;
        r33 = 26;
        goto L86
    L85:
        r33 = this.q.charAt(r34);
        goto L86
    L76:
        r30 = this.q.charAt(r29);
    L94:
        int r35 = ((this.f12408e + r115) - r110) - 1;
        if (r117 == false) goto L97;
    L101:
        double r36 = Double.parseDouble(Y(r110, r35));
    L103:
        if (r18 < r17.length) goto L105;
        double[] r37 = new double[(r17.length * 3) / 2];
        System.arraycopy(r17, 0, r37, 0, r18);
        r17 = r37;
    L105:
        int r38 = r18 + 1;
        r17[r18] = r36;
        if (r24 != ',') goto L113;
        int r39 = r115 + 1;
        int r40 = this.f12408e + r115;
        if (r40 < this.r) goto L110;
        r16 = 26;
    L111:
        r115 = r39;
        char r41 = 16;
        int r119 = 0;
        double[][] r120 = null;
    L166:
        r3 = r120;
        r18 = r38;
        r1 = r119;
        r14 = r115;
        goto L24
    L110:
        r16 = this.q.charAt(r40);
        goto L111
    L113:
        if (r24 == ']') goto L114;
        r41 = 16;
        r119 = 0;
        r120 = null;
        r16 = r24;
        goto L166
    L114:
        int r42 = r115 + 1;
        int r43 = this.f12408e + r115;
        if (r43 < this.r) goto L117;
        char r44 = 26;
    L119:
        if (r38 == r17.length) goto L121;
        double[] r121 = new double[r38];
        int r122 = 0;
        System.arraycopy(r17, 0, r121, 0, r38);
        r17 = r121;
    L123:
        if (r13 < r12.length) goto L125;
        r12 = new double[(r12.length * 3) / 2][];
        System.arraycopy(r17, r122, r12, r122, r38);
    L125:
        int r45 = r13 + 1;
        r12[r13] = r17;
        if (r44 != ',') goto L132;
        int r46 = r42 + 1;
        int r47 = this.f12408e + r42;
        if (r47 < this.r) goto L130;
        r10 = 26;
    L131:
        r8 = r46;
        int r48 = 16;
        int r123 = 0;
        double[][] r124 = null;
    L164:
        r13 = r45;
        r11 = r48;
        r1 = r123;
        r3 = r124;
        r7 = '[';
        goto L18
    L130:
        r10 = this.q.charAt(r47);
        goto L131
    L132:
        if (r44 == ']') goto L133;
        r48 = 16;
        r123 = 0;
        r124 = null;
        r10 = r44;
        r8 = r42;
        goto L164
    L133:
        int r49 = r42 + 1;
        int r50 = this.f12408e + r42;
        if (r50 < this.r) goto L136;
        char r51 = 26;
    L138:
        if (r45 == r12.length) goto L140;
        double[][] r52 = new double[r45][];
        System.arraycopy(r12, 0, r52, 0, r45);
        r12 = r52;
    L140:
        if (r51 != ',') goto L144;
        this.f12408e += r49 - 1;
        q();
        this.p = 3;
        this.f12404a = 16;
        return r12;
    L144:
        if (r51 != '}') goto L161;
        int r53 = r49 + 1;
        char r54 = b(this.f12408e + r49);
        if (r54 != ',') goto L149;
        this.f12404a = 16;
    L148:
        this.f12408e += r53 - 1;
        q();
    L157:
        this.p = 4;
        return r12;
    L149:
        if (r54 != ']') goto L152;
        int r55 = 15;
    L151:
        this.f12404a = r55;
        goto L148
    L152:
        if (r54 != '}') goto L155;
        r55 = 13;
        goto L151
    L155:
        if (r54 != 26) goto L159;
        this.f12408e += r53 - 1;
        this.f12404a = 20;
        this.f12407d = 26;
        goto L157
    L159:
        this.p = -1;
        return null;
    L161:
        this.p = -1;
        return null;
    L136:
        r51 = this.q.charAt(r50);
        goto L138
    L121:
        r122 = 0;
        goto L123
    L117:
        r44 = this.q.charAt(r43);
        goto L119
    L97:
        if (r35 >= 10) goto L101;
        r36 = ((double) r22) / ((double) r27);
        if (r111 == 0) goto L103;
        r36 = -r36;
        goto L103
    L68:
        if (r24 == 'E') goto L71;
        r117 = false;
        goto L72
    L58:
        r24 = this.q.charAt(r28);
    L62:
        this.p = -1;
        return r3;
    L51:
        r26 = this.q.charAt(r25);
        goto L52
    L64:
        r27 = 1;
        goto L66
    L42:
        r24 = this.q.charAt(r23);
    L167:
        double[][] r125 = r3;
        this.p = -1;
        return r125;
    L27:
        r111 = r1;
        goto L28
    L22:
        r16 = this.q.charAt(r15);
        goto L23
    L16:
        r10 = this.q.charAt(r9);
        goto L17
    L8:
        r6 = this.q.charAt(r4);
        goto L9
    }

    public final float C(long r18) {
        boolean r1 = false;
        this.p = 0;
        int r2 = p(r18);
        if (r2 != 0) goto L5;
        return 0.0f;
    L5:
        int r5 = r2 + 1;
        char r3 = b(this.f12408e + r2);
        int r4 = this.f12408e;
        int r6 = (r4 + r5) - 1;
        if (r3 != '-') goto L8;
        boolean r9 = true;
    L9:
        if (r9 == false) goto L12;
        char r7 = b(r4 + r5);
        r5 = r5 + 1;
        r3 = r7;
    L12:
        if (r3 >= '0') goto L14;
    L84:
        this.p = -1;
        return 0.0f;
    L14:
        if (r3 > '9') goto L84;
        int r8 = r3 - '0';
    L16:
        int r13 = r5 + 1;
        char r10 = b(this.f12408e + r5);
        if (r10 < '0') goto L21;
        if (r10 > '9') goto L21;
        r8 = (r8 * 10) + (r10 - '0');
        r5 = r13;
    L21:
        if (r10 != '.') goto L23;
        boolean r12 = true;
    L25:
        if (r12 == false) goto L37;
        int r14 = r13 + 1;
        char r11 = b(this.f12408e + r13);
        if (r11 < '0') goto L35;
        if (r11 > '9') goto L35;
        r8 = (r8 * 10) + (r11 - '0');
        int r15 = 10;
    L30:
        int r16 = r14 + 1;
        char r17 = b(this.f12408e + r14);
        if (r17 < '0') goto L34;
        if (r17 > '9') goto L34;
        r8 = (r8 * 10) + (r17 - '0');
        r15 = r15 * 10;
        r14 = r16;
    L34:
        r13 = r16;
        int r19 = r15;
        r10 = r17;
    L39:
        if (r10 != 'e') goto L41;
    L42:
        r1 = true;
    L43:
        if (r1 == false) goto L54;
        int r110 = r13 + 1;
        r10 = b(this.f12408e + r13);
        if (r10 == '+') goto L49;
        if (r10 == '-') goto L49;
        r13 = r110;
    L51:
        if (r10 < '0') goto L54;
        if (r10 > '9') goto L54;
        int r20 = r13 + 1;
        r10 = b(this.f12408e + r13);
        r13 = r20;
    L49:
        int r21 = r110 + 1;
        r10 = b(this.f12408e + r110);
        r13 = r21;
    L54:
        int r22 = ((this.f12408e + r13) - r6) - 1;
        if (r1 == true) goto L60;
        if (r22 >= 10) goto L60;
        float r23 = r8 / r19;
        if (r9 == false) goto L61;
        r23 = -r23;
    L61:
        int r24 = 16;
        if (r10 != ',') goto L66;
        this.f12408e += r13 - 1;
        q();
        this.p = 3;
        this.f12404a = 16;
        return r23;
    L66:
        if (r10 != '}') goto L82;
        int r25 = r13 + 1;
        char r26 = b(this.f12408e + r13);
        if (r26 != ',') goto L71;
    L69:
        this.f12404a = r24;
        this.f12408e += r25 - 1;
        q();
    L78:
        this.p = 4;
        return r23;
    L71:
        if (r26 != ']') goto L73;
        r24 = 15;
        goto L69
    L73:
        if (r26 != '}') goto L76;
        r24 = 13;
        goto L69
    L76:
        if (r26 != 26) goto L80;
        this.f12408e += r25 - 1;
        this.f12404a = 20;
        this.f12407d = 26;
        goto L78
    L80:
        this.p = -1;
        return 0.0f;
    L82:
        this.p = -1;
        return 0.0f;
    L60:
        r23 = Float.parseFloat(Y(r6, r22));
        goto L61
    L41:
        if (r10 != 'E') goto L43;
    L35:
        this.p = -1;
        return 0.0f;
    L37:
        r19 = 1;
        goto L39
    L23:
        r12 = false;
        goto L25
    L8:
        r9 = false;
        goto L9
    }

    public final float[] D(long r20) {
        boolean r1 = false;
        this.p = 0;
        int r2 = p(r20);
        float[] r3 = null;
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r5 = r2 + 1;
        int r4 = this.f12408e + r2;
        if (r4 < this.r) goto L8;
        char r6 = 26;
    L10:
        if (r6 == '[') goto L13;
        this.p = -1;
        return null;
    L13:
        int r7 = r5 + 1;
        int r8 = this.f12408e + r5;
        if (r8 < this.r) goto L16;
        char r9 = 26;
    L17:
        float[] r10 = new float[16];
        int r11 = 0;
    L18:
        int r12 = this.f12408e;
        int r13 = (r12 + r7) - 1;
        if (r9 != '-') goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L29;
        int r15 = r7 + 1;
        int r16 = r12 + r7;
        if (r16 < this.r) goto L26;
        char r17 = 26;
    L27:
        char r18 = r17;
        r7 = r15;
        r9 = r18;
        goto L29
    L26:
        r17 = this.q.charAt(r16);
    L29:
        if (r9 < '0') goto L142;
        if (r9 > '9') goto L142;
        int r19 = r9 - '0';
    L33:
        int r110 = r7 + 1;
        int r21 = this.f12408e + r7;
        if (r21 < this.r) goto L36;
        char r22 = 26;
    L37:
        if (r22 < '0') goto L41;
        if (r22 > '9') goto L41;
        r19 = (r19 * 10) + (r22 - '0');
        r7 = r110;
    L41:
        if (r22 != '.') goto L43;
        boolean r23 = true;
    L45:
        if (r23 == false) goto L62;
        int r24 = r110 + 1;
        int r25 = this.f12408e + r110;
        if (r25 < this.r) goto L49;
        char r26 = 26;
    L50:
        if (r26 < '0') goto L60;
        if (r26 > '9') goto L60;
        r19 = (r19 * 10) + (r26 - '0');
        int r27 = 10;
    L53:
        r110 = r24 + 1;
        int r28 = this.f12408e + r24;
        if (r28 < this.r) goto L56;
        r22 = 26;
    L57:
        if (r22 < '0') goto L64;
        if (r22 > '9') goto L64;
        r19 = (r19 * 10) + (r22 - '0');
        r27 = r27 * 10;
        r24 = r110;
    L64:
        if (r22 != 'e') goto L66;
    L69:
        boolean r29 = true;
    L70:
        if (r29 == false) goto L90;
        int r111 = r110 + 1;
        int r30 = this.f12408e + r110;
        if (r30 < this.r) goto L74;
        char r31 = 26;
    L76:
        if (r31 == '+') goto L80;
        if (r31 == '-') goto L80;
        r22 = r31;
        r110 = r111;
    L85:
        if (r22 < '0') goto L90;
        if (r22 > '9') goto L90;
        int r32 = r110 + 1;
        int r33 = this.f12408e + r110;
        if (r33 >= this.r) goto L144;
    L84:
        r110 = r32;
        r22 = this.q.charAt(r33);
    L144:
        r110 = r32;
        r22 = 26;
    L80:
        r32 = r111 + 1;
        r33 = this.f12408e + r111;
        if (r33 < this.r) goto L84;
    L74:
        r31 = this.q.charAt(r30);
    L90:
        int r34 = ((this.f12408e + r110) - r13) - 1;
        if (r29 == true) goto L96;
        if (r34 >= 10) goto L96;
        float r35 = r19 / r27;
        if (r14 == false) goto L98;
        r35 = -r35;
    L98:
        if (r11 < r10.length) goto L100;
        float[] r36 = new float[(r10.length * 3) / 2];
        System.arraycopy(r10, 0, r36, 0, r11);
        r10 = r36;
    L100:
        int r37 = r11 + 1;
        r10[r11] = r35;
        if (r22 != ',') goto L108;
        int r38 = r110 + 1;
        int r39 = this.f12408e + r110;
        if (r39 < this.r) goto L105;
        char r40 = 26;
    L106:
        r22 = r40;
        r110 = r38;
    L141:
        r3 = null;
        r9 = r22;
        r11 = r37;
        r7 = r110;
        r1 = false;
        goto L18
    L105:
        r40 = this.q.charAt(r39);
        goto L106
    L108:
        if (r22 != ']') goto L141;
        int r41 = r110 + 1;
        int r42 = this.f12408e + r110;
        if (r42 < this.r) goto L112;
        char r43 = 26;
    L114:
        if (r37 == r10.length) goto L116;
        float[] r44 = new float[r37];
        System.arraycopy(r10, 0, r44, 0, r37);
        r10 = r44;
    L116:
        if (r43 != ',') goto L120;
        this.f12408e += r41 - 1;
        q();
        this.p = 3;
        this.f12404a = 16;
        return r10;
    L120:
        if (r43 != '}') goto L139;
        int r45 = r41 + 1;
        int r46 = this.f12408e + r41;
        if (r46 < this.r) goto L124;
        char r47 = 26;
    L125:
        if (r47 != ',') goto L128;
        int r48 = 16;
    L127:
        this.f12404a = r48;
        this.f12408e += r45 - 1;
        q();
    L135:
        this.p = 4;
        return r10;
    L128:
        if (r47 != ']') goto L130;
        r48 = 15;
        goto L127
    L130:
        if (r47 != '}') goto L133;
        r48 = 13;
        goto L127
    L133:
        if (r47 != 26) goto L137;
        this.f12408e += r45 - 1;
        this.f12404a = 20;
        this.f12407d = 26;
        goto L135
    L137:
        this.p = -1;
        return null;
    L124:
        r47 = this.q.charAt(r46);
        goto L125
    L139:
        this.p = -1;
        return null;
    L112:
        r43 = this.q.charAt(r42);
    L96:
        r35 = Float.parseFloat(Y(r13, r34));
        goto L98
    L66:
        if (r22 == 'E') goto L69;
        r29 = false;
        goto L70
    L56:
        r22 = this.q.charAt(r28);
    L60:
        this.p = -1;
        return r3;
    L49:
        r26 = this.q.charAt(r25);
        goto L50
    L62:
        r27 = 1;
        goto L64
    L43:
        r23 = r1;
        goto L45
    L36:
        r22 = this.q.charAt(r21);
    L142:
        this.p = -1;
        return r3;
    L21:
        r14 = r1;
        goto L22
    L16:
        r9 = this.q.charAt(r8);
        goto L17
    L8:
        r6 = this.q.charAt(r4);
        goto L10
    }

    public final float[][] E(long r21) {
        int r1 = 0;
        this.p = 0;
        int r2 = p(r21);
        float[][] r3 = null;
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r5 = r2 + 1;
        int r4 = this.f12408e + r2;
        if (r4 < this.r) goto L8;
        char r6 = 26;
    L9:
        char r7 = '[';
        if (r6 == '[') goto L13;
        this.p = -1;
        return null;
    L13:
        int r8 = r5 + 1;
        int r9 = this.f12408e + r5;
        if (r9 < this.r) goto L16;
        char r10 = 26;
    L17:
        int r11 = 16;
        float[][] r12 = new float[16][];
        int r13 = 0;
    L18:
        if (r10 != r7) goto L18;
        int r14 = r8 + 1;
        int r15 = this.f12408e + r8;
        if (r15 < this.r) goto L22;
        char r16 = 26;
    L23:
        float[] r17 = new float[r11];
        int r18 = r1;
    L24:
        int r19 = this.f12408e;
        int r110 = (r19 + r14) - 1;
        if (r16 != '-') goto L27;
        int r111 = 1;
    L28:
        if (r111 == 0) goto L35;
        int r20 = r14 + 1;
        int r112 = r19 + r14;
        if (r112 < this.r) goto L32;
        char r113 = 26;
    L33:
        char r114 = r113;
        r14 = r20;
        r16 = r114;
        goto L35
    L32:
        r113 = this.q.charAt(r112);
    L35:
        if (r16 < '0') goto L167;
        if (r16 > '9') goto L167;
        int r22 = r16 - '0';
    L39:
        int r115 = r14 + 1;
        int r23 = this.f12408e + r14;
        if (r23 < this.r) goto L42;
        char r24 = 26;
    L43:
        if (r24 < '0') goto L47;
        if (r24 > '9') goto L47;
        r22 = (r22 * 10) + (r24 - '0');
        r14 = r115;
    L47:
        if (r24 != '.') goto L64;
        int r116 = r115 + 1;
        int r25 = this.f12408e + r115;
        if (r25 < this.r) goto L51;
        char r26 = 26;
    L52:
        if (r26 < '0') goto L62;
        if (r26 > '9') goto L62;
        r22 = (r22 * 10) + (r26 - '0');
        int r27 = 10;
    L55:
        r115 = r116 + 1;
        int r28 = this.f12408e + r116;
        if (r28 < this.r) goto L58;
        r24 = 26;
    L59:
        if (r24 < '0') goto L66;
        if (r24 > '9') goto L66;
        r22 = (r22 * 10) + (r24 - '0');
        r27 = r27 * 10;
        r116 = r115;
    L66:
        if (r24 != 'e') goto L68;
    L71:
        boolean r117 = true;
    L72:
        if (r117 == false) goto L94;
        int r118 = r115 + 1;
        int r29 = this.f12408e + r115;
        if (r29 < this.r) goto L76;
        char r30 = 26;
    L78:
        if (r30 == '+') goto L82;
        if (r30 == '-') goto L82;
        r24 = r30;
        r115 = r118;
    L88:
        if (r24 < '0') goto L94;
        if (r24 > '9') goto L94;
        int r31 = r115 + 1;
        int r32 = this.f12408e + r115;
        if (r32 < this.r) goto L93;
        r24 = 26;
        r115 = r31;
        goto L88
    L93:
        char r33 = this.q.charAt(r32);
    L86:
        r24 = r33;
        r115 = r31;
    L82:
        r31 = r118 + 1;
        int r34 = this.f12408e + r118;
        if (r34 < this.r) goto L85;
        r33 = 26;
        goto L86
    L85:
        r33 = this.q.charAt(r34);
        goto L86
    L76:
        r30 = this.q.charAt(r29);
    L94:
        int r35 = ((this.f12408e + r115) - r110) - 1;
        if (r117 == false) goto L97;
    L101:
        float r36 = Float.parseFloat(Y(r110, r35));
    L103:
        if (r18 < r17.length) goto L105;
        float[] r37 = new float[(r17.length * 3) / 2];
        System.arraycopy(r17, 0, r37, 0, r18);
        r17 = r37;
    L105:
        int r38 = r18 + 1;
        r17[r18] = r36;
        if (r24 != ',') goto L113;
        int r39 = r115 + 1;
        int r40 = this.f12408e + r115;
        if (r40 < this.r) goto L110;
        r16 = 26;
    L111:
        r115 = r39;
        char r41 = 16;
        int r119 = 0;
        float[][] r120 = null;
    L166:
        r3 = r120;
        r18 = r38;
        r1 = r119;
        r14 = r115;
        goto L24
    L110:
        r16 = this.q.charAt(r40);
        goto L111
    L113:
        if (r24 == ']') goto L114;
        r41 = 16;
        r119 = 0;
        r120 = null;
        r16 = r24;
        goto L166
    L114:
        int r42 = r115 + 1;
        int r43 = this.f12408e + r115;
        if (r43 < this.r) goto L117;
        char r44 = 26;
    L119:
        if (r38 == r17.length) goto L121;
        float[] r121 = new float[r38];
        int r122 = 0;
        System.arraycopy(r17, 0, r121, 0, r38);
        r17 = r121;
    L123:
        if (r13 < r12.length) goto L125;
        r12 = new float[(r12.length * 3) / 2][];
        System.arraycopy(r17, r122, r12, r122, r38);
    L125:
        int r45 = r13 + 1;
        r12[r13] = r17;
        if (r44 != ',') goto L132;
        int r46 = r42 + 1;
        int r47 = this.f12408e + r42;
        if (r47 < this.r) goto L130;
        r10 = 26;
    L131:
        r8 = r46;
        int r48 = 16;
        int r123 = 0;
        float[][] r124 = null;
    L164:
        r13 = r45;
        r11 = r48;
        r1 = r123;
        r3 = r124;
        r7 = '[';
        goto L18
    L130:
        r10 = this.q.charAt(r47);
        goto L131
    L132:
        if (r44 == ']') goto L133;
        r48 = 16;
        r123 = 0;
        r124 = null;
        r10 = r44;
        r8 = r42;
        goto L164
    L133:
        int r49 = r42 + 1;
        int r50 = this.f12408e + r42;
        if (r50 < this.r) goto L136;
        char r51 = 26;
    L138:
        if (r45 == r12.length) goto L140;
        float[][] r52 = new float[r45][];
        System.arraycopy(r12, 0, r52, 0, r45);
        r12 = r52;
    L140:
        if (r51 != ',') goto L144;
        this.f12408e += r49 - 1;
        q();
        this.p = 3;
        this.f12404a = 16;
        return r12;
    L144:
        if (r51 != '}') goto L161;
        int r53 = r49 + 1;
        char r54 = b(this.f12408e + r49);
        if (r54 != ',') goto L149;
        this.f12404a = 16;
    L148:
        this.f12408e += r53 - 1;
        q();
    L157:
        this.p = 4;
        return r12;
    L149:
        if (r54 != ']') goto L152;
        int r55 = 15;
    L151:
        this.f12404a = r55;
        goto L148
    L152:
        if (r54 != '}') goto L155;
        r55 = 13;
        goto L151
    L155:
        if (r54 != 26) goto L159;
        this.f12408e += r53 - 1;
        this.f12404a = 20;
        this.f12407d = 26;
        goto L157
    L159:
        this.p = -1;
        return null;
    L161:
        this.p = -1;
        return null;
    L136:
        r51 = this.q.charAt(r50);
        goto L138
    L121:
        r122 = 0;
        goto L123
    L117:
        r44 = this.q.charAt(r43);
        goto L119
    L97:
        if (r35 >= 10) goto L101;
        r36 = r22 / r27;
        if (r111 == 0) goto L103;
        r36 = -r36;
        goto L103
    L68:
        if (r24 == 'E') goto L71;
        r117 = false;
        goto L72
    L58:
        r24 = this.q.charAt(r28);
    L62:
        this.p = -1;
        return r3;
    L51:
        r26 = this.q.charAt(r25);
        goto L52
    L64:
        r27 = 1;
        goto L66
    L42:
        r24 = this.q.charAt(r23);
    L167:
        float[][] r125 = r3;
        this.p = -1;
        return r125;
    L27:
        r111 = r1;
        goto L28
    L22:
        r16 = this.q.charAt(r15);
        goto L23
    L16:
        r10 = this.q.charAt(r9);
        goto L17
    L8:
        r6 = this.q.charAt(r4);
        goto L9
    }

    public int F(long r11) {
        this.p = 0;
        int r12 = p(r11);
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r1 = r12 + 1;
        int r13 = this.f12408e + r12;
        char r2 = 26;
        if (r13 < this.r) goto L8;
        char r14 = 26;
    L10:
        if (r14 != '\"') goto L16;
        int r4 = r1 + 1;
        int r15 = this.f12408e + r1;
        if (r15 < this.r) goto L14;
        r14 = 26;
    L15:
        r1 = r4;
        boolean r5 = true;
    L18:
        if (r14 >= '0') goto L20;
    L79:
        this.p = -1;
        return 0;
    L20:
        if (r14 > '9') goto L79;
        int r16 = r14 - '0';
    L22:
        int r9 = r1 + 1;
        int r8 = this.f12408e + r1;
        if (r8 < this.r) goto L25;
        char r3 = 26;
    L26:
        if (r3 < '0') goto L30;
        if (r3 > '9') goto L30;
        r16 = (r16 * 10) + (r3 - '0');
        r1 = r9;
    L30:
        if (r3 != '.') goto L33;
        this.p = -1;
        return 0;
    L33:
        if (r3 != '\"') goto L42;
        if (r5 == true) goto L37;
        this.p = -1;
        return 0;
    L37:
        int r6 = r9 + 1;
        int r17 = this.f12408e + r9;
        if (r17 < this.r) goto L40;
        char r18 = 26;
    L41:
        r9 = r6;
        r3 = r18;
        goto L42
    L40:
        r18 = this.q.charAt(r17);
    L42:
        if (r16 >= 0) goto L46;
        this.p = -1;
        return 0;
    L46:
        if (r3 != ',') goto L54;
        int r0 = this.f12408e + (r9 - 1);
        this.f12408e = r0;
        int r7 = r0 + 1;
        this.f12408e = r7;
        if (r7 >= this.r) goto L51;
        r2 = this.q.charAt(r7);
    L51:
        this.f12407d = r2;
        this.p = 3;
        this.f12404a = 16;
        return r16;
    L54:
        if (r3 != '}') goto L77;
        int r10 = r9 + 1;
        char r19 = b(this.f12408e + r9);
        if (r19 != ',') goto L63;
        this.f12404a = 16;
        int r110 = this.f12408e + (r10 - 1);
        this.f12408e = r110;
        int r111 = r110 + 1;
        this.f12408e = r111;
        if (r111 >= this.r) goto L61;
    L60:
        r2 = this.q.charAt(r111);
    L61:
        this.f12407d = r2;
        this.p = 4;
        return r16;
    L63:
        if (r19 != ']') goto L67;
        this.f12404a = 15;
        int r112 = this.f12408e + (r10 - 1);
        this.f12408e = r112;
        r111 = r112 + 1;
        this.f12408e = r111;
        if (r111 < this.r) goto L60;
    L67:
        if (r19 != '}') goto L71;
        this.f12404a = 13;
        int r113 = this.f12408e + (r10 - 1);
        this.f12408e = r113;
        r111 = r113 + 1;
        this.f12408e = r111;
        if (r111 < this.r) goto L60;
    L71:
        if (r19 != 26) goto L75;
        this.f12404a = 20;
        this.f12408e += r10 - 1;
        goto L61
    L75:
        this.p = -1;
        return 0;
    L77:
        this.p = -1;
        return 0;
    L25:
        r3 = this.q.charAt(r8);
        goto L26
    L14:
        r14 = this.q.charAt(r15);
        goto L15
    L16:
        r5 = false;
        goto L18
    L8:
        r14 = this.q.charAt(r13);
        goto L10
    }

    public final int[] G(long r18) {
        this.p = 0;
        int r2 = p(r18);
        int[] r3 = null;
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r5 = r2 + 1;
        int r4 = this.f12408e + r2;
        if (r4 < this.r) goto L8;
        char r6 = 26;
    L9:
        byte r7 = -1;
        if (r6 == '[') goto L13;
        this.p = -1;
        return null;
    L13:
        int r8 = r5 + 1;
        int r9 = this.f12408e + r5;
        if (r9 < this.r) goto L16;
        char r10 = 26;
    L17:
        int[] r11 = new int[16];
        if (r10 != ']') goto L24;
        int r13 = r8 + 1;
        int r12 = this.f12408e + r8;
        if (r12 < this.r) goto L22;
        char r14 = 26;
    L23:
        int r15 = 0;
    L64:
        if (r15 == r11.length) goto L66;
        int[] r16 = new int[r15];
        System.arraycopy(r11, 0, r16, 0, r15);
        r11 = r16;
    L66:
        if (r14 != ',') goto L70;
        this.f12408e += r13 - 1;
        q();
        this.p = 3;
        this.f12404a = 16;
        return r11;
    L70:
        if (r14 != '}') goto L86;
        int r17 = r13 + 1;
        char r19 = b(this.f12408e + r13);
        if (r19 != ',') goto L75;
        this.f12404a = 16;
    L74:
        this.f12408e += r17 - 1;
        q();
    L82:
        this.p = 4;
        return r11;
    L75:
        if (r19 != ']') goto L78;
        int r1 = 15;
    L77:
        this.f12404a = r1;
        goto L74
    L78:
        if (r19 != '}') goto L80;
        r1 = 13;
        goto L77
    L80:
        if (r19 != 26) goto L84;
        this.f12408e += r17 - 1;
        this.f12404a = 20;
        this.f12407d = 26;
        goto L82
    L84:
        this.p = -1;
        return null;
    L86:
        this.p = -1;
        return null;
    L22:
        r14 = this.q.charAt(r12);
        goto L23
    L24:
        int r110 = 0;
    L26:
        if (r10 != '-') goto L32;
        int r111 = r8 + 1;
        int r20 = this.f12408e + r8;
        if (r20 < this.r) goto L30;
        r10 = 26;
    L31:
        r8 = r111;
        boolean r112 = true;
    L34:
        if (r10 < '0') goto L91;
        if (r10 > '9') goto L90;
        int r21 = r10 - '0';
    L38:
        int r113 = r8 + 1;
        int r22 = this.f12408e + r8;
        if (r22 < this.r) goto L41;
        char r23 = 26;
    L42:
        if (r23 < '0') goto L46;
        if (r23 > '9') goto L46;
        r21 = (r21 * 10) + (r23 - '0');
        r8 = r113;
    L46:
        if (r110 < r11.length) goto L48;
        int[] r24 = new int[(r11.length * 3) / 2];
        System.arraycopy(r11, 0, r24, 0, r110);
        r11 = r24;
    L48:
        r15 = r110 + 1;
        if (r112 == false) goto L51;
        r21 = -r21;
    L51:
        r11[r110] = r21;
        if (r23 != ',') goto L58;
        int r25 = r113 + 1;
        int r26 = this.f12408e + r113;
        if (r26 < this.r) goto L56;
        char r27 = 26;
    L57:
        r113 = r25;
        int[] r28 = null;
        r23 = r27;
        byte r29 = -1;
    L89:
        r110 = r15;
        r3 = r28;
        r7 = r29;
        r10 = r23;
        r8 = r113;
        goto L26
    L56:
        r27 = this.q.charAt(r26);
        goto L57
    L58:
        if (r23 == ']') goto L59;
        r29 = -1;
        r28 = null;
        goto L89
    L59:
        r13 = r113 + 1;
        int r30 = this.f12408e + r113;
        if (r30 < this.r) goto L62;
        r14 = 26;
        goto L64
    L62:
        r14 = this.q.charAt(r30);
        goto L64
    L41:
        r23 = this.q.charAt(r22);
        goto L42
    L90:
        int[] r31 = null;
    L92:
        this.p = r7;
        return r31;
    L91:
        r31 = r3;
        goto L92
    L30:
        r10 = this.q.charAt(r20);
        goto L31
    L32:
        r112 = false;
        goto L34
    L16:
        r10 = this.q.charAt(r9);
        goto L17
    L8:
        r6 = this.q.charAt(r4);
        goto L9
    }

    public long H(long r18) {
        boolean r1 = false;
        this.p = 0;
        int r2 = p(r18);
        if (r2 != 0) goto L5;
        return 0;
    L5:
        int r6 = r2 + 1;
        int r5 = this.f12408e + r2;
        if (r5 < this.r) goto L8;
        char r3 = 26;
    L10:
        if (r3 != '\"') goto L17;
        int r4 = r6 + 1;
        int r7 = this.f12408e + r6;
        if (r7 < this.r) goto L14;
        char r8 = 26;
    L15:
        r6 = r4;
        r3 = r8;
        r1 = true;
        goto L17
    L14:
        r8 = this.q.charAt(r7);
    L17:
        if (r3 >= '0') goto L19;
    L80:
        this.p = -1;
        return 0;
    L19:
        if (r3 > '9') goto L80;
        long r12 = r3 - '0';
    L21:
        int r14 = r6 + 1;
        int r9 = this.f12408e + r6;
        if (r9 < this.r) goto L24;
        char r10 = 26;
    L25:
        if (r10 < '0') goto L29;
        if (r10 > '9') goto L29;
        r12 = (r12 * 10) + ((long) (r10 - '0'));
        r6 = r14;
    L29:
        if (r10 != '.') goto L32;
        this.p = -1;
        return 0;
    L32:
        if (r10 != '\"') goto L42;
        if (r1 == true) goto L36;
        this.p = -1;
        return 0;
    L36:
        int r11 = r14 + 1;
        int r13 = this.f12408e + r14;
        if (r13 < this.r) goto L39;
        char r15 = 26;
    L40:
        r14 = r11;
        r10 = r15;
        goto L42
    L39:
        r15 = this.q.charAt(r13);
    L42:
        if (r12 >= 0) goto L46;
        this.p = -1;
        return 0;
    L46:
        if (r10 != ',') goto L54;
        int r16 = this.f12408e + (r14 - 1);
        this.f12408e = r16;
        int r17 = r16 + 1;
        this.f12408e = r17;
        if (r17 < this.r) goto L50;
        char r19 = 26;
    L51:
        this.f12407d = r19;
        this.p = 3;
        this.f12404a = 16;
        return r12;
    L50:
        r19 = this.q.charAt(r17);
        goto L51
    L54:
        if (r10 != '}') goto L78;
        int r20 = r14 + 1;
        char r21 = b(this.f12408e + r14);
        if (r21 != ',') goto L63;
        this.f12404a = 16;
        int r22 = this.f12408e + (r20 - 1);
        this.f12408e = r22;
        int r23 = r22 + 1;
        this.f12408e = r23;
        if (r23 < this.r) goto L60;
    L59:
        char r24 = 26;
    L61:
        this.f12407d = r24;
    L74:
        this.p = 4;
        return r12;
    L60:
        r24 = this.q.charAt(r23);
        goto L61
    L63:
        if (r21 != ']') goto L67;
        this.f12404a = 15;
        int r25 = this.f12408e + (r20 - 1);
        this.f12408e = r25;
        r23 = r25 + 1;
        this.f12408e = r23;
        if (r23 < this.r) goto L60;
    L67:
        if (r21 != '}') goto L72;
        this.f12404a = 13;
        int r26 = this.f12408e + (r20 - 1);
        this.f12408e = r26;
        r23 = r26 + 1;
        this.f12408e = r23;
        if (r23 < this.r) goto L60;
    L72:
        if (r21 != 26) goto L76;
        this.f12404a = 20;
        this.f12408e += r20 - 1;
        this.f12407d = 26;
        goto L74
    L76:
        this.p = -1;
        return 0;
    L78:
        this.p = -1;
        return 0;
    L24:
        r10 = this.q.charAt(r9);
        goto L25
    L8:
        r3 = this.q.charAt(r5);
        goto L10
    }

    public String I(long r11) {
        this.p = 0;
        int r12 = p(r11);
        if (r12 != 0) goto L6;
        return null;
    L6:
        int r1 = r12 + 1;
        int r13 = this.f12408e + r12;
        if (r13 >= this.r) goto L69;
        if (this.q.charAt(r13) == '\"') goto L12;
    L10:
        this.p = -1;
        return this.s;
    L12:
        int r14 = this.f12408e + r1;
        int r4 = this.q.indexOf(34, r14);
        if (r4 == (-1)) goto L67;
        if (v == false) goto L17;
        String r2 = this.q.substring(r14, r4);
    L19:
        if (r2.indexOf(92) == (-1)) goto L35;
        boolean r3 = false;
    L21:
        int r6 = r4 - 1;
        int r8 = 0;
    L22:
        if (r6 < 0) goto L27;
        if (this.q.charAt(r6) != '\\') goto L27;
        r8 = r8 + 1;
        r6 = r6 - 1;
        r3 = true;
    L27:
        if ((r8 % 2) == 0) goto L28;
        r4 = this.q.indexOf(34, r4 + 1);
        goto L21
    L28:
        int r15 = r4 - r14;
        char[] r16 = Z(this.f12408e + r1, r15);
        if (r3 == false) goto L31;
    L30:
        r2 = w(r16, r15);
        goto L35
    L31:
        r2 = new String(r16, 0, r15);
        if (r2.indexOf(92) != (-1)) goto L30;
    L35:
        int r5 = r4 + 1;
        char r17 = 26;
        if (r5 < this.r) goto L38;
        char r18 = 26;
    L40:
        if (r18 != ',') goto L48;
        this.f12408e = r5;
        int r7 = r5 + 1;
        this.f12408e = r7;
        if (r7 >= this.r) goto L45;
        r17 = this.q.charAt(r7);
    L45:
        this.f12407d = r17;
        this.p = 3;
        this.f12404a = 16;
        return r2;
    L48:
        if (r18 != '}') goto L10;
        int r9 = r5 + 1;
        if (r9 < this.r) goto L52;
        char r19 = 26;
    L53:
        if (r19 != ',') goto L57;
        this.f12404a = 16;
    L55:
        this.f12408e = r9;
        q();
    L64:
        this.p = 4;
        return r2;
    L57:
        if (r19 != ']') goto L60;
        int r110 = 15;
    L59:
        this.f12404a = r110;
        goto L55
    L60:
        if (r19 != '}') goto L62;
        r110 = 13;
        goto L59
    L62:
        if (r19 != 26) goto L10;
        this.f12404a = 20;
        this.f12408e = r9;
        this.f12407d = 26;
        goto L64
    L52:
        r19 = this.q.charAt(r9);
        goto L53
    L38:
        r18 = this.q.charAt(r5);
        goto L40
    L17:
        int r10 = r4 - r14;
        r2 = new String(Z(this.f12408e + r1, r10), 0, r10);
        goto L19
    L67:
        throw new d.a.a.d("unclosed str, " + i());
    L69:
        throw new d.a.a.d("unclosed str, " + i());
    }

    public long J(long r11) {
        this.p = 0;
        int r12 = p(r11);
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r2 = r12 + 1;
        int r13 = this.f12408e + r12;
        char r3 = 26;
        if (r13 < this.r) goto L8;
        char r14 = 26;
    L10:
        if (r14 == '\"') goto L13;
        this.p = -1;
        return 0;
    L13:
        long r5 = -2128831035;
    L14:
        int r7 = r2 + 1;
        int r15 = this.f12408e + r2;
        if (r15 < this.r) goto L17;
        char r16 = 26;
    L18:
        if (r16 == '\"') goto L19;
        r5 = (r5 ^ ((long) r16)) * 16777619;
        if (r16 == '\\') goto L55;
        r2 = r7;
        goto L14
    L55:
        this.p = -1;
        return 0;
    L19:
        int r17 = r7 + 1;
        int r18 = this.f12408e + r7;
        if (r18 < this.r) goto L22;
        char r19 = 26;
    L24:
        if (r19 != ',') goto L32;
        int r110 = this.f12408e + (r17 - 1);
        this.f12408e = r110;
        int r111 = r110 + 1;
        this.f12408e = r111;
        if (r111 >= this.r) goto L29;
        r3 = this.q.charAt(r111);
    L29:
        this.f12407d = r3;
        this.p = 3;
        return r5;
    L32:
        if (r19 != '}') goto L51;
        int r8 = r17 + 1;
        int r112 = this.f12408e + r17;
        if (r112 < this.r) goto L36;
        char r113 = 26;
    L37:
        if (r113 != ',') goto L41;
        int r114 = 16;
    L39:
        this.f12404a = r114;
        this.f12408e += r8 - 1;
        q();
    L47:
        this.p = 4;
        return r5;
    L41:
        if (r113 != ']') goto L43;
        r114 = 15;
        goto L39
    L43:
        if (r113 != '}') goto L45;
        r114 = 13;
        goto L39
    L45:
        if (r113 != 26) goto L49;
        this.f12404a = 20;
        this.f12408e += r8 - 1;
        this.f12407d = 26;
        goto L47
    L49:
        this.p = -1;
        return 0;
    L36:
        r113 = this.q.charAt(r112);
        goto L37
    L51:
        this.p = -1;
        return 0;
    L22:
        r19 = this.q.charAt(r18);
        goto L24
    L17:
        r16 = this.q.charAt(r15);
        goto L18
    L8:
        r14 = this.q.charAt(r13);
        goto L10
    }

    public boolean K(boolean r36) {
        int r0 = this.r;
        int r1 = this.f12408e;
        int r10 = r0 - r1;
        if (r36 == true) goto L26;
        if (r10 <= 13) goto L26;
        if (this.q.startsWith("/Date(", r1) == false) goto L26;
        if (b((this.f12408e + r10) - 1) != '/') goto L26;
        if (b((this.f12408e + r10) - 2) != ')') goto L26;
        int r2 = -1;
        int r3 = 6;
    L12:
        if (r3 >= r10) goto L21;
        char r4 = b(this.f12408e + r3);
        if (r4 != '+') goto L16;
        r2 = r3;
    L19:
        r3 = r3 + 1;
        goto L12
    L16:
        if (r4 < '0') goto L21;
        if (r4 <= '9') goto L19;
    L21:
        if (r2 != (-1)) goto L23;
        return false;
    L23:
        int r5 = this.f12408e + 6;
        long r6 = Long.parseLong(Y(r5, r2 - r5), 10);
        Calendar r7 = Calendar.getInstance(this.m, this.n);
        this.o = r7;
        r7.setTimeInMillis(r6);
        this.f12404a = 5;
        return true;
    L26:
        if (r10 == 8) goto L155;
        if (r10 == 14) goto L155;
        if (r10 == 17) goto L155;
        if (r10 >= 10) goto L33;
        return false;
    L33:
        if (b(this.f12408e + 4) == '-') goto L36;
        return false;
    L36:
        if (b(this.f12408e + 7) == '-') goto L38;
        return false;
    L38:
        char r26 = b(this.f12408e);
        char r27 = b(this.f12408e + 1);
        char r28 = b(this.f12408e + 2);
        char r29 = b(this.f12408e + 3);
        char r30 = b(this.f12408e + 5);
        char r31 = b(this.f12408e + 6);
        char r32 = b(this.f12408e + 8);
        char r33 = b(this.f12408e + 9);
        if (c(r26, r27, r28, r29, r30, r31, r32, r33) == true) goto L41;
        return false;
    L41:
        U(r26, r27, r28, r29, r30, r31, r32, r33);
        char r8 = b(this.f12408e + 10);
        if (r8 == 'T') goto L56;
        if (r8 != ' ') goto L48;
        if (r36 == false) goto L56;
    L48:
        if (r8 != '\"') goto L50;
    L53:
        this.o.set(11, 0);
        this.o.set(12, 0);
        this.o.set(13, 0);
        this.o.set(14, 0);
        int r9 = this.f12408e + 10;
        this.f12408e = r9;
        this.f12407d = b(r9);
        this.f12404a = 5;
        return true;
    L50:
        if (r8 == 26) goto L53;
        return false;
    L56:
        if (r10 >= 19) goto L59;
        return false;
    L59:
        if (b(this.f12408e + 13) == ':') goto L62;
        return false;
    L62:
        if (b(this.f12408e + 16) == ':') goto L64;
        return false;
    L64:
        char r11 = b(this.f12408e + 11);
        char r23 = b(this.f12408e + 12);
        char r24 = b(this.f12408e + 14);
        char r25 = b(this.f12408e + 15);
        char r210 = b(this.f12408e + 17);
        char r211 = b(this.f12408e + 18);
        if (d(r11, r23, r24, r25, r210, r211) == true) goto L67;
        return false;
    L67:
        this.o.set(11, ((r11 - '0') * 10) + (r23 - '0'));
        this.o.set(12, ((r24 - '0') * 10) + (r25 - '0'));
        this.o.set(13, ((r210 - '0') * 10) + (r211 - '0'));
        char r12 = b(this.f12408e + 19);
        if (r12 == '.') goto L70;
        this.o.set(14, 0);
        int r13 = this.f12408e + 19;
        this.f12408e = r13;
        this.f12407d = b(r13);
        this.f12404a = 5;
        if (r12 == 'Z') goto L150;
    L154:
        return true;
    L150:
        if (this.o.getTimeZone().getRawOffset() == 0) goto L154;
        String[] r14 = TimeZone.getAvailableIDs(0);
        if (r14.length <= 0) goto L154;
        this.o.setTimeZone(TimeZone.getTimeZone(r14[0]));
        goto L154
    L70:
        if (r10 >= 21) goto L72;
        return false;
    L72:
        char r15 = b(this.f12408e + 20);
        if (r15 >= '0') goto L75;
    L146:
        return false;
    L75:
        if (r15 > '9') goto L146;
        int[] r16 = x;
        int r17 = r16[r15];
        if (r10 <= 21) goto L83;
        char r18 = b(this.f12408e + 21);
        if (r18 < '0') goto L83;
        if (r18 > '9') goto L83;
        r17 = (r17 * 10) + r16[r18];
        int r19 = 2;
    L85:
        if (r19 != 2) goto L91;
        char r20 = b(this.f12408e + 22);
        if (r20 < '0') goto L91;
        if (r20 > '9') goto L91;
        r17 = (r17 * 10) + r16[r20];
        r19 = 3;
    L91:
        this.o.set(14, r17);
        char r21 = b((this.f12408e + 20) + r19);
        if (r21 != '+') goto L94;
    L105:
        char r22 = b(((this.f12408e + 20) + r19) + 1);
        if (r22 < '0') goto L146;
        if (r22 > '1') goto L146;
        char r34 = b(((this.f12408e + 20) + r19) + 2);
        if (r34 < '0') goto L146;
        if (r34 > '9') goto L146;
        char r35 = b(((this.f12408e + 20) + r19) + 3);
        if (r35 == ':') goto L118;
        if (r35 == '0') goto L126;
        int r110 = 3;
    L130:
        int r37 = (((r16[r22] * 10) + r16[r34]) * 3600) * 1000;
        if (r21 != '-') goto L134;
        r37 = -r37;
    L134:
        if (this.o.getTimeZone().getRawOffset() == r37) goto L138;
        String[] r38 = TimeZone.getAvailableIDs(r37);
        if (r38.length <= 0) goto L138;
        this.o.setTimeZone(TimeZone.getTimeZone(r38[0]));
    L138:
        int r39 = r110;
    L139:
        int r40 = (r19 + 20) + r39;
        char r41 = b(this.f12408e + r40);
        if (r41 != 26) goto L142;
    L144:
        int r42 = this.f12408e + r40;
        this.f12408e = r42;
        this.f12407d = b(r42);
        this.f12404a = 5;
        return true;
    L142:
        if (r41 == '\"') goto L144;
        return false;
    L126:
        if (b(((this.f12408e + 20) + r19) + 4) == '0') goto L128;
        return false;
    L128:
        r110 = 5;
        goto L130
    L118:
        if (b(((this.f12408e + 20) + r19) + 4) == '0') goto L121;
        return false;
    L121:
        if (b(((this.f12408e + 20) + r19) + 5) == '0') goto L123;
        return false;
    L123:
        r110 = 6;
        goto L130
    L94:
        if (r21 == '-') goto L105;
        if (r21 == 'Z') goto L99;
        r39 = 0;
        goto L139
    L99:
        if (this.o.getTimeZone().getRawOffset() == 0) goto L103;
        String[] r43 = TimeZone.getAvailableIDs(0);
        if (r43.length <= 0) goto L103;
        this.o.setTimeZone(TimeZone.getTimeZone(r43[0]));
    L103:
        r39 = 1;
    L83:
        r19 = 1;
    L155:
        int r111 = 0;
        if (r36 == false) goto L158;
        return false;
    L158:
        char r44 = b(this.f12408e);
        char r45 = b(this.f12408e + 1);
        char r46 = b(this.f12408e + 2);
        char r47 = b(this.f12408e + 3);
        char r48 = b(this.f12408e + 4);
        char r112 = b(this.f12408e + 5);
        char r113 = b(this.f12408e + 6);
        char r114 = b(this.f12408e + 7);
        if (c(r44, r45, r46, r47, r48, r112, r113, r114) == true) goto L161;
        return false;
    L161:
        U(r44, r45, r46, r47, r48, r112, r113, r114);
        if (r10 == 8) goto L183;
        char r49 = b(this.f12408e + 8);
        char r50 = b(this.f12408e + 9);
        char r51 = b(this.f12408e + 10);
        char r115 = b(this.f12408e + 11);
        char r116 = b(this.f12408e + 12);
        char r117 = b(this.f12408e + 13);
        if (d(r49, r50, r51, r115, r116, r117) == true) goto L167;
        return false;
    L167:
        if (r10 != 17) goto L181;
        char r52 = b(this.f12408e + 14);
        char r53 = b(this.f12408e + 15);
        char r54 = b(this.f12408e + 16);
        char r55 = '0';
        if (r52 >= '0') goto L171;
    L180:
        return false;
    L171:
        if (r52 > '9') goto L180;
        if (r53 < '0') goto L180;
        if (r53 > '9') goto L180;
        if (r54 < '0') goto L180;
        if (r54 > '9') goto L180;
        int r56 = (((r52 - '0') * 100) + ((r53 - '0') * 10)) + (r54 - '0');
    L182:
        int r57 = ((r116 - '0') * 10) + (r117 - '0');
        r111 = ((r51 - r55) * 10) + (r115 - r55);
        int r310 = r56;
        int r58 = ((r49 - r55) * 10) + (r50 - r55);
        int r59 = r310;
    L184:
        this.o.set(11, r58);
        this.o.set(12, r111);
        this.o.set(13, r57);
        this.o.set(14, r59);
        this.f12404a = 5;
        return true;
    L181:
        r55 = '0';
        r56 = 0;
        goto L182
    L183:
        r59 = 0;
        r57 = 0;
        r58 = 0;
        goto L184
    }

    public final long M() {
        boolean r0 = false;
        this.f12414k = 0;
        if (this.f12407d != '-') goto L9;
        this.f12414k = 0 + 1;
        int r3 = this.f12408e + 1;
        this.f12408e = r3;
        if (r3 >= this.r) goto L8;
        this.f12407d = this.q.charAt(r3);
        long r4 = Long.MIN_VALUE;
        r0 = true;
    L10:
        long r5 = 0;
    L11:
        char r1 = this.f12407d;
        if (r1 < '0') goto L28;
        if (r1 > '9') goto L28;
        int r2 = r1 - '0';
        if (r5 < (-922337203685477580L)) goto L27;
        long r6 = r5 * 10;
        long r10 = r2;
        if (r6 < (r4 + r10)) goto L25;
        r5 = r6 - r10;
        this.f12414k++;
        int r7 = this.f12408e + 1;
        this.f12408e = r7;
        if (r7 < this.r) goto L22;
        char r8 = 26;
    L23:
        this.f12407d = r8;
        goto L11
    L22:
        r8 = this.q.charAt(r7);
        goto L23
    L25:
        throw new d.a.a.d("error long value, " + r6 + ", " + i());
    L27:
        throw new d.a.a.d("error long value, " + r5 + ", " + i());
    L28:
        if (r0 == false) goto L30;
        return r5;
    L30:
        return -r5;
    L8:
        throw new d.a.a.d("syntax error, " + i());
    L9:
        r4 = -9223372036854775807L;
        goto L10
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003c -> B:6:0x001c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x00fd -> B:59:0x00e1). Please report as a decompilation issue!!! */
    public final void N() {
        int r0 = this.f12408e;
        this.f12414k = r0;
        this.f12412i = false;
        if (this.f12407d != '-') goto L9;
        this.f12411h++;
        int r1 = r0 + 1;
        this.f12408e = r1;
        if (r1 < this.r) goto L78;
    L8:
        this.f12407d = 26;
    L78:
        this.f12407d = this.q.charAt(r1);
    L9:
        char r2 = this.f12407d;
        if (r2 < '0') goto L15;
        if (r2 > '9') goto L15;
        this.f12411h++;
        r1 = this.f12408e + 1;
        this.f12408e = r1;
        if (r1 < this.r) goto L78;
    L15:
        this.f12413j = false;
        if (r2 != '.') goto L30;
        this.f12411h++;
        int r3 = this.f12408e + 1;
        this.f12408e = r3;
        if (r3 < this.r) goto L20;
        char r4 = 26;
    L21:
        this.f12407d = r4;
        this.f12413j = true;
    L22:
        char r5 = this.f12407d;
        if (r5 < '0') goto L30;
        if (r5 > '9') goto L30;
        this.f12411h++;
        int r6 = this.f12408e + 1;
        this.f12408e = r6;
        if (r6 < this.r) goto L28;
        char r7 = 26;
    L29:
        this.f12407d = r7;
        goto L22
    L28:
        r7 = this.q.charAt(r6);
        goto L29
    L20:
        r4 = this.q.charAt(r3);
    L30:
        char r8 = this.f12407d;
        if (r8 != 'L') goto L34;
    L32:
        this.f12411h++;
        q();
    L73:
        if (this.f12413j == false) goto L75;
        int r9 = 3;
    L76:
        this.f12404a = r9;
        return;
    L75:
        r9 = 2;
        goto L76
    L34:
        if (r8 == 'S') goto L32;
        if (r8 == 'B') goto L32;
        if (r8 != 'F') goto L44;
    L41:
        this.f12411h++;
        q();
    L42:
        this.f12413j = true;
        goto L73
    L44:
        if (r8 == 'D') goto L41;
        if (r8 != 'e') goto L49;
    L50:
        this.f12411h++;
        int r10 = this.f12408e + 1;
        this.f12408e = r10;
        if (r10 < this.r) goto L53;
        char r11 = 26;
    L54:
        this.f12407d = r11;
        if (r11 == '+') goto L57;
        if (r11 == '-') goto L57;
    L62:
        char r12 = this.f12407d;
        if (r12 < '0') goto L68;
        if (r12 > '9') goto L68;
        this.f12411h++;
        int r13 = this.f12408e + 1;
        this.f12408e = r13;
        if (r13 >= this.r) goto L59;
    L60:
        char r14 = this.q.charAt(r13);
    L61:
        this.f12407d = r14;
    L59:
        r14 = 26;
    L68:
        if (r12 == 'D') goto L70;
        if (r12 == 'F') goto L70;
    L71:
        this.f12412i = true;
    L70:
        this.f12411h++;
        q();
    L57:
        this.f12411h++;
        int r15 = this.f12408e + 1;
        this.f12408e = r15;
        if (r15 < this.r) goto L60;
        r14 = this.q.charAt(r15);
        goto L61
    L53:
        r11 = this.q.charAt(r10);
        goto L54
    L49:
        if (r8 != 'E') goto L73;
        goto L50
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0102 -> B:46:0x00e5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0160 -> B:71:0x0143). Please report as a decompilation issue!!! */
    public final Number O() {
        int r0 = this.f12408e;
        this.f12414k = 0;
        if (this.f12407d != '-') goto L9;
        long r7 = Long.MIN_VALUE;
        this.f12414k = 0 + 1;
        int r3 = r0 + 1;
        this.f12408e = r3;
        if (r3 < this.r) goto L7;
        char r4 = 26;
    L8:
        this.f12407d = r4;
        boolean r5 = true;
    L10:
        long r9 = 0;
        boolean r11 = false;
    L11:
        char r12 = this.f12407d;
        if (r12 < '0') goto L25;
        if (r12 > '9') goto L25;
        int r13 = r12 - '0';
        if (r9 >= (-922337203685477580L)) goto L17;
        r11 = true;
    L17:
        long r10 = r9 * 10;
        long r14 = r13;
        if (r10 >= (r7 + r14)) goto L20;
        r11 = true;
    L20:
        r9 = r10 - r14;
        this.f12414k++;
        int r15 = this.f12408e + 1;
        this.f12408e = r15;
        if (r15 < this.r) goto L23;
        char r16 = 26;
    L24:
        this.f12407d = r16;
        goto L11
    L23:
        r16 = this.q.charAt(r15);
    L25:
        if (r5 == true) goto L28;
        r9 = -r9;
    L28:
        if (r12 != 'L') goto L32;
        this.f12414k++;
        q();
        Number r8 = Long.valueOf(r9);
    L30:
        Number r2 = r8;
    L43:
        if (this.f12407d != '.') goto L55;
        this.f12414k++;
        int r6 = this.f12408e + 1;
        this.f12408e = r6;
        if (r6 < this.r) goto L47;
    L46:
        char r17 = 26;
    L48:
        this.f12407d = r17;
        char r18 = this.f12407d;
        if (r18 < '0') goto L54;
        if (r18 > '9') goto L54;
        this.f12414k++;
        int r19 = this.f12408e + 1;
        this.f12408e = r19;
        if (r19 >= this.r) goto L46;
    L47:
        r17 = this.q.charAt(r19);
    L54:
        boolean r20 = true;
    L56:
        char r21 = this.f12407d;
        if (r21 != 'e') goto L59;
    L62:
        this.f12414k++;
        int r22 = this.f12408e + 1;
        this.f12408e = r22;
        if (r22 < this.r) goto L65;
        char r23 = 26;
    L66:
        this.f12407d = r23;
        if (r23 == '+') goto L69;
        if (r23 == '-') goto L69;
    L74:
        char r24 = this.f12407d;
        if (r24 < '0') goto L80;
        if (r24 > '9') goto L80;
        this.f12414k++;
        int r25 = this.f12408e + 1;
        this.f12408e = r25;
        if (r25 >= this.r) goto L71;
    L72:
        char r26 = this.q.charAt(r25);
    L73:
        this.f12407d = r26;
    L71:
        r26 = 26;
    L80:
        if (r24 != 'D') goto L82;
    L85:
        this.f12414k++;
        q();
    L86:
        boolean r27 = true;
    L87:
        if (r20 == true) goto L99;
        if (r27 == true) goto L99;
        if (r11 == false) goto L91;
        int r28 = this.f12408e;
        char[] r29 = new char[r28 - r0];
        this.q.getChars(r0, r28, r29, 0);
        r2 = new BigInteger(new String(r29));
    L91:
        if (r2 == null) goto L93;
        return r2;
    L93:
        if (r9 <= (-2147483648L)) goto L98;
        if (r9 >= 2147483647L) goto L98;
        return Integer.valueOf((int) r9);
    L98:
        return Long.valueOf(r9);
    L99:
        int r30 = this.f12408e - r0;
        if (r24 == 0) goto L102;
        r30 = r30 - 1;
    L102:
        char[] r31 = this.f12410g;
        if (r30 >= r31.length) goto L105;
        int r32 = 0;
        this.q.getChars(r0, r0 + r30, r31, 0);
        char[] r1 = this.f12410g;
    L106:
        if (r27 == true) goto L150;
        if ((this.f12406c & d.n.f12403f) == 0) goto L150;
        return new BigDecimal(r1, r32, r30);
    L150:
        if (r30 > 9) goto L140;
        if (r27 == true) goto L140;
        char r33 = r1[r32];     // Catch: NumberFormatException -> L147
        if (r33 == '-') goto L118;
        if (r33 == '+') goto L118;
        int r34 = 1;
    L119:
        int r35 = r33 - '0';     // Catch: NumberFormatException -> L147
        int r36 = 0;
    L120:
        if (r34 >= r30) goto L129;
        char r37 = r1[r34];     // Catch: NumberFormatException -> L147
        if (r37 != '.') goto L124;
        r36 = 1;
    L127:
        r34 = r34 + 1;     // Catch: NumberFormatException -> L147
        goto L120
    L124:
        r35 = (r35 * 10) + (r37 - '0');     // Catch: NumberFormatException -> L147
        if (r36 == 0) goto L127;
        r36 = r36 * 10;     // Catch: NumberFormatException -> L147
        goto L127
    L129:
        if (r24 != 'F') goto L135;
        float r38 = r35 / r36;     // Catch: NumberFormatException -> L147
        if (r5 == false) goto L134;
        r38 = -r38;
    L134:
        return Float.valueOf(r38);
    L135:
        double r39 = ((double) r35) / ((double) r36);     // Catch: NumberFormatException -> L147
        if (r5 == 0) goto L139;
        r39 = -r39;
    L139:
        return Double.valueOf(r39);
    L118:
        r34 = 2;
        r33 = r1[1];     // Catch: NumberFormatException -> L147
    L140:
        String r40 = new String(r1, 0, r30);     // Catch: NumberFormatException -> L147
        if (r24 != 'F') goto L144;
        Number r41 = Float.valueOf(r40);     // Catch: NumberFormatException -> L147
    L167:
        return r41;
    L144:
        r41 = Double.valueOf(Double.parseDouble(r40));     // Catch: NumberFormatException -> L147
    L147:
        e = move-exception;
        throw new d.a.a.d(e.getMessage() + ", " + i(), e);
    L105:
        r32 = 0;
        char[] r42 = new char[r30];
        this.q.getChars(r0, r0 + r30, r42, 0);
        r1 = r42;
        goto L106
    L82:
        if (r24 == 'F') goto L85;
        r24 = 0;
    L69:
        this.f12414k++;
        int r43 = this.f12408e + 1;
        this.f12408e = r43;
        if (r43 < this.r) goto L72;
        r26 = this.q.charAt(r43);
        goto L73
    L65:
        r23 = this.q.charAt(r22);
        goto L66
    L59:
        if (r21 == 'E') goto L62;
        r24 = 0;
        r27 = false;
        goto L87
    L151:
        r17 = this.q.charAt(r6);
        goto L48
    L55:
        r20 = false;
        goto L56
    L32:
        if (r12 != 'S') goto L35;
        this.f12414k++;
        q();
        r8 = Short.valueOf((short) r9);
        goto L30
    L35:
        if (r12 != 'B') goto L37;
        this.f12414k++;
        q();
        r8 = Byte.valueOf((byte) r9);
        goto L30
    L37:
        if (r12 != 'F') goto L39;
        this.f12414k++;
        q();
        r8 = Float.valueOf(r9);
        goto L30
    L39:
        if (r12 != 'D') goto L41;
        this.f12414k++;
        q();
        r2 = Double.valueOf(r9);
        goto L43
    L41:
        r2 = null;
        goto L43
    L7:
        r4 = this.q.charAt(r3);
        goto L8
    L9:
        r7 = -9223372036854775807L;
        r5 = false;
        goto L10
    }

    public final void P() {
        char r0 = this.f12407d;
        int r1 = this.f12408e + 1;
        int r3 = this.q.indexOf(r0, r1);
        if (r3 == (-1)) goto L37;
        int r2 = r3 - r1;
        char[] r4 = Z(this.f12408e + 1, r2);
        int r5 = 0;
        boolean r6 = false;
    L6:
        if (r2 <= 0) goto L24;
        if (r4[r2 - 1] != '\\') goto L24;
        int r8 = r2 - 2;
        int r9 = 1;
    L10:
        if (r8 < 0) goto L15;
        if (r4[r8] != '\\') goto L15;
        r9 = r9 + 1;
        r8 = r8 - 1;
    L15:
        if ((r9 % 2) == 0) goto L24;
        int r7 = this.q.indexOf(r0, r3 + 1);
        int r10 = (r7 - r3) + r2;
        if (r10 < r4.length) goto L23;
        int r11 = (r4.length * 3) / 2;
        if (r11 >= r10) goto L22;
        r11 = r10;
    L22:
        char[] r12 = new char[r11];
        System.arraycopy(r4, 0, r12, 0, r4.length);
        r4 = r12;
    L23:
        this.q.getChars(r3, r7, r4, r2);
        r3 = r7;
        r2 = r10;
        r6 = true;
    L24:
        if (r6 == true) goto L30;
    L25:
        if (r5 >= r2) goto L30;
        if (r4[r5] != '\\') goto L29;
        r6 = true;
    L29:
        r5 = r5 + 1;
    L30:
        this.f12410g = r4;
        this.f12411h = r2;
        this.f12414k = this.f12408e;
        this.f12415l = r6;
        int r13 = r3 + 1;
        this.f12408e = r13;
        if (r13 < this.r) goto L33;
        char r14 = 26;
    L34:
        this.f12407d = r14;
        this.f12404a = 4;
        return;
    L33:
        r14 = this.q.charAt(r13);
        goto L34
    L37:
        throw new d.a.a.d("unclosed str, " + i());
    }

    public String Q(char r8) {
        int r0 = this.f12408e + 1;
        int r1 = this.q.indexOf(r8, r0);
        if (r1 == (-1)) goto L26;
        if (v == false) goto L7;
        String r3 = this.q.substring(r0, r1);
    L9:
        if (r3.indexOf(92) == (-1)) goto L19;
    L10:
        int r2 = r1 - 1;
        int r4 = 0;
    L11:
        if (r2 < 0) goto L16;
        if (this.q.charAt(r2) != '\\') goto L16;
        r4 = r4 + 1;
        r2 = r2 - 1;
    L16:
        if ((r4 % 2) == 0) goto L17;
        r1 = this.q.indexOf(r8, r1 + 1);
        goto L10
    L17:
        int r9 = r1 - r0;
        r3 = w(Z(this.f12408e + 1, r9), r9);
    L19:
        int r5 = r1 + 1;
        this.f12408e = r5;
        if (r5 < this.r) goto L22;
        char r10 = 26;
    L23:
        this.f12407d = r10;
        return r3;
    L22:
        r10 = this.q.charAt(r5);
        goto L23
    L7:
        int r6 = r1 - r0;
        r3 = new String(Z(this.f12408e + 1, r6), 0, r6);
        goto L9
    L26:
        throw new d.a.a.d("unclosed str, " + i());
    }

    public final String R(o r5) {
    L2:
        char r0 = this.f12407d;
        if (r0 == ' ') goto L37;
        if (r0 == '\n') goto L37;
        if (r0 == '\r') goto L37;
        if (r0 == '\t') goto L37;
        if (r0 == '\f') goto L37;
        if (r0 == '\b') goto L37;
        if (r0 != '\"') goto L20;
        return S(r5, '\"');
    L20:
        if (r0 != '\'') goto L24;
        return S(r5, '\'');
    L24:
        if (r0 != '}') goto L28;
        q();
        this.f12404a = 13;
        return null;
    L28:
        if (r0 != ',') goto L32;
        q();
        this.f12404a = 16;
        return null;
    L32:
        if (r0 != 26) goto L36;
        this.f12404a = 20;
        return null;
    L36:
        return T(r5);
    L37:
        q();
        goto L2
    }

    public String S(o r11, char r12) {
        int r0 = this.f12408e + 1;
        int r2 = this.q.indexOf(r12, r0);
        if (r2 == (-1)) goto L45;
        int r1 = r2 - r0;
        char[] r3 = Z(this.f12408e + 1, r1);
        boolean r5 = false;
    L6:
        if (r1 <= 0) goto L24;
        if (r3[r1 - 1] != '\\') goto L24;
        int r7 = r1 - 2;
        int r8 = 1;
    L10:
        if (r7 < 0) goto L15;
        if (r3[r7] != '\\') goto L15;
        r8 = r8 + 1;
        r7 = r7 - 1;
    L15:
        if ((r8 % 2) == 0) goto L24;
        int r6 = this.q.indexOf(r12, r2 + 1);
        int r9 = (r6 - r2) + r1;
        if (r9 < r3.length) goto L23;
        int r10 = (r3.length * 3) / 2;
        if (r10 >= r9) goto L22;
        r10 = r9;
    L22:
        char[] r13 = new char[r10];
        System.arraycopy(r3, 0, r13, 0, r3.length);
        r3 = r13;
    L23:
        this.q.getChars(r2, r6, r3, r1);
        r2 = r6;
        r1 = r9;
        r5 = true;
    L24:
        if (r5 == true) goto L37;
        int r14 = 0;
        int r15 = 0;
    L26:
        if (r14 >= r1) goto L31;
        char r16 = r3[r14];
        r15 = (r15 * 31) + r16;
        if (r16 != '\\') goto L30;
        r5 = true;
    L30:
        r14 = r14 + 1;
        goto L26
    L31:
        if (r5 == true) goto L37;
        if (r1 >= 20) goto L36;
        String r17 = r11.b(r3, 0, r1, r15);
    L38:
        int r4 = r2 + 1;
        this.f12408e = r4;
        if (r4 < this.r) goto L41;
        char r18 = 26;
    L42:
        this.f12407d = r18;
        return r17;
    L41:
        r18 = this.q.charAt(r4);
        goto L42
    L36:
        r17 = new String(r3, 0, r1);
    L37:
        r17 = w(r3, r1);
        goto L38
    L45:
        throw new d.a.a.d("unclosed str, " + i());
    }

    public final String T(o r6) {
        int r0 = this.f12407d;
        boolean[] r1 = A;
        if (r0 < r1.length) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L25;
        this.f12414k = this.f12408e;
        this.f12411h = 1;
    L11:
        char r3 = q();
        boolean[] r4 = B;
        if (r3 >= r4.length) goto L23;
        if (r4[r3] == true) goto L23;
        this.f12407d = b(this.f12408e);
        this.f12404a = 18;
        if (this.f12411h != 4) goto L22;
        if (this.q.startsWith("null", this.f12414k) == false) goto L22;
        return null;
    L22:
        return r6.a(this.q, this.f12414k, this.f12411h, r0);
    L23:
        r0 = (r0 * 31) + r3;
        this.f12411h++;
        goto L11
    L25:
        throw new d.a.a.d("illegal identifier : " + this.f12407d + ", " + i());
    L5:
        if (r1[r0] == true) goto L8;
        r2 = false;
        goto L9
    }

    protected void V() {
        q();
        char r0 = this.f12407d;
        if (r0 != '/') goto L9;
    L4:
        q();
        if (this.f12407d != '\n') goto L4;
        q();
        return;
    L9:
        if (r0 != '*') goto L19;
    L10:
        q();
    L11:
        char r1 = this.f12407d;
        if (r1 == 26) goto L26;
        if (r1 != '*') goto L10;
        q();
        if (this.f12407d != '/') goto L11;
        q();
        return;
    L26:
        return;
    L19:
        throw new d.a.a.d("invalid comment");
    }

    final void W() {
    L2:
        char r0 = this.f12407d;
        if (r0 > '/') goto L20;
        if (r0 == ' ') goto L19;
        if (r0 == '\r') goto L19;
        if (r0 == '\n') goto L19;
        if (r0 == '\t') goto L19;
        if (r0 == '\f') goto L19;
        if (r0 == '\b') goto L19;
        if (r0 != '/') goto L33;
        V();
        goto L2
    L33:
        return;
    L19:
        q();
        goto L2
    }

    public final String X() {
        if (this.f12415l == false) goto L6;
        return w(this.f12410g, this.f12411h);
    L6:
        return Y(this.f12414k + 1, this.f12411h);
    }

    final char[] Z(int r4, int r5) {
        char[] r0 = this.f12410g;
        if (r5 >= r0.length) goto L6;
        this.q.getChars(r4, r5 + r4, r0, 0);
        return this.f12410g;
    L6:
        char[] r1 = new char[r5];
        this.f12410g = r1;
        this.q.getChars(r4, r5 + r4, r1, 0);
        return r1;
    }

    public byte[] a() {
        return h(this.q, this.f12414k + 1, this.f12411h);
    }

    public final int a0() {
        return this.f12404a;
    }

    protected char b(int r2) {
        if (r2 < this.r) goto L6;
        return 26;
    L6:
        return this.q.charAt(r2);
    }

    public void e() {
        char[] r0 = this.f12410g;
        if (r0.length > 8196) goto L5;
        w.set(r0);
    L5:
        this.f12410g = null;
    }

    public final Number f(boolean r9) {
        int r0 = (this.f12414k + this.f12411h) - 1;
        if (r0 < this.r) goto L5;
        char r1 = 26;
    L62:
        if (r1 != 'F') goto L13;
        return Float.valueOf(Float.parseFloat(v()));
    L13:
        if (r1 == 'D') goto L15;
        if (r9 == true) goto L18;
        char r10 = this.q.charAt((this.f12414k + this.f12411h) - 1);     // Catch: NumberFormatException -> L10
        int r2 = this.f12411h;     // Catch: NumberFormatException -> L10
        if (r10 != 'L') goto L22;
    L27:
        r2 = r2 - 1;     // Catch: NumberFormatException -> L10
    L28:
        int r11 = this.f12414k;     // Catch: NumberFormatException -> L10
        char[] r3 = this.f12410g;     // Catch: NumberFormatException -> L10
        int r4 = 0;
        if (r2 >= r3.length) goto L31;
        this.q.getChars(r11, r11 + r2, r3, 0);     // Catch: NumberFormatException -> L10
        char[] r12 = this.f12410g;     // Catch: NumberFormatException -> L10
    L33:
        if (r2 > 9) goto L59;
        if (this.f12412i == true) goto L59;
        char r5 = r12[0];     // Catch: NumberFormatException -> L10
        int r6 = 2;
        if (r5 != '-') goto L40;
        r5 = r12[1];     // Catch: NumberFormatException -> L10
        boolean r7 = true;
    L44:
        int r8 = r5 - '0';     // Catch: NumberFormatException -> L10
    L45:
        if (r6 >= r2) goto L53;
        char r13 = r12[r6];     // Catch: NumberFormatException -> L10
        if (r13 != '.') goto L49;
        r4 = 1;
    L52:
        r6 = r6 + 1;     // Catch: NumberFormatException -> L10
        goto L45
    L49:
        r8 = (r8 * 10) + (r13 - '0');     // Catch: NumberFormatException -> L10
        if (r4 == 0) goto L52;
        r4 = r4 * 10;     // Catch: NumberFormatException -> L10
        goto L52
    L53:
        double r14 = ((double) r8) / ((double) r4);     // Catch: NumberFormatException -> L10
        if (r7 == false) goto L57;
        r14 = -r14;
    L57:
        return Double.valueOf(r14);
    L40:
        if (r5 != '+') goto L42;
        r5 = r12[1];     // Catch: NumberFormatException -> L10
    L43:
        r7 = false;
        goto L44
    L42:
        r6 = 1;
    L59:
        return Double.valueOf(Double.parseDouble(new String(r12, 0, r2)));
    L31:
        char[] r15 = new char[r2];     // Catch: NumberFormatException -> L10
        this.q.getChars(r11, r11 + r2, r15, 0);     // Catch: NumberFormatException -> L10
        r12 = r15;
        goto L33
    L22:
        if (r10 == 'S') goto L27;
        if (r10 == 'B') goto L27;
        if (r10 == 'F') goto L27;
        if (r10 != 'D') goto L28;
    L18:
        return g();
    L15:
        return Double.valueOf(Double.parseDouble(v()));
    L10:
        e = move-exception;
        throw new d.a.a.d(e.getMessage() + ", " + i());
    L5:
        r1 = this.q.charAt(r0);
        goto L62
    }

    public final BigDecimal g() {
        char r0 = this.q.charAt((this.f12414k + this.f12411h) - 1);
        int r1 = this.f12411h;
        if (r0 != 'L') goto L5;
    L12:
        r1 = r1 - 1;
    L13:
        int r2 = this.f12414k;
        char[] r3 = this.f12410g;
        if (r1 >= r3.length) goto L17;
        this.q.getChars(r2, r2 + r1, r3, 0);
        return new BigDecimal(this.f12410g, 0, r1);
    L17:
        char[] r4 = new char[r1];
        this.q.getChars(r2, r1 + r2, r4, 0);
        return new BigDecimal(r4);
    L5:
        if (r0 == 'S') goto L12;
        if (r0 == 'B') goto L12;
        if (r0 == 'F') goto L12;
        if (r0 != 'D') goto L13;
        goto L12
    }

    public String i() {
        StringBuilder r0 = new StringBuilder();
        r0.append("pos ");
        r0.append(this.f12408e);
        r0.append(", json : ");
        int r1 = this.r;
        String r3 = this.q;
        if (r1 < 65536) goto L6;
        r3 = r3.substring(0, 65536);
    L6:
        r0.append(r3);
        return r0.toString();
    }

    public final int j() {
        int r0 = this.f12414k;
        int r1 = this.f12411h + r0;
        if (r0 < this.r) goto L5;
        char r2 = 26;
    L6:
        int r5 = 0;
        if (r2 != '-') goto L9;
        int r3 = Integer.MIN_VALUE;
        r0 = r0 + 1;
        boolean r4 = true;
    L10:
        if (r0 >= r1) goto L16;
        int r6 = r0 + 1;
        if (r0 < this.r) goto L14;
        char r7 = 26;
    L15:
        r5 = -(r7 - '0');
        r0 = r6;
        goto L16
    L14:
        r7 = this.q.charAt(r0);
    L16:
        if (r0 >= r1) goto L38;
        int r8 = r0 + 1;
        if (r0 < this.r) goto L20;
        char r9 = 26;
    L22:
        if (r9 == 'L') goto L37;
        if (r9 == 'S') goto L37;
        if (r9 == 'B') goto L37;
        int r10 = r9 - '0';
        if (r5 < (-214748364)) goto L36;
        int r11 = r5 * 10;
        if (r11 < (r3 + r10)) goto L34;
        r5 = r11 - r10;
        r0 = r8;
        goto L16
    L34:
        throw new NumberFormatException(v());
    L36:
        throw new NumberFormatException(v());
    L37:
        r0 = r8;
        goto L38
    L20:
        r9 = this.q.charAt(r0);
    L38:
        if (r4 == false) goto L45;
        if (r0 <= (this.f12414k + 1)) goto L43;
        return r5;
    L43:
        throw new NumberFormatException(v());
    L45:
        return -r5;
    L9:
        r3 = -2147483647;
        r4 = false;
        goto L10
    L5:
        r2 = this.q.charAt(r0);
        goto L6
    }

    public final Number k() {
        int r1 = this.f12414k;
        int r2 = this.f12411h + r1;
        int r3 = r2 - 1;
        if (r3 < this.r) goto L5;
        char r4 = 26;
    L7:
        if (r4 == 'B') goto L13;
        if (r4 == 'L') goto L12;
        if (r4 == 'S') goto L11;
        char r5 = ' ';
    L14:
        int r8 = this.f12414k;
        if (r8 < this.r) goto L17;
        char r9 = 26;
    L19:
        if (r9 != '-') goto L21;
        long r10 = Long.MIN_VALUE;
        r1 = r1 + 1;
        boolean r11 = true;
    L22:
        if (r1 >= r2) goto L28;
        int r12 = r1 + 1;
        if (r1 < this.r) goto L26;
        char r6 = 26;
    L27:
        long r13 = -(r6 - '0');
        r1 = r12;
    L29:
        if (r1 >= r2) goto L43;
        int r14 = r1 + 1;
        if (r1 < this.r) goto L33;
        char r7 = 26;
    L34:
        int r15 = r7 - '0';
        if (r13 < (-922337203685477580L)) goto L37;
        long r16 = r13 * 10;
        long r17 = r15;
        if (r16 < (r10 + r17)) goto L41;
        r13 = r16 - r17;
        r1 = r14;
        goto L29
    L41:
        return new BigInteger(v());
    L37:
        return new BigInteger(v());
    L33:
        r7 = this.q.charAt(r1);
        goto L34
    L43:
        if (r11 == true) goto L45;
        long r0 = -r13;
        if (r0 > 2147483647L) goto L76;
        if (r5 == 'L') goto L76;
        int r18 = (int) r0;
        if (r5 == 'S') goto L69;
        if (r5 != 'B') goto L74;
        return Byte.valueOf((byte) r18);
    L74:
        return Integer.valueOf(r18);
    L69:
        return Short.valueOf((short) r18);
    L76:
        return Long.valueOf(r0);
    L45:
        if (r1 <= (this.f12414k + 1)) goto L62;
        if (r13 < (-2147483648L)) goto L60;
        if (r5 == 'L') goto L60;
        if (r5 == 'S') goto L52;
        int r19 = (int) r13;
        if (r5 != 'B') goto L58;
        return Byte.valueOf((byte) r19);
    L58:
        return Integer.valueOf(r19);
    L52:
        return Short.valueOf((short) r13);
    L60:
        return Long.valueOf(r13);
    L62:
        throw new NumberFormatException(v());
    L26:
        r6 = this.q.charAt(r1);
        goto L27
    L28:
        r13 = 0;
        goto L29
    L21:
        r10 = -9223372036854775807L;
        r11 = false;
        goto L22
    L17:
        r9 = this.q.charAt(r8);
        goto L19
    L11:
        r2 = r2 - 1;
        r5 = 'S';
        goto L14
    L12:
        r2 = r2 - 1;
        r5 = 'L';
        goto L14
    L13:
        r2 = r2 - 1;
        r5 = 'B';
        goto L14
    L5:
        r4 = this.q.charAt(r3);
        goto L7
    }

    public final boolean l() {
        int r1 = 0;
    L3:
        char r2 = b(r1);
        boolean r4 = true;
        if (r2 == 26) goto L5;
        if (r2 > ' ') goto L20;
        if (r2 != ' ') goto L10;
    L21:
        if (r4 == false) goto L22;
        r1 = r1 + 1;
        goto L3
    L22:
        return false;
    L10:
        if (r2 == '\n') goto L21;
        if (r2 == '\r') goto L21;
        if (r2 == '\t') goto L21;
        if (r2 == '\f') goto L21;
        if (r2 == '\b') goto L21;
    L20:
        r4 = false;
        goto L21
    L5:
        return true;
    }

    public final boolean m(d r1) {
        if ((this.f12406c & r1.f12403f) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005d -> B:8:0x0026). Please report as a decompilation issue!!! */
    public final long n() {
        int r0 = this.f12414k;
        int r1 = this.f12411h + r0;
        if (b(r0) != '-') goto L5;
        long r4 = Long.MIN_VALUE;
        r0 = r0 + 1;
        boolean r2 = true;
    L6:
        if (r0 >= r1) goto L9;
        int r6 = r0 + 1;
        long r7 = -(b(r0) - '0');
    L8:
        r0 = r6;
    L10:
        if (r0 >= r1) goto L32;
        r6 = r0 + 1;
        if (r0 < this.r) goto L14;
        char r3 = 26;
    L16:
        if (r3 != 'L') goto L18;
    L31:
        r0 = r6;
        goto L32
    L18:
        if (r3 == 'S') goto L31;
        if (r3 == 'B') goto L31;
        int r5 = r3 - '0';
        if (r7 < (-922337203685477580L)) goto L30;
        long r8 = r7 * 10;
        long r9 = r5;
        if (r8 < (r4 + r9)) goto L28;
        r7 = r8 - r9;
        goto L8
    L28:
        throw new NumberFormatException(v());
    L30:
        throw new NumberFormatException(v());
    L14:
        r3 = this.q.charAt(r0);
    L32:
        if (r2 == false) goto L39;
        if (r0 <= (this.f12414k + 1)) goto L37;
        return r7;
    L37:
        throw new NumberFormatException(v());
    L39:
        return -r7;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = -9223372036854775807L;
        r2 = false;
        goto L6
    }

    public boolean o(long r18) {
        char r1 = this.f12407d;
        int r2 = this.f12408e + 1;
        int r4 = 1;
    L4:
        if (r1 == '\"') goto L8;
        if (r1 == '\'') goto L8;
        if (r1 > ' ') goto L81;
        if (r1 == ' ') goto L76;
        if (r1 == '\n') goto L76;
        if (r1 == '\r') goto L76;
        if (r1 == '\t') goto L76;
        if (r1 == '\f') goto L76;
        if (r1 != '\b') goto L81;
    L76:
        int r5 = r4 + 1;
        int r3 = this.f12408e + r4;
        if (r3 < this.r) goto L79;
        r1 = 26;
    L80:
        r4 = r5;
        goto L4
    L79:
        r1 = this.q.charAt(r3);
    L81:
        this.u = 0;
        this.p = -2;
        return false;
    L8:
        int r6 = r2;
        long r14 = -2128831035;
    L10:
        if (r6 >= this.r) goto L16;
        char r7 = this.q.charAt(r6);
        if (r7 == r1) goto L13;
        r14 = 16777619 * (r14 ^ ((long) r7));
        r6 = r6 + 1;
        goto L10
    L13:
        r4 = r4 + ((r6 - r2) + 1);
    L16:
        if (r14 == r18) goto L19;
        this.p = -2;
        this.u = r14;
        return false;
    L19:
        int r8 = r4 + 1;
        int r9 = this.f12408e + r4;
        if (r9 < this.r) goto L22;
        char r10 = 26;
    L24:
        if (r10 == ':') goto L25;
        if (r10 > ' ') goto L65;
        if (r10 == ' ') goto L59;
        if (r10 == '\n') goto L59;
        if (r10 == '\r') goto L59;
        if (r10 == '\t') goto L59;
        if (r10 == '\f') goto L59;
        if (r10 != '\b') goto L65;
    L59:
        int r11 = r8 + 1;
        int r12 = this.f12408e + r8;
        if (r12 < this.r) goto L62;
        r10 = 26;
    L63:
        r8 = r11;
        goto L24
    L62:
        r10 = this.q.charAt(r12);
    L65:
        throw new d.a.a.d("match feild error expect ':'");
    L25:
        int r13 = this.f12408e + r8;
        if (r13 < this.r) goto L28;
        char r15 = 26;
    L30:
        if (r15 != '{') goto L37;
        int r16 = r13 + 1;
        this.f12408e = r16;
        if (r16 < this.r) goto L34;
        char r17 = 26;
    L35:
        this.f12407d = r17;
        this.f12404a = 12;
    L48:
        return true;
    L34:
        r17 = this.q.charAt(r16);
        goto L35
    L37:
        if (r15 != '[') goto L43;
        int r19 = r13 + 1;
        this.f12408e = r19;
        if (r19 < this.r) goto L41;
        char r110 = 26;
    L42:
        this.f12407d = r110;
        this.f12404a = 14;
        goto L48
    L41:
        r110 = this.q.charAt(r19);
        goto L42
    L43:
        this.f12408e = r13;
        if (r13 < this.r) goto L46;
        char r111 = 26;
    L47:
        this.f12407d = r111;
        s();
        goto L48
    L46:
        r111 = this.q.charAt(r13);
        goto L47
    L28:
        r15 = this.q.charAt(r13);
        goto L30
    L22:
        r10 = this.q.charAt(r9);
        goto L24
    }

    public char q() {
        int r0 = this.f12408e + 1;
        this.f12408e = r0;
        if (r0 < this.r) goto L5;
        char r1 = 26;
    L6:
        this.f12407d = r1;
        return r1;
    L5:
        r1 = this.q.charAt(r0);
        goto L6
    }

    public final void r() {
    L2:
        char r0 = this.f12407d;
        if (r0 > ' ') goto L16;
        if (r0 != ' ') goto L6;
    L15:
        boolean r1 = true;
    L17:
        if (r1 == false) goto L19;
        q();
        goto L2
    L19:
        if (r0 != '_') goto L21;
    L24:
        L();
        return;
    L21:
        if (Character.isLetter(r0) == true) goto L24;
        s();
        return;
    L6:
        if (r0 == '\n') goto L15;
        if (r0 == '\r') goto L15;
        if (r0 == '\t') goto L15;
        if (r0 == '\f') goto L15;
        if (r0 == '\b') goto L15;
    L16:
        r1 = false;
        goto L17
    }

    public final void s() {
        this.f12411h = 0;
    L3:
        int r2 = this.f12408e;
        this.f12405b = r2;
        char r3 = this.f12407d;
        if (r3 == '/') goto L5;
        if (r3 == '\"') goto L8;
        if (r3 < '0') goto L15;
        if (r3 > '9') goto L15;
    L16:
        N();
        return;
    L15:
        if (r3 == '-') goto L16;
        if (r3 == ',') goto L20;
        if (r3 != '\f') goto L25;
    L161:
        q();
        goto L3
    L25:
        if (r3 == '\r') goto L161;
        if (r3 == ' ') goto L161;
        if (r3 == ':') goto L159;
        char r11 = 26;
        if (r3 == '[') goto L153;
        if (r3 == ']') goto L151;
        if (r3 == 'f') goto L134;
        if (r3 == 'n') goto L111;
        if (r3 == '{') goto L104;
        if (r3 == '}') goto L98;
        if (r3 == 'S') goto L96;
        if (r3 == 'T') goto L96;
        if (r3 == 't') goto L79;
        if (r3 == 'u') goto L96;
        switch(r3) {
            case 8: goto L161;
            case 9: goto L161;
            case 10: goto L161;
            default: goto L50;
        };
    L50:
        switch(r3) {
            case 39: goto L76;
            case 40: goto L74;
            case 41: goto L72;
            default: goto L51;
        };
    L51:
        int r1 = this.r;
        if (r2 == r1) goto L58;
        if (r3 == 26) goto L55;
    L57:
        boolean r4 = false;
    L59:
        if (r4 == true) goto L61;
        if (r3 <= 31) goto L161;
        if (r3 == 127) goto L161;
        this.f12404a = 1;
        q();
        return;
    L61:
        if (this.f12404a == 20) goto L64;
        this.f12404a = 20;
        int r5 = this.f12409f;
        this.f12408e = r5;
        this.f12405b = r5;
        return;
    L64:
        throw new d.a.a.d("EOF error");
    L55:
        if ((r2 + 1) != r1) goto L57;
    L58:
        r4 = true;
        goto L59
    L72:
        q();
        this.f12404a = 11;
        return;
    L74:
        q();
        this.f12404a = 10;
        return;
    L76:
        P();
        return;
    L79:
        if (this.q.startsWith("true", r2) == false) goto L95;
        int r6 = this.f12408e + 4;
        this.f12408e = r6;
        char r7 = b(r6);
        this.f12407d = r7;
        if (r7 == ' ') goto L92;
        if (r7 == ',') goto L92;
        if (r7 == '}') goto L92;
        if (r7 == ']') goto L92;
        if (r7 == '\n') goto L92;
        if (r7 == '\r') goto L92;
        if (r7 == '\t') goto L92;
        if (r7 == 26) goto L92;
        if (r7 == '\f') goto L92;
        if (r7 == '\b') goto L92;
        if (r7 != ':') goto L95;
    L92:
        this.f12404a = 6;
        return;
    L95:
        throw new d.a.a.d("scan true error");
    L96:
        L();
        return;
    L98:
        int r8 = r2 + 1;
        this.f12408e = r8;
        if (r8 >= this.r) goto L102;
        r11 = this.q.charAt(r8);
    L102:
        this.f12407d = r11;
        this.f12404a = 13;
        return;
    L104:
        int r9 = r2 + 1;
        this.f12408e = r9;
        if (r9 >= this.r) goto L108;
        r11 = this.q.charAt(r9);
    L108:
        this.f12407d = r11;
        this.f12404a = 12;
        return;
    L111:
        if (this.q.startsWith("null", r2) == false) goto L114;
        this.f12408e += 4;
        int r10 = 8;
    L117:
        if (r10 == 0) goto L132;
        char r12 = b(this.f12408e);
        this.f12407d = r12;
        if (r12 == ' ') goto L129;
        if (r12 == ',') goto L129;
        if (r12 == '}') goto L129;
        if (r12 == ']') goto L129;
        if (r12 == '\n') goto L129;
        if (r12 == '\r') goto L129;
        if (r12 == '\t') goto L129;
        if (r12 == 26) goto L129;
        if (r12 == '\f') goto L129;
        if (r12 != '\b') goto L132;
    L129:
        this.f12404a = r10;
        return;
    L132:
        throw new d.a.a.d("scan null/new error");
    L114:
        if (this.q.startsWith("new", this.f12408e) == false) goto L116;
        this.f12408e += 3;
        r10 = 9;
        goto L117
    L116:
        r10 = 0;
        goto L117
    L134:
        if (this.q.startsWith("false", r2) == false) goto L150;
        int r13 = this.f12408e + 5;
        this.f12408e = r13;
        char r14 = b(r13);
        this.f12407d = r14;
        if (r14 == ' ') goto L147;
        if (r14 == ',') goto L147;
        if (r14 == '}') goto L147;
        if (r14 == ']') goto L147;
        if (r14 == '\n') goto L147;
        if (r14 == '\r') goto L147;
        if (r14 == '\t') goto L147;
        if (r14 == 26) goto L147;
        if (r14 == '\f') goto L147;
        if (r14 == '\b') goto L147;
        if (r14 != ':') goto L150;
    L147:
        this.f12404a = 7;
        return;
    L150:
        throw new d.a.a.d("scan false error");
    L151:
        q();
        this.f12404a = 15;
        return;
    L153:
        int r15 = r2 + 1;
        this.f12408e = r15;
        if (r15 >= this.r) goto L157;
        r11 = this.q.charAt(r15);
    L157:
        this.f12407d = r11;
        this.f12404a = 14;
        return;
    L159:
        q();
        this.f12404a = 17;
        return;
    L20:
        q();
        this.f12404a = 16;
        return;
    L8:
        P();
        return;
    L5:
        V();
        goto L3
    }

    public final void t(int r11) {
        this.f12411h = 0;
    L4:
        if (r11 == 2) goto L88;
        char r9 = 26;
        if (r11 == 4) goto L73;
        if (r11 != 12) goto L9;
        char r0 = this.f12407d;
        if (r0 == '{') goto L60;
        if (r0 == '[') goto L67;
    L102:
        char r1 = this.f12407d;
        if (r1 == ' ') goto L115;
        if (r1 == '\n') goto L115;
        if (r1 == '\r') goto L115;
        if (r1 == '\t') goto L115;
        if (r1 == '\f') goto L115;
        if (r1 == '\b') goto L115;
        s();
        return;
    L115:
        q();
        goto L4
    L67:
        this.f12404a = 14;
        int r12 = this.f12408e + 1;
        this.f12408e = r12;
        if (r12 >= this.r) goto L71;
        r9 = this.q.charAt(r12);
    L71:
        this.f12407d = r9;
        return;
    L60:
        this.f12404a = 12;
        int r13 = this.f12408e + 1;
        this.f12408e = r13;
        if (r13 >= this.r) goto L64;
        r9 = this.q.charAt(r13);
    L64:
        this.f12407d = r9;
        return;
    L9:
        if (r11 == 18) goto L56;
        if (r11 == 20) goto L53;
        switch(r11) {
            case 14: goto L45;
            case 15: goto L42;
            case 16: goto L15;
            default: goto L102;
        };
    L15:
        char r4 = this.f12407d;
        if (r4 == ',') goto L17;
        if (r4 == '}') goto L25;
        if (r4 == ']') goto L32;
        if (r4 != 26) goto L102;
        this.f12404a = 20;
        return;
    L32:
        this.f12404a = 15;
        int r14 = this.f12408e + 1;
        this.f12408e = r14;
        if (r14 >= this.r) goto L36;
        r9 = this.q.charAt(r14);
    L36:
        this.f12407d = r9;
        return;
    L25:
        this.f12404a = 13;
        int r15 = this.f12408e + 1;
        this.f12408e = r15;
        if (r15 >= this.r) goto L29;
        r9 = this.q.charAt(r15);
    L29:
        this.f12407d = r9;
        return;
    L17:
        this.f12404a = 16;
        int r16 = this.f12408e + 1;
        this.f12408e = r16;
        if (r16 >= this.r) goto L21;
        r9 = this.q.charAt(r16);
    L21:
        this.f12407d = r9;
        return;
    L45:
        char r2 = this.f12407d;
        if (r2 == '[') goto L47;
        if (r2 != '{') goto L102;
        this.f12404a = 12;
        q();
        return;
    L47:
        this.f12404a = 14;
        q();
        return;
    L42:
        if (this.f12407d != ']') goto L53;
        this.f12404a = 15;
        q();
        return;
    L53:
        if (this.f12407d != 26) goto L102;
        this.f12404a = 20;
        return;
    L56:
        r();
        return;
    L73:
        char r3 = this.f12407d;
        if (r3 == '\"') goto L75;
        if (r3 < '0') goto L81;
        if (r3 > '9') goto L81;
        this.f12405b = this.f12408e;
        N();
        return;
    L81:
        if (r3 != '{') goto L102;
        this.f12404a = 12;
        int r17 = this.f12408e + 1;
        this.f12408e = r17;
        if (r17 >= this.r) goto L86;
        r9 = this.q.charAt(r17);
    L86:
        this.f12407d = r9;
        return;
    L75:
        this.f12405b = this.f12408e;
        P();
        return;
    L88:
        char r5 = this.f12407d;
        if (r5 < '0') goto L93;
        if (r5 > '9') goto L93;
        this.f12405b = this.f12408e;
        N();
        return;
    L93:
        if (r5 == '\"') goto L94;
        if (r5 == '[') goto L97;
        if (r5 != '{') goto L102;
        this.f12404a = 12;
        q();
        return;
    L97:
        this.f12404a = 14;
        q();
        return;
    L94:
        this.f12405b = this.f12408e;
        P();
    }

    public final void u(char r4) {
        this.f12411h = 0;
    L3:
        char r0 = this.f12407d;
        if (r0 == r4) goto L5;
        if (r0 == ' ') goto L26;
        if (r0 == '\n') goto L26;
        if (r0 == '\r') goto L26;
        if (r0 == '\t') goto L26;
        if (r0 == '\f') goto L26;
        if (r0 == '\b') goto L26;
        throw new d.a.a.d("not match " + r4 + " - " + this.f12407d);
    L26:
        q();
        goto L3
    L5:
        int r5 = this.f12408e + 1;
        this.f12408e = r5;
        if (r5 < this.r) goto L8;
        char r6 = 26;
    L9:
        this.f12407d = r6;
        s();
        return;
    L8:
        r6 = this.q.charAt(r5);
        goto L9
    }

    public final String v() {
        char r0 = this.q.charAt((this.f12414k + this.f12411h) - 1);
        int r1 = this.f12411h;
        if (r0 != 'L') goto L5;
    L12:
        r1 = r1 - 1;
    L14:
        return Y(this.f12414k, r1);
    L5:
        if (r0 == 'S') goto L12;
        if (r0 == 'B') goto L12;
        if (r0 == 'F') goto L12;
        if (r0 != 'D') goto L14;
        goto L12
    }

    public boolean x() {
        boolean r1 = false;
        int r2 = 1;
        if (this.q.startsWith("false", this.f12408e) == false) goto L6;
        r2 = 5;
    L13:
        int r0 = this.f12408e + r2;
        this.f12408e = r0;
        this.f12407d = b(r0);
        return r1;
    L6:
        if (this.q.startsWith("true", this.f12408e) == false) goto L8;
        r1 = true;
        r2 = 4;
        goto L13
    L8:
        char r3 = this.f12407d;
        if (r3 != '1') goto L12;
        r1 = true;
        goto L13
    L12:
        if (r3 == '0') goto L13;
        this.p = -1;
        return false;
    }

    public boolean y(long r11) {
        this.p = 0;
        int r12 = p(r11);
        if (r12 != 0) goto L6;
        return false;
    L6:
        if (this.q.startsWith("false", this.f12408e + r12) == false) goto L10;
        int r13 = r12 + 5;
    L8:
        boolean r14 = false;
    L19:
        int r5 = r13 + 1;
        int r4 = this.f12408e + r13;
        char r6 = 26;
        if (r4 < this.r) goto L22;
        char r15 = 26;
    L24:
        if (r15 != ',') goto L32;
        int r16 = this.f12408e + (r5 - 1);
        this.f12408e = r16;
        int r17 = r16 + 1;
        this.f12408e = r17;
        if (r17 >= this.r) goto L29;
        r6 = this.q.charAt(r17);
    L29:
        this.f12407d = r6;
        this.p = 3;
        this.f12404a = 16;
        return r14;
    L32:
        if (r15 != '}') goto L55;
        int r9 = r5 + 1;
        char r18 = b(this.f12408e + r5);
        if (r18 != ',') goto L41;
        this.f12404a = 16;
        int r19 = this.f12408e + (r9 - 1);
        this.f12408e = r19;
        int r110 = r19 + 1;
        this.f12408e = r110;
        if (r110 >= this.r) goto L39;
    L38:
        r6 = this.q.charAt(r110);
    L39:
        this.f12407d = r6;
        this.p = 4;
        return r14;
    L41:
        if (r18 != ']') goto L45;
        this.f12404a = 15;
        int r111 = this.f12408e + (r9 - 1);
        this.f12408e = r111;
        r110 = r111 + 1;
        this.f12408e = r110;
        if (r110 < this.r) goto L38;
    L45:
        if (r18 != '}') goto L49;
        this.f12404a = 13;
        int r112 = this.f12408e + (r9 - 1);
        this.f12408e = r112;
        r110 = r112 + 1;
        this.f12408e = r110;
        if (r110 < this.r) goto L38;
    L49:
        if (r18 != 26) goto L53;
        this.f12404a = 20;
        this.f12408e += r9 - 1;
        goto L39
    L53:
        this.p = -1;
        return false;
    L55:
        this.p = -1;
        return false;
    L22:
        r15 = this.q.charAt(r4);
        goto L24
    L10:
        if (this.q.startsWith("true", this.f12408e + r12) == false) goto L14;
        r13 = r12 + 4;
    L12:
        r14 = true;
        goto L19
    L14:
        if (this.q.startsWith("\"false\"", this.f12408e + r12) == false) goto L17;
        r13 = r12 + 7;
        goto L8
    L17:
        if (this.q.startsWith("\"true\"", this.f12408e + r12) == false) goto L57;
        r13 = r12 + 6;
        goto L12
    L57:
        this.p = -1;
        return false;
    }

    public final double z(long r19) {
        this.p = 0;
        int r2 = p(r19);
        if (r2 != 0) goto L5;
        return 0.0d;
    L5:
        int r6 = r2 + 1;
        char r3 = b(this.f12408e + r2);
        int r5 = this.f12408e;
        int r7 = (r5 + r6) - 1;
        if (r3 != '-') goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        char r8 = b(r5 + r6);
        r6 = r6 + 1;
        r3 = r8;
    L12:
        if (r3 >= '0') goto L14;
    L88:
        this.p = -1;
        return 0.0d;
    L14:
        if (r3 > '9') goto L88;
        int r4 = r3 - '0';
    L16:
        int r14 = r6 + 1;
        char r9 = b(this.f12408e + r6);
        if (r9 < '0') goto L21;
        if (r9 > '9') goto L21;
        r4 = (r4 * 10) + (r9 - '0');
        r6 = r14;
    L21:
        if (r9 != '.') goto L23;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L37;
        int r15 = r14 + 1;
        char r11 = b(this.f12408e + r14);
        if (r11 < '0') goto L35;
        if (r11 > '9') goto L35;
        r4 = (r4 * 10) + (r11 - '0');
        int r12 = 10;
    L30:
        int r16 = r15 + 1;
        char r17 = b(this.f12408e + r15);
        if (r17 < '0') goto L34;
        if (r17 > '9') goto L34;
        r4 = (r4 * 10) + (r17 - '0');
        r12 = r12 * 10;
        r15 = r16;
    L34:
        r14 = r16;
        int r18 = r12;
        r9 = r17;
    L39:
        if (r9 != 'e') goto L41;
    L44:
        boolean r1 = true;
    L45:
        if (r1 == false) goto L56;
        int r110 = r14 + 1;
        r9 = b(this.f12408e + r14);
        if (r9 == '+') goto L51;
        if (r9 == '-') goto L51;
        r14 = r110;
    L53:
        if (r9 < '0') goto L56;
        if (r9 > '9') goto L56;
        int r20 = r14 + 1;
        r9 = b(this.f12408e + r14);
        r14 = r20;
    L51:
        int r21 = r110 + 1;
        r9 = b(this.f12408e + r110);
        r14 = r21;
    L56:
        int r22 = ((this.f12408e + r14) - r7) - 1;
        if (r1 == true) goto L62;
        if (r22 >= 10) goto L62;
        double r23 = ((double) r4) / ((double) r18);
        if (r10 == false) goto L64;
        r23 = -r23;
    L64:
        if (r9 != ',') goto L68;
        this.f12408e += r14 - 1;
        q();
        this.p = 3;
        this.f12404a = 16;
        return r23;
    L68:
        if (r9 != '}') goto L86;
        int r111 = r14 + 1;
        char r24 = b(this.f12408e + r14);
        if (r24 != ',') goto L74;
        this.f12404a = 16;
    L72:
        this.f12408e += r111 - 1;
        q();
    L82:
        this.p = 4;
        return r23;
    L74:
        if (r24 != ']') goto L77;
        int r25 = 15;
    L76:
        this.f12404a = r25;
        goto L72
    L77:
        if (r24 != '}') goto L80;
        r25 = 13;
        goto L76
    L80:
        if (r24 != 26) goto L84;
        this.f12408e += r111 - 1;
        this.f12404a = 20;
        this.f12407d = 26;
        goto L82
    L84:
        this.p = -1;
        return 0.0d;
    L86:
        this.p = -1;
        return 0.0d;
    L62:
        r23 = Double.parseDouble(Y(r7, r22));
        goto L64
    L41:
        if (r9 == 'E') goto L44;
        r1 = false;
    L35:
        this.p = -1;
        return 0.0d;
    L37:
        r18 = 1;
        goto L39
    L23:
        r13 = false;
        goto L25
    L8:
        r10 = false;
        goto L9
    }
}
