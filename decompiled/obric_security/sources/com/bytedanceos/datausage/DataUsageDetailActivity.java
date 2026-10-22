package com.bytedanceos.datausage;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkStats;
import android.net.NetworkStatsHistory;
import android.net.NetworkTemplate;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.INetworkManagementService;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.NtpTrustedTime;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.internal.util.Preconditions;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.widget.DataUsageCycleView;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.bytedanceos.utils.Constants;
import com.bytedanceos.utils.NetworkPolicyEditor;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.tab.OTabLayout;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageDetailActivity extends BaseActivity {
    private static final String ARG_SYSTEM_APP_UNFOLDED = "arg_system_app_unfolded";
    public static final String INTENT_EXTRA_CHECKED = "checked";
    private static final String INTENT_EXTRA_CYCLE_INDEX = "cycle_index";
    public static final String INTENT_EXTRA_LIMIT = "limit";
    private static final String LAST_SUBSCRIBER_PROP = "persist.radio.last.subscriber";
    private static final int LOADER_CHART_DATA = 2;
    private static final int LOADER_SUMMARY = 3;
    private static final boolean LOGD = false;
    private static final int POWER_USAGE_CYCLE_MONTH = 2;
    private static final int POWER_USAGE_CYCLE_TODAY = 0;
    private static final int POWER_USAGE_CYCLE_WEEK = 1;
    private static final int REQUEST_LIMIT = 2;
    private static final int SUB1 = 0;
    public static final String SUBSCRIPTION_KEY = "slot";
    private static final String TAG = "DataUsage";
    private static final StringBuilder sBuilder = null;
    private static final Formatter sFormatter = null;
    private LinearLayout headView;
    private DataUsageAdapter mAdapter;
    private ChartData mChartData;
    private final LoaderManager.LoaderCallbacks<ChartData> mChartDataCallbacks;
    private int mCurrentIndex;
    private int mCurrentSlot;
    private View.OnClickListener mDataLimitChangeListener;
    private String[] mDataUsageCycleTime;
    private int[] mDataUsageCycleTimeRes;
    private DataUsageCycleView mDataUsageTotally;
    private boolean mHidenListView;
    private boolean mHidenSetting;
    private int mInsetSide;
    private IntentFilter mIntentFilter;
    private boolean mIsSystemAppUnfolded;
    private OCardListItem mLimitText;
    private OListView mListView;
    private INetworkManagementService mNetworkService;
    private NetworkPolicy mPolicy;
    private NetworkPolicyEditor mPolicyEditor;
    private NetworkPolicyManager mPolicyManager;
    private final BroadcastReceiver mReceiver;
    private INetworkStatsService mStatsService;
    private INetworkStatsSession mStatsSession;
    private final LoaderManager.LoaderCallbacks<NetworkStats> mSummaryCallbacks;
    private View mSystemAppFooter;
    private int mSystemFoldedAppCount;
    private TelephonyManager mTelephonyMgr;
    private NetworkTemplate mTemplate;
    private long mTotalBytesInMonth;
    private UidDetailProvider mUidDetailProvider;
    private View.OnClickListener mWarningCheckChangeListener;
    private OCardListItem mWarningSwitch;
    private CompoundButton.OnCheckedChangeListener mWarningSwitchListener;

    public static class AppItem implements Comparable<AppItem>, Parcelable {
        public static final Parcelable.Creator<AppItem> CREATOR = null;
        public final int key;
        public String packageName;
        public boolean restricted;
        public long total;
        public SparseBooleanArray uids;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(AppItem another) {
            return compareTo2(another);
        }

        public AppItem(int key) {
            this.uids = new SparseBooleanArray();
            this.key = key;
        }

        public AppItem(Parcel parcel) {
            this.uids = new SparseBooleanArray();
            this.key = parcel.readInt();
            this.uids = parcel.readSparseBooleanArray();
            this.total = parcel.readLong();
            this.packageName = parcel.readString();
        }

        public void addUid(int uid) {
            this.uids.put(uid, true);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.key);
            dest.writeSparseBooleanArray(this.uids);
            dest.writeLong(this.total);
            dest.writeString(this.packageName);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(AppItem another) {
            return Long.compare(another.total, this.total);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public class DataUsageAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<AppItem> mItems;
        private long mLargest;
        private final UidDetailProvider mProvider;
        final /* synthetic */ DataUsageDetailActivity this$0;

        public DataUsageAdapter(final DataUsageDetailActivity this$0, Context context, UidDetailProvider provider, int insetSide) {
            this.this$0 = this$0;
            this.mItems = Lists.newArrayList();
            this.mContext = context;
            this.mProvider = (UidDetailProvider) Preconditions.checkNotNull(provider);
        }

        public void bindStats(NetworkStats stats, int[] restrictedUids) {
            this.mItems.clear();
            IPackageManager r3 = AppGlobals.getPackageManager();
            int r4 = ActivityManager.getCurrentUser();
            SparseArray r5 = new SparseArray();
            if (stats == null) goto L5;
            int r7 = stats.size();
        L6:
            NetworkStats.Entry r8 = null;
            int r9 = 0;
        L7:
            if (r9 >= r7) goto L30;
            r8 = stats.getValues(r9, r8);
            int r10 = r8.uid;
            int r12 = -4;
            if (UserHandle.isApp(r10) == true) goto L11;
            if (r10 != (-4)) goto L22;
        L25:
            r12 = r10;
        L26:
            AppItem r11 = (AppItem) r5.get(r12);
            if (r11 != null) goto L29;
            r11 = new AppItem(r12);
            this.mItems.add(r11);
            r5.put(r11.key, r11);
        L29:
            r11.addUid(r10);
            r11.total += r8.rxBytes + r8.txBytes;
            r9 = r9 + 1;
            r7 = r7;
            goto L7
        L22:
            if (r10 == (-5)) goto L25;
            r12 = 1000;
            goto L26
        L11:
            if (UserHandle.getUserId(r10) == r4) goto L25;
            if (r4 == 0) goto L15;
        L19:
            r12 = UidDetailProvider.buildKeyForUser(UserHandle.getUserId(r10));
            goto L26
        L15:
            if (UserHandle.getUserId(r10) != 10) goto L19;
            if (DatausageUtils.doppelgangerAppExist(r3, r10) == true) goto L25;
        L30:
            int r1 = restrictedUids.length;
            int r6 = 0;
        L31:
            if (r6 >= r1) goto L40;
            int r13 = restrictedUids[r6];
            if (UserHandle.getUserId(r13) != r4) goto L39;
            AppItem r14 = (AppItem) r5.get(r13);
            if (r14 != null) goto L38;
            r14 = new AppItem(r13);
            r14.total = -1;
            this.mItems.add(r14);
            r5.put(r14.key, r14);
        L38:
            r14.restricted = true;
        L39:
            r6 = r6 + 1;
            goto L31
        L40:
            int r2 = WorkAppUtil.getWorkProfileUserId(this.mContext);
            if (r2 == (-1)) goto L51;
            Iterator<ApplicationInfo> r15 = WorkAppUtil.getWorkAppsByUserId(this.mContext, r2).iterator();
        L44:
            if (r15.hasNext() == false) goto L48;
            ApplicationInfo r16 = r15.next();
            int r17 = r16.uid;
            if (((AppItem) r5.get(r17)) != null) goto L44;
            AppItem r18 = new AppItem(r17);
            this.mItems.add(r18);
            r5.put(r18.key, r18);
            r18.packageName = r16.packageName;
            goto L44
        L48:
            int r19 = UidDetailProvider.buildKeyForUser(r2);
            if (((AppItem) r5.get(r19)) != null) goto L51;
            AppItem r20 = new AppItem(r19);
            this.mItems.add(0, r20);
            r5.put(r20.key, r20);
        L51:
            List r21 = DataUsageDetailActivity.access$1600(this.mItems, this.mContext);
            long r22 = 0;
            if (r21 != null) goto L54;
        L59:
            filterApplist();
            Collections.sort(this.mItems);
            int r23 = 0;
        L61:
            if (r23 >= this.mItems.size()) goto L66;
            if (UidDetailProvider.isKeyForUser(this.mItems.get(r23).key) == true) goto L64;
            r23 = r23 + 1;
            goto L61
        L64:
            int r24 = 0;
            this.mItems.add(0, this.mItems.remove(r23));
        L68:
            if (this.mItems.size() <= 0) goto L70;
            r22 = this.mItems.get(r24).total;
        L70:
            this.mLargest = r22;
            notifyDataSetChanged();
            return;
        L66:
            r24 = 0;
            goto L68
        L54:
            if (r21.size() <= 0) goto L59;
            Iterator r25 = r21.iterator();
        L57:
            if (r25.hasNext() == false) goto L59;
            AppItem r26 = new AppItem(((Integer) r25.next()).intValue());
            r26.total = 0;
            this.mItems.add(r26);
            goto L57
        L5:
            r7 = 0;
            goto L6
        }

        private boolean isSystemApp(int uid) {
            if (uid != (-5)) goto L5;
        L33:
            return true;
        L5:
            if (uid == (-4)) goto L33;
            if (uid == 1000) goto L33;
            PackageManager r0 = this.mContext.getPackageManager();
            if (r0 != null) goto L11;
            return false;
        L11:
            String[] r1 = r0.getPackagesForUid(uid);
            if (r1 != null) goto L14;
        L16:
            String r2 = null;
        L34:
        L30:
            e = move-exception;
            e.printStackTrace();
        L32:
            return false;
        L18:
            if (this.mProvider.isSpecialSystemApp(r2) == false) goto L20;
            return true;
        L20:
            ApplicationInfo r7 = AppGlobals.getPackageManager().getApplicationInfo(r2, 0, UserHandle.getUserId(uid));     // Catch: RemoteException -> L30
            if (r7 == null) goto L29;
            if ((r7.flags & 1) == 0) goto L25;
        L26:
            return true;
        L25:
            if (UserHandle.isApp(r7.uid) == true) goto L32;
        L29:
            return !DataUsageDetailActivity.access$700(this.this$0);
        L14:
            if (r1.length <= 0) goto L16;
            r2 = r1[0];
            goto L34
        }

        private void filterApplist() {
            OLog.d(DataUsageDetailActivity.TAG, "filterApplist...");
            DataUsageDetailActivity.access$1402(this.this$0, 0);
            ArrayList<AppItem> r0 = Lists.newArrayList();
            Iterator<AppItem> r3 = this.mItems.iterator();
            long r4 = 0;
            AppItem r6 = null;
        L4:
            if (r3.hasNext() == false) goto L17;
            AppItem r7 = r3.next();
            if (UidDetailProvider.isKeyForUser(r7.key) == true) goto L7;
            if (DataUsageDetailActivity.access$700(this.this$0) == true) goto L11;
            if (isSystemApp(r7.key) == false) goto L15;
            DataUsageDetailActivity.access$1408(this.this$0);
            r4 = r4 + r7.total;
            goto L4
        L15:
            r0.add(r7);
            goto L4
        L11:
            if (isSystemApp(r7.key) == false) goto L4;
            r0.add(r7);
            goto L4
        L7:
            r6 = r7;
            goto L4
        L17:
            if (r6 == null) goto L19;
            r0.add(0, r6);
        L19:
            this.mItems = r0;
            if (DataUsageDetailActivity.access$700(this.this$0) == false) goto L22;
        L29:
            OLog.d(DataUsageDetailActivity.TAG, "mItems size:" + this.mItems.size() + "mSystemFoldedAppCount " + DataUsageDetailActivity.access$1400(this.this$0));
            return;
        L22:
            if (DataUsageDetailActivity.access$1700(this.this$0) == false) goto L29;
            if (DataUsageDetailActivity.access$1800(this.this$0) == null) goto L29;
            OCardListItem r1 = (OCardListItem) DataUsageDetailActivity.access$1800(this.this$0).findViewById(R.id.system_app);
            if (r1 == null) goto L28;
            ByteUnitPair r5 = ByteConverter.convert(r4, "B", 1024);
            r1.getEndDetail().setText(r5.getValue() + r5.getUnit());
        L28:
            r1.setCardPosition(0);
            goto L29
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mItems.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            return this.mItems.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return this.mItems.get(position).key;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L5;
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_data_usage_item, parent, false);
        L5:
            Context r9 = parent.getContext();
            OCardListItem r1 = (OCardListItem) convertView.findViewById(R.id.app_info);
            if (this.mItems.size() != 1) goto L9;
            r1.setCardPosition(0);
        L14:
            r1.setCardType(1);
            AppItem r7 = this.mItems.get(position);
            UidDetailTask.bindView(this.mProvider, r7, convertView);
            if (r1 != null) goto L17;
        L31:
            return convertView;
        L17:
            if (r7.restricted == false) goto L22;
            if (r7.total > 0) goto L22;
            r1.setEndDetailText(r9.getResources().getString(R.string.data_usage_app_restricted));
        L26:
            if (DataUsageDetailActivity.access$700(this.this$0) == true) goto L31;
            if (DataUsageDetailActivity.access$1400(this.this$0) != 0) goto L31;
            this.mItems.size();
        L22:
            if (r7.total > 1) goto L24;
            ByteUnitPair r8 = ByteConverter.convert(r7.total, "B", 1024);
            r1.setEndDetailText(r8.getValue() + r8.getUnit());
            goto L26
        L24:
            ByteUnitPair r10 = ByteConverter.convert(r7.total, "B", 1024);
            r1.setEndDetailText(r10.getValue() + r10.getUnit());
            goto L26
        L9:
            if (position != (this.mItems.size() - 1)) goto L11;
            r1.setCardPosition(3);
            goto L14
        L11:
            if (position != 0) goto L13;
            r1.setCardPosition(1);
            goto L14
        L13:
            r1.setCardPosition(2);
            goto L14
        }
    }

    private static class UidDetailTask extends AsyncTask<Void, Void, UidDetail> {
        private final AppItem mItem;
        private final UidDetailProvider mProvider;
        private final View mTarget;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ UidDetail doInBackground(Void[] params) {
            return doInBackground2(params);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(UidDetail result) {
            onPostExecute2(result);
        }

        private UidDetailTask(UidDetailProvider provider, AppItem item, View target) {
            this.mProvider = (UidDetailProvider) Preconditions.checkNotNull(provider);
            this.mItem = (AppItem) Preconditions.checkNotNull(item);
            this.mTarget = (View) Preconditions.checkNotNull(target);
        }

        public static void bindView(UidDetailProvider provider, AppItem item, View target) {
            UidDetailTask r0 = (UidDetailTask) target.getTag();
            if (r0 == null) goto L5;
            r0.cancel(false);
        L5:
            UidDetail r1 = provider.getUidDetail(item.key, false);
            if (r1 == null) goto L8;
            bindView(r1, target);
            return;
        L8:
            target.setTag(new UidDetailTask(provider, item, target).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]));
        }

        private static void bindView(UidDetail detail, View target) {
            OCardListItem r2 = (OCardListItem) target.findViewById(R.id.app_info);
            if (r2 != null) goto L5;
            return;
        L5:
            if (detail == null) goto L7;
            r2.setAppIcon(detail.icon);
            r2.setTitle(detail.label);
            r2.showIcon(true);
            r2.showCustomEnd(true);
            return;
        L7:
            r2.setAppIcon(null);
            r2.setTitle("");
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            bindView(null, this.mTarget);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected UidDetail doInBackground2(Void... params) {
            return this.mProvider.getUidDetail(this.mItem.key, true);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(UidDetail result) {
            bindView(result, this.mTarget);
        }
    }

    public DataUsageDetailActivity() {
        this.mSystemFoldedAppCount = 0;
        this.mInsetSide = 0;
        this.mDataUsageTotally = null;
        this.mIsSystemAppUnfolded = false;
        this.mIntentFilter = new IntentFilter(DataUsageLimitActivity.ACTION_DATA_USAGE_LIMIT_CHANGED);
        this.mReceiver = new AnonymousClass1(this);
        this.mDataLimitChangeListener = new AnonymousClass4(this);
        this.mWarningSwitchListener = new AnonymousClass5(this);
        this.mWarningCheckChangeListener = new AnonymousClass6(this);
        this.mChartDataCallbacks = new AnonymousClass8(this);
        this.mSummaryCallbacks = new AnonymousClass9(this);
    }

    static /* synthetic */ int access$000(DataUsageDetailActivity r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$002(DataUsageDetailActivity r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ void access$100(DataUsageDetailActivity r0) {
        r0.updateDetailData();
    }

    static /* synthetic */ ChartData access$1002(DataUsageDetailActivity r0, ChartData r1) {
        r0.mChartData = r1;
        return r1;
    }

    static /* synthetic */ NetworkPolicyManager access$1100(DataUsageDetailActivity r0) {
        return r0.mPolicyManager;
    }

    static /* synthetic */ DataUsageAdapter access$1200(DataUsageDetailActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ DataUsageCycleView access$1300(DataUsageDetailActivity r0) {
        return r0.mDataUsageTotally;
    }

    static /* synthetic */ int access$1400(DataUsageDetailActivity r0) {
        return r0.mSystemFoldedAppCount;
    }

    static /* synthetic */ int access$1402(DataUsageDetailActivity r0, int r1) {
        r0.mSystemFoldedAppCount = r1;
        return r1;
    }

    static /* synthetic */ int access$1408(DataUsageDetailActivity r2) {
        int r0 = r2.mSystemFoldedAppCount;
        r2.mSystemFoldedAppCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ void access$1500(DataUsageDetailActivity r0) {
        r0.updateFooterView();
    }

    static /* synthetic */ List access$1600(ArrayList r0, Context r1) {
        return getNoDataUid(r0, r1);
    }

    static /* synthetic */ boolean access$1700(DataUsageDetailActivity r0) {
        return r0.mHidenSetting;
    }

    static /* synthetic */ View access$1800(DataUsageDetailActivity r0) {
        return r0.mSystemAppFooter;
    }

    static /* synthetic */ INetworkStatsService access$200(DataUsageDetailActivity r0) {
        return r0.mStatsService;
    }

    static /* synthetic */ void access$300(DataUsageDetailActivity r0) {
        r0.updateBody();
    }

    static /* synthetic */ NetworkPolicy access$400(DataUsageDetailActivity r0) {
        return r0.mPolicy;
    }

    static /* synthetic */ int access$500(DataUsageDetailActivity r0) {
        return r0.mCurrentSlot;
    }

    static /* synthetic */ void access$600(DataUsageDetailActivity r0, boolean r1) {
        r0.setWarningDialogEnabled(r1);
    }

    static /* synthetic */ boolean access$700(DataUsageDetailActivity r0) {
        return r0.mIsSystemAppUnfolded;
    }

    static /* synthetic */ OCardListItem access$800(DataUsageDetailActivity r0) {
        return r0.mWarningSwitch;
    }

    static /* synthetic */ INetworkStatsSession access$900(DataUsageDetailActivity r0) {
        return r0.mStatsSession;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_usage_detail_activity);
        this.mNetworkService = INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        this.mStatsService = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mPolicyManager = NetworkPolicyManager.from(this);
        this.mTelephonyMgr = (TelephonyManager) getSystemService("phone");
        NetworkPolicyEditor r3 = new NetworkPolicyEditor(this.mPolicyManager);
        this.mPolicyEditor = r3;
        r3.read();
        getWindow();
    L7:
        OLog.w(TAG, "No bandwidth control; leaving");
        finish();
    L35:
        this.mStatsSession = this.mStatsService.openSession();     // Catch: RemoteException -> L32
        this.mDataUsageCycleTime = getResources().getStringArray(R.array.data_usage_cycle);
        TypedArray r1 = getResources().obtainTypedArray(R.array.data_usage_cycle);
        this.mDataUsageCycleTimeRes = new int[r1.length()];
        int r4 = 0;
    L11:
        if (r4 >= r1.length()) goto L13;
        this.mDataUsageCycleTimeRes[r4] = r1.getResourceId(r4, -1);
        r4 = r4 + 1;
        goto L11
    L13:
        Intent r5 = getIntent();
        if (r5.hasExtra("slot") == false) goto L16;
        int r6 = r5.getIntExtra("slot", 0);
        this.mCurrentSlot = r6;
        DataUsageActivity.PAGE_SLOT = r6;
    L17:
        this.mHidenSetting = r5.getBooleanExtra("hidden_setting", false);
        this.mHidenListView = r5.getBooleanExtra("hidden_list", true);
        OLog.i(TAG, "onCreate(), slot=" + this.mCurrentSlot);
        this.mIsSystemAppUnfolded = getIntent().getBooleanExtra(ARG_SYSTEM_APP_UNFOLDED, false);
        OLog.d(TAG, "onCreate mIsSystemAppUnfolded " + this.mIsSystemAppUnfolded);
        String r7 = getActiveSubscriberId();
        OLog.d(TAG, "onCreate_getActiveSubscriberId:" + r7);
        if (r7 == null) goto L22;
        NetworkTemplate r2 = NetworkTemplate.buildTemplateMobileAll(r7);
        this.mTemplate = r2;
        NetworkPolicy r8 = this.mPolicyEditor.getPolicy(r2);
        this.mPolicy = r8;
        if (r8 != null) goto L22;
        Time r9 = new Time();
        r9.setToNow();
        NetworkPolicy r10 = new NetworkPolicy(this.mTemplate, r9.monthDay, r9.timezone, -1, -1, -1, -1, true, true);
        this.mPolicy = r10;
        this.mPolicyEditor.addPolicy(r10);
    L22:
        registerReceiver(this.mReceiver, this.mIntentFilter);
        r1.recycle();
        initView();
        if (this.mPolicy != null) goto L27;
        OCardListItem r11 = this.mLimitText;
        if (r11 == null) goto L27;
        r11.setEnabled(false);
        this.mWarningSwitch.setEnabled(false);
    L30:
        updateViewWidth(R.id.data_usage_header_scrollview);
        updateViewWidth(this.mListView);
        return;
    L27:
        OCardListItem r12 = this.mLimitText;
        if (r12 == null) goto L30;
        r12.setEnabled(true);
        this.mWarningSwitch.setEnabled(true);
        goto L30
    L16:
        int r13 = bytedanceos.util.MultiSimAdapter.getDefaultDataSlot();
        this.mCurrentSlot = r13;
        DataUsageActivity.PAGE_SLOT = r13;
    L32:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (this.mNetworkService.isBandwidthControlEnabled() == true) goto L35;
        OLog.w(TAG, "No bandwidth control; leaving");     // Catch: RemoteException -> L7
        finish();     // Catch: RemoteException -> L7
        goto L35
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        DataUsageActivity.PAGE_SLOT = this.mCurrentSlot;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        DataUsageActivity.PAGE_SLOT = -1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mReceiver);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void initView() {
        initTitleBar(false, false);
        this.mTitle.bringToFront();
        this.mTitle.requestLayout();
        this.mUidDetailProvider = new UidDetailProvider(this);
        this.mListView = (OListView) findViewById(R.id.data_usage_sort_list);
        if (this.mHidenListView == false) goto L14;
        LinearLayout r1 = (LinearLayout) findViewById(R.id.data_usage_header_view);
        this.headView = r1;
        if (r1 == null) goto L10;
        this.mWarningSwitch = (OCardListItem) r1.findViewById(R.id.data_usage_alarm_stub);
        OCardListItem r2 = (OCardListItem) this.headView.findViewById(R.id.data_usage_limit_stub);
        this.mLimitText = r2;
        OCardListItem r5 = this.mWarningSwitch;
        if (r5 == null) goto L10;
        if (r2 == null) goto L10;
        r5.setOnContentClickListener(this.mWarningCheckChangeListener);
        this.mWarningSwitch.setCardPosition(1);
        this.mWarningSwitch.showCustomEnd(true);
        this.mWarningSwitch.showSubTitle(true);
        this.mWarningSwitch.getEndSwitch().setOnCheckedChangeListener(this.mWarningSwitchListener);
        this.mLimitText.setOnContentClickListener(this.mDataLimitChangeListener);
        this.mLimitText.setCardPosition(3);
        this.mLimitText.setDefaultTailIcon(0);
        this.mLimitText.showTailIcon(true);
        this.mLimitText.showSubTitle(true);
    L10:
        OListView r3 = this.mListView;
        if (r3 == null) goto L27;
        r3.setVisibility(8);
    L27:
        OListView r4 = this.mListView;
        if (r4 != null) goto L30;
    L32:
        boolean r6 = false;
    L33:
        if (r6 == false) goto L35;
        this.mInsetSide = getResources().getDimensionPixelOffset(Utils.getResouceId("android", "preference_fragment_padding_side", "dimen", 17106073));
    L36:
        this.mAdapter = new DataUsageAdapter(this, this, this.mUidDetailProvider, this.mInsetSide);
        OListView r0 = this.mListView;
        if (r0 != null) goto L39;
        return;
    L39:
        if (this.mHidenSetting == true) goto L41;
    L44:
        this.mListView.setAdapter(this.mAdapter);
        return;
    L41:
        if (this.mIsSystemAppUnfolded == true) goto L43;
        r0.addHeaderView(this.headView, r0, true);
        goto L44
    L43:
        r0.addHeaderView(initListTransparentHeaderView());
        this.mListView.setEmptyView(findViewById(R.id.empty_view));
        goto L44
    L35:
        this.mInsetSide = 0;
        goto L36
    L30:
        if (r4.getScrollBarStyle() != 33554432) goto L32;
        r6 = true;
        goto L33
    L14:
        if (this.mHidenSetting == false) goto L27;
        View r7 = findViewById(R.id.data_usage_header_scrollview);
        if (r7 == null) goto L18;
        r7.setVisibility(8);
    L18:
        int r8 = getIntent().getIntExtra(INTENT_EXTRA_CYCLE_INDEX, 0);
        if (r8 >= 0) goto L21;
    L23:
        r8 = 0;
    L24:
        this.mCurrentIndex = r8;
        LinearLayout r9 = (LinearLayout) getLayoutInflater().inflate(R.layout.data_usage_header_otab, null, false);
        this.headView = r9;
        if (r9 == null) goto L27;
        String[] r10 = new String[3];
        getResources().getString(R.string.power_usage_cycle_today);
        getResources().getString(R.string.power_usage_cycle_week);
        getResources().getString(R.string.power_usage_cycle_month);
        ((OTabLayout) this.headView.findViewById(R.id.cycle_view)).addOnTabSelectedListener(new AnonymousClass2(this));
        goto L27
    L21:
        if (r8 > 2) goto L23;
        goto L23
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedanceos.datausage.DataUsageDetailActivity$3] */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        updateBody();
        new AnonymousClass3(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void updateLimitSubtitle() {
        if (this.mPolicy != null) goto L5;
        return;
    L5:
        if (this.mHidenSetting == false) goto L8;
        return;
    L8:
        if (DataUsageLimitActivity.getCurrentLimitUnit(getApplicationContext(), this.mCurrentSlot) != 1) goto L10;
        long r2 = 1073741824;
        String r0 = " GB";
    L11:
        ByteUnitPair r4 = ByteConverter.convert(this.mTotalBytesInMonth, "B", 1024);
        this.mLimitText.setEndDetailText(r4.getValue() + r4.getUnit() + " / " + (this.mPolicy.warningBytes / r2) + r0);
        this.mLimitText.showCustomEnd(true);
        return;
    L10:
        r2 = 1048576;
        r0 = " MB";
        goto L11
    }

    private void updateLimitView() {
        NetworkPolicy r0 = this.mPolicy;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHidenListView == true) goto L7;
        return;
    L7:
        if (r0.limitBytes == (-1)) goto L10;
        setPolicyLimitBytes(-1);
    L10:
        if (this.mPolicy.warningBytes == (-1)) goto L12;
        updateLimitSubtitle();
    L13:
        this.mWarningSwitch.getEndSwitch().setOnCheckedChangeListener(null);
        this.mWarningSwitch.getEndSwitch().setChecked(showWarningDialog());
        this.mWarningSwitch.getEndSwitch().setOnCheckedChangeListener(this.mWarningSwitchListener);
        return;
    L12:
        this.mLimitText.setEndDetailText(getString(R.string.data_usage_limit_unset));
        this.mLimitText.showCustomEnd(true);
        setPolicyWarningBytes(-1);
        goto L13
    }

    private boolean showWarningDialog() {
        if (this.mCurrentSlot != 0) goto L10;
        if (Settings.Global.getInt(getContentResolver(), Constants.DATA_USAGE_WARNING, 0) != 1) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (Settings.Global.getInt(getContentResolver(), Constants.DATA_USAGE_WARNING_SUB2, 0) != 1) goto L13;
        return true;
    L13:
        return false;
    }

    private void setWarningDialogEnabled(boolean r2) {
        if (this.mCurrentSlot != 0) goto L5;
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_WARNING, r2 ? 1 : 0);
        return;
    L5:
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_WARNING_SUB2, r2 ? 1 : 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) goto L6;
        return;
    L6:
        if (resultCode != (-1)) goto L10;
        if (data == null) goto L11;
        long r3 = data.getLongExtra(INTENT_EXTRA_LIMIT, -1);
        setPolicyWarningBytes(r3);
        this.mPolicy.warningBytes = r3;
        updateLimitView();
        return;
    L11:
        return;
    }

    private void updateFooterView() {
        if (this.mIsSystemAppUnfolded == true) goto L8;
        this.mListView.removeFooterView(getSystemAppFooter());
        if (this.mSystemFoldedAppCount <= 0) goto L9;
        this.mListView.addFooterView(getSystemAppFooter());
        return;
    L9:
        return;
    }

    private View getSystemAppFooter() {
        if (this.mSystemAppFooter != null) goto L10;
        View r0 = LayoutInflater.from(this).inflate(R.layout.datausage_list_footer_view, null);
        this.mSystemAppFooter = r0;
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.system_app);
        if (r1 == null) goto L7;
        r1.setEndDetailText("0 B");
        r1.showCustomEnd(true);
        r1.setOnContentClickListener(new AnonymousClass7(this));
        goto L10
    L7:
        return this.mSystemAppFooter;
    L10:
        return this.mSystemAppFooter;
    }

    private View initListTransparentHeaderView() {
        ImageView r0 = new ImageView(this);
        r0.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin)));
        r0.setBackgroundColor(getResources().getColor(R.color.transparent));
        return r0;
    }

    private void updateBody() {
        String r0 = getActiveSubscriberId();
        if (r0 == null) goto L6;
        this.mTemplate = NetworkTemplate.buildTemplateMobileAll(r0);
        getLoaderManager().restartLoader(2, ChartDataLoader.buildArgs(this.mTemplate, null), this.mChartDataCallbacks);
        return;
    }

    private void updateDetailData() {
        if (this.mCurrentIndex != (-1)) goto L5;
        this.mCurrentIndex = 1;
    L5:
        NtpTrustedTime r1 = NtpTrustedTime.getInstance(this);
        if (r1.hasCache() == false) goto L8;
        long r2 = r1.currentTimeMillis();
    L9:
        Calendar r4 = Calendar.getInstance();
        r4.set(11, 0);
        r4.set(12, 0);
        r4.set(13, 0);
        int r5 = this.mCurrentIndex;
        if (r5 != 2) goto L12;
        r4.set(5, 1);
    L14:
        long r6 = r4.getTimeInMillis();
        getLoaderManager().restartLoader(3, SummaryForAllUidLoader.buildArgs(this.mTemplate, r6, r2), this.mSummaryCallbacks);
        ChartData r7 = this.mChartData;
        if (r7 != null) goto L17;
    L19:
        Calendar r8 = Calendar.getInstance();
        r8.set(11, 0);
        r8.set(12, 0);
        r8.set(13, 0);
        r8.set(5, 1);
        long r9 = r8.getTimeInMillis();
        ChartData r3 = this.mChartData;
        if (r3 != null) goto L22;
    L24:
        NetworkStatsHistory.Entry r10 = null;
    L25:
        if (r10 == null) goto L27;
        long r11 = r10.rxBytes + r10.txBytes;
    L28:
        this.mTotalBytesInMonth = r11;
        updateLimitView();
        return;
    L27:
        r11 = 0;
        goto L28
    L22:
        if (r3.network == null) goto L24;
        r10 = this.mChartData.network.getValues(r9, r2, r2, null);
        goto L25
    L17:
        if (r7.network == null) goto L19;
        this.mChartData.network.getValues(r6, r2, r2, null);
        goto L19
    L12:
        if (r5 != 1) goto L14;
        r4.setFirstDayOfWeek(2);
        r4.get(7);
        r4.set(7, 2);
        goto L14
    L8:
        r2 = System.currentTimeMillis();
        goto L9
    }

    public void setPolicyLimitBytes(long limitBytes) {
        this.mPolicyEditor.setPolicyLimitBytes(this.mTemplate, limitBytes);
    }

    public void setPolicyWarningBytes(long limitBytes) {
        this.mPolicyEditor.setPolicyWarningBytes(this.mTemplate, limitBytes);
    }

    private String getActiveSubscriberId() {
        int r0 = bytedanceos.util.MultiSimAdapter.slot2Sub(this.mCurrentSlot);
        if (r0 != (-1)) goto L5;
        OLog.e(TAG, "MultiSimAdapter.slot2Sub - subId invalid; currentSlot=" + this.mCurrentSlot);
        r0 = this.mTelephonyMgr.getSubscriptionId();
    L5:
        String r1 = this.mTelephonyMgr.createForSubscriptionId(r0).getSubscriberId();
        if (r1 == null) goto L9;
        return r1;
    L9:
        return getLastSubscriberId();
    }

    private String getLastSubscriberId() {
        return TelephonyManager.getTelephonyProperty(this.mCurrentSlot, LAST_SUBSCRIBER_PROP, null);
    }

    static {
        StringBuilder r0 = new StringBuilder(50);
        sBuilder = r0;
        sFormatter = new Formatter(r0, Locale.getDefault());
    }

    public static String formatDateRange(Context context, long start, long end) {
        StringBuilder r0 = sBuilder;
        monitor-enter(r0);
        r0.setLength(0);     // Catch: Throwable -> L8
        String r10 = DateUtils.formatDateRange(context, sFormatter, start, end, 65552, null).toString();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    private static List<Integer> getInternetAppInfos(Context context) {
        PackageManager r0 = context.getPackageManager();
        if (r0 != null) goto L5;
        return null;
    L5:
        List<PackageInfo> r3 = r0.getInstalledPackages(4096);
        if (r3 != null) goto L8;
        return null;
    L8:
        UserManager r8 = (UserManager) context.getSystemService("user");
        UserHandle r4 = UserHandle.of(10);
        if (r8 != null) goto L11;
    L15:
        ArrayList r9 = new ArrayList();
        Iterator<PackageInfo> r1 = r3.iterator();
    L17:
        if (r1.hasNext() == false) goto L30;
        PackageInfo r2 = r1.next();
        String[] r5 = r2.requestedPermissions;
        if (r5 == null) goto L17;
        int r6 = r5.length;
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L17;
        if (r5[r7].equals("android.permission.INTERNET") == false) goto L29;
        ApplicationInfo r10 = r2.applicationInfo;
        int r11 = r10.uid;
        if ((r10.flags & 1) != 0) goto L29;
        if (UserHandle.isApp(r10.uid) == false) goto L29;
        r9.add(Integer.valueOf(r11));
    L29:
        r7 = r7 + 1;
        goto L21
    L30:
        return r9;
    L11:
        if (r8.isUserRunning(r4) == false) goto L15;
        if (r8.isUserUnlocked(r4) == false) goto L15;
        r3.addAll(r0.getInstalledPackagesAsUser(4096, 10));
        goto L15
    }

    private static List<Integer> getNoDataUid(ArrayList<AppItem> a2, Context context) {
        List<Integer> r3 = getInternetAppInfos(context);
        ArrayList r0 = new ArrayList();
        Iterator<AppItem> r2 = a2.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(Integer.valueOf(r2.next().key));
        goto L4
    L6:
        if (r3 == null) goto L8;
        r3.removeAll(r0);
    L8:
        return r3;
    }

    private int getIndexFromValue() {
        if (this.mCurrentSlot != 0) goto L5;
        String r0 = Settings.Global.getString(getContentResolver(), Constants.DATA_USAGE_CYCLE);
    L6:
        int r1 = 0;
        if (r0 != null) goto L9;
        return 0;
    L9:
        String[] r2 = this.mDataUsageCycleTime;
        if (r1 < r2.length) goto L12;
        return Integer.parseInt(r0);
    L17:
        return 1;
    L12:
        if (r2[r1].equals(r0) == true) goto L13;
        r1 = r1 + 1;
        goto L9
    L13:
        return r1;
    L5:
        r0 = Settings.Global.getString(getContentResolver(), "data_usage_cycle_sub2");
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.data_usage_header_scrollview);
        updateViewWidth(this.mListView);
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        if (this.mHidenSetting == false) goto L6;
        return "data_usage_detail_page";
    L6:
        return "data_reminder_page";
    }
}
