package com.bytedance.platform.godzilla.common;

import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ConsumeExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int OOM_LEVEL = 20;
    private final List<UncaughtExceptionConsumer> consumers;
    private boolean isRegister;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public ConsumeExceptionHandler() {
        this.consumers = new LinkedList();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r2, Throwable r3) {
    L19:
        th = move-exception;
        callDefaultHandler(r2, th);
        return;
    L3:
        if (isOutOfMemoryError(r3) == false) goto L5;
    L17:
        callDefaultHandler(r2, r3);     // Catch: Throwable -> L19
        return;
    L5:
        if (canConsumeInner(r2, r3) == false) goto L17;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.getName().equals("main") == false) goto L31;
    L22:
        Looper.loop();     // Catch: Exception -> L11 Throwable -> L19
    L11:
        e = move-exception;
        if (isOutOfMemoryError(e) == true) goto L16;
        if (canConsumeInner(r2, e) == true) goto L22;
    L16:
        callDefaultHandler(r2, e);     // Catch: Throwable -> L19
        return;
    }

    public boolean addExceptionConsumer(UncaughtExceptionConsumer r2) {
        List<UncaughtExceptionConsumer> r0 = this.consumers;
        monitor-enter(r0);
        boolean r1 = this.consumers.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean removeExceptionConsumer(UncaughtExceptionConsumer r2) {
        List<UncaughtExceptionConsumer> r0 = this.consumers;
        monitor-enter(r0);
        boolean r1 = this.consumers.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAllExceptionConsumer() {
        List<UncaughtExceptionConsumer> r0 = this.consumers;
        monitor-enter(r0);
        this.consumers.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void callDefaultHandler(Thread r2, Throwable r3) {
        Thread.UncaughtExceptionHandler r0 = this.mDefaultHandler;
        if (r0 == null) goto L7;
        if (r0 == this) goto L8;
        r0.uncaughtException(r2, r3);
        return;
    L8:
        return;
    }

    public void register() {
        if (this.isRegister == false) goto L5;
        return;
    L5:
        Thread.UncaughtExceptionHandler r0 = Thread.getDefaultUncaughtExceptionHandler();
        this.mDefaultHandler = r0;
        if (r0 == this) goto L8;
        Thread.setDefaultUncaughtExceptionHandler(this);
    L9:
        this.isRegister = true;
        return;
    L8:
        this.mDefaultHandler = null;
        goto L9
    }

    private boolean canConsumeInner(Thread r3, Throwable r4) throws Throwable {
        List<UncaughtExceptionConsumer> r0 = this.consumers;     // Catch: Throwable -> L19
        monitor-enter(r0);     // Catch: Throwable -> L19
        Iterator<UncaughtExceptionConsumer> r2 = this.consumers.iterator();     // Catch: Throwable -> L14
    L6:
        if (r2.hasNext() == false) goto L12;
        if (r2.next().consumeUncaughtException(r3, r4) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L25:
        return false;
    }

    private boolean isOutOfMemoryError(Throwable r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r0 = 0;
    L6:
        if (r3 == null) goto L16;
        if ((r3 instanceof OutOfMemoryError) == true) goto L9;
        if (r0 > 20) goto L13;
        r0 = r0 + 1;     // Catch: Throwable -> L17
        r3 = r3.getCause();     // Catch: Throwable -> L17
    L13:
        return false;
    L9:
        return true;
    L16:
        return false;
    }
}
