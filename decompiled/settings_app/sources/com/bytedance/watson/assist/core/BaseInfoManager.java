package com.bytedance.watson.assist.core;

import android.content.Context;
import com.bytedance.watson.assist.api.IAssistStat;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseInfoManager {
    protected IAssistStat mAssistStat;
    protected Context mContext;

    public void end() {
    }

    public void start() {
    }

    public BaseInfoManager(Context r1, IAssistStat r2) {
        this.mContext = r1;
        this.mAssistStat = r2;
    }
}
