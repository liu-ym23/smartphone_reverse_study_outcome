package com.android.settings;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.android.internal.telephony.Phone;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class Lte4GEnabler {
    private static final int LTE_FULL = 1;
    private static final int LTE_TDD = 2;
    public static final String SETTING_PREF_NETWORK_BAND = "network_band_preferred";
    public static final String SETTING_PRE_NW_MODE_DEFAULT = "preferred_network_mode_default";
    private static final String TAG = "Lte4GEnabler";
    private static final Uri URI_PHONE_FEATURE = null;
    private static MyHandler mHandler;
    private static final int sPhoneCount = 0;
    private AlertDialog mAlertDialog;
    private final Context mContext;
    private String[] mCtMccMncs;
    private boolean mDialogClicked;
    private CompoundButton.OnCheckedChangeListener mLte4GEnabledListener;
    private SubscriptionManager mSubscriptionManager;
    private Switch mSwitch;

    private class MyHandler extends Handler {
        static final int MESSAGE_SET_PREFERRED_NETWORK_TYPE = 0;
        final /* synthetic */ Lte4GEnabler this$0;

        private MyHandler(Lte4GEnabler r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MyHandler(Lte4GEnabler r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            if (r2.what != 0) goto L7;
            handleSetPreferredNetworkTypeResponse(r2);
            return;
        }

        private void handleSetPreferredNetworkTypeResponse(Message r2) {
            Lte4GEnabler.access$202(this.this$0, false);
            OLog.i(Lte4GEnabler.TAG, "handleSetPreferredNetworkTypeResponse");
            Lte4GEnabler.access$500(this.this$0);
        }
    }

    static /* synthetic */ void access$100(Lte4GEnabler r0) {
        r0.setPrefNetwork();
    }

    static /* synthetic */ boolean access$200(Lte4GEnabler r0) {
        return r0.mDialogClicked;
    }

    static /* synthetic */ boolean access$202(Lte4GEnabler r0, boolean r1) {
        r0.mDialogClicked = r1;
        return r1;
    }

    static /* synthetic */ Switch access$300(Lte4GEnabler r0) {
        return r0.mSwitch;
    }

    static /* synthetic */ void access$400(Lte4GEnabler r0) {
        r0.promptUser();
    }

    static /* synthetic */ void access$500(Lte4GEnabler r0) {
        r0.setSwitchStatus();
    }

    static {
        URI_PHONE_FEATURE = Uri.parse("content://com.qualcomm.qti.phonefeature.FEATURE_PROVIDER");
        sPhoneCount = TelephonyManager.getDefault().getPhoneCount();
    }

    public Lte4GEnabler(Context r2, Switch r3) {
        this.mDialogClicked = false;
        this.mLte4GEnabledListener = new AnonymousClass4(this);
        this.mContext = r2;
        this.mSwitch = r3;
        mHandler = new MyHandler(this, null);
        this.mSubscriptionManager = SubscriptionManager.from(r2);
        this.mCtMccMncs = r2.getResources().getStringArray(R.array.ct_mcc_mnc_list);
    }

    public void resume() {
        setSwitchStatus();
        this.mSwitch.setOnCheckedChangeListener(this.mLte4GEnabledListener);
    }

    public void pause() {
        this.mSwitch.setOnCheckedChangeListener(null);
    }

    public void setSwitch(Switch r2) {
        if (this.mSwitch != r2) goto L5;
        return;
    L5:
        this.mSwitch = r2;
        setSwitchStatus();
        this.mSwitch.setOnCheckedChangeListener(this.mLte4GEnabledListener);
    }

    private void setSwitchStatus() {
        boolean r0 = isDdsSubInLteMode();
        AlertDialog r1 = this.mAlertDialog;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L7:
        this.mSwitch.setChecked(r0);
        Switch r3 = this.mSwitch;
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0) == 0) goto L10;
    L12:
        r2 = false;
    L13:
        r3.setEnabled(r2);
        return;
    L10:
        if (isThereSimReady() == false) goto L12;
    L5:
        if (r1.isShowing() == false) goto L7;
        r0 = true;
        goto L7
    }

    private boolean isDdsSubInLteMode() {
        SubscriptionManager.getDefaultDataSubscriptionId();
        boolean r0 = false;
        if (MultiSDKAdapterNew.isSupportNetworkType(getPreferredNetworkType(0)) == true) goto L5;
    L7:
        OLog.i(TAG, "isDdsSubInLteMode: " + r0);
        return r0;
    L5:
        if (TelephonyManager.getDefault().getSimState(0) != 5) goto L7;
        r0 = true;
        goto L7
    }

    public boolean isThereSimReady() {
        int r0 = 0;
        boolean r1 = false;
    L4:
        if (r0 >= sPhoneCount) goto L10;
        if (TelephonyManager.getDefault().getSimState(r0) != 5) goto L8;
        boolean r2 = true;
    L9:
        r1 = r1 | r2;
        r0 = r0 + 1;
        goto L4
    L8:
        r2 = false;
        goto L9
    L10:
        OLog.i(TAG, "isThereSimReady: " + r1);
        return r1;
    }

    private void promptUser() {
        AlertDialog r0 = new AlertDialog.Builder(this.mContext).setMessage(this.mContext.getString(R.string.lte_4g_switch_prompt)).setNeutralButton(R.string.no, new AnonymousClass2(this)).setPositiveButton(R.string.yes, new AnonymousClass1(this)).create();
        this.mAlertDialog = r0;
        r0.setOnDismissListener(new AnonymousClass3(this));
        if (this.mAlertDialog.isShowing() == true) goto L6;
        this.mAlertDialog.show();
        return;
    }

    private boolean isPrefTDDDataOnly(int r3) {
        if (TelephonyManager.getIntAtIndex(this.mContext.getContentResolver(), SETTING_PREF_NETWORK_BAND, r3) != 2) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    private void setPrefNetwork() {
        int r1 = 0;
        this.mSwitch.setEnabled(false);
        OLog.i(TAG, "isChecked: " + this.mSwitch.isChecked());
        if (this.mSwitch.isChecked() == false) goto L9;
        int r0 = getProperNwMode(0);
        storeNwModeIntoDb(0, r0);
        if (isPrefTDDDataOnly(0) == false) goto L7;
        setPrefNetwork(0, MultiSDKAdapterNew.getModeLteOnly(), 2);
        return;
    L7:
        setPrefNetwork(0, r0);
        return;
    L9:
        if (r1 >= sPhoneCount) goto L14;
        int r2 = getProperNwMode(r1);
        storeNwModeIntoDb(r1, r2);
        setPrefNetwork(r1, r2);
        r1 = r1 + 1;
        goto L9
    }

    private boolean isCtCard(int r6) {
        SubscriptionInfo r0 = this.mSubscriptionManager.getActiveSubscriptionInfo(SubscriptionManager.getSubId(r6)[0]);
        if (r0 != null) goto L5;
    L12:
        return false;
    L5:
        if (this.mCtMccMncs == null) goto L12;
        String r1 = String.format("%03d%02d", new Object[]{Integer.valueOf(r0.getMcc()), Integer.valueOf(r0.getMnc())});
        OLog.i(TAG, "slot: " + r6 + " mccMnc: " + r1);
        String[] r5 = this.mCtMccMncs;
        int r7 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r7) goto L12;
        if (r1.equals(r5[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    }

    private int getProperNwMode(int r2) {
        boolean r3 = isCtCard(r2);
        int r0 = MultiSDKAdapterNew.getLteNwMode(r3);
        int r4 = MultiSDKAdapterNew.getNwMode(r3);
        if (this.mSwitch.isChecked() == false) goto L6;
        return r0;
    L6:
        return r4;
    }

    private void storeNwModeIntoDb(int r3, int r4) {
        TelephonyManager.putIntAtIndex(this.mContext.getContentResolver(), SETTING_PRE_NW_MODE_DEFAULT, r3, r4);
        int[] r5 = SubscriptionManager.getSubId(r3);
        if (r5 == null) goto L6;
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "preferred_network_mode" + r5[0], r4);
        return;
    }

    private void setPrefNetwork(int r4, int r5) {
        Messenger r0 = new Messenger(mHandler);
        Message r1 = mHandler.obtainMessage(0);
        r1.replyTo = r0;
        Bundle r2 = new Bundle();
        r2.putInt("slot", r4);
        r2.putInt("network", r5);
        r2.putParcelable("callback", r1);
        callBinder("set_pref_network", r2);
    }

    public void setPrefNetwork(int r4, int r5, int r6) {
        Message r0 = mHandler.obtainMessage(0);
        if (r0 == null) goto L5;
        r0.replyTo = new Messenger(r0.getTarget());
    L5:
        Bundle r1 = new Bundle();
        r1.putInt("slot", r4);
        r1.putInt("network", r5);
        r1.putInt("band", r6);
        r1.putParcelable("callback", r0);
        callBinder("set_pref_network", r1);
    }

    private Bundle callBinder(String r4, Bundle r5) {
        ContentResolver r0 = this.mContext.getContentResolver();
        Uri r1 = URI_PHONE_FEATURE;
        if (r0.acquireProvider(r1) != null) goto L6;
        return null;
    L6:
        return this.mContext.getContentResolver().call(r1, r4, null, r5);
    }

    private int getPreferredNetworkType(int r6) {
        int r0 = Phone.PREFERRED_NT_MODE;
        int[] r1 = SubscriptionManager.getSubId(r6);
        if (r1 != null) goto L5;
    L12:
        r0 = TelephonyManager.getIntAtIndex(this.mContext.getContentResolver(), "preferred_network_mode", r6);     // Catch: android.provider.Settings.SettingNotFoundException -> L9
    L10:
        OLog.i(TAG, "get preferred network type=" + r0);
        return r0;
    L9:
        OLog.e(TAG, "getPreferredNetworkType: Could not find PREFERRED_NETWORK_MODE!!!");
        goto L10
    L5:
        if (r1.length <= 0) goto L12;
        r0 = android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "preferred_network_mode" + r1[0], Phone.PREFERRED_NT_MODE);
        goto L10
    }
}
