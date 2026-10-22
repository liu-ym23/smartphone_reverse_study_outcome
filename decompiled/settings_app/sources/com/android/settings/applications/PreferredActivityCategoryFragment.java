package com.android.settings.applications;

import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import bytedanceos.api.PackageManagerSmt;
import com.android.settings.ApnEditor;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.SettingsFeature;
import com.android.settings.applications.api.OnSettingsItemClickListener;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredActivityCategoryFragment extends BaseFragment {
    private PreferredCategoryAdapter mAdapter;
    private PreferredSettingsUtils.Category[] mCategoryArray;
    private Intent mIntentHome;
    private Intent mIntentHttp;
    private Intent mIntentMailto;
    private Intent mIntentPhone;
    OnSettingsItemClickListener mItemClickListener;
    private ListView mListView;
    private PackageManager mPm;
    private List<List<ApplicationInfo>> mPreferredAppInfoList;
    private String[] mPreferredCategoryTitle;
    private String[] mPreferredCategoryType;
    private List<IntentFilter> mPreferredFilterList;
    private List<ResolveInfo> mPreferredResolveList;
    private List<String> mPreferredRoleNameList;
    private boolean mSupportHomePrefer;

    class PreferredCategoryAdapter extends SettingsAdapter {
        private Context mContext;
        private OnSettingsItemClickListener mItemClickListener;
        List<ComponentName> outActivitys;
        List<IntentFilter> outFilters;
        final /* synthetic */ PreferredActivityCategoryFragment this$0;

        class ViewHolder {
            FrameLayout itemView;
            final /* synthetic */ PreferredCategoryAdapter this$1;

            ViewHolder(PreferredCategoryAdapter r1) {
                this.this$1 = r1;
            }
        }

        static /* synthetic */ OnSettingsItemClickListener access$1000(PreferredCategoryAdapter r0) {
            return r0.mItemClickListener;
        }

        public PreferredCategoryAdapter(PreferredActivityCategoryFragment r1, Context r2, OnSettingsItemClickListener r3) {
            this.this$0 = r1;
            this.outActivitys = new ArrayList();
            this.outFilters = new ArrayList();
            this.mContext = r2;
            this.mItemClickListener = r3;
            updateAlwaysPreferredActivities();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return PreferredActivityCategoryFragment.access$000(this.this$0).length;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(final int r10, View r11, ViewGroup r12) {
            if (r11 != null) goto L5;
            r11 = View.inflate(this.this$0.getActivity(), R.layout.settings_oui_card_list_item, null);
            ViewHolder r0 = new ViewHolder(this);
            r0.itemView = (FrameLayout) r11;
            r11.setTag(r0);
        L6:
            final OCardListItem r1 = (OCardListItem) r0.itemView.findViewById(R.id.card_list_item);
            OCardListItemUtils.setTitle(r1, PreferredActivityCategoryFragment.access$000(this.this$0)[r10]);
            OCardListItemUtils.initCardItemInAdapter(this, r1, r10);
            View r2 = r1.getCustomEndView();
            if ((r2 instanceof OTextView) == false) goto L40;
            OTextView r3 = (OTextView) r2;
            r3.setText(this.mContext.getString(R.string.preferred_app_category_empty));
            r1.showCustomEnd(true);
            int r4 = PreferredActivityCategoryFragment.access$100(this.this$0).size();
            if (r10 >= PreferredActivityCategoryFragment.access$100(this.this$0).size()) goto L23;
            ResolveInfo r13 = (ResolveInfo) PreferredActivityCategoryFragment.access$100(this.this$0).get(r10);
            if (r13 == null) goto L40;
            if (r13.activityInfo.name.equals(PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY) == false) goto L15;
        L21:
            r3.setText(this.mContext.getString(R.string.preferred_app_category_empty));
            goto L40
        L15:
            if (r13.activityInfo.name.equals(PreferredSettingsUtils.COMPONENT_RESOLVERACTIVITY_ANDROID) == true) goto L21;
            String r5 = r13.activityInfo.packageName;
            r5.hashCode();
            if (r5.equals("com.bytedanceos.launcher") == true) goto L20;
            r3.setText(r13.activityInfo.applicationInfo.loadLabel(PreferredActivityCategoryFragment.access$200(this.this$0)).toString());
            goto L40
        L20:
            r3.setText(this.mContext.getString(R.string.bytedance_desktop_title));
            goto L40
        L23:
            if (r10 >= (PreferredActivityCategoryFragment.access$300(this.this$0).size() + r4)) goto L29;
            final List r14 = (List) PreferredActivityCategoryFragment.access$300(this.this$0).get(r10 - r4);
            String r6 = (String) IntStream.range(0, r14.size()).mapToObj(new PreferredActivityCategoryFragment$PreferredCategoryAdapter$$ExternalSyntheticLambda0(this, r14)).collect(Collectors.joining(","));
            if (r14 == null) goto L40;
            if (r14.isEmpty() == true) goto L40;
            r3.setText(r6);
            goto L40
        L29:
            r3.setText(this.mContext.getString(R.string.preferred_app_category_empty));
            int r7 = (r10 - PreferredActivityCategoryFragment.access$400(this.this$0).size()) - PreferredActivityCategoryFragment.access$300(this.this$0).size();
            if (r7 < 0) goto L40;
            if (r7 >= PreferredActivityCategoryFragment.access$500(this.this$0).length) goto L40;
            PreferredActivityChooseUtils r8 = new PreferredActivityChooseUtils(this.mContext);
            PreferredSettingsUtils.Category r9 = PreferredActivityCategoryFragment.access$500(this.this$0)[r7];
            List r15 = (List) PreferredSettingsUtils.getFileType2(this.mContext, this.outActivitys, this.outFilters, r9, r8).stream().filter(new PreferredActivityCategoryFragment$PreferredCategoryAdapter$$ExternalSyntheticLambda1()).filter(PreferredSettingsUtils.distinctByKey(new PreferredActivityCategoryFragment$PreferredCategoryAdapter$$ExternalSyntheticLambda2())).collect(Collectors.toList());
            if (r15.size() != 1) goto L40;
            String r16 = ((PreferredSettingsUtils.FileType) r15.get(0)).getComponentName().getPackageName();     // Catch: PackageManager.NameNotFoundException -> L37
            OLog.i(PreferredActivityCategoryFragment.access$600(this.this$0), "bind " + r9 + ", packagename=" + r16);     // Catch: PackageManager.NameNotFoundException -> L37
            r3.setText((String) PreferredActivityCategoryFragment.access$200(this.this$0).getApplicationInfo(r16, 0).loadLabel(PreferredActivityCategoryFragment.access$200(this.this$0)));     // Catch: PackageManager.NameNotFoundException -> L37
        L37:
            e = move-exception;
            OLog.e(PreferredActivityCategoryFragment.access$700(this.this$0), "getApplicationInfo NameNotFoundException=" + e);
        L40:
            if (PreferredActivityCategoryFragment.access$800(this.this$0) == false) goto L43;
            if (r10 != 0) goto L43;
            r11.setEnabled(!PreferredActivityCategoryFragment.access$900(this.this$0));
        L44:
            r1.setOnContentClickListener(new AnonymousClass1(this, r1, r10));
            return r11;
        L43:
            r11.setEnabled(true);
            goto L44
        L5:
            r0 = (ViewHolder) r11.getTag();
            goto L6
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-applications-PreferredActivityCategoryFragment$PreferredCategoryAdapter, reason: not valid java name */
        /* synthetic */ String m304xf44b035a(List r1, int r2) {
            return PreferredActivityCategoryFragment.access$200(this.this$0).getApplicationLabel((ApplicationInfo) r1.get(r2)).toString();
        }

        static /* synthetic */ boolean lambda$getView$1(PreferredSettingsUtils.FileType r0) {
            if (r0 != null) goto L4;
        L6:
            return false;
        L4:
            if (r0.getComponentName() == null) goto L6;
            return true;
        }

        static /* synthetic */ Object lambda$getView$2(PreferredSettingsUtils.FileType r0) {
            return r0.getComponentName().getPackageName();
        }

        public void updateAlwaysPreferredActivities() {
            PackageManagerSmt.getInstance().getAlwaysPreferredActivities(PreferredActivityCategoryFragment.access$200(this.this$0), this.outFilters, this.outActivitys, null);
        }
    }

    public void com_android_settings_applications_PreferredActivityCategoryFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_PreferredActivityCategoryFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.preferred_application;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_PreferredActivityCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_PreferredActivityCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.base.BaseFragment
    protected boolean shouldMonitorExtDisplayStatus() {
        return true;
    }

    public PreferredActivityCategoryFragment() {
        this.mCategoryArray = PreferredSettingsUtils.Category.values();
        this.mPreferredResolveList = new ArrayList();
        this.mPreferredRoleNameList = new ArrayList();
        this.mPreferredAppInfoList = new ArrayList();
        this.mPreferredFilterList = new ArrayList();
        this.mItemClickListener = new AnonymousClass1(this);
    }

    static /* synthetic */ String[] access$000(PreferredActivityCategoryFragment r0) {
        return r0.mPreferredCategoryTitle;
    }

    static /* synthetic */ List access$100(PreferredActivityCategoryFragment r0) {
        return r0.mPreferredResolveList;
    }

    static /* synthetic */ ListView access$1100(PreferredActivityCategoryFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ List access$1200(PreferredActivityCategoryFragment r0) {
        return r0.mPreferredRoleNameList;
    }

    static /* synthetic */ String access$1300(PreferredActivityCategoryFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$1400(PreferredActivityCategoryFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ PackageManager access$200(PreferredActivityCategoryFragment r0) {
        return r0.mPm;
    }

    static /* synthetic */ List access$300(PreferredActivityCategoryFragment r0) {
        return r0.mPreferredAppInfoList;
    }

    static /* synthetic */ List access$400(PreferredActivityCategoryFragment r0) {
        return r0.mPreferredFilterList;
    }

    static /* synthetic */ PreferredSettingsUtils.Category[] access$500(PreferredActivityCategoryFragment r0) {
        return r0.mCategoryArray;
    }

    static /* synthetic */ String access$600(PreferredActivityCategoryFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$700(PreferredActivityCategoryFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ boolean access$800(PreferredActivityCategoryFragment r0) {
        return r0.mSupportHomePrefer;
    }

    static /* synthetic */ boolean access$900(PreferredActivityCategoryFragment r0) {
        return r0.mIsExtDisplayConnected;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        this.mRootView = r6.inflate(R.layout.manage_applications_layout, r7, false);
        this.mSupportHomePrefer = !this.mIsExtDisplaying;
        if (SettingsFeature.isSupportAssistantRole() == false) goto L5;
        this.mPreferredCategoryTitle = getResources().getStringArray(R.array.preferred_category_with_assistant_role);
    L7:
        if (this.mSupportHomePrefer == true) goto L9;
        String[] r9 = this.mPreferredCategoryTitle;
        this.mPreferredCategoryTitle = (String[]) Arrays.copyOfRange(r9, 1, r9.length);
    L9:
        this.mPm = getPackageManager();
        this.mListView = (ListView) findViewByIdNullable(R.id.listView);
        PreferredCategoryAdapter r10 = new PreferredCategoryAdapter(this, requireActivity(), this.mItemClickListener);
        this.mAdapter = r10;
        this.mListView.setAdapter(r10);
        Intent r11 = new Intent("android.intent.action.VIEW");
        this.mIntentHttp = r11;
        r11.setData(new Uri.Builder().scheme("http").authority(ApnEditor.APN_TYPE_ALL).build());
        Intent r12 = new Intent("android.intent.action.SENDTO");
        this.mIntentMailto = r12;
        r12.setData(new Uri.Builder().scheme("mailto").build());
        Intent r13 = new Intent("android.intent.action.MAIN");
        this.mIntentHome = r13;
        r13.addCategory("android.intent.category.HOME");
        this.mIntentHome.addCategory("android.intent.category.DEFAULT");
        Intent r14 = new Intent("android.intent.action.DIAL");
        this.mIntentPhone = r14;
        r14.setData(new Uri.Builder().scheme("tel").build());
        IntentFilter r15 = new IntentFilter("android.intent.action.SENDTO");
        r15.addDataScheme("mailto");
        r15.addCategory("android.intent.category.DEFAULT");
        IntentFilter r16 = new IntentFilter("android.intent.action.MAIN");
        r16.addCategory("android.intent.category.HOME");
        r16.addCategory("android.intent.category.DEFAULT");
        this.mPreferredFilterList.add(r15);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mListView);
        return this.mRootView;
    L5:
        this.mPreferredCategoryTitle = getResources().getStringArray(R.array.preferred_category);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void buildDefaultIntentList() {
        this.mPreferredResolveList.clear();
        ResolveInfo r0 = this.mPm.resolveActivity(this.mIntentMailto, 65536);
        this.mPreferredResolveList.add(r0);
        this.mPreferredAppInfoList.clear();
        RoleManager r1 = (RoleManager) this.mContext.getSystemService(RoleManager.class);
        UserHandle r2 = new UserHandle(UserHandle.myUserId());
        ArrayList r3 = new ArrayList(Arrays.asList(new String[]{"android.app.role.HOME", "android.app.role.BROWSER", "android.app.role.DIALER", "android.app.role.SMS"}));
        if (SettingsFeature.isSupportAssistantRole() == false) goto L5;
        r3.add("android.app.role.ASSISTANT");
    L5:
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L16;
        String r5 = (String) r4.next();
        this.mPreferredRoleNameList.add(r5);
        if ("android.app.role.DIALER".equals(r5) == true) goto L10;
        List<ApplicationInfo> r6 = getApplicationInfos(r1, r2, r5);
        this.mPreferredAppInfoList.add(r6);
        goto L7
    L10:
        ResolveInfo r7 = this.mPm.resolveActivity(this.mIntentPhone, 65536);
        ArrayList r8 = new ArrayList();
        if (r7.activityInfo.packageName.equals(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME) == true) goto L14;
        r8.add(this.mPm.getApplicationInfo(r7.activityInfo.packageName, 786432));     // Catch: PackageManager.NameNotFoundException -> L17
    L14:
        this.mPreferredAppInfoList.add(r8);
        goto L7
    }

    private List<ApplicationInfo> getApplicationInfos(RoleManager r7, UserHandle r8, String r9) {
        ArrayList r0 = new ArrayList();
        List r10 = r7.getRoleHoldersAsUser(r9, r8);
        int r1 = r10.size();
        OLog.d(this.TAG, "buildDefaultIntentList holderPackageNamesSize: " + r1 + ", roleName: " + r9 + ", userHandle: " + r8);
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L13;
        String r2 = (String) r10.get(r11);
        ApplicationInfo r3 = this.mPm.getApplicationInfo(r2, 786432);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r3 != null) goto L8;
        OLog.e(this.TAG, "Cannot get ApplicationInfo for application, package name: " + r2 + ", user id: " + r8.getIdentifier());     // Catch: PackageManager.NameNotFoundException -> L10
    L12:
        r11 = r11 + 1;
        goto L3
    L8:
        r0.add(r3);     // Catch: PackageManager.NameNotFoundException -> L10
    L10:
        e = move-exception;
        OLog.e(this.TAG, "getApplicationInfos error: " + e);
        goto L12
    L13:
        return r0;
    }

    private void printApplicationInfo(ApplicationInfo r4) {
        OLog.e("ApplicationInfo", "PackageName = " + r4.packageName);
        OLog.e("ApplicationInfo", "Uid = " + r4.uid);
        OLog.e("ApplicationInfo", "SourceDir = " + r4.sourceDir);
        OLog.e("ApplicationInfo", "ProcessName = " + r4.processName);
        OLog.e("ApplicationInfo", "ClassName = " + r4.className);
        OLog.e("ApplicationInfo", "TargetSdkVersion = " + r4.targetSdkVersion);
        OLog.e("ApplicationInfo", "DataDir = " + r4.dataDir);
        OLog.e("ApplicationInfo", "getApplicationLabel = " + this.mPm.getApplicationLabel(r4));
    }

    @Override // com.android.settings.base.BaseFragment
    protected void onExtDisplayChanged(boolean r1) {
        this.mAdapter.updateAlwaysPreferredActivities();
        this.mAdapter.notifyDataSetChanged();
    }

    public void updateViews() {
        buildDefaultIntentList();
        PreferredCategoryAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.updateAlwaysPreferredActivities();
        this.mAdapter.notifyDataSetChanged();
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_PreferredActivityCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PreferredActivityCategoryFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityCategoryFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PreferredActivityCategoryFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_PreferredActivityCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_PreferredActivityCategoryFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PreferredActivityCategoryFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_PreferredActivityCategoryFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
