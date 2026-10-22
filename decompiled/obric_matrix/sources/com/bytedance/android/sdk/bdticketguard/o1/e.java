package com.bytedance.android.sdk.bdticketguard.o1;

import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.s0;
import kotlin.n0.d.o;
import net.bytedance.zdplib.Delta;
import net.bytedance.zdplib.DeltaSignerVerifier;

/* JADX INFO: loaded from: classes.dex */
public final class e extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DeltaSignerVerifier f957c;

    public e(boolean r2, String r3, String r4, DeltaSignerVerifier r5) {
        o.g(r3, "publicKey");
        o.g(r4, "privateKey");
        o.g(r5, "deltaSignerVerifier");
        super(r2, null);
        this.f956b = r3;
        this.f957c = r5;
        s0.f1065a.a("ReeKeyObject", "ree public key=" + r3);
        Base64.encodeToString(Delta.e(r3), 2);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.c
    public boolean b() {
        return true;
    }

    public final DeltaSignerVerifier c() {
        return this.f957c;
    }

    public String d(int r1) {
        String r0 = Base64.encodeToString(Delta.e(this.f956b), r1);
        o.b(r0, "Base64.encodeToString(De…y(publicKey), encodeFlag)");
        return r0;
    }
}
