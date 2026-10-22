package com.bytedance.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class JellyBeanV16Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.JellyBeanV16Compat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public long getTotalMem(ActivityManager.MemoryInfo r1) {
            return 0;
        }

        public void setViewBackground(View r1, Drawable r2) {
            r1.setBackgroundDrawable(r2);
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }
    }

    @TargetApi(16)
    public static class V16Impl extends BaseImpl {
        private V16Impl() {
            super(null);
        }

        @Override // com.bytedance.common.util.JellyBeanV16Compat.BaseImpl
        public long getTotalMem(ActivityManager.MemoryInfo r1) {
            return r1.totalMem;
        }

        @Override // com.bytedance.common.util.JellyBeanV16Compat.BaseImpl
        public void setViewBackground(View r1, Drawable r2) {
            r1.setBackground(r2);     // Catch: Throwable -> L4
            return;
        L4:
            r1.setBackgroundDrawable(r2);
        }

        public /* synthetic */ V16Impl(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        mImpl = new V16Impl(null);
    }

    public JellyBeanV16Compat() {
    }

    public static long getTotalMem(ActivityManager.MemoryInfo r2) {
        return mImpl.getTotalMem(r2);
    }

    public static void setViewBackground(View r1, Drawable r2) {
        mImpl.setViewBackground(r1, r2);
    }
}
