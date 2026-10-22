package com.obric.security.networksettings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.NetworkPolicyManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IPowerAdvisor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProvider;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.securitycenter.SharedPreferUtil;
import com.bytedanceos.securitycenter.networkControl.DeviceIdleControllerHelper;
import com.bytedanceos.securitycenter.networkControl.NetworkRejectHelper;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemCheck;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.security.R;
import com.obric.securitycenter.api.TrackUtils;
import java.util.HashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: NetworkPolicyActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0016\u0010\u001c\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\"\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u001fH\u0016R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R#\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR#\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\rR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/security/networksettings/NetworkPolicyActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "appName", "Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "kotlin.jvm.PlatformType", "getAppName", "()Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "appName$delegate", "Lkotlin/Lazy;", "backgroundNetworkAllow", "Lcom/obric/oui/lisitem/OListItemCheck;", "getBackgroundNetworkAllow", "()Lcom/obric/oui/lisitem/OListItemCheck;", "backgroundNetworkAllow$delegate", "backgroundNetworkRejectScreenOff", "getBackgroundNetworkRejectScreenOff", "backgroundNetworkRejectScreenOff$delegate", "dataViewModel", "Lcom/obric/security/networksettings/NetworkPolicySettingViewModel;", "mNetworkPolicyManager", "Landroid/net/NetworkPolicyManager;", "mPowerAdvisor", "Landroid/os/IPowerAdvisor;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveChangeAppInSP", "set", "", "", "saveNetworkPolicyStatus", "packageName", "uid", "", SearchConfigType.KEY_MODE, "scene", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class NetworkPolicyActivity extends BaseActivity {
    public static final Companion Companion = null;
    private HashMap _$_findViewCache;
    private final Lazy appName$delegate;
    private final Lazy backgroundNetworkAllow$delegate;
    private final Lazy backgroundNetworkRejectScreenOff$delegate;
    private NetworkPolicySettingViewModel dataViewModel;
    private NetworkPolicyManager mNetworkPolicyManager;
    private IPowerAdvisor mPowerAdvisor;

    /* JADX INFO: compiled from: NetworkPolicyActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/obric/security/networksettings/NetworkPolicyActivity$Companion;", "", "()V", "startNetworkPolicyActivity", "", "context", "Landroid/content/Context;", SearchConfigType.KEY_MODE, "", "appName", "", "packageName", "uid", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void startNetworkPolicyActivity(Context r11, int r12, String r13, String r14, int r15) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r13, "appName");
            Intrinsics.checkNotNullParameter(r14, "packageName");
            Intent r1 = new Intent(r11, NetworkPolicyActivity.class);
            r1.putExtra(SearchConfigType.KEY_MODE, r12);
            r1.putExtra("appName", r13);
            r1.putExtra("packageName", r14);
            r1.putExtra("uid", r15);
            TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "network_policy_click", MapsKt.mapOf(new Pair[]{TuplesKt.to(SearchConfigType.KEY_MODE, Integer.valueOf(r12)), TuplesKt.to("appName", r13), TuplesKt.to("packageName", r14), TuplesKt.to("uid", Integer.valueOf(r15))}), false, 4, null);
            r11.startActivity(r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final OCTitleBar getAppName() {
        return (OCTitleBar) this.appName$delegate.getValue();
    }

    private final OListItemCheck getBackgroundNetworkAllow() {
        return (OListItemCheck) this.backgroundNetworkAllow$delegate.getValue();
    }

    private final OListItemCheck getBackgroundNetworkRejectScreenOff() {
        return (OListItemCheck) this.backgroundNetworkRejectScreenOff$delegate.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "network_policy_setting";
    }

    public NetworkPolicyActivity() {
        this.appName$delegate = LazyKt.lazy(new NetworkPolicyActivity$appName$2(this));
        this.backgroundNetworkAllow$delegate = LazyKt.lazy(new NetworkPolicyActivity$backgroundNetworkAllow$2(this));
        this.backgroundNetworkRejectScreenOff$delegate = LazyKt.lazy(new NetworkPolicyActivity$backgroundNetworkRejectScreenOff$2(this));
    }

    public static final /* synthetic */ OListItemCheck access$getBackgroundNetworkAllow$p(NetworkPolicyActivity r0) {
        return r0.getBackgroundNetworkAllow();
    }

    public static final /* synthetic */ OListItemCheck access$getBackgroundNetworkRejectScreenOff$p(NetworkPolicyActivity r0) {
        return r0.getBackgroundNetworkRejectScreenOff();
    }

    public static final /* synthetic */ NetworkPolicySettingViewModel access$getDataViewModel$p(NetworkPolicyActivity r0) {
        return r0.dataViewModel;
    }

    public static final /* synthetic */ void access$saveChangeAppInSP(NetworkPolicyActivity r0, Set r1) {
        r0.saveChangeAppInSP(r1);
    }

    public static final /* synthetic */ void access$saveNetworkPolicyStatus(NetworkPolicyActivity r0, String r1, int r2, int r3) {
        r0.saveNetworkPolicyStatus(r1, r2, r3);
    }

    public static final /* synthetic */ void access$setDataViewModel$p(NetworkPolicyActivity r0, NetworkPolicySettingViewModel r1) {
        r0.dataViewModel = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.activity_network_policy);
        NetworkPolicySettingViewModel r0 = (NetworkPolicySettingViewModel) new ViewModelProvider(this).get(NetworkPolicySettingViewModel.class);
        this.dataViewModel = r0;
        if (r3 != null) goto L6;
        if (r0 == null) goto L6;
        Intent r4 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r4, "intent");
        r0.initFromIntent(r4);
    L6:
        OCTitleBar r5 = getAppName();
        Intrinsics.checkNotNull(r5);
        ViewCompat.setOnApplyWindowInsetsListener(r5, AnonymousClass1.INSTANCE);
        OCTitleBar r6 = getAppName();
        if (r6 == null) goto L11;
        OButton r7 = r6.getMLeftActionBack();
        if (r7 == null) goto L11;
        r7.setOnClickListener(new AnonymousClass2(this));
    L11:
        this.mPowerAdvisor = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));
        this.mNetworkPolicyManager = NetworkPolicyManager.from(this);
        NetworkPolicySettingViewModel r8 = this.dataViewModel;
        String r1 = null;
        if (r8 == null) goto L14;
        String r9 = r8.getAppName();
    L16:
        if (TextUtils.isEmpty(r9) == true) goto L23;
        OCTitleBar r10 = getAppName();
        if (r10 == null) goto L23;
        NetworkPolicySettingViewModel r2 = this.dataViewModel;
        if (r2 == null) goto L22;
        r1 = r2.getAppName();
    L22:
        r10.setTitleText(r1);
    L23:
        NetworkPolicySettingViewModel r11 = this.dataViewModel;
        if (r11 != null) goto L26;
    L33:
        OListItemCheck r12 = getBackgroundNetworkAllow();
        if (r12 == null) goto L36;
        r12.setChecked(false);
    L36:
        OListItemCheck r13 = getBackgroundNetworkRejectScreenOff();
        if (r13 == null) goto L39;
        r13.setChecked(true);
    L39:
        OListItemCheck r14 = getBackgroundNetworkAllow();
        if (r14 == null) goto L42;
        r14.setOnClickListener(new AnonymousClass3(this));
    L42:
        OListItemCheck r15 = getBackgroundNetworkRejectScreenOff();
        if (r15 == null) goto L46;
        r15.setOnClickListener(new AnonymousClass4(this));
        return;
    L46:
        return;
    L26:
        if (r11.getMode() != 0) goto L33;
        OListItemCheck r16 = getBackgroundNetworkAllow();
        if (r16 == null) goto L30;
        r16.setChecked(true);
    L30:
        OListItemCheck r17 = getBackgroundNetworkRejectScreenOff();
        if (r17 == null) goto L39;
        r17.setChecked(false);
        goto L39
    L14:
        r9 = null;
        goto L16
    }

    private final void saveNetworkPolicyStatus(String r2, final int r3, int r4) {
        NetworkRejectHelper.setRealPolicy(this.mNetworkPolicyManager, r3, r4);
        if (r4 != 0) goto L5;
        DeviceIdleControllerHelper.addApp(r2);
    L6:
        AsyncTask.execute(new RunnableC03891(this, r3));
        if (this.mPowerAdvisor != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L16;
        IPowerAdvisor r1 = this.mPowerAdvisor;     // Catch: RemoteException -> L12
        Intrinsics.checkNotNull(r1);     // Catch: RemoteException -> L12
        r1.userSelectedWhitelistApp(r2, r4);     // Catch: RemoteException -> L12
        return;
    L17:
        return;
    L16:
        return;
    L5:
        DeviceIdleControllerHelper.removeApp(r2);
        goto L6
    }

    private final void saveChangeAppInSP(Set<String> r3) {
        SharedPreferences r2 = getSharedPreferences(NetworkRejectHelper.NETWORK_CONTROL, 0);
        Set<String> r0 = r2.getStringSet(NetworkRejectHelper.NETWORKPOLICY_CHANGE_APP, SetsKt.emptySet());
        Intrinsics.checkNotNull(r0);
        r3.addAll(r0);
        SharedPreferUtil.commitAsynchronously(r2.edit().putStringSet(NetworkRejectHelper.NETWORKPOLICY_CHANGE_APP, r3));
    }
}
