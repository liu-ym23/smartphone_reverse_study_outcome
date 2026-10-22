package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.obric.common.oui.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.http.legacy.protocol.HTTP;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OSwipeLayout extends OUIFrameLayout {
    public float A;
    public float B;
    public int C;
    public boolean D;
    public float E;
    public float F;
    public View.OnClickListener G;
    public View.OnLongClickListener H;
    public Rect I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final GestureDetector f288J;
    public final int k;
    public DragEdge l;
    public final ViewDragHelper m;
    public int n;
    public final LinkedHashMap o;
    public ShowMode p;
    public final float[] q;
    public final ArrayList r;
    public final ArrayList s;
    public final HashMap t;
    public final HashMap u;
    public final HashMap v;
    public DoubleClickListener w;
    public boolean x;
    public final boolean[] y;
    public boolean z;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.OSwipeLayout$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f290a = null;

        static {
            int[] r0 = new int[DragEdge.values().length];
            f290a = r0;
            r0[1] = 1;     // Catch: NoSuchFieldError -> L9
        L19:
            f290a[3] = 2;     // Catch: NoSuchFieldError -> L10
        L17:
            f290a[0] = 3;     // Catch: NoSuchFieldError -> L11
        L13:
            f290a[2] = 4;     // Catch: NoSuchFieldError -> L12
            return;
        }
    }

    public interface DoubleClickListener {
        void a();
    }

    public static final enum DragEdge extends Enum<DragEdge> {
        public static final DragEdge b = null;
        public static final DragEdge c = null;
        public static final DragEdge e = null;
        public static final DragEdge f = null;
        public static final /* synthetic */ DragEdge[] i = null;

        static {
            DragEdge r0 = new DragEdge("Left", 0);
            b = r0;
            DragEdge r1 = new DragEdge("Top", 1);
            c = r1;
            DragEdge r2 = new DragEdge("Right", 2);
            e = r2;
            DragEdge r3 = new DragEdge("Bottom", 3);
            f = r3;
            i = new DragEdge[]{r0, r1, r2, r3};
        }

        public static DragEdge valueOf(String r1) {
            return (DragEdge) Enum.valueOf(DragEdge.class, r1);
        }

        public static DragEdge[] values() {
            return (DragEdge[]) i.clone();
        }
    }

    public interface OnLayout {
        void a(OSwipeLayout r1);
    }

    public interface OnRevealListener {
        void a();
    }

    public static final enum ShowMode extends Enum<ShowMode> {
        public static final ShowMode b = null;
        public static final ShowMode c = null;
        public static final /* synthetic */ ShowMode[] e = null;

        static {
            ShowMode r0 = new ShowMode("LayDown", 0);
            b = r0;
            ShowMode r1 = new ShowMode("PullOut", 1);
            c = r1;
            e = new ShowMode[]{r0, r1};
        }

        public static ShowMode valueOf(String r1) {
            return (ShowMode) Enum.valueOf(ShowMode.class, r1);
        }

        public static ShowMode[] values() {
            return (ShowMode[]) e.clone();
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status b = null;
        public static final Status c = null;
        public static final Status e = null;
        public static final /* synthetic */ Status[] f = null;

        static {
            Status r0 = new Status("Middle", 0);
            b = r0;
            Status r1 = new Status("Open", 1);
            c = r1;
            Status r2 = new Status(HTTP.CONN_CLOSE, 2);
            e = r2;
            f = new Status[]{r0, r1, r2};
        }

        public static Status valueOf(String r1) {
            return (Status) Enum.valueOf(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) f.clone();
        }
    }

    public interface SwipeDenier {
        boolean a();
    }

    public class SwipeDetector extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f291a;

        public SwipeDetector(OSwipeLayout r1) {
            this.f291a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r4) {
            OSwipeLayout r3 = this.f291a;
            if (r3.w == null) goto L16;
            View r0 = r3.getCurrentBottomView();
            r3.getSurfaceView();
            if (r0 != null) goto L7;
        L13:
            r3.w.a();
            return true;
        L7:
            if (r4.getX() <= r0.getLeft()) goto L13;
            if (r4.getX() >= r0.getRight()) goto L13;
            if (r4.getY() <= r0.getTop()) goto L13;
            int r5 = (r4.getY() > r0.getBottom() ? 1 : (r4.getY() == r0.getBottom() ? 0 : -1));
            goto L13
        L16:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r3) {
            OSwipeLayout r0 = this.f291a;
            if (r0.z == false) goto L8;
            if (r0.q(r3) == false) goto L8;
            r0.k(true, true);
        L8:
            return super.onSingleTapUp(r3);
        }
    }

    public interface SwipeListener {
        void a();

        void b();

        void c();

        void onClose();
    }

    public OSwipeLayout(Context r13, AttributeSet r14) {
        super(r13, r14, 0, 8);
        DragEdge r5 = DragEdge.e;
        this.l = r5;
        this.n = 0;
        LinkedHashMap r6 = new LinkedHashMap();
        this.o = r6;
        this.q = new float[]{r13.getDimension(3, 0.0f), r13.getDimension(6, 0.0f), r13.getDimension(4, 0.0f), r13.getDimension(0, 0.0f)};
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new HashMap();
        this.u = new HashMap();
        this.v = new HashMap();
        this.x = true;
        this.y = new boolean[]{true, true, true, true};
        this.z = false;
        this.A = 0.75f;
        this.B = 0.25f;
        ViewDragHelper.Callback r8 = new AnonymousClass1(this);
        this.C = 0;
        this.E = -1.0f;
        this.F = -1.0f;
        this.f288J = new GestureDetector(getContext(), new SwipeDetector(this));
        this.m = ViewDragHelper.create(this, r8);
        this.k = ViewConfiguration.get(r13).getScaledTouchSlop();
        TypedArray r15 = r13.obtainStyledAttributes(r14, R.styleable.r);
        int r16 = r15.getInt(2, 2);
        setClickToClose(r15.getBoolean(1, this.z));
        if ((r16 & 1) != 1) goto L6;
        r6.put(DragEdge.b, null);
    L6:
        if ((r16 & 4) != 4) goto L9;
        r6.put(DragEdge.c, null);
    L9:
        if ((r16 & 2) != 2) goto L12;
        r6.put(r5, null);
    L12:
        if ((r16 & 8) != 8) goto L14;
        r6.put(DragEdge.f, null);
    L14:
        this.p = ShowMode.values()[r15.getInt(5, 1)];
        r15.recycle();
    }

    private AdapterView getAdapterView() {
        ViewParent r1 = getParent();
        if ((r1 instanceof AdapterView) == true) goto L5;
        return null;
    L5:
        return (AdapterView) r1;
    }

    private float getCurrentOffset() {
        DragEdge r0 = this.l;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return this.q[r0.ordinal()];
    }

    public static void h(OSwipeLayout r4) {
        if (r4.getOpenStatus() != Status.e) goto L13;
        AdapterView r0 = r4.getAdapterView();
        if (r0 == null) goto L11;
        int r5 = r0.getPositionForView(r4);
        if (r5 == (-1)) goto L12;
        r0.performItemClick(r0.getChildAt(r5 - r0.getFirstVisiblePosition()), r5, r0.getAdapter().getItemId(r5));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void i(OSwipeLayout r9) {
        if (r9.getOpenStatus() != Status.e) goto L25;
        AdapterView<?> r0 = r9.getAdapterView();
        if (r0 == null) goto L23;
        int r5 = r0.getPositionForView(r9);
        if (r5 == (-1)) goto L26;
        long r6 = r0.getItemIdAtPosition(r5);
        Method r1 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L13
        r1.setAccessible(true);     // Catch: Exception -> L13
        ((Boolean) r1.invoke(r0, new Object[]{r9, Integer.valueOf(r5), Long.valueOf(r6)})).getClass();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        if (r0.getOnItemLongClickListener() == null) goto L17;
        boolean r10 = r0.getOnItemLongClickListener().onItemLongClick(r0, r9, r5, r6);
    L18:
        if (r10 == false) goto L24;
        r0.performHapticFeedback(0);
        return;
    L24:
        return;
    L17:
        r10 = false;
        goto L18
    L26:
        return;
    L23:
        return;
    }

    private void setCurrentDragEdge(DragEdge r1) {
        this.l = r1;
        t();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5, int r6, ViewGroup.LayoutParams r7) {
        if (r5 != null) goto L33;
        return;
    L33:
        int r0 = ((Integer) r7.getClass().getField("gravity").get(r7)).intValue();     // Catch: Exception -> L6
    L8:
        LinkedHashMap r1 = this.o;
        if (r0 <= 0) goto L22;
        int r2 = GravityCompat.getAbsoluteGravity(r0, ViewCompat.getLayoutDirection(this));
        if ((r2 & 3) != 3) goto L14;
        r1.put(DragEdge.b, r5);
    L14:
        if ((r2 & 5) != 5) goto L17;
        r1.put(DragEdge.e, r5);
    L17:
        if ((r2 & 48) != 48) goto L20;
        r1.put(DragEdge.c, r5);
    L20:
        if ((r2 & 80) != 80) goto L29;
        r1.put(DragEdge.f, r5);
    L29:
        if (r5.getParent() != this) goto L31;
        return;
    L31:
        super.addView(r5, r6, r7);
        return;
    L22:
        Iterator r3 = r1.entrySet().iterator();
    L24:
        if (r3.hasNext() == false) goto L29;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (r4.getValue() != null) goto L24;
        r1.put((DragEdge) r4.getKey(), r5);
    L6:
        e = move-exception;
        e.printStackTrace();
        r0 = 0;
        goto L8
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.m.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public List<View> getBottomViews() {
        ArrayList r0 = new ArrayList();
        DragEdge[] r1 = DragEdge.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        DragEdge r4 = r1[r3];
        r0.add((View) this.o.get(r4));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    public View getCurrentBottomView() {
        List<View> r0 = getBottomViews();
        if (this.l.ordinal() < r0.size()) goto L5;
        return null;
    L5:
        return r0.get(this.l.ordinal());
    }

    public int getDragDistance() {
        return this.n;
    }

    public DragEdge getDragEdge() {
        return this.l;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.o;
    }

    @Deprecated
    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.o.keySet());
    }

    public Status getOpenStatus() {
        View r0 = getSurfaceView();
        Status r1 = Status.e;
        if (r0 != null) goto L5;
        return r1;
    L5:
        int r2 = r0.getLeft();
        int r3 = r0.getTop();
        if (r2 != getPaddingLeft()) goto L11;
        if (r3 != getPaddingTop()) goto L11;
        return r1;
    L11:
        if (r2 == (getPaddingLeft() - this.n)) goto L22;
        if (r2 == (getPaddingLeft() + this.n)) goto L22;
        if (r3 == (getPaddingTop() - this.n)) goto L22;
        if (r3 == (getPaddingTop() + this.n)) goto L22;
        return Status.b;
    L22:
        return Status.c;
    }

    public ShowMode getShowMode() {
        return this.p;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public float getWillOpenPercentAfterClose() {
        return this.B;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.A;
    }

    public final void j(MotionEvent r18) {
        if (this.D == false) goto L5;
        return;
    L5:
        Status r1 = getOpenStatus();
        Status r2 = Status.b;
        if (r1 != r2) goto L9;
        this.D = true;
        return;
    L9:
        Status r3 = getOpenStatus();
        float r4 = r18.getRawX() - this.E;
        float r5 = r18.getRawY() - this.F;
        float r6 = (float) Math.toDegrees(Math.atan(Math.abs(r5 / r4)));
        Status r7 = getOpenStatus();
        Status r8 = Status.e;
        DragEdge r9 = DragEdge.f;
        DragEdge r10 = DragEdge.c;
        DragEdge r11 = DragEdge.e;
        DragEdge r12 = DragEdge.b;
        boolean r13 = false;
        if (r7 != r8) goto L60;
        boolean[] r14 = this.y;
        LinkedHashMap r15 = this.o;
        if (r6 >= 45.0f) goto L37;
        if (r4 <= 0.0f) goto L25;
        View r16 = (View) r15.get(r12);
        if (r16 == null) goto L25;
        if (r16.getParent() != this) goto L25;
        if (r16 == getSurfaceView()) goto L25;
        if (r14[0] == false) goto L25;
        DragEdge r17 = r12;
    L58:
        setCurrentDragEdge(r17);
    L25:
        if (r4 >= 0.0f) goto L35;
        View r19 = (View) r15.get(r11);
        if (r19 != null) goto L29;
        return;
    L29:
        if (r19.getParent() == this) goto L31;
        return;
    L31:
        if (r19 != getSurfaceView()) goto L33;
        return;
    L33:
        if (r14[2] == false) goto L128;
        r17 = r11;
        goto L58
    L128:
        return;
    L35:
        return;
    L37:
        if (r5 <= 0.0f) goto L48;
        View r20 = (View) r15.get(r10);
        if (r20 == null) goto L48;
        if (r20.getParent() != this) goto L48;
        if (r20 == getSurfaceView()) goto L48;
        if (r14[1] == false) goto L48;
        r17 = r10;
    L48:
        if (r5 >= 0.0f) goto L59;
        View r21 = (View) r15.get(r9);
        if (r21 != null) goto L52;
        return;
    L52:
        if (r21.getParent() == this) goto L54;
        return;
    L54:
        if (r21 != getSurfaceView()) goto L56;
        return;
    L56:
        if (r14[3] == false) goto L132;
        r17 = r9;
        goto L58
    L132:
        return;
    L59:
        return;
    L60:
        DragEdge r22 = this.l;
        Status r110 = Status.c;
        int r111 = this.k;
        if (r22 != r11) goto L76;
        if (r3 == r110) goto L64;
    L65:
        if (r3 == r8) goto L67;
    L69:
        if (r3 != r2) goto L71;
    L70:
        boolean r112 = true;
    L73:
        if (r6 > 30.0f) goto L75;
        if (r112 == true) goto L76;
    L75:
        boolean r113 = true;
    L77:
        if (r22 != r12) goto L93;
        if (r3 == r110) goto L80;
    L81:
        if (r3 == r8) goto L83;
    L85:
        if (r3 != r2) goto L87;
    L86:
        boolean r23 = true;
    L89:
        if (r6 > 30.0f) goto L91;
        if (r23 == true) goto L93;
    L91:
        r113 = true;
        goto L93
    L87:
        r23 = false;
        goto L89
    L83:
        if (r4 <= r111) goto L85;
    L80:
        if (r4 < (-r111)) goto L86;
    L93:
        if (r22 != r10) goto L108;
        if (r3 == r110) goto L96;
    L97:
        if (r3 == r8) goto L99;
    L101:
        if (r3 != r2) goto L103;
    L102:
        boolean r24 = true;
    L105:
        if (r6 < 60.0f) goto L107;
        if (r24 == true) goto L108;
    L107:
        r113 = true;
        goto L108
    L103:
        r24 = false;
        goto L105
    L99:
        if (r5 <= r111) goto L101;
    L96:
        if (r5 < (-r111)) goto L102;
    L108:
        if (r22 != r9) goto L122;
        if (r3 == r110) goto L111;
    L112:
        if (r3 == r8) goto L114;
    L116:
        if (r3 != r2) goto L119;
    L117:
        r13 = true;
    L119:
        if (r6 < 60.0f) goto L121;
        if (r13 == true) goto L122;
    L121:
        boolean r25 = true;
        boolean r26 = true;
    L123:
        this.D = r25 ^ r26;
        return;
    L114:
        if (r5 >= (-r111)) goto L116;
    L111:
        if (r5 > r111) goto L117;
    L122:
        r26 = r113;
        r25 = true;
        goto L123
    L71:
        r112 = false;
        goto L73
    L67:
        if (r4 >= (-r111)) goto L69;
    L64:
        if (r4 > r111) goto L70;
    L76:
        r113 = false;
        goto L77
    }

    public final void k(boolean r8, boolean r9) {
        View r0 = getSurfaceView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 == false) goto L7;
        View r10 = getSurfaceView();
        int r11 = getPaddingLeft();
        int r1 = getPaddingTop();
        this.m.smoothSlideViewTo(r10, r11, r1);
    L11:
        invalidate();
        return;
    L7:
        Rect r12 = m(false);
        int r2 = r12.left - r0.getLeft();
        int r3 = r12.top - r0.getTop();
        r0.layout(r12.left, r12.top, r12.right, r12.bottom);
        if (r9 == false) goto L10;
        n(r12.left, r12.top, r12.right, r12.bottom);
        o(r12.left, r12.top, r2, r3);
        goto L11
    L10:
        s();
        goto L11
    }

    public final Rect l(ShowMode r10, Rect r11) {
        View r0 = getCurrentBottomView();
        int r1 = r11.left;
        int r2 = r11.top;
        int r3 = r11.right;
        int r4 = r11.bottom;
        ShowMode r5 = ShowMode.c;
        DragEdge r6 = DragEdge.c;
        DragEdge r7 = DragEdge.b;
        DragEdge r8 = DragEdge.e;
        if (r10 != r5) goto L25;
        DragEdge r12 = this.l;
        if (r12 != r7) goto L7;
        r1 = r1 - this.n;
    L12:
        int r9 = 0;
        if (r12 == r7) goto L20;
        if (r12 == r8) goto L20;
        if (r0 == null) goto L19;
        r9 = r0.getMeasuredHeight();
    L19:
        r4 = r2 + r9;
        r3 = r11.right;
    L35:
        return new Rect(r1, r2, r3, r4);
    L20:
        if (r0 == null) goto L23;
        r9 = r0.getMeasuredWidth();
    L23:
        r3 = r1 + r9;
        goto L35
    L7:
        if (r12 != r8) goto L9;
        r1 = r3;
        goto L12
    L9:
        if (r12 != r6) goto L11;
        r2 = r2 - this.n;
        goto L12
    L11:
        r2 = r4;
        goto L12
    L25:
        if (r10 != ShowMode.b) goto L35;
        DragEdge r13 = this.l;
        if (r13 != r7) goto L29;
        r9 = this.n;
        goto L23
    L29:
        if (r13 != r8) goto L31;
        r1 = r3 - this.n;
        goto L35
    L31:
        if (r13 != r6) goto L33;
        r4 = r2 + this.n;
        goto L35
    L33:
        r2 = r4 - this.n;
        goto L35
    }

    public final Rect m(boolean r4) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        if (r4 == false) goto L15;
        DragEdge r5 = this.l;
        if (r5 != DragEdge.b) goto L8;
        int r6 = getPaddingLeft();
        r0 = this.n + r6;
        goto L15
    L8:
        if (r5 != DragEdge.e) goto L11;
        r0 = getPaddingLeft() - this.n;
        goto L15
    L11:
        if (r5 != DragEdge.c) goto L13;
        int r7 = getPaddingTop();
        r1 = this.n + r7;
        goto L15
    L13:
        r1 = getPaddingTop() - this.n;
    L15:
        return new Rect(r0, r1, getMeasuredWidth() + r0, getMeasuredHeight() + r1);
    }

    public final void n(int r21, int r22, int r23, int r24) {
        OSwipeLayout r0 = this;
        HashMap r5 = r0.t;
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L143;
        Map.Entry r7 = (Map.Entry) r6.next();
        View r8 = (View) r7.getKey();
        Rect r9 = new Rect(r8.getLeft(), r8.getTop(), 0, 0);
        View r10 = r8;
    L10:
        if (r10.getParent() == null) goto L17;
        if (r10 == getRootView()) goto L17;
        r10 = (View) r10.getParent();
        if (r10 == r0) goto L17;
        r9.left = r10.getLeft() + r9.left;
        r9.top = r10.getTop() + r9.top;
    L17:
        r9.right = r8.getMeasuredWidth() + r9.left;
        int r11 = r8.getMeasuredHeight() + r9.top;
        r9.bottom = r11;
        DragEdge r12 = r0.l;
        int r13 = r9.left;
        int r14 = r9.right;
        int r15 = r9.top;
        ShowMode r16 = getShowMode();
        ShowMode r17 = ShowMode.b;
        Iterator r18 = r6;
        ShowMode r19 = ShowMode.c;
        HashMap r20 = r0.u;
        if (r16 != r17) goto L41;
        int r25 = r12.ordinal();
        if (r25 != 0) goto L22;
        if (r21 >= r14) goto L39;
        if (r21 < r13) goto L39;
    L69:
        r20.put(r8, Boolean.FALSE);
        float r110 = 0.0f;
        if (getShowMode() != r17) goto L83;
        int r26 = r0.l.ordinal();
        if (r26 != 0) goto L74;
        Rect r27 = r9;
        float r28 = r27.left - r21;
        int r111 = r8.getWidth();
    L94:
        r110 = r28 / r111;
    L98:
        Iterator r29 = ((ArrayList) r7.getValue()).iterator();
    L100:
        if (r29.hasNext() == false) goto L104;
        OnRevealListener r112 = (OnRevealListener) r29.next();
        Math.abs(r110);
        r112.a();
        if (Math.abs(r110) != 1.0f) goto L100;
        r20.put(r8, Boolean.TRUE);
    L104:
        DragEdge r30 = r0.l;
        if (((Boolean) r20.get(r8)).booleanValue() == false) goto L107;
        OSwipeLayout r31 = r0;
    L142:
        r0 = r31;
        r6 = r18;
        goto L7
    L107:
        int r113 = r27.left;
        int r114 = r27.right;
        int r115 = r27.top;
        int r32 = r27.bottom;
        ShowMode r116 = getShowMode();
        DragEdge r117 = DragEdge.f;
        DragEdge r1 = DragEdge.c;
        DragEdge r33 = DragEdge.b;
        DragEdge r34 = DragEdge.e;
        if (r116 != r17) goto L119;
        if (r30 != r34) goto L111;
        if (r23 > r113) goto L111;
    L132:
        r20.put(r8, Boolean.TRUE);
        Iterator r2 = ((ArrayList) r7.getValue()).iterator();
    L134:
        if (r2.hasNext() == false) goto L141;
        OnRevealListener r35 = (OnRevealListener) r2.next();
        DragEdge r118 = this.l;
        if (r118 == r33) goto L140;
        if (r118 == r34) goto L140;
        r8.getHeight();
        r35.a();
    L140:
        r8.getWidth();
        r35.a();
    L141:
        r31 = this;
    L111:
        if (r30 != r33) goto L113;
        if (r21 >= r114) goto L132;
    L113:
        if (r30 != r1) goto L115;
        if (r22 >= r32) goto L132;
    L115:
        if (r30 != r117) goto L141;
        if (r24 > r115) goto L141;
    L119:
        if (getShowMode() != r19) goto L141;
        if (r30 == r34) goto L122;
    L123:
        if (r30 == r33) goto L125;
    L126:
        if (r30 == r1) goto L128;
    L129:
        if (r30 != r117) goto L141;
        if (r32 > getHeight()) goto L141;
    L128:
        if (r115 >= getPaddingTop()) goto L132;
    L125:
        if (r113 >= getPaddingLeft()) goto L132;
    L122:
        if (r114 <= getWidth()) goto L132;
    L74:
        if (r26 != 1) goto L76;
        r27 = r9;
        r28 = r27.top - r22;
        r111 = r8.getHeight();
        goto L94
    L76:
        if (r26 == 2) goto L80;
        if (r26 == 3) goto L79;
        r27 = r9;
        goto L98
    L79:
        r27 = r9;
        r28 = r27.bottom - r24;
        r111 = r8.getHeight();
        goto L94
    L80:
        r27 = r9;
        r28 = r27.right - r23;
        r111 = r8.getWidth();
        goto L94
    L83:
        r27 = r9;
        if (getShowMode() != r19) goto L98;
        int r119 = r0.l.ordinal();
        if (r119 != 0) goto L88;
        r28 = r27.right - getPaddingLeft();
        r111 = r8.getWidth();
        goto L94
    L88:
        if (r119 != 1) goto L90;
        r28 = r27.bottom - getPaddingTop();
        r111 = r8.getHeight();
        goto L94
    L90:
        if (r119 == 2) goto L95;
        if (r119 != 3) goto L98;
        r28 = r27.top - getHeight();
        r111 = r8.getHeight();
        goto L94
    L95:
        r28 = r27.left - getWidth();
        r111 = r8.getWidth();
    L39:
        r27 = r9;
        goto L104
    L22:
        if (r25 != 1) goto L24;
        if (r22 < r15) goto L39;
        if (r22 >= r11) goto L39;
    L24:
        if (r25 == 2) goto L30;
        if (r25 != 3) goto L39;
        if (r24 <= r15) goto L39;
        if (r24 > r11) goto L39;
    L30:
        if (r23 <= r13) goto L39;
        if (r23 > r14) goto L39;
    L41:
        if (getShowMode() != r19) goto L39;
        int r36 = r12.ordinal();
        if (r36 == 0) goto L66;
        if (r36 == 1) goto L61;
        if (r36 == 2) goto L56;
        if (r36 != 3) goto L39;
        if (r15 >= getHeight()) goto L39;
        if (r15 < getPaddingTop()) goto L39;
    L56:
        if (r13 > getWidth()) goto L39;
        if (r14 <= getWidth()) goto L39;
    L61:
        if (r15 >= getPaddingTop()) goto L39;
        if (r11 < getPaddingTop()) goto L39;
    L66:
        if (r14 < getPaddingLeft()) goto L39;
        if (r13 >= getPaddingLeft()) goto L39;
    }

    public final void o(int r5, int r6, int r7, int r8) {
        DragEdge r9 = getDragEdge();
        if (r9 != DragEdge.b) goto L7;
        if (r7 >= 0) goto L18;
    L5:
        boolean r10 = false;
    L19:
        s();
        Status r11 = getOpenStatus();
        ArrayList r12 = this.r;
        if (r12.isEmpty() == true) goto L54;
        this.C++;
        Iterator r13 = r12.iterator();
    L23:
        if (r13.hasNext() == false) goto L31;
        SwipeListener r2 = (SwipeListener) r13.next();
        if (this.C != 1) goto L29;
        if (r10 == false) goto L28;
        r2.c();
        goto L29
    L28:
        r2.getClass();
    L29:
        getPaddingLeft();
        getPaddingTop();
        r2.b();
        goto L23
    L31:
        if (r11 != Status.e) goto L38;
        Iterator r14 = r12.iterator();
    L34:
        if (r14.hasNext() == false) goto L36;
        ((SwipeListener) r14.next()).onClose();
        goto L34
    L36:
        this.C = 0;
    L38:
        if (r11 != Status.c) goto L55;
        View r15 = getCurrentBottomView();
        if (r15 == null) goto L42;
        r15.setEnabled(true);
    L42:
        Iterator r16 = r12.iterator();
    L44:
        if (r16.hasNext() == false) goto L46;
        ((SwipeListener) r16.next()).a();
        goto L44
    L46:
        this.C = 0;
        return;
    L55:
        return;
    L54:
        return;
    L18:
        r10 = true;
        goto L19
    L7:
        if (r9 != DragEdge.e) goto L11;
        if (r7 <= 0) goto L18;
    L11:
        if (r9 != DragEdge.c) goto L15;
        if (r8 >= 0) goto L18;
    L15:
        if (r9 != DragEdge.f) goto L18;
        if (r8 <= 0) goto L18;
        goto L18
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getAdapterView() != null) goto L5;
        return;
    L5:
        if (this.G != null) goto L8;
        setOnClickListener(new AnonymousClass2(this));
    L8:
        if (this.H != null) goto L12;
        setOnLongClickListener(new AnonymousClass3(this));
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        if (this.x == true) goto L6;
        return false;
    L6:
        if (this.z == true) goto L8;
    L12:
        Iterator r0 = this.s.iterator();
    L14:
        if (r0.hasNext() == false) goto L20;
        SwipeDenier r3 = (SwipeDenier) r0.next();
        if (r3 == null) goto L14;
        if (r3.a() == false) goto L14;
        return false;
    L20:
        int r1 = r6.getAction();
        ViewDragHelper r4 = this.m;
        if (r1 == 0) goto L38;
        if (r1 != 1) goto L24;
    L37:
        this.D = false;
        r4.processTouchEvent(r6);
    L42:
        return this.D;
    L24:
        if (r1 != 2) goto L26;
        boolean r2 = this.D;
        j(r6);
        if (this.D == false) goto L33;
        ViewParent r7 = getParent();
        if (r7 == null) goto L33;
        r7.requestDisallowInterceptTouchEvent(true);
    L33:
        if (r2 == true) goto L42;
        if (this.D == false) goto L42;
        return false;
    L26:
        if (r1 == 3) goto L37;
        r4.processTouchEvent(r6);
        goto L42
    L38:
        r4.processTouchEvent(r6);
        this.D = false;
        this.E = r6.getRawX();
        this.F = r6.getRawY();
        if (getOpenStatus() != Status.b) goto L42;
        this.D = true;
        goto L42
    L8:
        if (getOpenStatus() != Status.c) goto L12;
        if (q(r6) == false) goto L12;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        t();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        if (this.x == false) goto L5;
        int r0 = r6.getActionMasked();
        this.f288J.onTouchEvent(r6);
        ViewDragHelper r3 = this.m;
        if (r0 == 0) goto L15;
        if (r0 != 1) goto L10;
    L14:
        this.D = false;
        r3.processTouchEvent(r6);
    L20:
        if (super.onTouchEvent(r6) == true) goto L25;
        if (this.D == true) goto L25;
        if (r0 == 0) goto L25;
        return false;
    L25:
        return true;
    L10:
        if (r0 != 2) goto L12;
    L16:
        j(r6);
        if (this.D == false) goto L20;
        getParent().requestDisallowInterceptTouchEvent(true);
        r3.processTouchEvent(r6);
        goto L20
    L12:
        if (r0 == 3) goto L14;
        r3.processTouchEvent(r6);
        goto L20
    L15:
        r3.processTouchEvent(r6);
        this.E = r6.getRawX();
        this.F = r6.getRawY();
        goto L16
    L5:
        return super.onTouchEvent(r6);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r4) {
        LinkedHashMap r3 = this.o;
        Iterator r0 = new HashMap(r3).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (r1.getValue() != r4) goto L4;
        r3.remove(r1.getKey());
        goto L4
    }

    public final int p(float r1) {
        return (int) ((r1 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final boolean q(MotionEvent r3) {
        View r0 = getSurfaceView();
        if (r0 != null) goto L7;
        return false;
    L7:
        if (this.I != null) goto L9;
        this.I = new Rect();
    L9:
        r0.getHitRect(this.I);
        return this.I.contains((int) r3.getX(), (int) r3.getY());
    }

    public final void r(boolean r9, boolean r10) {
        View r0 = getSurfaceView();
        View r1 = getCurrentBottomView();
        if (r0 != null) goto L5;
        return;
    L5:
        Rect r2 = m(true);
        if (r9 == false) goto L8;
        int r11 = r2.left;
        int r12 = r2.top;
        this.m.smoothSlideViewTo(r0, r11, r12);
    L16:
        invalidate();
        return;
    L8:
        int r13 = r2.left - r0.getLeft();
        int r3 = r2.top - r0.getTop();
        r0.layout(r2.left, r2.top, r2.right, r2.bottom);
        ShowMode r4 = getShowMode();
        ShowMode r5 = ShowMode.c;
        if (r4 != r5) goto L13;
        Rect r6 = l(r5, r2);
        if (r1 == null) goto L13;
        r1.layout(r6.left, r6.top, r6.right, r6.bottom);
    L13:
        if (r10 == false) goto L15;
        n(r2.left, r2.top, r2.right, r2.bottom);
        o(r2.left, r2.top, r13, r3);
        goto L16
    L15:
        s();
        goto L16
    }

    public final void s() {
        Status r0 = getOpenStatus();
        List<View> r1 = getBottomViews();
        if (r0 != Status.e) goto L12;
        Iterator<View> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L27;
        View r2 = r3.next();
        if (r2 == null) goto L6;
        if (r2.getVisibility() == 4) goto L6;
        r2.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r4 = getCurrentBottomView();
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.getVisibility() == 0) goto L26;
        r4.setVisibility(0);
        return;
    }

    public void setBottomSwipeEnabled(boolean r2) {
        this.y[3] = r2;
    }

    public void setClickToClose(boolean r1) {
        this.z = r1;
    }

    public void setDragDistance(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.n = p(r1);
        requestLayout();
    }

    @Deprecated
    public void setDragEdge(DragEdge r4) {
        this.o.clear();
        if (getChildCount() < 2) goto L5;
        this.o.put(r4, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r4);
    }

    @Deprecated
    public void setDragEdges(List<DragEdge> r7) {
        this.o.clear();
        int r0 = Math.min(r7.size(), getChildCount() - 1);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.o.put(r7.get(r2), getChildAt(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        int r1 = r7.size();
        DragEdge r3 = DragEdge.e;
        if (r1 != 0) goto L8;
    L11:
        setCurrentDragEdge(r3);
        return;
    L8:
        if (r7.contains(r3) == true) goto L11;
        setCurrentDragEdge(r7.get(0));
    }

    public void setLeftSwipeEnabled(boolean r2) {
        this.y[0] = r2;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        super.setOnClickListener(r1);
        this.G = r1;
    }

    public void setOnDoubleClickListener(DoubleClickListener r1) {
        this.w = r1;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        super.setOnLongClickListener(r1);
        this.H = r1;
    }

    public void setRightSwipeEnabled(boolean r2) {
        this.y[2] = r2;
    }

    public void setShowMode(ShowMode r1) {
        this.p = r1;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r1) {
        this.x = r1;
    }

    public void setTopSwipeEnabled(boolean r2) {
        this.y[1] = r2;
    }

    public void setWillOpenPercentAfterClose(float r1) {
        this.B = r1;
    }

    public void setWillOpenPercentAfterOpen(float r1) {
        this.A = r1;
    }

    public final void t() {
        View r0 = getCurrentBottomView();
        if (r0 == null) goto L11;
        DragEdge r1 = this.l;
        if (r1 != DragEdge.b) goto L7;
    L10:
        this.n = r0.getMeasuredWidth() - p(getCurrentOffset());
        goto L11
    L7:
        if (r1 == DragEdge.e) goto L10;
        this.n = r0.getMeasuredHeight() - p(getCurrentOffset());
    L11:
        ShowMode r2 = this.p;
        ShowMode r3 = ShowMode.c;
        boolean r4 = false;
        if (r2 != r3) goto L22;
        View r5 = getSurfaceView();
        if (getOpenStatus() == Status.e) goto L16;
        r4 = true;
    L16:
        Rect r6 = m(r4);
        if (r5 == null) goto L19;
        r5.layout(r6.left, r6.top, r6.right, r6.bottom);
        bringChildToFront(r5);
    L19:
        View r7 = getCurrentBottomView();
        Rect r8 = l(r3, r6);
        if (r7 == null) goto L34;
        r7.layout(r8.left, r8.top, r8.right, r8.bottom);
    L34:
        s();
        return;
    L22:
        ShowMode r9 = ShowMode.b;
        if (r2 != r9) goto L34;
        View r10 = getSurfaceView();
        HashMap r11 = this.v;
        Rect r12 = (Rect) r11.get(r10);
        if (r12 != null) goto L27;
        r12 = m(false);
    L27:
        if (r10 == null) goto L29;
        r10.layout(r12.left, r12.top, r12.right, r12.bottom);
        bringChildToFront(r10);
    L29:
        View r13 = getCurrentBottomView();
        Rect r14 = (Rect) r11.get(r13);
        if (r14 != null) goto L32;
        r14 = l(r9, r12);
    L32:
        if (r13 == null) goto L34;
        r13.layout(r14.left, r14.top, r14.right, r14.bottom);
        goto L34
    }

    @Deprecated
    public void setDragEdges(DragEdge... r2) {
        this.o.clear();
        setDragEdges(Arrays.asList(r2));
    }
}
