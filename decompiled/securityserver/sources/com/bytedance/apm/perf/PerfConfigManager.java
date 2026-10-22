package com.bytedance.apm.perf;

import androidx.annotation.NonNull;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PerfConfigManager implements IConfigListener {
    private static final String TAG = "PerfConfigManager";
    private volatile JSONObject mAllowScene;
    private Map<String, String> mLogTypeToSwitch;
    private final Map<String, Boolean> mPerfAllowSwitch;
    private final Map<String, Boolean> mPerfSecondStageAllowSwitch;
    private List<String> mPerfServiceList;
    private List<String> mPerfSmoothTypeList;
    private List<String> mPerfStartTypeList;

    /* JADX INFO: renamed from: com.bytedance.apm.perf.PerfConfigManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Holder {
        private static final PerfConfigManager sInstance = null;

        static {
            sInstance = new PerfConfigManager(null);
        }

        private Holder() {
        }

        public static /* synthetic */ PerfConfigManager access$000() {
            return sInstance;
        }
    }

    public /* synthetic */ PerfConfigManager(AnonymousClass1 r1) {
        this();
    }

    public static PerfConfigManager getInstance() {
        return Holder.access$000();
    }

    private void refreshBatteryConfig(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r0 = this.mPerfSecondStageAllowSwitch;
        boolean r2 = false;
        if (r6.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD, 0) != 1) goto L7;
        boolean r1 = true;
    L8:
        r0.put(CommonServiceName.MONITOR_TYPE_TEMPERATURE, Boolean.valueOf(r1));
        Map<String, Boolean> r5 = this.mPerfSecondStageAllowSwitch;
        if (r6.optInt(SlardarSettingsConsts.PERF_BATTERY_EXCEPTION, 0) != 1) goto L11;
        r2 = true;
    L11:
        r5.put("battery_trace", Boolean.valueOf(r2));
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void refreshCpuConfig(JSONObject r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r2 = this.mPerfSecondStageAllowSwitch;
        boolean r1 = false;
        if (r3.optInt("exception", 0) != 1) goto L7;
        r1 = true;
    L7:
        r2.put("cpu_trace", Boolean.valueOf(r1));
    }

    private void refreshMemoryConfig(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Map<String, Boolean> r3 = this.mPerfSecondStageAllowSwitch;
        boolean r1 = false;
        if (r4.optInt("memory_object_monitor", 0) != 1) goto L7;
        r1 = true;
    L7:
        r3.put("memory_object_monitor", Boolean.valueOf(r1));
    }

    private void refreshPerformanceModule(@NonNull JSONObject r6) {
        JSONObject r7 = r6.optJSONObject("performance_modules");
        if (r7 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.mPerfServiceList.iterator();
    L7:
        if (r0.hasNext() == false) goto L28;
        String r1 = r0.next();
        JSONObject r3 = r7.optJSONObject(r1);
        if (SlardarSettingsConsts.PERF_KEY_SMOOTH.equals(r1) == true) goto L10;
        if ("memory".equals(r1) == false) goto L15;
        refreshMemoryConfig(r3);
    L15:
        if ("battery".equals(r1) == false) goto L18;
        refreshBatteryConfig(r3);
    L18:
        if ("cpu".equals(r1) == false) goto L21;
        refreshCpuConfig(r3);
    L21:
        if ("start_trace".equals(r1) == false) goto L23;
        refreshStartTraceConfig(r3);
    L23:
        if (r3 == null) goto L27;
        if (r3.optInt("enable_upload", 0) != 1) goto L27;
        this.mPerfAllowSwitch.put(r1, Boolean.TRUE);
    L27:
        this.mPerfAllowSwitch.put(r1, Boolean.FALSE);
        goto L7
    L10:
        refreshSmoothConfig(r3);
        goto L7
    L28:
        this.mAllowScene = JsonUtils.optJSONObject(r7, SlardarSettingsConsts.PERF_KEY_SMOOTH, SlardarSettingsConsts.PERF_SMOOTH_SCENE_ENABLE_UPLOAD);
    }

    private void refreshSmoothConfig(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = this.mPerfSmoothTypeList.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        Map<String, Boolean> r2 = this.mPerfSecondStageAllowSwitch;     // Catch: Exception -> L13
        String r3 = this.mLogTypeToSwitch.get(r1);     // Catch: Exception -> L13
        boolean r4 = false;
        if (r7.optInt(r1, 0) != 1) goto L11;
        r4 = true;
    L11:
        r2.put(r3, Boolean.valueOf(r4));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void refreshStartTraceConfig(JSONObject r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = this.mPerfStartTypeList.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();
        Map<String, Boolean> r2 = this.mPerfSecondStageAllowSwitch;     // Catch: Exception -> L13
        boolean r3 = false;
        if (r7.optInt(r1, 0) != 1) goto L11;
        r3 = true;
    L11:
        r2.put(r1, Boolean.valueOf(r3));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public boolean getPerfAllowSwitch(String r1) {
        Boolean r0 = this.mPerfAllowSwitch.get(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public boolean getPerfFpsAllowSwitch(String r4, String r5) {
        Boolean r6 = this.mPerfSecondStageAllowSwitch.get(r4);
        if (this.mAllowScene != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r6 != null) goto L10;
    L12:
        if (r3 == true) goto L14;
        return false;
    L14:
        return true;
    L10:
        if (r6.booleanValue() == false) goto L12;
    L5:
        if (this.mAllowScene.optInt(r5) != 1) goto L7;
        r3 = true;
        goto L8
    }

    public boolean getPerfSecondStageSwitch(String r1) {
        Boolean r0 = this.mPerfSecondStageAllowSwitch.get(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onReady() {
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        refreshPerformanceModule(r1);
    }

    private PerfConfigManager() {
        this.mPerfAllowSwitch = new ConcurrentHashMap();
        this.mPerfSecondStageAllowSwitch = new ConcurrentHashMap();
        this.mLogTypeToSwitch = new HashMap();
        LinkedList r0 = new LinkedList();
        this.mPerfServiceList = r0;
        r0.addAll(Arrays.asList(new String[]{"battery", SlardarSettingsConsts.PERF_KEY_SMOOTH, "cpu", "disk", "memory", "thread", SlardarSettingsConsts.PERF_KEY_FD, "page_load", "page_load_trace", "start", "start_trace", "traffic", SlardarSettingsConsts.PERF_KEY_UI}));
        ArrayList r1 = new ArrayList();
        this.mPerfSmoothTypeList = r1;
        r1.add("enable_upload");
        this.mPerfSmoothTypeList.add(SlardarSettingsConsts.PERF_SMOOTH_DROP_ENABLE_UPLOAD);
        this.mPerfSmoothTypeList.add(SlardarSettingsConsts.PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD);
        this.mPerfSmoothTypeList.add(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD);
        this.mPerfSmoothTypeList.add(SlardarSettingsConsts.PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD);
        LinkedList r2 = new LinkedList();
        this.mPerfStartTypeList = r2;
        r2.add(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT);
        this.mLogTypeToSwitch.put("enable_upload", "fps");
        this.mLogTypeToSwitch.put(SlardarSettingsConsts.PERF_SMOOTH_DROP_ENABLE_UPLOAD, "fps_drop");
        this.mLogTypeToSwitch.put(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, "block_monitor");
        this.mLogTypeToSwitch.put(SlardarSettingsConsts.PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD, "drop_frame_stack");
        this.mLogTypeToSwitch.put(SlardarSettingsConsts.PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD, "serious_block_monitor");
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
    }
}
