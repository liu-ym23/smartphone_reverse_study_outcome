package com.android.settings.textboom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import bytedanceos.util.NavigationBarHelper;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.pinyin.PinyinUtils;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.HorizontalScrollListView;
import com.android.settings.widget.SlideListView;
import com.obric.olog.OLog;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.privacy.GrantUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.QuickBar;
import obric.widget.SearchBar;
import obric.widget.SwitchEx;
import obric.widget.letters.QuickBarEx;

/* JADX INFO: loaded from: classes2.dex */
public class OcrApplicationsFragment extends BaseFragment implements AdapterView.OnItemClickListener, HorizontalScrollListView.ScrollStateListener, View.OnClickListener, SlideListView.Listener, SlideListView.OnQuickBarChangedListener {
    private static final int ANIM_DURATION = 200;
    private static final int ANIM_START_DELAY = 10;
    private static final int MSG_ID_DISMISS_CALCULATING_SIZE_DIALOG = 13;
    private static final int MSG_ID_DISMISS_DIALOG = 12;
    private static final int MSG_ID_SHOW_PROGRESS_DIALOG = 11;
    private static final int REQ_VERIFY_PASSWORD = 10;
    public static final String TAG = "OcrApplicationsFragment";
    private AppInfoDataLoader mAppInfoDataLoader;
    private ApplicationsAdapter mApplicationsAdapter;
    private DataLoadListener mDataLoadListener;
    private TextView mEmptyView;
    private AnimatorSet mEndSearchAnim;
    private final MyHandler mHandler;
    private boolean mIsEditAnimationRunning;
    private boolean mIsItemScrollRestored;
    private boolean mIsOCRInGameDisabled;
    private SearchAction mLastSearch;
    private Bitmap[][] mLetterProfileBitmaps;
    private SlideListView mListView;
    private HashMap<Character, Integer> mPositionOfSections;
    private QuickBarEx.QBListener mQBListener;
    private QuickBarEx mQuickBar;
    private SearchAdapter mSearchAdapter;
    private TextView mSearchBackground;
    private SearchBar mSearchBar;
    private EditText mSearchBarEditor;
    private View mSearchEmptyView;
    private ArrayList<AppInfoDataLoader.AppInfoEntry> mSearchResultList;
    private HorizontalScrollListView mSearchResultListView;
    private View mSearchResultView;
    private ArrayList<String> mSections;
    private AnimatorSet mStartSearchAnim;
    private HashMap<String, Boolean> mStatusChangedMap;
    private View mWholeView;

    private class AppListAdapter extends BaseAdapter {
        private List<AppInfoDataLoader.AppInfoEntry> mEntries;
        private int mItemArrowRightMargin;
        protected LayoutInflater mLayoutInflater;
        final /* synthetic */ OcrApplicationsFragment this$0;

        /* JADX INFO: renamed from: com.android.settings.textboom.OcrApplicationsFragment$AppListAdapter$2, reason: invalid class name */
        class AnonymousClass2 implements AsyncIconLoader.ImageCallback {
            final /* synthetic */ AppListAdapter this$1;
            final /* synthetic */ ImageView val$iconView;

            AnonymousClass2(AppListAdapter r1, ImageView r2) {
                this.this$1 = r1;
                this.val$iconView = r2;
            }

            @Override // com.android.settings.textboom.AsyncIconLoader.ImageCallback
            public void imageLoaded(final Bitmap r3, final String r4) {
                OcrApplicationsFragment.access$2200(this.this$1.this$0).post(new AnonymousClass1(this, r4, r3));
            }

            @Override // com.android.settings.textboom.AsyncIconLoader.ImageCallback
            public boolean isCancel(String r2) {
                if (TextUtils.isEmpty(r2) == true) goto L5;
                boolean r1 = r2.equals(this.val$iconView.getTag());
            L7:
                return !r1;
            L5:
                r1 = false;
                goto L7
            }
        }

        class ViewHolder implements View.OnClickListener {
            AppInfoDataLoader.AppInfoEntry entry;
            ImageView iconView;
            SwitchEx switchEx;
            final /* synthetic */ AppListAdapter this$1;
            TextView titleView;

