package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class qe {
    public static String a(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    public static boolean b(String r1) {
        if (r1 != null) goto L4;
    L7:
        return true;
    L4:
        if (r1.equals("") == true) goto L7;
        return false;
    }

    public static boolean c(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.equals("") == true) goto L6;
        return true;
    }
}
