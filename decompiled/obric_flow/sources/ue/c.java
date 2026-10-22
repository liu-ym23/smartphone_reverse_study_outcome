package ue;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.ies.xelement.reveal.RevealLayout$mDragHelperCallback$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f22322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.view.b f22323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f22324c;
    public final Rect d;
    public final Rect e;
    public final Rect f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f22325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f22326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f22327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f22331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f22332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f22333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f22334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewDragHelper f22335r;
    public GestureDetectorCompat s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RevealLayout$mDragHelperCallback$1 f22336t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f22337u;

    /* JADX WARN: Type inference failed for: r1v8, types: [com.bytedance.ies.xelement.reveal.RevealLayout$mDragHelperCallback$1] */
    public c(Context r5) {
        super(r5);
        this.f22324c = new Rect();
        this.d = new Rect();
        this.e = new Rect();
        this.f = new Rect();
        this.f22328k = 300;
        this.f22330m = 1;
        this.f22331n = 1;
        this.f22333p = -1.0f;
        this.f22334q = -1.0f;
        this.f22336t = new RevealLayout$mDragHelperCallback$1();
        this.f22337u = new b(this);
    }

    public static final /* synthetic */ int a(c r5) {
        return r5.getClosestEdgeDistance();
    }

    private final int getClosestEdgeDistance() {
        int r5 = this.f22331n;
        Rect r10 = this.f22324c;
        if (r5 != 1) goto L5;
        int r11 = r10.left;
        com.lynx.tasm.behavior.ui.view.b r12 = this.f22323b;
        if (r12 != null) goto L48;
        Intrinsics.throwNpe();
    L48:
        int r13 = r12.getWidth() + r11;
        View r14 = this.f22322a;
        if (r14 != null) goto L51;
        Intrinsics.throwNpe();
    L51:
        int r15 = r14.getLeft() - r10.left;
        View r16 = this.f22322a;
        if (r16 != null) goto L55;
        Intrinsics.throwNpe();
    L55:
        return Math.min(r15, r13 - r16.getLeft());
    L5:
        if (r5 != 2) goto L7;
        int r17 = r10.right;
        com.lynx.tasm.behavior.ui.view.b r18 = this.f22323b;
        if (r18 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        int r19 = r17 - r18.getWidth();
        View r20 = this.f22322a;
        if (r20 != null) goto L40;
        Intrinsics.throwNpe();
    L40:
        int r21 = r20.getRight() - r19;
        int r22 = r10.right;
        View r23 = this.f22322a;
        if (r23 != null) goto L44;
        Intrinsics.throwNpe();
    L44:
        return Math.min(r21, r22 - r23.getRight());
    L7:
        if (r5 != 4) goto L9;
        int r24 = r10.top;
        com.lynx.tasm.behavior.ui.view.b r25 = this.f22323b;
        if (r25 != null) goto L26;
        Intrinsics.throwNpe();
    L26:
        int r26 = r25.getHeight() + r24;
        View r27 = this.f22322a;
        if (r27 != null) goto L29;
        Intrinsics.throwNpe();
    L29:
        int r28 = r27.getBottom() - r26;
        View r29 = this.f22322a;
        if (r29 != null) goto L33;
        Intrinsics.throwNpe();
    L33:
        return Math.min(r28, r26 - r29.getTop());
    L9:
        if (r5 == 8) goto L12;
        return 0;
    L12:
        int r30 = r10.bottom;
        com.lynx.tasm.behavior.ui.view.b r31 = this.f22323b;
        if (r31 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        int r32 = r30 - r31.getHeight();
        int r33 = r10.bottom;
        View r34 = this.f22322a;
        if (r34 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        int r35 = r33 - r34.getBottom();
        View r36 = this.f22322a;
        if (r36 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        return Math.min(r35, r36.getBottom() - r32);
    }

    private final int getHalfwayPivotHorizontal() {
        int r5 = this.f22331n;
        Rect r10 = this.f22324c;
        if (r5 != 1) goto L9;
        int r11 = r10.left;
        com.lynx.tasm.behavior.ui.view.b r12 = this.f22323b;
        if (r12 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return (r12.getWidth() / 2) + r11;
    L9:
        int r13 = r10.right;
        com.lynx.tasm.behavior.ui.view.b r14 = this.f22323b;
        if (r14 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r13 - (r14.getWidth() / 2);
    }

    private final int getHalfwayPivotVertical() {
        int r5 = this.f22331n;
        Rect r10 = this.f22324c;
        if (r5 != 4) goto L9;
        int r11 = r10.top;
        com.lynx.tasm.behavior.ui.view.b r12 = this.f22323b;
        if (r12 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return (r12.getHeight() / 2) + r11;
    L9:
        int r13 = r10.bottom;
        com.lynx.tasm.behavior.ui.view.b r14 = this.f22323b;
        if (r14 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        return r13 - (r14.getHeight() / 2);
    }

    private final int getMainOpenLeft() {
        int r5 = this.f22331n;
        Rect r10 = this.f22324c;
        if (r5 != 1) goto L5;
        int r11 = r10.left;
        com.lynx.tasm.behavior.ui.view.b r12 = this.f22323b;
        if (r12 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        return r12.getWidth() + r11;
    L5:
        if (r5 != 2) goto L7;
        int r13 = r10.left;
        com.lynx.tasm.behavior.ui.view.b r14 = this.f22323b;
        if (r14 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        return r13 - r14.getWidth();
    L7:
        if (r5 == 4) goto L13;
        if (r5 == 8) goto L13;
        return 0;
    L13:
        return r10.left;
    }

    private final int getMainOpenTop() {
        int r5 = this.f22331n;
        Rect r10 = this.f22324c;
        if (r5 == 1) goto L23;
        if (r5 == 2) goto L23;
        if (r5 != 4) goto L9;
        int r11 = r10.top;
        com.lynx.tasm.behavior.ui.view.b r12 = this.f22323b;
        if (r12 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        return r12.getHeight() + r11;
    L9:
        if (r5 == 8) goto L12;
        return 0;
    L12:
        int r13 = r10.top;
        com.lynx.tasm.behavior.ui.view.b r14 = this.f22323b;
        if (r14 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        return r13 - r14.getHeight();
    L23:
        return r10.top;
    }

    private final int getSecOpenLeft() {
        int r5 = this.f22330m;
        Rect r10 = this.e;
        if (r5 == 0) goto L22;
        int r11 = this.f22331n;
        if (r11 == 8) goto L22;
        if (r11 == 4) goto L22;
        if (r11 != 1) goto L16;
        int r12 = r10.left;
        com.lynx.tasm.behavior.ui.view.b r13 = this.f22323b;
        if (r13 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        return r13.getWidth() + r12;
    L16:
        int r14 = r10.left;
        com.lynx.tasm.behavior.ui.view.b r15 = this.f22323b;
        if (r15 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        return r14 - r15.getWidth();
    L22:
        return r10.left;
    }

    private final int getSecOpenTop() {
        int r5 = this.f22330m;
        Rect r10 = this.e;
        if (r5 == 0) goto L22;
        int r11 = this.f22331n;
        if (r11 == 1) goto L22;
        if (r11 == 2) goto L22;
        if (r11 != 4) goto L16;
        int r12 = r10.top;
        com.lynx.tasm.behavior.ui.view.b r13 = this.f22323b;
        if (r13 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        return r13.getHeight() + r12;
    L16:
        int r14 = r10.top;
        com.lynx.tasm.behavior.ui.view.b r15 = this.f22323b;
        if (r15 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        return r14 - r15.getHeight();
    L22:
        return r10.top;
    }

    public final void b(com.lynx.tasm.behavior.ui.view.b r5) {
        if (this.f22323b == null) goto L5;
        Log.w("RevealLayout", "already added ,replacing the mSecondaryView view");
        removeView(this.f22323b);
    L5:
        this.f22323b = r5;
        addView(r5, 0);
    }

    public final void c(boolean r5) {
        this.f22325h = false;
        Rect r10 = this.f22324c;
        if (r5 == false) goto L11;
        this.f22329l = 1;
        ViewDragHelper r11 = this.f22335r;
        if (r11 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        View r12 = this.f22322a;
        if (r12 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        r11.smoothSlideViewTo(r12, r10.left, r10.top);
    L21:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L11:
        this.f22329l = 0;
        ViewDragHelper r13 = this.f22335r;
        if (r13 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r13.abort();
        View r14 = this.f22322a;
        if (r14 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        r14.layout(r10.left, r10.top, r10.right, r10.bottom);
        com.lynx.tasm.behavior.ui.view.b r15 = this.f22323b;
        if (r15 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        Rect r16 = this.e;
        r15.layout(r16.left, r16.top, r16.right, r16.bottom);
        goto L21
    }

    @Override // android.view.View
    public final void computeScroll() {
        ViewDragHelper r5 = this.f22335r;
        if (r5 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r5.continueSettling(true) == false) goto L9;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public final void d(boolean r5) {
        this.f22325h = true;
        Rect r10 = this.d;
        if (r5 == false) goto L11;
        this.f22329l = 3;
        ViewDragHelper r11 = this.f22335r;
        if (r11 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        View r12 = this.f22322a;
        if (r12 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        r11.smoothSlideViewTo(r12, r10.left, r10.top);
    L21:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L11:
        this.f22329l = 2;
        ViewDragHelper r13 = this.f22335r;
        if (r13 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r13.abort();
        View r14 = this.f22322a;
        if (r14 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        r14.layout(r10.left, r10.top, r10.right, r10.bottom);
        com.lynx.tasm.behavior.ui.view.b r15 = this.f22323b;
        if (r15 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        Rect r16 = this.f;
        r15.layout(r16.left, r16.top, r16.right, r16.bottom);
        goto L21
    }

    public final int getDragEdge() {
        return this.f22331n;
    }

    public final int getMinFlingVelocity() {
        return this.f22328k;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.f22327j == true) goto L5;
        ViewDragHelper r5 = this.f22335r;
        if (r5 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        r5.processTouchEvent(r10);
        GestureDetectorCompat r11 = this.s;
        if (r11 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        r11.onTouchEvent(r10);
        if (r10.getAction() != 0) goto L15;
        this.f22332o = 0.0f;
    L22:
        float r12 = r10.getX();
        float r13 = r10.getY();
        View r14 = this.f22322a;
        if (r14 != null) goto L26;
        Intrinsics.throwNpe();
    L26:
        if (r14.getTop() > r13) goto L33;
        View r15 = this.f22322a;
        if (r15 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        if (r13 > r15.getBottom()) goto L33;
        boolean r16 = true;
    L34:
        View r17 = this.f22322a;
        if (r17 != null) goto L38;
        Intrinsics.throwNpe();
    L38:
        if (r17.getLeft() > r12) goto L45;
        View r18 = this.f22322a;
        if (r18 != null) goto L43;
        Intrinsics.throwNpe();
    L43:
        if (r12 > r18.getRight()) goto L45;
        boolean r19 = true;
    L46:
        if (r16 == false) goto L55;
        if (r19 == false) goto L55;
        ViewDragHelper r20 = this.f22335r;
        if (r20 != null) goto L52;
        Intrinsics.throwNpe();
    L52:
        if (this.f22332o >= r20.getTouchSlop()) goto L55;
        boolean r21 = true;
    L56:
        ViewDragHelper r22 = this.f22335r;
        if (r22 != null) goto L60;
        Intrinsics.throwNpe();
    L60:
        if (r22.getViewDragState() != 2) goto L62;
        boolean r23 = true;
    L63:
        ViewDragHelper r24 = this.f22335r;
        if (r24 != null) goto L67;
        Intrinsics.throwNpe();
    L67:
        if (r24.getViewDragState() == 0) goto L69;
    L71:
        boolean r25 = false;
    L72:
        this.f22333p = r10.getX();
        this.f22334q = r10.getY();
        if (r21 == true) goto L77;
        if (r23 == true) goto L76;
        if (r25 == false) goto L77;
    L76:
        return true;
    L77:
        return false;
    L69:
        if (this.f22326i == false) goto L71;
        r25 = true;
        goto L72
    L62:
        r23 = false;
    L55:
        r21 = false;
    L45:
        r19 = false;
    L33:
        r16 = false;
        goto L34
    L15:
        int r26 = this.f22331n;
        if (r26 == 1) goto L20;
        if (r26 == 2) goto L20;
        float r27 = Math.abs(r10.getY() - this.f22334q);
    L21:
        this.f22332o += r27;
    L20:
        r27 = Math.abs(r10.getX() - this.f22333p);
        goto L21
    L5:
        return super.onInterceptTouchEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        int r5 = getChildCount();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5) goto L39;
        View r12 = getChildAt(r11);
        int r13 = getPaddingLeft();
        int r14 = Math.max((r20 - getPaddingRight()) - r18, r10);
        int r15 = getPaddingTop();
        int r16 = Math.max((r21 - getPaddingBottom()) - r19, r10);
        int r110 = r12.getMeasuredHeight();
        int r111 = r12.getMeasuredWidth();
        ViewGroup.LayoutParams r112 = r12.getLayoutParams();
        if (r112 != null) goto L8;
        boolean r22 = false;
    L14:
        boolean r23 = false;
    L16:
        if (r22 == false) goto L21;
        r110 = r16 - r15;
        if (r112 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        r112.height = r110;
    L21:
        if (r23 == false) goto L26;
        r111 = r14 - r13;
        if (r112 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        r112.width = r111;
    L26:
        int r24 = this.f22331n;
        if (r24 == 1) goto L36;
        if (r24 != 2) goto L30;
        int r25 = Math.max(((r20 - r111) - getPaddingRight()) - r18, r13);
        int r26 = Math.min(getPaddingTop(), r16);
        int r27 = Math.max((r20 - getPaddingRight()) - r18, r13);
        int r28 = Math.min(getPaddingTop() + r110, r16);
    L37:
        r12.layout(r25, r26, r27, r28);
        r11 = r11 + 1;
        r10 = 0;
        goto L4
    L30:
        if (r24 == 4) goto L36;
        if (r24 == 8) goto L34;
        r25 = 0;
        r26 = 0;
        r27 = 0;
        r28 = 0;
        goto L37
    L34:
        r25 = Math.min(getPaddingLeft(), r14);
        r26 = Math.max(((r21 - r110) - getPaddingBottom()) - r19, r15);
        r27 = Math.min(getPaddingLeft() + r111, r14);
        r28 = Math.max((r21 - getPaddingBottom()) - r19, r15);
    L36:
        r25 = Math.min(getPaddingLeft(), r14);
        r26 = Math.min(getPaddingTop(), r16);
        r27 = Math.min(getPaddingLeft() + r111, r14);
        r28 = Math.min(getPaddingTop() + r110, r16);
        goto L37
    L8:
        if (r112.height != (-1)) goto L10;
        r22 = true;
    L12:
        if (r112.width != (-1)) goto L14;
        r23 = true;
        goto L16
    L10:
        r22 = false;
        goto L12
    L39:
        if (this.f22330m != 1) goto L76;
        int r29 = this.f22331n;
        if (r29 == 1) goto L69;
        if (r29 != 2) goto L44;
        com.lynx.tasm.behavior.ui.view.b r30 = this.f22323b;
        if (r30 != null) goto L65;
        Intrinsics.throwNpe();
    L65:
        com.lynx.tasm.behavior.ui.view.b r31 = this.f22323b;
        if (r31 != null) goto L68;
        Intrinsics.throwNpe();
    L68:
        r30.offsetLeftAndRight(r31.getWidth());
        goto L76
    L44:
        if (r29 != 4) goto L46;
        com.lynx.tasm.behavior.ui.view.b r32 = this.f22323b;
        if (r32 != null) goto L58;
        Intrinsics.throwNpe();
    L58:
        com.lynx.tasm.behavior.ui.view.b r33 = this.f22323b;
        if (r33 != null) goto L61;
        Intrinsics.throwNpe();
    L61:
        r32.offsetTopAndBottom(-r33.getHeight());
        goto L76
    L46:
        if (r29 != 8) goto L76;
        com.lynx.tasm.behavior.ui.view.b r34 = this.f22323b;
        if (r34 != null) goto L51;
        Intrinsics.throwNpe();
    L51:
        com.lynx.tasm.behavior.ui.view.b r35 = this.f22323b;
        if (r35 != null) goto L54;
        Intrinsics.throwNpe();
    L54:
        r34.offsetTopAndBottom(r35.getHeight());
        goto L76
    L69:
        com.lynx.tasm.behavior.ui.view.b r36 = this.f22323b;
        if (r36 != null) goto L72;
        Intrinsics.throwNpe();
    L72:
        com.lynx.tasm.behavior.ui.view.b r37 = this.f22323b;
        if (r37 != null) goto L75;
        Intrinsics.throwNpe();
    L75:
        r36.offsetLeftAndRight(-r37.getWidth());
    L76:
        View r38 = this.f22322a;
        if (r38 != null) goto L79;
        Intrinsics.throwNpe();
    L79:
        int r39 = r38.getLeft();
        View r40 = this.f22322a;
        if (r40 != null) goto L82;
        Intrinsics.throwNpe();
    L82:
        int r41 = r40.getTop();
        View r42 = this.f22322a;
        if (r42 != null) goto L85;
        Intrinsics.throwNpe();
    L85:
        int r43 = r42.getRight();
        View r44 = this.f22322a;
        if (r44 != null) goto L88;
        Intrinsics.throwNpe();
    L88:
        this.f22324c.set(r39, r41, r43, r44.getBottom());
        com.lynx.tasm.behavior.ui.view.b r45 = this.f22323b;
        if (r45 != null) goto L91;
        Intrinsics.throwNpe();
    L91:
        int r46 = r45.getLeft();
        com.lynx.tasm.behavior.ui.view.b r47 = this.f22323b;
        if (r47 != null) goto L94;
        Intrinsics.throwNpe();
    L94:
        int r48 = r47.getTop();
        com.lynx.tasm.behavior.ui.view.b r49 = this.f22323b;
        if (r49 != null) goto L97;
        Intrinsics.throwNpe();
    L97:
        int r50 = r49.getRight();
        com.lynx.tasm.behavior.ui.view.b r51 = this.f22323b;
        if (r51 != null) goto L100;
        Intrinsics.throwNpe();
    L100:
        this.e.set(r46, r48, r50, r51.getBottom());
        int r52 = getMainOpenLeft();
        int r53 = getMainOpenTop();
        int r54 = getMainOpenLeft();
        View r55 = this.f22322a;
        if (r55 != null) goto L103;
        Intrinsics.throwNpe();
    L103:
        int r56 = r55.getWidth() + r54;
        int r57 = getMainOpenTop();
        View r58 = this.f22322a;
        if (r58 != null) goto L106;
        Intrinsics.throwNpe();
    L106:
        this.d.set(r52, r53, r56, r58.getHeight() + r57);
        int r59 = getSecOpenLeft();
        int r60 = getSecOpenTop();
        int r61 = getSecOpenLeft();
        com.lynx.tasm.behavior.ui.view.b r62 = this.f22323b;
        if (r62 != null) goto L109;
        Intrinsics.throwNpe();
    L109:
        int r63 = r62.getWidth() + r61;
        int r64 = getSecOpenTop();
        com.lynx.tasm.behavior.ui.view.b r65 = this.f22323b;
        if (r65 != null) goto L112;
        Intrinsics.throwNpe();
    L112:
        this.f.set(r59, r60, r63, r65.getHeight() + r64);
        if (this.f22325h == false) goto L115;
        d(false);
    L116:
        View r66 = this.f22322a;
        if (r66 != null) goto L119;
        Intrinsics.throwNpe();
    L119:
        r66.getLeft();
        View r67 = this.f22322a;
        if (r67 != null) goto L122;
        Intrinsics.throwNpe();
    L122:
        r67.getTop();
        return;
    L115:
        c(false);
        goto L116
    }

    @Override // android.view.View
    public final void onMeasure(int r14, int r15) {
        if (getChildCount() < 2) goto L39;
        ViewGroup.LayoutParams r5 = getLayoutParams();
        int r10 = View.MeasureSpec.getMode(r14);
        int r11 = View.MeasureSpec.getMode(r15);
        int r12 = getChildCount();
        int r13 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L5:
        if (r16 >= r12) goto L7;
        View r19 = getChildAt(r16);
        measureChild(r19, r14, r15);
        r18 = Math.max(r19.getMeasuredWidth(), r18);
        r17 = Math.max(r19.getMeasuredHeight(), r17);
        r16 = r16 + 1;
        goto L5
    L7:
        int r110 = View.MeasureSpec.makeMeasureSpec(r18, r10);
        int r111 = View.MeasureSpec.makeMeasureSpec(r17, r11);
        int r20 = View.MeasureSpec.getSize(r110);
        int r21 = View.MeasureSpec.getSize(r111);
        int r22 = getChildCount();
    L9:
        if (r13 >= r22) goto L19;
        View r112 = getChildAt(r13);
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L18;
        if (r113.height != (-1)) goto L16;
        r112.setMinimumHeight(r21);
    L16:
        if (r113.width != (-1)) goto L18;
        r112.setMinimumWidth(r20);
    L18:
        measureChild(r112, r110, r111);
        r18 = Math.max(r112.getMeasuredWidth(), r18);
        r17 = Math.max(r112.getMeasuredHeight(), r17);
        r13 = r13 + 1;
        goto L9
    L19:
        int r114 = (getPaddingRight() + getPaddingLeft()) + r18;
        int r23 = (getPaddingBottom() + getPaddingTop()) + r17;
        if (r10 != 1073741824) goto L23;
    L28:
        if (r11 != 1073741824) goto L31;
    L36:
        setMeasuredDimension(r20, r21);
        return;
    L31:
        if (r5.height != (-1)) goto L33;
        r23 = r21;
    L33:
        if (r11 != Integer.MIN_VALUE) goto L35;
        r21 = Math.min(r23, r21);
        goto L36
    L35:
        r21 = r23;
        goto L36
    L23:
        if (r5.width != (-1)) goto L25;
        r114 = r20;
    L25:
        if (r10 != Integer.MIN_VALUE) goto L27;
        r20 = Math.min(r114, r20);
        goto L28
    L27:
        r20 = r114;
        goto L28
    L39:
        throw new RuntimeException("Layout must have two children");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        GestureDetectorCompat r10 = this.s;
        if (r10 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r10.onTouchEvent(r5);
        ViewDragHelper r11 = this.f22335r;
        if (r11 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        r11.processTouchEvent(r5);
        return true;
    }

    public final void setDragEdge(int r5) {
        this.f22331n = r5;
    }

    public final void setLockDrag(boolean r5) {
        this.f22327j = r5;
    }

    public final void setMinFlingVelocity(int r5) {
        this.f22328k = r5;
    }

    public final void setMode$x_element_reveal_view_release(int r5) {
        this.f22330m = r5;
    }

    public final void setSwipeListener(a r5) {
    }
}
