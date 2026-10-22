package com.bytedance.ttnet;

import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TTNetThreadConfigInfoManager {
    private TTNetThreadConfig.Callback mThreadConfigCallback;
    private ArrayList<TTNetThreadConfig> mThreadConfigInfoSubsetList;

    public TTNetThreadConfigInfoManager(ArrayList<TTNetThreadConfig> r1, TTNetThreadConfig.Callback r2) {
        this.mThreadConfigInfoSubsetList = r1;
        this.mThreadConfigCallback = r2;
    }

    public List<TTNetThreadConfig> getThreadConfigInfoList() {
        return this.mThreadConfigInfoSubsetList;
    }

    public TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        return this.mThreadConfigCallback;
    }

    public static void bindBigCore(TTNetThreadConfig.ThreadType r1) {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (getCronetHttpClient() == null) goto L11;
        SsCronetHttpClient.bindBigCore(r1);     // Catch: Exception -> L6
        return;
    }

    public static void bindLittleCore(TTNetThreadConfig.ThreadType r1) {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (getCronetHttpClient() == null) goto L11;
        SsCronetHttpClient.bindLittleCore(r1);     // Catch: Exception -> L6
        return;
    }

    public static void resetCoreBind(TTNetThreadConfig.ThreadType r1) {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (getCronetHttpClient() == null) goto L11;
        SsCronetHttpClient.resetCoreBind(r1);     // Catch: Exception -> L6
        return;
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.isCronetClientEnable() == false) goto L7;
        return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }
}
