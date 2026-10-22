package com.bytedance.apm;

import com.bytedance.apm.block.EvilMethodSwitchManager;
import com.bytedance.apm.block.FluencyMonitor;
import com.bytedance.apm.block.StackThread;
import com.bytedance.apm.config.FluencyConfig;
import com.bytedance.apm.config.FluencyConfigService;
import com.bytedance.apm6.service.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public class FluencyMonitorManager {

    /* JADX INFO: renamed from: com.bytedance.apm.FluencyMonitorManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class SingletonHolder {
        private static final FluencyMonitorManager instance = null;

        static {
            instance = new FluencyMonitorManager(null);
        }

        private SingletonHolder() {
        }

        public static /* synthetic */ FluencyMonitorManager access$100() {
            return instance;
        }
    }

    public /* synthetic */ FluencyMonitorManager(AnonymousClass1 r1) {
        this();
    }

    public static FluencyMonitorManager getInstance() {
        return SingletonHolder.access$100();
    }

    public void init() {
        ServiceManager.getService(FluencyConfigService.class);
    }

    public void updateConfig(FluencyConfig r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        StackThread.setEvilThresholdMs(r3.getSlowMethodDropThreshold());
        FluencyMonitor.getInstance().onReady();
        FluencyMonitor.getInstance().onRefresh(r3.getBlockMonitorMode(), false);
        FluencySwitchManager.notify(r3);
        EvilMethodSwitchManager.notify(r3.isDropSlowMethodSwitch(), r3.getSlowMethodDropThreshold());
    }

    private FluencyMonitorManager() {
        ServiceManager.getService(FluencyConfigService.class);
    }
}
