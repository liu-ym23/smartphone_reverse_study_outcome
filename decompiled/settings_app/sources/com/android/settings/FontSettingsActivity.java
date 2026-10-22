package com.android.settings;

import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCheck;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class FontSettingsActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private BaseAdapter mAdapter;
    private final Configuration mCurConfig;
    private int mCurrentIndex;
    private ListContentItemText mCustomiseFont;
    private AlertDialog mDialog;
    private EditText mEditor;
    private LayoutInflater mInflater;
    private String[] mOptions;
    private ListView mOptionsListView;
    private String[] values;

    private class FontAdapter extends BaseAdapter {
        final /* synthetic */ FontSettingsActivity this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private FontAdapter(FontSettingsActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ FontAdapter(FontSettingsActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return FontSettingsActivity.access$600(this.this$0).length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
        L7:
            ViewHolder r7 = new ViewHolder();
            r5 = FontSettingsActivity.access$700(this.this$0).inflate(R.layout.option_item_layout, null);
            r7.contentItemCheck = (ListContentItemCheck) r5.findViewById(R.id.font_size_type);
            r5.setTag(r7);
        L8:
            boolean r1 = true;
            if (getCount() != 1) goto L11;
            r7.contentItemCheck.setBackgroundStyle(1);
        L17:
            r7.contentItemCheck.setTitle(FontSettingsActivity.access$600(this.this$0)[r4]);
            ListContentItemCheck r8 = r7.contentItemCheck;
            if (r4 == FontSettingsActivity.access$800(this.this$0)) goto L21;
            r1 = false;
        L21:
            r8.setChecked(r1);
            return r5;
        L11:
            if (r4 != 0) goto L14;
            r7.contentItemCheck.setBackgroundStyle(2);
            goto L17
        L14:
            if (r4 != (getCount() - 1)) goto L16;
            r7.contentItemCheck.setBackgroundStyle(4);
            goto L17
        L16:
            r7.contentItemCheck.setBackgroundStyle(3);
            goto L17
        L4:
            if ((r5.getTag() instanceof ViewHolder) == false) goto L7;
            r7 = (ViewHolder) r5.getTag();
            goto L8
        }
    }

    static class ViewHolder {
        ListContentItemCheck contentItemCheck;

        ViewHolder() {
        }
    }

    public void com_android_settings_FontSettingsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_FontSettingsActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_FontSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_FontSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FontSettingsActivity() {
        this.mCurConfig = new Configuration();
    }

    static /* synthetic */ EditText access$100(FontSettingsActivity r0) {
        return r0.mEditor;
    }

    static /* synthetic */ void access$200(FontSettingsActivity r0, float r1) {
        r0.setFontSize(r1);
    }

    static /* synthetic */ float access$300(FontSettingsActivity r0) {
        return r0.getCurrentFontScale();
    }

    static /* synthetic */ View access$400(FontSettingsActivity r0, String r1) {
        return r0.createDialogView(r1);
    }

    static /* synthetic */ AlertDialog access$500(FontSettingsActivity r0) {
        return r0.mDialog;
    }

    static /* synthetic */ AlertDialog access$502(FontSettingsActivity r0, AlertDialog r1) {
        r0.mDialog = r1;
        return r1;
    }

    static /* synthetic */ String[] access$600(FontSettingsActivity r0) {
        return r0.mOptions;
    }

    static /* synthetic */ LayoutInflater access$700(FontSettingsActivity r0) {
        return r0.mInflater;
    }

    static /* synthetic */ int access$800(FontSettingsActivity r0) {
        return r0.mCurrentIndex;
    }

    public void com_android_settings_FontSettingsActivity__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        setContentView(R.layout.options_layout);
        this.mOptionsListView = (ListView) findViewById(R.id.options_list);
        this.mOptions = getResources().getStringArray(R.array.font_size_entries);
        this.values = getResources().getStringArray(R.array.font_size_values);
        this.mInflater = LayoutInflater.from(this);
        this.mOptionsListView.setOnItemClickListener(this);
        FontAdapter r3 = new FontAdapter(this, null);
        this.mAdapter = r3;
        this.mOptionsListView.setAdapter(r3);
        this.mCurrentIndex = getCurrentFontIndex();
        setupCustomiseView();
        setupBackBtnOnTitle();
    }

    private void setupCustomiseView() {
        LinearLayout r0 = (LinearLayout) this.mInflater.inflate(R.layout.font_customize_layout, null);
        ListContentItemText r1 = (ListContentItemText) r0.findViewById(R.id.custom_font_size);
        this.mCustomiseFont = r1;
        r1.setTitle("自定义");
        this.mCustomiseFont.setArrowVisible(false);
        this.mCustomiseFont.setOnClickListener(new AnonymousClass1(this));
        this.mOptionsListView.addHeaderView(r0);
        setupCustomiseSize();
    }

    private View createDialogView(String r4) {
        View r0 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.dialog_edittext, null);
        OEditText r1 = ((OInputView) r0.findViewById(R.id.edittext)).getVInput();
        this.mEditor = r1;
        r1.addTextChangedListener(new AnonymousClass2(this));
        this.mEditor.setInputType(8194);
        this.mEditor.setSingleLine();
        this.mEditor.setText(r4);
        this.mEditor.setSelection(0, r4.length());
        return r0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        int r5 = r3 - 1;
        if (r5 < 0) goto L6;
        setFontSize(Float.valueOf(this.values[r5]).floatValue());
        this.mCurrentIndex = r5;
        this.mAdapter.notifyDataSetChanged();
        return;
    }

    private void setupCustomiseSize() {
        int r0 = getCurrentFontIndex();
        this.mCustomiseFont.setSubtitle(String.valueOf(getCurrentFontScale()));
        TextView r3 = this.mCustomiseFont.getSubTitleView();
        if (r0 < 0) goto L5;
        int r1 = 8;
    L6:
        r3.setVisibility(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private void setFontSize(float r2) {
        finish();
        android.provider.Settings.System.putFloat(this.mContext.getContentResolver(), "font_scale", r2);
    }

    private float getCurrentFontScale() {
        this.mCurConfig.updateFrom(ActivityManagerNative.getDefault().getConfiguration());     // Catch: RemoteException -> L5
    L4:
        return this.mCurConfig.fontScale;
    }

    private int getCurrentFontIndex() {
        float r0 = getCurrentFontScale();
        int r1 = 0;
    L3:
        String[] r2 = this.values;
        if (r1 >= r2.length) goto L9;
        if (r0 == Float.parseFloat(r2[r1].toString())) goto L13;
        r1 = r1 + 1;
        goto L3
    L13:
        return r1;
    L9:
        return -1;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FontSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FontSettingsActivity r1) {
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(FontSettingsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FontSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_FontSettingsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(FontSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FontSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FontSettingsActivity r5 = r4;
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
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FontSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_FontSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(FontSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_FontSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(FontSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FontSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_FontSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FontSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(FontSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FontSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_FontSettingsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FontSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_FontSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FontSettingsActivity r5 = r3;
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
    public static void com_android_settings_FontSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(FontSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FontSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_FontSettingsActivity__onStop$___twin___();
    }
}
