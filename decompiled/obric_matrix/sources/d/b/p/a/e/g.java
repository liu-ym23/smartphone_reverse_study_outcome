package d.b.p.a.e;

import android.app.Application;
import android.os.Build;
import android.os.storage.StorageManager;
import d.b.p.a.d.h;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class g extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14257a;

    public g() {
        this.f14257a = false;
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "SpFetcherDeadObjectPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r2) {
        super.c(r2);
        if (Build.VERSION.SDK_INT != 26) goto L5;
        boolean r3 = true;
    L6:
        this.f14257a = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        if (this.f14257a == false) goto L9;
        new d.b.p.a.e.h.b.b.b().i();
        Field r1 = StorageManager.class.getDeclaredField("sStorageManager");     // Catch: Exception -> L7
        r1.setAccessible(true);     // Catch: Exception -> L7
        r1.set(null, null);     // Catch: Exception -> L7
        h.a("DeadObjectFixer", "Fix success.");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        h.a("DeadObjectFixer", "Fix fail " + e);
    L9:
        h.c(b(), "start");
    }
}
