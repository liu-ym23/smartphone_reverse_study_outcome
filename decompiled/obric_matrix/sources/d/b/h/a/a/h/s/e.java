package d.b.h.a.a.h.s;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f13750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f13751b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f13752c = null;

    static {
        f13750a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f13751b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f13752c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r1) {
        return f13750a.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean b(String r1) {
        return f13752c.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean c(String r1) {
        return f13751b.matcher(r1).matches();
    L4:
        return false;
    }
}
