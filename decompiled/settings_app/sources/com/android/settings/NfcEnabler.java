package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.utils.ThreadUtils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class NfcEnabler implements CompoundButton.OnCheckedChangeListener {
    public boolean isUpdateReaderMode;
    private Context mContext;
    private IntentFilter mIntentFilter;
    private NfcAdapter mNfcAdapter;
    private NfcStateChangedListener mNfcStateChangedListener;
    private final BroadcastReceiver mReceiver;
    private boolean mReceiverRegistered;
    private OSwitch mSwitchAndroidBeam;
    private OCardListItem mViewSwitchAndroidBeam;
    private OSwitch mViewSwitchNfc;

    interface NfcStateChangedListener {
        void onNfcStateChanged(boolean r1);
    }

    static /* synthetic */ void access$000(NfcEnabler r0, int r1) {
        r0.handleNfcStateChanged(r1);
    }

    static /* synthetic */ NfcAdapter access$100(NfcEnabler r0) {
        return r0.mNfcAdapter;
    }

    public NfcEnabler(Context r3, OSwitch r4, OCardListItem r5) {
        this.mReceiverRegistered = false;
        this.isUpdateReaderMode = false;
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = r3;
        this.mViewSwitchNfc = r4;
        this.mViewSwitchAndroidBeam = r5;
        this.mSwitchAndroidBeam = r5.getEndSwitch();
        NfcAdapter r6 = NfcAdapter.getDefaultAdapter(r3);
        this.mNfcAdapter = r6;
        if (r6 != null) goto L6;
        this.mViewSwitchNfc.setEnabled(false);
        this.mSwitchAndroidBeam.setEnabled(false);
        this.mIntentFilter = null;
        return;
    L6:
        this.mIntentFilter = new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED");
    }

    public boolean isNfcSupport() {
        if (this.mNfcAdapter == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void handleNfcStateChanged(int r4) {
        if (this.isUpdateReaderMode == false) goto L5;
        return;
    L5:
        this.mViewSwitchNfc.setOnCheckedChangeListener(null);
        if (r4 != 1) goto L8;
        this.mViewSwitchNfc.setChecked(false);
        this.mViewSwitchNfc.setEnabled(true);
        this.mSwitchAndroidBeam.setChecked(false);
        this.mSwitchAndroidBeam.setEnabled(false);
    L21:
        this.mViewSwitchNfc.setOnCheckedChangeListener(this);
        return;
    L8:
        if (r4 != 2) goto L10;
        this.mViewSwitchNfc.setChecked(true);
        this.mViewSwitchNfc.setEnabled(false);
        this.mSwitchAndroidBeam.setEnabled(false);
        goto L21
    L10:
        if (r4 != 3) goto L12;
        this.mViewSwitchNfc.setChecked(true);
        this.mSwitchAndroidBeam.setEnabled(true);
        this.mViewSwitchNfc.setEnabled(true);
        if (this.mNfcAdapter.isNdefPushEnabled() == false) goto L18;
        this.mSwitchAndroidBeam.setChecked(true);
        goto L21
    L18:
        this.mSwitchAndroidBeam.setChecked(false);
        goto L21
    L12:
        if (r4 != 4) goto L21;
        this.mViewSwitchNfc.setChecked(false);
        this.mViewSwitchNfc.setEnabled(false);
        this.mSwitchAndroidBeam.setEnabled(false);
        this.mSwitchAndroidBeam.setChecked(false);
        goto L21
    }

    public void resume() {
        NfcAdapter r0 = this.mNfcAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        handleNfcStateChanged(r0.getAdapterState());
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, this.mIntentFilter, 2);
        this.mReceiverRegistered = true;
        this.mViewSwitchNfc.setOnCheckedChangeListener(this);
        this.mSwitchAndroidBeam.setOnCheckedChangeListener(this);
        NfcStateChangedListener r1 = this.mNfcStateChangedListener;
        if (r1 == null) goto L9;
        r1.onNfcStateChanged(this.mViewSwitchNfc.isChecked());
        return;
    }

    public void pause() {
        if (this.mReceiverRegistered != true) goto L5;
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mReceiverRegistered = false;
    L5:
        this.mViewSwitchNfc.setOnCheckedChangeListener(null);
        this.mSwitchAndroidBeam.setOnCheckedChangeListener(null);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, final boolean r4) {
        OSwitch r0 = this.mViewSwitchNfc;
        if (r3 != r0) goto L8;
        r0.setEnabled(false);
        ExecutorManager.execute(new AnonymousClass2(this, r4));
        SettingsTracker.onSwitcherClick(70201, r4);
        NfcStateChangedListener r2 = this.mNfcStateChangedListener;
        if (r2 == null) goto L21;
        r2.onNfcStateChanged(r4);
        return;
    L21:
        return;
    L8:
        if (r3 == this.mSwitchAndroidBeam) goto L10;
        return;
    L10:
        if (this.mNfcAdapter.getAdapterState() == 3) goto L12;
        return;
    L12:
        this.mSwitchAndroidBeam.setEnabled(false);
        if (r4 == false) goto L15;
        boolean r5 = this.mNfcAdapter.enableNdefPush();
    L16:
        if (r5 == false) goto L18;
        this.mSwitchAndroidBeam.setChecked(r4);
    L19:
        this.mSwitchAndroidBeam.setEnabled(true);
        SettingsTracker.onSwitcherClick(70202, r4);
        return;
    L18:
        this.mSwitchAndroidBeam.setChecked(!r4);
        goto L19
    L15:
        r5 = this.mNfcAdapter.disableNdefPush();
        goto L16
    }

    public void startUpdateReaderMode() {
        this.isUpdateReaderMode = true;
        ThreadUtils.getUiThreadHandler().postDelayed(new AnonymousClass3(this), 300);
    }

    public void setNfcStateChangedListener(NfcStateChangedListener r1) {
        this.mNfcStateChangedListener = r1;
    }
}
