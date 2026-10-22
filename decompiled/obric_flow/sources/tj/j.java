package tj;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends e8.f {
    public final /* synthetic */ String d;
    public final /* synthetic */ List e;

    public j(String r5, String r10, int r11, int r12, int r13, List r14, String r15) {
        this.d = r5;
        this.e = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentHashMap r5 = wj.a.a().f22868a;
        String r10 = this.d;
        wj.b r11 = (wj.b) r5.get(r10);
        if (r11 == null) goto L6;
        r11.f22869a.countDown();
        r5.remove(r10);
        return;
    }
}
