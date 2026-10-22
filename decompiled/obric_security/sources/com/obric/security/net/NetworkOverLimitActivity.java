package com.obric.security.net;

import android.app.Activity;
import android.net.INetworkPolicyManager;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkTemplate;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import bytedanceos.util.MultiSimAdapter;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.datausage.DataUsageActivity;
import com.bytedanceos.datausage.DataUsageDetailActivity;
import com.bytedanceos.utils.Constants;
import com.bytedanceos.utils.NetworkPolicyEditor;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.security.R;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkOverLimitActivity extends Activity {
    private static final String LAST_SUBSCRIBER_PROP = "persist.radio.last.subscriber";
    private static final String TAG = "NetworkOverLimitActivity";
    private OActionDialog dialog;
    private int mCurrentSlot;
    private NetworkPolicy mPolicy;
    private NetworkPolicyEditor mPolicyEditor;
    private NetworkPolicyManager mPolicyManager;
    private TelephonyManager mTelephonyMgr;
    private NetworkTemplate mTemplate;

    public NetworkOverLimitActivity() {
    }

    static /* synthetic */ OActionDialog access$000(NetworkOverLimitActivity r0) {
        return r0.dialog;
    }

    static /* synthetic */ void access$100(NetworkOverLimitActivity r0, NetworkTemplate r1) {
        r0.snoozePolicy(r1);
    }

    static /* synthetic */ void access$200(NetworkOverLimitActivity r0, boolean r1) {
        r0.setMobileNetworkEnabled(r1);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        long r3 = getIntent().getLongExtra(PerfConsts.PERF_DISK_TOTAL, 0);
        long r0 = getIntent().getLongExtra(DataUsageDetailActivity.INTENT_EXTRA_LIMIT, 0);
        if (r3 >= r0) goto L6;
        finish();
        return;
    L6:
        this.mTelephonyMgr = (TelephonyManager) getSystemService("phone");
        NetworkTemplate r6 = (NetworkTemplate) getIntent().getParcelableExtra("android.net.NETWORK_TEMPLATE");
        this.mCurrentSlot = MultiSimAdapter.getDefaultDataSlot();
        String r7 = nwTemplateGetSubscriberId(r6);
        String r2 = getActiveSubscriberId();
        if (r7.isEmpty() == false) goto L9;
    L29:
        finish();
        return;
    L9:
        if (r2.isEmpty() == true) goto L29;
        if (r7.equals(r2) == true) goto L16;
        finish();
        return;
    L16:
        if (DataUsageActivity.PAGE_SLOT == (-1)) goto L25;
        if (DataUsageActivity.PAGE_SLOT == this.mCurrentSlot) goto L25;
        if (openAutoDisconnect(DataUsageActivity.PAGE_SLOT) == false) goto L22;
        setMobileNetworkEnabled(true);
    L22:
        finish();
        return;
    L25:
        if (openAutoDisconnect(this.mCurrentSlot) == true) goto L27;
        setPolicyWarningAgain(r0);
    L27:
        createNetworkLimitDialog();
    }

    private String nwTemplateGetSubscriberId(NetworkTemplate temp) {
        return (String) NetworkTemplate.class.getMethod("getSubscriberId", new Class[0]).invoke(temp, new Object[0]);
    L4:
        e = move-exception;
        OLog.w(TAG, "nwTemplateGetSubscriberId Exception " + e);
        return "";
    }

    private boolean openAutoDisconnect(int mCurrentSlot) {
        if (mCurrentSlot != 0) goto L8;
        if (Settings.Global.getInt(getContentResolver(), Constants.DATA_USAGE_LIMIT, 0) != 0) goto L11;
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_LIMIT, 1);
        return false;
    L11:
        return true;
    L8:
        if (Settings.Global.getInt(getContentResolver(), Constants.DATA_USAGE_LIMIT_SUB2, 0) != 0) goto L11;
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_LIMIT_SUB2, 1);
        return false;
    }

    private void setPolicyWarningAgain(long limitBytes) {
        this.mPolicyManager = NetworkPolicyManager.from(this);
        NetworkPolicyEditor r1 = new NetworkPolicyEditor(this.mPolicyManager);
        this.mPolicyEditor = r1;
        r1.read();
        String r2 = getActiveSubscriberId();
        if (r2 == null) goto L8;
        NetworkTemplate r3 = NetworkTemplate.buildTemplateMobileAll(r2);
        this.mTemplate = r3;
        NetworkPolicy r4 = this.mPolicyEditor.getPolicy(r3);
        this.mPolicy = r4;
        if (r4 != null) goto L8;
        Time r5 = new Time();
        r5.setToNow();
        NetworkPolicy r15 = new NetworkPolicy(this.mTemplate, r5.monthDay, r5.timezone, -1, -1, -1, -1, true, true);
        this.mPolicy = r15;
        this.mPolicyEditor.addPolicy(r15);
    L8:
        if (this.mPolicy == null) goto L11;
        setPolicyWarningBytes(limitBytes);
        this.mPolicy.warningBytes = limitBytes;
        return;
    }

    private void createNetworkLimitDialog() {
        final NetworkTemplate r0 = getIntent().getParcelableExtra("android.net.NETWORK_TEMPLATE");
        final View r1 = LayoutInflater.from(this).inflate(R.layout.obric_network_limit, null);
        View r2 = r1.findViewById(R.id.obric_dialog_title);
        View r3 = r1.findViewById(R.id.obric_dialog_message);
        if (r2 == null) goto L5;
        r2.setVisibility(8);
    L5:
        if (r3 == null) goto L7;
        r3.setVisibility(8);
    L7:
        OButton r4 = (OButton) r1.findViewById(R.id.obric_btn_data_usage_disabled);
        ((OButton) r1.findViewById(R.id.obric_btn_ok)).setOnClickListener(new AnonymousClass1(this));
        r4.setOnClickListener(new AnonymousClass2(this, r0));
        OActionDialog r5 = new OActionDialog(this, new OActionDialog.Modifier(getString(getLimitedDialogTitleForTemplate(r0)), getString(R.string.data_usage_disabled_dialog), new AnonymousClass3(this, r1)));
        this.dialog = r5;
        r5.setCanceledOnTouchOutside(false);
        this.dialog.setCancelable(false);
        Window r6 = this.dialog.getWindow();
        if (r6 == null) goto L10;
        r6.setGravity(80);
        r6.setLayout(-1, -2);
    L10:
        this.dialog.setOnDismissListener(new AnonymousClass4(this));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus == false) goto L12;
        OActionDialog r1 = this.dialog;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isShowing() == false) goto L9;
        return;
    L9:
        if (isFinishing() == true) goto L15;
        this.dialog.show();
        return;
    L15:
        return;
    }

    private void snoozePolicy(NetworkTemplate template) {
        INetworkPolicyManager.Stub.asInterface(ServiceManager.getService("netpolicy")).snoozeLimit(template);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        OLog.w(TAG, "problem snoozing network policy", e);
    }

    private static int getLimitedDialogTitleForTemplate(NetworkTemplate template) {
        template.getSubscriberId();
        if (template.getMatchRule() == 1) goto L6;
        return R.string.data_usage_disabled_dialog_title;
    L6:
        return R.string.data_usage_disabled_dialog_mobile_title;
    }

    public void setPolicyWarningBytes(long limitBytes) {
        this.mPolicyEditor.setPolicyWarningBytes(this.mTemplate, limitBytes);
    }

    private String getActiveSubscriberId() {
        int r0 = MultiSimAdapter.slot2Sub(this.mCurrentSlot);
        if (r0 != (-1)) goto L5;
        OLog.e(TAG, "MultiSimAdapter.slot2Sub - subId invalid; currentSlot=" + this.mCurrentSlot);
        r0 = this.mTelephonyMgr.getSubscriptionId();
    L5:
        String r1 = this.mTelephonyMgr.createForSubscriptionId(r0).getSubscriberId();
        if (r1 == null) goto L9;
        return r1;
    L9:
        return getLastSubscriberId();
    }

    private String getLastSubscriberId() {
        return TelephonyManager.getTelephonyProperty(this.mCurrentSlot, LAST_SUBSCRIBER_PROP, null);
    }

    private void setMobileNetworkEnabled(boolean enabled) {
        ((TelephonyManager) getSystemService("phone")).setDataEnabled(enabled);
    }
}
