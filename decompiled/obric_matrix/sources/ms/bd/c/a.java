package ms.bd.c;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f22312b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f22313a;

    static {
        f22312b = new a();
    }

    public a() {
    }

    public static a a() {
        return f22312b;
    }

    public void b(Context r1) {
        if (r1 == null) goto L4;
        Context r2 = r1.getApplicationContext();
    L5:
        this.f22313a = r2;
        return;
    L4:
        r2 = null;
        goto L5
    }

    public Context c() {
        return this.f22313a;
    }
}
