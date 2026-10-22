package u9;

import java.util.HashMap;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile m f22318a;

    public static m a() {
        if (f22318a != null) goto L16;
        monitor-enter(m.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22318a != null) goto L11;
        f22318a = new m();     // Catch: Throwable -> L9
    L11:
        monitor-exit(m.class);     // Catch: Throwable -> L9
    L16:
        return f22318a;
    }

    public final void b(long r5, String r10, long r11, String r12, String r13) {
        HashMap r14 = new HashMap();
        r14.put("url", r10);
        r14.put("sent_bytes", Long.valueOf(r5));
        r14.put("received_bytes", Long.valueOf(r11));
        r14.put("content_type", r12);
        r14.put("request_log", r13);
        setChanged();
        notifyObservers(r14);
    }
}
