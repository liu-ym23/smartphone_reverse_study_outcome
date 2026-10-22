package com.bytedance.apm.agent.instrumentation.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class StreamCompleteListenerManager {
    private boolean streamComplete;
    private ArrayList<StreamCompleteListener> streamCompleteListeners;

    StreamCompleteListenerManager() {
        this.streamComplete = false;
        this.streamCompleteListeners = new ArrayList();
    }

    public boolean isComplete() {
        monitor-enter(this);
        boolean r0 = this.streamComplete;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void addStreamCompleteListener(StreamCompleteListener r2) {
        ArrayList<StreamCompleteListener> r0 = this.streamCompleteListeners;
        monitor-enter(r0);
        this.streamCompleteListeners.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeStreamCompleteListener(StreamCompleteListener r2) {
        ArrayList<StreamCompleteListener> r0 = this.streamCompleteListeners;
        monitor-enter(r0);
        this.streamCompleteListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyStreamComplete(StreamCompleteEvent r2) {
        if (checkComplete() == true) goto L8;
        Iterator<StreamCompleteListener> r1 = getStreamCompleteListeners().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().streamComplete(r2);
        goto L6
    L10:
        return;
    }

    public void notifyStreamError(StreamCompleteEvent r2) {
        if (checkComplete() == true) goto L8;
        Iterator<StreamCompleteListener> r1 = getStreamCompleteListeners().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().streamError(r2);
        goto L6
    L10:
        return;
    }

    private boolean checkComplete() {
        monitor-enter(this);
        boolean r0 = isComplete();     // Catch: Throwable -> L8
        if (r0 == true) goto L6;
        this.streamComplete = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    private List<StreamCompleteListener> getStreamCompleteListeners() {
        ArrayList<StreamCompleteListener> r0 = this.streamCompleteListeners;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.streamCompleteListeners);     // Catch: Throwable -> L7
        this.streamCompleteListeners.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
