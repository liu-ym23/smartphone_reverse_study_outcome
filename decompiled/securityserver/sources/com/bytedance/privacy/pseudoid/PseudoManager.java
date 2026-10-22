package com.bytedance.privacy.pseudoid;

import a.a;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.keymanager.AttestKeyManager;
import com.bytedance.privacy.network.ChallengeManager;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.pseudoid.network.NetworkManager;
import com.bytedance.privacy.pseudoid.network.NetworkRequest;
import com.bytedance.privacy.pseudoid.network.NetworkResponse;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.privacy.utils.PrivacyUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class PseudoManager {
    public static final String TAG = "PseudoManager";
    private static volatile PseudoManager pseudoManager;

    public PseudoManager() {
    }

    private void deletePseudoIDs(Context r6, String r7) {
        String r0 = AccountApi.a();
        if (isRPDIDExist(r6, r7, r0) == false) goto L19;
        String r1 = queryRPDID(r6, r7, r0);
        if (r1 != null) goto L7;
    L17:
        LogUtils.b(TAG, "RPDID is already stored, but query failed!");
        return;
    L7:
        if (r1.isEmpty() == true) goto L17;
        if (isDeviceIdExist(r6, r7, r1) == false) goto L14;
        int r2 = SecurityFrameworkCompat.f(r6, PrivacyUtils.a(RPIDStoreConfig.a(r7, r1, "_did")), new Bundle());
        if (r2 == 0) goto L14;
        LogUtils.b(TAG, "delete DeviceID failed, result = " + r2);
    L14:
        int r3 = SecurityFrameworkCompat.f(r6, PrivacyUtils.a(RPIDStoreConfig.a(r7, r0, "_rpdid")), new Bundle());
        if (r3 == 0) goto L19;
        LogUtils.b(TAG, "delete RPDID failed, result = " + r3);
    L19:
        IAccountBridge r4 = AccountApi.f23a;
        if (r4 == null) goto L22;
        boolean r5 = r4.d();
    L23:
        if (r5 == false) goto L36;
        IAccountBridge r8 = AccountApi.f23a;
        if (r8 == null) goto L27;
        String r9 = r8.b();
    L28:
        if (r9 != null) goto L31;
        r9 = "";
    L31:
        if (isRPUIDExist(r6, r7, r9) == false) goto L37;
        int r10 = SecurityFrameworkCompat.f(r6, PrivacyUtils.a(RPIDStoreConfig.a(r7, r9, "_rpuid")), new Bundle());
        if (r10 == 0) goto L38;
        LogUtils.b(TAG, "delete RPUID failed, result = " + r10);
        return;
    L38:
        return;
    L37:
        return;
    L27:
        r9 = null;
        goto L28
    L36:
        return;
    L22:
        r5 = false;
        goto L23
    }

    public static PseudoManager getInstance() {
        if (pseudoManager != null) goto L16;
        monitor-enter(PseudoManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (pseudoManager != null) goto L11;
        pseudoManager = new PseudoManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L9
    L16:
        return pseudoManager;
    }

    private int getPseudoIDFromCloud(Context r3, String r4, String r5, String r6) {
        if (r3 == null) goto L14;
        if (r6 == null) goto L14;
        if (r4 != null) goto L8;
    L12:
        LogUtils.b(TAG, "deviceId cannot be empty!!");
        return -2;
    L8:
        if (r4.isEmpty() == true) goto L12;
        return requestPseudoID(r3, r4, r5, r6);
    L14:
        LogUtils.b(TAG, "context or appID is null!!");
        return -2;
    }

    private boolean isDeviceIdExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        SecurityFrameworkCompat.p();
        SecurityFrameworkCompat.i();
        r2.putInt("query_mode", 0);
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.o(r3, PrivacyUtils.a(RPIDStoreConfig.a(r4, r5, "_did")), r2);
        if (r6.f30a == false) goto L5;
    L9:
        return false;
    L5:
        if (r6.b != 0) goto L9;
        return true;
    }

    private boolean isRPDIDExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        SecurityFrameworkCompat.p();
        SecurityFrameworkCompat.i();
        r2.putInt("query_mode", 0);
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.o(r3, PrivacyUtils.a(RPIDStoreConfig.a(r4, r5, "_rpdid")), r2);
        if (r6.f30a == false) goto L5;
    L9:
        return false;
    L5:
        if (r6.b != 0) goto L9;
        return true;
    }

    private boolean isRPUIDExist(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        SecurityFrameworkCompat.p();
        SecurityFrameworkCompat.i();
        r2.putInt("query_mode", 0);
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.o(r3, PrivacyUtils.a(RPIDStoreConfig.a(r4, r5, "_rpuid")), r2);
        if (r6.f30a == false) goto L5;
    L9:
        return false;
    L5:
        if (r6.b != 0) goto L9;
        return true;
    }

    private String queryRPDID(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        SecurityFrameworkCompat.p();
        SecurityFrameworkCompat.i();
        r2.putInt("query_mode", 2);
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.o(r3, PrivacyUtils.a(RPIDStoreConfig.a(r4, r5, "_rpdid")), r2);
        if (r6.f30a == false) goto L5;
    L15:
        LogUtils.b(TAG, "Query RPDID failed!!");
        return null;
    L5:
        if (r6.b != 0) goto L15;
        String r7 = r6.c;
        if (r7 != null) goto L10;
    L13:
        LogUtils.b(TAG, "Query success, but RPDID is null!!");
        return null;
    L10:
        if (r7.isEmpty() == true) goto L13;
        return r7;
    }

    private String queryRPUID(Context r3, String r4, String r5) {
        Bundle r2 = new Bundle();
        SecurityFrameworkCompat.p();
        SecurityFrameworkCompat.i();
        r2.putInt("query_mode", 2);
        SecurityFrameworkCompat.SecretQueryResult r6 = SecurityFrameworkCompat.o(r3, PrivacyUtils.a(RPIDStoreConfig.a(r4, r5, "_rpuid")), r2);
        if (r6.f30a == false) goto L5;
    L15:
        LogUtils.b(TAG, "Query RPUID failed!!");
        return null;
    L5:
        if (r6.b != 0) goto L15;
        String r7 = r6.c;
        if (r7 != null) goto L10;
    L13:
        LogUtils.b(TAG, "Query success, but RPUID is null!!");
        return null;
    L10:
        if (r7.isEmpty() == true) goto L13;
        return r7;
    }

    private int requestPseudoID(Context r17, String r18, String r19, String r20) {
        String r0 = TAG;
        LogUtils.a(r0, "request PseudoID, PackageName: " + r17.getPackageName());
        LogUtils.a(r0, "request PseudoID, appId:" + r20);
        LogUtils.a(r0, "request PseudoID, deviceId:" + r18);
        if (r19.isEmpty() == true) goto L5;
        LogUtils.a(r0, "request PseudoID, userId:".concat(r19));
    L5:
        NetworkRequest r7 = new NetworkRequest();
        r7.f25a = HttpMethodContrants.POST;
        OkHttpClient r8 = NetworkManager.f24a;
        if (NetworkConfig.a().b() == false) goto L8;
        String r9 = "https://ocean-secret-boe.bytedance.net/api/identity/pseudonymize";
    L9:
        r7.b = r9;
        AttestKeyManager.d().getClass();
        AttestKeyManager.a(r17, r20);
        Bundle r10 = new Bundle();
        SecurityFrameworkCompat.j();
        SecurityFrameworkCompat.i();
        r10.putInt("key_algorithm", 2);
        SecurityFrameworkCompat.l();
        r10.putInt("key_length", 256);
        SecurityFrameworkCompat.m();
        SecurityFrameworkCompat.n();
        r10.putInt("key_purpose", 64);
        AttestKeyManager.d().getClass();
        String r11 = ChallengeManager.b();
        if (TextUtils.isEmpty(r11) == false) goto L12;
        LogUtils.b("AttestKeyManager", "Request challenge failed!!");
        List r12 = new ArrayList();
    L20:
        if (r12.isEmpty() == false) goto L156;
        LogUtils.b(r0, "Get attest cert chain failed!!");
        int r1 = -9;
    L147:
        AttestKeyManager.d().getClass();
        AttestKeyManager.a(r17, r20);
        LogUtils.d(TAG, "requestPseudoID end, result:" + r1);
        return r1;
    L156:
        r7.c = CertUtils.a(r12, 3);     // Catch: Exception -> L145
        if (NetworkManager.b == null) goto L27;
    L37:
        NetworkManager.b.getClass();
        LogUtils.a("NetworkManager", "executeRequest enter");
        RequestBody r13 = RequestBody.create(MediaType.parse("application/json"), "{}");
        Map r14 = MapsKt.b();
        IAccountBridge r15 = AccountApi.f23a;
        Object r16 = null;
        if (r15 == null) goto L40;
        Map r110 = r15.a();
    L41:
        if (r110 == null) goto L44;
        r14 = r110;
    L44:
        Iterator r111 = r14.entrySet().iterator();
    L46:
        if (r111.hasNext() == false) goto L48;
        Map.Entry r112 = (Map.Entry) r111.next();
        LogUtils.a("NetworkManager", "xttTokenMap entry key:" + ((String) r112.getKey()) + " value:" + ((String) r112.getValue()));
        goto L46
    L48:
        Request r6 = new Request.Builder().url(r7.b).method(r7.f25a, r13).headers(Headers.of(r14)).addHeader("Content-Type", "application/json").addHeader("x-att-certchain", r7.c).build();
        LogUtils.a("NetworkManager", "PseudoID Request:" + r6.toString());
        LogUtils.a("NetworkManager", "PseudoID Request body:" + r6.body());
        NetworkResponse r21 = new NetworkResponse(400, "", null);
        int r113 = 3;
        int r114 = 1;
    L49:
        if (r114 > r113) goto L116;
        Response r115 = NetworkManager.f24a.newCall(r6).execute();     // Catch: Exception -> L64 IOException -> L66 ConnectException -> L68 SocketTimeoutException -> L70
    L91:
        th = th;
        Object r116 = r16;
    L88:
        Throwable r117 = th;
    L93:
        if (r115 != null) goto L152;
    L107:
        throw r117;     // Catch: Exception -> L99 IOException -> L101 ConnectException -> L103 SocketTimeoutException -> L105
    L103:
        e = e;
    L110:
        StringBuilder r118 = a.p(r114, "Challenge Attempt ", ": ConnectException (connect timeout): ");
        r118.append(e.getMessage());
        LogUtils.b("NetworkManager", r118.toString());
    L78:
        r113 = 3;
        if (r114 >= 3) goto L115;
        Thread.sleep(500);     // Catch: InterruptedException -> L149
    L115:
        r114 = r114 + 1;
        r16 = r116;
    L105:
        e = e;
    L111:
        StringBuilder r119 = a.p(r114, "Challenge Attempt ", ": SocketTimeoutException (read/write timeout): ");
        r119.append(e.getMessage());
        LogUtils.b("NetworkManager", r119.toString());
    L101:
        e = e;
    L109:
        StringBuilder r120 = a.p(r114, "Challenge Attempt ", ": IOException: ");
        r120.append(e.getMessage());
        LogUtils.b("NetworkManager", r120.toString());
    L99:
        e = e;
    L108:
        a.w(e, a.p(r114, "Challenge Attempt ", ": Unexpected exception: "), "NetworkManager");
        goto L78
    L152:
        r115.close();     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        r117.addSuppressed(th);     // Catch: Exception -> L99 IOException -> L101 ConnectException -> L103 SocketTimeoutException -> L105
        goto L107
    L52:
        if (r115.body() != null) goto L154;
        String r2 = "";
    L60:
        if (r115.isSuccessful() == false) goto L72;
        LogUtils.a("NetworkManager", "PseudoID Response received successfully");     // Catch: Throwable -> L55
        LogUtils.a("NetworkManager", "PseudoID Response body:" + r2);     // Catch: Throwable -> L55
        r21 = NetworkManager.a(r2);     // Catch: Throwable -> L55
        r115.close();     // Catch: Exception -> L64 IOException -> L66 ConnectException -> L68 SocketTimeoutException -> L70
    L55:
        th = move-exception;
        r117 = th;
        r116 = r16;
        goto L93
    L72:
        StringBuilder r121 = new StringBuilder();     // Catch: Throwable -> L91
        r121.append("PseudoID Attempt ");     // Catch: Throwable -> L89
        r121.append(r114);     // Catch: Throwable -> L89
        r121.append(": Response failed, code = ");     // Catch: Throwable -> L89
        r121.append(r115.code());     // Catch: Throwable -> L89
        LogUtils.b("NetworkManager", r121.toString());     // Catch: Throwable -> L89
        LogUtils.b("NetworkManager", "PseudoID Response body:" + r2);     // Catch: Throwable -> L89
        r116 = null;
        NetworkResponse r122 = new NetworkResponse(r115.code(), r115.message(), null);     // Catch: Throwable -> L87
        r115.close();     // Catch: Exception -> L79 IOException -> L81 ConnectException -> L83 SocketTimeoutException -> L85
        r21 = r122;
        goto L78
    L83:
        e = e;
        r21 = r122;
    L85:
        e = e;
        r21 = r122;
    L81:
        e = e;
        r21 = r122;
    L79:
        e = e;
        r21 = r122;
    L87:
        th = th;
    L89:
        th = th;
        r116 = null;
        goto L88
    L154:
        r2 = r115.body().string();     // Catch: Throwable -> L55
    L68:
        e = e;
        r116 = r16;
    L70:
        e = e;
        r116 = r16;
    L66:
        e = e;
        r116 = r16;
    L64:
        e = e;
        r116 = r16;
    L116:
        String r3 = TAG;
        LogUtils.a(r3, "response code:" + r21.f26a);
        LogUtils.a(r3, "response msg:" + r21.b);
        int r22 = r21.f26a;
        if (r22 >= 200) goto L119;
    L144:
        LogUtils.b(r3, "Network request failed, error code:" + r21.f26a);
        r1 = -21;
        goto L147
    L119:
        if (r22 >= 300) goto L144;
        if (r21.c != null) goto L124;
        LogUtils.b(r3, "Network response pseudoID is null!");
        r1 = -8;
        goto L147
    L124:
        LogUtils.a(r3, "PRDID:" + r21.c.f27a);
        LogUtils.a(r3, "PRUID:" + r21.c.b);
        if (r18.isEmpty() == false) goto L127;
        int r4 = 0;
    L136:
        if (r19.isEmpty() == false) goto L138;
    L133:
        r1 = r4;
        goto L147
    L138:
        if (r21.c.b.isEmpty() == false) goto L140;
        LogUtils.b(r3, "Network response RPUID is empty!!");
    L129:
        r1 = -22;
        goto L147
    L140:
        int r5 = storePseudoUID(r17, r20, r19, r21.c.b);
        if (r5 == 0) goto L143;
        LogUtils.b(r3, "storePseudoUID failed!, result:" + r5);
    L143:
        r1 = r5;
        goto L147
    L127:
        if (r21.c.f27a.isEmpty() == false) goto L130;
        LogUtils.b(r3, "Network response RPDID is empty!!");
        goto L129
    L130:
        r4 = storePseudoDID(r17, r20, r18, r21.c.f27a);
        if (r4 == 0) goto L136;
        LogUtils.b(r3, "storePseudoDID failed!, result:" + r4);
        goto L133
    L40:
        r110 = null;
        goto L41
    L27:
        monitor-enter(PseudoManager.class);
    L31:
        th = move-exception;
        throw th;
    L29:
        if (NetworkManager.b != null) goto L33;
        NetworkManager.b = new NetworkManager();     // Catch: Throwable -> L31
    L33:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L31
    L145:
        e = move-exception;
        a.w(e, new StringBuilder("Set certificate chain failed!! error:"), TAG);
        r1 = -100;
        goto L147
    L12:
        LogUtils.a("AttestKeyManager", "Request challenge succeed! challenge:" + r11);
        int r23 = AttestKeyManager.b(r17, r20, r10);
        SecurityFrameworkCompat.i();
        if (r23 == 0) goto L15;
        LogUtils.b("AttestKeyManager", "Generate attestation key pair failed! ret:" + r23);
        r12 = new ArrayList();
        goto L20
    L15:
        String r24 = r11 + ":" + r18 + ":" + r20;
        Bundle r25 = new Bundle();
        SecurityFrameworkCompat.d();
        r25.putString("challenge", r24);
        SecurityFrameworkCompat.KeyManagerResultCompat r26 = SecurityFrameworkCompat.k(r17, r20, r25);
        int r27 = r26.f29a;
        SecurityFrameworkCompat.i();
        if (r27 == 0) goto L18;
        LogUtils.b("AttestKeyManager", "Attest key failed! ret:" + r26.f29a);
        r12 = new ArrayList();
        goto L20
    L18:
        StringBuilder r28 = new StringBuilder("Attest key succeed! cert chain size:");
        r12 = r26.b;
        r28.append(r12.size());
        LogUtils.a("AttestKeyManager", r28.toString());
        goto L20
    L8:
        r9 = "https://ocean-secret.oceancloudapi.com/api/identity/pseudonymize";
        goto L9
    }

    private int storePseudoDID(Context r11, String r12, String r13, String r14) {
        if (isRPDIDExist(r11, r12, r13) == true) goto L12;
        int r0 = SecurityFrameworkCompat.a(r11, r14, r12, PrivacyUtils.a(RPIDStoreConfig.a(r12, r13, "_rpdid")), "RPDID", new Bundle());
        if (r0 != (-1)) goto L8;
        LogUtils.b(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r0 == 0) goto L12;
        LogUtils.b(TAG, "Store RPDID failed!! result: " + r0);
        return r0;
    L12:
        if (isDeviceIdExist(r11, r12, r14) == true) goto L20;
        int r10 = SecurityFrameworkCompat.a(r11, r13, r12, PrivacyUtils.a(RPIDStoreConfig.a(r12, r14, "_did")), "DID", new Bundle());
        if (r10 != (-1)) goto L17;
        LogUtils.b(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L17:
        if (r10 == 0) goto L22;
        LogUtils.b(TAG, "Store deviceID failed!! result: " + r10);
        return r10;
    L22:
        return 0;
    L20:
        return 0;
    }

    private int storePseudoUID(Context r7, String r8, String r9, String r10) {
        if (isRPUIDExist(r7, r8, r9) == true) goto L11;
        int r6 = SecurityFrameworkCompat.a(r7, r10, r8, PrivacyUtils.a(RPIDStoreConfig.a(r8, r9, "_rpuid")), "RPUID", new Bundle());
        if (r6 != (-1)) goto L8;
        LogUtils.b(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r6 == 0) goto L13;
        LogUtils.b(TAG, "Store RPUID failed!! result: " + r6);
        return r6;
    L13:
        return 0;
    L11:
        return 0;
    }

    public String getPseudoDID(Context r18, String r19) {
        String r3 = r19;
        long r6 = System.currentTimeMillis();
        String r4 = TAG;
        LogUtils.d(r4, "getPseudoDID enter");
        int r8 = 0;
        if (r18 == null) goto L79;
        if (r3 == null) goto L79;
        String r5 = r18.getPackageName();     // Catch: Throwable -> L16 Exception -> L18
        if (r19.isEmpty() == false) goto L9;
    L76:
        LogUtils.b(r4, "AppId size is invalid!!");     // Catch: Throwable -> L16 Exception -> L18
        PseudoIDEventTrace.a(-3, 0, r5, r19, System.currentTimeMillis() - r6);
        return null;
    L9:
        if (r19.length() > 128) goto L76;
        String r10 = AccountApi.a();     // Catch: Throwable -> L16 Exception -> L18
        if (r10.isEmpty() == false) goto L21;
        LogUtils.b(r4, "deviceId is empty!");     // Catch: Throwable -> L16 Exception -> L18
        PseudoIDEventTrace.a(-4, 0, r5, r19, System.currentTimeMillis() - r6);
        return null;
    L21:
        if (isRPDIDExist(r18, r3, r10) == false) goto L29;
        String r9 = queryRPDID(r18, r3, r10);     // Catch: Throwable -> L16 Exception -> L18
        if (TextUtils.isEmpty(r9) == false) goto L26;
        LogUtils.b(r4, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L16 Exception -> L18
        int r0 = -6;
    L27:
        PseudoIDEventTrace.a(r0, 0, r5, r19, System.currentTimeMillis() - r6);
        return r9;
    L26:
        r0 = 0;
        goto L27
    L29:
        String r11 = r19.intern();     // Catch: Throwable -> L16 Exception -> L18
        monitor-enter(r11);     // Catch: Throwable -> L16 Exception -> L18
    L36:
        th = th;
    L74:
        monitor-exit(r11);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L16 Exception -> L18
    L32:
        if (isRPDIDExist(r18, r3, r10) == false) goto L41;
        String r12 = queryRPDID(r18, r3, r10);     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r12) == false) goto L38;
        LogUtils.b(r4, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L36
        r8 = -6;
    L38:
        monitor-exit(r11);     // Catch: Throwable -> L36
        PseudoIDEventTrace.a(r8, 0, r5, r19, System.currentTimeMillis() - r6);
        return r12;
    L41:
        LogUtils.d(r4, "need to get pseudoID from cloud");     // Catch: Throwable -> L36
        IAccountBridge r13 = AccountApi.f23a;     // Catch: Throwable -> L36
        if (r13 == null) goto L44;
        boolean r14 = r13.d();     // Catch: Throwable -> L36
    L45:
        if (r14 == true) goto L47;
        LogUtils.d(r4, "Account is not login!!");     // Catch: Throwable -> L36
        int r15 = getPseudoIDFromCloud(r18, r10, "", r3);     // Catch: Throwable -> L36
    L63:
        if (r15 == 0) goto L68;
        LogUtils.b(r4, "get pseudoID from cloud failed, error: " + r15);     // Catch: Throwable -> L36
        monitor-exit(r11);     // Catch: Throwable -> L36
        PseudoIDEventTrace.a(r15, 0, r5, r19, System.currentTimeMillis() - r6);
        return null;
    L68:
        String r16 = queryRPDID(r18, r3, r10);     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r16) == false) goto L71;
        LogUtils.b(r4, "RPDID store success, but query failed!");     // Catch: Throwable -> L36
        r15 = -6;
    L71:
        monitor-exit(r11);     // Catch: Throwable -> L36
        PseudoIDEventTrace.a(r15, 0, r5, r19, System.currentTimeMillis() - r6);
        return r16;
    L47:
        LogUtils.d(r4, "Account is login!!");     // Catch: Throwable -> L36
        IAccountBridge r17 = AccountApi.f23a;     // Catch: Throwable -> L36
        if (r17 == null) goto L50;
        String r110 = r17.b();     // Catch: Throwable -> L36
    L51:
        if (r110 != null) goto L54;
        r110 = "";
    L54:
        if (r110.isEmpty() == false) goto L62;
        LogUtils.b(r4, "Account is login, but userId is empty!");     // Catch: Throwable -> L36
        monitor-exit(r11);     // Catch: Throwable -> L60
        PseudoIDEventTrace.a(-5, 0, r5, r19, System.currentTimeMillis() - r6);
        return null;
    L60:
        th = th;
        goto L74
    L62:
        r15 = getPseudoIDFromCloud(r18, r10, r110, r3);     // Catch: Throwable -> L36
        goto L63
    L50:
        r110 = null;
        goto L51
    L44:
        r14 = false;
    L79:
        LogUtils.b(r4, "Context or appId is null!!");     // Catch: Throwable -> L16 Exception -> L18
        long r7 = System.currentTimeMillis() - r6;
        if (r3 == null) goto L83;
        String r20 = r3;
    L84:
        PseudoIDEventTrace.a(-2, 0, "", r20, r7);
        return null;
    L83:
        r20 = "";
    L18:
        e = move-exception;
    L89:
        th = move-exception;
        Throwable r21 = th;
        int r1 = 0;
        String r2 = "";
    L99:
        long r22 = System.currentTimeMillis() - r6;
        if (r3 != null) goto L103;
        r3 = "";
    L103:
        PseudoIDEventTrace.a(r1, 0, r2, r3, r22);
        throw r21;
    L87:
        if (e.getMessage() != null) goto L91;
        String r23 = e.getClass().getSimpleName();     // Catch: Throwable -> L89
    L92:
        LogUtils.b(TAG, "getPseudoDID failed, error: " + r23);     // Catch: Throwable -> L89
        long r111 = System.currentTimeMillis() - r6;
        if (r3 == null) goto L96;
        String r112 = r3;
    L97:
        PseudoIDEventTrace.a(0, 0, "", r112, r111);
        return null;
    L96:
        r112 = "";
        goto L97
    L91:
        r23 = e.getMessage();     // Catch: Throwable -> L89
    L16:
        th = move-exception;
        r2 = "";
        r21 = th;
        r1 = 0;
        goto L99
    }

    public String getPseudoUID(Context r16, String r17) {
        String r5 = "";
        long r6 = System.currentTimeMillis();
        String r4 = TAG;
        LogUtils.d(r4, "getPseudoUID enter");
        int r8 = 0;
        if (r16 == null) goto L77;
        if (r17 == null) goto L77;
        r5 = r16.getPackageName();     // Catch: Throwable -> L19 Exception -> L21
        if (r17.isEmpty() == false) goto L9;
    L74:
        LogUtils.b(r4, "AppId size is invalid!!");     // Catch: Throwable -> L19 Exception -> L21
        PseudoIDEventTrace.a(-3, 1, r5, r17, System.currentTimeMillis() - r6);
        return null;
    L9:
        if (r17.length() > 128) goto L74;
        IAccountBridge r10 = AccountApi.f23a;     // Catch: Throwable -> L19 Exception -> L21
        if (r10 == null) goto L14;
        boolean r11 = r10.d();     // Catch: Throwable -> L19 Exception -> L21
    L15:
        if (r11 == true) goto L23;
        LogUtils.b(r4, "Account is not login, no userId!!");     // Catch: Throwable -> L19 Exception -> L21
        PseudoIDEventTrace.a(-20, 1, r5, r17, System.currentTimeMillis() - r6);
        return null;
    L23:
        IAccountBridge r12 = AccountApi.f23a;     // Catch: Throwable -> L19 Exception -> L21
        if (r12 == null) goto L26;
        String r13 = r12.b();     // Catch: Throwable -> L19 Exception -> L21
    L27:
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        if (r13.isEmpty() == false) goto L35;
        LogUtils.b(r4, "Account is login, but userId is empty!");     // Catch: Throwable -> L19 Exception -> L21
        PseudoIDEventTrace.a(-5, 1, r5, r17, System.currentTimeMillis() - r6);
        return null;
    L35:
        if (isRPUIDExist(r16, r17, r13) == false) goto L43;
        String r9 = queryRPUID(r16, r17, r13);     // Catch: Throwable -> L19 Exception -> L21
        if (TextUtils.isEmpty(r9) == false) goto L40;
        LogUtils.b(r4, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L19 Exception -> L21
        int r0 = -7;
    L41:
        PseudoIDEventTrace.a(r0, 1, r5, r17, System.currentTimeMillis() - r6);
        return r9;
    L40:
        r0 = 0;
        goto L41
    L43:
        LogUtils.d(r4, "need to get pseudoID from cloud");     // Catch: Throwable -> L19 Exception -> L21
        String r14 = AccountApi.a();     // Catch: Throwable -> L19 Exception -> L21
        if (r14.isEmpty() == false) goto L48;
        LogUtils.b(r4, "getPseudoUID, DID is empty!");     // Catch: Throwable -> L19 Exception -> L21
        PseudoIDEventTrace.a(-4, 1, r5, r17, System.currentTimeMillis() - r6);
        return null;
    L48:
        String r15 = r17.intern();     // Catch: Throwable -> L19 Exception -> L21
        monitor-enter(r15);     // Catch: Throwable -> L19 Exception -> L21
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19 Exception -> L21
    L51:
        if (isRPUIDExist(r16, r17, r13) == false) goto L60;
        String r18 = queryRPUID(r16, r17, r13);     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r18) == false) goto L57;
        LogUtils.b(r4, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L55
        r8 = -7;
    L57:
        monitor-exit(r15);     // Catch: Throwable -> L55
        PseudoIDEventTrace.a(r8, 1, r5, r17, System.currentTimeMillis() - r6);
        return r18;
    L60:
        int r19 = getPseudoIDFromCloud(r16, r14, r13, r17);     // Catch: Throwable -> L55
        if (r19 == 0) goto L66;
        LogUtils.b(r4, "get pseudoID from cloud failed, error: " + r19);     // Catch: Throwable -> L55
        monitor-exit(r15);     // Catch: Throwable -> L55
        PseudoIDEventTrace.a(r19, 1, r5, r17, System.currentTimeMillis() - r6);
        return null;
    L66:
        String r20 = queryRPUID(r16, r17, r13);     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r20) == false) goto L69;
        LogUtils.b(r4, "RPUID store success, but query failed!");     // Catch: Throwable -> L55
    L69:
        monitor-exit(r15);     // Catch: Throwable -> L55
        PseudoIDEventTrace.a(r19, 1, r5, r17, System.currentTimeMillis() - r6);
        return r20;
    L26:
        r13 = null;
        goto L27
    L14:
        r11 = false;
    L77:
        LogUtils.b(r4, "Context or app Id is null!!");     // Catch: Throwable -> L19 Exception -> L21
        long r7 = System.currentTimeMillis() - r6;
        if (r17 == null) goto L81;
        String r21 = r17;
    L82:
        PseudoIDEventTrace.a(-2, 1, "", r21, r7);
        return null;
    L81:
        r21 = "";
    L21:
        e = move-exception;
        String r110 = r5;
    L87:
        th = th;
    L97:
        long r111 = System.currentTimeMillis() - r6;
        if (r17 == null) goto L100;
        String r112 = r17;
    L101:
        PseudoIDEventTrace.a(0, 1, r110, r112, r111);
        throw th;
    L100:
        r112 = "";
        goto L101
    L85:
        if (e.getMessage() != null) goto L89;
        String r1 = e.getClass().getSimpleName();     // Catch: Throwable -> L87
    L90:
        LogUtils.b(TAG, "getPseudoUID failed, error: " + r1);     // Catch: Throwable -> L87
        long r113 = System.currentTimeMillis() - r6;
        if (r17 == null) goto L94;
        String r114 = r17;
    L95:
        PseudoIDEventTrace.a(0, 1, r110, r114, r113);
        return null;
    L94:
        r114 = "";
        goto L95
    L89:
        r1 = e.getMessage();     // Catch: Throwable -> L87
    L19:
        th = th;
        r110 = r5;
        goto L97
    }

    public String queryDIDFromRPDID(Context r4, String r5, String r6) {
        if (r4 == null) goto L31;
        if (r5 == null) goto L31;
        if (r6 == null) goto L31;
        if (r5.isEmpty() == false) goto L10;
    L29:
        LogUtils.b(TAG, "AppId or rpDID size is invalid!!");
        return null;
    L10:
        if (r5.length() > 128) goto L29;
        if (r6.isEmpty() == true) goto L29;
        Bundle r0 = new Bundle();
        SecurityFrameworkCompat.p();
        SecurityFrameworkCompat.i();
        r0.putInt("query_mode", 2);
        SecurityFrameworkCompat.SecretQueryResult r7 = SecurityFrameworkCompat.o(r4, PrivacyUtils.a(RPIDStoreConfig.a(r5, r6, "_did")), r0);
        if (r7.f30a == false) goto L17;
    L27:
        LogUtils.b(TAG, "Query original deviceId failed!!");
        return null;
    L17:
        if (r7.b != 0) goto L27;
        String r8 = r7.c;
        if (r8 != null) goto L22;
    L25:
        LogUtils.b(TAG, "Query success, but original deviceId is null!!");
        return null;
    L22:
        if (r8.isEmpty() == true) goto L25;
        return r8;
    L31:
        LogUtils.b(TAG, "input param is null!!");
        return null;
    }
}
