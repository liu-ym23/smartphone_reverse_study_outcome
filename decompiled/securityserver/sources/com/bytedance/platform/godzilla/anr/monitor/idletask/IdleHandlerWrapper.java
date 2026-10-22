package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes.dex */
public class IdleHandlerWrapper implements MessageQueue.IdleHandler {
    private MessageQueue.IdleHandler mOriginalIdleHandler;

    public IdleHandlerWrapper(MessageQueue.IdleHandler r1) {
        this.mOriginalIdleHandler = r1;
    }

    public MessageQueue.IdleHandler getOriginalIdleHandler() {
        return this.mOriginalIdleHandler;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        String r0 = this.mOriginalIdleHandler.getClass().getName();
        BridgeIdleTaskToLooperPrinter.println(">>>>> Dispatching to IdleTask ".concat(r0));
        long r1 = System.currentTimeMillis();
        boolean r6 = this.mOriginalIdleHandler.queueIdle();
        BridgeIdleTaskToLooperPrinter.println("<<<<< Finished to IdleTask ".concat(r0));
        IdleHandlerCostTimeMonitor.getInstance().getIdleHandlerCostTimeCallback().upload(r0, System.currentTimeMillis() - r1);
        return r6;
    }
}
