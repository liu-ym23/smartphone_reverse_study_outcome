package com.obric.oui.titlebar.optimize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.common.oui.c;
import com.obric.common.oui.d;
import com.obric.common.oui.e;
import com.obric.common.oui.j;
import com.obric.common.oui.k;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OBaseTextView;
import d.g.d.f.f.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010x\u001a\u00020w\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010y\u001a\u00020$¢\u0006\u0004\bz\u0010{J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0004\b!\u0010\u0016J\u001f\u0010%\u001a\u00020$2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\"H\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b*\u0010+J\u0015\u0010\u0015\u001a\u00020\u00022\u0006\u0010,\u001a\u00020$¢\u0006\u0004\b\u0015\u0010-J\u0015\u0010.\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b.\u0010+J/\u00102\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020$2\b\b\u0002\u00101\u001a\u00020$¢\u0006\u0004\b2\u00103J\u001f\u00106\u001a\u00020\u00022\u0006\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020$H\u0014¢\u0006\u0004\b6\u00107R\u0013\u0010:\u001a\u00020$8F@\u0006¢\u0006\u0006\u001a\u0004\b8\u00109R.\u0010@\u001a\u0004\u0018\u00010\u00132\b\u0010;\u001a\u0004\u0018\u00010\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010\u0016R\u0013\u0010B\u001a\u00020$8F@\u0006¢\u0006\u0006\u001a\u0004\bA\u00109R*\u0010I\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010KR$\u0010S\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010X\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010+R\u0016\u0010Z\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010YR\u0016\u0010\\\u001a\u00020\u001a8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u001cR$\u0010a\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010]\u001a\u0004\b^\u0010\u001c\"\u0004\b_\u0010`R$\u0010d\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010T\u001a\u0004\bb\u0010V\"\u0004\bc\u0010+R*\u0010g\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010D\u001a\u0004\be\u0010F\"\u0004\bf\u0010HR\u0016\u0010i\u001a\u00020\u001a8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u001cR\u001c\u0010k\u001a\b\u0012\u0004\u0012\u00020\r0C8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010FR\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020\r0C8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010FR$\u0010p\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010]\u001a\u0004\bn\u0010\u001c\"\u0004\bo\u0010`R$\u0010s\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010T\u001a\u0004\bq\u0010V\"\u0004\br\u0010+R.\u0010v\u001a\u0004\u0018\u00010\u00132\b\u0010;\u001a\u0004\u0018\u00010\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010<\u001a\u0004\bt\u0010>\"\u0004\bu\u0010\u0016¨\u0006|"}, d2 = {"Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "Landroid/widget/RelativeLayout;", "Lkotlin/f0;", "d", "()V", "q", "Landroid/util/AttributeSet;", "attrs", "n", "(Landroid/util/AttributeSet;)V", "", "o", "()Z", "Landroid/view/View;", "view", "Landroid/widget/RelativeLayout$LayoutParams;", "params", "r", "(Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;)V", "", "title", "setCenterText", "(Ljava/lang/String;)V", "setCenterSubText", "g", "p", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "k", "j", "()Landroid/widget/RelativeLayout$LayoutParams;", "scene", "h", "", "list", "", "m", "(Ljava/util/List;)I", "centerView", "i", "(Landroid/view/View;Z)Landroid/widget/RelativeLayout$LayoutParams;", "setCenterView", "(Landroid/view/View;)V", "resId", "(I)V", "e", "layoutParams", "index", "marginLeft", "f", "(Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;II)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "getLeftViewCount", "()I", "leftViewCount", "value", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "subTitleText", "getRightViewCount", "rightViewCount", "", "Ljava/util/List;", "getMRightViewList", "()Ljava/util/List;", "setMRightViewList", "(Ljava/util/List;)V", "mRightViewList", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayoutListener", "Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/button/OButton;", "getMLeftActionBack", "()Lcom/obric/oui/button/OButton;", "setMLeftActionBack", "(Lcom/obric/oui/button/OButton;)V", "mLeftActionBack", "Landroid/view/View;", "getMCenterView", "()Landroid/view/View;", "setMCenterView", "mCenterView", "Z", "autoAdjustTitleSpace", "getTitleViewOrCreate", "titleViewOrCreate", "Landroid/widget/TextView;", "getMTitleView", "setMTitleView", "(Landroid/widget/TextView;)V", "mTitleView", "getMLeftLastView", "setMLeftLastView", "mLeftLastView", "getMLeftViewList", "setMLeftViewList", "mLeftViewList", "getSubtitleViewOrCreate", "subtitleViewOrCreate", "getLeftViewListOrCreate", "leftViewListOrCreate", "getRightViewListOrCreate", "rightViewListOrCreate", "getMSubTitleView", "setMSubTitleView", "mSubTitleView", "getMRightLastView", "setMRightLastView", "mRightLastView", "getTitleText", "setTitleText", "titleText", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OCTitleBar extends RelativeLayout {
    private static final int r = 0;
    private static final int s = 0;
    private static final int t = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f11596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f11597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f11598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<View> f11599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<View> f11600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OButton f11601l;
    private TextView m;
    private String n;
    private TextView o;
    private String p;
    private final ViewTreeObserver.OnGlobalLayoutListener q;

    static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OCTitleBar f11602f;

        a(OCTitleBar r1) {
            this.f11602f = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            OCTitleBar.c(this.f11602f);
            if (OCTitleBar.b(this.f11602f) == true) goto L5;
            return;
        L5:
            OCTitleBar.a(this.f11602f, "OnGlobalLayoutListener");
        }
    }

    static {
        r = e.M;
        s = c.O;
        t = c.Q;
    }

    public OCTitleBar(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public OCTitleBar(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
        this.q = new a(this);
        if (r3 == null) goto L6;
        n(r3);
    L6:
        if (o() == false) goto L9;
        d();
        return;
    }

    public /* synthetic */ OCTitleBar(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ void a(OCTitleBar r0, String r1) {
        r0.h(r1);
    }

    public static final /* synthetic */ boolean b(OCTitleBar r0) {
        return r0.o();
    }

    public static final /* synthetic */ void c(OCTitleBar r0) {
        r0.q();
    }

    private final void d() {
        getViewTreeObserver().addOnGlobalLayoutListener(this.q);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.c("OCTitleBar", "addGlobalLayoutListener: ", e);
    }

    private final void g() {
        TextView r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.o == null) goto L13;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;
        r2.removeRule(13);
        r2.addRule(14);
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        r2.topMargin = kotlin.o0.a.a(TypedValue.applyDimension(1, 9, r3.getDisplayMetrics()));
        Context r4 = getContext();
        o.e(r4, "context");
        Resources r5 = r4.getResources();
        o.e(r5, "context.resources");
        if (r5.getConfiguration().fontScale <= 1.0f) goto L14;
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        r2.topMargin = kotlin.o0.a.a(TypedValue.applyDimension(1, 6, r6.getDisplayMetrics()));
        TextView r7 = this.o;
        if (r7 == null) goto L15;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        Resources r9 = Resources.getSystem();
        o.e(r9, "Resources.getSystem()");
        ((RelativeLayout.LayoutParams) r8).topMargin = kotlin.o0.a.a(TypedValue.applyDimension(1, 31, r9.getDisplayMetrics()));
        return;
    L15:
        return;
    L14:
        return;
    }

    private final List<View> getLeftViewListOrCreate() {
        if (this.f11599j != null) goto L5;
        this.f11599j = new ArrayList();
    L5:
        List<View> r1 = this.f11599j;
        o.c(r1);
        return r1;
    }

    private final List<View> getRightViewListOrCreate() {
        if (this.f11600k != null) goto L5;
        this.f11600k = new ArrayList();
    L5:
        List<View> r1 = this.f11600k;
        o.c(r1);
        return r1;
    }

    private final TextView getSubtitleViewOrCreate() {
        TextView r0 = this.o;
        if (r0 == null) goto L6;
        o.c(r0);
        return r0;
    L6:
        this.o = k();
        ViewGroup.LayoutParams r1 = generateDefaultLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;
        r2.addRule(14);
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        r2.topMargin = kotlin.o0.a.a(TypedValue.applyDimension(1, 30, r3.getDisplayMetrics()));
        addView(this.o, r2);
        TextView r5 = this.o;
        o.c(r5);
        return r5;
    }

    private final TextView getTitleViewOrCreate() {
        View r0 = this.f11596g;
        if (r0 == null) goto L8;
        TextView r1 = this.m;
        if (r0 != r1) goto L8;
    L6:
        o.c(r1);
        return r1;
    L8:
        if (this.m != null) goto L11;
        this.m = l();
    L11:
        if (this.f11596g == null) goto L13;
        p();
    L13:
        addView(this.m, j());
        r1 = this.m;
        this.f11596g = r1;
        goto L6
    }

    private final void h(String r8) {
        Rect r0 = new Rect();
        Rect r1 = new Rect();
        List<View> r2 = this.f11599j;
        if (r2 == null) goto L8;
        Iterator<T> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        View r4 = (View) r3.next();
        Rect r5 = new Rect();
        r4.getGlobalVisibleRect(r5);
        r0.union(r5.left, r5.top, r5.right, r5.bottom);
    L8:
        List<View> r6 = this.f11600k;
        if (r6 == null) goto L15;
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L15;
        View r9 = (View) r7.next();
        Rect r10 = new Rect();
        r9.getGlobalVisibleRect(r10);
        r1.union(r10.left, r10.top, r10.right, r10.bottom);
    L15:
        if (r0.isEmpty() == false) goto L17;
        int r11 = 0;
    L18:
        int r12 = kotlin.r0.e.c(r11, 0);
        if (r1.isEmpty() == false) goto L21;
        int r13 = 0;
    L22:
        int r14 = kotlin.r0.e.c(r13, 0);
        int r15 = Math.max(r12, r14);
        b.a("OCTitleBar", "adjustTitleViewSpace, scene: " + r8 + ", leftSpace: " + r12 + ", rightSpace: " + r14 + ", leftViewRectF: " + r0 + ", rightViewRectF: " + r1 + ", width: " + getWidth() + ", height: " + getHeight());
        if (r15 <= 0) goto L51;
        d.g.d.f.b r16 = d.g.d.f.b.f16934a;
        TextView r17 = this.m;
        ViewGroup.LayoutParams r18 = null;
        if (r17 == null) goto L27;
        ViewGroup.LayoutParams r19 = r17.getLayoutParams();
    L28:
        if (r19 != null) goto L31;
    L29:
        r19 = null;
    L32:
        RelativeLayout.LayoutParams r20 = (RelativeLayout.LayoutParams) r19;
        if (r20 == null) goto L35;
        r20.leftMargin = r15;
        r20.rightMargin = r15;
    L35:
        TextView r21 = this.o;
        if (r21 == null) goto L38;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L39:
        if (r22 != null) goto L42;
    L44:
        RelativeLayout.LayoutParams r23 = (RelativeLayout.LayoutParams) r18;
        if (r23 == null) goto L47;
        r23.leftMargin = r15;
        r23.rightMargin = r15;
    L47:
        requestLayout();
        return;
    L42:
        if ((r22 instanceof RelativeLayout.LayoutParams) == false) goto L44;
        r18 = r22;
        goto L44
    L38:
        r22 = null;
        goto L39
    L31:
        if ((r19 instanceof RelativeLayout.LayoutParams) == false) goto L29;
    L27:
        r19 = null;
        goto L28
    L51:
        return;
    L21:
        r13 = getWidth() - r1.left;
        goto L22
    L17:
        r11 = r0.right;
        goto L18
    }

    private final RelativeLayout.LayoutParams i(View r2, boolean r3) {
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if ((r4 instanceof RelativeLayout.LayoutParams) == true) goto L10;
        if (r3 == false) goto L7;
        ViewGroup.LayoutParams r1 = j();
    L8:
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        return (RelativeLayout.LayoutParams) r1;
    L7:
        r1 = generateDefaultLayoutParams();
        goto L8
    L10:
        return (RelativeLayout.LayoutParams) r4;
    }

    private final RelativeLayout.LayoutParams j() {
        ViewGroup.LayoutParams r1 = generateDefaultLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;
        r2.addRule(13);
        return r2;
    }

    @SuppressLint({"NewApi"})
    private final TextView k() {
        Context r1 = getContext();
        o.e(r1, "context");
        OBaseTextView r6 = new OBaseTextView(r1, null, 0, 6, null);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextAppearance(j.f8277b);
        Context r0 = r6.getContext();
        o.e(r0, "context");
        r6.setTextColor(r0.getResources().getColor(t));
        return r6;
    }

    @SuppressLint({"NewApi"})
    private final TextView l() {
        Context r1 = getContext();
        o.e(r1, "context");
        OBaseTextView r6 = new OBaseTextView(r1, null, 0, 6, null);
        r6.setMaxLines(1);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextAppearance(j.f8286k);
        Context r0 = r6.getContext();
        o.e(r0, "context");
        r6.setTextColor(r0.getResources().getColor(s));
        return r6;
    }

    private final int m(List<? extends View> r5) {
        int r4 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.size() <= 0) goto L18;
        int r0 = r5.size();
        int r1 = 0;
    L7:
        if (r4 >= r0) goto L13;
        if (r5.get(r4).getVisibility() == 8) goto L11;
        r1 = r1 + 1;
    L11:
        r4 = r4 + 1;
        goto L7
    L13:
        return r1;
    L18:
        return 0;
    }

    private final void n(AttributeSet r6) {
        Context r0 = getContext();
        o.e(r0, "context");
        TypedArray r7 = r0.getTheme().obtainStyledAttributes(r6, k.u, 0, 0);
        int r1 = r7.getInt(k.x, com.obric.oui.titlebar.a.f11543g.a());
        com.obric.oui.titlebar.a r2 = com.obric.oui.titlebar.a.values()[r1];
        String r3 = r7.getString(k.y);
        if (r3 == null) goto L6;
        setCenterText(r3);
    L6:
        if (r7.getBoolean(k.z, true) == false) goto L8;
        Context r4 = getContext();
        o.e(r4, "context");
        OButton r5 = com.obric.oui.titlebar.optimize.a.b(this, r4);
        r5.setButtonSourceBitmap(r);
        this.f11601l = r5;
        f0 r8 = f0.f18324a;
        e(r5);
    L8:
        String r9 = r7.getString(k.w);
        if (r9 == null) goto L11;
        setCenterSubText(r9);
    L11:
        this.f11595f = r7.getBoolean(k.v, true);
        Context r10 = getContext();
        o.e(r10, "context");
        int r11 = (int) r10.getResources().getDimension(d.f8221h);
        setPadding(r11, 0, r11, 0);
    }

    private final boolean o() {
        return this.f11595f;
    }

    private final void p() {
        View r0 = this.f11596g;
        if (r0 == null) goto L6;
        removeView(r0);
        this.f11596g = null;
        return;
    }

    private final void q() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.q);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        b.c("OCTitleBar", "removeGlobalLayoutListener: ", e);
    }

    private final void r(View r2, RelativeLayout.LayoutParams r3) {
        if (o.a(this.f11596g, r2) == false) goto L5;
        return;
    L5:
        p();
        this.f11596g = r2;
        addView(r2, r3);
    }

    private final void setCenterSubText(String r2) {
        getSubtitleViewOrCreate().setText(r2);
        g();
    }

    private final void setCenterText(String r1) {
        getTitleViewOrCreate().setText(r1);
    }

    public final void e(View r4) {
        o.f(r4, "view");
        f(r4, i(r4, false), getLeftViewCount(), 0);
    }

    public final void f(View r4, RelativeLayout.LayoutParams r5, int r6, int r7) {
        o.f(r4, "view");
        o.f(r5, "layoutParams");
        r5.alignWithParent = true;
        r5.leftMargin = r7;
        r4.setId(View.generateViewId());
        if (this.f11597h != null) goto L5;
        r6 = 0;
        r5.addRule(9);
    L14:
        r5.addRule(15);
        List<View> r8 = this.f11599j;
        if (r8 == null) goto L18;
        o.c(r8);
        if (r6 == r8.size()) goto L18;
    L19:
        getLeftViewListOrCreate().add(r6, r4);
        addView(r4, r5);
        return;
    L18:
        this.f11597h = r4;
        goto L19
    L5:
        if (r6 < 0) goto L13;
        List<View> r9 = this.f11599j;
        o.c(r9);
        if (r6 >= r9.size()) goto L13;
        if (r6 != 0) goto L12;
        r5.addRule(9);
        List<View> r2 = this.f11599j;
        o.c(r2);
        ViewGroup.LayoutParams r3 = r2.get(r6).getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r10 = (RelativeLayout.LayoutParams) r3;
        r10.removeRule(9);
        r10.addRule(1, r4.getId());
        goto L14
    L12:
        List<View> r1 = this.f11599j;
        o.c(r1);
        View r11 = r1.get(r6 - 1);
        List<View> r12 = this.f11599j;
        o.c(r12);
        View r13 = r12.get(r6);
        r5.addRule(1, r11.getId());
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) r14).addRule(1, r4.getId());
    L13:
        List<View> r15 = this.f11599j;
        o.c(r15);
        r6 = r15.size();
        View r16 = this.f11597h;
        o.c(r16);
        r5.addRule(1, r16.getId());
        goto L14
    }

    public final int getLeftViewCount() {
        return m(this.f11599j);
    }

    public final View getMCenterView() {
        return this.f11596g;
    }

    public final OButton getMLeftActionBack() {
        return this.f11601l;
    }

    public final View getMLeftLastView() {
        return this.f11597h;
    }

    public final List<View> getMLeftViewList() {
        return this.f11599j;
    }

    public final View getMRightLastView() {
        return this.f11598i;
    }

    public final List<View> getMRightViewList() {
        return this.f11600k;
    }

    public final TextView getMSubTitleView() {
        return this.o;
    }

    public final TextView getMTitleView() {
        return this.m;
    }

    public final int getRightViewCount() {
        return m(this.f11600k);
    }

    public final String getSubTitleText() {
        return this.p;
    }

    public final String getTitleText() {
        return this.n;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        Context r4 = getContext();
        o.e(r4, "context");
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec((int) r4.getResources().getDimension(d.f8220g), BasicMeasure.EXACTLY));
    }

    public final void setCenterText(int r2) {
        setCenterText(getContext().getString(r2));
    }

    public final void setCenterView(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r(r2, i(r2, true));
    }

    public final void setMCenterView(View r1) {
        this.f11596g = r1;
    }

    public final void setMLeftActionBack(OButton r1) {
        this.f11601l = r1;
    }

    public final void setMLeftLastView(View r1) {
        this.f11597h = r1;
    }

    public final void setMLeftViewList(List<View> r1) {
        this.f11599j = r1;
    }

    public final void setMRightLastView(View r1) {
        this.f11598i = r1;
    }

    public final void setMRightViewList(List<View> r1) {
        this.f11600k = r1;
    }

    public final void setMSubTitleView(TextView r1) {
        this.o = r1;
    }

    public final void setMTitleView(TextView r1) {
        this.m = r1;
    }

    public final void setSubTitleText(String r1) {
        this.p = r1;
        setCenterSubText(r1);
    }

    public final void setTitleText(String r1) {
        this.n = r1;
        setCenterText(r1);
    }
}
