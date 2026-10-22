package tmsdkobf;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tmsdk.common.TMSDKContext;
import tmsdk.common.creator.BaseManagerC;

/* JADX INFO: loaded from: classes5.dex */
public class ne extends BaseManagerC {
    private Context b;
    private final HashMap c;
    private ReentrantReadWriteLock d;
    private HashMap e;
    private HashMap f;

    public ne() {
        this.c = new HashMap(5);
        this.d = new ReentrantReadWriteLock();
        this.e = null;
        this.f = new HashMap();
    }

    public o3 a(String r4, long r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        String r0 = r4 + r5;
        this.d.readLock().lock();
        o3 r1 = (o3) this.c.get(r0);
        this.d.readLock().unlock();
        if (r1 != null) goto L13;
        this.d.writeLock().lock();
        u3 r2 = p3.a(r4);
        if (r2 == null) goto L10;
        r1 = new kb(r5, r2.b, r4);
    L10:
        if (r1 == null) goto L12;
        this.c.put(r0, r1);
    L12:
        this.d.writeLock().unlock();
    L13:
        return r1;
    }

    public p6 b(String r1, long r2) {
        return g9.a(this.b, r1);
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r1) {
        this.b = TMSDKContext.getApplicaionContext();
    }
}
