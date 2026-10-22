package com.obric.matrix.base.settings.config;

import java.util.List;
import kotlin.Metadata;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<com.obric.matrix.base.settings.config.d>] */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020\u0000H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006%"}, d2 = {"Lcom/obric/matrix/base/settings/config/MatrixConfig;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "()V", "autoGrantExternalStorageRuntimePermission", "", "getAutoGrantExternalStorageRuntimePermission", "()Z", "setAutoGrantExternalStorageRuntimePermission", "(Z)V", "autoPollingInterval", "", "getAutoPollingInterval", "()I", "setAutoPollingInterval", "(I)V", "intentRedirectionVerifyEnable", "getIntentRedirectionVerifyEnable", "setIntentRedirectionVerifyEnable", "intentRedirectionVerifySkipLowestRom", "", "getIntentRedirectionVerifySkipLowestRom", "()Ljava/lang/String;", "setIntentRedirectionVerifySkipLowestRom", "(Ljava/lang/String;)V", "notUseMatrixUserCenterVersionList", "", "getNotUseMatrixUserCenterVersionList", "()Ljava/util/List;", "setNotUseMatrixUserCenterVersionList", "(Ljava/util/List;)V", "npthDefaultAnrCheckInterval", "getNpthDefaultAnrCheckInterval", "setNpthDefaultAnrCheckInterval", "waitDialogShowTime", "getWaitDialogShowTime", "setWaitDialogShowTime", "create", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("auto_polling_interval")
    private int f8866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("wait_dialog_show_time")
    private int f8867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("not_use_matrix_user_center_version_list")
    private List<Integer> f8868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("npth_default_anr_check_interval")
    private int f8869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("auth_gen_external_storage_permission")
    private boolean f8870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("intent_redirection_verify_enable")
    private boolean f8871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("intent_redirection_verify_skip_lowest_rom")
    private String f8872g;

    public d() {
        this.f8866a = 30;
        this.f8867b = 10;
        this.f8869d = 10;
        this.f8870e = true;
        this.f8871f = true;
        this.f8872g = "";
    }

    public d a() {
        return new d();
    }

    public final int b() {
        return this.f8866a;
    }

    public final int c() {
        return this.f8869d;
    }
}
