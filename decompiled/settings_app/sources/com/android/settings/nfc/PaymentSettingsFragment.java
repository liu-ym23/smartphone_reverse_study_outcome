package com.android.settings.nfc;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.MultiSimAdapter;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentSettingsFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    public static final int HOST_ID_TYPE = 0;
    public static final int SMART_MX_ID_TYPE = 1;
    public static final int UICC2_ID_TYPE = 3;
    public static final int UICC_ID_TYPE = 2;
    public static final String WALLET_COMPONENT_NAME = "com.zte.wallet/com.zte.wallet.service.WalletOffHostApduService";
    private boolean isSim1SupportNfc;
    private boolean isSim2SupportNfc;
    private int mCurrentSe;
    private ListView mListView;
    private NfcAdapter mNfcAdapter;
    private NfcSettingsAdapterExt mNfcSettingsAdapterExt;
    private PaymentAdapter mPaymentAdapter;
    private PaymentBackend mPaymentBackend;
    private List<PaymentBackend.PaymentAppInfo> mPaymentList;
    private final BroadcastReceiver mStateReceiver;
    private boolean mSupportBytedanceWallet;

    private class PaymentAdapter extends BaseAdapter {
        final /* synthetic */ PaymentSettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private PaymentAdapter(PaymentSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PaymentAdapter(PaymentSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return PaymentSettingsFragment.access$500(this.this$0).size() + 3;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return PaymentSettingsFragment.access$500(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(final int r10, final View r11, final ViewGroup r12) {
            if (r11 != null) goto L5;
        L8:
            r11 = LayoutInflater.from(this.this$0.mContext).inflate(R.layout.list_nfc_payment_item_image, r12, false);
            OCardListItem r3 = (OCardListItem) r11.findViewById(R.id.item_view);
            PaymentSettingsFragment r4 = this.this$0;
            PaymentInfoHolder r2 = new PaymentInfoHolder(r4, r4.mContext, 1);
            r2.item = r3;
            r2.itemNoPayment = (OCardListItem) r11.findViewById(R.id.item_no_payment);
            r11.setTag(r2);
        L9:
            r3.showCustomEnd(false);
            r3.setVisibility(0);
            int r5 = 8;
            r2.itemNoPayment.setVisibility(8);
            r3.setOnContentClickListener(new PaymentSettingsFragment$PaymentAdapter$$ExternalSyntheticLambda0(this, r12, r11, r10));
            r2.itemNoPayment.setOnContentClickListener(new PaymentSettingsFragment$PaymentAdapter$$ExternalSyntheticLambda1(this, r12, r11, r10));
            if (r10 != (getCount() - 3)) goto L19;
            r3.setIcon(this.this$0.mContext.getDrawable(R.drawable.nfc_sim));
            r3.setTitle(this.this$0.mContext.getString(R.string.nfc_sim_card_1));
            r2.setPaymentAppInfo(null);
            r2.setSeType(2);
            if (PaymentSettingsFragment.access$200(this.this$0) != 2) goto L15;
            r3.showCustomEnd(true);
        L15:
            if (PaymentSettingsFragment.access$600(this.this$0) == false) goto L17;
            r5 = 0;
        L17:
            r3.setVisibility(r5);
        L54:
            int r13 = getCount();
            if (PaymentSettingsFragment.access$600(this.this$0) == true) goto L58;
            r13 = r13 - 1;
        L58:
            if (PaymentSettingsFragment.access$700(this.this$0) == true) goto L60;
            r13 = r13 - 1;
        L60:
            if (r10 != 0) goto L63;
            if (r13 != 1) goto L63;
            r3.setCardPosition(0);
        L69:
            return r11;
        L63:
            if (r10 != 0) goto L66;
            r3.setCardPosition(1);
            goto L69
        L66:
            if (r10 != (r13 - 1)) goto L68;
            r3.setCardPosition(3);
            goto L69
        L68:
            r3.setCardPosition(2);
            goto L69
        L19:
            if (r10 != (getCount() - 2)) goto L28;
            r3.setIcon(this.this$0.mContext.getDrawable(R.drawable.nfc_sim));
            r3.setTitle(this.this$0.mContext.getString(R.string.nfc_sim_card_2));
            r2.setPaymentAppInfo(null);
            r2.setSeType(3);
            if (PaymentSettingsFragment.access$200(this.this$0) != 3) goto L24;
            r3.showCustomEnd(true);
        L24:
            if (PaymentSettingsFragment.access$700(this.this$0) == false) goto L26;
            r5 = 0;
        L26:
            r3.setVisibility(r5);
            goto L54
        L28:
            if (r10 != (getCount() - 1)) goto L38;
            r2.itemNoPayment.setVisibility(0);
            r2.item.setVisibility(8);
            r2.itemNoPayment.setTitle(this.this$0.mContext.getString(R.string.no_nfc_payment));
            r2.setPaymentAppInfo(null);
            r2.setSeType(0);
            PaymentBackend.PaymentInfo r14 = PaymentSettingsFragment.access$100(this.this$0).getDefaultPaymentApp();
            PaymentBackend.PaymentAppInfo r6 = PaymentSettingsFragment.access$100(this.this$0).getDefaultApp();
            OCardListItem r7 = r2.itemNoPayment;
            if (r14 != null) goto L32;
        L36:
            boolean r15 = true;
        L37:
            r7.showCustomEnd(r15);
            goto L54
        L32:
            if (r14.componentName == null) goto L36;
            if (r6 == null) goto L36;
            r15 = false;
            goto L37
        L38:
            PaymentBackend.PaymentAppInfo r16 = (PaymentBackend.PaymentAppInfo) PaymentSettingsFragment.access$500(this.this$0).get(r10);
            if (r16 == null) goto L54;
            Drawable r8 = r16.banner;
            if (r8 != null) goto L43;
        L45:
            if (r8 == null) goto L47;
            r3.setAppIcon(ObricIconUtils.getRoundedDrawable(r11.getContext(), r8));
        L48:
            r3.setTitle(r16.label.toString());
            r2.setPaymentAppInfo(r16);
            if (PaymentSettingsFragment.WALLET_COMPONENT_NAME.equals(r16.componentName.flattenToString()) == true) goto L52;
            r2.setSeType(0);
        L52:
            if (r16.isDefault == false) goto L54;
            r3.showCustomEnd(true);
            goto L54
        L47:
            r3.setAppIcon(null);
            goto L48
        L43:
            if (PaymentSettingsFragment.access$800(r8) == false) goto L45;
            r3.setAppIcon(r8);
            goto L48
        L5:
            if ((r11.getTag() instanceof PaymentInfoHolder) == false) goto L8;
            r2 = (PaymentInfoHolder) r11.getTag();
            r3 = r2.item;
            goto L9
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-nfc-PaymentSettingsFragment$PaymentAdapter, reason: not valid java name */
        /* synthetic */ void m517xef257c3c(ViewGroup r7, View r8, int r9, View r10) {
            if ((r7 instanceof ListView) == false) goto L6;
            PaymentSettingsFragment r0 = this.this$0;
            r0.onItemClick((ListView) r7, r8, r9, getItemId(r9));
            return;
        }

        /* JADX INFO: renamed from: lambda$getView$1$com-android-settings-nfc-PaymentSettingsFragment$PaymentAdapter, reason: not valid java name */
        /* synthetic */ void m518x3ce4f43d(ViewGroup r7, View r8, int r9, View r10) {
            if ((r7 instanceof ListView) == false) goto L6;
            PaymentSettingsFragment r0 = this.this$0;
            r0.onItemClick((ListView) r7, r8, r9, getItemId(r9));
            return;
        }
    }

    private class PaymentInfoHolder {
        OCardListItem item;
        OCardListItem itemNoPayment;
        private PaymentBackend.PaymentAppInfo mPaymentAppInfo;
        private int mSeType;
        final /* synthetic */ PaymentSettingsFragment this$0;

        public PaymentInfoHolder(PaymentSettingsFragment r1, Context r2, int r3) {
            this.this$0 = r1;
            this.mSeType = r3;
        }

        public void setSeType(int r1) {
            this.mSeType = r1;
        }

        public int getSeType() {
            return this.mSeType;
        }

        public void setPaymentAppInfo(PaymentBackend.PaymentAppInfo r1) {
            this.mPaymentAppInfo = r1;
        }

        public PaymentBackend.PaymentAppInfo getPaymentAppInfo() {
            return this.mPaymentAppInfo;
        }
    }

    private boolean isSim2SupportNfc() {
        return false;
    }

    public void com_android_settings_nfc_PaymentSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_nfc_PaymentSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_nfc_PaymentSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_nfc_PaymentSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PaymentSettingsFragment() {
        this.mPaymentList = new ArrayList();
        this.isSim1SupportNfc = false;
        this.isSim2SupportNfc = false;
        this.mSupportBytedanceWallet = false;
        this.mStateReceiver = new AnonymousClass3(this);
    }

    static /* synthetic */ PaymentBackend access$100(PaymentSettingsFragment r0) {
        return r0.mPaymentBackend;
    }

    static /* synthetic */ int access$200(PaymentSettingsFragment r0) {
        return r0.mCurrentSe;
    }

    static /* synthetic */ void access$300(PaymentSettingsFragment r0, int r1) {
        r0.updateSeType(r1);
    }

    static /* synthetic */ void access$400(PaymentSettingsFragment r0) {
        r0.refreshListView();
    }

    static /* synthetic */ List access$500(PaymentSettingsFragment r0) {
        return r0.mPaymentList;
    }

    static /* synthetic */ boolean access$600(PaymentSettingsFragment r0) {
        return r0.isSim1SupportNfc;
    }

    static /* synthetic */ boolean access$700(PaymentSettingsFragment r0) {
        return r0.isSim2SupportNfc;
    }

    static /* synthetic */ boolean access$800(Drawable r0) {
        return isSquareDrawable(r0);
    }

    static /* synthetic */ NfcAdapter access$900(PaymentSettingsFragment r0) {
        return r0.mNfcAdapter;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        int r0 = 0;
        this.mRootView = r2.inflate(R.layout.payment_setting_layout, r3, false);
        this.mNfcAdapter = NfcAdapter.getNfcAdapter(this.mContext);     // Catch: UnsupportedOperationException -> L5
    L7:
        NfcSettingsAdapterExt r5 = NfcSettingsAdapterExt.getInstance(this.mNfcAdapter);
        this.mNfcSettingsAdapterExt = r5;
        if (this.mNfcAdapter == null) goto L10;
        r0 = r5.getDefaultSEOption();
    L10:
        this.mCurrentSe = r0;
        this.isSim1SupportNfc = isSim1SupportNfc();
        this.isSim2SupportNfc = isSim2SupportNfc();
        this.mSupportBytedanceWallet = SettingsFeature.isWalletNfcFeatureEnabled(this.mContext);
        PaymentBackend r6 = new PaymentBackend(this.mContext);
        this.mPaymentBackend = r6;
        int r7 = this.mCurrentSe;
        AnonymousClass1 r1 = null;
        if (r7 != 2) goto L13;
    L14:
        r6.setDefaultPaymentApp(null);
    L15:
        this.mPaymentList = new ArrayList(this.mPaymentBackend.getPaymentAppInfos());
        this.mPaymentAdapter = new PaymentAdapter(this, r1);
        ListView r8 = (ListView) findViewByIdNullable(R.id.listView);
        this.mListView = r8;
        r8.setOnItemClickListener(this);
        View r9 = LayoutInflater.from(this.mContext).inflate(R.layout.default_payment_tips_layout, null);
        this.mListView.addFooterView(r9);
        View r10 = LayoutInflater.from(this.mContext).inflate(R.layout.default_payment_top_layout, null);
        this.mListView.addHeaderView(r10);
        this.mListView.setAdapter(this.mPaymentAdapter);
        IntentFilter r11 = new IntentFilter("android.intent.action.SIM_STATE_CHANGED");
        r11.addAction("android.nfc.action.ADAPTER_STATE_CHANGED");
        registerReceiver(this.mStateReceiver, r11);
        return this.mRootView;
    L13:
        if (r7 != 3) goto L15;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterReceiver(this.mStateReceiver);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        if ((r2.getTag() instanceof PaymentInfoHolder) == true) goto L5;
        return;
    L5:
        PaymentInfoHolder r5 = (PaymentInfoHolder) r2.getTag();
        int r6 = r5.getSeType();
        PaymentBackend.PaymentInfo r7 = this.mPaymentBackend.getDefaultPaymentApp();
        PaymentBackend.PaymentAppInfo r8 = r5.getPaymentAppInfo();
        if (r7 == null) goto L8;
        ComponentName r9 = r7.componentName;
    L9:
        if (r8 == null) goto L11;
        ComponentName r10 = r8.componentName;
    L13:
        if (isZteWalletToOther(r9, r10) == false) goto L15;
        showDialog(r8, r6);
        return;
    L15:
        if (r8 != null) goto L17;
        this.mPaymentBackend.setDefaultPaymentApp(null);
    L21:
        if (r6 == this.mCurrentSe) goto L23;
        updateSeType(r6);
    L23:
        refreshListView();
        return;
    L17:
        if (r8.isDefault == true) goto L21;
        this.mPaymentBackend.setDefaultPaymentApp(r8.componentName, r8.userHandle.getIdentifier());
        goto L21
    L11:
        r10 = null;
        goto L13
    L8:
        r9 = null;
        goto L9
    }

    private boolean isZteWalletToOther(ComponentName r2, ComponentName r3) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (WALLET_COMPONENT_NAME.equals(r2.flattenToString()) == false) goto L12;
        if (r3 != null) goto L9;
    L10:
        return true;
    L9:
        if (WALLET_COMPONENT_NAME.equals(r3.flattenToString()) == false) goto L10;
        return false;
    L12:
        return false;
    }

    private void showDialog(final PaymentBackend.PaymentAppInfo r4, final int r5) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "showDialog, activity is null, return");
        return;
    L6:
        new OAlertDialogBuilder(r0).autoDismiss(false).horizontalButton().title(R.string.nfc_wallet_dialog_title).message(R.string.nfc_wallet_dialog_msg).negativeButton(R.string.activate_dlg_negative, new AnonymousClass2(this)).positiveButton(R.string.dialog_theme_positive, new AnonymousClass1(this, r4, r5)).show();
    }

    private void updateSeType(int r1) {
        this.mCurrentSe = r1;
        refreshListView();
        NfcSettingsAdapterExt r0 = this.mNfcSettingsAdapterExt;
        if (r0 == null) goto L6;
        r0.setDefaultSEOption(r1);
        return;
    }

    private static boolean isSquareDrawable(Drawable r4) {
        int r0 = r4.getIntrinsicWidth();
        int r1 = r4.getIntrinsicHeight();
        if (r0 <= 0) goto L10;
        if (r1 <= 0) goto L10;
        if (r0 != r1) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((r4 instanceof BitmapDrawable) == false) goto L18;
        Bitmap r5 = ((BitmapDrawable) r4).getBitmap();
        if (r5 == null) goto L17;
        if (r5.getWidth() != r5.getHeight()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
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

    private void refreshListView() {
        this.mPaymentList.clear();
        this.isSim1SupportNfc = isSim1SupportNfc();
        this.isSim2SupportNfc = isSim2SupportNfc();
        this.mPaymentList.addAll(this.mPaymentBackend.getPaymentAppInfos());
        this.mPaymentAdapter.notifyDataSetChanged();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_nfc_PaymentSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PaymentSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_nfc_PaymentSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_nfc_PaymentSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PaymentSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_nfc_PaymentSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_nfc_PaymentSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PaymentSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_nfc_PaymentSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
