package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

/* JADX INFO: loaded from: classes6.dex */
public class SimpleSubscriberInfo extends AbstractSubscriberInfo {
    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class r2, boolean r3, SubscriberMethodInfo[] r4) {
        super(r2, null, r3);
        this.methodInfos = r4;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public synchronized SubscriberMethod[] getSubscriberMethods() {
        monitor-enter(this);
        int r0 = this.methodInfos.length;     // Catch: Throwable -> L9
        SubscriberMethod[] r1 = new SubscriberMethod[r0];     // Catch: Throwable -> L9
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L7;
        SubscriberMethodInfo r3 = this.methodInfos[r2];     // Catch: Throwable -> L9
        r1[r2] = createSubscriberMethod(r3.methodName, r3.eventType, r3.threadMode, r3.priority, r3.sticky);     // Catch: Throwable -> L9
        r2 = r2 + 1;
        goto L4
    L7:
        monitor-exit(this);
        return r1;
    L9:
        th = move-exception;
        throw th;
    }
}
