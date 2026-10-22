package com.bytedance.bdinstall;

import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class ExecutorOptions {
    public ExecutorService ioExecutor;
    public Executor networkExecutor;
    public Looper workLooper;

    public ExecutorOptions() {
    }
}
