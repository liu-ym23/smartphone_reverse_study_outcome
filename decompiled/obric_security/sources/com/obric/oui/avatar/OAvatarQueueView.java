package com.obric.oui.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: OAvatarQueueView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0014\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "configAvatarSize", "", PerfConsts.PERF_DISK_FILE_SIZE, "Lcom/obric/oui/avatar/OAvatar$AvatarSize;", "count", "", "getAvatars", "", "Lcom/obric/oui/avatar/OAvatar;", "setAvatars", "drawables", "Landroid/graphics/drawable/Drawable;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAvatarQueueView extends ConstraintLayout {
    /* JADX WARN: Multi-variable type inference failed */
    public OAvatarQueueView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OAvatarQueueView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OAvatarQueueView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        ConstraintLayout.inflate(r2, R.layout.o_widget_avatar_queue, this);
    }

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

    public final void setAvatars(List<? extends Drawable> r4) {
        Intrinsics.checkNotNullParameter(r4, "drawables");
        int r1 = 0;
        Iterator<T> r5 = r4.subList(0, 5).iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        Object r0 = r5.next();
        int r2 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Drawable r3 = (Drawable) r0;
        View r6 = getChildAt(r1);
        if (r6 == null) goto L12;
        ((OAvatar) r6).getContentImageView().setImageDrawable(r3);
        r1 = r2;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.avatar.OAvatar");
    }

    public final void configAvatarSize(OAvatar.AvatarSize r14, int r15) {
        Intrinsics.checkNotNullParameter(r14, PerfConsts.PERF_DISK_FILE_SIZE);
        OAvatarQueueView r0 = this;
        Iterator<View> r1 = ViewGroupKt.getChildren(r0).iterator();
    L3:
        int r3 = 0;
        if (r1.hasNext() == false) goto L20;
        View r2 = r1.next();
        OAvatar r4 = (OAvatar) r2;
        r4.setAvatarSize(r14);
        if (r14.getDpValue() < OAvatar.AvatarSize.DP_40.getDpValue()) goto L8;
        int r5 = OUnitExtensionKt.vdp(this, 3);
    L9:
        OAvatar r6 = r4;
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        if (r9 == null) goto L19;
        int r10 = r5 * 2;
        OAvatarQueueView r11 = this;
        r9.width = OUnitExtensionKt.vdp(r11, r14.getDpValue()) + r10;
        r9.height = r10 + OUnitExtensionKt.vdp(r11, r14.getDpValue());
        r6.setLayoutParams(r9);
        r4.setAvatarInset(r5);
        r4.getContentImageView().setContentPadding(OUnitExtensionKt.vdp(r11, 0));
        if (Intrinsics.areEqual(r2, SequencesKt.first(ViewGroupKt.getChildren(r0))) == true) goto L3;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L17;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        r8.setMargins(0, 0, (OUnitExtensionKt.vdp(r11, r14.getDpValue()) / 3) * 2, 0);
        r6.setLayoutParams(r8);
        goto L3
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L8:
        r5 = OUnitExtensionKt.vdp(this, 2);
        goto L9
    L20:
        int r16 = getChildCount();
    L21:
        if (r3 >= r16) goto L27;
        int r12 = r3 + 1;
        if (r3 < r15) goto L25;
        View r13 = getChildAt(r3);
        Intrinsics.checkNotNullExpressionValue(r13, "getChildAt(index)");
        ViewExtensionsKt.makeGone(r13);
    L26:
        r3 = r12;
        goto L21
    L25:
        View r17 = getChildAt(r3);
        Intrinsics.checkNotNullExpressionValue(r17, "getChildAt(index)");
        ViewExtensionsKt.makeVisible(r17);
        goto L26
    }
}
