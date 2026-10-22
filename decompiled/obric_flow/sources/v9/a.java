package v9;

import ai.j0;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashSet f22554m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22557c;
    public String d;
    public long e;
    public final String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f22558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f22560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f22561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22562l;

    static {
        HashSet r5 = new HashSet();
        f22554m = r5;
        r5.add("comment");
        r5.add("commenturl");
        r5.add("discard");
        r5.add("domain");
        r5.add("expires");
        r5.add("httponly");
        r5.add("max-age");
        r5.add(SVGRenderEngine.PATH);
        r5.add("port");
        r5.add("secure");
        r5.add("version");
        Pattern.compile("(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])", 2);     // Catch: PatternSyntaxException -> L6
        Pattern.compile("([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}", 2);     // Catch: PatternSyntaxException -> L6
    L4:
        new so.c(1);
    }

    public a(String r10, String r11) {
        this.e = -1;
        boolean r5 = true;
        this.f22562l = 1;
        String r12 = r10.trim();
        boolean r13 = false;
        if (r12.length() != 0) goto L5;
    L9:
        r5 = false;
    L10:
        if (r5 == false) goto L28;
        int r14 = 0;
    L13:
        if (r14 >= r12.length()) goto L28;
        char r15 = r12.charAt(r14);
        if (r15 < 0) goto L29;
        if (r15 >= 127) goto L29;
        if (r15 == ';') goto L29;
        if (r15 == ',') goto L29;
        if (Character.isWhitespace(r15) == false) goto L27;
        if (r15 != ' ') goto L29;
    L27:
        r14 = r14 + 1;
    L29:
        if (r13 == false) goto L33;
        this.f = r12;
        this.f22561k = r11;
        return;
    L33:
        throw new IllegalArgumentException("Invalid name: ".concat(r10));
    L28:
        r13 = r5;
        goto L29
    L5:
        if (r12.startsWith("$") == true) goto L9;
        if (f22554m.contains(r12.toLowerCase(Locale.US)) == true) goto L9;
        goto L9
    }

    public static void a(StringBuilder r5, String r10, String r11) {
        if (r11 == null) goto L5;
        androidx.constraintlayout.motion.widget.a.C(r5, ";$", r10, "=\"", r11);
        r5.append("\"");
        return;
    }

    public final Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public final boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == false) goto L26;
        a r10 = (a) r5;
        if (this.f.equalsIgnoreCase(r10.f) == false) goto L25;
        String r11 = this.d;
        if (r11 == null) goto L15;
        if (r11.equalsIgnoreCase(r10.d) == false) goto L25;
    L16:
        String r12 = this.g;
        String r13 = r10.g;
        if (r12 != null) goto L21;
        if (r13 != null) goto L20;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L25;
        return true;
    L20:
        r14 = false;
        goto L22
    L21:
        r14 = r12.equals(r13);
        goto L22
    L15:
        if (r10.d == null) goto L16;
    L25:
        return false;
    L26:
        return false;
    }

    public final int hashCode() {
        Locale r5 = Locale.US;
        int r10 = this.f.toLowerCase(r5).hashCode();
        String r11 = this.d;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = r10 + r13;
        String r15 = this.g;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.toLowerCase(r5).hashCode();
        goto L6
    }

    public final String toString() {
        int r5 = this.f22562l;
        String r10 = this.f22561k;
        String r11 = this.f;
        if (r5 == 0) goto L5;
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        r12.append("=\"");
        r12.append(r10);
        r12.append("\"");
        a(r12, "Path", this.g);
        a(r12, "Domain", this.d);
        a(r12, "Port", this.f22558h);
        return r12.toString();
    L5:
        return j0.D(r11, "=", r10);
    }
}
