package com.android.settings;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import bytedanceos.api.PackageManagerSmt;
import bytedanceos.util.NavigationBarHelper;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.base.BaseFragment;
import com.android.settings.pinyin.PinyinUtils;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.android.settings.stickylistheaders.StickyListHeadersListView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SearchBar;
import obric.widget.letters.QuickBarEx;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayAreaAppsFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private static final int ANIM_DURATION = 300;
    private static final int ANIM_START_DELAY = 10;
    private static final int SETTINGS_NOTCH_ANDROID = 1;
    private AnimatorSet mEndSearchAnim;
    private IPackageManager mIPackageManager;
    private SearchAction mLastSearch;
    private PackageManager mPackageManager;
    private HashMap<Character, Integer> mPositionOfSections;
    private QuickBarEx.QBListener mQBListener;
    private QuickBarEx mQuickBar;
    private AppListAdapter mSearchAdapter;
    private TextView mSearchBackground;
    private SearchBar mSearchBar;
    private View mSearchEmptyView;
    private ListView mSearchListView;
    private View mSearchResultView;
    private ArrayList<String> mSections;
    private AnimatorSet mStartSearchAnim;
    private ApplicationsAdapter mThirdAppAdapter;
    private StickyListHeadersListView mThirdAppsListView;
    private View mWholeView;

    private class AppListAdapter extends BaseAdapter {
        final int iconRightMargin;
        final int itemIconSize;
        protected ArrayList<ApplicationsState.AppEntry> mAppEntries;
        protected Context mContext;
        private int mItemArrowRightMargin;
        protected LayoutInflater mLayoutInflater;
        final /* synthetic */ DisplayAreaAppsFragment this$0;

        class ViewHolder {
            TextView appSizeView;
            ImageView arrow;
            CheckBox checkBox;
            ApplicationsState.AppEntry entry;
            ImageView iconView;
            final /* synthetic */ AppListAdapter this$1;
            TextView titleView;
            ImageView uninstallButton;

            ViewHolder(AppListAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        AppListAdapter(DisplayAreaAppsFragment r3, Context r4) {
            this.this$0 = r3;
            this.mContext = r4;
            this.mAppEntries = new ArrayList();
            this.itemIconSize = r3.getResources().getDimensionPixelOffset(R.dimen.settings_list_item_icon_size);
            this.iconRightMargin = r3.getResources().getDimensionPixelOffset(R.dimen.settings_list_item_icon_margin_right);
            this.mItemArrowRightMargin = r3.getResources().getDimensionPixelSize(R.dimen.settings_item_right_arrow_margin);
            this.mLayoutInflater = LayoutInflater.from(r4);
        }

        public ArrayList<ApplicationsState.AppEntry> getAppEntries() {
            return this.mAppEntries;
        }

        protected void updateAppEntries(ArrayList<ApplicationsState.AppEntry> r2) {
            if (r2 != null) goto L4;
        L8:
            this.mAppEntries.clear();
            return;
        L4:
            if (r2.isEmpty() == true) goto L8;
            this.mAppEntries.clear();
            this.mAppEntries.addAll(r2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<ApplicationsState.AppEntry> r0 = this.mAppEntries;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mAppEntries.get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L5;
        L8:
            r6 = this.mLayoutInflater.inflate(R.layout.application_item_scroll_layout, null);
            ViewHolder r0 = new ViewHolder(this);
            r0.uninstallButton = (ImageView) r6.findViewById(R.id.scroll_del_btn);
            r0.uninstallButton.setVisibility(8);
            r0.checkBox = (CheckBox) r6.findViewById(R.id.item_checkbox);
            r0.iconView = (ImageView) r6.findViewById(R.id.item_icon);
            r0.titleView = (TextView) r6.findViewById(R.id.item_title);
            r0.appSizeView = (TextView) r6.findViewById(R.id.item_subtitle);
            r0.arrow = (ImageView) r6.findViewById(R.id.item_check);
            r0.arrow.setImageResource(R.drawable.secletor_setting_item_arrow);
            RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(-2, -2);
            r1.setMargins(0, 0, this.mItemArrowRightMargin, 0);
            r1.addRule(11);
            r1.addRule(15);
            r0.arrow.setLayoutParams(r1);
            r0.appSizeView.setVisibility(0);
            r0.arrow.setVisibility(0);
            r6.setTag(r0);
        L9:
            ApplicationsState.AppEntry r8 = this.mAppEntries.get(r5);
            monitor-enter(r8);
            r0.entry = r8;     // Catch: Throwable -> L27
            if (r8.label == null) goto L15;
            r0.titleView.setText(r8.label);     // Catch: Throwable -> L27
        L15:
            if (r8.icon != null) goto L17;
            r8.ensureIconLocked(this.mContext, DisplayAreaAppsFragment.access$2000(this.this$0));     // Catch: Throwable -> L27
        L17:
            r0.iconView.setImageDrawable(r8.icon);     // Catch: Throwable -> L27
            r0.checkBox.setVisibility(8);     // Catch: Throwable -> L27
            if (r0.appSizeView.getVisibility() != 0) goto L24;
            int r4 = PackageManagerSmt.getInstance().getNotchState(DisplayAreaAppsFragment.access$2000(this.this$0), r8.info.packageName);     // Catch: Throwable -> L27
            TextView r9 = r0.appSizeView;     // Catch: Throwable -> L27
            if (r4 != 1) goto L22;
            int r10 = R.string.status_bar_title_adaptive;
        L23:
            r9.setText(r10);     // Catch: Throwable -> L27
            goto L24
        L22:
            r10 = R.string.show_content_below_status_bar;
        L24:
            monitor-exit(r8);     // Catch: Throwable -> L27
            r6.findViewById(R.id.app_layout).setBackgroundResource(R.drawable.horizontal_scroll_app_list_item_bg_selector);
            return r6;
        L27:
            th = move-exception;
            throw th;
        L5:
            if (r6.getTag() == null) goto L8;
            r0 = (ViewHolder) r6.getTag();
            goto L9
        }
    }

    private class ApplicationsAdapter extends AppListAdapter implements StickyListHeadersAdapter, SectionIndexer {
        private final String TAG;
        private AppSessionCallback mAppCallback;
        private PackageManager mPackageManager;
        private boolean mResumed;
        private final ApplicationsState.Session mSession;
        final /* synthetic */ DisplayAreaAppsFragment this$0;

        private class AppSessionCallback implements ApplicationsState.Callbacks {
            final /* synthetic */ ApplicationsAdapter this$1;

            @Override // com.android.settings.applications.ApplicationsState.Callbacks
            public void onRunningStateChanged(boolean r1) {
            }

            private AppSessionCallback(ApplicationsAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ AppSessionCallback(ApplicationsAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // com.android.settings.applications.ApplicationsState.Callbacks
            public void onPackageListChanged() {
                OLog.d("DisplayAreaAppsFragment/AppAdapter", "onPackageListChanged: ");
                this.this$1.rebuild();
            }

            @Override // com.android.settings.applications.ApplicationsState.Callbacks
            public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r1) {
                OLog.d("DisplayAreaAppsFragment/AppAdapter", "onRebuildComplete: ");
            }

            @Override // com.android.settings.applications.ApplicationsState.Callbacks
            public void onPackageIconChanged() {
                this.this$1.notifyDataSetChanged();
            }

            @Override // com.android.settings.applications.ApplicationsState.Callbacks
            public void onPackageSizeChanged(String r2) {
                OLog.d("DisplayAreaAppsFragment/AppAdapter", "onPackageSizeChanged " + r2);
            }

            @Override // com.android.settings.applications.ApplicationsState.Callbacks
            public void onAllSizesComputed() {
                OLog.d("DisplayAreaAppsFragment/AppAdapter", "onAllSizesComputed: ");
            }
        }

        private class HeaderViewHolder {
            OSectionTitleBar headerText;
            final /* synthetic */ ApplicationsAdapter this$1;

            private HeaderViewHolder(ApplicationsAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ HeaderViewHolder(ApplicationsAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        private class LoadAppListTask extends AsyncTask<Void, Void, ArrayList<ApplicationsState.AppEntry>> {
            final /* synthetic */ ApplicationsAdapter this$1;

            private LoadAppListTask(ApplicationsAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ LoadAppListTask(ApplicationsAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ ArrayList<ApplicationsState.AppEntry> doInBackground(Void[] r1) {
                return doInBackground2(r1);
            }

            @Override // android.os.AsyncTask
            protected /* bridge */ /* synthetic */ void onPostExecute(ArrayList<ApplicationsState.AppEntry> r1) {
                onPostExecute2(r1);
            }

            /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
            protected ArrayList<ApplicationsState.AppEntry> doInBackground2(Void... r2) {
                return ApplicationsAdapter.access$1900(this.this$1).rebuild(ApplicationsState.THRID_LAUNCHABLE_APP_FILTER, ApplicationsState.ALPHA_COMPARATOR);
            }

            /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
            protected void onPostExecute2(ArrayList<ApplicationsState.AppEntry> r2) {
                if (this.this$1.this$0.isAdded() == true) goto L5;
                return;
            L5:
                DisplayAreaAppsFragment.access$700(this.this$1.this$0);
                if (r2 == null) goto L13;
                this.this$1.updateAppEntries(r2);
                SearchBar r3 = DisplayAreaAppsFragment.access$000(this.this$1.this$0);
                if (this.this$1.getCount() <= 0) goto L10;
                int r0 = 0;
            L11:
                r3.setVisibility(r0);
                this.this$1.notifyDataSetChanged();
                return;
            L10:
                r0 = 8;
                goto L11
            }
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int r1) {
            return 0;
        }

        static /* synthetic */ ApplicationsState.Session access$1900(ApplicationsAdapter r0) {
            return r0.mSession;
        }

        ApplicationsAdapter(DisplayAreaAppsFragment r1, Context r2, ApplicationsState r3) {
            this.this$0 = r1;
            super(r1, r2);
            this.TAG = "DisplayAreaAppsFragment/AppAdapter";
            this.mAppCallback = new AppSessionCallback(this, null);
            this.mPackageManager = this.mContext.getPackageManager();
            this.mSession = r3.newSession(this.mAppCallback);
        }

        public void resume() {
            if (this.mResumed == true) goto L5;
            this.mResumed = true;
            this.mSession.resume(false);
            rebuild();
            return;
        L5:
            rebuild();
        }

        public void pause() {
            if (this.mResumed == false) goto L6;
            this.mResumed = false;
            this.mSession.pause();
            return;
        }

        public void destroy() {
            this.mSession.release();
        }

        public void rebuild() {
            new LoadAppListTask(this, null).execute(new Void[0]);
        }

        public ArrayList<ApplicationsState.AppEntry> query(String r6) {
            ArrayList<ApplicationsState.AppEntry> r0 = new ArrayList();
            if (TextUtils.isEmpty(r6) == false) goto L5;
        L23:
            return r0;
        L5:
            if (DisplayAreaAppsFragment.access$1400(this.this$0) != null) goto L7;
        L9:
            ArrayList<ApplicationsState.AppEntry> r1 = getAppEntries();
            DisplayAreaAppsFragment.access$1402(this.this$0, null);
            ArrayList<ApplicationsState.AppEntry> r5 = r1;
        L10:
            String r7 = r6.toUpperCase();
            if (r5 == null) goto L23;
            Iterator<ApplicationsState.AppEntry> r8 = r5.iterator();
        L14:
            if (r8.hasNext() == false) goto L23;
            ApplicationsState.AppEntry r2 = r8.next();
            boolean r3 = r2.label.toUpperCase().contains(r7);
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
            if (r6.startsWith(SearchAction.access$1500(DisplayAreaAppsFragment.access$1400(this.this$0))) == false) goto L9;
            r5 = SearchAction.access$1600(DisplayAreaAppsFragment.access$1400(this.this$0));
            goto L10
        }

        private void initSections() {
            DisplayAreaAppsFragment.access$1000(this.this$0).clear();
            DisplayAreaAppsFragment.access$1700(this.this$0).clear();
            ArrayList<ApplicationsState.AppEntry> r0 = getAppEntries();
            OLog.d("DisplayAreaAppsFragment/AppAdapter", "entries size:" + r0.size());
            if (r0.size() <= 0) goto L11;
            char r3 = r0.get(0).mLabelEntry.firstChar;
            String r4 = String.valueOf(r3);
            DisplayAreaAppsFragment.access$1000(this.this$0).add(r4);
            DisplayAreaAppsFragment.access$1700(this.this$0).put(Character.valueOf(r3), 0);
            int r1 = 1;
        L6:
            if (r1 >= r0.size()) goto L11;
            char r5 = r0.get(r1).mLabelEntry.firstChar;
            String r6 = String.valueOf(r5);
            if (r4.equals(r6) == true) goto L10;
            DisplayAreaAppsFragment.access$1000(this.this$0).add(r6);
            DisplayAreaAppsFragment.access$1700(this.this$0).put(Character.valueOf(r5), Integer.valueOf(r1));
            r4 = r6;
        L10:
            r1 = r1 + 1;
        L11:
            OLog.d("DisplayAreaAppsFragment/AppAdapter", "section position map:" + DisplayAreaAppsFragment.access$1700(this.this$0));
        }

        @Override // com.android.settings.DisplayAreaAppsFragment.AppListAdapter
        protected void updateAppEntries(ArrayList<ApplicationsState.AppEntry> r1) {
            super.updateAppEntries(r1);
            initSections();
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return DisplayAreaAppsFragment.access$1000(this.this$0).toArray();
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int r1) {
            Integer r0 = (Integer) DisplayAreaAppsFragment.access$1700(this.this$0).get(Character.valueOf((char) r1));
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.intValue();
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
        L7:
            HeaderViewHolder r6 = new HeaderViewHolder(this, null);
            r4 = this.mLayoutInflater.inflate(R.layout.sticky_list_header_view, null);
            r6.headerText = (OSectionTitleBar) r4.findViewById(R.id.sticky_header);
            r4.setTag(r6);
        L8:
            ArrayList<ApplicationsState.AppEntry> r2 = getAppEntries();
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
            ArrayList<ApplicationsState.AppEntry> r1 = getAppEntries();
            if (r1.get(r2).mLabelEntry != null) goto L7;
            return 35;
        L7:
            return r1.get(r2).mLabelEntry.firstChar;
        }
    }

    private class SearchAction {
        private String keyword;
        private ArrayList<ApplicationsState.AppEntry> searchResult;
        final /* synthetic */ DisplayAreaAppsFragment this$0;

        static /* synthetic */ String access$1500(SearchAction r0) {
            return r0.keyword;
        }

        static /* synthetic */ ArrayList access$1600(SearchAction r0) {
            return r0.searchResult;
        }

        public SearchAction(DisplayAreaAppsFragment r1, String r2, ArrayList<ApplicationsState.AppEntry> r3) {
            this.this$0 = r1;
            this.keyword = r2;
            this.searchResult = r3;
        }
    }

    private class SearchBarCallback extends SearchBar.ListenerAdapter {
        final /* synthetic */ DisplayAreaAppsFragment this$0;

        private SearchBarCallback(DisplayAreaAppsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SearchBarCallback(DisplayAreaAppsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationStart() {
            if (DisplayAreaAppsFragment.access$000(this.this$0).isSearchMode() == false) goto L8;
            ViewGroup r0 = (ViewGroup) DisplayAreaAppsFragment.access$100(this.this$0).getParent();
            if (r0 == null) goto L9;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            r1.height = DisplayAreaAppsFragment.access$100(this.this$0).getHeight() + this.this$0.mTitleView.getHeight();
            r0.setLayoutParams(r1);
            return;
        L9:
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationEnd() {
            if (DisplayAreaAppsFragment.access$000(this.this$0).isSearchMode() == true) goto L8;
            ViewGroup r2 = (ViewGroup) DisplayAreaAppsFragment.access$100(this.this$0).getParent();
            if (r2 == null) goto L9;
            ViewGroup.LayoutParams r0 = r2.getLayoutParams();
            r0.height = -1;
            r2.setLayoutParams(r0);
            return;
        L9:
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void searchText(String r1) {
            DisplayAreaAppsFragment.access$200(this.this$0, r1);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchEdit() {
            if (DisplayAreaAppsFragment.access$000(this.this$0).isPlayingAnimation() == false) goto L5;
            return;
        L5:
            if (DisplayAreaAppsFragment.access$000(this.this$0).isSearchMode() == true) goto L9;
            DisplayAreaAppsFragment.access$300(this.this$0);
            DisplayAreaAppsFragment.access$400(this.this$0);
            DisplayAreaAppsFragment.access$500(this.this$0).restoreScrollState(true);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickCancelButton() {
            if (DisplayAreaAppsFragment.access$000(this.this$0).isPlayingAnimation() == false) goto L5;
            return;
        L5:
            if (DisplayAreaAppsFragment.access$000(this.this$0).isSearchMode() == false) goto L9;
            DisplayAreaAppsFragment.access$600(this.this$0);
            return;
        }
    }

    private void updateNotchState() {
    }

    public void com_android_settings_DisplayAreaAppsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DisplayAreaAppsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DisplayAreaAppsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DisplayAreaAppsFragment() {
        this.mSections = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.mQBListener = new AnonymousClass3(this);
    }

    static /* synthetic */ SearchBar access$000(DisplayAreaAppsFragment r0) {
        return r0.mSearchBar;
    }

    static /* synthetic */ View access$100(DisplayAreaAppsFragment r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ ArrayList access$1000(DisplayAreaAppsFragment r0) {
        return r0.mSections;
    }

    static /* synthetic */ SearchAction access$1400(DisplayAreaAppsFragment r0) {
        return r0.mLastSearch;
    }

    static /* synthetic */ SearchAction access$1402(DisplayAreaAppsFragment r0, SearchAction r1) {
        r0.mLastSearch = r1;
        return r1;
    }

    static /* synthetic */ HashMap access$1700(DisplayAreaAppsFragment r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ void access$200(DisplayAreaAppsFragment r0, String r1) {
        r0.search(r1);
    }

    static /* synthetic */ PackageManager access$2000(DisplayAreaAppsFragment r0) {
        return r0.mPackageManager;
    }

    static /* synthetic */ boolean access$300(DisplayAreaAppsFragment r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ void access$400(DisplayAreaAppsFragment r0) {
        r0.startSearchBeginAnimation();
    }

    static /* synthetic */ StickyListHeadersListView access$500(DisplayAreaAppsFragment r0) {
        return r0.mThirdAppsListView;
    }

    static /* synthetic */ void access$600(DisplayAreaAppsFragment r0) {
        r0.startSearchEndAnimation();
    }

    static /* synthetic */ void access$700(DisplayAreaAppsFragment r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ View access$800(DisplayAreaAppsFragment r0) {
        return r0.mSearchResultView;
    }

    static /* synthetic */ ApplicationsAdapter access$900(DisplayAreaAppsFragment r0) {
        return r0.mThirdAppAdapter;
    }

    private void search(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        this.mSearchListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
        return;
    L6:
        this.mSearchListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        ArrayList<ApplicationsState.AppEntry> r0 = this.mThirdAppAdapter.query(r3);
        this.mLastSearch = new SearchAction(this, r3, r0);
        if (this.mSearchAdapter != null) goto L9;
        AppListAdapter r4 = new AppListAdapter(this, this._mActivity);
        this.mSearchAdapter = r4;
        this.mSearchListView.setAdapter(r4);
    L9:
        this.mSearchAdapter.updateAppEntries(r0);
        notifyAdapterDataChanged();
    }

    private void startSearchBeginAnimation() {
        if (this.mStartSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, (-this.mTitleView.getHeight()) - 1})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mStartSearchAnim = r3;
        r3.setDuration(300);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mStartSearchAnim.addListener(new AnonymousClass1(this));
    L5:
        this.mStartSearchAnim.start();
    }

    private void startSearchEndAnimation() {
        if (this.mEndSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(-this.mTitleView.getHeight()) - 1, 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mEndSearchAnim = r3;
        r3.setDuration(300);
        this.mEndSearchAnim.setStartDelay(10);
        this.mEndSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mEndSearchAnim.addListener(new AnonymousClass2(this));
    L5:
        this.mEndSearchAnim.start();
    }

    private boolean resetQuickBarState() {
        if (this.mQuickBar.isLetterGridShow() == false) goto L6;
        this.mQuickBar.hideLetterGrid(true);
        return true;
    L6:
        return false;
    }

    private void setQuickBarVisibility() {
        if (this.mQuickBar == null) goto L18;
        ApplicationsAdapter r0 = this.mThirdAppAdapter;
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
        if (r0.getCount() <= 0) goto L11;
        if (this.mSearchBar.isSearchMode() == true) goto L11;
        r2 = true;
        goto L12
    }

    private void notifyAdapterDataChanged() {
        if (this.mSearchBar.isSearchMode() == false) goto L5;
        AppListAdapter r1 = this.mSearchAdapter;
    L6:
        if (r1 == null) goto L9;
        r1.notifyDataSetChanged();
        return;
    L9:
        return;
    L5:
        r1 = this.mThirdAppAdapter;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.display_area_apps_fragment_layout, r4, false);
        this.mWholeView = findViewByIdNullable(R.id.whole_view);
        this.mThirdAppsListView = (StickyListHeadersListView) findViewByIdNullable(R.id.id_app_list);
        TextView r6 = (TextView) findViewByIdNullable(R.id.view_empty);
        ApplicationsState r7 = ApplicationsState.getInstance(getApplication(), false);
        ApplicationsAdapter r8 = new ApplicationsAdapter(this, this.mContext, r7);
        this.mThirdAppAdapter = r8;
        this.mThirdAppsListView.setAdapter(r8);
        this.mThirdAppsListView.setEmptyView(r6);
        this.mThirdAppsListView.setHorizontalScrollEnabled(false);
        this.mThirdAppsListView.setOnItemClickListener(this);
        this.mThirdAppsListView.addFooterView(Utils.inflateListTransparentFooterOnlyExtra(this._mActivity, null, false));
        ListView r9 = (ListView) findViewByIdNullable(R.id.search_listview);
        this.mSearchListView = r9;
        r9.setOnItemClickListener(this);
        this.mSearchEmptyView = findViewByIdNullable(R.id.search_empty_view);
        this.mSearchResultView = findViewByIdNullable(R.id.seachresultview);
        SearchBar r10 = (SearchBar) findViewByIdNullable(R.id.id_search_bar);
        this.mSearchBar = r10;
        r10.setListener(new SearchBarCallback(this, null));
        TextView r11 = (TextView) findViewByIdNullable(R.id.searchview_bg);
        this.mSearchBackground = r11;
        r11.setOnClickListener(new AnonymousClass4(this));
        QuickBarEx r12 = (QuickBarEx) findViewByIdNullable(R.id.quickbar);
        this.mQuickBar = r12;
        r12.setLongPressEnabled(false);
        this.mQuickBar.setQBListener(this.mQBListener);
        this.mQuickBar.setPoundVisibility(true);
        this.mQuickBar.setPoundPosition(1);
        this.mQuickBar.initLetters();
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mQuickBar);
        this.mIPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
        this.mPackageManager = getPackageManager();
        return this.mRootView;
    }

    public void com_android_settings_DisplayAreaAppsFragment__onResume$___twin___() {
        super.onResume();
        this.mThirdAppAdapter.resume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mThirdAppAdapter.pause();
        updateNotchState();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mThirdAppAdapter.destroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        if (this.mSearchBar.isPlayingAnimation() == false) goto L5;
        return;
    L5:
        startDisplayAreaSetting((ApplicationsState.AppEntry) r1.getItemAtPosition(r3));
        Utils.hideInputMethod(this._mActivity);
    }

    private void startDisplayAreaSetting(ApplicationsState.AppEntry r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.info == null) goto L9;
        DisplayAreaSettingsFragment r0 = new DisplayAreaSettingsFragment();
        Bundle r1 = new Bundle();
        r1.putString("pkg", r5.info.packageName);
        r1.putString("label", r5.label);
        start(r0, r1);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DisplayAreaAppsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DisplayAreaAppsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DisplayAreaAppsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DisplayAreaAppsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DisplayAreaAppsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DisplayAreaAppsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DisplayAreaAppsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DisplayAreaAppsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DisplayAreaAppsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
