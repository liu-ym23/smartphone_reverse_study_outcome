package com.bytedance.privacy.pcc;

import android.content.Context;
import android.os.Bundle;
import com.obric.security.keymanager.KeyManager;
import com.obric.security.keymanager.KeyManagerResult;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5421a = "f";

    static {
    }

    public static void a(Context r3, String r4) {
        int r5 = KeyManager.getInstance().deleteKey(r3, r4, new Bundle());
        if (r5 != 0) goto L5;
        com.bytedance.privacy.f.b.a(f5421a, "deleteSignKey: alias=" + r4);
        return;
    L5:
        com.bytedance.privacy.f.b.b(f5421a, "deleteSignKey: ret=" + r5 + " alias=" + r4);
    }

    public static String b(Context r3, String r4, String r5, String r6, String r7) {
        a(r3, r4);
        Bundle r0 = new Bundle();
        r0.putInt("key_algorithm", 2);
        r0.putInt("key_length", 256);
        r0.putInt("key_purpose", 68);
        int r1 = KeyManager.getInstance().generateKeyPair(r3, r4, r0);
        if (r1 != 0) goto L17;
        Bundle r2 = new Bundle();
        r2.putString("challenge", r5);
        r2.putString("attest_rpdid", r6);
        r2.putString("attest_rpuid", r7);
        r2.putBoolean("device_health_status_required", true);
        KeyManagerResult r8 = KeyManager.getInstance().keyAttestation(r3, r4, r2);
        if (r8.getResultCode() != 0) goto L15;
        List r9 = r8.getCertChain();
        if (r9 == null) goto L13;
        if (r9.isEmpty() == true) goto L13;
        return com.bytedance.privacy.f.a.a(r9, Math.min(r9.size(), 3));
    L13:
        throw new Exception("cert chain is empty");
    L15:
        throw new Exception("keyAttestation failed: ret=" + r8.getResultCode());
    L17:
        throw new Exception("generateKeyPair failed: ret=" + r1);
    }

    public static byte[] c(Context r2, String r3, byte[] r4) {
        KeyManagerResult r5 = KeyManager.getInstance().sign(r2, r3, r4, new Bundle());
        if (r5.getResultCode() != 0) goto L11;
        if (r5.getOutData() == null) goto L11;
        if (r5.getOutData().length == 0) goto L11;
        return r5.getOutData();
    L11:
        throw new Exception("sign failed: ret=" + r5.getResultCode());
    }
}
