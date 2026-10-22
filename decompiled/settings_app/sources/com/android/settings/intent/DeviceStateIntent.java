package com.android.settings.intent;

import android.app.usage.StorageStatsManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.GlobalProxyLancet;
import com.android.settings.AdaptUtils;
import com.android.settings.MultiSimAdapter;
import com.android.settings.PageConstants;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.Utils;
import com.android.settings.about.DeviceUtils;
import com.android.settings.applications.PreferredSettingsUtils;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemDeviceStateIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 a2\u00020\u0001:\u0001aB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\b\u0010'\u001a\u00020\u0012H\u0002J$\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u0002002\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u00103\u001a\u0002002\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\tH\u0002J\u0010\u00106\u001a\u0002002\u0006\u00105\u001a\u00020\tH\u0002J\u0010\u00107\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u00108\u001a\u0002092\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u0002002\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0014J\u0012\u0010<\u001a\u0002002\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010A\u001a\u000200H\u0002J\b\u0010B\u001a\u000200H\u0002J\u0012\u0010C\u001a\u00020\u000f2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0018\u0010F\u001a\u00020G2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010H\u001a\u000200H\u0002J\u0010\u0010I\u001a\u0002002\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010J\u001a\u000200H\u0002J\u001a\u0010K\u001a\u00020\u000f2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010L\u001a\u00020\u000fH\u0002J\u0010\u0010M\u001a\u00020G2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010N\u001a\u00020G2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010O\u001a\u00020G2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010P\u001a\u00020G2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\u000fH\u0002J\u0012\u0010R\u001a\u0002002\b\u0010S\u001a\u0004\u0018\u000100H\u0002J\f\u0010T\u001a\u00020G*\u00020\tH\u0002J\u000e\u0010U\u001a\u00020G*\u0004\u0018\u00010VH\u0002JF\u0010W\u001a\u00020\u0004*\u00020\u00122\u0006\u0010H\u001a\u0002002\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00120Y2\u001c\u0010Z\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\\\u0012\u0006\u0012\u0004\u0018\u00010]0[H\u0082@¢\u0006\u0002\u0010^J\u001e\u0010_\u001a\u00020\u0004*\u00020\u00122\u0006\u0010H\u001a\u0002002\b\u0010`\u001a\u0004\u0018\u00010]H\u0002¨\u0006b"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntent;", "Lcom/obric/capabilitykit/common/intent/BaseSystemDeviceStateIntent;", "()V", "addBondedConnectedBluetoothDevices", "", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "devices", "", "Landroid/bluetooth/BluetoothDevice;", "awaitProfileConnectedDevices", "", "context", "Landroid/content/Context;", "profile", "", "(Landroid/content/Context;Landroid/bluetooth/BluetoothAdapter;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildBatteryState", "Lorg/json/JSONObject;", "buildBluetoothState", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildDeviceState", "buildDisplayState", "buildHotspotState", "buildModeState", "buildNetworkState", "buildSoundState", "buildWifiState", "closeProfileProxySafely", "proxy", "Landroid/bluetooth/BluetoothProfile;", "defaultBatteryState", "defaultBluetoothState", "defaultDeviceState", "defaultDisplayState", "defaultHotspotState", "defaultModeState", "defaultNetworkState", "defaultSoundState", "defaultWifiState", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", "params", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/Empty;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBatteryCapacity", "", "getBatteryHealth", "getBatteryLevel", "getBatteryRemainingTime", "getBluetoothBatteryLevel", "device", "getBluetoothDeviceType", "getBrightnessPercent", "getConnectedBluetoothDevices", "Lorg/json/JSONArray;", "(Landroid/content/Context;Landroid/bluetooth/BluetoothAdapter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceStatesJson", "getHotspotName", "wifiManager", "Landroid/net/wifi/WifiManager;", "getPrimaryStorageFreeBytes", "", "getRam", "getResolution", "getRingerMode", "audioManager", "Landroid/media/AudioManager;", "getSecureBoolean", "", "key", "getStorageAvailable", "getStorageTotal", "getVolumePercent", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "isAutoBrightness", "isBatteryCharging", "isPowerSaveMode", "isVibrationEnabled", "ringerMode", "normalizeSsid", "ssid", "isAclConnected", "isConnected", "Landroid/net/wifi/WifiInfo;", "putCategory", "defaultValue", "Lkotlin/Function0;", "valueBuilder", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putSafe", "value", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntent extends BaseSystemDeviceStateIntent {
    private static final int[] BLUETOOTH_PROFILES = null;
    private static final long BLUETOOTH_PROFILE_WAIT_MS = 500;
    public static final Companion Companion = null;
    private static final int DEFAULT_INT = -1;
    private static final String FIND_MY_PHONE_SWITCH = "obric_find_device_switch";
    private static final String NIGHT_DISPLAY_ACTIVATED = "night_display_activated";
    private static final String NO_DISTURB_ON = "NoDisturbOn";
    private static final String TAG = "DeviceStateIntent";

    /* JADX INFO: compiled from: DeviceStateIntent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntent$Companion;", "", "()V", "BLUETOOTH_PROFILES", "", "BLUETOOTH_PROFILE_WAIT_MS", "", "DEFAULT_INT", "", "FIND_MY_PHONE_SWITCH", "", "NIGHT_DISPLAY_ACTIVATED", "NO_DISTURB_ON", "TAG", "getDeviceStatesJsonForDebug", "context", "Landroid/content/Context;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String getDeviceStatesJsonForDebug(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (DeviceStateIntentDebug.isDebugInvocationSupported(Build.IS_DEBUGGABLE, SystemProperties.getInt("ro.debuggable", 0)) == true) goto L7;
            return DeviceStateIntentDebug.getUnsupportedDebugResult();
        L7:
            return (String) BuildersKt.runBlocking$default(null, new DeviceStateIntent$Companion$getDeviceStatesJsonForDebug$1(r3, null), 1, null);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$awaitProfileConnectedDevices$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeviceStateIntent.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent", f = "DeviceStateIntent.kt", i = {0}, l = {141}, m = "awaitProfileConnectedDevices", n = {"profile"}, s = {"I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DeviceStateIntent this$0;

        AnonymousClass1(DeviceStateIntent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return DeviceStateIntent.access$awaitProfileConnectedDevices(this.this$0, null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$buildBluetoothState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeviceStateIntent.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent", f = "DeviceStateIntent.kt", i = {0}, l = {107}, m = "buildBluetoothState", n = {"result"}, s = {"L$0"})
    static final class C01461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DeviceStateIntent this$0;

        C01461(DeviceStateIntent r1, Continuation<? super C01461> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DeviceStateIntent.access$buildBluetoothState(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$doAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeviceStateIntent.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent", f = "DeviceStateIntent.kt", i = {}, l = {71}, m = "doAction", n = {}, s = {})
    static final class C01471 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DeviceStateIntent this$0;

        C01471(DeviceStateIntent r1, Continuation<? super C01471> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doAction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getConnectedBluetoothDevices$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeviceStateIntent.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent", f = "DeviceStateIntent.kt", i = {0, 0}, l = {117}, m = "getConnectedBluetoothDevices", n = {"this", "adapter"}, s = {"L$0", "L$1"})
    static final class C01481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DeviceStateIntent this$0;

        C01481(DeviceStateIntent r1, Continuation<? super C01481> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DeviceStateIntent.access$getConnectedBluetoothDevices(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2, reason: invalid class name */
    /* JADX INFO: compiled from: DeviceStateIntent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2", f = "DeviceStateIntent.kt", i = {0, 1, 2, 3, 4, 5, 6, 7, 8}, l = {84, 85, 86, 87, 88, 89, 90, 91, 92}, m = "invokeSuspend", n = {"root", "root", "root", "root", "root", "root", "root", "root", "root"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Context $context;
        Object L$0;
        int label;
        final /* synthetic */ DeviceStateIntent this$0;

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass1(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultBluetoothState", "defaultBluetoothState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultBluetoothState((DeviceStateIntent) this.receiver);
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$10, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$10", f = "DeviceStateIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass10 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            AnonymousClass10(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass10> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new AnonymousClass10(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((AnonymousClass10) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return DeviceStateIntent.access$buildModeState(this.this$0, this.$context);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$11, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass11 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass11(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultDisplayState", "defaultDisplayState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultDisplayState((DeviceStateIntent) this.receiver);
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$12, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$12", f = "DeviceStateIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass12 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            AnonymousClass12(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass12> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new AnonymousClass12(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((AnonymousClass12) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return DeviceStateIntent.access$buildDisplayState(this.this$0, this.$context);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$13, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass13 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass13(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultBatteryState", "defaultBatteryState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultBatteryState((DeviceStateIntent) this.receiver);
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$14, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$14", f = "DeviceStateIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass14 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            AnonymousClass14(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass14> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new AnonymousClass14(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((AnonymousClass14) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return DeviceStateIntent.access$buildBatteryState(this.this$0, this.$context);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$15, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass15 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass15(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultSoundState", "defaultSoundState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultSoundState((DeviceStateIntent) this.receiver);
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$16, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$16", f = "DeviceStateIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass16 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            AnonymousClass16(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass16> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new AnonymousClass16(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((AnonymousClass16) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return DeviceStateIntent.access$buildSoundState(this.this$0, this.$context);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$17, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass17 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass17(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultDeviceState", "defaultDeviceState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultDeviceState((DeviceStateIntent) this.receiver);
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$18, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$18", f = "DeviceStateIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass18 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            AnonymousClass18(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass18> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new AnonymousClass18(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((AnonymousClass18) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return DeviceStateIntent.access$buildDeviceState(this.this$0, this.$context);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$2", f = "DeviceStateIntent.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
        static final class C00262 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            C00262(DeviceStateIntent r1, Context r2, Continuation<? super C00262> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new C00262(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((C00262) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L11:
                return r5;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                this.label = 1;
                r5 = DeviceStateIntent.access$buildBluetoothState(this.this$0, this.$context, this);
                if (r5 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass3(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultWifiState", "defaultWifiState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultWifiState((DeviceStateIntent) this.receiver);
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$4", f = "DeviceStateIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            AnonymousClass4(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass4> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new AnonymousClass4(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((AnonymousClass4) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return DeviceStateIntent.access$buildWifiState(this.this$0, this.$context);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass5(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultNetworkState", "defaultNetworkState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultNetworkState((DeviceStateIntent) this.receiver);
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$6", f = "DeviceStateIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            AnonymousClass6(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass6> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new AnonymousClass6(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((AnonymousClass6) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return DeviceStateIntent.access$buildNetworkState(this.this$0, this.$context);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$7, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass7(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultHotspotState", "defaultHotspotState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultHotspotState((DeviceStateIntent) this.receiver);
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$8, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$8", f = "DeviceStateIntent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass8 extends SuspendLambda implements Function1<Continuation<? super JSONObject>, Object> {
            final /* synthetic */ Context $context;
            int label;
            final /* synthetic */ DeviceStateIntent this$0;

            AnonymousClass8(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass8> r3) {
                this.this$0 = r1;
                this.$context = r2;
                super(1, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r3) {
                return new AnonymousClass8(this.this$0, this.$context, r3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super JSONObject> r1) {
                return invoke2(r1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super JSONObject> r1) {
                return ((AnonymousClass8) create(r1)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return DeviceStateIntent.access$buildHotspotState(this.this$0, this.$context);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$getDeviceStatesJson$2$9, reason: invalid class name */
        /* JADX INFO: compiled from: DeviceStateIntent.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function0<JSONObject> {
            AnonymousClass9(Object r8) {
                super(0, r8, DeviceStateIntent.class, "defaultModeState", "defaultModeState()Lorg/json/JSONObject;", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ JSONObject invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final JSONObject invoke2() {
                return DeviceStateIntent.access$defaultModeState((DeviceStateIntent) this.receiver);
            }
        }

        AnonymousClass2(DeviceStateIntent r1, Context r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, this.$context, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super String> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L15;
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                default: goto L5;
            };
        L6:
            JSONObject r10 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L43:
            String r12 = r10.toString();
            Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
            OLog.d(DeviceStateIntent.TAG, "getDeviceStatesJson finish, length=" + r12.length());
            return r12;
        L7:
            JSONObject r1 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L39:
            this.L$0 = r1;
            this.label = 9;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, "device", new AnonymousClass17(this.this$0), new AnonymousClass18(this.this$0, this.$context, null), this) != r0) goto L42;
            return r0;
        L42:
            r10 = r1;
            goto L43
        L8:
            r1 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L36:
            this.L$0 = r1;
            this.label = 8;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, PageConstants.LAUNCH_PAGE_SOUND, new AnonymousClass15(this.this$0), new AnonymousClass16(this.this$0, this.$context, null), this) != r0) goto L39;
            return r0;
        L9:
            r1 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L33:
            this.L$0 = r1;
            this.label = 7;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, "battery", new AnonymousClass13(this.this$0), new AnonymousClass14(this.this$0, this.$context, null), this) != r0) goto L36;
            return r0;
        L10:
            r1 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L30:
            this.L$0 = r1;
            this.label = 6;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, "display", new AnonymousClass11(this.this$0), new AnonymousClass12(this.this$0, this.$context, null), this) != r0) goto L33;
            return r0;
        L11:
            r1 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L27:
            this.L$0 = r1;
            this.label = 5;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, "mode", new AnonymousClass9(this.this$0), new AnonymousClass10(this.this$0, this.$context, null), this) != r0) goto L30;
            return r0;
        L12:
            r1 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L24:
            this.L$0 = r1;
            this.label = 4;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, "hotspot", new AnonymousClass7(this.this$0), new AnonymousClass8(this.this$0, this.$context, null), this) != r0) goto L27;
            return r0;
        L13:
            r1 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L21:
            this.L$0 = r1;
            this.label = 3;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, "network", new AnonymousClass5(this.this$0), new AnonymousClass6(this.this$0, this.$context, null), this) != r0) goto L24;
            return r0;
        L14:
            r1 = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(r11);
        L18:
            this.L$0 = r1;
            this.label = 2;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, "wifi", new AnonymousClass3(this.this$0), new AnonymousClass4(this.this$0, this.$context, null), this) != r0) goto L21;
            return r0;
        L15:
            ResultKt.throwOnFailure(r11);
            OLog.d(DeviceStateIntent.TAG, "getDeviceStatesJson start");
            r1 = new JSONObject();
            this.L$0 = r1;
            this.label = 1;
            if (DeviceStateIntent.access$putCategory(this.this$0, r1, "bluetooth", new AnonymousClass1(this.this$0), new C00262(this.this$0, this.$context, null), this) != r0) goto L18;
            return r0;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntent$putCategory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeviceStateIntent.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntent", f = "DeviceStateIntent.kt", i = {0, 0, 0, 0}, l = {786}, m = "putCategory", n = {"this", "$this$putCategory", "key", "defaultValue"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C01491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DeviceStateIntent this$0;

        C01491(DeviceStateIntent r1, Continuation<? super C01491> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return DeviceStateIntent.access$putCategory(this.this$0, null, null, null, null, this);
        }
    }

    @JvmStatic
    public static final String getDeviceStatesJsonForDebug(Context r1) {
        return Companion.getDeviceStatesJsonForDebug(r1);
    }

    public DeviceStateIntent() {
    }

    public static final /* synthetic */ Object access$awaitProfileConnectedDevices(DeviceStateIntent r0, Context r1, BluetoothAdapter r2, int r3, Continuation r4) {
        return r0.awaitProfileConnectedDevices(r1, r2, r3, r4);
    }

    public static final /* synthetic */ JSONObject access$buildBatteryState(DeviceStateIntent r0, Context r1) {
        return r0.buildBatteryState(r1);
    }

    public static final /* synthetic */ Object access$buildBluetoothState(DeviceStateIntent r0, Context r1, Continuation r2) {
        return r0.buildBluetoothState(r1, r2);
    }

    public static final /* synthetic */ JSONObject access$buildDeviceState(DeviceStateIntent r0, Context r1) {
        return r0.buildDeviceState(r1);
    }

    public static final /* synthetic */ JSONObject access$buildDisplayState(DeviceStateIntent r0, Context r1) {
        return r0.buildDisplayState(r1);
    }

    public static final /* synthetic */ JSONObject access$buildHotspotState(DeviceStateIntent r0, Context r1) {
        return r0.buildHotspotState(r1);
    }

    public static final /* synthetic */ JSONObject access$buildModeState(DeviceStateIntent r0, Context r1) {
        return r0.buildModeState(r1);
    }

    public static final /* synthetic */ JSONObject access$buildNetworkState(DeviceStateIntent r0, Context r1) {
        return r0.buildNetworkState(r1);
    }

    public static final /* synthetic */ JSONObject access$buildSoundState(DeviceStateIntent r0, Context r1) {
        return r0.buildSoundState(r1);
    }

    public static final /* synthetic */ JSONObject access$buildWifiState(DeviceStateIntent r0, Context r1) {
        return r0.buildWifiState(r1);
    }

    public static final /* synthetic */ void access$closeProfileProxySafely(DeviceStateIntent r0, BluetoothAdapter r1, int r2, BluetoothProfile r3) {
        r0.closeProfileProxySafely(r1, r2, r3);
    }

    public static final /* synthetic */ JSONObject access$defaultBatteryState(DeviceStateIntent r0) {
        return r0.defaultBatteryState();
    }

    public static final /* synthetic */ JSONObject access$defaultBluetoothState(DeviceStateIntent r0) {
        return r0.defaultBluetoothState();
    }

    public static final /* synthetic */ JSONObject access$defaultDeviceState(DeviceStateIntent r0) {
        return r0.defaultDeviceState();
    }

    public static final /* synthetic */ JSONObject access$defaultDisplayState(DeviceStateIntent r0) {
        return r0.defaultDisplayState();
    }

    public static final /* synthetic */ JSONObject access$defaultHotspotState(DeviceStateIntent r0) {
        return r0.defaultHotspotState();
    }

    public static final /* synthetic */ JSONObject access$defaultModeState(DeviceStateIntent r0) {
        return r0.defaultModeState();
    }

    public static final /* synthetic */ JSONObject access$defaultNetworkState(DeviceStateIntent r0) {
        return r0.defaultNetworkState();
    }

    public static final /* synthetic */ JSONObject access$defaultSoundState(DeviceStateIntent r0) {
        return r0.defaultSoundState();
    }

    public static final /* synthetic */ JSONObject access$defaultWifiState(DeviceStateIntent r0) {
        return r0.defaultWifiState();
    }

    public static final /* synthetic */ Object access$getConnectedBluetoothDevices(DeviceStateIntent r0, Context r1, BluetoothAdapter r2, Continuation r3) {
        return r0.getConnectedBluetoothDevices(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$getDeviceStatesJson(DeviceStateIntent r0, Context r1, Continuation r2) {
        return r0.getDeviceStatesJson(r1, r2);
    }

    public static final /* synthetic */ Object access$putCategory(DeviceStateIntent r0, JSONObject r1, String r2, Function0 r3, Function1 r4, Continuation r5) {
        return r0.putCategory(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemDeviceStateIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((Empty) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemDeviceStateIntent
    public Object doAction(Empty r21, DispatchContext r22, Continuation<? super IntentResult<Empty>> r23) {
        if ((r23 instanceof C01471) == false) goto L7;
        C01471 r2 = (C01471) r23;
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L21:
        String r11 = (String) r1;
        OLog.i(TAG, "doAction success, detailsLength=" + r11.length());
        return new IntentResult(0, new Empty(), null, r11, false, false, 256, null, null, null, 948, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        OLog.i(TAG, "doAction start");
        Context r5 = r22.getContext();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L18;
        OLog.d(TAG, "start privacy activity");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r22);
        return new IntentResult(201, new Empty(), null, null, false, false, 256, null, null, null, 956, null);
    L18:
        r2.label = 1;
        r1 = getDeviceStatesJson(r5, r2);
        if (r1 != r3) goto L21;
        return r3;
    L7:
        r2 = new C01471(this, r23);
        goto L8
    }

    private final Object getDeviceStatesJson(Context r4, Continuation<? super String> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r4, null), r5);
    }

    private final Object buildBluetoothState(Context r10, Continuation<? super JSONObject> r11) {
        if ((r11 instanceof C01461) == false) goto L7;
        C01461 r0 = (C01461) r11;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        String r9 = (String) r0.L$3;
        JSONObject r13 = (JSONObject) r0.L$2;
        DeviceStateIntent r3 = (DeviceStateIntent) r0.L$1;
        JSONObject r4 = (JSONObject) r0.L$0;
        ResultKt.throwOnFailure(r12);
        String r5 = r9;
        DeviceStateIntent this = r3;
    L34:
        JSONArray r14 = (JSONArray) r12;
        JSONObject r15 = r13;
        JSONArray r16 = r14;
    L36:
        this.putSafe(r15, r5, r16);
        return r4;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r15 = new JSONObject();
        BluetoothAdapter r6 = BluetoothAdapter.getDefaultAdapter();
        boolean r7 = false;
        if (r6 != null) goto L17;
    L19:
        boolean r8 = false;
    L20:
        Context r17 = r10.getApplicationContext();
        if (r17 == null) goto L24;
        r10 = r17;
    L24:
        StringBuilder r18 = new StringBuilder("buildBluetoothState enabled=").append(r8).append(", adapterNull=");
        if (r6 != null) goto L27;
        r7 = true;
    L27:
        OLog.d(TAG, r18.append(r7).toString());
        putSafe(r15, IndexDatabaseHelper.IndexColumns.ENABLED, Boxing.boxBoolean(r8));
        r5 = "connected_devices";
        if (r8 == false) goto L35;
        if (r6 == null) goto L35;
        r0.L$0 = r15;
        r0.L$1 = this;
        r0.L$2 = r15;
        r0.L$3 = "connected_devices";
        r0.label = 1;
        Object r19 = getConnectedBluetoothDevices(r10, r6, r0);
        if (r19 != r1) goto L33;
        return r1;
    L33:
        r4 = r15;
        r12 = r19;
        r13 = r4;
    L35:
        r16 = new JSONArray();
        r4 = r15;
        goto L36
    L17:
        if (r6.isEnabled() != true) goto L19;
        r8 = true;
    L7:
        r0 = new C01461(this, r11);
        goto L8
    }

    private final Object getConnectedBluetoothDevices(Context r7, BluetoothAdapter r8, Continuation<? super JSONArray> r9) {
        if ((r9 instanceof C01481) == false) goto L7;
        C01481 r0 = (C01481) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r8 = (BluetoothAdapter) r0.L$1;
        DeviceStateIntent this = (DeviceStateIntent) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L17:
        LinkedHashSet r11 = (LinkedHashSet) r10;
        this.addBondedConnectedBluetoothDevices(r8, r11);
        JSONArray r12 = new JSONArray();
        Iterator r13 = DeviceStateIntentBluetoothFields.snapshotDevices(r11).iterator();
    L19:
        if (r13.hasNext() == false) goto L30;
        BluetoothDevice r14 = (BluetoothDevice) r13.next();
        JSONObject r3 = new JSONObject();
        String r4 = r14.getName();
        if (r4 != null) goto L23;
        r4 = "";
    L23:
        String r5 = r4;
        if (r5.length() != 0) goto L26;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L29;
        r5 = "Unknown";
    L29:
        this.putSafe(r3, "name", r5);
        this.putSafe(r3, "device_type", this.getBluetoothDeviceType(r14));
        this.putSafe(r3, "remaining_battery", Boxing.boxInt(this.getBluetoothBatteryLevel(r14)));
        r12.put(r3);
        goto L19
    L26:
        r6 = false;
        goto L27
    L30:
        OLog.d(TAG, "getConnectedBluetoothDevices finish, jsonCount=" + r12.length());
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        StringBuilder r15 = new StringBuilder("getConnectedBluetoothDevices start, profileCount=");
        int[] r16 = BLUETOOTH_PROFILES;
        OLog.d(TAG, r15.append(r16.length).toString());
        DeviceStateIntent$getConnectedBluetoothDevices$devices$1 r17 = new DeviceStateIntent$getConnectedBluetoothDevices$devices$1(this, r7, r8, null);
        r0.L$0 = this;
        r0.L$1 = r8;
        r0.label = 1;
        r10 = DeviceStateIntentBluetoothFields.awaitProfileResultsConcurrently(r16, r17, r0);
        if (r10 != r1) goto L17;
        return r1;
    L7:
        r0 = new C01481(this, r9);
        goto L8
    }

    private final Object awaitProfileConnectedDevices(Context r11, BluetoothAdapter r12, int r13, Continuation<? super List<BluetoothDevice>> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r14;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r13 = r0.I$0;
        ResultKt.throwOnFailure(r15);
    L17:
        List r16 = (List) r15;
        if (r16 != null) goto L21;
        OLog.d(TAG, "wait bluetooth profile proxy timed out, profile=" + r13);
        return CollectionsKt.emptyList();
    L21:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1 r17 = new DeviceStateIntent$awaitProfileConnectedDevices$connectedDevices$1(r13, this, r12, r11, null);
        r0.I$0 = r13;
        r0.label = 1;
        r15 = TimeoutKt.withTimeoutOrNull(500, r17, r0);
        if (r15 != r1) goto L17;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r14);
        goto L8
    }

    private final void closeProfileProxySafely(BluetoothAdapter r2, int r3, BluetoothProfile r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        DeviceStateIntent r1 = this;     // Catch: Throwable -> L4
        r2.closeProfileProxy(r3, r4);     // Catch: Throwable -> L4
        Object r5 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.m1511exceptionOrNullimpl(r5);
        if (r6 == null) goto L12;
        OLog.e(TAG, "close profile proxy failed, profile=" + r3, r6);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void addBondedConnectedBluetoothDevices(BluetoothAdapter r5, Set<BluetoothDevice> r6) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        DeviceStateIntent r2 = this;     // Catch: Throwable -> L14
        Set<BluetoothDevice> r7 = r5.getBondedDevices();     // Catch: Throwable -> L14
        if (r7 != null) goto L6;
        r7 = SetsKt.emptySet();     // Catch: Throwable -> L14
    L6:
        Iterator<T> r8 = r7.iterator();     // Catch: Throwable -> L14
    L8:
        if (r8.hasNext() == false) goto L12;
        BluetoothDevice r3 = (BluetoothDevice) r8.next();     // Catch: Throwable -> L14
        boolean r4 = r6.contains(r3);     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L14
        if (DeviceStateIntentBluetoothFields.shouldAddBondedBluetoothDevice(r4, isAclConnected(r3)) == false) goto L8;
        r6.add(r3);     // Catch: Throwable -> L14
        goto L8
    L12:
        OLog.d(TAG, "addBondedConnectedBluetoothDevices finish, deviceCount=" + r6.size());     // Catch: Throwable -> L14
        Object r9 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r10 = Result.m1511exceptionOrNullimpl(r9);
        if (r10 == null) goto L27;
        OLog.e(TAG, "add bonded connected bluetooth devices failed", r10);
        return;
    L27:
        return;
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private final boolean isAclConnected(BluetoothDevice r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = r4.getClass().getMethod("isConnected", new Class[0]).invoke(r4, new Object[0]);     // Catch: Throwable -> L12
        if ((r5 instanceof Boolean) == false) goto L6;
        Boolean r6 = (Boolean) r5;     // Catch: Throwable -> L12
    L7:
        if (r6 == null) goto L9;
        boolean r7 = r6.booleanValue();     // Catch: Throwable -> L12
    L10:
        Object r8 = Result.m1508constructorimpl(Boolean.valueOf(r7));     // Catch: Throwable -> L12
    L14:
        Throwable r1 = Result.m1511exceptionOrNullimpl(r8);
        if (r1 == null) goto L19;
        OLog.e(TAG, "get bluetooth acl connected failed", r1);
        r8 = false;
    L19:
        return ((Boolean) r8).booleanValue();
    L9:
        r7 = false;
        goto L10
    L6:
        r6 = null;
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final String getBluetoothDeviceType(BluetoothDevice r3) {
        BluetoothClass r2 = r3.getBluetoothClass();
        if (r2 != null) goto L6;
        return VCardConstants.PARAM_PHONE_EXTRA_TYPE_OTHER;
    L6:
        if (r2.getDeviceClass() != 1056) goto L9;
        return "CAR_AUDIO";
    L9:
        if (r2.getMajorDeviceClass() != 1024) goto L13;
        return "AUDIO_VIDEO";
    L13:
        return VCardConstants.PARAM_PHONE_EXTRA_TYPE_OTHER;
    }

    private final int getBluetoothBatteryLevel(BluetoothDevice r6) {
        Object r0 = null;
        boolean r2 = false;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        DeviceStateIntent r5 = this;     // Catch: Throwable -> L12
        Object r7 = r6.getClass().getMethod("getBatteryLevel", new Class[0]).invoke(r6, new Object[0]);     // Catch: Throwable -> L12
        if ((r7 instanceof Integer) == false) goto L6;
        Integer r8 = (Integer) r7;     // Catch: Throwable -> L12
    L7:
        if (r8 == null) goto L9;
        int r9 = r8.intValue();     // Catch: Throwable -> L12
    L10:
        Object r10 = Result.m1508constructorimpl(Integer.valueOf(r9));     // Catch: Throwable -> L12
    L14:
        Throwable r11 = Result.m1511exceptionOrNullimpl(r10);
        if (r11 == null) goto L18;
        OLog.e(TAG, "get bluetooth battery level failed", r11);
        r10 = -1;
    L18:
        int r12 = ((Number) r10).intValue();
        if (r12 >= 0) goto L21;
    L23:
        if (r2 == false) goto L25;
        r0 = r10;
    L25:
        Integer r1 = (Integer) r0;
        if (r1 != null) goto L28;
        return -1;
    L28:
        return r1.intValue();
    L21:
        if (r12 >= 101) goto L23;
        r2 = true;
        goto L23
    L9:
        r9 = -1;
        goto L10
    L6:
        r8 = null;
    L12:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final JSONObject buildWifiState(Context r9) {
        JSONObject r0 = new JSONObject();
        Object r10 = r9.getApplicationContext().getSystemService("wifi");
        String r2 = null;
        if ((r10 instanceof WifiManager) == false) goto L5;
        WifiManager r11 = (WifiManager) r10;
    L6:
        if (r11 == null) goto L8;
        WifiInfo r1 = r11.getConnectionInfo();
    L9:
        if (r1 == null) goto L11;
        r2 = r1.getSSID();
    L11:
        String r3 = normalizeSsid(r2);
        boolean r4 = true;
        if (isConnected(r1) == true) goto L14;
    L19:
        boolean r5 = false;
    L20:
        StringBuilder r6 = new StringBuilder("buildWifiState enabled=");
        if (r11 != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        StringBuilder r8 = r6.append(r7).append(", connected=").append(r5).append(", hasSsid=");
        if (r3.length() <= 0) goto L29;
        boolean r12 = true;
    L30:
        StringBuilder r13 = r8.append(r12).append(", networkId=");
        if (r1 == null) goto L33;
        int r14 = r1.getNetworkId();
    L34:
        OLog.d(TAG, r13.append(r14).toString());
        if (r11 != null) goto L37;
    L39:
        r4 = false;
    L40:
        putSafe(r0, IndexDatabaseHelper.IndexColumns.ENABLED, Boolean.valueOf(r4));
        putSafe(r0, "connected", Boolean.valueOf(r5));
        if (r5 == true) goto L44;
        r3 = "";
    L44:
        putSafe(r0, "ssid", r3);
        return r0;
    L37:
        if (r11.isWifiEnabled() != true) goto L39;
    L33:
        r14 = -1;
        goto L34
    L29:
        r12 = false;
        goto L30
    L23:
        if (r11.isWifiEnabled() != true) goto L25;
        r7 = true;
        goto L26
    L14:
        if (r3.length() <= 0) goto L16;
        boolean r15 = true;
    L17:
        if (r15 == false) goto L19;
        r5 = true;
        goto L20
    L16:
        r15 = false;
        goto L17
    L8:
        r1 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    private final boolean isConnected(WifiInfo r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getNetworkId() == (-1)) goto L6;
        return true;
    }

    private final String normalizeSsid(String r2) {
        String r1 = r2;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return "";
    L11:
        if (Intrinsics.areEqual(r2, "<unknown ssid>") == false) goto L14;
        return "";
    L14:
        return StringsKt.removeSuffix(StringsKt.removePrefix(r2, "\""), "\"");
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r3 = false;
        goto L9
    }

    private final JSONObject buildNetworkState(Context r12) {
        boolean r3 = true;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        DeviceStateIntent r6 = this;     // Catch: Throwable -> L9
        if (Settings.Global.getInt(r12.getContentResolver(), "airplane_mode_on", 0) != 1) goto L6;
        boolean r7 = true;
    L7:
        Object r8 = Result.m1508constructorimpl(Boolean.valueOf(r7));     // Catch: Throwable -> L9
    L12:
        if (Result.m1514isFailureimpl(r8) == false) goto L15;
        r8 = false;
    L15:
        if (((Boolean) r8).booleanValue() == false) goto L18;
        OLog.d(TAG, "buildNetworkState airplaneModeOn=true, force cellular state false");
        return DeviceStateIntentNetworkFields.buildNetworkState(false, false);
    L18:
        TelephonyManager r9 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L37
        DeviceStateIntent r11 = this;     // Catch: Throwable -> L37
        Object r13 = r12.getSystemService(MultiSimAdapter.PHONE_KEY);     // Catch: Throwable -> L37
        if ((r13 instanceof TelephonyManager) == false) goto L22;
        TelephonyManager r14 = (TelephonyManager) r13;     // Catch: Throwable -> L37
    L23:
        int r15 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Throwable -> L37
        if (r14 == null) goto L28;
        TelephonyManager r16 = r14.createForSubscriptionId(r15);     // Catch: Throwable -> L37
        if (r16 == null) goto L28;
        boolean r17 = r16.isDataEnabled();     // Catch: Throwable -> L37
    L31:
        StringBuilder r2 = new StringBuilder("buildNetworkState airplaneModeOn=false, dataSubId=").append(r15).append(", telephonyNull=");     // Catch: Throwable -> L37
        if (r14 == null) goto L35;
        r3 = false;
    L35:
        OLog.d(TAG, r2.append(r3).append(", cellular_enabled=").append(r17).toString());     // Catch: Throwable -> L37
        Object r4 = Result.m1508constructorimpl(Boolean.valueOf(r17));     // Catch: Throwable -> L37
    L39:
        Throwable r18 = Result.m1511exceptionOrNullimpl(r4);
        if (r18 == null) goto L43;
        OLog.e(TAG, "get cellular enabled state failed", r18);
        r4 = false;
    L43:
        boolean r19 = ((Boolean) r4).booleanValue();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L58
        DeviceStateIntent r110 = this;     // Catch: Throwable -> L58
        Object r111 = r12.getSystemService(MultiSimAdapter.PHONE_KEY);     // Catch: Throwable -> L58
        if ((r111 instanceof TelephonyManager) == false) goto L47;
        r9 = (TelephonyManager) r111;     // Catch: Throwable -> L58
    L47:
        int r112 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Throwable -> L58
        if (r9 == null) goto L53;
        TelephonyManager r113 = r9.createForSubscriptionId(r112);     // Catch: Throwable -> L58
        if (r113 == null) goto L53;
        r9 = r113;
    L53:
        if (r9 == null) goto L55;
        int r114 = r9.getDataState();     // Catch: Throwable -> L58
    L56:
        OLog.d(TAG, "buildNetworkState dataSubId=" + r112 + ", dataState=" + r114);     // Catch: Throwable -> L58
        Object r115 = Result.m1508constructorimpl(Boolean.valueOf(DeviceStateIntentNetworkFields.isCellularConnected(r114)));     // Catch: Throwable -> L58
    L60:
        Throwable r116 = Result.m1511exceptionOrNullimpl(r115);
        if (r116 == null) goto L64;
        OLog.e(TAG, "get cellular connected state failed", r116);
        r115 = false;
    L64:
        boolean r117 = ((Boolean) r115).booleanValue();
        OLog.d(TAG, "buildNetworkState cellular_enabled=" + r19 + ", connected=" + r117);
        return DeviceStateIntentNetworkFields.buildNetworkState(r19, r117);
    L55:
        r114 = 0;
    L58:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.m1508constructorimpl(ResultKt.createFailure(th));
    L28:
        if (r14 == null) goto L30;
        r17 = r14.isDataEnabled();     // Catch: Throwable -> L37
        goto L31
    L30:
        r17 = false;
        goto L31
    L22:
        r14 = null;
    L37:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L39
    L6:
        r7 = false;
    L9:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r8 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private final JSONObject buildHotspotState(Context r9) {
        JSONObject r0 = new JSONObject();
        Object r10 = r9.getApplicationContext().getSystemService("wifi");
        if ((r10 instanceof WifiManager) == false) goto L5;
        WifiManager r11 = (WifiManager) r10;
    L6:
        boolean r1 = true;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        DeviceStateIntent r4 = this;     // Catch: Throwable -> L15
        if (r11 != null) goto L10;
    L12:
        boolean r5 = false;
    L13:
        Object r6 = Result.m1508constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L15
    L17:
        Throwable r7 = Result.m1511exceptionOrNullimpl(r6);
        if (r7 == null) goto L21;
        OLog.e(TAG, "get hotspot enabled failed", r7);
        r6 = false;
    L21:
        boolean r8 = ((Boolean) r6).booleanValue();
        String r12 = getHotspotName(r11);
        StringBuilder r13 = new StringBuilder("buildHotspotState enabled=").append(r8).append(", wifiManagerNull=");
        if (r11 != null) goto L24;
        boolean r14 = true;
    L25:
        StringBuilder r15 = r13.append(r14).append(", hasName=");
        if (r12.length() > 0) goto L29;
        r1 = false;
    L29:
        OLog.d(TAG, r15.append(r1).toString());
        putSafe(r0, IndexDatabaseHelper.IndexColumns.ENABLED, Boolean.valueOf(r8));
        putSafe(r0, "name", r12);
        return r0;
    L24:
        r14 = false;
        goto L25
    L10:
        if (r11.isWifiApEnabled() != true) goto L12;
        r5 = true;
    L15:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        r11 = null;
        goto L6
    }

    private final String getHotspotName(WifiManager r4) {
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        DeviceStateIntent r3 = this;     // Catch: Throwable -> L27
        String r5 = null;
        if (r4 == null) goto L8;
        SoftApConfiguration r2 = r4.getSoftApConfiguration();     // Catch: Throwable -> L27
        if (r2 == null) goto L8;
        String r6 = r2.getSsid();     // Catch: Throwable -> L27
    L9:
        String r7 = r6;     // Catch: Throwable -> L27
        if (r7 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == false) goto L25;
        if (r4 == null) goto L22;
        WifiConfiguration r9 = r4.getWifiApConfiguration();     // Catch: Throwable -> L27
        if (r9 == null) goto L22;
        r5 = r9.SSID;     // Catch: Throwable -> L27
    L22:
        if (r5 != null) goto L24;
        r6 = "";
        goto L25
    L24:
        r6 = r5;
    L25:
        Object r10 = Result.m1508constructorimpl(r6);     // Catch: Throwable -> L27
    L29:
        Throwable r11 = Result.m1511exceptionOrNullimpl(r10);
        if (r11 != null) goto L32;
        r0 = r10;
    L34:
        return (String) r0;
    L32:
        OLog.e(TAG, "get hotspot name failed", r11);
        goto L34
    L12:
        if (r7.length() == 0) goto L15;
        r8 = false;
    L8:
        r6 = null;
    L27:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    private final JSONObject buildModeState(Context r6) {
        JSONObject r0 = new JSONObject();
        boolean r1 = getSecureBoolean(r6, FIND_MY_PHONE_SWITCH);
        boolean r2 = getSecureBoolean(r6, "NoDisturbOn");
        boolean r7 = isPowerSaveMode(r6);
        OLog.d(TAG, "buildModeState find_my_phone=" + r1 + ", dnd=" + r2 + ", power_saving=" + r7);
        putSafe(r0, "find_my_phone", Boolean.valueOf(r1));
        putSafe(r0, "dnd", Boolean.valueOf(r2));
        putSafe(r0, "power_saving", Boolean.valueOf(r7));
        return r0;
    }

    private final boolean getSecureBoolean(Context r3, String r4) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        DeviceStateIntent r2 = this;     // Catch: Throwable -> L9
        int r5 = Settings.Secure.getInt(r3.getContentResolver(), r4, 0);     // Catch: Throwable -> L9
        boolean r6 = true;
        if (r5 == 1) goto L7;
        r6 = false;
    L7:
        Object r7 = Result.m1508constructorimpl(Boolean.valueOf(r6));     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.m1511exceptionOrNullimpl(r7);
        if (r8 == null) goto L16;
        OLog.e(TAG, "get secure boolean failed, key=" + r4, r8);
        r7 = false;
    L16:
        return ((Boolean) r7).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final boolean isPowerSaveMode(Context r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        DeviceStateIntent r2 = this;     // Catch: Throwable -> L12
        Object r3 = r5.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L12
        if ((r3 instanceof PowerManager) == false) goto L6;
        PowerManager r4 = (PowerManager) r3;     // Catch: Throwable -> L12
    L7:
        if (r4 == null) goto L9;
        boolean r6 = r4.isPowerSaveMode();     // Catch: Throwable -> L12
    L10:
        Object r7 = Result.m1508constructorimpl(Boolean.valueOf(r6));     // Catch: Throwable -> L12
    L14:
        Throwable r8 = Result.m1511exceptionOrNullimpl(r7);
        if (r8 == null) goto L31;
        OLog.e(TAG, "get power save mode failed", r8);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L24
        DeviceStateIntent r10 = this;     // Catch: Throwable -> L24
        int r11 = Settings.Global.getInt(r5.getContentResolver(), "low_power", 0);     // Catch: Throwable -> L24
        boolean r12 = true;
        if (r11 == 1) goto L22;
        r12 = false;
    L22:
        Object r13 = Result.m1508constructorimpl(Boolean.valueOf(r12));     // Catch: Throwable -> L24
    L27:
        if (Result.m1514isFailureimpl(r13) == false) goto L29;
        r13 = false;
    L29:
        r7 = Boolean.valueOf(((Boolean) r13).booleanValue());
    L24:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.m1508constructorimpl(ResultKt.createFailure(th));
    L31:
        return ((Boolean) r7).booleanValue();
    L9:
        r6 = false;
        goto L10
    L6:
        r4 = null;
    L12:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final JSONObject buildDisplayState(Context r7) {
        JSONObject r0 = new JSONObject();
        if ((r7.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r1 = true;
    L6:
        boolean r2 = getSecureBoolean(r7, NIGHT_DISPLAY_ACTIVATED);
        boolean r3 = isAutoBrightness(r7);
        int r8 = getBrightnessPercent(r7);
        OLog.d(TAG, "buildDisplayState night_mode=" + r1 + ", eye_comfort=" + r2 + ", auto_brightness=" + r3 + ", brightness=" + r8);
        putSafe(r0, "night_mode", Boolean.valueOf(r1));
        putSafe(r0, "eye_comfort", Boolean.valueOf(r2));
        putSafe(r0, "auto_brightness", Boolean.valueOf(r3));
        putSafe(r0, "brightness", Integer.valueOf(r8));
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    private final boolean isAutoBrightness(Context r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        DeviceStateIntent r2 = this;     // Catch: Throwable -> L9
        int r4 = Settings.System.getInt(r3.getContentResolver(), "screen_brightness_mode", 0);     // Catch: Throwable -> L9
        boolean r5 = true;
        if (r4 == 1) goto L7;
        r5 = false;
    L7:
        Object r6 = Result.m1508constructorimpl(Boolean.valueOf(r5));     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.m1511exceptionOrNullimpl(r6);
        if (r7 == null) goto L16;
        OLog.e(TAG, "get auto brightness failed", r7);
        r6 = false;
    L16:
        return ((Boolean) r6).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final int getBrightnessPercent(Context r6) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        DeviceStateIntent r5 = this;     // Catch: Throwable -> L15
        Object r7 = r6.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L15
        if ((r7 instanceof PowerManager) == false) goto L6;
        PowerManager r8 = (PowerManager) r7;     // Catch: Throwable -> L15
    L7:
        int r3 = 0;
        if (r8 == null) goto L10;
        int r4 = r8.getMultiBitMinimumScreenBrightnessSetting();     // Catch: Throwable -> L15
    L11:
        if (r8 == null) goto L13;
        r3 = r8.getMultiBitMaximumScreenBrightnessSetting();     // Catch: Throwable -> L15
    L13:
        int r9 = AdaptUtils.getBrightness(r6);     // Catch: Throwable -> L15
        int r10 = DeviceStateIntentDisplayFields.calculateBrightnessPercent(r9, r4, r3);     // Catch: Throwable -> L15
        OLog.d(TAG, "getBrightnessPercent raw=" + r9 + ", min=" + r4 + ", max=" + r3 + ", percent=" + r10);     // Catch: Throwable -> L15
        Object r11 = Result.m1508constructorimpl(Integer.valueOf(r10));     // Catch: Throwable -> L15
    L17:
        Throwable r12 = Result.m1511exceptionOrNullimpl(r11);
        if (r12 == null) goto L22;
        OLog.e(TAG, "get brightness failed", r12);
        r11 = -1;
    L22:
        return ((Number) r11).intValue();
    L10:
        r4 = 0;
        goto L11
    L6:
        r8 = null;
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final JSONObject buildBatteryState(Context r10) {
        JSONObject r0 = new JSONObject();
        int r1 = getBatteryLevel(r10);
        String r2 = getBatteryRemainingTime(r10);
        boolean r3 = isBatteryCharging(r10);
        String r4 = getBatteryCapacity(r10);
        int r11 = getBatteryHealth(r10);
        StringBuilder r5 = new StringBuilder("buildBatteryState level=").append(r1).append(", hasRemainingTime=");
        boolean r7 = true;
        if (r2.length() <= 0) goto L5;
        boolean r6 = true;
    L6:
        StringBuilder r8 = r5.append(r6).append(", charging=").append(r3).append(", hasCapacity=");
        if (r4.length() > 0) goto L10;
        r7 = false;
    L10:
        OLog.d(TAG, r8.append(r7).append(", health=").append(r11).toString());
        putSafe(r0, "level", Integer.valueOf(r1));
        putSafe(r0, "remaining_time", r2);
        putSafe(r0, "charging", Boolean.valueOf(r3));
        putSafe(r0, PerfConsts.KEY_CURRENT_CAPACITY, r4);
        putSafe(r0, "health", Integer.valueOf(r11));
        return r0;
    L5:
        r6 = false;
        goto L6
    }

    private final int getBatteryLevel(Context r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        DeviceStateIntent r2 = this;     // Catch: Throwable -> L12
        Object r4 = r3.getSystemService("batterymanager");     // Catch: Throwable -> L12
        if ((r4 instanceof BatteryManager) == false) goto L6;
        BatteryManager r5 = (BatteryManager) r4;     // Catch: Throwable -> L12
    L7:
        if (r5 == null) goto L9;
        int r6 = r5.getIntProperty(4);     // Catch: Throwable -> L12
    L10:
        Object r7 = Result.m1508constructorimpl(Integer.valueOf(DeviceStateIntentBatteryFields.normalizeBatteryLevel(r6)));     // Catch: Throwable -> L12
    L14:
        Throwable r8 = Result.m1511exceptionOrNullimpl(r7);
        if (r8 == null) goto L19;
        OLog.e(TAG, "get battery level failed", r8);
        r7 = -1;
    L19:
        return ((Number) r7).intValue();
    L9:
        r6 = -1;
        goto L10
    L6:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final boolean isBatteryCharging(Context r5) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        DeviceStateIntent r4 = this;     // Catch: Throwable -> L8
        Intent r6 = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r5, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2);     // Catch: Throwable -> L8
        int r7 = 1;
        if (r6 == null) goto L6;
        r7 = r6.getIntExtra("status", 1);     // Catch: Throwable -> L8
    L6:
        boolean r8 = DeviceStateIntentBatteryFields.isBatteryCharging(r7);     // Catch: Throwable -> L8
        OLog.d(TAG, "isBatteryCharging status=" + r7 + ", charging=" + r8);     // Catch: Throwable -> L8
        Object r9 = Result.m1508constructorimpl(Boolean.valueOf(r8));     // Catch: Throwable -> L8
    L10:
        Throwable r10 = Result.m1511exceptionOrNullimpl(r9);
        if (r10 == null) goto L15;
        OLog.e(TAG, "get battery charging failed", r10);
        r9 = false;
    L15:
        return ((Boolean) r9).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final String getBatteryRemainingTime(Context r13) {
        Object r0 = "";
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        DeviceStateIntent r5 = this;     // Catch: Throwable -> L19
        Object r6 = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"poweradvisor"});     // Catch: Throwable -> L19
        if ((r6 instanceof IBinder) == false) goto L6;
        IBinder r7 = (IBinder) r6;     // Catch: Throwable -> L19
    L7:
        if (r7 != null) goto L9;
    L8:
        String r12 = "";
    L17:
        Object r14 = Result.m1508constructorimpl(r12);     // Catch: Throwable -> L19
    L21:
        Throwable r15 = Result.m1511exceptionOrNullimpl(r14);
        if (r15 != null) goto L24;
        r0 = r14;
    L26:
        return (String) r0;
    L24:
        OLog.e(TAG, "get battery remaining time failed", r15);
        goto L26
    L9:
        Object r8 = Class.forName("android.os.IPowerAdvisor$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r7});     // Catch: Throwable -> L19
        if (r8 == null) goto L8;
        if (isPowerSaveMode(r13) == false) goto L15;
        String r16 = "computePowerSavingModeBatteryTimeRemaining";
    L16:
        OLog.d(TAG, "getBatteryRemainingTime call method=".concat(r16));     // Catch: Throwable -> L19
        long r17 = DeviceStateIntentBatteryFields.extractRemainingTimeMillis(r8, r16);     // Catch: Throwable -> L19
        OLog.d(TAG, "getBatteryRemainingTime millis=" + r17);     // Catch: Throwable -> L19
        r12 = DeviceStateIntentBatteryFields.formatRemainingTime(r17);     // Catch: Throwable -> L19
        goto L17
    L15:
        r16 = "computeBatteryTimeRemaining";
        goto L16
    L6:
        r7 = null;
    L19:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final String getBatteryCapacity(Context r6) {
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        DeviceStateIntent r5 = this;     // Catch: Throwable -> L14
        Class<?> r7 = Class.forName("com.android.internal.os.PowerProfile");     // Catch: Throwable -> L14
        Object r8 = r7.getMethod("getBatteryCapacity", new Class[0]).invoke(r7.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r6}), new Object[0]);     // Catch: Throwable -> L14
        if ((r8 instanceof Double) == false) goto L6;
        Double r9 = (Double) r8;     // Catch: Throwable -> L14
    L7:
        if (r9 != null) goto L9;
    L11:
        String r10 = "";
    L12:
        Object r11 = Result.m1508constructorimpl(r10);     // Catch: Throwable -> L14
    L16:
        Throwable r12 = Result.m1511exceptionOrNullimpl(r11);
        if (r12 != null) goto L19;
        r0 = r11;
    L21:
        return (String) r0;
    L19:
        OLog.e(TAG, "get battery capacity failed", r12);
        goto L21
    L9:
        if (r9.doubleValue() <= 0.0d) goto L11;
        r10 = MathKt.roundToInt(r9.doubleValue()) + "mAh";     // Catch: Throwable -> L14
        goto L12
    L6:
        r9 = null;
    L14:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private final int getBatteryHealth(Context r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        DeviceStateIntent r4 = this;     // Catch: Throwable -> L23
        Object r6 = r5.getSystemService("batterymanager");     // Catch: Throwable -> L23
        Integer r2 = null;
        if ((r6 instanceof BatteryManager) == false) goto L6;
        BatteryManager r7 = (BatteryManager) r6;     // Catch: Throwable -> L23
    L7:
        int r8 = BatteryManager.class.getField("BATTERY_PROPERTY_SOH").getInt(null);     // Catch: Throwable -> L23
        if (r7 == null) goto L10;
        int r9 = (int) r7.getLongProperty(r8);     // Catch: Throwable -> L23
    L11:
        Integer r10 = Integer.valueOf(r9);     // Catch: Throwable -> L23
        int r11 = r10.intValue();     // Catch: Throwable -> L23
        boolean r3 = false;
        if (r11 >= 0) goto L14;
    L16:
        if (r3 == false) goto L18;
        r2 = r10;
    L18:
        if (r2 == null) goto L20;
        int r12 = r2.intValue();     // Catch: Throwable -> L23
    L21:
        Object r13 = Result.m1508constructorimpl(Integer.valueOf(r12));     // Catch: Throwable -> L23
    L25:
        Throwable r14 = Result.m1511exceptionOrNullimpl(r13);
        if (r14 == null) goto L30;
        OLog.e(TAG, "get battery health failed", r14);
        r13 = -1;
    L30:
        return ((Number) r13).intValue();
    L20:
        r12 = -1;
        goto L21
    L14:
        if (r11 >= 101) goto L16;
        r3 = true;
        goto L16
    L10:
        r9 = -1;
        goto L11
    L6:
        r7 = null;
    L23:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    private final JSONObject buildSoundState(Context r11) {
        Object r0 = r11.getSystemService("audio");
        if ((r0 instanceof AudioManager) == false) goto L5;
        AudioManager r1 = (AudioManager) r0;
    L6:
        JSONObject r2 = new JSONObject();
        int r3 = getVolumePercent(r1, 3);
        int r4 = getVolumePercent(r1, 2);
        int r5 = getVolumePercent(r1, 5);
        int r6 = getVolumePercent(r1, 4);
        int r7 = getVolumePercent(r1, 11);
        int r8 = getRingerMode(r1);
        boolean r12 = isVibrationEnabled(r11, r8);
        if (r8 != 0) goto L9;
        boolean r9 = true;
    L10:
        OLog.d(TAG, "buildSoundState media=" + r3 + ", ring=" + r4 + ", notification=" + r5 + ", alarm=" + r6 + ", assistant=" + r7 + ", vibration=" + r12 + ", ringerMode=" + r8 + ", silent_mode=" + r9);
        putSafe(r2, "media_volume", Integer.valueOf(r3));
        putSafe(r2, "ring_volume", Integer.valueOf(r4));
        putSafe(r2, "notification_volume", Integer.valueOf(r5));
        putSafe(r2, "alarm_volume", Integer.valueOf(r6));
        putSafe(r2, "assistant_volume", Integer.valueOf(r7));
        putSafe(r2, "vibration", Boolean.valueOf(r12));
        putSafe(r2, SettingsSwitchKeyUtil.SILENT_MODE, Boolean.valueOf(r9));
        return r2;
    L9:
        r9 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final int getVolumePercent(AudioManager r8, int r9) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        DeviceStateIntent r7 = this;     // Catch: Throwable -> L13
        if (r8 != null) goto L6;
    L5:
        int r4 = -1;
    L11:
        Object r10 = Result.m1508constructorimpl(Integer.valueOf(r4));     // Catch: Throwable -> L13
    L15:
        Throwable r11 = Result.m1511exceptionOrNullimpl(r10);
        if (r11 == null) goto L20;
        OLog.e(TAG, "get volume failed, stream=" + r9, r11);
        r10 = -1;
    L20:
        return ((Number) r10).intValue();
    L6:
        int r12 = r8.getStreamMaxVolume(r9);     // Catch: Throwable -> L13
        if (r12 <= 0) goto L10;
        int r13 = r8.getStreamVolume(r9);     // Catch: Throwable -> L13
        r4 = RangesKt.coerceIn(MathKt.roundToInt((r13 * 100.0f) / r12), 0, 100);     // Catch: Throwable -> L13
        OLog.d(TAG, "getVolumePercent stream=" + r9 + ", current=" + r13 + ", max=" + r12 + ", percent=" + r4);     // Catch: Throwable -> L13
        goto L11
    L10:
        OLog.d(TAG, "getVolumePercent stream=" + r9 + ", max=" + r12 + ", return default");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final boolean isVibrationEnabled(Context r3, int r4) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        DeviceStateIntent r2 = this;     // Catch: Throwable -> L5
        Object r5 = Result.m1508constructorimpl(Boolean.valueOf(DeviceStateIntentSoundFields.isVibrationEnabled(r4, Settings.Global.getInt(r3.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 0))));     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m1511exceptionOrNullimpl(r5);
        if (r6 == null) goto L12;
        OLog.e(TAG, "get vibration enabled failed", r6);
        r5 = false;
    L12:
        return ((Boolean) r5).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final int getRingerMode(AudioManager r4) {
        int r0 = 2;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        DeviceStateIntent r3 = this;     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        int r5 = r4.getRingerModeInternal();     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.m1508constructorimpl(Integer.valueOf(r5));     // Catch: Throwable -> L9
    L11:
        Throwable r2 = Result.m1511exceptionOrNullimpl(r6);
        if (r2 == null) goto L19;
        OLog.e(TAG, "get ringer mode internal failed", r2);
        if (r4 == null) goto L17;
        r0 = r4.getRingerMode();
    L17:
        r6 = Integer.valueOf(r0);
    L19:
        return ((Number) r6).intValue();
    L6:
        r5 = 2;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final JSONObject buildDeviceState(Context r14) {
        Object r0 = r14.getSystemService("connectivity");
        if ((r0 instanceof ConnectivityManager) == false) goto L5;
        ConnectivityManager r1 = (ConnectivityManager) r0;
    L6:
        String r3 = SystemProperties.get("ro.soc.model", "");
        Intrinsics.checkNotNullExpressionValue(r3, "get(...)");
        String r4 = getRam();
        String r5 = getStorageTotal();
        String r6 = getStorageAvailable(r14);
        String r8 = getResolution();
        String r11 = DeviceUtils.INSTANCE.getOSVersion();
        String r13 = Build.BRAND;
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        String r7 = DeviceStateIntentDeviceFields.getScreenSizeForSoc(r13, r3);
        String r12 = DeviceStateIntentDeviceFields.getFirstIpv4Address(Utils.getDefaultIpAddresses(r1));
        StringBuilder r15 = new StringBuilder("buildDeviceState processor=").append(r3).append(", hasRam=");
        boolean r2 = true;
        if (r4.length() <= 0) goto L12;
        boolean r16 = true;
    L13:
        StringBuilder r17 = r15.append(r16).append(", hasStorageTotal=");
        if (r5.length() <= 0) goto L16;
        boolean r18 = true;
    L17:
        StringBuilder r19 = r17.append(r18).append(", hasStorageAvailable=");
        if (r6.length() <= 0) goto L20;
        boolean r110 = true;
    L21:
        StringBuilder r111 = r19.append(r110).append(", hasScreenSize=");
        if (r7.length() <= 0) goto L24;
        boolean r112 = true;
    L25:
        StringBuilder r113 = r111.append(r112).append(", hasResolution=");
        if (r8.length() <= 0) goto L28;
        boolean r114 = true;
    L29:
        StringBuilder r115 = r113.append(r114).append(", brand=");
        String r116 = Build.BRAND;
        if (r116 != null) goto L32;
        r116 = "";
    L32:
        StringBuilder r117 = r115.append(r116).append(", model=");
        String r118 = Build.MODEL;
        if (r118 != null) goto L35;
        r118 = "";
    L35:
        StringBuilder r119 = r117.append(r118).append(", hasOsVersion=");
        if (r11.length() <= 0) goto L38;
        boolean r120 = true;
    L39:
        StringBuilder r121 = r119.append(r120).append(", hasIpAddress=");
        if (r12.length() > 0) goto L43;
        r2 = false;
    L43:
        OLog.d(TAG, r121.append(r2).toString());
        String r122 = Build.BRAND;
        if (r122 != null) goto L46;
        String r9 = "";
    L47:
        String r123 = Build.MODEL;
        if (r123 != null) goto L50;
        String r10 = "";
    L52:
        return DeviceStateIntentJson.buildDeviceState(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L50:
        r10 = r123;
        goto L52
    L46:
        r9 = r122;
        goto L47
    L38:
        r120 = false;
        goto L39
    L28:
        r114 = false;
        goto L29
    L24:
        r112 = false;
        goto L25
    L20:
        r110 = false;
        goto L21
    L16:
        r18 = false;
        goto L17
    L12:
        r16 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private final String getRam() {
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        DeviceStateIntent r5 = this;     // Catch: Throwable -> L9
        long r2 = DeviceUtils.INSTANCE.getMemInfoKBSize();     // Catch: Throwable -> L9
        if (r2 <= 0) goto L6;
        long r3 = 1000;
        String r6 = (((r2 / r3) / r3) + 1) + " GB";     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.m1508constructorimpl(r6);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.m1511exceptionOrNullimpl(r7);
        if (r4 != null) goto L14;
        r0 = r7;
    L16:
        return (String) r0;
    L14:
        OLog.e(TAG, "get ram failed", r4);
        goto L16
    L6:
        r6 = "";
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final String getStorageTotal() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        DeviceStateIntent r2 = this;     // Catch: Throwable -> L4
        Object r3 = Result.m1508constructorimpl(DeviceStateIntentDeviceFields.formatStorageSize(Utils.getStorageVersion()));     // Catch: Throwable -> L4
    L6:
        Throwable r1 = Result.m1511exceptionOrNullimpl(r3);
        if (r1 == null) goto L11;
        OLog.e(TAG, "get storage total failed", r1);
        r3 = "";
    L11:
        return (String) r3;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final String getStorageAvailable(Context r20) {
        Object r1 = "";
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L33
        DeviceStateIntent r5 = this;     // Catch: Throwable -> L33
        long r11 = DeviceUtils.INSTANCE.getSDAvailableSize();     // Catch: Throwable -> L33
        boolean r6 = DeviceStateIntentDeviceFields.shouldQueryPrimaryStorageFreeBytes(r11);     // Catch: Throwable -> L33
        if (r6 == false) goto L6;
        long r9 = getPrimaryStorageFreeBytes(r20);     // Catch: Throwable -> L33
    L8:
        if (r11 <= 0) goto L10;
    L12:
        boolean r7 = false;
    L13:
        boolean r8 = r7;
        if (r8 == true) goto L16;
        long r19 = 0;
    L17:
        long r17 = r9;
        long r10 = DeviceStateIntentDeviceFields.chooseStorageAvailableBytes(r9, r11, r19);     // Catch: Throwable -> L33
        if (r11 <= 0) goto L20;
        long r12 = r19;
        String r15 = "settings_statfs";
        long r13 = r17;
    L27:
        OLog.d(TAG, "getStorageAvailable settingsBytes=" + r11 + ", queryStats=" + r6 + ", statsBytes=" + r13 + ", queryLegacy=" + r8 + ", legacyBytes=" + r12 + ", selectedSource=" + r15 + ", selectedBytes=" + r10);     // Catch: Throwable -> L33
        if (r10 <= 0) goto L30;
        String r3 = DeviceStateIntentDeviceFields.formatStorageSizeBase1000(r10);     // Catch: Throwable -> L33
        OLog.d(TAG, "getStorageAvailable formatted=" + r3);     // Catch: Throwable -> L33
    L31:
        Object r0 = Result.m1508constructorimpl(r3);     // Catch: Throwable -> L33
    L35:
        Throwable r14 = Result.m1511exceptionOrNullimpl(r0);
        if (r14 != null) goto L38;
        r1 = r0;
    L40:
        return (String) r1;
    L38:
        OLog.e(TAG, "get storage available failed", r14);
        goto L40
    L30:
        OLog.d(TAG, "getStorageAvailable no valid bytes, return empty");     // Catch: Throwable -> L33
        r3 = "";
        goto L31
    L20:
        r13 = r17;
        if (r13 <= 0) goto L23;
        r15 = "storage_stats";
        r12 = r19;
        goto L27
    L23:
        r12 = r19;
        if (r12 <= 0) goto L26;
        r15 = "legacy_statfs";
        goto L27
    L26:
        r15 = PreferredSettingsUtils.INTENT_EXTRA_EMPTY;
        goto L27
    L16:
        r19 = Utils.getAvailableSize(Environment.getExternalStorageDirectory());     // Catch: Throwable -> L33
        goto L17
    L10:
        if (r9 > 0) goto L12;
        r7 = true;
        goto L13
    L6:
        r9 = 0;
    L33:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r0 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L35
    }

    private final long getPrimaryStorageFreeBytes(Context r9) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L32
        DeviceStateIntent r8 = this;     // Catch: Throwable -> L32
        StorageManager r10 = (StorageManager) r9.getSystemService(StorageManager.class);     // Catch: Throwable -> L32
        StorageStatsManager r11 = (StorageStatsManager) r9.getSystemService(StorageStatsManager.class);     // Catch: Throwable -> L32
        String r4 = null;
        if (r10 == null) goto L15;
        List r12 = r10.getVolumes();     // Catch: Throwable -> L32
        if (r12 == null) goto L15;
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L32
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L32
    L9:
        if (r13.hasNext() == false) goto L13;
        Object r5 = r13.next();     // Catch: Throwable -> L32
        if (((VolumeInfo) r5).isPrimary() == false) goto L9;
    L14:
        VolumeInfo r6 = (VolumeInfo) r5;     // Catch: Throwable -> L32
    L16:
        if (r6 == null) goto L18;
        r4 = r6.fsUuid;     // Catch: Throwable -> L32
    L18:
        if (r11 == null) goto L21;
        if (r4 == null) goto L21;
        long r14 = r11.getFreeBytes(r4);     // Catch: Throwable -> L32
    L22:
        StringBuilder r7 = new StringBuilder().append("getPrimaryStorageFreeBytes primaryVolumeNull=");     // Catch: Throwable -> L32
        boolean r15 = true;
        if (r6 != null) goto L25;
        boolean r16 = true;
    L26:
        StringBuilder r17 = r7.append(r16).append(", hasFsUuid=");     // Catch: Throwable -> L32
        if (r4 != null) goto L30;
        r15 = false;
    L30:
        OLog.d(TAG, r17.append(r15).append(", freeBytes=").append(r14).toString());     // Catch: Throwable -> L32
        Object r18 = Result.m1508constructorimpl(Long.valueOf(r14));     // Catch: Throwable -> L32
    L34:
        Throwable r19 = Result.m1511exceptionOrNullimpl(r18);
        if (r19 == null) goto L39;
        OLog.e(TAG, "get primary storage free bytes failed", r19);
        r18 = 0L;
    L39:
        return ((Number) r18).longValue();
    L25:
        r16 = false;
    L21:
        r14 = 0;
        goto L22
    L13:
        r5 = null;
    L15:
        r6 = null;
    L32:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    private final String getResolution() {
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        DeviceStateIntent r3 = this;     // Catch: Throwable -> L10
        int r4 = DeviceUtils.INSTANCE.getScreenWidth();     // Catch: Throwable -> L10
        int r2 = DeviceUtils.INSTANCE.getScreenHeight();     // Catch: Throwable -> L10
        if (r4 <= 0) goto L7;
        if (r2 <= 0) goto L7;
        String r5 = r2 + " x " + r4;     // Catch: Throwable -> L10
    L8:
        Object r6 = Result.m1508constructorimpl(r5);     // Catch: Throwable -> L10
    L12:
        Throwable r7 = Result.m1511exceptionOrNullimpl(r6);
        if (r7 != null) goto L15;
        r0 = r6;
    L17:
        return (String) r0;
    L15:
        OLog.e(TAG, "get resolution failed", r7);
    L7:
        r5 = "";
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private final void putSafe(JSONObject r1, String r2, Object r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r4 = Result.m1508constructorimpl(r1.put(r2, r3));     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L12;
        OLog.e(TAG, "put json failed, key=" + r2, r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final Object putCategory(JSONObject r7, String r8, Function0<? extends JSONObject> r9, Function1<? super Continuation<? super JSONObject>, ? extends Object> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C01491) == false) goto L7;
        C01491 r1 = (C01491) r11;
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        Function0 r13 = (Function0) r1.L$3;
        r8 = (String) r1.L$2;
        r7 = (JSONObject) r1.L$1;
        DeviceStateIntent this = (DeviceStateIntent) r1.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L14 CancellationException -> L16
    L24:
        Pair r14 = TuplesKt.to(r12, Boxing.boxBoolean(false));     // Catch: Exception -> L14 CancellationException -> L16
    L27:
        JSONObject r15 = (JSONObject) r14.component1();
        OLog.d(TAG, "build category finish, key=" + r8 + ", usedDefault=" + ((Boolean) r14.component2()).booleanValue());
        this.putSafe(r7, r8, r15);
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r12);
        OLog.d(TAG, "build category start, key=" + r8);     // Catch: Exception -> L14 CancellationException -> L16
        r1.L$0 = this;     // Catch: Exception -> L14 CancellationException -> L16
        r1.L$1 = r7;     // Catch: Exception -> L14 CancellationException -> L16
        r1.L$2 = r8;     // Catch: Exception -> L14 CancellationException -> L16
        r1.L$3 = r9;     // Catch: Exception -> L14 CancellationException -> L16
        r1.label = 1;     // Catch: Exception -> L14 CancellationException -> L16
        r12 = r10.invoke(r1);     // Catch: Exception -> L14 CancellationException -> L16
        if (r12 != r2) goto L24;
        return r2;
    L16:
        e = move-exception;
        throw e;
    L14:
        e = move-exception;
        OLog.e(TAG, "build device state category failed, key=" + r8, e);
        r14 = TuplesKt.to(r9.invoke(), Boxing.boxBoolean(true));
    L7:
        r1 = new C01491(this, r11);
        goto L8
    }

    private final JSONObject defaultBluetoothState() {
        JSONObject r2 = new JSONObject().put(IndexDatabaseHelper.IndexColumns.ENABLED, false).put("connected_devices", new JSONArray());
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    private final JSONObject defaultWifiState() {
        JSONObject r2 = new JSONObject().put(IndexDatabaseHelper.IndexColumns.ENABLED, false).put("connected", false).put("ssid", "");
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    private final JSONObject defaultNetworkState() {
        return DeviceStateIntentNetworkFields.buildNetworkState(false, false);
    }

    private final JSONObject defaultHotspotState() {
        JSONObject r2 = new JSONObject().put(IndexDatabaseHelper.IndexColumns.ENABLED, false).put("name", "");
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    private final JSONObject defaultModeState() {
        JSONObject r2 = new JSONObject().put("find_my_phone", false).put("dnd", false).put("power_saving", false);
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    private final JSONObject defaultDisplayState() {
        JSONObject r2 = new JSONObject().put("night_mode", false).put("eye_comfort", false).put("auto_brightness", false).put("brightness", -1);
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    private final JSONObject defaultBatteryState() {
        JSONObject r4 = new JSONObject().put("level", -1).put("remaining_time", "").put("charging", false).put(PerfConsts.KEY_CURRENT_CAPACITY, "").put("health", -1);
        Intrinsics.checkNotNullExpressionValue(r4, "put(...)");
        return r4;
    }

    private final JSONObject defaultSoundState() {
        JSONObject r2 = new JSONObject().put("media_volume", -1).put("ring_volume", -1).put("notification_volume", -1).put("alarm_volume", -1).put("assistant_volume", -1).put("vibration", false).put(SettingsSwitchKeyUtil.SILENT_MODE, false);
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    private final JSONObject defaultDeviceState() {
        return DeviceStateIntentJson.buildDeviceState("", "", "", "", "", "", "", "", "", "");
    }

    static {
        Companion = new Companion(null);
        BLUETOOTH_PROFILES = new int[]{2, 1};
    }
}
