package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes.dex */
public final class PreloadTarget<Z> extends CustomTarget<Z> {
    private static final Handler HANDLER = null;
    private static final int MESSAGE_CLEAR = 1;
    private final RequestManager requestManager;

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r1) {
    }

    static {
        HANDLER = new Handler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager r1, int r2, int r3) {
        return new PreloadTarget(r1, r2, r3);
    }

    private PreloadTarget(RequestManager r1, int r2, int r3) {
        super(r2, r3);
        this.requestManager = r1;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z r1, Transition<? super Z> r2) {
        Request r3 = getRequest();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isComplete() == false) goto L9;
        HANDLER.obtainMessage(1, this).sendToTarget();
        return;
    }

    void clear() {
        this.requestManager.clear(this);
    }
}
