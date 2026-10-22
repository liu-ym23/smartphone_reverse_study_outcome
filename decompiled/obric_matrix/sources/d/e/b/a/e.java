package d.e.b.a;

import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final String A = null;
    static final Pattern B = null;
    private static final Pattern C = null;
    private static final Pattern D = null;
    private static e E;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Logger f16558h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<Integer, String> f16559i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Map<Character, Character> f16560j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<Character, Character> f16561k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<Character, Character> f16562l = null;
    private static final Map<Character, Character> m = null;
    private static final String n = null;
    static final Pattern o = null;
    private static final Pattern p = null;
    private static final Pattern q = null;
    static final Pattern r = null;
    static final Pattern s = null;
    private static final Pattern t = null;
    private static final String u = null;
    private static final String v = null;
    static final Pattern w = null;
    private static final String x = null;
    private static final String y = null;
    private static final String z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.e.b.a.l.c.g f16563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, List<String>> f16564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.e.b.a.k.b f16565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<String> f16566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.e.b.a.k.d f16567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<String> f16568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<Integer> f16569g;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16570a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f16571b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f16572c = null;

        static {
            int[] r0 = new int[c.values().length];
            f16572c = r0;
            r0[c.f16582j.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L67:
            f16572c[c.f16581i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L51:
            f16572c[c.f16579g.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L65:
            f16572c[c.f16578f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L69:
            f16572c[c.f16580h.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L55:
            f16572c[c.f16583k.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L57:
            f16572c[c.f16584l.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L81:
            f16572c[c.m.ordinal()] = 8;     // Catch: NoSuchFieldError -> L35
        L47:
            f16572c[c.n.ordinal()] = 9;     // Catch: NoSuchFieldError -> L36
        L75:
            f16572c[c.o.ordinal()] = 10;     // Catch: NoSuchFieldError -> L37
        L79:
            f16572c[c.p.ordinal()] = 11;     // Catch: NoSuchFieldError -> L38
        L17:
            int[] r4 = new int[b.values().length];
            f16571b = r4;
            r4[b.f16573f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L71:
            f16571b[b.f16574g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L53:
            f16571b[b.f16576i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L41
        L63:
            f16571b[b.f16575h.ordinal()] = 4;     // Catch: NoSuchFieldError -> L42
        L22:
            int[] r5 = new int[j.a.values().length];
            f16570a = r5;
            r5[j.a.f16621f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L49:
            f16570a[j.a.f16622g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L73:
            f16570a[j.a.f16623h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L45
        L83:
            f16570a[j.a.f16624i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L46
            return;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f16573f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f16574g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f16575h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f16576i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ b[] f16577j = null;

        static {
            f16573f = new b("E164", 0);
            f16574g = new b("INTERNATIONAL", 1);
            f16575h = new b("NATIONAL", 2);
            f16576i = new b("RFC3966", 3);
            f16577j = a();
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ b[] a() {
            return new b[]{f16573f, f16574g, f16575h, f16576i};
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f16577j.clone();
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f16578f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f16579g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f16580h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f16581i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final c f16582j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final c f16583k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final c f16584l = null;
        public static final c m = null;
        public static final c n = null;
        public static final c o = null;
        public static final c p = null;
        public static final c q = null;
        private static final /* synthetic */ c[] r = null;

        static {
            f16578f = new c("FIXED_LINE", 0);
            f16579g = new c("MOBILE", 1);
            f16580h = new c("FIXED_LINE_OR_MOBILE", 2);
            f16581i = new c("TOLL_FREE", 3);
            f16582j = new c("PREMIUM_RATE", 4);
            f16583k = new c("SHARED_COST", 5);
            f16584l = new c("VOIP", 6);
            m = new c("PERSONAL_NUMBER", 7);
            n = new c("PAGER", 8);
            o = new c("UAN", 9);
            p = new c("VOICEMAIL", 10);
            q = new c("UNKNOWN", 11);
            r = a();
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ c[] a() {
            return new c[]{f16578f, f16579g, f16580h, f16581i, f16582j, f16583k, f16584l, m, n, o, p, q};
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) r.clone();
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f16585f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f16586g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f16587h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final d f16588i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final d f16589j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final d f16590k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ d[] f16591l = null;

        static {
            f16585f = new d("IS_POSSIBLE", 0);
            f16586g = new d("IS_POSSIBLE_LOCAL_ONLY", 1);
            f16587h = new d("INVALID_COUNTRY_CODE", 2);
            f16588i = new d("TOO_SHORT", 3);
            f16589j = new d("INVALID_LENGTH", 4);
            f16590k = new d("TOO_LONG", 5);
            f16591l = a();
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ d[] a() {
            return new d[]{f16585f, f16586g, f16587h, f16588i, f16589j, f16590k};
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f16591l.clone();
        }
    }

    static {
        f16558h = Logger.getLogger(e.class.getName());
        HashMap r0 = new HashMap();
        r0.put(54, "9");
        f16559i = Collections.unmodifiableMap(r0);
        HashSet r1 = new HashSet();
        r1.add(86);
        Collections.unmodifiableSet(r1);
        HashSet r4 = new HashSet();
        r4.add(52);
        r4.add(54);
        r4.add(55);
        r4.add(62);
        r4.addAll(r1);
        Collections.unmodifiableSet(r4);
        HashMap r2 = new HashMap();
        r2.put('0', '0');
        r2.put('1', '1');
        r2.put('2', '2');
        r2.put('3', '3');
        r2.put('4', '4');
        r2.put('5', '5');
        r2.put('6', '6');
        r2.put('7', '7');
        r2.put('8', '8');
        r2.put('9', '9');
        HashMap r10 = new HashMap(40);
        r10.put('A', '2');
        r10.put('B', '2');
        r10.put('C', '2');
        r10.put('D', '3');
        r10.put('E', '3');
        r10.put('F', '3');
        r10.put('G', '4');
        r10.put('H', '4');
        r10.put('I', '4');
        r10.put('J', '5');
        r10.put('K', '5');
        r10.put('L', '5');
        r10.put('M', '6');
        r10.put('N', '6');
        r10.put('O', '6');
        r10.put('P', '7');
        r10.put('Q', '7');
        r10.put('R', '7');
        r10.put('S', '7');
        r10.put('T', '8');
        r10.put('U', '8');
        r10.put('V', '8');
        r10.put('W', '9');
        r10.put('X', '9');
        r10.put('Y', '9');
        r10.put('Z', '9');
        Map<Character, Character> r3 = Collections.unmodifiableMap(r10);
        f16561k = r3;
        HashMap r5 = new HashMap(100);
        r5.putAll(r3);
        r5.putAll(r2);
        f16562l = Collections.unmodifiableMap(r5);
        HashMap r6 = new HashMap();
        r6.putAll(r2);
        r6.put('+', '+');
        r6.put('*', '*');
        r6.put('#', '#');
        f16560j = Collections.unmodifiableMap(r6);
        HashMap r7 = new HashMap();
        Iterator<Character> r8 = r3.keySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        char r9 = r8.next().charValue();
        r7.put(Character.valueOf(Character.toLowerCase(r9)), Character.valueOf(r9));
        r7.put(Character.valueOf(r9), Character.valueOf(r9));
        goto L4
    L6:
        r7.putAll(r2);
        r7.put('-', '-');
        r7.put((char) 65293, '-');
        r7.put((char) 8208, '-');
        r7.put((char) 8209, '-');
        r7.put((char) 8210, '-');
        r7.put((char) 8211, '-');
        r7.put((char) 8212, '-');
        r7.put((char) 8213, '-');
        r7.put((char) 8722, '-');
        r7.put('/', '/');
        r7.put((char) 65295, '/');
        r7.put(' ', ' ');
        r7.put((char) 12288, ' ');
        r7.put((char) 8288, ' ');
        r7.put('.', '.');
        r7.put((char) 65294, '.');
        m = Collections.unmodifiableMap(r7);
        Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder r11 = new StringBuilder();
        Map<Character, Character> r12 = f16561k;
        r11.append(Arrays.toString(r12.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        r11.append(Arrays.toString(r12.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String r13 = r11.toString();
        n = r13;
        o = Pattern.compile("[+＋]+");
        Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        p = Pattern.compile("(\\p{Nd})");
        q = Pattern.compile("[+＋\\p{Nd}]");
        r = Pattern.compile("[\\\\/] *x");
        s = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
        t = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String r14 = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + r13 + "\\p{Nd}]*";
        u = r14;
        String r15 = c(true);
        v = r15;
        c(false);
        w = Pattern.compile("^\\+(\\p{Nd}|[\\-\\.\\(\\)]?)*\\p{Nd}(\\p{Nd}|[\\-\\.\\(\\)]?)*$");
        String r16 = r13 + "\\p{Nd}";
        x = r16;
        String r17 = "[" + r16 + "]+((\\-)*[" + r16 + "])*";
        y = r17;
        String r18 = "[" + r13 + "]+((\\-)*[" + r16 + "])*";
        z = r18;
        String r19 = "^(" + r17 + "\\.)*" + r18 + "\\.?$";
        A = r19;
        B = Pattern.compile(r19);
        C = Pattern.compile("(?:" + r15 + ")$", 66);
        D = Pattern.compile(r14 + "(?:" + r15 + ")?", 66);
        Pattern.compile("(\\D+)");
        Pattern.compile("(\\$\\d)");
        Pattern.compile("\\(?\\$1\\)?");
        E = null;
    }

    e(d.e.b.a.l.c.g r6, Map<Integer, List<String>> r7) {
        this.f16565c = d.e.b.a.k.c.b();
        this.f16566d = new HashSet(35);
        this.f16567e = new d.e.b.a.k.d(100);
        this.f16568f = new HashSet(320);
        this.f16569g = new HashSet();
        this.f16563a = r6;
        this.f16564b = r7;
        Iterator<Map.Entry<Integer, List<String>>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        Map.Entry<Integer, List<String>> r0 = r8.next();
        List<String> r3 = r0.getValue();
        if (r3.size() != 1) goto L10;
        if ("001".equals(r3.get(0)) == false) goto L10;
        this.f16569g.add(r0.getKey());
    L10:
        this.f16568f.addAll(r3);
        goto L4
    L12:
        if (this.f16568f.remove("001") == false) goto L14;
        f16558h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
    L14:
        this.f16566d.addAll(r7.get(1));
    }

    static StringBuilder A(CharSequence r5, boolean r6) {
        StringBuilder r0 = new StringBuilder(r5.length());
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L11;
        char r2 = r5.charAt(r1);
        int r3 = Character.digit(r2, 10);
        if (r3 == (-1)) goto L8;
        r0.append(r3);
    L10:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r6 == false) goto L10;
        r0.append(r2);
        goto L10
    L11:
        return r0;
    }

    public static String B(CharSequence r1) {
        return A(r1, false).toString();
    }

    private static String C(CharSequence r4, Map<Character, Character> r5, boolean r6) {
        StringBuilder r0 = new StringBuilder(r4.length());
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L12;
        char r2 = r4.charAt(r1);
        Character r3 = r5.get(Character.valueOf(Character.toUpperCase(r2)));
        if (r3 == null) goto L8;
        r0.append(r3);
    L10:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r6 == true) goto L10;
        r0.append(r2);
        goto L10
    L12:
        return r0.toString();
    }

    private void F(CharSequence r9, String r10, boolean r11, boolean r12, j r13) {
        if (r9 == null) goto L72;
        if (r9.length() > 250) goto L70;
        StringBuilder r0 = new StringBuilder();
        String r14 = r9.toString();
        a(r14, r0);
        if (u(r0) == false) goto L68;
        if (r12 == true) goto L9;
    L13:
        if (r11 == false) goto L15;
        r13.w(r14);
    L15:
        String r15 = w(r0);
        if (r15.length() <= 0) goto L18;
        r13.r(r15);
    L18:
        g r16 = o(r10);
        StringBuilder r17 = new StringBuilder();
        int r1 = v(r0, r16, r17, r11, r13);     // Catch: d.e.b.a.d -> L21
    L28:
        if (r1 == 0) goto L32;
        String r2 = r(r1);
        if (r2.equals(r10) == true) goto L38;
        r16 = p(r1, r2);
    L38:
        if (r17.length() < 2) goto L62;
        if (r16 == null) goto L51;
        StringBuilder r18 = new StringBuilder();
        StringBuilder r3 = new StringBuilder(r17);
        y(r3, r16, r18);
        d r8 = J(r3, r16);
        if (r8 == d.f16588i) goto L51;
        if (r8 == d.f16586g) goto L51;
        if (r8 == d.f16589j) goto L51;
        if (r11 == true) goto L48;
    L50:
        r17 = r3;
        goto L51
    L48:
        if (r18.length() <= 0) goto L50;
        r13.v(r18.toString());
    L51:
        int r19 = r17.length();
        if (r19 < 2) goto L60;
        if (r19 > 17) goto L58;
        I(r17, r13);
        r13.t(Long.parseLong(r17.toString()));
        return;
    L58:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16556j, "The string supplied is too long to be a phone number.");
    L60:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16555i, "The string supplied is too short to be a phone number.");
    L62:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16555i, "The string supplied is too short to be a phone number.");
    L32:
        z(r0);
        r17.append(r0);
        if (r10 == null) goto L35;
        r13.p(r16.a());
        goto L38
    L35:
        if (r11 == false) goto L38;
        r13.a();
    L21:
        e = move-exception;
        Matcher r4 = o.matcher(r0);
        if (e.a() != d.e.b.a.d.a.f16552f) goto L66;
        if (r4.lookingAt() == false) goto L66;
        r1 = v(r0.substring(r4.end()), r16, r17, r11, r13);
        if (r1 != 0) goto L28;
        throw new d.e.b.a.d(d.e.b.a.d.a.f16552f, "Could not interpret numbers after plus-sign.");
    L66:
        throw new d.e.b.a.d(e.a(), e.getMessage());
    L9:
        if (b(r0, r10) == true) goto L13;
        throw new d.e.b.a.d(d.e.b.a.d.a.f16552f, "Missing or invalid default region.");
    L68:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16553g, "The string supplied did not seem to be a phone number.");
    L70:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16556j, "The string supplied was too long to parse.");
    L72:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16553g, "The phone number supplied was null.");
    }

    private boolean G(Pattern r4, StringBuilder r5) {
        Matcher r3 = r4.matcher(r5);
        if (r3.lookingAt() == false) goto L11;
        int r6 = r3.end();
        Matcher r7 = p.matcher(r5.substring(r6));
        if (r7.find() == true) goto L7;
    L9:
        r5.delete(0, r6);
        return true;
    L7:
        if (B(r7.group(1)).equals(BDLocationException.ERROR_TIMEOUT) == false) goto L9;
        return false;
    L11:
        return false;
    }

    static synchronized void H(e r1) {
        monitor-enter(e.class);
        E = r1;     // Catch: Throwable -> L7
        monitor-exit(e.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static void I(CharSequence r4, j r5) {
        if (r4.length() > 1) goto L5;
        return;
    L5:
        if (r4.charAt(0) != '0') goto L18;
        r5.s(true);
        int r0 = 1;
    L8:
        if (r0 >= (r4.length() - 1)) goto L12;
        if (r4.charAt(r0) != '0') goto L12;
        r0 = r0 + 1;
    L12:
        if (r0 == 1) goto L19;
        r5.u(r0);
        return;
    L19:
        return;
    }

    private d J(CharSequence r2, g r3) {
        return K(r2, r3, c.q);
    }

    private d K(CharSequence r4, g r5, c r6) {
        i r0 = q(r5, r6);
        if (r0.e().isEmpty() == false) goto L5;
        List<Integer> r1 = r5.c().e();
    L6:
        List<Integer> r2 = r0.g();
        if (r6 != c.f16580h) goto L24;
        if (f(q(r5, c.f16578f)) == false) goto L11;
        i r3 = q(r5, c.f16579g);
        if (f(r3) == false) goto L24;
        ArrayList r7 = new ArrayList(r1);
        if (r3.d() != 0) goto L17;
        List<Integer> r8 = r5.c().e();
    L18:
        r7.addAll(r8);
        Collections.sort(r7);
        if (r2.isEmpty() == false) goto L21;
        r2 = r3.g();
    L22:
        r1 = r7;
        goto L24
    L21:
        ArrayList r9 = new ArrayList(r2);
        r9.addAll(r3.g());
        Collections.sort(r9);
        r2 = r9;
        goto L22
    L17:
        r8 = r3.e();
        goto L18
    L11:
        return K(r4, r5, c.f16579g);
    L24:
        if (r1.get(0).intValue() == (-1)) goto L26;
        int r10 = r4.length();
        if (r2.contains(Integer.valueOf(r10)) == true) goto L30;
        int r11 = r1.get(0).intValue();
        if (r11 == r10) goto L34;
        if (r11 <= r10) goto L39;
        return d.f16588i;
    L39:
        if (r1.get(r1.size() - 1).intValue() >= r10) goto L43;
        return d.f16590k;
    L43:
        if (r1.subList(1, r1.size()).contains(Integer.valueOf(r10)) == false) goto L46;
        return d.f16585f;
    L46:
        return d.f16589j;
    L34:
        return d.f16585f;
    L30:
        return d.f16586g;
    L26:
        return d.f16589j;
    L5:
        r1 = r0.e();
        goto L6
    }

    private void a(String r5, StringBuilder r6) {
        int r0 = r5.indexOf(";phone-context=");
        String r1 = j(r5, r0);
        if (s(r1) == false) goto L18;
        if (r1 == null) goto L12;
        int r4 = 0;
        if (r1.charAt(0) != '+') goto L8;
        r6.append(r1);
    L8:
        int r2 = r5.indexOf("tel:");
        if (r2 < 0) goto L11;
        r4 = r2 + 4;
    L11:
        r6.append(r5.substring(r4, r0));
    L13:
        int r7 = r6.indexOf(";isub=");
        if (r7 <= 0) goto L19;
        r6.delete(r7, r6.length());
        return;
    L19:
        return;
    L12:
        r6.append(k(r5));
        goto L13
    L18:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16553g, "The phone-context value is invalid.");
    }

    private boolean b(CharSequence r1, String r2) {
        if (t(r2) == true) goto L11;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.length() != 0) goto L8;
        return false;
    L8:
        if (o.matcher(r1).lookingAt() == true) goto L15;
        return false;
    L15:
        return true;
    L11:
        return true;
    }

    private static String c(boolean r8) {
        String r2 = (";ext=" + h(20)) + "|" + ("[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|anexo)[:\\.．]?[  \\t,-]*" + h(20) + "#?") + "|" + ("[  \\t,]*(?:[xｘ#＃~～]|int|ｉｎｔ)[:\\.．]?[  \\t,-]*" + h(9) + "#?") + "|" + ("[- ]+" + h(6) + "#");
        if (r8 == true) goto L5;
        return r2;
    L5:
        return r2 + "|" + ("[  \\t]*(?:,{2}|;)[:\\.．]?[  \\t,-]*" + h(15) + "#?") + "|" + ("[  \\t]*(?:,)+[:\\.．]?[  \\t,-]*" + h(9) + "#?");
    }

    public static e d(d.e.b.a.b r3) {
        if (r3 == null) goto L6;
        return e(new d.e.b.a.l.c.h(d.e.b.a.l.a.a().d(), r3, d.e.b.a.l.a.a().c()));
    L6:
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static e e(d.e.b.a.l.c.g r2) {
        if (r2 == null) goto L6;
        return new e(r2, d.e.b.a.a.a());
    L6:
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    private static boolean f(i r3) {
        if (r3.d() != 1) goto L7;
        if (r3.c(0) != (-1)) goto L7;
        return false;
    L7:
        return true;
    }

    private static void g(g r0, String r1) {
        if (r0 == null) goto L5;
        return;
    L5:
        throw new d.e.b.a.c(r1);
    }

    private static String h(int r2) {
        return "(\\p{Nd}{1," + r2 + "})";
    }

    private String j(String r2, int r3) {
        if (r3 != (-1)) goto L6;
        return null;
    L6:
        int r4 = r3 + 15;
        if (r4 < r2.length()) goto L10;
        return "";
    L10:
        int r0 = r2.indexOf(59, r4);
        if (r0 == (-1)) goto L15;
        return r2.substring(r4, r0);
    L15:
        return r2.substring(r4);
    }

    static CharSequence k(CharSequence r3) {
        Matcher r0 = q.matcher(r3);
        if (r0.find() == false) goto L11;
        CharSequence r4 = r3.subSequence(r0.start(), r3.length());
        Matcher r1 = s.matcher(r4);
        if (r1.find() == false) goto L7;
        r4 = r4.subSequence(0, r1.start());
    L7:
        Matcher r2 = r.matcher(r4);
        if (r2.find() == true) goto L10;
        return r4;
    L10:
        return r4.subSequence(0, r2.start());
    L11:
        return "";
    }

    public static synchronized e m() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (E != null) goto L7;
        H(d(d.e.b.a.l.a.a().b()));     // Catch: Throwable -> L10
    L7:
        e r1 = E;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r1;
    }

    private g p(int r2, String r3) {
        if ("001".equals(r3) == false) goto L6;
        return n(r2);
    L6:
        return o(r3);
    }

    private boolean s(String r3) {
        if (r3 != null) goto L6;
        return true;
    L6:
        if (r3.length() != 0) goto L9;
        return false;
    L9:
        if (w.matcher(r3).matches() == false) goto L11;
        return true;
    L11:
        if (B.matcher(r3).matches() == false) goto L14;
        return true;
    L14:
        return false;
    }

    private boolean t(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.f16568f.contains(r1) == false) goto L6;
        return true;
    }

    static boolean u(CharSequence r2) {
        if (r2.length() >= 2) goto L7;
        return false;
    L7:
        return D.matcher(r2).matches();
    }

    static StringBuilder z(StringBuilder r4) {
        if (t.matcher(r4).matches() == false) goto L5;
        int r0 = r4.length();
        String r2 = C(r4, f16562l, true);
    L6:
        r4.replace(0, r0, r2);
        return r4;
    L5:
        r0 = r4.length();
        r2 = B(r4);
        goto L6
    }

    public j D(CharSequence r2, String r3) {
        j r0 = new j();
        E(r2, r3, r0);
        return r0;
    }

    public void E(CharSequence r7, String r8, j r9) {
        F(r7, r8, false, true, r9);
    }

    int i(StringBuilder r7, StringBuilder r8) {
        if (r7.length() != 0) goto L5;
    L16:
        return 0;
    L5:
        if (r7.charAt(0) == '0') goto L16;
        int r0 = r7.length();
        int r2 = 1;
    L9:
        if (r2 > 3) goto L16;
        if (r2 > r0) goto L16;
        int r3 = Integer.parseInt(r7.substring(0, r2));
        if (this.f16564b.containsKey(Integer.valueOf(r3)) == true) goto L13;
        r2 = r2 + 1;
        goto L9
    L13:
        r8.append(r7.substring(r2));
        return r3;
    }

    public j l(String r4, c r5) {
        if (t(r4) == true) goto L6;
        f16558h.log(Level.WARNING, "Invalid or unknown region code provided: " + r4);
        return null;
    L6:
        i r6 = q(o(r4), r5);
    L11:
        e = move-exception;
        f16558h.log(Level.SEVERE, e.toString());
    L13:
        return null;
    L8:
        if (r6.h() == false) goto L13;
        return D(r6.a(), r4);
    }

    g n(int r3) {
        if (this.f16569g.contains(Integer.valueOf(r3)) == true) goto L6;
        return null;
    L6:
        g r2 = this.f16563a.a(r3);
        g(r2, "Missing metadata for country code " + r3);
        return r2;
    }

    g o(String r3) {
        if (t(r3) == true) goto L6;
        return null;
    L6:
        g r2 = this.f16563a.b(r3);
        g(r2, "Missing metadata for region code " + r3);
        return r2;
    }

    i q(g r1, c r2) {
        switch(a.f16572c[r2.ordinal()]) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L5;
        };
    L5:
        return r1.c();
    L7:
        return r1.q();
    L9:
        return r1.p();
    L11:
        return r1.k();
    L13:
        return r1.l();
    L15:
        return r1.r();
    L17:
        return r1.n();
    L19:
        return r1.b();
    L21:
        return r1.g();
    L23:
        return r1.o();
    L25:
        return r1.m();
    }

    public String r(int r1) {
        List<String> r0 = this.f16564b.get(Integer.valueOf(r1));
        if (r0 != null) goto L6;
        return "ZZ";
    L6:
        return r0.get(0);
    }

    int v(CharSequence r6, g r7, StringBuilder r8, boolean r9, j r10) {
        if (r6.length() != 0) goto L5;
        return 0;
    L5:
        StringBuilder r0 = new StringBuilder(r6);
        if (r7 == null) goto L8;
        String r11 = r7.e();
    L9:
        j.a r12 = x(r0, r11);
        if (r9 == false) goto L13;
        r10.q(r12);
    L13:
        if (r12 != j.a.f16624i) goto L15;
        if (r7 == null) goto L38;
        int r13 = r7.a();
        String r2 = String.valueOf(r13);
        String r3 = r0.toString();
        if (r3.startsWith(r2) == false) goto L38;
        StringBuilder r4 = new StringBuilder(r3.substring(r2.length()));
        i r5 = r7.c();
        y(r4, r7, null);
        if (this.f16565c.a(r0, r5, false) == true) goto L32;
        if (this.f16565c.a(r4, r5, false) == false) goto L32;
    L33:
        r8.append(r4);
        if (r9 == false) goto L36;
        r10.q(j.a.f16623h);
    L36:
        r10.p(r13);
        return r13;
    L32:
        if (J(r0, r7) == d.f16590k) goto L33;
    L38:
        r10.p(0);
        return 0;
    L15:
        if (r0.length() <= 2) goto L23;
        int r14 = i(r0, r8);
        if (r14 == 0) goto L21;
        r10.p(r14);
        return r14;
    L21:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16552f, "Country calling code supplied was not recognised.");
    L23:
        throw new d.e.b.a.d(d.e.b.a.d.a.f16554h, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
    L8:
        r11 = "NonMatch";
        goto L9
    }

    String w(StringBuilder r4) {
        Matcher r3 = C.matcher(r4);
        if (r3.find() == true) goto L5;
        return "";
    L5:
        if (u(r4.substring(0, r3.start())) == false) goto L17;
        int r0 = r3.groupCount();
        int r1 = 1;
    L7:
        if (r1 > r0) goto L18;
        if (r3.group(r1) != null) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        String r2 = r3.group(r1);
        r4.delete(r3.start(), r4.length());
        return r2;
    L18:
        return "";
    L17:
        return "";
    }

    j.a x(StringBuilder r3, String r4) {
        if (r3.length() == 0) goto L5;
        Matcher r0 = o.matcher(r3);
        if (r0.lookingAt() == false) goto L10;
        r3.delete(0, r0.end());
        z(r3);
        return j.a.f16621f;
    L10:
        Pattern r5 = this.f16567e.a(r4);
        z(r3);
        if (G(r5, r3) == false) goto L14;
        return j.a.f16622g;
    L14:
        return j.a.f16624i;
    L5:
        return j.a.f16624i;
    }

    boolean y(StringBuilder r9, g r10, StringBuilder r11) {
        int r0 = r9.length();
        String r1 = r10.h();
        if (r0 != 0) goto L5;
    L37:
        return false;
    L5:
        if (r1.length() == 0) goto L37;
        Matcher r2 = this.f16567e.a(r1).matcher(r9);
        if (r2.lookingAt() == false) goto L37;
        i r3 = r10.c();
        boolean r4 = this.f16565c.a(r9, r3, false);
        int r5 = r2.groupCount();
        String r12 = r10.i();
        if (r12 != null) goto L12;
    L26:
        if (r4 == true) goto L28;
    L30:
        if (r11 == null) goto L35;
        if (r5 <= 0) goto L35;
        if (r2.group(r5) == null) goto L35;
        r11.append(r2.group(1));
    L35:
        r9.delete(0, r2.end());
        return true;
    L28:
        if (this.f16565c.a(r9.substring(r2.end()), r3, false) == true) goto L30;
        return false;
    L12:
        if (r12.length() == 0) goto L26;
        if (r2.group(r5) == null) goto L26;
        StringBuilder r7 = new StringBuilder(r9);
        r7.replace(0, r0, r2.replaceFirst(r12));
        if (r4 == true) goto L19;
    L21:
        if (r11 == null) goto L24;
        if (r5 <= 1) goto L24;
        r11.append(r2.group(1));
    L24:
        r9.replace(0, r9.length(), r7.toString());
        return true;
    L19:
        if (this.f16565c.a(r7.toString(), r3, false) == true) goto L21;
        return false;
    }
}
