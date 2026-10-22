package p000j;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f18217e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f18218f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18222d;

    static {
        f18217e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        f18218f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private y(String r1, String r2, String r3, String r4) {
        this.f18219a = r1;
        this.f18220b = r2;
        this.f18221c = r3;
        this.f18222d = r4;
    }

    public static y c(String r11) {
        Matcher r0 = f18217e.matcher(r11);
        if (r0.lookingAt() == false) goto L37;
        String r3 = r0.group(1);
        Locale r4 = Locale.US;
        String r5 = r3.toLowerCase(r4);
        String r6 = r0.group(2).toLowerCase(r4);
        String r7 = null;
        Matcher r8 = f18218f.matcher(r11);
        int r1 = r0.end();
    L6:
        if (r1 >= r11.length()) goto L35;
        r8.region(r1, r11.length());
        if (r8.lookingAt() == false) goto L33;
        String r2 = r8.group(1);
        if (r2 == null) goto L31;
        if (r2.equalsIgnoreCase("charset") == false) goto L31;
        String r9 = r8.group(2);
        if (r9 != null) goto L17;
        r9 = r8.group(3);
    L24:
        if (r7 != null) goto L26;
    L30:
        r7 = r9;
        goto L31
    L26:
        if (r9.equalsIgnoreCase(r7) == true) goto L30;
        throw new IllegalArgumentException("Multiple charsets defined: \"" + r7 + "\" and: \"" + r9 + "\" for: \"" + r11 + '\"');
    L17:
        if (r9.startsWith("'") == false) goto L24;
        if (r9.endsWith("'") == false) goto L24;
        if (r9.length() <= 2) goto L24;
        r9 = r9.substring(1, r9.length() - 1);
    L31:
        r1 = r8.end();
        goto L6
    L33:
        throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + r11.substring(r1) + "\" for: \"" + r11 + '\"');
    L35:
        return new y(r11, r5, r6, r7);
    L37:
        throw new IllegalArgumentException("No subtype found for: \"" + r11 + '\"');
    }

    public static y d(String r0) {
        return c(r0);
    L4:
        return null;
    }

    public Charset a() {
        return b(null);
    }

    public Charset b(Charset r1) {
        String r0 = this.f18222d;     // Catch: IllegalArgumentException -> L6
        if (r0 == null) goto L9;
        return Charset.forName(r0);
    L9:
        return r1;
    L10:
        return r1;
    }

    public String e() {
        return this.f18221c;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof y) == true) goto L5;
    L7:
        return false;
    L5:
        if (((y) r2).f18219a.equals(this.f18219a) == false) goto L7;
        return true;
    }

    public String f() {
        return this.f18220b;
    }

    public int hashCode() {
        return this.f18219a.hashCode();
    }

    public String toString() {
        return this.f18219a;
    }
}
