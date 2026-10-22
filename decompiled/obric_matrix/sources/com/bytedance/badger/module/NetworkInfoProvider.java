package com.bytedance.badger.module;

import android.content.Context;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkInfoProvider extends BadgerModuleBase {
    public NetworkInfoProvider() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    protected BadgerResult a(Context r13) {
        o.g(r13, "context");
        com.bytedance.badger.k.d r12 = BadgerCore.Companion.a().getPublicIpAddressInfo();
        return new BadgerResult.Success(m0.k(new u[]{a0.a("pub_ipv4", r.Z(r12.a(), ";", null, null, 0, null, null, 62, null)), a0.a("pub_ipv6", r.Z(r12.b(), ";", null, null, 0, null, null, 62, null))}));
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public String getName() {
        return "network";
    }
}
