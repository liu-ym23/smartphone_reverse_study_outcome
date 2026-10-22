package com.android.settings;

import android.os.BatteryStats;
import android.util.ArrayMap;
import android.util.SparseArray;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes2.dex */
public class FakeUid extends BatteryStats.Uid {
    private final int mUid;

    public BatteryStats.Timer getAggregatedPartialWakelockTimer() {
        return null;
    }

    public BatteryStats.Timer getAudioTurnedOnTimer() {
        return null;
    }

    public Object getBatteryStatsImplUidSmtEx() {
        return null;
    }

    public BatteryStats.ControllerActivityCounter getBluetoothControllerActivity() {
        return null;
    }

    public long getBluetoothEnergyConsumptionUC() {
        return 0;
    }

    public long getBluetoothEnergyConsumptionUC(int r1) {
        return 0;
    }

    public BatteryStats.Timer getBluetoothScanBackgroundTimer() {
        return null;
    }

    public BatteryStats.Counter getBluetoothScanResultBgCounter() {
        return null;
    }

    public BatteryStats.Counter getBluetoothScanResultCounter() {
        return null;
    }

    public BatteryStats.Timer getBluetoothScanTimer() {
        return null;
    }

    public BatteryStats.Timer getBluetoothUnoptimizedScanBackgroundTimer() {
        return null;
    }

    public BatteryStats.Timer getBluetoothUnoptimizedScanTimer() {
        return null;
    }

    public long getCameraEnergyConsumptionUC() {
        return 0;
    }

    public BatteryStats.Timer getCameraTurnedOnTimer() {
        return null;
    }

    public long getCpuActiveTime() {
        return 0;
    }

    public long getCpuActiveTime(int r1) {
        return 0;
    }

    public long[] getCpuClusterTimes() {
        return null;
    }

    public long getCpuEnergyConsumptionUC() {
        return 0;
    }

    public long getCpuEnergyConsumptionUC(int r1) {
        return 0;
    }

    public boolean getCpuFreqTimes(long[] r1, int r2) {
        return false;
    }

    public long[] getCpuFreqTimes(int r1) {
        return null;
    }

    public long[] getCustomEnergyConsumerBatteryConsumptionUC() {
        return new long[0];
    }

    public void getDeferredJobsCheckinLineLocked(StringBuilder r1, int r2) {
    }

    public void getDeferredJobsLineLocked(StringBuilder r1, int r2) {
    }

    public BatteryStats.Timer getFlashlightTurnedOnTimer() {
        return null;
    }

    public BatteryStats.Timer getForegroundActivityTimer() {
        return null;
    }

    public BatteryStats.Timer getForegroundServiceTimer() {
        return null;
    }

    public long getFullWifiLockTime(long r1, int r3) {
        return 0;
    }

    public long getGnssEnergyConsumptionUC() {
        return 0;
    }

    public ArrayMap<String, SparseIntArray> getJobCompletionStats() {
        return null;
    }

    public ArrayMap<String, ? extends BatteryStats.Timer> getJobStats() {
        return null;
    }

    public int getMobileRadioActiveCount(int r1) {
        return 0;
    }

    public long getMobileRadioActiveTime(int r1) {
        return 0;
    }

    public long getMobileRadioActiveTimeInProcessState(int r1) {
        return 0;
    }

    public long getMobileRadioApWakeupCount(int r1) {
        return 0;
    }

    public long getMobileRadioEnergyConsumptionUC() {
        return 0;
    }

    public long getMobileRadioEnergyConsumptionUC(int r1) {
        return 0;
    }

    public BatteryStats.ControllerActivityCounter getModemControllerActivity() {
        return null;
    }

    public BatteryStats.Timer getMulticastWakelockStats() {
        return null;
    }

    public long getNetworkActivityBytes(int r1, int r2) {
        return 0;
    }

    public long getNetworkActivityPackets(int r1, int r2) {
        return 0;
    }

    public ArrayMap<String, ? extends BatteryStats.Uid.Pkg> getPackageStats() {
        return null;
    }

