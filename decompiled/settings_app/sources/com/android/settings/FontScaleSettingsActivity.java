package com.android.settings;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class FontScaleSettingsActivity extends BaseActivity {
    public static final String EXTRA_FONT_SIZE = "extra_font_size";
    public static final String EXTRA_REQUEST_AS_RESULT = "extra_request_as_result";
    private BaseAdapter mAdapter;
    private final Configuration mCurConfig;
    private int mCurrentIndex;
    private int mNormalFontSizePixel;
    private ArrayList<String> mOptionsList;
    private boolean mRequestAsResult;
    private ArrayList<String> mValuesList;

    /* JADX INFO: renamed from: com.android.settings.FontScaleSettingsActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class FontAdapter extends BaseAdapter {
        final /* synthetic */ FontScaleSettingsActivity this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private FontAdapter(FontScaleSettingsActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ FontAdapter(FontScaleSettingsActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return FontScaleSettingsActivity.access$100(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(final int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
        L7:
            r5 = View.inflate(this.this$0, R.layout.list_content_item_check_oui_2, null);
            OCardListItem r7 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.item_check));
            r5.setTag(r7);
        L8:
            r7.setTitle((CharSequence) FontScaleSettingsActivity.access$100(this.this$0).get(r4));
            int r2 = 0;
            r7.getTitleView().setTextSize(0, FontScaleSettingsActivity.access$300(this.this$0) * Float.valueOf((String) FontScaleSettingsActivity.access$200(this.this$0).get(r4)).floatValue());
            OCardListItemUtils.setCustomEndImageView(r7);
            if (r4 != FontScaleSettingsActivity.access$400(this.this$0)) goto L11;
            r7.showCustomEnd(true);
        L12:
            if (r4 != 0) goto L19;
            if (r4 == (getCount() - 1)) goto L17;
            r2 = 1;
        L17:
            r7.setCardPosition(r2);
        L22:
            r7.setOnContentClickListener(new AnonymousClass1(this, r4));
            return r5;
        L19:
            if (r4 != (getCount() - 1)) goto L21;
            r7.setCardPosition(3);
            goto L22
        L21:
            r7.setCardPosition(2);
            goto L22
        L11:
            r7.showCustomEnd(false);
            goto L12
        L4:
            if ((r5 instanceof OCardListItem) == false) goto L7;
            r7 = (OCardListItem) r5;
            goto L8
        }
    }

    public void com_android_settings_FontScaleSettingsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_FontScaleSettingsActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_FontScaleSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_FontScaleSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FontScaleSettingsActivity() {
        this.mOptionsList = new ArrayList();
        this.mValuesList = new ArrayList();
        this.mCurConfig = new Configuration();
    }

    static /* synthetic */ ArrayList access$100(FontScaleSettingsActivity r0) {
        return r0.mOptionsList;
    }

    static /* synthetic */ ArrayList access$200(FontScaleSettingsActivity r0) {
        return r0.mValuesList;
    }

    static /* synthetic */ int access$300(FontScaleSettingsActivity r0) {
        return r0.mNormalFontSizePixel;
    }

    static /* synthetic */ int access$400(FontScaleSettingsActivity r0) {
        return r0.mCurrentIndex;
    }

    static /* synthetic */ int access$402(FontScaleSettingsActivity r0, int r1) {
        r0.mCurrentIndex = r1;
        return r1;
    }

    static /* synthetic */ BaseAdapter access$500(FontScaleSettingsActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$600(FontScaleSettingsActivity r0) {
        return r0.mRequestAsResult;
    }

    static /* synthetic */ void access$700(FontScaleSettingsActivity r0, float r1) {
        r0.sendSettingAsResult(r1);
    }

    static /* synthetic */ void access$800(FontScaleSettingsActivity r0, float r1) {
        r0.setFontSize(r1);
    }

    public void com_android_settings_FontScaleSettingsActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.options_layout);
        initFontScaleSetting();
        Intent r5 = getIntent();
        boolean r0 = r5.getBooleanExtra("extra_request_as_result", false);
        this.mRequestAsResult = r0;
        if (r0 == false) goto L5;
        this.mCurrentIndex = getCurrentFontIndex(r5.getFloatExtra(EXTRA_FONT_SIZE, Utils.getCurrentFontScale()));
    L6:
        ListView r6 = (ListView) findViewById(R.id.options_list);
        this.mNormalFontSizePixel = getResources().getDimensionPixelSize(R.dimen.settings_item_normal_size_in_dp_unit);
        r6.addHeaderView(Utils.inflateListTransparentHeader(this, r6, false));
        FontAdapter r1 = new FontAdapter(this, null);
        this.mAdapter = r1;
        r6.setAdapter(r1);
        ((OFloatingTitleBar) findViewById(R.id.view_title)).setCenterTitle(getString(R.string.font_size));
        setupBackBtnOnTitle();
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(findViewById(R.id.fake_status_bar));
        return;
    L5:
        this.mCurrentIndex = getCurrentFontIndex(Utils.getCurrentFontScale());
        goto L6
    }

    private void initFontScaleSetting() {
        String[] r0 = getResources().getStringArray(R.array.font_scale_entries);
        String[] r1 = getResources().getStringArray(R.array.font_scale_values);
        this.mOptionsList.clear();
        this.mValuesList.clear();
        this.mOptionsList.addAll(Arrays.asList(r0));
        this.mValuesList.addAll(Arrays.asList(r1));
    }

    private void sendSettingAsResult(float r3) {
        Intent r0 = new Intent();
        r0.putExtra(EXTRA_FONT_SIZE, r3);
        setResult(-1, r0);
        finish();
    }

    private void setFontSize(float r3) {
        OLog.d("Settings", "selected font size:" + r3);
        ContentResolver r0 = this.mContext.getContentResolver();
        android.provider.Settings.System.putFloat(r0, "font_scale", r3);
        android.provider.Settings.System.putString(r0, "home_font_scale_setter", getPackageName());
    }

    private int getCurrentFontIndex(float r1) {
        return this.mValuesList.indexOf(Float.toString(r1));
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FontScaleSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FontScaleSettingsActivity r1) {
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(FontScaleSettingsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FontScaleSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_FontScaleSettingsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(FontScaleSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FontScaleSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FontScaleSettingsActivity r5 = r4;
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
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FontScaleSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_FontScaleSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(FontScaleSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_FontScaleSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(FontScaleSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FontScaleSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_FontScaleSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FontScaleSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(FontScaleSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FontScaleSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_FontScaleSettingsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FontScaleSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FontScaleSettingsActivity r5 = r3;
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
    public static void com_android_settings_FontScaleSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(FontScaleSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FontScaleSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_FontScaleSettingsActivity__onStop$___twin___();
    }
}
