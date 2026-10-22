package com.bytedance.memory.b;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class f implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5000f;

    public f(@NonNull String r3) {
        this.f5000f = "MemoryWidget_" + r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable r2) {
        return new Thread(r2, this.f5000f);
    }
}
