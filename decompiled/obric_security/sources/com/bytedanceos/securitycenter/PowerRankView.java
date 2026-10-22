package com.bytedanceos.securitycenter;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.BatteryStatsManager;
import android.os.BatteryUsageStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedanceos.batteryusage.BatteryEntry;
import com.bytedanceos.batteryusage.BatteryUsageStatsHelper;
import com.bytedanceos.os.BatteryStatsHelper;
import com.bytedanceos.security.widget.SecurityItemTextNeutral;
import com.bytedanceos.security.widget.SecurityProgressItemText;
import com.obric.olog.OLog;
import com.obric.security.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PowerRankView extends RelativeLayout {
    private static final int MAX_SHOW_COUNT = 3;
    private static final int MIN_POWER_THRESHOLD_MILLI_AMP = 5;
    private static final int MSG_REFRESH_STATS = 100;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final String TAG = "PowerRankView";
    private BroadcastReceiver mBatteryInfoReceiver;
    private LinearLayout mContainer;
    private Activity mContext;
    PowerHandler mHandler;
    private SecurityProgressItemText mPowerRankTop1;
    private SecurityProgressItemText mPowerRankTop2;
    private SecurityProgressItemText mPowerRankTop3;
    private SecurityItemTextNeutral mPowerRankTotal;
    private volatile boolean mRefreshing;
    private BatteryStatsHelper mStatsHelper;
    private View mTitleDivider;
    private double mTotalUsage;
    private UserManager mUm;
    private SparseArray<Map<String, BatteryEntry>> mUsageMap;
    private SparseArray<BatteryEntry> mUsageMapWithUid;

    private static class PowerHandler extends Handler {
        private WeakReference<PowerRankView> powerReference;

        PowerHandler(PowerRankView powerRankView) {
            this.powerReference = new WeakReference(powerRankView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int r0 = msg.what;
            if (r0 != 1) goto L5;
            BatteryEntry r3 = (BatteryEntry) msg.obj;
            PowerRankView.access$000(this.powerReference.get(), r3);
            return;
        L5:
            if (r0 == 100) goto L8;
            return;
        L8:
            if (PowerRankView.access$100(this.powerReference.get()) == false) goto L10;
            return;
        L10:
            PowerRankView.access$102(this.powerReference.get(), true);
            new StaticAsyncTask(this.powerReference.get()).execute(new Void[0]);
        }
    }

    private static class StaticAsyncTask extends AsyncTask<Void, Void, Boolean> {
        private WeakReference<PowerRankView> wReference;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Boolean doInBackground(Void[] voids) {
            return doInBackground2(voids);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Boolean aBoolean) {
            onPostExecute2(aBoolean);
        }

        StaticAsyncTask(PowerRankView context) {
            this.wReference = new WeakReference(context);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Boolean doInBackground2(Void... voids) {
            PowerRankView.access$200(this.wReference.get());
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Boolean aBoolean) {
            PowerRankView.access$102(this.wReference.get(), false);
            PowerRankView.access$300(this.wReference.get());
        }
    }

    public void doStart() {
    }

    static /* synthetic */ void access$000(PowerRankView r0, BatteryEntry r1) {
        r0.updateView(r1);
    }

    static /* synthetic */ boolean access$100(PowerRankView r0) {
        return r0.mRefreshing;
    }

    static /* synthetic */ boolean access$102(PowerRankView r0, boolean r1) {
        r0.mRefreshing = r1;
        return r1;
    }

    static /* synthetic */ void access$200(PowerRankView r0) {
        r0.refreshStats();
    }

    static /* synthetic */ void access$300(PowerRankView r0) {
        r0.refreshUI();
    }

    static /* synthetic */ Activity access$400(PowerRankView r0) {
        return r0.mContext;
    }

    public PowerRankView(Context context) {
        this(context, null);
    }

    public PowerRankView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PowerRankView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
        this.mRefreshing = false;
        this.mHandler = new PowerHandler(this);
        this.mBatteryInfoReceiver = new AnonymousClass1(this);
        init(context);
    }

    private void init(Context context) {
        View r3 = LayoutInflater.from(context).inflate(R.layout.power_rank_layout, this, true);
        this.mPowerRankTotal = (SecurityItemTextNeutral) r3.findViewById(R.id.power_rank_total);
        this.mPowerRankTop1 = (SecurityProgressItemText) r3.findViewById(R.id.power_rank_top1);
        this.mPowerRankTop2 = (SecurityProgressItemText) r3.findViewById(R.id.power_rank_top2);
        this.mPowerRankTop3 = (SecurityProgressItemText) r3.findViewById(R.id.power_rank_top3);
        this.mContainer = (LinearLayout) r3.findViewById(R.id.power_rank_container);
        this.mPowerRankTotal.setRightLayout(2);
        this.mPowerRankTotal.setBtnText(getResources().getString(R.string.see));
        this.mPowerRankTotal.setBtnClickListener(new AnonymousClass2(this));
    }

    public void doCreate(Activity context, Bundle savedInstanceState) {
        this.mContext = context;
        BatteryStatsHelper r3 = new BatteryStatsHelper(this.mContext, true);
        this.mStatsHelper = r3;
        r3.create(savedInstanceState);
        this.mUm = (UserManager) this.mContext.getSystemService("user");
    }

    public void doResume() {
        BatteryStatsHelper.dropFile(this.mContext, "tmp_bat_history.bin");
        this.mContext.registerReceiver(this.mBatteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.mHandler.removeMessages(100);
        this.mHandler.sendEmptyMessageDelayed(100, 500);
    }

    public void doPause() {
        BatteryEntry.stopRequestQueue();
        this.mContext.unregisterReceiver(this.mBatteryInfoReceiver);
    }

    public void doStop() {
        this.mHandler.removeMessages(100);
    }

    public void onDestroy(boolean isConfigChange) {
        if (isConfigChange == false) goto L5;
        this.mStatsHelper.storeState();
        return;
    }

    private void refreshStats() {
        BatteryStatsHelper r0 = this.mStatsHelper;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clearStats();
        List<UserHandle> r1 = this.mUm.getUserProfiles();
        this.mStatsHelper.refreshStats(0, r1);
        BatteryUsageStats r2 = ((BatteryStatsManager) this.mContext.getSystemService(BatteryStatsManager.class)).getBatteryUsageStats();
        int r3 = r2.getDischargePercentage();
        if (r3 >= 0) goto L8;
        r3 = 0;
    L8:
        BatteryUsageStatsHelper r10 = new BatteryUsageStatsHelper(this.mContext, this.mHandler);
        List<BatteryEntry> r4 = r10.getCoalescedUsageList(true, true);
        this.mTotalUsage = r2.getConsumedPower();
        SparseArray<Map<String, BatteryEntry>> r5 = this.mUsageMap;
        if (r5 == null) goto L11;
        r5.clear();
    L11:
        SparseArray<BatteryEntry> r6 = this.mUsageMapWithUid;
        if (r6 == null) goto L14;
        r6.clear();
    L14:
        this.mUsageMap = new SparseArray(r1.size());
        this.mUsageMapWithUid = new SparseArray();
        Iterator<UserHandle> r7 = r1.iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        this.mUsageMap.put(r7.next().getIdentifier(), new HashMap());
        goto L16
    L18:
        Iterator r8 = new CopyOnWriteArrayList(r4).iterator();
    L20:
        if (r8.hasNext() == false) goto L35;
        BatteryEntry r9 = (BatteryEntry) r8.next();
        r9.mPercent = r10.calculateBatteryPercent(r9.getConsumedPower(), this.mTotalUsage, r3);
        if (r9.isAppEntry() == true) goto L23;
        Map<String, BatteryEntry> r11 = this.mUsageMap.get(this.mContext.getUserId());
        if (r11 == null) goto L20;
        r11.put(r9.getLabel(), r9);
        goto L20
    L23:
        Map<String, BatteryEntry> r12 = this.mUsageMap.get(UserHandle.getUserId(r9.getUid()));
        if (r12 == null) goto L20;
        r12.put(r9.getDefaultPackageName(), r9);
        int r13 = r9.getUid();
        if (r13 != 1000) goto L30;
        r13 = 0;
    L30:
        if (com.bytedanceos.powerusage.BatteryEntry.isSplitedSystemPackage(r9.getDefaultPackageName()) == true) goto L20;
        this.mUsageMapWithUid.put(r13, r9);
        goto L20
    L35:
        BatteryEntry.startRequestQueue();
    }

    private void refreshUI() {
        long r1 = System.currentTimeMillis();
        OLog.e(TAG, "refreshUI start");
        ArrayList r3 = new ArrayList();
        int r5 = this.mUsageMap.size();
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L8;
        int r8 = this.mUsageMap.keyAt(r7);
        if (this.mUsageMap.get(r8) == null) goto L7;
        r3.addAll(this.mUsageMap.get(r8).values());
    L7:
        r7 = r7 + 1;
        goto L3
    L8:
        Collections.sort(r3);
        Iterator r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        BatteryEntry r9 = (BatteryEntry) r6.next();
        if (TextUtils.equals(Integer.toString(r9.getUid()), r9.getLabel()) == false) goto L10;
        r9.getConsumedPower();
        r6.remove();
        goto L10
    L14:
        Iterator r10 = r3.iterator();
        double r11 = 0.0d;
    L15:
        double r12 = 5.0d;
        if (r10.hasNext() == false) goto L24;
        BatteryEntry r13 = (BatteryEntry) r10.next();
        if ((r13.getConsumedPower() * 3600.0d) < 5.0d) goto L15;
        if (((int) (r13.mPercent + 0.5d)) < 1) goto L15;
        r11 = r11 + r13.getConsumedPower();
        goto L15
    L24:
        ArrayList r14 = new ArrayList();
        Iterator r4 = r3.iterator();
        float r15 = 0.0f;
        float r18 = 0.0f;
        int r16 = 0;
        int r17 = 0;
    L26:
        if (r4.hasNext() == false) goto L40;
        BatteryEntry r19 = (BatteryEntry) r4.next();
        if ((r19.getConsumedPower() * 3600.0d) < r12) goto L32;
        double r22 = (r19.getConsumedPower() * 100.0d) / r11;
        if (((int) (r19.mPercent + 0.5d)) < 1) goto L32;
        if (r14.size() >= 3) goto L37;
        r14.add(r19);
    L37:
        if (r19.isAppEntry() == false) goto L39;
        r17 = r17 + 1;
        r18 = (float) (((double) r18) + r22);
        goto L32
    L39:
        r16 = r16 + 1;
        r15 = (float) (((double) r15) + r22);
    L32:
        r12 = 5.0d;
        goto L26
    L40:
        float r20 = r18;
        int r21 = r14.size();
        resetView();
        if (r21 <= 0) goto L61;
        setVisibility(0);
        this.mContainer.setVisibility(0);
        Iterator r23 = r14.iterator();
        int r110 = 0;
    L44:
        if (r23.hasNext() == false) goto L52;
        BatteryEntry r111 = (BatteryEntry) r23.next();
        int r112 = r110 + 1;
        SecurityProgressItemText r113 = getViewByIndex(r110);
        if (r113 == null) goto L52;
        double r114 = (r111.getConsumedPower() * 100.0d) / r11;
        Iterator r24 = r23;
        UserHandle r115 = new UserHandle(UserHandle.getUserId(r111.getUid()));
        double r25 = r11;
        Drawable r26 = this.mUm.getBadgedIconForUser(r111.getIcon(), r115);
        this.mUm.getBadgedLabelForUser(r111.getLabel(), r115);
        r111.getConsumedPower();
        this.mStatsHelper.getMaxPower();
        r113.setTag(Integer.valueOf(r111.getUid()));
        r113.setTitle(r111.getLabel());
        r113.setIcon(r26);
        r113.setMaxProgress(100);
        r113.setCurrentProgress(r114);
        r113.setVisibility(0);
        r113.setBackgroundStyle(3);
        r113.showSpliteLine(true);
        if (r112 != r21) goto L51;
        r113.setBackgroundStyle(4);
        r113.showSpliteLine(false);
    L51:
        r110 = r112;
        r23 = r24;
        r11 = r25;
    L52:
        int r116 = (int) (((double) r15) + 0.5d);
        int r27 = 100 - r116;
        if (r16 != 0) goto L56;
        if (r17 != 0) goto L56;
        r27 = 0;
        int r28 = 100;
        r116 = 0;
    L57:
        if (r116 <= r28) goto L59;
        r27 = (int) (((double) r20) + 0.5d);
        r116 = 100 - r27;
    L59:
        this.mPowerRankTotal.setSummary(String.format(getResources().getString(R.string.power_rank_status), new Object[]{r27 + "%", r116 + "%"}));
        OLog.e(TAG, "refreshUI execution time: " + (System.currentTimeMillis() - r1) + " ms");
        return;
    L56:
        r28 = 100;
        goto L57
    L61:
        setVisibility(8);
    }

    private void updateView(BatteryEntry entry) {
        if (entry != null) goto L5;
        return;
    L5:
        if (this.mPowerRankTop1.getTag() == null) goto L10;
        if (this.mPowerRankTop1.getTag().equals(Integer.valueOf(entry.getUid())) == false) goto L10;
        SecurityProgressItemText r2 = this.mPowerRankTop1;
    L20:
        if (r2 == null) goto L23;
        r2.setTitle(entry.getLabel());
        r2.setIcon(entry.getIcon());
        return;
    L23:
        return;
    L10:
        if (this.mPowerRankTop2.getTag() == null) goto L15;
        if (this.mPowerRankTop2.getTag().equals(Integer.valueOf(entry.getUid())) == false) goto L15;
        r2 = this.mPowerRankTop2;
    L15:
        if (this.mPowerRankTop3.getTag() != null) goto L17;
    L19:
        r2 = null;
        goto L20
    L17:
        if (this.mPowerRankTop3.getTag().equals(Integer.valueOf(entry.getUid())) == false) goto L19;
        r2 = this.mPowerRankTop3;
        goto L20
    }

    private void resetView() {
        this.mContainer.setVisibility(8);
        this.mPowerRankTop1.setVisibility(8);
        this.mPowerRankTop1.setTag(null);
        this.mPowerRankTop2.setVisibility(8);
        this.mPowerRankTop2.setTag(null);
        this.mPowerRankTop3.setVisibility(8);
        this.mPowerRankTop3.setTag(null);
    }

    private SecurityProgressItemText getViewByIndex(int index) {
        if (index != 0) goto L6;
        return this.mPowerRankTop1;
    L6:
        if (index != 1) goto L10;
        return this.mPowerRankTop2;
    L10:
        if (index == 2) goto L12;
        return null;
    L12:
        return this.mPowerRankTop3;
    }
}
