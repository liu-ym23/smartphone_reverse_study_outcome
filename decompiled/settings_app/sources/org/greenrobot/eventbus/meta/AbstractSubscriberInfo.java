package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSubscriberInfo implements SubscriberInfo {
    private final boolean shouldCheckSuperclass;
    private final Class subscriberClass;
    private final Class<? extends SubscriberInfo> superSubscriberInfoClass;

    protected AbstractSubscriberInfo(Class r1, Class<? extends SubscriberInfo> r2, boolean r3) {
        this.subscriberClass = r1;
        this.superSubscriberInfoClass = r2;
        this.shouldCheckSuperclass = r3;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public Class getSubscriberClass() {
        return this.subscriberClass;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public SubscriberInfo getSuperSubscriberInfo() {
        Class<? extends SubscriberInfo> r1 = this.superSubscriberInfoClass;
        if (r1 != null) goto L14;
        return null;
    L14:
        return r1.newInstance();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public boolean shouldCheckSuperclass() {
        return this.shouldCheckSuperclass;
    }

    protected SubscriberMethod createSubscriberMethod(String r7, Class<?> r8) {
        return createSubscriberMethod(r7, r8, ThreadMode.POSTING, 0, false);
    }

    protected SubscriberMethod createSubscriberMethod(String r7, Class<?> r8, ThreadMode r9) {
        return createSubscriberMethod(r7, r8, r9, 0, false);
    }

    protected SubscriberMethod createSubscriberMethod(String r10, Class<?> r11, ThreadMode r12, int r13, boolean r14) {
        return new SubscriberMethod(this.subscriberClass.getDeclaredMethod(r10, new Class[]{r11}), r11, r12, r13, r14);
    L4:
        e = move-exception;
        throw new EventBusException("Could not find subscriber method in " + this.subscriberClass + ". Maybe a missing ProGuard rule?", e);
    }
}
