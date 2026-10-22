package com.bytedance.apm6.perf.base;

import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.apm.util.DeviceInfoUtil;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.perf.IPerfFilterManager;
import com.bytedance.apm6.util.ListUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PerfFilterManager implements IPerfFilterManager {
    private static volatile PerfFilterManager singleton;
    private boolean mHasJavaHeapLeak;
    private long mJavaHeapSizeMaxMega;
    private long mJavaHeapSizeUsedMega;
    private long mNativeHeapSizeMega;
    private ConcurrentHashMap<String, String> mPerfFilters;
    private CopyOnWriteArraySet<String> mSceneSet;

    private PerfFilterManager() {
        this.mSceneSet = new CopyOnWriteArraySet();
        this.mPerfFilters = new ConcurrentHashMap();
    }

    public static PerfFilterManager getInstance() {
        if (singleton != null) goto L16;
        monitor-enter(PerfFilterManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L11;
        singleton = new PerfFilterManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(PerfFilterManager.class);     // Catch: Throwable -> L9
    L16:
        return singleton;
    }

    private void updateMemInfo() {
        this.mNativeHeapSizeMega = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime r0 = Runtime.getRuntime();
        long r4 = r0.maxMemory();
        long r6 = r0.freeMemory();
        long r1 = r0.totalMemory();
        this.mJavaHeapSizeMaxMega = r4 / 1048576;
        long r2 = r1 - r6;
        this.mJavaHeapSizeUsedMega = r2 / 1048576;
        if (r2 <= (r4 * 0.95f)) goto L5;
        boolean r3 = true;
    L6:
        this.mHasJavaHeapLeak = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void addPerfTag(String r1, String r2) {
        this.mPerfFilters.put(r1, r2);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public ConcurrentHashMap<String, String> getPerfFilters() {
        return this.mPerfFilters;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getPerfFiltersJson() {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r3 = this.mPerfFilters.entrySet().iterator();     // Catch: JSONException -> L9
    L5:
        if (r3.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r3.next();     // Catch: JSONException -> L9
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L9
    L8:
        return r0;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getRealTimeMemInfo() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        updateMemInfo();     // Catch: Exception -> L4
        r0.put("apm_native_heap_size", this.mNativeHeapSizeMega);     // Catch: Exception -> L4
        r0.put("apm_java_heap_leak", this.mHasJavaHeapLeak);     // Catch: Exception -> L4
        r0.put("apm_java_heap_used", this.mJavaHeapSizeUsedMega);     // Catch: Exception -> L4
        r0.put("apm_java_heap_max", this.mJavaHeapSizeMaxMega);     // Catch: Exception -> L4
        return r0;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public CopyOnWriteArraySet<String> getSceneSet() {
        return this.mSceneSet;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public String getSceneString() {
        String r1 = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        if (TextUtils.isEmpty(r1) == true) goto L5;
        return r1;
    L5:
        ActivityLifecycleService r2 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.getTopActivityClassName();
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void removePerfTag(String r1, String r2) {
        this.mPerfFilters.remove(r1, r2);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void startScene(String r1) {
        this.mSceneSet.add(r1);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void stopScene(String r1) {
        this.mSceneSet.remove(r1);
    }

    public JSONObject getPerfFiltersJson(boolean r4) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, String>> r3 = this.mPerfFilters.entrySet().iterator();     // Catch: JSONException -> L11
    L5:
        if (r3.hasNext() == false) goto L7;
        Map.Entry<String, String> r1 = r3.next();     // Catch: JSONException -> L11
        r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L11
        goto L5
    L7:
        r0.put("RealRefreshRate", String.valueOf(FpsUtil.getRealMaxRate()));     // Catch: JSONException -> L11
        r0.put("RealMaxRefreshRate", String.valueOf(FpsUtil.getRealMaxRate()));     // Catch: JSONException -> L11
        if (r4 == false) goto L10;
        DeviceInfoUtil.getInstance().addRealTimeDeviceInfo(r0);     // Catch: JSONException -> L11
        DeviceInfoUtil.getInstance().addConstantDeviceInfo(r0);     // Catch: JSONException -> L11
    L10:
        return r0;
    }
}
