package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class SubscriberMethod {
    final Class<?> eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(Method r1, Class<?> r2, ThreadMode r3, int r4, boolean r5) {
        this.method = r1;
        this.threadMode = r3;
        this.eventType = r2;
        this.priority = r4;
        this.sticky = r5;
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof SubscriberMethod) == false) goto L9;
        checkMethodString();
        SubscriberMethod r3 = (SubscriberMethod) r2;
        r3.checkMethodString();
        return this.methodString.equals(r3.methodString);
    L9:
        return false;
    }

    private synchronized void checkMethodString() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.methodString != null) goto L6;
        StringBuilder r0 = new StringBuilder(64);     // Catch: Throwable -> L8
        r0.append(this.method.getDeclaringClass().getName());     // Catch: Throwable -> L8
        r0.append('#').append(this.method.getName());     // Catch: Throwable -> L8
        r0.append('(').append(this.eventType.getName());     // Catch: Throwable -> L8
        this.methodString = r0.toString();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
