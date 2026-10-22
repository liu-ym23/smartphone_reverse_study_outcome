package com.bytedance.platform.godzilla;

import a.a;
import android.app.Application;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.ILog;
import com.bytedance.platform.godzilla.common.IReflectHackHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.platform.godzilla.plugin.PluginGroup;
import com.bytedance.platform.godzilla.plugin.StartType;
import com.bytedance.platform.godzilla.plugin.XHookPlugin;
import com.bytedance.platform.godzilla.utils.HackHelper;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class Godzilla {
    private static final String TAG = "Godzilla";
    private static volatile Godzilla sInstance;
    private final Application application;
    private final HashMap<String, BasePlugin> plugins;

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.Godzilla$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final Application application;
        private ILog log;
        private Logger.Level logLevel;
        private final HashMap<String, BasePlugin> plugins;
        private IReflectHackHelper reflectHackHelper;

        public Builder(Application r2) {
            this.plugins = new HashMap();
            if (r2 == null) goto L7;
            this.application = r2;
            return;
        L7:
            throw new RuntimeException("Godzilla init, application is null");
        }

        public Godzilla build() {
            return new Godzilla(this.application, this.plugins, this.log, this.logLevel, this.reflectHackHelper, null);
        }

        public Builder plugin(BasePlugin r3) {
            String r0 = r3.getName();
            if (TextUtils.isEmpty(r0) == true) goto L11;
            if (this.plugins.get(r0) != null) goto L9;
            this.plugins.put(r0, r3);
            return this;
        L9:
            throw new RuntimeException(a.j(r0, " plugin is already exist"));
        L11:
            throw new RuntimeException(r3.getClass().getName().concat(" plugin name is null"));
        }

        public Builder setLog(ILog r1) {
            this.log = r1;
            return this;
        }

        public Builder setLogLevel(Logger.Level r1) {
            this.logLevel = r1;
            return this;
        }

        public Builder setReflectHackHelper(IReflectHackHelper r1) {
            this.reflectHackHelper = r1;
            return this;
        }
    }

    public /* synthetic */ Godzilla(Application r1, HashMap r2, ILog r3, Logger.Level r4, IReflectHackHelper r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }

    public static Godzilla init(Godzilla r2) {
        if (r2 == null) goto L17;
        monitor-enter(Godzilla.class);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (sInstance != null) goto L10;
        sInstance = r2;     // Catch: Throwable -> L8
    L11:
        monitor-exit(Godzilla.class);     // Catch: Throwable -> L8
        return sInstance;
    L10:
        Logger.e(TAG, "Godzilla instance is already set. this invoking will be ignored");     // Catch: Throwable -> L8
        goto L11
    L17:
        throw new RuntimeException("Godzilla should not be null.");
    }

    public static Godzilla with() {
        if (sInstance == null) goto L7;
        return sInstance;
    L7:
        throw new RuntimeException("Godzilla.init() method must be called first");
    }

    public void addPlugin(BasePlugin r3) {
        if (getPlugin(r3.getName()) != null) goto L6;
        stop();
        destroy();
        this.plugins.put(r3.getName(), r3);
        start(StartType.REGISTER_EXCEPTION);
        return;
    }

    public void destroy() {
        Iterator<BasePlugin> r1 = this.plugins.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().destroy();
        goto L4
    }

    public BasePlugin getPlugin(String r1) {
        return this.plugins.get(r1);
    }

    public void removePlugin(BasePlugin r2) {
        if (getPlugin(r2.getName()) == null) goto L6;
        stop();
        destroy();
        this.plugins.remove(r2.getName());
        start(StartType.REGISTER_EXCEPTION);
        return;
    }

    public void start() {
        start(StartType.IMMEDIATE);
    }

    public void stop() {
        Iterator<BasePlugin> r1 = this.plugins.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().stop();
        goto L4
    }

    private Godzilla(Application r2, HashMap<String, BasePlugin> r3, ILog r4, Logger.Level r5, IReflectHackHelper r6) {
        this.application = r2;
        this.plugins = r3;
        GodzillaCore.INSTANCE.init(r2, r4, r5);
        Iterator<BasePlugin> r7 = r3.values().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r7.next().init(this.application);
        goto L4
    L6:
        HackHelper.init(r6);
    }

    public void start(StartType r5) {
        Iterator<BasePlugin> r4 = this.plugins.values().iterator();
        XHookPlugin r1 = null;
    L4:
        if (r4.hasNext() == false) goto L15;
        BasePlugin r2 = r4.next();
        if ((r2 instanceof PluginGroup) == true) goto L7;
        if (r2.startType() != r5) goto L4;
        r2.start();
        if ((r2 instanceof XHookPlugin) == false) goto L4;
        r1 = (XHookPlugin) r2;
        goto L4
    L7:
        PluginGroup r3 = (PluginGroup) r2;
        r3.start(r5);
        if (r3.getXHookPlugin() == null) goto L4;
        r1 = r3.getXHookPlugin();
        r3.setXHookPlugin(null);
        goto L4
    L15:
        if (r1 == null) goto L30;
        r1.invokeXHookRefresh();
        return;
    }
}
