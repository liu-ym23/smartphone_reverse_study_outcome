package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.IOaidObserver;
import com.bytedance.bdinstall.callback.event.OaidChangeEvent;

/* JADX INFO: loaded from: classes3.dex */
public class OaidCallback extends CallbackWrapper<OaidChangeEvent, IOaidObserver> implements Callback<OaidChangeEvent> {
    @Override // com.bytedance.bdinstall.callback.Callback
    public /* bridge */ /* synthetic */ void onCall(OaidChangeEvent r1) {
        onCall2(r1);
    }

    public OaidCallback(IOaidObserver r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(OaidChangeEvent r1) {
        IOaidObserver r0 = getListener();
        if (r0 == null) goto L6;
        r0.onOaidLoaded(r1.getOaid());
        return;
    }
}
