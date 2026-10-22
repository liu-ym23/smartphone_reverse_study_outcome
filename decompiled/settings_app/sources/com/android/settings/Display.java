package com.android.settings;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class Display extends LifeHookActivity2 implements View.OnClickListener {
    private DisplayMetrics mDisplayMetrics;
    private float mFontScale;
    private Spinner mFontSize;
    private AdapterView.OnItemSelectedListener mFontSizeChanged;
    private TextView mPreview;
    private TypedValue mTextSizeTyped;

    public void com_android_settings_Display__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_Display__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_Display__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_Display_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_Display_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_Display_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_Display_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_Display_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public Display() {
        this.mFontSizeChanged = new AnonymousClass1(this);
        this.mFontScale = 1.0f;
    }

    static /* synthetic */ float access$002(Display r0, float r1) {
        r0.mFontScale = r1;
        return r1;
    }

    static /* synthetic */ void access$100(Display r0) {
        r0.updateFontScale();
    }

    public void com_android_settings_Display__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.display);
        Spinner r6 = (Spinner) findViewById(R.id.fontSize);
        this.mFontSize = r6;
        r6.setOnItemSelectedListener(this.mFontSizeChanged);
        Resources r0 = getResources();
        ArrayAdapter r1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{r0.getString(R.string.small_font), r0.getString(R.string.medium_font), r0.getString(R.string.large_font)});
        r1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.mFontSize.setAdapter(r1);
        TextView r7 = (TextView) findViewById(R.id.preview);
        this.mPreview = r7;
        r7.setText(r0.getText(R.string.font_size_preview_text));
        Button r8 = (Button) findViewById(R.id.save);
        r8.setText(r0.getText(R.string.font_size_save));
        r8.setOnClickListener(this);
        this.mTextSizeTyped = new TypedValue();
        TypedArray r9 = obtainStyledAttributes(android.R.styleable.TextView);
        r9.getValue(2, this.mTextSizeTyped);
        DisplayMetrics r2 = getResources().getDisplayMetrics();
        DisplayMetrics r3 = new DisplayMetrics();
        this.mDisplayMetrics = r3;
        r3.density = r2.density;
        this.mDisplayMetrics.heightPixels = r2.heightPixels;
        this.mDisplayMetrics.scaledDensity = r2.scaledDensity;
        this.mDisplayMetrics.widthPixels = r2.widthPixels;
        this.mDisplayMetrics.xdpi = r2.xdpi;
        this.mDisplayMetrics.ydpi = r2.ydpi;
        r9.recycle();
    }

    public void com_android_settings_Display__onResume$___twin___() {
        super.onResume();
        float r0 = android.provider.Settings.System.getFloat(getContentResolver(), "font_scale", 1.0f);
        this.mFontScale = r0;
        if (r0 >= 1.0f) goto L6;
        this.mFontSize.setSelection(0);
    L9:
        updateFontScale();
        return;
    L6:
        if (r0 <= 1.0f) goto L8;
        this.mFontSize.setSelection(2);
        goto L9
    L8:
        this.mFontSize.setSelection(1);
        goto L9
    }

    private void updateFontScale() {
        DisplayMetrics r0 = this.mDisplayMetrics;
        r0.scaledDensity = r0.density * this.mFontScale;
        float r1 = this.mTextSizeTyped.getDimension(this.mDisplayMetrics);
        this.mPreview.setTextSize(0, r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        android.provider.Settings.System.putFloat(getContentResolver(), "font_scale", this.mFontScale);
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_Display_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Display r1) {
        com_android_settings_Display_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_Display_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(Display r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        Display r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_Display__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_Display_com_obric_hook_lancet_BatchedActivityLancet_onResume(Display r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_Display_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_Display_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(Display r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_Display_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        Display r5 = r4;
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
    public static void com_android_settings_Display_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(Display r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_Display__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_Display_com_obric_hook_lancet_BatchedActivityLancet_onStop(Display r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_Display_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_Display_com_obric_hook_lancet_PrivacyHookActivity2_onResume(Display r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        Display r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_Display__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_Display_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(Display r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_Display_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_Display_com_obric_hook_lancet_PrivacyHookActivity2_onPause(Display r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        Display r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_Display__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_Display_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(Display r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_Display_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        Display r5 = r3;
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
    public static void com_android_settings_Display_com_obric_hook_lancet_PrivacyHookActivity2_onStop(Display r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        Display r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_Display__onStop$___twin___();
    }
}
