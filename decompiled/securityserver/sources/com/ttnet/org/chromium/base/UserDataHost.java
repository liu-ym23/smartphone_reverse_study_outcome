package com.ttnet.org.chromium.base;

import android.os.Process;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class UserDataHost {
    private final long mThreadId;
    private HashMap<Class<? extends UserData>, UserData> mUserDataMap;

    public UserDataHost() {
        this.mThreadId = Process.myTid();
        this.mUserDataMap = new HashMap();
    }

    private static void checkArgument(boolean r1) {
        if (r1 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Neither key nor object of UserDataHost can be null.");
    }

    private void checkThreadAndState() {
        if (this.mThreadId != Process.myTid()) goto L10;
        if (this.mUserDataMap == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Operation is not allowed after destroy().");
    L10:
        throw new IllegalStateException("UserData must only be used on a single thread.");
    }

    public void destroy() {
        checkThreadAndState();
        HashMap<Class<? extends UserData>, UserData> r0 = this.mUserDataMap;
        this.mUserDataMap = null;
        Iterator<UserData> r2 = r0.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().destroy();
        goto L4
    }

    public <T extends UserData> T getUserData(Class<T> r2) {
        checkThreadAndState();
        if (r2 == null) goto L5;
        boolean r0 = true;
    L6:
        checkArgument(r0);
        return r2.cast(this.mUserDataMap.get(r2));
    L5:
        r0 = false;
        goto L6
    }

    public <T extends UserData> T removeUserData(Class<T> r2) {
        checkThreadAndState();
        if (r2 == null) goto L5;
        boolean r0 = true;
    L6:
        checkArgument(r0);
        if (this.mUserDataMap.containsKey(r2) == false) goto L11;
        return r2.cast(this.mUserDataMap.remove(r2));
    L11:
        throw new IllegalStateException("UserData for the key is not present.");
    L5:
        r0 = false;
        goto L6
    }

    public <T extends UserData> T setUserData(Class<T> r2, T r3) {
        checkThreadAndState();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        boolean r0 = true;
    L7:
        checkArgument(r0);
        this.mUserDataMap.put(r2, r3);
        return (T) getUserData(r2);
    L6:
        r0 = false;
        goto L7
    }
}
