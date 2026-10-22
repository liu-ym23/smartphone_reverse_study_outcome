package com.obric.oui.popover.v2;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OPopover extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f268a = 0;

    @Metadata
    public static final class Builder {
    }

    @Metadata
    public static final class CommonFloatProperty {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f269a;
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface OnBubbleDismissListener {
    }

    @Metadata
    public interface OnBubbleShowListener {
    }

    public final void a() {
        Intrinsics.m("mWindowFrame");
        throw null;
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        Intrinsics.m("mWindowFrame");
        throw null;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r1, int r2, int r3, int r4) {
        a();     // Catch: Exception -> L4
        throw null;     // Catch: Exception -> L4
    L4:
        e = move-exception;
        L.c("OPopover", "showAsDropDown, error", e);
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r1, int r2, int r3, int r4) {
        Intrinsics.f(r1, "anchor");
        a();     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        L.c("OPopover", "showAtLocation, error", e);
    }
}
