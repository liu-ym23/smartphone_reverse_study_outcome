package com.bytedance.platform.godzilla.sysopt;

import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.platform.godzilla.plugin.PluginGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SysOptPluginGroup extends PluginGroup {
    @Override // com.bytedance.platform.godzilla.plugin.PluginGroup, com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "SysOptPlugin";
    }

    public SysOptPluginGroup() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.PluginGroup
    protected List<BasePlugin> getPluginList() {
        ArrayList r2 = new ArrayList();
        r2.add(new DvmOptimizerPlugin());
        r2.add(new ArtOptimizerPlugin());
        r2.add(new SmFakeNameHandlerPlugin());
        r2.add(new IvimageOptPlugin());
        r2.add(new MTK_PVR_OptimizerPlugin(false));
        r2.add(new HighLevelTrimMemoryPlugin());
        r2.add(new DvmDeadLockOptimizerPlugin());
        return r2;
    }
}
