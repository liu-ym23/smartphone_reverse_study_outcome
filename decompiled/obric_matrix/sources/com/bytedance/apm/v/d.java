package com.bytedance.apm.v;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.apm.api.IActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class d {

    static class a implements IActivityLifeObserver {
        a() {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityCreated(Activity r1, Bundle r2) {
            d.d(System.currentTimeMillis());
            if (r2 == null) goto L5;
            boolean r3 = true;
        L6:
            d.e(r3);
            d.c(true);
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityPause(Activity r1) {
            d.f(r1.getComponentName().getClassName());
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityResume(Activity r1) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onActivityStarted(Activity r1) {
            d.g(System.currentTimeMillis());
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onBackground(Activity r1) {
            d.b(true);
            d.c(false);
            d.a("");
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onChange(Activity r1, Fragment r2) {
        }

        @Override // com.bytedance.services.apm.api.IActivityLifeObserver
        public void onFront(Activity r1) {
            d.a(r1.getComponentName().getClassName());
        }
    }

    static {
    }

    static /* synthetic */ String a(String r0) {
        return r0;
    }

    static /* synthetic */ boolean b(boolean r0) {
        return r0;
    }

    static /* synthetic */ boolean c(boolean r0) {
        return r0;
    }

    static /* synthetic */ long d(long r0) {
        return r0;
    }

    static /* synthetic */ boolean e(boolean r0) {
        return r0;
    }

    static /* synthetic */ String f(String r0) {
        return r0;
    }

    static /* synthetic */ long g(long r0) {
        return r0;
    }

    public static void h() {
        f.c();
        ActivityLifeObserver.getInstance().register(new a());
    }
}