            @Override // android.view.View.OnClickListener
            public void onClick(View r1) {
            }

            ViewHolder(AppListAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public AppListAdapter(OcrApplicationsFragment r1, Context r2) {
            this.this$0 = r1;
            this.mLayoutInflater = LayoutInflater.from(r2);
            this.mItemArrowRightMargin = r1.getResources().getDimensionPixelSize(R.dimen.settings_item_right_arrow_margin);
        }

        protected void updateAppEntries(List<AppInfoDataLoader.AppInfoEntry> r2) {
            ArrayList r0 = new ArrayList();
            r0.addAll(r2);
            this.mEntries = r0;
        }

        protected List<AppInfoDataLoader.AppInfoEntry> getAppEntries() {
            return this.mEntries;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<AppInfoDataLoader.AppInfoEntry> r0 = this.mEntries;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public AppInfoDataLoader.AppInfoEntry getItem(int r1) {
            return this.mEntries.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r2) {
            if (r2 < getCount()) goto L7;
            return 0;
        L7:
            return this.mEntries.get(r2).id;
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L5;
        L8:
            r5 = this.mLayoutInflater.inflate(R.layout.ocr_app_item_layout, null);
            ViewHolder r0 = new ViewHolder(this);
            r0.iconView = (ImageView) r5.findViewById(R.id.item_icon);
            r0.titleView = (TextView) r5.findViewById(R.id.item_title);
            r0.switchEx = (SwitchEx) r5.findViewById(R.id.item_switch);
            r5.setTag(r0);
        L9:
            AppInfoDataLoader.AppInfoEntry r7 = this.mEntries.get(r4);
            monitor-enter(r7);
            r0.entry = r7;     // Catch: Throwable -> L28
            if (r7.mLabelEntry.label == null) goto L14;
            r0.titleView.setText(r7.mLabelEntry.label);     // Catch: Throwable -> L28
        L14:
            r0.iconView.setTag(r0.entry.appInfo.sourceDir);     // Catch: Throwable -> L28
            r0.switchEx.setOnCheckedChangeListener(null);     // Catch: Throwable -> L28
            if (OcrApplicationsFragment.access$2000(this.this$0).containsKey(r0.entry.appInfo.packageName) == false) goto L17;
            r0.switchEx.setChecked(((Boolean) OcrApplicationsFragment.access$2000(this.this$0).get(r0.entry.appInfo.packageName)).booleanValue());     // Catch: Throwable -> L28
        L19:
            if (OcrApplicationsFragment.access$2100(this.this$0) == true) goto L21;
        L23:
            r0.switchEx.setEnabled(true);     // Catch: Throwable -> L28
        L24:
            r0.switchEx.setTag(r0.entry.appInfo.packageName);     // Catch: Throwable -> L28
            r0.switchEx.setOnCheckedChangeListener(new AnonymousClass1(this));     // Catch: Throwable -> L28
            ImageView r8 = r0.iconView;     // Catch: Throwable -> L28
            AsyncIconLoader.getInstance(this.this$0.getApplicationContext()).loadBitmap(r7.appInfo, new AnonymousClass2(this, r8));     // Catch: Throwable -> L28
            monitor-exit(r7);     // Catch: Throwable -> L28
            r5.findViewById(R.id.app_layout).setBackgroundResource(R.drawable.horizontal_scroll_app_list_item_bg_selector);
            return r5;
        L21:
            if (r0.entry.isGame == false) goto L23;
            r0.switchEx.setEnabled(false);     // Catch: Throwable -> L28
            goto L24
        L17:
            r0.switchEx.setChecked(r0.entry.canBoom);     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        L5:
            if (r5.getTag() == null) goto L8;
            r0 = (ViewHolder) r5.getTag();
            goto L9
        }
    }

    private class ApplicationsAdapter extends AppListAdapter implements AbsListView.RecyclerListener, StickyListHeadersAdapter, SectionIndexer {
        private final ArrayList<View> mActives;
        private boolean mResumed;
        final /* synthetic */ OcrApplicationsFragment this$0;

        class HeaderViewHolder {
            OSectionTitleBar headerText;
            final /* synthetic */ ApplicationsAdapter this$1;

            HeaderViewHolder(ApplicationsAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int r1) {
            return 0;
        }

        public ApplicationsAdapter(OcrApplicationsFragment r1, Context r2) {
            this.this$0 = r1;
            super(r1, r2);
            this.mActives = new ArrayList();
        }

        public void resume() {
            if (this.mResumed == true) goto L5;
            this.mResumed = true;
            rebuild();
            return;
        L5:
            rebuild();
        }

        public void pause() {
            if (this.mResumed == false) goto L6;
            this.mResumed = false;
            return;
        }

        public ArrayList<AppInfoDataLoader.AppInfoEntry> query(String r6) {
            ArrayList<AppInfoDataLoader.AppInfoEntry> r0 = new ArrayList();
            if (TextUtils.isEmpty(r6) == false) goto L5;
        L23:
            return r0;
        L5:
            if (OcrApplicationsFragment.access$1600(this.this$0) != null) goto L7;
        L9:
            List<AppInfoDataLoader.AppInfoEntry> r1 = OcrApplicationsFragment.access$000(this.this$0).getAppEntries();
            OcrApplicationsFragment.access$1602(this.this$0, null);
            List<AppInfoDataLoader.AppInfoEntry> r5 = r1;
        L10:
            String r7 = r6.toUpperCase();
            if (r5 == null) goto L23;
            Iterator<AppInfoDataLoader.AppInfoEntry> r8 = r5.iterator();
        L14:
            if (r8.hasNext() == false) goto L23;
            AppInfoDataLoader.AppInfoEntry r2 = r8.next();
            boolean r3 = r2.mLabelEntry.label.toUpperCase().contains(r7);
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
            if (r6.startsWith(SearchAction.access$1700(OcrApplicationsFragment.access$1600(this.this$0))) == false) goto L9;
            r5 = SearchAction.access$1800(OcrApplicationsFragment.access$1600(this.this$0));
            goto L10
        }

        @Override // com.android.settings.textboom.OcrApplicationsFragment.AppListAdapter
        protected void updateAppEntries(List<AppInfoDataLoader.AppInfoEntry> r1) {
            super.updateAppEntries(r1);
            initSections();
            notifyDataSetChanged();
        }

        @Override // com.android.settings.textboom.OcrApplicationsFragment.AppListAdapter, android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            View r4 = super.getView(r1, r2, r3);
            this.mActives.remove(r4);
            this.mActives.add(r4);
            return r4;
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View r1) {
            this.mActives.remove(r1);
        }

        public void rebuild() {
            OcrApplicationsFragment.access$500(this.this$0).requestData("all_apps");
        }

        private void initSections() {
            OcrApplicationsFragment.access$1500(this.this$0).clear();
            OcrApplicationsFragment.access$1900(this.this$0).clear();
            List<AppInfoDataLoader.AppInfoEntry> r0 = getAppEntries();
            OLog.d(OcrApplicationsFragment.TAG, "entries size:" + r0.size());
            if (r0.size() <= 0) goto L11;
            String r3 = String.valueOf(r0.get(0).mLabelEntry.firstChar);
            OcrApplicationsFragment.access$1500(this.this$0).add(r3);
            OcrApplicationsFragment.access$1900(this.this$0).put(Character.valueOf(r0.get(0).mLabelEntry.firstChar), 0);
            int r1 = 1;
        L6:
            if (r1 >= r0.size()) goto L11;
            String r4 = String.valueOf(r0.get(r1).mLabelEntry.firstChar);
            if (r3.equals(r4) == true) goto L10;
            OcrApplicationsFragment.access$1500(this.this$0).add(r4);
            OcrApplicationsFragment.access$1900(this.this$0).put(Character.valueOf(r0.get(r1).mLabelEntry.firstChar), Integer.valueOf(r1));
            r3 = r4;
        L10:
            r1 = r1 + 1;
        L11:
            OLog.d(OcrApplicationsFragment.TAG, "section position map:" + OcrApplicationsFragment.access$1900(this.this$0));
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
            List<AppInfoDataLoader.AppInfoEntry> r2 = getAppEntries();
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

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int r2) {
            List<AppInfoDataLoader.AppInfoEntry> r1 = getAppEntries();
            if (r1.get(r2).mLabelEntry != null) goto L7;
            return 35;
        L7:
            return r1.get(r2).mLabelEntry.firstChar;
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return OcrApplicationsFragment.access$1500(this.this$0).toArray();
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int r1) {
            Integer r0 = (Integer) OcrApplicationsFragment.access$1900(this.this$0).get(Character.valueOf((char) r1));
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.intValue();
        }
    }

    private static class MyHandler extends Handler {
        WeakReference<OcrApplicationsFragment> weakReference;

        public MyHandler(OcrApplicationsFragment r2) {
            this.weakReference = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            OcrApplicationsFragment r1 = this.weakReference.get();
            if (r1.isAdded() == true) goto L6;
            return;
        L6:
            if (r2.what != 2) goto L10;
            OcrApplicationsFragment.access$500(r1).clearCache();
            return;
        }
    }

    private class SearchAction {
        private String keyword;
        private ArrayList<AppInfoDataLoader.AppInfoEntry> searchResult;
        final /* synthetic */ OcrApplicationsFragment this$0;

        static /* synthetic */ String access$1700(SearchAction r0) {
            return r0.keyword;
        }

        static /* synthetic */ ArrayList access$1800(SearchAction r0) {
            return r0.searchResult;
        }

        public SearchAction(OcrApplicationsFragment r1, String r2, ArrayList<AppInfoDataLoader.AppInfoEntry> r3) {
            this.this$0 = r1;
            this.keyword = r2;
            this.searchResult = r3;
        }
    }

    private class SearchAdapter extends AppListAdapter {
        final /* synthetic */ OcrApplicationsFragment this$0;

        public SearchAdapter(OcrApplicationsFragment r1, Context r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.android.settings.textboom.OcrApplicationsFragment.AppListAdapter
        protected void updateAppEntries(List<AppInfoDataLoader.AppInfoEntry> r1) {
            super.updateAppEntries(r1);
            notifyDataSetChanged();
        }
    }

    private class SearchBarCallback extends SearchBar.ListenerAdapter {
        final /* synthetic */ OcrApplicationsFragment this$0;

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchRightView() {
        }

        private SearchBarCallback(OcrApplicationsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SearchBarCallback(OcrApplicationsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationStart() {
            if (OcrApplicationsFragment.access$100(this.this$0).isSearchMode() == false) goto L6;
            ViewGroup.LayoutParams r0 = OcrApplicationsFragment.access$600(this.this$0).getLayoutParams();
            r0.height = OcrApplicationsFragment.access$600(this.this$0).getHeight() + this.this$0.mTitleView.getHeight();
            OcrApplicationsFragment.access$600(this.this$0).setLayoutParams(r0);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationEnd() {
            if (OcrApplicationsFragment.access$100(this.this$0).isSearchMode() == true) goto L6;
            ViewGroup.LayoutParams r0 = OcrApplicationsFragment.access$600(this.this$0).getLayoutParams();
            r0.height = -1;
            OcrApplicationsFragment.access$600(this.this$0).setLayoutParams(r0);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void searchText(String r1) {
            OcrApplicationsFragment.access$400(this.this$0, r1);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchEdit() {
            if (OcrApplicationsFragment.access$100(this.this$0).isPlayingAnimation() == false) goto L5;
            return;
        L5:
            if (OcrApplicationsFragment.access$100(this.this$0).isSearchMode() == true) goto L9;
            OcrApplicationsFragment.access$700(this.this$0);
            OcrApplicationsFragment.access$800(this.this$0);
            OcrApplicationsFragment.access$900(this.this$0).restoreScrollState(true);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickCancelButton() {
            if (OcrApplicationsFragment.access$100(this.this$0).isPlayingAnimation() == false) goto L5;
            return;
        L5:
            if (OcrApplicationsFragment.access$100(this.this$0).isSearchMode() == false) goto L9;
            OcrApplicationsFragment.access$1000(this.this$0);
            return;
        }
    }

    private void onAppCheckStateChanged(AppInfoDataLoader.AppInfoEntry r1, boolean r2) {
    }

    public void com_android_settings_textboom_OcrApplicationsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public boolean isItemCanScroll(int r1) {
        return true;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_textboom_OcrApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_textboom_OcrApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OcrApplicationsFragment() {
        this.mSections = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.mIsItemScrollRestored = true;
        this.mIsEditAnimationRunning = false;
        this.mStatusChangedMap = new HashMap();
        this.mDataLoadListener = new AnonymousClass1(this);
        this.mHandler = new MyHandler(this);
        this.mQBListener = new AnonymousClass6(this);
    }

    static /* synthetic */ ApplicationsAdapter access$000(OcrApplicationsFragment r0) {
        return r0.mApplicationsAdapter;
    }

    static /* synthetic */ SearchBar access$100(OcrApplicationsFragment r0) {
        return r0.mSearchBar;
    }

    static /* synthetic */ void access$1000(OcrApplicationsFragment r0) {
        r0.startEndSearchAnimation();
    }

    static /* synthetic */ void access$1200(OcrApplicationsFragment r0) {
        r0.hideIME();
    }

    static /* synthetic */ void access$1300(OcrApplicationsFragment r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ View access$1400(OcrApplicationsFragment r0) {
        return r0.mSearchResultView;
    }

    static /* synthetic */ ArrayList access$1500(OcrApplicationsFragment r0) {
        return r0.mSections;
    }

    static /* synthetic */ SearchAction access$1600(OcrApplicationsFragment r0) {
        return r0.mLastSearch;
    }

    static /* synthetic */ SearchAction access$1602(OcrApplicationsFragment r0, SearchAction r1) {
        r0.mLastSearch = r1;
        return r1;
    }

    static /* synthetic */ HashMap access$1900(OcrApplicationsFragment r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ void access$200(OcrApplicationsFragment r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ HashMap access$2000(OcrApplicationsFragment r0) {
        return r0.mStatusChangedMap;
    }

    static /* synthetic */ boolean access$2100(OcrApplicationsFragment r0) {
        return r0.mIsOCRInGameDisabled;
    }

    static /* synthetic */ MyHandler access$2200(OcrApplicationsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ EditText access$300(OcrApplicationsFragment r0) {
        return r0.mSearchBarEditor;
    }

    static /* synthetic */ void access$400(OcrApplicationsFragment r0, String r1) {
        r0.search(r1);
    }

    static /* synthetic */ AppInfoDataLoader access$500(OcrApplicationsFragment r0) {
        return r0.mAppInfoDataLoader;
    }

    static /* synthetic */ View access$600(OcrApplicationsFragment r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ boolean access$700(OcrApplicationsFragment r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ void access$800(OcrApplicationsFragment r0) {
        r0.initStartSearchAnimation();
    }

    static /* synthetic */ SlideListView access$900(OcrApplicationsFragment r0) {
        return r0.mListView;
    }

    public void com_android_settings_textboom_OcrApplicationsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mRootView = r4.inflate(R.layout.ocr_app_list, r5, false);
        this.mWholeView = findViewByIdNullable(R.id.whole_view);
        SearchBar r7 = (SearchBar) findViewByIdNullable(R.id.searchbar);
        this.mSearchBar = r7;
        r7.setListener(new SearchBarCallback(this, null));
        this.mSearchBarEditor = (EditText) this.mSearchBar.getSearchEditor();
        QuickBarEx r8 = (QuickBarEx) findViewByIdNullable(R.id.quickbar);
        this.mQuickBar = r8;
        r8.setLongPressEnabled(false);
        this.mQuickBar.setQBListener(this.mQBListener);
        this.mQuickBar.setPoundVisibility(true);
        this.mQuickBar.setPoundPosition(QuickBar.POUND_POSITION_TOP);
        this.mQuickBar.initLetters();
        getArguments();
        this.mEmptyView = (TextView) findViewByIdNullable(R.id.view_empty);
        SlideListView r9 = (SlideListView) findViewByIdNullable(R.id.listView);
        this.mListView = r9;
        r9.setSlideListener(this);
        this.mListView.setEmptyView(this.mEmptyView);
        this.mListView.setOnScrollStateChangeListener(this);
        this.mListView.setOnQuickBarChanged(this);
        this.mListView.setHorizontalScrollEnabled(false);
        this.mSearchResultView = findViewByIdNullable(R.id.seachresultview);
        this.mSearchResultListView = (HorizontalScrollListView) findViewByIdNullable(R.id.search_listview);
        this.mSearchEmptyView = findViewByIdNullable(R.id.search_empty_view);
        this.mSearchResultListView.setOnItemClickListener(this);
        this.mSearchResultListView.setScrollEnabled(false);
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass2(this));
        TextView r10 = (TextView) findViewByIdNullable(R.id.searchview_bg);
        this.mSearchBackground = r10;
        r10.setOnClickListener(new AnonymousClass3(this));
        Bitmap[][] r11 = (Bitmap[][]) Array.newInstance(Bitmap.class, new int[]{1, 3});
        this.mLetterProfileBitmaps = r11;
        r11[0][0] = BitmapFactory.decodeResource(getResources(), R.drawable.quickbar_setting_nor);
        this.mLetterProfileBitmaps[0][1] = BitmapFactory.decodeResource(getResources(), R.drawable.quickbar_setting_holder);
        this.mLetterProfileBitmaps[0][2] = BitmapFactory.decodeResource(getResources(), R.drawable.quickbar_setting_touch);
        this.mQuickBar.initSpecialIcons(new int[]{1}, this.mLetterProfileBitmaps);
        this.mApplicationsAdapter = new ApplicationsAdapter(this, this._mActivity);
        this.mListView.setAreHeadersSticky(true);
        this.mListView.setAdapter(this.mApplicationsAdapter);
        this.mListView.setOnItemClickListener(this);
        AppInfoDataLoader r12 = AppInfoDataLoader.getInstance(getApplicationContext());
        this.mAppInfoDataLoader = r12;
        r12.addDataLoadListener(this.mDataLoadListener);
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mQuickBar);
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mListView);
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mSearchResultListView);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        this.mBackView.setOnClickListener(this);
        this.mApplicationsAdapter.resume();
        updateViews();
    }

    private void search(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.restoreScrollState(false);
        this.mSearchResultListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
    L6:
        this.mSearchResultList = this.mApplicationsAdapter.query(r4);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        this.mLastSearch = new SearchAction(this, r4, this.mSearchResultList);
    L10:
        if (this.mSearchAdapter != null) goto L12;
        SearchAdapter r5 = new SearchAdapter(this, this._mActivity);
        this.mSearchAdapter = r5;
        this.mSearchResultListView.setAdapter(r5);
    L12:
        this.mSearchAdapter.updateAppEntries(this.mSearchResultList);
        return;
    L5:
        this.mSearchResultListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        goto L6
    }

    private void cancelSearch() {
        this.mSearchBar.onClickCancelView(true);
    }

    private void hideIME() {
        Utils.hideInputMethod(this._mActivity);
    }

    private void setQuickBarVisibility() {
        if (this.mQuickBar == null) goto L20;
        ApplicationsAdapter r0 = this.mApplicationsAdapter;
        int r1 = 0;
        if (r0 != null) goto L7;
    L13:
        boolean r2 = false;
    L14:
        QuickBarEx r3 = this.mQuickBar;
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
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, -this.mTitleView.getHeight()})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mStartSearchAnim = r3;
        r3.setDuration(200);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mStartSearchAnim.addListener(new AnonymousClass4(this));
    L5:
        this.mStartSearchAnim.start();
    }

    private void startEndSearchAnimation() {
        if (this.mEndSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{-this.mTitleView.getHeight(), 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mEndSearchAnim = r3;
        r3.setDuration(200);
        this.mEndSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mEndSearchAnim.addListener(new AnonymousClass5(this));
    L5:
        this.mEndSearchAnim.start();
    }

    public void updateViews() {
        boolean r2 = true;
        if (Settings.Global.getInt(getContentResolver(), "big_bang_disable_ocr_in_game", 1) == 1) goto L6;
        r2 = false;
    L6:
        this.mIsOCRInGameDisabled = r2;
        updateListViews();
        this.mApplicationsAdapter.resume();
        if (this.mSearchBar.isSearchMode() == false) goto L14;
        SearchAdapter r0 = this.mSearchAdapter;
        if (r0 != null) goto L11;
    L12:
        Utils.showSoftInputMethod(this.mContext, this.mSearchBarEditor);
        getWindow().setSoftInputMode(21);
        goto L14
    L11:
        if (r0.getCount() == 0) goto L12;
    L14:
        if (this.mSearchBar.isSearchMode() == true) goto L17;
        this.mSearchBarEditor.setText("");
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        this.mApplicationsAdapter.resume();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mSearchBar.isPlayingAnimation() == false) goto L5;
    L7:
        this.mApplicationsAdapter.pause();
        this.mLastSearch = null;
        restoreListViewScrollState(false);
        AppInfoDataLoader.getInstance(getApplicationContext()).syncStatusToDb(this.mApplicationsAdapter.getAppEntries(), this.mStatusChangedMap);
        return;
    L5:
        if (this.mSearchBar.isSearchMode() == false) goto L7;
        this.mSearchBar.onClickCancelView(false);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mApplicationsAdapter = null;
        this.mAppInfoDataLoader.removeDataLoadListener(this.mDataLoadListener);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private boolean resetQuickBarState() {
        if (this.mQuickBar.isLetterGridShow() == false) goto L6;
        this.mQuickBar.hideLetterGrid(true);
        return true;
    L6:
        return false;
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        if (this.mSearchBar.isSearchMode() == true) goto L16;
        if (this.mSearchBar.isPlayingAnimation() == true) goto L16;
        if (resetQuickBarState() == false) goto L11;
        return true;
    L11:
        if (this.mListView.restoreScrollState(true) == false) goto L13;
        return true;
    L13:
        return false;
    L16:
        if (this.mSearchResultListView.restoreScrollState(true) == false) goto L18;
        return true;
    L18:
        cancelSearch();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        this.mSearchBar.isPlayingAnimation();
    }

    private void onAppCheckStateChanged(AppInfoDataLoader.AppInfoEntry r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.appInfo != null) goto L6;
        return;
    L6:
        if (r2.appInfo.packageName == null) goto L11;
        onAppCheckStateChanged(r2, false);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mSearchBar.isPlayingAnimation() == false) goto L6;
        return;
    L6:
        if (this.mIsEditAnimationRunning == false) goto L9;
        return;
    L9:
        if (r2 != this.mBackView) goto L12;
        finish();
        return;
    }

    private void updateListViews() {
        this.mSearchBarEditor.setEnabled(true);
        if (this.mSearchBar.isSearchMode() == false) goto L5;
        AppListAdapter r2 = this.mSearchAdapter;
    L6:
        if (r2 == null) goto L9;
        r2.notifyDataSetChanged();
        return;
    L9:
        return;
    L5:
        r2 = this.mApplicationsAdapter;
        goto L6
    }

    @Override // com.android.settings.widget.SlideListView.Listener
    public void setChecked(int r2, boolean r3) {
        onAppCheckStateChanged(this.mApplicationsAdapter.getItem(r2), r3);
    }

    @Override // com.android.settings.widget.SlideListView.Listener
    public boolean isChecked(int r2) {
        AppInfoDataLoader.AppInfoEntry r1 = this.mApplicationsAdapter.getItem(r2);
        if (r1.appInfo == null) goto L5;
        String r3 = r1.appInfo.packageName;
    L5:
        return false;
    }

    @Override // com.android.settings.widget.SlideListView.OnQuickBarChangedListener
    public boolean processQuickBar() {
        QuickBarEx r0 = this.mQuickBar;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isLetterGridShow() == false) goto L10;
        this.mQuickBar.hideLetterGrid(true);
        return true;
    L10:
        return false;
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

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_textboom_OcrApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OcrApplicationsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_OcrApplicationsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_OcrApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OcrApplicationsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_textboom_OcrApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_OcrApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OcrApplicationsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_OcrApplicationsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
