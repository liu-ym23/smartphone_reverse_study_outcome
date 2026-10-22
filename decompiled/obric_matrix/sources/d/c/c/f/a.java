package d.c.c.f;

import d.c.c.d.f;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f15391a = null;

    static {
        f15391a = f.of("mkv", "video/x-matroska", "glb", "model/gltf-binary");
    }

    private static String a(String r2) {
        int r0 = r2.lastIndexOf(46);
        if (r0 >= 0) goto L5;
        return null;
    L5:
        if (r0 != (r2.length() - 1)) goto L8;
        return null;
    L8:
        return r2.substring(r0 + 1);
    }

    public static String b(String r1) {
        String r2 = a(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        String r3 = r2.toLowerCase(Locale.US);
        String r0 = b.a(r3);
        if (r0 == null) goto L9;
        return r0;
    L9:
        return f15391a.get(r3);
    }

    public static boolean c(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.startsWith("image/") == false) goto L6;
        return true;
    }

    public static boolean d(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.startsWith("video/") == false) goto L6;
        return true;
    }
}
