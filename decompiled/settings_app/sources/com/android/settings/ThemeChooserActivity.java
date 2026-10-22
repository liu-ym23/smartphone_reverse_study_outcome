package com.android.settings;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.PackageInstallObserver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.CustomTheme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import bytedanceos.api.ActivityManagerSmt;
import bytedanceos.api.ConfigurationSmt;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.GridViewWithHeaderAndFooter;
import com.android.settings.widget.OptionCardView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;

/* JADX INFO: loaded from: classes2.dex */
public class ThemeChooserActivity extends BaseActivity {
    private static final int MSG_ID_UPDATE_CONFIG = 1;
    private ActivityManager mActivityManager;
    private ThemeChooserAdapter mAdapter;
    private Configuration mConfiguration;
    private String mCurrentTheme;
    private AlertDialog mDialog;
    private GridViewWithHeaderAndFooter mGridView;
    private Handler mHandler;
    private final AdapterView.OnItemClickListener mItemSelected;
    private int mPosition;
    private BytedanceProgressDialog mProgressDialog;
    private ArrayList<Drawable> mThemeDrawable;
    private ArrayList<String> mThemeId;
    private ArrayList<String> mThemeName;
    private ArrayList<String> mThemePackage;

    private class LocalPackageInstallObserver extends PackageInstallObserver {
        final /* synthetic */ ThemeChooserActivity this$0;

        public void onUserActionRequired(Intent r1) {
        }

        public LocalPackageInstallObserver(ThemeChooserActivity r1) {
            this.this$0 = r1;
        }

        public void onPackageInstalled(String r2, int r3, String r4, Bundle r5) {
            OLog.d(this.this$0.TAG, "packageInstalled: " + r2);
            if (r3 != 1) goto L5;
            ThemeChooserActivity.access$400(this.this$0).sendEmptyMessageDelayed(1, 300);
            ThemeChooserActivity.access$500(this.this$0).notifyDataSetChanged();
            return;
        L5:
            ThemeChooserActivity.access$100(this.this$0).dismiss();
        }
    }

    class ThemeChooserAdapter extends SettingsAdapter {
        private LayoutInflater mInflater;
        final /* synthetic */ ThemeChooserActivity this$0;

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public ThemeChooserAdapter(ThemeChooserActivity r1, Activity r2) {
            this.this$0 = r1;
            this.mInflater = LayoutInflater.from(r2);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return ThemeChooserActivity.access$800(this.this$0).size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r6, View r7, ViewGroup r8) {
            if (r7 != null) goto L4;
            OptionCardView r9 = new OptionCardView(this.this$0.mContext);
            View r10 = r9;
        L6:
            if (((String) ThemeChooserActivity.access$800(this.this$0).get(r6)).equals(ThemeChooserActivity.access$700(this.this$0)) == false) goto L8;
            r9.setCheck(true);
        L10:
            if (Utils.isPackageInstalled(this.this$0.mContext, (String) ThemeChooserActivity.access$300(this.this$0).get(r6)) == true) goto L12;
            r9.setEnabled(false);
        L13:
            Utils.setBackgroundForGridItemChooser(r6, getCount(), r10);
            r9.setTitle((CharSequence) ThemeChooserActivity.access$600(this.this$0).get(r6));
            r9.setIcon((Drawable) ThemeChooserActivity.access$1000(this.this$0).get(r6));
            return r10;
        L12:
            r9.setEnabled(true);
            goto L13
        L8:
            r9.setCheck(false);
            goto L10
        L4:
            r10 = r7;
            r9 = (OptionCardView) r7;
            goto L6
        }
    }

