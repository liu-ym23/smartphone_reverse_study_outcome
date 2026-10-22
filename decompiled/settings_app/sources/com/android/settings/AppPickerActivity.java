package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class AppPickerActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_DEBUGGABLE = "com.android.settings.extra.DEBUGGABLE";
    public static final String EXTRA_LEAKCANARY = "com.android.settings.extra.LEAKCANARY";
    public static final String EXTRA_REQUESTIING_PERMISSION = "com.android.settings.extra.REQUESTIING_PERMISSION";
    public static final String SELECTED_APP = "com.android.settings.extra.SELECTED_APP";
    private static final Comparator<MyApplicationInfo> sDisplayNameComparator = null;
    private AppListAdapter mAdapter;
    private String mDebugPackage;
    private boolean mDebuggableOnly;
    private boolean mLeakCanaryApp;
    private List<String> mLeakCanaryApps;
    private List<MyApplicationInfo> mLeakCanaryInfos;
    private ListView mListView;
    private String mPermissionName;

    public class AppListAdapter extends ArrayAdapter<MyApplicationInfo> {
        private final int mIconSize;
        private final LayoutInflater mInflater;
        private final List<MyApplicationInfo> mPackageInfoList;
        final /* synthetic */ AppPickerActivity this$0;

        public AppListAdapter(AppPickerActivity r11, Context r12) {
            this.this$0 = r11;
            super(r12, 0);
            this.mPackageInfoList = new ArrayList();
            this.mIconSize = r11.getResources().getDimensionPixelSize(R.dimen.settings_list_item_icon_size);
            this.mInflater = (LayoutInflater) r12.getSystemService("layout_inflater");
            List<ApplicationInfo> r1 = r12.getPackageManager().getInstalledApplications(0);
            int r2 = 0;
        L3:
            boolean r4 = true;
            if (r2 >= r1.size()) goto L45;
            ApplicationInfo r3 = r1.get(r2);
            if (r3.uid == 1000) goto L44;
            if (AppPickerActivity.access$000(r11) == false) goto L16;
            if ((r3.flags & 2) != 0) goto L16;
            if (PickApplicationActivity.EXTRA_USER.equals(Build.TYPE) == true) goto L44;
        L16:
            if (AppPickerActivity.access$100(r11) == null) goto L30;
            PackageInfo r5 = r11.getPackageManager().getPackageInfo(r3.packageName, 4096);     // Catch: PackageManager.NameNotFoundException -> L53
            if (r5.requestedPermissions == null) goto L44;
            String[] r6 = r5.requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L53
            int r7 = r6.length;     // Catch: PackageManager.NameNotFoundException -> L53
            int r8 = 0;
        L21:
            if (r8 >= r7) goto L26;
            if (r6[r8].equals(AppPickerActivity.access$100(r11)) == true) goto L27;
            r8 = r8 + 1;
        L27:
            if (r4 == true) goto L30;
        L26:
            r4 = false;
        L30:
            if (AppPickerActivity.access$200(r11) == true) goto L32;
        L38:
            MyApplicationInfo r9 = new MyApplicationInfo(r11);
            r9.info = r3;
            r9.label = r9.info.loadLabel(r11.getPackageManager()).toString();
            if (AppPickerActivity.access$200(r11) == true) goto L41;
        L43:
            this.mPackageInfoList.add(r9);
            goto L44
        L41:
            if (AppPickerActivity.access$300(r11).contains(r3.packageName) == false) goto L43;
            AppPickerActivity.access$400(r11).add(r9);
            goto L43
        L32:
            if (r3.processName.equals(SettingsSwitchKeyUtil.SettingTable.System) == true) goto L44;
            if (r3.processName.equals("com.android.shell") == true) goto L44;
            if (r3.packageName.equals("com.custom.leakcanary") == false) goto L38;
        L44:
            r2 = r2 + 1;
            goto L3
        L45:
            Collections.sort(this.mPackageInfoList, AppPickerActivity.access$500());
            MyApplicationInfo r10 = new MyApplicationInfo(r11);
            r10.label = r12.getText(R.string.no_application);
            this.mPackageInfoList.add(0, r10);
            if (AppPickerActivity.access$200(r11) == false) goto L51;
            r10.label = "Done";
            MyApplicationInfo r13 = new MyApplicationInfo(r11);
            r13.label = "SystemApp";
            if (AppPickerActivity.access$300(r11).contains("SystemApp") == false) goto L50;
            AppPickerActivity.access$400(r11).add(r13);
        L50:
            this.mPackageInfoList.add(1, r13);
        L51:
            addAll(this.mPackageInfoList);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(final int r7, final View r8, final ViewGroup r9) {
            if (r8 != null) goto L5;
            r8 = this.mInflater.inflate(R.layout.list_content_item_check_oui_with_icon_2, r9, false);
            OCardListItem r1 = (OCardListItem) r8.findViewById(R.id.item_check);
            r8.setTag(r1);
        L7:
            if (r7 == 0) goto L9;
        L11:
            if (r7 != 0) goto L14;
            r1.setCardPosition(1);
        L17:
            MyApplicationInfo r4 = getItem(r7);
            r1.setTitle(r4.label);
            r1.setDefaultCustomEndView(2);
            r1.showTailIcon(false);
            r1.showCustomEnd(false);
            r1.setOnContentClickListener(new AppPickerActivity$AppListAdapter$$ExternalSyntheticLambda0(this, r9, r8, r7));
            if (r4.info == null) goto L29;
            r1.setIcon(r4.info.loadIcon(this.this$0.getPackageManager()));
            r1.showIcon(true);
            r1.setSubTitle(r4.info.packageName);
            r1.showSubTitle(true);
            if (AppPickerActivity.access$200(this.this$0) == false) goto L26;
            if (AppPickerActivity.access$400(this.this$0).contains(r4) == false) goto L24;
            r1.showCustomEnd(true);
        L39:
            return r8;
        L24:
            r1.showCustomEnd(false);
            goto L39
        L26:
            if (r4.info.packageName.equals(AppPickerActivity.access$600(this.this$0)) == false) goto L28;
            r1.showCustomEnd(true);
            goto L39
        L28:
            r1.showCustomEnd(false);
            goto L39
        L29:
            r1.showSubTitle(false);
            r1.showIcon(false);
            r1.showCustomEnd(false);
            if (AppPickerActivity.access$200(this.this$0) == false) goto L36;
            if (AppPickerActivity.access$400(this.this$0).contains(r4) == false) goto L34;
            r1.showCustomEnd(true);
            goto L39
        L34:
            r1.showCustomEnd(false);
            goto L39
        L36:
            if (AppPickerActivity.access$600(this.this$0) != null) goto L38;
            r1.showCustomEnd(true);
            goto L39
        L38:
            r1.showCustomEnd(false);
            goto L39
        L14:
            if (r7 != (getCount() - 1)) goto L16;
            r1.setCardPosition(3);
            goto L17
        L16:
            r1.setCardPosition(2);
            goto L17
        L9:
            if (getCount() != 1) goto L11;
            r1.setCardPosition(0);
            goto L17
        L5:
            r1 = (OCardListItem) r8.getTag();
            goto L7
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-AppPickerActivity$AppListAdapter, reason: not valid java name */
        /* synthetic */ void m103xdc7ea3bc(ViewGroup r3, View r4, int r5, View r6) {
            if ((r3 instanceof ListView) == false) goto L6;
            ((ListView) r3).performItemClick(r4, r5, getItemId(r5));
            return;
        }
    }

    class MyApplicationInfo {
        ApplicationInfo info;
        CharSequence label;
        final /* synthetic */ AppPickerActivity this$0;

        MyApplicationInfo(AppPickerActivity r1) {
            this.this$0 = r1;
        }
    }

    public void com_android_settings_AppPickerActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_AppPickerActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_AppPickerActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_AppPickerActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public AppPickerActivity() {
    }

    static /* synthetic */ boolean access$000(AppPickerActivity r0) {
        return r0.mDebuggableOnly;
    }

    static /* synthetic */ String access$100(AppPickerActivity r0) {
        return r0.mPermissionName;
    }

    static /* synthetic */ boolean access$200(AppPickerActivity r0) {
        return r0.mLeakCanaryApp;
    }

    static /* synthetic */ List access$300(AppPickerActivity r0) {
        return r0.mLeakCanaryApps;
    }

    static /* synthetic */ List access$400(AppPickerActivity r0) {
        return r0.mLeakCanaryInfos;
    }

    static /* synthetic */ Comparator access$500() {
        return sDisplayNameComparator;
    }

    static /* synthetic */ String access$600(AppPickerActivity r0) {
        return r0.mDebugPackage;
    }

    public void com_android_settings_AppPickerActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.app_picker_layout);
        this.mListView = (ListView) findViewById(R.id.listView);
        this.mDebugPackage = getIntent().getStringExtra(SELECTED_APP);
        this.mPermissionName = getIntent().getStringExtra(EXTRA_REQUESTIING_PERMISSION);
        this.mDebuggableOnly = getIntent().getBooleanExtra(EXTRA_DEBUGGABLE, false);
        boolean r4 = getIntent().getBooleanExtra(EXTRA_LEAKCANARY, false);
        this.mLeakCanaryApp = r4;
        if (r4 == true) goto L5;
    L9:
        AppListAdapter r5 = new AppListAdapter(this, this);
        this.mAdapter = r5;
        if (r5.getCount() > 0) goto L12;
        finish();
    L13:
        this.mListView.setOnItemClickListener(this);
        setupBackBtnOnTitle();
        return;
    L12:
        this.mListView.setAdapter(this.mAdapter);
        goto L13
    L5:
        if (TextUtils.isEmpty(this.mDebugPackage) == false) goto L7;
        this.mLeakCanaryApps = new ArrayList();
    L8:
        this.mLeakCanaryInfos = new ArrayList(this.mLeakCanaryApps.size());
        goto L9
    L7:
        this.mLeakCanaryApps = new ArrayList(Arrays.asList(this.mDebugPackage.split(",")));
        goto L8
    }

    static {
        sDisplayNameComparator = new AnonymousClass1();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r7, View r8, int r9, long r10) {
        if (r10 != (-1)) goto L5;
        return;
    L5:
        MyApplicationInfo r1 = (MyApplicationInfo) r7.getItemAtPosition(r9);
        if (this.mLeakCanaryApp == false) goto L9;
        leakCanaryItemClick(r1, r8, r7, r10);
        return;
    L9:
        Intent r11 = new Intent();
        if (r1 != null) goto L12;
    L14:
        setResult(-1, r11);
        finish();
        return;
    L12:
        if (r1.info == null) goto L14;
        r11.setAction(r1.info.packageName);
        goto L14
    }

    private void leakCanaryItemClick(MyApplicationInfo r6, View r7, AdapterView<?> r8, long r9) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r1 = 0;
        if (r6.info == null) goto L7;
        OCardListItem r10 = (OCardListItem) r7.findViewById(R.id.item_check);
        if (this.mLeakCanaryInfos.contains(r6) == false) goto L41;
        this.mLeakCanaryInfos.remove(r6);
        r10.showCustomEnd(false);
    L42:
        this.mAdapter.notifyDataSetChanged();
        return;
    L41:
        this.mLeakCanaryInfos.add(r6);
        r10.showCustomEnd(true);
        goto L42
    L7:
        if (r9 != 0) goto L24;
        Intent r11 = new Intent();
        if (this.mLeakCanaryInfos.isEmpty() == true) goto L22;
        StringBuilder r12 = new StringBuilder();
    L12:
        if (r1 >= this.mLeakCanaryInfos.size()) goto L21;
        MyApplicationInfo r13 = this.mLeakCanaryInfos.get(r1);
        if (r1 <= 0) goto L17;
        r12.append(",");
    L17:
        if (r13.info != null) goto L19;
        r12.append("SystemApp");
    L20:
        r1 = r1 + 1;
        goto L12
    L19:
        r12.append(r13.info.packageName);
        goto L20
    L21:
        r11.setAction(r12.toString());
    L22:
        setResult(-1, r11);
        finish();
        goto L42
    L24:
        if (r9 != 1) goto L42;
        OCardListItem r14 = (OCardListItem) r7.findViewById(R.id.item_check);
        if (this.mLeakCanaryInfos.contains(r6) == false) goto L28;
        this.mLeakCanaryInfos.remove(r6);
        r14.showCustomEnd(false);
        goto L42
    L28:
        Iterator<MyApplicationInfo> r15 = this.mLeakCanaryInfos.iterator();
    L30:
        if (r15.hasNext() == false) goto L37;
        MyApplicationInfo r16 = r15.next();
        if (TextUtils.isEmpty(r16.info.sourceDir) == true) goto L36;
        if (r16.info.sourceDir.startsWith("/data/app") == true) goto L30;
    L36:
        r15.remove();
        goto L30
    L37:
        this.mLeakCanaryInfos.add(r6);
        r14.showCustomEnd(true);
        this.mAdapter.notifyDataSetChanged();
        goto L42
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_AppPickerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AppPickerActivity r1) {
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_PrivacyHook_onCreate(AppPickerActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_AppPickerActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(AppPickerActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(AppPickerActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        AppPickerActivity r5 = r4;
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
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(AppPickerActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_AppPickerActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(AppPickerActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_AppPickerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_PrivacyHook_onResume(AppPickerActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_AppPickerActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(AppPickerActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_PrivacyHook_onPause(AppPickerActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_AppPickerActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(AppPickerActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_AppPickerActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        AppPickerActivity r5 = r3;
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
    public static void com_android_settings_AppPickerActivity_com_obric_hook_lancet_PrivacyHook_onStop(AppPickerActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AppPickerActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_AppPickerActivity__onStop$___twin___();
    }
}
