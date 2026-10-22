package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.android.settings.base.BaseFragment;
import com.android.settings.nfc.NfcSettingsAdapterExt;
import com.android.settings.nfc.PaymentBackend;
import com.android.settings.nfc.PaymentSettingsFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.toast.OToast;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NfcSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final String NFC_DND_MODE = "nfc_dnd_mode";
    private static final String NFC_REPAIR_ACTION = "com.obric.cae.action.nfcffd";
    private static final String NFC_REPAIR_COMPLETED_ACTION = "com.obric.cae.action.nfcffd_state";
    private static final String NFC_REPAIR_COMPLETED_ACTION_STATE = "state";
    private static final String NFC_REPAIR_PACKAGE = "com.obric.cae";
    public static final String TAG = "NfcSettingsFragment";
    private static final int THREE_SECONDS = 3000;
    private OCardListItem mDefaultPaymentService;
    private boolean mIsNfcRepairing;
    private OCardListItem mNFCWallet;
    private NfcAdapter mNfcAdapter;
    private NfcEnabler mNfcEnabler;
    private View mNfcFeatures;
    private ContentObserver mNfcReaderModeObserver;
    private OAlertDialog mNfcRepairAlertDialog;
    private OToast mNfcRepairCompletedToast;
    private OCardListItem mNfcRepairItem;
    private StatusDialog mNfcRepairStatusDialog;
    private NfcSettingsAdapterExt mNfcSettingsAdapterExt;
    private PaymentBackend mPaymentBackend;
    private final BroadcastReceiver mStateReceiver;
    private OSwitch mSwitchNfcReader;
    private OCardListItem mViewSwitchAndroidBeam;
    private OCardListItem mViewSwitchNfc;
    private OCardListItem mViewSwitchNfcReader;

    public void com_android_settings_NfcSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_NfcSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_NfcSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_NfcSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NfcSettingsFragment() {
        this.mIsNfcRepairing = false;
        this.mStateReceiver = new AnonymousClass1(this);
        final Handler r1 = null;
        this.mNfcReaderModeObserver = new AnonymousClass2(this, r1);
    }

    static /* synthetic */ NfcAdapter access$000(NfcSettingsFragment r0) {
        return r0.mNfcAdapter;
    }

    static /* synthetic */ NfcEnabler access$100(NfcSettingsFragment r0) {
        return r0.mNfcEnabler;
    }

    static /* synthetic */ void access$200(NfcSettingsFragment r0) {
        r0.updateSubTitle();
    }

    static /* synthetic */ PaymentBackend access$300(NfcSettingsFragment r0) {
        return r0.mPaymentBackend;
    }

    static /* synthetic */ OCardListItem access$400(NfcSettingsFragment r0) {
        return r0.mDefaultPaymentService;
    }

    static /* synthetic */ OCardListItem access$500(NfcSettingsFragment r0) {
        return r0.mViewSwitchNfcReader;
    }

    static /* synthetic */ void access$600(NfcSettingsFragment r0) {
        r0.checkSimAndUpdateVisibleState();
    }

    static /* synthetic */ void access$700(NfcSettingsFragment r0, boolean r1) {
        r0.nfcRepairCompleted(r1);
    }

    static /* synthetic */ boolean access$800(NfcSettingsFragment r0) {
        return r0.isNfcReaderModeEnabled();
    }

    static /* synthetic */ OSwitch access$900(NfcSettingsFragment r0) {
        return r0.mSwitchNfcReader;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.nfc_settings_layout, r4, false);
        this.mViewSwitchNfc = (OCardListItem) findViewByIdNullable(R.id.item_id_nfc);
        this.mNfcFeatures = findViewByIdNullable(R.id.nfc_features);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.item_id_nfc_reader);
        this.mViewSwitchNfcReader = r6;
        this.mSwitchNfcReader = r6.getEndSwitch();
        this.mViewSwitchAndroidBeam = (OCardListItem) findViewByIdNullable(R.id.item_id_android_beam);
        this.mNfcEnabler = new NfcEnabler(this._mActivity, this.mViewSwitchNfc.getEndSwitch(), this.mViewSwitchAndroidBeam);
        ((FrameLayout) this.mRootView.findViewById(R.id.banner)).addView(UIUtils.buildNoScaledView(this._mActivity, R.layout.view_banner_nfc));
        NfcAdapter r7 = NfcAdapter.getDefaultAdapter(this.mContext);
        this.mNfcAdapter = r7;
        this.mNfcSettingsAdapterExt = NfcSettingsAdapterExt.getInstance(r7);
        this.mPaymentBackend = new PaymentBackend(this.mContext);
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.default_payment_service);
        this.mDefaultPaymentService = r8;
        r8.setOnContentClickListener(new NfcSettingsFragment$$ExternalSyntheticLambda2(this));
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.item_id_wallet);
        this.mNFCWallet = r9;
        r9.setOnContentClickListener(new NfcSettingsFragment$$ExternalSyntheticLambda3(this));
        if (ProductFlavor.isNeridaHk() == false) goto L6;
        this.mNFCWallet.setVisibility(8);
        this.mViewSwitchNfcReader.setCardPosition(0);
    L6:
        if (SettingsFeature.isWalletNfcFeatureEnabled(this.mContext) == true) goto L8;
        this.mNFCWallet.setEnabled(false);
        this.mNFCWallet.setSubTitle(getString(R.string.nfc_wallet_not_install_subtitle));
        this.mNFCWallet.showSubTitle(true);
    L8:
        IntentFilter r10 = new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED");
        r10.addAction("android.intent.action.SIM_STATE_CHANGED");
        r10.addAction(NFC_REPAIR_COMPLETED_ACTION);
        registerReceiver(this.mStateReceiver, r10);
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor(NFC_DND_MODE), false, this.mNfcReaderModeObserver);
        OCardListItem r11 = (OCardListItem) findViewByIdNullable(R.id.nfc_repair_item);
        this.mNfcRepairItem = r11;
        r11.setOnContentClickListener(this);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((LinearLayout) findViewByIdNullable(R.id.page_container));
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-NfcSettingsFragment, reason: not valid java name */
    /* synthetic */ void m173lambda$onCreateView$0$comandroidsettingsNfcSettingsFragment(View r1) {
        onClick(this.mDefaultPaymentService);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-NfcSettingsFragment, reason: not valid java name */
    /* synthetic */ void m174lambda$onCreateView$1$comandroidsettingsNfcSettingsFragment(View r1) {
        onClick(this.mNFCWallet);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (this.mNfcAdapter == null) goto L6;
        updateSubTitle();
    L6:
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r1).setClipChildren(false);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        this.mSwitchNfcReader.setOnCheckedChangeListener(this);
        this.mSwitchNfcReader.setChecked(isNfcReaderModeEnabled());
        updateViews();
    }

    private void updateViews() {
        this.mNfcEnabler.resume();
        if (this.mNfcAdapter == null) goto L17;
        updateSubTitle();
        if (this.mNfcAdapter.isEnabled() == true) goto L7;
    L10:
        this.mDefaultPaymentService.setEnabled(false);
    L12:
        if (this.mNfcAdapter.isEnabled() == true) goto L14;
        this.mViewSwitchNfcReader.setEnabled(false);
    L15:
        checkSimAndUpdateVisibleState();
        return;
    L14:
        this.mViewSwitchNfcReader.setEnabled(true);
        goto L15
    L7:
        if (this.mPaymentBackend.getPaymentAppInfos().size() == 0) goto L10;
        this.mDefaultPaymentService.setEnabled(true);
        goto L12
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mNfcEnabler.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SettingsTracker.trackNFC(this.mContext);
        super.onDestroy();
        unregisterReceiver(this.mStateReceiver);
        clearNFCRepairDialog();
    }

    private void clearNFCRepairDialog() {
        OAlertDialog r0 = this.mNfcRepairAlertDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mNfcRepairAlertDialog = null;
    L5:
        StatusDialog r1 = this.mNfcRepairStatusDialog;
        if (r1 == null) goto L8;
        r1.dismiss();
        this.mNfcRepairStatusDialog = null;
    L8:
        OToast r2 = this.mNfcRepairCompletedToast;
        if (r2 == null) goto L12;
        r2.cancel();
        this.mNfcRepairCompletedToast = null;
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != R.id.default_payment_service) goto L6;
        start(PaymentSettingsFragment.class);
        return;
    L6:
        if (r3.getId() != R.id.item_id_wallet) goto L12;
        Intent r4 = new Intent();     // Catch: Exception -> L9
        r4.setClassName("com.zte.wallet", "com.zte.wallet.card.CardEntranceActivity");     // Catch: Exception -> L9
        Utils.startActivity(this._mActivity, r4);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        OLog.e(TAG, "start wallet activity failed", e);
        return;
    L12:
        if (r3 != this.mNfcRepairItem.getContentContainer()) goto L19;
        showNfcRepairAlertDialog();
        return;
    }

    private void showNfcRepairAlertDialog() {
        if (this.mNfcRepairAlertDialog != null) goto L6;
        this.mNfcRepairAlertDialog = new OAlertDialogBuilder(this._mActivity).horizontalButton().title(R.string.nfc_one_click_repair).message(R.string.nfc_one_click_repair_alert_dialog_sub_title).positiveButton(R.string.nfc_one_click_repair_alert_dialog_positive_button, new NfcSettingsFragment$$ExternalSyntheticLambda0(this)).negativeButton(R.string.nfc_one_click_repair_alert_dialog_negative_button, new NfcSettingsFragment$$ExternalSyntheticLambda1(this)).build();
    L6:
        if (this.mNfcRepairAlertDialog.isShowing() == false) goto L8;
        return;
    L8:
        this.mNfcRepairAlertDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showNfcRepairAlertDialog$2$com-android-settings-NfcSettingsFragment, reason: not valid java name */
    /* synthetic */ void m175xfb22132e(DialogInterface r1, int r2) {
        repairNfc();
        OAlertDialog r0 = this.mNfcRepairAlertDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$showNfcRepairAlertDialog$3$com-android-settings-NfcSettingsFragment, reason: not valid java name */
    /* synthetic */ void m176x287484d(DialogInterface r1, int r2) {
        OAlertDialog r0 = this.mNfcRepairAlertDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private void repairNfc() {
        StatusDialog r0 = this.mNfcRepairStatusDialog;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        this.mNfcRepairStatusDialog.dismiss();
    L8:
        if (this.mNfcRepairStatusDialog != null) goto L10;
        StatusDialog r1 = new StatusDialog(this._mActivity, new StatusDialog.Modifier(getString(R.string.nfc_one_click_repairing_dialog_title), getString(R.string.nfc_one_click_repairing_dialog_sub_title), null, null));
        this.mNfcRepairStatusDialog = r1;
        r1.getProcessView().setProcessingColor(ContextCompat.getColor(this.mContext, R.color.nfc_repairing_progress_color));
        this.mNfcRepairStatusDialog.setCanceledOnTouchOutside(false);
    L10:
        this.mNfcRepairStatusDialog.show();
        if (this.mIsNfcRepairing == true) goto L14;
        this.mIsNfcRepairing = true;
        sendNfcRepairBroadcast();
        return;
    }

    private void sendNfcRepairBroadcast() {
        Intent r0 = new Intent("com.obric.cae.action.nfcffd");
        r0.setPackage(NFC_REPAIR_PACKAGE);
        this._mActivity.sendBroadcast(r0);
    }

    private void nfcRepairCompleted(boolean r3) {
        if (this.mIsNfcRepairing == false) goto L16;
        this.mIsNfcRepairing = false;
        StatusDialog r0 = this.mNfcRepairStatusDialog;
        if (r0 != null) goto L7;
    L9:
        if (r3 == false) goto L14;
        OToast r4 = this.mNfcRepairCompletedToast;
        if (r4 == null) goto L13;
        r4.cancel();
    L13:
        this.mNfcRepairCompletedToast = ToastUtils.showLeftIcon(this._mActivity, getString(R.string.nfc_one_click_repair_completed_dialog_title), R.drawable.settings_oic_checkmark_circle_fill_green);
        return;
    L14:
        ToastUtils.show(this._mActivity, getString(R.string.nfc_one_click_repair_failed_toast));
        return;
    L7:
        if (r0.isShowing() == false) goto L9;
        this.mNfcRepairStatusDialog.dismiss();
        goto L9
    }

    private void checkSimAndUpdateVisibleState() {
        if (this.mPaymentBackend.getPaymentAppInfos().isEmpty() == true) goto L6;
        return;
    L6:
        if (this.mNfcAdapter.isEnabled() == true) goto L8;
    L12:
        this.mDefaultPaymentService.setEnabled(false);
        return;
    L8:
        if (isSim1SupportNfc() == false) goto L10;
    L11:
        this.mDefaultPaymentService.setEnabled(true);
        return;
    L10:
        if (isSim2SupportNfc() == false) goto L12;
        goto L11
    }

    private void updateSubTitle() {
        if (this.mNfcAdapter.isEnabled() == true) goto L5;
        this.mDefaultPaymentService.setEndDetailText(getString(R.string.nfc_is_off));
        return;
    L5:
        if (this.mNfcAdapter == null) goto L7;
        int r0 = this.mNfcSettingsAdapterExt.getDefaultSEOption();
    L8:
        SettingsFeature.isWalletNfcFeatureEnabled(this.mContext);
        if (isSim1SupportNfc() == false) goto L14;
        if (r0 != 2) goto L14;
        CharSequence r1 = getResources().getString(R.string.nfc_sim_card_1);
    L19:
        this.mDefaultPaymentService.setEndDetailText(r1.toString());
        return;
    L14:
        if (isSim2SupportNfc() == true) goto L16;
    L18:
        r1 = this.mPaymentBackend.getDefaultPaymentDescription();
        goto L19
    L16:
        if (r0 != 3) goto L18;
        r1 = getResources().getString(R.string.nfc_sim_card_2);
        goto L19
    L7:
        r0 = -1;
        goto L8
    }

    private boolean isSim1SupportNfc() {
        if (MultiSimAdapter.hasIccCard(0) == true) goto L5;
        return false;
    L5:
        if (this.mNfcSettingsAdapterExt.isSimSupportNfc(0) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isSim2SupportNfc() {
        if (MultiSimAdapter.hasIccCard(1) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNfcSettingsAdapterExt.isSimSupportNfc(1) == false) goto L7;
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        int r3 = 1;
        if (r2 == true) goto L6;
        r3 = 0;
    L6:
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), NFC_DND_MODE, r3);
    }

    private boolean isNfcReaderModeEnabled() {
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), NFC_DND_MODE, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NfcSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NfcSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NfcSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NfcSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NfcSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_NfcSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NfcSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NfcSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NfcSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
