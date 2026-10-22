package com.bytedance.apm.battery;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.perf.AbstractPerfCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BatteryTemperatureCollector extends AbstractPerfCollector {
    private static final String TAG = "TemperatureCollector";
    private BroadcastReceiver batteryReceiver;
    private IntentFilter intentFilter;
    private boolean isRegistered;
    private List<ApmAgent.IBatteryDataListener> mBatteryDataListeners;
    private boolean mEnableLocalRecord;
    private boolean mIsSampled;
    private long mLastReportTime;
    private int mReportInterval;

    public static final class Holder {
        private static final BatteryTemperatureCollector INSTANCE = null;

        static {
            INSTANCE = new BatteryTemperatureCollector();
        }

        private Holder() {
        }

        public static /* synthetic */ BatteryTemperatureCollector access$000() {
            return INSTANCE;
        }
    }

    public BatteryTemperatureCollector() {
        this.mIsSampled = false;
        this.mReportInterval = 60;
        this.mCollectorSettingKey = "battery";
    }

    public static /* synthetic */ long access$100(BatteryTemperatureCollector r2) {
        return r2.mLastReportTime;
    }

    public static /* synthetic */ long access$102(BatteryTemperatureCollector r0, long r1) {
        r0.mLastReportTime = r1;
        return r1;
    }

    public static /* synthetic */ int access$200(BatteryTemperatureCollector r0) {
        return r0.mReportInterval;
    }

    public static /* synthetic */ boolean access$300(BatteryTemperatureCollector r0) {
        return r0.mIsSampled;
    }

    public static /* synthetic */ boolean access$400(BatteryTemperatureCollector r0) {
        return r0.mEnableLocalRecord;
    }

    public static /* synthetic */ List access$500(BatteryTemperatureCollector r0) {
        return r0.mBatteryDataListeners;
    }

    public static BatteryTemperatureCollector getInstance() {
        return Holder.access$000();
    }

    private void registerBatteryReceiver() {
        if (this.isRegistered == false) goto L8;
        return;
    L8:
        ApmContext.getContext().registerReceiver(this.batteryReceiver, this.intentFilter);     // Catch: Exception -> L7
        this.isRegistered = true;     // Catch: Exception -> L7
        return;
    }

    private void unRegisterBatteryReceiver() {
        if (this.isRegistered == true) goto L8;
        return;
    L8:
        ApmContext.getContext().unregisterReceiver(this.batteryReceiver);     // Catch: Exception -> L7
        this.isRegistered = false;     // Catch: Exception -> L7
        return;
    }

    public void addBatteryDataListener(ApmAgent.IBatteryDataListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.mBatteryDataListeners != null) goto L7;
        this.mBatteryDataListeners = new ArrayList();
    L7:
        this.mBatteryDataListeners.add(r2);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject r4) {
        super.doConfig(r4);
        boolean r1 = false;
        if (r4.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD, 0) != 1) goto L5;
        r1 = true;
    L5:
        this.mIsSampled = r1;
        this.mReportInterval = r4.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_UPLOAD_INTERVAL, 60);
        if (this.mIsSampled == false) goto L8;
        return;
    L8:
        if (this.mEnableLocalRecord == true) goto L12;
        ActivityLifeObserver.getInstance().unregister(this);
        unRegisterBatteryReceiver();
        return;
    }

    public void init(boolean r1) {
        this.mEnableLocalRecord = r1;
        init();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public boolean isTimerMonitor() {
        return false;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        unRegisterBatteryReceiver();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        registerBatteryReceiver();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onInit() {
        this.batteryReceiver = new AnonymousClass1(this);
        this.intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        registerBatteryReceiver();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public long workInternalMs() {
        return 0;
    }
}
