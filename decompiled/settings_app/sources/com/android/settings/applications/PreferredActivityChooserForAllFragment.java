package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import bytedanceos.util.SettingsUtil;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.api.OnSettingsItemClickListener;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.SectionComparator2;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredActivityChooserForAllFragment extends BaseFragment {
    private boolean isEnterFinished;
    private PreferredSettingsUtils.Category mCategory;
    private PreferredActivityChooseUtils mChooseUtils;
    private Comparator mComparator;
    private RelativeLayout mEmptyRelativeLayout;
    private List<PreferredSettingsUtils.FileType> mFileTypes;
    OnSettingsItemClickListener mItemClickListener;
    private LoadDataAsyncTask mLoadDataAsyncTask;
    private View mLoadingView;
    private PackageManager mPm;
    private ComponentName mPreferredComponent;
    private PreferredActivityAdapter mSeeAdapter;
    private LinearLayout mSeeLinearLayout;
    private ExtendListView mSeeListView;
    private List<ResolveInfo> mSeeSendResolveInfoList;
    private List<ResolveListItem> resolveListItems;

    public static class ExtendListView extends ListView {
        public ExtendListView(Context r1) {
            super(r1);
        }

        public ExtendListView(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public ExtendListView(Context r1, AttributeSet r2, int r3) {
            super(r1, r2, r3);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
        protected void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        }
    }

    static class LoadDataAsyncTask extends AsyncTask<Void, Integer, List<PreferredSettingsUtils.FileType>> {
        private WeakReference<PreferredActivityChooserForAllFragment> weakReference;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ List<PreferredSettingsUtils.FileType> doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(List<PreferredSettingsUtils.FileType> r1) {
            onPostExecute2(r1);
        }

        public LoadDataAsyncTask(PreferredActivityChooserForAllFragment r2) {
            this.weakReference = new WeakReference(r2);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected List<PreferredSettingsUtils.FileType> doInBackground2(Void... r1) {
            if (this.weakReference.get() != null) goto L5;
            return null;
        L5:
            if (isCancelled() == false) goto L7;
            return null;
        L7:
            return PreferredActivityChooserForAllFragment.access$700(this.weakReference.get());
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(List<PreferredSettingsUtils.FileType> r2) {
            super.onPostExecute(r2);
            if (this.weakReference.get() == null) goto L6;
            PreferredActivityChooserForAllFragment.access$800(this.weakReference.get(), r2);
            return;
        }
    }

    class PreferredActivityAdapter extends SettingsAdapter {
        private OnSettingsItemClickListener mClickListener;
        private Context mContext;
        private List<ResolveListItem> mResolveListItems;
        private boolean mShowSummary;
        final /* synthetic */ PreferredActivityChooserForAllFragment this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        static /* synthetic */ OnSettingsItemClickListener access$100(PreferredActivityAdapter r0) {
            return r0.mClickListener;
        }

        public PreferredActivityAdapter(PreferredActivityChooserForAllFragment r1, Context r2, boolean r3, OnSettingsItemClickListener r4) {
            this.this$0 = r1;
            this.mResolveListItems = new ArrayList();
            this.mContext = r2;
            this.mShowSummary = r3;
            this.mClickListener = r4;
        }

        public void setData(List<ResolveListItem> r1) {
            this.mResolveListItems = r1;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return this.mResolveListItems.size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(final int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
            r3 = View.inflate(this.this$0.getActivity(), R.layout.settings_oui_card_list_item_with_icon, null);
            final OCardListItem r5 = (OCardListItem) r3.findViewById(R.id.card_list_item);
            r3.setTag(r5);
        L5:
            OCardListItemUtils.initCardItemInAdapter(this, r5, r2);
            ResolveListItem r0 = this.mResolveListItems.get(r2);
            bindTitleAndSummary(r5, r0);
            setCheckedIcon(r5, r0);
            r5.setOnContentClickListener(new AnonymousClass1(this, r5, r2));
            return r3;
        L4:
            r5 = (OCardListItem) r3.getTag();
            goto L5
        }

        private void bindTitleAndSummary(OCardListItem r1, ResolveListItem r2) {
            if (r2.summary != null) goto L5;
        L7:
            OCardListItemUtils.setTitle(r1, r2.title);
            return;
        L5:
            if (r2.summary.isEmpty() == true) goto L7;
            OCardListItemUtils.setTitle(r1, r2.summary);
        }

        private void setCheckedIcon(OCardListItem r5, ResolveListItem r6) {
            if (r6.icon == null) goto L5;
            OCardListItemUtils.setIcon(r5, r6.icon);
        L5:
            ResolveInfo r7 = r6.resolveInfo;
            if (PreferredActivityChooserForAllFragment.access$200(this.this$0) != null) goto L8;
        L17:
            r5.showCustomEnd(true);
            OCardListItemUtils.setMark(r5, false);
            return;
        L8:
            if (r7.activityInfo == null) goto L17;
            if (PreferredActivityChooserForAllFragment.access$200(this.this$0).getPackageName().equals(r7.activityInfo.packageName) == true) goto L13;
        L15:
            r5.showCustomEnd(true);
            OCardListItemUtils.setMark(r5, false);
            return;
        L13:
            if (PreferredActivityChooserForAllFragment.access$200(this.this$0).getClassName().contains(r7.activityInfo.name) == false) goto L15;
            r5.showCustomEnd(true);
            OCardListItemUtils.setMark(r5, true);
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r4) {
            ResolveInfo r0 = this.mResolveListItems.get(r4).resolveInfo;
            boolean r1 = SettingsUtil.isAccessibilityEnabled(this.mContext);
            if (r0.activityInfo.packageName.equals("com.bytedanceos.launcher") == false) goto L8;
            if (r1 == false) goto L8;
            return false;
        L8:
            return super.isEnabled(r4);
        }
    }

    private static class ResolveListItem {
        public Drawable icon;
        public ResolveInfo resolveInfo;
        public String summary;
        public String title;
        public String titlePinyin;

        private ResolveListItem() {
        }

        /* synthetic */ ResolveListItem(AnonymousClass1 r1) {
            this();
        }

        public String getTitle() {
            return this.titlePinyin;
        }
    }

    public void com_android_settings_applications_PreferredActivityChooserForAllFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_PreferredActivityChooserForAllFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_PreferredActivityChooserForAllFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.base.BaseFragment
    protected boolean shouldMonitorExtDisplayStatus() {
        return true;
    }

    public PreferredActivityChooserForAllFragment() {
        this.mSeeSendResolveInfoList = new ArrayList();
        this.resolveListItems = new ArrayList();
        this.mComparator = new SectionComparator2();
        this.isEnterFinished = false;
        this.mFileTypes = null;
        this.mItemClickListener = new AnonymousClass1(this);
    }

    static /* synthetic */ ComponentName access$200(PreferredActivityChooserForAllFragment r0) {
        return r0.mPreferredComponent;
    }

    static /* synthetic */ ExtendListView access$300(PreferredActivityChooserForAllFragment r0) {
        return r0.mSeeListView;
    }

    static /* synthetic */ List access$400(PreferredActivityChooserForAllFragment r0) {
        return r0.resolveListItems;
    }

    static /* synthetic */ void access$500(PreferredActivityChooserForAllFragment r0, List r1) {
        r0.setAllMimeTypes(r1);
    }

    static /* synthetic */ LoadDataAsyncTask access$600(PreferredActivityChooserForAllFragment r0) {
        return r0.mLoadDataAsyncTask;
    }

    static /* synthetic */ LoadDataAsyncTask access$602(PreferredActivityChooserForAllFragment r0, LoadDataAsyncTask r1) {
        r0.mLoadDataAsyncTask = r1;
        return r1;
    }

    static /* synthetic */ List access$700(PreferredActivityChooserForAllFragment r0) {
        return r0.getResolveInfoByIntentFilter();
    }

    static /* synthetic */ void access$800(PreferredActivityChooserForAllFragment r0, List r1) {
        r0.updateFileTypes(r1);
    }

    @Override // com.android.settings.base.BaseFragment
    protected void onExtDisplayChanged(boolean r1) {
        if (r1 == false) goto L5;
        finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fragment_preferred_all_choooser, r3, false);
        this.mEmptyRelativeLayout = (RelativeLayout) findViewByIdNullable(R.id.preferred_empty);
        this.mSeeLinearLayout = (LinearLayout) findViewByIdNullable(R.id.ll_see_list);
        this.mSeeListView = (ExtendListView) findViewByIdNullable(R.id.see_list);
        View r5 = findViewByIdNullable(R.id.view_empty);
        this.mLoadingView = r5;
        r5.setVisibility(0);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mRootView.findViewById(R.id.page_container));
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mSeeListView.setAdapter(this.mSeeAdapter);
    }

    public void com_android_settings_applications_PreferredActivityChooserForAllFragment__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        this.mSeeAdapter = new PreferredActivityAdapter(this, getActivity(), true, this.mItemClickListener);
        this.mCategory = (PreferredSettingsUtils.Category) r7.getSerializable("category");     // Catch: Exception -> L5
    L11:
        if (this.mCategory == null) goto L13;
        this.mPm = getPackageManager();
        this.mChooseUtils = new PreferredActivityChooseUtils(this.mContext);
        this.mPreferredComponent = (ComponentName) r7.getParcelable(PreferredSettingsUtils.INTENT_EXTRA_SELECT_PREFERRED_PKG);
        LoadDataAsyncTask r8 = new LoadDataAsyncTask(this);
        this.mLoadDataAsyncTask = r8;
        r8.execute(new Void[0]);
        return;
    L13:
        finish();
        return;
    L5:
        e = move-exception;
        if (r7.getString("category") == null) goto L9;
        this.mCategory = PreferredSettingsUtils.Category.valueOf(r7.getString("category"));
        goto L11
    L9:
        OLog.e(this.TAG, "onCreate getCategory failed, e=" + e);
        goto L11
    }

    private void refreshUiIfNeeded() {
        OLog.i(this.TAG, "refreshUiIfNeeded start resolveListItems.sz=" + this.resolveListItems.size());
        if (this.resolveListItems.isEmpty() == false) goto L5;
        this.mEmptyRelativeLayout.setVisibility(0);
        this.mSeeLinearLayout.setVisibility(8);
    L7:
        if (this.resolveListItems.isEmpty() == true) goto L9;
        this.mSeeAdapter.setData(new ArrayList(this.resolveListItems));
        this.mSeeAdapter.notifyDataSetChanged();
    L9:
        this.mLoadingView.setVisibility(8);
        return;
    L5:
        this.mEmptyRelativeLayout.setVisibility(8);
        this.mSeeLinearLayout.setVisibility(0);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LoadDataAsyncTask r0 = this.mLoadDataAsyncTask;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.mLoadDataAsyncTask = null;
        return;
    }

    private List<PreferredSettingsUtils.FileType> getResolveInfoByIntentFilter() {
        long r0 = System.currentTimeMillis();
        OLog.i(this.TAG, "getResolveInfoByIntentFilter start");
        List<PreferredSettingsUtils.FileType> r2 = PreferredSettingsUtils.getFileType(this.mContext, this.mCategory, this.mChooseUtils);
        OLog.i(this.TAG, "getResolveInfoByIntentFilter getFileType " + (System.currentTimeMillis() - r0));
        updatePreferredActivity1(r2);
        OLog.i(this.TAG, "getResolveInfoByIntentFilter updatePreferredActivity1 " + (System.currentTimeMillis() - r0));
        Map<String, List<ResolveInfo>> r3 = PreferredSettingsUtils.loadSeeAndSendResolveInfoMap(this.mCategory, r2, this.mChooseUtils);
        OLog.i(this.TAG, "getResolveInfoByIntentFilter loadSeeAndSendResolveInfoMap " + (System.currentTimeMillis() - r0));
        List<ResolveInfo> r4 = r3.get("android.intent.action.VIEW");
        List<ResolveInfo> r5 = r3.get("android.intent.action.SEND");
        this.mSeeSendResolveInfoList.clear();
        if (r4 == null) goto L5;
        this.mSeeSendResolveInfoList.addAll(r4);
    L5:
        if (r5 == null) goto L7;
        this.mSeeSendResolveInfoList.addAll(r5);
    L7:
        this.mSeeSendResolveInfoList = (List) this.mSeeSendResolveInfoList.stream().filter(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda6()).filter(PreferredSettingsUtils.distinctByKey(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda7())).collect(Collectors.toList());
        OLog.i(this.TAG, "getResolveInfoByIntentFilter addAll " + (System.currentTimeMillis() - r0));
        this.resolveListItems.clear();
        int r6 = this.mSeeSendResolveInfoList.size();
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L13;
        ResolveListItem r8 = new ResolveListItem(null);
        ResolveInfo r9 = this.mSeeSendResolveInfoList.get(r7);
        r8.resolveInfo = r9;
        r8.title = r9.activityInfo.applicationInfo.loadLabel(this.mPm).toString();
        r8.titlePinyin = ApplicationLabelUtils.loadLabelPinyin(this.mContext, r8.title);
        CharSequence r10 = r9.loadLabel(this.mPm);
        if (r10 == null) goto L12;
        r8.summary = r10.toString().replaceAll("\\p{C}", "").replaceAll("\\p{Z}", HanziToPinyin.Token.SEPARATOR).trim();
    L12:
        r8.icon = ObricIconUtils.getDrawable(r9.activityInfo.packageName);
        this.resolveListItems.add(r8);
        r7 = r7 + 1;
        goto L8
    L13:
        this.resolveListItems.sort(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda8(this));
        OLog.i(this.TAG, "getResolveInfoByIntentFilter end " + (System.currentTimeMillis() - r0));
        return r2;
    }

    static /* synthetic */ boolean lambda$getResolveInfoByIntentFilter$0(ResolveInfo r1) {
        if (r1 != null) goto L4;
    L10:
        return false;
    L4:
        if (r1.activityInfo == null) goto L10;
        if (TextUtils.isEmpty(r1.activityInfo.packageName) == true) goto L10;
        if (TextUtils.isEmpty(r1.activityInfo.name) == true) goto L10;
        return true;
    }

    static /* synthetic */ Object lambda$getResolveInfoByIntentFilter$1(ResolveInfo r2) {
        return r2.activityInfo.packageName + r2.activityInfo.name;
    }

    /* JADX INFO: renamed from: lambda$getResolveInfoByIntentFilter$2$com-android-settings-applications-PreferredActivityChooserForAllFragment, reason: not valid java name */
    /* synthetic */ int m306xab1a82e7(ResolveListItem r1, ResolveListItem r2) {
        return this.mComparator.compare(r1.getTitle(), r2.getTitle());
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        LoadDataAsyncTask r3 = this.mLoadDataAsyncTask;
        if (r3 == null) goto L5;
        r3.cancel(true);
        this.mLoadDataAsyncTask = null;
    L5:
        LoadDataAsyncTask r4 = new LoadDataAsyncTask(this);
        this.mLoadDataAsyncTask = r4;
        r4.execute(new Void[0]);
    }

    private void setAllMimeTypes(final List<ResolveInfo> r5) {
        final AtomicInteger r0 = new AtomicInteger(0);
        final AtomicInteger r2 = new AtomicInteger(0);
        this.mFileTypes.stream().filter(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda3()).forEach(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda4(this, r5, r2, r0));
    }

    static /* synthetic */ boolean lambda$setAllMimeTypes$3(PreferredSettingsUtils.FileType r0) {
        return !TextUtils.isEmpty(r0.getMimeType());
    }

    /* JADX INFO: renamed from: lambda$setAllMimeTypes$5$com-android-settings-applications-PreferredActivityChooserForAllFragment, reason: not valid java name */
    /* synthetic */ void m307xf0073307(List r4, AtomicInteger r5, AtomicInteger r6, PreferredSettingsUtils.FileType r7) {
        List r0 = new ArrayList();
        if (r7.getMimeType().contains(";") == false) goto L6;
        r0 = (List) Stream.of(r7.getMimeType().split(";")).map(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda5()).collect(Collectors.toList());
    L9:
        Iterator r8 = r0.iterator();
        boolean r1 = false;
    L11:
        if (r8.hasNext() == false) goto L15;
        if (addPreferredActivityForChooserAll((IntentFilter) r8.next(), r4) == false) goto L11;
        r1 = true;
        goto L11
    L15:
        if (r1 == false) goto L17;
        r5.getAndIncrement();
        return;
    L17:
        r6.getAndIncrement();
        return;
    L6:
        if (r7.getIntentFilter() == null) goto L8;
        r0.add(r7.getIntentFilter());
        goto L9
    L8:
        r0.add(PreferredSettingsUtils.getIntentFilterForType(r7.getMimeType()));
        goto L9
    }

    static /* synthetic */ IntentFilter lambda$setAllMimeTypes$4(String r0) {
        return PreferredSettingsUtils.getIntentFilterForType(r0);
    }

    private boolean addPreferredActivityForChooserAll(IntentFilter r5, List<ResolveInfo> r6) {
        Iterator<ResolveInfo> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        ResolveInfo r0 = r7.next();
        ComponentName r2 = new ComponentName(r0.activityInfo.packageName, r0.activityInfo.name);
        if (PreferredSettingsUtils.addPreferredActivity(r5, this.mChooseUtils, this.mPm, false, r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private void updatePreferredActivity1(List<PreferredSettingsUtils.FileType> r4) {
        if (this.mCategory != PreferredSettingsUtils.Category.others) goto L5;
        return;
    L5:
        if (this.mContext != null) goto L7;
        return;
    L7:
        if (isAdded() == true) goto L9;
        return;
    L9:
        if (r4.isEmpty() == true) goto L22;
        List r0 = (List) r4.stream().filter(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda1()).filter(PreferredSettingsUtils.distinctByKey(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda2())).collect(Collectors.toList());
        if (r0.isEmpty() == false) goto L15;
        return;
    L15:
        if (r0.size() <= 1) goto L17;
        return;
    L17:
        updatePreferredActivity2(r4, ((PreferredSettingsUtils.FileType) r0.get(0)).getComponentName().getPackageName());
        return;
    }

    static /* synthetic */ boolean lambda$updatePreferredActivity1$6(PreferredSettingsUtils.FileType r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.getComponentName() == null) goto L6;
        return true;
    }

    static /* synthetic */ Object lambda$updatePreferredActivity1$7(PreferredSettingsUtils.FileType r0) {
        return r0.getComponentName().getPackageName();
    }

    private void updatePreferredActivity2(List<PreferredSettingsUtils.FileType> r6, String r7) {
        StringBuffer r0 = new StringBuffer();
        ArrayList r1 = new ArrayList();
        Iterator<PreferredSettingsUtils.FileType> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        PreferredSettingsUtils.FileType r2 = r8.next();
        if (r2 == null) goto L4;
        ComponentName r3 = r2.getComponentName();
        if (r3 != null) goto L11;
        if (this.mCategory != PreferredSettingsUtils.Category.text) goto L4;
        r1.add(r2);
        goto L4
    L11:
        if (r3.getPackageName().equals(r7) == false) goto L4;
        r0.append(r3.getClassName() + ";");
        goto L4
    L16:
        this.mPreferredComponent = new ComponentName(r7, r0.toString());
    }

    private List<ResolveInfo> getSelectTargetData(int r1, ListView r2, List<ResolveInfo> r3, List<ResolveInfo> r4) {
        final String r0 = r4.get(r1 - r2.getHeaderViewsCount()).activityInfo.packageName;
        return (List) r3.stream().filter(new PreferredActivityChooserForAllFragment$$ExternalSyntheticLambda0(r0)).collect(Collectors.toList());
    }

    static /* synthetic */ boolean lambda$getSelectTargetData$8(String r0, ResolveInfo r1) {
        return r0.equals(r1.activityInfo.packageName);
    }

    private void updateFileTypes(List<PreferredSettingsUtils.FileType> r3) {
        OLog.i(this.TAG, "updateFileTypes start");
        this.mFileTypes = r3;
        refreshUiIfNeeded();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_PreferredActivityChooserForAllFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PreferredActivityChooserForAllFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityChooserForAllFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityChooserForAllFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PreferredActivityChooserForAllFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_PreferredActivityChooserForAllFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityChooserForAllFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PreferredActivityChooserForAllFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityChooserForAllFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
