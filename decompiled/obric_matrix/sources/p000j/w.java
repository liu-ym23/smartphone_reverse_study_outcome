package p000j;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import k.e;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final char[] f18199j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f18200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f18203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f18204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f18205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<String> f18206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f18207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f18208i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f18209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f18210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f18211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f18212d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18213e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<String> f18214f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        List<String> f18215g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f18216h;

        public a() {
            this.f18210b = "";
            this.f18211c = "";
            this.f18213e = -1;
            ArrayList r1 = new ArrayList();
            this.f18214f = r1;
            r1.add("");
        }

        private static String c(String r1, int r2, int r3) {
            return c.d(w.t(r1, r2, r3, false));
        }

        private boolean g(String r1) {
            if (r1.equals(".") == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.equalsIgnoreCase("%2e") == true) goto L8;
            return false;
        }

        private boolean h(String r1) {
            if (r1.equals("..") == false) goto L5;
        L12:
            return true;
        L5:
            if (r1.equalsIgnoreCase("%2e.") == true) goto L12;
            if (r1.equalsIgnoreCase(".%2e") == true) goto L12;
            if (r1.equalsIgnoreCase("%2e%2e") == true) goto L12;
            return false;
        }

        private static int j(String r10, int r11, int r12) {
            int r13 = Integer.parseInt(w.a(r10, r11, r12, "", false, false, false, true, null));     // Catch: NumberFormatException -> L9
            if (r13 <= 0) goto L8;
            if (r13 > 65535) goto L8;
            return r13;
        L8:
            return -1;
        }

        private void l() {
            List<String> r0 = this.f18214f;
            if (r0.remove(r0.size() - 1).isEmpty() == true) goto L5;
        L7:
            this.f18214f.add("");
            return;
        L5:
            if (this.f18214f.isEmpty() == true) goto L7;
            List<String> r2 = this.f18214f;
            r2.set(r2.size() - 1, "");
        }

        private static int n(String r2, int r3, int r4) {
        L2:
            if (r3 >= r4) goto L14;
            char r0 = r2.charAt(r3);
            if (r0 == ':') goto L13;
            if (r0 != '[') goto L12;
        L8:
            r3 = r3 + 1;
            if (r3 >= r4) goto L12;
            if (r2.charAt(r3) != ']') goto L8;
        L12:
            r3 = r3 + 1;
            goto L2
        L13:
            return r3;
        L14:
            return r4;
        }

        private void o(String r10, int r11, int r12, boolean r13, boolean r14) {
            String r15 = w.a(r10, r11, r12, " \"<>^`{}|/\\?#", r14, false, false, true, null);
            if (g(r15) == false) goto L6;
            return;
        L6:
            if (h(r15) == false) goto L9;
            l();
            return;
        L9:
            List<String> r16 = this.f18214f;
            if (r16.get(r16.size() - 1).isEmpty() == false) goto L12;
            List<String> r17 = this.f18214f;
            r17.set(r17.size() - 1, r15);
        L13:
            if (r13 == false) goto L16;
            this.f18214f.add("");
            return;
        L16:
            return;
        L12:
            this.f18214f.add(r15);
            goto L13
        }

        private void q(String r11, int r12, int r13) {
            if (r12 != r13) goto L4;
            return;
        L4:
            char r0 = r11.charAt(r12);
            if (r0 != '/') goto L7;
        L10:
            this.f18214f.clear();
            this.f18214f.add("");
            r12 = r12 + 1;
        L11:
            int r6 = r12;
            if (r6 >= r13) goto L20;
            r12 = c.o(r11, r6, r13, "/\\");
            if (r12 >= r13) goto L16;
            boolean r1 = true;
        L17:
            o(r11, r6, r12, r1, true);
            if (r1 == false) goto L11;
            r12 = r12 + 1;
            goto L11
        L16:
            r1 = false;
            goto L17
        L20:
            return;
        L7:
            if (r0 == '\\') goto L10;
            List<String> r2 = this.f18214f;
            r2.set(r2.size() - 1, "");
            goto L11
        }

        private static int s(String r7, int r8, int r9) {
            if ((r9 - r8) >= 2) goto L5;
            return -1;
        L5:
            char r0 = r7.charAt(r8);
            if (r0 < 'a') goto L8;
            if (r0 > 'z') goto L8;
        L11:
            r8 = r8 + 1;
            if (r8 >= r9) goto L32;
            char r1 = r7.charAt(r8);
            if (r1 < 'a') goto L16;
            if (r1 <= 'z') goto L11;
        L16:
            if (r1 < 'A') goto L19;
            if (r1 <= 'Z') goto L11;
        L19:
            if (r1 < '0') goto L23;
            if (r1 <= '9') goto L11;
        L23:
            if (r1 == '+') goto L11;
            if (r1 == '-') goto L11;
            if (r1 == '.') goto L11;
            if (r1 != ':') goto L32;
            return r8;
        L32:
            return -1;
        L8:
            if (r0 < 'A') goto L32;
            if (r0 <= 'Z') goto L11;
            goto L32
        }

        private static boolean t(int r2, String r3) {
            if (r2 >= 2) goto L6;
            return false;
        L6:
            if (p000j.l0.a.k() == true) goto L9;
            return true;
        L9:
            if (TextUtils.isEmpty(r3) == false) goto L11;
        L15:
            return false;
        L11:
            if (r3.startsWith("https://") == false) goto L13;
        L14:
            return true;
        L13:
            if (r3.startsWith("http://") == false) goto L15;
            goto L14
        }

        private static int u(String r3, int r4, int r5) {
            int r0 = 0;
        L3:
            if (r4 >= r5) goto L9;
            char r1 = r3.charAt(r4);
            if (r1 == '\\') goto L8;
            if (r1 != '/') goto L9;
        L8:
            r0 = r0 + 1;
            r4 = r4 + 1;
        L9:
            return r0;
        }

        public a a(String r8, String r9) {
            Objects.requireNonNull(r8, "name == null");
            if (this.f18215g != null) goto L5;
            this.f18215g = new ArrayList();
        L5:
            this.f18215g.add(w.b(r8, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            List<String> r10 = this.f18215g;
            if (r9 == null) goto L8;
            String r11 = w.b(r9, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);
        L9:
            r10.add(r11);
            return this;
        L8:
            r11 = null;
            goto L9
        }

        public w b() {
            if (this.f18209a == null) goto L11;
            if (this.f18212d == null) goto L9;
            return new w(this);
        L9:
            throw new IllegalStateException("host == null");
        L11:
            throw new IllegalStateException("scheme == null");
        }

        int d() {
            int r0 = this.f18213e;
            if (r0 == (-1)) goto L6;
            return r0;
        L6:
            return w.e(this.f18209a);
        }

        public a e(String r7) {
            if (r7 == null) goto L4;
            List<String> r8 = w.A(w.b(r7, " \"'<>#", true, false, true, true));
        L5:
            this.f18215g = r8;
            return this;
        L4:
            r8 = null;
            goto L5
        }

        public a f(String r3) {
            Objects.requireNonNull(r3, "host == null");
            String r0 = c(r3, 0, r3.length());
            if (r0 == null) goto L7;
            this.f18212d = r0;
            return this;
        L7:
            throw new IllegalArgumentException("unexpected host: " + r3);
        }

        a i(w r22, String r23) {
            int r9 = c.E(r23, 0, r23.length());
            int r11 = c.F(r23, r9, r23.length());
            int r12 = s(r23, r9, r11);
            if (r12 != (-1)) goto L5;
            if (r22 == null) goto L76;
            this.f18209a = r22.f18200a;
        L14:
            int r2 = u(r23, r9, r11);
            char r13 = '?';
            char r14 = '#';
            if (t(r2, r23) == true) goto L25;
            if (r22 == null) goto L25;
            if (r22.f18200a.equals(this.f18209a) == false) goto L25;
            this.f18210b = r22.k();
            this.f18211c = r22.g();
            this.f18212d = r22.f18203d;
            this.f18213e = r22.f18204e;
            this.f18214f.clear();
            this.f18214f.addAll(r22.i());
            if (r9 != r11) goto L23;
        L24:
            e(r22.j());
        L63:
            int r1 = c.o(r23, r9, r11, "?#");
            q(r23, r9, r1);
            if (r1 < r11) goto L66;
        L68:
            if (r1 < r11) goto L70;
        L72:
            return this;
        L70:
            if (r23.charAt(r1) != '#') goto L72;
            this.f18216h = w.a(r23, 1 + r1, r11, "", true, false, false, false, null);
            goto L72
        L66:
            if (r23.charAt(r1) != '?') goto L68;
            int r15 = c.n(r23, r1, r11, '#');
            this.f18215g = w.A(w.a(r23, r1 + 1, r15, " \"'<>#", true, false, true, true, null));
            r1 = r15;
            goto L68
        L23:
            if (r23.charAt(r9) != '#') goto L63;
        L25:
            boolean r16 = false;
            boolean r17 = false;
            int r3 = r9 + r2;
        L26:
            int r10 = c.o(r23, r3, r11, "@/\\?#");
            if (r10 == r11) goto L29;
            byte r4 = r23.charAt(r10);
        L30:
            if (r4 == (-1)) goto L52;
            if (r4 == r14) goto L52;
            if (r4 == 47) goto L52;
            if (r4 == 92) goto L52;
            if (r4 == r13) goto L52;
            if (r4 != 64) goto L51;
            if (r16 == true) goto L49;
            int r7 = c.n(r23, r3, r10, ':');
            int r18 = r10;
            String r5 = w.a(r23, r3, r7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            if (r17 == false) goto L45;
            r5 = this.f18210b + "%40" + r5;
        L45:
            this.f18210b = r5;
            if (r7 == r18) goto L48;
            this.f18211c = w.a(r23, r7 + 1, r18, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            r16 = true;
        L48:
            r17 = true;
        L50:
            r3 = r18 + 1;
            goto L51
        L49:
            r18 = r10;
            this.f18211c += "%40" + w.a(r23, r3, r18, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        L51:
            r13 = '?';
            r14 = '#';
        L52:
            int r6 = n(r23, r3, r10);
            int r8 = r6 + 1;
            if (r8 >= r10) goto L59;
            this.f18212d = c(r23, r3, r6);
            int r19 = j(r23, r8, r10);
            this.f18213e = r19;
            if (r19 != (-1)) goto L61;
            throw new IllegalArgumentException("Invalid URL port: \"" + r23.substring(r8, r10) + '\"');
        L61:
            if (this.f18212d == null) goto L74;
            r9 = r10;
            goto L63
        L74:
            throw new IllegalArgumentException("Invalid URL host: \"" + r23.substring(r3, r6) + '\"');
        L59:
            this.f18212d = c(r23, r3, r6);
            this.f18213e = w.e(this.f18209a);
            goto L61
        L29:
            r4 = -1;
            goto L30
        L76:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        L5:
            if (r23.regionMatches(true, r9, "https:", 0, 6) == false) goto L8;
            this.f18209a = LocationInfoConst.HTTPS;
            r9 = r9 + 6;
            goto L14
        L8:
            if (r23.regionMatches(true, r9, "http:", 0, 5) == false) goto L11;
            this.f18209a = "http";
            r9 = r9 + 5;
            goto L14
        L11:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + r23.substring(0, r12) + "'");
        }

        public a k(String r8) {
            Objects.requireNonNull(r8, "password == null");
            this.f18211c = w.b(r8, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a m(int r3) {
            if (r3 <= 0) goto L8;
            if (r3 > 65535) goto L8;
            this.f18213e = r3;
            return this;
        L8:
            throw new IllegalArgumentException("unexpected port: " + r3);
        }

        a p() {
            int r0 = this.f18214f.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            this.f18214f.set(r2, w.b(this.f18214f.get(r2), "[]", true, true, false, true));
            r2 = r2 + 1;
            goto L3
        L5:
            List<String> r3 = this.f18215g;
            if (r3 == null) goto L13;
            int r4 = r3.size();
        L8:
            if (r1 >= r4) goto L13;
            String r5 = this.f18215g.get(r1);
            if (r5 == null) goto L12;
            this.f18215g.set(r1, w.b(r5, "\\^`{|}", true, true, true, true));
        L12:
            r1 = r1 + 1;
        L13:
            String r6 = this.f18216h;
            if (r6 == null) goto L16;
            this.f18216h = w.b(r6, " \"#<>\\^`{|}", true, true, false, false);
        L16:
            return this;
        }

        public a r(String r3) {
            Objects.requireNonNull(r3, "scheme == null");
            String r0 = "http";
            if (r3.equalsIgnoreCase("http") == false) goto L5;
        L4:
            this.f18209a = r0;
            return this;
        L5:
            r0 = LocationInfoConst.HTTPS;
            if (r3.equalsIgnoreCase(LocationInfoConst.HTTPS) == true) goto L4;
            throw new IllegalArgumentException("unexpected scheme: " + r3);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            String r1 = this.f18209a;
            if (r1 == null) goto L5;
            r0.append(r1);
            String r2 = "://";
        L6:
            r0.append(r2);
            if (this.f18210b.isEmpty() == true) goto L9;
        L10:
            r0.append(this.f18210b);
            if (this.f18211c.isEmpty() == true) goto L13;
            r0.append(':');
            r0.append(this.f18211c);
        L13:
            r0.append('@');
        L14:
            String r3 = this.f18212d;
            if (r3 == null) goto L21;
            if (r3.indexOf(58) == (-1)) goto L19;
            r0.append('[');
            r0.append(this.f18212d);
            r0.append(']');
            goto L21
        L19:
            r0.append(this.f18212d);
        L21:
            if (this.f18213e == (-1)) goto L23;
        L24:
            int r4 = d();
            String r5 = this.f18209a;
            if (r5 != null) goto L27;
        L28:
            r0.append(':');
            r0.append(r4);
        L29:
            w.s(r0, this.f18214f);
            if (this.f18215g == null) goto L33;
            r0.append('?');
            w.o(r0, this.f18215g);
        L33:
            if (this.f18216h == null) goto L36;
            r0.append('#');
            r0.append(this.f18216h);
        L36:
            return r0.toString();
        L27:
            if (r4 == w.e(r5)) goto L29;
        L23:
            if (this.f18209a == null) goto L29;
        L9:
            if (this.f18211c.isEmpty() == true) goto L14;
        L5:
            r2 = "//";
            goto L6
        }

        public a v(String r8) {
            Objects.requireNonNull(r8, "username == null");
            this.f18210b = w.b(r8, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    static {
        f18199j = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    w(a r5) {
        this.f18200a = r5.f18209a;
        this.f18201b = u(r5.f18210b, false);
        this.f18202c = u(r5.f18211c, false);
        this.f18203d = r5.f18212d;
        this.f18204e = r5.d();
        this.f18205f = v(r5.f18214f, false);
        List<String> r0 = r5.f18215g;
        String r2 = null;
        if (r0 == null) goto L5;
        List<String> r1 = v(r0, true);
    L6:
        this.f18206g = r1;
        String r3 = r5.f18216h;
        if (r3 == null) goto L9;
        r2 = u(r3, false);
    L9:
        this.f18207h = r2;
        this.f18208i = r5.toString();
        return;
    L5:
        r1 = null;
        goto L6
    }

    static List<String> A(String r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 > r5.length()) goto L15;
        int r2 = r5.indexOf(38, r1);
        if (r2 != (-1)) goto L8;
        r2 = r5.length();
    L8:
        int r4 = r5.indexOf(61, r1);
        if (r4 == (-1)) goto L13;
        if (r4 > r2) goto L13;
        r0.add(r5.substring(r1, r4));
        String r3 = r5.substring(r4 + 1, r2);
    L14:
        r0.add(r3);
        r1 = r2 + 1;
    L13:
        r0.add(r5.substring(r1, r2));
        r3 = null;
        goto L14
    L15:
        return r0;
    }

    static String a(String r11, int r12, int r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18, Charset r19) {
        int r2 = r12;
    L3:
        if (r2 >= r13) goto L28;
        int r0 = r11.codePointAt(r2);
        if (r0 < 32) goto L25;
        if (r0 == 127) goto L25;
        if (r0 < 128) goto L12;
        if (r18 == true) goto L25;
    L12:
        if (r14.indexOf(r0) != (-1)) goto L25;
        if (r0 != 37) goto L20;
        if (r15 == false) goto L25;
        if (r16 == false) goto L20;
        if (x(r11, r2, r13) == false) goto L25;
    L20:
        if (r0 != 43) goto L23;
        if (r17 == true) goto L25;
    L23:
        r2 = r2 + Character.charCount(r0);
    L25:
        e r10 = new e();
        r10.C0(r11, r12, r2);
        d(r10, r11, r2, r13, r14, r15, r16, r17, r18, r19);
        return r10.i0();
    L28:
        return r11.substring(r12, r13);
    }

    static String b(String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        return a(r9, 0, r9.length(), r10, r11, r12, r13, r14, null);
    }

    static String c(String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14, Charset r15) {
        return a(r9, 0, r9.length(), r10, r11, r12, r13, r14, r15);
    }

    static void d(e r6, String r7, int r8, int r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14, Charset r15) {
        e r0 = null;
    L3:
        if (r8 >= r9) goto L50;
        int r1 = r7.codePointAt(r8);
        if (r11 == false) goto L16;
        if (r1 == 9) goto L49;
        if (r1 == 10) goto L49;
        if (r1 == 12) goto L49;
        if (r1 != 13) goto L16;
    L49:
        r8 = r8 + Character.charCount(r1);
    L16:
        if (r1 != 43) goto L23;
        if (r13 == false) goto L23;
        if (r11 == false) goto L20;
        String r2 = "+";
    L21:
        r6.B0(r2);
        goto L49
    L20:
        r2 = "%2B";
    L23:
        if (r1 >= 32) goto L25;
    L38:
        if (r0 != null) goto L40;
        r0 = new e();
    L40:
        if (r15 != null) goto L42;
    L45:
        r0.D0(r1);
    L47:
        if (r0.v() == true) goto L49;
        int r3 = r0.readByte() & 255;
        r6.s0(37);
        char[] r4 = f18199j;
        r6.s0(r4[(r3 >> 4) & 15]);
        r6.s0(r4[r3 & 15]);
        goto L47
    L42:
        if (r15.equals(c.f17800i) == true) goto L45;
        r0.A0(r7, r8, Character.charCount(r1) + r8, r15);
        goto L47
    L25:
        if (r1 == 127) goto L38;
        if (r1 < 128) goto L30;
        if (r14 == true) goto L38;
    L30:
        if (r10.indexOf(r1) != (-1)) goto L38;
        if (r1 != 37) goto L37;
        if (r11 == false) goto L38;
        if (r12 == false) goto L37;
        if (x(r7, r8, r9) == false) goto L38;
    L37:
        r6.D0(r1);
        goto L49
    }

    public static int e(String r1) {
        if (r1.equals("http") == false) goto L7;
        return 80;
    L7:
        if (r1.equals(LocationInfoConst.HTTPS) == false) goto L10;
        return 443;
    L10:
        return -1;
    }

    public static w l(String r2) {
        a r0 = new a();
        r0.i(null, r2);
        return r0.b();
    }

    static void o(StringBuilder r5, List<String> r6) {
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        String r2 = r6.get(r1);
        String r3 = r6.get(r1 + 1);
        if (r1 <= 0) goto L7;
        r5.append('&');
    L7:
        r5.append(r2);
        if (r3 == null) goto L10;
        r5.append('=');
        r5.append(r3);
    L10:
        r1 = r1 + 2;
        goto L3
    }

    public static w r(String r0) {
        return l(r0);
    L4:
        return null;
    }

    static void s(StringBuilder r3, List<String> r4) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.append('/');
        r3.append(r4.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    static String t(String r3, int r4, int r5, boolean r6) {
        int r0 = r4;
    L3:
        if (r0 >= r5) goto L14;
        char r1 = r3.charAt(r0);
        if (r1 == '%') goto L11;
        if (r1 != '+') goto L10;
        if (r6 == true) goto L11;
    L10:
        r0 = r0 + 1;
    L11:
        e r2 = new e();
        r2.C0(r3, r4, r0);
        w(r2, r3, r0, r5, r6);
        return r2.i0();
    L14:
        return r3.substring(r4, r5);
    }

    static String u(String r2, boolean r3) {
        return t(r2, 0, r2.length(), r3);
    }

    private List<String> v(List<String> r4, boolean r5) {
        int r3 = r4.size();
        ArrayList r0 = new ArrayList(r3);
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L10;
        String r2 = r4.get(r1);
        if (r2 == null) goto L7;
        String r6 = u(r2, r5);
    L8:
        r0.add(r6);
        r1 = r1 + 1;
        goto L3
    L7:
        r6 = null;
        goto L8
    L10:
        return Collections.unmodifiableList(r0);
    }

    static void w(e r5, String r6, int r7, int r8, boolean r9) {
    L2:
        if (r7 >= r8) goto L17;
        int r0 = r6.codePointAt(r7);
        if (r0 != 37) goto L12;
        int r1 = r7 + 2;
        if (r1 >= r8) goto L12;
        int r2 = c.k(r6.charAt(r7 + 1));
        int r3 = c.k(r6.charAt(r1));
        if (r2 == (-1)) goto L15;
        if (r3 == (-1)) goto L15;
        r5.s0((r2 << 4) + r3);
        r7 = r1;
    L16:
        r7 = r7 + Character.charCount(r0);
    L15:
        r5.D0(r0);
    L12:
        if (r0 != 43) goto L15;
        if (r9 == false) goto L15;
        r5.s0(32);
        goto L16
    }

    static boolean x(String r3, int r4, int r5) {
        int r0 = r4 + 2;
        if (r0 < r5) goto L5;
    L11:
        return false;
    L5:
        if (r3.charAt(r4) != '%') goto L11;
        if (c.k(r3.charAt(r4 + 1)) == (-1)) goto L11;
        if (c.k(r3.charAt(r0)) == (-1)) goto L11;
        return true;
    }

    public String B() {
        a r1 = q("/...");
        r1.v("");
        r1.k("");
        return r1.b().toString();
    }

    public w C(String r1) {
        a r0 = q(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public String D() {
        return this.f18200a;
    }

    public URI E() {
        a r3 = p();
        r3.p();
        String r4 = r3.toString();
        return new URI(r4);
    L5:
        e = move-exception;
        return URI.create(r4.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L9:
        throw new RuntimeException(e);
    }

    public URL F() {
        return new URL(this.f18208i);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof w) == true) goto L5;
    L7:
        return false;
    L5:
        if (((w) r2).f18208i.equals(this.f18208i) == false) goto L7;
        return true;
    }

    public String f() {
        if (this.f18207h != null) goto L6;
        return null;
    L6:
        int r0 = this.f18208i.indexOf(35) + 1;
        return this.f18208i.substring(r0);
    }

    public String g() {
        if (this.f18202c.isEmpty() == false) goto L6;
        return "";
    L6:
        int r0 = this.f18208i.indexOf(58, this.f18200a.length() + 3) + 1;
        int r1 = this.f18208i.indexOf(64);
        return this.f18208i.substring(r0, r1);
    }

    public String h() {
        int r0 = this.f18208i.indexOf(47, this.f18200a.length() + 3);
        String r1 = this.f18208i;
        int r2 = c.o(r1, r0, r1.length(), "?#");
        return this.f18208i.substring(r0, r2);
    }

    public int hashCode() {
        return this.f18208i.hashCode();
    }

    public List<String> i() {
        int r0 = this.f18208i.indexOf(47, this.f18200a.length() + 3);
        String r1 = this.f18208i;
        int r2 = c.o(r1, r0, r1.length(), "?#");
        ArrayList r3 = new ArrayList();
    L3:
        if (r0 >= r2) goto L5;
        int r4 = r0 + 1;
        int r5 = c.n(this.f18208i, r4, r2, '/');
        r3.add(this.f18208i.substring(r4, r5));
        r0 = r5;
        goto L3
    L5:
        return r3;
    }

    public String j() {
        if (this.f18206g != null) goto L6;
        return null;
    L6:
        int r0 = this.f18208i.indexOf(63) + 1;
        String r1 = this.f18208i;
        int r2 = c.n(r1, r0, r1.length(), '#');
        return this.f18208i.substring(r0, r2);
    }

    public String k() {
        if (this.f18201b.isEmpty() == false) goto L6;
        return "";
    L6:
        int r0 = this.f18200a.length() + 3;
        String r1 = this.f18208i;
        int r2 = c.o(r1, r0, r1.length(), ":@");
        return this.f18208i.substring(r0, r2);
    }

    public String m() {
        return this.f18203d;
    }

    public boolean n() {
        return this.f18200a.equals(LocationInfoConst.HTTPS);
    }

    public a p() {
        a r0 = new a();
        r0.f18209a = this.f18200a;
        r0.f18210b = k();
        r0.f18211c = g();
        r0.f18212d = this.f18203d;
        if (this.f18204e == e(this.f18200a)) goto L5;
        int r1 = this.f18204e;
    L6:
        r0.f18213e = r1;
        r0.f18214f.clear();
        r0.f18214f.addAll(i());
        r0.e(j());
        r0.f18216h = f();
        return r0;
    L5:
        r1 = -1;
        goto L6
    }

    public a q(String r2) {
        a r0 = new a();     // Catch: IllegalArgumentException -> L4
        r0.i(this, r2);     // Catch: IllegalArgumentException -> L4
        return r0;
    L4:
        return null;
    }

    public String toString() {
        return this.f18208i;
    }

    public int y() {
        return this.f18204e;
    }

    public String z() {
        if (this.f18206g != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        o(r0, this.f18206g);
        return r0.toString();
    }
}
