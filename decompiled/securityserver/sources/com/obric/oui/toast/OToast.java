package com.obric.oui.toast;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import d.b;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OToast {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class OutlineProvider extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r1, Outline r2) {
            if (r1 == null) goto L8;
            Drawable r3 = r1.getBackground();
            if (r3 == null) goto L9;
            r3.copyBounds(null);
            throw null;
        L9:
            throw null;
        L8:
            throw null;
        }
    }

    @Metadata
    public static final class TN {

        @Metadata
        public static final class Companion {
        }
    }

    static {
        Resources r1 = Resources.getSystem();
        Intrinsics.e(r1, "Resources.getSystem()");
        TypedValue.applyDimension(1, 8, r1.getDisplayMetrics());
        b.b("Resources.getSystem()", 1, 20);
        Resources r2 = Resources.getSystem();
        Intrinsics.e(r2, "Resources.getSystem()");
        MathKt.a(TypedValue.applyDimension(1, 96, r2.getDisplayMetrics()));
        new WeakReference(null);
    }
}
