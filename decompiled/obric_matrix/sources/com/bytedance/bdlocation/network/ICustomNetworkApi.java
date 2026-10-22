package com.bytedance.bdlocation.network;

import androidx.annotation.Nullable;
import d.b.r.d0;
import d.b.r.h0.b;
import d.b.r.k0.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICustomNetworkApi {
    d0<String> doPost(String r1, String r2, @Nullable Map<String, String> r3, @Nullable Map<String, String> r4, @Nullable List<b> r5, boolean r6);

    String doPostJson(String r1, String r2, @Nullable Map<String, String> r3, @Nullable j r4, @Nullable List<b> r5, boolean r6);
}
