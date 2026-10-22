package com.bytedance.apm.battery.internal;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.battery.dao.tmp.BatteryTmpLogDao;
import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryDataManager {
    private static final String TAG = "BatteryData";
    private BatteryTmpLogDao mBatteryLogManager;
    private String mCurrentActivityName;
    private String mStartUUID;

    private static class Holder {
        private static final BatteryDataManager sInstance = null;

        private Holder() {
        }

        static /* synthetic */ BatteryDataManager access$000() {
            return sInstance;
        }

        static {
            sInstance = new BatteryDataManager(null);
        }
    }

    /* synthetic */ BatteryDataManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ void access$200(BatteryDataManager r0) {
        r0.reportLastTimeBattery();
    }

    private BatteryDataManager() {
        this.mCurrentActivityName = "";
    }

    public static BatteryDataManager getInstance() {
        return Holder.access$000();
    }

    public void setCurrentActivityName(String r1) {
        this.mCurrentActivityName = r1;
    }

    public String getCurrentActivityName() {
        return this.mCurrentActivityName;
    }

    public void record(BatteryLogEntity r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        handleRecord(r1);
    }

    public void handleReportAndHandleCache(boolean r2) {
        if (r2 == false) goto L9;
        AsyncEventManager.getInstance().post(new AnonymousClass1(this));
        return;
    L9:
        reportLastTimeBattery();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "handleReportAndHandleCache");
    }

    private void handleRecord(BatteryLogEntity r4) {
        if (TextUtils.isEmpty(this.mStartUUID) == false) goto L5;
        this.mStartUUID = String.valueOf(System.currentTimeMillis());
    L5:
        r4.setMainProcess(ApmContext.isMainProcess());
        r4.setProcessName(ApmContext.getCurrentProcessName());
        r4.setStartUuid(this.mStartUUID);
        if (r4.isFront() == false) goto L8;
        String r0 = this.mCurrentActivityName;
    L10:
        if (TextUtils.isEmpty(r4.getScene()) == true) goto L13;
        r0 = r4.getScene() + "#" + r0;
    L13:
        r4.setScene(r0);
        handleChargingStatus(r4);
        saveBatteryLog(r4);
        return;
    L8:
        r0 = "background";
        goto L10
    }

    private void handleChargingStatus(BatteryLogEntity r2) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return;
    L5:
        if (r2.isFront() == true) goto L10;
        r2.setStatus(false);
        return;
    }

    private void reportLastTimeBattery() {
        if (ApmContext.isMainProcess() == true) goto L5;
        return;
    L5:
        BatteryStatsRet r0 = new BatteryStatsRet();
        List<BatteryLogEntity> r1 = getBatteryLog(true, 0);
        if (ListUtils.isEmpty(r1) == false) goto L8;
        return;
    L8:
        boolean r2 = divideBySceneAndReport(r0, r1);
        r0.isProcessOver();
        BatteryLogEntity r3 = r1.get(r1.size() - 1);
        long r4 = r3.getId();
        long r5 = r3.getTime();
        if (r2 == true) goto L16;
        if (ApmContext.isDebugMode() == false) goto L13;
        Logger.w(DebugLogger.TAG_BATTERY, new String[]{"report main process data failed, clean data and stop calc data of other process"});
    L13:
        cleanBatteryLog(r4);
        return;
    L16:
        if (ApmContext.isDebugMode() == false) goto L18;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"report main process data over, begin handle other process data"});
    L18:
        List<BatteryLogEntity> r6 = getBatteryLog(false, r5);
        HashMap r7 = new HashMap(4);
        Iterator<BatteryLogEntity> r8 = r6.iterator();
    L20:
        if (r8.hasNext() == false) goto L34;
        BatteryLogEntity r9 = r8.next();
        String r10 = r9.getProcessName();
        List r11 = (List) r7.get(r10);
        if (r11 != null) goto L23;
        LinkedList r12 = new LinkedList();
        r12.add(r9);
        r7.put(r10, r12);
        goto L20
    L23:
        r11.add(r9);
        goto L20
    L34:
        Iterator r13 = r7.values().iterator();     // Catch: Exception -> L30
    L27:
        if (r13.hasNext() == false) goto L32;
        divideBySceneAndReport(r0, (List) r13.next());     // Catch: Exception -> L30
        r0.isProcessOver();     // Catch: Exception -> L30
    L32:
        r0.reportOverallData();
        cleanBatteryLog(r4);
        ApmAlogHelper.i(Constants.TAG_BATTERY, "Report Data All Success");
        return;
    L30:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "reportLastTimeBattery");
        goto L32
    }

    private boolean divideBySceneAndReport(BatteryStatsRet r5, List<BatteryLogEntity> r6) {
        HashMap r0 = new HashMap(4);
        Iterator<BatteryLogEntity> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L20;
        BatteryLogEntity r1 = r7.next();
        String r2 = r1.getScene();
        List r3 = (List) r0.get(r2);
        if (r3 != null) goto L7;
        LinkedList r4 = new LinkedList();
        r4.add(r1);
        r0.put(r2, r4);
        goto L4
    L7:
        r3.add(r1);
        goto L4
    L20:
        Iterator r8 = r0.values().iterator();     // Catch: Exception -> L17
        boolean r9 = true;
    L12:
        if (r8.hasNext() == false) goto L33;
        if (divideByChargingStatusAndReport(r5, (List) r8.next()) == true) goto L12;
        r9 = false;
        goto L12
    L33:
        return r9;
    L17:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "divideBySceneAndReport");
        return false;
    }

    private boolean divideByChargingStatusAndReport(BatteryStatsRet r5, List<BatteryLogEntity> r6) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<BatteryLogEntity> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L25;
        BatteryLogEntity r2 = r7.next();
        if (r2.isOn() == true) goto L7;
        r1.add(r2);
        goto L4
    L7:
        r0.add(r2);
        goto L4
    L25:
    L22:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "divideByChargingStatusAndReport");
        return false;
    L11:
        if (r0.isEmpty() == false) goto L13;
    L15:
        boolean r3 = true;
    L17:
        if (r1.isEmpty() == true) goto L33;
        if (report(r5, r1) == true) goto L33;
        return false;
    L33:
        return r3;
    L13:
        if (report(r5, r0) == true) goto L15;
        r3 = false;
        goto L17
    }

    private boolean report(BatteryStatsRet r7, List<BatteryLogEntity> r8) throws Exception {
        Map<String, IBatteryStats> r6 = BatteryCollector.getInstance().getBatteryStatsMap();
        StringBuilder r0 = new StringBuilder();
        Iterator<BatteryLogEntity> r1 = r8.iterator();
        String r2 = null;
    L4:
        if (r1.hasNext() == false) goto L19;
        BatteryLogEntity r3 = r1.next();
        if (r2 != null) goto L8;
    L9:
        r2 = r3.getStartUuid();
        r0.append(r2);
    L11:
        if (BatteryTypeInf.BATTERY_GROUND_RECORD.equals(r3.type) == true) goto L13;
        IBatteryStats r4 = r6.get(r3.type);
        if (r4 == null) goto L4;
        r4.updateStatsRet(r7, r3);
        goto L4
    L13:
        if (r3.isFront() == true) goto L14;
        r7.addBackDuration(r3.getAccumulation());
        goto L4
    L14:
        r7.addFrontDuration(r3.getAccumulation());
        goto L4
    L8:
        if (r2.equals(r3.getStartUuid()) == true) goto L11;
    L19:
        BatteryLogEntity r9 = r8.get(0);
        r7.setMainProcess(r9.isMainProcess());
        r7.setProcessName(r9.getProcessName());
        r7.setStartUUID(r0.toString());
        r7.setScene(r9.getScene());
        r7.setIsCharging(r9.isOn());
        ApmAlogHelper.i(Constants.TAG_BATTERY, "Report Data proc:" + r9.getProcessName() + " scene:" + r9.getScene() + " size:" + r8.size());
        return r7.report(true);
    }

    private void saveBatteryLog(BatteryLogEntity r5) {
    L8:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "saveBatteryLog");
        return;
    L4:
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"saveBatteryLog into db: " + r5});     // Catch: Exception -> L8
    L6:
        ApmAlogHelper.i(Constants.TAG_BATTERY_LOCAL, transToLocalRecordData(r5));     // Catch: Exception -> L8
        getBatteryLogManager().saveLog(r5);     // Catch: Exception -> L8
    }

    private String transToLocalRecordData(BatteryLogEntity r7) throws JSONException {
        JSONObject r6 = r7.simpleJson();
        if (TextUtils.equals(r7.getType(), BatteryTypeInf.BATTERY_CPU_ACTIVE) == false) goto L6;
        r6.put(DBHelper.BATTERY_COL_ACCUMULATION, (r7.getAccumulation() * 1000) / CommonMonitorUtil.getScClkTck(100));
    L10:
        return r6.toString();
    L6:
        if (TextUtils.equals(r7.getType(), "traffic") == false) goto L8;
        r6.put(DBHelper.BATTERY_COL_ACCUMULATION, r7.getAccumulation() / 1024);
        goto L10
    L8:
        r6.put(DBHelper.BATTERY_COL_ACCUMULATION, r7.getAccumulation());
        goto L10
    }

    private List<BatteryLogEntity> getBatteryLog(boolean r1, long r2) {
        return getBatteryLogManager().getLogs(r1, r2);
    L5:
        return Collections.emptyList();
    }

    private void cleanBatteryLog(long r1) {
        getBatteryLogManager().updateDeleteFlag(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "cleanBatteryLog");
    }

    private BatteryTmpLogDao getBatteryLogManager() {
        if (this.mBatteryLogManager != null) goto L6;
        this.mBatteryLogManager = BatteryTmpLogDao.getInstance();
    L6:
        return this.mBatteryLogManager;
    }

    public JSONObject getMainThreadBatteryData() {
        JSONObject r0 = new JSONObject();
        List<BatteryLogEntity> r1 = getBatteryLog(true, 0);
        if (ListUtils.isEmpty(r1) == false) goto L5;
        return r0;
    L5:
        BatteryStatsRet r2 = new BatteryStatsRet();
        if (setupBatteryStats(r2, r1) == true) goto L13;
    L12:
        return r0;
    L13:
        JSONObject r4 = r2.computeAndReturnJSONObject(true);     // Catch: Exception -> L10
        if (r4 == null) goto L12;
        return r4;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private boolean setupBatteryStats(BatteryStatsRet r7, List<BatteryLogEntity> r8) {
        Map<String, IBatteryStats> r6 = BatteryCollector.getInstance().getBatteryStatsMap();
        StringBuilder r0 = new StringBuilder();
        Iterator<BatteryLogEntity> r1 = r8.iterator();
        String r2 = null;
    L4:
        if (r1.hasNext() == false) goto L19;
        BatteryLogEntity r3 = r1.next();
        if (r2 != null) goto L8;
    L9:
        r2 = r3.getStartUuid();
        r0.append(r2);
    L11:
        if (BatteryTypeInf.BATTERY_GROUND_RECORD.equals(r3.type) == true) goto L13;
        IBatteryStats r4 = r6.get(r3.type);
        if (r4 == null) goto L4;
        r4.updateStatsRet(r7, r3);
        goto L4
    L13:
        if (r3.isFront() == true) goto L14;
        r7.addBackDuration(r3.getAccumulation());
        goto L4
    L14:
        r7.addFrontDuration(r3.getAccumulation());
        goto L4
    L8:
        if (r2.equals(r3.getStartUuid()) == true) goto L11;
    L19:
        BatteryLogEntity r9 = r8.get(0);
        r7.setMainProcess(r9.isMainProcess());
        r7.setProcessName(r9.getProcessName());
        r7.setStartUUID(r0.toString());
        return true;
    }
}
