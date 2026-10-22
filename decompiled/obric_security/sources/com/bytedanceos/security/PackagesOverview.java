package com.bytedanceos.security;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import bytedanceos.util.LogTag;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.permission.NativePackagesListLoader;
import com.bytedanceos.security.widget.BottomExtraView;
import com.bytedanceos.security.widget.QuickBarEx;
import com.bytedanceos.security.widget.SearchBar;
import com.bytedanceos.security.widget.pinyin.PinyinUtils;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersListView;
import com.bytedanceos.utils.NavigationBarHelper;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.button.OButton;
import com.obric.oui.searchbar.OSearchBar;
import com.obric.oui.simplified.ORoundedListItemText;
import com.obric.oui.titlebar.OCTitleBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackagesOverview extends BaseActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<PackagePermissions>>, AdapterView.OnItemClickListener, SearchBar.Listener {
    private static final int ANIM_DURATION = 300;
    private static final int ANIM_START_DELAY = 10;
    private static int MAX_NUMBER = 30;
    public static final Comparator<PackagePermissions> PACKAGE_COMPARATOR = null;
    private static final String TAG = "PackagesOverview";
    private int animInLeft;
    private int animInRight;
    private int animOutLeft;
    private int animOutRight;
    private String lastQueryText;
    MyAdapter mAdapter;
    private DecelerateInterpolator mDecelerateInterpolator;
    private long mDuration;
    private AnimatorSet mEndSearchAnim;
    private float mItemTranslateX;
    private SearchAction mLastSearch;
    private StickyListHeadersListView mListView;
    private View mListViewEmptyView;
    private Point mOutSize;
    private PackageManager mPM;
    BroadcastReceiver mPackageReceiver;
    private PackagesListLoader mPackagesListLoader;
    private HashMap<Character, Integer> mPositionOfSections;
    private QuickBarEx.QBListener mQBListener;
    private QuickBarEx mQuickBar;
    private int mResId;
    private MyAdapter mSearchAdapter;
    private TextView mSearchBackground;
    private OSearchBar mSearchBar;
    private OButton mSearchBarCancel;
    private OCTitleBar mSearchBarContainer;
    private View mSearchEmptyView;
    private List<PackagePermissions> mSearchResultList;
    private OListView mSearchResultListView;
    private View mSearchResultView;
    private EditText mSearchView;
    private ArrayList<String> mSections;
    private AnimatorSet mStartSearchAnim;
    private int mTitleBarHeight;
    private View mWholeView;

    class MyAdapter extends ArrayAdapter<PackagePermissions> implements AbsListView.RecyclerListener, StickyListHeadersAdapter {
        private List<PackagePermissions> mDatas;
        LayoutInflater mInflater;
        final /* synthetic */ PackagesOverview this$0;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View arg0) {
        }

        public MyAdapter(final PackagesOverview this$0, Context context) {
            this.this$0 = this$0;
            super(context, R.layout.simple_list_item_2);
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void setData(List<PackagePermissions> data, boolean initSections) {
            PackagesOverview.access$900(this.this$0).setEmptyView(PackagesOverview.access$1300(this.this$0));
            clear();
            int r0 = 0;
            if (data == null) goto L15;
            if (data.size() <= 0) goto L15;
            Collections.sort(data, PackagesOverview.PACKAGE_COMPARATOR);
            addAll(data);
            this.mDatas = data;
            OCTitleBar r4 = PackagesOverview.access$1400(this.this$0);
            if (getCount() > 0) goto L10;
            r0 = 8;
        L10:
            r4.setVisibility(r0);
            if (initSections == false) goto L13;
            initSections();
        L13:
            PackagesOverview.access$1300(this.this$0).setVisibility(8);
        L18:
            PackagesOverview.access$1200(this.this$0);
            return;
        L15:
            if (PackagesOverview.access$1500(this.this$0).hasFocus() == false) goto L17;
            PackagesOverview.access$1300(this.this$0).setVisibility(8);
            goto L18
        L17:
            PackagesOverview.access$1300(this.this$0).setVisibility(0);
            goto L18
        }

        public List<PackagePermissions> getDatas() {
            return this.mDatas;
        }

        private void initSections() {
            PackagesOverview.access$1000(this.this$0).clear();
            PackagesOverview.access$1600(this.this$0).clear();
            List<PackagePermissions> r0 = this.mDatas;
            if (r0.size() <= 0) goto L11;
            String r2 = String.valueOf(r0.get(0).mLabelEntry.firstChar);
            PackagesOverview.access$1000(this.this$0).add(r2);
            PackagesOverview.access$1600(this.this$0).put(Character.valueOf(r0.get(0).mLabelEntry.firstChar), 0);
            int r1 = 1;
        L6:
            if (r1 >= r0.size()) goto L15;
            String r3 = String.valueOf(r0.get(r1).mLabelEntry.firstChar);
            if (r2.equals(r3) == true) goto L10;
            PackagesOverview.access$1000(this.this$0).add(r3);
            PackagesOverview.access$1600(this.this$0).put(Character.valueOf(r0.get(r1).mLabelEntry.firstChar), Integer.valueOf(r1));
            r2 = r3;
        L10:
            r1 = r1 + 1;
            goto L6
        L15:
            return;
        }

        public int getPositionForSection(int section) {
            Integer r0 = (Integer) PackagesOverview.access$1600(this.this$0).get(Character.valueOf((char) section));
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.intValue();
        }

        public ArrayList<PackagePermissions> query(String input) {
            ArrayList<PackagePermissions> r0 = new ArrayList();
            if (TextUtils.isEmpty(input) == false) goto L5;
        L23:
            return r0;
        L5:
            if (PackagesOverview.access$1700(this.this$0) != null) goto L7;
        L9:
            List<PackagePermissions> r1 = this.mDatas;
            PackagesOverview.access$1702(this.this$0, null);
            List<PackagePermissions> r5 = r1;
        L10:
            String r6 = input.toUpperCase();
            if (r5 == null) goto L23;
            Iterator<PackagePermissions> r7 = r5.iterator();
        L14:
            if (r7.hasNext() == false) goto L23;
            PackagePermissions r2 = r7.next();
            boolean r3 = r2.getLabel().toUpperCase().contains(r6);
            boolean r4 = r2.mLabelEntry.firstLetters.toUpperCase().contains(r6);
            if (PinyinUtils.isChinese(r6) == true) goto L18;
            boolean r8 = r2.mLabelEntry.labelPinyin.toUpperCase().contains(r6);
        L19:
            if (r3 == true) goto L22;
            if (r8 == true) goto L22;
            if (r4 == false) goto L14;
        L22:
            r0.add(r2);
            goto L14
        L18:
            r8 = false;
            goto L19
        L7:
            if (input.startsWith(SearchAction.access$1800(PackagesOverview.access$1700(this.this$0))) == false) goto L9;
            r5 = SearchAction.access$1900(PackagesOverview.access$1700(this.this$0));
            goto L10
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
            convertView = this.mInflater.inflate(com.obric.security.R.layout.package_overview_item, null);
            ViewHolder r8 = new ViewHolder(this.this$0);
            r8.item = (ORoundedListItemText) convertView.findViewById(com.obric.security.R.id.app_info);
            r8.emptyView = convertView.findViewById(com.obric.security.R.id.empty_view);
            convertView.setTag(r8);
        L6:
            if (r8.emptyView == null) goto L9;
            r8.emptyView.setVisibility(8);
        L9:
            if (r8.item != null) goto L11;
            return convertView;
        L11:
            PackagePermissions r6 = getItem(position);
            String r0 = r6.getPackageName();
            ApplicationInfo r1 = PackagesOverview.access$2000(this.this$0).getApplicationInfo(r0, 0);     // Catch: PackageManager.NameNotFoundException -> L21
            if (r1 == null) goto L15;
            r8.item.setTitleString(r1.loadLabel(PackagesOverview.access$2000(this.this$0)).toString());     // Catch: PackageManager.NameNotFoundException -> L21
        L15:
            r8.item.setContentImage(r6.getIcon());     // Catch: PackageManager.NameNotFoundException -> L21
            if (UserHandle.getUserId(r6.getUid()) != 10) goto L18;
            boolean r2 = true;
        L19:
            r8.item.setDoppleganger(r2);     // Catch: PackageManager.NameNotFoundException -> L21
            r8.item.setTrailingText(this.this$0.getString(com.obric.security.R.string.package_overview_count, new Object[]{Integer.valueOf(r6.getPermissionCount())}));     // Catch: PackageManager.NameNotFoundException -> L21
        L22:
            return convertView;
        L18:
            r2 = false;
        L21:
            LogTag.e(PackagesOverview.TAG, "get application info failed " + r0);
            goto L22
        L4:
            r8 = (ViewHolder) convertView.getTag();
            goto L6
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
        L7:
            RadioPermissions.HeaderViewHolder r5 = new RadioPermissions.HeaderViewHolder();
            convertView = this.mInflater.inflate(com.obric.security.R.layout.sticky_list_header_view, null);
            r5.headerText = (TextView) convertView.findViewById(com.obric.security.R.id.sticky_header);
            convertView.setTag(r5);
        L8:
            List<PackagePermissions> r2 = this.mDatas;
            if (r2.get(position).mLabelEntry == null) goto L11;
            String r3 = Character.toString(r2.get(position).mLabelEntry.firstChar);
        L13:
            if (r5.headerText == null) goto L15;
            r5.headerText.setText(r3);
        L15:
            return convertView;
        L11:
            r3 = "#";
            goto L13
        L4:
            if ((convertView.getTag() instanceof RadioPermissions.HeaderViewHolder) == false) goto L7;
            r5 = (RadioPermissions.HeaderViewHolder) convertView.getTag();
            goto L8
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int position) {
            List<PackagePermissions> r1 = this.mDatas;
            if (r1.get(position).mLabelEntry != null) goto L7;
            return 35;
        L7:
            return r1.get(position).mLabelEntry.firstChar;
        }
    }

    private class SearchAction {
        private String keyword;
        private List<PackagePermissions> searchResult;
        final /* synthetic */ PackagesOverview this$0;

        static /* synthetic */ String access$1800(SearchAction r0) {
            return r0.keyword;
        }

        static /* synthetic */ List access$1900(SearchAction r0) {
            return r0.searchResult;
        }

        public SearchAction(final PackagesOverview this$0, String keyword, List<PackagePermissions> list) {
            this.this$0 = this$0;
            this.keyword = keyword;
            this.searchResult = list;
        }
    }

    class ViewHolder {
        View emptyView;
        ORoundedListItemText item;
        final /* synthetic */ PackagesOverview this$0;

        ViewHolder(final PackagesOverview this$0) {
            this.this$0 = this$0;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<PackagePermissions>> loader) {
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public boolean onModeChange(int sortMode) {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
    }

    public PackagesOverview() {
        this.mAdapter = null;
        this.mSections = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.lastQueryText = "";
        this.mDuration = 200;
        this.mOutSize = new Point();
        this.mPM = null;
        this.mQBListener = new AnonymousClass11(this);
    }

    static /* synthetic */ void access$000(PackagesOverview r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ OButton access$100(PackagesOverview r0) {
        return r0.mSearchBarCancel;
    }

    static /* synthetic */ ArrayList access$1000(PackagesOverview r0) {
        return r0.mSections;
    }

    static /* synthetic */ boolean access$1100(PackagesOverview r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ void access$1200(PackagesOverview r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ View access$1300(PackagesOverview r0) {
        return r0.mListViewEmptyView;
    }

    static /* synthetic */ OCTitleBar access$1400(PackagesOverview r0) {
        return r0.mSearchBarContainer;
    }

    static /* synthetic */ EditText access$1500(PackagesOverview r0) {
        return r0.mSearchView;
    }

    static /* synthetic */ HashMap access$1600(PackagesOverview r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ SearchAction access$1700(PackagesOverview r0) {
        return r0.mLastSearch;
    }

    static /* synthetic */ SearchAction access$1702(PackagesOverview r0, SearchAction r1) {
        r0.mLastSearch = r1;
        return r1;
    }

    static /* synthetic */ QuickBarEx access$200(PackagesOverview r0) {
        return r0.mQuickBar;
    }

    static /* synthetic */ PackageManager access$2000(PackagesOverview r0) {
        return r0.mPM;
    }

    static /* synthetic */ void access$300(PackagesOverview r0) {
        r0.hideIME();
    }

    static /* synthetic */ View access$400(PackagesOverview r0) {
        return r0.mSearchResultView;
    }

    static /* synthetic */ View access$500(PackagesOverview r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ Point access$600(PackagesOverview r0) {
        return r0.mOutSize;
    }

    static /* synthetic */ int access$700(PackagesOverview r0) {
        return r0.mTitleBarHeight;
    }

    static /* synthetic */ void access$800(PackagesOverview r0) {
        r0.resetOkButton();
    }

    static /* synthetic */ StickyListHeadersListView access$900(PackagesOverview r0) {
        return r0.mListView;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<PackagePermissions>> loader, List<PackagePermissions> data) {
        onLoadFinished2(loader, data);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.obric.security.R.layout.packages_overview);
        getWindow().setBackgroundDrawableResource(com.obric.security.R.color.oui_bg_base_1);
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(com.obric.security.R.color.oui_bg_base_1));
        this.mPM = getPackageManager();
        this.mItemTranslateX = getResources().getDimension(com.obric.security.R.dimen.list_item_translation_x);
        initTitleBar(false);
        initView();
        if (getWindowManager() != null) goto L5;
    L7:
        this.mPackageReceiver = new AnonymousClass1(this);
        this.animInLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", com.obric.security.R.anim.slide_in_from_left);
        this.animOutRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", com.obric.security.R.anim.slide_out_to_right);
        this.animInRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_right", "anim", com.obric.security.R.anim.slide_in_from_right);
        this.animOutLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_left", "anim", com.obric.security.R.anim.slide_out_to_left);
        IntentFilter r4 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r4.addAction("android.intent.action.PACKAGE_ADDED");
        r4.addDataScheme("package");
        registerReceiver(this.mPackageReceiver, r4);
        this.mResId = Utils.getResouceId("android", "simple_list_item_2", "layout", R.layout.simple_list_item_2);
        return;
    L5:
        if (getWindowManager().getDefaultDisplay() == null) goto L7;
        getWindowManager().getDefaultDisplay().getSize(this.mOutSize);
        goto L7
    }

    private void initView() {
        getLoaderManager().initLoader(0, null, this);
        OCTitleBar r0 = (OCTitleBar) findViewById(com.obric.security.R.id.oc_searchbar_container);
        this.mSearchBarContainer = r0;
        r0.removeAllLeftViews();
        this.mSearchBarContainer.removeAllRightViews();
        OCTitleBar r1 = this.mSearchBarContainer;
        OButton r2 = r1.createNeutralButton(this, r1.getMRightContainer());
        this.mSearchBarCancel = r2;
        r2.setVisibility(8);
        this.mSearchBarCancel.setText(com.obric.security.R.string.btn_cancel);
        this.mSearchBarCancel.setOnClickListener(new AnonymousClass2(this));
        OSearchBar r3 = new OSearchBar(this);
        this.mSearchBar = r3;
        r3.getInputView().setHint(getString(com.obric.security.R.string.search));
        this.mSearchView = this.mSearchBar.getInputView().getVInput();
        int r4 = getResources().getDimensionPixelOffset(com.obric.security.R.dimen.dimen_8);
        this.mSearchBarContainer.getMCenterContainer().setPadding(r4, 0, r4, 0);
        this.mSearchBarContainer.getMCenterContainer().addView(this.mSearchBar);
        OSearchBar r5 = this.mSearchBar;
        if (r5 == null) goto L5;
        this.mSearchView = r5.getInputView().getVInput();
        this.mSearchBar.getInputView().setOnTextClearedListener(new AnonymousClass3(this));
        this.mSearchView.setShowSoftInputOnFocus(true);
        this.mSearchView.setOnFocusChangeListener(new AnonymousClass4(this));
        this.mSearchView.addTextChangedListener(new AnonymousClass5(this));
        this.mSearchView.setOnEditorActionListener(new AnonymousClass6(this));
    L5:
        this.mWholeView = findViewById(com.obric.security.R.id.whole_view);
        QuickBarEx r6 = (QuickBarEx) findViewById(com.obric.security.R.id.quickbar);
        this.mQuickBar = r6;
        if (r6 == null) goto L8;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r6);
        this.mQuickBar.setLongPressEnabled(false);
        this.mQuickBar.setQBListener(this.mQBListener);
        this.mQuickBar.setPoundVisibility(true);
        this.mQuickBar.setPoundPosition(1);
        this.mQuickBar.initLetters();
    L8:
        this.mListViewEmptyView = findViewById(com.obric.security.R.id.empty_view);
        this.mAdapter = new MyAdapter(this, this);
        StickyListHeadersListView r7 = (StickyListHeadersListView) findViewById(com.obric.security.R.id.listView);
        this.mListView = r7;
        if (r7 == null) goto L11;
        r7.setAreHeadersSticky(true);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this);
        BottomExtraView.setBottomPaddingWhenNavigationBarStatusChangeByProxy(this.mListView);
        this.mListView.setOnTouchListener(new AnonymousClass7(this));
    L11:
        this.mSearchResultView = findViewById(com.obric.security.R.id.seachresultview);
        this.mSearchResultListView = (OListView) findViewById(com.obric.security.R.id.search_listview);
        this.mSearchEmptyView = findViewById(com.obric.security.R.id.search_empty_view);
        OListView r8 = this.mSearchResultListView;
        if (r8 == null) goto L14;
        r8.setOnItemClickListener(this);
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass8(this));
    L14:
        TextView r9 = (TextView) findViewById(com.obric.security.R.id.searchview_bg);
        this.mSearchBackground = r9;
        if (r9 == null) goto L18;
        r9.setOnClickListener(new AnonymousClass9(this));
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mSearchBar == null) goto L8;
        if (this.mSearchView.hasFocus() == false) goto L8;
        cancelSearch();
        return;
    L8:
        if (resetQuickBarState() == false) goto L10;
        return;
    L10:
        super.onBackPressed();
    }

    private void cancelSearch() {
        this.mSearchView.setText("");
        this.mSearchView.clearFocus();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<PackagePermissions>> onCreateLoader(int id, Bundle args) {
        if (MultiSdkAdapter.sdkIsBeforeO() == false) goto L5;
        PackagesListLoader r1 = new PackagesListLoader(this);
    L6:
        this.mPackagesListLoader = r1;
        return r1;
    L5:
        r1 = new NativePackagesListLoader(this);
        goto L6
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.mPackagesListLoader.forceLoad();
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<PackagePermissions>> loader, List<PackagePermissions> data) {
        List<PackagePermissions> r4 = this.mAdapter.getDatas();
        int r0 = 0;
        if (data == null) goto L12;
        if (r4 == null) goto L12;
        if (r4.size() <= 0) goto L12;
        OListView r5 = this.mListView.getWrappedList();
        int r1 = r5.getFirstVisiblePosition();
        View r6 = r5.getChildAt(0);
        if (r6 == null) goto L11;
        r0 = r6.getTop();
    L11:
        int r7 = r0;
        r0 = r1;
    L13:
        this.mAdapter.setData(data, true);
        View r8 = findViewById(com.obric.security.R.id.package_loading_text);
        if (r8 == null) goto L16;
        r8.setVisibility(8);
    L16:
        if (r0 != 0) goto L18;
        if (r7 != 0) goto L18;
        return;
    L18:
        this.mListView.setRealSelectionFromTop(r0, r7);
        return;
    L12:
        r7 = 0;
        goto L13
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (this.mSearchView.hasFocus() == false) goto L9;
        MyAdapter r3 = this.mSearchAdapter;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.getCount() > position) goto L15;
        return;
    L15:
        if (position <= this.mAdapter.getCount()) goto L18;
        LogTag.w(TAG, "[onItemClick]: must some wrong position=" + position + " adapter size=" + this.mAdapter.getCount());
    L18:
        if (this.mSearchView.hasFocus() == false) goto L20;
        PackagePermissions r4 = this.mSearchAdapter.getItem(position);
    L21:
        hideIME();
        Intent r5 = new Intent(Utils.INTENT_ACTION_PACKAGE_DETAIL);
        PackageInfo r6 = this.mPM.getPackageInfoAsUser(r4.getPackageName(), 0, UserHandle.getUserId(r4.getUid()));     // Catch: Exception -> L29
        if (MultiSdkAdapter.sdkIsBeforeO() == false) goto L26;
        r5.putExtra("detail", r6);     // Catch: Exception -> L29
    L27:
        r5.putExtra(Utils.INTENT_KEY_FROM_CENTER, isFromSecurityCenter());     // Catch: Exception -> L29
        startActivity(r5);     // Catch: Exception -> L29
        return;
    L26:
        r5.setAction(Utils.INTENT_ACTION_NATIVE_PACKAGE_DETAIL);     // Catch: Exception -> L29
        r5.putExtra("detail", r6);     // Catch: Exception -> L29
        r5.putExtra(Utils.INTENT_KEY_SHOW_ICON, false);     // Catch: Exception -> L29
    L29:
        OLog.d(TAG, "can't find package " + r4.getPackageName());
        return;
    L20:
        r4 = this.mAdapter.getItem(position - this.mListView.getHeaderViewsCount());
        goto L21
    L9:
        MyAdapter r7 = this.mAdapter;
        if (r7 != null) goto L12;
        return;
    L12:
        if (r7.getCount() != 0) goto L15;
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void setSoftKeyboardHide() {
        hideIME();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void startSearchAnimation() {
        initStartSearchAnimation();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void endSearchAnimation() {
        startEndSearchAnimation();
        resetOkButton();
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

    private void resetOkButton() {
        if (this.mAdapter.isEmpty() == true) goto L6;
        setQuickBarVisibility();
        return;
    }

    protected void searchAnimationEnd() {
        this.mWholeView.postDelayed(new AnonymousClass10(this), 30);
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void recoverQuickBar() {
        this.mQuickBar.hideLetterGrid();
    }

    private void hideIME() {
        Utils.hideInputMethod(this, getWindow().getDecorView().getWindowToken());
    }

    private void initStartSearchAnimation() {
        if (this.mStartSearchAnim != null) goto L5;
        this.mTitleBarHeight = this.mTitle.getHeight() + 2;
        Utils.setAnimatorScale(this);
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, -this.mTitleBarHeight})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mStartSearchAnim = r3;
        r3.setDuration(300);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.setInterpolator(this.mDecelerateInterpolator);
        this.mStartSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mStartSearchAnim.addListener(new AnonymousClass12(this));
    L5:
        this.mStartSearchAnim.start();
    }

    private void startEndSearchAnimation() {
        isFromSecurityCenter();
        if (this.mEndSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{-this.mTitleBarHeight, 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mEndSearchAnim = r3;
        r3.setDuration(300);
        this.mEndSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mEndSearchAnim.addListener(new AnonymousClass13(this));
    L5:
        this.mEndSearchAnim.start();
    }

    private void setQuickBarVisibility() {
        if (this.mQuickBar == null) goto L18;
        MyAdapter r0 = this.mAdapter;
        int r1 = 0;
        if (r0 != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        QuickBarEx r3 = this.mQuickBar;
        if (r2 == true) goto L16;
        r1 = 8;
    L16:
        r3.setVisibility(r1);
        return;
    L7:
        if (r0.getCount() < MAX_NUMBER) goto L11;
        if (this.mSearchView.hasFocus() == true) goto L11;
        r2 = true;
        goto L12
    }

    private boolean resetQuickBarState() {
        if (this.mQuickBar.isLetterGridShow() == false) goto L6;
        this.mQuickBar.hideLetterGrid(true);
        return true;
    L6:
        return false;
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
        this.mSearchResultList = this.mAdapter.query(keyword);
        if (TextUtils.isEmpty(keyword) == true) goto L17;
        this.mLastSearch = new SearchAction(this, keyword, this.mSearchResultList);
    L17:
        if (this.mSearchAdapter != null) goto L19;
        MyAdapter r4 = new MyAdapter(this, this);
        this.mSearchAdapter = r4;
        this.mSearchResultListView.setAdapter(r4);
    L19:
        this.mSearchAdapter.setData(this.mSearchResultList, false);
        return;
    L9:
        if (this.mSearchView.hasFocus() == false) goto L13;
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

    static {
        PACKAGE_COMPARATOR = new AnonymousClass14();
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
        if (r0 == null) goto L6;
        unregisterReceiver(r0);
        this.mPackageReceiver = null;
        return;
    }
}
