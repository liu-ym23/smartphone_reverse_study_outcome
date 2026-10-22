package com.android.settings.bluetooth.codec.utils;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothCodecStatus;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.bluetooth.codec.IBluetoothCodecCallback;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BluetoothCodecHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t*\u0002\u000f\u0018\u0018\u0000 02\u00020\u0001:\u00010B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J)\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0(H\u0002¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u001dJ\u0006\u0010+\u001a\u00020\u001dJ\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020%J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020%R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Lcom/android/settings/bluetooth/codec/utils/BluetoothCodecHelper;", "", "source", "", "context", "Landroid/content/Context;", "callback", "Lcom/android/settings/bluetooth/codec/IBluetoothCodecCallback;", "(Ljava/lang/String;Landroid/content/Context;Lcom/android/settings/bluetooth/codec/IBluetoothCodecCallback;)V", "TAG", "bluetoothA2dp", "Landroid/bluetooth/BluetoothA2dp;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothReceiver", "com/android/settings/bluetooth/codec/utils/BluetoothCodecHelper$bluetoothReceiver$1", "Lcom/android/settings/bluetooth/codec/utils/BluetoothCodecHelper$bluetoothReceiver$1;", "getCallback", "()Lcom/android/settings/bluetooth/codec/IBluetoothCodecCallback;", "getContext", "()Landroid/content/Context;", "hasBluetoothReceiverRegister", "", "profileServiceListener", "com/android/settings/bluetooth/codec/utils/BluetoothCodecHelper$profileServiceListener$1", "Lcom/android/settings/bluetooth/codec/utils/BluetoothCodecHelper$profileServiceListener$1;", "getSource", "()Ljava/lang/String;", "closeProfileProxy", "", "connect", "disconnect", "handleBluetoothReceiver", "intent", "Landroid/content/Intent;", "parseBitmask", "", "", "bitmask", "constants", "", "(I[Ljava/lang/Integer;)Ljava/util/List;", "queryCodecCapabilities", "queryCodecConfig", "setBitsPerSample", "bitsPerSample", "setSampleRate", "sampleRate", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BluetoothCodecHelper {
    private static final Integer[] BITS_PER_SAMPLES = null;
    public static final Companion Companion = null;
    private static final int INVAILD_VALUE = -1;
    private static final Integer[] SAMPLE_RATES = null;
    private static final String STATIC_TAG = "BluetoothCodecHelper";
    private final String TAG;
    private BluetoothA2dp bluetoothA2dp;
    private final BluetoothAdapter bluetoothAdapter;
    private final BluetoothCodecHelper$bluetoothReceiver$1 bluetoothReceiver;
    private final IBluetoothCodecCallback callback;
    private final Context context;
    private boolean hasBluetoothReceiverRegister;
    private final BluetoothCodecHelper$profileServiceListener$1 profileServiceListener;
    private final String source;

    /* JADX INFO: compiled from: BluetoothCodecHelper.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/settings/bluetooth/codec/utils/BluetoothCodecHelper$Companion;", "", "()V", "BITS_PER_SAMPLES", "", "", "[Ljava/lang/Integer;", "INVAILD_VALUE", "SAMPLE_RATES", "STATIC_TAG", "", "bitsPerSampleToString", "context", "Landroid/content/Context;", "bitsPerSample", "useDefaultBrief", "", "sampleRateToString", "sampleRate", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final String bitsPerSampleToString(Context r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            return bitsPerSampleToString$default(this, r8, r9, false, 4, null);
        }

        @JvmStatic
        public final String sampleRateToString(Context r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            return sampleRateToString$default(this, r8, r9, false, 4, null);
        }

        private Companion() {
        }

        public static /* synthetic */ String sampleRateToString$default(Companion r0, Context r1, int r2, boolean r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = false;
        L6:
            return r0.sampleRateToString(r1, r2, r3);
        }

        @JvmStatic
        public final String sampleRateToString(Context r1, int r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (r2 != 0) goto L5;
            if (r3 == false) goto L25;
            String r0 = r1.getString(R.string.bluetooth_select_a2dp_codec_default_brief);
        L26:
            Intrinsics.checkNotNull(r0);
            return r0;
        L25:
            r0 = r1.getString(R.string.bluetooth_select_a2dp_codec_default);
            goto L26
        L5:
            if (r2 != 1) goto L7;
            return "44.1 kHz";
        L7:
            if (r2 != 2) goto L9;
            return "48 kHz";
        L9:
            if (r2 != 4) goto L11;
            return "88.2 kHz";
        L11:
            if (r2 != 8) goto L13;
            return "96 kHz";
        L13:
            if (r2 != 16) goto L15;
            return "176.4 kHz";
        L15:
            if (r2 != 32) goto L28;
            return "192 kHz";
        L28:
            return "Unknown (" + r2 + ')';
        }

        public static /* synthetic */ String bitsPerSampleToString$default(Companion r0, Context r1, int r2, boolean r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = false;
        L6:
            return r0.bitsPerSampleToString(r1, r2, r3);
        }

        @JvmStatic
        public final String bitsPerSampleToString(Context r1, int r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (r2 != 0) goto L5;
            if (r3 == false) goto L16;
            String r0 = r1.getString(R.string.bluetooth_select_a2dp_codec_default_brief);
        L17:
            Intrinsics.checkNotNull(r0);
            return r0;
        L16:
            r0 = r1.getString(R.string.bluetooth_select_a2dp_codec_default);
            goto L17
        L5:
            if (r2 != 1) goto L7;
            return "16-bit";
        L7:
            if (r2 != 2) goto L9;
            return "24-bit";
        L9:
            if (r2 != 4) goto L19;
            return "32-bit";
        L19:
            return "Unknown (" + r2 + ')';
        }
    }

    @JvmStatic
    public static final String bitsPerSampleToString(Context r1, int r2) {
        return Companion.bitsPerSampleToString(r1, r2);
    }

    @JvmStatic
    public static final String bitsPerSampleToString(Context r1, int r2, boolean r3) {
        return Companion.bitsPerSampleToString(r1, r2, r3);
    }

    @JvmStatic
    public static final String sampleRateToString(Context r1, int r2) {
        return Companion.sampleRateToString(r1, r2);
    }

    @JvmStatic
    public static final String sampleRateToString(Context r1, int r2, boolean r3) {
        return Companion.sampleRateToString(r1, r2, r3);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.android.settings.bluetooth.codec.utils.BluetoothCodecHelper$profileServiceListener$1] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.android.settings.bluetooth.codec.utils.BluetoothCodecHelper$bluetoothReceiver$1] */
    public BluetoothCodecHelper(String r2, Context r3, IBluetoothCodecCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.source = r2;
        this.context = r3;
        this.callback = r4;
        this.TAG = "BluetoothCodecHelper(" + r2 + ')';
        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.profileServiceListener = new BluetoothCodecHelper$profileServiceListener$1(this);
        this.bluetoothReceiver = new BluetoothCodecHelper$bluetoothReceiver$1(this);
    }

    public static final /* synthetic */ void access$closeProfileProxy(BluetoothCodecHelper r0) {
        r0.closeProfileProxy();
    }

    public static final /* synthetic */ String access$getTAG$p(BluetoothCodecHelper r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ void access$handleBluetoothReceiver(BluetoothCodecHelper r0, Intent r1) {
        r0.handleBluetoothReceiver(r1);
    }

    public static final /* synthetic */ void access$setBluetoothA2dp$p(BluetoothCodecHelper r0, BluetoothA2dp r1) {
        r0.bluetoothA2dp = r1;
    }

    public final IBluetoothCodecCallback getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getSource() {
        return this.source;
    }

    static {
        Companion = new Companion(null);
        SAMPLE_RATES = new Integer[]{1, 2, 4, 8, 16, 32};
        BITS_PER_SAMPLES = new Integer[]{1, 2, 4};
    }

    public final void connect() {
        BluetoothAdapter r0 = this.bluetoothAdapter;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        closeProfileProxy();
        this.bluetoothAdapter.getProfileProxy(this.context, this.profileServiceListener, 2);
        if (this.hasBluetoothReceiverRegister == true) goto L14;
        IntentFilter r2 = new IntentFilter("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED");
        r2.addAction("android.bluetooth.a2dp.profile.action.CODEC_CONFIG_CHANGED");
        r2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.context, this.bluetoothReceiver, r2);
        this.hasBluetoothReceiverRegister = true;
        return;
    L14:
        return;
    L12:
        OLog.e(this.TAG, "Bluetooth is not enabled");
        this.callback.onBluetoothServiceConnected(false);
        return;
    L5:
        if (r0.isEnabled() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void disconnect() {
        closeProfileProxy();
        if (this.hasBluetoothReceiverRegister == false) goto L12;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        this.context.unregisterReceiver(this.bluetoothReceiver);     // Catch: Throwable -> L6
        Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        this.hasBluetoothReceiverRegister = false;
        return;
    L6:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void closeProfileProxy() {
        BluetoothA2dp r0 = this.bluetoothA2dp;
        if (r0 == null) goto L9;
        BluetoothAdapter r1 = this.bluetoothAdapter;
        if (r1 == null) goto L7;
        r1.closeProfileProxy(2, r0);
    L7:
        this.bluetoothA2dp = null;
        return;
    }

    private final void handleBluetoothReceiver(Intent r5) {
        String r0 = this.TAG;
        StringBuilder r1 = new StringBuilder("handleBluetoothReceiver, action: ");
        if (r5 == null) goto L5;
        String r3 = r5.getAction();
    L6:
        OLog.d(r0, r1.append(r3).toString());
        if (r5 == null) goto L41;
        String r2 = r5.getAction();
        if (r2 == null) goto L48;
        int r4 = r2.hashCode();
        if (r4 == (-1752476703)) goto L37;
        if (r4 == (-1530327060)) goto L27;
        if (r4 == 487423555) goto L19;
        return;
    L19:
        if (r2.equals("android.bluetooth.a2dp.profile.action.ACTIVE_DEVICE_CHANGED") == true) goto L21;
        return;
    L21:
        if (((BluetoothDevice) r5.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) != null) goto L24;
        OLog.d(this.TAG, "No active Bluetooth device");
        this.callback.onBluetoothServiceConnected(false);
        return;
    L24:
        if (this.bluetoothA2dp == null) goto L44;
        OLog.d(this.TAG, "Has Bluetooth device");
        this.callback.onBluetoothServiceConnected(true);
        return;
    L44:
        return;
    L27:
        if (r2.equals("android.bluetooth.adapter.action.STATE_CHANGED") == false) goto L50;
        int r6 = r5.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
        OLog.d(this.TAG, "handleBluetoothReceiver, action: " + r5.getAction() + ", state: " + r6);
        if (r6 != 10) goto L32;
        closeProfileProxy();
        return;
    L32:
        if (r6 != 12) goto L51;
        connect();
        return;
    L51:
        return;
    L50:
        return;
    L37:
        if (r2.equals("android.bluetooth.a2dp.profile.action.CODEC_CONFIG_CHANGED") == false) goto L52;
        queryCodecConfig();
        return;
    L52:
        return;
    L48:
        return;
    L41:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void queryCodecCapabilities() {
        OLog.d(this.TAG, "queryCodecCapabilities");
        BluetoothA2dp r0 = this.bluetoothA2dp;
        if (r0 != null) goto L6;
        OLog.d(this.TAG, "BluetoothA2dp is null");
        this.callback.onCodecCapabilitiesQueriedFailed("BluetoothA2dp is null");
        return;
    L6:
        BluetoothDevice r1 = r0.getActiveDevice();
        if (r1 != null) goto L10;
        OLog.d(this.TAG, "No active Bluetooth device");
        this.callback.onCodecCapabilitiesQueriedFailed("No active Bluetooth device");
        return;
    L10:
        BluetoothCodecStatus r2 = r0.getCodecStatus(r1);
        if (r2 != null) goto L14;
        OLog.d(this.TAG, "Failed to get codec status");
        this.callback.onCodecCapabilitiesQueriedFailed("Failed to get codec status");
        return;
    L14:
        BluetoothCodecConfig r3 = r2.getCodecConfig();
        Object r4 = null;
        if (r3 == null) goto L17;
        Integer r5 = Integer.valueOf(r3.getCodecType());
    L19:
        if (r3 == null) goto L21;
        int r10 = r3.getSampleRate();
    L22:
        if (r3 == null) goto L24;
        int r11 = r3.getBitsPerSample();
    L25:
        OLog.d(this.TAG, "Current codec type: " + r5);
        OLog.d(this.TAG, "Current sample rate: " + r10);
        OLog.d(this.TAG, "Current bits per sample: " + r11);
        List<BluetoothCodecConfig> r6 = r2.getCodecsSelectableCapabilities();
        Intrinsics.checkNotNull(r6);
        if ((!r6.isEmpty()) == true) goto L29;
        r6 = null;
    L29:
        if (r6 != null) goto L32;
        OLog.d(this.TAG, "No selectable configs available");
        this.callback.onCodecCapabilitiesQueriedFailed("No selectable configs available");
        return;
    L32:
        Iterator<T> r7 = r6.iterator();
    L34:
        if (r7.hasNext() == false) goto L44;
        Object r8 = r7.next();
        int r9 = ((BluetoothCodecConfig) r8).getCodecType();
        if (r5 != null) goto L39;
    L41:
        boolean r12 = false;
    L42:
        if (r12 == false) goto L34;
        r4 = r8;
        goto L44
    L39:
        if (r9 != r5.intValue()) goto L41;
        r12 = true;
    L44:
        BluetoothCodecConfig r13 = (BluetoothCodecConfig) r4;
        if (r13 != null) goto L48;
        OLog.d(this.TAG, "Failed to find config for current codec type");
        this.callback.onCodecCapabilitiesQueriedFailed("Failed to find config for current codec type");
        return;
    L48:
        OLog.d(this.TAG, "sample rate bitmask: " + r13.getSampleRate() + ", bits per sample bitmask: " + r13.getBitsPerSample());
        List<Integer> r14 = CollectionsKt.mutableListOf(new Integer[]{0});
        r14.addAll(parseBitmask(r13.getSampleRate(), SAMPLE_RATES));
        List<Integer> r15 = CollectionsKt.mutableListOf(new Integer[]{0});
        r15.addAll(parseBitmask(r13.getBitsPerSample(), BITS_PER_SAMPLES));
        IBluetoothCodecCallback r16 = this.callback;
        if (r3 == null) goto L51;
        int r17 = r3.getCodecType();
    L52:
        r16.onCodecCapabilitiesQueried(r17, r14, r15, r10, r11);
        OLog.d(this.TAG, "Supported sample rates:");
        Iterator<T> r18 = r14.iterator();
    L54:
        if (r18.hasNext() == false) goto L56;
        OLog.d(this.TAG, Companion.sampleRateToString$default(Companion, this.context, ((Number) r18.next()).intValue(), false, 4, null));
        goto L54
    L56:
        OLog.d(this.TAG, "Supported bits per sample:");
        Iterator<T> r19 = r15.iterator();
    L58:
        if (r19.hasNext() == false) goto L60;
        OLog.d(this.TAG, Companion.bitsPerSampleToString$default(Companion, this.context, ((Number) r19.next()).intValue(), false, 4, null));
        goto L58
    L60:
        return;
    L51:
        r17 = 1000000;
        goto L52
    L24:
        r11 = 0;
        goto L25
    L21:
        r10 = 0;
        goto L22
    L17:
        r5 = null;
        goto L19
    }

    public final void queryCodecConfig() {
        OLog.d(this.TAG, "queryCodecConfig");
        BluetoothA2dp r0 = this.bluetoothA2dp;
        if (r0 != null) goto L6;
        OLog.d(this.TAG, "BluetoothA2dp is null");
        this.callback.onCodecConfigQueriedFailed("BluetoothA2dp is null");
        return;
    L6:
        BluetoothDevice r1 = r0.getActiveDevice();
        if (r1 != null) goto L10;
        OLog.d(this.TAG, "No active Bluetooth device");
        this.callback.onCodecConfigQueriedFailed("No active Bluetooth device");
        return;
    L10:
        BluetoothCodecStatus r2 = r0.getCodecStatus(r1);
        if (r2 != null) goto L14;
        OLog.d(this.TAG, "Failed to get codec status");
        this.callback.onCodecConfigQueriedFailed("Failed to get codec status");
        return;
    L14:
        BluetoothCodecConfig r3 = r2.getCodecConfig();
        if (r3 != null) goto L17;
        OLog.d(this.TAG, "No current codec config");
        this.callback.onCodecConfigQueriedFailed("No current codec config");
        return;
    L17:
        OLog.d(this.TAG, "Found current codec config: " + r3);
        this.callback.onCodecConfigQueried(r3);
    }

    public final void setSampleRate(int r8) {
        OLog.d(this.TAG, "setSampleRate: " + r8);
        BluetoothA2dp r1 = this.bluetoothA2dp;
        if (r1 != null) goto L6;
        OLog.d(this.TAG, "BluetoothA2dp is null");
        this.callback.onCodecConfigSetFailed("BluetoothA2dp is null");
        return;
    L6:
        BluetoothDevice r2 = r1.getActiveDevice();
        if (r2 != null) goto L10;
        OLog.d(this.TAG, "No active Bluetooth device");
        this.callback.onBluetoothServiceConnected(false);
        this.callback.onCodecConfigSetFailed("No active Bluetooth device");
        return;
    L10:
        BluetoothCodecStatus r3 = r1.getCodecStatus(r2);
        if (r3 != null) goto L14;
        OLog.d(this.TAG, "Failed to get codec status");
        this.callback.onCodecConfigSetFailed("Failed to get codec status");
        return;
    L14:
        BluetoothCodecConfig r4 = r3.getCodecConfig();
        BluetoothCodecConfig.Builder r5 = new BluetoothCodecConfig.Builder().setSampleRate(r8);
        if (r4 == null) goto L20;
        r5.setCodecType(r4.getCodecType());
        if (Build.VERSION.SDK_INT < 35) goto L19;
        r5.setExtendedCodecType(r4.getExtendedCodecType());
    L19:
        r5.setCodecPriority(1000000);
        r5.setBitsPerSample(r4.getBitsPerSample());
        r5.setChannelMode(r4.getChannelMode());
        r5.setCodecSpecific1(r4.getCodecSpecific1());
        r5.setCodecSpecific2(r4.getCodecSpecific2());
        r5.setCodecSpecific3(r4.getCodecSpecific3());
        r5.setCodecSpecific4(r4.getCodecSpecific4());
    L20:
        BluetoothCodecConfig r6 = r5.build();
        Intrinsics.checkNotNullExpressionValue(r6, "build(...)");
        r1.setCodecConfigPreference(r2, r6);     // Catch: Exception -> L23
        OLog.d(this.TAG, "Set sample rate success: " + r8);     // Catch: Exception -> L23
        this.callback.onCodecConfigSetSuccess(r8, -1);     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        OLog.e(this.TAG, "Failed to set sample rate", e);
        this.callback.onCodecConfigSetFailed("Failed to set sample rate: " + e.getMessage());
    }

    public final void setBitsPerSample(int r8) {
        OLog.d(this.TAG, "setBitsPerSample: " + r8);
        BluetoothA2dp r1 = this.bluetoothA2dp;
        if (r1 != null) goto L6;
        OLog.d(this.TAG, "BluetoothA2dp is null");
        this.callback.onCodecConfigSetFailed("BluetoothA2dp is null");
        return;
    L6:
        BluetoothDevice r2 = r1.getActiveDevice();
        if (r2 != null) goto L10;
        OLog.d(this.TAG, "No active Bluetooth device");
        this.callback.onBluetoothServiceConnected(false);
        this.callback.onCodecConfigSetFailed("No active Bluetooth device");
        return;
    L10:
        BluetoothCodecStatus r3 = r1.getCodecStatus(r2);
        if (r3 != null) goto L14;
        OLog.d(this.TAG, "Failed to get codec status");
        this.callback.onCodecConfigSetFailed("Failed to get codec status");
        return;
    L14:
        BluetoothCodecConfig r4 = r3.getCodecConfig();
        BluetoothCodecConfig.Builder r5 = new BluetoothCodecConfig.Builder().setBitsPerSample(r8);
        if (r4 == null) goto L20;
        r5.setCodecType(r4.getCodecType());
        if (Build.VERSION.SDK_INT < 35) goto L19;
        r5.setExtendedCodecType(r4.getExtendedCodecType());
    L19:
        r5.setCodecPriority(1000000);
        r5.setSampleRate(r4.getSampleRate());
        r5.setChannelMode(r4.getChannelMode());
        r5.setCodecSpecific1(r4.getCodecSpecific1());
        r5.setCodecSpecific2(r4.getCodecSpecific2());
        r5.setCodecSpecific3(r4.getCodecSpecific3());
        r5.setCodecSpecific4(r4.getCodecSpecific4());
    L20:
        BluetoothCodecConfig r6 = r5.build();
        Intrinsics.checkNotNullExpressionValue(r6, "build(...)");
        r1.setCodecConfigPreference(r2, r6);     // Catch: Exception -> L23
        OLog.d(this.TAG, "Set bits per sample success: " + r8);     // Catch: Exception -> L23
        this.callback.onCodecConfigSetSuccess(-1, r8);     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        OLog.e(this.TAG, "Failed to set bits per sample", e);
        this.callback.onCodecConfigSetFailed("Failed to set bits per sample: " + e.getMessage());
    }

    private final List<Integer> parseBitmask(int r6, Integer[] r7) {
        ArrayList r5 = new ArrayList();
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        Integer r3 = r7[r2];
        if ((r3.intValue() & r6) == 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        r5.add(r3);
    L10:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = false;
        goto L8
    L12:
        return r5;
    }
}
