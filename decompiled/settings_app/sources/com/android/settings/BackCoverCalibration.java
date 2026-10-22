package com.android.settings;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.CustomTheme;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import bytedanceos.api.ActivityManagerSmt;
import bytedanceos.api.ConfigurationSmt;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class BackCoverCalibration extends BaseActivity {
    private ActivityManager mActivityManager;
    private CoverAdapter mAdapter;
    private Configuration mConfiguration;
    private int mCurrentValue;
    private int mDetectedValue;
    private String[] mDisplayNameArray;
    private final AdapterView.OnItemClickListener mItemSelected;
    boolean mLaunchedAuto;
    private ListView mListView;
    private int[] mValueArray;

    class CoverAdapter extends SettingsAdapter {
        private Context mContext;
        final /* synthetic */ BackCoverCalibration this$0;

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public CoverAdapter(BackCoverCalibration r1, Activity r2) {
            this.this$0 = r1;
            this.mContext = r2;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            return BackCoverCalibration.access$500(this.this$0).length;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L4;
            ViewHolder r8 = new ViewHolder();
            SettingItemCheck r9 = new SettingItemCheck(this.this$0);
            r9.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            r8.name = r9.getTitleView();
            r9.setTag(r8);
            ViewHolder r10 = r8;
            r6 = r9;
        L6:
            if (BackCoverCalibration.access$500(this.this$0)[r5] != BackCoverCalibration.access$100(this.this$0)) goto L8;
            ((SettingItemCheck) r6).setChecked(true);
        L9:
            r10.name.setText(BackCoverCalibration.access$600(this.this$0)[r5]);
            r6.setBackgroundResource(getBackgroundRes(BackCoverCalibration.access$500(this.this$0).length, r5));
            return r6;
        L8:
            ((SettingItemCheck) r6).setChecked(false);
            goto L9
        L4:
            r10 = (ViewHolder) r6.getTag();
            goto L6
        }
    }

    static class ViewHolder {
        public TextView name;
        public ImageView selected;

        ViewHolder() {
        }
    }

    public void com_android_settings_BackCoverCalibration__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_BackCoverCalibration__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_BackCoverCalibration__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_BackCoverCalibration__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public BackCoverCalibration() {
        this.mItemSelected = new AnonymousClass1(this);
    }

    static /* synthetic */ ListView access$000(BackCoverCalibration r0) {
        return r0.mListView;
    }

    static /* synthetic */ int access$100(BackCoverCalibration r0) {
        return r0.mCurrentValue;
    }

    static /* synthetic */ int access$102(BackCoverCalibration r0, int r1) {
        r0.mCurrentValue = r1;
        return r1;
    }

    static /* synthetic */ void access$200(BackCoverCalibration r0) {
        r0.setCalibrateList();
    }

    static /* synthetic */ Configuration access$300(BackCoverCalibration r0) {
        return r0.mConfiguration;
    }

    static /* synthetic */ ActivityManager access$400(BackCoverCalibration r0) {
        return r0.mActivityManager;
    }

    static /* synthetic */ int[] access$500(BackCoverCalibration r0) {
        return r0.mValueArray;
    }

    static /* synthetic */ String[] access$600(BackCoverCalibration r0) {
        return r0.mDisplayNameArray;
    }

    public void com_android_settings_BackCoverCalibration__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.launcher_anim_or_backcover_chooser_layout);
        this.mActivityManager = (ActivityManager) getSystemService("activity");
        this.mConfiguration = ActivityManagerSmt.getInstance().getConfiguration(this.mActivityManager);     // Catch: Exception -> L5
    L7:
        Resources r4 = getResources();
        this.mValueArray = r4.getIntArray(R.array.cover_value_list);
        this.mDisplayNameArray = r4.getStringArray(R.array.back_cover_name);
        int r5 = Utils.getDetectedColor(this);
        this.mDetectedValue = r5;
        this.mCurrentValue = Utils.getCurrentColor(this, r5);
        this.mListView = (ListView) findViewById(android.R.id.list);
        addHeaderFooter();
        CoverAdapter r6 = new CoverAdapter(this, this);
        this.mAdapter = r6;
        this.mListView.setAdapter(r6);
        this.mListView.setOnItemClickListener(this.mItemSelected);
        boolean r7 = getIntent().getBooleanExtra("launched_automatically", false);
        this.mLaunchedAuto = r7;
        if (r7 == false) goto L10;
        this.mDetectedValue = getDetectedColor();
        this.mCurrentValue = getCurrentColor();
    L10:
        setupBackBtnOnTitle();
        ((OFloatingTitleBar) findViewById(R.id.view_title)).setCenterTitle(getString(R.string.backcover_calibration));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void addHeaderFooter() {
        if (this.mListView.getHeaderViewsCount() != 0) goto L6;
        LinearLayout r0 = (LinearLayout) getLayoutInflater().inflate(R.layout.back_cover_calibration_header, null, false);
        this.mListView.addHeaderView(r0);
        this.mListView.addFooterView(Utils.inflateListTransparentHeader(this));
        return;
    }

    protected int getValueFromPosition(int r1) {
        return this.mValueArray[r1];
    }

    protected CustomTheme getThemeFromValue() {
        int r2 = this.mCurrentValue;
        if (r2 == 1) goto L23;
        if (r2 == 2) goto L21;
        if (r2 == 3) goto L19;
        if (r2 == 4) goto L17;
        if (r2 == 6) goto L15;
        return new CustomTheme("BytedanceOSDefault", "com.bytedanceos.theme.default");
    L15:
        return new CustomTheme("BytedanceOSGreen", "com.bytedanceos.theme.green");
    L17:
        return new CustomTheme("BytedanceOSOrange", "com.bytedanceos.theme.orange");
    L19:
        return new CustomTheme("BytedanceOSPurple", "com.bytedanceos.theme.purple");
    L21:
        return new CustomTheme("BytedanceOSYellow", "com.bytedanceos.theme.yellow");
    L23:
        return new CustomTheme("BytedanceOSCyan", "com.bytedanceos.theme.cyan");
    }

    private String getLauncherThemeFromValue() {
        switch(this.mCurrentValue) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return "bytedance_theme_blue";
    L6:
        return "bytedance_theme_green";
    L8:
        return "bytedance_theme_light_blue";
    L10:
        return "bytedance_theme_orange";
    L12:
        return "bytedance_theme_purple";
    L14:
        return "bytedance_theme_yellow";
    L16:
        return "bytedance_theme_cyan";
    L18:
        return "bytedance_theme_red";
    }

    private String getCalibrateList() {
        return android.provider.Settings.System.getString(getContentResolver(), "rear_cover_color_final");
    }

    private void setCalibrateList() {
        String r0 = getCalibrateList();
        if (r0 == null) goto L5;
        String[] r1 = r0.split(",");
        StringBuilder r5 = new StringBuilder();
        StringBuilder r6 = new StringBuilder();
        int r7 = r1.length;
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L15;
        String r10 = r1[r9];
        String r11 = r10.substring(0, 1);
        if (Integer.parseInt(r11) == this.mDetectedValue) goto L13;
        r5.append(r10 + ",");
        r6.append(r11 + ",");
    L13:
        r9 = r9 + 1;
        goto L8
    L15:
        if (this.mDetectedValue == this.mCurrentValue) goto L17;
        r5.append(this.mDetectedValue + "_" + this.mCurrentValue + ",");
        r6.append(this.mDetectedValue + ",");
    L17:
        ContentResolver r2 = getContentResolver();
        String r4 = null;
        if (r5.toString().length() != 0) goto L20;
        String r3 = null;
    L21:
        android.provider.Settings.System.putString(r2, "rear_cover_color_final", r3);
        ContentResolver r14 = getContentResolver();
        if (r6.toString().length() == 0) goto L25;
        r4 = r6.toString();
    L25:
        android.provider.Settings.Global.putString(r14, "cover_color_calibrated", r4);
        return;
    L20:
        r3 = r5.toString();
        goto L21
    L5:
        if (this.mDetectedValue == this.mCurrentValue) goto L30;
        android.provider.Settings.System.putString(getContentResolver(), "rear_cover_color_final", this.mDetectedValue + "_" + this.mCurrentValue + ",");
        android.provider.Settings.Global.putString(getContentResolver(), "cover_color_calibrated", String.valueOf(this.mDetectedValue));
        return;
    }

    private void updateGlobalThemeIfNeeded() {
        String r0 = android.provider.Settings.Global.getString(getContentResolver(), "launcher_theme");
        String r1 = getCurrentTheme();
        if (r0.equals(getLauncherThemeFromValue()) == true) goto L5;
    L6:
        new AlertDialog.Builder(this).setTitle(R.string.dialog_title_alert).setMessage(getDialogMsg()).setNegativeButton(getString(R.string.dialog_theme_negative), new AnonymousClass3(this)).setPositiveButton(getString(R.string.dialog_theme_positive), new AnonymousClass2(this)).create().show();
        return;
    L5:
        if (r1.equals(getThemeFromValue().getThemeId()) == false) goto L6;
    }

    private String getDialogMsg() {
        if (this.mCurrentValue != 0) goto L7;
        return getString(R.string.dialog_msg_switch_theme_launcher);
    L7:
        return getString(R.string.dialog_msg_switch_theme_both);
    }

    private String getCurrentTheme() {
        CustomTheme r1 = ConfigurationSmt.getInstance().get_customTheme(this.mConfiguration);
        if (r1 != null) goto L5;
        return "BytedanceOSDefault";
    L5:
        if (TextUtils.isEmpty(r1.getThemeId()) == false) goto L7;
        return "BytedanceOSDefault";
    L7:
        return r1.getThemeId();
    }

    private int getDetectedColor() {
        return android.provider.Settings.System.getInt(getContentResolver(), "rear_cover_color", 7);
    }

    private int getCurrentColor() {
        String r0 = getCalibrateList();
        if (r0 == null) goto L17;
        if (r0.length() == 0) goto L17;
        String[] r1 = r0.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L15;
        String r4 = r1[r3];
        if (Integer.parseInt(r4.substring(0, 1)) == this.mDetectedValue) goto L12;
        r3 = r3 + 1;
        goto L8
    L12:
        return Integer.parseInt(r4.substring(2));
    L15:
        return this.mDetectedValue;
    L17:
        return this.mDetectedValue;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_BackCoverCalibration_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BackCoverCalibration r1) {
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_PrivacyHook_onCreate(BackCoverCalibration r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BackCoverCalibration r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_BackCoverCalibration__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_BatchedActivityLancet_onResume(BackCoverCalibration r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(BackCoverCalibration r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        BackCoverCalibration r5 = r4;
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
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(BackCoverCalibration r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_BackCoverCalibration__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_BatchedActivityLancet_onStop(BackCoverCalibration r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_BackCoverCalibration_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_PrivacyHook_onResume(BackCoverCalibration r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BackCoverCalibration r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_BackCoverCalibration__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(BackCoverCalibration r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_PrivacyHook_onPause(BackCoverCalibration r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BackCoverCalibration r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_BackCoverCalibration__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(BackCoverCalibration r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_BackCoverCalibration_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        BackCoverCalibration r5 = r3;
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
    public static void com_android_settings_BackCoverCalibration_com_obric_hook_lancet_PrivacyHook_onStop(BackCoverCalibration r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BackCoverCalibration r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_BackCoverCalibration__onStop$___twin___();
    }
}