    public SparseArray<? extends BatteryStats.Uid.Pid> getPidStats() {
        return null;
    }

    public long getProcessStateTime(int r1, long r2, int r4) {
        return 0;
    }

    public BatteryStats.Timer getProcessStateTimer(int r1) {
        return null;
    }

    public ArrayMap<String, ? extends BatteryStats.Uid.Proc> getProcessStats() {
        return null;
    }

    public double getProportionalSystemServiceUsage() {
        return 0.0d;
    }

    public boolean getScreenOffCpuFreqTimes(long[] r1, int r2) {
        return false;
    }

    public long[] getScreenOffCpuFreqTimes(int r1) {
        return null;
    }

    public long getScreenOnEnergyConsumptionUC() {
        return 0;
    }

    public SparseArray<? extends BatteryStats.Uid.Sensor> getSensorStats() {
        return null;
    }

    public ArrayMap<String, ? extends BatteryStats.Timer> getSyncStats() {
        return null;
    }

    public long getSystemCpuTimeUs(int r1) {
        return 0;
    }

    public long getTimeAtCpuSpeed(int r1, int r2, int r3) {
        return 0;
    }

    public int getUserActivityCount(int r1, int r2) {
        return 0;
    }

    public long getUserCpuTimeUs(int r1) {
        return 0;
    }

    public BatteryStats.Timer getVibratorOnTimer() {
        return null;
    }

    public BatteryStats.Timer getVideoTurnedOnTimer() {
        return null;
    }

    public ArrayMap<String, ? extends BatteryStats.Uid.Wakelock> getWakelockStats() {
        return null;
    }

    public int getWifiBatchedScanCount(int r1, int r2) {
        return 0;
    }

    public long getWifiBatchedScanTime(int r1, long r2, int r4) {
        return 0;
    }

    public BatteryStats.ControllerActivityCounter getWifiControllerActivity() {
        return null;
    }

    public long getWifiEnergyConsumptionUC() {
        return 0;
    }

    public long getWifiEnergyConsumptionUC(int r1) {
        return 0;
    }

    public long getWifiMulticastTime(long r1, int r3) {
        return 0;
    }

    public long getWifiRadioApWakeupCount(int r1) {
        return 0;
    }

    public long getWifiRunningTime(long r1, int r3) {
        return 0;
    }

    public long getWifiScanActualTime(long r1) {
        return 0;
    }

    public int getWifiScanBackgroundCount(int r1) {
        return 0;
    }

    public long getWifiScanBackgroundTime(long r1) {
        return 0;
    }

    public BatteryStats.Timer getWifiScanBackgroundTimer() {
        return null;
    }

    public int getWifiScanCount(int r1) {
        return 0;
    }

    public long getWifiScanTime(long r1, int r3) {
        return 0;
    }

    public BatteryStats.Timer getWifiScanTimer() {
        return null;
    }

    public boolean hasNetworkActivity() {
        return false;
    }

    public boolean hasUserActivity() {
        return false;
    }

    public void noteActivityPausedLocked(long r1) {
    }

    public void noteActivityResumedLocked(long r1) {
    }

    public void noteFullWifiLockAcquiredLocked(long r1) {
    }

    public void noteFullWifiLockReleasedLocked(long r1) {
    }

    public void noteUserActivityLocked(int r1) {
    }

    public void noteWifiBatchedScanStartedLocked(int r1, long r2) {
    }

    public void noteWifiBatchedScanStoppedLocked(long r1) {
    }

    public void noteWifiMulticastDisabledLocked(long r1) {
    }

    public void noteWifiMulticastEnabledLocked(long r1) {
    }

    public void noteWifiRunningLocked(long r1) {
    }

    public void noteWifiScanStartedLocked(long r1) {
    }

    public void noteWifiScanStoppedLocked(long r1) {
    }

    public void noteWifiStoppedLocked(long r1) {
    }

    public FakeUid(int r1) {
        this.mUid = r1;
    }

    public int getUid() {
        return this.mUid;
    }
}
