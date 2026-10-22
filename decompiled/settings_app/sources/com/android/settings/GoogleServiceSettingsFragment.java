package com.android.settings;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleServiceSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final String DISABLE_GMS_APPS = "disable_gms_apps";
    protected OCardListItem mGoogleSettingBtn;
    protected OCardListItem mSwitchService;
    protected OSwitch mSwitchServiceSwitch;
    private int mTitleStringResId;

    public void com_android_settings_GoogleServiceSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_GoogleServiceSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_GoogleServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_GoogleServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public GoogleServiceSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.google_service_settings, r3, false);
        this.mTitleStringResId = R.string.google_service_title;
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.switch_google_service);
        this.mSwitchService = r5;
        r5.setDefaultCustomEndView(1);
        this.mSwitchService.showCustomEnd(true);
        this.mSwitchService.showSubTitle(true);
        this.mSwitchService.getSubTitleView().setMaxLines(5);
        this.mSwitchServiceSwitch = (OSwitch) this.mSwitchService.getCustomEndView();
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.item_google_settings);
        this.mGoogleSettingBtn = r6;
        r6.setOnContentClickListener(new GoogleServiceSettingsFragment$$ExternalSyntheticLambda0(this));
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-GoogleServiceSettingsFragment, reason: not valid java name */
    /* synthetic */ void m142x2f91dd0a(View r1) {
        onClick(this.mGoogleSettingBtn);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        if (android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), DISABLE_GMS_APPS, -1) == (-1)) goto L5;
    L7:
        updateServiceViews();
        return;
    L5:
        if (android.provider.Settings.Secure.putInt(this.mContext.getContentResolver(), DISABLE_GMS_APPS, 1) == true) goto L7;
        OLog.e(this.TAG, String.format("putInt %s failed", new Object[]{DISABLE_GMS_APPS}));
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateServiceViews();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateServiceViews();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void updateServiceViews() {
        int r1 = 0;
        if (android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), DISABLE_GMS_APPS, -1) != 0) goto L5;
        ?? r0 = 1;
    L6:
        this.mSwitchServiceSwitch.setOnCheckedChangeListener(null);
        this.mSwitchServiceSwitch.setChecked(r0);
        this.mSwitchServiceSwitch.setOnCheckedChangeListener(this);
        this.mSwitchService.setCardPosition(r0);
        OCardListItem r4 = this.mGoogleSettingBtn;
        if (r0 != 0) goto L10;
        r1 = 8;
    L10:
        r4.setVisibility(r1);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3 == this.mSwitchServiceSwitch) goto L5;
        return;
    L5:
        if (android.provider.Settings.Secure.putInt(this.mContext.getContentResolver(), DISABLE_GMS_APPS, !r4 ? 1 : 0) == true) goto L7;
        OLog.e(this.TAG, String.format("putInt %s failed", new Object[]{DISABLE_GMS_APPS}));
    L7:
        updateServiceViews();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        Intent r0 = new Intent();
        r0.putExtra("back_text_id", this.mTitleStringResId);
        if (r4.getId() != R.id.item_google_settings) goto L6;
        r0.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.app.settings.GoogleSettingsLink"));
        SettingsTracker.onItemClick(2609);
        Utils.startActivity(this._mActivity, r0, 0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_GoogleServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(GoogleServiceSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_GoogleServiceSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_GoogleServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(GoogleServiceSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_GoogleServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_GoogleServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(GoogleServiceSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_GoogleServiceSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
