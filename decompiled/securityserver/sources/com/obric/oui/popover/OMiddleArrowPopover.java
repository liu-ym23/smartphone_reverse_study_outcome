package com.obric.oui.popover;

import android.view.View;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OMiddleArrowPopover extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f262a = 0;

    @Metadata
    public static final class Builder {
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface OnBubbleClickListener {
    }

    @Metadata
    public interface OnBubbleDismissListener {
    }

    @Metadata
    public interface OnBubbleShowListener {
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        Intrinsics.m("mOBubbleLayout");
        throw null;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r2, int r3, int r4, int r5) {
        if (r5 != 8388611) goto L5;
        r5 = 3;
    L12:
        super.showAsDropDown(r2, r3, r4, r5);     // Catch: Exception -> L11
        Intrinsics.m("mOBubbleLayout");     // Catch: Exception -> L11
        throw null;     // Catch: Exception -> L11
    L11:
        return;
    L5:
        if (r5 != 8388613) goto L12;
        r5 = 5;
        goto L12
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r2, int r3, int r4, int r5) {
        Intrinsics.f(r2, "anchor");
        if (r3 != 8388611) goto L5;
        r3 = 3;
    L12:
        super.showAtLocation(r2, r3, r4, r5);     // Catch: Exception -> L11
        Intrinsics.m("mOBubbleLayout");     // Catch: Exception -> L11
        throw null;     // Catch: Exception -> L11
    L11:
        return;
    L5:
        if (r3 != 8388613) goto L12;
        r3 = 5;
        goto L12
    }
}
