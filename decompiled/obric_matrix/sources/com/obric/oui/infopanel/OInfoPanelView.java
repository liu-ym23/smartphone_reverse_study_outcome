package com.obric.oui.infopanel;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.common.util.j;
import com.obric.oui.text.OTextView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0005*\u0001'\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0018\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001bR\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/obric/oui/infopanel/OInfoPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/f0;", "f", "()V", "g", "Landroid/widget/ImageView;", "getTopBannerView", "()Landroid/widget/ImageView;", "getTopImgView", "", "resId", "setInsetTopImg", "(I)V", "setUnInsetImg", "Landroid/view/ViewGroup;", "getCustomContainer", "()Landroid/view/ViewGroup;", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "desc", "setDesc", "setScrollableDesc", "Lcom/obric/oui/text/OTextView;", "j", "Lcom/obric/oui/text/OTextView;", "tvTitle", "i", "Landroid/widget/ImageView;", "ivImg", "h", "Landroid/view/ViewGroup;", "customContainer", "k", "tvDesc", "headerContainer", "contentContainer", "com/obric/oui/infopanel/a", "l", "Lcom/obric/oui/infopanel/a;", "fixDescHeightListener", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OInfoPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewGroup f11105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ViewGroup f11106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ViewGroup f11107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImageView f11108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final OTextView f11109j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final OTextView f11110k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a f11111l;

    private final void f() {
        ViewGroup r0 = this.f11105f;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        r0.setPadding(0, kotlin.o0.a.a(TypedValue.applyDimension(1, 32, r2.getDisplayMetrics())), 0, 0);
        if (this.f11106g.getLayoutParams() == null) goto L6;
        ViewGroup r6 = this.f11106g;
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1;
        int r4 = r3.leftMargin;
        Resources r5 = Resources.getSystem();
        o.e(r5, "Resources.getSystem()");
        r3.setMargins(r4, kotlin.o0.a.a(TypedValue.applyDimension(1, 16, r5.getDisplayMetrics())), r3.rightMargin, r3.bottomMargin);
        f0 r7 = f0.f18324a;
        r6.setLayoutParams(r3);
        return;
    }

    private final void g() {
        this.f11105f.setPadding(0, 0, 0, 0);
        if (this.f11106g.getLayoutParams() == null) goto L6;
        ViewGroup r6 = this.f11106g;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        int r2 = r1.leftMargin;
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        r1.setMargins(r2, kotlin.o0.a.a(TypedValue.applyDimension(1, 24, r4.getDisplayMetrics())), r1.rightMargin, r1.bottomMargin);
        f0 r3 = f0.f18324a;
        r6.setLayoutParams(r1);
        return;
    }

    public final ViewGroup getCustomContainer() {
        return this.f11107h;
    }

    public final ImageView getTopBannerView() {
        g();
        return this.f11108i;
    }

    public final ImageView getTopImgView() {
        f();
        return this.f11108i;
    }

    public final void setDesc(CharSequence r2) {
        if (r2 != null) goto L4;
        j.e(this.f11110k);
        ViewGroup.LayoutParams r1 = this.f11110k.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r1).topMargin = 0;
        return;
    L4:
        this.f11110k.setText(r2);
        j.g(this.f11110k);
    }

    public final void setInsetTopImg(int r1) {
        getTopBannerView().setImageResource(r1);
    }

    public final void setScrollableDesc(CharSequence r1) {
        setDesc(r1);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f11111l);
    }

    public final void setTitle(CharSequence r2) {
        o.f(r2, "title");
        this.f11109j.setText(r2);
    }

    public final void setUnInsetImg(int r1) {
        getTopImgView().setImageResource(r1);
    }
}
