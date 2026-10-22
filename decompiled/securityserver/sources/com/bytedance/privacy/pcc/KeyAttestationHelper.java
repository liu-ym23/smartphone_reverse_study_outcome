package com.bytedance.privacy.pcc;

import a.a;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.privacy.security.SecurityFrameworkCompat;
import com.bytedance.privacy.utils.CertUtils;
import com.bytedance.privacy.utils.LogUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class KeyAttestationHelper {
    public static void a(Context r5, String r6, String r7, String r8) {
        int r0 = SecurityFrameworkCompat.e(r5, "pcc_sign_key", new Bundle());
        SecurityFrameworkCompat.i();
        if (r0 != 0) goto L5;
        LogUtils.a("KeyAttestationHelper", "deleteSignKey: alias=pcc_sign_key");
    L6:
        Bundle r1 = new Bundle();
        SecurityFrameworkCompat.j();
        SecurityFrameworkCompat.i();
        r1.putInt("key_algorithm", 2);
        SecurityFrameworkCompat.l();
        r1.putInt("key_length", 256);
        SecurityFrameworkCompat.m();
        SecurityFrameworkCompat.n();
        SecurityFrameworkCompat.i();
        r1.putInt("key_purpose", 68);
        int r2 = SecurityFrameworkCompat.h(r5, "pcc_sign_key", r1);
        SecurityFrameworkCompat.i();
        if (r2 != 0) goto L21;
        Bundle r3 = new Bundle();
        SecurityFrameworkCompat.d();
        r3.putString("challenge", r6);
        SecurityFrameworkCompat.b();
        r3.putString("attest_rpdid", r7);
        SecurityFrameworkCompat.c();
        r3.putString("attest_rpuid", r8);
        SecurityFrameworkCompat.g();
        r3.putBoolean("device_health_status_required", true);
        SecurityFrameworkCompat.KeyManagerResultCompat r9 = SecurityFrameworkCompat.k(r5, "pcc_sign_key", r3);
        SecurityFrameworkCompat.i();
        int r10 = r9.f29a;
        if (r10 != 0) goto L19;
        List r11 = r9.b;
        if (r11 == null) goto L17;
        if (r11.isEmpty() == true) goto L17;
        CertUtils.a(r11, Math.min(r11.size(), 3));
        return;
    L17:
        throw new Exception("cert chain is empty");
    L19:
        throw new Exception(a.e(r10, "keyAttestation failed: ret="));
    L21:
        throw new Exception(a.e(r2, "generateKeyPair failed: ret="));
    L5:
        LogUtils.b("KeyAttestationHelper", "deleteSignKey: ret=" + r0 + " alias=pcc_sign_key");
        goto L6
    }

    public static byte[] b(Context r1, byte[] r2) {
        SecurityFrameworkCompat.KeyManagerResultCompat r3 = SecurityFrameworkCompat.q(r1, r2, new Bundle());
        SecurityFrameworkCompat.i();
        int r4 = r3.f29a;
        if (r4 != 0) goto L10;
        byte[] r5 = r3.c;
        if (r5 == null) goto L10;
        if (r5.length == 0) goto L10;
        return r5;
    L10:
        throw new Exception(a.e(r4, "sign failed: ret="));
    }
}
