package com.android.settingslib.net;

import android.R;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkTemplate;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.Range;
import com.GlobalProxyLancet;
import com.android.internal.util.ArrayUtils;
import java.time.ZonedDateTime;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DataUsageController {
    private static final boolean DEBUG = false;
    private static final long MB_IN_BYTES = 1048576;
    private static final StringBuilder PERIOD_BUILDER = null;
    private static final Formatter PERIOD_FORMATTER = null;
    private static final String TAG = "DataUsageController";
    private Callback mCallback;
    private final Context mContext;
    private NetworkNameProvider mNetworkController;
    private final NetworkStatsManager mNetworkStatsManager;
    private final NetworkPolicyManager mPolicyManager;
    private int mSubscriptionId;

    public interface Callback {
        void onMobileDataEnabled(boolean r1);
    }

    public static class DataUsageInfo {
        public String carrier;
        public long cycleEnd;
        public long cycleStart;
        public long limitLevel;
        public String period;
        public long startDate;
        public long usageLevel;
        public long warningLevel;

        public DataUsageInfo() {
        }
    }

    public interface NetworkNameProvider {
        String getMobileDataNetworkName();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        StringBuilder r0 = new StringBuilder(50);
        PERIOD_BUILDER = r0;
        PERIOD_FORMATTER = new Formatter(r0, Locale.getDefault());
    }

    public DataUsageController(Context r2) {
        this.mContext = r2;
        this.mPolicyManager = NetworkPolicyManager.from(r2);
        this.mNetworkStatsManager = (NetworkStatsManager) r2.getSystemService(NetworkStatsManager.class);
        this.mSubscriptionId = -1;
    }

    public void setNetworkController(NetworkNameProvider r1) {
        this.mNetworkController = r1;
    }

    public void setSubscriptionId(int r1) {
        this.mSubscriptionId = r1;
    }

    public long getDefaultWarningLevel() {
        return ((long) this.mContext.getResources().getInteger(R.integer.config_wait_for_satellite_enabling_response_timeout_millis)) * 1048576;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    private DataUsageInfo warn(String r2) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to get data usage, " + r2);
        return null;
    }

    public DataUsageInfo getDataUsageInfo(NetworkTemplate r14) {
        NetworkPolicy r0 = findNetworkPolicy(r14);
        long r1 = System.currentTimeMillis();
        if (r0 == null) goto L5;
        Iterator r3 = r0.cycleIterator();
    L6:
        if (r3 != null) goto L8;
    L10:
        long r4 = r1 - 2419200000L;
    L11:
        long r5 = getUsageLevel(r14, r4, r1);
        long r7 = 0;
        if (r5 < 0) goto L14;
        DataUsageInfo r15 = new DataUsageInfo();
        r15.startDate = r4;
        r15.usageLevel = r5;
        r15.period = formatDateRange(r4, r1);
        r15.cycleStart = r4;
        r15.cycleEnd = r1;
        if (r0 != null) goto L18;
        r15.warningLevel = getDefaultWarningLevel();
    L26:
        NetworkNameProvider r13 = this.mNetworkController;
        if (r13 == null) goto L29;
        r15.carrier = r13.getMobileDataNetworkName();
    L29:
        return r15;
    L18:
        if (r0.limitBytes <= 0) goto L20;
        long r2 = r0.limitBytes;
    L21:
        r15.limitLevel = r2;
        if (r0.warningBytes <= 0) goto L24;
        r7 = r0.warningBytes;
    L24:
        r15.warningLevel = r7;
        goto L26
    L20:
        r2 = 0;
        goto L21
    L14:
        return warn("no entry data");
    L8:
        if (r3.hasNext() == false) goto L10;
        Range r6 = (Range) r3.next();
        long r8 = ((ZonedDateTime) r6.getLower()).toInstant().toEpochMilli();
        r1 = ((ZonedDateTime) r6.getUpper()).toInstant().toEpochMilli();
        r4 = r8;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    public long getHistoricalUsageLevel(NetworkTemplate r7) {
        return getUsageLevel(r7, 0, System.currentTimeMillis());
    }

    private long getUsageLevel(NetworkTemplate r8, long r9, long r11) {
        NetworkStats.Bucket r7 = this.mNetworkStatsManager.querySummaryForDevice(r8, r9, r11);     // Catch: RuntimeException -> L9
        if (r7 != null) goto L6;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to get data usage, no entry data");     // Catch: RuntimeException -> L9
        return -1;
    L6:
        return r7.getRxBytes() + r7.getTxBytes();
    L9:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to get data usage, remote call failed");
        return -1;
    }

    private NetworkPolicy findNetworkPolicy(NetworkTemplate r6) {
        NetworkPolicyManager r5 = this.mPolicyManager;
        if (r5 == null) goto L17;
        if (r6 == null) goto L17;
        NetworkPolicy[] r7 = r5.getNetworkPolicies();
        if (r7 != null) goto L9;
        return null;
    L9:
        int r1 = r7.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L17;
        NetworkPolicy r3 = r7[r2];
        if (r3 == null) goto L16;
        if (r6.equals(r3.template) == false) goto L16;
        return r3;
    L16:
        r2 = r2 + 1;
    L17:
        return null;
    }

    public TelephonyManager getTelephonyManager() {
        int r0 = this.mSubscriptionId;
        if (SubscriptionManager.isValidSubscriptionId(r0) == true) goto L6;
        r0 = SubscriptionManager.getDefaultDataSubscriptionId();
    L6:
        if (SubscriptionManager.isValidSubscriptionId(r0) == true) goto L11;
        int[] r1 = SubscriptionManager.from(this.mContext).getActiveSubscriptionIdList();
        if (ArrayUtils.isEmpty(r1) == true) goto L11;
        r0 = r1[0];
    L11:
        return ((TelephonyManager) this.mContext.getSystemService(TelephonyManager.class)).createForSubscriptionId(r0);
    }

    public void setMobileDataEnabled(boolean r3) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "setMobileDataEnabled: enabled=" + r3);
        getTelephonyManager().setDataEnabled(r3);
        Callback r2 = this.mCallback;
        if (r2 == null) goto L6;
        r2.onMobileDataEnabled(r3);
        return;
    }

    public boolean isMobileDataSupported() {
        if (getTelephonyManager().isDataCapable() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTelephonyManager().getSimState() != 5) goto L7;
        return true;
    }

    public boolean isMobileDataEnabled() {
        return getTelephonyManager().isDataEnabled();
    }

    private String formatDateRange(long r11, long r13) {
        StringBuilder r0 = PERIOD_BUILDER;
        monitor-enter(r0);
        r0.setLength(0);     // Catch: Throwable -> L8
        String r10 = DateUtils.formatDateRange(this.mContext, PERIOD_FORMATTER, r11, r13, 65552, null).toString();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r10;
    L8:
        th = move-exception;
        throw th;
    }
}
