package com.bytedance.apm6.hub.config.internal;

import android.text.TextUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ConfigManager {
    private static volatile ConfigManager sInstance;
    private AsyncTask asyncTask;
    private IConfigManager configManager;
    private volatile boolean inited;
    private AsyncTask interceptorAsyncTask;
    private volatile JSONObject mConfigData;
    private boolean mConfigFromLocal;
    private List<IConfigChangeListener> mConfigListeners;
    private volatile boolean mReady;

    private ConfigManager() {
        this.inited = false;
    }

    public static /* synthetic */ JSONObject access$000(ConfigManager r0) {
        return r0.mConfigData;
    }

    public static /* synthetic */ void access$100(ConfigManager r0) {
        r0.initConfig();
    }

    public static /* synthetic */ AsyncTask access$200(ConfigManager r0) {
        return r0.asyncTask;
    }

    public static /* synthetic */ AsyncTask access$300(ConfigManager r0) {
        return r0.interceptorAsyncTask;
    }

    public static /* synthetic */ AsyncTask access$302(ConfigManager r0, AsyncTask r1) {
        r0.interceptorAsyncTask = r1;
        return r1;
    }

    public static /* synthetic */ void access$400(ConfigManager r0, JSONObject r1, boolean r2) {
        r0.updateCurrentConfig(r1, r2);
    }

    public static ConfigManager getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(ConfigManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new ConfigManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ConfigManager.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private void initConfig() {
        if (this.configManager != null) goto L5;
        this.configManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
    L5:
        IConfigManager r0 = this.configManager;
        if (r0 != null) goto L8;
        return;
    L8:
        String r1 = r0.queryConfig();
        if (ApmBaseContext.isDebugMode() == false) goto L16;
        Logger.d(ConfigConstants.LOG_TAG, "initConfig:" + r1);
    L16:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        updateCurrentConfig(new JSONObject(r1), true);     // Catch: Exception -> L15
        return;
    L18:
        return;
    }

    private void notifyListenerRefresh(JSONObject r2, boolean r3) {
        this.mReady = true;
        List<IConfigChangeListener> r1 = this.mConfigListeners;
        if (r1 == null) goto L10;
        Iterator<IConfigChangeListener> r4 = r1.iterator();
    L6:
        if (r4.hasNext() == false) goto L17;
        r4.next().onConfigChanged(r2, r3);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    private void updateCurrentConfig(JSONObject r2, boolean r3) {
        if (JsonUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.mConfigData = r2;
        this.mConfigFromLocal = r3;
        notifyListenerRefresh(r2, r3);
    }

    public synchronized void init() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.inited = true;     // Catch: Throwable -> L11
        if (ApmContext.isMainProcess() == false) goto L13;
        final long r3 = 500;
        final long r5 = 1000;
        this.asyncTask = new AnonymousClass1(this, r3, r5);     // Catch: Throwable -> L11
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.asyncTask);     // Catch: Throwable -> L11
    L13:
        IConfigManager r0 = (IConfigManager) ServiceManager.getService(IConfigManager.class);     // Catch: Throwable -> L11
        this.configManager = r0;     // Catch: Throwable -> L11
        r0.registerConfigListener(new AnonymousClass2(this));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void registerConfigListener(IConfigChangeListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.mConfigListeners != null) goto L8;
        this.mConfigListeners = new CopyOnWriteArrayList();
    L8:
        if (this.mConfigListeners.contains(r2) == true) goto L11;
        this.mConfigListeners.add(r2);
    L11:
        if (this.mReady == false) goto L14;
        r2.onConfigChanged(this.mConfigData, this.mConfigFromLocal);
        return;
    }

    public void removeConfigListener(IConfigChangeListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List<IConfigChangeListener> r0 = this.mConfigListeners;
        if (r0 == null) goto L8;
        r0.remove(r1);
        return;
    }
}
