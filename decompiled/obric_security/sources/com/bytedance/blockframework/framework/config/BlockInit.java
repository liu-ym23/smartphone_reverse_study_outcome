package com.bytedance.blockframework.framework.config;

import com.bytedance.blockframework.framework.monitor.BlockLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockInit.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/blockframework/framework/config/BlockInit;", "", "()V", "config", "Lcom/bytedance/blockframework/framework/config/IBlockInitConfig;", "allTaskMustRunOnMain", "", "enableDebugDependencyCheck", "init", "", "logOptEnable", "recordEnable", "recordException", "e", "", "useTreeMessageCenterEnable", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockInit {
    public static final BlockInit INSTANCE = null;
    private static IBlockInitConfig config;

    private BlockInit() {
    }

    static {
        INSTANCE = new BlockInit();
        config = new IBlockInitConfig.DefaultInitConfig();
    }

    public final boolean useTreeMessageCenterEnable() {
        return config.useTreeMessageCenterEnable();
    }

    public final boolean allTaskMustRunOnMain() {
        return config.allTaskMustRunOnMain();
    }

    public final boolean recordEnable() {
        return config.recordEnable();
    }

    public final boolean logOptEnable() {
        return config.logOptEnable();
    }

    public final boolean enableDebugDependencyCheck() {
        return config.enableDebugDependencyCheck();
    }

    public final void init(IBlockInitConfig r1) {
        Intrinsics.checkNotNullParameter(r1, "config");
        config = r1;
        BlockLogger.Companion.setLogger(r1.getBlockLogger());
    }

    public final void recordException(Throwable r1) {
        config.recordException(r1);
    }
}
