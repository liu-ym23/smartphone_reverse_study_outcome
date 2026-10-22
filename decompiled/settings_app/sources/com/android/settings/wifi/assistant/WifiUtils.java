package com.android.settings.wifi.assistant;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import com.android.settings.Settings;
import com.android.settings.SettingsApplication;
import com.android.settings.wifi.AccessPointDetailFragment;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.WlanRiskInfo;
import com.obric.cae.libs.wifi.ICaeSmartNetworkManager;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: WifiUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\rJ0\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010#J\n\u0010$\u001a\u00020\u0016*\u00020\u0016J\n\u0010%\u001a\u00020\u0016*\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006&"}, d2 = {"Lcom/android/settings/wifi/assistant/WifiUtils;", "", "()V", "TAG", "", "caeSmartNetworkManager", "Lcom/obric/cae/libs/wifi/ICaeSmartNetworkManager;", "kotlin.jvm.PlatformType", "getCaeSmartNetworkManager", "()Lcom/obric/cae/libs/wifi/ICaeSmartNetworkManager;", "caeSmartNetworkManager$delegate", "Lkotlin/Lazy;", "connect", "", "wifiManager", "Landroid/net/wifi/WifiManager;", "config", "Landroid/net/wifi/WifiConfiguration;", "(Landroid/net/wifi/WifiManager;Landroid/net/wifi/WifiConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectSubWifi", "ssid", "band", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openAccessPointDetailPage", "", "context", "Landroid/content/Context;", "info", "Lcom/android/settings/wifi/AccessPointInfo;", "secondary", "requestSecondaryWifi", WlanRiskInfo.EXTRA_BSSID, "securityType", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bandRevers", "frequencyToBand", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WifiUtils {
    public static final WifiUtils INSTANCE = null;
    private static final String TAG = "WifiUtils";
    private static final Lazy caeSmartNetworkManager$delegate = null;

    /* JADX INFO: renamed from: com.android.settings.wifi.assistant.WifiUtils$connect$2, reason: invalid class name */
    /* JADX INFO: compiled from: WifiUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.assistant.WifiUtils$connect$2", f = "WifiUtils.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ WifiConfiguration $config;
        final /* synthetic */ WifiManager $wifiManager;
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(WifiManager r1, WifiConfiguration r2, Continuation<? super AnonymousClass2> r3) {
            this.$wifiManager = r1;
            this.$config = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$wifiManager, this.$config, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            WifiConfiguration r2 = (WifiConfiguration) this.L$1;
            WifiManager r5 = (WifiManager) this.L$0;
            ResultKt.throwOnFailure(r6);
        L13:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            WifiManager r7 = this.$wifiManager;
            WifiConfiguration r3 = this.$config;
            this.L$0 = r7;
            this.L$1 = r3;
            this.label = 1;
            AnonymousClass2 r8 = this;
            SafeContinuation r4 = new SafeContinuation(IntrinsicsKt.intercepted(r8));
            final SafeContinuation r9 = r4;
            r7.connect(r3, new WifiUtils$connect$2$1$1(r9));
            r6 = r4.getOrThrow();
            if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(r8);
        L11:
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.assistant.WifiUtils$connectSubWifi$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WifiUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.assistant.WifiUtils$connectSubWifi$2", f = "WifiUtils.kt", i = {0}, l = {57}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    static final class C01552 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ int $band;
        final /* synthetic */ String $ssid;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C01552(String r1, int r2, Continuation<? super C01552> r3) {
            this.$ssid = r1;
            this.$band = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01552 r0 = new C01552(this.$ssid, this.$band, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super String> r2) {
            return ((C01552) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r2 = (String) this.L$1;
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L16:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            final String r14 = this.$ssid;
            int r4 = this.$band;
            this.L$0 = r3;
            this.L$1 = r14;
            this.I$0 = r4;
            this.label = 1;
            C01552 r15 = this;
            SafeContinuation r9 = new SafeContinuation(IntrinsicsKt.intercepted(r15));
            final SafeContinuation r10 = r9;
            final Ref.BooleanRef r11 = new Ref.BooleanRef();
            BuildersKt.launch$default(r3, Dispatchers.getIO(), null, new WifiUtils$connectSubWifi$2$1$1(r11, r10, null), 2, null);
            OLog.d(WifiUtils.TAG, "requestNetwork " + r14 + TokenParser.SP + r4);
            WifiNetworkSpecifier.Builder r5 = new WifiNetworkSpecifier.Builder();
            if (r14 == null) goto L11;
            r5.setSsid(r14);
        L11:
            r5.setBand(r4);
            WifiNetworkSpecifier r6 = r5.build();
            Intrinsics.checkNotNullExpressionValue(r6, "build(...)");
            NetworkRequest r7 = new NetworkRequest.Builder().addTransportType(1).addCapability(12).setNetworkSpecifier(r6).build();
            Object r8 = SettingsApplication.getContext().getSystemService("connectivity");
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.net.ConnectivityManager");
            final ConnectivityManager r16 = (ConnectivityManager) r8;
            r16.requestNetwork(r7, new WifiUtils$connectSubWifi$2$1$callback$1(r14, r16, r11, r10));
            r13 = r9.getOrThrow();
            if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
            DebugProbesKt.probeCoroutineSuspended(r15);
        L14:
            if (r13 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.assistant.WifiUtils$requestSecondaryWifi$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WifiUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.wifi.assistant.WifiUtils$requestSecondaryWifi$2", f = "WifiUtils.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
    static final class C01562 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $bssid;
        final /* synthetic */ String $password;
        final /* synthetic */ String $securityType;
        final /* synthetic */ String $ssid;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C01562(String r1, String r2, String r3, String r4, Continuation<? super C01562> r5) {
            this.$bssid = r1;
            this.$ssid = r2;
            this.$securityType = r3;
            this.$password = r4;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01562(this.$bssid, this.$ssid, this.$securityType, this.$password, r8);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super String> r2) {
            return ((C01562) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r2 = (String) this.L$3;
            String r3 = (String) this.L$2;
            String r4 = (String) this.L$1;
            String r9 = (String) this.L$0;
            ResultKt.throwOnFailure(r10);
        L18:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            OLog.i(WifiUtils.TAG, "requestSecondaryWifi " + this.$bssid + TokenParser.SP + this.$ssid + TokenParser.SP + this.$securityType + TokenParser.SP + this.$password);
            String r5 = this.$bssid;
            String r6 = this.$ssid;
            String r7 = this.$securityType;
            String r8 = this.$password;
            this.L$0 = r5;
            this.L$1 = r6;
            this.L$2 = r7;
            this.L$3 = r8;
            this.label = 1;
            C01562 r11 = this;
            SafeContinuation r12 = new SafeContinuation(IntrinsicsKt.intercepted(r11));
            final SafeContinuation r13 = r12;
            WifiUtils.access$getCaeSmartNetworkManager(WifiUtils.INSTANCE).requestSecondaryWifi(r5, r6, r7, r8, new WifiUtils$requestSecondaryWifi$2$1$1(r13));     // Catch: Exception -> L11
        L13:
            r10 = r12.getOrThrow();
            if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
            DebugProbesKt.probeCoroutineSuspended(r11);
        L16:
            if (r10 != r0) goto L18;
            return r0;
        L11:
            e = move-exception;
            OLog.e(WifiUtils.TAG, "requestSecondaryWifi failed, e: " + e);
            Result.Companion r14 = Result.Companion;
            r13.resumeWith(Result.m1508constructorimpl(null));
            goto L13
        }
    }

    public final int bandRevers(int r1) {
        if (1 != r1) goto L6;
        return 2;
    L6:
        return 1;
    }

    public final int frequencyToBand(int r1) {
        if (r1 >= 2500) goto L5;
        return 1;
    L5:
        return 2;
    }

    private WifiUtils() {
    }

    public static final /* synthetic */ ICaeSmartNetworkManager access$getCaeSmartNetworkManager(WifiUtils r0) {
        return r0.getCaeSmartNetworkManager();
    }

    static {
        INSTANCE = new WifiUtils();
        caeSmartNetworkManager$delegate = LazyKt.lazy(WifiUtils$caeSmartNetworkManager$2.INSTANCE);
    }

    private final ICaeSmartNetworkManager getCaeSmartNetworkManager() {
        return (ICaeSmartNetworkManager) caeSmartNetworkManager$delegate.getValue();
    }

    public final Object connect(WifiManager r3, WifiConfiguration r4, Continuation<? super Boolean> r5) {
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(r3, r4, null), r5);
    }

    public final Object connectSubWifi(String r3, int r4, Continuation<? super String> r5) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C01552(r3, r4, null), r5);
    }

    public static /* synthetic */ void openAccessPointDetailPage$default(WifiUtils r0, Context r1, AccessPointInfo r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.openAccessPointDetailPage(r1, r2, r3);
    }

    public final void openAccessPointDetailPage(Context r3, AccessPointInfo r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "info");
        Intent r2 = new Intent(r3, Settings.AccessPointDetailActivity.class);
        r2.putExtra(AccessPointInfo.EXTRA_WIFI_CONFIGURATION, r4.getConfig());
        r2.putExtra(AccessPointInfo.EXTRA_PSK_TYPE, r4.pskType);
        if (r5 == false) goto L5;
        WifiInfo r0 = SecondaryNetworkCallback.Companion.getWifiInfo();
    L6:
        r2.putExtra(AccessPointInfo.EXTRA_WIFI_INFO, r0);
        if (r5 == false) goto L9;
        NetworkInfo.DetailedState r1 = NetworkInfo.DetailedState.CONNECTED;
    L10:
        r2.putExtra(AccessPointInfo.EXTRA_DETAILED_STATE, r1);
        if (r5 == true) goto L13;
        r2.putExtra("key_chosen_wifientry_key", r4.key);
    L13:
        r2.putExtra(AccessPointDetailFragment.KEY_IS_SECONDARY_WLAN, r5);
        r3.startActivity(r2);
        return;
    L9:
        r1 = r4.getState();
        goto L10
    L5:
        r0 = r4.getInfo();
        goto L6
    }

    public final Object requestSecondaryWifi(String r8, String r9, String r10, String r11, Continuation<? super String> r12) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C01562(r8, r9, r10, r11, null), r12);
    }
}
