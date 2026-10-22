package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes6.dex */
public class SubscriberMethodInfo {
    final Class<?> eventType;
    final String methodName;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethodInfo(String r1, Class<?> r2, ThreadMode r3, int r4, boolean r5) {
        this.methodName = r1;
        this.threadMode = r3;
        this.eventType = r2;
        this.priority = r4;
        this.sticky = r5;
    }

    public SubscriberMethodInfo(String r7, Class<?> r8) {
        this(r7, r8, ThreadMode.POSTING, 0, false);
    }

    public SubscriberMethodInfo(String r7, Class<?> r8, ThreadMode r9) {
        this(r7, r8, r9, 0, false);
    }
}
