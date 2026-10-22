package com.obric.matrix.platform.sdk.ones.commonmonitor.Thread;

import com.bytedance.apm.perf.ThreadCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadMonitor {

    @NotNull
    public static final ThreadMonitor INSTANCE = null;

    static {
        INSTANCE = new ThreadMonitor();
    }

    private ThreadMonitor() {
    }

    public final int reportThreadCount(@NotNull String r1) {
        Intrinsics.f(r1, "scene");
        return ThreadCollector.reportThreadCount(r1, true);
    }
}
