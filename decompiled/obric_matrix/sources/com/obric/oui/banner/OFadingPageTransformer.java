package com.obric.oui.banner;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0007\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0013\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/banner/OFadingPageTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "Lkotlin/Function0;", "Lkotlin/f0;", "actionWithTargetApi", "actionWithLowerApi", "a", "(Lkotlin/n0/c/a;Lkotlin/n0/c/a;)V", "Landroid/view/View;", "view", "", "position", "transformPage", "(Landroid/view/View;F)V", "", "I", "b", "()I", "transformColor", "<init>", "(I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10787a;

    static final class a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OFadingPageTransformer f10788f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f10789g;

        a(OFadingPageTransformer r1, View r2) {
            this.f10788f = r1;
            this.f10789g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.f10789g.getForeground() != null) goto L6;
            View r0 = this.f10789g;
            GradientDrawable r1 = new GradientDrawable();
            r1.setAlpha(0);
            r1.setColor(ContextCompat.getColorStateList(this.f10789g.getContext(), this.f10788f.b()));
            f0 r3 = f0.f18324a;
            r0.setForeground(r1);
            return;
        }
    }

    static final class b extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f10790f = null;

        static {
            f10790f = new b();
        }

        b() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    static final class c extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f10791f;

        c(View r1) {
            this.f10791f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Drawable r1 = this.f10791f.getForeground();
            if (r1 == null) goto L6;
            r1.setAlpha(0);
            return;
        }
    }

    static final class d extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f10792f;

        d(View r1) {
            this.f10792f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f10792f.setAlpha(0.0f);
        }
    }

    static final class e extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f10793f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f10794g;

        e(View r1, float r2) {
            this.f10793f = r1;
            this.f10794g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Drawable r0 = this.f10793f.getForeground();
            o.e(r0, "view.foreground");
            r0.setAlpha((int) ((1 - this.f10794g) * 255));
        }
    }

    static final class f extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f10795f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f10796g;

        f(View r1, float r2) {
            this.f10795f = r1;
            this.f10796g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f10795f.setAlpha(this.f10796g);
        }
    }

    static final class g extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f10797f;

        g(View r1) {
            this.f10797f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Drawable r1 = this.f10797f.getForeground();
            if (r1 == null) goto L6;
            r1.setAlpha(0);
            return;
        }
    }

    static final class h extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f10798f;

        h(View r1) {
            this.f10798f = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.f10798f.setAlpha(0.0f);
        }
    }

    static {
    }

    public OFadingPageTransformer() {
        this(0, 1, null);
    }

    public OFadingPageTransformer(@ColorRes int r1) {
        this.f10787a = r1;
    }

    public /* synthetic */ OFadingPageTransformer(int r1, int r2, kotlin.n0.d.g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = com.obric.common.oui.c.u;
    L5:
        this(r1);
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private final void a(kotlin.n0.c.a<f0> r2, kotlin.n0.c.a<f0> r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r2.invoke();
        return;
    L5:
        r3.invoke();
    }

    public final int b() {
        return this.f10787a;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    @SuppressLint({"AnnotateVersionCheck"})
    public void transformPage(View r3, float r4) {
        o.f(r3, "view");
        a(new a(this, r3), b.f10790f);
        if (r4 >= (-1)) goto L5;
        kotlin.n0.c.a<f0> r5 = new c(r3);
        kotlin.n0.c.a<f0> r0 = new d(r3);
    L9:
        a(r5, r0);
        return;
    L5:
        float r1 = 1;
        if (r4 > r1) goto L8;
        float r6 = Math.max(0.5f, r1 - Math.abs(r4));
        a(new e(r3, r6), new f(r3, r6));
        return;
    L8:
        r5 = new g(r3);
        r0 = new h(r3);
        goto L9
    }
}
