package com.bytedance.securityserver.trustcircle;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.e2ee.E2EEManager;
import com.bytedance.security.e2ee.E2EEResult;
import com.bytedance.securityserver.network.ChallengeManager;
import com.bytedance.securityserver.trustcircle.account.EnvBridgeImpl;
import com.bytedance.securityserver.trustcircle.network.NetworkConfig;
import com.bytedance.securityserver.trustcircle.network.NetworkManager;
import com.bytedance.securityserver.trustcircle.network.NetworkRequest;
import com.bytedance.securityserver.trustcircle.network.NetworkResponse;
import com.bytedance.securityserver.utils.CryptoUtils;
import com.bytedance.securityserver.utils.GlobalContext;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ttnet.org.chromium.net.NetError;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class TrustCircleUtils {
    public static void a() {
        E2EEResult r0 = E2EEManager.getInstance().processCmd(GlobalContext.f82a, -487718897, "None".getBytes(StandardCharsets.UTF_8), new Bundle());
        r0.getResultCode();
        int r1 = r0.getResultCode();
        if (r1 != 0) goto L6;
        return;
    L6:
        throw new TrustCircleException(NetError.ERR_CERT_UNABLE_TO_CHECK_REVOCATION, a.a.e(r1, "clear trust circle data failed, code: "));
    }

    public static String b() {
        String r0 = GlobalVariable.f66a;
        if (r0 != null) goto L5;
    L6:
        E2EEManager r1 = E2EEManager.getInstance();
        Context r2 = GlobalContext.f82a;
        Charset r3 = StandardCharsets.UTF_8;
        E2EEResult r4 = r1.processCmd(r2, -487718900, "None".getBytes(r3), new Bundle());
        r4.getResultCode();
        if (r4.getResultCode() != 0) goto L11;
        String r5 = new String(r4.getOutData(), r3).replace("\n", "").replaceAll("(?i)(-----BEGIN CERTIFICATE-----)", "$1\\\\n").replaceAll("(?i)(-----END CERTIFICATE-----)", "\\\\n$1\\\\n");
        GlobalVariable.f66a = r5;
        return r5;
    L11:
        throw new TrustCircleException(-10, "export account cert chain from tee failed, code: " + r4.getResultCode());
    L5:
        if (r0.isEmpty() == true) goto L6;
        return r0;
    }

    public static Pair c() {
        E2EEResult r0 = E2EEManager.getInstance().processCmd(GlobalContext.f82a, -487718911, DataConverter.b(), new Bundle());
        r0.getResultCode();
        if (r0.getResultCode() != 0) goto L35;
        NetworkManager r1 = NetworkManager.c();
        NetworkRequest r2 = new NetworkRequest(NetworkConfig.a("/api/trust/devices/list/get"), new String(r0.getOutData(), StandardCharsets.UTF_8), b(), "x-ad-certchain");
        r1.getClass();
        NetworkResponse r3 = NetworkManager.b(r2);
        int r4 = r3.f79a;
        JsonObject r5 = null;
        if (r4 != 2001) goto L9;
        return new Pair(Boolean.TRUE, null);
    L9:
        if (r4 != 200) goto L32;
        JsonObject r6 = r3.f80d;
        if (e(r6) == false) goto L31;
        JsonObject r7 = r6.getAsJsonObject(WsConstants.KEY_PAYLOAD);
        if (r7 != null) goto L15;
    L24:
        Log.e("SecurityServer-DataConverter", "get payload item failed");
    L25:
        if (r5 == null) goto L29;
        return new Pair(Boolean.FALSE, r5);
    L29:
        throw new TrustCircleException(-3, "get trust_device_lists item failed");
    L15:
        if (r7.has("trust_device_lists") == false) goto L24;
        JsonElement r8 = r7.get("trust_device_lists");
        if (r8 != null) goto L20;
    L23:
        Log.e("SecurityServer-DataConverter", "get trust_device_lists item failed");
        goto L25
    L20:
        if (r8.isJsonObject() == false) goto L23;
        r5 = r8.getAsJsonObject();
        goto L25
    L31:
        throw new TrustCircleException(-2, "response signature verify failed");
    L32:
        StringBuilder r9 = a.a.p(r4, "rsp code: ", ", rsp msg: ");
        r9.append(r3.b);
        r9.append(", rsp log_id: ");
        r9.append(r3.c);
        throw new TrustCircleException(NetError.ERR_INVALID_URL, r9.toString());
    L35:
        throw new TrustCircleException(NetError.ERR_CERT_NO_REVOCATION_MECHANISM, "build req json data by ta failed, code: " + r0.getResultCode());
    }

    public static void d(JsonObject r14) {
        if (r14 == null) goto L74;
        int r1 = 1;
    L6:
        if (r1 > 3) goto L84;
        if (r1 <= 1) goto L9;
        r14 = (JsonObject) c().second;
    L9:
        NetworkManager r3 = NetworkManager.c();
        E2EEManager r4 = E2EEManager.getInstance();
        Context r5 = GlobalContext.f82a;
        Gson r6 = DataConverter.f65a;
        if (r14 != null) goto L12;
        Log.e("SecurityServer-DataConverter", "input tc_device_lists is null");
        byte[] r9 = new byte[0];
    L19:
        E2EEResult r7 = r4.processCmd(r5, -487718903, r9, new Bundle());
        r7.getResultCode();
        if (r7.getResultCode() == 1500) goto L21;
        if (r7.getResultCode() != 0) goto L71;
        String r10 = NetworkConfig.a("/api/trust/devices/list/update");
        byte[] r11 = r7.getOutData();
        Charset r12 = StandardCharsets.UTF_8;
        NetworkRequest r8 = new NetworkRequest(r10, new String(r11, r12), b(), "x-ad-certchain");
        r3.getClass();
        NetworkResponse r13 = NetworkManager.b(r8);
        int r15 = r13.f79a;
        if (200 == r15) goto L32;
        if (r1 >= 3) goto L30;
        Log.w("SecurityServer-TrustCircleUtils", "retry attempt: " + r1);
        Thread.sleep(((long) r1) * 100);     // Catch: InterruptedException -> L75
    L29:
        r1 = r1 + 1;
        goto L6
    L30:
        StringBuilder r0 = a.a.p(r15, "rsp code: ", ", rsp msg: ");
        r0.append(r13.b);
        r0.append(", rsp log_id: ");
        r0.append(r13.c);
        throw new TrustCircleException(NetError.ERR_INVALID_URL, r0.toString());
    L32:
        byte[] r16 = r7.getOutData();
        JsonObject r2 = null;
        if (r16 != null) goto L35;
    L65:
        Log.e("SecurityServer-DataConverter", "input rspData is null or empty");
    L66:
        if (r2 == null) goto L69;
        GlobalContext.f82a.getSharedPreferences("e2ee_data", 0).edit().remove("trust_device_lists").apply();
        return;
    L69:
        throw new TrustCircleException(-13, "parse updateTrustDeviceList req failed");
    L35:
        if (r16.length == 0) goto L65;
        if (r16.length != 0) goto L40;
        JsonObject r17 = null;
    L41:
        if (r17 != null) goto L43;
        Log.e("SecurityServer-DataConverter", "parse reqData failed");
        goto L66
    L43:
        JsonElement r18 = r17.get(WsConstants.KEY_PAYLOAD);
        if (r18 != null) goto L46;
        Log.e("SecurityServer-DataConverter", "get payload item failed");
        goto L66
    L46:
        String r19 = r18.getAsString();
        if (r19 != null) goto L49;
        byte[] r110 = null;
    L50:
        if (r110 != null) goto L52;
    L55:
        JsonObject r111 = null;
    L56:
        if (r111 != null) goto L58;
        Log.e("SecurityServer-DataConverter", "decode or parse payload item failed");
        goto L66
    L58:
        JsonElement r112 = r111.get("trust_device_lists");
        if (r112 != null) goto L61;
    L64:
        Log.e("SecurityServer-DataConverter", "get trust_device_lists item failed");
        goto L66
    L61:
        if (r112.isJsonObject() == false) goto L64;
        r2 = r112.getAsJsonObject();
        goto L66
    L52:
        if (r110.length == 0) goto L55;
        r111 = DataConverter.c(new String(r110, r12));
        goto L56
    L49:
        r110 = Base64.decode(r19, 2);
        goto L50
    L40:
        r17 = DataConverter.c(new String(r16, r12));
        goto L41
    L71:
        throw new TrustCircleException(NetError.ERR_CERT_AUTHORITY_INVALID, "exit trust circle failed, errCode: " + r7.getResultCode());
    L21:
        return;
    L12:
        String r20 = ChallengeManager.b();
        if (r20 != null) goto L15;
    L18:
        Log.e("SecurityServer-DataConverter", "requestChallenge failed");
        r9 = new byte[0];
        goto L19
    L15:
        if (r20.isEmpty() == true) goto L18;
        JsonObject r113 = new JsonObject();
        r113.addProperty("challenge", r20);
        r113.add("trust_device_lists", r14);
        r9 = r113.toString().getBytes(StandardCharsets.UTF_8);
        goto L19
    L84:
        return;
    L74:
        throw new TrustCircleException(-1, "input trust device list is null");
    }

    public static boolean e(JsonObject r5) {
        if (r5 == null) goto L24;
        EnvBridgeImpl r0 = com.bytedance.securityserver.network.NetworkConfig.a().f55a;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        String r2 = r5.get(WsConstants.KEY_PAYLOAD).toString();
        String r3 = r5.get("signature").getAsString();
        if (r3 != null) goto L12;
        byte[] r4 = null;
    L13:
        String r6 = r5.get("algorithm").getAsString();
        if (r1 == false) goto L18;
        String r7 = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEI2BI1wqxRO+XHiDIwOKfHZJlmhZe\n2aeek05q42jFM5aVZMD2nebPWfAcJhMOAExzkvlom+5XfBKFQcqszYTQcA==\n-----END PUBLIC KEY-----";
    L25:
        String r8 = r7.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");     // Catch: Exception -> L16
        X509EncodedKeySpec r9 = new X509EncodedKeySpec(java.util.Base64.getDecoder().decode(r8));     // Catch: Exception -> L16
        return CryptoUtils.a(KeyFactory.getInstance("EC").generatePublic(r9), r2.getBytes(StandardCharsets.UTF_8), r4, r6);
    L16:
        e = move-exception;
        throw new TrustCircleException(-2, e.getMessage());
    L18:
        r7 = "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEQG2TeIDwOMlGroxzJVw2tWnCpNM1\nl1g1swZEXwr/+YQ4N6HWEq9qapSWfOngLhh33MD0K71AkSzi03XZeht3FQ==\n-----END PUBLIC KEY-----";
        goto L25
    L12:
        r4 = Base64.decode(r3, 2);
        goto L13
    L6:
        if (r0.a() == false) goto L8;
        r1 = true;
        goto L9
    L24:
        throw new TrustCircleException(-3, "rspData is null");
    }
}
