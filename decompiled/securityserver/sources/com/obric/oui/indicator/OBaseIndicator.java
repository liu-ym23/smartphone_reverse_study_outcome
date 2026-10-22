package com.obric.oui.indicator;

import a.a;
import android.database.DataSetObserver;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.obric.oui.utils.log.L;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class OBaseIndicator extends FrameLayout {
    public boolean b;
    public boolean c;
    public boolean e;
    public boolean f;
    public boolean i;
    public float j;
    public float k;
    public float l;
    public int m;
    public float n;
    public int o;
    public int p;
    public float q;
    public boolean r;
    public int s;
    public float t;
    public Pager u;
    public ReleaseMe v;

    @Metadata
    public static final class CustomDot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f228a;
        public final float b;
        public final float c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f229d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final int m;
        public final int n;

        public CustomDot(float r1, float r2, float r3, int[] r4) {
            this.f228a = r1;
            this.b = r2;
            this.c = r3;
            this.f229d = r4;
            this.e = 11;
            this.f = 9;
            this.g = 7;
            this.h = 3;
            this.i = 4;
            this.j = 1;
            this.k = 2;
            this.l = 0;
            this.m = 5;
            this.n = 6;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof CustomDot) == false) goto L34;
            CustomDot r4 = (CustomDot) r3;
            float r0 = r4.f228a;
            if (Float.compare(this.f228a, r0) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.b, r4.b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.c, r4.c) == 0) goto L12;
            return false;
        L12:
            if (Intrinsics.a(this.f229d, r4.f229d) == true) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L18;
            return false;
        L18:
            if (this.g == r4.g) goto L20;
            return false;
        L20:
            if (this.h == r4.h) goto L22;
            return false;
        L22:
            if (this.i == r4.i) goto L24;
            return false;
        L24:
            if (this.j == r4.j) goto L26;
            return false;
        L26:
            if (this.k == r4.k) goto L28;
            return false;
        L28:
            if (this.l == r4.l) goto L30;
            return false;
        L30:
            if (this.m == r4.m) goto L32;
            return false;
        L32:
            if (this.n == r4.n) goto L52;
            return false;
        L52:
            return true;
        L34:
            return false;
        }

        public final int hashCode() {
            int r0 = Float.hashCode(this.f228a) * 31;
            int r1 = a.b(this.b, r0, 31);
            int r2 = a.b(this.c, r1, 31);
            int[] r3 = this.f229d;
            if (r3 == null) goto L5;
            int r4 = Arrays.hashCode(r3);
        L6:
            int r5 = (r2 + r4) * 31;
            int r6 = a.c(this.e, r5, 31);
            int r7 = a.c(this.f, r6, 31);
            int r8 = a.c(this.g, r7, 31);
            int r9 = a.c(this.h, r8, 31);
            int r10 = a.c(this.i, r9, 31);
            int r11 = a.c(this.j, r10, 31);
            int r12 = a.c(this.k, r11, 31);
            int r13 = a.c(this.l, r12, 31);
            int r14 = a.c(this.m, r13, 31);
            return Integer.hashCode(this.n) + r14;
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            StringBuilder r0 = new StringBuilder("CustomDot(defaultWidth=");
            r0.append(this.f228a);
            r0.append(", defaultHeight=");
            r0.append(this.b);
            r0.append(", defaultSpacing=");
            r0.append(this.c);
            r0.append(", styleableId=");
            r0.append(Arrays.toString(this.f229d));
            r0.append(", typeId=");
            r0.append(this.e);
            r0.append(", layoutHeightId=");
            r0.append(this.f);
            r0.append(", dotsWidthId=");
            r0.append(this.g);
            r0.append(", dotsHeightId=");
            r0.append(this.h);
            r0.append(", dotsSpacingId=");
            r0.append(this.i);
            r0.append(", dotsColorId=");
            r0.append(this.j);
            r0.append(", dotsCornerRadiusId=");
            r0.append(this.k);
            r0.append(", dotsClickableId=");
            r0.append(this.l);
            r0.append(", dotsStrokeColorId=");
            r0.append(this.m);
            r0.append(", dotsStrokeWidthId=");
            return a.n(r0, ")", this.n);
        }
    }

    @Metadata
    public interface Pager {
        int a();

        void b();

        void c(OnPageChangeListenerHelper r1);

        boolean d();

        int getCount();
    }

    @Metadata
    public interface ReleaseMe {
        Function1 a();
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$2, reason: invalid class name */
    @Metadata
    public final class AnonymousClass2 extends DataSetObserver implements ReleaseMe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OBaseIndicator f230a;
        public final /* synthetic */ ViewPager b;

        public AnonymousClass2(OBaseIndicator r1, ViewPager r2) {
            this.f230a = r1;
            this.b = r2;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.ReleaseMe
        public final Function1 a() {
            return new OBaseIndicator$setViewPager$2$releaseAction$1(this);
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            super.onChanged();
            OBaseIndicator r1 = this.f230a;
            if (r1.u == null) goto L7;
            r1.post(new OBaseIndicator$refreshDots$1(r1));
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$3, reason: invalid class name */
    @Metadata
    public final class AnonymousClass3 implements Pager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OBaseIndicator$setViewPager$3$addOnPageChangeListener$1 f231a;
        public final /* synthetic */ OBaseIndicator b;
        public final /* synthetic */ ViewPager c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f232d;

        public AnonymousClass3(OBaseIndicator r1, ViewPager r2, Function0 r3) {
            this.b = r1;
            this.c = r2;
            this.f232d = r3;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public final int a() {
            int r0 = this.c.getCurrentItem();
            int r1 = getCount();
            return OBaseIndicator.a(this.b, r0, r1);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public final void b() {
            OBaseIndicator$setViewPager$3$addOnPageChangeListener$1 r0 = this.f231a;
            if (r0 == null) goto L6;
            this.c.removeOnPageChangeListener(r0);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewpager.widget.ViewPager$OnPageChangeListener, com.obric.oui.indicator.OBaseIndicator$setViewPager$3$addOnPageChangeListener$1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public final void c(final OnPageChangeListenerHelper r2) {
            Intrinsics.f(r2, "onPageChangeListenerHelper");
            ?? r0 = new OBaseIndicator$setViewPager$3$addOnPageChangeListener$1(this, r2);
            this.f231a = r0;
            this.c.addOnPageChangeListener(r0);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public final boolean d() {
            ViewPager r1 = this.c;
            Intrinsics.f(r1, "$this$isNotEmpty");
            PagerAdapter r2 = r1.getAdapter();
            if (r2 == null) goto L5;
            int r3 = r2.getCount();
        L6:
            if (r3 <= 0) goto L9;
            return true;
        L9:
            return false;
        L5:
            r3 = 0;
            goto L6
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.Pager
        public final int getCount() {
            return ((Number) this.f232d.invoke()).intValue();
        }
    }

    public static final int a(OBaseIndicator r1, int r2, int r3) {
        r1.getClass();
        if (r3 != 0) goto L15;
        L.g(null, "mod num is 0");
        throw null;
    L15:
        return r2 % r3;
    L6:
        e = move-exception;
        if ((e instanceof ArithmeticException) == false) goto L11;
        L.g(null, "不要乱除0呀 " + e.getMessage());
        throw null;
    L11:
        L.g(null, "抓住了一个Exception并ignore, " + e.getMessage());
        throw null;
    }

    private final void setPagerDataSetObserver(ReleaseMe r3) {
        ReleaseMe r0 = this.v;
        if (r0 == null) goto L5;
        Function1 r1 = r0.a();
        ReleaseMe r2 = this.v;
        Intrinsics.c(r2);
        r1.invoke(r2);
    L5:
        this.v = r3;
    }

    public abstract OCarouselIndicator$buildOnPageChangedListener$1 b();

    public final void c() {
        if (this.b == true) goto L6;
        this.e = true;
        return;
    L6:
        this.e = false;
        throw null;
    }

    public final void d() {
        if (this.b == true) goto L6;
        this.i = true;
        return;
    L6:
        int r0 = 0;
        this.i = false;
        Pager r1 = this.u;
        if (r1 != null) goto L9;
        return;
    L9:
        Intrinsics.c(r1);
        int r2 = r1.getCount();
    L10:
        if (r0 >= r2) goto L16;
        Pager r3 = this.u;
        Intrinsics.c(r3);
        if (r0 != r3.a()) goto L15;
        r0 = r0 + 1;
        goto L10
    L15:
        throw null;
    }

    public abstract void e();

    @NotNull
    public abstract CustomDot getCustom();

    public final boolean getDotsClickable() {
        return this.r;
    }

    public final int getDotsColor() {
        return this.p;
    }

    public final float getDotsCornerRadius() {
        return this.q;
    }

    public final float getDotsHeight() {
        return this.k;
    }

    public final float getDotsSpacing() {
        return this.n;
    }

    public final int getDotsStrokeColor() {
        return this.s;
    }

    public final float getDotsStrokeWidth() {
        return this.t;
    }

    public final float getDotsWidth() {
        return this.j;
    }

    public final boolean getInitialized() {
        return this.b;
    }

    public final float getLayoutHeight() {
        return this.l;
    }

    @Nullable
    public final Pager getPager() {
        return this.u;
    }

    public final boolean getPendingRefreshParentLayout() {
        return this.c;
    }

    public final int getSidePadding() {
        return this.m;
    }

    public final int getType() {
        return this.o;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.u == null) goto L6;
        post(new OBaseIndicator$refreshDots$1(this));
    L6:
        post(new OBaseIndicator$postPendingRefresh$1(this));
    }

    public final void setDotsClickable(boolean r1) {
        this.r = r1;
    }

    public final void setDotsColor(int r3) {
        if (this.o != 1) goto L5;
        this.p = 872415231;
        c();
        return;
    L5:
        if (this.p == r3) goto L9;
        this.p = r3;
        c();
        return;
    }

    public final void setDotsCornerRadius(float r2) {
        if (this.q == r2) goto L6;
        this.q = r2;
        c();
        return;
    }

    public final void setDotsHeight(float r2) {
        if (this.k == r2) goto L6;
        this.k = r2;
        d();
        return;
    }

    public final void setDotsSpacing(float r2) {
        if (this.n == r2) goto L15;
        this.n = r2;
        if (this.b == true) goto L7;
        this.f = true;
        return;
    L7:
        this.f = false;
        Pager r1 = this.u;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.a() > 0) goto L14;
        return;
    L14:
        throw null;
    }

    public final void setDotsStrokeColor(int r2) {
        if (this.s == r2) goto L6;
        this.s = r2;
        c();
        return;
    }

    public final void setDotsStrokeWidth(float r2) {
        if (this.t == r2) goto L6;
        this.t = r2;
        c();
        return;
    }

    public final void setDotsWidth(float r2) {
        if (this.j == r2) goto L6;
        this.j = r2;
        d();
        return;
    }

    public final void setInitialized(boolean r1) {
        this.b = r1;
    }

    public final void setLayoutHeight(float r2) {
        if (this.l == r2) goto L6;
        this.l = r2;
        e();
        return;
    }

    public final void setPager(@Nullable Pager r2) {
        Pager r0 = this.u;
        if (r0 == null) goto L5;
        Intrinsics.c(r0);
        r0.b();
    L5:
        this.u = r2;
    }

    public final void setPendingRefreshParentLayout(boolean r1) {
        this.c = r1;
    }

    public final void setSidePadding(int r2) {
        if (this.m == r2) goto L6;
        this.m = r2;
        e();
        return;
    }

    public final void setType(int r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        e();
        c();
        return;
    }

    @Deprecated
    public final void setViewPager(@NotNull ViewPager r4) {
        Intrinsics.f(r4, "viewPager");
        PagerAdapter r0 = r4.getAdapter();
        if (r0 == null) goto L5;
        final int r1 = r0.getCount();
    L6:
        Function0<Integer> r2 = new AnonymousClass1(r1);
        if (r4.getAdapter() == null) goto L18;
        setPagerDataSetObserver(new AnonymousClass2(this, r4));
        PagerAdapter r3 = r4.getAdapter();
        Intrinsics.c(r3);
        Object r5 = this.v;
        if (r5 == null) goto L16;
        r3.registerDataSetObserver((DataSetObserver) r5);
        setPager(new AnonymousClass3(this, r4, r2));
        if (this.u == null) goto L19;
        post(new OBaseIndicator$refreshDots$1(this));
        return;
    L19:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.database.DataSetObserver");
    L18:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    L5:
        r1 = 1;
        goto L6
    }
}
