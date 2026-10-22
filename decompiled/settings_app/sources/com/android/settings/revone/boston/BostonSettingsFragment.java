package com.android.settings.revone.boston;

import android.casthal.CasthalManager;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.BytedanceEventReceiver;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.revone.AboutBostonFragment;
import com.android.settings.revone.CustomChargeFragment;
import com.android.settings.revone.WirelessTntAutoFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingItemCheckSimpleText;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.OMenuDialog;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class BostonSettingsFragment extends BaseFragment implements View.OnClickListener {
    private static final int UPDATE_VIEW_DELAY_TIME = 100;
    private SettingItemText mAboutBoston;
    private SettingItemCheckSimpleText mChargeAlways;
    private SettingItemCheckSimpleText mChargeCustom;
    private ContentObserver mChargeUpPhoneMode;
    private Handler mHandler;
    private SettingItemText mOta;
    private View mOtaGap;
    private SettingItemSwitch mRelayMode;
    private ContentObserver mRelayModeObserver;
    private boolean mSupportWireless;
    private SettingItemText mWirelessTntAuto;
    private ContentObserver mWirelessTntAutoObserver;

    /* JADX INFO: renamed from: com.android.settings.revone.boston.BostonSettingsFragment$2, reason: invalid class name */
    class AnonymousClass2 extends ContentObserver {
        final /* synthetic */ BostonSettingsFragment this$0;

        AnonymousClass2(BostonSettingsFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        /* JADX INFO: renamed from: lambda$onChange$0$com-android-settings-revone-boston-BostonSettingsFragment$2, reason: not valid java name */
        /* synthetic */ void m567x782ab018() {
            BostonSettingsFragment.access$100(this.this$0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4) {
            BostonSettingsFragment.access$000(this.this$0).postDelayed(new BostonSettingsFragment$2$$ExternalSyntheticLambda0(this), 100);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.revone.boston.BostonSettingsFragment$3, reason: invalid class name */
    class AnonymousClass3 extends ContentObserver {
        final /* synthetic */ BostonSettingsFragment this$0;

        AnonymousClass3(BostonSettingsFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        /* JADX INFO: renamed from: lambda$onChange$0$com-android-settings-revone-boston-BostonSettingsFragment$3, reason: not valid java name */
        /* synthetic */ void m568x782ab019() {
            BostonSettingsFragment.access$200(this.this$0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4) {
            BostonSettingsFragment.access$000(this.this$0).postDelayed(new BostonSettingsFragment$3$$ExternalSyntheticLambda0(this), 100);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.revone.boston.BostonSettingsFragment$4, reason: invalid class name */
    class AnonymousClass4 extends ContentObserver {
        final /* synthetic */ BostonSettingsFragment this$0;

        AnonymousClass4(BostonSettingsFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4) {
            super.onChange(r4);
            BostonSettingsFragment.access$000(this.this$0).postDelayed(new BostonSettingsFragment$4$$ExternalSyntheticLambda0(this), 100);
        }

        /* JADX INFO: renamed from: lambda$onChange$0$com-android-settings-revone-boston-BostonSettingsFragment$4, reason: not valid java name */
        /* synthetic */ void m569x782ab01a() {
            BostonSettingsFragment.access$300(this.this$0);
        }
    }

    public void com_android_settings_revone_boston_BostonSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_boston_BostonSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_boston_BostonSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public BostonSettingsFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mChargeUpPhoneMode = new AnonymousClass2(this, null);
        this.mWirelessTntAutoObserver = new AnonymousClass3(this, null);
        this.mRelayModeObserver = new AnonymousClass4(this, null);
    }

    static /* synthetic */ Handler access$000(BostonSettingsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$100(BostonSettingsFragment r0) {
        r0.updateChargeMode();
    }

    static /* synthetic */ void access$200(BostonSettingsFragment r0) {
        r0.updateWirelessTntAutoStatus();
    }

    static /* synthetic */ void access$300(BostonSettingsFragment r0) {
        r0.updateRelayModeView();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.boston_settings_layout, r3, false);
        View r5 = findViewByIdNullable(R.id.wireless_layout);
        this.mOta = (SettingItemText) findViewByIdNullable(R.id.ota);
        this.mOtaGap = findViewByIdNullable(R.id.ota_gap);
        boolean r6 = CasthalManager.getInstance(getContext()).hasWirelessCapabilitie();
        this.mSupportWireless = r6;
        if (r6 == false) goto L5;
        r5.setVisibility(0);
        SettingItemSwitch r7 = (SettingItemSwitch) findViewByIdNullable(R.id.relay_mode);
        this.mRelayMode = r7;
        r7.setVisibility(0);
        this.mRelayMode.setOnCheckedChangeListener(new BostonSettingsFragment$$ExternalSyntheticLambda0(this));
        findViewByIdNullable(R.id.relay_tips).setVisibility(0);
        SettingItemText r8 = (SettingItemText) findViewByIdNullable(R.id.wireless_tnt_auto);
        this.mWirelessTntAuto = r8;
        r8.setOnClickListener(this);
        this.mOta.setBackgroundResource(R.drawable.selector_boston_ota_bg);
        this.mOta.getTitleView().setTextColor(this.mContext.getResources().getColor(R.color.setting_item_text_red));
        this.mOta.getSubTitleView().setTextColor(this.mContext.getResources().getColor(R.color.setting_item_text_red));
        this.mOta.getArrowImageView().setImageResource(R.drawable.item_arrow_red);
        this.mOta.setOnClickListener(this);
    L5:
        this.mChargeAlways = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.charge_always);
        SettingItemCheckSimpleText r9 = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.charge_custom);
        this.mChargeCustom = r9;
        r9.setIconArrowListener(new BostonSettingsFragment$$ExternalSyntheticLambda1(this));
        this.mChargeAlways.setOnClickListener(this);
        this.mChargeCustom.setOnClickListener(this);
        SettingItemText r10 = (SettingItemText) findViewByIdNullable(R.id.about_boston);
        this.mAboutBoston = r10;
        if (r10 == null) goto L9;
        r10.setOnClickListener(this);
    L9:
        return this.mRootView;
    }

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
    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-revone-boston-BostonSettingsFragment, reason: not valid java name */
    /* synthetic */ void m564x73622e9b(CompoundButton r2, boolean r3) {
        Settings.Global.putInt(getContentResolver(), "cast_relay_mode", r3 ? 1 : 0);
        this.mRelayMode.setEnabled(!r3);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-revone-boston-BostonSettingsFragment, reason: not valid java name */
    /* synthetic */ void m565x8417fb5c(View r1) {
        start(CustomChargeFragment.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void updateViews() {
        initView();
        boolean r0 = PreferenceMgr.getInstance(this.mContext).getBoolean(BytedanceEventReceiver.PREF_KEY_SHOW_BOSTON_OTA, false);
        if (this.mSupportWireless == false) goto L6;
        if (r0 == false) goto L6;
        this.mOta.setVisibility(0);
        this.mOtaGap.setVisibility(0);
        return;
    L6:
        this.mOta.setVisibility(8);
        this.mOtaGap.setVisibility(8);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void com_android_settings_revone_boston_BostonSettingsFragment__onResume$___twin___() {
        super.onResume();
        registerContentObserver();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unRegisterContentObserver();
    }

    private void initView() {
        if (this.mSupportWireless == false) goto L5;
        updateRelayModeView();
        updateWirelessTntAutoStatus();
    L5:
        updateChargeMode();
        this.mChargeCustom.setSummary(getString(R.string.boston_charge_mode_custom_summary) + Settings.Global.getInt(getContentResolver(), "charge_up_max_power", 50) + "%");
    }

    private void updateRelayModeView() {
        boolean r2 = false;
        if (Settings.Global.getInt(getContentResolver(), "cast_relay_mode", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mRelayMode.setChecked(r0);
        boolean r3 = CasthalManager.getInstance(this.mContext).isVuartConnected();
        SettingItemSwitch r4 = this.mRelayMode;
        if (r3 == false) goto L10;
        if (r0 == true) goto L10;
        r2 = true;
    L10:
        r4.setEnabled(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void updateChargeMode() {
        boolean r2 = true;
        int r0 = Settings.Global.getInt(getContentResolver(), "charge_up_phone_mode", 1);
        SettingItemCheckSimpleText r1 = this.mChargeAlways;
        if (r0 != 1) goto L5;
        boolean r4 = true;
    L6:
        r1.setChecked(r4);
        SettingItemCheckSimpleText r5 = this.mChargeCustom;
        if (r0 == 2) goto L10;
        r2 = false;
    L10:
        r5.setChecked(r2);
        return;
    L5:
        r4 = false;
        goto L6
    }

    private void updateWirelessTntAutoStatus() {
        boolean r2 = false;
        if (Settings.Global.getInt(getContentResolver(), "wireless_tnt_auto", 0) != 1) goto L5;
        r2 = true;
    L5:
        SettingItemText r3 = this.mWirelessTntAuto;
        if (r2 == false) goto L8;
        int r0 = R.string.wireless_tnt_enabled;
    L9:
        r3.setSubTitle(r0);
        return;
    L8:
        r0 = R.string.wireless_tnt_disabled;
        goto L9
    }

    private void resetBoston() {
        OMenuDialog r0 = new OMenuDialog(getContext());
        r0.setTitle(R.string.boston_reset_dialog_title);
        r0.setPositiveButton(R.string.boston_reset_title, new BostonSettingsFragment$$ExternalSyntheticLambda2(this));
        r0.setPositiveRedBg(true);
        r0.show();
    }

    /* JADX INFO: renamed from: lambda$resetBoston$2$com-android-settings-revone-boston-BostonSettingsFragment, reason: not valid java name */
    /* synthetic */ void m566x45a8d0ff(View r3) {
        Settings.Global.putInt(getContentResolver(), "cast_relay_mode", 0);
        Settings.Global.putInt(getContentResolver(), "wireless_tnt_auto", 0);
        Settings.Global.putInt(getContentResolver(), "wireless_lighten_auto", 1);
        initView();
        CasthalManager.getInstance(this.mContext).requestBootMode(2, new AnonymousClass1(this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        new Intent();
        switch(r3.getId()) {
            case 2131427381: goto L10;
            case 2131428033: goto L9;
            case 2131428035: goto L8;
            case 2131430246: goto L7;
            case 2131430556: goto L6;
            case 2131431771: goto L5;
            default: goto L17;
        };
    L5:
        start(WirelessTntAutoFragment.class);
        return;
    L6:
        resetBoston();
        return;
    L7:
        Intent r4 = new Intent("com.bytedanceos.boston.ota_receiver.SETTING_BOSTON_OTA_CLICK");
        this.mContext.sendBroadcast(r4);
        return;
    L8:
        Settings.Global.putInt(getContentResolver(), "charge_up_phone_mode", 2);
        updateChargeMode();
        return;
    L9:
        Settings.Global.putInt(getContentResolver(), "charge_up_phone_mode", 1);
        updateChargeMode();
        return;
    L10:
        start(AboutBostonFragment.class);
        return;
    }

    private void registerContentObserver() {
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("charge_up_phone_mode"), true, this.mChargeUpPhoneMode);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("wireless_tnt_auto"), true, this.mWirelessTntAutoObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("cast_relay_mode"), true, this.mRelayModeObserver);
    }

    private void unRegisterContentObserver() {
        getContentResolver().unregisterContentObserver(this.mChargeUpPhoneMode);
        getContentResolver().unregisterContentObserver(this.mWirelessTntAutoObserver);
        getContentResolver().unregisterContentObserver(this.mRelayModeObserver);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_boston_BostonSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BostonSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_boston_BostonSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_boston_BostonSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BostonSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_boston_BostonSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_boston_BostonSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BostonSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_boston_BostonSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
