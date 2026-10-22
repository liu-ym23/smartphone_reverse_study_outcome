package com.bytedance.common.util;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class JellyBeanMR1V16Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.JellyBeanMR1V16Compat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public void setBackground(View r1, Drawable r2) {
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

        @Override // com.bytedance.common.util.JellyBeanMR1V16Compat.BaseImpl
        public void setBackground(View r1, Drawable r2) {
            r1.setBackground(r2);
        }

        public /* synthetic */ V16Impl(AnonymousClass1 r1) {
            this();
        }
    }

    public JellyBeanMR1V16Compat() {
    }

    public static void setBackgroundForView(View r2, Drawable r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (mImpl != null) goto L7;
        mImpl = new V16Impl(null);
    L7:
        mImpl.setBackground(r2, r3);
    }
}
