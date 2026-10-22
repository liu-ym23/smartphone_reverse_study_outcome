package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

/* JADX INFO: loaded from: classes.dex */
interface EngineJobListener {
    void onEngineJobCancelled(EngineJob<?> r1, Key r2);

    void onEngineJobComplete(EngineJob<?> r1, Key r2, EngineResource<?> r3);
}
