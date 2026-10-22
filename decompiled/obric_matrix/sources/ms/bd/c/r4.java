package ms.bd.c;

/* JADX INFO: loaded from: classes2.dex */
public class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22479a = 0;

    static {
        String r0 = (String) m.a(16777217, 0, 0, "8be36c", new byte[]{18, 60, 87, 25, 52});
    }

    public static String a(String r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (r2.length() > 0) goto L7;
        return "";
    L7:
        return r2.trim().replace('\'', ' ').replace('\"', ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
