package com.loopj.android.http;

import android.os.Looper;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class RequestHandle {
    private final WeakReference<AsyncHttpRequest> request;

    public RequestHandle(AsyncHttpRequest r2) {
        this.request = new WeakReference(r2);
    }

    public boolean cancel(final boolean r4) {
        final AsyncHttpRequest r0 = this.request.get();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        new Thread(new AnonymousClass1(this, r0, r4)).start();
        return true;
    L9:
        return r0.cancel(r4);
    }

    public boolean isFinished() {
        AsyncHttpRequest r0 = this.request.get();
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isDone() == true) goto L8;
        return false;
    }

    public boolean isCancelled() {
        AsyncHttpRequest r0 = this.request.get();
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.isCancelled() == true) goto L8;
        return false;
    }

    public boolean shouldBeGarbageCollected() {
        if (isCancelled() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        this.request.clear();
    L11:
        return r0;
    L5:
        if (isFinished() == true) goto L8;
        r0 = false;
        goto L9
    }

    public Object getTag() {
        AsyncHttpRequest r0 = this.request.get();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getTag();
    }

    public RequestHandle setTag(Object r2) {
        AsyncHttpRequest r0 = this.request.get();
        if (r0 == null) goto L5;
        r0.setRequestTag(r2);
    L5:
        return this;
    }
}
