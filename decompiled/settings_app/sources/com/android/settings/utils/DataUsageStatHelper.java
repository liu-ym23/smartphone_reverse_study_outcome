package com.android.settings.utils;

import android.content.Context;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.NetworkStats;
import android.net.NetworkTemplate;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.telephony.TelephonyManager;
import android.util.NtpTrustedTime;
import com.android.settings.MultiSimAdapter;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import java.util.Calendar;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageStatHelper {
    public static final int CYCLE_MONTH = 3;
    public static final int CYCLE_TODAY = 1;
    public static final int CYCLE_WEEK = 2;
    private static final String TAG = "DataUsageStatHelper";
    private static volatile DataUsageStatHelper mDataUsageStatHelper;
    private Context mContext;
    private INetworkStatsService mStatsService;
    private INetworkStatsSession mStatsSession;

    public static class AppDataUsageInfo {
        public long monthTotal;
        public long todayTotal;
        public long weekTotal;

        public AppDataUsageInfo() {
        }
    }

    public interface Callback {
        void onDataStatUpdated(AppDataUsageInfo r1);
    }

    static /* synthetic */ void access$000(DataUsageStatHelper r0) {
        r0.forceUpdate();
    }

    public static DataUsageStatHelper getInstance(Context r2) {
        if (mDataUsageStatHelper != null) goto L15;
        monitor-enter(DataUsageStatHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mDataUsageStatHelper != null) goto L9;
        mDataUsageStatHelper = new DataUsageStatHelper(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DataUsageStatHelper.class);     // Catch: Throwable -> L11
    L15:
        return mDataUsageStatHelper;
    }

    public DataUsageStatHelper(Context r1) {
        this.mContext = r1.getApplicationContext();
        INetworkStatsService r2 = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mStatsService = r2;
        this.mStatsSession = r2.openSession();     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.utils.DataUsageStatHelper$1] */
    public void forceUpdateAsync(final int r3, final Callback r4) {
        Void r1 = (Void) null;
        new AnonymousClass1(this, r3, r4).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[]{null});
    }

    private void forceUpdate() {
        Thread.sleep(100);     // Catch: RemoteException -> L5 InterruptedException -> L7
        this.mStatsService.forceUpdate();     // Catch: RemoteException -> L5 InterruptedException -> L7
    L13:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public long getDataUsageTotal(int r5, int r6) {
        long r0 = getDataUsageTotal(getMobileTemplate(this.mContext, null), r5, r6);
        OLog.d(TAG, "uid = " + r5 + ", data usage total is " + r0);
        OLog.d(TAG, "getDataUsageTotal for pkg = " + Utils.getPackageNameViaUid(this.mContext, r5) + ", cycle = " + r6 + " , total = " + r0);
        return r0;
    }

    public static NetworkTemplate getMobileTemplate(Context r1, String r2) {
        if (r2 == null) goto L4;
        Set r3 = Set.of(r2);
    L6:
        return new NetworkTemplate.Builder(1).setSubscriberIds(r3).setMeteredness(1).build();
    L4:
        r3 = Set.of();
        goto L6
    }

    private String getSubId(int r4) {
        String r0 = ((TelephonyManager) this.mContext.getSystemService(MultiSimAdapter.PHONE_KEY)).getSubscriberId(MultiSimAdapter.slot2Sub(r4));
        if (r0 != null) goto L6;
        TelephonyManager r3 = (TelephonyManager) this.mContext.getSystemService(MultiSimAdapter.PHONE_KEY);
        return TelephonyManager.getTelephonyProperty(r4, "persist.radio.last.subscriber", null);
    L6:
        return r0;
    }

    @Deprecated
    public long getDataUsageTotal(String r4, int r5) {
        int r0 = Utils.getAppUid(this.mContext, r4);
        if (r0 == (-1)) goto L5;
        long r1 = getDataUsageTotal(r0, r5);
    L6:
        OLog.d(TAG, "package name " + r4 + " , uid = " + r0 + " , data usage total = " + r1);
        return r1;
    L5:
        r1 = 0;
        goto L6
    }

    private long getDataUsageTotal(NetworkTemplate r7, int r8, int r9) {
        NetworkStats r6 = getNetworkStats(r7, r9);
        long r0 = 0;
        if (r6 == null) goto L11;
        int r10 = 0;
    L6:
        if (r10 >= r6.size()) goto L11;
        NetworkStats.Entry r11 = r6.getValues(r10, null);
        if (r11.uid != r8) goto L10;
        r0 = r0 + (r11.rxBytes + r11.txBytes);
    L10:
        r10 = r10 + 1;
    L11:
        return r0;
    }

    private NetworkStats getNetworkStats(NetworkTemplate r10, int r11) {
        Calendar r0 = Calendar.getInstance();
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        if (r11 != 2) goto L5;
        r0.setFirstDayOfWeek(2);
        r0.get(7);
        r0.set(7, 2);
    L9:
        long r4 = r0.getTimeInMillis();
        NtpTrustedTime r12 = NtpTrustedTime.getInstance(this.mContext);
        if (r12.hasCache() == false) goto L12;
        long r1 = r12.currentTimeMillis();
    L13:
        long r6 = r1;
        return this.mStatsSession.getSummaryForAllUid(r10, r4, r6, false);
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        r1 = System.currentTimeMillis();
        goto L13
    L5:
        if (r11 != 3) goto L9;
        r0.set(5, 1);
        goto L9
    }
}
