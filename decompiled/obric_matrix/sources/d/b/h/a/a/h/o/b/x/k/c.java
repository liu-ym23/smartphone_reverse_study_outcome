package d.b.h.a.a.h.o.b.x.k;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Pattern f13618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f13619b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f13620c = null;

    static {
        f13618a = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        f13619b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f13620c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r1) {
        return f13620c.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean b(String r1) {
        return f13619b.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean c(String r9) {
        if (r9 == null) goto L45;
        if (r9.length() < 7) goto L45;
        if (r9.length() > 15) goto L45;
        if (r9.equals("") == true) goto L45;
        if (f13618a.matcher(r9).matches() == false) goto L45;
        return true;
    L47:
        int r3 = r9.indexOf(46);     // Catch: Exception -> L46
        if (r3 == (-1)) goto L43;
        if (r9.charAt(0) == '-') goto L43;
        if (Integer.parseInt(r9.substring(0, r3)) > 255) goto L43;
        int r4 = r3 + 1;     // Catch: Exception -> L46
        int r5 = r9.indexOf(46, r4);     // Catch: Exception -> L46
        if (r5 == (-1)) goto L43;
        if (r9.charAt(r4) == '-') goto L43;
        if (Integer.parseInt(r9.substring(r4, r5)) > 255) goto L43;
        int r6 = r5 + 1;     // Catch: Exception -> L46
        int r7 = r9.indexOf(46, r6);     // Catch: Exception -> L46
        if (r7 == (-1)) goto L42;
        if (r9.charAt(r6) == '-') goto L42;
        if (Integer.parseInt(r9.substring(r6, r7)) > 255) goto L42;
        int r8 = r7 + 1;     // Catch: Exception -> L46
        if (r9.charAt(r8) == '-') goto L42;
        if (Integer.parseInt(r9.substring(r8, r9.length())) > 255) goto L42;
        if (r9.charAt(r9.length() - 1) == '.') goto L42;
        return true;
    L42:
        return false;
    L43:
        return false;
    L45:
        return false;
    }

    public static boolean d(String r1) {
        if (b(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (a(r1) == true) goto L8;
        return false;
    }
}
