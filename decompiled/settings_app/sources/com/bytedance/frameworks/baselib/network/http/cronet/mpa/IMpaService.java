package com.bytedance.frameworks.baselib.network.http.cronet.mpa;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IMpaService {

    public interface ICallback {
        void onFinish(boolean r1, String r2);
    }

    void command(String r1, String r2);

    void init(ICallback r1);

    void setAccAddress(List<String> r1, ICallback r2);

    void start();

    void stop();
}
