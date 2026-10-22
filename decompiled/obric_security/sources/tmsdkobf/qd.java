package tmsdkobf;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tmsdk.common.CallerIdent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class qd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ReentrantReadWriteLock f442a;
    private static HashMap b;

    static {
        f442a = new ReentrantReadWriteLock();
        b = new HashMap();
    }

    private static Object a(int r5, long r6) {
        if (r5 != 4) goto L5;
        String r7 = "" + r5 + "-" + r6;
        f442a.readLock().lock();
        Object r0 = b.get(r7);
        f442a.readLock().unlock();
        if (r0 != null) goto L24;
        r0 = new bf(r6, "com.tencent.meri");
        StringBuilder r8 = new StringBuilder("create service: ");
    L23:
        r8.c("ServiceCenter", r8.append(r7).toString());
    L24:
        if (r7 == null) goto L30;
        if (r0 == null) goto L30;
        f442a.writeLock().lock();
        if (b.get(r7) != null) goto L29;
        b.put(r7, r0);
    L29:
        f442a.writeLock().unlock();
    L30:
        return r0;
    L5:
        if (r5 != 9) goto L7;
        r7 = "" + r5 + "-" + r6;
        f442a.readLock().lock();
        r0 = b.get(r7);
        f442a.readLock().unlock();
        if (r0 != null) goto L24;
        r0 = new oe(r6);
        r8 = new StringBuilder("create service: ");
        goto L23
    L7:
        if (r5 != 12) goto L9;
        r7 = "" + r5 + "-" + r6;
        f442a.readLock().lock();
        r0 = b.get(r7);
        f442a.readLock().unlock();
        if (r0 != null) goto L24;
        r0 = new ue(r6);
        r8 = new StringBuilder("create service: ");
        goto L23
    L9:
        if (r5 == 17) goto L11;
        r7 = null;
        r0 = null;
        goto L24
    L11:
        r7 = "" + r5 + "-" + r6;
        f442a.readLock().lock();
        r0 = b.get(r7);
        f442a.readLock().unlock();
        if (r0 != null) goto L24;
        r0 = new x2(r6);
        r8 = new StringBuilder("create service: ");
        goto L23
    }

    private static Object b(int r2, long r3) {
        f442a.readLock().lock();
        Object r0 = b.get("" + r2 + "-" + r3);
        f442a.readLock().unlock();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return a(r2, r3);
    }

    public static Object a(int r3) {
        return b(r3, CallerIdent.getIdent(1, 4294967296L));
    }
}
