package com.android.settingslib.bluetooth;

import android.content.Context;
import android.content.SharedPreferences;
import com.GlobalProxyLancet;
import com.android.internal.util.FrameworkStatsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public final class HearingAidStatsLogUtils {
    private static final String ACCESSIBILITY_PREFERENCE = "accessibility_prefs";
    private static final String BT_HEARABLE_DEVICES_CONNECTED_HISTORY = "bt_hearing_devices_connected_history";
    private static final String BT_HEARABLE_DEVICES_PAIRED_HISTORY = "bt_hearing_devices_paired_history";
    private static final String BT_HEARING_AIDS_CONNECTED_HISTORY = "bt_hearing_aids_connected_history";
    private static final String BT_HEARING_AIDS_PAIRED_HISTORY = "bt_hearing_aids_paired_history";
    static final String CATEGORY_HEARABLE_DEVICES = "A11yHearingDevicesUser";
    static final String CATEGORY_HEARING_AIDS = "A11yHearingAidsUser";
    static final String CATEGORY_NEW_HEARABLE_DEVICES = "A11yNewHearingDevicesUser";
    static final String CATEGORY_NEW_HEARING_AIDS = "A11yNewHearingAidsUser";
    static final int CONNECTED_HISTORY_EXPIRED_DAY = 7;
    private static final boolean DEBUG = true;
    private static final String HISTORY_RECORD_DELIMITER = ",";
    private static final HashMap<Integer, String> HISTORY_TYPE_TO_SP_NAME_MAPPING = null;
    static final int PAIRED_HISTORY_EXPIRED_DAY = 30;
    private static final String TAG = "HearingAidStatsLogUtils";
    private static final int VALID_CONNECTED_EVENT_COUNT = 7;
    private static final int VALID_PAIRED_EVENT_COUNT = 1;
    private static final HashMap<String, Integer> sDeviceAddressToBondEntryMap = null;
    private static final Set<String> sJustBondedDeviceAddressSet = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HistoryType {
        public static final int TYPE_HEARABLE_DEVICES_CONNECTED = 3;
        public static final int TYPE_HEARABLE_DEVICES_PAIRED = 2;
        public static final int TYPE_HEARING_AIDS_CONNECTED = 1;
        public static final int TYPE_HEARING_AIDS_PAIRED = 0;
        public static final int TYPE_UNKNOWN = -1;
    }

    public static /* synthetic */ String $r8$lambda$KlpKwH32oNvWt8mdxCAl3BFSBx4(Long r0) {
        return r0.toString();
    }

    static {
        sDeviceAddressToBondEntryMap = new HashMap();
        sJustBondedDeviceAddressSet = new HashSet();
        HashMap<Integer, String> r0 = new HashMap();
        HISTORY_TYPE_TO_SP_NAME_MAPPING = r0;
        r0.put(0, BT_HEARING_AIDS_PAIRED_HISTORY);
        r0.put(1, BT_HEARING_AIDS_CONNECTED_HISTORY);
        r0.put(2, BT_HEARABLE_DEVICES_PAIRED_HISTORY);
        r0.put(3, BT_HEARABLE_DEVICES_CONNECTED_HISTORY);
    }

    public static void setBondEntryForDevice(int r1, CachedBluetoothDevice r2) {
        sDeviceAddressToBondEntryMap.put(r2.getAddress(), Integer.valueOf(r1));
    }

    public static void logHearingAidInfo(CachedBluetoothDevice r5) {
        String r0 = r5.getAddress();
        HashMap<String, Integer> r1 = sDeviceAddressToBondEntryMap;
        if (r1.containsKey(r0) == false) goto L5;
        int r2 = r1.getOrDefault(r0, -1).intValue();
        FrameworkStatsLog.write(513, r5.getDeviceMode(), r5.getDeviceSide(), r2);
        r1.remove(r0);
        return;
    L5:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "The device address was not found. Hearing aid device info is not logged.");
    }

    static HashMap<String, Integer> getDeviceAddressToBondEntryMap() {
        return sDeviceAddressToBondEntryMap;
    }

    public static void updateHistoryIfNeeded(Context r3, CachedBluetoothDevice r4, LocalBluetoothProfile r5, int r6) {
        if (isJustBonded(r4.getAddress()) == true) goto L5;
    L11:
        if (r6 == 2) goto L13;
        return;
    L13:
        if ((r5 instanceof HearingAidProfile) == false) goto L15;
    L22:
        addCurrentTimeToHistory(r3, 1);
        return;
    L15:
        if ((r5 instanceof HapClientProfile) == true) goto L22;
        if ((r5 instanceof A2dpSinkProfile) == false) goto L20;
    L21:
        addCurrentTimeToHistory(r3, 3);
        return;
    L20:
        if ((r5 instanceof HeadsetProfile) == true) goto L21;
        return;
    L5:
        if (r4.getProfiles().stream().anyMatch(new HearingAidStatsLogUtils$$ExternalSyntheticLambda1()) == false) goto L8;
        addCurrentTimeToHistory(r3, 0);
    L10:
        removeFromJustBonded(r4.getAddress());
        goto L11
    L8:
        if (r4.getProfiles().stream().anyMatch(new HearingAidStatsLogUtils$$ExternalSyntheticLambda2()) == false) goto L10;
        addCurrentTimeToHistory(r3, 2);
        goto L10
    }

    static /* synthetic */ boolean lambda$updateHistoryIfNeeded$0(LocalBluetoothProfile r1) {
        if ((r1 instanceof HearingAidProfile) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof HapClientProfile) == true) goto L8;
        return false;
    }

    static /* synthetic */ boolean lambda$updateHistoryIfNeeded$1(LocalBluetoothProfile r1) {
        if ((r1 instanceof A2dpSinkProfile) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof HeadsetProfile) == true) goto L8;
        return false;
    }

    public static synchronized String getUserCategory(Context r4) {
        monitor-enter(HearingAidStatsLogUtils.class);
        LinkedList<Long> r2 = getHistory(r4, 1);     // Catch: Throwable -> L37
        if (r2 == null) goto L20;
        if (r2.size() < 7) goto L20;
        LinkedList<Long> r5 = getHistory(r4, 0);     // Catch: Throwable -> L37
        if (r5 == null) goto L17;
        if (r5.size() < 1) goto L17;
        monitor-exit(HearingAidStatsLogUtils.class);
        return CATEGORY_NEW_HEARING_AIDS;
    L17:
        monitor-exit(HearingAidStatsLogUtils.class);
        return CATEGORY_HEARING_AIDS;
    L20:
        LinkedList<Long> r3 = getHistory(r4, 3);     // Catch: Throwable -> L37
        if (r3 == null) goto L35;
        if (r3.size() < 7) goto L35;
        LinkedList<Long> r6 = getHistory(r4, 2);     // Catch: Throwable -> L37
        if (r6 == null) goto L32;
        if (r6.size() < 1) goto L32;
        monitor-exit(HearingAidStatsLogUtils.class);
        return CATEGORY_NEW_HEARABLE_DEVICES;
    L32:
        monitor-exit(HearingAidStatsLogUtils.class);
        return CATEGORY_HEARABLE_DEVICES;
    L35:
        monitor-exit(HearingAidStatsLogUtils.class);
        return "";
    L37:
        th = move-exception;
        throw th;
    }

    public static void addToJustBonded(String r1) {
        sJustBondedDeviceAddressSet.add(r1);
    }

    private static void removeFromJustBonded(String r1) {
        sJustBondedDeviceAddressSet.remove(r1);
    }

    private static boolean isJustBonded(String r1) {
        return sJustBondedDeviceAddressSet.contains(r1);
    }

    public static void addCurrentTimeToHistory(Context r2, int r3) {
        addToHistory(r2, r3, System.currentTimeMillis());
    }

    static synchronized void addToHistory(Context r5, int r6, long r7) {
        monitor-enter(HearingAidStatsLogUtils.class);
        LinkedList<Long> r2 = getHistory(r5, r6);     // Catch: Throwable -> L19
        if (r2 != null) goto L10;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Couldn't find shared preference name matched type=" + r6);     // Catch: Throwable -> L19
        monitor-exit(HearingAidStatsLogUtils.class);
        return;
    L10:
        if (r2.peekLast() != null) goto L12;
    L16:
        r2.add(Long.valueOf(r7));     // Catch: Throwable -> L19
        getSharedPreferences(r5).edit().putString(HISTORY_TYPE_TO_SP_NAME_MAPPING.get(Integer.valueOf(r6)), convertToHistoryString(r2)).apply();     // Catch: Throwable -> L19
        monitor-exit(HearingAidStatsLogUtils.class);
        return;
    L12:
        if (isSameDay(r7, r2.peekLast().longValue()) == false) goto L16;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Skip this record, it's same day record");     // Catch: Throwable -> L19
        monitor-exit(HearingAidStatsLogUtils.class);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    static synchronized LinkedList<Long> getHistory(Context r2, int r3) {
        monitor-enter(HearingAidStatsLogUtils.class);
        String r4 = HISTORY_TYPE_TO_SP_NAME_MAPPING.get(Integer.valueOf(r3));     // Catch: Throwable -> L23
        if (BT_HEARING_AIDS_PAIRED_HISTORY.equals(r4) == false) goto L7;
    L20:
        LinkedList<Long> r5 = convertToHistoryList(getSharedPreferences(r2).getString(r4, ""));     // Catch: Throwable -> L23
        removeRecordsBeforeDay(r5, 30);     // Catch: Throwable -> L23
        monitor-exit(HearingAidStatsLogUtils.class);
        return r5;
    L7:
        if (BT_HEARABLE_DEVICES_PAIRED_HISTORY.equals(r4) == true) goto L20;
        if (BT_HEARING_AIDS_CONNECTED_HISTORY.equals(r4) == false) goto L12;
    L17:
        LinkedList<Long> r6 = convertToHistoryList(getSharedPreferences(r2).getString(r4, ""));     // Catch: Throwable -> L23
        removeRecordsBeforeDay(r6, 7);     // Catch: Throwable -> L23
        monitor-exit(HearingAidStatsLogUtils.class);
        return r6;
    L12:
        if (BT_HEARABLE_DEVICES_CONNECTED_HISTORY.equals(r4) == true) goto L17;
        monitor-exit(HearingAidStatsLogUtils.class);
        return null;
    L23:
        th = move-exception;
        throw th;
    }

    private static void removeRecordsBeforeDay(LinkedList<Long> r6, int r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L15;
        long r0 = System.currentTimeMillis();
    L8:
        if (r6.peekFirst() == null) goto L16;
        if (dayDifference(r0, r6.peekFirst().longValue()) < r7) goto L17;
        r6.poll();
        goto L8
    L17:
        return;
    L16:
        return;
    }

    private static String convertToHistoryString(LinkedList<Long> r1) {
        return (String) r1.stream().map(new HearingAidStatsLogUtils$$ExternalSyntheticLambda0()).collect(Collectors.joining(HISTORY_RECORD_DELIMITER));
    }

    private static LinkedList<Long> convertToHistoryList(String r5) {
        if (r5 == null) goto L15;
        if (r5.isEmpty() == true) goto L15;
        LinkedList<Long> r0 = new LinkedList();
        String[] r6 = r5.split(HISTORY_RECORD_DELIMITER);
        int r1 = r6.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        String r3 = r6[r2];
        if (r3.isEmpty() == true) goto L12;
        r0.offer(Long.valueOf(Long.parseLong(r3)));
    L12:
        r2 = r2 + 1;
        goto L7
    L13:
        return r0;
    L15:
        return new LinkedList();
    }

    private static boolean isSameDay(long r0, long r2) {
        if (dayDifference(r0, r2) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static long dayDifference(long r1, long r3) {
        ZoneId r0 = ZoneId.systemDefault();
        LocalDate r2 = Instant.ofEpochMilli(r1).atZone(r0).toLocalDate();
        LocalDate r4 = Instant.ofEpochMilli(r3).atZone(r0).toLocalDate();
        return Math.abs(ChronoUnit.DAYS.between(r2, r4));
    }

    private static SharedPreferences getSharedPreferences(Context r2) {
        return r2.getSharedPreferences(ACCESSIBILITY_PREFERENCE, 0);
    }

    private HearingAidStatsLogUtils() {
    }
}
