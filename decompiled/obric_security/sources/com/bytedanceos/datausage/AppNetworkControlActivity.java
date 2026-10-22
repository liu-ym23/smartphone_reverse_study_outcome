package com.bytedanceos.datausage;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.Loader;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedanceos.application.AppComparator;
import com.bytedanceos.application.AppEntry;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.common.CardPositionDecider;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.permission.DangerousPermissionUtil;
import com.bytedanceos.security.permission.OpenSystemApp;
import com.bytedanceos.security.permission.RiskPermissionControlGuard;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.reflect.PackageManagerHelper;
import com.bytedanceos.security.widget.BottomExtraView;
import com.bytedanceos.security.widget.SearchBar;
import com.bytedanceos.security.widget.pinyin.PinyinUtils;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersListView;
import com.obric.common.oea.style.scene.search.SearchModeSwitchAnimHelperType2;
import com.obric.olog.OLog;
import com.obric.oui.OuiWidgetUtils;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.OPopoverHelper;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class AppNetworkControlActivity extends BaseActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<AppEntry>>, AdapterView.OnItemClickListener, SearchBar.Listener {
    private static final int ALL = 99;
    private static final int ANIM_DURATION = 200;
    private static final int ANIM_START_DELAY = 10;
    private static final int MAX_NUMBER = 30;
    private static final String RISK_TAG = "RiskNetworkControl";
    private static final int SETTING_BTN_ID = 1;
    private static final int SLOT_MOBILE = 1;
    private static final int SLOT_WLAN = 2;
    private static final String TAG = "AppNetworkControlActivity";
    private static final int TYPE_ALLOW = 0;
    private static final int TYPE_DENNY = 0;
    private static int mCurrentSlot;
    private static final List<AppEntry> mMobileList = null;
    private static HashSet<String> mNewInstallPackage;
    private static final List<AppEntry> mWLANList = null;
    private OTabLayout cycleView;
    private OIndexScrollbar indexScrollbar;
    private String lastQueryText;
    private NetworkOptimizationAdapter mAdapter;
    private CheckBox mBtnSelectAll;
    private int mCurrentSortMode;
    private List<AppEntry> mDataList;
    private AnimatorSet mEndSearchAnim;
    private boolean mFirstLoadReported;
    private long mFirstLoadStartMs;
    private boolean mIsEdit;
    private AppEntry mLastClickItem;
    private SearchAction mLastSearch;
    private final PerformanceMonitors.FpsSceneSession mListFpsSession;
    private StickyListHeadersListView mListView;
    private View mListViewEmptyView;
    OpsManagerHelper mOpsManagerHelper;
    private final Point mOutSize;
    private BroadcastReceiver mPackageReceiver;
    private final HashMap<Character, Integer> mPositionOfSections;
    private boolean mRiskNetworkReverting;
    private NetworkOptimizationAdapter mSearchAdapter;
    private final PerformanceMonitors.FpsSceneSession mSearchAnimFpsSession;
    private TextView mSearchBackground;
    private OSearchBar mSearchBar;
    private OIconButtonFloating mSearchBarCancel;
    private OSearchBar mSearchBarContainer;
    private int mSearchBoxInitialWidth;
    private float mSearchBoxOriginalWeight;
    private View mSearchEmptyView;
    private LinearLayout mSearchOrEditBar;
    private OListView mSearchResultListView;
    private View mSearchResultView;
    private SearchModeSwitchAnimHelperType2 mSearchTransitionAnimHelper;
    private EditText mSearchView;
    private final ArrayList<String> mSections;
    private OPopover mSortDialog;
    private AnimatorSet mStartSearchAnim;
    private int mTitleBarHeight;
    private View mWholeView;
    private View search;

    private static class AppListLoader extends AsyncTaskLoader<List<AppEntry>> {
        private List<AppEntry> mApps;
        final PackageManager pm;

        @Override // android.content.Loader
        public /* bridge */ /* synthetic */ void deliverResult(Object apps) {
            deliverResult((List) apps);
        }

        @Override // android.content.AsyncTaskLoader
        public /* bridge */ /* synthetic */ List<AppEntry> loadInBackground() {
            return loadInBackground2();
        }

        AppListLoader(Context context) {
            super(context);
            this.pm = context.getPackageManager();
        }

        public void deliverResult(List<AppEntry> apps) {
            if (isReset() == false) goto L5;
            return;
        L5:
            this.mApps = apps;
            if (isStarted() == false) goto L9;
            super.deliverResult(apps);
            return;
        }

        @Override // android.content.Loader
        protected void onStartLoading() {
            super.onStartLoading();
            List<AppEntry> r0 = this.mApps;
            if (r0 == null) goto L5;
            deliverResult(r0);
            return;
        L5:
            forceLoad();
        }

        @Override // android.content.Loader
        protected void onStopLoading() {
            super.onStopLoading();
            cancelLoad();
        }

        protected boolean hasPermission(PackageInfo info) {
            if (info != null) goto L5;
            return false;
        L5:
            String[] r1 = null;
            PackageInfo r4 = this.pm.getPackageInfo(info.packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L22
            if (r4 == null) goto L10;
            r1 = r4.requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L22
        L10:
            if (r1 != null) goto L12;
        L21:
            return false;
        L12:
            if (r1.length <= 0) goto L21;
            int r5 = r1.length;
            int r6 = 0;
        L15:
            if (r6 >= r5) goto L21;
            if (TextUtils.equals(r1[r6], "android.permission.INTERNET") == true) goto L18;
            r6 = r6 + 1;
            goto L15
        L18:
            return true;
        }

        @Override // android.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<AppEntry> loadInBackground2() {
            final ArrayList r0 = new ArrayList();
            final ArrayList r1 = new ArrayList();
            if (UserHandle.myUserId() != 0) goto L5;
            int r2 = 12800;
        L67:
            List<PackageInfo> r3 = this.pm.getInstalledPackages(r2);     // Catch: RuntimeException -> L64
            if (r3 != null) goto L10;
            return null;
        L10:
            PackageManagerHelper r4 = new PackageManagerHelper(getContext().getPackageManager());     // Catch: RuntimeException -> L64
            UserManager r5 = (UserManager) getContext().getSystemService("user");     // Catch: RuntimeException -> L64
            UserHandle r6 = UserHandle.of(10);     // Catch: RuntimeException -> L64
            if (r5 != null) goto L13;
        L21:
            Iterator<PackageInfo> r7 = r3.iterator();
        L22:
            boolean r8 = true;
            if (r7.hasNext() == false) goto L50;
            PackageInfo r9 = r7.next();
            ApplicationInfo r10 = r9.applicationInfo;
            OpenSystemApp r11 = DangerousPermissionUtil.getOpenSystemAppByPkg(r9.packageName);
            if (r11 == null) goto L29;
            if (r11.isShowInNet() == false) goto L29;
        L42:
            if (hasPermission(r9) == false) goto L22;
            AppEntry r12 = new AppEntry(getContext(), r10);
            r12.setMode(OpsManagerHelper.get_MODE_INVALID());
            r0.add(r12);
            AppEntry r13 = new AppEntry(getContext(), r10);
            r12.setMode(OpsManagerHelper.get_MODE_INVALID());
            r1.add(r13);
            if (r12.mLabelEntry != null) goto L48;
            r12.ensureLabelEntry();
        L48:
            if (r13.mLabelEntry != null) goto L22;
            r13.ensureLabelEntry();
        L29:
            if ((r10.flags & 1) == 0) goto L33;
            if ("com.android.vending".equals(r10.packageName) == true) goto L33;
        L36:
            if (r8 == true) goto L22;
            if (Utils.isHiddenApp(r10.packageName) == false) goto L42;
        L33:
            if (UserHandle.isApp(r10.uid) == false) goto L36;
            r8 = false;
            goto L36
        L50:
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass1(this, r0, r1));
            Collections.sort(r0, AppComparator.ALPHA_COMPARATOR);
            Collections.sort(r1, AppComparator.ALPHA_COMPARATOR);
            OpsManagerHelper r14 = OpsManagerHelper.getInstance();
            Iterator r15 = r0.iterator();
        L52:
            if (r15.hasNext() == false) goto L56;
            AppEntry r16 = (AppEntry) r15.next();
            ApplicationInfo r17 = r16.getApplicationInfo();
            int r18 = r14.getMode(r17.uid, r17.packageName, new int[]{OpsManagerHelper.get_OP_NET_MOBILE()});
            if (r18 == OpsManagerHelper.get_MODE_INVALID()) goto L52;
            r16.setMode(r18);
            goto L52
        L56:
            Iterator r19 = r1.iterator();
        L58:
            if (r19.hasNext() == false) goto L62;
            AppEntry r20 = (AppEntry) r19.next();
            ApplicationInfo r21 = r20.getApplicationInfo();
            int r22 = r14.getMode(r21.uid, r21.packageName, new int[]{OpsManagerHelper.get_OP_NET_WIFI()});
            if (r22 == OpsManagerHelper.get_MODE_INVALID()) goto L58;
            r20.setMode(r22);
            goto L58
        L62:
            AppNetworkControlActivity.resetData(r1);
            return r0;
        L13:
            if (r5.isUserRunning(r6) == false) goto L21;
            if (r5.isUserUnlocked(r6) == false) goto L21;
            List<PackageInfo> r23 = r4.getInstalledPackages(0, 10);     // Catch: RuntimeException -> L64
            if (r23 == null) goto L21;
            if (r23.size() <= 0) goto L21;
            r3.addAll(r23);     // Catch: RuntimeException -> L64
        L64:
            e = move-exception;
            e.printStackTrace();
            return r0;
        L5:
            r2 = 4608;
            goto L67
        }

        @Override // android.content.Loader
        protected void onReset() {
            cancelLoad();
        }
    }

    static class HeaderViewHolder {
        OSectionTitleBar sectionTitleBar;

        HeaderViewHolder() {
        }
    }

    class NetworkOptimizationAdapter extends ArrayAdapter<AppEntry> implements AbsListView.RecyclerListener, StickyListHeadersAdapter {
        private static final char OTHER_SECTION = '#';
        private final Comparator<AppEntry> mAlphaComparatorWithOtherLast;
        private final CompoundButton.OnCheckedChangeListener mCheckChangeListener;
        private List<AppEntry> mEntries;
        private final int mFirstHeaderTopPadding;
        private final int mHeaderTopPadding;
        LayoutInflater mInflater;
        final /* synthetic */ AppNetworkControlActivity this$0;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
        }

        NetworkOptimizationAdapter(final AppNetworkControlActivity this$0, Context context) {
            this.this$0 = this$0;
            super(context, Utils.getResouceId("android", "simple_list_item_2", "layout", R.layout.simple_list_item_2));
            this.mAlphaComparatorWithOtherLast = new AnonymousClass1(this);
            this.mEntries = new ArrayList();
            this.mCheckChangeListener = new AnonymousClass2(this);
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
            this.mHeaderTopPadding = context.getResources().getDimensionPixelSize(com.obric.security.R.dimen.dimen_16);
            this.mFirstHeaderTopPadding = context.getResources().getDimensionPixelSize(com.obric.security.R.dimen.dimen_8);
        }

        List<AppEntry> getDatas() {
            return this.mEntries;
        }

        void setEdit(boolean isEdit) {
            AppNetworkControlActivity.access$3202(this.this$0, isEdit);
        }

        void setData(List<AppEntry> data, boolean initSections) {
            AppNetworkControlActivity.access$300(this.this$0).setEmptyView(AppNetworkControlActivity.access$3300(this.this$0));
            AppNetworkControlActivity.access$300(this.this$0).setVisibility(0);
            if (data.size() <= 30) goto L5;
            AppNetworkControlActivity.access$3400(this.this$0).setVisibility(0);
        L6:
            clear();
            if (data != null) goto L9;
        L14:
            this.mEntries = data;
            if (AppNetworkControlActivity.access$800(this.this$0).isFocused() == false) goto L17;
            AppNetworkControlActivity.access$3300(this.this$0).setVisibility(8);
        L18:
            AppNetworkControlActivity.access$3100(this.this$0);
            return;
        L17:
            AppNetworkControlActivity.access$3300(this.this$0).setVisibility(0);
            goto L18
        L9:
            if (data.size() <= 0) goto L14;
            Collections.sort(data, this.mAlphaComparatorWithOtherLast);
            clear();
            addAll(data);
            this.mEntries = data;
            if (initSections == false) goto L13;
            initSections();
        L13:
            AppNetworkControlActivity.access$3300(this.this$0).setVisibility(8);
            goto L18
        L5:
            AppNetworkControlActivity.access$3400(this.this$0).setVisibility(8);
            goto L6
        }

        public ArrayList<AppEntry> query(String input) {
            ArrayList<AppEntry> r0 = new ArrayList();
            if (TextUtils.isEmpty(input) == true) goto L17;
            List<AppEntry> r5 = this.mEntries;
            String r6 = input.toUpperCase();
            if (r5 == null) goto L17;
            Iterator<AppEntry> r7 = r5.iterator();
        L8:
            if (r7.hasNext() == false) goto L17;
            AppEntry r1 = r7.next();
            boolean r2 = r1.getLabel().toUpperCase().contains(r6);
            boolean r3 = r1.mLabelEntry.firstLetters.toUpperCase().contains(r6);
            if (PinyinUtils.isChinese(r6) == true) goto L12;
            boolean r4 = r1.mLabelEntry.labelPinyin.toUpperCase().contains(r6);
        L13:
            if (r2 == true) goto L16;
            if (r4 == true) goto L16;
            if (r3 == false) goto L8;
        L16:
            r0.add(r1);
            goto L8
        L12:
            r4 = false;
        L17:
            return r0;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            final AppEntry r9 = getItem(position);
            if (convertView != null) goto L5;
            convertView = this.mInflater.inflate(com.obric.security.R.layout.list_item_app_network_control, null);
            ViewHolder r1 = new ViewHolder(convertView);
            convertView.setTag(r1);
        L6:
            OLog.d("xxx", "getView position=" + position + ", lable=" + r9.getLabel());
            int r2 = getCount();
            if (AppNetworkControlActivity.access$800(this.this$0) != null) goto L9;
        L11:
            CardPositionDecider.HeaderIdProvider r3 = new AnonymousClass4(this);
        L12:
            r1.item.setCardPosition(CardPositionDecider.compute(position, r2, r3));
            r1.item.setDefaultCustomEndView(1);
            final OSwitch r7 = r1.item.getEndSwitch();
            r7.setTag(r9);
            r1.item.showCustomEnd(true);
            r7.setOnCheckedChangeListener(null);
            if (r9.getMode() != OpsManagerHelper.get_MODE_ALLOWED()) goto L15;
            boolean r0 = true;
        L16:
            r7.setChecked(r0);
            r7.setClickable(true);
            r7.setOnTouchListener(new AnonymousClass5(this, r9));
            r7.setOnCheckedChangeListener(this.mCheckChangeListener);
            r1.item.setOnContentClickListener(new AnonymousClass6(this, r9, r7));
            r1.item.setTitle(r9.getLabel());
            r1.item.showTitle(true);
            r1.item.setAppIcon(OuiWidgetUtils.applyDopplegangerBadge(r1.item.getContext(), r9.getIcon(), r9.isDoppleganger));
            r1.item.showIcon(true);
            if (r9.isGxbForbidRun() == false) goto L19;
            r7.setAlpha(0.6f);
            r7.setEnabled(false);
            r7.setClickable(false);
            r1.item.getCustomEndView().setEnabled(false);
        L20:
            return convertView;
        L19:
            r7.setAlpha(1.0f);
            r7.setEnabled(true);
            r7.setClickable(true);
            r1.item.getCustomEndView().setEnabled(true);
            goto L20
        L15:
            r0 = false;
            goto L16
        L9:
            if (AppNetworkControlActivity.access$800(this.this$0).isFocused() == false) goto L11;
            r3 = new AnonymousClass3(this);
            goto L12
        L5:
            r1 = (ViewHolder) convertView.getTag();
            goto L6
        }

        private void initSections() {
            AppNetworkControlActivity.access$100(this.this$0).clear();
            AppNetworkControlActivity.access$3900(this.this$0).clear();
            List<AppEntry> r0 = this.mEntries;
            if (r0.size() <= 0) goto L11;
            String r2 = String.valueOf(r0.get(0).mLabelEntry.firstChar);
            AppNetworkControlActivity.access$100(this.this$0).add(r2);
            AppNetworkControlActivity.access$3900(this.this$0).put(Character.valueOf(r0.get(0).mLabelEntry.firstChar), 0);
            int r1 = 1;
        L6:
            if (r1 >= r0.size()) goto L15;
            String r3 = String.valueOf(r0.get(r1).mLabelEntry.firstChar);
            if (r2.equals(r3) == true) goto L10;
            AppNetworkControlActivity.access$100(this.this$0).add(r3);
            AppNetworkControlActivity.access$3900(this.this$0).put(Character.valueOf(r0.get(r1).mLabelEntry.firstChar), Integer.valueOf(r1));
            r2 = r3;
        L10:
            r1 = r1 + 1;
            goto L6
        L15:
            return;
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
        L7:
            HeaderViewHolder r5 = new HeaderViewHolder();
            convertView = this.mInflater.inflate(com.obric.security.R.layout.app_network_control_sticky_header_view, null);
            r5.sectionTitleBar = (OSectionTitleBar) convertView.findViewById(com.obric.security.R.id.sticky_header);
            convertView.setTag(r5);
        L9:
            if (this.mEntries.size() >= position) goto L11;
        L13:
            String r0 = "#";
        L15:
            if (r5.sectionTitleBar == null) goto L17;
            r5.sectionTitleBar.setTitleText(r0);
        L17:
            int r6 = convertView.getPaddingLeft();
            if (position != 0) goto L20;
            int r2 = this.mFirstHeaderTopPadding;
        L21:
            convertView.setPadding(r6, r2, convertView.getPaddingRight(), convertView.getPaddingBottom());
            return convertView;
        L20:
            r2 = this.mHeaderTopPadding;
            goto L21
        L11:
            if (this.mEntries.get(position).mLabelEntry == null) goto L13;
            r0 = Character.toString(this.mEntries.get(position).mLabelEntry.firstChar);
            goto L15
        L4:
            if ((convertView.getTag() instanceof HeaderViewHolder) == false) goto L7;
            r5 = (HeaderViewHolder) convertView.getTag();
            goto L9
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int position) {
            if (this.mEntries.size() > position) goto L6;
            return 35;
        L6:
            if (this.mEntries.get(position).mLabelEntry != null) goto L8;
            return 35;
        L8:
            return this.mEntries.get(position).mLabelEntry.firstChar;
        }

        int getPositionForSection(int section) {
            Integer r0 = (Integer) AppNetworkControlActivity.access$3900(this.this$0).get(Character.valueOf((char) section));
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.intValue();
        }
    }

    private static class SearchAction {
        private final String keyword;
        private final ArrayList<AppEntry> searchResult;

        SearchAction(String keyword, ArrayList<AppEntry> list) {
            this.keyword = keyword;
            this.searchResult = list;
        }
    }

    static class ViewHolder {
        OCardListItem item;

        public ViewHolder(View view) {
            this.item = (OCardListItem) view.findViewById(com.obric.security.R.id.app_info);
        }
    }

    private boolean resetQuickBarState() {
        return false;
    }

    private void setQuickBarVisibility() {
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected boolean enablePerformanceActivityResumePeriod() {
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<AppEntry>> loader) {
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected String performancePageScene() {
        return PerformanceScenes.PAGE_PERMISSION_NETWORK_CONTROL;
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void recoverQuickBar() {
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "network_control_page";
    }

    public AppNetworkControlActivity() {
        this.mAdapter = null;
        this.mLastClickItem = null;
        this.mSearchBoxInitialWidth = -1;
        this.mSearchBoxOriginalWeight = -1.0f;
        this.mDataList = new ArrayList();
        this.mCurrentSortMode = 99;
        this.mSections = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.lastQueryText = "";
        this.mIsEdit = false;
        this.mRiskNetworkReverting = false;
        this.mOutSize = new Point();
        this.mOpsManagerHelper = null;
        this.mListFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_PERMISSION_NETWORK_CONTROL_LIST);
        this.mSearchAnimFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_ANIM_PERMISSION_NETWORK_CONTROL_SEARCH);
        this.mFirstLoadStartMs = 0;
        this.mFirstLoadReported = false;
    }

    static /* synthetic */ HashSet access$000() {
        return mNewInstallPackage;
    }

    static /* synthetic */ HashSet access$002(HashSet r0) {
        mNewInstallPackage = r0;
        return r0;
    }

    static /* synthetic */ ArrayList access$100(AppNetworkControlActivity r0) {
        return r0.mSections;
    }

    static /* synthetic */ void access$1000(AppNetworkControlActivity r0) {
        r0.hideIME();
    }

    static /* synthetic */ void access$1100(AppNetworkControlActivity r0, int r1) {
        r0.updateNetworkTab(r1);
    }

    static /* synthetic */ int access$1200(AppNetworkControlActivity r0, View r1) {
        return r0.getHeaderContentHeight(r1);
    }

    static /* synthetic */ void access$1300(AppNetworkControlActivity r0, int r1) {
        r0.updateListTopPadding(r1);
    }

    static /* synthetic */ void access$1400(AppNetworkControlActivity r0, View r1) {
        r0.playSearchBarRevealAnimation(r1);
    }

    static /* synthetic */ OTabLayout access$1500(AppNetworkControlActivity r0) {
        return r0.cycleView;
    }

    static /* synthetic */ OFloatingTitleBar access$1600(AppNetworkControlActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OFloatingTitleBar access$1700(AppNetworkControlActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OFloatingTitleBar access$1800(AppNetworkControlActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OSearchBar access$1900(AppNetworkControlActivity r0) {
        return r0.mSearchBarContainer;
    }

    static /* synthetic */ NetworkOptimizationAdapter access$200(AppNetworkControlActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ int access$2000(AppNetworkControlActivity r0) {
        return r0.mSearchBoxInitialWidth;
    }

    static /* synthetic */ int access$2002(AppNetworkControlActivity r0, int r1) {
        r0.mSearchBoxInitialWidth = r1;
        return r1;
    }

    static /* synthetic */ LinearLayout access$2100(AppNetworkControlActivity r0) {
        return r0.mSearchOrEditBar;
    }

    static /* synthetic */ float access$2200(AppNetworkControlActivity r0) {
        return r0.mSearchBoxOriginalWeight;
    }

    static /* synthetic */ float access$2202(AppNetworkControlActivity r0, float r1) {
        r0.mSearchBoxOriginalWeight = r1;
        return r1;
    }

    static /* synthetic */ SearchModeSwitchAnimHelperType2 access$2300(AppNetworkControlActivity r0) {
        return r0.mSearchTransitionAnimHelper;
    }

    static /* synthetic */ SearchModeSwitchAnimHelperType2 access$2302(AppNetworkControlActivity r0, SearchModeSwitchAnimHelperType2 r1) {
        r0.mSearchTransitionAnimHelper = r1;
        return r1;
    }

    static /* synthetic */ OFloatingTitleBar access$2400(AppNetworkControlActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OFloatingTitleBar access$2500(AppNetworkControlActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OFloatingTitleBar access$2600(AppNetworkControlActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ View access$2700(AppNetworkControlActivity r0) {
        return r0.mSearchResultView;
    }

    static /* synthetic */ View access$2800(AppNetworkControlActivity r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ Point access$2900(AppNetworkControlActivity r0) {
        return r0.mOutSize;
    }

    static /* synthetic */ StickyListHeadersListView access$300(AppNetworkControlActivity r0) {
        return r0.mListView;
    }

    static /* synthetic */ boolean access$3000(AppNetworkControlActivity r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ void access$3100(AppNetworkControlActivity r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ boolean access$3202(AppNetworkControlActivity r0, boolean r1) {
        r0.mIsEdit = r1;
        return r1;
    }

    static /* synthetic */ View access$3300(AppNetworkControlActivity r0) {
        return r0.mListViewEmptyView;
    }

    static /* synthetic */ OIndexScrollbar access$3400(AppNetworkControlActivity r0) {
        return r0.indexScrollbar;
    }

    static /* synthetic */ boolean access$3500(AppNetworkControlActivity r0) {
        return r0.mRiskNetworkReverting;
    }

    static /* synthetic */ boolean access$3502(AppNetworkControlActivity r0, boolean r1) {
        r0.mRiskNetworkReverting = r1;
        return r1;
    }

    static /* synthetic */ AppEntry access$3602(AppNetworkControlActivity r0, AppEntry r1) {
        r0.mLastClickItem = r1;
        return r1;
    }

    static /* synthetic */ List access$3700(AppNetworkControlActivity r0) {
        return r0.mDataList;
    }

    static /* synthetic */ boolean access$3800(AppNetworkControlActivity r0, AppEntry r1, String r2) {
        return r0.interceptRiskNetworkPermissionChange(r1, r2);
    }

    static /* synthetic */ HashMap access$3900(AppNetworkControlActivity r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ void access$400(AppNetworkControlActivity r0, int r1) {
        r0.scrollListToPositionAvoidingTitle(r1);
    }

    static /* synthetic */ NetworkOptimizationAdapter access$4000(AppNetworkControlActivity r0) {
        return r0.mSearchAdapter;
    }

    static /* synthetic */ int access$4100(AppNetworkControlActivity r0) {
        return r0.mCurrentSortMode;
    }

    static /* synthetic */ void access$500(AppNetworkControlActivity r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ void access$600(AppNetworkControlActivity r0, boolean r1) {
        r0.updateMainListVisibilityForSearch(r1);
    }

    static /* synthetic */ OIconButtonFloating access$700(AppNetworkControlActivity r0) {
        return r0.mSearchBarCancel;
    }

    static /* synthetic */ EditText access$800(AppNetworkControlActivity r0) {
        return r0.mSearchView;
    }

    static /* synthetic */ PerformanceMonitors.FpsSceneSession access$900(AppNetworkControlActivity r0) {
        return r0.mListFpsSession;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<AppEntry>> loader, List<AppEntry> data) {
        onLoadFinished2(loader, data);
    }

    static {
        mMobileList = new ArrayList();
        mWLANList = new ArrayList();
        TYPE_ALLOW = OpsManagerHelper.get_MODE_ALLOWED();
        TYPE_DENNY = OpsManagerHelper.get_MODE_IGNORED();
        mCurrentSlot = 1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.obric.security.R.layout.network_optimization2);
        getWindow().setBackgroundDrawable(null);
        if (getWindowManager() != null) goto L5;
    L7:
        mCurrentSlot = 1;
        this.mFirstLoadStartMs = SystemClock.elapsedRealtime();
        initView();
        getWindow();
        this.mPackageReceiver = new AnonymousClass1(this);
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
        this.mSearchOrEditBar = (LinearLayout) findViewById(com.obric.security.R.id.search_or_edit_bar);
        IntentFilter r3 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r3.addAction("android.intent.action.PACKAGE_ADDED");
        r3.addDataScheme("package");
        registerReceiver(this.mPackageReceiver, r3);
        return;
    L5:
        if (getWindowManager().getDefaultDisplay() == null) goto L7;
        getWindowManager().getDefaultDisplay().getSize(this.mOutSize);
        goto L7
    }

    private void initView() {
        if (ContextCompat.checkSelfPermission(this, "com.android.permission.GET_INSTALLED_APPS") == 0) goto L5;
        ActivityCompat.requestPermissions(this, new String[]{"com.android.permission.GET_INSTALLED_APPS"}, 1000);
    L6:
        this.mSearchBarContainer = (OSearchBar) findViewById(com.obric.security.R.id.oc_searchbar_container);
        OIndexScrollbar r0 = (OIndexScrollbar) findViewById(com.obric.security.R.id.index_scrollbar);
        this.indexScrollbar = r0;
        r0.setVisibility(8);
        this.indexScrollbar.setQBListener(new AnonymousClass2(this));
        OIconButtonFloating r1 = (OIconButtonFloating) findViewById(com.obric.security.R.id.search_field_button);
        this.mSearchBarCancel = r1;
        r1.setVisibility(8);
        this.mSearchBarCancel.setOnClickListener(new AnonymousClass3(this));
        this.mSearchBarContainer.getInputView().setHint(getString(com.obric.security.R.string.search));
        this.mSearchView = this.mSearchBarContainer.getInputView();
        this.mSearchBarContainer.getInputView().addTextChangedListener(new AnonymousClass4(this));
        this.mSearchView.setShowSoftInputOnFocus(true);
        this.mSearchView.setOnFocusChangeListener(new AnonymousClass5(this));
        this.mSearchView.addTextChangedListener(new AnonymousClass6(this));
        this.mSearchView.setOnEditorActionListener(new AnonymousClass7(this));
        CheckBox r2 = (CheckBox) findViewById(com.obric.security.R.id.checkbox_select_all);
        this.mBtnSelectAll = r2;
        if (r2 == null) goto L9;
        r2.setOnClickListener(this);
    L9:
        this.mWholeView = findViewById(com.obric.security.R.id.whole_view);
        this.mListViewEmptyView = findViewById(com.obric.security.R.id.empty_view);
        this.mAdapter = new NetworkOptimizationAdapter(this, this);
        StickyListHeadersListView r3 = (StickyListHeadersListView) findViewById(com.obric.security.R.id.listView);
        this.mListView = r3;
        if (r3 == null) goto L12;
        r3.setVisibility(4);
        this.mListView.setAreHeadersSticky(false);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.addHeaderView(new BottomExtraView(this));
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnScrollListener(new AnonymousClass8(this));
    L12:
        this.mSearchResultView = findViewById(com.obric.security.R.id.seachresultview);
        this.mSearchResultListView = (OListView) findViewById(com.obric.security.R.id.search_listview);
        this.mSearchEmptyView = findViewById(com.obric.security.R.id.search_empty_view);
        OListView r4 = this.mSearchResultListView;
        if (r4 == null) goto L15;
        r4.setOnItemClickListener(this);
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass9(this));
    L15:
        TextView r5 = (TextView) findViewById(com.obric.security.R.id.searchview_bg);
        this.mSearchBackground = r5;
        if (r5 == null) goto L19;
        r5.setOnClickListener(new AnonymousClass10(this));
    L19:
        if (this.mTitle == null) goto L21;
        this.mTitle.removeAllStartAction();
        this.mTitle.removeAllEndAction();
    L21:
        initViewsCommon();
        syncListTopPaddingWithHeader();
        OTabLayout r6 = (OTabLayout) findViewById(com.obric.security.R.id.cycle_view);
        this.cycleView = r6;
        if (r6 != null) goto L24;
        return;
    L24:
        r6.addOnTabSelectedListener(new AnonymousClass11(this));
        return;
    L5:
        ApplicationLabelCache.getInstance().reload(this);
        getLoaderManager().initLoader(0, null, this);
        goto L6
    }

    private void syncListTopPaddingWithHeader() {
        final View r0 = findViewById(com.obric.security.R.id.app_network_control_header_container);
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mListView == null) goto L10;
        r0.addOnLayoutChangeListener(new AnonymousClass12(this));
        r0.post(new AnonymousClass13(this, r0));
        return;
    }

    private int getHeaderContentHeight(View header) {
        return Math.max(0, header.getHeight() - header.getPaddingBottom());
    }

    private void updateListTopPadding(int paddingTop) {
        StickyListHeadersListView r0 = this.mListView;
        if (r0 == null) goto L10;
        if (paddingTop > 0) goto L6;
        return;
    L6:
        if (r0.getPaddingTop() == paddingTop) goto L12;
        StickyListHeadersListView r1 = this.mListView;
        r1.setPadding(r1.getPaddingLeft(), paddingTop, this.mListView.getPaddingRight(), this.mListView.getPaddingBottom());
        return;
    L12:
        return;
    }

    private void updateNetworkTab(int index) {
        boolean r0 = true;
        if (index != 0) goto L5;
        mCurrentSlot = 1;
        this.mDataList = mMobileList;
    L7:
        List<AppEntry> r6 = new ArrayList();
        if (this.mCurrentSortMode == 99) goto L15;
        Iterator<AppEntry> r1 = this.mDataList.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        AppEntry r2 = r1.next();
        if (r2.getMode() != this.mCurrentSortMode) goto L11;
        r6.add(r2);
    L16:
        NetworkOptimizationAdapter r3 = this.mAdapter;
        if (r6.size() != 0) goto L20;
        r0 = false;
    L20:
        r3.setData(r6, r0);
        this.mAdapter.notifyDataSetChanged();
        return;
    L15:
        r6 = this.mDataList;
        goto L16
    L5:
        if (index != 1) goto L27;
        mCurrentSlot = 2;
        this.mDataList = mWLANList;
        goto L7
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 1000) goto L11;
        if (grantResults != null) goto L6;
        return;
    L6:
        if (grantResults.length > 0) goto L8;
        return;
    L8:
        if (grantResults[0] != 0) goto L14;
        getLoaderManager().initLoader(0, null, this);
        return;
    L14:
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mSearchView.isFocused() == false) goto L6;
        cancelSearch();
        return;
    L6:
        if (this.mIsEdit == true) goto L11;
        super.onBackPressed();
        return;
    }

    private void cancelSearch() {
        this.mSearchView.setText("");
        this.mSearchView.clearFocus();
        SearchModeSwitchAnimHelperType2 r0 = this.mSearchTransitionAnimHelper;
        if (r0 == null) goto L5;
        r0.playExitAnim(new AnonymousClass14(this));
    L11:
        OSearchBar r1 = this.mSearchBarContainer;
        if (r1 == null) goto L18;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof LinearLayout.LayoutParams) == false) goto L18;
        float r3 = this.mSearchBoxOriginalWeight;
        if (r3 < 0.0f) goto L18;
        ((LinearLayout.LayoutParams) r2).weight = r3;
        this.mSearchBarContainer.setLayoutParams(r2);
    L18:
        OTabLayout r4 = this.cycleView;
        if (r4 == null) goto L22;
        r4.setVisibility(0);
    L22:
        if (this.mTitle == null) goto L24;
        this.mTitle.removeAllStartAction();
        this.mTitle.removeAllEndAction();
    L24:
        initViewsCommon();
        updateMainListVisibilityForSearch(false);
        return;
    L5:
        LinearLayout r5 = this.mSearchOrEditBar;
        if (r5 == null) goto L8;
        r5.setVisibility(8);
        this.mSearchOrEditBar.setAlpha(1.0f);
        this.mSearchOrEditBar.setScaleX(1.0f);
        this.mSearchOrEditBar.setScaleY(1.0f);
    L8:
        OSearchBar r6 = this.mSearchBarContainer;
        if (r6 == null) goto L11;
        r6.setVisibility(8);
        goto L11
    }

    private void updateMainListVisibilityForSearch(boolean searching) {
        StickyListHeadersListView r0 = this.mListView;
        if (r0 != null) goto L6;
        return;
    L6:
        if (searching == false) goto L8;
        int r2 = 8;
    L9:
        r0.setVisibility(r2);
        View r3 = this.mListViewEmptyView;
        if (r3 == null) goto L14;
        if (searching == false) goto L15;
        r3.setVisibility(8);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r2 = 0;
        goto L9
    }

    private void scrollListToPositionAvoidingTitle(int position) {
        StickyListHeadersListView r0 = this.mListView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setSelectionFromTop(position, getListSelectionTopOffset());
    }

    private int getListSelectionTopOffset() {
        int r1 = 0;
        if (this.mTitle == null) goto L7;
        int r0 = this.mTitle.getHeight();
        if (r0 > 0) goto L8;
        r0 = this.mTitleBarHeight;
    L8:
        StickyListHeadersListView r2 = this.mListView;
        if (r2 == null) goto L12;
        r1 = r2.getPaddingTop();
    L12:
        return Math.max(r1, r0);
    L7:
        r0 = 0;
        goto L8
    }

    private void initViewsCommon() {
        initTitleBar(false, false);
        this.mTitle.bringToFront();
        this.mTitle.requestLayout();
        getResources().getDimensionPixelSize(com.obric.security.R.dimen.dimen_44);
        getResources().getDimensionPixelSize(com.obric.security.R.dimen.dimen_32);
        getLayoutInflater();
        this.mTitle.addEndAction(com.obric.security.R.drawable.oic_ellipsis_3, -1, new AnonymousClass15(this));
        this.search = this.mTitle.addEndAction(com.obric.security.R.drawable.o_icon_search, 0, new AnonymousClass16(this));
    }

    private void playSearchBarRevealAnimation(final View anchor) {
        LinearLayout r0 = this.mSearchOrEditBar;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(0);
        OSearchBar r1 = this.mSearchBarContainer;
        if (r1 != null) goto L8;
        return;
    L8:
        r1.post(new AnonymousClass17(this, anchor));
    }

    private List<DataUsageMenuItem> getSortMenuList() {
        String r1 = getString(com.obric.security.R.string.permission_status_all);
        boolean r4 = true;
        if (this.mCurrentSortMode != 99) goto L5;
        boolean r2 = true;
    L6:
        DataUsageMenuItem r0 = new DataUsageMenuItem(r1, r2, 6);
        String r3 = getString(com.obric.security.R.string.switch_open);
        if (this.mCurrentSortMode != TYPE_ALLOW) goto L9;
        boolean r5 = true;
    L10:
        DataUsageMenuItem r6 = new DataUsageMenuItem(r3, r5, SearchBar.FILTER_BY_ALLOW);
        String r7 = getString(com.obric.security.R.string.switch_close);
        if (this.mCurrentSortMode == TYPE_DENNY) goto L14;
        r4 = false;
    L14:
        DataUsageMenuItem r8 = new DataUsageMenuItem(r7, r4, SearchBar.FILTER_BY_DENY);
        ArrayList r9 = new ArrayList();
        r9.add(r0);
        r9.add(r6);
        r9.add(r8);
        return r9;
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private void showSortDialog(View anchorView) {
        OPopover.Builder r1 = new OPopover.Builder(this);
        this.mSortDialog = null;
        final Function r2 = new AppNetworkControlActivity$$ExternalSyntheticLambda0(this);
        OPopoverEntranceMenuView.Builder r13 = new OPopoverEntranceMenuView.Builder(this);
        r13.enableOption();
        final List<DataUsageMenuItem> r14 = getSortMenuList();
        int r12 = 0;
    L4:
        if (r12 >= r14.size()) goto L6;
        DataUsageMenuItem r3 = r14.get(r12);
        r13.addPopoverRightOptionItem(false, 0, 0, Integer.valueOf(getColor(com.obric.security.R.color.oui_accent_fg)), r3.getTitle(), null, false, r3.isSelected(), new AnonymousClass18(this, r14, r2));
        r12 = r12 + 1;
        goto L4
    L6:
        OPopover r4 = r1.setView(r13.build()).setGravity(48).build();
        OPopoverHelper.INSTANCE.showPopoverSmartly(r4, anchorView, 48, false, 0.0f, 0, 0);
        this.mSortDialog = r4;
    }

    /* JADX INFO: renamed from: lambda$showSortDialog$0$com-bytedanceos-datausage-AppNetworkControlActivity, reason: not valid java name */
    /* synthetic */ Unit m101x109fa47(Unit r2) {
        OPopover r3 = this.mSortDialog;
        if (r3 == null) goto L5;
        r3.dismiss();
        this.mSortDialog = null;
    L5:
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.obric.security.R.id.btn_ok) goto L6;
        return;
    L6:
        if (this.mSearchView.isFocused() == true) goto L11;
        resetQuickBarState();
        return;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<AppEntry>> onCreateLoader(int id, Bundle args) {
        return new AppListLoader(this);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<AppEntry>> loader, List<AppEntry> data) {
        if (this.mFirstLoadReported == false) goto L5;
    L7:
        PerformanceMonitors.reportThreads(PerformanceScenes.THREAD_PERMISSION_NETWORK_CONTROL_LOAD);
        this.mDataList = data;
        if (mCurrentSlot != 1) goto L10;
        List<AppEntry> r6 = mMobileList;
        r6.clear();
        r6.addAll(data);
    L11:
        View r7 = findViewById(com.obric.security.R.id.package_loading_text);
        if (r7 == null) goto L14;
        r7.setVisibility(8);
    L14:
        ArrayList r8 = new ArrayList();
        if (this.mCurrentSortMode != 99) goto L17;
        this.mAdapter.setData(this.mDataList, true);
    L24:
        this.mAdapter.notifyDataSetChanged();
        return;
    L17:
        Iterator<AppEntry> r9 = this.mDataList.iterator();
    L19:
        if (r9.hasNext() == false) goto L23;
        AppEntry r1 = r9.next();
        if (r1.getMode() != this.mCurrentSortMode) goto L19;
        r8.add(r1);
        goto L19
    L23:
        this.mAdapter.setData(r8, true);
        goto L24
    L10:
        List<AppEntry> r10 = mWLANList;
        r10.clear();
        r10.addAll(data);
        goto L11
    L5:
        if (this.mFirstLoadStartMs <= 0) goto L7;
        this.mFirstLoadReported = true;
        PerformanceMonitors.reportActionTime(PerformanceScenes.ACTION_PERMISSION_NETWORK_CONTROL_FIRST_LOAD, SystemClock.elapsedRealtime() - this.mFirstLoadStartMs);
        goto L7
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public boolean onModeChange(int sortMode) {
        List<AppEntry> r0 = new ArrayList();
        if (sortMode != 6) goto L6;
        this.mCurrentSortMode = 99;
        r0 = this.mDataList;
    L12:
        if (this.mCurrentSortMode == 99) goto L20;
        Iterator<AppEntry> r5 = this.mDataList.iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        AppEntry r1 = r5.next();
        if (r1.getMode() != this.mCurrentSortMode) goto L15;
        r0.add(r1);
    L20:
        if (r0.size() != 0) goto L22;
        this.mAdapter.setData(r0, false);
        this.mAdapter.notifyDataSetChanged();
    L23:
        return true;
    L22:
        this.mAdapter.setData(r0, true);
        goto L23
    L6:
        if (sortMode != SearchBar.FILTER_BY_ALLOW) goto L9;
        this.mCurrentSortMode = TYPE_ALLOW;
        goto L12
    L9:
        if (sortMode != SearchBar.FILTER_BY_DENY) goto L12;
        this.mCurrentSortMode = TYPE_DENNY;
        goto L12
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void setSoftKeyboardHide() {
        hideIME();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void startSearchAnimation() {
        this.mSearchAnimFpsSession.start();
        initStartSearchAnimation();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void endSearchAnimation() {
        startEndSearchAnimation();
        this.mSearchAnimFpsSession.stop();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void onQueryTextChange(String newString) {
        search(newString);
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void hideQuickContactView() {
        resetQuickBarState();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void endSearchAnimationWithoutAnimation() {
        Utils.setAnimatorScale(this);
        this.mWholeView.setTranslationY(0.0f);
        this.mSearchResultView.setAlpha(0.0f);
        searchAnimationEnd();
    }

    protected void searchAnimationEnd() {
        this.mWholeView.postDelayed(new AnonymousClass19(this), 30);
    }

    private void hideIME() {
        Utils.hideInputMethod(this, getWindow().getDecorView().getWindowToken());
    }

    private void initStartSearchAnimation() {
        if (this.mStartSearchAnim != null) goto L5;
        this.mTitleBarHeight = this.mTitle.getHeight() + 2;
        Utils.setAnimatorScale(this);
        PropertyValuesHolder r0 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{r0});
        AnimatorSet r2 = new AnimatorSet();
        this.mStartSearchAnim = r2;
        r2.setDuration(200);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.playTogether(new Animator[]{r1});
        this.mStartSearchAnim.addListener(new AnonymousClass20(this));
    L5:
        this.mStartSearchAnim.start();
    }

    private void startEndSearchAnimation() {
        resetDataOnSearchEnd();
        if (this.mEndSearchAnim != null) goto L5;
        PropertyValuesHolder r0 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{r0});
        AnimatorSet r2 = new AnimatorSet();
        this.mEndSearchAnim = r2;
        r2.setDuration(200);
        this.mEndSearchAnim.playTogether(new Animator[]{r1});
        this.mEndSearchAnim.addListener(new AnonymousClass21(this));
    L5:
        this.mEndSearchAnim.start();
    }

    private void search(String keyword) {
        if (keyword != null) goto L4;
        return;
    L4:
        if (keyword.trim().equals(this.lastQueryText) == true) goto L24;
        this.lastQueryText = keyword.trim();
        if (TextUtils.isEmpty(keyword) == true) goto L9;
    L13:
        this.mListView.setEmptyView(null);
        this.mSearchResultListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        ArrayList<AppEntry> r0 = this.mAdapter.query(keyword);
        if (TextUtils.isEmpty(keyword) == true) goto L17;
        this.mLastSearch = new SearchAction(keyword, r0);
    L17:
        if (this.mSearchAdapter != null) goto L19;
        NetworkOptimizationAdapter r4 = new NetworkOptimizationAdapter(this, this);
        this.mSearchAdapter = r4;
        this.mSearchResultListView.setAdapter(r4);
    L19:
        this.mSearchAdapter.setData(r0, false);
        return;
    L9:
        if (this.mSearchView.isFocused() == false) goto L13;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
        if (this.mAdapter.getCount() > 0) goto L22;
        this.mListView.setEmptyView(this.mListViewEmptyView);
        return;
    L22:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.mSearchView.isFocused() == false) goto L5;
        cancelSearch();
        this.mListView.setVisibility(0);
    L5:
        resetQuickBarState();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getLoaderManager().destroyLoader(0);
        BroadcastReceiver r0 = this.mPackageReceiver;
        if (r0 == null) goto L5;
        unregisterReceiver(r0);
        this.mPackageReceiver = null;
    L5:
        HashSet<String> r2 = mNewInstallPackage;
        if (r2 == null) goto L9;
        r2.clear();
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    protected static void resetData(List<AppEntry> otherEntries) {
        if (mCurrentSlot != 1) goto L5;
        List<AppEntry> r0 = mWLANList;
        r0.clear();
        r0.addAll(otherEntries);
        return;
    L5:
        List<AppEntry> r1 = mMobileList;
        r1.clear();
        r1.addAll(otherEntries);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    private void resetDataOnSearchEnd() {
        if (this.mCurrentSortMode == 99) goto L11;
        ArrayList r0 = new ArrayList();
        Iterator<AppEntry> r1 = this.mDataList.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        AppEntry r3 = r1.next();
        if (r3.getMode() != this.mCurrentSortMode) goto L6;
        r0.add(r3);
        goto L6
    L10:
        this.mAdapter.setData(r0, true);
    L12:
        this.mAdapter.notifyDataSetChanged();
        return;
    L11:
        this.mAdapter.setData(this.mDataList, true);
        goto L12
    }

    protected boolean savePermissionStatus(final AppEntry entry, int mode) {
        if (interceptRiskNetworkPermissionChange(entry, "savePermissionStatus") == false) goto L6;
        return false;
    L6:
        entry.setMode(mode);
        if (mCurrentSlot != 1) goto L9;
        int r0 = OpsManagerHelper.get_OP_NET_MOBILE();
    L10:
        this.mOpsManagerHelper.setMode(r0, entry.getApplicationInfo().uid, entry.getApplicationInfo().packageName, mode);
        Runnable r7 = new AnonymousClass22(this, entry);
        this.mListView.postDelayed(r7, 220);
        return true;
    L9:
        r0 = OpsManagerHelper.get_OP_NET_WIFI();
        goto L10
    }

    private boolean interceptRiskNetworkPermissionChange(AppEntry entry, String source) {
        return RiskPermissionControlGuard.interceptNetworkPermissionChange(this, entry, RISK_TAG, source);
    }
}
