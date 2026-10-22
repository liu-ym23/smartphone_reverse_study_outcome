package com.bytedance.apm.block.trace;

/* JADX INFO: loaded from: classes3.dex */
public interface BeatLifecycle {
    boolean isAlive();

    void onStart();

    void onStop();
}
