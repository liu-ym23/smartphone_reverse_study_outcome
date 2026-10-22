package com.obric.oui.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f176a;

    @Metadata
    public static final class Companion {
    }

    /* JADX INFO: renamed from: com.obric.oui.banner.OFadingPageTransformer$transformPage$2, reason: invalid class name */
    @Metadata
    final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Object invoke() {
            return Unit.f330a;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.banner.OFadingPageTransformer$transformPage$4, reason: invalid class name */
    @Metadata
    final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.banner.OFadingPageTransformer$transformPage$6, reason: invalid class name */
    @Metadata
    final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.banner.OFadingPageTransformer$transformPage$8, reason: invalid class name */
    @Metadata
    final class AnonymousClass8 extends Lambda implements Function0<Unit> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            throw null;
        }
    }

    public OFadingPageTransformer() {
        this.f176a = R.color.Transparent;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void transformPage(final View r2, float r3) {
        Intrinsics.f(r2, "view");
        new AnonymousClass1(this, r2).invoke();
        if (r3 >= (-1)) goto L5;
        new AnonymousClass3(r2).invoke();
        return;
    L5:
        float r1 = 1;
        if (r3 > r1) goto L8;
        final float r4 = Math.max(0.5f, r1 - Math.abs(r3));
        new AnonymousClass5(r2, r4).invoke();
        return;
    L8:
        new AnonymousClass7(r2).invoke();
    }
}
