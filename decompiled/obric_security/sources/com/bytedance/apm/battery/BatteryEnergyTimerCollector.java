package com.bytedance.apm.battery;

import android.app.Activity;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.thread.AsyncEventManager;
import com.ss.thor.ThorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BatteryEnergyTimerCollector extends AbstractPerfCollector {
    private static int MIN_VALID_CURRENT = 10;
    private boolean mEnabled;

    static {
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return 300000;
    }

    public BatteryEnergyTimerCollector() {
        this.mCollectorSettingKey = "battery";
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void doConfig(JSONObject r3) {
        boolean r1 = false;
        if (r3.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_ENABLE_UPLOAD, 0) != 1) goto L5;
        r1 = true;
    L5:
        this.mEnabled = r1;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void onStart() {
        super.onStart();
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        if (isBackground() == false) goto L8;
        return;
    L8:
        if (BatteryUtils.isCharging(ApmContext.getContext()) == false) goto L10;
        return;
    L10:
        float r0 = ThorUtils.getGalvanicNow(ApmContext.getContext());
        if (r0 >= MIN_VALID_CURRENT) goto L16;
        return;
    L16:
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
        r5.put(PerfConsts.KEY_TIMING_CURRENT, r0);     // Catch: JSONException -> L15
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L15
        r6.put("scene", ActivityLifeObserver.getInstance().getTopActivityClassName());     // Catch: JSONException -> L15
        sendPerfLog(new PerfData("battery", "", r5, r6, null));     // Catch: JSONException -> L15
        return;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        AsyncEventManager.getInstance().removeTimeTask(this);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
        if (this.mEnabled == false) goto L6;
        AsyncEventManager.getInstance().addTimeTask(this);
        return;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return this.mEnabled;
    }
}
