package d.b.i.a.c;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f13919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f13920b;

    public static class a implements b {
        public a() {
        }

        @Override // d.b.i.a.c.c.b
        public boolean a(Context r1) {
            return false;
        }
    }

    public interface b {
        boolean a(Context r1);
    }

    static {
        f13919a = new a();
    }

    public static void a(b r1) {
        if (f13920b == false) goto L5;
        return;
    L5:
        if (r1 == null) goto L7;
        f13919a = r1;
    L7:
        f13920b = true;
    }

    static boolean b(Context r1) {
        return f13919a.a(r1);
    }

    public static byte[] c(String r1) {
        if (r1 != null) goto L10;
    L8:
        return null;
    L10:
        if (r1.length() <= 0) goto L8;
        return r1.getBytes("UTF-8");
    L12:
        return r1.getBytes();
    }
}
