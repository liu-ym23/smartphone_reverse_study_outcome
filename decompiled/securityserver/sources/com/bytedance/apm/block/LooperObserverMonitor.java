package com.bytedance.apm.block;

import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LooperObserverMonitor {
    public static final char END = '<';
    public static final char START = '>';
    public static Method dispatchingThrewException = null;
    private static volatile boolean isInited = false;
    public static Method messageDispatchStarting = null;
    public static Method messageDispatched = null;
    public static final String sEnd = "<<<<< Finished to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee";
    public static final Thread sMainThread = null;
    public static BaseObserver sObserverWrapper = null;
    public static Object sOriginObserver = null;
    public static final String sStart = ">>>>> Dispatching to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee: 0";

    public static class BaseObserver {
        volatile boolean haveAdd;
        volatile boolean haveRemove;
        List<ILooperObserver> mAddObservers;
        final List<ILooperObserver> mObservers;
        List<ILooperObserver> mRemoveObservers;

        public BaseObserver() {
            this.mObservers = new ArrayList();
            this.mRemoveObservers = new ArrayList();
            this.mAddObservers = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        public void addMessageObserver(ILooperObserver r3) {
            List<ILooperObserver> r0 = this.mObservers;
            monitor-enter(r0);
            if (r3 != null) goto L14;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L14:
            if (this.mAddObservers.contains(r3) == true) goto L10;
            this.mAddObservers.add(r3);     // Catch: Throwable -> L8
            this.haveAdd = true;     // Catch: Throwable -> L8
            goto L10
        }

        public void messageDispatchStarting(String r5) {
            if (this.haveAdd == false) goto L19;
            List<ILooperObserver> r0 = this.mObservers;
            monitor-enter(r0);
            Iterator<ILooperObserver> r1 = this.mAddObservers.iterator();     // Catch: Throwable -> L12
        L8:
            if (r1.hasNext() == false) goto L14;
            ILooperObserver r2 = r1.next();     // Catch: Throwable -> L12
            if (this.mObservers.contains(r2) == true) goto L8;
            this.mObservers.add(r2);     // Catch: Throwable -> L12
            goto L8
        L14:
            this.mAddObservers.clear();     // Catch: Throwable -> L12
            this.haveAdd = false;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        L19:
            Iterator<ILooperObserver> r4 = this.mObservers.iterator();
        L21:
            if (r4.hasNext() == false) goto L25;
            ILooperObserver r3 = r4.next();
            if (r3 == null) goto L21;
            r3.messageDispatchStarting(r5);
            goto L21
        }

        public void messageDispatched(String r3, Message r4) {
            Iterator<ILooperObserver> r0 = this.mObservers.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            ILooperObserver r1 = r0.next();
            if (r1 == null) goto L4;
            r1.messageDispatched(r3, r4);
            goto L4
        L9:
            if (this.haveRemove == false) goto L23;
            List<ILooperObserver> r5 = this.mObservers;
            monitor-enter(r5);
            Iterator<ILooperObserver> r6 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L16
        L14:
            if (r6.hasNext() == false) goto L18;
            ILooperObserver r2 = r6.next();     // Catch: Throwable -> L16
            this.mObservers.remove(r2);     // Catch: Throwable -> L16
            this.mAddObservers.remove(r2);     // Catch: Throwable -> L16
            goto L14
        L18:
            this.mRemoveObservers.clear();     // Catch: Throwable -> L16
            this.haveRemove = false;     // Catch: Throwable -> L16
            monitor-exit(r5);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public void removeMessageObserver(ILooperObserver r3) {
            List<ILooperObserver> r0 = this.mObservers;
            monitor-enter(r0);
            if (r3 != null) goto L14;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L14:
            if (this.mRemoveObservers.contains(r3) == true) goto L10;
            this.mRemoveObservers.add(r3);     // Catch: Throwable -> L8
            this.haveRemove = true;     // Catch: Throwable -> L8
            goto L10
        }

        public void setup(Object r1) {
        }
    }

    static {
        sMainThread = Looper.getMainLooper().getThread();
    }

    private LooperObserverMonitor() {
    }

    public static void addMessageObserver(ILooperObserver r1) {
        BaseObserver r0 = sObserverWrapper;
        if (r0 == null) goto L6;
        r0.addMessageObserver(r1);
        return;
    }

    public static synchronized boolean init() {
        monitor-enter(LooperObserverMonitor.class);
    L29:
        th = move-exception;
        throw th;
    L6:
        if (isInited == false) goto L33;
        monitor-exit(LooperObserverMonitor.class);
        return true;
    L33:
        Object r4 = reflectHideObject(Looper.class, null, "sObserver");     // Catch: Throwable -> L26
        sOriginObserver = r4;     // Catch: Throwable -> L26
        if (r4 == null) goto L14;
        messageDispatchStarting = reflectHideMethod(r4.getClass(), "messageDispatchStarting", new Class[0]);     // Catch: Throwable -> L26
        messageDispatched = reflectHideMethod(sOriginObserver.getClass(), "messageDispatched", new Class[]{Object.class, Message.class});     // Catch: Throwable -> L26
        dispatchingThrewException = reflectHideMethod(sOriginObserver.getClass(), "dispatchingThrewException", new Class[]{Object.class, Message.class, Exception.class});     // Catch: Throwable -> L26
    L14:
        if (messageDispatchStarting != null) goto L16;
    L19:
        sOriginObserver = null;     // Catch: Throwable -> L26
    L20:
        sObserverWrapper = (BaseObserver) Class.forName("com.bytedance.observer.ObserverWrapper").getDeclaredConstructor(null).newInstance(null);     // Catch: Throwable -> L26
        if (sOriginObserver == null) goto L23;
        System.out.println("LooperObserverMonitor.init: " + sOriginObserver);     // Catch: Throwable -> L26
        sObserverWrapper.setup(sOriginObserver);     // Catch: Throwable -> L26
    L23:
        reflectHideMethod(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")}).invoke(null, new Object[]{sObserverWrapper});     // Catch: Throwable -> L26
        isInited = true;     // Catch: Throwable -> L26
        boolean r0 = isInited;     // Catch: Throwable -> L26
        monitor-exit(LooperObserverMonitor.class);
        return r0;
    L16:
        if (messageDispatched == null) goto L19;
        if (dispatchingThrewException != null) goto L20;
    L26:
        sOriginObserver = null;     // Catch: Throwable -> L29
        sObserverWrapper = new BaseObserver();     // Catch: Throwable -> L29
        sOriginObserver = null;     // Catch: Throwable -> L29
        Looper.getMainLooper().setMessageLogging(new AnonymousClass1());     // Catch: Throwable -> L29
        isInited = true;     // Catch: Throwable -> L29
        return isInited;
    }

    public static Method reflectHideMethod(Class r4, String r5, Class<?>... r6) {
        Method r7 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r4, new Object[]{r5, r6});     // Catch: Exception -> L4
        r7.setAccessible(true);     // Catch: Exception -> L4
        return r7;
    L4:
        return null;
    }

    private static <T> T reflectHideObject(Class r3, Object r4, String r5) {
        Field r6 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r3, new Object[]{r5});     // Catch: Exception -> L4
        r6.setAccessible(true);     // Catch: Exception -> L4
        return (T) r6.get(r4);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void removeMessageObserver(ILooperObserver r1) {
        BaseObserver r0 = sObserverWrapper;
        if (r0 == null) goto L6;
        r0.removeMessageObserver(r1);
        return;
    }
}
