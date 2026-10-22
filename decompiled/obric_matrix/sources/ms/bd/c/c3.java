package ms.bd.c;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class c3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c3 f22324b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22325a;

    class a implements g3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c3 f22326a;

        a(c3 r1) {
            this.f22326a = r1;
        }

        @Override // ms.bd.c.g3.a
        public void a(String r1) {
            c3.b(this.f22326a, r1);
        }
    }

    private c3(Context r7) {
        this.f22325a = null;
        new g3(new a(this)).c(r7);     // Catch: Throwable -> L5
        return;
    L5:
        String r6 = (String) m.a(16777217, 0, 0, "282c01", new byte[]{44, 47, 66});
    }

    static /* synthetic */ String b(c3 r0, String r1) {
        r0.f22325a = r1;
        return r1;
    }

    public static c3 c(Context r2) {
        if (f22324b != null) goto L15;
        monitor-enter(c3.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22324b != null) goto L9;
        f22324b = new c3(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c3.class);     // Catch: Throwable -> L11
    L15:
        return f22324b;
    }

    public static boolean d(Context r2, String r3) {
        if (r2.getPackageManager().getPackageInfo(r3, 128) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public String a() {
        return this.f22325a;
    }
}
