package com.android.settings;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.base.BaseActivity;
import com.android.settings.pinyin.PinyinUtils;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.widget.HorizontalScrollListView;
import com.android.settings.widget.SlideListView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedanceos.tencent.SMTCodeName;
import com.obric.olog.OLog;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.QuickBar;

/* JADX INFO: loaded from: classes2.dex */
public class ProvinceActivity extends BaseActivity implements AdapterView.OnItemClickListener, SearchBarEx.Listener, HorizontalScrollListView.ScrollStateListener, AdapterView.OnItemLongClickListener, View.OnClickListener, SlideListView.OnQuickBarChangedListener {
    private static final int ANIM_DURATION = 200;
    private static final int ANIM_START_DELAY = 10;
    public static final String TAG = "ManageApplications";
    private Comparator<ItemEntry> ALPHA_COMPARATOR;
    private String mCurrentCode;
    private String mCurrentName;
    private RelativeLayout mEditBarView;
    private TextView mEmptyView;
    private AnimatorSet mEndSearchAnim;
    private boolean mIsEditAnimationRunning;
    private boolean mIsEditMode;
    private boolean mIsItemScrollRestored;
    private boolean mIsProvince;
    private ArrayList<ItemEntry> mItemList;
    private SearchAction mLastSearch;
    private ItemListAdapter mListAdapter;
    private SlideListView mListView;
    private TextView mOptionTextView;
    private CharSequence mOriginBackButtonText;
    private String mOrignalCode;
    private HashMap<Character, Integer> mPositionOfSections;
    private QuickBar.QBListener mQBListener;
    private QuickBar mQuickBar;
    private ImageView mRightBtn;
    private SearchAdapter mSearchAdapter;
    private TextView mSearchBackground;
    private SearchBarEx mSearchBar;
    private View mSearchEmptyView;
    private ArrayList<ItemEntry> mSearchResultList;
    private HorizontalScrollListView mSearchResultListView;
    private View mSearchResultView;
    private ArrayList<String> mSections;
    private AnimatorSet mStartSearchAnim;
    private OFloatingTitleBar mTitle;
    private int mTitleStringResId;
    private OToast mToast;
    private View mWholeView;

    public class ItemEntry {
        public Context context;
        private String mCode;
        private String mLabel;
        public LabelEntry mLabelEntry;
        final /* synthetic */ ProvinceActivity this$0;

        public class LabelEntry {
            public char firstChar;
            public String firstLetters;
            public String label;
            public String labelPinyin;
            final /* synthetic */ ItemEntry this$1;

            public LabelEntry(ItemEntry r1, String r2) {
                this.this$1 = r1;
                init(r2);
            }

            private void init(String r6) {
                this.label = r6;
                ArrayList<HanziToPinyin.Token> r7 = HanziToPinyin.getInstance().get(r6);
                StringBuilder r0 = new StringBuilder();
                StringBuilder r1 = new StringBuilder();
                Iterator<HanziToPinyin.Token> r8 = r7.iterator();
            L4:
                if (r8.hasNext() == false) goto L8;
                HanziToPinyin.Token r2 = r8.next();
                char r3 = r2.target.charAt(0);
                if (Character.isSpaceChar(r3) == true) goto L4;
                r0.append(r3);
                r1.append(r2.target);
                goto L4
            L8:
                this.labelPinyin = r1.toString();
                this.firstLetters = r0.toString();
                this.firstChar = PinyinUtils.getFirstChar(this.labelPinyin);
            }
        }

        static /* synthetic */ String access$800(ItemEntry r0) {
            return r0.mCode;
        }

        static /* synthetic */ String access$900(ItemEntry r0) {
            return r0.mLabel;
        }

        public ItemEntry(ProvinceActivity r1, SMTCodeName r2) {
            this.this$0 = r1;
            this.mLabel = null;
            this.mCode = null;
            if (r2 == null) goto L6;
            this.mCode = r2.mCode;
            this.mLabel = r2.mName;
            ensureLabelEntry();
            return;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public String getCode() {
            return this.mCode;
        }

        public void ensureLabelEntry() {
            if (this.mLabel == null) goto L6;
            this.mLabelEntry = new LabelEntry(this, this.mLabel);
            return;
        }
    }

    private class ItemListAdapter extends BaseAdapter implements StickyListHeadersAdapter {
        private ArrayList<ItemEntry> mEntries;
        protected LayoutInflater mLayoutInflater;
        final /* synthetic */ ProvinceActivity this$0;

