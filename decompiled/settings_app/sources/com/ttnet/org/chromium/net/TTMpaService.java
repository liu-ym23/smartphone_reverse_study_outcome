package com.ttnet.org.chromium.net;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TTMpaService {

    public interface ICallback {
        void onFinish(boolean r1, String r2);
    }

    public abstract void command(String r1, String r2);

    public abstract void init(ICallback r1);

    public abstract void setAccAddress(List<String> r1, ICallback r2);

    public abstract void start();

    public abstract void stop();

    public TTMpaService() {
    }
}
