package com.android.settingslib.wifi;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.MessageFormat;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.GlobalProxyLancet;
import com.android.settings.ApnEditor;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.wifi.WlanRiskInfo;
import com.android.settingslib.R;
import com.android.settingslib.flags.Flags;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: WifiUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/android/settingslib/wifi/WifiUtils;", "", "()V", "Companion", "InternetIconInjector", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class WifiUtils {
    public static final String ACTION_WIFI_DETAILS_SETTINGS = "android.settings.WIFI_DETAILS_SETTINGS";
    public static final String ACTION_WIFI_DIALOG = null;
    public static final Companion Companion = null;
    public static final String DIALOG_WINDOW_TYPE = "dialog_window_type";
    public static final String EXTRA_CHOSEN_WIFI_ENTRY_KEY = null;
    public static final String EXTRA_CONNECT_FOR_CALLER = null;
    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":settings:show_fragment_args";
    private static final int INVALID_RSSI = -127;
    public static final String KEY_CHOSEN_WIFIENTRY_KEY = "key_chosen_wifientry_key";
    private static final int[] NO_INTERNET_WIFI_PIE = null;
    public static final String SSID = "ssid";
    private static final String TAG = "WifiUtils";
    private static final int[] WIFI_4_PIE = null;
    private static final int[] WIFI_5_PIE = null;
    private static final int[] WIFI_6_PIE = null;
    private static final int[] WIFI_7_PIE = null;
    public static final int[] WIFI_PIE = null;

    /* JADX INFO: compiled from: WifiUtils.kt */
    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J.\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020%0,H\u0007JY\u0010$\u001a\u00020-2\u0006\u0010&\u001a\u00020'2\u0006\u0010.\u001a\u00020/2\u0006\u0010*\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u000e2!\u00101\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020%022\f\u0010+\u001a\b\u0012\u0004\u0012\u00020%0,H\u0007J\b\u00107\u001a\u00020\u0011H\u0002J\u0010\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0007J\b\u0010:\u001a\u00020\u0011H\u0002J\u0018\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020>H\u0007J \u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000eH\u0007J\u0018\u0010@\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'2\u0006\u0010\"\u001a\u00020#H\u0007J$\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020C2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020F0EH\u0002J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0007J\u0012\u0010H\u001a\u0002032\b\u0010I\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010J\u001a\u0002032\b\u0010I\u001a\u0004\u0018\u00010\u00042\u0006\u0010K\u001a\u00020>H\u0007J\u0018\u0010L\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'2\u0006\u0010M\u001a\u00020\u000eH\u0007J\u0010\u0010N\u001a\u00020>2\u0006\u0010\"\u001a\u00020#H\u0007J*\u0010O\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0006\u0010B\u001a\u00020C2\b\u0010P\u001a\u0004\u0018\u00010\u00042\u0006\u0010Q\u001a\u00020RH\u0007J\u0015\u0010S\u001a\u00020>*\u00020TH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010UR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0010\u0010\u001e\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006V"}, d2 = {"Lcom/android/settingslib/wifi/WifiUtils$Companion;", "", "()V", "ACTION_WIFI_DETAILS_SETTINGS", "", "ACTION_WIFI_DIALOG", "getACTION_WIFI_DIALOG$annotations", "DIALOG_WINDOW_TYPE", "EXTRA_CHOSEN_WIFI_ENTRY_KEY", "getEXTRA_CHOSEN_WIFI_ENTRY_KEY$annotations", "EXTRA_CONNECT_FOR_CALLER", "getEXTRA_CONNECT_FOR_CALLER$annotations", "EXTRA_SHOW_FRAGMENT_ARGUMENTS", "INVALID_RSSI", "", "KEY_CHOSEN_WIFIENTRY_KEY", "NO_INTERNET_WIFI_PIE", "", "getNO_INTERNET_WIFI_PIE", "()[I", "SSID", "TAG", "WIFI_4_PIE", "getWIFI_4_PIE", "WIFI_5_PIE", "getWIFI_5_PIE", "WIFI_6_PIE", "getWIFI_6_PIE", "WIFI_7_PIE", "getWIFI_7_PIE", "WIFI_PIE", "buildLoggingSummary", "accessPoint", "Lcom/android/settingslib/wifi/AccessPoint;", "config", "Landroid/net/wifi/WifiConfiguration;", "checkWepAllowed", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "ssid", "onAllowed", "Lkotlin/Function0;", "Lkotlinx/coroutines/Job;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "dialogWindowType", "onStartActivity", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "getErrorIconsBasedOnFlag", "getHotspotIconResource", "deviceType", "getIconsBasedOnFlag", "getInternetIconResource", "level", "noInternet", "", "standard", "getMeteredLabel", "getSpecificApSpeed", "result", "Landroid/net/wifi/ScanResult;", "scoredNetworkCache", "", "Lcom/android/settingslib/wifi/TimestampedScoredNetwork;", "getVisibilityStatus", "getWifiDetailsSettingsIntent", "key", "getWifiDialogIntent", "connectForCaller", "getWifiTetherSummaryForConnectedDevices", "connectedDevices", "isMeteredOverridden", "verboseScanResultSummary", WlanRiskInfo.EXTRA_BSSID, "nowMs", "", "queryWepAllowed", "Landroid/net/wifi/WifiManager;", "(Landroid/net/wifi/WifiManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getACTION_WIFI_DIALOG$annotations() {
        }

        public static /* synthetic */ void getEXTRA_CHOSEN_WIFI_ENTRY_KEY$annotations() {
        }

        public static /* synthetic */ void getEXTRA_CONNECT_FOR_CALLER$annotations() {
        }

        private Companion() {
        }

        public static final /* synthetic */ int[] access$getErrorIconsBasedOnFlag(Companion r0) {
            return r0.getErrorIconsBasedOnFlag();
        }

        public static final /* synthetic */ int[] access$getIconsBasedOnFlag(Companion r0) {
            return r0.getIconsBasedOnFlag();
        }

        public static final /* synthetic */ Object access$queryWepAllowed(Companion r0, WifiManager r1, Continuation r2) {
            return r0.queryWepAllowed(r1, r2);
        }

        private final int[] getIconsBasedOnFlag() {
            if (Flags.newStatusBarIcons() == false) goto L6;
            return new int[]{R.drawable.ic_wifi_0, R.drawable.ic_wifi_1, R.drawable.ic_wifi_2, R.drawable.ic_wifi_3, R.drawable.ic_wifi_4};
        L6:
            return new int[]{android.R.drawable.pointer_vertical_double_arrow_vector_icon, android.R.drawable.pointer_vertical_text, android.R.drawable.pointer_vertical_text_icon, android.R.drawable.pointer_vertical_text_large, android.R.drawable.pointer_vertical_text_large_icon};
        }

        public final int[] getNO_INTERNET_WIFI_PIE() {
            return WifiUtils.access$getNO_INTERNET_WIFI_PIE$cp();
        }

        private final int[] getErrorIconsBasedOnFlag() {
            if (Flags.newStatusBarIcons() == false) goto L6;
            return new int[]{R.drawable.ic_wifi_0_error, R.drawable.ic_wifi_1_error, R.drawable.ic_wifi_2_error, R.drawable.ic_wifi_3_error, R.drawable.ic_wifi_4_error};
        L6:
            return new int[]{R.drawable.ic_no_internet_wifi_signal_0, R.drawable.ic_no_internet_wifi_signal_1, R.drawable.ic_no_internet_wifi_signal_2, R.drawable.ic_no_internet_wifi_signal_3, R.drawable.ic_no_internet_wifi_signal_4};
        }

        public final int[] getWIFI_4_PIE() {
            return WifiUtils.access$getWIFI_4_PIE$cp();
        }

        public final int[] getWIFI_5_PIE() {
            return WifiUtils.access$getWIFI_5_PIE$cp();
        }

        public final int[] getWIFI_6_PIE() {
            return WifiUtils.access$getWIFI_6_PIE$cp();
        }

        public final int[] getWIFI_7_PIE() {
            return WifiUtils.access$getWIFI_7_PIE$cp();
        }

        @JvmStatic
        public final String buildLoggingSummary(AccessPoint r12, WifiConfiguration r13) {
            Intrinsics.checkNotNullParameter(r12, "accessPoint");
            StringBuilder r0 = new StringBuilder();
            WifiInfo r1 = r12.getInfo();
            if (r12.isActive() == false) goto L6;
            if (r1 == null) goto L6;
            r0.append(" f=" + r1.getFrequency());
        L6:
            r0.append(HanziToPinyin.Token.SEPARATOR + getVisibilityStatus(r12));
            if (r13 != null) goto L9;
        L17:
            if (r13 == null) goto L26;
            WifiConfiguration.NetworkSelectionStatus r11 = r13.getNetworkSelectionStatus();
            Intrinsics.checkNotNullExpressionValue(r11, "config.networkSelectionStatus");
            int r14 = WifiConfiguration.NetworkSelectionStatus.getMaxNetworkSelectionDisableReason();
            if (r14 < 0) goto L26;
            int r15 = 0;
        L22:
            if (r11.getDisableReasonCounter(r15) == 0) goto L24;
            r0.append(HanziToPinyin.Token.SEPARATOR).append(WifiConfiguration.NetworkSelectionStatus.getNetworkSelectionDisableReasonString(r15)).append("=").append(r11.getDisableReasonCounter(r15));
        L24:
            if (r15 == r14) goto L26;
            r15 = r15 + 1;
        L26:
            String r16 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r16, "summary.toString()");
            return r16;
        L9:
            if (r13.getNetworkSelectionStatus().getNetworkSelectionStatus() == 0) goto L17;
            r0.append(" (" + r13.getNetworkSelectionStatus().getNetworkStatusString());
            if (r13.getNetworkSelectionStatus().getDisableTime() <= 0) goto L16;
            long r17 = (System.currentTimeMillis() - r13.getNetworkSelectionStatus().getDisableTime()) / ((long) 1000);
            long r5 = 60;
            long r7 = r17 % r5;
            long r18 = (r17 / r5) % r5;
            long r9 = (r18 / r5) % r5;
            r0.append(", ");
            if (r9 <= 0) goto L15;
            r0.append(r9 + "h ");
        L15:
            r0.append(r18 + "m ");
            r0.append(r7 + "s ");
        L16:
            r0.append(")");
            goto L17
        }

        @JvmStatic
        public final String getVisibilityStatus(AccessPoint r22) {
            Intrinsics.checkNotNullParameter(r22, "accessPoint");
            WifiInfo r0 = r22.getInfo();
            StringBuilder r8 = new StringBuilder();
            StringBuilder r9 = new StringBuilder();
            StringBuilder r10 = new StringBuilder();
            StringBuilder r11 = new StringBuilder();
            int r2 = 0;
            if (r22.isActive() == false) goto L12;
            if (r0 == null) goto L12;
            String r1 = r0.getBSSID();
            if (r1 == null) goto L8;
            r8.append(HanziToPinyin.Token.SEPARATOR).append(r1);
        L8:
            r8.append(" standard = ").append(r0.getWifiStandard());
            r8.append(" rssi=").append(r0.getRssi());
            r8.append("  score=");
            r8.append(r0.getScore());
            if (r22.getSpeed() == 0) goto L11;
            r8.append(" speed=").append(r22.getSpeedLabel());
        L11:
            StringCompanionObject r3 = StringCompanionObject.INSTANCE;
            String r4 = String.format(" tx=%.1f,", Arrays.copyOf(new Object[]{Double.valueOf(r0.getSuccessfulTxPacketsPerSecond())}, 1));
            Intrinsics.checkNotNullExpressionValue(r4, "format(format, *args)");
            r8.append(r4);
            StringCompanionObject r5 = StringCompanionObject.INSTANCE;
            String r6 = String.format("%.1f,", Arrays.copyOf(new Object[]{Double.valueOf(r0.getRetriedTxPacketsPerSecond())}, 1));
            Intrinsics.checkNotNullExpressionValue(r6, "format(format, *args)");
            r8.append(r6);
            StringCompanionObject r7 = StringCompanionObject.INSTANCE;
            String r12 = String.format("%.1f ", Arrays.copyOf(new Object[]{Double.valueOf(r0.getLostTxPacketsPerSecond())}, 1));
            Intrinsics.checkNotNullExpressionValue(r12, "format(format, *args)");
            r8.append(r12);
            StringCompanionObject r13 = StringCompanionObject.INSTANCE;
            String r14 = String.format("rx=%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r0.getSuccessfulRxPacketsPerSecond())}, 1));
            Intrinsics.checkNotNullExpressionValue(r14, "format(format, *args)");
            r8.append(r14);
        L13:
            String r15 = r1;
            long r16 = SystemClock.elapsedRealtime();
            Iterator<ScanResult> r17 = r22.getScanResults().iterator();
            int r18 = -127;
            int r19 = -127;
            int r110 = -127;
            int r20 = 0;
            int r21 = 0;
        L14:
            int r111 = r2;
            if (r17.hasNext() == false) goto L56;
            ScanResult r23 = r17.next();
            if (r23 != null) goto L20;
            int r24 = r21;
            StringBuilder r112 = r8;
            Iterator<ScanResult> r113 = r17;
            int r25 = r111;
            int r114 = r19;
        L19:
            StringBuilder r115 = r10;
            int r116 = r20;
        L54:
            r21 = r24;
            r2 = r25;
            r20 = r116;
            r19 = r114;
            r10 = r115;
            r17 = r113;
            r8 = r112;
            r18 = r18;
            goto L14
        L20:
            int r117 = r21;
            if (r23.frequency >= 4900) goto L23;
        L33:
            r112 = r8;
            r25 = r111;
            r24 = r117;
            r113 = r17;
            r114 = r19;
            if (r23.frequency >= 2400) goto L36;
        L44:
            r18 = r18;
            r115 = r10;
            r116 = r20;
            if (r23.frequency < 58320) goto L54;
            if (r23.frequency > 70200) goto L54;
            r25 = r25 + 1;
            if (r23.level <= r114) goto L52;
            r114 = r23.level;
        L52:
            if (r25 > 4) goto L54;
            r11.append(verboseScanResultSummary(r22, r23, r15, r16));
            goto L54
        L36:
            if (r23.frequency > 2500) goto L44;
            r24 = r24 + 1;
            if (r23.level <= r110) goto L41;
            r110 = r23.level;
        L41:
            if (r24 > 4) goto L19;
            r18 = r18;
            r115 = r10;
            r116 = r20;
            r9.append(verboseScanResultSummary(r22, r23, r15, r16));
            goto L54
        L23:
            if (r23.frequency > 5900) goto L33;
            int r26 = r20 + 1;
            if (r23.level <= r18) goto L27;
            int r118 = r23.level;
        L29:
            if (r26 > 4) goto L31;
            int r27 = r111;
            r10.append(verboseScanResultSummary(r22, r23, r15, r16));
        L32:
            r21 = r117;
            r2 = r27;
            r19 = r19;
            r20 = r26;
            r18 = r118;
            r17 = r17;
            r8 = r8;
            goto L14
        L31:
            r27 = r111;
            goto L32
        L27:
            r118 = r18;
            goto L29
        L56:
            int r28 = r21;
            int r29 = r18;
            int r119 = r19;
            StringBuilder r120 = r8;
            StringBuilder r121 = r10;
            int r122 = r20;
            r120.append(" [");
            if (r28 <= 0) goto L62;
            r120.append("(").append(r28).append(")");
            if (r28 <= 4) goto L61;
            r120.append("max=").append(r110).append(",");
        L61:
            r120.append(r9.toString());
        L62:
            r120.append(";");
            if (r122 <= 0) goto L68;
            r120.append("(").append(r122).append(")");
            if (r122 <= 4) goto L67;
            r120.append("max=").append(r29).append(",");
        L67:
            r120.append(r121.toString());
        L68:
            r120.append(";");
            if (r111 <= 0) goto L74;
            r120.append("(").append(r111).append(")");
            if (r111 <= 4) goto L73;
            r120.append("max=").append(r119).append(",");
        L73:
            r120.append(r11.toString());
        L74:
            r120.append("]");
            String r30 = r120.toString();
            Intrinsics.checkNotNullExpressionValue(r30, "visibility.toString()");
            return r30;
        L12:
            r1 = null;
            goto L13
        }

        @JvmStatic
        public final String verboseScanResultSummary(AccessPoint r4, ScanResult r5, String r6, long r7) {
            Intrinsics.checkNotNullParameter(r4, "accessPoint");
            Intrinsics.checkNotNullParameter(r5, "result");
            StringBuilder r0 = new StringBuilder(" \n{");
            r0.append(r5.BSSID);
            if (Intrinsics.areEqual(r5.BSSID, r6) == false) goto L5;
            r0.append(ApnEditor.APN_TYPE_ALL);
        L5:
            r0.append("=").append(r5.frequency);
            r0.append(",").append(r5.level);
            Map<String, TimestampedScoredNetwork> r1 = r4.getScoredNetworkCache();
            Intrinsics.checkNotNullExpressionValue(r1, "accessPoint.scoredNetworkCache");
            int r3 = getSpecificApSpeed(r5, r1);
            if (r3 == 0) goto L8;
            r0.append(",").append(r4.getSpeedLabel(r3));
        L8:
            int r8 = ((int) (r7 - (r5.timestamp / ((long) 1000)))) / 1000;
            r0.append(",").append(r8).append("s}");
            String r9 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r9, "stringBuilder.toString()");
            return r9;
        }

        private final int getSpecificApSpeed(ScanResult r1, Map<String, ? extends TimestampedScoredNetwork> r2) {
            TimestampedScoredNetwork r0 = r2.get(r1.BSSID);
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getScore().calculateBadge(r1.level);
        }

        @JvmStatic
        public final String getMeteredLabel(Context r3, WifiConfiguration r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "config");
            if (r4.meteredOverride != 1) goto L5;
        L10:
            String r2 = r3.getString(R.string.wifi_metered_label);
            Intrinsics.checkNotNullExpressionValue(r2, "{\n                contex…ered_label)\n            }");
            return r2;
        L5:
            if (r4.meteredHint == true) goto L7;
        L9:
            String r5 = r3.getString(R.string.wifi_unmetered_label);
            Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.string.wifi_unmetered_label)");
            return r5;
        L7:
            if (isMeteredOverridden(r4) == true) goto L9;
            goto L9
        }

        @JvmStatic
        public final int getInternetIconResource(int r2, boolean r3) {
            return getInternetIconResource(r2, r3, 0);
        }

        @JvmStatic
        public final int getInternetIconResource(int r4, boolean r5, int r6) {
            if (r4 >= 0) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(WifiUtils.TAG, "Wi-Fi level is out of range! level:" + r4);
            r4 = 0;
        L8:
            if (r5 == false) goto L12;
            return getNO_INTERNET_WIFI_PIE()[r4];
        L12:
            if (r6 == 4) goto L24;
            if (r6 == 5) goto L28;
            if (r6 == 6) goto L27;
            if (r6 == 8) goto L26;
            return WifiUtils.WIFI_PIE[r4];
        L26:
            return getWIFI_7_PIE()[r4];
        L27:
            return getWIFI_6_PIE()[r4];
        L28:
            return getWIFI_5_PIE()[r4];
        L24:
            return getWIFI_4_PIE()[r4];
        L6:
            if (r4 < WifiUtils.WIFI_PIE.length) goto L8;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(WifiUtils.TAG, "Wi-Fi level is out of range! level:" + r4);
            r4 = WifiUtils.WIFI_PIE.length - 1;
            goto L8
        }

        @JvmStatic
        public final int getHotspotIconResource(int r1) {
            if (r1 == 1) goto L18;
            if (r1 == 2) goto L23;
            if (r1 == 3) goto L22;
            if (r1 == 4) goto L21;
            if (r1 == 5) goto L20;
            return R.drawable.ic_hotspot_phone;
        L20:
            return R.drawable.ic_hotspot_auto;
        L21:
            return R.drawable.ic_hotspot_watch;
        L22:
            return R.drawable.ic_hotspot_laptop;
        L23:
            return R.drawable.ic_hotspot_tablet;
        L18:
            return R.drawable.ic_hotspot_phone;
        }

        @JvmStatic
        public final boolean isMeteredOverridden(WifiConfiguration r1) {
            Intrinsics.checkNotNullParameter(r1, "config");
            if (r1.meteredOverride == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public final Intent getWifiDialogIntent(String r2, boolean r3) {
            Intent r1 = new Intent(WifiUtils.ACTION_WIFI_DIALOG);
            r1.putExtra(WifiUtils.EXTRA_CHOSEN_WIFI_ENTRY_KEY, r2);
            r1.putExtra(WifiUtils.EXTRA_CONNECT_FOR_CALLER, r3);
            return r1;
        }

        @JvmStatic
        public final Intent getWifiDetailsSettingsIntent(String r3) {
            Intent r2 = new Intent(WifiUtils.ACTION_WIFI_DETAILS_SETTINGS);
            Bundle r0 = new Bundle();
            r0.putString("key_chosen_wifientry_key", r3);
            r2.putExtra(":settings:show_fragment_args", r0);
            return r2;
        }

        @JvmStatic
        public final String getWifiTetherSummaryForConnectedDevices(Context r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            MessageFormat r1 = new MessageFormat(r2.getResources().getString(R.string.wifi_tether_connected_summary), Locale.getDefault());
            HashMap r4 = new HashMap();
            r4.put("count", Integer.valueOf(r3));
            String r5 = r1.format(r4);
            Intrinsics.checkNotNullExpressionValue(r5, "msgFormat.format(arguments)");
            return r5;
        }

        @JvmStatic
        public final void checkWepAllowed(final Context r8, LifecycleOwner r9, String r10, Function0<Unit> r11) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r10, "ssid");
            Intrinsics.checkNotNullParameter(r11, "onAllowed");
            checkWepAllowed(r8, LifecycleOwnerKt.getLifecycleScope(r9), r10, 1, new WifiUtils$Companion$checkWepAllowed$1(r8), r11);
        }

        @JvmStatic
        public final Job checkWepAllowed(Context r10, CoroutineScope r11, String r12, int r13, Function1<? super Intent, Unit> r14, Function0<Unit> r15) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "coroutineScope");
            Intrinsics.checkNotNullParameter(r12, "ssid");
            Intrinsics.checkNotNullParameter(r14, "onStartActivity");
            Intrinsics.checkNotNullParameter(r15, "onAllowed");
            return BuildersKt.launch$default(r11, null, null, new WifiUtils$Companion$checkWepAllowed$2(r10, r15, r14, r13, r12, null), 3, null);
        }

        private final Object queryWepAllowed(WifiManager r3, Continuation<? super Boolean> r4) {
            return BuildersKt.withContext(Dispatchers.getDefault(), new WifiUtils$Companion$queryWepAllowed$2(r3, null), r4);
        }
    }

    /* JADX INFO: compiled from: WifiUtils.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/android/settingslib/wifi/WifiUtils$InternetIconInjector;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getIcon", "Landroid/graphics/drawable/Drawable;", "noInternet", "", "level", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class InternetIconInjector {
        private final Context context;

        public InternetIconInjector(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
        }

        protected final Context getContext() {
            return this.context;
        }

        public Drawable getIcon(boolean r2, int r3) {
            return this.context.getDrawable(WifiUtils.Companion.getInternetIconResource(r3, r2));
        }
    }

    @JvmStatic
    public static final String buildLoggingSummary(AccessPoint r1, WifiConfiguration r2) {
        return Companion.buildLoggingSummary(r1, r2);
    }

    @JvmStatic
    public static final Job checkWepAllowed(Context r7, CoroutineScope r8, String r9, int r10, Function1<? super Intent, Unit> r11, Function0<Unit> r12) {
        return Companion.checkWepAllowed(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final void checkWepAllowed(Context r1, LifecycleOwner r2, String r3, Function0<Unit> r4) {
        Companion.checkWepAllowed(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final int getHotspotIconResource(int r1) {
        return Companion.getHotspotIconResource(r1);
    }

    @JvmStatic
    public static final int getInternetIconResource(int r1, boolean r2) {
        return Companion.getInternetIconResource(r1, r2);
    }

    @JvmStatic
    public static final int getInternetIconResource(int r1, boolean r2, int r3) {
        return Companion.getInternetIconResource(r1, r2, r3);
    }

    @JvmStatic
    public static final String getMeteredLabel(Context r1, WifiConfiguration r2) {
        return Companion.getMeteredLabel(r1, r2);
    }

    @JvmStatic
    public static final String getVisibilityStatus(AccessPoint r1) {
        return Companion.getVisibilityStatus(r1);
    }

    @JvmStatic
    public static final Intent getWifiDetailsSettingsIntent(String r1) {
        return Companion.getWifiDetailsSettingsIntent(r1);
    }

    @JvmStatic
    public static final Intent getWifiDialogIntent(String r1, boolean r2) {
        return Companion.getWifiDialogIntent(r1, r2);
    }

    @JvmStatic
    public static final String getWifiTetherSummaryForConnectedDevices(Context r1, int r2) {
        return Companion.getWifiTetherSummaryForConnectedDevices(r1, r2);
    }

    @JvmStatic
    public static final boolean isMeteredOverridden(WifiConfiguration r1) {
        return Companion.isMeteredOverridden(r1);
    }

    @JvmStatic
    public static final String verboseScanResultSummary(AccessPoint r6, ScanResult r7, String r8, long r9) {
        return Companion.verboseScanResultSummary(r6, r7, r8, r9);
    }

    public WifiUtils() {
    }

    public static final /* synthetic */ int[] access$getNO_INTERNET_WIFI_PIE$cp() {
        return NO_INTERNET_WIFI_PIE;
    }

    public static final /* synthetic */ int[] access$getWIFI_4_PIE$cp() {
        return WIFI_4_PIE;
    }

    public static final /* synthetic */ int[] access$getWIFI_5_PIE$cp() {
        return WIFI_5_PIE;
    }

    public static final /* synthetic */ int[] access$getWIFI_6_PIE$cp() {
        return WIFI_6_PIE;
    }

    public static final /* synthetic */ int[] access$getWIFI_7_PIE$cp() {
        return WIFI_7_PIE;
    }

    static {
        Companion r0 = new Companion(null);
        Companion = r0;
        ACTION_WIFI_DIALOG = "com.android.settings.WIFI_DIALOG";
        EXTRA_CHOSEN_WIFI_ENTRY_KEY = "key_chosen_wifientry_key";
        EXTRA_CONNECT_FOR_CALLER = "connect_for_caller";
        WIFI_PIE = Companion.access$getIconsBasedOnFlag(r0);
        NO_INTERNET_WIFI_PIE = Companion.access$getErrorIconsBasedOnFlag(r0);
        WIFI_4_PIE = new int[]{android.R.drawable.pointer_text_large_icon, android.R.drawable.pointer_text_vector, android.R.drawable.pointer_text_vector_icon, android.R.drawable.pointer_top_left_diagonal_double_arrow, android.R.drawable.pointer_top_left_diagonal_double_arrow_icon};
        WIFI_5_PIE = new int[]{android.R.drawable.pointer_top_left_diagonal_double_arrow_large, android.R.drawable.pointer_top_left_diagonal_double_arrow_large_icon, android.R.drawable.pointer_top_left_diagonal_double_arrow_vector, android.R.drawable.pointer_top_left_diagonal_double_arrow_vector_icon, android.R.drawable.pointer_top_right_diagonal_double_arrow};
        WIFI_6_PIE = new int[]{android.R.drawable.pointer_top_right_diagonal_double_arrow_icon, android.R.drawable.pointer_top_right_diagonal_double_arrow_large, android.R.drawable.pointer_top_right_diagonal_double_arrow_large_icon, android.R.drawable.pointer_top_right_diagonal_double_arrow_vector, android.R.drawable.pointer_top_right_diagonal_double_arrow_vector_icon};
        WIFI_7_PIE = new int[]{android.R.drawable.pointer_vertical_double_arrow, android.R.drawable.pointer_vertical_double_arrow_icon, android.R.drawable.pointer_vertical_double_arrow_large, android.R.drawable.pointer_vertical_double_arrow_large_icon, android.R.drawable.pointer_vertical_double_arrow_vector};
    }
}
