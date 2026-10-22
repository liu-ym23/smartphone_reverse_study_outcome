package com.android.settings.applications.manageapplications;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.usage.IUsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.icu.lang.UCharacter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.preference.PreferenceFrameLayout;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.IconDrawableFactory;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.jank.InteractionJankMonitor;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsActivity;
import com.android.settings.Utils;
import com.android.settings.applications.AppInfoBase;
import com.android.settings.applications.AppStateAlarmsAndRemindersBridge;
import com.android.settings.applications.AppStateAppOpsBridge;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.applications.AppStateBaseSwitchInterface;
import com.android.settings.applications.AppStateInstallAppsBridge;
import com.android.settings.applications.AppStateInteractAcrossProfilesBridge;
import com.android.settings.applications.AppStateLocaleBridge;
import com.android.settings.applications.AppStateLongBackgroundTasksBridge;
import com.android.settings.applications.AppStateManageExternalStorageBridge;
import com.android.settings.applications.AppStateMediaManagementAppsBridge;
import com.android.settings.applications.AppStateNotificationBridge;
import com.android.settings.applications.AppStateOverlayBridge;
import com.android.settings.applications.AppStateTurnScreenOnBridge;
import com.android.settings.applications.AppStateUsageBridge;
import com.android.settings.applications.AppStateWriteSettingsBridge;
import com.android.settings.applications.appinfo.DrawOverlayDetails;
import com.android.settings.applications.appinfo.InteractAcrossProfilesDetails;
import com.android.settings.base.BaseFragment;
import com.android.settings.nfc.AppStateNfcTagAppsBridge;
import com.android.settings.notification.NotificationBackend;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.MinorUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.LoadingViewController2;
import com.android.settings.wifi.AppStateChangeWifiStateBridge;
import com.android.settingslib.applications.AppUtils;
import com.android.settingslib.applications.ApplicationStateExKt;
import com.android.settingslib.applications.ApplicationsState;
import com.android.settingslib.utils.ThreadUtils;
import com.obric.matrix.sdk.network.BuildConfig;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ManageApplications extends BaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener, SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {
    private static final int ADVANCED_SETTINGS = 2;
    public static final String APP_CHG = "chg";
    public static final String ARG_PACKAGE_NAME = "package";
    static final boolean DEBUG = false;
    public static final String EXTRA_CLASSNAME = "classname";
    static final String EXTRA_EXPAND_SEARCH_VIEW = "expand_search_view";
    private static final String EXTRA_FILTER_TYPE = "filterType";
    private static final String EXTRA_HAS_BRIDGE = "hasBridge";
    private static final String EXTRA_HAS_ENTRIES = "hasEntries";
    public static final String EXTRA_LIST_TYPE = "listType";
    private static final String EXTRA_SHOW_SYSTEM = "showSystem";
    private static final String EXTRA_SORT_ORDER = "sortOrder";
    public static final String EXTRA_STORAGE_TYPE = "storageType";
    public static final String EXTRA_VOLUME_NAME = "volumeName";
    public static final String EXTRA_VOLUME_UUID = "volumeUuid";
    public static final String EXTRA_WORK_ID = "workId";
    private static final ApplicationsState.AppFilter FILTER_DOWNLOADED_AND_LAUNCHER_AND_INSTANT_WITH_BLUETOOTH = null;
    private static final ApplicationsState.AppFilter FILTER_DOWNLOADED_AND_LAUNCHER_WITH_BLUETOOTH = null;
    private static final int INSTALLED_APP_DETAILS = 1;
    public static final int LIST_MANAGE_EXTERNAL_STORAGE = 11;
    public static final Set<Integer> LIST_TYPES_WITH_INSTANT = null;
    public static final int LIST_TYPE_ALARMS_AND_REMINDERS = 12;
    public static final int LIST_TYPE_APPS_LOCALE = 14;
    public static final int LIST_TYPE_BATTERY_OPTIMIZATION = 15;
    public static final int LIST_TYPE_CLONED_APPS = 17;
    public static final int LIST_TYPE_GAMES = 9;
    public static final int LIST_TYPE_HIGH_POWER = 5;
    public static final int LIST_TYPE_INTERACT_ACROSS_PROFILES = 21;
    public static final int LIST_TYPE_LONG_BACKGROUND_TASKS = 16;
    public static final int LIST_TYPE_MAIN = 0;
    public static final int LIST_TYPE_MANAGE_SOURCES = 8;
    public static final int LIST_TYPE_MEDIA_MANAGEMENT_APPS = 13;
    public static final int LIST_TYPE_NFC_TAG_APPS = 18;
    public static final int LIST_TYPE_NONE = -1;
    public static final int LIST_TYPE_NOTIFICATION = 1;
    public static final int LIST_TYPE_OVERLAY = 6;
    public static final int LIST_TYPE_STORAGE = 3;
    public static final int LIST_TYPE_TURN_SCREEN_ON = 19;
    public static final int LIST_TYPE_USAGE_ACCESS = 4;
    public static final int LIST_TYPE_USER_ASPECT_RATIO_APPS = 20;
    public static final int LIST_TYPE_WIFI_ACCESS = 10;
    public static final int LIST_TYPE_WRITE_SETTINGS = 7;
    private static final String PACKAGE_BLUETOOTH = "com.android.bluetooth";
    public static final int SIZE_EXTERNAL = 2;
    public static final int SIZE_INTERNAL = 1;
    public static final int SIZE_TOTAL = 0;
    public static final int STORAGE_TYPE_DEFAULT = 0;
    public static final int STORAGE_TYPE_LEGACY = 1;
    static final String TAG = "ManageApplications";
    protected ApplicationsState.AppEntry mAppEntry;
    private ApplicationsAdapter mApplications;
    private ApplicationsState mApplicationsState;
    private View mContentLayout;
    private String mCurrentPkgName;
    private int mCurrentUid;
    private OPageStatus mEmptyDesc;
    private View mEmptyView;
    boolean mExpandSearch;
    private AppFilterItem mFilter;
    FilterSpinnerAdapter mFilterAdapter;
    private Spinner mFilterSpinner;
    private int mFilterType;
    CharSequence mInvalidSizeStr;
    private boolean mIsPersonalOnly;
    private boolean mIsPrivateProfileOnly;
    private boolean mIsWorkOnly;
    public int mListType;
    private View mLoadingContainer;
    private NotificationBackend mNotificationBackend;
    private Menu mOptionsMenu;
    protected PackageInfo mPackageInfo;
    private String mPackageName;
    RecyclerView mRecyclerView;
    private View mRootView;
    private SearchView mSearchView;
    private boolean mShowSystem;
    int mSortOrder;
    View mSpinnerHeader;
    private int mStorageType;
    private OFloatingTitleBar mTitleBar;
    private IUsageStatsManager mUsageStatsManager;
    protected int mUserId;
    private UserManager mUserManager;
    private String mVolumeUuid;
    private int mWorkUserId;
    private CollapsingToolbarLayoutState state;
    private TextView tvTitle;

    static class ApplicationsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ApplicationsState.Callbacks, AppStateBaseBridge.Callback {
        private static final String STATE_LAST_SCROLL_INDEX = "state_last_scroll_index";
        private static final int VIEW_TYPE_APP = 0;
        private static final int VIEW_TYPE_APP_HEADER = 2;
        private static final int VIEW_TYPE_EXTRA_VIEW = 1;
        private static final int VIEW_TYPE_TWO_TARGET = 3;
        private final Set<String> DEFAULT_WHITE_SET;
        private int TYPE_LIST_CONTENT;
        private int TYPE_LIST_HEADER;
        private AppFilterItem mAppFilter;
        private BindTitleListener mBindTitleListener;
        private ApplicationsState.AppFilter mCompositeFilter;
        private final Context mContext;
        private ArrayList<ApplicationsState.AppEntry> mEntries;
        private AppStateBaseBridge mExtraInfoBridge;
        private boolean mHasReceivedBridgeCallback;
        private boolean mHasReceivedLoadEntries;
        private boolean mHasScrolledToHighlight;
        private int mHighlightPosition;
        private final IconDrawableFactory mIconDrawableFactory;
        private int mLastIndex;
        private int mLastSortMode;
        private final LoadingViewController2 mLoadingViewController;
        private final ManageApplications mManageApplications;
        OnScrollListener mOnScrollListener;
        private ArrayList<ApplicationsState.AppEntry> mOriginalEntries;
        private RecyclerView mRecyclerView;
        private boolean mResumed;
        private SearchFilter mSearchFilter;
        private final ApplicationsState.Session mSession;
        private final ApplicationsState mState;
        private int mWhichSize;

        interface BindTitleListener {
            void bindTitle(ApplicationHeadViewHolder r1);
        }

        public static class OnScrollListener extends RecyclerView.OnScrollListener {
            private ApplicationsAdapter mAdapter;
            private String mClassName;
            private boolean mDelayNotifyDataChange;
            private InputMethodManager mInputMethodManager;
            private InteractionJankMonitor mMonitor;
            private int mScrollState;

            public OnScrollListener(ApplicationsAdapter r2, String r3) {
                this.mScrollState = 0;
                this.mAdapter = r2;
                this.mInputMethodManager = (InputMethodManager) ApplicationsAdapter.access$2300(r2).getSystemService(InputMethodManager.class);
                this.mMonitor = InteractionJankMonitor.getInstance();
                this.mClassName = r3;
            }

            @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView r4, int r5) {
                this.mScrollState = r5;
                if (r5 != 0) goto L8;
                if (this.mDelayNotifyDataChange == false) goto L8;
                this.mDelayNotifyDataChange = false;
                this.mAdapter.notifyDataSetChanged();
                return;
            L8:
                if (r5 != 1) goto L15;
                InputMethodManager r6 = this.mInputMethodManager;
                if (r6 != null) goto L12;
            L14:
                InteractionJankMonitor.Configuration.Builder r7 = InteractionJankMonitor.Configuration.Builder.withView(28, r4).setTag(this.mClassName);
                this.mMonitor.begin(r7);
                return;
            L12:
                if (r6.isActive() == false) goto L14;
                this.mInputMethodManager.hideSoftInputFromWindow(r4.getWindowToken(), 0);
                goto L14
            L15:
                if (r5 != 0) goto L20;
                this.mMonitor.end(28);
                return;
            }

            public void postNotifyItemChange(int r2) {
                if (this.mScrollState != 0) goto L5;
                this.mAdapter.notifyItemChanged(r2);
                return;
            L5:
                this.mDelayNotifyDataChange = true;
            }
        }

        private class SearchFilter extends Filter {
            final /* synthetic */ ApplicationsAdapter this$0;

            private SearchFilter(ApplicationsAdapter r1) {
                this.this$0 = r1;
            }

            /* synthetic */ SearchFilter(ApplicationsAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence r5) {
                if (TextUtils.isEmpty(r5) == false) goto L5;
                ArrayList r4 = ApplicationsAdapter.access$2400(this.this$0);
            L12:
                Filter.FilterResults r6 = new Filter.FilterResults();
                r6.values = r4;
                r6.count = r4.size();
                return r6;
            L5:
                ArrayList r0 = new ArrayList();
                Iterator r7 = ApplicationsAdapter.access$2400(this.this$0).iterator();
            L7:
                if (r7.hasNext() == false) goto L11;
                ApplicationsState.AppEntry r1 = (ApplicationsState.AppEntry) r7.next();
                if (r1.label.toLowerCase().contains(r5.toString().toLowerCase()) == false) goto L7;
                r0.add(r1);
                goto L7
            L11:
                r4 = r0;
                goto L12
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence r1, Filter.FilterResults r2) {
                ApplicationsAdapter.access$702(this.this$0, (ArrayList) r2.values);
                this.this$0.notifyDataSetChanged();
            }
        }

        public static int getApplicationPosition(int r1, int r2) {
            if (r1 != 14) goto L5;
        L6:
            if (r2 <= 0) goto L9;
            return r2 - 1;
        L9:
            return -1;
        L5:
            if (r1 == 17) goto L6;
            return r2;
        }

        private void logAction(int r1) {
        }

        private void logAppBatteryUsage(int r1) {
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
        }

        static /* synthetic */ boolean access$000(ApplicationsAdapter r0) {
            return r0.mHasReceivedLoadEntries;
        }

        static /* synthetic */ boolean access$002(ApplicationsAdapter r0, boolean r1) {
            r0.mHasReceivedLoadEntries = r1;
            return r1;
        }

        static /* synthetic */ boolean access$100(ApplicationsAdapter r0) {
            return r0.mHasReceivedBridgeCallback;
        }

        static /* synthetic */ boolean access$102(ApplicationsAdapter r0, boolean r1) {
            r0.mHasReceivedBridgeCallback = r1;
            return r1;
        }

        static /* synthetic */ Context access$2300(ApplicationsAdapter r0) {
            return r0.mContext;
        }

        static /* synthetic */ ArrayList access$2400(ApplicationsAdapter r0) {
            return r0.mOriginalEntries;
        }

        static /* synthetic */ void access$300(ApplicationsAdapter r0, BindTitleListener r1) {
            r0.bindTitle(r1);
        }

        static /* synthetic */ AppStateBaseBridge access$600(ApplicationsAdapter r0) {
            return r0.mExtraInfoBridge;
        }

        static /* synthetic */ ArrayList access$700(ApplicationsAdapter r0) {
            return r0.mEntries;
        }

        static /* synthetic */ ArrayList access$702(ApplicationsAdapter r0, ArrayList r1) {
            r0.mEntries = r1;
            return r1;
        }

        public ApplicationsAdapter(ApplicationsState r10, ManageApplications r11, AppFilterItem r12, Bundle r13) {
            this.TYPE_LIST_HEADER = -1;
            this.TYPE_LIST_CONTENT = 0;
            this.mExtraInfoBridge = null;
            this.mLastSortMode = -1;
            this.mWhichSize = 0;
            this.mLastIndex = -1;
            this.mHighlightPosition = -1;
            this.DEFAULT_WHITE_SET = new AnonymousClass1(this);
            setHasStableIds(true);
            this.mState = r10;
            this.mSession = r10.newSession(this);
            this.mManageApplications = r11;
            this.mLoadingViewController = new LoadingViewController2(ManageApplications.access$1100(r11), ManageApplications.access$1200(r11), ManageApplications.access$1300(r11), ManageApplications.access$1400(r11));
            FragmentActivity r3 = r11.getActivity();
            this.mContext = r3;
            this.mIconDrawableFactory = IconDrawableFactory.newInstance(r3);
            this.mAppFilter = r12;
            if (r11.mListType != 1) goto L6;
            this.mExtraInfoBridge = new AppStateNotificationBridge(r3, r10, this, ManageApplications.access$1500(r11), ManageApplications.access$1600(r11), ManageApplications.access$1700(r11));
        L48:
            if (r13 == null) goto L51;
            this.mLastIndex = r13.getInt(STATE_LAST_SCROLL_INDEX);
            return;
        L51:
            return;
        L6:
            if (r11.mListType != 4) goto L9;
            this.mExtraInfoBridge = new AppStateUsageBridge(r3, r10, this);
            goto L48
        L9:
            if (r11.mListType == 5) goto L48;
            if (r11.mListType != 6) goto L15;
            this.mExtraInfoBridge = new AppStateOverlayBridge(r3, r10, this);
            goto L48
        L15:
            if (r11.mListType != 7) goto L18;
            this.mExtraInfoBridge = new AppStateWriteSettingsBridge(r3, r10, this);
            goto L48
        L18:
            if (r11.mListType != 8) goto L21;
            this.mExtraInfoBridge = new AppStateInstallAppsBridge(r3, r10, this);
            goto L48
        L21:
            if (r11.mListType != 10) goto L24;
            this.mExtraInfoBridge = new AppStateChangeWifiStateBridge(r3, r10, this);
            goto L48
        L24:
            if (r11.mListType != 11) goto L27;
            this.mExtraInfoBridge = new AppStateManageExternalStorageBridge(r3, r10, this);
            goto L48
        L27:
            if (r11.mListType != 12) goto L30;
            this.mExtraInfoBridge = new AppStateAlarmsAndRemindersBridge(r3, r10, this);
            goto L48
        L30:
            if (r11.mListType != 13) goto L33;
            this.mExtraInfoBridge = new AppStateMediaManagementAppsBridge(r3, r10, this);
            goto L48
        L33:
            if (r11.mListType != 14) goto L36;
            this.mExtraInfoBridge = new AppStateLocaleBridge(r3, r10, this, ManageApplications.access$1600(r11));
            goto L48
        L36:
            if (r11.mListType != 16) goto L39;
            this.mExtraInfoBridge = new AppStateLongBackgroundTasksBridge(r3, r10, this);
            goto L48
        L39:
            if (r11.mListType != 18) goto L42;
            this.mExtraInfoBridge = new AppStateNfcTagAppsBridge(r3, r10, this);
            goto L48
        L42:
            if (r11.mListType != 19) goto L45;
            this.mExtraInfoBridge = new AppStateTurnScreenOnBridge(r3, r10, this);
            goto L48
        L45:
            if (r11.mListType != 21) goto L47;
            this.mExtraInfoBridge = new AppStateInteractAcrossProfilesBridge(r3, r10, this);
            goto L48
        L47:
            this.mExtraInfoBridge = null;
            goto L48
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView r3) {
            super.onAttachedToRecyclerView(r3);
            String r0 = this.mManageApplications.getClass().getName() + "_" + this.mManageApplications.mListType;
            this.mRecyclerView = r3;
            OnScrollListener r4 = new OnScrollListener(this, r0);
            this.mOnScrollListener = r4;
            this.mRecyclerView.addOnScrollListener(r4);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView r2) {
            super.onDetachedFromRecyclerView(r2);
            this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mOnScrollListener = null;
            this.mRecyclerView = null;
        }

        public void setCompositeFilter(ApplicationsState.AppFilter r1) {
            this.mCompositeFilter = r1;
            rebuild();
        }

        public void setFilter(AppFilterItem r5) {
            this.mAppFilter = r5;
            int r6 = r5.getFilterType();
            if (this.mManageApplications.mListType != 1) goto L16;
            if (3 != r6) goto L8;
            rebuild(R.id.sort_order_alpha, false);
            return;
        L8:
            if (2 != r6) goto L11;
            rebuild(R.id.sort_order_alpha, false);
            return;
        L11:
            if (16 != r6) goto L13;
            rebuild(R.id.sort_order_alpha, true);
            return;
        L13:
            rebuild(R.id.sort_order_alpha, true);
            return;
        L16:
            if (this.mManageApplications.mListType != 15) goto L18;
            logAppBatteryUsage(r6);
        L18:
            rebuild();
        }

        public void resume(int r3) {
            if (ManageApplications.DEBUG == false) goto L6;
            OLog.i("ManageApplications", "Resume!  mResumed=" + this.mResumed);
        L6:
            if (this.mResumed == true) goto L11;
            this.mResumed = true;
            this.mSession.onResume();
            this.mLastSortMode = r3;
            AppStateBaseBridge r4 = this.mExtraInfoBridge;
            if (r4 == null) goto L10;
            r4.resume(false);
        L10:
            rebuild();
            return;
        L11:
            rebuild(r3, false);
        }

        public void pause() {
            if (this.mResumed == false) goto L8;
            this.mResumed = false;
            this.mSession.onPause();
            AppStateBaseBridge r1 = this.mExtraInfoBridge;
            if (r1 == null) goto L9;
            r1.pause();
            return;
        L9:
            return;
        }

        public void onSaveInstanceState(Bundle r2) {
            r2.putInt(STATE_LAST_SCROLL_INDEX, ((LinearLayoutManager) this.mManageApplications.mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition());
        }

        public void release() {
            this.mSession.onDestroy();
            AppStateBaseBridge r1 = this.mExtraInfoBridge;
            if (r1 == null) goto L6;
            r1.release();
            return;
        }

        public void rebuild(int r2, boolean r3) {
            if (r2 != this.mLastSortMode) goto L6;
            if (r3 == true) goto L6;
            return;
        L6:
            this.mManageApplications.mSortOrder = r2;
            this.mLastSortMode = r2;
            rebuild();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            if (r3 != 2) goto L7;
            return ApplicationHeadViewHolder.Companion.create(r2.getContext());
        L7:
            if (this.mManageApplications.mListType != 11) goto L9;
        L30:
            boolean r4 = true;
        L32:
            return new ApplicationViewHolder(ApplicationViewHolder.newView(r2, r4, this.mManageApplications.mListType));
        L9:
            if (this.mManageApplications.mListType == 13) goto L30;
            if (this.mManageApplications.mListType == 6) goto L30;
            if (this.mManageApplications.mListType == 7) goto L30;
            if (this.mManageApplications.mListType == 8) goto L30;
            if (this.mManageApplications.mListType == 12) goto L30;
            if (this.mManageApplications.mListType == 4) goto L30;
            if (this.mManageApplications.mListType == 10) goto L30;
            if (this.mManageApplications.mListType == 19) goto L30;
            if (this.mManageApplications.mListType == 18) goto L30;
            if (this.mManageApplications.mListType == 21) goto L30;
            r4 = false;
            goto L32
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r1) {
            if (r1 != 0) goto L6;
            return 2;
        L6:
            if (this.mManageApplications.mListType != 17) goto L9;
            return 3;
        L9:
            return 0;
        }

        public void rebuild() {
            boolean r1 = false;
            if (this.mHasReceivedLoadEntries == false) goto L36;
            if (this.mExtraInfoBridge == null) goto L10;
            if (this.mHasReceivedBridgeCallback == false) goto L36;
        L10:
            if (Environment.isExternalStorageEmulated() == false) goto L12;
            this.mWhichSize = 0;
        L13:
            ApplicationsState.AppFilter r0 = this.mAppFilter.getFilter();
            if (this.mCompositeFilter == null) goto L17;
            r0 = new ApplicationsState.CompoundFilter(r0, this.mCompositeFilter);
        L17:
            if (ManageApplications.access$1800(this.mManageApplications) == true) goto L24;
            if (ManageApplications.LIST_TYPES_WITH_INSTANT.contains(Integer.valueOf(this.mManageApplications.mListType)) == false) goto L21;
            ApplicationsState.CompoundFilter r2 = new ApplicationsState.CompoundFilter(r0, ManageApplications.access$1900());
        L22:
            r0 = r2;
            goto L24
        L21:
            r2 = new ApplicationsState.CompoundFilter(r0, ManageApplications.access$2000());
        L24:
            if (this.mLastSortMode != R.id.sort_order_size) goto L32;
            int r3 = this.mWhichSize;
            if (r3 != 1) goto L28;
            final Comparator<ApplicationsState.AppEntry> r4 = ApplicationsState.INTERNAL_SIZE_COMPARATOR;
        L33:
            final ApplicationsState.CompoundFilter r5 = new ApplicationsState.CompoundFilter(r0, ApplicationsState.FILTER_NOT_HIDE);
            ThreadUtils.postOnBackgroundThread(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda5(this, r5, r4));
            return;
        L28:
            if (r3 == 2) goto L30;
            r4 = ApplicationsState.SIZE_COMPARATOR;
            goto L33
        L30:
            r4 = ApplicationsState.EXTERNAL_SIZE_COMPARATOR;
            goto L33
        L32:
            r4 = ApplicationsState.ALPHA_COMPARATOR;
            goto L33
        L12:
            this.mWhichSize = 1;
        L36:
            if (ManageApplications.DEBUG == false) goto L42;
            StringBuilder r6 = new StringBuilder("Not rebuilding until all the app entries loaded. !mHasReceivedLoadEntries=").append(!this.mHasReceivedLoadEntries).append(" !mExtraInfoBridgeNull=");
            if (this.mExtraInfoBridge == null) goto L40;
            r1 = true;
        L40:
            OLog.d("ManageApplications", r6.append(r1).append(" !mHasReceivedBridgeCallback=").append(!this.mHasReceivedBridgeCallback).toString());
            return;
        }

        /* JADX INFO: renamed from: lambda$rebuild$0$com-android-settings-applications-manageapplications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ void m311xa0aac851(ApplicationsState.AppFilter r3, Comparator r4) {
            if (ManageApplications.access$2500(this.mManageApplications) == false) goto L5;
            r3 = new ApplicationsState.CompoundFilter(r3, ApplicationsState.FILTER_WORK);
        L5:
            this.mSession.rebuild(r3, r4, false);
        }

        void filterSearch(String r3) {
            if (this.mSearchFilter != null) goto L6;
            this.mSearchFilter = new SearchFilter(this, null);
        L6:
            if (this.mOriginalEntries != null) goto L9;
            OLog.w("ManageApplications", "Apps haven't loaded completely yet, so nothing can be filtered");
            return;
        L9:
            this.mSearchFilter.filter(r3);
        }

        private static boolean packageNameEquals(PackageItemInfo r2, PackageItemInfo r3) {
            if (r2 == null) goto L13;
            if (r3 == null) goto L13;
            if (r2.packageName == null) goto L13;
            if (r3.packageName == null) goto L13;
            return r2.packageName.equals(r3.packageName);
        L13:
            return false;
        }

        private ArrayList<ApplicationsState.AppEntry> removeDuplicateIgnoringUser(ArrayList<ApplicationsState.AppEntry> r7) {
            int r6 = r7.size();
            ArrayList<ApplicationsState.AppEntry> r0 = new ArrayList(r6);
            ApplicationInfo r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r6) goto L8;
            ApplicationsState.AppEntry r3 = r7.get(r2);
            ApplicationInfo r4 = r3.info;
            if (packageNameEquals(r1, r3.info) == true) goto L7;
            r0.add(r3);
        L7:
            r2 = r2 + 1;
            r1 = r4;
            goto L3
        L8:
            r0.trimToSize();
            return r0;
        }

        private ArrayList<ApplicationsState.AppEntry> filterWhiteAppEntries(ArrayList<ApplicationsState.AppEntry> r5) {
            ArrayList<ApplicationsState.AppEntry> r0 = new ArrayList();
            Iterator<ApplicationsState.AppEntry> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L8;
            ApplicationsState.AppEntry r1 = r6.next();
            if (this.DEFAULT_WHITE_SET.contains(r1.info.packageName) == true) goto L4;
            r0.add(r1);
            goto L4
        L8:
            return r0;
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r6) {
            if (ManageApplications.DEBUG == false) goto L5;
            OLog.d("ManageApplications", "onRebuildComplete size=" + r6.size());
        L5:
            Context r0 = this.mContext;
            AppUtils.preloadTopIcons(r0, r6, r0.getResources().getInteger(R.integer.config_num_visible_app_icons));
            int r1 = this.mAppFilter.getFilterType();
            if (r1 != 17) goto L8;
            r6 = filterWhiteAppEntries(r6);
        L8:
            if (r1 != 0) goto L10;
        L11:
            r6 = removeDuplicateIgnoringUser(r6);
        L12:
            this.mEntries = r6;
            this.mOriginalEntries = r6;
            notifyDataSetChanged();
            int r2 = 0;
            if (getApplicationCount() != 0) goto L15;
            this.mLoadingViewController.showEmpty(false);
        L17:
            if (ManageApplications.access$400(this.mManageApplications) != null) goto L19;
        L30:
            this.mManageApplications.mRecyclerView.post(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda4(this));
            if (this.mManageApplications.mListType != 4) goto L33;
            return;
        L33:
            this.mManageApplications.setHasDisabled(this.mState.haveDisabledApps());
            this.mManageApplications.setHasInstant(this.mState.haveInstantApps());
            return;
        L19:
            if (getApplicationCount() <= 0) goto L30;
            int r7 = this.mEntries.size();
        L21:
            if (r2 >= r7) goto L30;
            ApplicationInfo r3 = this.mEntries.get(r2).info;
            if (r3 == null) goto L29;
            if (TextUtils.equals(ManageApplications.access$400(this.mManageApplications), r3.packageName) == false) goto L29;
            OLog.i("ManageApplications", "jump to: " + r2 + ", package: " + r3.packageName);
            if (this.mHighlightPosition >= 0) goto L30;
            this.mHighlightPosition = r2;
        L29:
            r2 = r2 + 1;
            goto L21
        L15:
            this.mLoadingViewController.showContent(false);
            goto L17
        L10:
            if (r1 != 1) goto L12;
            goto L11
        }

        /* JADX INFO: renamed from: lambda$onRebuildComplete$1$com-android-settings-applications-manageapplications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ void m310xa0f5e0c() {
            if (this.mLastIndex == (-1)) goto L12;
            if (getApplicationCount() <= this.mLastIndex) goto L12;
            LinearLayoutManager r0 = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
            if (r0 == null) goto L9;
            r0.scrollToPosition(this.mLastIndex);
        L9:
            this.mLastIndex = -1;
            this.mHasScrolledToHighlight = true;
            return;
        L12:
            if (this.mHasScrolledToHighlight == true) goto L21;
            int r1 = this.mHighlightPosition;
            if (r1 >= 1) goto L16;
            return;
        L16:
            if (r1 >= getApplicationCount()) goto L23;
            LinearLayoutManager r2 = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
            if (r2 == null) goto L24;
            r2.scrollToPositionWithOffset(this.mHighlightPosition - 1, 0);
            this.mHasScrolledToHighlight = true;
            return;
        L24:
            return;
        L23:
            return;
        }

        void updateLoading() {
            if (this.mHasReceivedLoadEntries == true) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == false) goto L10;
            this.mLoadingViewController.showContent(false);
            return;
        L10:
            this.mLoadingViewController.showLoadingViewDelayed();
            return;
        L5:
            if (this.mSession.getAllApps().size() == 0) goto L7;
            r0 = true;
            goto L8
        }

        @Override // com.android.settings.applications.AppStateBaseBridge.Callback
        public void onExtraInfoUpdated() {
            this.mHasReceivedBridgeCallback = true;
            rebuild();
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
            this.mManageApplications.getActivity().setProgressBarIndeterminateVisibility(r1);
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            rebuild();
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onLoadEntriesCompleted() {
            this.mHasReceivedLoadEntries = true;
            rebuild();
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r5) {
            ArrayList<ApplicationsState.AppEntry> r0 = this.mEntries;
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.size();
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L18;
            ApplicationInfo r3 = this.mEntries.get(r2).info;
            if (r3 != null) goto L13;
            if (TextUtils.equals(r5, r3.packageName) == true) goto L13;
        L17:
            r2 = r2 + 1;
        L13:
            if (TextUtils.equals(ManageApplications.access$2200(this.mManageApplications), r3.packageName) == true) goto L14;
            this.mOnScrollListener.postNotifyItemChange(r2);
            goto L17
        L14:
            rebuild();
            return;
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onLauncherInfoChanged() {
            if (ManageApplications.access$1800(this.mManageApplications) == true) goto L6;
            rebuild();
            return;
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
            if (this.mLastSortMode != R.id.sort_order_size) goto L6;
            rebuild();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int r0 = getApplicationCount();
            if (r0 != 0) goto L5;
        L9:
            if (r0 != 0) goto L12;
            return 0;
        L12:
            return r0 + 1;
        L5:
            if (this.mManageApplications.mListType != 14) goto L7;
        L8:
            r0 = r0 + 1;
            goto L9
        L7:
            if (this.mManageApplications.mListType != 17) goto L9;
            goto L8
        }

        public int getApplicationCount() {
            ArrayList<ApplicationsState.AppEntry> r0 = this.mEntries;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public ApplicationsState.AppEntry getAppEntry(int r1) {
            return this.mEntries.get(r1);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public long getItemId(int r2) {
            int r3 = getApplicationPosition(this.mManageApplications.mListType, r2 - 1);
            if (r3 != this.mEntries.size()) goto L5;
            return -1;
        L5:
            if (r3 != (-1)) goto L8;
            return -1;
        L8:
            return this.mEntries.get(r3).id;
        }

        public boolean isEnabled(int r8) {
            int r0 = getItemViewType(r8);
            if (r0 != 1) goto L5;
        L20:
            int r9 = getApplicationPosition(this.mManageApplications.mListType, r8 - 1);
            if (r9 != (-1)) goto L23;
            return true;
        L23:
            ApplicationsState.AppEntry r10 = this.mEntries.get(r9);
            if (this.mManageApplications.mListType == 4) goto L26;
        L30:
            return true;
        L26:
            if (MinorUtils.INSTANCE.getMinorsModeState(this.mContext) == false) goto L30;
            if (r10.info.packageName.contains("com.zte.usebalance") == false) goto L30;
            return false;
        L5:
            if (r0 == 2) goto L20;
            if (this.mManageApplications.mListType != 5) goto L20;
            int r11 = getApplicationPosition(this.mManageApplications.mListType, r8);
            if (r11 != (-1)) goto L12;
            return true;
        L12:
            ApplicationsState.AppEntry r12 = this.mEntries.get(r11);
            if (this.mManageApplications.mListType == 4) goto L15;
        L19:
            return true;
        L15:
            if (MinorUtils.INSTANCE.getMinorsModeState(this.mContext) == false) goto L19;
            if (r12.info.packageName.contains("com.zte.usebalance") == false) goto L19;
            return false;
        }

        private void bindTitle(BindTitleListener r1) {
            this.mBindTitleListener = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
            if (getItemViewType(r6) == 2) goto L5;
            int r1 = r6 - 1;
            int r0 = getApplicationPosition(this.mManageApplications.mListType, r1);
            if (r0 != (-1)) goto L11;
            return;
        L11:
            ApplicationsState.AppEntry r2 = this.mEntries.get(r0);
            if ((r5 instanceof ApplicationViewHolder) == false) goto L20;
            monitor-enter(r2);
            ((ApplicationViewHolder) r5).initCardItemInAdapter(getItemCount() - 1, r1);     // Catch: Throwable -> L17
            ((ApplicationViewHolder) r5).setTitle(r2.label, null);     // Catch: Throwable -> L17
            updateIcon((ApplicationViewHolder) r5, r2);     // Catch: Throwable -> L17
            updateSummary((ApplicationViewHolder) r5, r2);     // Catch: Throwable -> L17
            updateSwitch((ApplicationViewHolder) r5, r2);     // Catch: Throwable -> L17
            ((ApplicationViewHolder) r5).updateDisableView(r2.info);     // Catch: Throwable -> L17
            monitor-exit(r2);     // Catch: Throwable -> L17
            ((ApplicationViewHolder) r5).setEnabled(isEnabled(r6));
            return;
        L17:
            th = move-exception;
            throw th;
        L20:
            return;
        L5:
            if ((r5 instanceof ApplicationHeadViewHolder) == false) goto L23;
            this.mBindTitleListener.bindTitle((ApplicationHeadViewHolder) r5);
            return;
        }

        private void updateIcon(final ApplicationViewHolder r3, final ApplicationsState.AppEntry r4) {
            if (r4.icon != null) goto L5;
            ApplicationStateExKt.ensureIconLockedEx(r4, this.mContext);
        L5:
            Drawable r0 = r4.icon;
            if (r0 != null) goto L8;
        L10:
            ThreadUtils.postOnBackgroundThread(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda3(this, r4, r3));
            return;
        L8:
            if (r4.mounted == false) goto L10;
            r3.setIcon(r0);
        }

        /* JADX INFO: renamed from: lambda$updateIcon$3$com-android-settings-applications-manageapplications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ void m312xd3c4d3b5(ApplicationsState.AppEntry r1, final ApplicationViewHolder r2) {
            final Drawable r0 = AppUtils.getIcon(this.mContext, r1);
            if (r0 == null) goto L6;
            ThreadUtils.postOnMainThread(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda2(r2, r0));
            return;
        }

        static /* synthetic */ void lambda$updateIcon$2(ApplicationViewHolder r0, Drawable r1) {
            r0.setIcon(r1);
        }

        private void updateSummary(ApplicationViewHolder r4, ApplicationsState.AppEntry r5) {
            int r0 = this.mManageApplications.mListType;
            if (r0 == 1) goto L22;
            if (r0 == 4) goto L14;
            if (r0 != 6) goto L9;
            r4.setSummary(DrawOverlayDetails.getSummary(this.mContext, r5));
            return;
        L9:
            if (r0 == 21) goto L11;
            r4.updateSizeText(r5, this.mManageApplications.mInvalidSizeStr, this.mWhichSize);
            return;
        L11:
            r4.setSummary(InteractAcrossProfilesDetails.getSummary(this.mContext, r5));
            return;
        L14:
            if (r5.extraInfo != null) goto L16;
            r4.setSummary(null);
            return;
        L16:
            if (new AppStateUsageBridge.UsageState((AppStateAppOpsBridge.PermissionState) r5.extraInfo).isPermissible() == false) goto L18;
            int r3 = R.string.app_permission_summary_allowed;
        L19:
            r4.setSummary(r3);
            return;
        L18:
            r3 = R.string.app_permission_summary_not_allowed;
            goto L19
        L22:
            if (r5.extraInfo != null) goto L24;
        L26:
            r4.setSummary(null);
            return;
        L24:
            if ((r5.extraInfo instanceof AppStateNotificationBridge.NotificationsSentState) == false) goto L26;
            r4.setSummary(AppStateNotificationBridge.getSummary(this.mContext, (AppStateNotificationBridge.NotificationsSentState) r5.extraInfo, this.mLastSortMode));
        }

        private void updateSwitch(ApplicationViewHolder r6, final ApplicationsState.AppEntry r7) {
            int r0 = this.mManageApplications.mListType;
            if (r0 != 1) goto L5;
            r6.updateSwitch(((AppStateNotificationBridge) this.mExtraInfoBridge).getSwitchOnCheckedListener(r7), AppStateNotificationBridge.enableSwitch(r7), AppStateNotificationBridge.checkSwitch(r7));
            r6.setSwitchOnTouchListener(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda0(this, r7));
            if (r7.extraInfo != null) goto L26;
        L28:
            r6.setSummary(null);
            return;
        L26:
            if ((r7.extraInfo instanceof AppStateNotificationBridge.NotificationsSentState) == false) goto L28;
            r6.setSummary(AppStateNotificationBridge.getSummary(this.mContext, (AppStateNotificationBridge.NotificationsSentState) r7.extraInfo, this.mLastSortMode));
            return;
        L5:
            if (r0 != 4) goto L7;
        L19:
            r6.updateSwitch(((AppStateBaseSwitchInterface) this.mExtraInfoBridge).getSwitchOnCheckedListener(r7), ((AppStateBaseSwitchInterface) this.mExtraInfoBridge).enableSwitch(r7), ((AppStateBaseSwitchInterface) this.mExtraInfoBridge).checkSwitch(r7));
            if (this.mManageApplications.mListType != 8) goto L22;
            r6.setSwitchOnTouchListener(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda1(this, r7));
            return;
        L22:
            r6.setSwitchOnTouchListener(null);
            return;
        L7:
            if (r0 == 21) goto L19;
            if (r0 == 6) goto L19;
            if (r0 == 7) goto L19;
            if (r0 == 8) goto L19;
            if (r0 == 18) goto L19;
            if (r0 == 19) goto L19;
            switch(r0) {
                case 10: goto L19;
                case 11: goto L19;
                case 12: goto L19;
                case 13: goto L19;
                default: goto L33;
            };
        }

        /* JADX INFO: renamed from: lambda$updateSwitch$4$com-android-settings-applications-manageapplications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ boolean m313xe167f831(ApplicationsState.AppEntry r2, View r3, MotionEvent r4) {
            return RiskPermissionControlGuard.interceptOnActionUp(this.mContext, r2.info.packageName, UserHandle.getUserId(r2.info.uid), 64, r4);
        }

        /* JADX INFO: renamed from: lambda$updateSwitch$5$com-android-settings-applications-manageapplications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ boolean m314xc71354b2(ApplicationsState.AppEntry r2, View r3, MotionEvent r4) {
            return RiskPermissionControlGuard.interceptOnActionUp(this.mContext, r2.info.packageName, UserHandle.getUserId(r2.info.uid), 16, r4);
        }
    }

    private static final enum CollapsingToolbarLayoutState extends Enum<CollapsingToolbarLayoutState> {
        private static final /* synthetic */ CollapsingToolbarLayoutState[] $VALUES = null;
        public static final CollapsingToolbarLayoutState COLLAPSED = null;
        public static final CollapsingToolbarLayoutState EXPANDED = null;
        public static final CollapsingToolbarLayoutState INTERNEDIATE = null;

        private static /* synthetic */ CollapsingToolbarLayoutState[] $values() {
            return new CollapsingToolbarLayoutState[]{EXPANDED, COLLAPSED, INTERNEDIATE};
        }

        private CollapsingToolbarLayoutState(String r1, int r2) {
            super(r1, r2);
        }

        public static CollapsingToolbarLayoutState valueOf(String r1) {
            return (CollapsingToolbarLayoutState) Enum.valueOf(CollapsingToolbarLayoutState.class, r1);
        }

        public static CollapsingToolbarLayoutState[] values() {
            return (CollapsingToolbarLayoutState[]) $VALUES.clone();
        }

        static {
            EXPANDED = new CollapsingToolbarLayoutState("EXPANDED", 0);
            COLLAPSED = new CollapsingToolbarLayoutState("COLLAPSED", 1);
            INTERNEDIATE = new CollapsingToolbarLayoutState("INTERNEDIATE", 2);
            $VALUES = $values();
        }
    }

    static class FilterSpinnerAdapter extends ArrayAdapter<CharSequence> {
        private final Context mContext;
        private final ArrayList<AppFilterItem> mFilterOptions;
        private final ManageApplications mManageApplications;

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public FilterSpinnerAdapter(ManageApplications r3) {
            super(r3.getContext(), R.layout.filter_spinner_item);
            this.mFilterOptions = new ArrayList();
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.mContext = r3.getContext();
            this.mManageApplications = r3;
        }

        public AppFilterItem getFilter(int r1) {
            return this.mFilterOptions.get(r1);
        }

        public void setFilterEnabled(int r1, boolean r2) {
            if (r2 == false) goto L4;
            enableFilter(r1);
            return;
        L4:
            disableFilter(r1);
        }

        public void enableFilter(int r11) {
            AppFilterItem r12 = AppFilterRegistry.getInstance().get(r11);
            if (this.mFilterOptions.contains(r12) == false) goto L6;
            return;
        L6:
            if (ManageApplications.DEBUG == false) goto L8;
            OLog.d("ManageApplications", "Enabling filter " + this.mContext.getText(r12.getTitle()));
        L8:
            this.mFilterOptions.add(r12);
            Collections.sort(this.mFilterOptions);
            if (this.mFilterOptions.size() <= 1) goto L11;
            boolean r0 = true;
        L12:
            updateFilterView(r0);
            notifyDataSetChanged();
            if (this.mFilterOptions.size() != 1) goto L19;
            if (ManageApplications.DEBUG == false) goto L17;
            OLog.d("ManageApplications", "Auto selecting filter " + r12 + HanziToPinyin.Token.SEPARATOR + this.mContext.getText(r12.getTitle()));
        L17:
            ManageApplications.access$800(this.mManageApplications).setSelection(0);
            this.mManageApplications.onItemSelected(null, null, 0, 0);
        L19:
            if (this.mFilterOptions.size() <= 1) goto L24;
            int r4 = this.mFilterOptions.indexOf(AppFilterRegistry.getInstance().get(ManageApplications.access$900(this.mManageApplications)));
            if (r4 == (-1)) goto L25;
            ManageApplications.access$800(this.mManageApplications).setSelection(r4);
            this.mManageApplications.onItemSelected(null, null, r4, 0);
            return;
        L25:
            return;
        L24:
            return;
        L11:
            r0 = false;
            goto L12
        }

        public void disableFilter(int r11) {
            AppFilterItem r12 = AppFilterRegistry.getInstance().get(r11);
            if (this.mFilterOptions.remove(r12) == true) goto L6;
            return;
        L6:
            if (ManageApplications.DEBUG == false) goto L8;
            OLog.d("ManageApplications", "Disabling filter " + r12 + HanziToPinyin.Token.SEPARATOR + this.mContext.getText(r12.getTitle()));
        L8:
            Collections.sort(this.mFilterOptions);
            boolean r2 = true;
            if (this.mFilterOptions.size() > 1) goto L12;
            r2 = false;
        L12:
            updateFilterView(r2);
            notifyDataSetChanged();
            if (ManageApplications.access$1000(this.mManageApplications) == r12) goto L15;
            return;
        L15:
            if (this.mFilterOptions.size() > 0) goto L17;
            return;
        L17:
            if (ManageApplications.DEBUG == false) goto L19;
            OLog.d("ManageApplications", "Auto selecting filter " + this.mFilterOptions.get(0) + this.mContext.getText(this.mFilterOptions.get(0).getTitle()));
        L19:
            ManageApplications.access$800(this.mManageApplications).setSelection(0);
            this.mManageApplications.onItemSelected(null, null, 0, 0);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.mFilterOptions.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public CharSequence getItem(int r2) {
            return this.mContext.getText(this.mFilterOptions.get(r2).getTitle());
        }

        void updateFilterView(boolean r1) {
            if (r1 == false) goto L4;
            this.mManageApplications.mSpinnerHeader.setVisibility(0);
            return;
        L4:
            this.mManageApplications.mSpinnerHeader.setVisibility(8);
        }
    }

    private void autoSetCollapsingToolbarLayoutScrolling() {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_manageapplications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String r1) {
        return false;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_manageapplications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    void updateOptionsMenu() {
    }

    public ManageApplications() {
        this.mSortOrder = R.id.sort_order_alpha;
        this.mIsWorkOnly = false;
        this.mIsPrivateProfileOnly = false;
        this.mIsPersonalOnly = false;
        this.tvTitle = null;
        this.state = null;
        this.mPackageName = null;
    }

    static /* synthetic */ AppFilterItem access$1000(ManageApplications r0) {
        return r0.mFilter;
    }

    static /* synthetic */ TextView access$1100(ManageApplications r0) {
        return r0.tvTitle;
    }

    static /* synthetic */ View access$1200(ManageApplications r0) {
        return r0.mLoadingContainer;
    }

    static /* synthetic */ View access$1300(ManageApplications r0) {
        return r0.mContentLayout;
    }

    static /* synthetic */ View access$1400(ManageApplications r0) {
        return r0.mEmptyView;
    }

    static /* synthetic */ IUsageStatsManager access$1500(ManageApplications r0) {
        return r0.mUsageStatsManager;
    }

    static /* synthetic */ UserManager access$1600(ManageApplications r0) {
        return r0.mUserManager;
    }

    static /* synthetic */ NotificationBackend access$1700(ManageApplications r0) {
        return r0.mNotificationBackend;
    }

    static /* synthetic */ boolean access$1800(ManageApplications r0) {
        return r0.mShowSystem;
    }

    static /* synthetic */ ApplicationsState.AppFilter access$1900() {
        return FILTER_DOWNLOADED_AND_LAUNCHER_AND_INSTANT_WITH_BLUETOOTH;
    }

    static /* synthetic */ OPageStatus access$200(ManageApplications r0) {
        return r0.mEmptyDesc;
    }

    static /* synthetic */ ApplicationsState.AppFilter access$2000() {
        return FILTER_DOWNLOADED_AND_LAUNCHER_WITH_BLUETOOTH;
    }

    static /* synthetic */ String access$2200(ManageApplications r0) {
        return r0.mCurrentPkgName;
    }

    static /* synthetic */ boolean access$2500(ManageApplications r0) {
        return r0.mIsWorkOnly;
    }

    static /* synthetic */ String access$400(ManageApplications r0) {
        return r0.mPackageName;
    }

    static /* synthetic */ void access$500(ManageApplications r0, boolean r1) {
        r0.setCanInstallApps(r1);
    }

    static /* synthetic */ Spinner access$800(ManageApplications r0) {
        return r0.mFilterSpinner;
    }

    static /* synthetic */ int access$900(ManageApplications r0) {
        return r0.mFilterType;
    }

    static {
        DEBUG = Build.IS_DEBUGGABLE;
        LIST_TYPES_WITH_INSTANT = new ArraySet(Arrays.asList(new Integer[]{0, 3}));
        FILTER_DOWNLOADED_AND_LAUNCHER_WITH_BLUETOOTH = allowlistPackage(ApplicationsState.FILTER_DOWNLOADED_AND_LAUNCHER, PACKAGE_BLUETOOTH);
        FILTER_DOWNLOADED_AND_LAUNCHER_AND_INSTANT_WITH_BLUETOOTH = allowlistPackage(ApplicationsState.FILTER_DOWNLOADED_AND_LAUNCHER_AND_INSTANT, PACKAGE_BLUETOOTH);
    }

    private static ApplicationsState.AppFilter allowlistPackage(final ApplicationsState.AppFilter r1, final String r2) {
        return new AnonymousClass1(r1, r2);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context r2) {
        super.onAttach(r2);
        this.mListType = getListType();
        this.mPackageName = getPackageData(requireActivity().getIntent());
        OLog.i("ManageApplications", "getPackageData: " + this.mPackageName);
    }

    private static String getPackageData(Intent r2) {
        Uri r3 = r2.getData();
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.getScheme().equals("package") == true) goto L7;
        return null;
    L7:
        return r3.getSchemeSpecificPart();
    }

    private static String getClassName(Intent r1, Bundle r2) {
        if (r2 == null) goto L4;
        String r3 = r2.getString("classname");
    L5:
        if (r3 == null) goto L7;
        return r3;
    L7:
        return r1.getComponent().getClassName();
    L4:
        r3 = null;
        goto L5
    }

    private int getListType() {
        Bundle r0 = getArguments();
        if (r0.containsKey(EXTRA_LIST_TYPE) == true) goto L5;
        String r3 = getClassName(getActivity().getIntent(), r0);
        return ManageApplicationsUtil.LIST_TYPE_MAP.getOrDefault(r3, 0).intValue();
    L5:
        return r0.getInt(EXTRA_LIST_TYPE);
    }

    public void com_android_settings_applications_manageapplications_ManageApplications__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        FragmentActivity r0 = getActivity();
        if (r0.isFinishing() == false) goto L5;
        return;
    L5:
        setHasOptionsMenu(true);
        this.mUserManager = (UserManager) r0.getSystemService(UserManager.class);
        this.mApplicationsState = ApplicationsState.getInstance(r0.getApplication());
        Intent r2 = r0.getIntent();
        Bundle r3 = getArguments();
        int r4 = this.mListType;
        if (r4 != 3) goto L8;
        if (r3 != null) goto L22;
    L24:
        this.mListType = 0;
    L25:
        this.mSortOrder = R.id.sort_order_size;
    L26:
        AppFilterRegistry r1 = AppFilterRegistry.getInstance();
        this.mFilter = r1.get(r1.getDefaultFilterType(this.mListType));
        int r5 = Utils.getSecureTargetUser(getActivity().getActivityToken(), this.mUserManager, null, getIntent().getExtras()).getIdentifier();
        this.mUserId = r5;
        this.mWorkUserId = this.mUserManager.getCredentialOwnerProfile(r5);
        this.mIsWorkOnly = this.mUserManager.isManagedProfile(this.mUserId);
        this.mExpandSearch = r0.getIntent().getBooleanExtra(EXTRA_EXPAND_SEARCH_VIEW, false);
        if (r9 == null) goto L29;
        this.mSortOrder = r9.getInt(EXTRA_SORT_ORDER, this.mSortOrder);
        this.mShowSystem = r9.getBoolean(EXTRA_SHOW_SYSTEM, this.mShowSystem);
        this.mFilterType = r9.getInt(EXTRA_FILTER_TYPE, 4);
        this.mExpandSearch = r9.getBoolean(EXTRA_EXPAND_SEARCH_VIEW);
    L29:
        this.mInvalidSizeStr = r0.getText(R.string.invalid_size_value);
        retrieveAppEntry();
        return;
    L22:
        if (r3.containsKey("volumeUuid") == false) goto L24;
        this.mVolumeUuid = r3.getString("volumeUuid");
        this.mStorageType = r3.getInt("storageType", 0);
        goto L25
    L8:
        if (r4 != 9) goto L10;
        this.mSortOrder = R.id.sort_order_size;
        goto L26
    L10:
        if (r4 != 18) goto L12;
        this.mShowSystem = true;
        goto L26
    L12:
        if (r4 != 5) goto L14;
        this.mShowSystem = true;
        goto L26
    L14:
        if (r4 != 6) goto L26;
        reportIfRestrictedSawIntent(r2);
        goto L26
    }

    private void reportIfRestrictedSawIntent(Intent r4) {
        Uri r5 = r4.getData();     // Catch: RemoteException -> L19
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals("package", r5.getScheme()) == false) goto L23;
        IBinder r3 = getActivity().getActivityToken();     // Catch: RemoteException -> L19
        int r6 = ActivityManager.getService().getLaunchedFromUid(r3);     // Catch: RemoteException -> L19
        if (r6 != (-1)) goto L12;
        OLog.w("ManageApplications", "Error obtaining calling uid");     // Catch: RemoteException -> L19
        return;
    L12:
        IPlatformCompat r7 = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));     // Catch: RemoteException -> L19
        if (r7 != null) goto L16;
        OLog.w("ManageApplications", "Error obtaining IPlatformCompat service");     // Catch: RemoteException -> L19
        return;
    L16:
        r7.reportChangeByUid(135920175, r6);     // Catch: RemoteException -> L19
        return;
    L23:
        return;
    L19:
        e = move-exception;
        OLog.w("ManageApplications", "Error reporting SAW intent restriction", e);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        if (getActivity().isFinishing() == false) goto L6;
        return null;
    L6:
        if (this.mListType == 6) goto L8;
    L11:
        View r8 = r5.inflate(R.layout.manage_applications_apps2, null);
        this.mRootView = r8;
        this.mLoadingContainer = r8.findViewById(R.id.oui_loading_container);
        this.mContentLayout = this.mRootView.findViewById(R.id.content_layout);
        this.mEmptyView = this.mRootView.findViewById(R.id.empty_container);
        OPageStatus r9 = (OPageStatus) this.mRootView.findViewById(R.id.manager_status_loading);
        this.mEmptyDesc = r9;
        r9.setTitle(getString(R.string.no_apps_with_permission));
        OFloatingTitleBar r10 = (OFloatingTitleBar) this.mRootView.findViewById(R.id.view_title);
        this.mTitleBar = r10;
        this.tvTitle = (TextView) r10.findViewById(R.id.center_title);
        this.mRecyclerView = (RecyclerView) this.mRootView.findViewById(R.id.apps_list);
        ApplicationsAdapter r11 = new ApplicationsAdapter(this.mApplicationsState, this, this.mFilter, r7);
        this.mApplications = r11;
        if (r7 == null) goto L14;
        ApplicationsAdapter.access$002(r11, r7.getBoolean(EXTRA_HAS_ENTRIES, false));
        ApplicationsAdapter.access$102(this.mApplications, r7.getBoolean(EXTRA_HAS_BRIDGE, false));
    L14:
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.mRecyclerView.setAdapter(this.mApplications);
        if ((r6 instanceof PreferenceFrameLayout) == false) goto L17;
        this.mRootView.getLayoutParams().removeBorders = true;
    L17:
        createHeader();
        int r12 = getTitleResId(requireActivity().getIntent(), getArguments());
        if (r12 <= 0) goto L20;
        this.mTitleBar.setCenterTitle(getString(r12));
    L20:
        ApplicationsAdapter.access$300(this.mApplications, new AnonymousClass2(this));
        initCtsTestItem();
        return this.mRootView;
    L8:
        if (Utils.isSystemAlertWindowEnabled(getContext()) == true) goto L11;
        this.mRootView = r5.inflate(R.layout.manage_applications_apps_unsupported, null);
        setHasOptionsMenu(false);
        return this.mRootView;
    }

    void initCtsTestItem() {
        FrameLayout r0 = (FrameLayout) this.mRootView.findViewById(R.id.cts_item_container);
        final OSwitch r1 = (OSwitch) r0.findViewById(R.id.cts_item_switch);
        r1.setChecked(getCanInstallApps());
        r0.setOnClickListener(new AnonymousClass3(this, r1));
        r1.setClickable(false);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        UIUtils.fitMaskTitle(this, this.mRootView, this.mRecyclerView);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mRecyclerView);
        super.onViewCreated(r3, r4);
    }

    void createHeader() {
        FragmentActivity r0 = getActivity();
        FrameLayout r1 = (FrameLayout) this.mRootView.findViewById(R.id.pinned_header);
        View r2 = r0.getLayoutInflater().inflate(R.layout.apps_filter_spinner, r1, false);
        this.mSpinnerHeader = r2;
        this.mFilterSpinner = (Spinner) r2.findViewById(R.id.filter_spinner);
        FilterSpinnerAdapter r3 = new FilterSpinnerAdapter(this);
        this.mFilterAdapter = r3;
        this.mFilterSpinner.setAdapter(r3);
        this.mFilterSpinner.setOnItemSelectedListener(this);
        r1.addView(this.mSpinnerHeader, 0);
        int r4 = AppFilterRegistry.getInstance().getDefaultFilterType(this.mListType);
        this.mFilterAdapter.enableFilter(r4);
        if (this.mListType != 0) goto L8;
        if (UserManager.get(getActivity()).getUserProfiles().size() <= 1) goto L8;
        this.mFilterAdapter.enableFilter(8);
        this.mFilterAdapter.enableFilter(9);
    L8:
        if (this.mListType != 1) goto L11;
        this.mFilterAdapter.enableFilter(2);
        this.mFilterAdapter.enableFilter(3);
        this.mFilterAdapter.enableFilter(16);
        this.mFilterAdapter.enableFilter(4);
    L11:
        if (this.mListType != 5) goto L14;
        this.mFilterAdapter.enableFilter(1);
    L14:
        if (this.mListType != 15) goto L16;
        this.mFilterAdapter.enableFilter(4);
        this.mFilterAdapter.enableFilter(21);
        this.mFilterAdapter.enableFilter(22);
        this.mFilterAdapter.enableFilter(23);
    L16:
        setCompositeFilter();
    }

    static ApplicationsState.AppFilter getCompositeFilter(int r0, int r1, String r2) {
        ApplicationsState.VolumeFilter r3 = new ApplicationsState.VolumeFilter(r2);
        if (r0 != 3) goto L6;
        return r3;
    L6:
        if (r0 == 9) goto L8;
        return null;
    L8:
        return new ApplicationsState.CompoundFilter(ApplicationsState.FILTER_GAMES, r3);
    }

    @Override // com.android.settings.base.BaseFragment
    public int getMetricsCategory() {
        switch(this.mListType) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L4;
            case 3: goto L38;
            case 4: goto L36;
            case 5: goto L34;
            case 6: goto L32;
            case 7: goto L30;
            case 8: goto L28;
            case 9: goto L26;
            case 10: goto L24;
            case 11: goto L22;
            case 12: goto L20;
            case 13: goto L18;
            case 14: goto L16;
            case 15: goto L14;
            case 16: goto L12;
            case 17: goto L10;
            case 18: goto L8;
            case 19: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 2020;
    L8:
        return 2016;
    L10:
        return 1989;
    L12:
        return 1975;
    L14:
        return 1931;
    L16:
        return BuildConfig.SDK_VERSION_CODE;
    L18:
        return 1874;
    L20:
        return 1869;
    L22:
        return 1822;
    L24:
        return 338;
    L26:
        return 838;
    L28:
        return 808;
    L30:
        return 1976;
    L32:
        return UCharacter.UnicodeBlock.BASSA_VAH_ID;
    L34:
        return 184;
    L36:
        return 95;
    L38:
        return 182;
    L40:
        return 133;
    L42:
        return 65;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        updateView();
        ApplicationsAdapter r0 = this.mApplications;
        if (r0 == null) goto L6;
        r0.updateLoading();
        return;
    }

    public void com_android_settings_applications_manageapplications_ManageApplications__onResume$___twin___() {
        super.onResume();
        ApplicationsAdapter r0 = this.mApplications;
        if (r0 == null) goto L6;
        r0.resume(this.mSortOrder);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putInt(EXTRA_SORT_ORDER, this.mSortOrder);
        r3.putInt(EXTRA_FILTER_TYPE, this.mFilter.getFilterType());
        r3.putBoolean(EXTRA_SHOW_SYSTEM, this.mShowSystem);
        SearchView r0 = this.mSearchView;
        if (r0 == null) goto L5;
        r3.putBoolean(EXTRA_EXPAND_SEARCH_VIEW, !r0.isIconified());
    L5:
        ApplicationsAdapter r1 = this.mApplications;
        if (r1 == null) goto L9;
        r3.putBoolean(EXTRA_HAS_ENTRIES, ApplicationsAdapter.access$000(r1));
        r3.putBoolean(EXTRA_HAS_BRIDGE, ApplicationsAdapter.access$100(this.mApplications));
        this.mApplications.onSaveInstanceState(r3);
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ApplicationsAdapter r0 = this.mApplications;
        if (r0 == null) goto L24;
        int r1 = r0.getApplicationCount();
        Object r2 = ApplicationsAdapter.access$600(this.mApplications);
        FragmentActivity r3 = getActivity();
        if (this.mPackageName == null) goto L20;
        if (r1 <= 0) goto L20;
        if ((r2 instanceof AppStateBaseSwitchInterface) == false) goto L20;
        if (r3 == null) goto L20;
        int r4 = 0;
    L11:
        if (r4 >= r1) goto L20;
        ApplicationsState.AppEntry r5 = (ApplicationsState.AppEntry) ApplicationsAdapter.access$700(this.mApplications).get(r4);
        if (this.mPackageName.equals(r5.info.packageName) == true) goto L14;
        r4 = r4 + 1;
        goto L11
    L14:
        boolean r6 = ((AppStateBaseSwitchInterface) r2).checkSwitch(r5);
        OLog.i("ManageApplications", "isAppSpecific setResult: " + r6);
        if (r6 == false) goto L17;
        int r7 = RESULT_OK;
    L18:
        r3.setResult(r7);
        goto L20
    L17:
        r7 = RESULT_CANCELED;
    L20:
        this.mApplications.pause();
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ApplicationsAdapter r0 = this.mApplications;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.mRootView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        if (r1 != 1) goto L20;
        String r4 = this.mCurrentPkgName;
        if (r4 == null) goto L21;
        int r5 = this.mListType;
        if (r5 != 1) goto L9;
    L18:
        ApplicationsAdapter.access$600(this.mApplications).forceUpdate(this.mCurrentPkgName, this.mCurrentUid);
        return;
    L9:
        if (r5 == 5) goto L18;
        if (r5 == 6) goto L18;
        if (r5 == 7) goto L18;
        if (r5 == 18) goto L18;
        this.mApplicationsState.requestSize(r4, UserHandle.getUserId(this.mCurrentUid));
        return;
    L21:
        return;
    }

    private void setCompositeFilter() {
        ApplicationsState.AppFilter r0 = getCompositeFilter(this.mListType, this.mStorageType, this.mVolumeUuid);
        if (r0 != null) goto L6;
        r0 = this.mFilter.getFilter();
    L6:
        if (this.mIsWorkOnly == false) goto L8;
        r0 = new ApplicationsState.CompoundFilter(r0, ApplicationsState.FILTER_WORK);
    L8:
        boolean r1 = this.mIsPrivateProfileOnly;
        if (this.mIsPersonalOnly == false) goto L11;
    L13:
        r0 = new ApplicationsState.CompoundFilter(r0, ApplicationsState.FILTER_PERSONAL);
    L14:
        this.mApplications.setCompositeFilter(r0);
        return;
    L11:
        if (this.mIsWorkOnly == true) goto L14;
        if (r1 == true) goto L14;
        goto L13
    }

    private void startApplicationDetailsActivity() {
        if (this.mListType != 21) goto L7;
        startAppInfoFragment(InteractAcrossProfilesDetails.class, R.string.interact_across_profiles_title);
        return;
    }

    private void startAppInfoFragment(Class<?> r7, int r8) {
        AppInfoBase.startAppInfoFragment(r7, r8, this.mCurrentPkgName, this.mCurrentUid, this, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        this.mOptionsMenu = r2;
        r3.inflate(R.menu.manage_apps, r2);
        updateOptionsMenu();
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem r1) {
        ViewCompat.setNestedScrollingEnabled(this.mRecyclerView, false);
        return true;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem r1) {
        ViewCompat.setNestedScrollingEnabled(this.mRecyclerView, true);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu r1) {
        updateOptionsMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyOptionsMenu() {
        this.mOptionsMenu = null;
    }

    int getHelpResource() {
        if (this.mListType == 1) goto L6;
        return R.string.help_uri_apps;
    L6:
        return R.string.help_uri_notifications;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r4) {
        int r0 = r4.getItemId();
        int r5 = r4.getItemId();
        if (r5 != R.id.sort_order_alpha) goto L5;
    L23:
        ApplicationsAdapter r6 = this.mApplications;
        if (r6 == null) goto L26;
        r6.rebuild(r0, false);
    L26:
        updateOptionsMenu();
        return true;
    L5:
        if (r5 == R.id.sort_order_size) goto L23;
        if (r5 != R.id.show_system) goto L10;
    L22:
        this.mShowSystem = !this.mShowSystem;
        this.mApplications.rebuild();
        goto L26
    L10:
        if (r5 == R.id.hide_system) goto L22;
        if (r5 != R.id.reset_app_preferences) goto L16;
        return true;
    L16:
        if (r5 != R.id.advanced) goto L26;
        if (this.mListType == 1) goto L21;
        startActivityForResult(new Intent("android.settings.MANAGE_DEFAULT_APPS_SETTINGS").setPackage(getContext().getPackageManager().getPermissionControllerPackageName()), 2);
    L21:
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (this.mApplications != null) goto L5;
        return;
    L5:
        int r4 = ApplicationsAdapter.getApplicationPosition(this.mListType, this.mRecyclerView.getChildAdapterPosition(r3));
        if (r4 != (-1)) goto L10;
        OLog.w("ManageApplications", "Cannot find position for child, skipping onClick handling");
        return;
    L10:
        if (this.mApplications.getApplicationCount() <= r4) goto L13;
        ApplicationsState.AppEntry r5 = this.mApplications.getAppEntry(r4);
        this.mCurrentPkgName = r5.info.packageName;
        this.mCurrentUid = r5.info.uid;
        startApplicationDetailsActivity();
        ViewCompat.setNestedScrollingEnabled(this.mRecyclerView, true);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        this.mFilter = this.mFilterAdapter.getFilter(r3);
        setCompositeFilter();
        this.mApplications.setFilter(this.mFilter);
        if (DEBUG == false) goto L6;
        OLog.d("ManageApplications", "Selecting filter " + getContext().getText(this.mFilter.getTitle()));
        return;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String r1) {
        this.mApplications.filterSearch(r1);
        return false;
    }

    public void updateView() {
        updateOptionsMenu();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.invalidateOptionsMenu();
        return;
    }

    public void setHasDisabled(boolean r3) {
        if (this.mListType == 0) goto L5;
        return;
    L5:
        this.mFilterAdapter.setFilterEnabled(5, r3);
        this.mFilterAdapter.setFilterEnabled(7, r3);
    }

    public void setHasInstant(boolean r3) {
        if (LIST_TYPES_WITH_INSTANT.contains(Integer.valueOf(this.mListType)) == false) goto L6;
        this.mFilterAdapter.setFilterEnabled(6, r3);
        return;
    }

    public static int getTitleResId(Intent r12, Bundle r13) {
        if (r13.containsKey(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RESID) == false) goto L5;
        int r0 = r13.getInt(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RESID);
    L6:
        boolean r2 = r13.containsKey(EXTRA_LIST_TYPE);
        int r3 = R.string.turn_screen_on_title;
        if (r2 == false) goto L42;
        if (r0 != 0) goto L42;
        int r1 = r13.getInt(EXTRA_LIST_TYPE);
        if (r1 != 11) goto L13;
        r0 = R.string.manage_external_storage_title;
        goto L42
    L13:
        if (r1 != 6) goto L16;
        r0 = R.string.system_alert_window_settings;
        goto L42
    L16:
        if (r1 != 13) goto L19;
        r0 = R.string.media_management_apps_title;
        goto L42
    L19:
        if (r1 != 7) goto L22;
        r0 = R.string.write_settings;
        goto L42
    L22:
        if (r1 != 8) goto L25;
        r0 = R.string.install_other_apps;
        goto L42
    L25:
        if (r1 != 12) goto L28;
        r0 = R.string.alarms_and_reminders_title;
        goto L42
    L28:
        if (r1 != 4) goto L31;
        r0 = R.string.usage_access;
        goto L42
    L31:
        if (r1 != 10) goto L34;
        r0 = R.string.change_wifi_state_title;
        goto L42
    L34:
        if (r1 != 19) goto L37;
        r0 = R.string.turn_screen_on_title;
        goto L42
    L37:
        if (r1 != 18) goto L40;
        r0 = R.string.change_nfc_tag_apps_title;
        goto L42
    L40:
        if (r1 != 21) goto L42;
        r0 = R.string.interact_across_profiles_title;
    L42:
        String r14 = getClassName(r12, r13);
        if (r14.equals(Settings.OverlaySettingsActivity.class.getName()) == false) goto L45;
    L72:
        r3 = R.string.system_alert_window_settings;
    L73:
        if (r3 != 0) goto L76;
        return R.string.application_info_label;
    L76:
        return r3;
    L45:
        if (r14.equals(Settings.AppDrawOverlaySettingsActivity.class.getName()) == true) goto L72;
        if (r14.equals(Settings.ManageExternalStorageActivity.class.getName()) == false) goto L51;
        r3 = R.string.manage_external_storage_title;
        goto L73
    L51:
        if (r14.equals(Settings.MediaManagementAppsActivity.class.getName()) == false) goto L54;
        r3 = R.string.media_management_apps_title;
        goto L73
    L54:
        if (r14.equals(Settings.WriteSettingsActivity.class.getName()) == false) goto L57;
        r3 = R.string.write_settings;
        goto L73
    L57:
        if (r14.equals(Settings.ManageExternalSourcesActivity.class.getName()) == false) goto L60;
        r3 = R.string.install_other_apps;
        goto L73
    L60:
        if (r14.equals(Settings.AlarmsAndRemindersActivity.class.getName()) == false) goto L63;
        r3 = R.string.alarms_and_reminders_title;
        goto L73
    L63:
        if (r14.equals(Settings.UsageAccessSettingsActivity.class.getName()) == false) goto L66;
        r3 = R.string.usage_access;
        goto L73
    L66:
        if (r14.equals(Settings.ChangeWifiStateActivity.class.getName()) == false) goto L69;
        r3 = R.string.change_wifi_state_title;
        goto L73
    L69:
        if (r14.equals(Settings.TurnScreenOnSettingsActivity.class.getName()) == true) goto L73;
        r3 = r0;
        goto L73
    L5:
        r0 = 0;
        goto L6
    }

    public static int getSubtitleResId(Intent r12, Bundle r13) {
        if (r13.containsKey(SettingsActivity.EXTRA_SHOW_FRAGMENT_SUBTITLE_RESID) == false) goto L5;
        int r0 = r13.getInt(SettingsActivity.EXTRA_SHOW_FRAGMENT_SUBTITLE_RESID);
    L6:
        boolean r2 = r13.containsKey(EXTRA_LIST_TYPE);
        int r3 = R.string.allow_turn_screen_on_description;
        if (r2 == false) goto L42;
        if (r0 != 0) goto L42;
        int r1 = r13.getInt(EXTRA_LIST_TYPE);
        if (r1 != 11) goto L13;
        r0 = R.string.allow_manage_external_storage_description;
        goto L42
    L13:
        if (r1 != 6) goto L16;
        r0 = R.string.allow_overlay_description;
        goto L42
    L16:
        if (r1 != 13) goto L19;
        r0 = R.string.media_management_apps_description;
        goto L42
    L19:
        if (r1 != 7) goto L22;
        r0 = R.string.write_settings_description;
        goto L42
    L22:
        if (r1 != 8) goto L25;
        r0 = R.string.install_unknown_applications;
        goto L42
    L25:
        if (r1 != 12) goto L28;
        r0 = R.string.alarms_and_reminders_switch_title;
        goto L42
    L28:
        if (r1 != 4) goto L31;
        r0 = R.string.usage_access_description;
        goto L42
    L31:
        if (r1 != 10) goto L34;
        r0 = R.string.change_wifi_state_app_detail_switch;
        goto L42
    L34:
        if (r1 != 19) goto L37;
        r0 = R.string.allow_turn_screen_on_description;
        goto L42
    L37:
        if (r1 != 18) goto L40;
        r0 = R.string.change_nfc_tag_apps_detail_switch;
        goto L42
    L40:
        if (r1 != 21) goto L42;
        r0 = R.string.interact_across_profiles_title;
    L42:
        String r14 = getClassName(r12, r13);
        if (r14.equals(Settings.OverlaySettingsActivity.class.getName()) == false) goto L45;
    L72:
        r3 = R.string.allow_overlay_description;
    L73:
        if (r3 != 0) goto L76;
        return R.string.application_info_label;
    L76:
        return r3;
    L45:
        if (r14.equals(Settings.AppDrawOverlaySettingsActivity.class.getName()) == true) goto L72;
        if (r14.equals(Settings.ManageExternalStorageActivity.class.getName()) == false) goto L51;
        r3 = R.string.allow_manage_external_storage_description;
        goto L73
    L51:
        if (r14.equals(Settings.MediaManagementAppsActivity.class.getName()) == false) goto L54;
        r3 = R.string.media_management_apps_description;
        goto L73
    L54:
        if (r14.equals(Settings.WriteSettingsActivity.class.getName()) == false) goto L57;
        r3 = R.string.write_settings_description;
        goto L73
    L57:
        if (r14.equals(Settings.ManageExternalSourcesActivity.class.getName()) == false) goto L60;
        r3 = R.string.install_unknown_applications;
        goto L73
    L60:
        if (r14.equals(Settings.AlarmsAndRemindersActivity.class.getName()) == false) goto L63;
        r3 = R.string.alarms_and_reminders_switch_title;
        goto L73
    L63:
        if (r14.equals(Settings.UsageAccessSettingsActivity.class.getName()) == false) goto L66;
        r3 = R.string.usage_access_description;
        goto L73
    L66:
        if (r14.equals(Settings.ChangeWifiStateActivity.class.getName()) == false) goto L69;
        r3 = R.string.change_wifi_state_app_detail_switch;
        goto L73
    L69:
        if (r14.equals(Settings.TurnScreenOnSettingsActivity.class.getName()) == true) goto L73;
        r3 = r0;
        goto L73
    L5:
        r0 = 0;
        goto L6
    }

    protected String retrieveAppEntry() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r2 = r0.getString("package");
    L6:
        this.mPackageName = r2;
        if (r0 == null) goto L9;
    L11:
        Intent r1 = (Intent) r0.getParcelable("intent");
    L13:
        if (this.mPackageName != null) goto L23;
        if (r1 == null) goto L16;
    L19:
        if (r1 == null) goto L23;
        if (r1.getData() == null) goto L23;
        this.mPackageName = r1.getData().getSchemeSpecificPart();
        goto L23
    L16:
        if (getActivity() == null) goto L18;
        r1 = getActivity().getIntent();
        goto L19
    L18:
        r1 = null;
    L23:
        int r3 = Utils.getSecureTargetUser(getActivity().getActivityToken(), this.mUserManager, null, getIntent().getExtras()).getIdentifier();
        this.mUserId = r3;
        ApplicationsState r4 = this.mApplicationsState;
        if (r4 == null) goto L37;
        String r5 = this.mPackageName;
        if (r5 == null) goto L37;
        ApplicationsState.AppEntry r6 = r4.getEntry(r5, r3);
        this.mAppEntry = r6;
        if (r6 != null) goto L38;
        OLog.w("ManageApplications", "Missing AppEntry; maybe reinstalling?");
        this.mPackageInfo = null;
    L36:
        return this.mPackageName;
    L38:
        this.mPackageInfo = getPackageManager().getPackageInfoAsUser(this.mAppEntry.info.packageName, PackageManager.PackageInfoFlags.of(4429189632L), this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L32
    L32:
        e = move-exception;
        OLog.e("ManageApplications", "Exception when retrieving package:" + this.mAppEntry.info.packageName, e);
    L37:
        return null;
    L9:
        if (getActivity() == null) goto L11;
        r1 = getActivity().getIntent();
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    private void setCanInstallApps(boolean r4) {
        PackageInfo r0 = this.mPackageInfo;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.applicationInfo != null) goto L7;
        return;
    L7:
        if (this.mPackageName == null) goto L17;
        OLog.d("ManageApplications", this.mPackageName + "setCanInstallApps: newState=" + r4);
        AppOpsManager r1 = (AppOpsManager) this.mContext.getSystemService("appops");
        int r2 = this.mPackageInfo.applicationInfo.uid;
        String r3 = this.mPackageName;
        if (r4 == false) goto L12;
        int r5 = 0;
    L13:
        r1.setMode(66, r2, r3, r5);
        return;
    L12:
        r5 = 2;
        goto L13
    }

    private boolean getCanInstallApps() {
        PackageInfo r0 = this.mPackageInfo;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.applicationInfo != null) goto L7;
        return false;
    L7:
        if (this.mPackageName != null) goto L10;
        return false;
    L10:
        if (((AppOpsManager) this.mContext.getSystemService("appops")).checkOpNoThrow(66, this.mPackageInfo.applicationInfo.uid, this.mPackageName) != 0) goto L15;
        return true;
    L15:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_manageapplications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ManageApplications r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_manageapplications_ManageApplications__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_manageapplications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ManageApplications r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_manageapplications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_manageapplications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ManageApplications r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_manageapplications_ManageApplications__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
