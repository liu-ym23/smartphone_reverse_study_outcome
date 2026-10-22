package com.bytedance.securityserver.utils;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r2) {
        Thread r1 = new Thread(r2, "SecurityAuditReportThread");
        r1.setPriority(4);
        return r1;
    }
}
