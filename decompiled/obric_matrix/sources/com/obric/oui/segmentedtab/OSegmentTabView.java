package com.obric.oui.segmentedtab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import d.g.d.f.f.b;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.r0.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bR\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006."}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabView;", "Lcom/obric/oui/segmentedtab/a;", "", "fraction", "", "scene", "Lkotlin/f0;", "h", "(FLjava/lang/String;)V", "g", "", "originIconAlpha", "setOriginIconAlpha", "(I)V", "", "c", "()Z", "animFraction", "d", "k", "I", "mTextSelectColor", "l", "mTextUnselectColor", "j", "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "iconView", "m", "p", "Z", "selectState", "Landroid/widget/TextView;", "n", "Landroid/widget/TextView;", "tabTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OSegmentTabView extends a {
    private static int q;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f11350j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11351k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11352l;
    private int m;
    private TextView n;
    private ImageView o;
    private boolean p;

    static {
    }

    public OSegmentTabView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public OSegmentTabView(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
        StringBuilder r5 = new StringBuilder();
        r5.append("OSegmentTabView_");
        int r6 = q;
        q = r6 + 1;
        r5.append(r6);
        this.f11350j = r5.toString();
    }

    public /* synthetic */ OSegmentTabView(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    private final void g(float r5, String r6) {
        int r0 = e.i((int) (this.m * a.f11360i.a(r5)), 0, 255);
        ImageView r1 = this.o;
        if (r1 == null) goto L6;
        r1.setImageAlpha(r0);
        b.a(this.f11350j, "updateIconAlphaOnPress, scene: " + r6 + ", fraction: " + r5 + ", alpha: " + r0 + ", originIconAlpha: " + this.m);
        return;
    L6:
        o.v("iconView");
        throw null;
    }

    private final void h(float r9, String r10) {
        int r0 = r10.hashCode();
        if (r0 == (-1965932727)) goto L11;
        if (r0 == 1870923917) goto L8;
    L13:
        int r1 = 0;
    L14:
        if (r1 != 0) goto L16;
        return;
    L16:
        int r2 = (r1 >> 24) & 255;
        int r3 = e.i((int) (r2 * a.f11360i.a(r9)), 0, 255);
        int r4 = (r1 & 255) | (((r3 << 24) | (((r1 >> 16) & 255) << 16)) | (((r1 >> 8) & 255) << 8));
        TextView r5 = this.n;
        if (r5 == null) goto L20;
        r5.setTextColor(r4);
        b.a(this.f11350j, "updateTextColorOnPress, scene: " + r10 + ", fraction: " + r9 + ", newTextAlpha: " + r3 + ", originTextAlpha: " + r2);
        return;
    L20:
        o.v("tabTitle");
        throw null;
    L8:
        if (r10.equals("press_anim") == false) goto L13;
        r1 = this.f11352l;
        goto L14
    L11:
        if (r10.equals("release_anim") == false) goto L13;
        r1 = this.f11351k;
        goto L14
    }

    @Override // com.obric.oui.segmentedtab.a
    public boolean c() {
        return !this.p;
    }

    @Override // com.obric.oui.segmentedtab.a
    public void d(float r4, String r5) {
        o.f(r5, "scene");
        b.a(this.f11350j, "onTouchAnimUpdate, scene: " + r5 + ", animFraction: " + r4);
        h(r4, r5);
        g(r4, r5);
    }

    public final void setOriginIconAlpha(int r1) {
        this.m = r1;
    }
}
