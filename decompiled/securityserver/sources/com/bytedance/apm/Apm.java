package com.bytedance.apm;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmReportConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.LogBypassStoreEventManager;
import com.bytedance.apm.trace.ITraceListener;
import com.bytedance.apm.trace.TraceConfig;

/* JADX INFO: loaded from: classes.dex */
public class Apm {

    public static class Holder {
        private static final Apm sInstance = null;

        static {
            sInstance = new Apm(null);
        }

        private Holder() {
        }

        public static /* synthetic */ Apm access$000() {
            return sInstance;
        }
    }

    public /* synthetic */ Apm(AnonymousClass1 r1) {
        this();
    }

    public static Apm getInstance() {
        return Holder.access$000();
    }

    public static void setReportMode(ApmReportConfig r1) {
        ApmDelegate.getInstance().setReportConfig(r1);
    }

    public void clearAllLogSync() {
        ApmDelegate.getInstance().clearBufferLogSync();
        ApmDelegate.getInstance().clearLegacyLogSync(-1);
    }

    public void clearBufferLog() {
        ApmDelegate.getInstance().clearBufferLog();
    }

    public void clearLegacyLog(long r1) {
        ApmDelegate.getInstance().clearLegacyLog(r1);
    }

    public void destroyAllPlugins() {
        ApmDelegate.getInstance().destroyAllPlugins();
    }

    public void init(Context r2) {
        ApmDelegate.getInstance().init(r2);
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass1(this));
        return;
    }

    @Nullable
    public ApmStartConfig.Builder newStartConfigBuilder() {
        return ApmDelegate.getInstance().newStartConfigBuilder();
    }

    public void pause() {
        ApmDelegate.getInstance().pause();
    }

    public void restart(ApmStartConfig r1) {
        ApmDelegate.getInstance().restart(r1);
    }

    public void resume() {
        ApmDelegate.getInstance().resume();
    }

    public void start(ApmStartConfig r2) {
        ApmDelegate.getInstance().start(r2);
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass3(this));
        return;
    }

    public void startAllPlugins() {
        ApmDelegate.getInstance().startAllPlugins();
    }

    public void stop() {
        ApmDelegate.getInstance().stop();
    }

    public void stopAllPlugins() {
        ApmDelegate.getInstance().stopAllPlugins();
    }

    @Deprecated
    public Apm traceConfig(TraceConfig r2) {
        ApmDelegate.getInstance().setTraceConfig(r2);
        return this;
    }

    @Deprecated
    public Apm traceListener(ITraceListener r2) {
        ApmDelegate.getInstance().setTraceListener(r2);
        return this;
    }

    private Apm() {
    }

    public void init(Context r2, ApmInitConfig r3) {
        ApmDelegate.getInstance().init(r2, r3);
        if (ApmContext.isInternalTest() == false) goto L6;
        LogBypassStoreEventManager.getInstance().post(new AnonymousClass2(this));
        return;
    }
}
