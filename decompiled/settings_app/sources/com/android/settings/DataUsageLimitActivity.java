package com.android.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
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
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.SettingItemSwitch;
import obric.widget.editor.LabelEditor;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageLimitActivity extends BaseActivity implements View.OnClickListener {
    public static final String ACTION_DATA_USAGE_LIMIT_CHANGED = "com.bytedanceos.action.DATA_USAGE_LIMIT_CHANGED";
    private static final String DATA_USAGE_LIMIT_SUB2 = "data_usage_limit_sub2";
    private static final long MAX_GB = 8589934591L;
    private static final long MAX_MB = 8796093022207L;
    public static final int UNIT_GB = 1;
    public static final int UNIT_MB = 0;
    private long mCurrentBytes;
    private int mCurrentSub;
    private int mCurrentUnitType;
    private InputFilterMinMax mDataLimitInputFilterMinMax;
    private EditText mEditText;
    private LabelEditor mLabelEditor;
    private SettingItemSwitch mSwitchDisconnect;

    class InputFilterMinMax implements InputFilter {
        private long max;
        private long min;
        final /* synthetic */ DataUsageLimitActivity this$0;

        private boolean isInRange(long r3, long r5, long r7) {
            if (r5 <= r3) goto L10;
            if (r7 < r3) goto L15;
            if (r7 > r5) goto L15;
            return true;
        L15:
            return false;
        L10:
            if (r7 < r5) goto L15;
            if (r7 > r3) goto L15;
            return true;
        }

        public InputFilterMinMax(DataUsageLimitActivity r1, long r2, long r4) {
            this.this$0 = r1;
            this.min = r2;
            if (r4 != 0) goto L5;
            long r3 = DataUsageLimitActivity.MAX_MB;
        L6:
            this.max = r3;
            return;
        L5:
            r3 = DataUsageLimitActivity.MAX_GB;
            goto L6
        }

        public void updateMax(long r3) {
            if (this.max == r3) goto L6;
            this.max = r3;
            return;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence r8, int r9, int r10, Spanned r11, int r12, int r13) {
            char[] r14 = r11.toString().toCharArray();     // Catch: NumberFormatException -> L16
            StringBuilder r15 = new StringBuilder();     // Catch: NumberFormatException -> L16
            StringBuilder r16 = new StringBuilder();     // Catch: NumberFormatException -> L16
            int r0 = 0;
        L4:
            if (r0 >= r14.length) goto L10;
            if (r0 >= r12) goto L7;
            r15.append(r14[r0]);     // Catch: NumberFormatException -> L16
        L9:
            r0 = r0 + 1;     // Catch: NumberFormatException -> L16
            goto L4
        L7:
            if (r0 < r13) goto L9;
            r16.append(r14[r0]);     // Catch: NumberFormatException -> L16
            goto L9
        L10:
            if (isInRange(this.min, this.max, Long.parseLong(r15.toString() + r8 + r16.toString())) == false) goto L14;
            return null;
        L14:
            return "";
        L23:
            return "";
        }
    }

    public void com_android_settings_DataUsageLimitActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_DataUsageLimitActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_DataUsageLimitActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DataUsageLimitActivity() {
        this.mCurrentUnitType = 0;
    }

    static /* synthetic */ int access$000(DataUsageLimitActivity r0) {
        return r0.mCurrentSub;
    }

    static /* synthetic */ int access$100(DataUsageLimitActivity r0) {
        return r0.mCurrentUnitType;
    }

    static /* synthetic */ int access$102(DataUsageLimitActivity r0, int r1) {
        r0.mCurrentUnitType = r1;
        return r1;
    }

    static /* synthetic */ EditText access$200(DataUsageLimitActivity r0) {
        return r0.mEditText;
    }

    static /* synthetic */ void access$300(DataUsageLimitActivity r0, String r1) {
        r0.updateEditIfNeed(r1);
    }

    static /* synthetic */ InputFilterMinMax access$400(DataUsageLimitActivity r0) {
        return r0.mDataLimitInputFilterMinMax;
    }

    static /* synthetic */ LabelEditor access$500(DataUsageLimitActivity r0) {
        return r0.mLabelEditor;
    }

    public void com_android_settings_DataUsageLimitActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.data_usage_limit);
        boolean r1 = false;
        this.mCurrentSub = Utils.getIntExtraSafely(getIntent(), "slot", 0);
        SettingItemSwitch r6 = (SettingItemSwitch) findViewById(R.id.disable_connectivity);
        this.mSwitchDisconnect = r6;
        if (this.mCurrentSub != 0) goto L9;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "data_usage_limit", 0) != 1) goto L7;
        r1 = true;
    L7:
        r6.setChecked(r1);
    L12:
        this.mCurrentBytes = Utils.getLongExtraSafely(getIntent(), DataUsageFragment.INTENT_EXTRA_LIMIT, 0);
        this.mSwitchDisconnect.setOnCheckedChangeListener(new AnonymousClass1(this));
        OFloatingTitleBar r7 = (OFloatingTitleBar) findViewById(R.id.view_title);
        this.mBackView = r7.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass2(this));
        r7.addEndAction(R.drawable.standard_icon_hignlight_confirm_selector, -1, null).setOnClickListener(this);
        initEditText();
        return;
    L9:
        if (android.provider.Settings.Global.getInt(getContentResolver(), DATA_USAGE_LIMIT_SUB2, 0) != 1) goto L11;
        r1 = true;
    L11:
        r6.setChecked(r1);
        goto L12
    }

    public void com_android_settings_DataUsageLimitActivity__onResume$___twin___() {
        super.onResume();
        isFromSecurityCenter();
    }

    private void initEditText() {
        this.mCurrentUnitType = getCurrentLimitUnit(this.mContext, this.mCurrentSub);
        LabelEditor r0 = (LabelEditor) findViewById(R.id.edittext);
        this.mLabelEditor = r0;
        r0.setOnRightWidgetClickListener(new AnonymousClass3(this));
        LabelEditor r1 = this.mLabelEditor;
        if (this.mCurrentUnitType != 0) goto L5;
        int r2 = R.string.megabyteShort;
    L6:
        r1.setRightLabel(r2);
        this.mEditText = this.mLabelEditor.getEditText();
        InputFilterMinMax r3 = new InputFilterMinMax(this, 0, this.mCurrentUnitType);
        this.mDataLimitInputFilterMinMax = r3;
        this.mEditText.setFilters(new InputFilter[]{r3});
        this.mEditText.setText(currentValueToNumberText(this.mCurrentBytes));
        EditText r7 = this.mEditText;
        r7.setSelection(0, r7.length());
        return;
    L5:
        r2 = R.string.gigabyteShort;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        Intent r9 = new Intent();
        if (this.mEditText.getText().length() <= 0) goto L5;
        long r0 = currentValueToByte();
    L6:
        notifyDataLimitChanged(r0);
        if (r0 <= 0) goto L16;
        if (Utils.getBooleanExtraSafely(getIntent(), "checked", false) == true) goto L11;
    L14:
        r9.putExtra(DataUsageFragment.INTENT_EXTRA_LIMIT, r0);
    L19:
        setCurrentLimitUnit(this.mContext, this.mCurrentSub, this.mCurrentUnitType);
        setResult(-1, r9);
        finish();
        return;
    L11:
        if (this.mCurrentSub != 0) goto L13;
        android.provider.Settings.Global.putInt(getContentResolver(), SettingsSwitchKeyUtil.DATA_USAGE_WARNING, 1);
        goto L14
    L13:
        android.provider.Settings.Global.putInt(getContentResolver(), "data_usage_warning_sub2", 1);
        goto L14
    L16:
        if (this.mCurrentSub != 0) goto L18;
        android.provider.Settings.Global.putInt(getContentResolver(), SettingsSwitchKeyUtil.DATA_USAGE_WARNING, 0);
        goto L19
    L18:
        android.provider.Settings.Global.putInt(getContentResolver(), "data_usage_warning_sub2", 0);
        goto L19
    L5:
        r0 = -1;
        goto L6
    }

    public static void setCurrentLimitUnit(Context r0, int r1, int r2) {
        ContentResolver r3 = r0.getContentResolver();
        if (r1 != 0) goto L5;
        android.provider.Settings.Global.putInt(r3, "data_usage_limit_unit", r2);
        return;
    L5:
        android.provider.Settings.Global.putInt(r3, "data_usage_limit_unit_sub2", r2);
    }

    public static int getCurrentLimitUnit(Context r1, int r2) {
        ContentResolver r3 = r1.getContentResolver();
        if (r2 != 0) goto L6;
        return android.provider.Settings.Global.getInt(r3, "data_usage_limit_unit", 0);
    L6:
        return android.provider.Settings.Global.getInt(r3, "data_usage_limit_unit_sub2", 0);
    }

    private long currentValueToByte() {
        if (this.mEditText.getText().length() > 0) goto L5;
        return 0;
    L5:
        String r0 = this.mEditText.getText().toString();
        int r4 = this.mCurrentUnitType;
        if (r4 != 0) goto L10;
        long r1 = Long.parseLong(r0);
        long r2 = 1048576;
    L12:
        return r1 * r2;
    L10:
        if (r4 != 1) goto L13;
        r1 = Long.parseLong(r0);
        r2 = FileUtils.ONE_GB;
        goto L12
    L13:
        return 0;
    }

    private String currentValueToNumberText(long r3) {
        if (r3 >= 0) goto L5;
        return null;
    L5:
        int r2 = this.mCurrentUnitType;
        if (r2 != 0) goto L9;
        return String.valueOf(r3 / 1048576);
    L9:
        if (r2 == 1) goto L11;
        return null;
    L11:
        return String.valueOf(r3 / FileUtils.ONE_GB);
    }

    private void updateEditIfNeed(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return;
    L6:
        if (this.mCurrentUnitType == 1) goto L8;
        return;
    L8:
        if (Long.parseLong(r5) < MAX_GB) goto L12;
        String r6 = currentValueToNumberText(Long.MAX_VALUE);
        this.mEditText.setText(r6);
        this.mEditText.setSelection(r6.length());
        return;
    }

    private void notifyDataLimitChanged(long r3) {
        Intent r0 = new Intent(ACTION_DATA_USAGE_LIMIT_CHANGED);
        r0.putExtra(DataUsageFragment.INTENT_EXTRA_LIMIT, r3);
        sendBroadcast(r0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DataUsageLimitActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DataUsageLimitActivity r1) {
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_PrivacyHook_onCreate(DataUsageLimitActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageLimitActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_DataUsageLimitActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(DataUsageLimitActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DataUsageLimitActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DataUsageLimitActivity r5 = r4;
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
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DataUsageLimitActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_DataUsageLimitActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(DataUsageLimitActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_DataUsageLimitActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_PrivacyHook_onResume(DataUsageLimitActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageLimitActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_DataUsageLimitActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DataUsageLimitActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_PrivacyHook_onPause(DataUsageLimitActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageLimitActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_DataUsageLimitActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DataUsageLimitActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DataUsageLimitActivity r5 = r3;
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
    public static void com_android_settings_DataUsageLimitActivity_com_obric_hook_lancet_PrivacyHook_onStop(DataUsageLimitActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DataUsageLimitActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_DataUsageLimitActivity__onStop$___twin___();
    }
}
