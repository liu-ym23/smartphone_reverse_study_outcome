package com.bytedance.apm.battery;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.internal.LocCallback;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.perf.traffic.TrafficStatisticWrapper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.ss.thor.Thor;
import com.ss.thor.ThorCallback;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BatteryEnergyCollector extends AbstractPerfCollector implements LocCallback, BatteryUtils.ChargeListener {
    private static final int DEFAULT_SAMPLE_INTERVAL_MS = 3000;
    private static final long DEFAULT_UPLOAD_INTERVAL_MS = 120000;
    private static final String TAG = "BatteryEnergyCollector";
    private boolean isCharging;
    private boolean mCollectEnabled;
    private long mCpuTime;
    private CopyOnWriteArrayList<Long> mLocRequestTime;
    private final Object mLock;
    private int mSampleIntervalMs;
    private String mScene;
    private long mTrafficBytes;
    private TrafficStatisticWrapper mTrafficStatisticWrapper;
    private long mUploadIntervalMs;
    private long samplingTimes;
    private ConcurrentHashMap<String, BatteryInfoItem> sceneMap;
    private ThorCallback thorCallback;
    private float totalCurrentGalvanic;

    public class BatteryInfoItem {
        long cpuTime;
        long currentCapacity;
        float currentGalvanic;
        StringBuilder loc;
        final /* synthetic */ BatteryEnergyCollector this$0;
        long traffic;

        public BatteryInfoItem(BatteryEnergyCollector r1) {
            this.this$0 = r1;
            this.loc = new StringBuilder();
        }

        public long getCpuTime() {
            return this.cpuTime;
        }

        public long getCurrentCapacity() {
            return this.currentCapacity;
        }

        public float getCurrentGalvanic() {
            return this.currentGalvanic;
        }

        public String getLoc() {
            return this.loc.toString();
        }

        public long getTraffic() {
            return this.traffic;
        }

        public void setCpuTime(long r1) {
            this.cpuTime = r1;
        }

        public void setCurrentCapacity(long r1) {
            this.currentCapacity = r1;
        }

        public void setCurrentGalvanic(float r1) {
            this.currentGalvanic = r1;
        }

        public void setLoc(List<Long> r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (r4.size() == 0) goto L14;
            int r0 = 0;
        L8:
            if (r0 >= (r4.size() - 1)) goto L10;
            StringBuilder r1 = this.loc;
            r1.append(r4.get(r0));
            r1.append(',');
            r0 = r0 + 1;
            goto L8
        L10:
            this.loc.append(r4.get(r4.size() - 1));
            return;
        }

        public void setTraffic(long r1) {
            this.traffic = r1;
        }
    }

    public static final class Holder {
        private static final BatteryEnergyCollector INSTANCE = null;

        static {
            INSTANCE = new BatteryEnergyCollector(null);
        }

        private Holder() {
        }

        public static /* synthetic */ BatteryEnergyCollector access$100() {
            return INSTANCE;
        }
    }

    public /* synthetic */ BatteryEnergyCollector(AnonymousClass1 r1) {
        this();
    }

    public static /* synthetic */ long access$1000(BatteryEnergyCollector r2) {
        return r2.mTrafficBytes;
    }

    public static /* synthetic */ long access$1002(BatteryEnergyCollector r0, long r1) {
        r0.mTrafficBytes = r1;
        return r1;
    }

    public static /* synthetic */ TrafficStatisticWrapper access$1100(BatteryEnergyCollector r0) {
        return r0.mTrafficStatisticWrapper;
    }

    public static /* synthetic */ CopyOnWriteArrayList access$1200(BatteryEnergyCollector r0) {
        return r0.mLocRequestTime;
    }

    public static /* synthetic */ float access$1300(BatteryEnergyCollector r0) {
        return r0.totalCurrentGalvanic;
    }

    public static /* synthetic */ float access$1302(BatteryEnergyCollector r0, float r1) {
        r0.totalCurrentGalvanic = r1;
        return r1;
    }

    public static /* synthetic */ ConcurrentHashMap access$1400(BatteryEnergyCollector r0) {
        return r0.sceneMap;
    }

    public static /* synthetic */ void access$200(BatteryEnergyCollector r0) {
        r0.resetData();
    }

    public static /* synthetic */ Object access$300(BatteryEnergyCollector r0) {
        return r0.mLock;
    }

    public static /* synthetic */ String access$400(BatteryEnergyCollector r0) {
        return r0.mScene;
    }

    public static /* synthetic */ boolean access$500(BatteryEnergyCollector r0) {
        return r0.isBackground();
    }

    public static /* synthetic */ boolean access$600(BatteryEnergyCollector r0) {
        return r0.isCharging;
    }

    public static /* synthetic */ void access$700(BatteryEnergyCollector r0) {
        r0.endAll();
    }

    public static /* synthetic */ long access$800(BatteryEnergyCollector r2) {
        return r2.samplingTimes;
    }

    public static /* synthetic */ long access$804(BatteryEnergyCollector r4) {
        long r0 = r4.samplingTimes + 1;
        r4.samplingTimes = r0;
        return r0;
    }

    public static /* synthetic */ long access$900(BatteryEnergyCollector r2) {
        return r2.mCpuTime;
    }

    public static /* synthetic */ long access$902(BatteryEnergyCollector r0, long r1) {
        r0.mCpuTime = r1;
        return r1;
    }

    private void endAll() {
        if (TextUtils.isEmpty(this.mScene) == true) goto L6;
        this.mScene = null;
        AsyncEventManager.getInstance().removeTimeTask(this);
        Thor.stop();
        resetData();
        return;
    }

    public static BatteryEnergyCollector getInstance() {
        return Holder.access$100();
    }

    private void resetData() {
        this.samplingTimes = 0;
        this.totalCurrentGalvanic = 0.0f;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject r4) {
        boolean r1 = false;
        if (r4.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_ENABLE_UPLOAD, 0) != 1) goto L5;
        r1 = true;
    L5:
        this.mCollectEnabled = r1;
        if (r1 == false) goto L8;
        this.mSampleIntervalMs = r4.optInt(SlardarSettingsConsts.PERF_BATTERY_ENERGY_SAMPLE_INTERVAL, 3000);
        this.mUploadIntervalMs = r4.optLong(SlardarSettingsConsts.PERF_BATTERY_ENERGY_UPLOAD_INTERVAL, 120000);
        return;
    L8:
        ActivityLifeObserver.getInstance().unregister(this);
        AsyncEventManager.getInstance().removeTimeTask(this);
    }

    public void endSceneMonitor(String r3) {
        if (this.mCollectEnabled == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (r3.equals(this.mScene) == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        this.mScene = null;     // Catch: Throwable -> L11
        AsyncEventManager.getInstance().removeTimeTask(this);     // Catch: Throwable -> L11
        Thor.stop();     // Catch: Throwable -> L11
        resetData();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public boolean isTimerMonitor() {
        return !isBackground();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onBackground(Activity r1) {
        super.onBackground(r1);
        AsyncEventManager.getInstance().removeTimeTask(this);
        Object r2 = this.mLock;
        monitor-enter(r2);
        endAll();     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.util.BatteryUtils.ChargeListener
    public void onChange(boolean r1) {
        this.isCharging = r1;
        if (r1 == false) goto L12;
        Object r2 = this.mLock;
        monitor-enter(r2);
        endAll();     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector, com.bytedance.services.apm.api.IActivityLifeObserver
    public void onFront(Activity r1) {
        super.onFront(r1);
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onInit() {
        this.isCharging = BatteryUtils.addChargeListener(ApmContext.getContext(), this);
    }

    @Override // com.bytedance.apm.battery.internal.LocCallback
    public void onLocRequest(long r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLocRequestTime.add(Long.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStart() {
        super.onStart();
        Iterator<Map.Entry<String, BatteryInfoItem>> r0 = this.sceneMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<String, BatteryInfoItem> r1 = r0.next();
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L10
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L10
        r6.put("scene", r1.getKey());     // Catch: JSONException -> L10
        r5.put(PerfConsts.KEY_CURRENT_GALVANIC, r1.getValue().getCurrentGalvanic());     // Catch: JSONException -> L10
        r5.put(PerfConsts.KEY_CURRENT_CAPACITY, r1.getValue().getCurrentCapacity());     // Catch: JSONException -> L10
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L10
        r7.put("cpu_time", r1.getValue().getCpuTime());     // Catch: JSONException -> L10
        r7.put("traffic", r1.getValue().getTraffic());     // Catch: JSONException -> L10
        r7.put("loc", r1.getValue().getLoc());     // Catch: JSONException -> L10
        CommonDataPipeline.getInstance().handle(new PerfData("battery", "", r5, r6, r7));     // Catch: JSONException -> L10
        goto L4
    L8:
        this.sceneMap.clear();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onStop() {
        super.onStop();
    }

    public void startSceneMonitor(String r6) {
        if (this.mCollectEnabled == true) goto L5;
        return;
    L5:
        if (isBackground() == false) goto L7;
        return;
    L7:
        if (this.isCharging == true) goto L25;
        Object r0 = this.mLock;
        monitor-enter(r0);
        Thor.start(ApmContext.getContext(), this.thorCallback, 5, this.mSampleIntervalMs);     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(this.mScene) == false) goto L16;
        AsyncEventManager.getInstance().addTimeTask(this);     // Catch: Throwable -> L14
    L16:
        this.mScene = r6;     // Catch: Throwable -> L14
        resetData();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public long workInternalMs() {
        return this.mUploadIntervalMs;
    }

    private BatteryEnergyCollector() {
        this.sceneMap = new ConcurrentHashMap();
        this.mLock = new Object();
        this.samplingTimes = 0;
        this.totalCurrentGalvanic = 0.0f;
        this.mCpuTime = 0;
        this.mTrafficBytes = 0;
        this.mTrafficStatisticWrapper = TrafficStatisticWrapper.getInstance();
        this.mLocRequestTime = new CopyOnWriteArrayList();
        this.thorCallback = new AnonymousClass1(this);
        this.mCollectorSettingKey = "battery";
    }
}
