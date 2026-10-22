package com.bytedance.common.utility;

import android.util.Pair;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NetworkClient.java */
/* JADX INFO: loaded from: classes.dex */
class DummyNetworkClient extends NetworkClient {
    DummyNetworkClient() {
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String r1, Map<String, String> r2, NetworkClient.ReqContext r3) throws Exception {
        throw new IOException("not implemented");
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r1, List<Pair<String, String>> r2, Map<String, String> r3, NetworkClient.ReqContext r4) throws CommonHttpException {
        throw new CommonHttpException(0, "not implemented");
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r1, byte[] r2, Map<String, String> r3, NetworkClient.ReqContext r4) throws CommonHttpException {
        throw new CommonHttpException(0, "not implemented");
    }
}
