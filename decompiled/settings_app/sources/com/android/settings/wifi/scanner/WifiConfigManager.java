package com.android.settings.wifi.scanner;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class WifiConfigManager extends AsyncTask<WifiParsedResult, Object, Object> {
    private static final Pattern HEX_DIGITS = null;
    private static final String TAG = "WifiConfigManager";
    private final WifiManager wifiManager;

    /* JADX INFO: renamed from: com.android.settings.wifi.scanner.WifiConfigManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$wifi$scanner$NetworkType = null;

        static {
            int[] r0 = new int[NetworkType.values().length];
            $SwitchMap$com$android$settings$wifi$scanner$NetworkType = r0;
            r0[NetworkType.WEP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$wifi$scanner$NetworkType[NetworkType.WPA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$wifi$scanner$NetworkType[NetworkType.SAE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$wifi$scanner$NetworkType[NetworkType.WPA2_EAP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Object doInBackground(WifiParsedResult[] r1) {
        return doInBackground2(r1);
    }

    static {
        HEX_DIGITS = Pattern.compile("[0-9A-Fa-f]+");
    }

    public WifiConfigManager(WifiManager r1) {
        this.wifiManager = r1;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Object doInBackground2(WifiParsedResult... r7) {
        int r0 = 0;
        WifiParsedResult r8 = r7[0];
        if (this.wifiManager.isWifiEnabled() == true) goto L18;
        String r1 = TAG;
        OLog.i(r1, "Enabling wi-fi...");
        if (this.wifiManager.setWifiEnabled(true) == false) goto L16;
        OLog.i(r1, "Wi-fi enabled");
    L8:
        if (this.wifiManager.isWifiEnabled() == true) goto L18;
        if (r0 >= 10) goto L11;
        OLog.i(TAG, "Still waiting for wi-fi to enable...");
        Thread.sleep(1000);     // Catch: InterruptedException -> L43
    L15:
        r0 = r0 + 1;
        goto L8
    L11:
        OLog.i(TAG, "Took too long to enable wi-fi, quitting");
        return null;
    L16:
        OLog.w(r1, "Wi-fi could not be enabled!");
        return null;
    L18:
        String r2 = r8.getNetworkEncryption();
        NetworkType r3 = NetworkType.forIntentValue(r2);     // Catch: IllegalArgumentException -> L41
        if (r3 != NetworkType.NO_PASSWORD) goto L23;
        changeNetworkUnEncrypted(this.wifiManager, r8);
    L40:
        return null;
    L23:
        String r4 = r8.getPassword();
        if (r4 == null) goto L40;
        if (r4.isEmpty() == true) goto L40;
        int r5 = AnonymousClass1.$SwitchMap$com$android$settings$wifi$scanner$NetworkType[r3.ordinal()];
        if (r5 != 1) goto L30;
        changeNetworkWEP(this.wifiManager, r8);
        goto L40
    L30:
        if (r5 != 2) goto L32;
        changeNetworkWPA(this.wifiManager, r8);
        goto L40
    L32:
        if (r5 != 3) goto L34;
        changeNetworkSAE(this.wifiManager, r8);
        goto L40
    L34:
        if (r5 != 4) goto L40;
        changeNetworkWPA2EAP(this.wifiManager, r8);
    L41:
        OLog.w(TAG, "Bad network type; see NetworkType values: " + r2);
        return null;
    }

    private static void updateNetwork(WifiManager r4, WifiConfiguration r5) {
        Integer r0 = findNetworkInExistingConfig(r4, r5.SSID);
        if (r0 == null) goto L5;
        OLog.i(TAG, "Removing old configuration for network " + r5.SSID);
        r4.removeNetwork(r0.intValue());
        r4.saveConfiguration();
    L5:
        int r1 = r4.addNetwork(r5);
        if (r1 >= 0) goto L8;
        OLog.w(TAG, "Unable to add network " + r5.SSID);
        return;
    L8:
        if (r4.enableNetwork(r1, true) == false) goto L10;
        OLog.i(TAG, "Associating to network " + r5.SSID);
        r4.saveConfiguration();
        return;
    L10:
        OLog.w(TAG, "Failed to enable network " + r5.SSID);
    }

    private static WifiConfiguration changeNetworkCommon(WifiParsedResult r2) {
        WifiConfiguration r0 = new WifiConfiguration();
        r0.allowedAuthAlgorithms.clear();
        r0.allowedGroupCiphers.clear();
        r0.allowedKeyManagement.clear();
        r0.allowedPairwiseCiphers.clear();
        r0.allowedProtocols.clear();
        r0.SSID = convertToQuotedString(r2.getSsid());
        r0.hiddenSSID = r2.isHidden();
        return r0;
    }

    private static void changeNetworkWEP(WifiManager r5, WifiParsedResult r6) {
        WifiConfiguration r0 = changeNetworkCommon(r6);
        r0.wepKeys[0] = quoteNonHex(r6.getPassword(), new int[]{10, 26, 58});
        r0.wepTxKeyIndex = 0;
        r0.allowedAuthAlgorithms.set(1);
        r0.allowedKeyManagement.set(0);
        r0.allowedGroupCiphers.set(2);
        r0.allowedGroupCiphers.set(3);
        r0.allowedGroupCiphers.set(0);
        r0.allowedGroupCiphers.set(1);
        r0.setSecurityParams(1);
        updateNetwork(r5, r0);
    }

    private static void changeNetworkWPA(WifiManager r5, WifiParsedResult r6) {
        WifiConfiguration r0 = changeNetworkCommon(r6);
        r0.preSharedKey = quoteNonHex(r6.getPassword(), new int[]{64});
        r0.allowedAuthAlgorithms.set(0);
        r0.allowedProtocols.set(0);
        r0.allowedProtocols.set(1);
        r0.allowedKeyManagement.set(1);
        r0.allowedKeyManagement.set(2);
        r0.allowedPairwiseCiphers.set(1);
        r0.allowedPairwiseCiphers.set(2);
        r0.allowedGroupCiphers.set(2);
        r0.allowedGroupCiphers.set(3);
        r0.setSecurityParams(2);
        updateNetwork(r5, r0);
    }

    private static void changeNetworkSAE(WifiManager r4, WifiParsedResult r5) {
        WifiConfiguration r0 = changeNetworkCommon(r5);
        r0.preSharedKey = quoteNonHex(r5.getPassword(), new int[]{64});
        r0.setSecurityParams(4);
        updateNetwork(r4, r0);
    }

    private static void changeNetworkWPA2EAP(WifiManager r6, WifiParsedResult r7) {
        WifiConfiguration r0 = changeNetworkCommon(r7);
        r0.preSharedKey = quoteNonHex(r7.getPassword(), new int[]{64});
        r0.allowedAuthAlgorithms.set(0);
        r0.allowedProtocols.set(1);
        r0.allowedKeyManagement.set(2);
        r0.allowedPairwiseCiphers.set(1);
        r0.allowedPairwiseCiphers.set(2);
        r0.allowedGroupCiphers.set(2);
        r0.allowedGroupCiphers.set(3);
        r0.enterpriseConfig.setIdentity(r7.getIdentity());
        r0.enterpriseConfig.setAnonymousIdentity(r7.getAnonymousIdentity());
        r0.enterpriseConfig.setPassword(r7.getPassword());
        r0.enterpriseConfig.setEapMethod(parseEap(r7.getEapMethod()));
        r0.enterpriseConfig.setPhase2Method(parsePhase2(r7.getPhase2Method()));
        updateNetwork(r6, r0);
    }

    private static void changeNetworkUnEncrypted(WifiManager r2, WifiParsedResult r3) {
        WifiConfiguration r4 = changeNetworkCommon(r3);
        r4.allowedKeyManagement.set(0);
        r4.setSecurityParams(0);
        updateNetwork(r2, r4);
    }

    private static Integer findNetworkInExistingConfig(WifiManager r2, String r3) {
        List<WifiConfiguration> r4 = r2.getConfiguredNetworks();
        if (r4 == null) goto L13;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L21;
        WifiConfiguration r0 = (WifiConfiguration) r5.next();
        String r1 = r0.SSID;
        if (r1 == null) goto L6;
        if (r1.equals(r3) == false) goto L6;
        return Integer.valueOf(r0.networkId);
    L21:
        return null;
    L13:
        return null;
    }

    private static String quoteNonHex(String r0, int... r1) {
        if (isHexOfLength(r0, r1) == false) goto L6;
        return r0;
    L6:
        return convertToQuotedString(r0);
    }

    private static String convertToQuotedString(String r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == false) goto L7;
        return null;
    L7:
        if (r3.charAt(0) != '\"') goto L12;
        if (r3.charAt(r3.length() - 1) != '\"') goto L12;
        return r3;
    L12:
        return "\"" + r3 + '\"';
    }

    private static boolean isHexOfLength(CharSequence r6, int... r7) {
        if (r6 != null) goto L5;
    L16:
        return false;
    L5:
        if (HEX_DIGITS.matcher(r6).matches() == false) goto L16;
        if (r7.length != 0) goto L10;
        return true;
    L10:
        int r1 = r7.length;
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L16;
        if (r6.length() == r7[r3]) goto L14;
        r3 = r3 + 1;
        goto L11
    L14:
        return true;
    }

    private static int parseEap(String r6) {
        if (r6 != null) goto L5;
        return -1;
    L5:
        r6.hashCode();
        switch(r6.hashCode()) {
            case 79645: goto L25;
            case 83163: goto L21;
            case 2402104: goto L17;
            case 2451684: goto L13;
            case 2585607: goto L9;
            default: goto L7;
        };
    L7:
        byte r1 = -1;
    L28:
        switch(r1) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            default: goto L30;
        };
    L31:
        return 2;
    L32:
        return 0;
    L33:
        return -1;
    L34:
        return 1;
    L35:
        return 3;
    L30:
        throw new IllegalArgumentException("Unknown value for EAP method: " + r6);
    L9:
        if (r6.equals("TTLS") == false) goto L36;
        r1 = 4;
        goto L28
    L36:
        r1 = -1;
        goto L28
    L13:
        if (r6.equals("PEAP") == false) goto L37;
        r1 = 3;
        goto L28
    L37:
        r1 = -1;
        goto L28
    L17:
        if (r6.equals("NONE") == false) goto L38;
        r1 = 2;
        goto L28
    L38:
        r1 = -1;
        goto L28
    L21:
        if (r6.equals("TLS") == false) goto L39;
        r1 = 1;
        goto L28
    L39:
        r1 = -1;
        goto L28
    L25:
        if (r6.equals("PWD") == false) goto L40;
        r1 = 0;
        goto L28
    L40:
        r1 = -1;
        goto L28
    }

    private static int parsePhase2(String r7) {
        if (r7 != null) goto L5;
        return 0;
    L5:
        r7.hashCode();
        byte r6 = -1;
        switch(r7.hashCode()) {
            case -2011803142: goto L25;
            case -607533546: goto L21;
            case 70902: goto L17;
            case 78975: goto L13;
            case 2402104: goto L9;
            default: goto L28;
        };
    L28:
        switch(r6) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            default: goto L30;
        };
    L31:
        return 0;
    L32:
        return 1;
    L33:
        return 4;
    L34:
        return 3;
    L35:
        return 2;
    L30:
        throw new IllegalArgumentException("Unknown value for phase 2 method: " + r7);
    L9:
        if (r7.equals("NONE") == false) goto L28;
        r6 = 4;
        goto L28
    L13:
        if (r7.equals("PAP") == false) goto L28;
        r6 = 3;
        goto L28
    L17:
        if (r7.equals("GTC") == false) goto L28;
        r6 = 2;
        goto L28
    L21:
        if (r7.equals("MSCHAPV2") == false) goto L28;
        r6 = 1;
        goto L28
    L25:
        if (r7.equals("MSCHAP") == false) goto L28;
        r6 = 0;
        goto L28
    }
}
