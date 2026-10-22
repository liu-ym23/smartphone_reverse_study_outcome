package d.b.u.v;

import androidx.core.internal.view.SupportMenu;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f15097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f15098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f15100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public short f15101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short f15102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Pattern f15103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Pattern f15104h;

    /* JADX INFO: renamed from: d.b.u.v.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0407a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15105a = null;

        static {
            int[] r0 = new int[d.values().length];
            f15105a = r0;
            r0[d.f15112g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f15105a[d.f15111f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f15105a[d.f15113h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f15106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15107b;

        public b(d r1, String r2) {
            this.f15106a = r1;
            this.f15107b = r2;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (b.class == r5.getClass()) goto L11;
            return false;
        L11:
            b r6 = (b) r5;
            if (this.f15106a == r6.f15106a) goto L14;
            return false;
        L14:
            String r4 = this.f15107b;
            if (r4 != null) goto L20;
            if (r6.f15107b == null) goto L22;
            return false;
        L22:
            return true;
        L20:
            if (r4.equals(r6.f15107b) == true) goto L22;
            return false;
        }

        public int hashCode() {
            d r0 = this.f15106a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            String r3 = this.f15107b;
            if (r3 == null) goto L11;
            r1 = r3.hashCode();
        L11:
            return r2 + (r1 * 31);
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Diff(" + this.f15106a + ",\"" + this.f15107b.replace('\n', 182) + "\")";
        }
    }

    protected static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected String f15108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f15109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected List<String> f15110c;

        protected c(String r1, String r2, List<String> r3) {
            this.f15108a = r1;
            this.f15109b = r2;
            this.f15110c = r3;
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f15111f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f15112g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f15113h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ d[] f15114i = null;

        static {
            d r0 = new d("DELETE", 0);
            f15111f = r0;
            d r1 = new d("INSERT", 1);
            f15112g = r1;
            d r3 = new d("EQUAL", 2);
            f15113h = r3;
            f15114i = new d[]{r0, r1, r3};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        public static d valueOf(String r1) {
            return (d) Enum.valueOf(d.class, r1);
        }

        public static d[] values() {
            return (d[]) f15114i.clone();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LinkedList<b> f15115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15118d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15119e;

        public e() {
            this.f15115a = new LinkedList();
        }

        public String toString() {
            int r0 = this.f15118d;
            if (r0 != 0) goto L6;
            StringBuilder r1 = new StringBuilder();
            r1.append(this.f15116b);
            r1.append(",0");
        L5:
            String r2 = r1.toString();
        L9:
            int r4 = this.f15119e;
            if (r4 != 0) goto L12;
            String r3 = this.f15117c + ",0";
        L15:
            StringBuilder r5 = new StringBuilder();
            r5.append("@@ -");
            r5.append(r2);
            r5.append(" +");
            r5.append(r3);
            r5.append(" @@\n");
            Iterator<b> r7 = this.f15115a.iterator();
        L17:
            if (r7.hasNext() == false) goto L34;
            b r6 = r7.next();
            int r8 = C0407a.f15105a[r6.f15106a.ordinal()];
            if (r8 != 1) goto L21;
            r5.append('+');
        L35:
            r5.append(URLEncoder.encode(r6.f15107b, "UTF-8").replace('+', ' '));     // Catch: UnsupportedEncodingException -> L30
            r5.append("\n");     // Catch: UnsupportedEncodingException -> L30
        L30:
            e = move-exception;
            throw new Error("This system does not support UTF-8.", e);
        L21:
            if (r8 != 2) goto L23;
            r5.append('-');
            goto L35
        L23:
            if (r8 != 3) goto L35;
            r5.append(' ');
            goto L35
        L34:
            return a.a(r5.toString());
        L12:
            if (r4 != 1) goto L14;
            r3 = Integer.toString(this.f15117c + 1);
            goto L15
        L14:
            r3 = (this.f15117c + 1) + "," + this.f15119e;
            goto L15
        L6:
            if (r0 != 1) goto L8;
            r2 = Integer.toString(this.f15116b + 1);
            goto L9
        L8:
            r1 = new StringBuilder();
            r1.append(this.f15116b + 1);
            r1.append(",");
            r1.append(this.f15118d);
            goto L5
        }
    }

    static {
    }

    public a() {
        this.f15097a = 1.0f;
        this.f15098b = 0.5f;
        this.f15099c = 1000;
        this.f15100d = 0.5f;
        this.f15101e = 4;
        this.f15102f = 32;
        this.f15103g = Pattern.compile("\\n\\r?\\n\\Z", 32);
        this.f15104h = Pattern.compile("\\A\\r?\\n\\r?\\n", 32);
    }

    private static String G(String r2) {
        return r2.replace("%21", "!").replace("%7E", "~").replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%3B", ";").replace("%2F", "/").replace("%3F", "?").replace("%3A", ":").replace("%40", "@").replace("%26", "&").replace("%3D", "=").replace("%2B", "+").replace("%24", "$").replace("%2C", ",").replace("%23", "#");
    }

    static /* synthetic */ String a(String r0) {
        return G(r0);
    }

    private LinkedList<b> c(String r12, String r13, int r14, int r15, long r16) {
        String r6 = r12.substring(0, r14);
        String r7 = r13.substring(0, r15);
        String r2 = r12.substring(r14);
        String r3 = r13.substring(r15);
        LinkedList<b> r8 = t(r6, r7, false, r16);
        r8.addAll(t(r2, r3, false, r16));
        return r8;
    }

    private int h(String r10, String r11) {
        if (r10.length() != 0) goto L5;
        return 6;
    L5:
        if (r11.length() == 0) goto L69;
        char r0 = r10.charAt(r10.length() - 1);
        char r3 = r11.charAt(0);
        boolean r4 = !Character.isLetterOrDigit(r0);
        boolean r5 = !Character.isLetterOrDigit(r3);
        if (r4 == true) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r5 == true) goto L15;
    L17:
        boolean r7 = false;
    L19:
        if (r6 == true) goto L21;
    L23:
        boolean r1 = false;
    L24:
        if (r7 == true) goto L26;
    L28:
        boolean r8 = false;
    L29:
        if (r1 == true) goto L31;
    L33:
        boolean r12 = false;
    L34:
        if (r8 == true) goto L36;
    L38:
        boolean r9 = false;
    L39:
        if (r12 == true) goto L62;
        if (r9 == true) goto L68;
        if (r1 == true) goto L60;
        if (r8 == true) goto L67;
        if (r4 == false) goto L50;
        if (r6 == true) goto L50;
        if (r7 == false) goto L50;
        return 3;
    L50:
        if (r6 == true) goto L58;
        if (r7 == true) goto L66;
        if (r4 == true) goto L57;
        if (r5 == true) goto L57;
        return 0;
    L57:
        return 1;
    L66:
        return 2;
    L58:
        return 2;
    L67:
        return 4;
    L60:
        return 4;
    L68:
        return 5;
    L62:
        return 5;
    L36:
        if (this.f15104h.matcher(r11).find() == false) goto L38;
        r9 = true;
        goto L39
    L31:
        if (this.f15103g.matcher(r10).find() == false) goto L33;
        r12 = true;
        goto L34
    L26:
        if (Character.getType(r3) != 15) goto L28;
        r8 = true;
        goto L29
    L21:
        if (Character.getType(r0) != 15) goto L23;
        r1 = true;
        goto L24
    L15:
        if (Character.isWhitespace(r3) == false) goto L17;
        r7 = true;
        goto L19
    L10:
        if (Character.isWhitespace(r0) == false) goto L12;
        r6 = true;
        goto L13
    L69:
        return 6;
    }

    private LinkedList<b> l(String r14, String r15, boolean r16, long r17) {
        LinkedList<b> r2 = new LinkedList();
        if (r14.length() != 0) goto L7;
        r2.add(new b(d.f15112g, r15));
        return r2;
    L7:
        if (r15.length() != 0) goto L11;
        r2.add(new b(d.f15111f, r14));
        return r2;
    L11:
        if (r14.length() <= r15.length()) goto L13;
        String r3 = r14;
    L15:
        if (r14.length() <= r15.length()) goto L17;
        String r4 = r15;
    L18:
        int r5 = r3.indexOf(r4);
        if (r5 == (-1)) goto L27;
        if (r14.length() <= r15.length()) goto L23;
        d r0 = d.f15111f;
    L24:
        r2.add(new b(r0, r3.substring(0, r5)));
        r2.add(new b(d.f15113h, r4));
        r2.add(new b(r0, r3.substring(r5 + r4.length())));
        return r2;
    L23:
        r0 = d.f15112g;
        goto L24
    L27:
        if (r4.length() != 1) goto L30;
        r2.add(new b(d.f15111f, r14));
        r2.add(new b(d.f15112g, r15));
        return r2;
    L30:
        String[] r6 = m(r14, r15);
        if (r6 == null) goto L34;
        String r1 = r6[0];
        String r9 = r6[1];
        String r7 = r6[2];
        String r10 = r6[3];
        String r11 = r6[4];
        LinkedList<b> r12 = t(r1, r7, r16, r17);
        LinkedList<b> r8 = t(r9, r10, r16, r17);
        r12.add(new b(d.f15113h, r11));
        r12.addAll(r8);
        return r12;
    L34:
        if (r16 == false) goto L42;
        if (r14.length() <= 100) goto L42;
        if (r15.length() <= 100) goto L42;
        return p(r14, r15, r17);
    L42:
        return b(r14, r15, r17);
    L17:
        r4 = r14;
        goto L18
    L13:
        r3 = r15;
        goto L15
    }

    private String[] n(String r17, String r18, int r19) {
        String r4 = r17.substring(r19, (r17.length() / 4) + r19);
        int r6 = -1;
        String r7 = "";
        int r12 = -1;
        String r8 = "";
        String r9 = r8;
        String r10 = r9;
        String r11 = r10;
    L3:
        r12 = r18.indexOf(r4, r12 + 1);
        if (r12 == r6) goto L10;
        int r13 = j(r17.substring(r19), r18.substring(r12));
        int r14 = k(r17.substring(0, r19), r18.substring(0, r12));
        if (r7.length() >= (r14 + r13)) goto L8;
        StringBuilder r5 = new StringBuilder();
        int r15 = r12 - r14;
        r5.append(r18.substring(r15, r12));
        int r16 = r12 + r13;
        r5.append(r18.substring(r12, r16));
        String r20 = r5.toString();
        String r21 = r17.substring(0, r19 - r14);
        r9 = r17.substring(r19 + r13);
        r10 = r18.substring(0, r15);
        r11 = r18.substring(r16);
        r7 = r20;
        r8 = r21;
    L8:
        r6 = -1;
        goto L3
    L10:
        if ((r7.length() * 2) >= r17.length()) goto L12;
        return null;
    L12:
        return new String[]{r8, r9, r10, r11, r7};
    }

    private LinkedList<b> p(String r11, String r12, long r13) {
        c r14 = q(r11, r12);
        String r1 = r14.f15108a;
        String r2 = r14.f15109b;
        List<String> r15 = r14.f15110c;
        LinkedList<b> r16 = t(r1, r2, false, r13);
        d(r16, r15);
        f(r16);
        r16.add(new b(d.f15113h, ""));
        ListIterator<b> r17 = r16.listIterator();
        b r0 = r17.next();
        String r5 = "";
        String r6 = r5;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r0 == null) goto L28;
        int r7 = C0407a.f15105a[r0.f15106a.ordinal()];
        if (r7 != 1) goto L7;
        r3 = r3 + 1;
        r6 = r6 + r0.f15107b;
    L25:
        if (r17.hasNext() == true) goto L26;
        r0 = null;
        goto L3
    L26:
        r0 = r17.next();
        goto L3
    L7:
        if (r7 != 2) goto L9;
        r4 = r4 + 1;
        r5 = r5 + r0.f15107b;
        goto L25
    L9:
        if (r7 != 3) goto L25;
        if (r4 < 1) goto L21;
        if (r3 < 1) goto L21;
        r17.previous();
        int r8 = 0;
    L15:
        if (r8 >= (r4 + r3)) goto L17;
        r17.previous();
        r17.remove();
        r8 = r8 + 1;
        goto L15
    L17:
        Iterator<b> r9 = t(r5, r6, false, r13).iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        r17.add(r9.next());
    L21:
        r5 = "";
        r6 = r5;
        r3 = 0;
        r4 = 0;
        goto L25
    L28:
        r16.removeLast();
        return r16;
    }

    private String r(String r6, List<String> r7, Map<String, Integer> r8, int r9) {
        StringBuilder r5 = new StringBuilder();
        int r1 = 0;
        int r2 = -1;
    L4:
        if (r2 >= (r6.length() - 1)) goto L18;
        r2 = r6.indexOf(10, r1);
        if (r2 != (-1)) goto L8;
        r2 = r6.length() - 1;
    L8:
        String r3 = r6.substring(r1, r2 + 1);
        if (r8.containsKey(r3) == false) goto L13;
        int r4 = r8.get(r3).intValue();
    L11:
        r5.append(String.valueOf((char) r4));
        r1 = r2 + 1;
        goto L4
    L13:
        if (r7.size() != r9) goto L15;
        r3 = r6.substring(r1);
        r2 = r6.length();
    L15:
        r7.add(r3);
        r8.put(r3, Integer.valueOf(r7.size() - 1));
        r4 = r7.size() - 1;
        goto L11
    L18:
        return r5.toString();
    }

    private LinkedList<b> t(String r9, String r10, boolean r11, long r12) {
        if (r9 == null) goto L19;
        if (r10 == null) goto L19;
        if (r9.equals(r10) == false) goto L10;
        LinkedList<b> r1 = new LinkedList();
        if (r9.length() == 0) goto L9;
        r1.add(new b(d.f15113h, r9));
    L9:
        return r1;
    L10:
        int r2 = j(r9, r10);
        String r6 = r9.substring(0, r2);
        String r0 = r9.substring(r2);
        String r3 = r10.substring(r2);
        int r4 = k(r0, r3);
        String r7 = r0.substring(r0.length() - r4);
        LinkedList<b> r5 = l(r0.substring(0, r0.length() - r4), r3.substring(0, r3.length() - r4), r11, r12);
        if (r6.length() == 0) goto L14;
        r5.addFirst(new b(d.f15113h, r6));
    L14:
        if (r7.length() == 0) goto L16;
        r5.addLast(new b(d.f15113h, r7));
    L16:
        e(r5);
        return r5;
    L19:
        throw new IllegalArgumentException("Null inputs. (diff_main)");
    }

    private double z(int r1, int r2, int r3, String r4) {
        float r5 = r1 / r4.length();
        int r6 = Math.abs(r3 - r2);
        int r0 = this.f15099c;
        if (r0 != 0) goto L9;
        if (r6 == 0) goto L10;
        return 1.0d;
    L10:
        return r5;
    L9:
        return r5 + (r6 / r0);
    }

    public int A(String r3, String r4, int r5) {
        if (r3 == null) goto L19;
        if (r4 == null) goto L19;
        int r6 = Math.max(0, Math.min(r5, r3.length()));
        if (r3.equals(r4) == false) goto L8;
        return 0;
    L8:
        if (r3.length() != 0) goto L12;
        return -1;
    L12:
        if ((r4.length() + r6) > r3.length()) goto L17;
        if (r3.substring(r6, r4.length() + r6).equals(r4) == false) goto L17;
        return r6;
    L17:
        return y(r3, r4, r6);
    L19:
        throw new IllegalArgumentException("Null inputs. (match_main)");
    }

    public String B(LinkedList<e> r7) {
        int r6 = this.f15101e;
        short r0 = 1;
        String r1 = "";
    L3:
        if (r0 > r6) goto L5;
        r1 = r1 + String.valueOf((char) r0);
        r0 = (short) (r0 + 1);
        goto L3
    L5:
        Iterator<e> r2 = r7.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        e r3 = r2.next();
        r3.f15116b += r6;
        r3.f15117c += r6;
        goto L7
    L9:
        e r4 = r7.getFirst();
        LinkedList<b> r5 = r4.f15115a;
        if (r5.isEmpty() == false) goto L12;
    L17:
        r5.addFirst(new b(d.f15113h, r1));
        r4.f15116b -= r6;
        r4.f15117c -= r6;
        r4.f15118d += r6;
        int r8 = r4.f15119e + r6;
    L18:
        r4.f15119e = r8;
    L19:
        e r9 = r7.getLast();
        LinkedList<b> r10 = r9.f15115a;
        if (r10.isEmpty() == false) goto L22;
    L27:
        r10.addLast(new b(d.f15113h, r1));
    L28:
        r9.f15118d += r6;
        r9.f15119e += r6;
    L29:
        return r1;
    L22:
        if (r10.getLast().f15106a != d.f15113h) goto L27;
        if (r6 <= r10.getLast().f15107b.length()) goto L29;
        b r11 = r10.getLast();
        r6 = r6 - r11.f15107b.length();
        r11.f15107b += r1.substring(0, r6);
        goto L28
    L12:
        if (r5.getFirst().f15106a != d.f15113h) goto L17;
        if (r6 <= r5.getFirst().f15107b.length()) goto L19;
        b r12 = r5.getFirst();
        int r13 = r6 - r12.f15107b.length();
        r12.f15107b = r1.substring(r12.f15107b.length()) + r12.f15107b;
        r4.f15116b = r4.f15116b - r13;
        r4.f15117c = r4.f15117c - r13;
        r4.f15118d = r4.f15118d + r13;
        r8 = r4.f15119e + r13;
        goto L18
    }

    public Object[] C(LinkedList<e> r17, String r18) {
        if (r17.isEmpty() == true) goto L5;
        LinkedList<e> r2 = D(r17);
        String r6 = B(r2);
        String r1 = r6 + r18 + r6;
        F(r2);
        boolean[] r7 = new boolean[r2.size()];
        Iterator<e> r3 = r2.iterator();
        int r8 = 0;
        int r9 = 0;
    L8:
        if (r3.hasNext() == false) goto L51;
        e r10 = r3.next();
        int r11 = r10.f15117c + r8;
        String r12 = u(r10.f15115a);
        int r13 = r12.length();
        short r14 = this.f15102f;
        if (r13 <= r14) goto L17;
        int r15 = A(r1, r12.substring(0, r14), r11);
        if (r15 == (-1)) goto L18;
        int r4 = A(r1, r12.substring(r12.length() - this.f15102f), (r12.length() + r11) - this.f15102f);
        if (r4 == (-1)) goto L16;
        if (r15 >= r4) goto L16;
    L19:
        if (r15 != (-1)) goto L21;
        r7[r9] = false;
        r8 = r8 - (r10.f15119e - r10.f15118d);
    L49:
        r9 = r9 + 1;
        goto L8
    L21:
        r7[r9] = true;
        int r5 = r15 - r11;
        if (r4 != (-1)) goto L24;
        int r16 = r12.length() + r15;
    L25:
        String r19 = r1.substring(r15, Math.min(r16, r1.length()));
        if (r12.equals(r19) == false) goto L29;
        r1 = r1.substring(0, r15) + v(r10.f15115a) + r1.substring(r15 + r12.length());
    L28:
        r8 = r5;
        goto L49
    L29:
        LinkedList<b> r20 = s(r12, r19, false);
        if (r12.length() > this.f15102f) goto L32;
    L34:
        g(r20);
        Iterator<b> r21 = r10.f15115a.iterator();
        int r110 = 0;
    L36:
        if (r21.hasNext() == false) goto L28;
        b r111 = r21.next();
        if (r111.f15106a == d.f15113h) goto L47;
        int r112 = w(r20, r110);
        d r113 = r111.f15106a;
        if (r113 != d.f15112g) goto L44;
        StringBuilder r114 = new StringBuilder();
        int r115 = r112 + r15;
        r114.append(r1.substring(0, r115));
        r114.append(r111.f15107b);
    L42:
        r114.append(r1.substring(r115));
        r1 = r114.toString();
        goto L47
    L44:
        if (r113 != d.f15111f) goto L47;
        r114 = new StringBuilder();
        r114.append(r1.substring(0, r112 + r15));
        r115 = w(r20, r111.f15107b.length() + r110) + r15;
    L47:
        if (r111.f15106a == d.f15111f) goto L36;
        r110 = r110 + r111.f15107b.length();
        goto L36
    L32:
        if ((o(r20) / r12.length()) <= this.f15100d) goto L34;
        r7[r9] = false;
        goto L28
    L24:
        r16 = r4 + this.f15102f;
    L16:
        r15 = -1;
    L18:
        r4 = -1;
        goto L19
    L17:
        r15 = A(r1, r12, r11);
        goto L18
    L51:
        return new Object[]{r1.substring(r6.length(), r1.length() - r6.length()), r7};
    L5:
        return new Object[]{r18, new boolean[0]};
    }

    public LinkedList<e> D(LinkedList<e> r7) {
        LinkedList<e> r6 = new LinkedList();
        Iterator<e> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        e r0 = r8.next();
        e r1 = new e();
        Iterator<b> r2 = r0.f15115a.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        b r3 = r2.next();
        b r4 = new b(r3.f15106a, r3.f15107b);
        r1.f15115a.add(r4);
        goto L7
    L9:
        r1.f15116b = r0.f15116b;
        r1.f15117c = r0.f15117c;
        r1.f15118d = r0.f15118d;
        r1.f15119e = r0.f15119e;
        r6.add(r1);
        goto L4
    L10:
        return r6;
    }

    public List<e> E(String r9) {
        LinkedList r8 = new LinkedList();
        if (r9.length() != 0) goto L5;
        return r8;
    L5:
        LinkedList r0 = new LinkedList(Arrays.asList(r9.split("\n")));
        Pattern r10 = Pattern.compile("^@@ -(\\d+),?(\\d*) \\+(\\d+),?(\\d*) @@$");
    L7:
        if (r0.isEmpty() == true) goto L52;
        Matcher r1 = r10.matcher((CharSequence) r0.getFirst());
        if (r1.matches() == false) goto L51;
        e r2 = new e();
        r8.add(r2);
        r2.f15116b = Integer.parseInt(r1.group(1));
        if (r1.group(2).length() != 0) goto L14;
        r2.f15116b--;
        r2.f15118d = 1;
    L17:
        r2.f15117c = Integer.parseInt(r1.group(3));
        if (r1.group(4).length() != 0) goto L21;
        r2.f15117c--;
        r2.f15119e = 1;
    L24:
        r0.removeFirst();
        if (r0.isEmpty() == true) goto L7;
        char r3 = ((String) r0.getFirst()).charAt(0);     // Catch: IndexOutOfBoundsException -> L53
        String r4 = ((String) r0.getFirst()).substring(1).replace("+", "%2B");
        String r5 = URLDecoder.decode(r4, "UTF-8");     // Catch: IllegalArgumentException -> L44 UnsupportedEncodingException -> L47
    L30:
        if (r3 != '-') goto L34;
        LinkedList<b> r6 = r2.f15115a;
        b r7 = new b(d.f15111f, r5);
    L32:
        r6.add(r7);
        goto L24
    L34:
        if (r3 != '+') goto L37;
        r6 = r2.f15115a;
        r7 = new b(d.f15112g, r5);
        goto L32
    L37:
        if (r3 != ' ') goto L40;
        r6 = r2.f15115a;
        r7 = new b(d.f15113h, r5);
        goto L32
    L40:
        if (r3 == '@') goto L7;
        throw new IllegalArgumentException("Invalid patch mode '" + r3 + "' in: " + r5);
    L47:
        e = move-exception;
        throw new Error("This system does not support UTF-8.", e);
    L44:
        e = move-exception;
        throw new IllegalArgumentException("Illegal escape in patch_fromText: " + r4, e);
    L21:
        if (r1.group(4).equals(BDLocationException.ERROR_TIMEOUT) == false) goto L23;
        r2.f15119e = 0;
        goto L24
    L23:
        r2.f15117c--;
        r2.f15119e = Integer.parseInt(r1.group(4));
        goto L24
    L14:
        if (r1.group(2).equals(BDLocationException.ERROR_TIMEOUT) == false) goto L16;
        r2.f15118d = 0;
        goto L17
    L16:
        r2.f15116b--;
        r2.f15118d = Integer.parseInt(r1.group(2));
        goto L17
    L51:
        throw new IllegalArgumentException("Invalid patch string: " + ((String) r0.getFirst()));
    L52:
        return r8;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:4:0x000d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01f5 -> B:4:0x000d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x0014 -> B:6:0x0015). Please report as a decompilation issue!!! */
    public void F(LinkedList<e> r15) {
        short r0 = this.f15102f;
        ListIterator<e> r16 = r15.listIterator();
        if (r16.hasNext() == false) goto L5;
    L4:
        e r1 = r16.next();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.f15118d <= this.f15102f) goto L10;
        r16.remove();
        int r3 = r1.f15116b;
        int r4 = r1.f15117c;
        String r5 = "";
    L14:
        if (r1.f15115a.isEmpty() == true) goto L59;
        e r6 = new e();
        r6.f15116b = r3 - r5.length();
        r6.f15117c = r4 - r5.length();
        if (r5.length() == 0) goto L18;
        int r7 = r5.length();
        r6.f15119e = r7;
        r6.f15118d = r7;
        r6.f15115a.add(new b(d.f15113h, r5));
    L18:
        boolean r8 = true;
    L20:
        if (r1.f15115a.isEmpty() == true) goto L44;
        if (r6.f15118d >= (r0 - this.f15101e)) goto L44;
        d r9 = r1.f15115a.getFirst().f15106a;
        String r10 = r1.f15115a.getFirst().f15107b;
        if (r9 == d.f15112g) goto L25;
        if (r9 != d.f15111f) goto L36;
        if (r6.f15115a.size() != 1) goto L36;
        if (r6.f15115a.getFirst().f15106a != d.f15113h) goto L36;
        if (r10.length() <= (r0 * 2)) goto L36;
        r6.f15118d += r10.length();
        r3 = r3 + r10.length();
        r6.f15115a.add(new b(r9, r10));
        r1.f15115a.removeFirst();
    L26:
        r8 = false;
    L36:
        String r11 = r10.substring(0, Math.min(r10.length(), (r0 - r6.f15118d) - this.f15101e));
        r6.f15118d += r11.length();
        r3 = r3 + r11.length();
        if (r9 != d.f15113h) goto L39;
        r6.f15119e += r11.length();
        r4 = r4 + r11.length();
    L40:
        r6.f15115a.add(new b(r9, r11));
        if (r11.equals(r1.f15115a.getFirst().f15107b) == true) goto L42;
        r1.f15115a.getFirst().f15107b = r1.f15115a.getFirst().f15107b.substring(r11.length());
        goto L20
    L42:
        r1.f15115a.removeFirst();
        goto L20
    L39:
        r8 = false;
        goto L40
    L25:
        r6.f15119e += r10.length();
        r4 = r4 + r10.length();
        r6.f15115a.addLast(r1.f15115a.removeFirst());
    L44:
        String r12 = v(r6.f15115a);
        r5 = r12.substring(Math.max(0, r12.length() - this.f15101e));
        if (u(r1.f15115a).length() <= this.f15101e) goto L47;
        String r13 = u(r1.f15115a).substring(0, this.f15101e);
    L49:
        if (r13.length() == 0) goto L56;
        r6.f15118d += r13.length();
        r6.f15119e += r13.length();
        if (r6.f15115a.isEmpty() == false) goto L53;
    L55:
        r6.f15115a.add(new b(d.f15113h, r13));
        goto L56
    L53:
        if (r6.f15115a.getLast().f15106a != d.f15113h) goto L55;
        StringBuilder r14 = new StringBuilder();
        b r17 = r6.f15115a.getLast();
        r14.append(r17.f15107b);
        r14.append(r13);
        r17.f15107b = r14.toString();
    L56:
        if (r8 == true) goto L14;
        r16.add(r6);
        goto L14
    L47:
        r13 = u(r1.f15115a);
        goto L49
    L59:
        if (r16.hasNext() == false) goto L5;
    L10:
        if (r16.hasNext() == true) goto L4;
    L5:
        r1 = null;
        goto L6
    }

    protected LinkedList<b> b(String r25, String r26, long r27) {
        int r0 = r25.length();
        int r3 = r26.length();
        int r4 = ((r0 + r3) + 1) / 2;
        int r6 = r4 * 2;
        int[] r7 = new int[r6];
        int[] r8 = new int[r6];
        int r9 = 0;
        int r10 = 0;
    L4:
        if (r10 >= r6) goto L6;
        r7[r10] = -1;
        r8[r10] = -1;
        r10 = r10 + 1;
        goto L4
    L6:
        int r11 = r4 + 1;
        r7[r11] = 0;
        r8[r11] = 0;
        int r12 = r0 - r3;
        if ((r12 % 2) == 0) goto L9;
        boolean r13 = true;
    L10:
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L11:
        if (r9 >= r4) goto L90;
        if (System.currentTimeMillis() > r27) goto L90;
        int r18 = -r9;
        int r19 = r15;
        int r5 = r18 + r14;
    L17:
        if (r5 > (r9 - r16)) goto L51;
        int r110 = r4 + r5;
        if (r5 == r18) goto L26;
        if (r5 == r9) goto L24;
        int r21 = r9;
        int r22 = r18;
        if (r7[r110 - 1] < r7[r110 + 1]) goto L27;
    L25:
        int r20 = r7[r110 - 1] + 1;
    L28:
        int r111 = r20 - r5;
    L29:
        if (r20 >= r0) goto L34;
        if (r111 >= r3) goto L34;
        int[] r23 = r8;
        if (r25.charAt(r20) != r26.charAt(r111)) goto L35;
        r20 = r20 + 1;
        r111 = r111 + 1;
        r25 = r25;
        r8 = r23;
    L35:
        r7[r110] = r20;
        if (r20 <= r0) goto L38;
        r16 = r16 + 2;
    L50:
        r5 = r5 + 2;
        r25 = r25;
        r8 = r23;
        r9 = r21;
        r18 = r22;
        goto L17
    L38:
        if (r111 <= r3) goto L40;
        r14 = r14 + 2;
        goto L50
    L40:
        if (r13 == false) goto L50;
        int r1 = (r4 + r12) - r5;
        if (r1 < 0) goto L50;
        if (r1 >= r6) goto L50;
        if (r23[r1] == (-1)) goto L50;
        if (r20 < (r0 - r23[r1])) goto L50;
        return c(r25, r26, r20, r111, r27);
    L34:
        r23 = r8;
    L27:
        r20 = r7[r110 + 1];
        goto L28
    L24:
        r21 = r9;
        r22 = r18;
        goto L25
    L26:
        r21 = r9;
        r22 = r18;
        goto L27
    L51:
        int[] r24 = r8;
        int r28 = r9;
        int r29 = r18;
        int r112 = r29 + r19;
        r15 = r19;
    L53:
        if (r112 > (r28 - r17)) goto L89;
        int r2 = r4 + r112;
        int r30 = r29;
        if (r112 == r30) goto L63;
        int r31 = r28;
        if (r112 == r31) goto L61;
        r29 = r30;
        if (r24[r2 - 1] < r24[r2 + 1]) goto L64;
    L62:
        int r32 = r24[r2 - 1] + 1;
    L65:
        int r33 = r32 - r112;
    L66:
        if (r32 >= r0) goto L71;
        if (r33 >= r3) goto L71;
        int r210 = r14;
        int r113 = r16;
        if (r25.charAt((r0 - r32) - 1) != r26.charAt((r3 - r33) - 1)) goto L72;
        r32 = r32 + 1;
        r33 = r33 + 1;
        r16 = r113;
        r14 = r210;
    L72:
        r24[r2] = r32;
        if (r32 <= r0) goto L76;
        r17 = r17 + 2;
    L88:
        r112 = r112 + 2;
        r16 = r113;
        r14 = r210;
        r28 = r31;
        goto L53
    L76:
        if (r33 <= r3) goto L78;
        r15 = r15 + 2;
        goto L88
    L78:
        if (r13 == true) goto L88;
        int r34 = (r4 + r12) - r112;
        if (r34 < 0) goto L88;
        if (r34 >= r6) goto L88;
        if (r7[r34] == (-1)) goto L88;
        int r35 = r7[r34];
        int r114 = (r4 + r35) - r34;
        if (r35 < (r0 - r32)) goto L88;
        return c(r25, r26, r35, r114, r27);
    L71:
        r210 = r14;
        r113 = r16;
    L64:
        r32 = r24[r2 + 1];
        goto L65
    L61:
        r29 = r30;
        goto L62
    L63:
        r29 = r30;
        r31 = r28;
        goto L64
    L89:
        r9 = r28 + 1;
        r8 = r24;
        r14 = r14;
    L90:
        LinkedList<b> r36 = new LinkedList();
        r36.add(new b(d.f15111f, r25));
        r36.add(new b(d.f15112g, r26));
        return r36;
    L9:
        r13 = false;
        goto L10
    }

    protected void d(List<b> r4, List<String> r5) {
        Iterator<b> r3 = r4.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        b r6 = r3.next();
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L7:
        if (r1 >= r6.f15107b.length()) goto L9;
        r0.append(r5.get(r6.f15107b.charAt(r1)));
        r1 = r1 + 1;
        goto L7
    L9:
        r6.f15107b = r0.toString();
        goto L4
    }

    public void e(LinkedList<b> r15) {
        r15.add(new b(d.f15113h, ""));
        ListIterator<b> r0 = r15.listIterator();
        b r1 = r0.next();
        String r6 = "";
        String r8 = r6;
        b r9 = null;
        int r5 = 0;
        int r7 = 0;
    L3:
        boolean r10 = true;
        if (r1 == null) goto L57;
        int r11 = C0407a.f15105a[r1.f15106a.ordinal()];
        if (r11 != 1) goto L8;
        r5 = r5 + 1;
        r6 = r6 + r1.f15107b;
    L51:
        r9 = null;
    L53:
        if (r0.hasNext() == true) goto L54;
        r1 = null;
        goto L3
    L54:
        r1 = r0.next();
        goto L3
    L8:
        if (r11 != 2) goto L10;
        r7 = r7 + 1;
        r8 = r8 + r1.f15107b;
        goto L51
    L10:
        if (r11 != 3) goto L53;
        if ((r7 + r5) <= 1) goto L46;
        if (r7 == 0) goto L17;
        if (r5 == 0) goto L17;
    L18:
        r0.previous();
    L19:
        int r2 = r7 - 1;
        if (r7 <= 0) goto L22;
        r0.previous();
        r0.remove();
        r7 = r2;
    L22:
        int r3 = r5 - 1;
        if (r5 <= 0) goto L25;
        r0.previous();
        r0.remove();
        r5 = r3;
        goto L22
    L25:
        if (r10 == false) goto L37;
        int r4 = j(r6, r8);
        if (r4 != 0) goto L29;
    L33:
        int r12 = k(r6, r8);
        if (r12 == 0) goto L37;
        b r13 = r0.next();
        r13.f15107b = r6.substring(r6.length() - r12) + r13.f15107b;
        r6 = r6.substring(0, r6.length() - r12);
        r8 = r8.substring(0, r8.length() - r12);
        r0.previous();
        goto L37
    L29:
        if (r0.hasPrevious() == false) goto L31;
        r0.previous().f15107b += r6.substring(0, r4);
        r0.next();
    L32:
        String r14 = r6.substring(r4);
        r8 = r8.substring(r4);
        r6 = r14;
        goto L33
    L31:
        r0.add(new b(d.f15113h, r6.substring(0, r4)));
    L37:
        if (r8.length() == 0) goto L40;
        r0.add(new b(d.f15111f, r8));
    L40:
        if (r6.length() == 0) goto L43;
        r0.add(new b(d.f15112g, r6));
    L43:
        if (r0.hasNext() == false) goto L45;
        r1 = r0.next();
    L48:
        r9 = r1;
        r6 = "";
        r8 = r6;
        r5 = 0;
        r7 = 0;
        goto L53
    L45:
        r1 = null;
    L17:
        r10 = false;
        goto L18
    L46:
        if (r9 == null) goto L48;
        r9.f15107b += r1.f15107b;
        r0.remove();
        r1 = r0.previous();
        r0.next();
        goto L48
    L57:
        if (r15.getLast().f15107b.length() != 0) goto L59;
        r15.removeLast();
    L59:
        ListIterator<b> r16 = r15.listIterator();
        if (r16.hasNext() == false) goto L62;
        b r17 = r16.next();
    L64:
        if (r16.hasNext() == false) goto L66;
        b r18 = r16.next();
    L68:
        if (r16.hasNext() == false) goto L70;
        b r19 = r16.next();
    L71:
        boolean r20 = false;
    L72:
        if (r19 == null) goto L96;
        d r21 = r17.f15106a;
        d r22 = d.f15113h;
        if (r21 == r22) goto L76;
    L91:
        r17 = r18;
        r18 = r19;
    L93:
        if (r16.hasNext() == true) goto L94;
        r19 = null;
        goto L72
    L94:
        r19 = r16.next();
        goto L72
    L76:
        if (r19.f15106a != r22) goto L91;
        if (r18.f15107b.endsWith(r17.f15107b) == false) goto L85;
        StringBuilder r23 = new StringBuilder();
        r23.append(r17.f15107b);
        String r24 = r18.f15107b;
        r23.append(r24.substring(0, r24.length() - r17.f15107b.length()));
        r18.f15107b = r23.toString();
        r19.f15107b = r17.f15107b + r19.f15107b;
        r16.previous();
        r16.previous();
        r16.previous();
        r16.remove();
        r16.next();
        r17 = r16.next();
        if (r16.hasNext() == false) goto L82;
        r18 = r16.next();
    L83:
        r20 = true;
        goto L93
    L82:
        r18 = null;
        goto L83
    L85:
        if (r18.f15107b.startsWith(r19.f15107b) == false) goto L91;
        r17.f15107b += r19.f15107b;
        r18.f15107b = r18.f15107b.substring(r19.f15107b.length()) + r19.f15107b;
        r16.remove();
        if (r16.hasNext() == false) goto L89;
        b r25 = r16.next();
    L90:
        r20 = true;
        b r110 = r18;
        r18 = r25;
        r17 = r110;
        goto L93
    L89:
        r25 = null;
        goto L90
    L96:
        if (r20 == false) goto L113;
        e(r15);
        return;
    L113:
        return;
    L70:
        r19 = null;
        goto L71
    L66:
        r18 = null;
        goto L68
    L62:
        r17 = null;
        goto L64
    }

    public void f(LinkedList<b> r17) {
        if (r17.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayDeque r1 = new ArrayDeque();
        ListIterator<b> r2 = r17.listIterator();
        b r3 = r2.next();
        int r5 = 0;
        boolean r6 = false;
        int r7 = 0;
        int r8 = 0;
        int r10 = 0;
        int r11 = 0;
        String r9 = null;
    L6:
        if (r3 == null) goto L39;
        d r12 = r3.f15106a;
        if (r12 != d.f15113h) goto L11;
        r1.push(r3);
        r9 = r3.f15107b;
        r10 = r7;
        r11 = r8;
        r7 = 0;
        r8 = 0;
    L36:
        if (r2.hasNext() == true) goto L37;
        r3 = null;
        goto L6
    L37:
        r3 = r2.next();
        goto L6
    L11:
        if (r12 != d.f15112g) goto L13;
        r7 = r7 + r3.f15107b.length();
    L14:
        if (r9 == null) goto L36;
        if (r9.length() > Math.max(r10, r11)) goto L36;
        if (r9.length() > Math.max(r7, r8)) goto L36;
    L20:
        if (r3 == r1.peek()) goto L22;
        r3 = r2.previous();
        goto L20
    L22:
        r2.next();
        r2.set(new b(d.f15111f, r9));
        r2.add(new b(d.f15112g, r9));
        r1.pop();
        if (r1.isEmpty() == true) goto L26;
        r1.pop();
    L26:
        if (r1.isEmpty() == false) goto L32;
    L28:
        if (r2.hasPrevious() == false) goto L34;
        r2.previous();
    L34:
        r6 = true;
        r7 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 0;
        r9 = null;
    L32:
        if (((b) r1.peek()) == r2.previous()) goto L34;
    L13:
        r8 = r8 + r3.f15107b.length();
        goto L14
    L39:
        if (r6 == false) goto L41;
        e(r17);
    L41:
        g(r17);
        ListIterator<b> r4 = r17.listIterator();
        if (r4.hasNext() == false) goto L46;
        b r13 = r4.next();
        if (r4.hasNext() == false) goto L47;
        b r14 = r4.next();
    L48:
        if (r14 == null) goto L78;
        d r15 = r13.f15106a;
        d r16 = d.f15111f;
        if (r15 != r16) goto L72;
        d r18 = r14.f15106a;
        d r19 = d.f15112g;
        if (r18 != r19) goto L72;
        String r20 = r13.f15107b;
        String r21 = r14.f15107b;
        int r110 = i(r20, r21);
        int r111 = i(r21, r20);
        if (r110 < r111) goto L61;
        double r22 = r110;
        if (r22 < (((double) r20.length()) / 2.0d)) goto L58;
    L59:
        r4.previous();
        r4.add(new b(d.f15113h, r21.substring(r5, r110)));
        r13.f15107b = r20.substring(r5, r20.length() - r110);
        r14.f15107b = r21.substring(r110);
    L60:
        int r112 = r5;
    L69:
        if (r4.hasNext() == false) goto L71;
        r13 = r4.next();
    L74:
        if (r4.hasNext() == false) goto L76;
        r14 = r4.next();
    L77:
        r5 = r112;
        goto L48
    L76:
        r14 = null;
        goto L77
    L71:
        r13 = null;
        goto L74
    L58:
        if (r22 < (((double) r21.length()) / 2.0d)) goto L60;
    L61:
        double r113 = r111;
        if (r113 < (((double) r20.length()) / 2.0d)) goto L64;
    L67:
        r4.previous();
        r112 = 0;
        r4.add(new b(d.f15113h, r20.substring(0, r111)));
        r13.f15106a = r19;
        r13.f15107b = r21.substring(0, r21.length() - r111);
        r14.f15106a = r16;
        r14.f15107b = r20.substring(r111);
        goto L69
    L64:
        if (r113 >= (((double) r21.length()) / 2.0d)) goto L67;
        r112 = 0;
    L72:
        r112 = r5;
        r13 = r14;
        goto L74
    L78:
        return;
    L47:
        r14 = null;
        goto L48
    L46:
        r13 = null;
        goto L47
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x011d -> B:12:0x0027). Please report as a decompilation issue!!! */
    public void g(LinkedList<b> r15) {
        ListIterator<b> r16 = r15.listIterator();
        if (r16.hasNext() == false) goto L5;
        b r0 = r16.next();
    L7:
        if (r16.hasNext() == false) goto L9;
        b r2 = r16.next();
    L11:
        if (r16.hasNext() == false) goto L13;
    L12:
        b r3 = r16.next();
    L14:
        if (r3 == null) goto L46;
        d r4 = r0.f15106a;
        d r5 = d.f15113h;
        if (r4 == r5) goto L18;
    L42:
        r0 = r2;
        r2 = r3;
    L44:
        if (r16.hasNext() == true) goto L12;
    L13:
        r3 = null;
        goto L14
    L18:
        if (r3.f15106a != r5) goto L42;
        String r6 = r0.f15107b;
        String r7 = r2.f15107b;
        String r8 = r3.f15107b;
        int r9 = k(r6, r7);
        if (r9 == 0) goto L22;
        String r10 = r7.substring(r7.length() - r9);
        r6 = r6.substring(0, r6.length() - r9);
        r7 = r10 + r7.substring(0, r7.length() - r9);
        r8 = r10 + r8;
    L22:
        String r11 = r8;
        String r12 = r11;
        int r13 = h(r6, r7) + h(r7, r8);
        String r14 = r7;
        String r17 = r14;
        String r18 = r6;
    L24:
        if (r14.length() == 0) goto L33;
        if (r11.length() == 0) goto L33;
        if (r14.charAt(0) != r11.charAt(0)) goto L33;
        r18 = r18 + r14.charAt(0);
        r14 = r14.substring(1) + r11.charAt(0);
        r11 = r11.substring(1);
        int r19 = h(r18, r14) + h(r14, r11);
        if (r19 < r13) goto L24;
        r6 = r18;
        r17 = r14;
        r12 = r11;
        r13 = r19;
    L33:
        if (r0.f15107b.equals(r6) == true) goto L42;
        if (r6.length() == 0) goto L37;
        r0.f15107b = r6;
    L38:
        r2.f15107b = r17;
        if (r12.length() == 0) goto L41;
        r3.f15107b = r12;
        goto L42
    L41:
        r16.remove();
        goto L44
    L37:
        r16.previous();
        r16.previous();
        r16.previous();
        r16.remove();
        r16.next();
        r16.next();
        goto L38
    L46:
        return;
    L47:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }

    protected int i(String r7, String r8) {
        int r6 = r7.length();
        int r0 = r8.length();
        if (r6 == 0) goto L22;
        if (r0 == 0) goto L22;
        if (r6 <= r0) goto L8;
        r7 = r7.substring(r6 - r0);
    L10:
        int r9 = Math.min(r6, r0);
        if (r7.equals(r8) == false) goto L13;
        return r9;
    L13:
        int r1 = 1;
        int r2 = 0;
    L14:
        int r3 = r8.indexOf(r7.substring(r9 - r1));
        if (r3 == (-1)) goto L16;
        r1 = r1 + r3;
        if (r3 == 0) goto L21;
        if (r7.substring(r9 - r1).equals(r8.substring(0, r1)) == false) goto L14;
    L21:
        r2 = r1;
        r1 = r1 + 1;
        goto L14
    L16:
        return r2;
    L8:
        if (r6 >= r0) goto L10;
        r8 = r8.substring(0, r6);
    L22:
        return 0;
    }

    public int j(String r4, String r5) {
        int r3 = Math.min(r4.length(), r5.length());
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L8;
        if (r4.charAt(r0) != r5.charAt(r0)) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return r0;
    L8:
        return r3;
    }

    public int k(String r7, String r8) {
        int r6 = r7.length();
        int r0 = r8.length();
        int r1 = Math.min(r6, r0);
        int r3 = 1;
    L3:
        if (r3 > r1) goto L9;
        if (r7.charAt(r6 - r3) != r8.charAt(r0 - r3)) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        return r3 - 1;
    L9:
        return r1;
    }

    protected String[] m(String r10, String r11) {
        if (this.f15097a > 0.0f) goto L6;
        return null;
    L6:
        if (r10.length() <= r11.length()) goto L8;
        String r0 = r10;
    L10:
        if (r10.length() <= r11.length()) goto L12;
        String r2 = r11;
    L14:
        if (r0.length() >= 4) goto L16;
    L33:
        return null;
    L16:
        if ((r2.length() * 2) < r0.length()) goto L33;
        String[] r3 = n(r0, r2, (r0.length() + 3) / 4);
        String[] r9 = n(r0, r2, (r0.length() + 1) / 2);
        if (r3 != null) goto L22;
        if (r9 != null) goto L22;
        return null;
    L22:
        if (r9 == null) goto L29;
        if (r3 != null) goto L27;
    L25:
        r3 = r9;
        goto L29
    L27:
        if (r3[4].length() <= r9[4].length()) goto L25;
    L29:
        if (r10.length() <= r11.length()) goto L32;
        return r3;
    L32:
        return new String[]{r3[2], r3[3], r3[0], r3[1], r3[4]};
    L12:
        r2 = r10;
        goto L14
    L8:
        r0 = r11;
        goto L10
    }

    public int o(List<b> r7) {
        Iterator<b> r6 = r7.iterator();
        int r0 = 0;
        int r1 = 0;
    L3:
        int r2 = r1;
    L5:
        if (r6.hasNext() == false) goto L17;
        b r3 = r6.next();
        int r4 = C0407a.f15105a[r3.f15106a.ordinal()];
        if (r4 != 1) goto L9;
        r1 = r1 + r3.f15107b.length();
        goto L5
    L9:
        if (r4 != 2) goto L11;
        r2 = r2 + r3.f15107b.length();
        goto L5
    L11:
        if (r4 != 3) goto L5;
        r0 = r0 + Math.max(r1, r2);
        r1 = 0;
        goto L3
    L17:
        return r0 + Math.max(r1, r2);
    }

    protected c q(String r4, String r5) {
        ArrayList r0 = new ArrayList();
        HashMap r1 = new HashMap();
        r0.add("");
        return new c(r(r4, r0, r1, 40000), r(r5, r0, r1, SupportMenu.USER_MASK), r0);
    }

    public LinkedList<b> s(String r9, String r10, boolean r11) {
        if (this.f15097a > 0.0f) goto L5;
        long r0 = LocationRequestCompat.PASSIVE_INTERVAL;
    L7:
        return t(r9, r10, r11, r0);
    L5:
        r0 = System.currentTimeMillis() + ((long) (this.f15097a * 1000.0f));
        goto L7
    }

    public String u(List<b> r4) {
        StringBuilder r3 = new StringBuilder();
        Iterator<b> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        b r0 = r5.next();
        if (r0.f15106a == d.f15112g) goto L4;
        r3.append(r0.f15107b);
        goto L4
    L9:
        return r3.toString();
    }

    public String v(List<b> r4) {
        StringBuilder r3 = new StringBuilder();
        Iterator<b> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        b r0 = r5.next();
        if (r0.f15106a == d.f15111f) goto L4;
        r3.append(r0.f15107b);
        goto L4
    L9:
        return r3.toString();
    }

    public int w(List<b> r7, int r8) {
        Iterator<b> r6 = r7.iterator();
        int r9 = 0;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r6.hasNext() == false) goto L14;
        b r3 = r6.next();
        if (r3.f15106a == d.f15112g) goto L9;
        r9 = r9 + r3.f15107b.length();
    L9:
        if (r3.f15106a == d.f15111f) goto L11;
        r0 = r0 + r3.f15107b.length();
    L11:
        if (r9 > r8) goto L15;
        r1 = r9;
        r2 = r0;
    L15:
        if (r3 == null) goto L20;
        if (r3.f15106a != d.f15111f) goto L20;
        return r2;
    L20:
        return r2 + (r8 - r1);
    L14:
        r3 = null;
        goto L15
    }

    protected Map<Character, Integer> x(String r9) {
        HashMap r8 = new HashMap();
        char[] r0 = r9.toCharArray();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r8.put(Character.valueOf(r0[r3]), 0);
        r3 = r3 + 1;
        goto L3
    L5:
        int r4 = r0.length;
        int r5 = 0;
    L6:
        if (r2 >= r4) goto L8;
        char r6 = r0[r2];
        r8.put(Character.valueOf(r6), Integer.valueOf(((Integer) r8.get(Character.valueOf(r6))).intValue() | (1 << ((r9.length() - r5) - 1))));
        r5 = r5 + 1;
        r2 = r2 + 1;
        goto L6
    L8:
        return r8;
    }

    protected int y(String r22, String r23, int r24) {
        Map<Character, Integer> r4 = x(r23);
        double r5 = this.f15098b;
        int r7 = r22.indexOf(r23, r24);
        int r8 = -1;
        int r9 = 0;
        if (r7 == (-1)) goto L7;
        r5 = Math.min(z(0, r7, r24, r23), r5);
        int r10 = r22.lastIndexOf(r23, r23.length() + r24);
        if (r10 == (-1)) goto L7;
        r5 = Math.min(z(0, r10, r24, r23), r5);
    L7:
        int r11 = 1;
        int r12 = 1 << (r23.length() - 1);
        int r13 = r23.length() + r22.length();
        int[] r14 = new int[0];
        int r15 = 0;
    L9:
        if (r15 >= r23.length()) goto L43;
        int r16 = r9;
        int r17 = r13;
    L11:
        if (r16 >= r13) goto L17;
        if (z(r15, r24 + r13, r24, r23) > r5) goto L15;
        r16 = r13;
    L16:
        r13 = ((r17 - r16) / 2) + r16;
        goto L11
    L15:
        r17 = r13;
        goto L16
    L17:
        int r18 = Math.max(r11, (r24 - r13) + r11);
        int r19 = Math.min(r24 + r13, r22.length()) + r23.length();
        int[] r110 = new int[r19 + 2];
        r110[r19 + 1] = (r11 << r15) - 1;
    L18:
        if (r19 < r18) goto L39;
        int r111 = r8;
        r8 = r19 - 1;
        if (r22.length() > r8) goto L22;
    L25:
        int r112 = 0;
    L26:
        if (r15 != 0) goto L28;
        r110[r19] = ((r110[r19 + 1] << 1) | 1) & r112;
    L30:
        if ((r110[r19] & r12) == 0) goto L36;
        double r113 = z(r15, r8, r24, r23);
        if (r113 > r5) goto L36;
        if (r8 <= r24) goto L35;
        r11 = 1;
        r18 = Math.max(1, (r24 * 2) - r8);
        r5 = r113;
    L37:
        r19 = r19 - 1;
        goto L18
    L35:
        r11 = 1;
        r5 = r113;
    L36:
        r11 = 1;
        r8 = r111;
        goto L37
    L28:
        int r114 = r19 + 1;
        r110[r19] = ((((r110[r114] << 1) | 1) & r112) | (((r14[r114] | r14[r19]) << 1) | 1)) | r14[r114];
        goto L30
    L22:
        if (r4.containsKey(Character.valueOf(r22.charAt(r8))) == false) goto L25;
        r112 = r4.get(Character.valueOf(r22.charAt(r8))).intValue();
    L39:
        r15 = r15 + 1;
        if (z(r15, r24, r24, r23) > r5) goto L43;
        r14 = r110;
        r9 = 0;
    L43:
        return r8;
    }
}
