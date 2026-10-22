package com.bytedance.bdinstall.util;

import com.bytedance.bdinstall.IDataObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public class DataObserverHolder implements IDataObserver {
    private static volatile DataObserverHolder sInstance;
    private final CopyOnWriteArraySet<IDataObserver> mDataObserver;

    public static DataObserverHolder getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(DataObserverHolder.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DataObserverHolder();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DataObserverHolder.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private DataObserverHolder() {
        this.mDataObserver = new CopyOnWriteArraySet();
    }

    @Override // com.bytedance.bdinstall.IDataObserver
    public void onIdLoaded(String r2, String r3, String r4) {
        Iterator<IDataObserver> r1 = this.mDataObserver.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onIdLoaded(r2, r3, r4);
        goto L4
    }

    @Override // com.bytedance.bdinstall.IDataObserver
    public void onRemoteIdGet(boolean r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Iterator<IDataObserver> r0 = this.mDataObserver.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onRemoteIdGet(r11, r12, r13, r14, r15, r16, r17);
        goto L4
    }

    public void addDataObserver(IDataObserver r1) {
        if (r1 == null) goto L5;
        this.mDataObserver.add(r1);
        return;
    }

    public void removeDataObserver(IDataObserver r1) {
        if (r1 == null) goto L5;
        this.mDataObserver.remove(r1);
        return;
    }

    public void removeAllDataObserver() {
        this.mDataObserver.clear();
    }
}
