package com.android.settings.revone;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.TrackerConstants;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class TNTVoiceSettings extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private SettingItemCheck mItemCheckVoiceInputAll;
    private SettingItemCheck mItemCheckVoiceInputCurrent;
    private SettingItemSwitch mSwitchVoiceInput;

    public void com_android_settings_revone_TNTVoiceSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TNTVoiceSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TNTVoiceSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TNTVoiceSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TNTVoiceSettings() {
        super(R.layout.tnt_voice_settings_layout);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mSwitchVoiceInput = (SettingItemSwitch) findViewByIdNullable(R.id.voice_input);
        this.mItemCheckVoiceInputAll = (SettingItemCheck) findViewByIdNullable(R.id.voice_input_all);
        this.mItemCheckVoiceInputCurrent = (SettingItemCheck) findViewByIdNullable(R.id.voice_input_current);
        this.mItemCheckVoiceInputAll.setOnClickListener(this);
        this.mItemCheckVoiceInputCurrent.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mSwitchVoiceInput.setOnCheckedChangeListener(this);
    }

    private void updateViews() {
        ContentResolver r0 = getContentResolver();
        boolean r2 = true;
        if (Settings.Global.getInt(r0, "global_voice_input_switch", 1) != 1) goto L5;
        boolean r1 = true;
    L7:
        if (Settings.Global.getInt(r0, "voice_water_drop_switch", 0) != 1) goto L9;
        boolean r4 = true;
    L11:
        if (Settings.Global.getInt(r0, "cursor_water_drop_switch", 1) == 1) goto L14;
        r2 = false;
    L14:
        this.mSwitchVoiceInput.setChecked(r1);
        updateItemCheckView(r1, r4, r2);
        return;
    L9:
        r4 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateItemCheckView(boolean r1, boolean r2, boolean r3) {
        this.mItemCheckVoiceInputAll.setVisibility(8);
        this.mItemCheckVoiceInputCurrent.setVisibility(8);
        if (r1 == false) goto L6;
        this.mItemCheckVoiceInputAll.setChecked(false);
        this.mItemCheckVoiceInputCurrent.setChecked(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
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
    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4 == this.mItemCheckVoiceInputAll) goto L7;
        if (r4 == this.mItemCheckVoiceInputCurrent) goto L7;
        return;
    L7:
        if (((SettingItemCheck) r4).isChecked() == false) goto L10;
        return;
    L10:
        if (r4 != this.mItemCheckVoiceInputAll) goto L12;
        ?? r5 = 1;
    L13:
        ContentResolver r0 = getContentResolver();
        Settings.Global.putInt(r0, "voice_water_drop_switch", r5);
        Settings.Global.putInt(r0, "cursor_water_drop_switch", 1);
        this.mItemCheckVoiceInputAll.setChecked(r5);
        this.mItemCheckVoiceInputCurrent.setChecked(r5 ^ 1);
        return;
    L12:
        r5 = 0;
        goto L13
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mSwitchVoiceInput.getSwitch()) goto L6;
        Settings.Global.putInt(getContentResolver(), "global_voice_input_switch", r3 ? 1 : 0);
        setWaterDropEnable(this.mContext, r3);
        updateItemCheckView(r3, r3, r3);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.GLOBALL_VOICE_INPUT_BUTTON, r3);
        return;
    }

    public static void setWaterDropEnable(Context r2, boolean r3) {
        ContentResolver r4 = r2.getContentResolver();
        Settings.Global.putInt(r4, "voice_water_drop_switch", 0);
        Settings.Global.putInt(r4, "cursor_water_drop_switch", r3 ? 1 : 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TNTVoiceSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TNTVoiceSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TNTVoiceSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TNTVoiceSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TNTVoiceSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TNTVoiceSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TNTVoiceSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TNTVoiceSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TNTVoiceSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
