package com.android.settings;

import android.animation.LayoutTransition;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkStats;
import android.net.NetworkStatsHistory;
import android.net.NetworkTemplate;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.INetworkManagementService;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.loader.app.LoaderManager;
import com.android.internal.util.Preconditions;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.drawable.InsetBoundsDrawable;
import com.android.settings.net.ChartData;
import com.android.settings.net.SummaryForAllUidLoader;
import com.android.settings.net.UidDetail;
import com.android.settings.net.UidDetailProvider;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.ChartDataUsageView;
import com.android.settings.widget.ChartNetworkSeriesView;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.NetworkPolicyEditor;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageSummary extends HighlightingFragment {
    private static final String DATA_USAGE_CYCLE_KEY = "data_usage_cycle";
    private static final String DATA_USAGE_DISABLE_MOBILE_LIMIT_KEY = "data_usage_disable_mobile_limit";
    private static final String DATA_USAGE_ENABLE_MOBILE_KEY = "data_usage_enable_mobile";
    public static final String EXTRA_SHOW_APP_IMMEDIATE_PKG = "showAppImmediatePkg";
    private static final int LOADER_CHART_DATA = 2;
    private static final int LOADER_SUMMARY = 3;
    private static final boolean LOGD = false;
    private static final String PREF_FILE = "data_usage";
    private static final String PREF_SHOW_ETHERNET = "show_ethernet";
    private static final String PREF_SHOW_WIFI = "show_wifi";
    private static final String TAB_3G = "3g";
    private static final String TAB_4G = "4g";
    private static final String TAB_ETHERNET = "ethernet";
    private static final String TAB_MOBILE = "mobile";
    private static final String TAB_WIFI = "wifi";
    private static final String TAG = "DataUsage";
    private static final String TAG_APP_DETAILS = "appDetails";
    private static final String TAG_CONFIRM_APP_RESTRICT = "confirmAppRestrict";
    private static final String TAG_CONFIRM_DATA_DISABLE = "confirmDataDisable";
    private static final String TAG_CONFIRM_LIMIT = "confirmLimit";
    private static final String TAG_CONFIRM_RESTRICT = "confirmRestrict";
    private static final String TAG_CYCLE_EDITOR = "cycleEditor";
    private static final String TAG_DENIED_RESTRICT = "deniedRestrict";
    private static final String TAG_LIMIT_EDITOR = "limitEditor";
    private static final String TAG_WARNING_EDITOR = "warningEditor";
    private static final boolean TEST_ANIM = false;
    private static final boolean TEST_RADIOS = false;
    private static final String TEST_RADIOS_PROP = "test.radios";
    private static final String TEST_SUBSCRIBER_PROP = "test.subscriberid";
    private static final StringBuilder sBuilder = null;
    private static final Formatter sFormatter = null;
    private DataUsageAdapter mAdapter;
    private TextView mAppBackground;
    private View mAppDetail;
    private TextView mAppForeground;
    private ImageView mAppIcon;
    private Switch mAppRestrict;
    private View.OnClickListener mAppRestrictListener;
    private View mAppRestrictView;
    private Button mAppSettings;
    private Intent mAppSettingsIntent;
    private LinearLayout mAppSwitches;
    private ViewGroup mAppTitles;
    private TextView mAppTotal;
    private boolean mBinding;
    private ChartDataUsageView mChart;
    private ChartData mChartData;
    private final LoaderManager.LoaderCallbacks<ChartData> mChartDataCallbacks;
    private ChartDataUsageView.DataUsageChartListener mChartListener;
    private AppItem mCurrentApp;
    private String mCurrentTab;
    private CycleAdapter mCycleAdapter;
    private AdapterView.OnItemSelectedListener mCycleListener;
    private Spinner mCycleSpinner;
    private TextView mCycleSummary;
    private View mCycleView;
    private Switch mDataEnabled;
    private View.OnClickListener mDataEnabledListener;
    private boolean mDataEnabledSupported;
    private View mDataEnabledView;
    private ChartNetworkSeriesView mDetailedSeries;
    private Switch mDisableAtLimit;
    private View.OnClickListener mDisableAtLimitListener;
    private boolean mDisableAtLimitSupported;
    private View mDisableAtLimitView;
    private View mDisclaimer;
    private TextView mEmpty;
    private TabHost.TabContentFactory mEmptyTabContent;
    private ViewGroup mHeader;
    private int mInsetSide;
    private String mIntentTab;
    private AdapterView.OnItemClickListener mListListener;
    private ListView mListView;
    private MenuItem mMenuCellularNetworks;
    private MenuItem mMenuRestrictBackground;
    private MenuItem mMenuShowEthernet;
    private MenuItem mMenuShowWifi;
    private MenuItem mMenuSimCards;
    private final Map<String, Boolean> mMobileDataEnabled;
    private Map<Integer, String> mMobileTagMap;
    private INetworkManagementService mNetworkService;
    private LinearLayout mNetworkSwitches;
    private ViewGroup mNetworkSwitchesContainer;
    private NetworkPolicyEditor mPolicyEditor;
    private NetworkPolicyManager mPolicyManager;
    private SharedPreferences mPrefs;
    private ChartNetworkSeriesView mSeries;
    private String mShowAppImmediatePkg;
    private boolean mShowEthernet;
    private boolean mShowWifi;
    private INetworkStatsService mStatsService;
    private INetworkStatsSession mStatsSession;
    private View mStupidPadding;
    private List<SubscriptionInfo> mSubInfoList;
    private SubscriptionManager mSubscriptionManager;
    private final LoaderManager.LoaderCallbacks<NetworkStats> mSummaryCallbacks;
    private TabHost mTabHost;
    private TabHost.OnTabChangeListener mTabListener;
    private TabWidget mTabWidget;
    private ViewGroup mTabsContainer;
    private TelephonyManager mTelephonyManager;
    private NetworkTemplate mTemplate;
    private UidDetailProvider mUidDetailProvider;

    public static class AppDetailsFragment extends Fragment {
        private static final String EXTRA_APP = "app";

        public void com_android_settings_DataUsageSummary$AppDetailsFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$AppDetailsFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$AppDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$AppDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public AppDetailsFragment() {
        }

        public static void show(DataUsageSummary r1, AppItem r2, CharSequence r3) {
            show(r1, r2, r3, true);
        }

        public static void show(DataUsageSummary r1, AppItem r2, CharSequence r3, boolean r4) {
            if (r1.isAdded() == true) goto L5;
            return;
        L5:
            Bundle r5 = new Bundle();
            r5.putParcelable("app", r2);
            AppDetailsFragment r6 = new AppDetailsFragment();
            r6.setArguments(r5);
            r6.setTargetFragment(r1, 0);
            FragmentTransaction r7 = r1.getParentFragmentManager().beginTransaction();
            r7.add(r6, DataUsageSummary.TAG_APP_DETAILS);
            if (r4 == false) goto L8;
            r7.addToBackStack(DataUsageSummary.TAG_APP_DETAILS);
        L8:
            r7.setBreadCrumbTitle(r1.getResources().getString(R.string.data_usage_app_summary_title));
            r7.commitAllowingStateLoss();
        }

        @Override // androidx.fragment.app.Fragment
        public void onStart() {
            super.onStart();
            DataUsageSummary r0 = (DataUsageSummary) getTargetFragment();
            DataUsageSummary.access$2902(r0, (AppItem) getArguments().getParcelable("app"));
            DataUsageSummary.access$100(r0);
        }

        @Override // androidx.fragment.app.Fragment
        public void onStop() {
            super.onStop();
            DataUsageSummary r1 = (DataUsageSummary) getTargetFragment();
            DataUsageSummary.access$2902(r1, null);
            DataUsageSummary.access$100(r1);
        }

        @Override // androidx.fragment.app.Fragment
        public boolean onOptionsItemSelected(MenuItem r3) {
            if (r3.getItemId() != 16908332) goto L5;
            getParentFragmentManager().popBackStack();
            return true;
        L5:
            return super.onOptionsItemSelected(r3);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$AppDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppDetailsFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$AppDetailsFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$AppDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppDetailsFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$AppDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$AppDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppDetailsFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$AppDetailsFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class AppItem implements Comparable<AppItem>, Parcelable {
        public static final int CATEGORY_APP = 2;
        public static final int CATEGORY_APP_TITLE = 1;
        public static final int CATEGORY_USER = 0;
        public static final Parcelable.Creator<AppItem> CREATOR = null;
        public int category;
        public final int key;
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

        public AppItem() {
            this.uids = new SparseBooleanArray();
            this.key = 0;
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
        }

        public void addUid(int r2) {
            this.uids.put(r2, true);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeInt(this.key);
            r3.writeSparseBooleanArray(this.uids);
            r3.writeLong(this.total);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(AppItem r3) {
            int r0 = Integer.compare(this.category, r3.category);
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return Long.compare(r3.total, this.total);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public static class ConfirmAppRestrictFragment extends DialogFragment {
        public void com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ConfirmAppRestrictFragment() {
        }

        public static void show(DataUsageSummary r2) {
            if (r2.isAdded() == true) goto L5;
            return;
        L5:
            ConfirmAppRestrictFragment r0 = new ConfirmAppRestrictFragment();
            r0.setTargetFragment(r2, 0);
            r0.show(r2.getParentFragmentManager(), DataUsageSummary.TAG_CONFIRM_APP_RESTRICT);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r2) {
            AlertDialog.Builder r0 = new AlertDialog.Builder(getActivity());
            r0.setTitle(R.string.data_usage_app_restrict_dialog_title);
            r0.setMessage(R.string.data_usage_app_restrict_dialog);
            r0.setPositiveButton(android.R.string.ok, new AnonymousClass1(this));
            r0.setNegativeButton(android.R.string.cancel, null);
            return r0.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmAppRestrictFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmAppRestrictFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmAppRestrictFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$ConfirmAppRestrictFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class ConfirmDataDisableFragment extends DialogFragment {
        static int mSubId;

        public void com_android_settings_DataUsageSummary$ConfirmDataDisableFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$ConfirmDataDisableFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$ConfirmDataDisableFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$ConfirmDataDisableFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ConfirmDataDisableFragment() {
        }

        public static void show(DataUsageSummary r1, int r2) {
            mSubId = r2;
            if (r1.isAdded() == true) goto L5;
            return;
        L5:
            ConfirmDataDisableFragment r3 = new ConfirmDataDisableFragment();
            r3.setTargetFragment(r1, 0);
            r3.show(r1.getParentFragmentManager(), DataUsageSummary.TAG_CONFIRM_DATA_DISABLE);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r2) {
            AlertDialog.Builder r0 = new AlertDialog.Builder(getActivity());
            r0.setMessage(R.string.data_usage_disable_mobile);
            r0.setPositiveButton(android.R.string.ok, new AnonymousClass1(this));
            r0.setNegativeButton(android.R.string.cancel, null);
            return r0.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$ConfirmDataDisableFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmDataDisableFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$ConfirmDataDisableFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$ConfirmDataDisableFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmDataDisableFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$ConfirmDataDisableFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$ConfirmDataDisableFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmDataDisableFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$ConfirmDataDisableFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class ConfirmLimitFragment extends DialogFragment {
        private static final String EXTRA_LIMIT_BYTES = "limitBytes";
        private static final String EXTRA_MESSAGE = "message";

        public void com_android_settings_DataUsageSummary$ConfirmLimitFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$ConfirmLimitFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$ConfirmLimitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$ConfirmLimitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ConfirmLimitFragment() {
        }

        public static void show(DataUsageSummary r8) {
            if (r8.isAdded() == true) goto L5;
            return;
        L5:
            NetworkPolicy r0 = DataUsageSummary.access$3100(r8).getPolicy(DataUsageSummary.access$3000(r8));
            if (r0 != null) goto L8;
            return;
        L8:
            Resources r1 = r8.getResources();
            long r2 = (long) (r0.warningBytes * 1.2f);
            String r3 = DataUsageSummary.access$600(r8);
            if (DataUsageSummary.TAB_3G.equals(r3) == false) goto L12;
            String r4 = r1.getString(R.string.data_usage_limit_dialog_mobile);
            long r5 = Math.max(5368709120L, r2);
        L17:
            Bundle r6 = new Bundle();
            r6.putCharSequence("message", r4);
            r6.putLong(EXTRA_LIMIT_BYTES, r5);
            ConfirmLimitFragment r7 = new ConfirmLimitFragment();
            r7.setArguments(r6);
            r7.setTargetFragment(r8, 0);
            r7.show(r8.getParentFragmentManager(), DataUsageSummary.TAG_CONFIRM_LIMIT);
            return;
        L12:
            if (DataUsageSummary.TAB_4G.equals(r3) == false) goto L15;
            r4 = r1.getString(R.string.data_usage_limit_dialog_mobile);
            r5 = Math.max(5368709120L, r2);
            goto L17
        L15:
            if (DataUsageSummary.access$700(r3) == false) goto L20;
            r4 = r1.getString(R.string.data_usage_limit_dialog_mobile);
            r5 = Math.max(5368709120L, r2);
            goto L17
        L20:
            throw new IllegalArgumentException("unknown current tab: " + r3);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r5) {
            FragmentActivity r6 = getActivity();
            CharSequence r0 = getArguments().getCharSequence("message");
            final long r1 = getArguments().getLong(EXTRA_LIMIT_BYTES);
            AlertDialog.Builder r3 = new AlertDialog.Builder(r6);
            r3.setTitle(R.string.data_usage_limit_dialog_title);
            r3.setMessage(r0);
            r3.setPositiveButton(android.R.string.ok, new AnonymousClass1(this, r1));
            return r3.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$ConfirmLimitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmLimitFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$ConfirmLimitFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$ConfirmLimitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmLimitFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$ConfirmLimitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$ConfirmLimitFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmLimitFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$ConfirmLimitFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class ConfirmRestrictFragment extends DialogFragment {
        public void com_android_settings_DataUsageSummary$ConfirmRestrictFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$ConfirmRestrictFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$ConfirmRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$ConfirmRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ConfirmRestrictFragment() {
        }

        public static void show(DataUsageSummary r2) {
            if (r2.isAdded() == true) goto L5;
            return;
        L5:
            ConfirmRestrictFragment r0 = new ConfirmRestrictFragment();
            r0.setTargetFragment(r2, 0);
            r0.show(r2.getParentFragmentManager(), DataUsageSummary.TAG_CONFIRM_RESTRICT);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            FragmentActivity r4 = getActivity();
            AlertDialog.Builder r0 = new AlertDialog.Builder(r4);
            r0.setTitle(R.string.data_usage_restrict_background_title);
            if (Utils.hasMultipleUsers(r4) == false) goto L5;
            r0.setMessage(R.string.data_usage_restrict_background_multiuser);
        L6:
            r0.setPositiveButton(android.R.string.ok, new AnonymousClass1(this));
            r0.setNegativeButton(android.R.string.cancel, null);
            return r0.create();
        L5:
            r0.setMessage(R.string.data_usage_restrict_background);
            goto L6
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$ConfirmRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfirmRestrictFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$ConfirmRestrictFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$ConfirmRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfirmRestrictFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$ConfirmRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$ConfirmRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfirmRestrictFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$ConfirmRestrictFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class CycleAdapter extends ArrayAdapter<CycleItem> {
        private final CycleChangeItem mChangeItem;
        private boolean mChangePossible;
        private boolean mChangeVisible;

        public CycleAdapter(Context r2) {
            super(r2, R.layout.data_usage_cycle_item);
            this.mChangePossible = false;
            this.mChangeVisible = false;
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

    public static class CycleEditorFragment extends DialogFragment {
        private static final String EXTRA_TEMPLATE = "template";

        public void com_android_settings_DataUsageSummary$CycleEditorFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$CycleEditorFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$CycleEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$CycleEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public CycleEditorFragment() {
        }

        public static void show(DataUsageSummary r3) {
            if (r3.isAdded() == true) goto L5;
            return;
        L5:
            Bundle r0 = new Bundle();
            r0.putParcelable(EXTRA_TEMPLATE, DataUsageSummary.access$3000(r3));
            CycleEditorFragment r1 = new CycleEditorFragment();
            r1.setArguments(r0);
            r1.setTargetFragment(r3, 0);
            r1.show(r3.getParentFragmentManager(), DataUsageSummary.TAG_CYCLE_EDITOR);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r7) {
            FragmentActivity r8 = getActivity();
            final DataUsageSummary r0 = (DataUsageSummary) getTargetFragment();
            DataUsageSummary.access$3100(r0);
            AlertDialog.Builder r1 = new AlertDialog.Builder(r8);
            View r9 = LayoutInflater.from(r1.getContext()).inflate(R.layout.data_usage_cycle_editor, null, false);
            final NumberPicker r2 = (NumberPicker) r9.findViewById(R.id.cycle_day);
            NetworkTemplate r3 = getArguments().getParcelable(EXTRA_TEMPLATE);
            r2.setMinValue(1);
            r2.setMaxValue(31);
            r2.setValue(0);
            r2.setWrapSelectorWheel(true);
            r1.setTitle(R.string.data_usage_cycle_editor_title);
            r1.setView(r9);
            r1.setPositiveButton(R.string.data_usage_cycle_editor_positive, new AnonymousClass1(this, r2, r0));
            return r1.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$CycleEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CycleEditorFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$CycleEditorFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$CycleEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CycleEditorFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$CycleEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$CycleEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CycleEditorFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$CycleEditorFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
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
            this.label = DataUsageSummary.formatDateRange(r1, r2, r4);
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

    public static class DataUsageAdapter extends BaseAdapter {
        private final int mInsetSide;
        private ArrayList<AppItem> mItems;
        private long mLargest;
        private final UidDetailProvider mProvider;
        private final UserManager mUm;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        public DataUsageAdapter(UserManager r2, UidDetailProvider r3, int r4) {
            this.mItems = Lists.newArrayList();
            this.mProvider = (UidDetailProvider) Preconditions.checkNotNull(r3);
            this.mInsetSide = r4;
            this.mUm = r2;
        }

        public void bindStats(NetworkStats r13, int[] r14) {
            this.mItems.clear();
            this.mLargest = 0;
            int r0 = ActivityManager.getCurrentUser();
            List<UserHandle> r1 = this.mUm.getUserProfiles();
            SparseArray<AppItem> r2 = new SparseArray();
            int r3 = 0;
            if (r13 == null) goto L5;
            int r4 = r13.size();
        L6:
            NetworkStats.Entry r5 = null;
            int r6 = 0;
        L7:
            if (r6 >= r4) goto L24;
            r5 = r13.getValues(r6, r5);
            int r7 = r5.uid;
            int r8 = UserHandle.getUserId(r7);
            int r11 = 2;
            if (UserHandle.isApp(r7) == true) goto L11;
            if (r7 == (-4)) goto L23;
            if (r7 == (-5)) goto L23;
            r7 = 1000;
        L23:
            accumulate(r7, r2, r5, r11);
            r6 = r6 + 1;
            goto L7
        L11:
            if (r1.contains(new UserHandle(r8)) == false) goto L15;
            if (r8 == r0) goto L23;
            accumulate(UidDetailProvider.buildKeyForUser(r8), r2, r5, 0);
            goto L23
        L15:
            if (this.mUm.getUserInfo(r8) != null) goto L17;
            r7 = -4;
            goto L23
        L17:
            r7 = UidDetailProvider.buildKeyForUser(r8);
            r11 = 0;
            goto L23
        L24:
            int r15 = r14.length;
        L26:
            if (r3 >= r15) goto L36;
            int r9 = r14[r3];
            if (r1.contains(new UserHandle(UserHandle.getUserId(r9))) == false) goto L34;
            AppItem r10 = r2.get(r9);
            if (r10 != null) goto L33;
            r10 = new AppItem(r9);
            r10.total = -1;
            this.mItems.add(r10);
            r2.put(r10.key, r10);
        L33:
            r10.restricted = true;
        L34:
            r3 = r3 + 1;
            goto L26
        L36:
            if (this.mItems.isEmpty() == true) goto L38;
            AppItem r16 = new AppItem();
            r16.category = 1;
            this.mItems.add(r16);
        L38:
            Collections.sort(this.mItems);
            notifyDataSetChanged();
            return;
        L5:
            r4 = 0;
            goto L6
        }

        private void accumulate(int r5, SparseArray<AppItem> r6, NetworkStats.Entry r7, int r8) {
            int r0 = r7.uid;
            AppItem r1 = r6.get(r5);
            if (r1 != null) goto L5;
            r1 = new AppItem(r5);
            r1.category = r8;
            this.mItems.add(r1);
            r6.put(r1.key, r1);
        L5:
            r1.addUid(r0);
            r1.total += r7.rxBytes + r7.txBytes;
            if (this.mLargest >= r1.total) goto L9;
            this.mLargest = r1.total;
            return;
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

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            if (this.mItems.get(r1).category != 1) goto L5;
            return 1;
        L5:
            return 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r2) {
            if (r2 > this.mItems.size()) goto L10;
            if (getItemViewType(r2) != 0) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new ArrayIndexOutOfBoundsException();
        }

        @Override // android.widget.Adapter
        public View getView(int r9, View r10, ViewGroup r11) {
            AppItem r0 = this.mItems.get(r9);
            LayoutInflater r1 = LayoutInflater.from(r11.getContext());
            if (getItemViewType(r9) != 1) goto L7;
            if (r10 != null) goto L6;
            r10 = Utils.inflateCategoryHeader(r1, r11);
        L6:
            ((TextView) r10.findViewById(android.R.id.title)).setText(R.string.data_usage_app);
        L22:
            return r10;
        L7:
            int r12 = 0;
            if (r10 != null) goto L12;
            r10 = r1.inflate(R.layout.data_usage_item, r11, false);
            r1.inflate(R.layout.widget_progress_bar, (ViewGroup) r10.findViewById(android.R.id.widget_frame));
            int r2 = this.mInsetSide;
            if (r2 <= 0) goto L12;
            r10.setPaddingRelative(r2, 0, r2, 0);
        L12:
            Context r13 = r11.getContext();
            TextView r3 = (TextView) r10.findViewById(android.R.id.summary);
            ProgressBar r4 = (ProgressBar) r10.findViewById(android.R.id.progress);
            UidDetailTask.bindView(this.mProvider, r0, r10);
            if (r0.restricted == true) goto L15;
        L17:
            r3.setText(android.text.format.Formatter.formatFileSize(r13, r0.total).replace('k', 'K'));
            r4.setVisibility(0);
        L19:
            if (this.mLargest == 0) goto L21;
            r12 = (int) ((r0.total * 100) / this.mLargest);
        L21:
            r4.setProgress(r12);
            goto L22
        L15:
            if (r0.total > 0) goto L17;
            r3.setText(R.string.data_usage_app_restricted);
            r4.setVisibility(8);
            goto L19
        }
    }

    public static class DeniedRestrictFragment extends DialogFragment {
        public void com_android_settings_DataUsageSummary$DeniedRestrictFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$DeniedRestrictFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$DeniedRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$DeniedRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public DeniedRestrictFragment() {
        }

        public static void show(DataUsageSummary r2) {
            if (r2.isAdded() == true) goto L5;
            return;
        L5:
            DeniedRestrictFragment r0 = new DeniedRestrictFragment();
            r0.setTargetFragment(r2, 0);
            r0.show(r2.getParentFragmentManager(), DataUsageSummary.TAG_DENIED_RESTRICT);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r2) {
            AlertDialog.Builder r3 = new AlertDialog.Builder(getActivity());
            r3.setTitle(R.string.data_usage_app_restrict_background);
            r3.setMessage(R.string.data_usage_restrict_denied_dialog);
            r3.setPositiveButton(android.R.string.ok, null);
            return r3.create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$DeniedRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DeniedRestrictFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$DeniedRestrictFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$DeniedRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DeniedRestrictFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$DeniedRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$DeniedRestrictFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DeniedRestrictFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$DeniedRestrictFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static class LimitEditorFragment extends DialogFragment {
        private static final String EXTRA_TEMPLATE = "template";

        public void com_android_settings_DataUsageSummary$LimitEditorFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$LimitEditorFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$LimitEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$LimitEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public LimitEditorFragment() {
        }

        public static void show(DataUsageSummary r3) {
            if (r3.isAdded() == true) goto L5;
            return;
        L5:
            Bundle r0 = new Bundle();
            r0.putParcelable(EXTRA_TEMPLATE, DataUsageSummary.access$3000(r3));
            LimitEditorFragment r1 = new LimitEditorFragment();
            r1.setArguments(r0);
            r1.setTargetFragment(r3, 0);
            r1.show(r3.getParentFragmentManager(), DataUsageSummary.TAG_LIMIT_EDITOR);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r17) {
            FragmentActivity r0 = getActivity();
            final DataUsageSummary r7 = (DataUsageSummary) getTargetFragment();
            final NetworkPolicyEditor r5 = DataUsageSummary.access$3100(r7);
            AlertDialog.Builder r1 = new AlertDialog.Builder(r0);
            View r2 = LayoutInflater.from(r1.getContext()).inflate(R.layout.data_usage_bytes_editor, null, false);
            final NumberPicker r6 = (NumberPicker) r2.findViewById(R.id.bytes);
            final NetworkTemplate r8 = (NetworkTemplate) getArguments().getParcelable(EXTRA_TEMPLATE);
            long r3 = r5.getPolicyWarningBytes(r8);
            long r9 = r5.getPolicyLimitBytes(r8);
            r6.setMaxValue(Integer.MAX_VALUE);
            if (r3 != (-1)) goto L5;
        L7:
            r6.setMinValue(0);
        L8:
            r6.setValue((int) (r9 / 1048576));
            r6.setWrapSelectorWheel(false);
            r1.setTitle(R.string.data_usage_limit_editor_title);
            r1.setView(r2);
            r1.setPositiveButton(R.string.data_usage_cycle_editor_positive, new AnonymousClass1(this, r6, r5, r8, r7));
            return r1.create();
        L5:
            if (r9 <= 0) goto L7;
            r6.setMinValue(((int) (r3 / 1048576)) + 1);
            goto L8
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$LimitEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LimitEditorFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$LimitEditorFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$LimitEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LimitEditorFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$LimitEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$LimitEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LimitEditorFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$LimitEditorFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    private static class UidDetailTask extends AsyncTask<Void, Void, UidDetail> {
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

        private static void bindView(UidDetail r2, View r3) {
            ImageView r0 = (ImageView) r3.findViewById(android.R.id.icon);
            TextView r4 = (TextView) r3.findViewById(android.R.id.title);
            if (r2 == null) goto L5;
            r0.setImageDrawable(r2.icon);
            r4.setText(r2.label);
            r4.setContentDescription(r2.contentDescription);
            return;
        L5:
            r0.setImageDrawable(null);
            r4.setText(null);
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

    public static class WarningEditorFragment extends DialogFragment {
        private static final String EXTRA_TEMPLATE = "template";

        public void com_android_settings_DataUsageSummary$WarningEditorFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_DataUsageSummary$WarningEditorFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_DataUsageSummary$WarningEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_DataUsageSummary$WarningEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public WarningEditorFragment() {
        }

        public static void show(DataUsageSummary r3) {
            if (r3.isAdded() == true) goto L5;
            return;
        L5:
            Bundle r0 = new Bundle();
            r0.putParcelable(EXTRA_TEMPLATE, DataUsageSummary.access$3000(r3));
            WarningEditorFragment r1 = new WarningEditorFragment();
            r1.setArguments(r0);
            r1.setTargetFragment(r3, 0);
            r1.show(r3.getParentFragmentManager(), DataUsageSummary.TAG_WARNING_EDITOR);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r14) {
            FragmentActivity r15 = getActivity();
            final DataUsageSummary r6 = (DataUsageSummary) getTargetFragment();
            final NetworkPolicyEditor r4 = DataUsageSummary.access$3100(r6);
            AlertDialog.Builder r0 = new AlertDialog.Builder(r15);
            View r16 = LayoutInflater.from(r0.getContext()).inflate(R.layout.data_usage_bytes_editor, null, false);
            final NumberPicker r5 = (NumberPicker) r16.findViewById(R.id.bytes);
            final NetworkTemplate r7 = (NetworkTemplate) getArguments().getParcelable(EXTRA_TEMPLATE);
            long r1 = r4.getPolicyWarningBytes(r7);
            long r8 = r4.getPolicyLimitBytes(r7);
            r5.setMinValue(0);
            if (r8 == (-1)) goto L5;
            r5.setMaxValue(((int) (r8 / 1048576)) - 1);
        L6:
            r5.setValue((int) (r1 / 1048576));
            r5.setWrapSelectorWheel(false);
            r0.setTitle(R.string.data_usage_warning_editor_title);
            r0.setView(r16);
            r0.setPositiveButton(R.string.data_usage_cycle_editor_positive, new AnonymousClass1(this, r5, r4, r7, r6));
            return r0.create();
        L5:
            r5.setMaxValue(Integer.MAX_VALUE);
            goto L6
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_DataUsageSummary$WarningEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WarningEditorFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$WarningEditorFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$WarningEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WarningEditorFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_DataUsageSummary$WarningEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_DataUsageSummary$WarningEditorFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WarningEditorFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_DataUsageSummary$WarningEditorFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public static boolean hasReadyMobile4gRadio(Context r0) {
        return false;
    }

    @Override // com.android.settings.InstrumentedFragment
    protected int getMetricsCategory() {
        return 1;
    }

    @Override // com.android.settings.HighlightingFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DataUsageSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.InstrumentedFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DataUsageSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DataUsageSummary() {
        this.mInsetSide = 0;
        this.mShowWifi = false;
        this.mShowEthernet = false;
        this.mCurrentApp = null;
        this.mCurrentTab = null;
        this.mIntentTab = null;
        this.mMobileDataEnabled = new HashMap();
        this.mEmptyTabContent = new AnonymousClass3(this);
        this.mTabListener = new AnonymousClass4(this);
        this.mDataEnabledListener = new AnonymousClass6(this);
        this.mDisableAtLimitListener = new AnonymousClass7(this);
        this.mAppRestrictListener = new AnonymousClass8(this);
        this.mListListener = new AnonymousClass9(this);
        this.mCycleListener = new AnonymousClass10(this);
        this.mChartDataCallbacks = new AnonymousClass11(this);
        this.mSummaryCallbacks = new AnonymousClass12(this);
        this.mChartListener = new AnonymousClass13(this);
    }

    static /* synthetic */ INetworkStatsService access$000(DataUsageSummary r0) {
        return r0.mStatsService;
    }

    static /* synthetic */ void access$100(DataUsageSummary r0) {
        r0.updateBody();
    }

    static /* synthetic */ void access$1000(DataUsageSummary r0, boolean r1) {
        r0.updatePolicy(r1);
    }

    static /* synthetic */ Switch access$1100(DataUsageSummary r0) {
        return r0.mDisableAtLimit;
    }

    static /* synthetic */ void access$1200(DataUsageSummary r0, long r1) {
        r0.setPolicyLimitBytes(r1);
    }

    static /* synthetic */ Switch access$1300(DataUsageSummary r0) {
        return r0.mAppRestrict;
    }

    static /* synthetic */ void access$1400(DataUsageSummary r0, boolean r1) {
        r0.setAppRestrictBackground(r1);
    }

    static /* synthetic */ UidDetailProvider access$1500(DataUsageSummary r0) {
        return r0.mUidDetailProvider;
    }

    static /* synthetic */ Spinner access$1600(DataUsageSummary r0) {
        return r0.mCycleSpinner;
    }

    static /* synthetic */ void access$1700(DataUsageSummary r0) {
        r0.updateDetailData();
    }

    static /* synthetic */ INetworkStatsSession access$1800(DataUsageSummary r0) {
        return r0.mStatsSession;
    }

    static /* synthetic */ ChartData access$1900(DataUsageSummary r0) {
        return r0.mChartData;
    }

    static /* synthetic */ ChartData access$1902(DataUsageSummary r0, ChartData r1) {
        r0.mChartData = r1;
        return r1;
    }

    static /* synthetic */ TabHost access$200(DataUsageSummary r0) {
        return r0.mTabHost;
    }

    static /* synthetic */ ChartDataUsageView access$2000(DataUsageSummary r0) {
        return r0.mChart;
    }

    static /* synthetic */ void access$2100(DataUsageSummary r0) {
        r0.updateAppDetail();
    }

    static /* synthetic */ ListView access$2200(DataUsageSummary r0) {
        return r0.mListView;
    }

    static /* synthetic */ NetworkPolicyManager access$2300(DataUsageSummary r0) {
        return r0.mPolicyManager;
    }

    static /* synthetic */ DataUsageAdapter access$2400(DataUsageSummary r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$2500(DataUsageSummary r0) {
        return r0.isAppDetailMode();
    }

    static /* synthetic */ TextView access$2600(DataUsageSummary r0) {
        return r0.mEmpty;
    }

    static /* synthetic */ View access$2700(DataUsageSummary r0) {
        return r0.mStupidPadding;
    }

    static /* synthetic */ void access$2800(DataUsageSummary r0, long r1) {
        r0.setPolicyWarningBytes(r1);
    }

    static /* synthetic */ AppItem access$2902(DataUsageSummary r0, AppItem r1) {
        r0.mCurrentApp = r1;
        return r1;
    }

    static /* synthetic */ Intent access$300(DataUsageSummary r0) {
        return r0.mAppSettingsIntent;
    }

    static /* synthetic */ NetworkTemplate access$3000(DataUsageSummary r0) {
        return r0.mTemplate;
    }

    static /* synthetic */ NetworkPolicyEditor access$3100(DataUsageSummary r0) {
        return r0.mPolicyEditor;
    }

    static /* synthetic */ boolean access$400(DataUsageSummary r0) {
        return r0.mBinding;
    }

    static /* synthetic */ Switch access$500(DataUsageSummary r0) {
        return r0.mDataEnabled;
    }

    static /* synthetic */ String access$600(DataUsageSummary r0) {
        return r0.mCurrentTab;
    }

    static /* synthetic */ boolean access$700(String r0) {
        return isMobileTab(r0);
    }

    static /* synthetic */ int access$800(DataUsageSummary r0, String r1) {
        return r0.getSubId(r1);
    }

    static /* synthetic */ void access$900(DataUsageSummary r0, int r1, boolean r2) {
        r0.setMobileDataEnabled(r1, r2);
    }

    public void com_android_settings_DataUsageSummary__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        FragmentActivity r7 = getActivity();
        this.mNetworkService = INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        this.mStatsService = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mPolicyManager = NetworkPolicyManager.from(r7);
        this.mTelephonyManager = TelephonyManager.from(r7);
        this.mSubscriptionManager = SubscriptionManager.from(r7);
        this.mPrefs = getActivity().getSharedPreferences(PREF_FILE, 0);
        NetworkPolicyEditor r2 = new NetworkPolicyEditor(this.mPolicyManager);
        this.mPolicyEditor = r2;
        r2.read();
        List<SubscriptionInfo> r3 = this.mSubscriptionManager.getActiveSubscriptionInfoList();
        this.mSubInfoList = r3;
        this.mMobileTagMap = initMobileTabTag(r3);
    L7:
        OLog.w(TAG, "No bandwidth control; leaving");
        getActivity().finish();
    L22:
        this.mStatsSession = this.mStatsService.openSession();     // Catch: RemoteException -> L17
        this.mShowWifi = this.mPrefs.getBoolean(PREF_SHOW_WIFI, false);
        this.mShowEthernet = this.mPrefs.getBoolean(PREF_SHOW_ETHERNET, false);
        if (hasReadyMobileRadio(r7) == true) goto L12;
        this.mShowWifi = true;
        this.mShowEthernet = true;
    L12:
        this.mUidDetailProvider = new UidDetailProvider(r7);
        Bundle r8 = getArguments();
        if (r8 == null) goto L15;
        this.mShowAppImmediatePkg = r8.getString(EXTRA_SHOW_APP_IMMEDIATE_PKG);
    L15:
        setHasOptionsMenu(true);
        return;
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (this.mNetworkService.isBandwidthControlEnabled() == true) goto L22;
        OLog.w(TAG, "No bandwidth control; leaving");     // Catch: RemoteException -> L7
        getActivity().finish();     // Catch: RemoteException -> L7
        goto L22
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Context r10 = r7.getContext();
        View r0 = r7.inflate(R.layout.data_usage_summary, r8, false);
        this.mTabHost = (TabHost) r0.findViewById(android.R.id.tabhost);
        this.mTabsContainer = (ViewGroup) r0.findViewById(R.id.tabs_container);
        this.mTabWidget = (TabWidget) r0.findViewById(android.R.id.tabs);
        ListView r2 = (ListView) r0.findViewById(android.R.id.list);
        this.mListView = r2;
        r2.getScrollBarStyle();
        this.mInsetSide = 0;
        Utils.prepareCustomPreferencesList(r8, r0, this.mListView, false);
        this.mTabHost.setup();
        this.mTabHost.setOnTabChangedListener(this.mTabListener);
        this.mHeader.setClickable(true);
        this.mListView.addHeaderView(new View(r10), null, true);
        this.mListView.addHeaderView(this.mHeader, null, true);
        this.mListView.setItemsCanFocus(true);
        int r11 = this.mInsetSide;
        if (r11 <= 0) goto L5;
        insetListViewDrawables(this.mListView, r11);
        ViewGroup r12 = this.mHeader;
        int r3 = this.mInsetSide;
        r12.setPaddingRelative(r3, 0, r3, 0);
    L5:
        Switch r13 = new Switch(r7.getContext());
        this.mDataEnabled = r13;
        r13.setClickable(false);
        this.mDataEnabled.setFocusable(false);
        View r14 = inflatePreference(r7, this.mNetworkSwitches, this.mDataEnabled);
        this.mDataEnabledView = r14;
        r14.setTag(R.id.preference_highlight_key, DATA_USAGE_ENABLE_MOBILE_KEY);
        this.mDataEnabledView.setClickable(true);
        this.mDataEnabledView.setFocusable(true);
        this.mDataEnabledView.setOnClickListener(this.mDataEnabledListener);
        this.mNetworkSwitches.addView(this.mDataEnabledView);
        Switch r15 = new Switch(r7.getContext());
        this.mDisableAtLimit = r15;
        r15.setClickable(false);
        this.mDisableAtLimit.setFocusable(false);
        View r16 = inflatePreference(r7, this.mNetworkSwitches, this.mDisableAtLimit);
        this.mDisableAtLimitView = r16;
        r16.setTag(R.id.preference_highlight_key, DATA_USAGE_DISABLE_MOBILE_LIMIT_KEY);
        this.mDisableAtLimitView.setClickable(true);
        this.mDisableAtLimitView.setFocusable(true);
        this.mDisableAtLimitView.setOnClickListener(this.mDisableAtLimitListener);
        this.mNetworkSwitches.addView(this.mDisableAtLimitView);
        View r17 = r7.inflate(R.layout.data_usage_cycles, this.mNetworkSwitches, false);
        this.mCycleView = r17;
        r17.setTag(R.id.preference_highlight_key, DATA_USAGE_CYCLE_KEY);
        this.mCycleSpinner = (Spinner) this.mCycleView.findViewById(R.id.cycles_spinner);
        CycleAdapter r18 = new CycleAdapter(r10);
        this.mCycleAdapter = r18;
        this.mCycleSpinner.setAdapter(r18);
        this.mCycleSpinner.setOnItemSelectedListener(this.mCycleListener);
        this.mNetworkSwitches.addView(this.mCycleView);
        this.mSeries = (ChartNetworkSeriesView) r0.findViewById(R.id.series);
        this.mDetailedSeries = (ChartNetworkSeriesView) r0.findViewById(R.id.detail_series);
        ChartDataUsageView r19 = (ChartDataUsageView) this.mHeader.findViewById(R.id.chart);
        this.mChart = r19;
        r19.setListener(this.mChartListener);
        this.mChart.bindNetworkPolicy(null);
        View r20 = this.mHeader.findViewById(R.id.app_detail);
        this.mAppDetail = r20;
        this.mAppIcon = (ImageView) r20.findViewById(R.id.app_icon);
        this.mAppTitles = (ViewGroup) this.mAppDetail.findViewById(R.id.app_titles);
        this.mAppForeground = (TextView) this.mAppDetail.findViewById(R.id.app_foreground);
        this.mAppBackground = (TextView) this.mAppDetail.findViewById(R.id.app_background);
        this.mAppSwitches = (LinearLayout) this.mAppDetail.findViewById(R.id.app_switches);
        this.mAppSettings = (Button) this.mAppDetail.findViewById(R.id.app_settings);
        Switch r21 = new Switch(r7.getContext());
        this.mAppRestrict = r21;
        r21.setClickable(false);
        this.mAppRestrict.setFocusable(false);
        View r22 = inflatePreference(r7, this.mAppSwitches, this.mAppRestrict);
        this.mAppRestrictView = r22;
        r22.setClickable(true);
        this.mAppRestrictView.setFocusable(true);
        this.mAppRestrictView.setOnClickListener(this.mAppRestrictListener);
        this.mAppSwitches.addView(this.mAppRestrictView);
        this.mEmpty = (TextView) this.mHeader.findViewById(android.R.id.empty);
        this.mAdapter = new DataUsageAdapter((UserManager) r10.getSystemService(PickApplicationActivity.EXTRA_USER), this.mUidDetailProvider, this.mInsetSide);
        this.mListView.setOnItemClickListener(this.mListListener);
        this.mListView.setAdapter(this.mAdapter);
        showRequestedAppIfNeeded(r0);
        return r0;
    }

    private void showRequestedAppIfNeeded(View r5) {
        if (this.mShowAppImmediatePkg != null) goto L10;
        return;
    L10:
        int r0 = getActivity().getPackageManager().getPackageUidAsUser(this.mShowAppImmediatePkg, UserHandle.myUserId());     // Catch: PackageManager.NameNotFoundException -> L7
        AppItem r1 = new AppItem(r0);     // Catch: PackageManager.NameNotFoundException -> L7
        r1.addUid(r0);     // Catch: PackageManager.NameNotFoundException -> L7
        UidDetail r2 = this.mUidDetailProvider.getUidDetail(r1.key, true);     // Catch: PackageManager.NameNotFoundException -> L7
        FrameLayout r6 = (FrameLayout) r5.findViewById(R.id.pinned_header);     // Catch: PackageManager.NameNotFoundException -> L7
        AppDetailsFragment.show(this, r1, r2.label, true);     // Catch: PackageManager.NameNotFoundException -> L7
        return;
    L7:
        e = move-exception;
        OLog.w(TAG, "Could not find " + this.mShowAppImmediatePkg, e);
        ToastUtils.show(getActivity(), getString(R.string.unknown_app));
        getActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        this.mIntentTab = computeTabFromIntent(getActivity().getIntent());
        updateTabs();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.settings.DataUsageSummary$2] */
    public void com_android_settings_DataUsageSummary__onResume$___twin___() {
        super.onResume();
        getView().post(new AnonymousClass1(this));
        new AnonymousClass2(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void updateMenuTitles() {
        if (this.mPolicyManager.getRestrictBackground() == false) goto L5;
        this.mMenuRestrictBackground.setTitle(R.string.data_usage_menu_allow_background);
    L7:
        if (this.mShowWifi == false) goto L9;
        this.mMenuShowWifi.setTitle(R.string.data_usage_menu_hide_wifi);
    L11:
        if (this.mShowEthernet == false) goto L13;
        this.mMenuShowEthernet.setTitle(R.string.data_usage_menu_hide_ethernet);
        return;
    L13:
        this.mMenuShowEthernet.setTitle(R.string.data_usage_menu_show_ethernet);
        return;
    L9:
        this.mMenuShowWifi.setTitle(R.string.data_usage_menu_show_wifi);
        goto L11
    L5:
        this.mMenuRestrictBackground.setTitle(R.string.data_usage_menu_restrict_background);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mDataEnabledView = null;
        this.mDisableAtLimitView = null;
        this.mUidDetailProvider.clearCache();
        this.mUidDetailProvider = null;
        TrafficStats.closeQuietly(this.mStatsSession);
        super.onDestroy();
    }

    private void ensureLayoutTransitions() {
        if (this.mShowAppImmediatePkg == null) goto L6;
        return;
    L6:
        if (this.mChart.getLayoutTransition() == null) goto L8;
        return;
    L8:
        this.mTabsContainer.setLayoutTransition(buildLayoutTransition());
        this.mHeader.setLayoutTransition(buildLayoutTransition());
        this.mNetworkSwitchesContainer.setLayoutTransition(buildLayoutTransition());
        LayoutTransition r0 = buildLayoutTransition();
        r0.disableTransitionType(2);
        r0.disableTransitionType(3);
        this.mChart.setLayoutTransition(r0);
    }

    private static LayoutTransition buildLayoutTransition() {
        LayoutTransition r0 = new LayoutTransition();
        r0.setAnimateParentHierarchy(false);
        return r0;
    }

    private void updateTabs() {
        FragmentActivity r0 = getActivity();
        this.mTabHost.clearAllTabs();
        int r1 = this.mTelephonyManager.getSimCount();
        List<SubscriptionInfo> r2 = this.mSubscriptionManager.getActiveSubscriptionInfoList();
        int r3 = 0;
        boolean r4 = true;
        if (r2 == null) goto L13;
        Iterator<SubscriptionInfo> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        SubscriptionInfo r6 = r5.next();
        if (r1 <= 1) goto L10;
        boolean r7 = true;
    L11:
        addMobileTab(r0, r6, r7);
        goto L6
    L10:
        r7 = false;
    L13:
        if (this.mShowWifi == false) goto L18;
        if (hasWifiRadio(r0) == false) goto L18;
        this.mTabHost.addTab(buildTabSpec("wifi", R.string.data_usage_tab_wifi));
    L18:
        if (this.mShowEthernet == false) goto L23;
        if (hasEthernet(r0) == false) goto L23;
        this.mTabHost.addTab(buildTabSpec(TAB_ETHERNET, R.string.data_usage_tab_ethernet));
    L23:
        if (this.mTabWidget.getTabCount() != 0) goto L25;
        boolean r8 = true;
    L27:
        if (this.mTabWidget.getTabCount() > 1) goto L30;
        r4 = false;
    L30:
        TabWidget r9 = this.mTabWidget;
        if (r4 == true) goto L34;
        r3 = 8;
    L34:
        r9.setVisibility(r3);
        String r10 = this.mIntentTab;
        if (r10 != null) goto L37;
        if (r8 == false) goto L48;
        updateBody();
        return;
    L48:
        return;
    L37:
        if (Objects.equals(r10, this.mTabHost.getCurrentTabTag()) == false) goto L39;
        updateBody();
    L40:
        this.mIntentTab = null;
        return;
    L39:
        this.mTabHost.setCurrentTabByTag(this.mIntentTab);
        goto L40
    L25:
        r8 = false;
        goto L27
    }

    private TabHost.TabSpec buildTabSpec(String r2, int r3) {
        return this.mTabHost.newTabSpec(r2).setIndicator(getText(r3)).setContent(this.mEmptyTabContent);
    }

    private TabHost.TabSpec buildTabSpec(String r2, CharSequence r3) {
        return this.mTabHost.newTabSpec(r2).setIndicator(r3).setContent(this.mEmptyTabContent);
    }

    private void updateBody() {
        this.mBinding = true;
        if (isAdded() == true) goto L5;
        return;
    L5:
        FragmentActivity r1 = getActivity();
        r1.getResources();
        String r2 = this.mTabHost.getCurrentTabTag();
        if (ActivityManager.getCurrentUser() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r2 != null) goto L12;
        OLog.w(TAG, "no tab selected; hiding body");
        this.mListView.setVisibility(8);
        return;
    L12:
        this.mListView.setVisibility(0);
        this.mCurrentTab = r2;
        this.mDataEnabledSupported = r3;
        this.mDisableAtLimitSupported = true;
        if (isMobileTab(r2) == false) goto L16;
        setPreferenceTitle(this.mDataEnabledView, R.string.data_usage_enable_mobile);
        setPreferenceTitle(this.mDisableAtLimitView, R.string.data_usage_disable_mobile_limit);
        this.mDataEnabledSupported = isMobileDataAvailable(getSubId(r2));
        NetworkTemplate r0 = NetworkTemplate.buildTemplateMobileAll(getActiveSubscriberId(r1, getSubId(r2)));
        this.mTemplate = r0;
        this.mTemplate = NetworkTemplate.normalize(r0, this.mTelephonyManager.getMergedSubscriberIds());
    L27:
        this.mPolicyEditor.read();
        this.mPolicyEditor.getPolicy(this.mTemplate);
        getActivity().invalidateOptionsMenu();
        this.mBinding = false;
        int r4 = r1.getColor(R.color.sim_noitification);
        String r5 = this.mCurrentTab;
        if (r5 != null) goto L30;
    L34:
        int r6 = Color.argb(127, Color.red(r4), Color.green(r4), Color.blue(r4));
        this.mSeries.setChartColor(-16777216, r4, r6);
        this.mDetailedSeries.setChartColor(-16777216, r4, r6);
        return;
    L30:
        if (r5.length() <= 6) goto L34;
        String r7 = this.mCurrentTab;
        SubscriptionInfo r8 = this.mSubscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(Integer.parseInt(r7.substring(6, r7.length())));
        if (r8 == null) goto L34;
        r4 = r8.getIconTint();
        goto L34
    L16:
        if (TAB_3G.equals(r2) == false) goto L19;
        setPreferenceTitle(this.mDataEnabledView, R.string.data_usage_enable_3g);
        setPreferenceTitle(this.mDisableAtLimitView, R.string.data_usage_disable_3g_limit);
        this.mTemplate = MultiSDKAdapter.buildTemplateMobile(getActiveSubscriberId(r1), TAB_3G);
        goto L27
    L19:
        if (TAB_4G.equals(r2) == false) goto L22;
        setPreferenceTitle(this.mDataEnabledView, R.string.data_usage_enable_4g);
        setPreferenceTitle(this.mDisableAtLimitView, R.string.data_usage_disable_4g_limit);
        this.mTemplate = MultiSDKAdapter.buildTemplateMobile(getActiveSubscriberId(r1), TAB_4G);
        goto L27
    L22:
        if ("wifi".equals(r2) == false) goto L25;
        this.mDataEnabledSupported = false;
        this.mDisableAtLimitSupported = false;
        this.mTemplate = NetworkTemplate.buildTemplateWifiWildcard();
        goto L27
    L25:
        if (TAB_ETHERNET.equals(r2) == false) goto L37;
        this.mDataEnabledSupported = false;
        this.mDisableAtLimitSupported = false;
        this.mTemplate = NetworkTemplate.buildTemplateEthernet();
        goto L27
    L37:
        throw new IllegalStateException("unknown tab: " + r2);
    L8:
        r3 = false;
        goto L9
    }

    private boolean isAppDetailMode() {
        if (this.mCurrentApp == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateAppDetail() {
        FragmentActivity r0 = getActivity();
        PackageManager r1 = r0.getPackageManager();
        getActivity().getLayoutInflater();
        boolean r3 = true;
        View r5 = null;
        if (isAppDetailMode() == false) goto L36;
        this.mAppDetail.setVisibility(0);
        this.mCycleAdapter.setChangeVisible(false);
        this.mChart.setVisibility(8);
        this.mChart.bindNetworkPolicy(null);
        final int r2 = this.mCurrentApp.key;
        UidDetail r7 = this.mUidDetailProvider.getUidDetail(r2, true);
        this.mAppIcon.setImageDrawable(r7.icon);
        this.mAppTitles.removeAllViews();
        if (r7.detailLabels != null) goto L7;
        r5.findViewById(R.id.app_title);
        throw null;
    L7:
        if (r7.detailLabels.length > 0) goto L32;
        this.mAppTotal = null;
        String[] r8 = r1.getPackagesForUid(r2);
        if (r8 != null) goto L11;
    L20:
        this.mAppSettingsIntent = null;
        this.mAppSettings.setOnClickListener(null);
        this.mAppSettings.setVisibility(8);
    L21:
        updateDetailData();
        if (UserHandle.isApp(r2) == true) goto L24;
    L30:
        this.mAppRestrictView.setVisibility(8);
        return;
    L24:
        if (this.mPolicyManager.getRestrictBackground() == true) goto L30;
        if (isBandwidthControlEnabled() == false) goto L30;
        if (hasReadyMobileRadio(r0) == false) goto L30;
        setPreferenceTitle(this.mAppRestrictView, R.string.data_usage_app_restrict_background);
        setPreferenceSummary(this.mAppRestrictView, getString(R.string.data_usage_app_restrict_background_summary));
        this.mAppRestrictView.setVisibility(0);
        this.mAppRestrict.setChecked(getAppRestrictBackground());
        return;
    L11:
        if (r8.length <= 0) goto L20;
        Intent r6 = new Intent("android.intent.action.MANAGE_NETWORK_USAGE");
        this.mAppSettingsIntent = r6;
        r6.addCategory("android.intent.category.DEFAULT");
        int r9 = r8.length;
        int r10 = 0;
    L13:
        if (r10 >= r9) goto L18;
        this.mAppSettingsIntent.setPackage(r8[r10]);
        if (r1.resolveActivity(this.mAppSettingsIntent, 0) != null) goto L19;
        r10 = r10 + 1;
    L19:
        this.mAppSettings.setOnClickListener(new AnonymousClass5(this, r2));
        this.mAppSettings.setEnabled(r3);
        this.mAppSettings.setVisibility(0);
        goto L21
    L18:
        r3 = false;
        goto L19
    L32:
        CharSequence r11 = r7.detailLabels[0];
        CharSequence r12 = r7.detailContentDescriptions[0];
        r5.findViewById(R.id.app_title);
        throw null;
    L36:
        this.mAppDetail.setVisibility(8);
        this.mCycleAdapter.setChangeVisible(true);
        this.mChart.setVisibility(0);
        this.mChart.bindDetailNetworkStats(null);
    }

    private void setPolicyWarningBytes(long r3) {
        this.mPolicyEditor.setPolicyWarningBytes(this.mTemplate, r3);
        updatePolicy(false);
    }

    private void setPolicyLimitBytes(long r3) {
        this.mPolicyEditor.setPolicyLimitBytes(this.mTemplate, r3);
        updatePolicy(false);
    }

    private boolean isMobileDataEnabled(int r3) {
        if (this.mMobileDataEnabled.get(String.valueOf(r3)) == null) goto L6;
        boolean r0 = this.mMobileDataEnabled.get(String.valueOf(r3)).booleanValue();
        this.mMobileDataEnabled.put(String.valueOf(r3), null);
        return r0;
    L6:
        return this.mTelephonyManager.getDataEnabled(r3);
    }

    private void setMobileDataEnabled(int r4, boolean r5) {
        if (r4 != SubscriptionManager.getPhoneId(SubscriptionManager.getDefaultDataSubscriptionId())) goto L5;
    L8:
        this.mTelephonyManager.setDataEnabled(r4, r5);
    L9:
        this.mMobileDataEnabled.put(String.valueOf(r4), Boolean.valueOf(r5));
        updatePolicy(false);
        return;
    L5:
        if (TelephonyManager.getDefault().getSimCount() == 1) goto L8;
        android.provider.Settings.Global.putInt(getActivity().getContentResolver(), "mobile_data" + r4, r5 ? 1 : 0);
        goto L9
    }

    private boolean isNetworkPolicyModifiable(NetworkPolicy r1) {
        if (r1 != null) goto L4;
    L10:
        return false;
    L4:
        if (isBandwidthControlEnabled() == false) goto L10;
        if (this.mDataEnabled.isChecked() == false) goto L10;
        if (ActivityManager.getCurrentUser() != 0) goto L10;
        return true;
    }

    private boolean isBandwidthControlEnabled() {
        return this.mNetworkService.isBandwidthControlEnabled();
    L4:
        e = move-exception;
        OLog.w(TAG, "problem talking with INetworkManagementService: " + e);
        return false;
    }

    public void setRestrictBackground(boolean r2) {
        this.mPolicyManager.setRestrictBackground(r2);
        updateMenuTitles();
    }

    private boolean getAppRestrictBackground() {
        int r0 = this.mCurrentApp.key;
        if ((this.mPolicyManager.getUidPolicy(r0) & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private void setAppRestrictBackground(boolean r3) {
        int r0 = this.mCurrentApp.key;
        this.mPolicyManager.setUidPolicy(r0, r3 ? 1 : 0);
        this.mAppRestrict.setChecked(r3);
    }

    private void updatePolicy(boolean r11) {
        boolean r0 = this.mDataEnabledSupported;
        boolean r1 = this.mDisableAtLimitSupported;
        int r3 = 0;
        if (isAppDetailMode() == false) goto L5;
        r0 = false;
        r1 = false;
    L5:
        boolean r4 = true;
        if (isMobileTab(this.mCurrentTab) == false) goto L8;
        this.mBinding = true;
        this.mDataEnabled.setChecked(isMobileDataEnabled(getSubId(this.mCurrentTab)));
        this.mBinding = false;
    L8:
        NetworkPolicy r2 = this.mPolicyEditor.getPolicy(this.mTemplate);
        if (isNetworkPolicyModifiable(r2) == true) goto L11;
    L21:
        this.mChart.bindNetworkPolicy(null);
        r1 = false;
    L22:
        View r5 = this.mDataEnabledView;
        if (r0 == false) goto L25;
        int r6 = 0;
    L26:
        r5.setVisibility(r6);
        View r7 = this.mDisableAtLimitView;
        if (r1 == true) goto L30;
        r3 = 8;
    L30:
        r7.setVisibility(r3);
        if (r11 == false) goto L34;
        updateCycleList(r2);
        return;
    L34:
        return;
    L25:
        r6 = 8;
        goto L26
    L11:
        if (isMobileDataAvailable(getSubId(this.mCurrentTab)) == false) goto L21;
        Switch r8 = this.mDisableAtLimit;
        if (r2 != null) goto L15;
    L17:
        r4 = false;
    L18:
        r8.setChecked(r4);
        if (isAppDetailMode() == true) goto L22;
        this.mChart.bindNetworkPolicy(r2);
        goto L22
    L15:
        if (r2.limitBytes == (-1)) goto L17;
        goto L17
    }

    private void updateCycleList(NetworkPolicy r15) {
        CycleItem r16 = (CycleItem) this.mCycleSpinner.getSelectedItem();
        this.mCycleAdapter.clear();
        Context r0 = this.mCycleSpinner.getContext();
        ChartData r1 = this.mChartData;
        if (r1 == null) goto L5;
        long r6 = r1.network.getStart();
        long r8 = this.mChartData.network.getEnd();
    L6:
        long r10 = System.currentTimeMillis();
        if (r6 != Long.MAX_VALUE) goto L9;
        long r12 = r10;
    L11:
        if (r8 != Long.MIN_VALUE) goto L13;
        r8 = r10 + 1;
    L13:
        long r5 = r8;
    L15:
        if (r5 <= r12) goto L17;
        long r7 = r5 - 2419200000L;
        this.mCycleAdapter.add(new CycleItem(r0, r7, r5));
        r5 = r7;
        goto L15
    L17:
        this.mCycleAdapter.setChangePossible(false);
        if (this.mCycleAdapter.getCount() <= 0) goto L23;
        int r4 = this.mCycleAdapter.findNearestPosition(r16);
        this.mCycleSpinner.setSelection(r4);
        if (Objects.equals(this.mCycleAdapter.getItem(r4), r16) == true) goto L22;
        this.mCycleListener.onItemSelected(this.mCycleSpinner, null, r4, 0);
        return;
    L22:
        updateDetailData();
        return;
    L23:
        updateDetailData();
        return;
    L9:
        r12 = r6;
        goto L11
    L5:
        r6 = Long.MAX_VALUE;
        r8 = Long.MIN_VALUE;
        goto L6
    }

    private void updateDetailData() {
        long r10 = this.mChart.getInspectStart();
        long r12 = this.mChart.getInspectEnd();
        long r14 = System.currentTimeMillis();
        FragmentActivity r1 = getActivity();
        NetworkStatsHistory.Entry r9 = null;
        if (isAppDetailMode() == false) goto L13;
        ChartData r2 = this.mChartData;
        if (r2 == null) goto L13;
        if (r2.detail == null) goto L13;
        NetworkStatsHistory.Entry r11 = this.mChartData.detailDefault.getValues(r10, r12, r14, null);
        long r7 = r11.rxBytes + r11.txBytes;
        NetworkStatsHistory.Entry r3 = this.mChartData.detailForeground.getValues(r10, r12, r14, r11);
        long r4 = r3.rxBytes + r3.txBytes;
        long r8 = r7 + r4;
        TextView r5 = this.mAppTotal;
        if (r5 == null) goto L11;
        String r6 = android.text.format.Formatter.formatFileSize(r1, r8);
        char r13 = 'k';
        char r15 = 'K';
        r5.setText(r6.replace('k', 'K'));
    L12:
        this.mAppBackground.setText(android.text.format.Formatter.formatFileSize(r1, r7).replace(r13, r15));
        this.mAppForeground.setText(android.text.format.Formatter.formatFileSize(r1, r4).replace(r13, r15));
        char r16 = r13;
        NetworkStatsHistory.Entry r17 = this.mChartData.detail.getValues(r10, r12, r14, null);
        LoaderManager.getInstance(this).destroyLoader(3);
        this.mCycleSummary.setVisibility(8);
        int r18 = 0;
    L17:
        if (r17 == null) goto L19;
        long r19 = r17.rxBytes + r17.txBytes;
    L20:
        this.mCycleSummary.setText(android.text.format.Formatter.formatFileSize(r1, r19).replace(r16, 'K'));
        if (isMobileTab(this.mCurrentTab) == true) goto L29;
        if (TAB_3G.equals(this.mCurrentTab) == true) goto L29;
        if (TAB_4G.equals(this.mCurrentTab) == true) goto L29;
        this.mDisclaimer.setVisibility(8);
    L32:
        ensureLayoutTransitions();
        return;
    L29:
        if (isAppDetailMode() == false) goto L31;
        this.mDisclaimer.setVisibility(8);
        goto L32
    L31:
        this.mDisclaimer.setVisibility(r18);
        goto L32
    L19:
        r19 = 0;
        goto L20
    L11:
        r13 = 'k';
        r15 = 'K';
    L13:
        r16 = 'k';
        ChartData r20 = this.mChartData;
        if (r20 == null) goto L16;
        r9 = r20.network.getValues(r10, r12, r14, null);
    L16:
        r18 = 0;
        this.mCycleSummary.setVisibility(0);
        LoaderManager.getInstance(this).restartLoader(3, SummaryForAllUidLoader.buildArgs(this.mTemplate, r10, r12), this.mSummaryCallbacks);
        r17 = r9;
        goto L17
    }

    @Deprecated
    private boolean isMobilePolicySplit() {
        FragmentActivity r0 = getActivity();
        if (hasReadyMobileRadio(r0) == false) goto L6;
        TelephonyManager.from(r0);
        return this.mPolicyEditor.isMobilePolicySplit(getActiveSubscriberId(r0));
    L6:
        return false;
    }

    @Deprecated
    private void setMobilePolicySplit(boolean r3) {
        FragmentActivity r0 = getActivity();
        if (hasReadyMobileRadio(r0) == false) goto L6;
        TelephonyManager.from(r0);
        this.mPolicyEditor.setMobilePolicySplit(getActiveSubscriberId(r0), r3);
        return;
    }

    private static String getActiveSubscriberId(Context r1) {
        return SystemProperties.get(TEST_SUBSCRIBER_PROP, TelephonyManager.from(r1).getSubscriberId());
    }

    private static String getActiveSubscriberId(Context r0, int r1) {
        return TelephonyManager.from(r0).getSubscriberId(r1);
    }

    static {
        StringBuilder r0 = new StringBuilder(50);
        sBuilder = r0;
        sFormatter = new Formatter(r0, Locale.getDefault());
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

    private static String computeTabFromIntent(Intent r4) {
        NetworkTemplate r0 = r4.getParcelableExtra("android.net.NETWORK_TEMPLATE");
        if (r0 != null) goto L9;
        int r5 = r4.getIntExtra("subscription", -1);
        if (SubscriptionManager.isValidSubscriptionId(r5) == true) goto L7;
        return null;
    L7:
        return "mobile" + String.valueOf(r5);
    L9:
        int r6 = r0.getMatchRule();
        if (r6 != 1) goto L12;
        return "mobile";
    L12:
        if (r6 != 2) goto L14;
        return TAB_3G;
    L14:
        if (r6 != 3) goto L16;
        return TAB_4G;
    L16:
        if (r6 == 4) goto L18;
        return null;
    L18:
        return "wifi";
    }

    public static boolean hasReadyMobileRadio(Context r7) {
        ConnectivityManager r0 = ConnectivityManager.from(r7);
        TelephonyManager r1 = TelephonyManager.from(r7);
        List<SubscriptionInfo> r8 = SubscriptionManager.from(r7).getActiveSubscriptionInfoList();
        if (r8 != null) goto L5;
        return false;
    L5:
        Iterator<SubscriptionInfo> r9 = r8.iterator();
        boolean r4 = true;
    L7:
        if (r9.hasNext() == false) goto L14;
        if (r1.getSimState(r9.next().getSimSlotIndex()) != 5) goto L11;
        boolean r5 = true;
    L12:
        r4 = r4 & r5;
        goto L7
    L11:
        r5 = false;
        goto L12
    L14:
        if (r0.isNetworkSupported(0) == false) goto L21;
        if (r4 == true) goto L17;
        return false;
    L17:
        return true;
    L21:
        return false;
    }

    public static boolean hasReadyMobileRadio(Context r3, int r4) {
        ConnectivityManager r5 = ConnectivityManager.from(r3);
        if (TelephonyManager.from(r3).getSimState(0) != 5) goto L5;
        boolean r6 = true;
    L7:
        if (r5.isNetworkSupported(0) == false) goto L11;
        if (r6 == true) goto L10;
        return false;
    L10:
        return true;
    L11:
        return false;
    L5:
        r6 = false;
        goto L7
    }

    public static boolean hasWifiRadio(Context r1) {
        return ConnectivityManager.from(r1).isNetworkSupported(1);
    }

    public boolean hasEthernet(Context r9) {
        boolean r10 = ConnectivityManager.from(r9).isNetworkSupported(9);
        INetworkStatsSession r0 = this.mStatsSession;
        if (r0 != null) goto L16;
        long r1 = 0;
    L10:
        if (r10 == true) goto L12;
    L14:
        return false;
    L12:
        if (r1 <= 0) goto L14;
        return true;
    L16:
        r1 = r0.getSummaryForNetwork(NetworkTemplate.buildTemplateEthernet(), Long.MIN_VALUE, Long.MAX_VALUE).getTotalBytes();     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static View inflatePreference(LayoutInflater r2, ViewGroup r3, View r4) {
        View r5 = r2.inflate(R.layout.preference, r3, false);
        ((LinearLayout) NullSafe.nonNull(r5.findViewById(android.R.id.widget_frame))).addView(r4, new LinearLayout.LayoutParams(-2, -2));
        return r5;
    }

    private boolean hasLimitedNetworks() {
        return !buildLimitedNetworksList().isEmpty();
    }

    @Deprecated
    private CharSequence buildLimitedNetworksString() {
        List<CharSequence> r0 = buildLimitedNetworksList();
        if (r0.isEmpty() == false) goto L7;
        r0.add(getText(R.string.data_usage_list_none));
        return null;
    L7:
        return null;
    }

    @Deprecated
    private List<CharSequence> buildLimitedNetworksList() {
        FragmentActivity r0 = getActivity();
        ArrayList r1 = Lists.newArrayList();
        if (TelephonyManager.from(r0).getSimState() != 5) goto L14;
        String r2 = getActiveSubscriberId(r0);
        if (this.mPolicyEditor.hasLimitedPolicy(NetworkTemplate.buildTemplateMobileAll(r2)) == false) goto L8;
        r1.add(getText(R.string.data_usage_list_mobile));
    L8:
        if (this.mPolicyEditor.hasLimitedPolicy(MultiSDKAdapter.buildTemplateMobile(r2, TAB_3G)) == false) goto L11;
        r1.add(getText(R.string.data_usage_tab_3g));
    L11:
        if (this.mPolicyEditor.hasLimitedPolicy(MultiSDKAdapter.buildTemplateMobile(r2, TAB_4G)) == false) goto L14;
        r1.add(getText(R.string.data_usage_tab_4g));
    L14:
        if (this.mPolicyEditor.hasLimitedPolicy(NetworkTemplate.buildTemplateWifiWildcard()) == false) goto L17;
        r1.add(getText(R.string.data_usage_tab_wifi));
    L17:
        if (this.mPolicyEditor.hasLimitedPolicy(NetworkTemplate.buildTemplateEthernet()) == false) goto L19;
        r1.add(getText(R.string.data_usage_tab_ethernet));
    L19:
        return r1;
    }

    private static void insetListViewDrawables(ListView r4, int r5) {
        Drawable r0 = r4.getSelector();
        Drawable r1 = r4.getDivider();
        ColorDrawable r2 = new ColorDrawable(0);
        r4.setSelector(r2);
        r4.setDivider(r2);
        r4.setSelector(new InsetBoundsDrawable(r0, r5));
        r4.setDivider(new InsetBoundsDrawable(r1, r5));
    }

    private static void setPreferenceTitle(View r1, int r2) {
        ((TextView) r1.findViewById(android.R.id.title)).setText(r2);
    }

    private static void setPreferenceSummary(View r1, CharSequence r2) {
        TextView r3 = (TextView) r1.findViewById(android.R.id.summary);
        r3.setVisibility(0);
        r3.setText(r2);
    }

    private void addMobileTab(Context r2, SubscriptionInfo r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.mMobileTagMap != null) goto L6;
        return;
    L6:
        if (hasReadyMobileRadio(r2, r3.getSubscriptionId()) == false) goto L13;
        if (r4 == false) goto L9;
        this.mTabHost.addTab(buildTabSpec(this.mMobileTagMap.get(Integer.valueOf(r3.getSubscriptionId())), r3.getDisplayName()));
        return;
    L9:
        this.mTabHost.addTab(buildTabSpec(this.mMobileTagMap.get(Integer.valueOf(r3.getSubscriptionId())), R.string.data_usage_tab_mobile));
        return;
    }

    private SubscriptionInfo getCurrentTabSubInfo(Context r5) {
        if (this.mSubInfoList == null) goto L15;
        TabHost r0 = this.mTabHost;
        if (r0 == null) goto L23;
        int r1 = r0.getCurrentTab();
        Iterator<SubscriptionInfo> r4 = this.mSubInfoList.iterator();
        int r2 = 0;
    L8:
        if (r4.hasNext() == false) goto L24;
        SubscriptionInfo r3 = r4.next();
        if (hasReadyMobileRadio(r5, r3.getSubscriptionId()) == false) goto L8;
        int r6 = r2 + 1;
        if (r2 == r1) goto L13;
        r2 = r6;
        goto L8
    L13:
        return r3;
    L24:
        return null;
    L23:
        return null;
    L15:
        return null;
    }

    private Map<Integer, String> initMobileTabTag(List<SubscriptionInfo> r4) {
        if (r4 == null) goto L7;
        HashMap r3 = new HashMap();
        Iterator<SubscriptionInfo> r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L10;
        SubscriptionInfo r0 = r5.next();
        r3.put(Integer.valueOf(r0.getSubscriptionId()), "mobile" + String.valueOf(r0.getSubscriptionId()));
        goto L5
    L10:
        return r3;
    L7:
        return null;
    }

    private static boolean isMobileTab(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.contains("mobile");
    }

    private int getSubId(String r4) {
        Map<Integer, String> r0 = this.mMobileTagMap;
        if (r0 == null) goto L11;
        Iterator<Integer> r1 = r0.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        Integer r2 = r1.next();
        if (this.mMobileTagMap.get(r2).equals(r4) == false) goto L6;
        return r2.intValue();
    L11:
        OLog.e(TAG, "currentTab = " + r4 + " non mobile tab called this function");
        return -1;
    }

    private boolean isMobileDataAvailable(int r1) {
        if (this.mSubscriptionManager.getActiveSubscriptionInfo(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DataUsageSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DataUsageSummary r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DataUsageSummary__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DataUsageSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DataUsageSummary r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DataUsageSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DataUsageSummary_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DataUsageSummary r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DataUsageSummary__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
