package com.android.settings.applock.view;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import bytedanceos.util.NavigationBarHelper;
import com.android.settings.Utils;
import com.android.settings.applock.data.AppEntry;
import com.android.settings.applock.data.AppLockListInfo;
import com.android.settings.applock.data.SwitchAdapter;
import com.android.settings.applock.event.AppStateChangeEvent;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.HorizontalScrollListView;
import com.android.settings.widget.SearchBarSmt;
import com.android.settings.widget.SlideListView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.QuickBar;
import obric.widget.letters.QuickBarEx;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class AppLockListFragment extends BaseFragment implements SearchBarSmt.Listener, SlideListView.Listener {
    private static final int ANIM_DURATION = 200;
    private static final int ANIM_START_DELAY = 10;
    private static final String SWITCH_ADAPT_DEF_TYPE = "layout";
    private static final String SWITCH_ADAPT_NAME = "simple_list_item_2";
    private static final String SWITCH_ADAPT_PACKAGE_NAME = "android";
    private static final String TAG = "AppLockListFragment";
    private static int sCurrentSortMode = 2;
    private String lastQueryText;
    private SwitchAdapter mAdapter;
    private View mEmptyView;
    private AnimatorSet mEndSearchAnim;
    private boolean mIsEdit;
    private SlideListView mListView;
    private boolean mNeedFinish;
    private QuickBarEx.QBListener mQbListener;
    private QuickBarEx mQuickBar;
    private int mResId;
    private SwitchAdapter mSearchAdapter;
    private TextView mSearchBackground;
    private SearchBarSmt mSearchBar;
    private View mSearchEmptyView;
    private HorizontalScrollListView mSearchResultListView;
    private View mSearchResultView;
    private ArrayList<AppEntry> mSelectedInfos;
    private AnimatorSet mStartSearchAnim;
    private int mTitleBarHeight;
    private View mWholeView;

    static {
    }

    public void com_android_settings_applock_view_AppLockListFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applock_view_AppLockListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applock_view_AppLockListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AppLockListFragment() {
        this.mAdapter = null;
        this.mIsEdit = false;
        this.lastQueryText = "";
        this.mSelectedInfos = new ArrayList();
        this.mQbListener = new AnonymousClass2(this);
    }

    static /* synthetic */ void access$000(AppLockListFragment r0) {
        r0.hideIME();
    }

    static /* synthetic */ SlideListView access$100(AppLockListFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ SwitchAdapter access$200(AppLockListFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ void access$300(AppLockListFragment r0) {
        r0.resetQuickBarState();
    }

    static /* synthetic */ void access$400(AppLockListFragment r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ View access$500(AppLockListFragment r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ int access$600(AppLockListFragment r0) {
        return r0.mTitleBarHeight;
    }

    static /* synthetic */ View access$700(AppLockListFragment r0) {
        return r0.mSearchResultView;
    }

    public void com_android_settings_applock_view_AppLockListFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        EventBus.getDefault().register(this);
        this.mNeedFinish = true;
        this.mResId = Utils.getResouceId("android", SWITCH_ADAPT_NAME, SWITCH_ADAPT_DEF_TYPE, R.layout.simple_list_item_2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(com.android.settings.R.layout.app_lock_list, r3, false);
        initView();
        return this.mRootView;
    }

    private void initView() {
        this.mWholeView = NullSafe.nonNull(this.mRootView.findViewById(com.android.settings.R.id.whole_view));
        SearchBarSmt r0 = (SearchBarSmt) NullSafe.nonNull(this.mRootView.findViewById(com.android.settings.R.id.applock_search_bar));
        this.mSearchBar = r0;
        r0.setListener(this);
        this.mSearchBar.setFilterMode(1);
        this.mSearchResultView = NullSafe.nonNull(findViewByIdNullable(com.android.settings.R.id.seachresultview));
        QuickBarEx r2 = (QuickBarEx) NullSafe.nonNull(this.mRootView.findViewById(com.android.settings.R.id.quickbar));
        this.mQuickBar = r2;
        r2.setLongPressEnabled(false);
        this.mQuickBar.setQBListener(this.mQbListener);
        this.mQuickBar.setPoundVisibility(true);
        this.mQuickBar.setPoundPosition(QuickBar.POUND_POSITION_TOP);
        this.mQuickBar.initLetters();
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mQuickBar);
        this.mEmptyView = NullSafe.nonNull(this.mRootView.findViewById(com.android.settings.R.id.view_empty));
        SlideListView r3 = (SlideListView) NullSafe.nonNull(this.mRootView.findViewById(com.android.settings.R.id.listView));
        this.mListView = r3;
        r3.setAreHeadersSticky(true);
        this.mListView.setSlideListener(this);
        SwitchAdapter r1 = new SwitchAdapter(this.mContext, this.mResId);
        this.mAdapter = r1;
        r1.setInSearchMode(false);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnTouchListener(new AppLockListFragment$$ExternalSyntheticLambda2(this));
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mListView);
        this.mSearchResultView = NullSafe.nonNull(findViewByIdNullable(com.android.settings.R.id.seachresultview));
        this.mSearchResultListView = (HorizontalScrollListView) NullSafe.nonNull(findViewByIdNullable(com.android.settings.R.id.search_listview));
        this.mSearchEmptyView = NullSafe.nonNull(findViewByIdNullable(com.android.settings.R.id.search_empty_view));
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass1(this));
        TextView r4 = (TextView) NullSafe.nonNull(findViewByIdNullable(com.android.settings.R.id.searchview_bg));
        this.mSearchBackground = r4;
        r4.setOnClickListener(new AppLockListFragment$$ExternalSyntheticLambda3(this));
        initData();
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-android-settings-applock-view-AppLockListFragment, reason: not valid java name */
    /* synthetic */ boolean m322x70058fed(View r1, MotionEvent r2) {
        if (this.mQuickBar.isPerformingAnim() == false) goto L7;
        return !this.mIsEdit;
    L7:
        if (this.mQuickBar.isLetterGridShow() == false) goto L10;
        this.mQuickBar.hideLetterGrid();
        return !this.mIsEdit;
    L10:
        return false;
    }

    /* JADX INFO: renamed from: lambda$initView$1$com-android-settings-applock-view-AppLockListFragment, reason: not valid java name */
    /* synthetic */ void m323x9959e52e(View r1) {
        cancelSearch();
    }

    private void initData() {
        ArrayList<AppEntry> r0 = AppLockListInfo.newInstance(this.mContext).getAppEntries();
        if (r0 != null) goto L5;
    L7:
        AppLockListInfo.newInstance(this.mContext).setApplockCallback(new AppLockListFragment$$ExternalSyntheticLambda1(this));
        return;
    L5:
        if (r0.isEmpty() == true) goto L7;
        this.mAdapter.setData(r0, true);
        setQuickBarVisibility();
    }

    /* JADX INFO: renamed from: lambda$initData$3$com-android-settings-applock-view-AppLockListFragment, reason: not valid java name */
    /* synthetic */ void m321x13b71b5(final ArrayList r3) {
        if (this.mAdapter != null) goto L5;
        return;
    L5:
        if (this.mListView == null) goto L9;
        getActivity().runOnUiThread(new AppLockListFragment$$ExternalSyntheticLambda0(this, r3));
        return;
    }

    /* JADX INFO: renamed from: lambda$initData$2$com-android-settings-applock-view-AppLockListFragment, reason: not valid java name */
    /* synthetic */ void m320xd7e71c74(ArrayList r3) {
        this.mAdapter.setData(r3, true);
        setQuickBarVisibility();
    }

    private void hideIME() {
        Utils.hideInputMethod(this._mActivity);
    }

    private void cancelSearch() {
        this.mSearchBar.cancelSearch();
    }

    @Override // com.android.settings.widget.SearchBarSmt.Listener
    public boolean onModeChange(int r3) {
        ArrayList<AppEntry> r0 = AppLockListInfo.newInstance(this.mContext).getAppEntries();
        sCurrentSortMode = r3;
        this.mAdapter.setCurrentSortMode(r3);
        this.mAdapter.setData(r0, true);
        setQuickBarVisibility();
        return true;
    }

    @Override // com.android.settings.widget.SearchBarSmt.Listener
    public void startSearchAnimation() {
        initStartSearchAnimation();
    }

    @Override // com.android.settings.widget.SearchBarSmt.Listener
    public void endSearchAnimation() {
        startEndSearchAnimation();
        resetOkButton();
        this.mAdapter.setInSearchMode(false);
    }

    @Override // com.android.settings.widget.SearchBarSmt.Listener
    public void onQueryTextChange(String r1) {
        search(r1);
        this.mAdapter.setInSearchMode(true);
    }

    @Override // com.android.settings.widget.SearchBarSmt.Listener
    public void hideQuickContactView() {
        resetQuickBarState();
    }

    @Override // com.android.settings.widget.SearchBarSmt.Listener
    public void recoverQuickBar() {
        this.mQuickBar.hideLetterGrid();
    }

    @Override // com.android.settings.widget.SlideListView.Listener
    public void setChecked(int r2, boolean r3) {
        if (r2 < this.mListView.getHeaderViewsCount()) goto L8;
        setCheckedInternal(r2 - this.mListView.getHeaderViewsCount(), r3);
        int r4 = r2 - this.mListView.getFirstVisiblePosition();
        View r1 = this.mListView.getWrappedList().getChildAt(r4);
        if (r1 == null) goto L9;
        ((CheckBox) NullSafe.nonNull(r1.findViewById(com.android.settings.R.id.checkBox))).setChecked(r3);
        return;
    L9:
        return;
    }

    @Override // com.android.settings.widget.SlideListView.Listener
    public boolean isChecked(int r2) {
        if (this.mSearchBar.isInSearchMode() == false) goto L5;
        AppEntry r3 = this.mSearchAdapter.getItem(r2);
    L7:
        return this.mSelectedInfos.contains(r3);
    L5:
        r3 = this.mAdapter.getItem(r2);
        goto L7
    }

    private void setCheckedInternal(int r2, boolean r3) {
        if (this.mSearchBar.isInSearchMode() == false) goto L11;
        SwitchAdapter r0 = this.mSearchAdapter;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getCount() <= 0) goto L19;
        AppEntry r4 = this.mSearchAdapter.getItem(r2);
    L12:
        if (r3 == true) goto L14;
        this.mSelectedInfos.remove(r4);
    L17:
        recoverQuickBar();
        return;
    L14:
        if (this.mSelectedInfos.contains(r4) == true) goto L17;
        this.mSelectedInfos.add(r4);
        goto L17
    L19:
        return;
    L11:
        r4 = this.mAdapter.getItem(r2);
        goto L12
    }

    private void search(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.trim().equals(this.lastQueryText) == true) goto L21;
        this.lastQueryText = r5.trim();
        if (TextUtils.isEmpty(r5) == true) goto L9;
    L13:
        this.mListView.setEmptyView(null);
        this.mSearchResultListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        ArrayList<AppEntry> r6 = this.mAdapter.query(r5);
        if (this.mSearchAdapter != null) goto L16;
        SwitchAdapter r0 = new SwitchAdapter(this.mContext, this.mResId);
        this.mSearchAdapter = r0;
        this.mSearchResultListView.setAdapter(r0);
    L16:
        this.mSearchAdapter.setData(r6, false);
        return;
    L9:
        if (this.mSearchBar.isInSearchMode() == false) goto L13;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
        if (this.mAdapter.getCount() > 0) goto L19;
        this.mListView.setEmptyView(this.mEmptyView);
        return;
    L19:
        return;
    }

    private void initStartSearchAnimation() {
        if (this.mStartSearchAnim != null) goto L5;
        this.mTitleBarHeight = this.mTitleView.getHeight() + 2;
        Utils.setAnimatorScale(this.mContext);
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, -this.mTitleBarHeight})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mStartSearchAnim = r3;
        r3.setDuration(200);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mStartSearchAnim.addListener(new AnonymousClass3(this));
    L5:
        this.mStartSearchAnim.start();
    }

    private void resetQuickBarState() {
        if (this.mQuickBar.isLetterGridShow() == false) goto L6;
        this.mQuickBar.hideLetterGrid(true);
        return;
    }

    private void setQuickBarVisibility() {
        if (this.mQuickBar == null) goto L18;
        int r1 = 0;
        if (this.mAdapter != null) goto L7;
    L11:
        boolean r0 = false;
    L12:
        QuickBarEx r3 = this.mQuickBar;
        if (r0 == true) goto L16;
        r1 = 8;
    L16:
        r3.setVisibility(r1);
        return;
    L7:
        if (this.mSearchBar.isInSearchMode() == true) goto L11;
        if (sCurrentSortMode != 2) goto L11;
        r0 = true;
        goto L12
    }

    private void startEndSearchAnimation() {
        if (this.mEndSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{-this.mTitleBarHeight, 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mEndSearchAnim = r3;
        r3.setDuration(200);
        this.mEndSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mEndSearchAnim.addListener(new AnonymousClass4(this));
    L5:
        this.mEndSearchAnim.start();
    }

    private void resetOkButton() {
        if (this.mAdapter.isEmpty() == true) goto L6;
        setQuickBarVisibility();
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAppStateChange(AppStateChangeEvent r3) {
        ArrayList<AppEntry> r4 = AppLockListInfo.newInstance(this.mContext).getAppEntries();
        this.mAdapter.setData(r4, true);
        setQuickBarVisibility();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AppLockListInfo.newInstance(this.mContext).setApplockCallback(null);
        EventBus.getDefault().unregister(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNeedFinish == false) goto L6;
        Utils.finishActivityDelay(getActivity());
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applock_view_AppLockListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AppLockListFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applock_view_AppLockListFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_AppLockListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AppLockListFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applock_view_AppLockListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_AppLockListFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AppLockListFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applock_view_AppLockListFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
