package com.bytedance.apm.battery.stats;

import android.app.usage.NetworkStatsManager;
import android.os.Process;
import android.text.TextUtils;
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
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

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean r10, boolean r11) {
        if (isMainProcess() == true) goto L19;
        return;
    L19:
        long[] r2 = getTrafficData();     // Catch: Throwable -> L11
        if (this.mLastNetInfo == null) goto L9;
        if (r11 == false) goto L9;
        String r12 = BatteryCollector.getInstance().getCurSceneSetStr();     // Catch: Throwable -> L11
        saveNetInfo(r10, r2[0] - this.mLastNetInfo[0], "source_bytes", r12);     // Catch: Throwable -> L11
        saveNetInfo(r10, r2[1] - this.mLastNetInfo[1], "source_packets", r12);     // Catch: Throwable -> L11
    L9:
        this.mLastNetInfo = r2;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L16;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L16:
        if (this.hasReportedCustomException == true) goto L22;
        EnsureManager.ensureNotReachHere(th, "BatteryTrafficAllInterface");
        this.hasReportedCustomException = true;
        return;
    }

    private void saveNetInfo(boolean r12, long r13, String r15, String r16) {
        if (r13 < 0) goto L5;
        BatteryDataManager.getInstance().record(new BatteryLogEntity(r12, System.currentTimeMillis(), BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, this.mIsCharging, r13, r16, r15));
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"BatteryTrafficAllInterface value error: " + r13});
    L7:
        ApmAlogHelper.i(Constants.TAG_BATTERY, "BatteryTrafficAllInterface value error: " + r13);
    }

    private long[] getTrafficData() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (this.mGetDataLayerMethod != null) goto L10;
        NetworkStatsManager r0 = (NetworkStatsManager) ApmContext.getContext().getSystemService("netstats");
        Field r3 = r0.getClass().getDeclaredField("mService");
        r3.setAccessible(true);
        Object r1 = r3.get(r0);
        this.mServiceInstance = r1;
        Method[] r2 = r1.getClass().getDeclaredMethods();
        int r4 = r2.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L10;
        Method r6 = r2[r5];
        if (TextUtils.equals("getDataLayerSnapshotForUid", r6.getName()) == true) goto L8;
        r5 = r5 + 1;
        goto L5
    L8:
        this.mGetDataLayerMethod = r6;
        r6.setAccessible(true);
    L10:
        Object r7 = this.mGetDataLayerMethod.invoke(this.mServiceInstance, new Object[]{Integer.valueOf(Process.myUid())});
        Field r8 = r7.getClass().getDeclaredField("rxBytes");
        r8.setAccessible(true);
        long[] r9 = (long[]) r8.get(r7);
        Field r10 = r7.getClass().getDeclaredField("txBytes");
        r10.setAccessible(true);
        long[] r11 = (long[]) r10.get(r7);
        Field r12 = r7.getClass().getDeclaredField("rxPackets");
        r12.setAccessible(true);
        long[] r13 = (long[]) r12.get(r7);
        Field r14 = r7.getClass().getDeclaredField("txPackets");
        r14.setAccessible(true);
        return new long[]{sum(r9) + sum(r11), sum(r13) + sum((long[]) r14.get(r7))};
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
