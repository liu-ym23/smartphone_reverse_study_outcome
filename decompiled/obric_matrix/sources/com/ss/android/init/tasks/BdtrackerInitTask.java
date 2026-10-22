package com.ss.android.init.tasks;

import com.bytedance.lego.init.e.h;
import d.b.m.d.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/ss/android/init/tasks/BdtrackerInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "()V", "run", "", "ostracker_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BdtrackerInitTask extends h {
    public BdtrackerInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        a.b("mPaaSInit", new Object[]{"BdtrackerInitTask start"});
        BdtrackerInitTaskHook r1 = (BdtrackerInitTaskHook) d.b.m.e.a.a(BdtrackerInitTaskHook.class);
        new com.bytedance.mpaas.bdtracker.a().a(com.bytedance.mpaas.app.a.f5245g, r1);
        if (r1 == null) goto L5;
        com.bytedance.mpaas.monitor.a.d(BdtrackerInitTaskHook.class.getName());
    L5:
        a.b("mPaaSInit", new Object[]{"BdtrackerInitTask end"});
    }
}
