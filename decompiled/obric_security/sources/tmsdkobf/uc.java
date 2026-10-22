package tmsdkobf;

import android.os.IBinder;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import tmsdk.common.DataEntity;

/* JADX INFO: loaded from: classes5.dex */
public final class uc extends r6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue f554a;
    private static volatile uc b;

    static {
        f554a = new ConcurrentLinkedQueue();
        b = null;
    }

    private uc() {
    }

    public static uc c() {
        if (b != null) goto L15;
        monitor-enter(uc.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new uc();     // Catch: Throwable -> L11
    L9:
        monitor-exit(uc.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    @Override // tmsdkobf.r6
    public DataEntity a(DataEntity r2) {
        r2.what();
        Iterator r1 = f554a.iterator();
        if (r1.hasNext() == true) goto L5;
        return null;
    L5:
        ua.a(r1.next());
        throw null;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
