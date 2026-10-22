package com.bytedance.ttnet.cronet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CronetDropReasonAccess extends Observable {
    public static final String DROP_REASON_LIST = "drop_reason_list";
    public static final String USER_BLOCKED_STATE = "user_blocked_state";
    private static volatile CronetDropReasonAccess sInstance;
    private CopyOnWriteArrayList<Integer> mDropReasonList;
    private volatile boolean mUserBlockedState;

    public CronetDropReasonAccess() {
        this.mDropReasonList = new CopyOnWriteArrayList();
    }

    public static CronetDropReasonAccess inst() {
        if (sInstance != null) goto L16;
        monitor-enter(CronetDropReasonAccess.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new CronetDropReasonAccess();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CronetDropReasonAccess.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private void notifyDropReasonChangedObservers(Map<String, Object> r1) {
        setChanged();
        notifyObservers(r1);
    }

    public List<Integer> dropReasonList() {
        return this.mDropReasonList;
    }

    public void onDropReasonChanged(boolean r2, List<Integer> r3) {
        this.mUserBlockedState = r2;
        this.mDropReasonList.clear();
        this.mDropReasonList.addAll(r3);
        HashMap r4 = new HashMap();
        r4.put(USER_BLOCKED_STATE, Boolean.valueOf(this.mUserBlockedState));
        r4.put(DROP_REASON_LIST, this.mDropReasonList);
        notifyDropReasonChangedObservers(r4);
    }

    public boolean userBlockedState() {
        return this.mUserBlockedState;
    }
}
