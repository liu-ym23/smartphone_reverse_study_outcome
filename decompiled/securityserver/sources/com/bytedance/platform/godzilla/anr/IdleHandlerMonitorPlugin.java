package com.bytedance.platform.godzilla.anr;

import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.platform.godzilla.anr.monitor.ITaskCostTimeCallback;
import com.bytedance.platform.godzilla.anr.monitor.idletask.ArrayListWrapper;
import com.bytedance.platform.godzilla.anr.monitor.idletask.IdleHandlerCostTimeMonitor;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class IdleHandlerMonitorPlugin extends BasePlugin {
    public IdleHandlerMonitorPlugin(ITaskCostTimeCallback r1) {
        if (r1 == null) goto L7;
        IdleHandlerCostTimeMonitor.getInstance().setIdleHandlerCostTimeCallback(r1);
        return;
    L7:
        throw new IllegalArgumentException("Argument idleHandlerCostTimeCallback can not be null ");
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "IdleHandlerMonitorPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L20;
        MessageQueue r4 = Looper.myQueue();     // Catch: Throwable -> L21
        monitor-enter(r4);     // Catch: Throwable -> L21
        Field r0 = DoubleReflectHelper.getField(MessageQueue.class, "mIdleHandlers");     // Catch: Throwable -> L11
        ArrayList r1 = (ArrayList) r0.get(r4);     // Catch: Throwable -> L11
        if (ArrayListWrapper.class.getName().equals(r1.getClass().getName()) == false) goto L13;
        Logger.e("IdleHandlerMonitorPlugin", "Already replaced,return.");     // Catch: Throwable -> L11
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L13:
        r0.set(r4, new ArrayListWrapper(r1));     // Catch: Throwable -> L11
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L24:
        return;
    L20:
        throw new RuntimeException("Must start in UI thread!");
    }
}
