package com.bytedance.privacy.pcc;

import com.google.gson.Gson;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c(IBdInstall.PARAM_APP_ID)
    public final String f5415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("app_svc_id")
    public final String f5416d;

    public String a() {
        return new Gson().v(this);
    }

    public String toString() {
        return a();
    }
}
