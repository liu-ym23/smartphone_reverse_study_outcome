package com.android.settings;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkStats;
import android.net.NetworkStatsHistory;
import android.net.NetworkTemplate;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.INetworkManagementService;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.NtpTrustedTime;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.loader.app.LoaderManager;
import bytedanceos.api.SmtOpsManagerSmt;
import com.GlobalProxyLancet;
import com.android.internal.util.Preconditions;
import com.android.settings.base.BaseActivity;
import com.android.settings.net.ChartData;
import com.android.settings.net.ChartDataLoader;
import com.android.settings.net.SummaryForAllUidLoader;
import com.android.settings.net.UidDetail;
import com.android.settings.net.UidDetailProvider;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.DataUsageCycleView;
import com.bytedanceos.tencent.ITencent;
import com.bytedanceos.tencent.SMTCodeName;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.NetworkPolicyEditor;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;
import obric.widget.SettingItemText;
import obric.widget.SwitchEx;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageFragment extends SettingsFragment {
    private static final String ARG_SYSTEM_APP_UNFOLDED = "arg_system_app_unfolded";
    public static final Uri CONTENT_URI_SIMINFO = null;
    public static final String INTENT_EXTRA_CHECKED = "checked";
    public static final String INTENT_EXTRA_LIMIT = "limit";
    private static final String LAST_SUBSCRIBER_PROP = "persist.radio.last.subscriber";
    private static final int LOADER_CHART_DATA = 2;
    private static final int LOADER_SUMMARY = 3;
    private static final boolean LOGD = false;
    private static final int MSG_REFRESH_CARDINFO = 1;
    private static final int REQUEST_CYCLE = 1;
    private static final int REQUEST_LIMIT = 2;
    private static final int REQUEST_SET_BRANCH = 6;
    private static final int REQUEST_SET_CARRY = 5;
    private static final int REQUEST_SET_CITY = 4;
    private static final int REQUEST_SET_PROVINCE = 3;
    private static final String[] SIMINFO_PROJECTION = null;
    private static final int SUB1 = 0;
    public static final String SUBSCRIPTION_KEY = "slot";
    private static final String TAG = "DataUsage";
    private static final String TEST_SUBSCRIBER_PROP = "test.subscriberid";
    private static final StringBuilder sBuilder = null;
    private static final Formatter sFormatter = null;
    private final int POWER_USAGE_CYCLE_MONTH;
    private final int POWER_USAGE_CYCLE_TODAY;
    private final int POWER_USAGE_CYCLE_WEEK;
    private LinearLayout headView;
    private boolean isTencentSDKEnabled;
    private Activity mActivity;
    private DataUsageAdapter mAdapter;
    private View mBottomGapFooter;
    String mBranchCode;
    String mBranchName;
    private SettingItemText mBranchView;
    ArrayList<SMTCodeName> mBranchs;
    private String[] mBranchsCodeArray;
    private String[] mBranchsNameArray;
    String mCarryCode;
    String mCarryName;
    private SettingItemText mCarryView;
    ArrayList<SMTCodeName> mCarrys;
    private String[] mCarrysCodeArray;
    private String[] mCarrysNameArray;
    private ChartData mChartData;
    private final LoaderManager.LoaderCallbacks<ChartData> mChartDataCallbacks;
    String mCityCode;
    String mCityName;
    private SettingItemText mCityView;
    ArrayList<SMTCodeName> mCitys;
    private int mCurrentBranchIndex;
    private int mCurrentCarryIndex;
    private int mCurrentIndex;
    private int mCurrentSlot;
    private long mDataLimit;
    private View.OnClickListener mDataLimitChangeListener;
    private String[] mDataUsageCycleTime;
    private int[] mDataUsageCycleTimeRes;
    private DataUsageCycleView mDataUsageTotally;
    private TextView mEmpty;
    private int mInsetSide;
    private IntentFilter mIntentFilter;
    private boolean mIsFromSecurity;
    private boolean mIsLimitLaunched;
    private boolean mIsSystemAppUnfolded;
    private SimCardInfo mLastSimInfoInDb;
    private ListContentItemText mLimitText;
    private ListView mListView;
    private INetworkManagementService mNetworkService;
    private NetworkPolicy mPolicy;
    private NetworkPolicyEditor mPolicyEditor;
    private NetworkPolicyManager mPolicyManager;
    String mProvinceCode;
    String mProvinceName;
    private SettingItemText mProvinceView;
    ArrayList<SMTCodeName> mProvinces;
    private final BroadcastReceiver mReceiver;
    private boolean mSettingFragment;
    private ImageView mSimGuide;
    private View.OnClickListener mSimInfoChangeListener;
    private INetworkStatsService mStatsService;
    private INetworkStatsSession mStatsSession;
    private final LoaderManager.LoaderCallbacks<NetworkStats> mSummaryCallbacks;
    private View mSystemAppFooter;
    private int mSystemFoldedAppCount;
    private NetworkTemplate mTemplate;
    public ITencent mTencentService;
    private final ServiceConnection mTencentServiceConnection;
    private long mTotalBytesInMonth;
    private UidDetailProvider mUidDetailProvider;
    private CompoundButton.OnCheckedChangeListener mWarningCheckChangeListener;
    private ListContentItemSwitch mWarningSwitch;
    private TextView mWarningtipView;
    private LinearLayout simGuideView;
    public Handler uiHandler;

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
        public /* bridge */ /* synthetic */ int compareTo(AppItem r1) {
            return compareTo2(r1);
        }

        public AppItem(int r2) {
            this.uids = new SparseBooleanArray();
            this.key = r2;
        }

        public AppItem(Parcel r3) {
            this.uids = new SparseBooleanArray();
            this.key = r3.readInt();
            this.uids = r3.readSparseBooleanArray();
            this.total = r3.readLong();
            this.packageName = r3.readString();
        }

        public void addUid(int r2) {
            this.uids.put(r2, true);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeInt(this.key);
            r3.writeSparseBooleanArray(this.uids);
            r3.writeLong(this.total);
            r3.writeString(this.packageName);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(AppItem r3) {
            return Long.compare(r3.total, this.total);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public static class CycleAdapter extends ArrayAdapter<CycleItem> {
        private final CycleChangeItem mChangeItem;
        private boolean mChangePossible;
        private boolean mChangeVisible;

        public CycleAdapter(Context r2) {
            super(r2, android.R.layout.simple_spinner_item);
            this.mChangePossible = false;
            this.mChangeVisible = false;
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.mChangeItem = new CycleChangeItem(r2);
        }

        public void setChangePossible(boolean r1) {
            this.mChangePossible = r1;
            updateChange();
        }

        public void setChangeVisible(boolean r1) {
            this.mChangeVisible = r1;
            updateChange();
        }

        private void updateChange() {
            remove(this.mChangeItem);
            if (this.mChangePossible == true) goto L5;
            return;
        L5:
            if (this.mChangeVisible == false) goto L9;
            add(this.mChangeItem);
            return;
        }

        public int findNearestPosition(CycleItem r4) {
            if (r4 == null) goto L12;
            int r0 = getCount() - 1;
        L4:
            if (r0 < 0) goto L18;
            CycleItem r1 = getItem(r0);
            if ((r1 instanceof CycleChangeItem) == true) goto L11;
            if (r1.compareTo2(r4) < 0) goto L11;
            return r0;
        L11:
            r0 = r0 - 1;
            goto L4
        L18:
            return 0;
        L12:
            return 0;
        }
    }

    public static class CycleChangeItem extends CycleItem {
        public CycleChangeItem(Context r2) {
            super(r2.getString(R.string.data_usage_change_cycle));
        }
    }

    public static class CycleItem implements Comparable<CycleItem> {
        public long end;
        public CharSequence label;
        public long start;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(CycleItem r1) {
            return compareTo2(r1);
        }

        CycleItem(CharSequence r1) {
            this.label = r1;
        }

        public CycleItem(Context r1, long r2, long r4) {
            this.label = DataUsageFragment.formatDateRange(r1, r2, r4);
            this.start = r2;
            this.end = r4;
        }

        public String toString() {
            return this.label.toString();
        }

        public boolean equals(Object r7) {
            if ((r7 instanceof CycleItem) == false) goto L10;
            CycleItem r8 = (CycleItem) r7;
            if (this.start == r8.start) goto L7;
            return false;
        L7:
            if (this.end != r8.end) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(CycleItem r3) {
            return Long.compare(this.start, r3.start);
        }
    }

    public class DataUsageAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<AppItem> mItems;
        private long mLargest;
        private final UidDetailProvider mProvider;
        final /* synthetic */ DataUsageFragment this$0;

        public DataUsageAdapter(DataUsageFragment r1, Context r2, UidDetailProvider r3, int r4) {
            this.this$0 = r1;
            this.mItems = Lists.newArrayList();
            this.mContext = r2;
            this.mProvider = (UidDetailProvider) Preconditions.checkNotNull(r3);
        }

        public void bindStats(NetworkStats r17, int[] r18) {
            this.mItems.clear();
            int r3 = ActivityManager.getCurrentUser();
            SparseArray r4 = new SparseArray();
            if (r17 == null) goto L5;
            int r6 = r17.size();
        L6:
            NetworkStats.Entry r7 = null;
            int r8 = 0;
        L7:
            if (r8 >= r6) goto L30;
            r7 = r17.getValues(r8, r7);
            int r9 = r7.uid;
            int r11 = -4;
            if (UserHandle.isApp(r9) == true) goto L11;
            if (r9 != (-4)) goto L22;
        L25:
            r11 = r9;
        L26:
            AppItem r10 = (AppItem) r4.get(r11);
            if (r10 != null) goto L29;
            r10 = new AppItem(r11);
            this.mItems.add(r10);
            r4.put(r10.key, r10);
        L29:
            r10.addUid(r9);
            r10.total += r7.rxBytes + r7.txBytes;
            r8 = r8 + 1;
            r6 = r6;
            goto L7
        L22:
            if (r9 == (-5)) goto L25;
            r11 = 1000;
            goto L26
        L11:
            if (UserHandle.getUserId(r9) == r3) goto L25;
            if (r3 == 0) goto L15;
        L19:
            r11 = UidDetailProvider.buildKeyForUser(UserHandle.getUserId(r9));
            goto L26
        L15:
            if (UserHandle.getUserId(r9) != 10) goto L19;
            if (Utils.doppelgangerAppExist(this.this$0.getActivity().getPackageManager(), r9) == true) goto L25;
        L30:
            int r1 = r18.length;
            int r5 = 0;
        L31:
            if (r5 >= r1) goto L40;
            int r12 = r18[r5];
            if (UserHandle.getUserId(r12) != r3) goto L39;
            AppItem r13 = (AppItem) r4.get(r12);
            if (r13 != null) goto L38;
            r13 = new AppItem(r12);
            r13.total = -1;
            this.mItems.add(r13);
            r4.put(r13.key, r13);
        L38:
            r13.restricted = true;
        L39:
            r5 = r5 + 1;
            goto L31
        L40:
            List r2 = DataUsageFragment.access$2700(this.mItems, this.mContext);
            long r14 = 0;
            if (r2.size() <= 0) goto L46;
            Iterator r15 = r2.iterator();
        L44:
            if (r15.hasNext() == false) goto L46;
            AppItem r16 = new AppItem(((Integer) r15.next()).intValue());
            r16.total = 0;
            this.mItems.add(r16);
        L46:
            filterApplist();
            Collections.sort(this.mItems);
            if (this.mItems.size() <= 0) goto L49;
            r14 = this.mItems.get(0).total;
        L49:
            this.mLargest = r14;
            notifyDataSetChanged();
            return;
        L5:
            r6 = 0;
            goto L6
        }

        private boolean isSystemApp(int r6) {
            if (r6 != (-5)) goto L5;
        L28:
            return true;
        L5:
            if (r6 == (-4)) goto L28;
            if (r6 == 1000) goto L28;
            String[] r0 = this.mContext.getPackageManager().getPackagesForUid(r6);
            if (r0 != null) goto L11;
        L13:
            String r1 = null;
        L14:
            OLog.d(DataUsageFragment.TAG, "pkg item: " + r1);
        L25:
            e = move-exception;
            e.printStackTrace();
        L27:
            return false;
        L16:
            if (this.mProvider.isSpecialSystemApp(r1) == false) goto L18;
            return true;
        L18:
            ApplicationInfo r5 = this.this$0.getActivity().getPackageManager().getApplicationInfoAsUser(r1, 0, UserHandle.getUserId(r6));     // Catch: PackageManager.NameNotFoundException -> L25
            if (r5 == null) goto L27;
            if ((r5.flags & 1) != 0) goto L24;
            if (UserHandle.isApp(r5.uid) == true) goto L27;
        L24:
            return true;
        L11:
            if (r0.length <= 0) goto L13;
            r1 = r0[0];
            goto L14
        }

        private void filterApplist() {
            OLog.d(DataUsageFragment.TAG, "filterApplist...");
            DataUsageFragment.access$2502(this.this$0, 0);
            ArrayList<AppItem> r0 = Lists.newArrayList();
            Iterator<AppItem> r2 = this.mItems.iterator();
        L4:
            if (r2.hasNext() == false) goto L14;
            AppItem r3 = r2.next();
            if (DataUsageFragment.access$1700(this.this$0) == true) goto L8;
            if (isSystemApp(r3.key) == false) goto L12;
            DataUsageFragment.access$2508(this.this$0);
            goto L4
        L12:
            r0.add(r3);
            goto L4
        L8:
            if (isSystemApp(r3.key) == false) goto L4;
            r0.add(r3);
            goto L4
        L14:
            this.mItems = r0;
            OLog.d(DataUsageFragment.TAG, "mItems size:" + this.mItems.size() + "mSystemFoldedAppCount " + DataUsageFragment.access$2500(this.this$0));
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mItems.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mItems.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return this.mItems.get(r1).key;
        }

        @Override // android.widget.Adapter
        public View getView(int r11, View r12, ViewGroup r13) {
            if (r12 != null) goto L5;
            r12 = LayoutInflater.from(r13.getContext()).inflate(R.layout.app_data_usage_item, r13, false);
        L5:
            Context r14 = r13.getContext();
            ListContentItemSwitch r1 = (ListContentItemSwitch) r12.findViewById(R.id.app_info);
            AppItem r2 = this.mItems.get(r11);
            UidDetailTask.bindView(this.mProvider, r2, r12);
            if (r2.restricted == false) goto L11;
            if (r2.total > 0) goto L11;
            r1.setSummary(R.string.data_usage_app_restricted);
        L14:
            View r15 = r12.findViewById(R.id.empty_view);
            r15.setVisibility(8);
            r1.setBackgroundStyle(3);
            if (DataUsageFragment.access$1700(this.this$0) == false) goto L25;
            if (this.mItems.size() != 1) goto L19;
            r1.setBackgroundStyle(1);
            r15.setVisibility(0);
        L29:
            return r12;
        L19:
            if (r11 != 0) goto L22;
            r1.setBackgroundStyle(2);
            goto L29
        L22:
            if (r11 != (this.mItems.size() - 1)) goto L29;
            r1.setBackgroundStyle(4);
            r15.setVisibility(0);
            goto L29
        L25:
            if (DataUsageFragment.access$2500(this.this$0) != 0) goto L29;
            if (r11 != (this.mItems.size() - 1)) goto L29;
            r1.setBackgroundStyle(4);
            r15.setVisibility(0);
        L11:
            if (r2.total > 1) goto L13;
            r1.setSummary(r14.getResources().getString(android.R.string.global_action_restart, new Object[]{Double.valueOf(0.0d), r14.getString(R.string.kilobyteShort)}));
            goto L14
        L13:
            r1.setSummary(android.text.format.Formatter.formatFileSize(r14, r2.total).replace('k', 'K'));
            goto L14
        }
    }

    private static class SimCardInfo {
        String branchCode;
        String carryCode;
        String cityCode;
        String provinceCode;

        public SimCardInfo() {
            this.provinceCode = "";
            this.cityCode = "";
            this.carryCode = "";
            this.branchCode = "";
        }

        public SimCardInfo(String r1, String r2, String r3, String r4) {
            this.provinceCode = r1;
            this.cityCode = r2;
            this.carryCode = r3;
            this.branchCode = r4;
        }

        public boolean equals(Object r5) {
            if (r5 != null) goto L6;
            return false;
        L6:
            if (r5 != this) goto L9;
            return true;
        L9:
            if ((r5 instanceof SimCardInfo) == false) goto L20;
            SimCardInfo r6 = (SimCardInfo) r5;
            if (TextUtils.equals(this.provinceCode, r6.provinceCode) == true) goto L13;
            return false;
        L13:
            if (TextUtils.equals(this.cityCode, r6.cityCode) == true) goto L15;
            return false;
        L15:
            if (TextUtils.equals(this.carryCode, r6.carryCode) == true) goto L17;
            return false;
        L17:
            if (TextUtils.equals(this.branchCode, r6.branchCode) == true) goto L19;
            return false;
        L19:
            return true;
        L20:
            return false;
        }
    }

    private static class UidDetailTask extends AsyncTask<Void, Void, UidDetail> {
        private static final CompoundButton.OnCheckedChangeListener mCheckChangeListener = null;
        private final AppItem mItem;
        private final UidDetailProvider mProvider;
        private final View mTarget;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ UidDetail doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(UidDetail r1) {
            onPostExecute2(r1);
        }

        static {
            mCheckChangeListener = new AnonymousClass1();
        }

        private UidDetailTask(UidDetailProvider r1, AppItem r2, View r3) {
            this.mProvider = (UidDetailProvider) Preconditions.checkNotNull(r1);
            this.mItem = (AppItem) Preconditions.checkNotNull(r2);
            this.mTarget = (View) Preconditions.checkNotNull(r3);
        }

        public static void bindView(UidDetailProvider r2, AppItem r3, View r4) {
            UidDetailTask r0 = (UidDetailTask) r4.getTag();
            if (r0 == null) goto L5;
            r0.cancel(false);
        L5:
            UidDetail r1 = r2.getUidDetail(r3.key, false);
            if (r1 == null) goto L8;
            bindView(r1, r4);
            return;
        L8:
            r4.setTag(new UidDetailTask(r2, r3, r4).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]));
        }

        private static void bindView(UidDetail r5, View r6) {
            ListContentItemSwitch r0 = (ListContentItemSwitch) r6.findViewById(R.id.app_info);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r5 == null) goto L13;
            r0.setIcon(r5.icon);
            r0.setTitle(r5.label);
            if (r5.displaySwitch == true) goto L9;
            r0.getSwitch().setVisibility(8);
            return;
        L9:
            boolean r2 = false;
            r0.getSwitch().setVisibility(0);
            r0.getSwitch().setTag(r5);
            r0.getSwitch().setOnCheckedChangeListener(mCheckChangeListener);
            SwitchEx r1 = r0.getSwitch();
            if (SmtOpsManagerSmt.getInstance().checkOp(r6.getContext(), 16, r5.uid, r5.packageName) != 0) goto L12;
            r2 = true;
        L12:
            r1.setChecked(r2);
            return;
        L13:
            ImageView r7 = r0.getIconView();
            if (r7 == null) goto L16;
            r7.setImageDrawable(null);
        L16:
            r0.setTitle("");
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            bindView(null, this.mTarget);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected UidDetail doInBackground2(Void... r2) {
            return this.mProvider.getUidDetail(this.mItem.key, true);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(UidDetail r1) {
            bindView(r1, this.mTarget);
        }
    }

    @Override // com.android.settings.SettingsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DataUsageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DataUsageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DataUsageFragment() {
        this.POWER_USAGE_CYCLE_TODAY = 0;
        this.POWER_USAGE_CYCLE_WEEK = 1;
        this.POWER_USAGE_CYCLE_MONTH = 2;
        this.mSystemFoldedAppCount = 0;
        this.mInsetSide = 0;
        this.mDataUsageTotally = null;
        this.mIsSystemAppUnfolded = false;
        this.mIntentFilter = new IntentFilter(DataUsageLimitActivity.ACTION_DATA_USAGE_LIMIT_CHANGED);
        this.mReceiver = new AnonymousClass1(this);
        this.mTencentService = null;
        this.mProvinceCode = "";
        this.mProvinceName = "";
        this.mCityCode = "";
        this.mCityName = "";
        this.mCarryCode = "";
        this.mCarryName = "";
        this.mBranchCode = "";
        this.mBranchName = "";
        this.mSettingFragment = false;
        this.mCurrentCarryIndex = -1;
        this.mCurrentBranchIndex = -1;
        this.mIsFromSecurity = false;
        this.isTencentSDKEnabled = false;
        this.mTencentServiceConnection = new AnonymousClass3(this);
        this.mSimInfoChangeListener = new AnonymousClass5(this);
        this.mDataLimitChangeListener = new AnonymousClass7(this);
        this.mWarningCheckChangeListener = new AnonymousClass8(this);
        this.mChartDataCallbacks = new AnonymousClass10(this);
        this.mSummaryCallbacks = new AnonymousClass11(this);
    }

    static /* synthetic */ NetworkPolicy access$000(DataUsageFragment r0) {
        return r0.mPolicy;
    }

    static /* synthetic */ void access$100(DataUsageFragment r0) {
        r0.updateSimInfoView();
    }

    static /* synthetic */ String[] access$1000(DataUsageFragment r0) {
        return r0.mBranchsNameArray;
    }

    static /* synthetic */ String[] access$1002(DataUsageFragment r0, String[] r1) {
        r0.mBranchsNameArray = r1;
        return r1;
    }

    static /* synthetic */ int access$1100(DataUsageFragment r0) {
        return r0.mCurrentBranchIndex;
    }

    static /* synthetic */ INetworkStatsService access$1200(DataUsageFragment r0) {
        return r0.mStatsService;
    }

    static /* synthetic */ void access$1300(DataUsageFragment r0) {
        r0.updateBody();
    }

    static /* synthetic */ boolean access$1400(DataUsageFragment r0) {
        return r0.mIsLimitLaunched;
    }

    static /* synthetic */ boolean access$1402(DataUsageFragment r0, boolean r1) {
        r0.mIsLimitLaunched = r1;
        return r1;
    }

    static /* synthetic */ int access$1500(DataUsageFragment r0) {
        return r0.mCurrentSlot;
    }

    static /* synthetic */ void access$1600(DataUsageFragment r0, boolean r1) {
        r0.setWarningDialogEnabled(r1);
    }

    static /* synthetic */ boolean access$1700(DataUsageFragment r0) {
        return r0.mIsSystemAppUnfolded;
    }

    static /* synthetic */ Activity access$1800(DataUsageFragment r0) {
        return r0.mActivity;
    }

    static /* synthetic */ INetworkStatsSession access$1900(DataUsageFragment r0) {
        return r0.mStatsSession;
    }

    static /* synthetic */ ChartData access$2002(DataUsageFragment r0, ChartData r1) {
        r0.mChartData = r1;
        return r1;
    }

    static /* synthetic */ int access$202(DataUsageFragment r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ NetworkPolicyManager access$2100(DataUsageFragment r0) {
        return r0.mPolicyManager;
    }

    static /* synthetic */ DataUsageAdapter access$2200(DataUsageFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ TextView access$2300(DataUsageFragment r0) {
        return r0.mEmpty;
    }

    static /* synthetic */ DataUsageCycleView access$2400(DataUsageFragment r0) {
        return r0.mDataUsageTotally;
    }

    static /* synthetic */ int access$2500(DataUsageFragment r0) {
        return r0.mSystemFoldedAppCount;
    }

    static /* synthetic */ int access$2502(DataUsageFragment r0, int r1) {
        r0.mSystemFoldedAppCount = r1;
        return r1;
    }

    static /* synthetic */ int access$2508(DataUsageFragment r2) {
        int r0 = r2.mSystemFoldedAppCount;
        r2.mSystemFoldedAppCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ void access$2600(DataUsageFragment r0) {
        r0.updateFooterView();
    }

    static /* synthetic */ List access$2700(ArrayList r0, Context r1) {
        return getNoDataUid(r0, r1);
    }

    static /* synthetic */ SimCardInfo access$2802(DataUsageFragment r0, SimCardInfo r1) {
        r0.mLastSimInfoInDb = r1;
        return r1;
    }

    static /* synthetic */ int access$300(DataUsageFragment r0) {
        return r0.getIndexFromValue();
    }

    static /* synthetic */ void access$400(DataUsageFragment r0) {
        r0.updateDetailData();
    }

    static /* synthetic */ boolean access$500(DataUsageFragment r0) {
        return r0.mIsFromSecurity;
    }

    static /* synthetic */ String[] access$600(DataUsageFragment r0) {
        return r0.mCarrysCodeArray;
    }

    static /* synthetic */ String[] access$602(DataUsageFragment r0, String[] r1) {
        r0.mCarrysCodeArray = r1;
        return r1;
    }

    static /* synthetic */ String[] access$700(DataUsageFragment r0) {
        return r0.mCarrysNameArray;
    }

    static /* synthetic */ String[] access$702(DataUsageFragment r0, String[] r1) {
        r0.mCarrysNameArray = r1;
        return r1;
    }

    static /* synthetic */ int access$800(DataUsageFragment r0) {
        return r0.mCurrentCarryIndex;
    }

    static /* synthetic */ String[] access$900(DataUsageFragment r0) {
        return r0.mBranchsCodeArray;
    }

    static /* synthetic */ String[] access$902(DataUsageFragment r0, String[] r1) {
        r0.mBranchsCodeArray = r1;
        return r1;
    }

    public void com_android_settings_DataUsageFragment__onCreate$___twin___(Bundle r19) {
        super.onCreate(r19);
        this.mActivity = getActivity();
        this.mNetworkService = INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        this.mStatsService = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mPolicyManager = NetworkPolicyManager.from(this.mActivity);
        NetworkPolicyEditor r3 = new NetworkPolicyEditor(this.mPolicyManager);
        this.mPolicyEditor = r3;
        r3.read();
    L7:
        OLog.w(TAG, "No bandwidth control; leaving");
        getActivity().finish();
    L30:
        this.mStatsSession = this.mStatsService.openSession();     // Catch: RemoteException -> L25
        if (this.isTencentSDKEnabled == false) goto L12;
        Intent r1 = new Intent();
        r1.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.datausage.TencentService");
        getActivity().bindService(r1, this.mTencentServiceConnection, 1);
    L12:
        this.mDataUsageCycleTime = this.mActivity.getResources().getStringArray(R.array.data_usage_cycle);
        TypedArray r2 = getResources().obtainTypedArray(R.array.data_usage_cycle);
        this.mDataUsageCycleTimeRes = new int[r2.length()];
        int r4 = 0;
    L14:
        if (r4 >= r2.length()) goto L16;
        this.mDataUsageCycleTimeRes[r4] = r2.getResourceId(r4, -1);
        r4 = r4 + 1;
        goto L14
    L16:
        Intent r5 = this.mActivity.getIntent();
        if (r5.hasExtra("slot") == false) goto L19;
        this.mCurrentSlot = r5.getIntExtra("slot", 0);
    L20:
        OLog.e(TAG, "onCreate(), slot=" + this.mCurrentSlot);
        this.mIsSystemAppUnfolded = this.mActivity.getIntent().getBooleanExtra(ARG_SYSTEM_APP_UNFOLDED, false);
        OLog.d(TAG, "onCreate mIsSystemAppUnfolded " + this.mIsSystemAppUnfolded);
        NetworkTemplate r6 = NetworkTemplate.buildTemplateMobileAll(getActiveSubscriberId());
        this.mTemplate = r6;
        NetworkPolicy r7 = this.mPolicyEditor.getPolicy(r6);
        this.mPolicy = r7;
        if (r7 != null) goto L23;
        Time r8 = new Time();
        r8.setToNow();
        NetworkPolicy r14 = new NetworkPolicy(this.mTemplate, r8.monthDay, r8.timezone, -1, -1, -1, -1, true, true);
        this.mPolicy = r14;
        this.mPolicyEditor.addPolicy(r14);
    L23:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mActivity, this.mReceiver, this.mIntentFilter, 2);
        this.mSettingFragment = this.mActivity.getIntent().getBooleanExtra("hidden_list", false);
        this.uiHandler = new AnonymousClass2(this);
        this.mIsFromSecurity = this.mActivity.getIntent().getBooleanExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r2.recycle();
        return;
    L19:
        this.mCurrentSlot = MultiSimAdapter.getDefaultDataSlot();
    L25:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (this.mNetworkService.isBandwidthControlEnabled() == true) goto L30;
        OLog.w(TAG, "No bandwidth control; leaving");     // Catch: RemoteException -> L7
        getActivity().finish();     // Catch: RemoteException -> L7
        goto L30
    }

    public void com_android_settings_DataUsageFragment__onResume$___twin___() {
        super.onResume();
        updateSimInfoView();
        this.mIsLimitLaunched = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.isTencentSDKEnabled == false) goto L5;
        this.mActivity.unbindService(this.mTencentServiceConnection);
    L5:
        this.mActivity.unregisterReceiver(this.mReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Context r9 = r6.getContext();
        View r10 = r6.inflate(R.layout.data_usage_layout, r7, false);
        this.mUidDetailProvider = new UidDetailProvider(r9);
        this.mListView = (ListView) r10.findViewById(android.R.id.list);
        boolean r11 = this.mActivity.getIntent().getBooleanExtra("hidden_setting", false);
        boolean r0 = this.mActivity.getIntent().getBooleanExtra("hidden_list", false);
        if (r0 == false) goto L5;
        LinearLayout r12 = (LinearLayout) r10.findViewById(R.id.data_usage_header_view);
        this.headView = r12;
        this.mWarningSwitch = (ListContentItemSwitch) r12.findViewById(R.id.data_usage_alarm_stub);
        this.mLimitText = (ListContentItemText) this.headView.findViewById(R.id.data_usage_limit_stub);
        this.mListView.setVisibility(8);
        LinearLayout r13 = (LinearLayout) this.headView.findViewById(R.id.sim_guide_layout_stub);
        this.simGuideView = r13;
        this.mSimGuide = (ImageView) r13.findViewById(R.id.sim_guide_stub);
        this.mWarningSwitch.setOnCheckedChangeListener(this.mWarningCheckChangeListener);
        SettingItemText r14 = (SettingItemText) this.headView.findViewById(R.id.card_info_province);
        this.mProvinceView = r14;
        r14.setOnClickListener(this.mSimInfoChangeListener);
        SettingItemText r15 = (SettingItemText) this.headView.findViewById(R.id.card_info_city);
        this.mCityView = r15;
        r15.setOnClickListener(this.mSimInfoChangeListener);
        SettingItemText r16 = (SettingItemText) this.headView.findViewById(R.id.card_info_carry);
        this.mCarryView = r16;
        r16.setOnClickListener(this.mSimInfoChangeListener);
        SettingItemText r17 = (SettingItemText) this.headView.findViewById(R.id.card_info_branch);
        this.mBranchView = r17;
        r17.setOnClickListener(this.mSimInfoChangeListener);
    L6:
        DataUsageCycleView r18 = this.mDataUsageTotally;
        if (r18 == null) goto L9;
        r18.initView();
        this.mCurrentIndex = getIndexFromValue();
        this.mDataUsageTotally.setCurrentSlot(this.mCurrentSlot);
        this.mDataUsageTotally.setTextViewBackground(this.mCurrentIndex);
        this.mDataUsageTotally.setListener(new AnonymousClass4(this));
    L9:
        this.mLimitText.setOnClickListener(this.mDataLimitChangeListener);
        if (this.mListView.getScrollBarStyle() != 33554432) goto L12;
        boolean r19 = true;
    L13:
        if (r19 == false) goto L15;
        this.mInsetSide = r10.getResources().getDimensionPixelOffset(17106088);
    L17:
        if (this.mIsSystemAppUnfolded == true) goto L20;
        if (r0 == true) goto L21;
        ListView r20 = this.mListView;
        r20.addHeaderView(this.headView, r20, true);
    L21:
        updateFooterView();
        setupSimGuide(this.simGuideView, this.mSimGuide, !this.mIsSystemAppUnfolded);
        this.mEmpty = (TextView) this.headView.findViewById(android.R.id.empty);
        if (r11 == false) goto L24;
        this.mWarningSwitch.setVisibility(8);
        this.mLimitText.setVisibility(8);
        this.mWarningtipView.setVisibility(8);
    L24:
        DataUsageAdapter r21 = new DataUsageAdapter(this, getActivity(), this.mUidDetailProvider, this.mInsetSide);
        this.mAdapter = r21;
        this.mListView.setAdapter(r21);
        setupContainer(this.headView);
        return r10;
    L20:
        this.mListView.addHeaderView(Utils.inflateListTransparentHeader(getActivity()));
        this.mListView.setEmptyView(r10.findViewById(R.id.empty_view));
        goto L21
    L15:
        this.mInsetSide = 0;
        goto L17
    L12:
        r19 = false;
        goto L13
    L5:
        this.headView = (LinearLayout) r6.inflate(R.layout.data_usage_header_bytedance, this.mListView, false);
        r10.findViewById(R.id.data_usage_header_scrollview).setVisibility(8);
        this.mDataUsageTotally = (DataUsageCycleView) this.headView.findViewById(R.id.cycle_view);
        this.mWarningSwitch = (ListContentItemSwitch) this.headView.findViewById(R.id.data_usage_alarm);
        this.mLimitText = (ListContentItemText) this.headView.findViewById(R.id.data_usage_limit);
        LinearLayout r22 = (LinearLayout) this.headView.findViewById(R.id.sim_guide_layout);
        this.simGuideView = r22;
        this.mSimGuide = (ImageView) r22.findViewById(R.id.sim_guide);
        this.mWarningSwitch.setOnCheckedChangeListener(this.mWarningCheckChangeListener);
        this.mWarningtipView = (TextView) this.headView.findViewById(R.id.data_usage_limit_tips);
        goto L6
    }

    private void saveCfgToDB(int r2) {
        Context r0 = getContext();
        if (this.mCurrentSlot != 0) goto L6;
        if (r0 == null) goto L9;
        android.provider.Settings.Global.putInt(r0.getContentResolver(), "data_usage_cycle", r2);
        return;
    L9:
        return;
    L6:
        if (r0 == null) goto L11;
        android.provider.Settings.Global.putInt(r0.getContentResolver(), "data_usage_cycle_sub2", r2);
        return;
    }

    private void setupSimGuide(LinearLayout r2, ImageView r3, boolean r4) {
        if (Utils.hasMultiSimInDevice() == false) goto L11;
        if (r4 == false) goto L12;
        r2.setVisibility(0);
        if (this.mCurrentSlot != 0) goto L8;
        int r1 = R.drawable.sim_card_guide_sim1_fillet;
    L9:
        r3.setBackgroundResource(r1);
        return;
    L8:
        r1 = R.drawable.sim_card_guide_sim2_fillet;
        goto L9
    L12:
        return;
    }

    private void updateSimInfoView() {
        if (this.mSettingFragment == true) goto L5;
        return;
    L5:
        SimCardInfo r0 = getCardInfo();
        if (r0.equals(this.mLastSimInfoInDb) == true) goto L8;
        this.mLastSimInfoInDb = r0;
        this.mProvinceCode = r0.provinceCode;
        this.mCityCode = this.mLastSimInfoInDb.cityCode;
        this.mCarryCode = this.mLastSimInfoInDb.carryCode;
        this.mBranchCode = this.mLastSimInfoInDb.branchCode;
        OLog.d(TAG, "updateSimInfoView as db, mProvinceCode " + this.mProvinceCode + " , mCityCode " + this.mCityCode);
    L10:
        if (TextUtils.isEmpty(this.mProvinceCode) == false) goto L12;
        this.mProvinceView.setSubTitle(R.string.unset);
    L24:
        if (TextUtils.isEmpty(this.mProvinceCode) == false) goto L26;
    L28:
        ArrayList<SMTCodeName> r1 = this.mCitys;
        if (r1 == null) goto L39;
        if (r1.size() <= 0) goto L39;
        Iterator<SMTCodeName> r2 = this.mCitys.iterator();
    L34:
        if (r2.hasNext() == false) goto L39;
        SMTCodeName r3 = r2.next();
        if (this.mCityCode.equals(r3.mCode) == false) goto L34;
        this.mCityName = r3.mName;
    L39:
        if (TextUtils.isEmpty(this.mCityCode) == false) goto L41;
        this.mCityView.setSubTitle(R.string.unset);
    L42:
        boolean r4 = false;
        if (TextUtils.isEmpty(this.mCarryCode) == false) goto L45;
        this.mCarryView.setSubTitle(R.string.unset);
    L58:
        if (TextUtils.isEmpty(this.mCarryCode) == false) goto L60;
    L62:
        ArrayList<SMTCodeName> r5 = this.mBranchs;
        if (r5 == null) goto L77;
        if (r5.size() <= 0) goto L77;
        Iterator<SMTCodeName> r6 = this.mBranchs.iterator();
        int r7 = 0;
    L68:
        if (r6.hasNext() == false) goto L74;
        SMTCodeName r8 = r6.next();
        if (this.mBranchCode.equals(r8.mCode) == true) goto L71;
        r7 = r7 + 1;
        goto L68
    L71:
        this.mBranchName = r8.mName;
        this.mCurrentBranchIndex = r7;
    L74:
        if ("0".equals(this.mBranchCode) == false) goto L77;
        this.mCurrentBranchIndex = 0;
        this.mBranchCode = this.mBranchs.get(0).mCode;
        this.mBranchName = this.mBranchs.get(0).mName;
    L77:
        if (TextUtils.isEmpty(this.mBranchCode) == false) goto L79;
        this.mBranchView.setSubTitle(R.string.unset);
    L80:
        SettingItemText r9 = this.mProvinceView;
        ArrayList<SMTCodeName> r10 = this.mProvinces;
        if (r10 != null) goto L83;
    L85:
        boolean r11 = false;
    L86:
        r9.setEnabled(r11);
        this.mCityView.setEnabled(!TextUtils.isEmpty(this.mProvinceCode));
        SettingItemText r12 = this.mCarryView;
        ArrayList<SMTCodeName> r13 = this.mProvinces;
        if (r13 != null) goto L89;
    L91:
        r12.setEnabled(r4);
        this.mBranchView.setEnabled(!TextUtils.isEmpty(this.mCarryCode));
        return;
    L89:
        if (r13.size() <= 0) goto L91;
        r4 = true;
        goto L91
    L83:
        if (r10.size() <= 0) goto L85;
        r11 = true;
        goto L86
    L79:
        this.mBranchView.setSubTitle(this.mBranchName);
        goto L80
    L60:
        if (this.mTencentService == null) goto L62;
        this.mBranchs = new ArrayList(this.mTencentService.getBrands(this.mCarryCode));     // Catch: RemoteException -> L94
        goto L62
    L45:
        ArrayList<SMTCodeName> r14 = this.mCarrys;
        if (r14 != null) goto L48;
    L56:
        this.mCarryView.setSubTitle(this.mCarryName);
        goto L58
    L48:
        if (r14.size() <= 0) goto L56;
        Iterator<SMTCodeName> r15 = this.mCarrys.iterator();
        int r16 = 0;
    L51:
        if (r15.hasNext() == false) goto L56;
        SMTCodeName r17 = r15.next();
        if (this.mCarryCode.equals(r17.mCode) == true) goto L54;
        r16 = r16 + 1;
        goto L51
    L54:
        String r18 = r17.mName;
        this.mCarryName = r18;
        this.mCarryView.setSubTitle(r18);
        this.mCurrentCarryIndex = r16;
        goto L56
    L41:
        this.mCityView.setSubTitle(this.mCityName);
        goto L42
    L26:
        if (this.mTencentService == null) goto L28;
        this.mCitys = new ArrayList(this.mTencentService.getCities(this.mProvinceCode));     // Catch: RemoteException -> L93
        goto L28
    L12:
        ArrayList<SMTCodeName> r19 = this.mProvinces;
        if (r19 != null) goto L15;
    L22:
        this.mProvinceView.setSubTitle(this.mProvinceName);
        goto L24
    L15:
        if (r19.size() <= 0) goto L22;
        Iterator<SMTCodeName> r20 = this.mProvinces.iterator();
    L18:
        if (r20.hasNext() == false) goto L22;
        SMTCodeName r21 = r20.next();
        if (this.mProvinceCode.equals(r21.mCode) == false) goto L18;
        String r22 = r21.mName;
        this.mProvinceName = r22;
        this.mProvinceView.setSubTitle(r22);
        goto L22
    L8:
        OLog.d(TAG, "no need update sim info");
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.DataUsageFragment$6] */
    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        updateBody();
        new AnonymousClass6(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void updateLimitSubtitle() {
        if (this.mPolicy != null) goto L5;
        return;
    L5:
        if (isAdded() == true) goto L7;
        return;
    L7:
        if (getActivity() != null) goto L10;
        return;
    L10:
        if (DataUsageLimitActivity.getCurrentLimitUnit(getContext().getApplicationContext(), this.mCurrentSlot) != 1) goto L12;
        long r0 = FileUtils.ONE_GB;
        String r2 = " GB";
    L13:
        long r3 = this.mTotalBytesInMonth;
        long r5 = r3 / r0;
        if (r3 > 0) goto L16;
        String r4 = "0";
    L23:
        this.mLimitText.setSubtitle(r4 + r2 + " / " + (this.mPolicy.warningBytes / r0) + r2);
        return;
    L16:
        if ((r3 % r0) != 0) goto L18;
        r4 = String.valueOf(r5);
        goto L23
    L18:
        float r6 = (r3 * 1.0f) / r0;
        float r7 = r5;
        if ((r6 - r7) > 0.01f) goto L21;
        r6 = r7 + 0.01f;
    L21:
        r4 = new DecimalFormat("0.00").format(r6);
        goto L23
    L12:
        r0 = 1048576;
        r2 = " MB";
        goto L13
    }

    private void updateLimitView() {
        NetworkPolicy r0 = this.mPolicy;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.limitBytes == (-1)) goto L8;
        setPolicyLimitBytes(-1);
    L8:
        if (this.mPolicy.warningBytes == (-1)) goto L10;
        updateLimitSubtitle();
    L11:
        this.mWarningSwitch.setChecked(showWarningDialog());
        return;
    L10:
        this.mLimitText.setSubtitle(getString(R.string.data_usage_limit_unset));
        setPolicyWarningBytes(-1);
        goto L11
    }

    private boolean showWarningDialog() {
        if (this.mCurrentSlot != 0) goto L10;
        if (android.provider.Settings.Global.getInt(getActivity().getContentResolver(), SettingsSwitchKeyUtil.DATA_USAGE_WARNING, 0) != 1) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (android.provider.Settings.Global.getInt(getActivity().getContentResolver(), "data_usage_warning_sub2", 0) != 1) goto L13;
        return true;
    L13:
        return false;
    }

    private void setWarningDialogEnabled(boolean r2) {
        if (this.mCurrentSlot != 0) goto L5;
        android.provider.Settings.Global.putInt(getActivity().getContentResolver(), SettingsSwitchKeyUtil.DATA_USAGE_WARNING, r2 ? 1 : 0);
        return;
    L5:
        android.provider.Settings.Global.putInt(getActivity().getContentResolver(), "data_usage_warning_sub2", r2 ? 1 : 0);
    }

    private int getMinListHeight() {
        int r0 = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        int[] r1 = new int[2];
        this.mListView.getLocationOnScreen(r1);
        return r0 - r1[1];
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r7, int r8, Intent r9) {
        super.onActivityResult(r7, r8, r9);
        if (r7 != 2) goto L5;
        if (r8 != (-1)) goto L41;
        if (r9 != null) goto L30;
        return;
    L30:
        if (isAdded() == false) goto L43;
        setPolicyWarningBytes(r9.getLongExtra(INTENT_EXTRA_LIMIT, -1));
        updateLimitView();
        return;
    L43:
        return;
    L41:
        return;
    L5:
        if (r7 != 3) goto L7;
        if (r8 != (-1)) goto L39;
        this.mProvinceCode = r9.getStringExtra("currentCode");
        String r10 = r9.getStringExtra("currentName");
        this.mProvinceName = r10;
        this.mProvinceView.setSubTitle(r10);
        this.mCityCode = "";
        this.mCityName = "";
        OLog.d(TAG, "mProvinceName=" + this.mProvinceName + ",mProvinceCode=" + this.mProvinceCode);
        return;
    L39:
        return;
    L7:
        if (r7 != 4) goto L9;
        if (r8 != (-1)) goto L37;
        this.mCityCode = r9.getStringExtra("currentCode");
        String r11 = r9.getStringExtra("currentName");
        this.mCityName = r11;
        this.mCityView.setSubTitle(r11);
        OLog.d(TAG, "mCityName=" + this.mCityName + ",CityCode=" + this.mCityCode);
        saveCardInfo(this.mProvinceCode, this.mCityCode, this.mCarryCode, this.mBranchCode);
        return;
    L37:
        return;
    L9:
        if (r7 != 5) goto L11;
        if (r8 != (-1)) goto L35;
        int r12 = r9.getIntExtra("extra_index", 0);
        this.mCurrentCarryIndex = r12;
        if (r12 < 0) goto L22;
        this.mCarryCode = this.mCarrysCodeArray[r12];
        this.mCarryName = this.mCarrysNameArray[r12];
    L22:
        this.mCurrentBranchIndex = -1;
        this.mBranchCode = "";
        this.mBranchName = "";
        this.mCarryView.setSubTitle(this.mCarryName);
        OLog.d(TAG, "CarryCode=" + this.mCarryCode + ",mCarryName=" + this.mCarryName);
        return;
    L35:
        return;
    L11:
        if (r7 != 6) goto L44;
        if (r8 != (-1)) goto L33;
        int r13 = r9.getIntExtra("extra_index", 0);
        this.mCurrentBranchIndex = r13;
        if (r13 < 0) goto L17;
        this.mBranchCode = this.mBranchsCodeArray[r13];
        this.mBranchName = this.mBranchsNameArray[r13];
    L17:
        this.mBranchView.setSubTitle(this.mBranchName);
        OLog.d(TAG, "branchCode=" + this.mBranchCode + ",mBranchName=" + this.mBranchName);
        saveCardInfo(this.mProvinceCode, this.mCityCode, this.mCarryCode, this.mBranchCode);
        return;
    L33:
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
        if (this.mSystemAppFooter != null) goto L6;
        View r0 = LayoutInflater.from(getContext()).inflate(R.layout.datausage_list_footer_view, null);
        this.mSystemAppFooter = r0;
        ((ListContentItemText) r0.findViewById(R.id.system_app)).setOnClickListener(new AnonymousClass9(this));
    L6:
        return this.mSystemAppFooter;
    }

    private View getBottomGapFooter() {
        if (this.mBottomGapFooter != null) goto L6;
        this.mBottomGapFooter = Utils.inflateListTransparentHeader(getActivity());
    L6:
        return this.mBottomGapFooter;
    }

    private View initListTransparentHeaderView() {
        ImageView r0 = new ImageView(getActivity());
        r0.setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin)));
        r0.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        return r0;
    }

    private void updateBody() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        LoaderManager.getInstance((BaseActivity) getActivity()).restartLoader(2, ChartDataLoader.buildArgs(this.mTemplate, null), this.mChartDataCallbacks);
    }

    private void updateDetailData() {
        if (this.mCurrentIndex != (-1)) goto L5;
        this.mCurrentIndex = 1;
    L5:
        NtpTrustedTime r1 = NtpTrustedTime.getInstance(getActivity());
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
        LoaderManager.getInstance((BaseActivity) getActivity()).restartLoader(3, SummaryForAllUidLoader.buildArgs(this.mTemplate, r6, r2), this.mSummaryCallbacks);
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

    public void setPolicyLimitBytes(long r2) {
        this.mPolicyEditor.setPolicyLimitBytes(this.mTemplate, r2);
    }

    public void setPolicyWarningBytes(long r2) {
        this.mPolicyEditor.setPolicyWarningBytes(this.mTemplate, r2);
    }

    private String getActiveSubscriberId(Context r1) {
        return SystemProperties.get(TEST_SUBSCRIBER_PROP, TelephonyManager.from(r1).getSubscriberId());
    }

    private String getActiveSubscriberId() {
        String r0 = TelephonyManager.getDefault().getSubscriberId(MultiSimAdapter.slot2Sub(this.mCurrentSlot));
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getLastSubscriberId();
    }

    private String getLastSubscriberId() {
        TelephonyManager r0 = (TelephonyManager) getActivity().getSystemService(MultiSimAdapter.PHONE_KEY);
        return TelephonyManager.getTelephonyProperty(this.mCurrentSlot, LAST_SUBSCRIBER_PROP, null);
    }

    static {
        StringBuilder r0 = new StringBuilder(50);
        sBuilder = r0;
        sFormatter = new Formatter(r0, Locale.getDefault());
        CONTENT_URI_SIMINFO = Uri.parse("content://com.bytedanceos.tencent/siminfo");
        SIMINFO_PROJECTION = new String[]{"provinceId", "cityId", "carryId", "brandId"};
    }

    public static String formatDateRange(Context r10, long r11, long r13) {
        StringBuilder r0 = sBuilder;
        monitor-enter(r0);
        r0.setLength(0);     // Catch: Throwable -> L8
        String r12 = DateUtils.formatDateRange(r10, sFormatter, r11, r13, 65552, null).toString();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    private static List<Integer> getInternetAppInfos(Context r8) {
        PackageManager r9 = r8.getPackageManager();
        List<PackageInfo> r1 = r9.getInstalledPackages(4096);
        r1.addAll(r9.getInstalledPackagesAsUser(4096, 10));
        ArrayList r10 = new ArrayList();
        Iterator<PackageInfo> r0 = r1.iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        PackageInfo r2 = r0.next();
        String[] r3 = r2.requestedPermissions;
        if (r3 == null) goto L4;
        int r4 = r3.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L4;
        if (r3[r5].equals("android.permission.INTERNET") == false) goto L16;
        ApplicationInfo r6 = r2.applicationInfo;
        int r7 = r6.uid;
        if ((r6.flags & 1) != 0) goto L16;
        if (UserHandle.isApp(r6.uid) == false) goto L16;
        r10.add(Integer.valueOf(r7));
    L16:
        r5 = r5 + 1;
        goto L8
    L17:
        return r10;
    }

    private static List<Integer> getNoDataUid(ArrayList<AppItem> r2, Context r3) {
        List<Integer> r4 = getInternetAppInfos(r3);
        ArrayList r0 = new ArrayList();
        Iterator<AppItem> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(Integer.valueOf(r5.next().key));
        goto L4
    L6:
        r4.removeAll(r0);
        return r4;
    }

    private int getIndexFromValue() {
        if (this.mCurrentSlot != 0) goto L5;
        String r0 = android.provider.Settings.Global.getString(this.mActivity.getContentResolver(), "data_usage_cycle");
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
        r0 = android.provider.Settings.Global.getString(this.mActivity.getContentResolver(), "data_usage_cycle_sub2");
        goto L6
    }

    public SimCardInfo getCardInfo() {
        SimCardInfo r1 = new SimCardInfo();
        String r2 = getDeviceIMSI();
        if (TextUtils.isEmpty(r2) == true) goto L20;
        Cursor r3 = null;
        r3 = getActivity().getContentResolver().query(CONTENT_URI_SIMINFO, SIMINFO_PROJECTION, "card_imsi = ?", new String[]{r2}, null);     // Catch: Throwable -> L12 SQLiteException -> L14
        if (r3 != null) goto L8;
    L10:
        if (r3 == null) goto L20;
    L16:
        r3.close();
        goto L20
    L8:
        if (r3.getCount() <= 0) goto L10;
        OLog.d(TAG, "getCardInfo from db");     // Catch: Throwable -> L12 SQLiteException -> L14
        r3.moveToFirst();     // Catch: Throwable -> L12 SQLiteException -> L14
        String[] r4 = new String[4];     // Catch: Throwable -> L12 SQLiteException -> L14
        r1.provinceCode = r3.getString(0);     // Catch: Throwable -> L12 SQLiteException -> L14
        r1.cityCode = r3.getString(1);     // Catch: Throwable -> L12 SQLiteException -> L14
        r1.carryCode = r3.getString(2);     // Catch: Throwable -> L12 SQLiteException -> L14
        r1.branchCode = r3.getString(3);     // Catch: Throwable -> L12 SQLiteException -> L14
    L12:
        th = move-exception;
        if (r3 == null) goto L19;
        r3.close();
    L19:
        throw th;
    L14:
        OLog.d(TAG, "query sim info error");     // Catch: Throwable -> L12
        if (r3 != null) goto L16;
    L20:
        return r1;
    }

    public String getDeviceIMSI() {
        return TelephonyManager.getDefault().getSubscriberId(MultiSimAdapter.slot2Sub(this.mCurrentSlot));
    }

    public void saveCardInfo(final String r8, final String r9, final String r10, final String r11) {
        if (TextUtils.isEmpty(getDeviceIMSI()) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r9) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r10) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r11) == true) goto L19;
        ExecutorManager.execute(new AnonymousClass12(this, r8, r9, r10, r11));
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DataUsageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DataUsageFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DataUsageFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DataUsageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DataUsageFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DataUsageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DataUsageFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DataUsageFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DataUsageFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
