package com.bytedance.platform.godzilla.anr.sp;

import android.os.Looper;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class LinkedListProxyForWorks<E> extends LinkedList<E> {
    private static final Object LOCK = null;
    private LinkedList<Runnable> mRealList;

    static {
        LOCK = new Object();
    }

    public LinkedListProxyForWorks(LinkedList<Runnable> r1) {
        this.mRealList = r1;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E r2) {
        Object r0 = LOCK;
        monitor-enter(r0);
        boolean r1 = this.mRealList.add((Runnable) r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.LinkedList
    public Object clone() {
        super.clone();
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
        Object r0 = LOCK;
        monitor-enter(r0);
        LinkedList r1 = new LinkedList(this.mRealList);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return new LinkedList();
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        QueuedWorkProxyAboveOrEqualsAndroid0.reSendMessageToQueueWork();
        return;
    L6:
        Object r0 = LOCK;
        monitor-enter(r0);
        this.mRealList.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