        class HeaderViewHolder {
            OSectionTitleBar headerText;
            final /* synthetic */ ItemListAdapter this$1;

            HeaderViewHolder(ItemListAdapter r1) {
                this.this$1 = r1;
            }
        }

        class ViewHolder implements View.OnClickListener {
            ItemEntry entry;
            ImageView selectView;
            final /* synthetic */ ItemListAdapter this$1;
            TextView titleView;

            @Override // android.view.View.OnClickListener
            public void onClick(View r1) {
            }

            void updateSizeText() {
            }

            ViewHolder(ItemListAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public ItemListAdapter(ProvinceActivity r1, Context r2) {
            this.this$0 = r1;
            this.mLayoutInflater = LayoutInflater.from(r2);
        }

        protected void updateAppEntries(ArrayList<ItemEntry> r1) {
            this.mEntries = r1;
            initSections();
        }

        protected ArrayList<ItemEntry> getEntries() {
            return this.mEntries;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<ItemEntry> r0 = this.mEntries;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public ItemEntry getItem(int r1) {
            return this.mEntries.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
        L7:
            r4 = this.mLayoutInflater.inflate(R.layout.province_item_layout, null);
            ViewHolder r6 = new ViewHolder(this);
            r6.titleView = (TextView) r4.findViewById(R.id.item_title);
            r6.selectView = (ImageView) r4.findViewById(R.id.item_check);
            r4.setTag(r6);
        L8:
            ItemEntry r7 = this.mEntries.get(r3);
            monitor-enter(r7);
            r6.entry = r7;     // Catch: Throwable -> L19
            r6.updateSizeText();     // Catch: Throwable -> L19
            r6.titleView.setText(r7.getLabel());     // Catch: Throwable -> L19
            if (TextUtils.isEmpty(ProvinceActivity.access$1400(this.this$0)) == false) goto L13;
        L15:
            r6.selectView.setVisibility(8);     // Catch: Throwable -> L19
        L16:
            monitor-exit(r7);     // Catch: Throwable -> L19
            r4.findViewById(R.id.app_layout).setBackgroundResource(R.drawable.horizontal_scroll_app_list_item_bg_selector);
            return r4;
        L13:
            if (ProvinceActivity.access$1400(this.this$0).equals(r7.getCode()) == false) goto L15;
            r6.selectView.setVisibility(0);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L4:
            if (r4.getTag() == null) goto L7;
            r6 = (ViewHolder) r4.getTag();
            goto L8
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
        L7:
            HeaderViewHolder r6 = new HeaderViewHolder(this);
            r4 = this.mLayoutInflater.inflate(R.layout.sticky_list_header_view, null);
            r6.headerText = (OSectionTitleBar) r4.findViewById(R.id.sticky_header);
            r4.setTag(r6);
        L8:
            ArrayList<ItemEntry> r2 = getEntries();
            if (r2.get(r3).mLabelEntry == null) goto L11;
            String r7 = Character.toString(r2.get(r3).mLabelEntry.firstChar);
        L12:
            r6.headerText.setTitleText(r7);
            r6.headerText.setVisibility(0);
            if (r4.getVisibility() != 4) goto L15;
            r4.setVisibility(0);
        L15:
            return r4;
        L11:
            r7 = "#";
            goto L12
        L4:
            if ((r4.getTag() instanceof HeaderViewHolder) == false) goto L7;
            r6 = (HeaderViewHolder) r4.getTag();
            goto L8
        }

        public ArrayList<ItemEntry> query(String r6) {
            ArrayList<ItemEntry> r0 = new ArrayList();
            if (TextUtils.isEmpty(r6) == false) goto L5;
        L23:
            return r0;
        L5:
            if (ProvinceActivity.access$1500(this.this$0) != null) goto L7;
        L9:
            ArrayList<ItemEntry> r1 = this.mEntries;
            ProvinceActivity.access$1502(this.this$0, null);
            ArrayList<ItemEntry> r5 = r1;
        L10:
            String r7 = r6.toUpperCase();
            if (r5 == null) goto L23;
            Iterator<ItemEntry> r8 = r5.iterator();
        L14:
            if (r8.hasNext() == false) goto L23;
            ItemEntry r2 = r8.next();
            boolean r3 = r2.getLabel().toUpperCase().contains(r7);
            boolean r4 = r2.mLabelEntry.firstLetters.toUpperCase().contains(r7);
            if (PinyinUtils.isChinese(r7) == true) goto L18;
            boolean r9 = r2.mLabelEntry.labelPinyin.toUpperCase().contains(r7);
        L19:
            if (r3 == true) goto L22;
            if (r9 == true) goto L22;
            if (r4 == false) goto L14;
        L22:
            r0.add(r2);
            goto L14
        L18:
            r9 = false;
            goto L19
        L7:
            if (r6.startsWith(SearchAction.access$1600(ProvinceActivity.access$1500(this.this$0))) == false) goto L9;
            r5 = SearchAction.access$1700(ProvinceActivity.access$1500(this.this$0));
            goto L10
        }

        public int getPositionForSection(int r1) {
            Integer r0 = (Integer) ProvinceActivity.access$1800(this.this$0).get(Character.valueOf((char) r1));
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.intValue();
        }

        private void initSections() {
            ProvinceActivity.access$1200(this.this$0).clear();
            ProvinceActivity.access$1800(this.this$0).clear();
            ArrayList<ItemEntry> r0 = getEntries();
            OLog.d("ManageApplications", "entries size:" + r0.size());
            if (r0.size() <= 0) goto L11;
            String r3 = String.valueOf(r0.get(0).mLabelEntry.firstChar);
            ProvinceActivity.access$1200(this.this$0).add(r3);
            ProvinceActivity.access$1800(this.this$0).put(Character.valueOf(r0.get(0).mLabelEntry.firstChar), 0);
            int r1 = 1;
        L6:
            if (r1 >= r0.size()) goto L11;
            String r4 = String.valueOf(r0.get(r1).mLabelEntry.firstChar);
            if (r3.equals(r4) == true) goto L10;
            ProvinceActivity.access$1200(this.this$0).add(r4);
            ProvinceActivity.access$1800(this.this$0).put(Character.valueOf(r0.get(r1).mLabelEntry.firstChar), Integer.valueOf(r1));
            r3 = r4;
        L10:
            r1 = r1 + 1;
        L11:
            OLog.d("ManageApplications", "section position map:" + ProvinceActivity.access$1800(this.this$0));
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int r2) {
            ArrayList<ItemEntry> r1 = getEntries();
            if (r1.get(r2).mLabelEntry != null) goto L7;
            return 35;
        L7:
            return r1.get(r2).mLabelEntry.firstChar;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            if (r1 < getCount()) goto L7;
            return 0;
        L7:
            return r1;
        }
    }

    private class SearchAction {
        private String keyword;
        private ArrayList<ItemEntry> searchResult;
        final /* synthetic */ ProvinceActivity this$0;

        static /* synthetic */ String access$1600(SearchAction r0) {
            return r0.keyword;
        }

        static /* synthetic */ ArrayList access$1700(SearchAction r0) {
            return r0.searchResult;
        }

        public SearchAction(ProvinceActivity r1, String r2, ArrayList<ItemEntry> r3) {
            this.this$0 = r1;
            this.keyword = r2;
            this.searchResult = r3;
        }
    }

    private class SearchAdapter extends ItemListAdapter {
        final /* synthetic */ ProvinceActivity this$0;

        public SearchAdapter(ProvinceActivity r1, Context r2) {
            this.this$0 = r1;
            super(r1, r2);
        }
    }

    public void com_android_settings_ProvinceActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public boolean isItemCanScroll(int r1) {
        return false;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    @Override // com.android.settings.SearchBarEx.Listener
    public void startSearch() {
    }

    public ProvinceActivity() {
        this.mSections = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.mItemList = new ArrayList();
        this.mIsItemScrollRestored = true;
        this.mIsEditMode = false;
        this.mIsEditAnimationRunning = false;
        this.mOriginBackButtonText = null;
        this.mCurrentCode = "";
        this.mOrignalCode = "";
        this.mCurrentName = "";
        this.mIsProvince = false;
        this.ALPHA_COMPARATOR = new AnonymousClass1(this);
        this.mQBListener = new AnonymousClass7(this);
    }

    static /* synthetic */ void access$000(ProvinceActivity r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ QuickBar access$100(ProvinceActivity r0) {
        return r0.mQuickBar;
    }

    static /* synthetic */ SlideListView access$1000(ProvinceActivity r0) {
        return r0.mListView;
    }

    static /* synthetic */ ItemListAdapter access$1100(ProvinceActivity r0) {
        return r0.mListAdapter;
    }

    static /* synthetic */ ArrayList access$1200(ProvinceActivity r0) {
        return r0.mSections;
    }

    static /* synthetic */ boolean access$1300(ProvinceActivity r0) {
        return r0.mIsProvince;
    }

    static /* synthetic */ String access$1400(ProvinceActivity r0) {
        return r0.mOrignalCode;
    }

    static /* synthetic */ SearchAction access$1500(ProvinceActivity r0) {
        return r0.mLastSearch;
    }

    static /* synthetic */ SearchAction access$1502(ProvinceActivity r0, SearchAction r1) {
        r0.mLastSearch = r1;
        return r1;
    }

    static /* synthetic */ HashMap access$1800(ProvinceActivity r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ boolean access$200(ProvinceActivity r0) {
        return r0.mIsEditMode;
    }

    static /* synthetic */ boolean access$300(ProvinceActivity r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ View access$400(ProvinceActivity r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ OFloatingTitleBar access$500(ProvinceActivity r0) {
        return r0.mTitle;
    }

    static /* synthetic */ void access$600(ProvinceActivity r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ View access$700(ProvinceActivity r0) {
        return r0.mSearchResultView;
    }

    @Override // com.android.settings.SearchBarEx.Listener
    public void exeStartSearchAnimation() {
        initStartSearchAnimation();
        this.mListView.restoreScrollState(true);
    }

    @Override // com.android.settings.SearchBarEx.Listener
    public void exeExitSearchAnimation(boolean r1) {
        startEndSearchAnimation();
    }

    @Override // com.android.settings.SearchBarEx.Listener
    public void searchText(String r1) {
        search(r1);
    }

    public void recoverQuickBar() {
        restoreListViewScrollState(true);
        this.mQuickBar.hideLetterGrid();
    }

    public void com_android_settings_ProvinceActivity__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.headerlist_with_searchbar_layout);
        OFloatingTitleBar r7 = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mTitle = r7;
        ImageView r8 = (ImageView) r7.addEndAction(R.drawable.standard_icon_hignlight_confirm_selector, -1, null);
        this.mRightBtn = r8;
        r8.setOnClickListener(this);
        this.mWholeView = findViewById(R.id.whole_view);
        SearchBarEx r9 = (SearchBarEx) findViewById(R.id.searchbar);
        this.mSearchBar = r9;
        r9.setListener(this);
        this.mEditBarView = (RelativeLayout) findViewById(R.id.option_bar);
        this.mOptionTextView = (TextView) findViewById(R.id.option_title);
        this.mRightBtn.setEnabled(false);
        QuickBar r10 = (QuickBar) findViewById(R.id.quickbar);
        this.mQuickBar = r10;
        r10.setLongPressEnabled(false);
        this.mQuickBar.setQBListener(this.mQBListener);
        this.mQuickBar.setPoundVisibility(true);
        this.mQuickBar.setPoundPosition(QuickBar.POUND_POSITION_TOP);
        this.mQuickBar.clearSpecialIcons();
        this.mQuickBar.initLetters();
        this.mEmptyView = (TextView) findViewById(R.id.view_empty);
        SlideListView r11 = (SlideListView) findViewById(R.id.listView);
        this.mListView = r11;
        r11.setEmptyView(this.mEmptyView);
        this.mListView.setOnScrollStateChangeListener(this);
        this.mListView.setOnQuickBarChanged(this);
        this.mListView.setHorizontalScrollEnabled(false);
        this.mSearchResultView = findViewById(R.id.seachresultview);
        this.mSearchResultListView = (HorizontalScrollListView) findViewById(R.id.search_listview);
        this.mSearchEmptyView = findViewById(R.id.search_empty_view);
        this.mSearchResultListView.setOnItemClickListener(this);
        this.mSearchResultListView.setOnItemLongClickListener(this);
        this.mSearchResultListView.setOnScrollStateChangeListener(new AnonymousClass2(this));
        TextView r12 = (TextView) findViewById(R.id.searchview_bg);
        this.mSearchBackground = r12;
        r12.setOnClickListener(new AnonymousClass3(this));
        setupBackBtnOnTitle(false);
        if (this.mBackView != null) goto L5;
        this.mBackView = this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(this);
    L5:
        this.mListAdapter = new ItemListAdapter(this, this);
        this.mListView.setAreHeadersSticky(true);
        this.mListView.setAdapter(this.mListAdapter);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnItemLongClickListener(this);
        this.mListView.setOnTouchListener(new AnonymousClass4(this));
        Parcelable[] r13 = getIntent().getParcelableArrayExtra("province");
        int r1 = 0;
    L7:
        if (r1 >= r13.length) goto L9;
        this.mItemList.add(new ItemEntry(this, (SMTCodeName) r13[r1]));
        r1 = r1 + 1;
        goto L7
    L9:
        Collections.sort(this.mItemList, this.ALPHA_COMPARATOR);
        this.mListAdapter.updateAppEntries(this.mItemList);
        this.mOrignalCode = getIntent().getStringExtra("provinceCode");
        this.mIsProvince = getIntent().getBooleanExtra("is_province", false);
    }

    private void search(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.restoreScrollState(false);
        this.mSearchResultListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
    L6:
        this.mSearchResultList = this.mListAdapter.query(r4);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        this.mLastSearch = new SearchAction(this, r4, this.mSearchResultList);
    L10:
        if (this.mSearchAdapter != null) goto L12;
        SearchAdapter r5 = new SearchAdapter(this, this);
        this.mSearchAdapter = r5;
        this.mSearchResultListView.setAdapter(r5);
    L12:
        this.mSearchAdapter.updateAppEntries(this.mSearchResultList);
        updateView();
        return;
    L5:
        this.mSearchResultListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        goto L6
    }

    private void cancelSearch() {
        this.mSearchBar.cancelSearch(true);
    }

    private void setQuickBarVisibility() {
        if (this.mQuickBar == null) goto L20;
        ItemListAdapter r0 = this.mListAdapter;
        int r1 = 0;
        if (r0 != null) goto L7;
    L13:
        boolean r2 = false;
    L14:
        QuickBar r3 = this.mQuickBar;
        if (r2 == true) goto L18;
        r1 = 8;
    L18:
        r3.setVisibility(r1);
        return;
    L7:
        if (r0.getCount() <= 0) goto L13;
        if (this.mSearchBar.isSearchMode() == true) goto L13;
        if (this.mIsItemScrollRestored == false) goto L13;
        r2 = true;
        goto L14
    }

    private void initStartSearchAnimation() {
        if (this.mStartSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, -this.mTitle.getHeight()})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mStartSearchAnim = r3;
        r3.setDuration(200);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mStartSearchAnim.addListener(new AnonymousClass5(this));
    L5:
        this.mStartSearchAnim.start();
    }

    private void startEndSearchAnimation() {
        if (this.mEndSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{-this.mTitle.getHeight(), 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mEndSearchAnim = r3;
        r3.setDuration(200);
        this.mEndSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mEndSearchAnim.addListener(new AnonymousClass6(this));
    L5:
        this.mEndSearchAnim.start();
    }

    public void com_android_settings_ProvinceActivity__onResume$___twin___() {
        super.onResume();
        updateView();
        if (this.mSearchBar.isSearchMode() == false) goto L10;
        SearchAdapter r0 = this.mSearchAdapter;
        if (r0 != null) goto L7;
    L8:
        getWindow().setSoftInputMode(21);
        return;
    L7:
        if (r0.getCount() == 0) goto L8;
        return;
    }

    public void com_android_settings_ProvinceActivity__onPause$___twin___() {
        super.onPause();
        this.mLastSearch = null;
    }

    public void com_android_settings_ProvinceActivity__onStop$___twin___() {
        super.onStop();
        restoreListViewScrollState(false);
        resetQuickBarState();
    }

    public void com_android_settings_ProvinceActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    private boolean resetQuickBarState() {
        if (this.mQuickBar.isLetterGridShow() == false) goto L6;
        this.mQuickBar.hideLetterGrid(true);
        return true;
    L6:
        return false;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mSearchBar.isSearchMode() == true) goto L16;
        if (this.mSearchBar.isPlayingSearchAnimation() == true) goto L16;
        if (resetQuickBarState() == false) goto L11;
        return;
    L11:
        if (this.mListView.restoreScrollState(true) == false) goto L13;
        return;
    L13:
        super.onBackPressed();
        return;
    L16:
        if (this.mSearchResultListView.restoreScrollState(true) == false) goto L18;
        return;
    L18:
        cancelSearch();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        if (this.mSearchBar.isPlayingSearchAnimation() == false) goto L5;
        return;
    L5:
        ItemEntry r5 = (ItemEntry) r1.getItemAtPosition(r3);
        if (r5 == null) goto L9;
        this.mCurrentCode = ItemEntry.access$800(r5);
        this.mCurrentName = ItemEntry.access$900(r5);
        finish();
        return;
    }

    public void com_android_settings_ProvinceActivity__finish$___twin___() {
        int r1 = 0;
        if (TextUtils.isEmpty(this.mCurrentCode) == false) goto L5;
    L8:
        boolean r0 = false;
    L9:
        Intent r2 = new Intent();
        r2.putExtra("currentCode", this.mCurrentCode);
        r2.putExtra("currentName", this.mCurrentName);
        if (r0 == false) goto L12;
        r1 = -1;
    L12:
        setResult(r1, r2);
        super.finish();
        return;
    L5:
        if (this.mCurrentCode.equals(this.mOrignalCode) == true) goto L8;
        r0 = true;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mSearchBar.isPlayingSearchAnimation() == false) goto L6;
        return;
    L6:
        if (this.mIsEditAnimationRunning == false) goto L9;
        return;
    L9:
        if (r2 != this.mBackView) goto L12;
        finish();
        return;
    }

    private void updateView() {
        updateTitleBar();
        SlideListView r0 = this.mListView;
        if (r0 == null) goto L6;
        r0.setHorizontalScrollEnabled(!this.mIsEditMode);
    L6:
        if (this.mSearchBar.isSearchMode() == false) goto L8;
        ItemListAdapter r2 = this.mSearchAdapter;
    L9:
        if (r2 == null) goto L12;
        r2.notifyDataSetChanged();
        return;
    L12:
        return;
    L8:
        r2 = this.mListAdapter;
        goto L9
    }

    private void updateTitleBar() {
        if (isFromSecurityCenter() == false) goto L6;
        updateTitleSecurityShadow();
        this.mRightBtn.setImageResource(R.drawable.standard_icon_complete_reverse_selector);
        return;
    }

    @Override // com.android.settings.widget.SlideListView.OnQuickBarChangedListener
    public boolean processQuickBar() {
        if (this.mIsEditMode == false) goto L10;
        QuickBar r0 = this.mQuickBar;
        if (r0 != null) goto L7;
    L9:
        return false;
    L7:
        if (r0.isLetterGridShow() == false) goto L9;
        this.mQuickBar.hideLetterGrid(true);
        goto L9
    L10:
        QuickBar r1 = this.mQuickBar;
        if (r1 != null) goto L13;
    L16:
        return false;
    L13:
        if (r1.isLetterGridShow() == false) goto L16;
        this.mQuickBar.hideLetterGrid(true);
        return true;
    }

    private boolean restoreListViewScrollState(boolean r2) {
        if (this.mSearchBar.isSearchMode() == false) goto L7;
        return this.mSearchResultListView.restoreScrollState(r2);
    L7:
        return this.mListView.restoreScrollState(r2);
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrollStart(int r1) {
        this.mIsItemScrollRestored = false;
        setQuickBarVisibility();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrollStartToComplete() {
        this.mIsItemScrollRestored = false;
        setQuickBarVisibility();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrolling() {
        this.mIsItemScrollRestored = false;
        setQuickBarVisibility();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrollCompleted() {
        this.mIsItemScrollRestored = false;
        setQuickBarVisibility();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrollRestored() {
        this.mIsItemScrollRestored = true;
        setQuickBarVisibility();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> r1, View r2, int r3, long r4) {
        if (this.mIsEditMode == true) goto L13;
        if (r3 >= r1.getCount()) goto L13;
        if ((r1.getItemAtPosition(r3) instanceof ApplicationsState.AppEntry) == false) goto L13;
        OToast r5 = this.mToast;
        if (r5 == null) goto L11;
        r5.cancel();
    L11:
        this.mToast = ToastUtils.show(this, R.string.toast_swipe_right);
    L13:
        return !this.mIsEditMode;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ProvinceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ProvinceActivity r1) {
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ProvinceActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvinceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ProvinceActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ProvinceActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ProvinceActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ProvinceActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ProvinceActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_ProvinceActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ProvinceActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_ProvinceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onResume(ProvinceActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvinceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_ProvinceActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ProvinceActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onPause(ProvinceActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvinceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_ProvinceActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ProvinceActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ProvinceActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onStop(ProvinceActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvinceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_ProvinceActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(ProvinceActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvinceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_ProvinceActivity__onDestroy$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_ProvinceActivity_com_obric_hook_lancet_PrivacyHook_finish(ProvinceActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvinceActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_ProvinceActivity__finish$___twin___();
    }
}
