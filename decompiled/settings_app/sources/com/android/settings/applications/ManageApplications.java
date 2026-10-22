package com.android.settings.applications;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.LocaleList;
import android.os.UserHandle;
import android.os.UserManager;
import android.preference.PreferenceFrameLayout;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.Utils;
import com.android.settings.fuelgauge.PowerWhitelistBackend;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.LoadingViewController;
import com.android.settingslib.HelpUtils;
import com.android.settingslib.core.lifecycle.ObservablePreferenceFragment;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ManageApplications extends ObservablePreferenceFragment implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    private static final int ADVANCED_SETTINGS = 2;
    public static final String APP_CHG = "chg";
    static final boolean DEBUG = false;
    public static final String EXTRA_CLASSNAME = "classname";
    private static final String EXTRA_HAS_BRIDGE = "hasBridge";
    private static final String EXTRA_HAS_ENTRIES = "hasEntries";
    private static final String EXTRA_SHOW_SYSTEM = "showSystem";
    private static final String EXTRA_SORT_ORDER = "sortOrder";
    public static final String EXTRA_STORAGE_TYPE = "storageType";
    public static final String EXTRA_VOLUME_NAME = "volumeName";
    public static final String EXTRA_VOLUME_UUID = "volumeUuid";
    public static final String EXTRA_WORK_ID = "workId";
    public static final String EXTRA_WORK_ONLY = "workProfileOnly";
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter[] FILTERS = null;
    public static final int FILTER_APPS_ALL = 2;
    public static final int FILTER_APPS_BLOCKED = 6;
    public static final int FILTER_APPS_COUNT = 13;
    public static final int FILTER_APPS_DISABLED = 5;
    public static final int FILTER_APPS_ENABLED = 3;
    public static final int FILTER_APPS_INSTALL_SOURCES = 12;
    public static final int FILTER_APPS_INSTANT = 4;
    public static final int FILTER_APPS_PERSONAL = 7;
    public static final int FILTER_APPS_POWER_WHITELIST = 0;
    public static final int FILTER_APPS_POWER_WHITELIST_ALL = 1;
    public static final int FILTER_APPS_USAGE_ACCESS = 9;
    public static final int FILTER_APPS_WITH_OVERLAY = 10;
    public static final int FILTER_APPS_WORK = 8;
    public static final int FILTER_APPS_WRITE_SETTINGS = 11;
    public static final int[] FILTER_LABELS = null;
    private static final int INSTALLED_APP_DETAILS = 1;
    public static final Set<Integer> LIST_TYPES_WITH_INSTANT = null;
    public static final int LIST_TYPE_GAMES = 9;
    public static final int LIST_TYPE_HIGH_POWER = 5;
    public static final int LIST_TYPE_MAIN = 0;
    public static final int LIST_TYPE_MANAGE_SOURCES = 8;
    public static final int LIST_TYPE_MOVIES = 10;
    public static final int LIST_TYPE_NOTIFICATION = 1;
    public static final int LIST_TYPE_OVERLAY = 6;
    public static final int LIST_TYPE_PHOTOGRAPHY = 11;
    public static final int LIST_TYPE_STORAGE = 3;
    public static final int LIST_TYPE_USAGE_ACCESS = 4;
    public static final int LIST_TYPE_WRITE_SETTINGS = 7;
    private static final int NO_USER_SPECIFIED = -1;
    public static final int SIZE_EXTERNAL = 2;
    public static final int SIZE_INTERNAL = 1;
    public static final int SIZE_TOTAL = 0;
    public static final int STORAGE_TYPE_DEFAULT = 0;
    public static final int STORAGE_TYPE_LEGACY = 2;
    public static final int STORAGE_TYPE_MUSIC = 1;
    public static final int STORAGE_TYPE_PHOTOS_VIDEOS = 3;
    static final String TAG = "ManageApplications";
    public ApplicationsAdapter mApplications;
    private com.android.settingslib.applications.ApplicationsState mApplicationsState;
    private String mCurrentPkgName;
    private int mCurrentUid;
    public int mFilter;
    private FilterSpinnerAdapter mFilterAdapter;
    private Spinner mFilterSpinner;
    private boolean mFinishAfterDialog;
    private LayoutInflater mInflater;
    CharSequence mInvalidSizeStr;
    private boolean mIsWorkOnly;
    private View mListContainer;
    public int mListType;
    private ListView mListView;
    private View mLoadingContainer;
    private Menu mOptionsMenu;
    private ResetAppsHelper mResetAppsHelper;
    private View mRootView;
    private boolean mShowSystem;
    private int mSortOrder;
    private View mSpinnerHeader;
    private int mStorageType;
    private String mVolumeUuid;
    private int mWorkUserId;

    static class ApplicationsAdapter extends BaseAdapter implements Filterable, com.android.settingslib.applications.ApplicationsState.Callbacks, AppStateBaseBridge.Callback, AbsListView.RecyclerListener, SectionIndexer {
        private static final long DELAY_SHOW_LOADING_CONTAINER_THRESHOLD_MS = 100;
        private static final SectionInfo[] EMPTY_SECTIONS = null;
        private final ArrayList<View> mActive;
        private ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> mBaseEntries;
        private final Handler mBgHandler;
        private com.android.settingslib.applications.ApplicationsState.AppFilter mCompositeFilter;
        private final Context mContext;
        CharSequence mCurFilterPrefix;
        private ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> mEntries;
        private final AppStateBaseBridge mExtraInfoBridge;
        private FileViewHolderController mExtraViewController;
        private final Handler mFgHandler;
        private Filter mFilter;
        private int mFilterMode;
        private boolean mHasReceivedBridgeCallback;
        private boolean mHasReceivedLoadEntries;
        private AlphabeticIndex.ImmutableIndex<Locale> mIndex;
        private int mLastIndex;
        private int mLastSortMode;
        private int mLastTop;
        private final LoadingViewController mLoadingViewController;
        private final ManageApplications mManageApplications;
        private PackageManager mPm;
        private int[] mPositionToSectionIndex;
        private boolean mResumed;
        private SectionInfo[] mSections;
        private final com.android.settingslib.applications.ApplicationsState.Session mSession;
        private final com.android.settingslib.applications.ApplicationsState mState;
        private int mWhichSize;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
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

        static /* synthetic */ AppStateBaseBridge access$200(ApplicationsAdapter r0) {
            return r0.mExtraInfoBridge;
        }

        static /* synthetic */ ArrayList access$500(ApplicationsAdapter r0) {
            return r0.mBaseEntries;
        }

        static /* synthetic */ ArrayList access$602(ApplicationsAdapter r0, ArrayList r1) {
            r0.mEntries = r1;
            return r1;
        }

        static /* synthetic */ void access$700(ApplicationsAdapter r0) {
            r0.rebuildSections();
        }

        static {
            EMPTY_SECTIONS = new SectionInfo[0];
        }

        public ApplicationsAdapter(com.android.settingslib.applications.ApplicationsState r4, ManageApplications r5, int r6) {
            this.mActive = new ArrayList();
            this.mLastSortMode = -1;
            this.mWhichSize = 0;
            this.mLastIndex = -1;
            this.mSections = EMPTY_SECTIONS;
            this.mFilter = new AnonymousClass1(this);
            this.mState = r4;
            this.mFgHandler = new Handler();
            this.mBgHandler = new Handler(r4.getBackgroundLooper());
            this.mSession = r4.newSession(this);
            this.mManageApplications = r5;
            this.mLoadingViewController = new LoadingViewController(ManageApplications.access$800(r5), ManageApplications.access$900(r5));
            FragmentActivity r0 = r5.getActivity();
            this.mContext = r0;
            this.mPm = r0.getPackageManager();
            this.mFilterMode = r6;
            if (r5.mListType != 4) goto L6;
            this.mExtraInfoBridge = new AppStateUsageBridge(r0, r4, this);
            return;
        L6:
            if (r5.mListType != 5) goto L9;
            this.mExtraInfoBridge = new AppStatePowerBridge(r4, this);
            return;
        L9:
            if (r5.mListType != 6) goto L12;
            this.mExtraInfoBridge = new AppStateOverlayBridge(r0, r4, this);
            return;
        L12:
            if (r5.mListType != 7) goto L14;
            this.mExtraInfoBridge = new AppStateWriteSettingsBridge(r0, r4, this);
            return;
        L14:
            this.mExtraInfoBridge = null;
        }

        public void setCompositeFilter(com.android.settingslib.applications.ApplicationsState.AppFilter r1) {
            this.mCompositeFilter = r1;
            rebuild(true);
        }

        public void setFilter(int r1) {
            this.mFilterMode = r1;
            rebuild(true);
        }

        public void setExtraViewController(FileViewHolderController r2) {
            this.mExtraViewController = r2;
            this.mBgHandler.post(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda1(this));
        }

        /* JADX INFO: renamed from: lambda$setExtraViewController$1$com-android-settings-applications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ void m299x461abc85() {
            this.mExtraViewController.queryStats();
            this.mFgHandler.post(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$setExtraViewController$0$com-android-settings-applications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ void m298x2ba9c366() {
            onExtraViewCompleted();
        }

        public void resume(int r3) {
            if (ManageApplications.DEBUG == false) goto L6;
            OLog.i("ManageApplications", "Resume!  mResumed=" + this.mResumed);
        L6:
            if (this.mResumed == true) goto L11;
            this.mResumed = true;
            MultiSDKAdapter.resumeSession(this.mSession);
            this.mLastSortMode = r3;
            AppStateBaseBridge r4 = this.mExtraInfoBridge;
            if (r4 == null) goto L10;
            r4.resume();
        L10:
            rebuild(false);
            return;
        L11:
            rebuild(r3);
        }

        public void pause() {
            int r1 = 0;
            if (this.mResumed == false) goto L7;
            this.mResumed = false;
            MultiSDKAdapter.pauseSession(this.mSession);
            AppStateBaseBridge r0 = this.mExtraInfoBridge;
            if (r0 == null) goto L7;
            r0.pause();
        L7:
            this.mLastIndex = ManageApplications.access$1000(this.mManageApplications).getFirstVisiblePosition();
            View r2 = ManageApplications.access$1000(this.mManageApplications).getChildAt(0);
            if (r2 == null) goto L11;
            r1 = r2.getTop() - ManageApplications.access$1000(this.mManageApplications).getPaddingTop();
        L11:
            this.mLastTop = r1;
        }

        public void release() {
            MultiSDKAdapter.releaseSession(this.mSession);
            AppStateBaseBridge r1 = this.mExtraInfoBridge;
            if (r1 == null) goto L6;
            r1.release();
            return;
        }

        public void rebuild(int r2) {
            if (r2 != this.mLastSortMode) goto L5;
            return;
        L5:
            this.mLastSortMode = r2;
            rebuild(true);
        }

        public void rebuild(boolean r4) {
            if (this.mHasReceivedLoadEntries == true) goto L5;
            return;
        L5:
            if (this.mExtraInfoBridge == null) goto L10;
            if (this.mHasReceivedBridgeCallback == true) goto L10;
            return;
        L10:
            if (Environment.isExternalStorageEmulated() == false) goto L12;
            this.mWhichSize = 0;
        L13:
            com.android.settingslib.applications.ApplicationsState.AppFilter r5 = ManageApplications.FILTERS[this.mFilterMode];
            if (this.mCompositeFilter == null) goto L17;
            r5 = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(r5, this.mCompositeFilter);
        L17:
            if (ManageApplications.access$1100(this.mManageApplications) == true) goto L24;
            if (ManageApplications.LIST_TYPES_WITH_INSTANT.contains(Integer.valueOf(this.mManageApplications.mListType)) == false) goto L21;
            com.android.settingslib.applications.ApplicationsState.CompoundFilter r1 = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(r5, com.android.settingslib.applications.ApplicationsState.FILTER_DOWNLOADED_AND_LAUNCHER_AND_INSTANT);
        L22:
            r5 = r1;
            goto L24
        L21:
            r1 = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(r5, com.android.settingslib.applications.ApplicationsState.FILTER_DOWNLOADED_AND_LAUNCHER);
        L24:
            if (this.mLastSortMode == R.id.sort_order_size) goto L26;
            final Comparator<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = com.android.settingslib.applications.ApplicationsState.ALPHA_COMPARATOR;
        L33:
            final com.android.settingslib.applications.ApplicationsState.CompoundFilter r2 = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(r5, com.android.settingslib.applications.ApplicationsState.FILTER_NOT_HIDE);
            this.mBgHandler.post(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda2(this, r2, r0));
            return;
        L26:
            int r3 = this.mWhichSize;
            if (r3 != 1) goto L29;
            r0 = com.android.settingslib.applications.ApplicationsState.INTERNAL_SIZE_COMPARATOR;
            goto L33
        L29:
            if (r3 == 2) goto L31;
            r0 = com.android.settingslib.applications.ApplicationsState.SIZE_COMPARATOR;
            goto L33
        L31:
            r0 = com.android.settingslib.applications.ApplicationsState.EXTERNAL_SIZE_COMPARATOR;
            goto L33
        L12:
            this.mWhichSize = 1;
            goto L13
        }

        /* JADX INFO: renamed from: lambda$rebuild$3$com-android-settings-applications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ void m297xbf337951(com.android.settingslib.applications.ApplicationsState.AppFilter r3, Comparator r4) {
            final ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r5 = this.mSession.rebuild(r3, r4, false);
            if (r5 == null) goto L6;
            this.mFgHandler.post(new ManageApplications$ApplicationsAdapter$$ExternalSyntheticLambda3(this, r5));
            return;
        }

        /* JADX INFO: renamed from: lambda$rebuild$2$com-android-settings-applications-ManageApplications$ApplicationsAdapter, reason: not valid java name */
        /* synthetic */ void m296xa4c28032(ArrayList r1) {
            onRebuildComplete(r1);
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

        private ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> removeDuplicateIgnoringUser(ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r7) {
            int r6 = r7.size();
            ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = new ArrayList(r6);
            ApplicationInfo r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r6) goto L8;
            com.android.settingslib.applications.ApplicationsState.AppEntry r3 = r7.get(r2);
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

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r5) {
            int r0 = this.mFilterMode;
            if (r0 == 0) goto L5;
            if (r0 == 1) goto L5;
        L6:
            this.mBaseEntries = r5;
            if (r5 == null) goto L9;
            this.mEntries = applyPrefixFilter(this.mCurFilterPrefix, r5);
            rebuildSections();
        L10:
            notifyDataSetChanged();
            if (this.mLastIndex == (-1)) goto L16;
            if (getCount() <= this.mLastIndex) goto L16;
            ManageApplications.access$1000(this.mManageApplications).setSelectionFromTop(this.mLastIndex, this.mLastTop);
            this.mLastIndex = -1;
        L16:
            if (this.mSession.getAllApps().size() == 0) goto L21;
            if (ManageApplications.access$900(this.mManageApplications).getVisibility() == 0) goto L21;
            this.mLoadingViewController.showContent(true);
        L21:
            if (this.mManageApplications.mListType != 4) goto L23;
            return;
        L23:
            this.mManageApplications.setHasDisabled(this.mState.haveDisabledApps());
            this.mManageApplications.setHasInstant(this.mState.haveInstantApps());
            return;
        L9:
            this.mEntries = null;
            this.mSections = EMPTY_SECTIONS;
            this.mPositionToSectionIndex = null;
        L5:
            r5 = removeDuplicateIgnoringUser(r5);
            goto L6
        }

        private void rebuildSections() {
            if (this.mEntries != null) goto L5;
        L25:
            this.mSections = EMPTY_SECTIONS;
            this.mPositionToSectionIndex = null;
            return;
        L5:
            if (ManageApplications.access$1000(this.mManageApplications).isFastScrollEnabled() == false) goto L25;
            int r1 = 0;
            if (this.mIndex != null) goto L15;
            LocaleList r0 = this.mContext.getResources().getConfiguration().getLocales();
            if (r0.size() != 0) goto L11;
            r0 = new LocaleList(new Locale[]{Locale.ENGLISH});
        L11:
            AlphabeticIndex r3 = new AlphabeticIndex(r0.get(0));
            int r4 = r0.size();
            int r5 = 1;
        L12:
            if (r5 >= r4) goto L14;
            r3.addLabels(new Locale[]{r0.get(r5)});
            r5 = r5 + 1;
            goto L12
        L14:
            r3.addLabels(new Locale[]{Locale.ENGLISH});
            this.mIndex = r3.buildImmutableIndex();
        L15:
            ArrayList r2 = new ArrayList();
            int r6 = this.mEntries.size();
            this.mPositionToSectionIndex = new int[r6];
            int r7 = -1;
        L16:
            if (r1 >= r6) goto L24;
            String r8 = this.mEntries.get(r1).label;
            AlphabeticIndex.ImmutableIndex<Locale> r9 = this.mIndex;
            if (TextUtils.isEmpty(r8) == false) goto L20;
            r8 = "";
        L20:
            int r10 = r9.getBucketIndex(r8);
            if (r10 == r7) goto L23;
            r2.add(new SectionInfo(this.mIndex.getBucket(r10).getLabel(), r1));
            r7 = r10;
        L23:
            this.mPositionToSectionIndex[r1] = r2.size() - 1;
            r1 = r1 + 1;
            goto L16
        L24:
            this.mSections = (SectionInfo[]) r2.toArray(EMPTY_SECTIONS);
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

        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> applyPrefixFilter(CharSequence r6, ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r7) {
            if (r6 != null) goto L4;
        L16:
            return r7;
        L4:
            if (r6.length() == 0) goto L16;
            String r5 = com.android.settingslib.applications.ApplicationsState.normalize(r6.toString());
            String r8 = HanziToPinyin.Token.SEPARATOR + r5;
            ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = new ArrayList();
            int r1 = 0;
        L8:
            if (r1 >= r7.size()) goto L15;
            com.android.settingslib.applications.ApplicationsState.AppEntry r2 = r7.get(r1);
            String r3 = r2.getNormalizedLabel();
            if (r3.startsWith(r5) == false) goto L12;
        L13:
            r0.add(r2);
        L14:
            r1 = r1 + 1;
            goto L8
        L12:
            if (r3.indexOf(r8) == (-1)) goto L14;
        L15:
            return r0;
        }

        @Override // com.android.settings.applications.AppStateBaseBridge.Callback
        public void onExtraInfoUpdated() {
            this.mHasReceivedBridgeCallback = true;
            rebuild(false);
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
            this.mManageApplications.getActivity().setProgressBarIndeterminateVisibility(r1);
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            rebuild(false);
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onLoadEntriesCompleted() {
            this.mHasReceivedLoadEntries = true;
            rebuild(false);
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r5) {
            int r1 = 0;
        L4:
            if (r1 >= this.mActive.size()) goto L29;
            AppViewHolder r2 = (AppViewHolder) this.mActive.get(r1).getTag();
            if (r2 == null) goto L28;
            if (r2.entry == null) goto L28;
            if (r2.entry.info == null) goto L28;
            if (r2.entry.info.packageName.equals(r5) == false) goto L28;
            com.android.settingslib.applications.ApplicationsState.AppEntry r3 = r2.entry;
            monitor-enter(r3);
            updateSummary(r2);     // Catch: Throwable -> L25
            monitor-exit(r3);     // Catch: Throwable -> L25
            if (r2.entry.info.packageName.equals(ManageApplications.access$1200(this.mManageApplications)) == true) goto L22;
            return;
        L22:
            if (this.mLastSortMode != R.id.sort_order_size) goto L39;
            rebuild(false);
            return;
        L39:
            return;
        L25:
            th = move-exception;
            throw th;
        L28:
            r1 = r1 + 1;
            goto L4
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onLauncherInfoChanged() {
            if (ManageApplications.access$1100(this.mManageApplications) == true) goto L6;
            rebuild(false);
            return;
        }

        @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
            if (this.mLastSortMode != R.id.sort_order_size) goto L6;
            rebuild(false);
            return;
        }

        public void onExtraViewCompleted() {
            int r0 = this.mActive.size();
            if (r0 >= 1) goto L5;
            return;
        L5:
            AppViewHolder r1 = (AppViewHolder) this.mActive.get(r0 - 1).getTag();
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.entry != null) goto L13;
            this.mExtraViewController.setupView(r1);
            return;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int r1 = 0;
            if (this.mEntries != null) goto L5;
            return 0;
        L5:
            FileViewHolderController r0 = this.mExtraViewController;
            if (r0 == null) goto L11;
            if (r0.shouldShow() == false) goto L11;
            r1 = 1;
        L11:
            return this.mEntries.size() + r1;
        }

        public int getApplicationCount() {
            ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mEntries;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            if (r2 != this.mEntries.size()) goto L7;
            return this.mExtraViewController;
        L7:
            return this.mEntries.get(r2);
        }

        public com.android.settingslib.applications.ApplicationsState.AppEntry getAppEntry(int r1) {
            return this.mEntries.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r2) {
            if (r2 != this.mEntries.size()) goto L7;
            return -1;
        L7:
            return this.mEntries.get(r2).id;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r4) {
            if (r4 != this.mEntries.size()) goto L10;
            FileViewHolderController r0 = this.mExtraViewController;
            if (r0 == null) goto L10;
            if (r0.shouldShow() == false) goto L10;
            return true;
        L10:
            if (this.mManageApplications.mListType == 5) goto L13;
            return true;
        L13:
            return !PowerWhitelistBackend.getInstance().isSysWhitelisted(this.mEntries.get(r4).info.packageName);
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            AppViewHolder r7 = AppViewHolder.createOrRecycle(ManageApplications.access$1300(this.mManageApplications), r5);
            View r8 = r7.rootView;
            ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mEntries;
            if (r0 != null) goto L6;
            return r8;
        L6:
            if (this.mExtraViewController != null) goto L8;
        L10:
            com.android.settingslib.applications.ApplicationsState.AppEntry r1 = this.mEntries.get(r4);
            monitor-enter(r1);
            r7.entry = r1;     // Catch: Throwable -> L23
            if (r1.label == null) goto L15;
            r7.appName.setText(r1.label);     // Catch: Throwable -> L23
        L15:
            this.mState.ensureIcon(r1);     // Catch: Throwable -> L23
            if (r1.icon == null) goto L18;
            r7.appIcon.setImageDrawable(r1.icon);     // Catch: Throwable -> L23
        L18:
            updateSummary(r7);     // Catch: Throwable -> L23
            updateDisableView(r7.disabled, r1.info);     // Catch: Throwable -> L23
            monitor-exit(r1);     // Catch: Throwable -> L23
            r8.setEnabled(isEnabled(r4));
        L21:
            this.mActive.remove(r8);
            this.mActive.add(r8);
            return r8;
        L23:
            th = move-exception;
            throw th;
        L8:
            if (r4 != r0.size()) goto L10;
            this.mExtraViewController.setupView(r7);
            r8.setEnabled(true);
            goto L21
        }

        void updateDisableView(TextView r2, ApplicationInfo r3) {
            if ((r3.flags & 8388608) != 0) goto L6;
            r2.setVisibility(0);
            r2.setText(R.string.not_installed);
            return;
        L6:
            if (r3.enabled == true) goto L8;
        L11:
            r2.setVisibility(0);
            r2.setText(R.string.disabled);
            return;
        L8:
            if (r3.enabledSetting == 4) goto L11;
            r2.setVisibility(8);
        }

        private void updateSummary(AppViewHolder r2) {
            int r0 = this.mManageApplications.mListType;
            r2.updateSizeText(this.mManageApplications.mInvalidSizeStr, this.mWhichSize);
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return this.mFilter;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View r1) {
            this.mActive.remove(r1);
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return this.mSections;
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int r1) {
            return this.mSections[r1].position;
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int r1) {
            return this.mPositionToSectionIndex[r1];
        }
    }

    static class FilterSpinnerAdapter extends ArrayAdapter<CharSequence> {
        private final ArrayList<Integer> mFilterOptions;
        private final ManageApplications mManageApplications;

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public FilterSpinnerAdapter(ManageApplications r3) {
            super(ManageApplications.access$300(r3).getContext(), R.layout.filter_spinner_item);
            this.mFilterOptions = new ArrayList();
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.mManageApplications = r3;
        }

        public int getFilter(int r1) {
            return this.mFilterOptions.get(r1).intValue();
        }

        public void setFilterEnabled(int r1, boolean r2) {
            if (r2 == false) goto L4;
            enableFilter(r1);
            return;
        L4:
            disableFilter(r1);
        }

        public void enableFilter(int r11) {
            if (this.mFilterOptions.contains(Integer.valueOf(r11)) == false) goto L6;
            return;
        L6:
            if (ManageApplications.DEBUG == false) goto L8;
            OLog.d("ManageApplications", "Enabling filter " + r11);
        L8:
            this.mFilterOptions.add(Integer.valueOf(r11));
            Collections.sort(this.mFilterOptions);
            View r0 = ManageApplications.access$400(this.mManageApplications);
            if (this.mFilterOptions.size() <= 1) goto L11;
            int r2 = 0;
        L12:
            r0.setVisibility(r2);
            notifyDataSetChanged();
            if (this.mFilterOptions.size() == 1) goto L15;
            return;
        L15:
            if (ManageApplications.DEBUG == false) goto L17;
            OLog.d("ManageApplications", "Auto selecting filter " + r11);
        L17:
            ManageApplications.access$300(this.mManageApplications).setSelection(0);
            this.mManageApplications.onItemSelected(null, null, 0, 0);
            return;
        L11:
            r2 = 8;
            goto L12
        }

        public void disableFilter(int r12) {
            if (this.mFilterOptions.remove(Integer.valueOf(r12)) == true) goto L6;
            return;
        L6:
            if (ManageApplications.DEBUG == false) goto L8;
            OLog.d("ManageApplications", "Disabling filter " + r12);
        L8:
            Collections.sort(this.mFilterOptions);
            View r0 = ManageApplications.access$400(this.mManageApplications);
            if (this.mFilterOptions.size() <= 1) goto L11;
            int r2 = 0;
        L12:
            r0.setVisibility(r2);
            notifyDataSetChanged();
            if (this.mManageApplications.mFilter == r12) goto L15;
            return;
        L15:
            if (this.mFilterOptions.size() > 0) goto L17;
            return;
        L17:
            if (ManageApplications.DEBUG == false) goto L19;
            OLog.d("ManageApplications", "Auto selecting filter " + this.mFilterOptions.get(0));
        L19:
            ManageApplications.access$300(this.mManageApplications).setSelection(0);
            this.mManageApplications.onItemSelected(null, null, 0, 0);
            return;
        L11:
            r2 = 8;
            goto L12
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.mFilterOptions.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public CharSequence getItem(int r2) {
            return getFilterString(this.mFilterOptions.get(r2).intValue());
        }

        private CharSequence getFilterString(int r2) {
            return this.mManageApplications.getString(ManageApplications.FILTER_LABELS[r2]);
        }
    }

    private static class SectionInfo {
        final String label;
        final int position;

        public SectionInfo(String r1, int r2) {
            this.label = r1;
            this.position = r2;
        }

        public String toString() {
            return this.label;
        }
    }

    private void startAppInfoFragment(Class<?> r1, int r2) {
    }

    public void com_android_settings_applications_ManageApplications__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    @Override // com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ManageApplications() {
        this.mSortOrder = R.id.sort_order_alpha;
    }

    static /* synthetic */ ListView access$1000(ManageApplications r0) {
        return r0.mListView;
    }

    static /* synthetic */ boolean access$1100(ManageApplications r0) {
        return r0.mShowSystem;
    }

    static /* synthetic */ String access$1200(ManageApplications r0) {
        return r0.mCurrentPkgName;
    }

    static /* synthetic */ LayoutInflater access$1300(ManageApplications r0) {
        return r0.mInflater;
    }

    static /* synthetic */ Spinner access$300(ManageApplications r0) {
        return r0.mFilterSpinner;
    }

    static /* synthetic */ View access$400(ManageApplications r0) {
        return r0.mSpinnerHeader;
    }

    static /* synthetic */ View access$800(ManageApplications r0) {
        return r0.mLoadingContainer;
    }

    static /* synthetic */ View access$900(ManageApplications r0) {
        return r0.mListContainer;
    }

    static {
        DEBUG = Log.isLoggable("ManageApplications", 3);
        FILTER_LABELS = new int[]{R.string.high_power_filter_on, R.string.filter_all_apps, R.string.filter_all_apps, R.string.filter_enabled_apps, 0, R.string.filter_apps_disabled, 0, R.string.filter_personal_apps, R.string.filter_work_apps, R.string.filter_all_apps, R.string.filter_overlay_apps, R.string.filter_write_settings_apps, R.string.filter_install_sources_apps};
        com.android.settingslib.applications.ApplicationsState.AppFilter[] r0 = new com.android.settingslib.applications.ApplicationsState.AppFilter[13];
        FILTERS = r0;
        r0[0] = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(AppStatePowerBridge.FILTER_POWER_WHITELISTED, com.android.settingslib.applications.ApplicationsState.FILTER_ALL_ENABLED);
        r0[1] = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(com.android.settingslib.applications.ApplicationsState.FILTER_WITHOUT_DISABLED_UNTIL_USED, com.android.settingslib.applications.ApplicationsState.FILTER_ALL_ENABLED);
        r0[2] = com.android.settingslib.applications.ApplicationsState.FILTER_EVERYTHING;
        r0[3] = com.android.settingslib.applications.ApplicationsState.FILTER_ALL_ENABLED;
        r0[5] = com.android.settingslib.applications.ApplicationsState.FILTER_DISABLED;
        r0[7] = com.android.settingslib.applications.ApplicationsState.FILTER_PERSONAL;
        r0[8] = com.android.settingslib.applications.ApplicationsState.FILTER_WORK;
        r0[9] = AppStateUsageBridge.FILTER_APP_USAGE;
        r0[10] = AppStateOverlayBridge.FILTER_SYSTEM_ALERT_WINDOW;
        r0[11] = AppStateWriteSettingsBridge.FILTER_WRITE_SETTINGS;
        r0[12] = AppStateInstallAppsBridge.FILTER_APP_SOURCES;
        LIST_TYPES_WITH_INSTANT = new ArraySet(Arrays.asList(new Integer[]{0, 3}));
    }

    public void com_android_settings_applications_ManageApplications__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setHasOptionsMenu(true);
        this.mApplicationsState = com.android.settingslib.applications.ApplicationsState.getInstance(getActivity().getApplication());
        Intent r1 = getActivity().getIntent();
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        String r3 = r2.getString("classname");
    L6:
        if (r3 != null) goto L8;
        r3 = r1.getComponent().getClassName();
    L8:
        boolean r4 = false;
        if (r3.equals(Settings.HighPowerApplicationsActivity.class.getName()) == false) goto L12;
        this.mListType = 5;
        this.mShowSystem = true;
    L15:
        this.mFilter = getDefaultFilter();
        if (r2 == null) goto L18;
        r4 = r2.getBoolean(EXTRA_WORK_ONLY);
    L18:
        this.mIsWorkOnly = r4;
        if (r2 == null) goto L21;
        int r0 = r2.getInt("workId");
    L22:
        this.mWorkUserId = r0;
        if (r6 == null) goto L25;
        this.mSortOrder = r6.getInt(EXTRA_SORT_ORDER, this.mSortOrder);
        this.mShowSystem = r6.getBoolean(EXTRA_SHOW_SYSTEM, this.mShowSystem);
    L25:
        this.mInvalidSizeStr = getActivity().getText(R.string.invalid_size_value);
        this.mResetAppsHelper = new ResetAppsHelper(getActivity());
        return;
    L21:
        r0 = -1;
        goto L22
    L12:
        if (r3.equals(Settings.ManageExternalSourcesActivity.class.getName()) == false) goto L14;
        this.mListType = 8;
        goto L15
    L14:
        this.mListType = 0;
        goto L15
    L5:
        r3 = null;
        goto L6
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mInflater = r4;
        View r7 = r4.inflate(R.layout.manage_applications_apps, null);
        this.mRootView = r7;
        this.mLoadingContainer = r7.findViewById(R.id.oui_loading_container);
        View r8 = this.mRootView.findViewById(R.id.list_container);
        this.mListContainer = r8;
        if (r8 == null) goto L16;
        View r9 = r8.findViewById(android.R.id.empty);
        ListView r1 = (ListView) this.mListContainer.findViewById(android.R.id.list);
        if (r9 == null) goto L7;
        r1.setEmptyView(r9);
    L7:
        r1.setOnItemClickListener(this);
        r1.setSaveEnabled(true);
        r1.setItemsCanFocus(true);
        r1.setTextFilterEnabled(true);
        this.mListView = r1;
        ApplicationsAdapter r10 = new ApplicationsAdapter(this.mApplicationsState, this, this.mFilter);
        this.mApplications = r10;
        if (r6 == null) goto L11;
        ApplicationsAdapter.access$002(r10, r6.getBoolean(EXTRA_HAS_ENTRIES, false));
        ApplicationsAdapter.access$102(this.mApplications, r6.getBoolean(EXTRA_HAS_BRIDGE, false));
    L11:
        if (this.mIsWorkOnly == true) goto L14;
        UserHandle.getUserId(this.mCurrentUid);
    L14:
        this.mListView.setAdapter(this.mApplications);
        this.mListView.setRecyclerListener(this.mApplications);
        this.mListView.setFastScrollEnabled(isFastScrollEnabled());
        this.mListView.setOnScrollListener(new AnonymousClass1(this));
        Utils.prepareCustomPreferencesList(r5, this.mRootView, this.mListView, false);
    L16:
        if ((r5 instanceof PreferenceFrameLayout) == false) goto L18;
        this.mRootView.getLayoutParams().removeBorders = true;
    L18:
        createHeader();
        this.mResetAppsHelper.onRestoreInstanceState(r6);
        return this.mRootView;
    }

    void createHeader() {
        FragmentActivity r0 = getActivity();
        FrameLayout r1 = (FrameLayout) this.mRootView.findViewById(R.id.pinned_header);
        View r2 = r0.getLayoutInflater().inflate(R.layout.apps_filter_spinner, r1, false);
        this.mSpinnerHeader = r2;
        this.mFilterSpinner = (Spinner) NullSafe.nonNull(r2.findViewById(R.id.filter_spinner));
        FilterSpinnerAdapter r3 = new FilterSpinnerAdapter(this);
        this.mFilterAdapter = r3;
        this.mFilterSpinner.setAdapter(r3);
        this.mFilterSpinner.setOnItemSelectedListener(this);
        r1.addView(this.mSpinnerHeader, 0);
        this.mFilterAdapter.enableFilter(getDefaultFilter());
        if (this.mListType != 0) goto L8;
        if (UserManager.get(getActivity()).getUserProfiles().size() <= 1) goto L8;
        this.mFilterAdapter.enableFilter(7);
        this.mFilterAdapter.enableFilter(8);
    L8:
        if (this.mListType != 1) goto L11;
        this.mFilterAdapter.enableFilter(6);
    L11:
        if (this.mListType != 5) goto L13;
        this.mFilterAdapter.enableFilter(1);
    L13:
        com.android.settingslib.applications.ApplicationsState.AppFilter r4 = getCompositeFilter(this.mListType, this.mStorageType, this.mVolumeUuid);
        if (this.mIsWorkOnly == false) goto L16;
        r4 = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(r4, FILTERS[8]);
    L16:
        if (r4 == null) goto L19;
        this.mApplications.setCompositeFilter(r4);
        return;
    }

    static com.android.settingslib.applications.ApplicationsState.AppFilter getCompositeFilter(int r1, int r2, String r3) {
        com.android.settingslib.applications.ApplicationsState.VolumeFilter r0 = new com.android.settingslib.applications.ApplicationsState.VolumeFilter(r3);
        if (r1 != 3) goto L12;
        if (r2 != 1) goto L8;
        com.android.settingslib.applications.ApplicationsState.CompoundFilter r4 = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(com.android.settingslib.applications.ApplicationsState.FILTER_AUDIO, r0);
    L10:
        return r4;
    L8:
        if (r2 != 0) goto L25;
        r4 = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(com.android.settingslib.applications.ApplicationsState.FILTER_OTHER_APPS, r0);
        goto L10
    L25:
        return r0;
    L12:
        if (r1 != 9) goto L16;
        return new com.android.settingslib.applications.ApplicationsState.CompoundFilter(com.android.settingslib.applications.ApplicationsState.FILTER_GAMES, r0);
    L16:
        if (r1 != 10) goto L20;
        return new com.android.settingslib.applications.ApplicationsState.CompoundFilter(com.android.settingslib.applications.ApplicationsState.FILTER_MOVIES, r0);
    L20:
        if (r1 == 11) goto L22;
        return null;
    L22:
        return new com.android.settingslib.applications.ApplicationsState.CompoundFilter(com.android.settingslib.applications.ApplicationsState.FILTER_PHOTOS, r0);
    }

    private int getDefaultFilter() {
        switch(this.mListType) {
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        return 2;
    L6:
        return 12;
    L8:
        return 11;
    L10:
        return 10;
    L12:
        return 0;
    L14:
        return 9;
    }

    private boolean isFastScrollEnabled() {
        int r0 = this.mListType;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L10;
        if (r0 == 3) goto L10;
        switch(r0) {
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L10;
            default: goto L8;
        };
    L8:
        return false;
    L10:
        if (this.mSortOrder == R.id.sort_order_alpha) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        updateView();
        ApplicationsAdapter r0 = this.mApplications;
        if (r0 == null) goto L6;
        r0.resume(this.mSortOrder);
        this.mApplications.updateLoading();
        return;
    }

    @Override // com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        this.mResetAppsHelper.onSaveInstanceState(r3);
        r3.putInt(EXTRA_SORT_ORDER, this.mSortOrder);
        r3.putBoolean(EXTRA_SHOW_SYSTEM, this.mShowSystem);
        r3.putBoolean(EXTRA_HAS_ENTRIES, ApplicationsAdapter.access$000(this.mApplications));
        r3.putBoolean(EXTRA_HAS_BRIDGE, ApplicationsAdapter.access$100(this.mApplications));
    }

    @Override // com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ApplicationsAdapter r0 = this.mApplications;
        if (r0 == null) goto L5;
        r0.pause();
    L5:
        this.mResetAppsHelper.stop();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
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
        super.onActivityResult(r1, r2, r3);
        if (r1 != 1) goto L22;
        String r4 = this.mCurrentPkgName;
        if (r4 == null) goto L23;
        int r5 = this.mListType;
        if (r5 != 1) goto L10;
        ApplicationsAdapter.access$200(this.mApplications).forceUpdate(this.mCurrentPkgName, this.mCurrentUid);
        return;
    L10:
        if (r5 == 5) goto L18;
        if (r5 == 6) goto L18;
        if (r5 == 7) goto L18;
        this.mApplicationsState.requestSize(r4, UserHandle.getUserId(this.mCurrentUid));
        return;
    L18:
        if (this.mFinishAfterDialog == false) goto L20;
        getActivity().onBackPressed();
        return;
    L20:
        ApplicationsAdapter.access$200(this.mApplications).forceUpdate(this.mCurrentPkgName, this.mCurrentUid);
        return;
    L23:
        return;
    }

    private void startApplicationDetailsActivity() {
        int r0 = this.mListType;
        if (r0 != 3) goto L5;
        startAppInfoFragment(AppStorageSettings.class, R.string.storage_settings);
        return;
    L5:
        if (r0 != 4) goto L7;
        startAppInfoFragment(UsageAccessDetails.class, R.string.usage_access);
        return;
    L7:
        if (r0 != 5) goto L9;
        return;
    L9:
        if (r0 == 8) goto L11;
        startAppInfoFragment(InstalledAppDetails.class, R.string.application_info_label);
        return;
    L11:
        startAppInfoFragment(ExternalSourcesDetails.class, R.string.install_other_apps);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r4, MenuInflater r5) {
        HelpUtils.prepareHelpMenuItem(getActivity(), r4, getHelpResource(), getClass().getName());
        this.mOptionsMenu = r4;
        r5.inflate(R.menu.manage_apps, r4);
        updateOptionsMenu();
    }

    @Override // com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu r1) {
        updateOptionsMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyOptionsMenu() {
        this.mOptionsMenu = null;
    }

    int getHelpResource() {
        if (this.mListType != 0) goto L6;
        return R.string.help_uri_apps;
    L6:
        return R.string.help_uri_notifications;
    }

    void updateOptionsMenu() {
        Menu r0 = this.mOptionsMenu;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        r0.findItem(R.id.advanced).setVisible(false);
        MenuItem r2 = this.mOptionsMenu.findItem(R.id.sort_order_alpha);
        if (this.mListType == 3) goto L8;
    L10:
        boolean r3 = false;
    L11:
        r2.setVisible(r3);
        MenuItem r4 = this.mOptionsMenu.findItem(R.id.sort_order_size);
        if (this.mListType == 3) goto L14;
    L16:
        boolean r5 = false;
    L17:
        r4.setVisible(r5);
        MenuItem r6 = this.mOptionsMenu.findItem(R.id.show_system);
        if (this.mShowSystem == false) goto L20;
    L22:
        boolean r7 = false;
    L23:
        r6.setVisible(r7);
        MenuItem r8 = this.mOptionsMenu.findItem(R.id.hide_system);
        if (this.mShowSystem == true) goto L26;
    L28:
        boolean r9 = false;
    L29:
        r8.setVisible(r9);
        MenuItem r10 = this.mOptionsMenu.findItem(R.id.reset_app_preferences);
        if (this.mListType != 0) goto L32;
        r1 = true;
    L32:
        r10.setVisible(r1);
        return;
    L26:
        if (this.mListType == 5) goto L28;
        r9 = true;
        goto L29
    L20:
        if (this.mListType == 5) goto L22;
        r7 = true;
        goto L23
    L14:
        if (this.mSortOrder == R.id.sort_order_size) goto L16;
        r5 = true;
        goto L17
    L8:
        if (this.mSortOrder == R.id.sort_order_alpha) goto L10;
        r3 = true;
        goto L11
    }

    @Override // com.android.settingslib.core.lifecycle.ObservablePreferenceFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r4) {
        int r0 = r4.getItemId();
        switch(r4.getItemId()) {
            case 2131427536: goto L12;
            case 2131428876: goto L10;
            case 2131430557: goto L8;
            case 2131430893: goto L10;
            case 2131430970: goto L5;
            case 2131430971: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        this.mSortOrder = r0;
        this.mListView.setFastScrollEnabled(isFastScrollEnabled());
        ApplicationsAdapter r5 = this.mApplications;
        if (r5 == null) goto L11;
        r5.rebuild(this.mSortOrder);
    L11:
        updateOptionsMenu();
        goto L12
    L8:
        this.mResetAppsHelper.buildResetDialog();
        return true;
    L10:
        this.mShowSystem = !this.mShowSystem;
        this.mApplications.rebuild(false);
    L12:
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        ApplicationsAdapter r5 = this.mApplications;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getApplicationCount() <= r3) goto L9;
        com.android.settingslib.applications.ApplicationsState.AppEntry r6 = this.mApplications.getAppEntry(r3);
        this.mCurrentPkgName = r6.info.packageName;
        this.mCurrentUid = r6.info.uid;
        startApplicationDetailsActivity();
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        int r5 = this.mFilterAdapter.getFilter(r3);
        this.mFilter = r5;
        this.mApplications.setFilter(r5);
        if (DEBUG == false) goto L6;
        OLog.d("ManageApplications", "Selecting filter " + this.mFilter);
        return;
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
        this.mFilterAdapter.setFilterEnabled(3, r3);
        this.mFilterAdapter.setFilterEnabled(5, r3);
    }

    public void setHasInstant(boolean r3) {
        if (LIST_TYPES_WITH_INSTANT.contains(Integer.valueOf(this.mListType)) == false) goto L6;
        this.mFilterAdapter.setFilterEnabled(4, r3);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ManageApplications r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ManageApplications__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ManageApplications r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ManageApplications_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ManageApplications r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ManageApplications__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
