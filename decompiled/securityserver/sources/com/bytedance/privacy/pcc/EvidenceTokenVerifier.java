package com.bytedance.privacy.pcc;

import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.utils.LogUtils;
import com.bytedance.ttnet.TTNetInit;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class EvidenceTokenVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f13a = null;

    /* JADX INFO: renamed from: com.bytedance.privacy.pcc.EvidenceTokenVerifier$1, reason: invalid class name */
    public class AnonymousClass1 extends HashMap<String, String> {
    }

    static {
        AnonymousClass1 r0 = new AnonymousClass1();
        r0.put("boe_TKMS-Auth-Center_auth_center_token_key_1", "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE7Za/Q33Mfhs2i0Kxn86BuImt1K1s\n/AbdZXFLC+/Ik+3a3NDVVFRm9W3iiUCh+pTk0Y4Omq1nmeNqz39NLCfKGA==\n-----END PUBLIC KEY-----");
        r0.put("prod_TKMS-Auth-Center_auth_center_token_key_1", "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAExG+TaCijKCxv+yXClDpjOrBD3t7q\nFG8e9pTas+ADSlgV5wRER2s1lCyawOnfBmKqrLtS/BpIbbf8Fkii1DtzPw==\n-----END PUBLIC KEY-----");
        r0.put("prod_TKMS-Auth-Center-TEE_auth_center_token_key_1", "-----BEGIN PUBLIC KEY-----\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEPkYpkzQTskQneVib9E7cv74CGmTW\nilp9mMBqWGR8jegdaqkt8CodOK8H+ALHmN5CP8RLu6zcGkaz+71lqN6VbA==\n-----END PUBLIC KEY-----");
    }

    public static void a(String r0, String r1, String r2, String r3) {
        if (NetworkConfig.a().b() == false) goto L5;
        String r4 = TTNetInit.DOMAIN_BOE_KEY;
    L6:
        LogUtils.a("EvidenceTokenVerifier", "verify: start V2 JWT evidence token verification (env=" + r4 + ")");
        throw null;
    L5:
        r4 = "prod";
        goto L6
    }
}
