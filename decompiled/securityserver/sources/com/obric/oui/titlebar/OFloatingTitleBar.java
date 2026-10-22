package com.obric.oui.titlebar;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OFloatingTitleBar extends FrameLayout {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: com.obric.oui.titlebar.OFloatingTitleBar$setCenterButtonGroupStyle$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object r1) {
            ((Number) r1).intValue();
            int r0 = OFloatingTitleBar.b;
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.titlebar.OFloatingTitleBar$setEndButtonGroupStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata
    public static final class C00411 extends Lambda implements Function1<Integer, Unit> {
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object r1) {
            ((Number) r1).intValue();
            int r0 = OFloatingTitleBar.b;
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.titlebar.OFloatingTitleBar$setStartButtonGroupStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata
    public static final class C00421 extends Lambda implements Function1<Integer, Unit> {
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object r1) {
            ((Number) r1).intValue();
            int r0 = OFloatingTitleBar.b;
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.titlebar.OFloatingTitleBar$setSubEndButtonGroupStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata
    public static final class C00431 extends Lambda implements Function1<Integer, Unit> {
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object r1) {
            ((Number) r1).intValue();
            int r0 = OFloatingTitleBar.b;
            throw null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        Intrinsics.m("centerTitleView");
        throw null;
    }

    public final void setCenterButtonGroupStyle(int r1) {
        Intrinsics.m("centerButtonGroup");
        throw null;
    }

    public final void setCenterCustomView(@NotNull View r1) {
        Intrinsics.f(r1, "view");
        Intrinsics.m("centerCustomContainer");
        throw null;
    }

    public final void setCenterSubTitle(int r2) {
        setCenterSubtitle(getResources().getString(r2));
    }

    public final void setCenterSubTitleColor(int r1) {
        Intrinsics.m("centerSubtitleView");
        throw null;
    }

    public final void setCenterSubtitle(@Nullable String r1) {
        Intrinsics.m("centerSubtitleView");
        throw null;
    }

    public final void setCenterTitle(@Nullable String r1) {
        Intrinsics.m("centerTitleView");
        throw null;
    }

    public final void setCenterTitleColor(int r1) {
        Intrinsics.m("centerTitleView");
        throw null;
    }

    public final void setEndButtonGroupStyle(int r1) {
        Intrinsics.m("endButtonGroup");
        throw null;
    }

    public final void setMaskBackground(@NotNull Drawable r1) {
        Intrinsics.f(r1, "drawable");
        Intrinsics.m("mask");
        throw null;
    }

    public final void setMaskBlurRadius(float r1) {
        Intrinsics.m("mask");
        throw null;
    }

    public final void setStartButtonGroupStyle(int r1) {
        Intrinsics.m("startButtonGroup");
        throw null;
    }

    public final void setStartSubTitleColor(int r1) {
        Intrinsics.m("startSubtitleView");
        throw null;
    }

    public final void setStartSubtitle(@Nullable String r1) {
        Intrinsics.m("startSubtitleView");
        throw null;
    }

    public final void setStartTitle(@Nullable String r1) {
        Intrinsics.m("startTitleView");
        throw null;
    }

    public final void setStartTitleColor(int r1) {
        Intrinsics.m("startTitleView");
        throw null;
    }

    public final void setSubEndButtonGroupStyle(int r1) {
        Intrinsics.m("endSubButtonGroup");
        throw null;
    }

    public final void setCenterTitle(int r2) {
        setCenterTitle(getResources().getString(r2));
    }

    public final void setStartSubtitle(int r2) {
        setStartSubtitle(getResources().getString(r2));
    }

    public final void setStartTitle(int r2) {
        setStartTitle(getResources().getString(r2));
    }
}
