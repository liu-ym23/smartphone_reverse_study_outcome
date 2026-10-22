package com.android.settings;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiManager;

/* JADX INFO: loaded from: classes2.dex */
public class AdaptWifi {
    public static final int WIFI_MANAGER_ERROR_AUTH_FAILURE_NONE = 0;
    public static final int WIFI_MANAGER_ERROR_AUTH_FAILURE_WRONG_PSWD = 2;
    public static final String WIFI_MANAGER_EXTRA_SUPPLICANT_ERROR_REASON = "supplicantErrorReason";
    public static final String WIFI_SAVED_STATE = "wifi_saved_state";

    /* JADX INFO: renamed from: com.android.settings.AdaptWifi$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$net$wifi$SupplicantState = null;

        static {
            int[] r0 = new int[SupplicantState.values().length];
            $SwitchMap$android$net$wifi$SupplicantState = r0;
            r0[SupplicantState.AUTHENTICATING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.ASSOCIATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.ASSOCIATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.FOUR_WAY_HANDSHAKE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.GROUP_HANDSHAKE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.DISCONNECTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INTERFACE_DISABLED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INACTIVE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.SCANNING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.DORMANT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.UNINITIALIZED.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$android$net$wifi$SupplicantState[SupplicantState.INVALID.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    public static String getSecurityWapiPskValue() {
        return "WAPI-PSK";
    }

    public AdaptWifi() {
    }

    public static String getWifiTetherConfigureSSIDDefault(Context r1) {
        return r1.getString(R.string.wifi_tether_configure_ssid_default);
    }

    public static boolean isHandshakeState(SupplicantState r1) {
        switch(AnonymousClass1.$SwitchMap$android$net$wifi$SupplicantState[r1.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L8:
        return true;
    L5:
        throw new IllegalArgumentException("Unknown supplicant state");
    }

    public static boolean is5GHzBandSupported(WifiManager r0) {
        return r0.is5GHzBandSupported();
    }

    public static boolean readWifiVerboseLoggingOptions(WifiManager r0) {
        return r0.isVerboseLoggingEnabled();
    }

    public static void writeWifiVerboseLoggingOptions(WifiManager r0, boolean r1) {
        r0.setVerboseLoggingEnabled(r1);
    }

    public static boolean getWifiStaSapConcurrency(WifiManager r0) {
        return r0.isStaApConcurrencySupported();
    }
}
