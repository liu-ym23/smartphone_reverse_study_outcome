package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bytedanceos.util.SettingsUtil;
import com.android.settings.ApnEditor;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.SettingsApplication;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.ViewUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.time.HttpHeadTimeFetcher;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredActivityChooserExtendFragment extends BaseFragment {
    private static final String FILTER_PACKAGE_ARTICLE_NEW = "com.ss.android.article.news";
    private static final String FILTER_PACKAGE_NETEASE_MUSIC = "com.netease.cloudmusic";
    private boolean isEmptyPreferredActivity;
    private PreferredSettingsUtils.Category mCategory;
    private PreferredActivityChooseUtils mChooseUtils;
    private RelativeLayout mEmptyRelativeLayout;
    private List<ResolveInfo> mFullResolveInfoList;
    private IntentFilter mIntentFilter;
    private List<IntentFilter> mIntentFilters;
    private boolean mIsPreferredOfSend;
    AdapterView.OnItemClickListener mItemClickListener;
    private PackageManager mPm;
    private ComponentName mPreferredActivity;
    private Intent mPreferredIntent;
    private PreferredActivityAdapter mSeeAdapter;
    private List<ResolveInfo> mSeeAdapterData;
    private LinearLayout mSeeLinearLayout;
    private ExtendListView mSeeListView;
    private List<ResolveInfo> mSeeResolveInfoList;
    private PreferredActivityAdapter mSendAdapter;
    private LinearLayout mSendLinearLayout;
    private ExtendListView mSendListView;
    private List<ResolveInfo> mSendResolveInfoList;
    private TextView mTipTextView;
    private String mTitle;

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

    class PreferredActivityAdapter extends SettingsAdapter {
        private Context mContext;
        private List<ResolveInfo> mResolveInfoList;
        private boolean mShowSummary;
        final /* synthetic */ PreferredActivityChooserExtendFragment this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        public PreferredActivityAdapter(PreferredActivityChooserExtendFragment r1, Context r2, List<ResolveInfo> r3, boolean r4) {
            this.this$0 = r1;
            this.mContext = r2;
            this.mShowSummary = r4;
            this.mResolveInfoList = r3;
        }

        public void setResolveInfoList(List<ResolveInfo> r1) {
            this.mResolveInfoList = r1;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            List<ResolveInfo> r0 = this.mResolveInfoList;
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r8, View r9, ViewGroup r10) {
            if (r9 != null) goto L5;
            r9 = View.inflate(this.this$0.getActivity(), R.layout.list_content_item_check_oui_with_icon, null);
            OListItemSettings r0 = (OListItemSettings) r9.findViewById(R.id.item_check);
            r9.setTag(r0);
        L6:
            ResolveInfo r11 = this.mResolveInfoList.get(r8);
            String r1 = r11.activityInfo.packageName;
            String r2 = r11.activityInfo.name;
            CharSequence r3 = r11.activityInfo.applicationInfo.loadLabel(PreferredActivityChooserExtendFragment.access$000(this.this$0));
            String r4 = r3.toString();
            if (PreferredActivityChooserExtendFragment.access$100(this.this$0) != null) goto L9;
        L15:
            r0.setTitleString(r4);
            Glide.with(SettingsApplication.getContext()).load(r11.activityInfo.applicationInfo.loadIcon(PreferredActivityChooserExtendFragment.access$000(this.this$0))).transform(new CircleCrop()).into(r0.mIvContent);
            if (this.mShowSummary == false) goto L25;
            CharSequence r12 = r11.loadLabel(PreferredActivityChooserExtendFragment.access$000(this.this$0));
            if (r12 == null) goto L20;
            String r13 = r12.toString().replaceAll("\\p{C}", "").replaceAll("\\p{Z}", HanziToPinyin.Token.SEPARATOR).trim();
        L22:
            if (r3.equals(r13) == true) goto L24;
            r0.setSubTitleString(r13);
            goto L25
        L24:
            r0.setSubTitleString(null);
            goto L25
        L20:
            r13 = null;
        L25:
            ImageView r14 = new ImageView(this.mContext);
            r14.setImageResource(R.drawable.icon_check_confirm_rounded);
            r0.setTrailingView(r14);
            r0.mTrailingElement.setVisibility(4);
            if (PreferredActivityChooserExtendFragment.access$200(this.this$0) == false) goto L28;
        L41:
            return r9;
        L28:
            if (PreferredActivityChooserExtendFragment.access$300(this.this$0) == null) goto L41;
            String r15 = PreferredActivityChooserExtendFragment.access$300(this.this$0).getPackageName();
            String r5 = PreferredActivityChooserExtendFragment.access$300(this.this$0).getClassName();
            if (r15.equals(r1) == false) goto L34;
            if (PreferredActivityChooserExtendFragment.access$400(this.this$0) == true) goto L34;
        L39:
            r0.mTrailingElement.setVisibility(0);
        L34:
            if (r15.equals(r1) == true) goto L36;
        L40:
            r0.mTrailingElement.setVisibility(4);
            goto L41
        L36:
            if (r5.equals(r2) == false) goto L40;
            if (PreferredActivityChooserExtendFragment.access$400(this.this$0) == false) goto L40;
        L9:
            if (PreferredActivityChooserExtendFragment.access$100(this.this$0) == PreferredSettingsUtils.Category.others) goto L15;
            if (PreferredSettingsUtils.getDefaultAppByCategory(PreferredActivityChooserExtendFragment.access$100(this.this$0)).equals(r1) == false) goto L15;
            if (this.this$0.isAdded() == false) goto L15;
            r4 = r4 + this.this$0.getString(R.string.preferred_default_app);
            goto L15
        L5:
            r0 = (OListItemSettings) r9.getTag();
            goto L6
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r4) {
            ResolveInfo r0 = this.mResolveInfoList.get(r4);
            boolean r1 = SettingsUtil.isAccessibilityEnabled(this.mContext);
            if (r0.activityInfo.packageName.equals("com.bytedanceos.launcher") == false) goto L8;
            if (r1 == false) goto L8;
            return false;
        L8:
            return super.isEnabled(r4);
        }
    }

    public static /* synthetic */ ArrayList $r8$lambda$j6VaO9x1NLQsBBK4uvDp3meaxFU(Collection r1) {
        return new ArrayList(r1);
    }

    static /* synthetic */ ResolveInfo lambda$updateViews$2(ResolveInfo r0) {
        return r0;
    }

    static /* synthetic */ ResolveInfo lambda$updateViews$3(ResolveInfo r0, ResolveInfo r1) {
        return r1;
    }

    static /* synthetic */ ResolveInfo lambda$updateViews$5(ResolveInfo r0) {
        return r0;
    }

    static /* synthetic */ ResolveInfo lambda$updateViews$6(ResolveInfo r0, ResolveInfo r1) {
        return r1;
    }

    public void com_android_settings_applications_PreferredActivityChooserExtendFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_PreferredActivityChooserExtendFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_PreferredActivityChooserExtendFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.base.BaseFragment
    protected boolean shouldMonitorExtDisplayStatus() {
        return true;
    }

    public PreferredActivityChooserExtendFragment() {
        this.mSeeResolveInfoList = new ArrayList();
        this.mSendResolveInfoList = new ArrayList();
        this.mSeeAdapterData = new ArrayList();
        this.mFullResolveInfoList = new ArrayList();
        this.mIntentFilters = new ArrayList();
        this.mIsPreferredOfSend = false;
        this.mItemClickListener = new AnonymousClass1(this);
    }

    static /* synthetic */ PackageManager access$000(PreferredActivityChooserExtendFragment r0) {
        return r0.mPm;
    }

    static /* synthetic */ PreferredSettingsUtils.Category access$100(PreferredActivityChooserExtendFragment r0) {
        return r0.mCategory;
    }

    static /* synthetic */ PreferredActivityChooseUtils access$1000(PreferredActivityChooserExtendFragment r0) {
        return r0.mChooseUtils;
    }

    static /* synthetic */ PreferredActivityAdapter access$1100(PreferredActivityChooserExtendFragment r0) {
        return r0.mSeeAdapter;
    }

    static /* synthetic */ PreferredActivityAdapter access$1200(PreferredActivityChooserExtendFragment r0) {
        return r0.mSendAdapter;
    }

    static /* synthetic */ boolean access$200(PreferredActivityChooserExtendFragment r0) {
        return r0.isEmptyPreferredActivity;
    }

    static /* synthetic */ ComponentName access$300(PreferredActivityChooserExtendFragment r0) {
        return r0.mPreferredActivity;
    }

    static /* synthetic */ ComponentName access$302(PreferredActivityChooserExtendFragment r0, ComponentName r1) {
        r0.mPreferredActivity = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(PreferredActivityChooserExtendFragment r0) {
        return r0.mIsPreferredOfSend;
    }

    static /* synthetic */ List access$500(PreferredActivityChooserExtendFragment r0, boolean r1, int r2) {
        return r0.getSelectItem(r1, r2);
    }

    static /* synthetic */ Intent access$600(PreferredActivityChooserExtendFragment r0) {
        return r0.mPreferredIntent;
    }

    static /* synthetic */ IntentFilter access$700(PreferredActivityChooserExtendFragment r0) {
        return r0.mIntentFilter;
    }

    static /* synthetic */ void access$800(PreferredActivityChooserExtendFragment r0, ResolveInfo r1) {
        r0.setOpenAppForSingleMimeType(r1);
    }

    static /* synthetic */ List access$900(PreferredActivityChooserExtendFragment r0) {
        return r0.mIntentFilters;
    }

    @Override // com.android.settings.base.BaseFragment
    protected void onExtDisplayChanged(boolean r1) {
        if (r1 == false) goto L5;
        finish();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.fragment_preferred_chooser, r3, false);
        this.mEmptyRelativeLayout = (RelativeLayout) findViewByIdNullable(R.id.preferred_empty);
        this.mSeeLinearLayout = (LinearLayout) findViewByIdNullable(R.id.ll_see_list);
        this.mSendLinearLayout = (LinearLayout) findViewByIdNullable(R.id.ll_send_list);
        this.mSeeListView = (ExtendListView) findViewByIdNullable(R.id.see_list);
        this.mSendListView = (ExtendListView) findViewByIdNullable(R.id.send_list);
        this.mTipTextView = (TextView) findViewByIdNullable(R.id.tips);
        PreferredActivityAdapter r5 = new PreferredActivityAdapter(this, requireActivity(), this.mSeeResolveInfoList, false);
        this.mSeeAdapter = r5;
        this.mSeeListView.setAdapter(r5);
        this.mSeeListView.setOnItemClickListener(this.mItemClickListener);
        PreferredActivityAdapter r6 = new PreferredActivityAdapter(this, requireActivity(), this.mSendResolveInfoList, true);
        this.mSendAdapter = r6;
        this.mSendListView.setAdapter(r6);
        this.mSendListView.setOnItemClickListener(this.mItemClickListener);
        return this.mRootView;
    }

    public void com_android_settings_applications_PreferredActivityChooserExtendFragment__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        this.mIntentFilter = (IntentFilter) r7.getParcelable("filter");
        this.isEmptyPreferredActivity = r7.getBoolean(PreferredSettingsUtils.INTENT_EXTRA_EMPTY);
        String r0 = r7.getString(PreferredSettingsUtils.INTENT_EXTRA_MIMETYPE);
        if (r0 != null) goto L5;
    L10:
        this.mCategory = (PreferredSettingsUtils.Category) r7.getSerializable("category");
        this.mTitle = r7.getString("title");
        if (r7.getInt("position", -1) != 0) goto L13;
        IntentFilter r1 = new IntentFilter("android.intent.action.VIEW");
        this.mIntentFilter = r1;
        r1.addDataScheme("http");
        this.mIntentFilter.addDataScheme(HttpHeadTimeFetcher.FETCHER_TYPE);
        this.mIntentFilter.addDataAuthority(ApnEditor.APN_TYPE_ALL, null);
        this.mIntentFilter.addCategory("android.intent.category.DEFAULT");
        this.mPreferredIntent = makeIntentByFilter(this.mIntentFilter);
    L13:
        IntentFilter r2 = this.mIntentFilter;
        if (r2 == null) goto L21;
        this.mPreferredIntent = makeIntentByFilter(r2);
        if (this.mIntentFilter.hasDataScheme("http") == false) goto L21;
        if (this.mIntentFilter.hasDataScheme(HttpHeadTimeFetcher.FETCHER_TYPE) == false) goto L21;
        this.mIntentFilters.add(this.mIntentFilter);
    L21:
        if (this.mPreferredIntent == null) goto L23;
    L27:
        this.mPm = getPackageManager();
        this.mChooseUtils = new PreferredActivityChooseUtils(this.mContext);
        return;
    L23:
        if (this.mIntentFilters.isEmpty() == true) goto L27;
        IntentFilter r8 = (IntentFilter) r7.getParcelable(PreferredSettingsUtils.INTENT_EXTRA_FILTER_FOR_MULTIPLE);
        if (r8 == null) goto L27;
        this.mPreferredIntent = makeIntentByFilter(r8);
        goto L27
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L10;
        if (r0.contains(";") == false) goto L9;
        this.mIntentFilters = (List) Stream.of(r0.split(";")).map(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda14()).collect(Collectors.toList());
        goto L10
    L9:
        this.mIntentFilters.add(PreferredSettingsUtils.getIntentFilterForType(r0));
        goto L10
    }

    static /* synthetic */ IntentFilter lambda$onCreate$0(String r0) {
        return PreferredSettingsUtils.getIntentFilterForType(r0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    public static Intent makeIntentByFilter(IntentFilter r0) {
        return PreferredActivityChooseUtils.makeIntentByFilter(r0);
    }

    public void updateViews() {
        int r1 = 0;
        if (this.mPreferredIntent == null) goto L5;
    L8:
        Intent r0 = this.mPreferredIntent;
        if (r0 == null) goto L21;
        ResolveInfo r2 = this.mPm.resolveActivity(r0, 131072);
        if (r2 == null) goto L21;
        if (r2.activityInfo == null) goto L21;
        String r3 = r2.activityInfo.name;
        if (PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY_ANDROID.equals(r3) == false) goto L17;
    L20:
        this.mPreferredActivity = (ComponentName) getArguments().getParcelable(PreferredSettingsUtils.INTENT_EXTRA_SELECT_PREFERRED_ACTIVITY);
        goto L21
    L17:
        if (PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY.equals(r3) == true) goto L20;
        this.mPreferredActivity = new ComponentName(r2.activityInfo.packageName, r3);
    L21:
        PreferredSettingsUtils.Category r4 = this.mCategory;
        if (r4 == null) goto L24;
        String r5 = PreferredSettingsUtils.getDefaultAppByCategory(r4);
    L25:
        this.mSeeResolveInfoList = getResolveInfoListWithAction("android.intent.action.VIEW", r5);
        this.mSendResolveInfoList = getResolveInfoListWithAction("android.intent.action.SEND", r5);
        this.mFullResolveInfoList.addAll(this.mSeeResolveInfoList);
        this.mFullResolveInfoList.addAll(this.mSendResolveInfoList);
        if (this.mSeeResolveInfoList.isEmpty() == true) goto L28;
        Map r6 = (Map) this.mSeeResolveInfoList.stream().collect(Collectors.toMap(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda15(), new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda16(), new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda17()));
        Map r7 = (Map) this.mSendResolveInfoList.stream().collect(Collectors.toMap(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda1(), new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda2(), new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda3()));
        final Set r8 = r6.keySet();
        r8.retainAll(r7.keySet());
        this.mSeeResolveInfoList = (List) this.mSeeResolveInfoList.stream().filter(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda4(r8)).collect(Collectors.toList());
        this.mSendResolveInfoList = (List) this.mSendResolveInfoList.stream().filter(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda5(r8)).collect(Collectors.toList());
        this.mSeeAdapterData = (List) this.mSeeResolveInfoList.stream().filter(PreferredSettingsUtils.distinctByKey(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda6())).collect(Collectors.toList());
    L28:
        findPrefereed();
        if (this.mSendResolveInfoList.isEmpty() == true) goto L31;
    L33:
        LinearLayout r9 = this.mSendLinearLayout;
        if (this.mSendResolveInfoList.isEmpty() == false) goto L36;
        int r10 = 8;
    L37:
        r9.setVisibility(r10);
        LinearLayout r11 = this.mSeeLinearLayout;
        if (this.mSeeResolveInfoList.isEmpty() == false) goto L40;
        r1 = 8;
    L40:
        r11.setVisibility(r1);
        this.mSeeAdapter.setResolveInfoList(this.mSeeAdapterData);
        this.mSendAdapter.setResolveInfoList(this.mSendResolveInfoList);
        ViewUtils.setListViewHeightBasedOnChildren(this.mSeeListView, this.mSeeAdapter);
        ViewUtils.setListViewHeightBasedOnChildren(this.mSendListView, this.mSendAdapter);
        this.mSeeAdapter.notifyDataSetChanged();
        this.mSendAdapter.notifyDataSetChanged();
        return;
    L36:
        r10 = 0;
        goto L37
    L31:
        if (this.mSeeResolveInfoList.isEmpty() == false) goto L33;
        this.mEmptyRelativeLayout.setVisibility(0);
        return;
    L24:
        r5 = null;
        goto L25
    L5:
        if (this.mIntentFilters.isEmpty() == false) goto L8;
        this.mSeeLinearLayout.setVisibility(8);
        this.mSendLinearLayout.setVisibility(8);
        this.mTipTextView.setVisibility(8);
        this.mEmptyRelativeLayout.setVisibility(0);
    }

    static /* synthetic */ String lambda$updateViews$1(ResolveInfo r2) {
        return r2.activityInfo.packageName + r2.activityInfo.name;
    }

    static /* synthetic */ String lambda$updateViews$4(ResolveInfo r2) {
        return r2.activityInfo.packageName + r2.activityInfo.name;
    }

    static /* synthetic */ boolean lambda$updateViews$7(Set r2, ResolveInfo r3) {
        return !r2.contains(r3.activityInfo.packageName + r3.activityInfo.name);
    }

    static /* synthetic */ boolean lambda$updateViews$8(Set r2, ResolveInfo r3) {
        return r2.contains(r3.activityInfo.packageName + r3.activityInfo.name);
    }

    static /* synthetic */ Object lambda$updateViews$9(ResolveInfo r0) {
        return r0.activityInfo.packageName;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void findPrefereed() {
        if (this.mPreferredActivity == null) goto L14;
        Iterator<ResolveInfo> r0 = this.mSendResolveInfoList.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        ResolveInfo r1 = r0.next();
        if (this.mPreferredActivity.getClassName().equals(r1.activityInfo.name) == false) goto L6;
        this.mIsPreferredOfSend = true;
        return;
    L15:
        return;
    }

    private List<ResolveInfo> getResolveInfoListWithAction(String r6, final String r7) {
        ArrayList r0 = new ArrayList();
        List<IntentFilter> r1 = this.mIntentFilters;
        if (r1 != null) goto L5;
    L25:
        return r0;
    L5:
        if (r1.isEmpty() == true) goto L25;
        Iterator r2 = ((List) this.mIntentFilters.stream().map(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda0()).collect(Collectors.toList())).iterator();
    L9:
        if (r2.hasNext() == false) goto L12;
        Intent r3 = ((Intent) r2.next()).cloneFilter();
        r3.setAction(r6);
        this.mChooseUtils.generateData(r3, false);
        r0.addAll(PreferredSettingsUtils.deepCopy(this.mChooseUtils.getResolveInfoList()));
        goto L9
    L12:
        if (r0.isEmpty() == false) goto L14;
        return r0;
    L14:
        List<ResolveInfo> r8 = (List) r0.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda9()), new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda10()));
        if (TextUtils.isEmpty(this.mTitle) == true) goto L20;
        if (TextUtils.equals(this.mTitle, getString(R.string.preferred_category_browser)) == false) goto L20;
        r8 = (List) r8.stream().filter(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda11()).filter(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda12()).collect(Collectors.toList());
    L20:
        if (TextUtils.isEmpty(r7) == true) goto L24;
        ResolveInfo r5 = r8.stream().filter(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda13(this, r7)).findFirst().orElse(null);
        if (r5 == null) goto L24;
        r8.remove(r8.indexOf(r5));
        r8.add(0, r5);
    L24:
        return r8;
    }

    static /* synthetic */ TreeSet lambda$getResolveInfoListWithAction$11() {
        return new TreeSet(Comparator.comparing(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda7()));
    }

    static /* synthetic */ String lambda$getResolveInfoListWithAction$10(ResolveInfo r2) {
        return r2.activityInfo.packageName + ";" + r2.activityInfo.name;
    }

    static /* synthetic */ boolean lambda$getResolveInfoListWithAction$12(ResolveInfo r1) {
        return !FILTER_PACKAGE_NETEASE_MUSIC.equals(r1.activityInfo.packageName);
    }

    static /* synthetic */ boolean lambda$getResolveInfoListWithAction$13(ResolveInfo r1) {
        return !FILTER_PACKAGE_ARTICLE_NEW.equals(r1.activityInfo.packageName);
    }

    /* JADX INFO: renamed from: lambda$getResolveInfoListWithAction$14$com-android-settings-applications-PreferredActivityChooserExtendFragment, reason: not valid java name */
    /* synthetic */ boolean m305xf7666017(String r2, ResolveInfo r3) {
        return filterDefaultApp(r2, r3.activityInfo.packageName, this.mCategory);
    }

    private boolean filterDefaultApp(String r1, String r2, PreferredSettingsUtils.Category r3) {
        if (r3 == PreferredSettingsUtils.Category.others) goto L7;
        if (r1.equals(r2) == false) goto L7;
    L10:
        return true;
    L7:
        if (r3 == PreferredSettingsUtils.Category.others) goto L9;
    L11:
        return false;
    L9:
        if (r1.contains(r2) == false) goto L11;
        goto L10
    }

    private List getSelectItem(boolean r2, int r3) {
        if (r2 == false) goto L5;
        final String r4 = this.mSeeAdapterData.get(r3 - this.mSeeListView.getHeaderViewsCount()).activityInfo.packageName;
        return (List) this.mSeeResolveInfoList.stream().filter(new PreferredActivityChooserExtendFragment$$ExternalSyntheticLambda8(r4)).collect(Collectors.toList());
    L5:
        ArrayList r5 = new ArrayList();
        r5.add(this.mSendResolveInfoList.get(r3 - this.mSendListView.getHeaderViewsCount()));
        return r5;
    }

    static /* synthetic */ boolean lambda$getSelectItem$15(String r0, ResolveInfo r1) {
        return r0.equals(r1.activityInfo.packageName);
    }

    private void setOpenAppForSingleMimeType(ResolveInfo r9) {
        int r0 = this.mFullResolveInfoList.size();
        ComponentName[] r1 = new ComponentName[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L8;
        ResolveInfo r4 = this.mFullResolveInfoList.get(r2);
        r1[r2] = new ComponentName(r4.activityInfo.packageName, r4.activityInfo.name);
        if (r4.match <= r3) goto L7;
        r3 = r4.match;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        ComponentName r5 = new ComponentName(r9.activityInfo.packageName, r9.activityInfo.name);
        if (this.mIntentFilter.countDataSchemes() <= 0) goto L11;
    L14:
        this.mPm.addPreferredActivity(this.mIntentFilter, r3, r1, r5);
        return;
    L11:
        if (this.mIntentFilter.countDataTypes() > 0) goto L14;
        this.mPm.addPreferredActivity(this.mIntentFilter, 1048576, r1, r5);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_PreferredActivityChooserExtendFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PreferredActivityChooserExtendFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityChooserExtendFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityChooserExtendFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PreferredActivityChooserExtendFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_PreferredActivityChooserExtendFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityChooserExtendFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PreferredActivityChooserExtendFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityChooserExtendFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
