package com.bytedance.platform.godzilla.plugin;

import android.app.Application;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PluginGroup extends BasePlugin {
    private List<BasePlugin> mPluginList;
    private XHookPlugin xHookPlugin;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public abstract String getName();

    protected abstract List<BasePlugin> getPluginList();

    public PluginGroup() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public final void init(Application r2) {
        super.init(r2);
        List<BasePlugin> r0 = getPluginList();
        this.mPluginList = r0;
        Iterator<BasePlugin> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().init(r2);
        goto L4
    }

    public final void start(StartType r4) {
        Iterator<BasePlugin> r0 = this.mPluginList.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        BasePlugin r1 = r0.next();
        if (r1.startType() != r4) goto L4;
        r1.start();
        if ((r1 instanceof XHookPlugin) == false) goto L4;
        this.xHookPlugin = (XHookPlugin) r1;
        goto L4
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public final void start() {
        super.start();
        Iterator<BasePlugin> r1 = this.mPluginList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().start();
        goto L4
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public final void stop() {
        super.stop();
        Iterator<BasePlugin> r1 = this.mPluginList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().stop();
        goto L4
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public final void destroy() {
        super.destroy();
        Iterator<BasePlugin> r1 = this.mPluginList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().destroy();
        goto L4
    }

    public XHookPlugin getXHookPlugin() {
        return this.xHookPlugin;
    }

    public void setXHookPlugin(XHookPlugin r1) {
        this.xHookPlugin = r1;
    }
}
