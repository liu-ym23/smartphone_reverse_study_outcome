package com.bytedance.securityserver.trustcircle.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.PrivacySdk;
import com.bytedance.privacy.attestation.AttestationConfig;
import com.bytedance.privacy.attestation.IdAttestationManager;
import com.bytedance.security.e2ee.E2EEManager;
import com.bytedance.security.e2ee.E2EEResult;
import com.bytedance.securityserver.trustcircle.DataConverter;
import com.bytedance.securityserver.trustcircle.GlobalVariable;
import com.bytedance.securityserver.trustcircle.TrustCircleException;
import com.bytedance.securityserver.trustcircle.TrustCircleManager;
import com.bytedance.securityserver.trustcircle.TrustCircleUtils;
import com.bytedance.securityserver.trustcircle.a;
import com.bytedance.securityserver.trustcircle.network.NetworkConfig;
import com.bytedance.securityserver.trustcircle.network.NetworkManager;
import com.bytedance.securityserver.trustcircle.network.NetworkRequest;
import com.bytedance.securityserver.trustcircle.network.NetworkResponse;
import com.bytedance.securityserver.utils.GlobalContext;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ttnet.org.chromium.net.NetError;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class AccountUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f72a = null;
    public static final AtomicBoolean b = null;
    public static final AtomicBoolean c = null;

    static {
        f72a = new Object();
        b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
    }

    public static void a(Context r2, int r3) {
        SharedPreferences r4 = r2.getSharedPreferences("account_bind_pref", 0);
        if (r3 != 0) goto L5;
        r4.edit().remove("bind_failed").apply();
        return;
    L5:
        r4.edit().remove("unbind_failed").apply();
    }

    public static String b() {
        E2EEManager r0 = E2EEManager.getInstance();
        Context r1 = GlobalContext.f82a;
        Charset r2 = StandardCharsets.UTF_8;
        E2EEResult r3 = r0.processCmd(r1, -487718902, "None".getBytes(r2), new Bundle());
        r3.getResultCode();
        if (r3.getResultCode() != 0) goto L7;
        return new String(r3.getOutData(), r2);
    L7:
        throw new TrustCircleException(-7, "Get account csr failed, errCode: " + r3.getResultCode());
    }

    public static String c(String r4) {
        if (PrivacySdk.isInitialized() == false) goto L10;
        AttestationConfig.Builder r0 = new AttestationConfig.Builder();     // Catch: Exception -> L6
        boolean[] r1 = r0.f7a;     // Catch: Exception -> L6
        r1[2] = true;     // Catch: Exception -> L6
        r1[1] = true;     // Catch: Exception -> L6
        r1[0] = true;     // Catch: Exception -> L6
        r0.a(r4);     // Catch: Exception -> L6
        r0.c = true;     // Catch: Exception -> L6
        IdAttestationManager r5 = PrivacySdk.getIdAttestationManager();     // Catch: Exception -> L6
        Context r2 = GlobalContext.f82a;     // Catch: Exception -> L6
        AttestationConfig r3 = new AttestationConfig(r0);     // Catch: Exception -> L6
        r5.getClass();     // Catch: Exception -> L6
        return IdAttestationManager.c(r2, r3);
    L6:
        e = move-exception;
        throw new TrustCircleException(-5, e.getMessage());
    L10:
        throw new TrustCircleException(-4, "PrivacySdk is not init");
    }

    public static boolean d(Context r2, int r3) {
        SharedPreferences r4 = r2.getSharedPreferences("account_bind_pref", 0);
        Object r0 = f72a;
        monitor-enter(r0);
        if (r3 != 0) goto L10;
        boolean r5 = r4.getBoolean("bind_failed", false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r5;
    L10:
        boolean r6 = r4.getBoolean("unbind_failed", false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r6;
    L8:
        th = move-exception;
        throw th;
    }

    public static void e(String r12) {
        final int r0 = 4;
        final int r1 = 2;
        final int r2 = 1;
        final int r3 = 3;
        final int r4 = 0;
        NetworkManager r5 = NetworkManager.c();
        NetworkRequest r6 = new NetworkRequest(NetworkConfig.a("/api/account/device/cert/issue"), "", r12, "x-att-certchain");
        r5.getClass();
        NetworkResponse r13 = NetworkManager.b(r6);
        int r7 = r13.f79a;
        if (r7 != 200) goto L63;
        JsonObject r14 = r13.f80d;
        if (TrustCircleUtils.e(r14) == false) goto L62;
        Gson r8 = DataConverter.f65a;
        AccountCertChain r9 = null;
        JsonArray r15 = r14.getAsJsonObject(WsConstants.KEY_PAYLOAD).get("cert_chain").getAsJsonArray();     // Catch: Exception -> L10
        if (r15.size() == 3) goto L12;
        Log.e("SecurityServer-DataConverter", "Invalid account cert chain size: " + r15.size());     // Catch: Exception -> L10
    L65:
    L24:
        if (r9 == null) goto L60;
        byte[] r16 = r9.f;
        if (r16 == null) goto L28;
        int r17 = r16.length;
    L29:
        int r18 = r17 + 24;
        byte[] r10 = r9.h;
        if (r10 == null) goto L32;
        int r11 = r10.length;
    L33:
        int r19 = (r18 + r11) + 4;
        byte[] r20 = r9.j;
        if (r20 == null) goto L36;
        int r21 = r20.length;
    L37:
        int r110 = r19 + r21;
        byte[] r22 = r9.k;
        if (r22 == null) goto L40;
        int r23 = r22.length;
    L41:
        ByteBuffer r111 = ByteBuffer.allocate(r110 + r23);
        r111.order(ByteOrder.LITTLE_ENDIAN);
        r111.putInt(r9.f69a);
        r111.putInt(r9.b);
        r111.putInt(r9.c);
        r111.putInt(r9.f70d);
        r111.putInt(r9.e);
        byte[] r24 = r9.f;
        if (r24 == null) goto L44;
        r111.put(r24);
    L44:
        r111.putInt(r9.g);
        byte[] r25 = r9.h;
        if (r25 == null) goto L47;
        r111.put(r25);
    L47:
        r111.putInt(r9.i);
        byte[] r26 = r9.j;
        if (r26 == null) goto L50;
        r111.put(r26);
    L50:
        byte[] r27 = r9.k;
        if (r27 == null) goto L53;
        r111.put(r27);
    L53:
        E2EEResult r112 = E2EEManager.getInstance().processCmd(GlobalContext.f82a, -487718901, r111.array(), new Bundle());
        r112.getResultCode();
        if (r112.getResultCode() != 0) goto L58;
        StringBuilder r113 = new StringBuilder();
        byte[] r28 = r9.f;
        int r29 = r9.e;
        Charset r30 = StandardCharsets.UTF_8;
        r113.append(new String(r28, 0, r29, r30));
        r113.append(new String(r9.h, 0, r9.g, r30));
        r113.append(new String(r9.j, 0, r9.i, r30));
        GlobalVariable.f66a = r113.toString().replace("\n", "").replaceAll("(?i)(-----BEGIN CERTIFICATE-----)", "$1\\\\n").replaceAll("(?i)(-----END CERTIFICATE-----)", "\\\\n$1\\\\n");
        return;
    L58:
        throw new TrustCircleException(-9, "import account cert chain failed");
    L40:
        r23 = 0;
        goto L41
    L36:
        r21 = 0;
        goto L37
    L32:
        r11 = 0;
        goto L33
    L28:
        r17 = 0;
        goto L29
    L60:
        throw new TrustCircleException(-8, "build account cert chain failed");
    L12:
        final AccountCertChain r31 = new AccountCertChain();     // Catch: Exception -> L10
        if (DataConverter.a(r15, 0, 1280, new a(r31, r4), new a(r31, r2)) == false) goto L65;
        if (DataConverter.a(r15, 1, 1024, new a(r31, r1), new a(r31, r3)) == false) goto L65;
        final int r114 = 5;
        if (DataConverter.a(r15, 2, 1536, new a(r31, r0), new a(r31, r114)) == false) goto L65;
        r31.f69a = 1;     // Catch: Exception -> L10
        r31.b = 1;     // Catch: Exception -> L10
        r31.c = -559038737;     // Catch: Exception -> L10
        r31.f70d = -1091576147;     // Catch: Exception -> L10
        r31.k = new byte[196];     // Catch: Exception -> L10
        r9 = r31;
    L10:
        e = move-exception;
        a.a.C(e, new StringBuilder("buildAccountCertChain failed, exception: "), "SecurityServer-DataConverter");
        goto L24
    L62:
        throw new TrustCircleException(-2, "response signature verify failed");
    L63:
        StringBuilder r32 = a.a.p(r7, "rsp code: ", ", rsp msg: ");
        r32.append(r13.b);
        r32.append(", rsp log_id: ");
        r32.append(r13.c);
        throw new TrustCircleException(NetError.ERR_INVALID_URL, r32.toString());
    }

    public static void f() {
        E2EEResult r0 = E2EEManager.getInstance().processCmd(GlobalContext.f82a, -487718898, "None".getBytes(StandardCharsets.UTF_8), new Bundle());
        r0.getResultCode();
        int r1 = r0.getResultCode();
        if (r1 != 0) goto L6;
        return;
    L6:
        throw new TrustCircleException(-12, a.a.e(r1, "remove account cert chain failed, code: "));
    }

    public static void g(String r6) {
        E2EEResult r0 = E2EEManager.getInstance().processCmd(GlobalContext.f82a, -487718899, DataConverter.b(), new Bundle());
        r0.getResultCode();
        if (r0.getResultCode() != 0) goto L10;
        NetworkManager r1 = NetworkManager.c();
        NetworkRequest r2 = new NetworkRequest(NetworkConfig.a("/api/account/device/cert/revoke"), new String(r0.getOutData(), StandardCharsets.UTF_8), r6, "x-ad-certchain");
        r1.getClass();
        NetworkResponse r7 = NetworkManager.b(r2);
        int r3 = r7.f79a;
        if (r3 != 200) goto L7;
        return;
    L7:
        StringBuilder r4 = a.a.p(r3, "rsp code: ", ", rsp msg: ");
        r4.append(r7.b);
        r4.append(", rsp log_id: ");
        r4.append(r7.c);
        throw new TrustCircleException(NetError.ERR_INVALID_URL, r4.toString());
    L10:
        throw new TrustCircleException(-11, "get revokeAccountCertChain req from tee failed");
    }

    public static void h(Context r2, int r3) {
        SharedPreferences r4 = r2.getSharedPreferences("account_bind_pref", 0);
        if (r3 != 0) goto L5;
        r4.edit().putBoolean("bind_failed", true).apply();
        return;
    L5:
        r4.edit().putBoolean("unbind_failed", true).apply();
    }

    public static int i(Context r13, int r14) {
        if (r14 == 0) goto L7;
        if (r14 == 1) goto L7;
        Log.e("SecurityServer-AccountUtils", "Invalid mode: " + r14);
        return -1;
    L7:
        AtomicBoolean r3 = c;
        AtomicBoolean r4 = b;
        if (r14 != 0) goto L10;
        AtomicBoolean r5 = r4;
    L12:
        if (r5.compareAndSet(false, true) == true) goto L15;
        Log.i("SecurityServer-AccountUtils", "Task is already running. Ignore this trigger.");
        return 0;
    L15:
        int r7 = 1;
        int r6 = 0;
    L17:
        if (r6 >= 5) goto L39;
        CountDownLatch r8 = new CountDownLatch(1);     // Catch: Throwable -> L24 Exception -> L44
        AtomicInteger r9 = new AtomicInteger(Integer.MIN_VALUE);     // Catch: Throwable -> L24 Exception -> L44
        com.bytedance.securityserver.a r10 = new com.bytedance.securityserver.a(r9, r8);     // Catch: Throwable -> L24 Exception -> L44
        TrustCircleManager r11 = TrustCircleManager.b();     // Catch: Throwable -> L24 Exception -> L44
        if (r14 != 0) goto L21;
        r11.c(r10);     // Catch: Throwable -> L24 Exception -> L44
    L53:
        boolean r12 = r8.await(10, TimeUnit.SECONDS);     // Catch: Throwable -> L24 InterruptedException -> L26 Exception -> L44
    L27:
        if (r12 == true) goto L29;
    L35:
        Log.i("SecurityServer-AccountUtils", "attempt " + r6 + " failed, will retry");     // Catch: Throwable -> L24 Exception -> L44
        if (r6 >= 4) goto L38;
        Thread.sleep(((long) r7) * 1000);     // Catch: Throwable -> L24 Exception -> L44
        r7 = Math.min(r7 * 2, 8);     // Catch: Throwable -> L24 Exception -> L44
    L38:
        r6 = r6 + 1;     // Catch: Throwable -> L24 Exception -> L44
        goto L17
    L29:
        if (r9.get() != 0) goto L35;
        a(r13, r14);     // Catch: Throwable -> L24 Exception -> L44
        if (r14 != 0) goto L33;
        r4.set(false);
    L34:
        return 0;
    L33:
        r3.set(false);
    L26:
        r12 = false;
        goto L27
    L21:
        r11.a(r10);     // Catch: Throwable -> L24 Exception -> L44
    L24:
        th = move-exception;
        if (r14 != 0) goto L51;
        r4.set(false);
    L52:
        throw th;
    L51:
        r3.set(false);
    L44:
        Log.e("SecurityServer-AccountUtils", "Exception in tryWithBackoff");     // Catch: Throwable -> L24
        if (r14 != 0) goto L47;
        r4.set(false);
    L48:
        return -1;
    L47:
        r3.set(false);
        goto L48
    L39:
        Log.e("SecurityServer-AccountUtils", "tryWithBackoff failed");     // Catch: Throwable -> L24 Exception -> L44
        if (r14 != 0) goto L42;
        r4.set(false);
    L43:
        return -1;
    L42:
        r3.set(false);
        goto L43
    L10:
        r5 = r3;
        goto L12
    }
}
