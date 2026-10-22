package p000j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f18197a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f18198a;

        public a() {
            this.f18198a = new ArrayList(20);
        }

        public a a(String r1, String r2) {
            v.b(r1);
            v.c(r2, r1);
            c(r1, r2);
            return this;
        }

        a b(String r5) {
            int r2 = r5.indexOf(":", 1);
            if (r2 == (-1)) goto L7;
            c(r5.substring(0, r2), r5.substring(r2 + 1));
            return this;
        L7:
            if (r5.startsWith(":") == false) goto L10;
            c("", r5.substring(1));
            return this;
        L10:
            c("", r5);
            return this;
        }

        a c(String r2, String r3) {
            this.f18198a.add(r2);
            this.f18198a.add(r3.trim());
            return this;
        }

        public v d() {
            return new v(this);
        }

        public a e(String r3) {
            int r0 = 0;
        L4:
            if (r0 >= this.f18198a.size()) goto L9;
            if (r3.equalsIgnoreCase(this.f18198a.get(r0)) == false) goto L8;
            this.f18198a.remove(r0);
            this.f18198a.remove(r0);
            r0 = r0 - 2;
        L8:
            r0 = r0 + 2;
            goto L4
        L9:
            return this;
        }

        public a f(String r1, String r2) {
            v.b(r1);
            v.c(r2, r1);
            e(r1);
            c(r1, r2);
            return this;
        }
    }

    v(a r2) {
        List<String> r3 = r2.f18198a;
        this.f18197a = (String[]) r3.toArray(new String[r3.size()]);
    }

    private v(String[] r1) {
        this.f18197a = r1;
    }

    static void b(String r5) {
        Objects.requireNonNull(r5, "name == null");
        if (r5.isEmpty() == true) goto L15;
        int r0 = r5.length();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L13;
        char r3 = r5.charAt(r2);
        if (r3 <= ' ') goto L12;
        if (r3 >= 127) goto L12;
        r2 = r2 + 1;
    L12:
        throw new IllegalArgumentException(c.r("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r3), Integer.valueOf(r2), r5}));
    L13:
        return;
    L15:
        throw new IllegalArgumentException("name is empty");
    }

    static void c(String r5, String r6) {
        if (r5 == null) goto L16;
        int r0 = r5.length();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L14;
        char r3 = r5.charAt(r2);
        if (r3 > 31) goto L10;
        if (r3 == '\t') goto L10;
    L13:
        throw new IllegalArgumentException(c.r("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(r3), Integer.valueOf(r2), r6, r5}));
    L10:
        if (r3 >= 127) goto L13;
        r2 = r2 + 1;
        goto L4
    L14:
        return;
    L16:
        throw new NullPointerException("value for name " + r6 + " == null");
    }

    private static String e(String[] r2, String r3) {
        int r0 = r2.length - 2;
    L3:
        if (r0 < 0) goto L9;
        if (r3.equalsIgnoreCase(r2[r0]) == true) goto L7;
        r0 = r0 - 2;
        goto L3
    L7:
        return r2[r0 + 1];
    L9:
        return null;
    }

    public static v i(Map<String, String> r4) {
        Objects.requireNonNull(r4, "headers == null");
        String[] r0 = new String[r4.size() * 2];
        int r1 = 0;
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, String> r2 = r5.next();
        if (r2.getKey() == null) goto L11;
        if (r2.getValue() == null) goto L11;
        String r3 = r2.getKey().trim();
        String r6 = r2.getValue().trim();
        b(r3);
        c(r6, r3);
        r0[r1] = r3;
        r0[r1 + 1] = r6;
        r1 = r1 + 2;
    L11:
        throw new IllegalArgumentException("Headers cannot be null");
    L13:
        return new v(r0);
    }

    public static v j(String... r3) {
        Objects.requireNonNull(r3, "namesAndValues == null");
        if ((r3.length % 2) != 0) goto L18;
        String[] r4 = (String[]) r3.clone();
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r1 >= r4.length) goto L13;
        if (r4[r1] == null) goto L11;
        r4[r1] = r4[r1].trim();
        r1 = r1 + 1;
        goto L6
    L11:
        throw new IllegalArgumentException("Headers cannot be null");
    L13:
        if (r0 >= r4.length) goto L16;
        String r2 = r4[r0];
        String r5 = r4[r0 + 1];
        b(r2);
        c(r5, r2);
        r0 = r0 + 2;
        goto L13
    L16:
        return new v(r4);
    L18:
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    public long a() {
        String[] r0 = this.f18197a;
        long r1 = r0.length * 2;
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1 = r1 + ((long) this.f18197a[r3].length());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public String d(String r1) {
        return e(this.f18197a, r1);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof v) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(((v) r2).f18197a, this.f18197a) == false) goto L7;
        return true;
    }

    public String f(int r1) {
        return this.f18197a[r1 * 2];
    }

    public Set<String> g() {
        TreeSet r0 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int r1 = k();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(f(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return Collections.unmodifiableSet(r0);
    }

    public a h() {
        a r0 = new a();
        Collections.addAll(r0.f18198a, this.f18197a);
        return r0;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f18197a);
    }

    public int k() {
        return this.f18197a.length / 2;
    }

    public Map<String, List<String>> l() {
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int r1 = k();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = f(r2).toLowerCase(Locale.US);
        List r4 = (List) r0.get(r3);
        if (r4 != null) goto L7;
        r4 = new ArrayList(2);
        r0.put(r3, r4);
    L7:
        r4.add(m(r2));
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public String m(int r1) {
        return this.f18197a[(r1 * 2) + 1];
    }

    public List<String> n(String r5) {
        int r0 = k();
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        if (r5.equalsIgnoreCase(f(r2)) == false) goto L9;
        if (r1 != null) goto L8;
        r1 = new ArrayList(2);
    L8:
        r1.add(m(r2));
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r1 == null) goto L13;
        return Collections.unmodifiableList(r1);
    L13:
        return Collections.emptyList();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = k();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.append(f(r2));
        r0.append(": ");
        r0.append(m(r2));
        r0.append("\n");
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toString();
    }
}
