package com.bytedance.apm.battery.stats;

import a.a;
import android.app.usage.NetworkStatsManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class BatteryTrafficAllInterface extends AbsBatteryValueStats {
    private final String SOURCE_BYTES;
    private final String SOURCE_PACKETS;
    private boolean hasReportedCustomException;
    private Method mGetDataLayerMethod;
    private long[] mLastNetInfo;
    private Object mServiceInstance;

    public BatteryTrafficAllInterface() {
        super(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE);
        this.SOURCE_BYTES = "source_bytes";
        this.SOURCE_PACKETS = "source_packets";
        this.hasReportedCustomException = false;
    }

    @RequiresApi(api = 23)
    private long[] getTrafficData() {
        if (this.mGetDataLayerMethod != null) goto L10;
        NetworkStatsManager r1 = (NetworkStatsManager) ApmContext.getContext().getSystemService("netstats");
        Field r3 = r1.getClass().getDeclaredField("mService");
        r3.setAccessible(true);
        Object r2 = r3.get(r1);
        this.mServiceInstance = r2;
        Method[] r4 = r2.getClass().getDeclaredMethods();
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L10;
        Method r7 = r4[r6];
        if (TextUtils.equals("getDataLayerSnapshotForUid", r7.getName()) == true) goto L8;
        r6 = r6 + 1;
        goto L5
    L8:
        this.mGetDataLayerMethod = r7;
        r7.setAccessible(true);
    L10:
        Object r8 = this.mGetDataLayerMethod.invoke(this.mServiceInstance, new Object[]{Integer.valueOf(Process.myUid())});
        Field r9 = r8.getClass().getDeclaredField("rxBytes");
        r9.setAccessible(true);
        long[] r10 = (long[]) r9.get(r8);
        Field r11 = r8.getClass().getDeclaredField("txBytes");
        r11.setAccessible(true);
        long[] r12 = (long[]) r11.get(r8);
        Field r13 = r8.getClass().getDeclaredField("rxPackets");
        r13.setAccessible(true);
        long[] r14 = (long[]) r13.get(r8);
        Field r15 = r8.getClass().getDeclaredField("txPackets");
        r15.setAccessible(true);
        return new long[]{sum(r10) + sum(r12), sum(r14) + sum((long[]) r15.get(r8))};
    }

    private void saveNetInfo(boolean r12, long r13, String r15, String r16) {
        if (r13 < 0) goto L5;
        BatteryDataManager.getInstance().record(new BatteryLogEntity(r12, System.currentTimeMillis(), BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, this.mIsCharging, r13, r16, r15));
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{a.h("BatteryTrafficAllInterface value error: ", r13)});
    L7:
        ApmAlogHelper.i(Constants.TAG_BATTERY, "BatteryTrafficAllInterface value error: " + r13);
    }

    private long sum(long[] r6) {
        long r0 = 0;
        if (r6 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r6.length == 0) goto L10;
        int r5 = r6.length;
        int r2 = 0;
    L8:
        if (r2 >= r5) goto L10;
        r0 = r0 + r6[r2];
        r2 = r2 + 1;
        goto L8
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    public void computeValue(boolean r9, boolean r10) {
        if (isMainProcess() == true) goto L20;
        return;
    L20:
        long[] r1 = getTrafficData();     // Catch: Throwable -> L9
        if (this.mLastNetInfo == null) goto L11;
        if (r10 == false) goto L11;
        String r11 = BatteryCollector.getInstance().getCurSceneSetStr();     // Catch: Throwable -> L9
        saveNetInfo(r9, r1[0] - this.mLastNetInfo[0], "source_bytes", r11);     // Catch: Throwable -> L9
        saveNetInfo(r9, r1[1] - this.mLastNetInfo[1], "source_packets", r11);     // Catch: Throwable -> L9
    L11:
        this.mLastNetInfo = r1;     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L17;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L17:
        if (this.hasReportedCustomException == true) goto L23;
        EnsureManager.ensureNotReachHere(th, "BatteryTrafficAllInterface");
        this.hasReportedCustomException = true;
        return;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r3, BatteryLogEntity r4) {
        if (r4.isFront() == false) goto L11;
        if (TextUtils.equals(r4.getSource(), "source_bytes") == false) goto L8;
        r3.addFrontBytesAllInterface(r4.getAccumulation());
        return;
    L8:
        if (TextUtils.equals(r4.getSource(), "source_packets") == false) goto L18;
        r3.addFrontPacketsAllInterface(r4.getAccumulation());
        return;
    L18:
        return;
    L11:
        if (TextUtils.equals(r4.getSource(), "source_bytes") == false) goto L14;
        r3.addBackBytesAllInterface(r4.getAccumulation());
        return;
    L14:
        if (TextUtils.equals(r4.getSource(), "source_packets") == false) goto L21;
        r3.addBackPacketsAllInterface(r4.getAccumulation());
        return;
    }
}
