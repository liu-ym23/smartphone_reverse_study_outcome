package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;

/* JADX INFO: loaded from: classes3.dex */
public class InstallFinishCallback extends CallbackWrapper<InstallFinishEvent, IInstallListener> implements Callback<InstallFinishEvent> {
    @Override // com.bytedance.bdinstall.callback.Callback
    public /* bridge */ /* synthetic */ void onCall(InstallFinishEvent r1) {
        onCall2(r1);
    }

    public InstallFinishCallback(IInstallListener r1) {
        super(r1);
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(InstallFinishEvent r1) {
        IInstallListener r0 = getListener();
        if (r0 == null) goto L6;
        r0.installFinished(r1.getInfo());
        return;
    }
}
