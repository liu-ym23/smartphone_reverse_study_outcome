package d.b.h.a.a.h.m;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class g implements Cloneable {
    private static final Set<String> r = null;
    private static Pattern s;
    private static Pattern t;
    private static final ThreadLocal<DateFormat> u = null;
    private static final String[] v = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f13435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f13436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f13437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f13438l;
    private String m;
    private boolean n;
    private boolean o;
    private String p;
    private int q;

    class a extends ThreadLocal<DateFormat> {
        a() {
        }

        protected DateFormat a() {
            SimpleDateFormat r2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            r2.setTimeZone(TimeZone.getTimeZone("UTC"));
            return r2;
        }

        @Override // java.lang.ThreadLocal
        protected /* bridge */ /* synthetic */ DateFormat initialValue() {
            return a();
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f13442d;

        b(String r2) {
            this.f13441c = 0;
            this.f13442d = false;
            this.f13439a = r2;
            this.f13440b = r2.toLowerCase(Locale.US);
        }

        private int a(String r4) {
            int r0 = this.f13441c;
        L4:
            if (r0 >= this.f13439a.length()) goto L10;
            if (r4.indexOf(this.f13439a.charAt(r0)) != (-1)) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L10:
            return this.f13439a.length();
        }

        private String c(boolean r3) {
            g();
            int r0 = a(",;= \t");
            if (r3 == false) goto L5;
            String r4 = this.f13440b;
        L6:
            int r1 = this.f13441c;
            if (r1 >= r0) goto L9;
            String r5 = r4.substring(r1, r0);
        L10:
            this.f13441c = r0;
            return r5;
        L9:
            r5 = null;
            goto L10
        L5:
            r4 = this.f13439a;
            goto L6
        }

        private String d(String r3) {
            g();
            int r4 = a(r3);
            String r0 = this.f13439a.substring(this.f13441c, r4);
            this.f13441c = r4;
            return r0;
        }

        private boolean e() {
            g();
            if (this.f13441c < this.f13439a.length()) goto L5;
            return false;
        L5:
            if (this.f13439a.charAt(this.f13441c) != '=') goto L10;
            this.f13441c++;
            return true;
        L10:
            return false;
        }

        private void f(g r5, String r6, String r7) {
            if (r6.equals("comment") == false) goto L8;
            if (g.c(r5) != null) goto L8;
            g.e(r5, r7);
            return;
        L8:
            if (r6.equals("commenturl") == false) goto L13;
            if (g.f(r5) != null) goto L13;
            g.h(r5, r7);
            return;
        L13:
            if (r6.equals("discard") == false) goto L16;
            g.i(r5, true);
            return;
        L16:
            if (r6.equals("domain") == false) goto L26;
            if (g.j(r5) != null) goto L26;
            if (TextUtils.isEmpty(r7) == false) goto L22;
        L24:
            g.k(r5, r7);
            return;
        L22:
            if (r7.charAt(0) != '.') goto L24;
            r7 = r7.substring(1);
        L26:
            if (r6.equals("expires") == false) goto L34;
            if (g.m(r5) != (-1)) goto L70;
            Date r4 = g.M(r7);
            if (r4 == null) goto L32;
            g.o(r5, r4);
            return;
        L32:
            g.n(r5, 0);
            return;
        L70:
            return;
        L34:
            if (r6.equals("max-age") == false) goto L40;
            g.n(r5, Long.parseLong(r7));     // Catch: NumberFormatException -> L37
            return;
        L38:
            throw new IllegalArgumentException("Invalid max-age: " + r7);
        L40:
            if (r6.equals("path") == false) goto L45;
            if (g.p(r5) != null) goto L45;
            g.q(r5, r7);
            return;
        L45:
            if (r6.equals("port") == false) goto L53;
            if (g.r(r5) != null) goto L53;
            if (r7 != null) goto L51;
            r7 = "";
        L51:
            g.t(r5, r7);
            return;
        L53:
            if (r6.equals("secure") == false) goto L56;
            g.u(r5, true);
            return;
        L56:
            if (r6.equals("httponly") == false) goto L59;
            g.d(r5, true);
            return;
        L59:
            if (r6.equals("version") == true) goto L61;
            return;
        L61:
            if (this.f13442d == true) goto L78;
            g.a(r5, Integer.parseInt(r7));
            return;
        }

        private void g() {
        L3:
            if (this.f13441c >= this.f13439a.length()) goto L8;
            if (" \t".indexOf(this.f13439a.charAt(this.f13441c)) == (-1)) goto L11;
            this.f13441c++;
            goto L3
        L11:
            return;
        }

        public List<g> b() {
            ArrayList r0 = new ArrayList(2);
            if (this.f13440b.startsWith("set-cookie2:") == false) goto L6;
            this.f13441c += 12;
            this.f13442d = true;
            int r1 = 0;
        L9:
            String r4 = c(false);
            if (r4 == null) goto L12;
            if (e() == false) goto L48;
            if (r1 == 0) goto L21;
            String r6 = ";";
        L22:
            g r7 = new g(r4, d(r6));
            g.a(r7, r1 ^ 1);
            r0.add(r7);
        L23:
            g();
            if (this.f13441c == this.f13439a.length()) goto L9;
            if (this.f13439a.charAt(this.f13441c) == ',') goto L28;
            if (this.f13439a.charAt(this.f13441c) != ';') goto L32;
            this.f13441c++;
        L32:
            String r5 = c(true);
            if (r5 == null) goto L23;
            if (r1 == 0) goto L37;
        L42:
            String r8 = ";";
        L43:
            String r9 = null;
            if (e() == false) goto L46;
            r9 = d(r8);
        L46:
            f(r7, r5, r9);
            goto L23
        L37:
            if ("expires".equals(r5) == true) goto L42;
            if ("port".equals(r5) == true) goto L42;
            r8 = ";,";
            goto L43
        L28:
            this.f13441c++;
            goto L9
        L21:
            r6 = ",;";
            goto L22
        L48:
            throw new IllegalArgumentException("Expected '=' after " + r4 + " in " + this.f13439a);
        L12:
            if (r0.isEmpty() == true) goto L15;
            return r0;
        L15:
            throw new IllegalArgumentException("No cookies in " + this.f13439a);
        L6:
            if (this.f13440b.startsWith("set-cookie:") == false) goto L8;
            this.f13441c += 11;
        L8:
            r1 = 1;
            goto L9
        }
    }

    static {
        HashSet r0 = new HashSet();
        r = r0;
        r0.add("comment");
        r0.add("commenturl");
        r0.add("discard");
        r0.add("domain");
        r0.add("expires");
        r0.add("httponly");
        r0.add("max-age");
        r0.add("path");
        r0.add("port");
        r0.add("secure");
        r0.add("version");
        s = null;
        t = null;
        s = Pattern.compile("(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])", 2);     // Catch: PatternSyntaxException -> L6
        t = Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}", 2);     // Catch: PatternSyntaxException -> L6
    L4:
        u = new a();
        v = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    public g(String r3, String r4) {
        this.f13436j = -1;
        this.q = 0;
        String r0 = r3.trim();
        if (J(r0) == false) goto L7;
        this.f13437k = r0;
        this.p = r4;
        return;
    L7:
        throw new IllegalArgumentException("Invalid name: " + r3);
    }

    private static boolean H(String r2, int r3) {
        int r4 = r2.indexOf(46, r3 + 1);
        if (r4 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (r4 >= (r2.length() - 1)) goto L7;
        return true;
    }

    public static boolean I(String r2) {
        if (s.matcher(r2).matches() == false) goto L5;
        return true;
    L5:
        if (t.matcher(r2).matches() == false) goto L8;
        return true;
    L8:
        return false;
    L13:
        return false;
    }

    private boolean J(String r5) {
        if (r5.length() != 0) goto L5;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L29;
        int r1 = 0;
    L13:
        if (r1 >= r5.length()) goto L29;
        char r2 = r5.charAt(r1);
        if (r2 < 0) goto L38;
        if (r2 >= 127) goto L39;
        if (r2 == ';') goto L40;
        if (r2 == ',') goto L41;
        if (Character.isWhitespace(r2) == false) goto L27;
        if (r2 == ' ') goto L27;
        return false;
    L27:
        r1 = r1 + 1;
        goto L13
    L41:
        return false;
    L40:
        return false;
    L39:
        return false;
    L38:
        return false;
    L29:
        return r4;
    L5:
        if (r5.startsWith("$") == true) goto L9;
        if (r.contains(r5.toLowerCase(Locale.US)) == true) goto L9;
        r4 = true;
        goto L10
    }

    private static String K(String r2) {
        if (r2 != null) goto L6;
        return "/";
    L6:
        if (r2.endsWith("/") == false) goto L9;
        return r2;
    L9:
        return r2 + "/";
    }

    public static List<g> L(String r1) {
        return new b(r1).b();
    }

    public static Date M(String r6) {
        return u.get().parse(r6);
    L4:
        String[] r0 = v;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        String r3 = r0[r2];
        return new SimpleDateFormat(r3, Locale.US).parse(r6);
    L9:
        r2 = r2 + 1;
        goto L5
    L10:
        return null;
    }

    public static boolean N(g r0, URI r1) {
        return K(r1.getPath()).startsWith(K(r0.C()));
    }

    public static boolean O(g r1, URI r2) {
        if (r1.D() != null) goto L7;
        return true;
    L7:
        return Arrays.asList(r1.D().split(",")).contains(Integer.toString(l.d(r2.getScheme(), r2.getPort())));
    }

    public static boolean P(g r0, URI r1) {
        if (r0.E() == true) goto L5;
    L8:
        return true;
    L5:
        if (LocationInfoConst.HTTPS.equalsIgnoreCase(r1.getScheme()) == true) goto L8;
        return false;
    }

    private void R(Date r5) {
        this.f13436j = (r5.getTime() - System.currentTimeMillis()) / 1000;
    }

    static /* synthetic */ int a(g r0, int r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ String c(g r0) {
        return r0.f13432f;
    }

    static /* synthetic */ boolean d(g r0, boolean r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ String e(g r0, String r1) {
        r0.f13432f = r1;
        return r1;
    }

    static /* synthetic */ String f(g r0) {
        return r0.f13433g;
    }

    static /* synthetic */ String h(g r0, String r1) {
        r0.f13433g = r1;
        return r1;
    }

    static /* synthetic */ boolean i(g r0, boolean r1) {
        r0.f13434h = r1;
        return r1;
    }

    static /* synthetic */ String j(g r0) {
        return r0.f13435i;
    }

    static /* synthetic */ String k(g r0, String r1) {
        r0.f13435i = r1;
        return r1;
    }

    static /* synthetic */ long m(g r2) {
        return r2.f13436j;
    }

    static /* synthetic */ long n(g r0, long r1) {
        r0.f13436j = r1;
        return r1;
    }

    static /* synthetic */ void o(g r0, Date r1) {
        r0.R(r1);
    }

    static /* synthetic */ String p(g r0) {
        return r0.f13438l;
    }

    static /* synthetic */ String q(g r0, String r1) {
        r0.f13438l = r1;
        return r1;
    }

    static /* synthetic */ String r(g r0) {
        return r0.m;
    }

    static /* synthetic */ String t(g r0, String r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ boolean u(g r0, boolean r1) {
        r0.n = r1;
        return r1;
    }

    public static boolean v(String r6, String r7) {
        if (r6 == null) goto L38;
        if (r7 == null) goto L42;
        Locale r1 = Locale.US;
        String r8 = r7.toLowerCase(r1);
        String r9 = r6.toLowerCase(r1);
        if (r8.equals(r9) == false) goto L14;
        if (H(r8, 0) == false) goto L11;
    L12:
        return true;
    L11:
        if (I(r8) == true) goto L12;
    L14:
        if (H(r8, 0) == true) goto L18;
        return r9.equals(".local");
    L18:
        if (r9.length() != (r8.length() + 1)) goto L27;
        if (r9.startsWith(".") == false) goto L27;
        if (r9.endsWith(r8) == false) goto L27;
        if (H(r9, 1) == false) goto L27;
        return true;
    L27:
        if (r8.length() > r9.length()) goto L29;
        return false;
    L29:
        if (r8.endsWith(r9) == true) goto L31;
        return false;
    L31:
        if (r9.startsWith(".") == false) goto L35;
        if (H(r9, 1) == false) goto L35;
    L37:
        return true;
    L35:
        if (r9.equals(".local") == true) goto L37;
        return false;
    L42:
        return false;
    L38:
        return false;
    }

    public static boolean w(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public String B() {
        return this.f13437k;
    }

    public String C() {
        return this.f13438l;
    }

    public String D() {
        return this.m;
    }

    public boolean E() {
        return this.n;
    }

    public int F() {
        return this.q;
    }

    public boolean G() {
        long r0 = this.f13436j;
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (r0 > 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void Q(String r2) {
        if (r2 != null) goto L4;
        String r3 = null;
    L5:
        this.f13435i = r3;
        return;
    L4:
        r3 = r2.toLowerCase(Locale.US);
        goto L5
    }

    public void S(String r1) {
        this.f13438l = r1;
    }

    public void T(String r1) {
        this.m = r1;
    }

    public Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == false) goto L21;
        g r6 = (g) r5;
        if (this.f13437k.equalsIgnoreCase(r6.B()) == false) goto L20;
        String r1 = this.f13435i;
        if (r1 == null) goto L15;
        if (r1.equalsIgnoreCase(r6.f13435i) == false) goto L20;
    L17:
        if (w(this.f13438l, r6.f13438l) == false) goto L20;
        return true;
    L15:
        if (r6.f13435i == null) goto L17;
    L20:
        return false;
    L21:
        return false;
    }

    public int hashCode() {
        String r0 = this.f13437k;
        Locale r1 = Locale.US;
        int r2 = r0.toLowerCase(r1).hashCode();
        String r3 = this.f13435i;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = r2 + r5;
        String r7 = this.f13438l;
        if (r7 == null) goto L11;
        r4 = r7.hashCode();
    L11:
        return r6 + r4;
    L5:
        r5 = r3.toLowerCase(r1).hashCode();
        goto L6
    }

    public String toString() {
        return this.f13437k + "=" + this.p;
    }

    public String y() {
        return this.f13435i;
    }

    public long z() {
        return this.f13436j;
    }
}
