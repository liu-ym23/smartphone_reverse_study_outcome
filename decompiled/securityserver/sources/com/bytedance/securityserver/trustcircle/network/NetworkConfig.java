package com.bytedance.securityserver.trustcircle.network;

import com.bytedance.securityserver.trustcircle.account.EnvBridgeImpl;

/* JADX INFO: loaded from: classes.dex */
public class NetworkConfig {
    public static String a(String r5) {
        byte r0 = 0;
        EnvBridgeImpl r2 = com.bytedance.securityserver.network.NetworkConfig.a().f55a;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        switch(r5.hashCode()) {
            case -1315244953: goto L48;
            case -788234847: goto L44;
            case -492752531: goto L40;
            case -251922300: goto L36;
            case 280681252: goto L32;
            case 280681253: goto L28;
            case 701487345: goto L24;
            case 985659698: goto L20;
            case 1443006360: goto L16;
            case 1579340478: goto L12;
            default: goto L10;
        };
    L10:
        r0 = -1;
    L50:
        switch(r0) {
            case 0: goto L89;
            case 1: goto L85;
            case 2: goto L81;
            case 3: goto L77;
            case 4: goto L73;
            case 5: goto L69;
            case 6: goto L65;
            case 7: goto L61;
            case 8: goto L57;
            case 9: goto L53;
            default: goto L51;
        };
    L51:
        return "unknown api";
    L53:
        if (r3 == false) goto L55;
        return "https://ocean-secret-boe.bytedance.net/api/account/device/cert/revoke";
    L55:
        return "https://ocean-secret.oceancloudapi.com/api/account/device/cert/revoke";
    L57:
        if (r3 == false) goto L59;
        return "https://ocean-secret-boe.bytedance.net/api/device/name/update";
    L59:
        return "https://ocean-secret.oceancloudapi.com/api/device/name/update";
    L61:
        if (r3 == false) goto L63;
        return "https://ocean-secret-boe.bytedance.net/api/trust/devices/list/get";
    L63:
        return "https://ocean-secret.oceancloudapi.com/api/trust/devices/list/get";
    L65:
        if (r3 == false) goto L67;
        return "https://ocean-secret-boe.bytedance.net/api/trust/circle/escrow/auth/init";
    L67:
        return "https://ocean-secret.oceancloudapi.com/api/trust/circle/escrow/auth/init";
    L69:
        if (r3 == false) goto L71;
        return "https://ocean-secret-boe.bytedance.net/api/trust/circle/escrow/auth/step2";
    L71:
        return "https://ocean-secret.oceancloudapi.com/api/trust/circle/escrow/auth/step2";
    L73:
        if (r3 == false) goto L75;
        return "https://ocean-secret-boe.bytedance.net/api/trust/circle/escrow/auth/step1";
    L75:
        return "https://ocean-secret.oceancloudapi.com/api/trust/circle/escrow/auth/step1";
    L77:
        if (r3 == false) goto L79;
        return "https://ocean-secret-boe.bytedance.net/api/trust/circle/escrow/list";
    L79:
        return "https://ocean-secret.oceancloudapi.com/api/trust/circle/escrow/list";
    L81:
        if (r3 == false) goto L83;
        return "https://ocean-secret-boe.bytedance.net/api/trust/devices/list/update";
    L83:
        return "https://ocean-secret.oceancloudapi.com/api/trust/devices/list/update";
    L85:
        if (r3 == false) goto L87;
        return "https://ocean-secret-boe.bytedance.net/api/account/device/cert/issue";
    L87:
        return "https://ocean-secret.oceancloudapi.com/api/account/device/cert/issue";
    L89:
        if (r3 == false) goto L91;
        return "https://ocean-secret-boe.bytedance.net/api/trust/circle/escrow/upload";
    L91:
        return "https://ocean-secret.oceancloudapi.com/api/trust/circle/escrow/upload";
    L12:
        if (r5.equals("/api/account/device/cert/revoke") == false) goto L93;
        r0 = 9;
        goto L50
    L93:
        r0 = -1;
        goto L50
    L16:
        if (r5.equals("/api/device/name/update") == false) goto L94;
        r0 = 8;
        goto L50
    L94:
        r0 = -1;
        goto L50
    L20:
        if (r5.equals("/api/trust/devices/list/get") == false) goto L95;
        r0 = 7;
        goto L50
    L95:
        r0 = -1;
        goto L50
    L24:
        if (r5.equals("/api/trust/circle/escrow/auth/init") == false) goto L96;
        r0 = 6;
        goto L50
    L96:
        r0 = -1;
        goto L50
    L28:
        if (r5.equals("/api/trust/circle/escrow/auth/step2") == false) goto L97;
        r0 = 5;
        goto L50
    L97:
        r0 = -1;
        goto L50
    L32:
        if (r5.equals("/api/trust/circle/escrow/auth/step1") == false) goto L98;
        r0 = 4;
        goto L50
    L98:
        r0 = -1;
        goto L50
    L36:
        if (r5.equals("/api/trust/circle/escrow/list") == false) goto L99;
        r0 = 3;
        goto L50
    L99:
        r0 = -1;
        goto L50
    L40:
        if (r5.equals("/api/trust/devices/list/update") == false) goto L100;
        r0 = 2;
        goto L50
    L100:
        r0 = -1;
        goto L50
    L44:
        if (r5.equals("/api/account/device/cert/issue") == false) goto L101;
        r0 = 1;
        goto L50
    L101:
        r0 = -1;
        goto L50
    L48:
        if (r5.equals("/api/trust/circle/escrow/upload") == true) goto L50;
        r0 = -1;
        goto L50
    L5:
        if (r2.a() == false) goto L7;
        r3 = true;
        goto L9
    }
}
