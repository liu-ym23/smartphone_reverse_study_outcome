package com.bytedance.mpaas.bdtracker;

import android.content.Context;
import com.bytedance.bdinstall.g;
import com.bytedance.bdinstall.i;
import com.bytedance.mpaas.app.AppInfo;
import com.bytedance.mpaas.applog.IBdtrackerService;
import com.bytedance.news.common.service.manager.d;
import com.ss.android.init.tasks.BdtrackerInitTaskHook;
import os.teatracker.e;
import os.teatracker.f;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.mpaas.bdtracker.a$a, reason: collision with other inner class name */
    class C0168a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f5258b;

        C0168a(a r1, Context r2, long r3) {
            this.f5257a = r2;
            this.f5258b = r3;
        }

        @Override // com.bytedance.bdinstall.g
        public String a() {
            return null;
        }

        @Override // com.bytedance.bdinstall.v
        public String b() {
            return null;
        }

        @Override // com.bytedance.bdinstall.v
        public String getAbClient() {
            return null;
        }

        @Override // com.bytedance.bdinstall.v
        public String getAbFeature() {
            return null;
        }

        @Override // com.bytedance.bdinstall.v
        public long getAbFlag() {
            return 0;
        }

        @Override // com.bytedance.bdinstall.v
        public String getAbVersion() {
            return null;
        }

        @Override // com.bytedance.bdinstall.g
        public int getAid() {
            return 508474;
        }

        @Override // com.bytedance.bdinstall.g
        public String getAppName() {
            return "o_project_test";
        }

        @Override // com.bytedance.bdinstall.g
        public String getChannel() {
            return AppInfo.getInstatnce().getChannel();
        }

        @Override // com.bytedance.bdinstall.g
        public Context getContext() {
            return this.f5257a;
        }

        @Override // com.bytedance.bdinstall.g
        public long getManifestVersionCode() {
            return this.f5258b;
        }

        @Override // com.bytedance.bdinstall.g
        public long getUpdateVersionCode() {
            return this.f5258b;
        }

        @Override // com.bytedance.bdinstall.g
        public String getVersion() {
            return AppInfo.getInstatnce().getVersionName();
        }

        @Override // com.bytedance.bdinstall.g
        public long getVersionCode() {
            return this.f5258b;
        }
    }

    class b implements com.bytedance.news.common.service.manager.a<IBdtrackerService> {
        b(a r1) {
        }

        public BdtrackerService a() {
            return new BdtrackerService();
        }

        @Override // com.bytedance.news.common.service.manager.a
        public /* bridge */ /* synthetic */ IBdtrackerService create() {
            return a();
        }
    }

    public a() {
    }

    public void a(Context r5, BdtrackerInitTaskHook r6) {
        f.a r0 = new f.a();
        if (r6 == null) goto L5;
        r6.before(r0);
    L5:
        i.u(new C0168a(this, r5, com.obric.matrix.r.e.b.f9938a.d(r5)));
        e.f(r5, r0.a());
        d.c(IBdtrackerService.class, new b(this));
        if (r6 == null) goto L9;
        r6.after();
        return;
    }
}
