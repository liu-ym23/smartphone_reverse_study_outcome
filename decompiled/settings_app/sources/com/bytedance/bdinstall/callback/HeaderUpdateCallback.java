package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.HeaderUpdateListener;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;

/* JADX INFO: loaded from: classes3.dex */
public class HeaderUpdateCallback extends CallbackWrapper<HeaderChangeEvent, HeaderUpdateListener> implements Callback<HeaderChangeEvent> {
    @Override // com.bytedance.bdinstall.callback.Callback
    public /* bridge */ /* synthetic */ void onCall(HeaderChangeEvent r1) {
        onCall2(r1);
    }

    public HeaderUpdateCallback(HeaderUpdateListener r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(HeaderChangeEvent r1) {
        HeaderUpdateListener r0 = getListener();
        if (r0 == null) goto L6;
        r0.onHeaderUpdate(r1.getHeaderCopy());
        return;
    }
}
