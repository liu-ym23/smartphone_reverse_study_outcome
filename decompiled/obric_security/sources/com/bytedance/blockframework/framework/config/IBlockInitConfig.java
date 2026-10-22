package com.bytedance.blockframework.framework.config;

import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.framework.monitor.DefaultBlockLogger;
import kotlin.Metadata;

/* JADX INFO: compiled from: IBlockInitConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/blockframework/framework/config/IBlockInitConfig;", "", "allTaskMustRunOnMain", "", "enableDebugDependencyCheck", "getBlockLogger", "Lcom/bytedance/blockframework/framework/monitor/BlockLogger;", "logOptEnable", "recordEnable", "recordException", "", "e", "", "useTreeMessageCenterEnable", "DefaultInitConfig", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBlockInitConfig {

    /* JADX INFO: compiled from: IBlockInitConfig.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/blockframework/framework/config/IBlockInitConfig$DefaultInitConfig;", "Lcom/bytedance/blockframework/framework/config/IBlockInitConfig;", "()V", "allTaskMustRunOnMain", "", "enableDebugDependencyCheck", "getBlockLogger", "Lcom/bytedance/blockframework/framework/monitor/BlockLogger;", "logOptEnable", "recordEnable", "recordException", "", "e", "", "useTreeMessageCenterEnable", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultInitConfig implements IBlockInitConfig {
        @Override // com.bytedance.blockframework.framework.config.IBlockInitConfig
        public boolean allTaskMustRunOnMain() {
            return true;
        }

        @Override // com.bytedance.blockframework.framework.config.IBlockInitConfig
        public boolean enableDebugDependencyCheck() {
            return true;
        }

        @Override // com.bytedance.blockframework.framework.config.IBlockInitConfig
        public boolean logOptEnable() {
            return false;
        }

        @Override // com.bytedance.blockframework.framework.config.IBlockInitConfig
        public boolean recordEnable() {
            return false;
        }

        @Override // com.bytedance.blockframework.framework.config.IBlockInitConfig
        public void recordException(Throwable r1) {
        }

        @Override // com.bytedance.blockframework.framework.config.IBlockInitConfig
        public boolean useTreeMessageCenterEnable() {
            return true;
        }

        public DefaultInitConfig() {
        }

        @Override // com.bytedance.blockframework.framework.config.IBlockInitConfig
        public BlockLogger getBlockLogger() {
            return new DefaultBlockLogger();
        }
    }

    boolean allTaskMustRunOnMain();

    boolean enableDebugDependencyCheck();

    BlockLogger getBlockLogger();

    boolean logOptEnable();

    boolean recordEnable();

    void recordException(Throwable r1);

    boolean useTreeMessageCenterEnable();
}
