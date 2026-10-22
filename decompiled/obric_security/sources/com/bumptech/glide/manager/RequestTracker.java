package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class RequestTracker {
    private static final String TAG = "RequestTracker";
    private boolean isPaused;
    private final Set<Request> pendingRequests;
    private final Set<Request> requests;

    public RequestTracker() {
        this.requests = Collections.newSetFromMap(new WeakHashMap());
        this.pendingRequests = new HashSet();
    }

    public void runRequest(Request r3) {
        this.requests.add(r3);
        if (this.isPaused == true) goto L5;
        r3.begin();
        return;
    L5:
        r3.clear();
        if (Log.isLoggable(TAG, 2) == false) goto L8;
        Log.v(TAG, "Paused, delaying request");
    L8:
        this.pendingRequests.add(r3);
    }

    void addRequest(Request r1) {
        this.requests.add(r1);
    }

    public boolean clearAndRemove(Request r3) {
        boolean r0 = true;
        if (r3 != null) goto L5;
        return true;
    L5:
        boolean r1 = this.requests.remove(r3);
        if (this.pendingRequests.remove(r3) == true) goto L10;
        if (r1 == true) goto L10;
        r0 = false;
    L10:
        if (r0 == false) goto L12;
        r3.clear();
    L12:
        return r0;
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseRequests() {
        this.isPaused = true;
        Iterator r0 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Request r1 = (Request) r0.next();
        if (r1.isRunning() == false) goto L4;
        r1.pause();
        this.pendingRequests.add(r1);
        goto L4
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        Iterator r0 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Request r1 = (Request) r0.next();
        if (r1.isRunning() == true) goto L9;
        if (r1.isComplete() == false) goto L4;
    L9:
        r1.clear();
        this.pendingRequests.add(r1);
        goto L4
    }

    public void resumeRequests() {
        this.isPaused = false;
        Iterator r0 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Request r1 = (Request) r0.next();
        if (r1.isComplete() == true) goto L4;
        if (r1.isRunning() == true) goto L4;
        r1.begin();
        goto L4
    L10:
        this.pendingRequests.clear();
    }

    public void clearRequests() {
        Iterator r0 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        clearAndRemove((Request) r0.next());
        goto L4
    L6:
        this.pendingRequests.clear();
    }

    public void restartRequests() {
        Iterator r0 = Util.getSnapshot(this.requests).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Request r1 = (Request) r0.next();
        if (r1.isComplete() == true) goto L4;
        if (r1.isCleared() == true) goto L4;
        r1.clear();
        if (this.isPaused == false) goto L11;
        this.pendingRequests.add(r1);
        goto L4
    L11:
        r1.begin();
        goto L4
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + "}";
    }
}
