package com.bytedance.badger.module;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.f.e;
import com.bytedance.badger.h.h;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.concurrent.CountDownLatch;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.d0;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceFingerprint1Provider extends BadgerModuleBase {
    public DeviceFingerprint1Provider() {
    }

    private final String b(Context r5) {
        String r6 = e.f2553a;
        boolean r0 = false;
        KeyStore r1 = KeyStore.getInstance(e.f2561i);     // Catch: Exception -> L6
        r1.load(null);     // Catch: Exception -> L6
        if (r1.getCertificate("Abc1") == null) goto L8;
        r0 = true;
    L8:
        if (r0 == true) goto L10;
        KeyPairGenerator r2 = KeyPairGenerator.getInstance("RSA", e.f2561i);
        r2.initialize(new KeyGenParameterSpec.Builder("Abc1.addcounter.auto_signed_when_get_pubkey_attk", 16).setDigests(new String[]{"SHA-256"}).setSignaturePaddings(new String[]{"PSS"}).build());
        r2.generateKeyPair();
    L10:
        KeyStore r3 = KeyStore.getInstance(e.f2561i);
        r3.load(null);
        String r4 = new JSONObject(new String(com.bytedance.badger.f.a.b((X509Certificate) r3.getCertificate("Abc1")))).getString("cpu_id");
        o.b(r4, "DeviceFp1.GetDeviceIdByAskProvider()");
        return r4;
    L6:
        e = move-exception;
        com.bytedance.badger.d.e("DeviceFp1", "hasAskProvider exception: " + e.getMessage());
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String c(Context r4) {
        CountDownLatch r3 = new CountDownLatch(1);
        d0 r0 = new d0();
        r0.f18431f = "";
        e.b(r4, new c(r0, r3));
        h r5 = com.bytedance.badger.h.a.t.n();
        if (r3.await(r5.b(), r5.a()) == false) goto L7;
        return (String) r0.f18431f;
    L7:
        throw new b();
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    protected BadgerResult a(Context r5) {
        o.g(r5, "context");
    L12:
        th = move-exception;
        if ((th instanceof b) == false) goto L16;
        String r4 = LocationMonitorConst.TIMEOUT;
    L18:
        return new BadgerResult.Failure(BadgerResult.ERROR_AWAIT_TIMEOUT, r4);
    L16:
        r4 = th.getClass().getName() + " " + th.getMessage();
        goto L18
    L4:
        if (Build.VERSION.SDK_INT >= 23) goto L6;
    L9:
        String r6 = c(r5);     // Catch: Throwable -> L12
        String r7 = "service";
    L8:
        u r8 = a0.a(r6, r7);     // Catch: Throwable -> L12
        return new BadgerResult.Success(m0.k(new u[]{a0.a("value", (String) r8.a()), a0.a(WsConstants.KEY_CONNECTION_TYPE, (String) r8.b())}));
    L6:
        if (e.d() == false) goto L9;
        r6 = b(r5);     // Catch: Throwable -> L12
        r7 = "provider";
        goto L8
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public String getName() {
        return "dfp1";
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public int getPriority() {
        return 0;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public int getRefreshIntervalSeconds() {
        return -1;
    }
}
