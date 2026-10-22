package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.annotation.WorkerThread;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface IFPSCallBack {
    @WorkerThread
    void fpsCallBack(@Nullable FpsBean r1);
}
