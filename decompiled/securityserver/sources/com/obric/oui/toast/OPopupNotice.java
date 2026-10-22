package com.obric.oui.toast;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.PopupWindow;
import d.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPopupNotice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f311a = 0;

    /* JADX INFO: renamed from: com.obric.oui.toast.OPopupNotice$11, reason: invalid class name */
    @Metadata
    final class AnonymousClass11 implements PopupWindow.OnDismissListener {
        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            int r0 = OPopupNotice.f311a;
            throw null;
        }
    }

    @Metadata
    public static final class Builder {
    }

    @Metadata
    public interface Callback {

        @Metadata
        public static final class DefaultImpls {
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface HideCallback {

        @Metadata
        public static final class DefaultImpls {
        }
    }

    @Metadata
    public static final enum HideReason extends Enum<HideReason> {
        public static final /* synthetic */ HideReason[] b = null;

        static {
            b = new HideReason[]{new HideReason("HIDE_AUTO", 0), new HideReason("HIDE_MANUAL", 1), new HideReason("HIDE_CONFLICT", 2)};
        }

        public static HideReason valueOf(String r1) {
            return (HideReason) Enum.valueOf(HideReason.class, r1);
        }

        public static HideReason[] values() {
            return (HideReason[]) b.clone();
        }
    }

    @Metadata
    public final class PopupOutlineProvider extends ViewOutlineProvider {
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
    public final class Timer extends CountDownTimer {
        @Override // android.os.CountDownTimer
        public final void onFinish() {
            throw null;
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r1) {
        }
    }

    static {
        Resources r1 = Resources.getSystem();
        Intrinsics.e(r1, "Resources.getSystem()");
        TypedValue.applyDimension(1, 12, r1.getDisplayMetrics());
        b.b("Resources.getSystem()", 1, 24);
    }
}
