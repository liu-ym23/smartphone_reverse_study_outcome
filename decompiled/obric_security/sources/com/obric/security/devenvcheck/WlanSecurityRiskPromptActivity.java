package com.obric.security.devenvcheck;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.devenvcheck.R;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.action.OActionDialog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WlanSecurityRiskPromptActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0014J\b\u0010\u001e\u001a\u00020\u0013H\u0002J@\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00172\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00100%j\b\u0012\u0004\u0012\u00020\u0010`&H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/security/devenvcheck/WlanSecurityRiskPromptActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "dialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "mainHandler", "Landroid/os/Handler;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "targetBssid", "", "targetSsid", "disconnectWifi", "", "dismissAndFinish", "dismissIfTargetWifiGone", "isSameTargetWifi", "", PerfConsts.KEY_CURRENT_GALVANIC, "Lcom/obric/security/devenvcheck/WifiInfoUtils$WifiInfoResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "registerWifiNetworkCallback", "sendDetectResultBroadcast", "userAction", "ssid", "bssid", "isSafe", "risks", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "unregisterWifiNetworkCallback", "Companion", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WlanSecurityRiskPromptActivity extends AppCompatActivity {
    public static final String ACTION_CHECK_RESULT_CHANGED = "com.ocean.security.wlan.ACTION_CHECK_RESULT_CHANGED";
    public static final Companion Companion = null;
    public static final String EXTRA_BSSID = "extra_bssid";
    public static final String EXTRA_HAS_RISK = "extra_has_risk";
    public static final String EXTRA_IS_SAFE = "extra_is_safe";
    public static final String EXTRA_RISKS = "extra_risks";
    public static final String EXTRA_SSID = "extra_ssid";
    public static final String EXTRA_TIMESTAMP = "extra_timestamp";
    public static final String EXTRA_USER_ACTION = "extra_user_action";
    private static final String TAG = "WlanWifiCheck";
    public static final String USER_ACTION_IGNORE = "ignore";
    private final Lazy connectivityManager$delegate;
    private OActionDialog dialog;
    private final Handler mainHandler;
    private ConnectivityManager.NetworkCallback networkCallback;
    private String targetBssid;
    private String targetSsid;

    /* JADX INFO: compiled from: WlanSecurityRiskPromptActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/security/devenvcheck/WlanSecurityRiskPromptActivity$Companion;", "", "()V", "ACTION_CHECK_RESULT_CHANGED", "", "EXTRA_BSSID", "EXTRA_HAS_RISK", "EXTRA_IS_SAFE", "EXTRA_RISKS", "EXTRA_SSID", "EXTRA_TIMESTAMP", "EXTRA_USER_ACTION", "TAG", "USER_ACTION_IGNORE", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) this.connectivityManager$delegate.getValue();
    }

    public WlanSecurityRiskPromptActivity() {
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.connectivityManager$delegate = LazyKt.lazy(new WlanSecurityRiskPromptActivity$connectivityManager$2(this));
        this.targetSsid = "";
        this.targetBssid = "";
    }

    public static final /* synthetic */ void access$disconnectWifi(WlanSecurityRiskPromptActivity r0) {
        r0.disconnectWifi();
    }

    public static final /* synthetic */ void access$dismissAndFinish(WlanSecurityRiskPromptActivity r0) {
        r0.dismissAndFinish();
    }

    public static final /* synthetic */ void access$dismissIfTargetWifiGone(WlanSecurityRiskPromptActivity r0) {
        r0.dismissIfTargetWifiGone();
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(WlanSecurityRiskPromptActivity r0) {
        return r0.mainHandler;
    }

    public static final /* synthetic */ void access$sendDetectResultBroadcast(WlanSecurityRiskPromptActivity r0, String r1, String r2, String r3, boolean r4, ArrayList r5) {
        r0.sendDetectResultBroadcast(r1, r2, r3, r4, r5);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        String r11 = getIntent().getStringExtra(EXTRA_SSID);
        if (r11 != null) goto L5;
        final String r4 = "";
    L6:
        String r12 = getIntent().getStringExtra(EXTRA_BSSID);
        if (r12 != null) goto L9;
        final String r3 = "";
    L10:
        ArrayList<String> r13 = getIntent().getStringArrayListExtra(EXTRA_RISKS);
        if (r13 != null) goto L13;
        r13 = new ArrayList();
    L13:
        final ArrayList<String> r6 = r13;
        final boolean r5 = getIntent().getBooleanExtra(EXTRA_IS_SAFE, r6.isEmpty());
        this.targetSsid = r4;
        this.targetBssid = r3;
        OLog.d("WlanWifiCheck", "Prompt onCreate: show prompt. ssid=" + r4 + ", bssid=" + r3 + ", isSafe=" + r5 + ", risks=" + r6);
        WlanSecurityRiskPromptActivity r14 = this;
        final View r0 = LayoutInflater.from(r14).inflate(R.layout.wlan_security_risk_action_dialog, null);
        String r2 = getString(R.string.wlan_security_risk_title);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.wlan_security_risk_title)");
        String r7 = getString(R.string.wlan_security_risk_subtitle);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.wlan_security_risk_subtitle)");
        OActionDialog r8 = new OActionDialog(r14, new OActionDialog.Modifier(r2, r7, new WlanSecurityRiskPromptActivity$onCreate$modifier$1(r0)));
        r8.setCanceledOnTouchOutside(false);
        Unit r15 = Unit.INSTANCE;
        this.dialog = r8;
        OButton r16 = (OButton) r0.findViewById(R.id.btn_disconnect);
        OButton r1 = (OButton) r0.findViewById(R.id.btn_trust);
        OButton r9 = (OButton) r0.findViewById(R.id.btn_ignore);
        r16.setText(R.string.wlan_security_risk_disconnect_now);
        r1.setText(R.string.wlan_security_risk_trust_network);
        r9.setText(R.string.wlan_security_risk_ignore);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L16
        WlanSecurityRiskPromptActivity r18 = this;     // Catch: Throwable -> L16
        r16.setTextColor(getColor(R.color.oui_functional_blue_6));     // Catch: Throwable -> L16
        Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        r16.setOnClickListener(new AnonymousClass3(this, r3, r4));
        r1.setOnClickListener(new AnonymousClass4(this, r3, r4));
        r9.setOnClickListener(new AnonymousClass5(this, r3, r4, r5, r6));
        OActionDialog r19 = this.dialog;
        if (r19 == null) goto L21;
        r19.setOnDismissListener(new AnonymousClass6(this));
    L21:
        OActionDialog r110 = this.dialog;
        if (r110 == null) goto L24;
        r110.show();
    L24:
        registerWifiNetworkCallback();
        return;
    L16:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L18
    L9:
        r3 = r12;
        goto L10
    L5:
        r4 = r11;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        unregisterWifiNetworkCallback();
        this.mainHandler.removeCallbacksAndMessages(null);
        OActionDialog r0 = this.dialog;
        if (r0 == null) goto L5;
        r0.setOnDismissListener(null);
    L5:
        OActionDialog r1 = this.dialog;
        if (r1 == null) goto L8;
        r1.dismiss();
    L8:
        OActionDialog r2 = (OActionDialog) null;
        this.dialog = null;
        super.onDestroy();
    }

    private final void registerWifiNetworkCallback() {
        ConnectivityManager r0 = getConnectivityManager();
        if (r0 != null) goto L6;
        OLog.w("WlanWifiCheck", "registerWifiNetworkCallback: ConnectivityManager unavailable");
        return;
    L6:
        NetworkRequest r2 = new NetworkRequest.Builder().addTransportType(1).build();
        WlanSecurityRiskPromptActivity$registerWifiNetworkCallback$callback$1 r3 = new WlanSecurityRiskPromptActivity$registerWifiNetworkCallback$callback$1(this);
        this.networkCallback = r3;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        WlanSecurityRiskPromptActivity r5 = this;     // Catch: Throwable -> L9
        r0.registerNetworkCallback(r2, r3, this.mainHandler);     // Catch: Throwable -> L9
        OLog.d("WlanWifiCheck", "registerWifiNetworkCallback: registered");     // Catch: Throwable -> L9
        Object r1 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r6 = Result.m777exceptionOrNullimpl(r1);
        if (r6 == null) goto L17;
        OLog.w("WlanWifiCheck", "registerWifiNetworkCallback failed", r6);
        ConnectivityManager.NetworkCallback r7 = (ConnectivityManager.NetworkCallback) null;
        this.networkCallback = null;
        return;
    L17:
        return;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final void unregisterWifiNetworkCallback() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        WlanSecurityRiskPromptActivity r2 = this;     // Catch: Throwable -> L11
        ConnectivityManager.NetworkCallback r3 = this.networkCallback;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        ConnectivityManager r4 = getConnectivityManager();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        r4.unregisterNetworkCallback(r3);     // Catch: Throwable -> L11
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.m774constructorimpl(r5);     // Catch: Throwable -> L11
    L13:
        ConnectivityManager.NetworkCallback r6 = (ConnectivityManager.NetworkCallback) null;
        this.networkCallback = null;
        return;
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void dismissIfTargetWifiGone() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L20;
        WlanSecurityRiskPromptActivity r1 = this;
        WifiInfoUtils.WifiInfoResult r0 = WifiInfoUtils.INSTANCE.getCurrentWifiInfo(r1);
        if (r0 != null) goto L10;
    L12:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L17;
        OLog.d("WlanWifiCheck", "dismissIfTargetWifiGone: still on target wifi, keep prompt. ssid=" + this.targetSsid);
        return;
    L17:
        OLog.d("WlanWifiCheck", "dismissIfTargetWifiGone: target wifi gone (current=" + r0 + "), dismiss prompt. ssid=" + this.targetSsid + ", bssid=" + this.targetBssid);
        WlanRiskNotifier.INSTANCE.cancel(r1);
        dismissAndFinish();
        return;
    L10:
        if (isSameTargetWifi(r0) == false) goto L12;
        r2 = true;
        goto L14
    }

    private final boolean isSameTargetWifi(WifiInfoUtils.WifiInfoResult r3) {
        if ((!StringsKt.isBlank(this.targetBssid)) == false) goto L6;
        return StringsKt.equals(r3.getBssid(), this.targetBssid, true);
    L6:
        return Intrinsics.areEqual(r3.getSsid(), this.targetSsid);
    }

    private final void disconnectWifi() {
        WlanDisconnector.INSTANCE.disconnectCurrent(this);
    }

    private final void dismissAndFinish() {
        OActionDialog r0 = this.dialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private final void sendDetectResultBroadcast(String r3, String r4, String r5, boolean r6, ArrayList<String> r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        WlanSecurityRiskPromptActivity r1 = this;     // Catch: Throwable -> L8
        Intent r2 = new Intent(ACTION_CHECK_RESULT_CHANGED);     // Catch: Throwable -> L8
        r2.putExtra(EXTRA_USER_ACTION, r3);     // Catch: Throwable -> L8
        r2.putExtra(EXTRA_SSID, r4);     // Catch: Throwable -> L8
        r2.putExtra(EXTRA_BSSID, r5);     // Catch: Throwable -> L8
        r2.putExtra(EXTRA_IS_SAFE, r6);     // Catch: Throwable -> L8
        r2.putStringArrayListExtra(EXTRA_RISKS, r7);     // Catch: Throwable -> L8
        if (r6 == true) goto L5;
        boolean r8 = true;
    L6:
        r2.putExtra(EXTRA_HAS_RISK, r8);     // Catch: Throwable -> L8
        r2.putExtra(EXTRA_TIMESTAMP, System.currentTimeMillis());     // Catch: Throwable -> L8
        sendBroadcast(r2);     // Catch: Throwable -> L8
        Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L5:
        r8 = false;
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
    }
}
