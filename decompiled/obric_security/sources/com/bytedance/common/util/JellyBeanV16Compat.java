package com.bytedance.common.util;

import android.app.ActivityManager;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class JellyBeanV16Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.JellyBeanV16Compat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BaseImpl {
        public long getTotalMem(ActivityManager.MemoryInfo r1) {
            return 0;
        }

        private BaseImpl() {
        }

        /* synthetic */ BaseImpl(AnonymousClass1 r1) {
            this();
        }

        public void setViewBackground(View r1, Drawable r2) {
            r1.setBackgroundDrawable(r2);
        }
    }

    private static class V16Impl extends BaseImpl {
        private V16Impl() {
            super(null);
        }

        /* synthetic */ V16Impl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.util.JellyBeanV16Compat.BaseImpl
        public void setViewBackground(View r1, Drawable r2) {
            r1.setBackground(r2);     // Catch: Throwable -> L4
            return;
        L4:
            r1.setBackgroundDrawable(r2);
        }

        @Override // com.bytedance.common.util.JellyBeanV16Compat.BaseImpl
        public long getTotalMem(ActivityManager.MemoryInfo r1) {
            return r1.totalMem;
        }
    }

    public JellyBeanV16Compat() {
    }

    static {
        mImpl = new V16Impl(null);
    }

    public static void setViewBackground(View r1, Drawable r2) {
        mImpl.setViewBackground(r1, r2);
    }

    public static long getTotalMem(ActivityManager.MemoryInfo r2) {
        return mImpl.getTotalMem(r2);
    }
}