    public void com_android_settings_ThemeChooserActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_ThemeChooserActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_ThemeChooserActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_ThemeChooserActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ThemeChooserActivity() {
        this.mThemeDrawable = new ArrayList();
        this.mHandler = new AnonymousClass1(this);
        this.mItemSelected = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(ThemeChooserActivity r0) {
        r0.updateThemeConfig();
    }

    static /* synthetic */ BytedanceProgressDialog access$100(ThemeChooserActivity r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ ArrayList access$1000(ThemeChooserActivity r0) {
        return r0.mThemeDrawable;
    }

    static /* synthetic */ int access$200(ThemeChooserActivity r0) {
        return r0.mPosition;
    }

    static /* synthetic */ int access$202(ThemeChooserActivity r0, int r1) {
        r0.mPosition = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$300(ThemeChooserActivity r0) {
        return r0.mThemePackage;
    }

    static /* synthetic */ Handler access$400(ThemeChooserActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ ThemeChooserAdapter access$500(ThemeChooserActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ ArrayList access$600(ThemeChooserActivity r0) {
        return r0.mThemeName;
    }

    static /* synthetic */ String access$700(ThemeChooserActivity r0) {
        return r0.mCurrentTheme;
    }

    static /* synthetic */ String access$702(ThemeChooserActivity r0, String r1) {
        r0.mCurrentTheme = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$800(ThemeChooserActivity r0) {
        return r0.mThemeId;
    }

    static /* synthetic */ AlertDialog access$900(ThemeChooserActivity r0) {
        return r0.mDialog;
    }

    static /* synthetic */ AlertDialog access$902(ThemeChooserActivity r0, AlertDialog r1) {
        r0.mDialog = r1;
        return r1;
    }

    public void com_android_settings_ThemeChooserActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.theme_chooser_layout);
        getWindow().setLayout(-1, -1);
        this.mActivityManager = (ActivityManager) getSystemService("activity");
        this.mConfiguration = ActivityManagerSmt.getInstance().getConfiguration(this.mActivityManager);     // Catch: Exception -> L5
    L7:
        Resources r6 = getResources();
        TypedArray r0 = r6.obtainTypedArray(R.array.device_theme_icon);
        int r1 = 0;
    L9:
        if (r1 >= r0.length()) goto L11;
        this.mThemeDrawable.add(r0.getDrawable(r1));
        r1 = r1 + 1;
        goto L9
    L11:
        this.mThemeId = new ArrayList(Arrays.asList(r6.getStringArray(R.array.device_theme_id)));
        this.mThemePackage = new ArrayList(Arrays.asList(r6.getStringArray(R.array.device_theme_package)));
        this.mThemeName = new ArrayList(Arrays.asList(r6.getStringArray(R.array.device_theme_name)));
        this.mCurrentTheme = getCurrentTheme(this);
        GridViewWithHeaderAndFooter r7 = (GridViewWithHeaderAndFooter) findViewById(R.id.grid_view);
        this.mGridView = r7;
        r7.setNumColumns(2);
        addHeaderFooter();
        ThemeChooserAdapter r8 = new ThemeChooserAdapter(this, this);
        this.mAdapter = r8;
        this.mGridView.setAdapter(r8);
        this.mGridView.setSelector(R.drawable.transparent_drawable);
        this.mGridView.setOnItemClickListener(this.mItemSelected);
        BytedanceProgressDialog r9 = new BytedanceProgressDialog(this);
        this.mProgressDialog = r9;
        r9.setOnShowListener(new AnonymousClass2(this));
        setupBackBtnOnTitle();
        checkItem();
        r0.recycle();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void checkItem() {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        int r4 = 0;
    L4:
        if (r4 >= this.mThemePackage.size()) goto L9;
        String r5 = this.mThemePackage.get(r4);
        String r6 = this.mThemeId.get(r4);
        String r7 = this.mThemeName.get(r4);
        Drawable r8 = this.mThemeDrawable.get(r4);
        if (Utils.isPackageInstalled(this.mActivity, r5) == true) goto L8;
        r0.add(r6);
        r2.add(r7);
        r1.add(r5);
        r3.add(r8);
    L8:
        r4 = r4 + 1;
        goto L4
    L9:
        this.mThemePackage.removeAll(r1);
        this.mThemePackage.addAll(r1);
        this.mThemeId.removeAll(r0);
        this.mThemeId.addAll(r0);
        this.mThemeName.removeAll(r2);
        this.mThemeName.addAll(r2);
        this.mThemeDrawable.removeAll(r3);
        this.mThemeDrawable.addAll(r3);
    }

    private void updateThemeConfig() {
        int r0 = this.mPosition;
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.mThemeId.size()) goto L15;
        CustomTheme r1 = new CustomTheme(this.mThemeId.get(this.mPosition), this.mThemePackage.get(this.mPosition));
        ConfigurationSmt.getInstance().set_customTheme(this.mConfiguration, r1);
        ActivityManagerSmt.getInstance().updateConfiguration(this.mActivityManager, this.mConfiguration);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void addHeaderFooter() {
        if (this.mGridView.getHeaderViewCount() != 0) goto L6;
        View r0 = Utils.inflateListTransparentHeader(this);
        this.mGridView.addHeaderView(r0);
        View r1 = Utils.inflateListTransparentHeader(this);
        this.mGridView.addFooterView(r1);
        return;
    }

    public static String getCurrentTheme(Context r3) {
        ActivityManager r4 = (ActivityManager) r3.getSystemService("activity");
        String r0 = "BytedanceOSDefault";
        Configuration r5 = ActivityManagerSmt.getInstance().getConfiguration(r4);     // Catch: Exception -> L17
        String r1 = Utils.getDeviceColor();
        if ("beige".equals(r1) == false) goto L8;
        r0 = "BytedanceOSEnsyuNezumi";
    L10:
        CustomTheme r6 = ConfigurationSmt.getInstance().get_customTheme(r5);
        if (r6 != null) goto L13;
    L16:
        return r0;
    L13:
        if (TextUtils.isEmpty(r6.getThemeId()) == true) goto L16;
        return r6.getThemeId();
    L8:
        if ("golden".equals(r1) == false) goto L10;
        r0 = "BytedanceOSOchikuri";
    L17:
        e = move-exception;
        e.printStackTrace();
        return "BytedanceOSDefault";
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ThemeChooserActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ThemeChooserActivity r1) {
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ThemeChooserActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ThemeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ThemeChooserActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ThemeChooserActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ThemeChooserActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ThemeChooserActivity r5 = r4;
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
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ThemeChooserActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_ThemeChooserActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ThemeChooserActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_ThemeChooserActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_PrivacyHook_onResume(ThemeChooserActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ThemeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_ThemeChooserActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ThemeChooserActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_PrivacyHook_onPause(ThemeChooserActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ThemeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_ThemeChooserActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ThemeChooserActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ThemeChooserActivity r5 = r3;
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
    public static void com_android_settings_ThemeChooserActivity_com_obric_hook_lancet_PrivacyHook_onStop(ThemeChooserActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ThemeChooserActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_ThemeChooserActivity__onStop$___twin___();
    }
}
