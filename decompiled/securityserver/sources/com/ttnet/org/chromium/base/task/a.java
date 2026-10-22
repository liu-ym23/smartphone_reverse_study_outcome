package com.ttnet.org.chromium.base.task;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r1) {
        AsyncTask.b(r1);
    }
}
