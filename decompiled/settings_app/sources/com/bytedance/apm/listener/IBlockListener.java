package com.bytedance.apm.listener;

/* JADX INFO: loaded from: classes3.dex */
public interface IBlockListener {
    void onBlockDetect(String r1, long r2, String r4, String r5);

    void onSeriousBlockDetect(String r1, long r2, String r4, String r5);
}
