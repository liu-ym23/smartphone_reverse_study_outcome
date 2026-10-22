package com.bytedanceos.securitycenter;

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
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.NetworkPolicyManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IPowerAdvisor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import bytedanceos.util.LogTag;
import com.bytedanceos.application.AppComparator;
import com.bytedanceos.application.AppEntry;
import com.bytedanceos.common.CardPositionDecider;
import com.bytedanceos.datausage.DataUsageMenuItem;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.permission.RiskPermissionControlGuard;
import com.bytedanceos.security.widget.QuickBarEx;
import com.bytedanceos.security.widget.SearchBar;
import com.bytedanceos.security.widget.SlideListView;
import com.bytedanceos.security.widget.pinyin.PinyinUtils;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersListView;
import com.bytedanceos.securitycenter.networkControl.DeviceIdleControllerHelper;
import com.bytedanceos.securitycenter.networkControl.NetworkRejectHelper;
import com.bytedanceos.utils.OCardListItemExtKt;
import com.obric.common.oea.style.scene.search.SearchModeSwitchAnimHelperType2;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.oui.OuiWidgetUtils;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.security.networksettings.NetworkPolicyActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import obric.widget.BarsHelper;
import obric.widget.ButtonTabGroup;
import obric.widget.TitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkOptimizationSetting extends BaseActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<AppEntry>>, AdapterView.OnItemClickListener, SearchBar.Listener, SlideListView.Listener {
    private static final int ALL = -1;
    private static final int ANIM_DURATION = 200;
    private static final int ANIM_START_DELAY = 10;
    private static final int LIST_TOP_PADDING_DP = 92;
    private static final int MAX_NUMBER = 30;
    private static final int NONE = 0;
    private static final int REJECT_ALL = 16;
    private static final int REJECT_SCREEN_OFF = 8;
    private static final String RISK_TAG = "RiskNetworkOptimizationSetting";
    private static final String TAG = "NetworkOptimizationSetting";
    private static HashSet<String> mNewInstallPackage;
    private OIndexScrollbar indexScrollbar;
    private boolean isSelectAll;
    private String lastQueryText;
    private NetworkOptimizationAdapter mAdapter;
    private View mAllow;
    private View mBottomBar;
    private OCheckBox mBtnSelectAll;
    private int mCurrentSortMode;
    private List<AppEntry> mDataList;
    private LinearInterpolator mDecelerateInterpolator;
    private View mEditBarView;
    private AnimatorSet mEndSearchAnim;
    private boolean mFirstLoadReported;
    private long mFirstLoadStartMs;
    private TextView mHeaderTip;
    private boolean mIsAnimating;
    private boolean mIsEdit;
    private boolean mIsHandleClick;
    private float mItemTranslateX;
    private AppEntry mLastClickItem;
    private final PerformanceMonitors.FpsSceneSession mListFpsSession;
    private StickyListHeadersListView mListView;
    private View mListViewEmptyView;
    private OInsetSheet mMenuDialog;
    private ViewStub mNetListControlVS;
    private NetworkPolicyManager mNetworkPolicyManager;
    private ViewStub mOptionBarVS;
    private Point mOutSize;
    private BroadcastReceiver mPackageReceiver;
    private HashMap<Character, Integer> mPositionOfSections;
    private IPowerAdvisor mPowerAdvisor;
    private QuickBarEx.QBListener mQBListener;
    private OButton mReject;
    private View mRejectScreenOff;
    private OCheckBox mRightCheckBox;
    private View mRightEditContainer;
    private int mRightImgCancelRes;
    private int mRightImgEditRes;
    private int mSearchActionIndex;
    private boolean mSearchActionRemoved;
    private NetworkOptimizationAdapter mSearchAdapter;
    private final PerformanceMonitors.FpsSceneSession mSearchAnimFpsSession;
    private TextView mSearchBackground;
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
    private ArrayList<String> mSections;
    private TextView mSelectFiles;
    private ArrayList<AppEntry> mSelectedInfos;
    private OPopover mSortDialog;
    private AnimatorSet mStartSearchAnim;
    private int mTitleBarHeight;
    private OIconButtonFloating mTitleBarLeftButton;
    private View mTitleBarRightButton;
    private View mTitleBarRightImg;
    private View mTitleBarSearchImg;
    private View mWholeView;

    private static class AppListLoader extends AsyncTaskLoader<List<AppEntry>> {
        private List<AppEntry> mApps;
        private NetworkPolicyManager npm;
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
            this.npm = NetworkPolicyManager.from(context);
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
            forceLoad();
        }

        @Override // android.content.Loader
        protected void onStopLoading() {
            super.onStopLoading();
            cancelLoad();
        }

        @Override // android.content.AsyncTaskLoader
        /* JADX INFO: renamed from: loadInBackground, reason: avoid collision after fix types in other method */
        public List<AppEntry> loadInBackground2() {
            final ArrayList r0 = new ArrayList();
            if (UserHandle.myUserId() != 0) goto L5;
            int r1 = 12800;
        L6:
            List<PackageInfo> r2 = this.pm.getInstalledPackages(r1);
            if (r2 == null) goto L22;
            Iterator<PackageInfo> r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L22;
            PackageInfo r4 = r3.next();
            if (com.bytedanceos.security.Utils.isHiddenApp(r4.packageName) == true) goto L10;
            ApplicationInfo r5 = r4.applicationInfo;
            if (r5.uid < 10000) goto L10;
            if ((r5.flags & 1) != 0) goto L10;
            AppEntry r6 = new AppEntry(getContext(), r5);
            if (r6.mLabelEntry != null) goto L21;
            r6.ensureLabelEntry();
        L21:
            r0.add(r6);
        L22:
            Collections.sort(r0, AppComparator.ALPHA_COMPARATOR);
            ArrayList r7 = new ArrayList();
            Iterator r8 = r0.iterator();
        L24:
            if (r8.hasNext() == false) goto L30;
            AppEntry r9 = (AppEntry) r8.next();
            if (r9.mLabelEntry == null) goto L24;
            if (r9.mLabelEntry.firstChar != '#') goto L24;
            r7.add(r9);
            r8.remove();
            goto L24
        L30:
            r0.addAll(r7);
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass1(this, r0));
            Iterator r10 = r0.iterator();
        L32:
            if (r10.hasNext() == false) goto L44;
            AppEntry r11 = (AppEntry) r10.next();
            ApplicationInfo r12 = r11.getApplicationInfo();
            int r13 = this.npm.getUidPolicy(r12.uid);
            if (r13 != 0) goto L39;
            if (DeviceIdleControllerHelper.isWhileListApp(r12.packageName) == true) goto L39;
            r13 = 8;
        L39:
            if (NetworkOptimizationSetting.access$000() == null) goto L43;
            if (NetworkOptimizationSetting.access$000().contains(r12.packageName) == false) goto L43;
            r13 = NetworkRejectHelper.setDefaultPolicyForPackage(r12, getContext());
            NetworkOptimizationSetting.access$000().remove(r12.packageName);
        L43:
            r11.setMode(r13);
            goto L32
        L44:
            return r0;
        L5:
            r1 = 4608;
            goto L6
        }

        @Override // android.content.Loader
        protected void onReset() {
            cancelLoad();
        }
    }

    static class HeaderViewHolder {
        TextView headerText;

        HeaderViewHolder() {
        }
    }

    class NetworkOptimizationAdapter extends ArrayAdapter<AppEntry> implements AbsListView.RecyclerListener, StickyListHeadersAdapter {
        private List<AppEntry> mEntries;
        LayoutInflater mInflater;
        private boolean mIsEdit;
        private View.OnClickListener mOnClickListener;
        final /* synthetic */ NetworkOptimizationSetting this$0;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
        }

        static /* synthetic */ View.OnClickListener access$4500(NetworkOptimizationAdapter r0) {
            return r0.mOnClickListener;
        }

        NetworkOptimizationAdapter(final NetworkOptimizationSetting this$0, Context context) {
            this.this$0 = this$0;
            super(context, com.bytedanceos.security.Utils.getResouceId("android", "simple_list_item_2", "layout", R.layout.simple_list_item_2));
            this.mEntries = new ArrayList();
            this.mIsEdit = false;
            this.mOnClickListener = new AnonymousClass1(this);
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        List<AppEntry> getDatas() {
            return this.mEntries;
        }

        void setEdit(boolean isEdit) {
            this.mIsEdit = isEdit;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }

        void setData(List<AppEntry> data, boolean initSections) {
            NetworkOptimizationSetting.access$200(this.this$0).setEmptyView(NetworkOptimizationSetting.access$4000(this.this$0));
            int r1 = 0;
            NetworkOptimizationSetting.access$200(this.this$0).setVisibility(0);
            if (data.size() <= 30) goto L5;
            NetworkOptimizationSetting.access$4100(this.this$0).setVisibility(0);
        L6:
            clear();
            resetSelecteds(data);
            if (data == null) goto L29;
            if (data.size() <= 0) goto L29;
            Collections.sort(data, AppComparator.ALPHA_COMPARATOR);
            ArrayList r0 = new ArrayList();
            Iterator<AppEntry> r2 = data.iterator();
        L12:
            if (r2.hasNext() == false) goto L18;
            AppEntry r4 = r2.next();
            if (r4.mLabelEntry == null) goto L12;
            if (r4.mLabelEntry.firstChar != '#') goto L12;
            r0.add(r4);
            r2.remove();
            goto L12
        L18:
            data.addAll(r0);
            clear();
            addAll(data);
            this.mEntries = data;
            OSearchBar r8 = NetworkOptimizationSetting.access$2300(this.this$0);
            if (NetworkOptimizationSetting.access$900(this.this$0) != null) goto L21;
        L23:
            r1 = 8;
        L24:
            r8.setVisibility(r1);
            if (initSections == false) goto L27;
            initSections();
        L27:
            NetworkOptimizationSetting.access$4200(this.this$0).setEnabled(true);
            NetworkOptimizationSetting.access$4000(this.this$0).setVisibility(8);
        L33:
            NetworkOptimizationSetting.access$3700(this.this$0);
            return;
        L21:
            if (NetworkOptimizationSetting.access$900(this.this$0).isFocused() == false) goto L23;
        L29:
            if (NetworkOptimizationSetting.access$900(this.this$0).isFocused() == false) goto L31;
            NetworkOptimizationSetting.access$4000(this.this$0).setVisibility(8);
        L32:
            NetworkOptimizationSetting.access$4200(this.this$0).setEnabled(false);
            goto L33
        L31:
            NetworkOptimizationSetting.access$4000(this.this$0).setVisibility(0);
            goto L32
        L5:
            NetworkOptimizationSetting.access$4100(this.this$0).setVisibility(8);
            goto L6
        }

        private void resetSelecteds(List<AppEntry> datas) {
            if (NetworkOptimizationSetting.access$4300(this.this$0).size() > 0) goto L5;
            return;
        L5:
            ArrayList r0 = new ArrayList();
            Iterator<AppEntry> r8 = datas.iterator();
        L7:
            if (r8.hasNext() == false) goto L23;
            AppEntry r1 = r8.next();
            Iterator r2 = NetworkOptimizationSetting.access$4300(this.this$0).iterator();
        L10:
            if (r2.hasNext() == false) goto L7;
            AppEntry r3 = (AppEntry) r2.next();
            int r5 = 0;
            if (r1.getApplicationInfo() != null) goto L14;
            int r4 = 0;
        L16:
            if (r3.getApplicationInfo() == null) goto L19;
            r5 = r3.getApplicationInfo().uid;
        L19:
            if (r4 != r5) goto L10;
            if (TextUtils.equals(r1.getPackageName(), r3.getPackageName()) == false) goto L10;
            r0.add(r1);
            goto L10
        L14:
            r4 = r1.getApplicationInfo().uid;
            goto L16
        L23:
            NetworkOptimizationSetting.access$4300(this.this$0).clear();
            if (r0.size() <= 0) goto L35;
            NetworkOptimizationSetting.access$4300(this.this$0).addAll(r0);
            return;
        }

        public ArrayList<AppEntry> query(String input) {
            ArrayList<AppEntry> r0 = new ArrayList();
            if (TextUtils.isEmpty(input) == true) goto L24;
            List<AppEntry> r1 = this.mEntries;
            String r9 = input.toUpperCase();
            if (r1 == null) goto L24;
            Iterator<AppEntry> r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L24;
            AppEntry r3 = r2.next();
            boolean r5 = false;
            if (NetworkOptimizationSetting.access$4400(this.this$0) != (-1)) goto L12;
        L15:
            boolean r4 = true;
        L16:
            boolean r6 = r3.getLabel().toUpperCase().contains(r9);
            boolean r7 = r3.mLabelEntry.firstLetters.toUpperCase().contains(r9);
            if (PinyinUtils.isChinese(r9) == true) goto L19;
            r5 = r3.mLabelEntry.labelPinyin.toUpperCase().contains(r9);
        L19:
            if (r4 == false) goto L8;
            if (r6 == true) goto L23;
            if (r5 == true) goto L23;
            if (r7 == false) goto L8;
        L23:
            r0.add(r3);
            goto L8
        L12:
            if (r3.getMode() == NetworkOptimizationSetting.access$4400(this.this$0)) goto L15;
            r4 = false;
        L24:
            return r0;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            final AppEntry r9 = getItem(position);
            if (convertView != null) goto L5;
            convertView = this.mInflater.inflate(com.obric.security.R.layout.application_item_scroll_layout, null);
            final ViewHolder r2 = new ViewHolder(convertView, this.mInflater.inflate(com.obric.security.R.layout.single_checkbox, null));
            convertView.setTag(r2);
        L7:
            if (NetworkOptimizationSetting.access$900(this.this$0) != null) goto L9;
        L11:
            CardPositionDecider.HeaderIdProvider r1 = new AnonymousClass3(this);
        L12:
            int r3 = CardPositionDecider.compute(position, getCount(), r1);
            r2.item.setCardPosition(r3);
            r2.checkBox.setTag(Integer.valueOf(position));
            r2.checkBox.setOnClickListener(this.mOnClickListener);
            r2.item.setDefaultTailIcon(1);
            if (this.mIsEdit == false) goto L15;
            r2.item.setOnContentClickListener(new AnonymousClass4(this, r2));
            r2.item.showTailIcon(false);
        L16:
            r2.item.setTitle(r9.getLabel());
            r2.item.setAppIcon(OuiWidgetUtils.applyDopplegangerBadge(r2.item.getContext(), r9.getIcon(), r9.isDoppleganger));
            r2.item.showIcon(true);
            OCardListItemExtKt.setEndText(r2.item, NetworkOptimizationSetting.access$4600(this.this$0, r9));
            final ImageView r0 = r2.item.getTailIconView();
            OTextView r4 = r2.item.getEndDetail();
            if (r0 == null) goto L19;
            r0.setOnTouchListener(new AnonymousClass5(this, r9));
            r0.setOnClickListener(new AnonymousClass6(this, r9));
        L19:
            if (r4 == null) goto L21;
            r4.setOnTouchListener(new AnonymousClass7(this, r9));
            r4.setOnClickListener(new AnonymousClass8(this, r9, r0));
        L21:
            AppEntry r7 = getItem(position);
            updateCheckBox(r2.item, r2.checkBox, this.mIsEdit, NetworkOptimizationSetting.access$4300(this.this$0).contains(r7));
            return convertView;
        L15:
            r2.item.setOnContentClickListener(null);
            r2.item.showTailIcon(true);
            goto L16
        L9:
            if (NetworkOptimizationSetting.access$900(this.this$0).isFocused() == false) goto L11;
            r1 = new AnonymousClass2(this);
            goto L12
        L5:
            r2 = (ViewHolder) convertView.getTag();
            goto L7
        }

        private void initSections() {
            NetworkOptimizationSetting.access$400(this.this$0).clear();
            NetworkOptimizationSetting.access$4900(this.this$0).clear();
            List<AppEntry> r0 = this.mEntries;
            if (r0.size() <= 0) goto L11;
            String r2 = String.valueOf(r0.get(0).mLabelEntry.firstChar);
            NetworkOptimizationSetting.access$400(this.this$0).add(r2);
            NetworkOptimizationSetting.access$4900(this.this$0).put(Character.valueOf(r0.get(0).mLabelEntry.firstChar), 0);
            int r1 = 1;
        L6:
            if (r1 >= r0.size()) goto L15;
            String r3 = String.valueOf(r0.get(r1).mLabelEntry.firstChar);
            if (r2.equals(r3) == true) goto L10;
            NetworkOptimizationSetting.access$400(this.this$0).add(r3);
            NetworkOptimizationSetting.access$4900(this.this$0).put(Character.valueOf(r0.get(r1).mLabelEntry.firstChar), Integer.valueOf(r1));
            r2 = r3;
        L10:
            r1 = r1 + 1;
            goto L6
        L15:
            return;
        }

        private void updateCheckBox(View mPicFrameView, OCheckBox mCheckBox, boolean isEditMode, boolean isCheck) {
            if (isEditMode == false) goto L8;
            if (NetworkOptimizationSetting.access$3100(this.this$0) == true) goto L6;
            mCheckBox.setVisibility(0);
        L6:
            mCheckBox.setChecked(isCheck);
            return;
        L8:
            if (NetworkOptimizationSetting.access$3100(this.this$0) == true) goto L12;
            mCheckBox.setVisibility(8);
            return;
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
        L7:
            HeaderViewHolder r5 = new HeaderViewHolder();
            convertView = this.mInflater.inflate(com.obric.security.R.layout.sticky_list_header_view, null);
            r5.headerText = (TextView) convertView.findViewById(com.obric.security.R.id.sticky_header);
            convertView.setTag(r5);
        L9:
            if (this.mEntries.size() >= position) goto L11;
        L13:
            String r2 = "#";
        L15:
            if (r5.headerText == null) goto L17;
            r5.headerText.setText(r2);
        L17:
            return convertView;
        L11:
            if (this.mEntries.get(position).mLabelEntry == null) goto L13;
            r2 = Character.toString(this.mEntries.get(position).mLabelEntry.firstChar);
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
            Integer r0 = (Integer) NetworkOptimizationSetting.access$4900(this.this$0).get(Character.valueOf((char) section));
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.intValue();
        }
    }

    private static class SearchAction {
        private String keyword;
        private ArrayList<AppEntry> searchResult;

        SearchAction(String keyword, ArrayList<AppEntry> list) {
            this.keyword = keyword;
            this.searchResult = list;
        }
    }

    static class ViewHolder {
        OCheckBox checkBox;
        OCardListItem item;

        public ViewHolder(View view, View checkBoxContainer) {
            this.item = (OCardListItem) view.findViewById(com.obric.security.R.id.app_info);
            OCheckBox r2 = (OCheckBox) checkBoxContainer.findViewById(com.obric.security.R.id.checkBox);
            if ((r2.getParent() instanceof ViewGroup) == false) goto L5;
            ((ViewGroup) r2.getParent()).removeView(r2);
        L5:
            com.bytedanceos.oui.OCardListItemExtKt.setStartView(this.item, r2);
            this.checkBox = r2;
        }
    }

    private boolean resetQuickBarState() {
        return false;
    }

    private void setQuickBarVisibility() {
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<AppEntry>> loader) {
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected String performancePageScene() {
        return PerformanceScenes.PAGE_PERMISSION_BACKGROUND_NETWORK;
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void recoverQuickBar() {
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "background_network_permission_page";
    }

    public NetworkOptimizationSetting() {
        this.mAdapter = null;
        this.mLastClickItem = null;
        this.mSearchBoxInitialWidth = -1;
        this.mSearchBoxOriginalWeight = -1.0f;
        this.mDataList = new ArrayList();
        this.mCurrentSortMode = -1;
        this.mSections = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.lastQueryText = "";
        this.mIsEdit = false;
        this.mIsHandleClick = false;
        this.mSelectedInfos = new ArrayList();
        this.mOutSize = new Point();
        this.mSearchActionIndex = 0;
        this.mSearchActionRemoved = false;
        this.isSelectAll = false;
        this.mListFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_PERMISSION_BACKGROUND_NETWORK_LIST);
        this.mSearchAnimFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_ANIM_PERMISSION_BACKGROUND_NETWORK_SEARCH);
        this.mFirstLoadStartMs = 0;
        this.mFirstLoadReported = false;
        this.mIsAnimating = false;
        this.mQBListener = new AnonymousClass25(this);
    }

    static /* synthetic */ HashSet access$000() {
        return mNewInstallPackage;
    }

    static /* synthetic */ HashSet access$002(HashSet r0) {
        mNewInstallPackage = r0;
        return r0;
    }

    static /* synthetic */ NetworkOptimizationAdapter access$100(NetworkOptimizationSetting r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$1000(NetworkOptimizationSetting r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ PerformanceMonitors.FpsSceneSession access$1100(NetworkOptimizationSetting r0) {
        return r0.mListFpsSession;
    }

    static /* synthetic */ void access$1200(NetworkOptimizationSetting r0) {
        r0.hideIME();
    }

    static /* synthetic */ AppEntry access$1300(NetworkOptimizationSetting r0) {
        return r0.mLastClickItem;
    }

    static /* synthetic */ AppEntry access$1302(NetworkOptimizationSetting r0, AppEntry r1) {
        r0.mLastClickItem = r1;
        return r1;
    }

    static /* synthetic */ void access$1400(NetworkOptimizationSetting r0, AppEntry r1, int r2) {
        r0.saveNetworkPolicyStatus(r1, r2);
    }

    static /* synthetic */ OInsetSheet access$1500(NetworkOptimizationSetting r0) {
        return r0.mMenuDialog;
    }

    static /* synthetic */ LinearLayout access$1600(NetworkOptimizationSetting r0) {
        return r0.mSearchOrEditBar;
    }

    static /* synthetic */ void access$1700(NetworkOptimizationSetting r0, View r1) {
        r0.playSearchBarRevealAnimation(r1);
    }

    static /* synthetic */ OFloatingTitleBar access$1800(NetworkOptimizationSetting r0) {
        return r0.mTitle;
    }

    static /* synthetic */ void access$1900(NetworkOptimizationSetting r0) {
        r0.hideNetworkTab();
    }

    static /* synthetic */ StickyListHeadersListView access$200(NetworkOptimizationSetting r0) {
        return r0.mListView;
    }

    static /* synthetic */ OFloatingTitleBar access$2000(NetworkOptimizationSetting r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OFloatingTitleBar access$2100(NetworkOptimizationSetting r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OFloatingTitleBar access$2200(NetworkOptimizationSetting r0) {
        return r0.mTitle;
    }

    static /* synthetic */ OSearchBar access$2300(NetworkOptimizationSetting r0) {
        return r0.mSearchBarContainer;
    }

    static /* synthetic */ int access$2400(NetworkOptimizationSetting r0) {
        return r0.mSearchBoxInitialWidth;
    }

    static /* synthetic */ int access$2402(NetworkOptimizationSetting r0, int r1) {
        r0.mSearchBoxInitialWidth = r1;
        return r1;
    }

    static /* synthetic */ float access$2500(NetworkOptimizationSetting r0) {
        return r0.mSearchBoxOriginalWeight;
    }

    static /* synthetic */ float access$2502(NetworkOptimizationSetting r0, float r1) {
        r0.mSearchBoxOriginalWeight = r1;
        return r1;
    }

    static /* synthetic */ SearchModeSwitchAnimHelperType2 access$2600(NetworkOptimizationSetting r0) {
        return r0.mSearchTransitionAnimHelper;
    }

    static /* synthetic */ SearchModeSwitchAnimHelperType2 access$2602(NetworkOptimizationSetting r0, SearchModeSwitchAnimHelperType2 r1) {
        r0.mSearchTransitionAnimHelper = r1;
        return r1;
    }

    static /* synthetic */ View access$2700(NetworkOptimizationSetting r0) {
        return r0.mSearchResultView;
    }

    static /* synthetic */ void access$2800(NetworkOptimizationSetting r0) {
        r0.clickBtnEdit();
    }

    static /* synthetic */ NetworkPolicyManager access$2900(NetworkOptimizationSetting r0) {
        return r0.mNetworkPolicyManager;
    }

    static /* synthetic */ void access$300(NetworkOptimizationSetting r0, int r1) {
        r0.scrollListToPositionAvoidingTitle(r1);
    }

    static /* synthetic */ void access$3000(NetworkOptimizationSetting r0, Set r1) {
        r0.saveChangeAppInSP(r1);
    }

    static /* synthetic */ boolean access$3100(NetworkOptimizationSetting r0) {
        return r0.mIsAnimating;
    }

    static /* synthetic */ boolean access$3102(NetworkOptimizationSetting r0, boolean r1) {
        r0.mIsAnimating = r1;
        return r1;
    }

    static /* synthetic */ View access$3200(NetworkOptimizationSetting r0) {
        return r0.mEditBarView;
    }

    static /* synthetic */ View access$3300(NetworkOptimizationSetting r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ Point access$3400(NetworkOptimizationSetting r0) {
        return r0.mOutSize;
    }

    static /* synthetic */ void access$3500(NetworkOptimizationSetting r0) {
        r0.resetOkButton();
    }

    static /* synthetic */ boolean access$3600(NetworkOptimizationSetting r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ void access$3700(NetworkOptimizationSetting r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ boolean access$3802(NetworkOptimizationSetting r0, boolean r1) {
        r0.mIsHandleClick = r1;
        return r1;
    }

    static /* synthetic */ void access$3900(NetworkOptimizationSetting r0, int r1, boolean r2) {
        r0.setCheckedInternal(r1, r2);
    }

    static /* synthetic */ ArrayList access$400(NetworkOptimizationSetting r0) {
        return r0.mSections;
    }

    static /* synthetic */ View access$4000(NetworkOptimizationSetting r0) {
        return r0.mListViewEmptyView;
    }

    static /* synthetic */ OIndexScrollbar access$4100(NetworkOptimizationSetting r0) {
        return r0.indexScrollbar;
    }

    static /* synthetic */ View access$4200(NetworkOptimizationSetting r0) {
        return r0.mTitleBarRightImg;
    }

    static /* synthetic */ ArrayList access$4300(NetworkOptimizationSetting r0) {
        return r0.mSelectedInfos;
    }

    static /* synthetic */ int access$4400(NetworkOptimizationSetting r0) {
        return r0.mCurrentSortMode;
    }

    static /* synthetic */ String access$4600(NetworkOptimizationSetting r0, AppEntry r1) {
        return r0.getStatusText(r1);
    }

    static /* synthetic */ boolean access$4700(NetworkOptimizationSetting r0, AppEntry r1, String r2) {
        return r0.interceptRiskNetworkPermissionChange(r1, r2);
    }

    static /* synthetic */ void access$4800(NetworkOptimizationSetting r0, View r1, AppEntry r2) {
        r0.showPolicyPopover(r1, r2);
    }

    static /* synthetic */ HashMap access$4900(NetworkOptimizationSetting r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ void access$500(NetworkOptimizationSetting r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ void access$600(NetworkOptimizationSetting r0, boolean r1) {
        r0.updateMainListVisibilityForSearch(r1);
    }

    static /* synthetic */ OIconButtonFloating access$700(NetworkOptimizationSetting r0) {
        return r0.mSearchBarCancel;
    }

    static /* synthetic */ View access$800(NetworkOptimizationSetting r0) {
        return r0.mBottomBar;
    }

    static /* synthetic */ EditText access$900(NetworkOptimizationSetting r0) {
        return r0.mSearchView;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<AppEntry>> loader, List<AppEntry> data) {
        onLoadFinished2(loader, data);
    }

    @Override // com.bytedanceos.security.widget.SlideListView.Listener
    public void setChecked(int position, boolean isChecked) {
        if (position < this.mListView.getHeaderViewsCount()) goto L10;
        setCheckedInternal(position - this.mListView.getHeaderViewsCount(), isChecked);
        int r2 = position - this.mListView.getFirstVisiblePosition();
        View r1 = this.mListView.getWrappedList().getChildAt(r2);
        if (r1 == null) goto L11;
        OCheckBox r3 = (OCheckBox) r1.findViewById(com.obric.security.R.id.checkBox);
        if (r3 == null) goto L12;
        r3.setChecked(isChecked);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void setCheckedInternal(int position, boolean isChecked) {
        if (this.mSearchView.isFocused() == false) goto L5;
        AppEntry r2 = this.mSearchAdapter.getItem(position);
    L6:
        if (isChecked == true) goto L8;
        this.mSelectedInfos.remove(r2);
    L11:
        updateSelectDesc();
        return;
    L8:
        if (this.mSelectedInfos.contains(r2) == true) goto L11;
        this.mSelectedInfos.add(r2);
        goto L11
    L5:
        r2 = this.mAdapter.getItem(position);
        goto L6
    }

    private void updateSelectDesc() {
        if (this.mAdapter == null) goto L21;
        int r0 = this.mSelectedInfos.size();
        if (r0 == 0) goto L7;
        boolean r3 = true;
    L8:
        View r4 = this.mAllow;
        if (r4 == null) goto L11;
        r4.setEnabled(r3);
    L11:
        View r5 = this.mRejectScreenOff;
        if (r5 == null) goto L15;
        r5.setEnabled(r3);
    L15:
        if (r0 != this.mAdapter.getCount()) goto L18;
        if (r0 == 0) goto L18;
        boolean r6 = true;
    L19:
        this.isSelectAll = r6;
        updateSelectAllTitleAction();
        setTitle(getResources().getString(com.obric.security.R.string.select_apps2, new Object[]{Integer.valueOf(r0)}));
        return;
    L18:
        r6 = false;
        goto L19
    L7:
        r3 = false;
        goto L8
    }

    @Override // com.bytedanceos.security.widget.SlideListView.Listener
    public boolean isChecked(int position) {
        if (this.mSearchView.isFocused() == false) goto L5;
        AppEntry r2 = this.mSearchAdapter.getItem(position);
    L7:
        return this.mSelectedInfos.contains(r2);
    L5:
        r2 = this.mAdapter.getItem(position);
        goto L7
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.obric.security.R.layout.network_optimization2);
        this.mFirstLoadStartMs = SystemClock.elapsedRealtime();
        getWindow().setBackgroundDrawable(null);
        this.mItemTranslateX = getResources().getDimension(com.obric.security.R.dimen.list_item_translation_x);
        this.mRightImgEditRes = com.obric.security.R.drawable.oic_line_3_list_checkmark;
        this.mRightImgCancelRes = com.obric.security.R.drawable.oic_list_cancel;
        initView();
        if (getWindowManager() != null) goto L5;
    L7:
        this.mPackageReceiver = new AnonymousClass1(this);
        IntentFilter r3 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r3.addAction("android.intent.action.PACKAGE_ADDED");
        r3.addDataScheme("package");
        registerReceiver(this.mPackageReceiver, r3);
        this.mPowerAdvisor = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));
        getWindow();
        return;
    L5:
        if (getWindowManager().getDefaultDisplay() == null) goto L7;
        getWindowManager().getDefaultDisplay().getSize(this.mOutSize);
        goto L7
    }

    private void initView() {
        this.mNetworkPolicyManager = NetworkPolicyManager.from(this);
        getLoaderManager().initLoader(0, null, this);
        this.mSearchOrEditBar = (LinearLayout) findViewById(com.obric.security.R.id.search_or_edit_bar);
        this.mSearchBarContainer = (OSearchBar) findViewById(com.obric.security.R.id.oc_searchbar_container);
        OIndexScrollbar r0 = (OIndexScrollbar) findViewById(com.obric.security.R.id.index_scrollbar);
        this.indexScrollbar = r0;
        r0.setQBListener(new AnonymousClass2(this));
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
        this.mWholeView = findViewById(com.obric.security.R.id.whole_view);
        this.mListViewEmptyView = findViewById(com.obric.security.R.id.empty_view);
        hideNetworkTab();
        this.mListView = (StickyListHeadersListView) findViewById(com.obric.security.R.id.listView);
        this.mAdapter = new NetworkOptimizationAdapter(this, this);
        StickyListHeadersListView r2 = this.mListView;
        if (r2 == null) goto L5;
        r2.setVisibility(4);
        this.mListView.setAreHeadersSticky(true);
        setListTopPadding(92);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setSlideListener(this);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnScrollListener(new AnonymousClass8(this));
    L5:
        View r3 = LayoutInflater.from(this).inflate(com.obric.security.R.layout.network_optimization_header, null);
        this.mHeaderTip = (TextView) r3.findViewById(com.obric.security.R.id.head_tip);
        TextView r4 = this.mHeaderTip;
        if (r4 == null) goto L8;
        r4.setText(getString(com.obric.security.R.string.background_network_tips, new Object[]{5}));
    L8:
        StickyListHeadersListView r5 = this.mListView;
        if (r5 == null) goto L11;
        r5.addHeaderView(r3);
    L11:
        this.mSearchResultView = findViewById(com.obric.security.R.id.seachresultview);
        this.mSearchResultListView = (OListView) findViewById(com.obric.security.R.id.search_listview);
        this.mSearchEmptyView = findViewById(com.obric.security.R.id.search_empty_view);
        OListView r6 = this.mSearchResultListView;
        if (r6 == null) goto L14;
        r6.setOnItemClickListener(this);
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass9(this));
    L14:
        TextView r7 = (TextView) findViewById(com.obric.security.R.id.searchview_bg);
        this.mSearchBackground = r7;
        if (r7 == null) goto L18;
        r7.setOnClickListener(new AnonymousClass10(this));
    L18:
        if (this.mTitle == null) goto L20;
        this.mTitle.removeAllStartAction();
        this.mTitle.removeAllEndAction();
        this.mTitle.setCenterTitle("");
    L20:
        initViewsCommon();
    }

    private void setListTopPadding(int paddingTopDp) {
        if (this.mListView != null) goto L5;
        return;
    L5:
        int r4 = (int) ((paddingTopDp * getResources().getDisplayMetrics().density) + 0.5f);
        StickyListHeadersListView r0 = this.mListView;
        r0.setPadding(r0.getPaddingLeft(), r4, this.mListView.getPaddingRight(), this.mListView.getPaddingBottom());
    }

    private void hideNetworkTab() {
        View r1 = findViewById(com.obric.security.R.id.cycle_view);
        if (r1 == null) goto L6;
        r1.setVisibility(8);
        return;
    }

    private void addButtonTab(View bar) {
        View r0 = bar.findViewById(com.obric.security.R.id.permission_status_allow);
        this.mAllow = r0;
        r0.setOnClickListener(this);
        View r1 = bar.findViewById(com.obric.security.R.id.permission_status_prompt);
        this.mRejectScreenOff = r1;
        r1.setOnClickListener(this);
        if ((bar instanceof OBottomActionBarFloating) == false) goto L18;
        OBottomActionBarFloating r4 = (OBottomActionBarFloating) bar;
        ArrayList r2 = new ArrayList();
        View r3 = this.mAllow;
        if (r3 != null) goto L7;
    L10:
        View r5 = this.mRejectScreenOff;
        if (r5 != null) goto L13;
    L16:
        r4.setButtons(r2);
        return;
    L13:
        if ((r5.getParent() instanceof ViewGroup) == false) goto L15;
        ((ViewGroup) this.mRejectScreenOff.getParent()).removeView(this.mRejectScreenOff);
    L15:
        r2.add(this.mRejectScreenOff);
        goto L16
    L7:
        if ((r3.getParent() instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) this.mAllow.getParent()).removeView(this.mAllow);
    L9:
        r2.add(this.mAllow);
        goto L10
    }

    private ButtonTabGroup createButtonTabGroup(TitleBar bar) {
        ArrayList r0 = new ArrayList();
        r0.add(getResources().getString(com.obric.security.R.string.background_network_allow));
        r0.add(getResources().getString(com.obric.security.R.string.background_network_reject_screen_off));
        r0.add(getResources().getString(com.obric.security.R.string.background_network_reject));
        return BarsHelper.createTabBuilder(this, bar).setAttachMode(false).setHasGap(true).setBigFilterTwoTabs(false).setStringData(r0).build();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mSearchView.isFocused() == false) goto L6;
        cancelSearch();
        return;
    L6:
        if (this.mIsEdit == false) goto L8;
        clickBtnEdit();
        return;
    L8:
        super.onBackPressed();
    }

    private void cancelSearch() {
        this.mSearchView.setText("");
        this.mSearchView.clearFocus();
        this.mIsHandleClick = false;
        SearchModeSwitchAnimHelperType2 r2 = this.mSearchTransitionAnimHelper;
        if (r2 == null) goto L5;
        r2.playExitAnim(new AnonymousClass11(this));
    L11:
        OSearchBar r3 = this.mSearchBarContainer;
        if (r3 == null) goto L18;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof LinearLayout.LayoutParams) == false) goto L18;
        float r5 = this.mSearchBoxOriginalWeight;
        if (r5 < 0.0f) goto L18;
        ((LinearLayout.LayoutParams) r4).weight = r5;
        this.mSearchBarContainer.setLayoutParams(r4);
    L18:
        hideNetworkTab();
        if (this.mTitle == null) goto L21;
        this.mTitle.removeAllStartAction();
        this.mTitle.removeAllEndAction();
        this.mTitle.setCenterTitle("");
    L21:
        initViewsCommon();
        updateMainListVisibilityForSearch(false);
        return;
    L5:
        LinearLayout r6 = this.mSearchOrEditBar;
        if (r6 == null) goto L8;
        r6.setVisibility(8);
        this.mSearchOrEditBar.setAlpha(1.0f);
        this.mSearchOrEditBar.setScaleX(1.0f);
        this.mSearchOrEditBar.setScaleY(1.0f);
    L8:
        OSearchBar r7 = this.mSearchBarContainer;
        if (r7 == null) goto L11;
        r7.setVisibility(8);
        goto L11
    }

    private void updateMainListVisibilityForSearch(boolean searching) {
        StickyListHeadersListView r0 = this.mListView;
        if (r0 == null) goto L16;
        if (searching == false) goto L6;
        int r2 = 8;
    L7:
        r0.setVisibility(r2);
        if (searching == true) goto L16;
        NetworkOptimizationAdapter r1 = this.mAdapter;
        if (r1 == null) goto L16;
        if (r1.getCount() > 0) goto L16;
        View r3 = this.mListViewEmptyView;
        if (r3 == null) goto L16;
        this.mListView.setEmptyView(r3);
        goto L16
    L6:
        r2 = 0;
    L16:
        if (searching == false) goto L24;
        View r4 = this.mListViewEmptyView;
        if (r4 == null) goto L20;
        r4.setVisibility(8);
    L20:
        OIndexScrollbar r5 = this.indexScrollbar;
        if (r5 == null) goto L25;
        r5.setVisibility(8);
        return;
    L25:
        return;
    }

    private void scrollListToPositionAvoidingTitle(int position) {
        StickyListHeadersListView r0 = this.mListView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setSelectionFromTop(position, getListSelectionTopOffset());
    }

    private boolean interceptRiskNetworkPermissionChange(AppEntry entry, String source) {
        return RiskPermissionControlGuard.interceptNetworkPermissionChange(this, entry, RISK_TAG, source);
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

    private void prepareMenuDialog() {
        Resources r0 = getResources();
        this.mMenuDialog = new OActionSheet(this, new OActionSheet.Companion.Modifier(OInsetSheet.PanelWidth.NARROW_WIDTH, r0.getString(com.obric.security.R.string.net_bg_policy_title), "", new NetworkOptimizationSetting$$ExternalSyntheticLambda0(this)));
        View r1 = LayoutInflater.from(this).inflate(com.obric.security.R.layout.permission_menu_item, null);
        OListItemSettings r2 = (OListItemSettings) r1.findViewById(com.obric.security.R.id.permission_status_allow);
        r2.setVisibility(0);
        r2.mTrailingElement.setVisibility(8);
        r2.setTitleString(r0.getString(com.obric.security.R.string.background_network_allow));
        r2.setOnClickListener(new AnonymousClass12(this));
        OListItemSettings r3 = (OListItemSettings) r1.findViewById(com.obric.security.R.id.permission_allow_in_use);
        r3.mTrailingElement.setVisibility(8);
        r3.setTitleString(r0.getString(com.obric.security.R.string.background_network_reject_screen_off));
        r3.setOnClickListener(new AnonymousClass13(this));
        this.mMenuDialog.setContainerView(r1);
    }

    /* JADX INFO: renamed from: lambda$prepareMenuDialog$0$com-bytedanceos-securitycenter-NetworkOptimizationSetting, reason: not valid java name */
    /* synthetic */ Unit m132x6963325c() {
        this.mMenuDialog.dismiss();
        return Unit.INSTANCE;
    }

    private void showPolicyPopover(View anchorView, final AppEntry entry) {
        if (this.mIsEdit == false) goto L5;
        return;
    L5:
        OPopoverEntranceMenuView.Builder r1 = new OPopoverEntranceMenuView.Builder(this);
        r1.enableOption();
        int r12 = 2;
        int[] r13 = {com.obric.security.R.string.background_network_allow, com.obric.security.R.string.background_network_reject_screen_off};
        final OPopover[] r15 = new OPopover[1];
        final int r11 = 0;
    L6:
        if (r11 >= r12) goto L16;
        if (entry.getMode() != 0) goto L11;
        if (r11 != 0) goto L11;
    L13:
        boolean r10 = true;
    L15:
        r1.addPopoverLeftOptionItem(0, 0, Integer.valueOf(getColor(com.obric.security.R.color.oui_accent_fg)), getString(r13[r11]), null, false, false, r10, new AnonymousClass14(this, r11, entry, r15));
        r11 = r11 + 1;
        r12 = 2;
    L11:
        if (entry.getMode() != 8) goto L14;
        if (r11 == 1) goto L13;
    L14:
        r10 = false;
        goto L15
    L16:
        OPopover r0 = new OPopover.Builder(this).setView(r1.build()).build();
        r15[0] = r0;
        OPopoverHelperEx.INSTANCE.showPopoverSmartly(r0, anchorView, 83);
    }

    private void initViewsCommon() {
        initTitleBar(false, false);
        if (this.mTitle == null) goto L5;
        this.mTitle.removeAllStartAction();
        this.mTitle.addStartAction(com.obric.security.R.drawable.o_floating_title_bar_icon_back, -1, new AnonymousClass15(this));
    L5:
        setTitle(getResources().getString(com.obric.security.R.string.net_bg_policy_title));
        int r1 = getResources().getDimensionPixelSize(com.obric.security.R.dimen.dimen_32);
        LayoutInflater r4 = getLayoutInflater();
        View r5 = this.mTitle.addEndAction(com.obric.security.R.drawable.oic_ellipsis_3, -1, this);
        this.mTitleBarRightImg = r5;
        r5.setVisibility(0);
        OIconButtonFloating r6 = (OIconButtonFloating) r4.inflate(com.obric.security.R.layout.f_oic_icon_network_button, this.mTitle, false);
        this.mTitleBarLeftButton = r6;
        r6.setIcon(com.obric.security.R.drawable.search_clear);
        this.mTitleBarLeftButton.setVisibility(8);
        this.mTitleBarLeftButton.setOnClickListener(this);
        this.mTitleBarRightButton = null;
        this.mRightEditContainer = r4.inflate(com.obric.security.R.layout.select_all_right_view, this.mTitle, false);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, r1);
        this.mRightEditContainer.setLayoutParams(r7);
        this.mTitle.addStartAction(this.mRightEditContainer, -1);
        this.mRightEditContainer.setVisibility(8);
        OCheckBox r2 = (OCheckBox) this.mRightEditContainer.findViewById(com.obric.security.R.id.select_all_cb);
        this.mRightCheckBox = r2;
        r2.setOnClickListener(this);
        if (this.mTitle == null) goto L9;
        this.mTitleBarSearchImg = this.mTitle.addEndAction(com.obric.security.R.drawable.o_icon_search, 0, new AnonymousClass16(this));
        this.mSearchActionIndex = 0;
        this.mTitle.setCenterTitle(com.obric.security.R.string.net_bg_policy_title);
        return;
    }

    private void addSelectAllTitleAction() {
        if (this.mTitle != null) goto L5;
        return;
    L5:
        this.mTitle.setEndButtonGroupStyle(2131821174);
        OFloatingTitleBar r0 = this.mTitle;
        if (this.isSelectAll == false) goto L8;
        int r1 = com.obric.security.R.string.cancel_select_all;
    L9:
        this.mTitleBarRightButton = r0.addEndAction(getString(r1), -1, this);
        return;
    L8:
        r1 = com.obric.security.R.string.select_all;
        goto L9
    }

    private void updateSelectAllTitleAction() {
        if (this.mIsEdit == true) goto L5;
        return;
    L5:
        if (this.mTitle != null) goto L7;
        return;
    L7:
        if (this.mTitleBarRightButton == null) goto L13;
        this.mTitle.removeAllEndAction();
        addSelectAllTitleAction();
        return;
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
        if (this.mCurrentSortMode != (-1)) goto L5;
        boolean r2 = true;
    L6:
        DataUsageMenuItem r0 = new DataUsageMenuItem(r1, r2, 6);
        String r3 = getString(com.obric.security.R.string.background_network_allow);
        if (this.mCurrentSortMode != 0) goto L9;
        boolean r5 = true;
    L10:
        DataUsageMenuItem r6 = new DataUsageMenuItem(r3, r5, 10);
        String r7 = getString(com.obric.security.R.string.background_network_reject_screen_off);
        if (this.mCurrentSortMode != 8) goto L13;
        boolean r8 = true;
    L14:
        DataUsageMenuItem r9 = new DataUsageMenuItem(r7, r8, 11);
        String r10 = getString(com.obric.security.R.string.background_network_reject);
        if (this.mCurrentSortMode == 16) goto L18;
        r4 = false;
    L18:
        DataUsageMenuItem r11 = new DataUsageMenuItem(r10, r4, 12);
        ArrayList r12 = new ArrayList();
        r12.add(r0);
        r12.add(r6);
        r12.add(r9);
        r12.add(r11);
        return r12;
    L13:
        r8 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private void showOverflowPopover(View anchorView) {
        OPopover.Builder r0 = new OPopover.Builder(this);
        OPopoverEntranceMenuView.Builder r11 = new OPopoverEntranceMenuView.Builder(this);
        r11.addPopoverItem(Integer.valueOf(com.obric.security.R.drawable.oic_line_3_list_checkmark), 0, 0, getString(com.obric.security.R.string.multiple_choice), null, null, false, null, new AnonymousClass18(this, r12));
        OPopover r14 = r0.setView(r11.build()).build();
        final OPopover[] r12 = {r14};
        OPopoverHelperEx.INSTANCE.showPopoverSmartly(r14, anchorView, 83);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.mTitleBarRightImg) goto L10;
        if (this.mIsAnimating == false) goto L7;
        return;
    L7:
        showOverflowPopover(view);
        resetHandleClickState();
        return;
    L10:
        if (view != this.mTitleBarRightButton) goto L27;
        if (this.mIsAnimating == false) goto L15;
        return;
    L15:
        if (this.mIsEdit == false) goto L22;
        this.mIsHandleClick = false;
        if (this.isSelectAll == false) goto L19;
        this.mSelectedInfos.clear();
    L20:
        this.mAdapter.notifyDataSetChanged();
        updateSelectDesc();
    L24:
        resetHandleClickState();
        return;
    L19:
        this.mSelectedInfos.clear();
        this.mSelectedInfos.addAll(this.mAdapter.getDatas());
        goto L20
    L22:
        if (this.mSearchView.isFocused() == true) goto L24;
        resetQuickBarState();
        clickBtnEdit();
        goto L24
    L27:
        if (view != this.mAllow) goto L30;
        setNetworkPolicyForList(0);
    L40:
        resetHandleClickState();
        return;
    L30:
        if (view != this.mRejectScreenOff) goto L33;
        setNetworkPolicyForList(8);
        goto L40
    L33:
        if (view != this.mReject) goto L36;
        setNetworkPolicyForList(16);
        goto L40
    L36:
        if (view != this.mTitleBarLeftButton) goto L40;
        this.mIsHandleClick = false;
        if (this.mIsEdit == false) goto L40;
        clickBtnEdit();
        goto L40
    }

    private void setNetworkPolicyForList(final int mode) {
        List<AppEntry> r0 = this.mAdapter.getDatas();
        Iterator<AppEntry> r1 = this.mSelectedInfos.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().setMode(mode);
        goto L4
    L6:
        final ArrayList r2 = new ArrayList(this.mSelectedInfos.size());
        r2.addAll(this.mSelectedInfos);
        AsyncTask.execute(new AnonymousClass19(this, r2, mode));
        if (this.mCurrentSortMode == (-1)) goto L9;
        this.mAdapter.setData(r0, true);
    L9:
        resetQuickBarState();
        clickBtnEdit();
    }

    private void saveChangeAppInSP(Set<String> set) {
        SharedPreferences r2 = getSharedPreferences(NetworkRejectHelper.NETWORK_CONTROL, 0);
        set.addAll(r2.getStringSet(NetworkRejectHelper.NETWORKPOLICY_CHANGE_APP, Collections.emptySet()));
        SharedPreferUtil.commitAsynchronously(r2.edit().putStringSet(NetworkRejectHelper.NETWORKPOLICY_CHANGE_APP, set));
    }

    private void clickBtnEdit() {
        initOptionBar();
        if (this.mIsEdit == false) goto L32;
        if (this.mTitle == null) goto L7;
        this.mTitle.setEndButtonGroupStyle(2131821175);
        this.mTitle.removeAllEndAction();
    L7:
        View r0 = this.mTitleBarSearchImg;
        if (r0 == null) goto L12;
        r0.setVisibility(0);
        if (this.mTitle == null) goto L12;
        this.mTitle.addEndAction(this.mTitleBarSearchImg, 0);
    L12:
        View r1 = this.mTitleBarRightImg;
        if (r1 == null) goto L17;
        r1.setVisibility(0);
        this.mTitleBarRightImg.setEnabled(true);
        if (this.mTitle == null) goto L17;
        this.mTitle.addEndAction(this.mTitleBarRightImg, -1);
    L17:
        View r2 = this.mTitleBarRightButton;
        if (r2 == null) goto L21;
        r2.setVisibility(8);
    L21:
        if (this.mTitleBarLeftButton == null) goto L26;
        if (this.mTitle == null) goto L26;
        this.mTitle.removeAllStartAction();
        this.mTitle.addStartAction(com.obric.security.R.drawable.o_floating_title_bar_icon_back, -1, new AnonymousClass20(this));
    L26:
        if (this.mTitle == null) goto L30;
        View r3 = this.mTitle.findViewById(com.obric.security.R.id.start_button_group);
        if (r3 == null) goto L30;
        r3.setVisibility(0);
    L30:
        setTitle(getResources().getString(com.obric.security.R.string.net_bg_policy_title));
        this.mBottomBar.setVisibility(8);
        this.mListView.setSlideEnable(false);
        this.mSelectedInfos.clear();
        this.isSelectAll = false;
        this.mListView.setmHeader(16);
    L54:
        processEditChanged(!this.mIsEdit, this.mListView.getWrappedList());
        return;
    L32:
        if (this.mTitle == null) goto L34;
        this.mTitle.removeAllEndAction();
        this.mTitle.setEndButtonGroupStyle(2131821174);
    L34:
        addSelectAllTitleAction();
        View r4 = this.mTitleBarRightImg;
        if (r4 == null) goto L38;
        r4.setVisibility(8);
    L38:
        if (this.mTitleBarLeftButton == null) goto L43;
        if (this.mTitle == null) goto L43;
        this.mTitle.removeAllStartAction();
        this.mTitle.addStartAction(com.obric.security.R.drawable.oui_icon_oic_xmark, -1, new AnonymousClass21(this));
    L43:
        if (this.mTitle == null) goto L47;
        View r5 = this.mTitle.findViewById(com.obric.security.R.id.start_button_group);
        if (r5 == null) goto L47;
        r5.setVisibility(0);
    L47:
        this.mBottomBar.setVisibility(0);
        LinearLayout r6 = this.mSearchOrEditBar;
        if (r6 == null) goto L50;
        r6.setVisibility(8);
    L50:
        OSearchBar r7 = this.mSearchBarContainer;
        if (r7 == null) goto L53;
        r7.setVisibility(8);
    L53:
        updateSelectDesc();
        this.mListView.setSlideEnable(true);
        this.mListView.setmHeader(60);
        goto L54
    }

    private void performAnimationForEdit(final boolean isEdit, OListView targetListView) {
        this.mIsEdit = isEdit;
        ArrayList<Animator> r2 = getEditAnimators(isEdit, targetListView);
        AnimatorSet r3 = new AnimatorSet();
        r3.addListener(new AnonymousClass22(this));
        r3.playTogether(r2);
        r3.start();
    }

    private void initOptionBar() {
        ViewStub r0 = (ViewStub) findViewById(com.obric.security.R.id.option_bar_vs);
        this.mOptionBarVS = r0;
        if (r0 == null) goto L8;
        r0.inflate();
        this.mEditBarView = findViewById(com.obric.security.R.id.option_bar);
        this.mSelectFiles = (TextView) findViewById(com.obric.security.R.id.option_title);
        OCheckBox r1 = (OCheckBox) findViewById(com.obric.security.R.id.checkbox_select_all);
        this.mBtnSelectAll = r1;
        if (r1 == null) goto L8;
        r1.setOnClickListener(this);
    L8:
        if (this.mBottomBar != null) goto L10;
        this.mBottomBar = findViewById(com.obric.security.R.id.net_list_control);
    L10:
        View r2 = this.mBottomBar;
        if (r2 != null) goto L13;
        return;
    L13:
        if (this.mAllow != null) goto L17;
        addButtonTab(r2);
        return;
    }

    private ArrayList<Animator> getEditAnimators(boolean isEdit, OListView targetListView) {
        ArrayList<Animator> r2 = new ArrayList();
        int r3 = this.mSearchBarContainer.getWidth();
        int r4 = targetListView.getFirstVisiblePosition();
        int r5 = targetListView.getLastVisiblePosition();
        if (this.mDecelerateInterpolator != null) goto L5;
        this.mDecelerateInterpolator = new LinearInterpolator();
    L5:
        ListAdapter r6 = targetListView.getAdapter();
        int r8 = com.obric.security.R.id.app_info;
        if (isEdit == false) goto L24;
        com.bytedanceos.security.Utils.AnimatorInfo r14 = new com.bytedanceos.security.Utils.AnimatorInfo("translationX", 200, 0, this.mDecelerateInterpolator, new float[]{0.0f, this.mItemTranslateX});
        com.bytedanceos.security.Utils.AnimatorInfo r7 = new com.bytedanceos.security.Utils.AnimatorInfo("scaleX", 200, 200, this.mDecelerateInterpolator, new float[]{0.1f, 1.0f});
        com.bytedanceos.security.Utils.AnimatorInfo r10 = new com.bytedanceos.security.Utils.AnimatorInfo("scaleY", 200, 200, this.mDecelerateInterpolator, new float[]{0.1f, 1.0f});
        com.bytedanceos.security.Utils.AnimatorInfo r11 = new com.bytedanceos.security.Utils.AnimatorInfo("alpha", 200, 200, this.mDecelerateInterpolator, new float[]{0.0f, 1.0f});
        int r12 = r4;
    L8:
        if (r12 > r5) goto L23;
        if (r12 >= r6.getCount()) goto L23;
        View r15 = targetListView.getChildAt(r12 - r4);
        if (r15 == null) goto L22;
        View r13 = r15.findViewById(r8);
        if (r13 == null) goto L22;
        r13.setVisibility(0);
        r2.add(com.bytedanceos.security.Utils.makePropertyAnimator(r14, r13));
        OCheckBox r16 = (OCheckBox) r15.findViewById(com.obric.security.R.id.checkBox);
        if (r16 == null) goto L21;
        r16.setVisibility(0);
        r16.setAlpha(0);
        r16.setChecked(false);
    L21:
        r2.add(com.bytedanceos.security.Utils.makePropertyAnimator(r7, r16));
        r2.add(com.bytedanceos.security.Utils.makePropertyAnimator(r10, r16));
        r2.add(com.bytedanceos.security.Utils.makePropertyAnimator(r11, r16));
    L22:
        r12 = r12 + 1;
        r8 = com.obric.security.R.id.app_info;
    L23:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mSearchBarContainer, "translationX", new float[]{0.0f, r3});
        r1.setDuration(200);
        r2.add(r1);
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.mEditBarView, "translationX", new float[]{-r3, 0.0f});
        r0.setDuration(200);
        r2.add(r0);
    L41:
        return r2;
    L24:
        com.bytedanceos.security.Utils.AnimatorInfo r9 = new com.bytedanceos.security.Utils.AnimatorInfo("scaleX", 200, 0, this.mDecelerateInterpolator, new float[]{1.0f, 0.1f});
        com.bytedanceos.security.Utils.AnimatorInfo r17 = new com.bytedanceos.security.Utils.AnimatorInfo("scaleY", 200, 0, this.mDecelerateInterpolator, new float[]{1.0f, 0.1f});
        com.bytedanceos.security.Utils.AnimatorInfo r18 = new com.bytedanceos.security.Utils.AnimatorInfo("alpha", 200, 0, this.mDecelerateInterpolator, new float[]{1.0f, 0.0f});
        com.bytedanceos.security.Utils.AnimatorInfo r19 = new com.bytedanceos.security.Utils.AnimatorInfo("translationX", 200, 0, this.mDecelerateInterpolator, new float[]{this.mItemTranslateX, 0.0f});
        int r110 = r4;
    L25:
        if (r110 > r5) goto L40;
        if (r110 >= r6.getCount()) goto L40;
        View r111 = targetListView.getChildAt(r110 - r4);
        if (r111 == null) goto L39;
        View r112 = r111.findViewById(com.obric.security.R.id.app_info);
        if (r112 == null) goto L39;
        r112.setVisibility(0);
        View r113 = r111.findViewById(com.obric.security.R.id.checkBox);
        if (r113 == null) goto L38;
        r113.setVisibility(0);
    L38:
        r2.add(com.bytedanceos.security.Utils.makePropertyAnimator(r9, r113));
        r2.add(com.bytedanceos.security.Utils.makePropertyAnimator(r17, r113));
        r2.add(com.bytedanceos.security.Utils.makePropertyAnimator(r18, r113));
        r2.add(com.bytedanceos.security.Utils.makePropertyAnimator(r19, r112));
    L39:
        r110 = r110 + 1;
    L40:
        ObjectAnimator r20 = ObjectAnimator.ofFloat(this.mSearchBarContainer, "translationX", new float[]{r3, 0.0f});
        r20.setDuration(200);
        r2.add(r20);
        ObjectAnimator r21 = ObjectAnimator.ofFloat(this.mEditBarView, "translationX", new float[]{0.0f, -r3});
        r21.setDuration(200);
        r2.add(r21);
        goto L41
    }

    private void processEditChanged(boolean isEdit, OListView targetListView) {
        this.mIsEdit = isEdit;
        this.mAdapter.setEdit(isEdit);
        this.mEditBarView.setVisibility(8);
        this.mAdapter.notifyDataSetChanged();
    }

    private void showMenuDialog() {
        if (this.mMenuDialog != null) goto L5;
        prepareMenuDialog();
    L5:
        this.mMenuDialog.show();
    }

    private void saveNetworkPolicyStatus(final AppEntry entry, final int mode) {
        NetworkRejectHelper.setRealPolicy(this.mNetworkPolicyManager, entry.getApplicationInfo().uid, mode);
        if (mode != 0) goto L5;
        DeviceIdleControllerHelper.addApp(entry.getApplicationInfo().packageName);
    L6:
        AsyncTask.execute(new AnonymousClass23(this, entry));
        entry.setMode(mode);
        NetworkRejectHelper.getWhiteList(this);
        String r5 = entry.getApplicationInfo().packageName;
        if (this.mPowerAdvisor == null) goto L15;
        if (TextUtils.isEmpty(r5) == true) goto L15;
        this.mPowerAdvisor.userSelectedWhitelistApp(r5, mode);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        LogTag.e(TAG, "saveNetworkPolicyStatus e: " + e);
    L15:
        if (this.mSearchView.isFocused() == false) goto L32;
        if (this.mCurrentSortMode == (-1)) goto L25;
        ArrayList r6 = new ArrayList();
        Iterator<AppEntry> r7 = this.mDataList.iterator();
    L20:
        if (r7.hasNext() == false) goto L24;
        AppEntry r1 = r7.next();
        if (r1.getMode() != this.mCurrentSortMode) goto L20;
        r6.add(r1);
        goto L20
    L24:
        this.mAdapter.setData(r6, true);
    L26:
        this.mAdapter.notifyDataSetChanged();
        this.mListViewEmptyView.setVisibility(8);
        NetworkOptimizationAdapter r8 = this.mSearchAdapter;
        if (r8 != null) goto L29;
        return;
    L29:
        if (r8.getCount() <= 0) goto L49;
        this.mSearchAdapter.notifyDataSetChanged();
        return;
    L49:
        return;
    L25:
        this.mAdapter.setData(this.mDataList, true);
        goto L26
    L32:
        if (this.mCurrentSortMode == (-1)) goto L39;
        List<AppEntry> r9 = this.mAdapter.getDatas();
        int r10 = this.mLastClickItem.getMode();
        int r2 = this.mCurrentSortMode;
        if (r10 != r2) goto L36;
    L38:
        this.mAdapter.setData(r9, true);
        goto L39
    L36:
        if (r2 == 6) goto L38;
        r9.remove(this.mLastClickItem);
    L39:
        this.mAdapter.notifyDataSetChanged();
        return;
    L5:
        DeviceIdleControllerHelper.removeApp(entry.getApplicationInfo().packageName);
        goto L6
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<AppEntry>> onCreateLoader(int id, Bundle args) {
        return new AppListLoader(this);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<AppEntry>> loader, List<AppEntry> data) {
        if (this.mFirstLoadReported == false) goto L5;
    L7:
        PerformanceMonitors.reportThreads(PerformanceScenes.THREAD_PERMISSION_BACKGROUND_NETWORK_LOAD);
        this.mDataList = data;
        if (findViewById(com.obric.security.R.id.package_loading_text) == null) goto L10;
        findViewById(com.obric.security.R.id.package_loading_text).setVisibility(8);
    L10:
        ArrayList r6 = new ArrayList();
        if (this.mCurrentSortMode != (-1)) goto L13;
        this.mAdapter.setData(this.mDataList, true);
    L20:
        this.mAdapter.notifyDataSetChanged();
        return;
    L13:
        Iterator<AppEntry> r7 = this.mDataList.iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        AppEntry r1 = r7.next();
        if (r1.getMode() != this.mCurrentSortMode) goto L15;
        r6.add(r1);
        goto L15
    L19:
        this.mAdapter.setData(r6, true);
        goto L20
    L5:
        if (this.mFirstLoadStartMs <= 0) goto L7;
        this.mFirstLoadReported = true;
        PerformanceMonitors.reportActionTime(PerformanceScenes.ACTION_PERMISSION_BACKGROUND_NETWORK_FIRST_LOAD, SystemClock.elapsedRealtime() - this.mFirstLoadStartMs);
        goto L7
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (com.bytedanceos.security.Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        if (this.mIsHandleClick == false) goto L9;
        return;
    L9:
        if (this.mSearchView.isFocused() == false) goto L16;
        NetworkOptimizationAdapter r7 = this.mSearchAdapter;
        if (r7 != null) goto L13;
        return;
    L13:
        if (r7.getCount() > position) goto L24;
        return;
    L24:
        if (position <= this.mAdapter.getCount()) goto L27;
        LogTag.w(TAG, "[onItemClick]: must some wrong position=" + position + " adapter size=" + this.mAdapter.getCount());
    L27:
        if (this.mSearchView.isFocused() == false) goto L29;
        AppEntry r8 = this.mSearchAdapter.getItem(position);
    L30:
        hideIME();
        if (this.mIsEdit == true) goto L33;
    L38:
        this.mIsHandleClick = true;
        this.mLastClickItem = r8;
        NetworkPolicyActivity.Companion.startNetworkPolicyActivity(this, r8.getMode(), r8.getLabel(), r8.getPackageName(), r8.getApplicationInfo().uid);
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.SubpageInOut);
        resetHandleClickState();
        return;
    L33:
        if (this.mSearchView.isFocused() == true) goto L38;
        if (this.mSelectedInfos.contains(r8) == false) goto L37;
        setChecked(position, false);
        return;
    L37:
        setChecked(position, true);
        return;
    L29:
        r8 = this.mAdapter.getItem(position - this.mListView.getHeaderViewsCount());
        goto L30
    L16:
        if (position >= this.mListView.getHeaderViewsCount()) goto L18;
        return;
    L18:
        NetworkOptimizationAdapter r9 = this.mAdapter;
        if (r9 != null) goto L21;
        return;
    L21:
        if (r9.getCount() != 0) goto L24;
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public boolean onModeChange(int sortMode) {
        List<AppEntry> r0 = new ArrayList();
        if (sortMode == 6) goto L9;
        switch(sortMode) {
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L11;
        };
    L6:
        this.mCurrentSortMode = 16;
        goto L11
    L7:
        this.mCurrentSortMode = 8;
        goto L11
    L8:
        this.mCurrentSortMode = 0;
    L11:
        if (this.mCurrentSortMode == (-1)) goto L19;
        Iterator<AppEntry> r6 = this.mDataList.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        AppEntry r1 = r6.next();
        if (r1.getMode() != this.mCurrentSortMode) goto L14;
        r0.add(r1);
    L19:
        if (r0.size() != 0) goto L21;
        this.mAdapter.setData(r0, false);
        this.mAdapter.notifyDataSetChanged();
    L22:
        return true;
    L21:
        this.mAdapter.setData(r0, true);
        goto L22
    L9:
        this.mCurrentSortMode = -1;
        r0 = this.mDataList;
        goto L11
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
        resetOkButton();
        this.mSearchAnimFpsSession.stop();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void onQueryTextChange(String newString) {
        search(newString);
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void hideQuickContactView() {
        this.mIsHandleClick = true;
        resetHandleClickState();
        resetQuickBarState();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void endSearchAnimationWithoutAnimation() {
        com.bytedanceos.security.Utils.setAnimatorScale(this);
        this.mWholeView.setTranslationY(0.0f);
        this.mSearchResultView.setAlpha(0.0f);
        searchAnimationEnd();
        OInsetSheet r2 = this.mMenuDialog;
        if (r2 == null) goto L6;
        r2.cancel();
        return;
    }

    private void resetOkButton() {
        if (this.mAdapter.isEmpty() == true) goto L5;
        this.mTitleBarRightImg.setEnabled(true);
        setQuickBarVisibility();
        return;
    L5:
        this.mTitleBarRightImg.setEnabled(false);
    }

    protected void searchAnimationEnd() {
        this.mWholeView.postDelayed(new AnonymousClass24(this), 30);
    }

    private void hideIME() {
        com.bytedanceos.security.Utils.hideInputMethod(this, getWindow().getDecorView().getWindowToken());
    }

    private void initStartSearchAnimation() {
        if (this.mStartSearchAnim != null) goto L5;
        this.mTitleBarHeight = this.mTitle.getHeight() + 2;
        com.bytedanceos.security.Utils.setAnimatorScale(this);
        PropertyValuesHolder r0 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{r0});
        AnimatorSet r2 = new AnimatorSet();
        this.mStartSearchAnim = r2;
        r2.setDuration(200);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.playTogether(new Animator[]{r1});
        this.mStartSearchAnim.addListener(new AnonymousClass26(this));
    L5:
        this.mStartSearchAnim.start();
        resetHandleClickState();
    }

    private void resetHandleClickState() {
        this.mWholeView.postDelayed(new AnonymousClass27(this), 500);
    }

    private void startEndSearchAnimation() {
        if (this.mEndSearchAnim != null) goto L5;
        PropertyValuesHolder r0 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{r0});
        AnimatorSet r2 = new AnimatorSet();
        this.mEndSearchAnim = r2;
        r2.setDuration(200);
        this.mEndSearchAnim.playTogether(new Animator[]{r1});
        this.mEndSearchAnim.addListener(new AnonymousClass28(this));
    L5:
        this.mEndSearchAnim.start();
    }

    private void search(String keyword) {
        if (keyword != null) goto L4;
        return;
    L4:
        if (keyword.trim().equals(this.lastQueryText) == true) goto L21;
        this.lastQueryText = keyword.trim();
        if (TextUtils.isEmpty(keyword) == true) goto L9;
    L13:
        this.mListView.setEmptyView(null);
        this.mSearchResultListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        ArrayList<AppEntry> r4 = this.mAdapter.query(keyword);
        if (this.mSearchAdapter != null) goto L16;
        NetworkOptimizationAdapter r0 = new NetworkOptimizationAdapter(this, this);
        this.mSearchAdapter = r0;
        this.mSearchResultListView.setAdapter(r0);
    L16:
        this.mSearchAdapter.setData(r4, false);
        return;
    L9:
        if (this.mSearchView.isFocused() == false) goto L13;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
        if (this.mAdapter.getCount() > 0) goto L19;
        this.mListView.setEmptyView(this.mListViewEmptyView);
        return;
    L19:
        return;
    }

    private String getStatusText(AppEntry entry) {
        int r2 = entry.getMode();
        if (r2 != 0) goto L6;
        return getResources().getString(com.obric.security.R.string.background_network_allow);
    L6:
        if (8 != r2) goto L9;
        return getResources().getString(com.obric.security.R.string.background_network_reject_screen_off);
    L9:
        if (16 == r2) goto L15;
        return "";
    L15:
        return getResources().getString(com.obric.security.R.string.background_network_reject);
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
        this.mListFpsSession.stop();
        this.mSearchAnimFpsSession.stop();
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

    private static boolean hasInternetPermission(PackageInfo installedPackage) {
        int r1 = 0;
        if (installedPackage.requestedPermissions != null) goto L5;
        return false;
    L5:
        String[] r5 = installedPackage.requestedPermissions;
        int r0 = r5.length;
        boolean r2 = false;
    L6:
        if (r1 >= r0) goto L11;
        if (r5[r1].equals("android.permission.INTERNET") == false) goto L10;
        r2 = true;
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        return r2;
    }
}
