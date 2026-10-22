package com.obric.oui.avatar;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/obric/oui/avatar/OAvatar;", "getAvatars", "()Ljava/util/List;", "Landroid/graphics/drawable/Drawable;", "drawables", "Lkotlin/f0;", "setAvatars", "(Ljava/util/List;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OAvatarQueueView extends ConstraintLayout {
    public final List<OAvatar> getAvatars() {
        ArrayList r0 = new ArrayList();
        Iterator<View> r3 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        View r1 = r3.next();
        if ((r1 instanceof OAvatar) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final void setAvatars(List<? extends Drawable> r5) {
        o.f(r5, "drawables");
        int r0 = 0;
        Iterator<T> r6 = r5.subList(0, 5).iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        Object r1 = r6.next();
        int r2 = r0 + 1;
        if (r0 < 0) goto L8;
        View r3 = getChildAt(r0);
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
        OCircleImageView r4 = ((OAvatar) r3).getContentImageView();
        r4.setImageDrawable((Drawable) r1);
        r0 = r2;
        goto L4
    L8:
        r.p();
        throw null;
    }
}
