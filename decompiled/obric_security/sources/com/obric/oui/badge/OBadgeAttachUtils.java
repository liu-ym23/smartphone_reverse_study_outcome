package com.obric.oui.badge;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBadgeAttachUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/badge/OBadgeAttachUtils;", "", "()V", "attachBadgeDrawable", "", "badge", "Lcom/obric/oui/badge/OBadgeDrawable;", "anchor", "Landroid/view/View;", "parent", "Landroid/widget/FrameLayout;", "horizontalOffset", "", "verticalOffset", "(Lcom/obric/oui/badge/OBadgeDrawable;Landroid/view/View;Landroid/widget/FrameLayout;Ljava/lang/Integer;Ljava/lang/Integer;)V", "detachBadgeDrawable", "isLaidOut", "", "view", "resolveOverlayHost", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBadgeAttachUtils {
    public static final OBadgeAttachUtils INSTANCE = null;

    static {
        INSTANCE = new OBadgeAttachUtils();
    }

    @JvmStatic
    public static final void attachBadgeDrawable(OBadgeDrawable r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "badge");
        Intrinsics.checkNotNullParameter(r9, "anchor");
        attachBadgeDrawable$default(r8, r9, null, null, null, 28, null);
    }

    @JvmStatic
    public static final void attachBadgeDrawable(OBadgeDrawable r8, View r9, FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r8, "badge");
        Intrinsics.checkNotNullParameter(r9, "anchor");
        attachBadgeDrawable$default(r8, r9, r10, null, null, 24, null);
    }

    @JvmStatic
    public static final void attachBadgeDrawable(OBadgeDrawable r8, View r9, FrameLayout r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r8, "badge");
        Intrinsics.checkNotNullParameter(r9, "anchor");
        attachBadgeDrawable$default(r8, r9, r10, r11, null, 16, null);
    }

    @JvmStatic
    public static final void detachBadgeDrawable(OBadgeDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "badge");
        detachBadgeDrawable$default(r2, null, null, 6, null);
    }

    @JvmStatic
    public static final void detachBadgeDrawable(OBadgeDrawable r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "badge");
        detachBadgeDrawable$default(r2, r3, null, 4, null);
    }

    private OBadgeAttachUtils() {
    }

    public static final /* synthetic */ boolean access$isLaidOut(OBadgeAttachUtils r0, View r1) {
        return r0.isLaidOut(r1);
    }

    public static /* synthetic */ void attachBadgeDrawable$default(OBadgeDrawable r1, View r2, FrameLayout r3, Integer r4, Integer r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 16) == 0) goto L11;
        r5 = null;
    L11:
        attachBadgeDrawable(r1, r2, r3, r4, r5);
    }

    @JvmStatic
    public static final void attachBadgeDrawable(final OBadgeDrawable r3, final View r4, FrameLayout r5, Integer r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r3, "badge");
        Intrinsics.checkNotNullParameter(r4, "anchor");
        OBadgeAttachUtils r0 = INSTANCE;
        final View r8 = r0.resolveOverlayHost(r4, r5);
        if ((r8 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r8;
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
    L5:
        if (r6 == null) goto L8;
        r3.setHorizontalOffset(r6.intValue());
    L8:
        if (r7 == null) goto L11;
        r3.setVerticalOffset(r7.intValue());
    L11:
        r8.getOverlay().add(r3);
        final Function0<Unit> r9 = new OBadgeAttachUtils$attachBadgeDrawable$updatePosition$1(r3, r4, r8);
        boolean r10 = r0.isLaidOut(r4);
        boolean r2 = r0.isLaidOut(r8);
        if (r10 == false) goto L15;
        if (r2 == false) goto L15;
        r9.invoke();
    L19:
        CharSequence r11 = r3.getContentDescription();
        if (r11 == null) goto L24;
        r4.setContentDescription(r11);
        return;
    L24:
        return;
    L15:
        if (r10 == true) goto L17;
        r4.addOnLayoutChangeListener(new AnonymousClass3(r4, r8, r9));
    L17:
        if (r2 == true) goto L19;
        r8.addOnLayoutChangeListener(new AnonymousClass4(r4, r8, r9));
        goto L19
    }

    public static /* synthetic */ void detachBadgeDrawable$default(OBadgeDrawable r1, View r2, FrameLayout r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        detachBadgeDrawable(r1, r2, r3);
    }

    @JvmStatic
    public static final void detachBadgeDrawable(OBadgeDrawable r1, View r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r1, "badge");
        if (r3 == null) goto L5;
        r3.getOverlay().remove(r1);
        return;
    L5:
        if (r2 != null) goto L7;
        Object r4 = null;
    L9:
        if ((r4 instanceof View) == false) goto L13;
        ((View) r4).getOverlay().remove(r1);
        return;
    L13:
        return;
    L7:
        r4 = r2.getParent();
        goto L9
    }

    private final View resolveOverlayHost(View r1, FrameLayout r2) {
        if (r2 != null) goto L4;
        Object r0 = r1.getParent();
        if ((r0 instanceof View) == true) goto L8;
        return r1;
    L8:
        return (View) r0;
    L4:
        return r2;
    }

    private final boolean isLaidOut(View r1) {
        if (r1.getWidth() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.getHeight() <= 0) goto L7;
        return true;
    }
}
