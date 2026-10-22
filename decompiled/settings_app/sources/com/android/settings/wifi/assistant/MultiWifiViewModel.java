package com.android.settings.wifi.assistant;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.GlobalProxyLancet;
import com.android.settings.AdaptConstants;
import com.android.settings.AdaptWifiConfig;
import com.android.settings.FeatureFactory;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.SettingsApplication;
import com.android.settings.ToastUtils;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.utils.SLog;
import com.android.settings.wifi.AccessPoint;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.WifiSetupActivity;
import com.android.settings.wifi.WifiSetupFragment;
import com.android.settings.wifi.WlanRiskInfo;
import com.android.settingslib.SliceBroadcastRelay;
import com.android.wifitrackerlib.Utils;
import com.android.wifitrackerlib.WifiEntry;
import com.android.wifitrackerlib.WifiPickerTracker;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.olog.OLog;
import com.obric.oui.utils.AnimTokens;
import cz.msebera.android.httpclient.message.TokenParser;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MultiWifiViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002)>\b\u0007\u0018\u0000 x2\u00020\u0001:\u0001xB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020#H\u0002J8\u0010D\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\n\u0012\u0006\u0012\u0004\u0018\u00010B0E2\u0006\u00106\u001a\u0002072\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0003J\b\u0010J\u001a\u00020KH\u0002J\u001c\u0010L\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180EH\u0002J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010C\u001a\u00020#H\u0002J\u0018\u0010N\u001a\u00020 2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020#H\u0002J\u001b\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000b0PH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bQ\u0010RJf\u0010S\u001a\u00020K2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020B0U2\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040W2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010X\u001a\u00020 2\u0016\b\u0002\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020K\u0018\u00010Z2\u0006\u0010[\u001a\u00020\u0006H\u0003J*\u0010\\\u001a\u00020K2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010bJ\b\u0010c\u001a\u00020KH\u0014J\u0016\u0010d\u001a\u00020K2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\u000bJ\u0016\u0010h\u001a\u00020K2\u0006\u0010i\u001a\u00020j2\u0006\u0010e\u001a\u00020fJ\u000e\u0010k\u001a\u00020K2\u0006\u0010l\u001a\u00020\u0006J\b\u0010m\u001a\u00020KH\u0002J\u0016\u0010n\u001a\u00020K2\u0006\u0010e\u001a\u00020f2\u0006\u0010o\u001a\u00020 J\u0010\u0010p\u001a\u00020K2\u0006\u0010A\u001a\u00020BH\u0002J\u0018\u0010q\u001a\u00020K2\u0006\u0010i\u001a\u00020j2\u0006\u0010e\u001a\u00020fH\u0002J\u0006\u0010r\u001a\u00020KJ\b\u0010s\u001a\u00020KH\u0002J\b\u0010t\u001a\u00020KH\u0002J\n\u0010u\u001a\u00020 *\u00020vJ\n\u0010u\u001a\u00020 *\u00020GJ\n\u0010w\u001a\u00020 *\u00020vJ\n\u0010w\u001a\u00020 *\u00020GR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR#\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010 0 0\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\rR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010$\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010 0 0\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u0010\u0010&\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u00102\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010 0 0\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\rR\u001d\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\n0\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\rR\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0014\u001a\u0004\b8\u00109R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006y"}, d2 = {"Lcom/android/settings/wifi/assistant/MultiWifiViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "REQUEST_CODE_SET_SETUP_WIFI", "", "TAG", "", "WIFI_AP_STATE_CHANGED_ACTION", "accessPointInfoListLv", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/android/settings/wifi/assistant/SubAccessPoint;", "getAccessPointInfoListLv", "()Landroidx/lifecycle/MutableLiveData;", "caeSmartNetworkManager", "Lcom/obric/cae/libs/wifi/ICaeSmartNetworkManager;", "kotlin.jvm.PlatformType", "getCaeSmartNetworkManager", "()Lcom/obric/cae/libs/wifi/ICaeSmartNetworkManager;", "caeSmartNetworkManager$delegate", "Lkotlin/Lazy;", "connectedAccessPointInfoLv", "getConnectedAccessPointInfoLv", "connectedWifiEntryLv", "Lcom/android/wifitrackerlib/WifiEntry;", "getConnectedWifiEntryLv", "connectivityManager", "Landroid/net/ConnectivityManager;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "isRefreshing", "", "isScanningLv", "lastConnectConfiguration", "Landroid/net/wifi/WifiConfiguration;", "multiWifiEnabledLv", "getMultiWifiEnabledLv", "pendingAccessPointInfo", "pendingConnect", SliceBroadcastRelay.EXTRA_RECEIVER, "com/android/settings/wifi/assistant/MultiWifiViewModel$receiver$1", "Lcom/android/settings/wifi/assistant/MultiWifiViewModel$receiver$1;", "secondaryNetworkCallback", "Lcom/android/settings/wifi/assistant/SecondaryNetworkCallback;", "getSecondaryNetworkCallback", "()Lcom/android/settings/wifi/assistant/SecondaryNetworkCallback;", "setSecondaryNetworkCallback", "(Lcom/android/settings/wifi/assistant/SecondaryNetworkCallback;)V", "supportPskTypes", "wifiEnabledLv", "getWifiEnabledLv", "wifiEntriesLv", "getWifiEntriesLv", "wifiManager", "Landroid/net/wifi/WifiManager;", "getWifiManager", "()Landroid/net/wifi/WifiManager;", "wifiManager$delegate", "wifiPickerTracker", "Lcom/android/wifitrackerlib/WifiPickerTracker;", "wifiPickerTrackerCallback", "com/android/settings/wifi/assistant/MultiWifiViewModel$wifiPickerTrackerCallback$1", "Lcom/android/settings/wifi/assistant/MultiWifiViewModel$wifiPickerTrackerCallback$1;", "configMatchScore", "accessPointInfo", "Lcom/android/settings/wifi/AccessPointInfo;", "config", "constructAccessPoints", "Lkotlin/Pair;", "lastWifiInfo", "Landroid/net/wifi/WifiInfo;", "lastState", "Landroid/net/NetworkInfo$DetailedState;", "endRefresh", "", "getAvailableWifiEntries", "getSecurityFromConfig", "isSameAccessPointConfig", "mainAccessPoint", "Lkotlin/Result;", "mainAccessPoint-d1pmJ48", "()Ljava/lang/Object;", "mergeConfiguredNetworks", "accessPoints", "", "duplicationSet", "", "appendUnmatchedConfig", "onAppendNewAccessPoint", "Lkotlin/Function1;", "logMessage", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCleared", "onItemClick", "context", "Landroid/content/Context;", "point", "onViewCreate", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "refreshWifiList", "scene", "resetSummary", "setMultiWifiEnabled", IndexDatabaseHelper.IndexColumns.ENABLED, "setWifiEntryKey", "setupWifiPickerTracker", "startScan", "tryResetConnectSubAccessPoint", "tryUpdateConnectSubAccessPoint", "is24GHzAP", "Landroid/net/wifi/ScanResult;", "is5GHzAP", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MultiWifiViewModel extends ViewModel {
    private static final Companion Companion = null;

    @Deprecated
    public static final int SECURITY_EAP = 3;

    @Deprecated
    public static final int SECURITY_PSK = 2;

    @Deprecated
    public static final int SECURITY_SAE = 6;

    @Deprecated
    public static final int SECURITY_WAPI_CERT = 5;

    @Deprecated
    public static final int SECURITY_WAPI_PSK = 4;

    @Deprecated
    public static final int SECURITY_WEP = 1;
    private final int REQUEST_CODE_SET_SETUP_WIFI;
    private final String TAG;
    private final String WIFI_AP_STATE_CHANGED_ACTION;
    private final MutableLiveData<List<SubAccessPoint>> accessPointInfoListLv;
    private final Lazy caeSmartNetworkManager$delegate;
    private final MutableLiveData<SubAccessPoint> connectedAccessPointInfoLv;
    private final MutableLiveData<WifiEntry> connectedWifiEntryLv;
    private final Lazy connectivityManager$delegate;
    private boolean isRefreshing;
    private final MutableLiveData<Boolean> isScanningLv;
    private WifiConfiguration lastConnectConfiguration;
    private final MutableLiveData<Boolean> multiWifiEnabledLv;
    private SubAccessPoint pendingAccessPointInfo;
    private boolean pendingConnect;
    private final MultiWifiViewModel$receiver$1 receiver;
    private SecondaryNetworkCallback secondaryNetworkCallback;
    private final List<String> supportPskTypes;
    private final MutableLiveData<Boolean> wifiEnabledLv;
    private final MutableLiveData<List<WifiEntry>> wifiEntriesLv;
    private final Lazy wifiManager$delegate;
    private WifiPickerTracker wifiPickerTracker;
    private final MultiWifiViewModel$wifiPickerTrackerCallback$1 wifiPickerTrackerCallback;

    /* JADX INFO: compiled from: MultiWifiViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/settings/wifi/assistant/MultiWifiViewModel$Companion;", "", "()V", "SECURITY_EAP", "", "SECURITY_PSK", "SECURITY_SAE", "SECURITY_WAPI_CERT", "SECURITY_WAPI_PSK", "SECURITY_WEP", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.assistant.MultiWifiViewModel$onActivityResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MultiWifiViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.assistant.MultiWifiViewModel$onActivityResult$1", f = "MultiWifiViewModel.kt", i = {0}, l = {625}, m = "invokeSuspend", n = {"pendingAccessPointInfo"}, s = {"L$0"})
    static final class C01511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Intent $data;
        Object L$0;
        int label;
        final /* synthetic */ MultiWifiViewModel this$0;

        C01511(Intent r1, MultiWifiViewModel r2, Activity r3, Continuation<? super C01511> r4) {
            this.$data = r1;
            this.this$0 = r2;
            this.$activity = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01511(this.$data, this.this$0, this.$activity, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01511) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            SubAccessPoint r3 = (SubAccessPoint) this.L$0;
            ResultKt.throwOnFailure(r13);
        L32:
            String r14 = (String) r13;
            if (r14 != null) goto L35;
        L36:
            r2 = true;
        L37:
            if (r2 == true) goto L39;
            r3.updateState(SubAccessPoint.State.Success.INSTANCE);
        L41:
            return Unit.INSTANCE;
        L39:
            r3.updateState(SubAccessPoint.State.Default.INSTANCE);
            ToastUtils.show(this.$activity, "连接失败");
            goto L41
        L35:
            if (r14.length() != 0) goto L37;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            Intent r15 = this.$data;
            if (r15 == null) goto L43;
            String r16 = r15.getStringExtra(WifiSetupFragment.KEY_WLAN_PASSWORD);
            if (r16 == null) goto L43;
            if (r16.length() <= 0) goto L15;
            boolean r4 = true;
        L17:
            if (r4 == true) goto L20;
            r16 = null;
        L20:
            if (r16 == null) goto L43;
            SubAccessPoint r5 = MultiWifiViewModel.access$getPendingAccessPointInfo$p(this.this$0);
            if (r5 == null) goto L24;
            MultiWifiViewModel.access$setLastConnectConfiguration$p(this.this$0, null);
            MultiWifiViewModel.access$setPendingAccessPointInfo$p(this.this$0, null);
            WifiUtils r6 = WifiUtils.INSTANCE;
            String r7 = r5.getInfo().bssid;
            Intrinsics.checkNotNullExpressionValue(r7, WlanRiskInfo.EXTRA_BSSID);
            String r8 = r5.getInfo().ssid;
            Intrinsics.checkNotNullExpressionValue(r8, "ssid");
            String r9 = r5.getInfo().pskType.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r9, "toLowerCase(...)");
            String r17 = r16.substring(1, r16.length() - 1);
            Intrinsics.checkNotNullExpressionValue(r17, "substring(...)");
            if (r17 != null) goto L28;
            r17 = "";
        L28:
            this.L$0 = r5;
            this.label = 1;
            r13 = r6.requestSecondaryWifi(r7, r8, r9, r17, this);
            if (r13 != r0) goto L31;
            return r0;
        L31:
            r3 = r5;
            goto L32
        L24:
            return Unit.INSTANCE;
        L15:
            r4 = false;
        L43:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.assistant.MultiWifiViewModel$onItemClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MultiWifiViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.assistant.MultiWifiViewModel$onItemClick$1", f = "MultiWifiViewModel.kt", i = {}, l = {554}, m = "invokeSuspend", n = {}, s = {})
    static final class C01521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AccessPointInfo $info;
        final /* synthetic */ SubAccessPoint $point;
        int label;

        C01521(AccessPointInfo r1, SubAccessPoint r2, Context r3, Continuation<? super C01521> r4) {
            this.$info = r1;
            this.$point = r2;
            this.$context = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01521(this.$info, this.$point, this.$context, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01521) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            String r11 = (String) r10;
            if (r11 != null) goto L14;
        L17:
            if (r2 == true) goto L19;
            this.$point.updateState(SubAccessPoint.State.Success.INSTANCE);
        L21:
            return Unit.INSTANCE;
        L19:
            this.$point.updateState(SubAccessPoint.State.Default.INSTANCE);
            ToastUtils.showInView(this.$context, "连接失败");
            goto L21
        L14:
            if (r11.length() == 0) goto L17;
            r2 = false;
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            WifiUtils r3 = WifiUtils.INSTANCE;
            String r4 = this.$info.bssid;
            Intrinsics.checkNotNullExpressionValue(r4, WlanRiskInfo.EXTRA_BSSID);
            String r5 = this.$info.ssid;
            Intrinsics.checkNotNullExpressionValue(r5, "ssid");
            this.label = 1;
            r10 = r3.requestSecondaryWifi(r4, r5, "open", "", this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.assistant.MultiWifiViewModel$onItemClick$2, reason: invalid class name */
    /* JADX INFO: compiled from: MultiWifiViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.assistant.MultiWifiViewModel$onItemClick$2", f = "MultiWifiViewModel.kt", i = {}, l = {569}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AccessPointInfo $info;
        final /* synthetic */ SubAccessPoint $point;
        int label;

        AnonymousClass2(AccessPointInfo r1, SubAccessPoint r2, Context r3, Continuation<? super AnonymousClass2> r4) {
            this.$info = r1;
            this.$point = r2;
            this.$context = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$info, this.$point, this.$context, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            String r11 = (String) r10;
            if (r11 != null) goto L18;
        L21:
            if (r2 == true) goto L23;
            this.$point.updateState(SubAccessPoint.State.Success.INSTANCE);
        L25:
            return Unit.INSTANCE;
        L23:
            this.$point.updateState(SubAccessPoint.State.Default.INSTANCE);
            ToastUtils.showInView(this.$context, "连接失败");
            goto L25
        L18:
            if (r11.length() == 0) goto L21;
            r2 = false;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            WifiUtils r3 = WifiUtils.INSTANCE;
            String r4 = this.$info.bssid;
            Intrinsics.checkNotNullExpressionValue(r4, WlanRiskInfo.EXTRA_BSSID);
            String r5 = this.$info.ssid;
            Intrinsics.checkNotNullExpressionValue(r5, "ssid");
            if (this.$info.security != 0) goto L11;
            String r12 = "open";
        L12:
            this.label = 1;
            r10 = r3.requestSecondaryWifi(r4, r5, r12, "", this);
            if (r10 != r0) goto L15;
            return r0;
        L11:
            r12 = this.$info.pskType.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r12, "toLowerCase(...)");
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.assistant.MultiWifiViewModel$refreshWifiList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MultiWifiViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.assistant.MultiWifiViewModel$refreshWifiList$1", f = "MultiWifiViewModel.kt", i = {}, l = {AnimTokens.OUI_ANIMATION_DURATION_LONG_1, 462}, m = "invokeSuspend", n = {}, s = {})
    static final class C01541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MultiWifiViewModel this$0;

        /* JADX INFO: renamed from: com.android.settings.wifi.assistant.MultiWifiViewModel$refreshWifiList$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MultiWifiViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.wifi.assistant.MultiWifiViewModel$refreshWifiList$1$1", f = "MultiWifiViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MultiWifiViewModel this$0;

            C00361(MultiWifiViewModel r1, Continuation<? super C00361> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                return new C00361(this.this$0, r2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00361) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                OLog.i(MultiWifiViewModel.access$getTAG$p(this.this$0), "refreshWifiList: wifi is disabled");
                this.this$0.getConnectedAccessPointInfoLv().setValue(null);
                this.this$0.getAccessPointInfoListLv().setValue(CollectionsKt.emptyList());
                MultiWifiViewModel.access$endRefresh(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.wifi.assistant.MultiWifiViewModel$refreshWifiList$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: MultiWifiViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.wifi.assistant.MultiWifiViewModel$refreshWifiList$1$2", f = "MultiWifiViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<AccessPointInfo> $assessPoints;
            final /* synthetic */ AccessPointInfo $connectedAccessPoint;
            int label;
            final /* synthetic */ MultiWifiViewModel this$0;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(MultiWifiViewModel r1, AccessPointInfo r2, List<? extends AccessPointInfo> r3, Continuation<? super AnonymousClass2> r4) {
                this.this$0 = r1;
                this.$connectedAccessPoint = r2;
                this.$assessPoints = r3;
                super(2, r4);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass2(this.this$0, this.$connectedAccessPoint, this.$assessPoints, r4);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r19) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L109;
                ResultKt.throwOnFailure(r19);
                String r0 = MultiWifiViewModel.access$getTAG$p(this.this$0);
                StringBuilder r2 = new StringBuilder("connectedAccessPoint: ");
                AccessPointInfo r3 = this.$connectedAccessPoint;
                if (r3 == null) goto L7;
                String r4 = r3.ssid;
            L8:
                StringBuilder r5 = r2.append(r4).append(TokenParser.SP);
                AccessPointInfo r6 = this.$connectedAccessPoint;
                if (r6 == null) goto L11;
                Integer r7 = Boxing.boxInt(r6.getFrequency());
            L12:
                SLog.i(r0, r5.append(r7).toString());
                SLog.i(MultiWifiViewModel.access$getTAG$p(this.this$0), "accessPointInfoListLv: " + CollectionsKt.joinToString$default(this.$assessPoints, null, null, null, 0, null, C00371.INSTANCE, 31, null));
                if (this.$connectedAccessPoint != null) goto L16;
                this.this$0.getConnectedAccessPointInfoLv().setValue(null);
                this.this$0.getAccessPointInfoListLv().setValue(CollectionsKt.emptyList());
                MultiWifiViewModel.access$endRefresh(this.this$0);
                return Unit.INSTANCE;
            L16:
                SubAccessPoint r1 = this.this$0.getConnectedAccessPointInfoLv().getValue();
                if (r1 == null) goto L21;
                AccessPointInfo r8 = r1.getInfo();
                if (r8 == null) goto L21;
                String r9 = r8.ssid;
            L23:
                if (Intrinsics.areEqual(r9, this.$connectedAccessPoint.ssid) == true) goto L34;
                SubAccessPoint r10 = this.this$0.getConnectedAccessPointInfoLv().getValue();
                if (r10 == null) goto L31;
                AccessPointInfo r11 = r10.getInfo();
                if (r11 == null) goto L31;
                if (WifiUtils.INSTANCE.frequencyToBand(r11.getFrequency()) != WifiUtils.INSTANCE.frequencyToBand(this.$connectedAccessPoint.getFrequency())) goto L31;
                boolean r12 = true;
            L32:
                if (r12 == true) goto L34;
                this.this$0.setSecondaryNetworkCallback(SecondaryNetworkCallback.Companion.registerSecondaryNetworkCallback(this.this$0.getConnectivityManager(), WifiUtils.INSTANCE.bandRevers(WifiUtils.INSTANCE.frequencyToBand(this.$connectedAccessPoint.getFrequency()))));
            L31:
                r12 = false;
            L34:
                this.this$0.getConnectedAccessPointInfoLv().setValue(new SubAccessPoint(this.$connectedAccessPoint, null, 2, null));
                MultiWifiViewModel r13 = this.this$0;
                Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L37
                Object r15 = Result.m1508constructorimpl(MultiWifiViewModel.access$getCaeSmartNetworkManager(r13).getSecondaryWifiList());     // Catch: Throwable -> L37
            L40:
                if (Result.m1514isFailureimpl(r15) == false) goto L42;
                r15 = null;
            L42:
                List r16 = (List) r15;
                if (r16 != null) goto L45;
                r16 = CollectionsKt.emptyList();
            L45:
                OLog.i(MultiWifiViewModel.access$getTAG$p(this.this$0), "secondaryWifiList size: " + r16.size());
                List r17 = r16;
                OLog.i(MultiWifiViewModel.access$getTAG$p(this.this$0), "secondaryWifiList: " + CollectionsKt.joinToString$default(r17, null, null, null, 0, null, C00382.INSTANCE, 31, null));
                LinkedHashMap r18 = new LinkedHashMap();
                ArrayList r20 = new ArrayList();
                MultiWifiViewModel r21 = this.this$0;
                Iterator r22 = r17.iterator();
            L47:
                if (r22.hasNext() == false) goto L73;
                ScanResult r23 = (ScanResult) r22.next();
                String r110 = r23.SSID;
                if (r110 != null) goto L51;
            L54:
                boolean r111 = true;
            L55:
                if (r111 == true) goto L47;
                String r112 = r23.capabilities;
                Intrinsics.checkNotNullExpressionValue(r112, "capabilities");
                if (StringsKt.contains$default(r112, "[IBSS]", false, 2, null) == true) goto L47;
                ArrayList r113 = (List) r18.get(r23.SSID);
                if (r113 != null) goto L62;
                r113 = new ArrayList();
            L62:
                Iterator r114 = r113.iterator();
            L64:
                if (r114.hasNext() == false) goto L68;
                Object r115 = r114.next();
                if (((AccessPointInfo) r115).update(r23, false) == false) goto L64;
            L69:
                AccessPointInfo r116 = (AccessPointInfo) r115;
                if (r116 != null) goto L71;
                AccessPointInfo r117 = new AccessPointInfo(r23);
                MultiWifiViewModel.access$setWifiEntryKey(r21, r117);
                r20.add(r117);
                r113.add(r117);
                String r24 = r23.SSID;
                Intrinsics.checkNotNullExpressionValue(r24, "SSID");
                r18.put(r24, r113);
                goto L47
            L71:
                r116.bssid = r23.BSSID;
                MultiWifiViewModel.access$setWifiEntryKey(r21, r116);
                goto L47
            L68:
                r115 = null;
                goto L69
            L51:
                if (r110.length() == 0) goto L54;
                r111 = false;
                goto L55
            L73:
                MultiWifiViewModel.mergeConfiguredNetworks$default(this.this$0, r20, null, null, null, false, null, "secondaryWifiList configuredNetworks failed", 46, null);
                List<SubAccessPoint> r25 = this.this$0.getAccessPointInfoListLv().getValue();
                if (r25 == null) goto L76;
                List r26 = CollectionsKt.toMutableList(r25);
            L77:
                MutableLiveData<List<SubAccessPoint>> r27 = this.this$0.getAccessPointInfoListLv();
                if (r26 != null) goto L84;
                ArrayList r28 = r20;
                ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
                Iterator r30 = r28.iterator();
            L81:
                if (r30.hasNext() == false) goto L83;
                r29.add(new SubAccessPoint((AccessPointInfo) r30.next(), null, 2, null));
                goto L81
            L83:
                ArrayList r31 = r29;
            L106:
                r27.setValue(CollectionsKt.sorted(r31));
                MultiWifiViewModel.access$endRefresh(this.this$0);
                MultiWifiViewModel.access$tryUpdateConnectSubAccessPoint(this.this$0);
                return Unit.INSTANCE;
            L84:
                ArrayList r32 = r20;
                ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
                Iterator r34 = r32.iterator();
            L86:
                if (r34.hasNext() == false) goto L105;
                AccessPointInfo r35 = (AccessPointInfo) r34.next();
                Iterator r118 = r26.iterator();
            L89:
                if (r118.hasNext() == false) goto L98;
                Object r119 = r118.next();
                SubAccessPoint r120 = (SubAccessPoint) r119;
                if (Intrinsics.areEqual(r120.getInfo().ssid, r35.ssid) == true) goto L93;
            L95:
                boolean r121 = false;
            L96:
                if (r121 == false) goto L89;
            L99:
                SubAccessPoint r122 = (SubAccessPoint) r119;
                if (r122 == null) goto L103;
                r122.setInfo(r35);
                if (r122 == null) goto L103;
            L104:
                r33.add(r122);
            L103:
                r122 = new SubAccessPoint(r35, null, 2, null);
                goto L104
            L93:
                if (WifiUtils.INSTANCE.frequencyToBand(r120.getInfo().getFrequency()) != WifiUtils.INSTANCE.frequencyToBand(r35.getFrequency())) goto L95;
                r121 = true;
                goto L96
            L98:
                r119 = null;
                goto L99
            L105:
                r31 = r33;
                goto L106
            L76:
                r26 = null;
            L37:
                th = move-exception;
                Result.Companion r36 = Result.Companion;
                r15 = Result.m1508constructorimpl(ResultKt.createFailure(th));
            L21:
                r9 = null;
                goto L23
            L11:
                r7 = null;
                goto L12
            L7:
                r4 = null;
                goto L8
            L109:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C01541(MultiWifiViewModel r1, Continuation<? super C01541> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C01541(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01541) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L16:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r8);
            if (MultiWifiViewModel.access$getWifiManager(this.this$0).getWifiState() != 1) goto L17;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C00361(this.this$0, null), this) != r0) goto L16;
            return r0;
        L17:
            MultiWifiViewModel r9 = this.this$0;
            Pair r10 = MultiWifiViewModel.access$constructAccessPoints(r9, MultiWifiViewModel.access$getWifiManager(r9), null, null);
            List r3 = (List) r10.component1();
            AccessPointInfo r11 = (AccessPointInfo) r10.component2();
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, r11, r3, null), this) != r0) goto L21;
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Pair access$constructAccessPoints(MultiWifiViewModel r0, WifiManager r1, WifiInfo r2, NetworkInfo.DetailedState r3) {
        return r0.constructAccessPoints(r1, r2, r3);
    }

    public static final /* synthetic */ void access$endRefresh(MultiWifiViewModel r0) {
        r0.endRefresh();
    }

    public static final /* synthetic */ ICaeSmartNetworkManager access$getCaeSmartNetworkManager(MultiWifiViewModel r0) {
        return r0.getCaeSmartNetworkManager();
    }

    public static final /* synthetic */ SubAccessPoint access$getPendingAccessPointInfo$p(MultiWifiViewModel r0) {
        return r0.pendingAccessPointInfo;
    }

    public static final /* synthetic */ String access$getTAG$p(MultiWifiViewModel r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ WifiManager access$getWifiManager(MultiWifiViewModel r0) {
        return r0.getWifiManager();
    }

    public static final /* synthetic */ void access$setLastConnectConfiguration$p(MultiWifiViewModel r0, WifiConfiguration r1) {
        r0.lastConnectConfiguration = r1;
    }

    public static final /* synthetic */ void access$setPendingAccessPointInfo$p(MultiWifiViewModel r0, SubAccessPoint r1) {
        r0.pendingAccessPointInfo = r1;
    }

    public static final /* synthetic */ void access$setWifiEntryKey(MultiWifiViewModel r0, AccessPointInfo r1) {
        r0.setWifiEntryKey(r1);
    }

    public static final /* synthetic */ void access$tryResetConnectSubAccessPoint(MultiWifiViewModel r0) {
        r0.tryResetConnectSubAccessPoint();
    }

    public static final /* synthetic */ void access$tryUpdateConnectSubAccessPoint(MultiWifiViewModel r0) {
        r0.tryUpdateConnectSubAccessPoint();
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.android.settings.wifi.assistant.MultiWifiViewModel$wifiPickerTrackerCallback$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.android.settings.wifi.assistant.MultiWifiViewModel$receiver$1] */
    public MultiWifiViewModel() {
        this.TAG = "MultiWifiViewModel";
        this.supportPskTypes = CollectionsKt.listOf(new String[]{"wpa2", "wpa3", "wpa", "psk", "sae"});
        this.REQUEST_CODE_SET_SETUP_WIFI = 1000;
        this.WIFI_AP_STATE_CHANGED_ACTION = "android.net.wifi.WIFI_AP_STATE_CHANGED";
        this.wifiManager$delegate = LazyKt.lazy(MultiWifiViewModel$wifiManager$2.INSTANCE);
        this.caeSmartNetworkManager$delegate = LazyKt.lazy(MultiWifiViewModel$caeSmartNetworkManager$2.INSTANCE);
        this.wifiPickerTrackerCallback = new MultiWifiViewModel$wifiPickerTrackerCallback$1(this);
        ?? r0 = new MultiWifiViewModel$receiver$1(this);
        this.receiver = r0;
        boolean r2 = true;
        this.isScanningLv = new MutableLiveData(true);
        if (getWifiManager().getStaConcurrencyForMultiInternetMode() != 2) goto L5;
        boolean r3 = true;
    L6:
        MutableLiveData<Boolean> r1 = new MutableLiveData(Boolean.valueOf(r3));
        this.multiWifiEnabledLv = r1;
        if (getWifiManager().getWifiState() == 3) goto L10;
        r2 = false;
    L10:
        this.wifiEnabledLv = new MutableLiveData(Boolean.valueOf(r2));
        this.accessPointInfoListLv = new MutableLiveData(CollectionsKt.emptyList());
        this.connectedAccessPointInfoLv = new MutableLiveData(null);
        this.wifiEntriesLv = new MutableLiveData(CollectionsKt.emptyList());
        this.connectedWifiEntryLv = new MutableLiveData(null);
        this.connectivityManager$delegate = LazyKt.lazy(MultiWifiViewModel$connectivityManager$2.INSTANCE);
        IntentFilter r4 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        r4.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        r4.addAction("android.net.wifi.SCAN_RESULTS");
        r4.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
        r4.addAction(AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION);
        r4.addAction("android.net.wifi.STATE_CHANGE");
        r4.addAction("android.net.wifi.RSSI_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(SettingsApplication.getContext(), (BroadcastReceiver) r0, r4, null, null);
        r1.observeForever(new MultiWifiViewModel$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(this)));
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final WifiManager getWifiManager() {
        return (WifiManager) this.wifiManager$delegate.getValue();
    }

    private final ICaeSmartNetworkManager getCaeSmartNetworkManager() {
        return (ICaeSmartNetworkManager) this.caeSmartNetworkManager$delegate.getValue();
    }

    public final MutableLiveData<Boolean> isScanningLv() {
        return this.isScanningLv;
    }

    public final MutableLiveData<Boolean> getMultiWifiEnabledLv() {
        return this.multiWifiEnabledLv;
    }

    public final MutableLiveData<Boolean> getWifiEnabledLv() {
        return this.wifiEnabledLv;
    }

    public final MutableLiveData<List<SubAccessPoint>> getAccessPointInfoListLv() {
        return this.accessPointInfoListLv;
    }

    public final MutableLiveData<SubAccessPoint> getConnectedAccessPointInfoLv() {
        return this.connectedAccessPointInfoLv;
    }

    public final MutableLiveData<List<WifiEntry>> getWifiEntriesLv() {
        return this.wifiEntriesLv;
    }

    public final MutableLiveData<WifiEntry> getConnectedWifiEntryLv() {
        return this.connectedWifiEntryLv;
    }

    public final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) this.connectivityManager$delegate.getValue();
    }

    public final SecondaryNetworkCallback getSecondaryNetworkCallback() {
        return this.secondaryNetworkCallback;
    }

    public final void setSecondaryNetworkCallback(SecondaryNetworkCallback r1) {
        this.secondaryNetworkCallback = r1;
    }

    public final void onViewCreate(Lifecycle r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        Intrinsics.checkNotNullParameter(r3, "context");
        setupWifiPickerTracker(r2, r3);
        r2.addObserver(new C01531(this));
    }

    public final void setMultiWifiEnabled(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Intrinsics.areEqual(this.multiWifiEnabledLv.getValue(), Boolean.valueOf(r3)) == false) goto L5;
        return;
    L5:
        WifiManager r4 = getWifiManager();
        if (r3 == false) goto L8;
        int r0 = 2;
    L9:
        r4.setStaConcurrencyForMultiInternetMode(r0);
        this.multiWifiEnabledLv.setValue(Boolean.valueOf(r3));
        return;
    L8:
        r0 = 0;
        goto L9
    }

    private final Pair<List<AccessPointInfo>, AccessPointInfo> constructAccessPoints(WifiManager r13, WifiInfo r14, NetworkInfo.DetailedState r15) {
        ArrayList r0 = new ArrayList();
        final LinkedHashMap r1 = new LinkedHashMap();
        LinkedHashSet r3 = new LinkedHashSet();
        AccessPointInfo r11 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L36
        List<ScanResult> r4 = r13.getScanResults();     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r4, "getScanResults(...)");     // Catch: Throwable -> L36
        Iterator<T> r5 = r4.iterator();     // Catch: Throwable -> L36
    L5:
        if (r5.hasNext() == false) goto L34;
        ScanResult r6 = (ScanResult) r5.next();     // Catch: Throwable -> L36
        String r7 = r6.SSID;     // Catch: Throwable -> L36
        if (r7 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == true) goto L5;
        String r9 = r6.capabilities;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r9, "capabilities");     // Catch: Throwable -> L36
        if (StringsKt.contains$default(r9, "[IBSS]", false, 2, null) == true) goto L5;
        List r10 = (List) r1.get(r6.SSID);     // Catch: Throwable -> L36
        if (r10 == null) goto L27;
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L36
    L21:
        if (r12.hasNext() == false) goto L25;
        Object r16 = r12.next();     // Catch: Throwable -> L36
        if (((AccessPointInfo) r16).update(r6, false) == false) goto L21;
    L26:
        AccessPointInfo r17 = (AccessPointInfo) r16;     // Catch: Throwable -> L36
    L28:
        if (r17 == null) goto L29;
        r17.bssid = r6.BSSID;     // Catch: Throwable -> L36
        setWifiEntryKey(r17);     // Catch: Throwable -> L36
        goto L5
    L29:
        AccessPointInfo r18 = new AccessPointInfo(r6);     // Catch: Throwable -> L36
        r0.add(r18);     // Catch: Throwable -> L36
        setWifiEntryKey(r18);     // Catch: Throwable -> L36
        ArrayList r19 = (List) r1.get(r18.ssid);     // Catch: Throwable -> L36
        if (r19 != null) goto L32;
        r19 = new ArrayList();     // Catch: Throwable -> L36
    L32:
        r19.add(r18);     // Catch: Throwable -> L36
        String r20 = r18.ssid;     // Catch: Throwable -> L36
        Intrinsics.checkNotNullExpressionValue(r20, "ssid");     // Catch: Throwable -> L36
        r1.put(r20, r19);     // Catch: Throwable -> L36
        goto L5
    L25:
        r16 = null;
        goto L26
    L27:
        r17 = null;
        goto L28
    L9:
        if (r7.length() == 0) goto L12;
        r8 = false;
        goto L13
    L34:
        Object r21 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r22 = Result.m1511exceptionOrNullimpl(r21);
        if (r22 == null) goto L41;
        OLog.e(this.TAG, "constructAccessPoints scanResults failed", r22);
    L41:
        mergeConfiguredNetworks(r0, r3, r14, r15, true, new AnonymousClass3(this, r1), "constructAccessPoints configuredNetworks failed");
        WifiPickerTracker r110 = this.wifiPickerTracker;
        if (r110 == null) goto L44;
        WifiEntry r111 = r110.getConnectedWifiEntry();
    L45:
        if (r111 == null) goto L56;
        String r112 = r111.getSsid();
        if (r112 == null) goto L56;
        if (r112.length() <= 0) goto L51;
        boolean r23 = true;
    L52:
        if (r23 == true) goto L55;
        r112 = null;
    L55:
        if (r112 == null) goto L56;
    L57:
        Intrinsics.checkNotNull(r112);
        if (r111 == null) goto L61;
        String r113 = r111.getBandString();
        if (r113 == null) goto L61;
    L62:
        String r24 = this.TAG;
        StringBuilder r25 = new StringBuilder("picker ");
        WifiPickerTracker r26 = this.wifiPickerTracker;
        if (r26 == null) goto L67;
        WifiEntry r27 = r26.getConnectedWifiEntry();
        if (r27 == null) goto L67;
        String r28 = r27.getSsid();
    L68:
        StringBuilder r29 = r25.append(r28).append(" active ");
        WifiPickerTracker r114 = this.wifiPickerTracker;
        if (r114 == null) goto L77;
        List<WifiEntry> r115 = r114.getActiveWifiEntries();
        if (r115 == null) goto L77;
        List<WifiEntry> r116 = r115;
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r117 = r116.iterator();
    L74:
        if (r117.hasNext() == false) goto L76;
        r30.add(((WifiEntry) r117.next()).getSsid());
        goto L74
    L76:
        ArrayList r31 = r30;
    L78:
        SLog.d(r24, r29.append(r31).append(" wifi:").append(r13.getConnectionInfo().getSSID()).toString());
        ArrayList r32 = r0;
        Iterator r118 = r32.iterator();
    L80:
        if (r118.hasNext() == false) goto L89;
        Object r119 = r118.next();
        AccessPointInfo r33 = (AccessPointInfo) r119;
        if (Intrinsics.areEqual(r33.ssid, r112) == true) goto L84;
    L86:
        boolean r34 = false;
    L87:
        if (r34 == false) goto L80;
    L90:
        AccessPointInfo r120 = (AccessPointInfo) r119;
        if (r120 == null) goto L93;
        r120.mState = NetworkInfo.DetailedState.CONNECTED;
        r11 = r120;
    L93:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r32.iterator();
    L95:
        if (r122.hasNext() == false) goto L103;
        Object r123 = r122.next();
        if (((AccessPointInfo) r123).getLevel() == (-1)) goto L99;
        boolean r124 = true;
    L100:
        if (r124 == false) goto L95;
        r121.add(r123);
        goto L95
    L99:
        r124 = false;
        goto L100
    L103:
        return TuplesKt.to(r121, r11);
    L84:
        if (Intrinsics.areEqual(Utils.frequencyToBandString(SettingsApplication.getContext(), r33.getFrequency()), r113) == false) goto L86;
        r34 = true;
        goto L87
    L89:
        r119 = null;
    L77:
        r31 = null;
    L67:
        r28 = null;
    L61:
        r113 = Utils.frequencyToBandString(SettingsApplication.getContext(), r13.getConnectionInfo().getFrequency());
        goto L62
    L51:
        r23 = false;
    L56:
        String r125 = r13.getConnectionInfo().getSSID();
        Intrinsics.checkNotNullExpressionValue(r125, "getSSID(...)");
        r112 = StringsKt.removeSuffix(StringsKt.removePrefix(r125, "\""), "\"");
        goto L57
    L44:
        r111 = null;
    L36:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r21 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L38
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void mergeConfiguredNetworks$default(MultiWifiViewModel r9, List r10, Set r11, WifiInfo r12, NetworkInfo.DetailedState r13, boolean r14, Function1 r15, String r16, int r17, Object r18) {
        if ((r17 & 2) == 0) goto L5;
        Set r3 = new LinkedHashSet();
    L7:
        if ((r17 & 4) == 0) goto L9;
        WifiInfo r4 = null;
    L11:
        if ((r17 & 8) == 0) goto L13;
        NetworkInfo.DetailedState r5 = null;
    L15:
        if ((r17 & 32) == 0) goto L17;
        Function1 r7 = null;
    L18:
        r9.mergeConfiguredNetworks(r10, r3, r4, r5, r14, r7, r16);
        return;
    L17:
        r7 = r15;
        goto L18
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    private final void mergeConfiguredNetworks(List<AccessPointInfo> r9, Set<Integer> r10, WifiInfo r11, NetworkInfo.DetailedState r12, boolean r13, Function1<? super AccessPointInfo, Unit> r14, String r15) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L61
        List<WifiConfiguration> r1 = getWifiManager().getConfiguredNetworks();     // Catch: Throwable -> L61
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L61
    L5:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L61
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L61
    L7:
        if (r3.hasNext() == false) goto L19;
        Object r4 = r3.next();     // Catch: Throwable -> L61
        WifiConfiguration r5 = (WifiConfiguration) r4;     // Catch: Throwable -> L61
        boolean r6 = false;
        if (r10.contains(Integer.valueOf(r5.networkId)) == false) goto L12;
    L17:
        if (r6 == false) goto L7;
        r2.add(r4);     // Catch: Throwable -> L61
        goto L7
    L12:
        if (new AdaptWifiConfig(r5).getSelfAdded() == true) goto L14;
    L16:
        r6 = true;
        goto L17
    L14:
        if (r5.numAssociation != 0) goto L16;
    L19:
        ArrayList r7 = r2;     // Catch: Throwable -> L61
        Iterator<T> r8 = r9.iterator();     // Catch: Throwable -> L61
    L21:
        if (r8.hasNext() == false) goto L44;
        AccessPointInfo r16 = (AccessPointInfo) r8.next();     // Catch: Throwable -> L61
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L61
        Iterator r18 = r7.iterator();     // Catch: Throwable -> L61
    L24:
        if (r18.hasNext() == false) goto L28;
        Object r19 = r18.next();     // Catch: Throwable -> L61
        WifiConfiguration r20 = (WifiConfiguration) r19;     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L61
        if (isSameAccessPointConfig(r16, r20) == false) goto L24;
        r17.add(r19);     // Catch: Throwable -> L61
        goto L24
    L28:
        Iterator r21 = r17.iterator();     // Catch: Throwable -> L61
        if (r21.hasNext() == true) goto L31;
        Object r22 = null;
    L41:
        WifiConfiguration r23 = (WifiConfiguration) r22;     // Catch: Throwable -> L61
        if (r23 == null) goto L21;
        r16.loadConfig(r23);     // Catch: Throwable -> L61
        r10.add(Integer.valueOf(r23.networkId));     // Catch: Throwable -> L61
        goto L21
    L31:
        Object r24 = r21.next();     // Catch: Throwable -> L61
        if (r21.hasNext() == true) goto L34;
    L33:
        r22 = r24;
        goto L41
    L34:
        WifiConfiguration r25 = (WifiConfiguration) r24;     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L61
        int r26 = configMatchScore(r16, r25);     // Catch: Throwable -> L61
    L35:
        Object r27 = r21.next();     // Catch: Throwable -> L61
        WifiConfiguration r28 = (WifiConfiguration) r27;     // Catch: Throwable -> L61
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L61
        int r29 = configMatchScore(r16, r28);     // Catch: Throwable -> L61
        if (r26 >= r29) goto L39;
        r24 = r27;
        r26 = r29;
    L39:
        if (r21.hasNext() == true) goto L35;
    L44:
        if (r13 == false) goto L59;
        Iterator r110 = r7.iterator();     // Catch: Throwable -> L61
    L47:
        if (r110.hasNext() == false) goto L59;
        WifiConfiguration r30 = (WifiConfiguration) r110.next();     // Catch: Throwable -> L61
        if (r10.contains(Integer.valueOf(r30.networkId)) == true) goto L47;
        AccessPointInfo r31 = new AccessPointInfo(r30);     // Catch: Throwable -> L61
        if (r12 == null) goto L55;
        if (r11 == null) goto L55;
        r31.update(r11, r12);     // Catch: Throwable -> L61
    L55:
        r9.add(r31);     // Catch: Throwable -> L61
        if (r14 == null) goto L58;
        r14.invoke(r31);     // Catch: Throwable -> L61
    L58:
        r10.add(Integer.valueOf(r30.networkId));     // Catch: Throwable -> L61
    L59:
        Object r32 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L61
    L63:
        Throwable r33 = Result.m1511exceptionOrNullimpl(r32);
        if (r33 == null) goto L92;
        OLog.e(this.TAG, r15, r33);
        return;
    L92:
        return;
    L61:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r32 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L63
    }

    private final boolean isSameAccessPointConfig(AccessPointInfo r3, WifiConfiguration r4) {
        if (Intrinsics.areEqual(AccessPoint.removeDoubleQuotes(r4.SSID), AccessPoint.removeDoubleQuotes(r3.ssid)) == true) goto L6;
        return false;
    L6:
        if (getSecurityFromConfig(r4) == r3.security) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r4.BSSID) == true) goto L13;
        if (StringsKt.equals(r4.BSSID, r3.bssid, true) == true) goto L13;
        return false;
    L13:
        return true;
    }

    private final int configMatchScore(AccessPointInfo r2, WifiConfiguration r3) {
        int r1 = r3.numAssociation;
        if (TextUtils.isEmpty(r3.BSSID) == false) goto L5;
        return r1;
    L5:
        if (StringsKt.equals(r3.BSSID, r2.bssid, true) == true) goto L7;
        return r1;
    L7:
        return r1 + 1000;
    }

    private final int getSecurityFromConfig(WifiConfiguration r6) {
        int r1 = 2;
        if (r6.allowedKeyManagement.get(1) == false) goto L5;
    L29:
        return r1;
    L5:
        if (r6.allowedKeyManagement.get(4) == true) goto L29;
        r1 = 3;
        if (r6.allowedKeyManagement.get(2) == true) goto L29;
        if (r6.allowedKeyManagement.get(3) == true) goto L29;
        int r5 = r6.wepKeys.length;
        r1 = 0;
        int r3 = 0;
    L13:
        if (r3 >= r5) goto L19;
        if (r6.wepKeys[r3] != null) goto L16;
        r3 = r3 + 1;
        goto L13
    L16:
        return 1;
    L19:
        if (r6.allowedKeyManagement.get(MultiSDKAdapterNew.getWapiPskValue()) == false) goto L22;
        return 4;
    L22:
        if (r6.allowedKeyManagement.get(MultiSDKAdapterNew.getWapiCertValue()) == false) goto L26;
        return 5;
    L26:
        if (r6.allowedKeyManagement.get(8) == false) goto L29;
        return 6;
    }

    private final Pair<List<WifiEntry>, WifiEntry> getAvailableWifiEntries() {
        WifiPickerTracker r0 = this.wifiPickerTracker;
        if (r0 == null) goto L5;
        WifiEntry r1 = r0.getConnectedWifiEntry();
    L6:
        WifiPickerTracker r6 = this.wifiPickerTracker;
        if (r6 == null) goto L19;
        List<WifiEntry> r2 = r6.getWifiEntries();
        Intrinsics.checkNotNullExpressionValue(r2, "getWifiEntries(...)");
        List r3 = CollectionsKt.toMutableList(r2);
        List<WifiEntry> r4 = r6.getActiveWifiEntries();
        Intrinsics.checkNotNullExpressionValue(r4, "getActiveWifiEntries(...)");
        r3.addAll(0, r4);
        r3.remove(r6.getConnectedWifiEntry());
        ArrayList r7 = new ArrayList();
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L18;
        Object r8 = r5.next();
        String r9 = ((WifiEntry) r8).getBandString();
        if (r1 == null) goto L14;
        String r10 = r1.getBandString();
    L16:
        if ((!Intrinsics.areEqual(r9, r10)) == false) goto L10;
        r7.add(r8);
        goto L10
    L14:
        r10 = null;
        goto L16
    L18:
        ArrayList r11 = r7;
    L20:
        if (r1 != null) goto L24;
        return TuplesKt.to(CollectionsKt.emptyList(), null);
    L24:
        return TuplesKt.to(r11, r1);
    L19:
        r11 = CollectionsKt.emptyList();
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    private final void setWifiEntryKey(AccessPointInfo r5) {
        WifiPickerTracker r4 = this.wifiPickerTracker;
        if (r4 != null) goto L5;
        return;
    L5:
        List<WifiEntry> r0 = r4.getWifiEntries();
        Intrinsics.checkNotNullExpressionValue(r0, "getWifiEntries(...)");
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(r5.ssid, AccessPointInfo.removeDoubleQuotes(((WifiEntry) r2).getSsid())) == false) goto L7;
    L12:
        WifiEntry r3 = (WifiEntry) r2;
        if (r3 == null) goto L15;
        r5.key = r3.getKey();
    L15:
        WifiEntry r6 = r4.getConnectedWifiEntry();
        if (r6 != null) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(r5.ssid, AccessPointInfo.removeDoubleQuotes(r6.getSsid())) == false) goto L25;
        r5.key = r6.getKey();
        r5.wifiEntry = r6;
        return;
    L25:
        return;
    L11:
        r2 = null;
        goto L12
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        SettingsApplication.getContext().unregisterReceiver(this.receiver);
    }

    private final void setupWifiPickerTracker(Lifecycle r16, Context r17) {
        HandlerThread r1 = new HandlerThread(this.TAG + '{' + Integer.toHexString(System.identityHashCode(this)) + '}', 10);
        r1.start();
        final ZoneOffset r2 = ZoneOffset.UTC;
        this.wifiPickerTracker = FeatureFactory.getFactory(r17).getWifiTrackerLibProvider().createWifiPickerTracker(r16, r17, new Handler(Looper.getMainLooper()), r1.getThreadHandler(), new MultiWifiViewModel$setupWifiPickerTracker$clock$1(r2), 15000, 10000, this.wifiPickerTrackerCallback);
    }

    public final void refreshWifiList(String r7) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        if (this.isRefreshing == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.multiWifiEnabledLv.getValue(), true) == false) goto L10;
        this.isRefreshing = true;
        OLog.i(this.TAG, "refreshWifiList: start " + r7);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01541(this, null), 2, null);
        return;
    }

    public final void onItemClick(Context r13, SubAccessPoint r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "point");
        AccessPointInfo r0 = r14.getInfo();
        OLog.i("MultiWifiViewModel_click", "onItemClick: " + r0.bssid + TokenParser.SP + r0.ssid + TokenParser.SP + r0.pskType.name() + TokenParser.SP + r0.security);
        String r1 = getCaeSmartNetworkManager().getCurrentSecondarySsid();
        if (Intrinsics.areEqual(r14.getInfo().ssid, AccessPoint.removeDoubleQuotes(r1)) == false) goto L6;
        WifiUtils.INSTANCE.openAccessPointDetailPage(r13, r0, true);
        return;
    L6:
        String r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        getCaeSmartNetworkManager().releaseAll();
    L15:
        resetSummary();
        r14.updateState(SubAccessPoint.State.Connecting.INSTANCE);
        SubAccessPoint r4 = this.connectedAccessPointInfoLv.getValue();
        if (r4 != null) goto L19;
        return;
    L19:
        if (r0.security != 0) goto L24;
        if (r0.networkId != (-1)) goto L24;
        r0.generateOpenNetworkConfig();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C01521(r0, r14, r13, null), 2, null);
        return;
    L24:
        if (r0.networkId == (-1)) goto L26;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass2(r0, r14, r13, null), 2, null);
        return;
    L26:
        Bundle r5 = new Bundle();
        r5.putBoolean("edit", false);
        r5.putBoolean("text_is_selectable", true);
        Bundle r6 = new Bundle();
        r0.saveWifiState(r6);
        Unit r7 = Unit.INSTANCE;
        r5.putBundle("access_point", r6);
        Intent r8 = new Intent(r13, WifiSetupActivity.class);
        r8.putExtras(r5);
        r8.putExtra("multi_wifi", true);
        ((Activity) r13).startActivityForResult(r8, this.REQUEST_CODE_SET_SETUP_WIFI);
        this.pendingConnect = true;
        this.lastConnectConfiguration = r4.getInfo().getConfig();
        this.pendingAccessPointInfo = r14;
        return;
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    }

    private final void endRefresh() {
        OLog.i(this.TAG, "endRefresh: ");
        this.isRefreshing = false;
        this.isScanningLv.setValue(false);
    }

    public final void startScan() {
        this.isScanningLv.setValue(true);
        getWifiManager().startScan();
    }

    public final void onActivityResult(Activity r8, int r9, int r10, Intent r11) {
        if (r9 == this.REQUEST_CODE_SET_SETUP_WIFI) goto L5;
        return;
    L5:
        if (this.pendingConnect == false) goto L15;
        this.pendingConnect = false;
        if (r10 != (-1)) goto L9;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01511(r11, this, r8, null), 3, null);
        return;
    L9:
        SubAccessPoint r12 = this.pendingAccessPointInfo;
        if (r12 == null) goto L12;
        r12.updateState(SubAccessPoint.State.Default.INSTANCE);
    L12:
        this.lastConnectConfiguration = null;
        this.pendingAccessPointInfo = null;
        return;
    }

    private final void tryUpdateConnectSubAccessPoint() {
        String r0 = AccessPoint.removeDoubleQuotes(getCaeSmartNetworkManager().getCurrentSecondarySsid());
        OLog.i(this.TAG, "tryUpdateConnectSubAccessPoint: currentSecondarySsid " + r0);
        List<SubAccessPoint> r4 = this.accessPointInfoListLv.getValue();
        if (r4 == null) goto L18;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r1 = r5.next();
        if (Intrinsics.areEqual(AccessPoint.removeDoubleQuotes(((SubAccessPoint) r1).getInfo().ssid), r0) == false) goto L6;
    L11:
        SubAccessPoint r2 = (SubAccessPoint) r1;
        if (r2 == null) goto L19;
        r2.updateState(SubAccessPoint.State.Success.INSTANCE);
        return;
    L19:
        return;
    L10:
        r1 = null;
        goto L11
    }

    private final void tryResetConnectSubAccessPoint() {
        String r0 = AccessPoint.removeDoubleQuotes(getCaeSmartNetworkManager().getCurrentSecondarySsid());
        OLog.i(this.TAG, "tryResetConnectSubAccessPoint: currentSecondarySsid " + r0);
        List<SubAccessPoint> r4 = this.accessPointInfoListLv.getValue();
        if (r4 == null) goto L14;
        ArrayList r1 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r2 = r5.next();
        if ((!Intrinsics.areEqual(AccessPoint.removeDoubleQuotes(((SubAccessPoint) r2).getInfo().ssid), r0)) == false) goto L6;
        r1.add(r2);
        goto L6
    L10:
        Iterator r6 = r1.iterator();
    L12:
        if (r6.hasNext() == false) goto L21;
        ((SubAccessPoint) r6.next()).updateState(SubAccessPoint.State.Default.INSTANCE);
        goto L12
    L21:
        return;
    }

    private final void resetSummary() {
        List<SubAccessPoint> r2 = this.accessPointInfoListLv.getValue();
        if (r2 == null) goto L8;
        Iterator<T> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((SubAccessPoint) r3.next()).updateState(SubAccessPoint.State.Default.INSTANCE);
        goto L6
    L10:
        return;
    }

    public final boolean is24GHzAP(WifiInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r1 = r2.getFrequency();
        if (2400 <= r1) goto L5;
        return false;
    L5:
        if (r1 >= 2500) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean is5GHzAP(WifiInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r1 = r2.getFrequency();
        if (4900 <= r1) goto L5;
        return false;
    L5:
        if (r1 >= 5900) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean is24GHzAP(ScanResult r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r1 = r2.frequency;
        if (2400 <= r1) goto L5;
        return false;
    L5:
        if (r1 >= 2500) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean is5GHzAP(ScanResult r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r1 = r2.frequency;
        if (4900 <= r1) goto L5;
        return false;
    L5:
        if (r1 >= 5900) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX INFO: renamed from: mainAccessPoint-d1pmJ48, reason: not valid java name */
    public final Object m718mainAccessPointd1pmJ48() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L29
        MultiWifiViewModel r2 = this;     // Catch: Throwable -> L29
        List<ScanResult> r3 = getWifiManager().getScanResults();     // Catch: Throwable -> L29
        WifiInfo r4 = getWifiManager().getConnectionInfo();     // Catch: Throwable -> L29
        if (r4 == null) goto L28;
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L29
        if (r3 == null) goto L22;
        Iterator<T> r5 = r3.iterator();     // Catch: Throwable -> L29
    L9:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();     // Catch: Throwable -> L29
        ScanResult r7 = (ScanResult) r6;     // Catch: Throwable -> L29
        if (r7.frequency != r4.getFrequency()) goto L15;
        String r8 = r7.SSID;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r8, "SSID");     // Catch: Throwable -> L29
        String r9 = StringsKt.removeSuffix(StringsKt.removePrefix(r8, "\""), "\"");     // Catch: Throwable -> L29
        String r10 = r4.getSSID();     // Catch: Throwable -> L29
        Intrinsics.checkNotNullExpressionValue(r10, "getSSID(...)");     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r9, StringsKt.removeSuffix(StringsKt.removePrefix(r10, "\""), "\"")) == false) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == false) goto L9;
    L19:
        ScanResult r12 = (ScanResult) r6;     // Catch: Throwable -> L29
        if (r12 == null) goto L22;
        AccessPointInfo r0 = new AccessPointInfo(r12);     // Catch: Throwable -> L29
        setWifiEntryKey(r0);     // Catch: Throwable -> L29
    L23:
        if (r0 == null) goto L26;
        return Result.m1508constructorimpl(new SubAccessPoint(r0, null, 2, null));
    L26:
        throw new RuntimeException("mainAp==null");     // Catch: Throwable -> L29
    L15:
        r11 = false;
        goto L16
    L18:
        r6 = null;
    L22:
        r0 = null;
        goto L23
    L28:
        throw new RuntimeException("wifiInfo==null");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        return Result.m1508constructorimpl(ResultKt.createFailure(th));
    }
}
