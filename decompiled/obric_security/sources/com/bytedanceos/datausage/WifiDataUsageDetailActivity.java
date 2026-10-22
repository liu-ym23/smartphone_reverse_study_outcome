package com.bytedanceos.datausage;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.LoaderManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.NetworkStats;
import android.net.NetworkTemplate;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.INetworkManagementService;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.format.Formatter;
import android.util.NtpTrustedTime;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.internal.util.Preconditions;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.tab.OTabLayout;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WifiDataUsageDetailActivity extends BaseActivity {
    private static final String ARG_SYSTEM_APP_UNFOLDED = "arg_system_app_unfolded";
    private static final String ARG_WORK_APP_UNFOLDED = "arg_work_app_unfolded";
    private static final String INTENT_EXTRA_CYCLE_INDEX = "cycle_index";
    private static final int LOADER_CHART_DATA = 2;
    private static final int LOADER_SUMMARY = 3;
    private static final boolean LOGD = false;
    private static final int POWER_USAGE_CYCLE_MONTH = 2;
    private static final int POWER_USAGE_CYCLE_TODAY = 0;
    private static final int POWER_USAGE_CYCLE_WEEK = 1;
    private static final String TAG = "WifiDataUsage";
    private LinearLayout headView;
    private DataUsageAdapter mAdapter;
    private ChartData mChartData;
    private final LoaderManager.LoaderCallbacks<ChartData> mChartDataCallbacks;
    private int mCurrentIndex;
    private int mInsetSide;
    private boolean mIsSystemAppUnfolded;
    private boolean mIsWorkAppUnfolded;
    private OListView mListView;
    private INetworkManagementService mNetworkService;
    private INetworkStatsService mStatsService;
    private INetworkStatsSession mStatsSession;
    private final LoaderManager.LoaderCallbacks<NetworkStats> mSummaryCallbacks;
    private View mSystemAppFooter;
    private int mSystemFoldedAppCount;
    private NetworkTemplate mTemplate;
    private UidDetailProvider mUidDetailProvider;
    private View mWorkAppFooter;
    private int mWorkFoldedAppCount;

    public static class AppItem implements Comparable<AppItem> {
        public boolean hasWorkProfile;
        public final int key;
        public String packageName;
        public boolean restricted;
        public long total;
        public long workTotal;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(AppItem another) {
            return compareTo2(another);
        }

        public AppItem(int key) {
            this.hasWorkProfile = false;
            this.key = key;
        }

        public AppItem(Parcel parcel) {
            this.hasWorkProfile = false;
            this.key = parcel.readInt();
            this.total = parcel.readLong();
            this.packageName = parcel.readString();
        }

        public void applyNetworkTrans(NetworkStats.Entry entry, boolean isWork) {
            this.total += entry.rxBytes + entry.txBytes;
            if (isWork == false) goto L6;
            this.workTotal += entry.rxBytes + entry.txBytes;
            this.hasWorkProfile = true;
            return;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(AppItem another) {
            return Long.compare(another.total, this.total);
        }
    }

    public class DataUsageAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<AppItem> mItems;
        private long mLargest;
        private final UidDetailProvider mProvider;
        final /* synthetic */ WifiDataUsageDetailActivity this$0;

        public DataUsageAdapter(final WifiDataUsageDetailActivity this$0, Context context, UidDetailProvider provider, int insetSide) {
            this.this$0 = this$0;
            this.mItems = Lists.newArrayList();
            this.mContext = context;
            this.mProvider = (UidDetailProvider) Preconditions.checkNotNull(provider);
        }

        public void bindStats(NetworkStats stats, int[] restrictedUids) {
            this.mItems.clear();
            IPackageManager r2 = AppGlobals.getPackageManager();
            int r3 = ActivityManager.getCurrentUser();
            SparseArray r4 = new SparseArray();
            if (stats == null) goto L5;
            int r6 = stats.size();
        L6:
            int r7 = WorkAppUtil.getWorkProfileUserId(this.mContext);
            if (r7 == (-1)) goto L9;
            List<ApplicationInfo> r9 = WorkAppUtil.getWorkAppsByUserId(this.mContext, r7);
        L10:
            NetworkStats.Entry r10 = null;
            int r11 = 0;
        L11:
            if (r11 >= r6) goto L40;
            r10 = stats.getValues(r11, r10);
            int r12 = r10.uid;
            Iterator<ApplicationInfo> r13 = r9.iterator();
            boolean r14 = false;
        L14:
            if (r13.hasNext() == false) goto L18;
            if (r12 != r13.next().uid) goto L14;
            r14 = true;
            goto L14
        L18:
            int r15 = UserHandle.getUserId(r12);
            if (UserHandle.isApp(r12) == false) goto L31;
            if (r15 == r3) goto L36;
            if (r15 == r7) goto L36;
            if (r3 == 0) goto L26;
        L30:
            r12 = UidDetailProvider.buildKeyForUser(r15);
            goto L36
        L26:
            if (r15 != 10) goto L30;
            if (DatausageUtils.doppelgangerAppExist(r2, r12) == true) goto L36;
            r12 = -4;
        L36:
            AppItem r5 = (AppItem) r4.get(r12);
            if (r5 != null) goto L39;
            r5 = new AppItem(r12);
            this.mItems.add(r5);
            r4.put(r5.key, r5);
            r5.packageName = r5.packageName;
        L39:
            r5.applyNetworkTrans(r10, r14);
            r11 = r11 + 1;
            goto L11
        L31:
            if (r12 == (-4)) goto L36;
            if (r12 == (-5)) goto L36;
            r12 = 1000;
            goto L36
        L40:
            if (r7 == (-1)) goto L44;
            int r1 = UidDetailProvider.buildKeyForUser(r7);
            if (((AppItem) r4.get(r1)) != null) goto L44;
            AppItem r8 = new AppItem(r1);
            this.mItems.add(0, r8);
            r4.put(r8.key, r8);
        L44:
            OLog.d(WifiDataUsageDetailActivity.TAG, "dumpAllItems(beforeFilter) size=" + this.mItems.size() + ", sysUnfolded=" + WifiDataUsageDetailActivity.access$700(this.this$0) + ", workUnfolded=" + WifiDataUsageDetailActivity.access$800(this.this$0));
            Iterator<AppItem> r16 = this.mItems.iterator();
        L46:
            if (r16.hasNext() == false) goto L48;
            AppItem r17 = r16.next();
            OLog.d(WifiDataUsageDetailActivity.TAG, "pkg item " + r17.packageName + " total " + r17.total);
            goto L46
        L48:
            filterApplist(r7);
            Collections.sort(this.mItems);
            int r18 = 0;
        L50:
            if (r18 >= this.mItems.size()) goto L55;
            if (UidDetailProvider.isKeyForUser(this.mItems.get(r18).key) == true) goto L53;
            r18 = r18 + 1;
            goto L50
        L53:
            int r19 = 0;
            this.mItems.add(0, this.mItems.remove(r18));
        L57:
            if (this.mItems.size() <= 0) goto L59;
            long r20 = this.mItems.get(r19).total;
        L60:
            this.mLargest = r20;
            notifyDataSetChanged();
            return;
        L59:
            r20 = 0;
            goto L60
        L55:
            r19 = 0;
            goto L57
        L9:
            r9 = Collections.emptyList();
            goto L10
        L5:
            r6 = 0;
            goto L6
        }

        private boolean isSystemApp(int uid) {
            if (uid != (-5)) goto L5;
        L34:
            return true;
        L5:
            if (uid == (-4)) goto L34;
            if (uid == 1000) goto L34;
            PackageManager r0 = this.mContext.getPackageManager();
            if (r0 != null) goto L11;
            return false;
        L11:
            String[] r1 = r0.getPackagesForUid(uid);
            if (r1 != null) goto L14;
        L16:
            String r2 = null;
        L17:
            OLog.d(WifiDataUsageDetailActivity.TAG, "pkg item: " + r2);
        L31:
            e = move-exception;
            e.printStackTrace();
        L33:
            return false;
        L19:
            if (this.mProvider.isSpecialSystemApp(r2) == false) goto L21;
            return true;
        L21:
            ApplicationInfo r7 = AppGlobals.getPackageManager().getApplicationInfo(r2, 0, UserHandle.getUserId(uid));     // Catch: RemoteException -> L31
            if (r7 == null) goto L30;
            if ((r7.flags & 1) == 0) goto L26;
        L27:
            return true;
        L26:
            if (UserHandle.isApp(r7.uid) == true) goto L33;
        L30:
            return !WifiDataUsageDetailActivity.access$700(this.this$0);
        L14:
            if (r1.length <= 0) goto L16;
            r2 = r1[0];
            goto L17
        }

        private void filterApplist(int workUserId) {
            OLog.d(WifiDataUsageDetailActivity.TAG, "filterApplist...");
            WifiDataUsageDetailActivity.access$1002(this.this$0, 0);
            WifiDataUsageDetailActivity.access$1102(this.this$0, 0);
            ArrayList<AppItem> r11 = Lists.newArrayList();
            Iterator<AppItem> r2 = this.mItems.iterator();
            long r3 = 0;
            AppItem r7 = null;
            long r5 = 0;
        L4:
            if (r2.hasNext() == false) goto L27;
            AppItem r8 = r2.next();
            if (UidDetailProvider.isKeyForUser(r8.key) == true) goto L7;
            if (WifiDataUsageDetailActivity.access$800(this.this$0) == true) goto L11;
            if (WifiDataUsageDetailActivity.access$700(this.this$0) == true) goto L16;
            if (r8.hasWorkProfile == true) goto L22;
            if (isSystemApp(r8.key) == true) goto L25;
            r11.add(r8);
            goto L4
        L25:
            WifiDataUsageDetailActivity.access$1008(this.this$0);
            r5 = r5 + r8.total;
            goto L4
        L22:
            WifiDataUsageDetailActivity.access$1108(this.this$0);
            r3 = r3 + r8.total;
            goto L4
        L16:
            if (isSystemApp(r8.key) == false) goto L4;
            if (r8.hasWorkProfile == true) goto L4;
            r11.add(r8);
            goto L4
        L11:
            if (r8.hasWorkProfile == false) goto L4;
            r11.add(r8);
            goto L4
        L7:
            r7 = r8;
            goto L4
        L27:
            if (r7 == null) goto L29;
            r11.add(0, r7);
        L29:
            this.mItems = r11;
            if (WifiDataUsageDetailActivity.access$700(this.this$0) == false) goto L32;
        L45:
            OLog.d(WifiDataUsageDetailActivity.TAG, "mItems size:" + this.mItems.size() + ", sys fold: " + WifiDataUsageDetailActivity.access$1000(this.this$0) + ", work fold: " + WifiDataUsageDetailActivity.access$1100(this.this$0));
            return;
        L32:
            if (WifiDataUsageDetailActivity.access$800(this.this$0) == true) goto L45;
            if (WifiDataUsageDetailActivity.access$1200(this.this$0) == null) goto L40;
            OCardListItem r12 = (OCardListItem) WifiDataUsageDetailActivity.access$1200(this.this$0).findViewById(R.id.system_app);
            if (r12 == null) goto L38;
            r12.getEndDetail().setText(Formatter.formatFileSize(this.this$0.getApplicationContext(), r5));
        L38:
            r12.setCardPosition(0);
        L40:
            if (WifiDataUsageDetailActivity.access$1300(this.this$0) == null) goto L45;
            OCardListItem r13 = (OCardListItem) WifiDataUsageDetailActivity.access$1300(this.this$0).findViewById(R.id.system_app);
            if (r13 == null) goto L44;
            r13.getEndDetail().setText(Formatter.formatFileSize(this.this$0.getApplicationContext(), r3));
        L44:
            r13.setCardPosition(0);
            goto L45
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
        L25:
            return convertView;
        L17:
            if (r7.restricted == false) goto L22;
            if (r7.total > 0) goto L22;
            r1.setEndDetailText(r9.getResources().getString(R.string.data_usage_app_restricted));
        L22:
            if (r7.total > 1) goto L24;
            ByteUnitPair r6 = ByteConverter.convert(r7.total, "B", 1000);
            r1.setEndDetailText(r6.getValue() + r6.getUnit());
            goto L25
        L24:
            ByteUnitPair r8 = ByteConverter.convert(r7.total, "B", 1000);
            r1.setEndDetailText(r8.getValue() + r8.getUnit());
            goto L25
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

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "wifi_data_usage_page";
    }

    public WifiDataUsageDetailActivity() {
        this.mSystemFoldedAppCount = 0;
        this.mWorkFoldedAppCount = 0;
        this.mInsetSide = 0;
        this.mIsSystemAppUnfolded = false;
        this.mIsWorkAppUnfolded = false;
        this.mChartDataCallbacks = new AnonymousClass5(this);
        this.mSummaryCallbacks = new AnonymousClass6(this);
    }

    static /* synthetic */ int access$000(WifiDataUsageDetailActivity r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$002(WifiDataUsageDetailActivity r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ void access$100(WifiDataUsageDetailActivity r0) {
        r0.updateDetailData();
    }

    static /* synthetic */ int access$1000(WifiDataUsageDetailActivity r0) {
        return r0.mSystemFoldedAppCount;
    }

    static /* synthetic */ int access$1002(WifiDataUsageDetailActivity r0, int r1) {
        r0.mSystemFoldedAppCount = r1;
        return r1;
    }

    static /* synthetic */ int access$1008(WifiDataUsageDetailActivity r2) {
        int r0 = r2.mSystemFoldedAppCount;
        r2.mSystemFoldedAppCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ int access$1100(WifiDataUsageDetailActivity r0) {
        return r0.mWorkFoldedAppCount;
    }

    static /* synthetic */ int access$1102(WifiDataUsageDetailActivity r0, int r1) {
        r0.mWorkFoldedAppCount = r1;
        return r1;
    }

    static /* synthetic */ int access$1108(WifiDataUsageDetailActivity r2) {
        int r0 = r2.mWorkFoldedAppCount;
        r2.mWorkFoldedAppCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ View access$1200(WifiDataUsageDetailActivity r0) {
        return r0.mSystemAppFooter;
    }

    static /* synthetic */ View access$1300(WifiDataUsageDetailActivity r0) {
        return r0.mWorkAppFooter;
    }

    static /* synthetic */ INetworkStatsService access$200(WifiDataUsageDetailActivity r0) {
        return r0.mStatsService;
    }

    static /* synthetic */ void access$300(WifiDataUsageDetailActivity r0) {
        r0.updateBody();
    }

    static /* synthetic */ INetworkStatsSession access$400(WifiDataUsageDetailActivity r0) {
        return r0.mStatsSession;
    }

    static /* synthetic */ ChartData access$502(WifiDataUsageDetailActivity r0, ChartData r1) {
        r0.mChartData = r1;
        return r1;
    }

    static /* synthetic */ DataUsageAdapter access$600(WifiDataUsageDetailActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$700(WifiDataUsageDetailActivity r0) {
        return r0.mIsSystemAppUnfolded;
    }

    static /* synthetic */ boolean access$800(WifiDataUsageDetailActivity r0) {
        return r0.mIsWorkAppUnfolded;
    }

    static /* synthetic */ void access$900(WifiDataUsageDetailActivity r0) {
        r0.updateFooterView();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_data_usage_detail_activity);
        this.mNetworkService = INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        this.mStatsService = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
    L7:
        OLog.w(TAG, "No bandwidth control; leaving");
        finish();
    L14:
        this.mStatsSession = this.mStatsService.openSession();     // Catch: RemoteException -> L11
        this.mIsSystemAppUnfolded = getIntent().getBooleanExtra(ARG_SYSTEM_APP_UNFOLDED, false);
        this.mIsWorkAppUnfolded = getIntent().getBooleanExtra(ARG_WORK_APP_UNFOLDED, false);
        this.mTemplate = NetworkTemplate.buildTemplateWifiWildcard();
        initView();
        return;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (this.mNetworkService.isBandwidthControlEnabled() == true) goto L14;
        OLog.w(TAG, "No bandwidth control; leaving");     // Catch: RemoteException -> L7
        finish();     // Catch: RemoteException -> L7
        goto L14
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
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
        this.mUidDetailProvider = new UidDetailProvider(this);
        OListView r1 = (OListView) findViewById(R.id.data_usage_sort_list);
        this.mListView = r1;
        ViewCompat.setOnApplyWindowInsetsListener(r1, new WifiDataUsageDetailActivity$$ExternalSyntheticLambda0());
        int r2 = getIntent().getIntExtra(INTENT_EXTRA_CYCLE_INDEX, 0);
        if (r2 >= 0) goto L5;
    L7:
        r2 = 0;
    L8:
        this.mCurrentIndex = r2;
        LinearLayout r3 = (LinearLayout) getLayoutInflater().inflate(R.layout.data_usage_header_otab, null, false);
        this.headView = r3;
        if (r3 == null) goto L11;
        ((OTabLayout) r3.findViewById(R.id.cycle_view)).addOnTabSelectedListener(new AnonymousClass1(this));
    L11:
        OListView r4 = this.mListView;
        if (r4 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L19;
        this.mInsetSide = getResources().getDimensionPixelOffset(Utils.getResouceId("android", "preference_fragment_padding_side", "dimen", 17106073));
    L20:
        this.mAdapter = new DataUsageAdapter(this, this, this.mUidDetailProvider, this.mInsetSide);
        OListView r0 = this.mListView;
        if (r0 != null) goto L23;
        return;
    L23:
        if (this.mIsSystemAppUnfolded == false) goto L25;
    L27:
        r0.addHeaderView(initListTransparentHeaderView());
        this.mListView.setEmptyView(findViewById(R.id.empty_view));
    L28:
        this.mListView.setAdapter(this.mAdapter);
        return;
    L25:
        if (this.mIsWorkAppUnfolded == true) goto L27;
        r0.addHeaderView(this.headView, r0, true);
        goto L28
    L19:
        this.mInsetSide = 0;
        goto L20
    L14:
        if (r4.getScrollBarStyle() != 33554432) goto L16;
        r5 = true;
        goto L17
    L5:
        if (r2 > 2) goto L7;
        goto L7
    }

    static /* synthetic */ WindowInsetsCompat lambda$initView$0(View r3, WindowInsetsCompat r4) {
        Insets r0 = r4.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        r3.setPadding(0, r3.getPaddingTop(), 0, r0.bottom + OUnitExtensionKt.dp2px(16));
        return r4;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedanceos.datausage.WifiDataUsageDetailActivity$2] */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        updateBody();
        new AnonymousClass2(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void updateFooterView() {
        if (this.mIsSystemAppUnfolded == false) goto L5;
        return;
    L5:
        if (this.mIsWorkAppUnfolded == true) goto L14;
        this.mListView.removeFooterView(getSystemAppFooter());
        this.mListView.removeFooterView(getWorkAppFooter());
        if (this.mSystemFoldedAppCount <= 0) goto L10;
        this.mListView.addFooterView(getSystemAppFooter());
    L10:
        if (this.mWorkFoldedAppCount <= 0) goto L15;
        this.mListView.addFooterView(getWorkAppFooter());
        return;
    L15:
        return;
    }

    private View getSystemAppFooter() {
        if (this.mSystemAppFooter != null) goto L10;
        View r0 = LayoutInflater.from(this).inflate(R.layout.datausage_list_footer_view, null);
        this.mSystemAppFooter = r0;
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.system_app);
        if (r1 == null) goto L7;
        r1.setEndDetailText("");
        r1.showCustomEnd(true);
        r1.setDefaultTailIcon(0);
        r1.showTailIcon(true);
        r1.setOnContentClickListener(new AnonymousClass3(this));
        goto L10
    L7:
        return this.mSystemAppFooter;
    L10:
        return this.mSystemAppFooter;
    }

    private View getWorkAppFooter() {
        if (this.mWorkAppFooter != null) goto L10;
        View r0 = LayoutInflater.from(this).inflate(R.layout.datausage_list_footer_view, null);
        this.mWorkAppFooter = r0;
        OCardListItem r1 = (OCardListItem) r0.findViewById(R.id.system_app);
        if (r1 == null) goto L7;
        r1.setTitle(getString(R.string.managed_user_title));
        r1.setEndDetailText("");
        r1.showCustomEnd(true);
        r1.setDefaultTailIcon(0);
        r1.showTailIcon(true);
        r1.setOnContentClickListener(new AnonymousClass4(this));
        goto L10
    L7:
        return this.mWorkAppFooter;
    L10:
        return this.mWorkAppFooter;
    }

    private View initListTransparentHeaderView() {
        ImageView r0 = new ImageView(this);
        r0.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin)));
        r0.setBackgroundColor(getResources().getColor(R.color.transparent));
        return r0;
    }

    private void updateBody() {
        if (this.mTemplate == null) goto L6;
        getLoaderManager().restartLoader(2, ChartDataLoader.buildArgs(this.mTemplate, null), this.mChartDataCallbacks);
        return;
    }

    private void updateDetailData() {
        if (this.mCurrentIndex != (-1)) goto L5;
        this.mCurrentIndex = 1;
    L5:
        NtpTrustedTime r0 = NtpTrustedTime.getInstance(this);
        if (r0.hasCache() == false) goto L8;
        long r1 = r0.currentTimeMillis();
    L9:
        Calendar r3 = Calendar.getInstance();
        r3.set(11, 0);
        r3.set(12, 0);
        r3.set(13, 0);
        int r4 = this.mCurrentIndex;
        if (r4 != 2) goto L12;
        r3.set(5, 1);
    L14:
        long r2 = r3.getTimeInMillis();
        getLoaderManager().restartLoader(3, SummaryForAllUidLoader.buildArgs(this.mTemplate, r2, r1), this.mSummaryCallbacks);
        return;
    L12:
        if (r4 != 1) goto L14;
        r3.setFirstDayOfWeek(2);
        r3.get(7);
        r3.set(7, 2);
        goto L14
    L8:
        r1 = System.currentTimeMillis();
        goto L9
    }

    private static List<Integer> getInternetAppInfos(Context context) {
        PackageManager r8 = context.getPackageManager();
        if (r8 != null) goto L5;
        return null;
    L5:
        List<PackageInfo> r2 = r8.getInstalledPackages(4096);
        if (r2 != null) goto L8;
        return null;
    L8:
        r2.addAll(r8.getInstalledPackagesAsUser(4096, 10));
        ArrayList r9 = new ArrayList();
        Iterator<PackageInfo> r0 = r2.iterator();
    L10:
        if (r0.hasNext() == false) goto L23;
        PackageInfo r1 = r0.next();
        String[] r3 = r1.requestedPermissions;
        if (r3 == null) goto L10;
        int r4 = r3.length;
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L10;
        if (r3[r5].equals("android.permission.INTERNET") == false) goto L22;
        ApplicationInfo r6 = r1.applicationInfo;
        int r7 = r6.uid;
        if ((r6.flags & 1) != 0) goto L22;
        if (UserHandle.isApp(r6.uid) == false) goto L22;
        r9.add(Integer.valueOf(r7));
    L22:
        r5 = r5 + 1;
        goto L14
    L23:
        return r9;
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
}
