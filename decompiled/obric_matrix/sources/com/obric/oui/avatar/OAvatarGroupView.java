package com.obric.oui.avatar;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/avatar/OAvatarGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/avatar/OAvatar;", "avatar", "Lcom/obric/oui/avatar/OAvatar$a;", "size", "", "borderWidth", "Lkotlin/f0;", "f", "(Lcom/obric/oui/avatar/OAvatar;Lcom/obric/oui/avatar/OAvatar$a;I)V", "getTopAvatar", "()Lcom/obric/oui/avatar/OAvatar;", "getUnderAvatar", "setAvatarGroupSize", "(Lcom/obric/oui/avatar/OAvatar$a;)V", "g", "Lcom/obric/oui/avatar/OAvatar;", "topAvatar", "underAvatar", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OAvatarGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OAvatar f10755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final OAvatar f10756g;

    private final void f(OAvatar r6, OAvatar.a r7, int r8) {
        ViewGroup.LayoutParams r5 = r6.getLayoutParams();
        if (r5 == null) goto L7;
        int r0 = r8 * 2;
        float r1 = r7.a();
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        r5.width = kotlin.o0.a.a(TypedValue.applyDimension(1, r1, r2.getDisplayMetrics())) + r0;
        float r9 = r7.a();
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        r5.height = r0 + kotlin.o0.a.a(TypedValue.applyDimension(1, r9, r3.getDisplayMetrics()));
        r6.setLayoutParams(r5);
        r6.setAvatarInset(r8);
        return;
    L7:
        throw new b0("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final OAvatar getTopAvatar() {
        return this.f10756g;
    }

    public final OAvatar getUnderAvatar() {
        return this.f10755f;
    }

    public final void setAvatarGroupSize(OAvatar.a r6) {
        o.f(r6, "size");
        switch(b.f10768a[r6.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        OAvatar.a r0 = OAvatar.a.f10750l;
    L13:
        if (r6.a() < OAvatar.a.m.a()) goto L15;
        int r1 = 3;
    L16:
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        int r3 = kotlin.o0.a.a(TypedValue.applyDimension(1, r1, r2.getDisplayMetrics()));
        f(this.f10756g, r0, r3);
        f(this.f10755f, r0, r3);
        ViewGroup.LayoutParams r4 = getLayoutParams();
        if (r4 == null) goto L21;
        float r5 = r6.a();
        Resources r7 = Resources.getSystem();
        o.e(r7, "Resources.getSystem()");
        r4.height = kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r7.getDisplayMetrics()));
        float r8 = r6.a();
        Resources r9 = Resources.getSystem();
        o.e(r9, "Resources.getSystem()");
        r4.width = kotlin.o0.a.a(TypedValue.applyDimension(1, r8, r9.getDisplayMetrics()));
        setLayoutParams(r4);
        return;
    L21:
        throw new b0("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L15:
        r1 = 2;
        goto L16
    L7:
        r0 = OAvatar.a.f10749k;
        goto L13
    L8:
        r0 = OAvatar.a.f10748j;
        goto L13
    L9:
        r0 = OAvatar.a.f10747i;
        goto L13
    L10:
        r0 = OAvatar.a.f10746h;
        goto L13
    L11:
        r0 = OAvatar.a.f10745g;
        goto L13
    L5:
        throw new IllegalArgumentException("disallow the size: " + r6);
    }
}
