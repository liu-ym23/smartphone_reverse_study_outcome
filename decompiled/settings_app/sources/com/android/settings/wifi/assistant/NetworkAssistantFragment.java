package com.android.settings.wifi.assistant;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.NetworkAssistantFragmentBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.SettingsProviderUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.wfd.WifiDisplaySettings;
import com.android.settings.wfd.WifiDisplaySettingsActivity;
import com.android.settings.wifi.p2p.WifiP2pSettingsActivity;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: compiled from: NetworkAssistantFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/android/settings/wifi/assistant/NetworkAssistantFragment;", "Lcom/android/settings/base/BaseFragment;", "()V", "viewBinding", "Lcom/android/settings/databinding/NetworkAssistantFragmentBinding;", "wifiManager", "Landroid/net/wifi/WifiManager;", "getWifiManager", "()Landroid/net/wifi/WifiManager;", "wifiManager$delegate", "Lkotlin/Lazy;", "getConfigLocationEnforcedAdmin", "Lcom/android/settingslib/RestrictedLockUtils$EnforcedAdmin;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResumeNonInitial", "", "onViewCreated", "view", "onViewStateRestored", "updateViews", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NetworkAssistantFragment extends BaseFragment {
    private NetworkAssistantFragmentBinding viewBinding;
    private final Lazy wifiManager$delegate;

    public static /* synthetic */ void $r8$lambda$0_tG0ahNq_3Nf0nHNf3_hEoH2cM(View r0, CompoundButton r1, boolean r2) {
        onViewCreated$lambda$9$lambda$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$5Dp4Q-DesuWyWzD6g-O0JV7TesY, reason: not valid java name */
    public static /* synthetic */ void m719$r8$lambda$5Dp4QDesuWyWzD6gO0JV7TesY(NetworkAssistantFragment r0, CompoundButton r1, DialogInterface r2, int r3) {
        onViewStateRestored$lambda$13$lambda$12(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$DR2GNoID0cROOQKuec8RzgzRr8w(NetworkAssistantFragment r0, View r1) {
        onViewCreated$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$G9U5U5sM-rtp4hf0CDRZNVd9a8I, reason: not valid java name */
    public static /* synthetic */ void m720$r8$lambda$G9U5U5sMrtp4hf0CDRZNVd9a8I(CompoundButton r0, DialogInterface r1, int r2) {
        onViewStateRestored$lambda$13$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$NT_DGKRl_oUh7a7nVpQivq4ICQ8(NetworkAssistantFragment r0, View r1) {
        onViewCreated$lambda$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$RGO15ddrCgW9kkzIhsAtE5egeok(NetworkAssistantFragment r0, CompoundButton r1, boolean r2) {
        onViewStateRestored$lambda$14(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$SWGs10pxzG4IwANeu_1qqZgGQfk(NetworkAssistantFragment r0, View r1) {
        updateViews$lambda$15(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$_9jwmYdiHv2BRk-IKWZsGB5CyZc, reason: not valid java name */
    public static /* synthetic */ void m721$r8$lambda$_9jwmYdiHv2BRkIKWZsGB5CyZc(NetworkAssistantFragment r0, View r1) {
        onViewCreated$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$b33Il9R53y0p8PgvkPk40Che6Jw(NetworkAssistantFragment r0, View r1) {
        onViewCreated$lambda$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$fGAEHEkXgLkWE0vwC1IQ3ymVS8Q(NetworkAssistantFragment r0, View r1) {
        onViewCreated$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pXJVOYDV3piIbPVzFsisAy914dk(NetworkAssistantFragment r0, View r1) {
        onViewCreated$lambda$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$qgoelPzi__ViPD5cUYC9uqv5KNA(NetworkAssistantFragment r0, CompoundButton r1, boolean r2) {
        onViewStateRestored$lambda$13(r0, r1, r2);
    }

    public void com_android_settings_wifi_assistant_NetworkAssistantFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_wifi_assistant_NetworkAssistantFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_assistant_NetworkAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_assistant_NetworkAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NetworkAssistantFragment() {
        this.wifiManager$delegate = LazyKt.lazy(NetworkAssistantFragment$wifiManager$2.INSTANCE);
    }

    public static final /* synthetic */ NetworkAssistantFragmentBinding access$getViewBinding$p(NetworkAssistantFragment r0) {
        return r0.viewBinding;
    }

    private final WifiManager getWifiManager() {
        return (WifiManager) this.wifiManager$delegate.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        NetworkAssistantFragmentBinding r4 = NetworkAssistantFragmentBinding.inflate(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.viewBinding = r4;
        NetworkAssistantFragmentBinding r5 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L5:
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(r4.pageContainer);
        NetworkAssistantFragmentBinding r0 = this.viewBinding;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L9:
        RelativeLayout r6 = r5.getRoot();
        Intrinsics.checkNotNullExpressionValue(r6, "getRoot(...)");
        return r6;
    L8:
        r5 = r0;
        goto L9
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        NetworkAssistantFragmentBinding r11 = this.viewBinding;
        NetworkAssistantFragmentBinding r1 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L5:
        r11.wifiCellularDataFallback.setOnClickListener(null);
        NetworkAssistantFragmentBinding r12 = this.viewBinding;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r12 = null;
    L8:
        r12.wifiAssistantLocationPosition.setOnClickListener(null);
        NetworkAssistantFragmentBinding r13 = this.viewBinding;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r13 = null;
    L11:
        r13.multiWifi.setOnContentClickListener(new NetworkAssistantFragment$$ExternalSyntheticLambda5(this));
        NetworkAssistantFragmentBinding r14 = this.viewBinding;
        if (r14 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r14 = null;
    L14:
        r14.itemIdWifiP2p.setOnContentClickListener(new NetworkAssistantFragment$$ExternalSyntheticLambda6(this));
        NetworkAssistantFragmentBinding r15 = this.viewBinding;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L17:
        r15.itemIdWifiDisplay.setOnContentClickListener(new NetworkAssistantFragment$$ExternalSyntheticLambda7(this));
        NetworkAssistantFragmentBinding r16 = this.viewBinding;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r16 = null;
    L20:
        r16.itemIdWapiCertManage.setOnContentClickListener(new NetworkAssistantFragment$$ExternalSyntheticLambda8(this));
        NetworkAssistantFragmentBinding r17 = this.viewBinding;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L23:
        r17.itemIdWifiDataUsage.setOnContentClickListener(new NetworkAssistantFragment$$ExternalSyntheticLambda9(this));
        NetworkAssistantFragmentBinding r18 = this.viewBinding;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = null;
    L26:
        OFloatingTitleBar r2 = r18.titleBar;
        Intrinsics.checkNotNullExpressionValue(r2, "titleBar");
        OFloatingTitleBar.addStartAction$default(r2, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null).setOnClickListener(new NetworkAssistantFragment$$ExternalSyntheticLambda10(this));
        NetworkAssistantFragmentBinding r19 = this.viewBinding;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r19 = null;
    L29:
        r19.autoOpenWifi.setOnClickListener(null);
        NetworkAssistantFragmentBinding r110 = this.viewBinding;
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r110 = null;
    L32:
        OCardListItem r111 = r110.wlanSecurityCheck;
        r111.setOnClickListener(null);
        OSwitch r112 = r111.getEndSwitch();
        if (r112 == null) goto L35;
        r112.setOnCheckedChangeListener(new NetworkAssistantFragment$$ExternalSyntheticLambda11(r9));
    L35:
        NetworkAssistantFragmentBinding r20 = this.viewBinding;
        if (r20 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L39:
        LinearLayout r21 = r1.dynamicItems;
        IPrivateDnsItemView r113 = (IPrivateDnsItemView) ServiceManager.getService(IPrivateDnsItemView.class);
        if (r113 == null) goto L42;
        r21.setVisibility(0);
        r21.addView(r113.create(getActivity()));
        return;
    L42:
        r21.setVisibility(8);
        return;
    L38:
        r1 = r20;
        goto L39
    }

    private static final void onViewCreated$lambda$0(NetworkAssistantFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivity(new Intent(r2.getContext(), MultiWifiSettingActivity.class));
    }

    private static final void onViewCreated$lambda$1(NetworkAssistantFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivity(new Intent(r2.getContext(), WifiP2pSettingsActivity.class));
    }

    private static final void onViewCreated$lambda$3(NetworkAssistantFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent(r2.getContext(), WifiDisplaySettingsActivity.class);
        r4.putExtra(WifiDisplaySettings.EXTRA_ENTRY_FLAG, true);
        r2.startActivity(r4);
    }

    private static final void onViewCreated$lambda$4(NetworkAssistantFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent();
        r4.setClassName("com.wapi.wapicertmanage", "com.wapi.wapicertmanage.WapiCertManageActivity");
        r2.startActivity(r4);
    }

    private static final void onViewCreated$lambda$5(NetworkAssistantFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent();
        r4.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.datausage.WifiDataUsageDetailActivity");
        r2.startActivity(r4);
    }

    private static final void onViewCreated$lambda$6(NetworkAssistantFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.finish();
        return;
    }

    private static final void onViewCreated$lambda$9$lambda$8(View r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$view");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        ContentResolver r4 = r1.getContext().getContentResolver();
        if (r3 == false) goto L5;
        String r5 = "1";
    L6:
        Settings.Global.putString(r4, SettingsProviderUtils.WLAN_SECURITY_CHECK, r5);
        TrackerEvent.switchEvent(SettingsProviderUtils.WLAN_SECURITY_CHECK, r3);
        return;
    L5:
        r5 = "0";
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r4) {
        super.onViewStateRestored(r4);
        NetworkAssistantFragmentBinding r5 = this.viewBinding;
        NetworkAssistantFragmentBinding r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L5:
        OSwitch r6 = r5.wifiCellularDataFallback.getEndSwitch();
        if (r6 == null) goto L8;
        r6.setOnCheckedChangeListener(new NetworkAssistantFragment$$ExternalSyntheticLambda3(this));
    L8:
        NetworkAssistantFragmentBinding r7 = this.viewBinding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L11:
        OCardListItem r8 = r7.wifiAssistantLocationPosition;
        if (r8 == null) goto L16;
        OSwitch r9 = r8.getEndSwitch();
        if (r9 == null) goto L16;
        r9.setOnCheckedChangeListener(new NetworkAssistantFragment$$ExternalSyntheticLambda4(this));
    L16:
        NetworkAssistantFragmentBinding r10 = this.viewBinding;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L20:
        OSwitch r11 = r0.autoOpenWifi.getEndSwitch();
        if (r11 == null) goto L23;
        r11.setOnCheckedChangeListener(new AnonymousClass3(this));
    L23:
        updateViews();
        return;
    L19:
        r0 = r10;
        goto L20
    }

    private static final void onViewStateRestored$lambda$13(final NetworkAssistantFragment r13, final CompoundButton r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Intrinsics.checkNotNullParameter(r14, "buttonView");
        if (r15 == false) goto L11;
        Context r16 = r13.getContext();
        if (r16 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(Settings.Global.getString(r16.getContentResolver(), SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI), "1") == false) goto L10;
        return;
    L10:
        FragmentActivity r2 = r13.getActivity();
        Intrinsics.checkNotNull(r2);
        OAlertDialogBuilder.positiveButton$default(OAlertDialogBuilder.negativeButton$default(OAlertDialogBuilder.horizontalButton$default(new OAlertDialogBuilder(r2).autoDismiss(false), false, 1, null).title(R.string.dlg_title_notice).message(R.string.wifi_cellular_data_fallback_dlg_msg), R.string.close, new NetworkAssistantFragment$$ExternalSyntheticLambda1(r14), null, 4, null), R.string.wifi_cellular_data_fallback_dlg_ok, new NetworkAssistantFragment$$ExternalSyntheticLambda2(r13, r14), null, 4, null).show();
        return;
    L11:
        NetworkAssistantFragmentBinding r17 = r13.viewBinding;
        if (r17 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L14:
        Settings.Global.putString(r17.getRoot().getContext().getContentResolver(), SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI, null);
        TrackerEvent.switchEvent(SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI, false);
    }

    private static final void onViewStateRestored$lambda$13$lambda$11(CompoundButton r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "$buttonView");
        r0.setChecked(false);
        r1.dismiss();
    }

    private static final void onViewStateRestored$lambda$13$lambda$12(NetworkAssistantFragment r1, CompoundButton r2, DialogInterface r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$buttonView");
        NetworkAssistantFragmentBinding r5 = r1.viewBinding;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L5:
        Settings.Global.putString(r5.getRoot().getContext().getContentResolver(), SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI, "1");
        r2.setChecked(true);
        r3.dismiss();
        TrackerEvent.switchEvent(SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI, true);
    }

    private static final void onViewStateRestored$lambda$14(NetworkAssistantFragment r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        NetworkAssistantFragmentBinding r4 = r1.viewBinding;
        String r5 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L5:
        ContentResolver r6 = r4.getRoot().getContext().getContentResolver();
        if (r3 == false) goto L8;
        r5 = "1";
    L8:
        Settings.Global.putString(r6, "wifi_scan_always_enabled", r5);
        TrackerEvent.switchEvent("wifi_scan_always_enabled", r3);
    }

    private final void updateViews() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        NetworkAssistantFragmentBinding r1 = this.viewBinding;
        NetworkAssistantFragmentBinding r3 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L8:
        OSwitch r2 = r1.wifiCellularDataFallback.getEndSwitch();
        if (r2 == null) goto L12;
        r2.setChecked(Intrinsics.areEqual(Settings.Global.getString(r0.getContentResolver(), SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI), "1"));
    L12:
        if (getConfigLocationEnforcedAdmin() == null) goto L19;
        NetworkAssistantFragmentBinding r4 = this.viewBinding;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L16:
        OSwitch r5 = r4.wifiAssistantLocationPosition.getEndSwitch();
        if (r5 == null) goto L31;
        r5.setOnClickListener(new NetworkAssistantFragment$$ExternalSyntheticLambda0(this));
    L31:
        NetworkAssistantFragmentBinding r6 = this.viewBinding;
        if (r6 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L34:
        OCardListItem r7 = r6.multiWifi;
        Intrinsics.checkNotNullExpressionValue(r7, "multiWifi");
        if (getWifiManager().getStaConcurrencyForMultiInternetMode() != 2) goto L37;
        String r8 = ResourceUtils.getString(R.string.settings_state_on);
    L38:
        OCardListItem.setEndDetailText$default(r7, r8, 0, 2, null);
        NetworkAssistantFragmentBinding r9 = this.viewBinding;
        if (r9 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L41:
        OCardListItem r10 = r9.autoOpenWifi;
        if (r10 == null) goto L46;
        OSwitch r11 = r10.getEndSwitch();
        if (r11 == null) goto L46;
        r11.setChecked(Intrinsics.areEqual(Settings.Global.getString(r0.getContentResolver(), "wifi_wakeup_enabled"), "1"));
    L46:
        NetworkAssistantFragmentBinding r12 = this.viewBinding;
        if (r12 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L50:
        OCardListItem r13 = r3.wlanSecurityCheck;
        if (r13 == null) goto L56;
        OSwitch r14 = r13.getEndSwitch();
        if (r14 == null) goto L57;
        r14.setChecked(SettingsProviderUtils.isWlanSecurityCheckSwitchEnabled(r0));
        return;
    L57:
        return;
    L56:
        return;
    L49:
        r3 = r12;
        goto L50
    L37:
        r8 = ResourceUtils.getString(R.string.settings_state_off);
        goto L38
    L19:
        NetworkAssistantFragmentBinding r15 = this.viewBinding;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L22:
        OSwitch r16 = r15.wifiAssistantLocationPosition.getEndSwitch();
        if (r16 == null) goto L25;
        r16.setOnClickListener(null);
    L25:
        NetworkAssistantFragmentBinding r17 = this.viewBinding;
        if (r17 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L28:
        OSwitch r18 = r17.wifiAssistantLocationPosition.getEndSwitch();
        if (r18 == null) goto L31;
        r18.setChecked(Intrinsics.areEqual(Settings.Global.getString(r0.getContentResolver(), "wifi_scan_always_enabled"), "1"));
        goto L31
    }

    private static final void updateViews$lambda$15(NetworkAssistantFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(r2.getContext(), r1.getConfigLocationEnforcedAdmin());
        NetworkAssistantFragmentBinding r3 = r1.viewBinding;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L5:
        OSwitch r4 = r3.wifiAssistantLocationPosition.getEndSwitch();
        if (r4 == null) goto L10;
        r4.setChecked(false);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private final RestrictedLockUtils.EnforcedAdmin getConfigLocationEnforcedAdmin() {
        return RestrictedLockUtilsInternal.checkIfRestrictionEnforced(getContext(), "no_config_location", UserHandle.myUserId());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_assistant_NetworkAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NetworkAssistantFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_assistant_NetworkAssistantFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_assistant_NetworkAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NetworkAssistantFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_assistant_NetworkAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_assistant_NetworkAssistantFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NetworkAssistantFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_assistant_NetworkAssistantFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
