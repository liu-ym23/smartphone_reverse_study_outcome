package com.bytedance.apm.perf;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.bytedance.apm.ApmContext;

/* JADX INFO: loaded from: classes.dex */
public class TemperatureDataManager {
    private BroadcastReceiver batteryReceiver;
    private IntentFilter intentFilter;
    private boolean isRegistered;
    private int mPlugged;
    private int mStatus;
    private float mTemperature;

    public static class Holder {
        private static final TemperatureDataManager INSTANCE = null;

        static {
            INSTANCE = new TemperatureDataManager(null);
        }

        private Holder() {
        }

        public static /* synthetic */ TemperatureDataManager access$100() {
            return INSTANCE;
        }
    }

    public /* synthetic */ TemperatureDataManager(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ float access$202(TemperatureDataManager r0, float r1) {
        r0.mTemperature = r1;
        return r1;
    }

    public static /* synthetic */ int access$302(TemperatureDataManager r0, int r1) {
        r0.mStatus = r1;
        return r1;
    }

    public static /* synthetic */ int access$402(TemperatureDataManager r0, int r1) {
        r0.mPlugged = r1;
        return r1;
    }

    public static TemperatureDataManager getInstance() {
        return Holder.access$100();
    }

    private void onInit() {
        this.batteryReceiver = new AnonymousClass1(this);
        this.intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public int getPlugged() {
        return this.mPlugged;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public float getTemperature() {
        return this.mTemperature;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public synchronized void registerTemperatureReceiver() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.isRegistered == false) goto L19;
        monitor-exit(this);
        return;
    L19:
        this.isRegistered = true;     // Catch: Throwable -> L10 Exception -> L16
        ApmContext.getContext().registerReceiver(this.batteryReceiver, this.intentFilter);     // Catch: Throwable -> L10 Exception -> L16
    L12:
        monitor-exit(this);
    }

    public synchronized void unRegisterTemperatureReceiver() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.isRegistered == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        ApmContext.getContext().unregisterReceiver(this.batteryReceiver);     // Catch: Throwable -> L9 Exception -> L15
        this.isRegistered = false;     // Catch: Throwable -> L9 Exception -> L15
    L11:
        monitor-exit(this);
    }

    private TemperatureDataManager() {
        onInit();
    }
}
