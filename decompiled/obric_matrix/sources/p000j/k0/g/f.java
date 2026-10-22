package p000j.k0.g;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static boolean a(String r1) {
        if (r1.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals("PATCH") == true) goto L14;
        if (r1.equals("PUT") == true) goto L14;
        if (r1.equals("DELETE") == true) goto L14;
        if (r1.equals("MOVE") == true) goto L14;
        return false;
    }

    public static boolean b(String r1) {
        if (r1.equals("GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals("HEAD") == true) goto L7;
        return true;
    }

    public static boolean c(String r1) {
        return !r1.equals("PROPFIND");
    }

    public static boolean d(String r1) {
        return r1.equals("PROPFIND");
    }

    public static boolean e(String r1) {
        if (r1.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals("PUT") == true) goto L14;
        if (r1.equals("PATCH") == true) goto L14;
        if (r1.equals("PROPPATCH") == true) goto L14;
        if (r1.equals("REPORT") == true) goto L14;
        return false;
    }
}
