package com.obric.matrix;

import android.app.Application;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/matrix/MySettingsConfigProviderImpl;", "Lcom/bytedance/news/common/settings/SettingsConfigProvider;", "()V", "TAG", "", "isMainProcess", "", "settingsRequestService", "Lcom/obric/matrix/MyRequestServiceImpl;", "getConfig", "Lcom/bytedance/news/common/settings/SettingsConfig;", "getLazyConfig", "Lcom/bytedance/news/common/settings/SettingsLazyConfig;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MySettingsConfigProviderImpl implements SettingsConfigProvider {
    private final String TAG;
    private final boolean isMainProcess;
    private final n settingsRequestService;

    public MySettingsConfigProviderImpl() {
        this.TAG = "SettingsConfigProviderImpl";
        Application r1 = com.bytedance.mpaas.app.a.f5245g;
        kotlin.n0.d.o.e(r1, "sApplication");
        this.settingsRequestService = new n(r1);
        this.isMainProcess = com.ss.android.k.c.c.c(com.bytedance.mpaas.app.a.f5245g);
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public com.bytedance.news.common.settings.b getConfig() {
        boolean r0 = com.ss.android.k.c.c.c(com.bytedance.mpaas.app.a.f5245g);
        com.bytedance.news.common.settings.b.C0170b r1 = new com.bytedance.news.common.settings.b.C0170b();
        r1.b(com.bytedance.mpaas.app.a.f5245g);
        r1.d(this.settingsRequestService);
        r1.c(r0);
        com.bytedance.news.common.settings.b r3 = r1.a();
        kotlin.n0.d.o.e(r3, "Builder()\n            .c…ess)\n            .build()");
        return r3;
    }

    @Override // com.bytedance.news.common.settings.SettingsConfigProvider
    public com.bytedance.news.common.settings.d getLazyConfig() {
        com.bytedance.news.common.settings.d.b r0 = new com.bytedance.news.common.settings.d.b();
        r0.b("6.8.8");
        com.bytedance.news.common.settings.d r2 = r0.a();
        kotlin.n0.d.o.e(r2, "Builder()\n            .u…ode)\n            .build()");
        return r2;
    }
}
