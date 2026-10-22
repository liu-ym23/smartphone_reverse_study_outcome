package com.bytedance.platform.godzilla.crash;

import com.bytedance.platform.godzilla.crash.uncaughtexecption.FinalizeTimeoutPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.JsDialogBadTokenPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.OppoMessageNPEPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.StopActivityNPEPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.ToastBadTokenPlugin;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.TopResumedActivityPlugin;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.platform.godzilla.plugin.PluginGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CrashPluginGroup extends PluginGroup {
    @Override // com.bytedance.platform.godzilla.plugin.PluginGroup, com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CrashPlugin";
    }

    public CrashPluginGroup() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.PluginGroup
    protected List<BasePlugin> getPluginList() {
        ArrayList r1 = new ArrayList();
        r1.add(new FinalizeTimeoutPlugin());
        r1.add(new JsDialogBadTokenPlugin());
        r1.add(new OppoMessageNPEPlugin());
        r1.add(new StopActivityNPEPlugin());
        r1.add(new ToastBadTokenPlugin());
        r1.add(new TopResumedActivityPlugin());
        r1.add(new HWReceiverCrashPlugin());
        r1.add(new BadParcelableExceptionPlugin());
        r1.add(new EnterTransitionCrashPlugin());
        r1.add(new LayoutInflaterAsyncCrashPlugin());
        return r1;
    }
}
