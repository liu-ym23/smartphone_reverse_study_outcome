package com.obric.oui.avatar;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OAvatarQueueView extends ConstraintLayout {
    @NotNull
    public final List<OAvatar> getAvatars() {
        ArrayList r0 = new ArrayList();
        Iterator r3 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        View r1 = (View) r3.next();
        if ((r1 instanceof OAvatar) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final void setAvatars(@NotNull List<? extends Drawable> r4) {
        Intrinsics.f(r4, "drawables");
        int r1 = 0;
        Iterator<T> r5 = r4.subList(0, 5).iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        Object r0 = r5.next();
        int r2 = r1 + 1;
        if (r1 < 0) goto L12;
        Drawable r3 = (Drawable) r0;
        View r6 = getChildAt(r1);
        if (r6 == null) goto L11;
        ((OAvatar) r6).getContentImageView().setImageDrawable(r3);
        r1 = r2;
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
    L12:
        CollectionsKt.p();
        throw null;
    }
}
