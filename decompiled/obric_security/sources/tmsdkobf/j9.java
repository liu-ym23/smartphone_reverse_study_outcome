package tmsdkobf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class j9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NetworkInfo f285a;
    private Context b;
    private List c;

    public j9(Context r2) {
        this.c = new ArrayList();
        this.b = r2;
    }

    public void a(te.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List r0 = this.c;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.c.contains(r3) == true) goto L9;
        this.c.add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void b(te.a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        List r0 = this.c;
        monitor-enter(r0);
        this.c.remove(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public NetworkInfo a() {
        NetworkInfo r1 = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        this.f285a = r1;     // Catch: Exception -> L9
        if (r1 != null) goto L15;
    L12:
        return r1;
    L15:
        q8.c("NetworkInfoManager", "network type:" + this.f285a.getType());     // Catch: Exception -> L7
    L7:
        e = e;
    L11:
        e.printStackTrace();
    L9:
        e = e;
        r1 = null;
        goto L11
    }
}
