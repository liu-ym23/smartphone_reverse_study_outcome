package x9;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction$DispatchResultEnum;
import com.bytedance.frameworks.baselib.network.http.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static volatile b d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f22998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f22999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantReadWriteLock f23000c;

    static {
        new AtomicBoolean(false);
    }

    public b() {
        this.f22998a = null;
        new AtomicBoolean(true);
        new AtomicLong(0);
        new ArrayList();
        new ReentrantReadWriteLock();
        this.f22999b = new ArrayList();
        this.f23000c = new ReentrantReadWriteLock();
        new AtomicInteger(0);
        new AtomicLong(0);
        new ConcurrentHashMap();
    }

    public static b b() {
        if (d != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    public final int a(String r10, String r11) {
        ReentrantReadWriteLock r12 = this.f23000c;
        if (Logger.debug() == false) goto L6;
        kotlin.collections.a.n("getDelayResultForUrl: ", r10, "b");
    L6:
        if (c.a(r10) == false) goto L8;
        r12.readLock().lock();
        ArrayList r5 = new ArrayList();
        r5.add(0, 0);
        Iterator r13 = this.f22999b.iterator();
    L13:
        if (r13.hasNext() == false) goto L36;
        a r14 = (a) r13.next();
        if (Logger.debug() == false) goto L17;
        StringBuilder r15 = new StringBuilder("current action priority is ");
        r14.getClass();
        r15.append(0);
        Logger.d("b", r15.toString());
    L17:
        r14.getClass();
        Logger.d("a", "take delay action");
        if (r14.b() == true) goto L20;
    L30:
        r5.set(0, 0);
        BaseDispatchAction$DispatchResultEnum r16 = BaseDispatchAction$DispatchResultEnum.DISPATCH_NONE;
    L32:
        if (r16 != BaseDispatchAction$DispatchResultEnum.DISPATCH_DELAY) goto L13;
        if (Logger.debug() == false) goto L36;
        Logger.d("b", "the url has been delayed by delay action, skip follow-up actions");
        goto L36
    L20:
        if (TextUtils.isEmpty(r10) == true) goto L30;
        Uri r17 = Uri.parse(r10);
        if (r17.getHost() != null) goto L25;
    L29:
        r16 = BaseDispatchAction$DispatchResultEnum.DISPATCH_NONE;
        goto L32
    L25:
        if (r14.c(r17) == false) goto L29;
        throw null;
    L36:
        r12.readLock().unlock();
        return ((Integer) r5.get(0)).intValue();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("b", "illegal url");
    L10:
        return 0;
    }
}
