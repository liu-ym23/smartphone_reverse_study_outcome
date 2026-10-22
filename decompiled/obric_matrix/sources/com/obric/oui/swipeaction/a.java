package com.obric.oui.swipeaction;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.r0.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u009d\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u001f\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010%\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010\u0004J/\u00103\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0014¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b5\u0010*J\u0017\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u0013H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0002H\u0014¢\u0006\u0004\b9\u0010\u0004J\u0017\u0010:\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b:\u0010*J\u000f\u0010;\u001a\u00020\u0002H\u0016¢\u0006\u0004\b;\u0010\u0004R\u0018\u0010=\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010%R\u0016\u0010C\u001a\u00020\u00058B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010<R\u0016\u0010H\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00058B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010BR\u0016\u0010M\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\"\u0010Q\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010G\u001a\u0004\bO\u0010L\"\u0004\bP\u00108R\u0016\u0010T\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010SR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010XR\"\u0010^\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010S\u001a\u0004\b[\u0010B\"\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010SR$\u0010g\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010<R\u0016\u0010j\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010SR\u0016\u0010k\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010SR\u0016\u0010l\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010SR\u0016\u0010n\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010LR\u0016\u0010o\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010GR$\u0010s\u001a\u00020\u00052\u0006\u0010p\u001a\u00020\u00058\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bq\u0010S\"\u0004\br\u0010]R\u0016\u0010u\u001a\u00020\u00058B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010BR\u0016\u0010w\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010SR\u0016\u00106\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010GR\u0016\u0010y\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010GR\u0016\u0010|\u001a\u00020z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010{R\u0016\u0010~\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010SR\u0018\u0010\u0081\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b)\u0010\u0080\u0001R%\u0010\u0084\u0001\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b0\u0010G\u001a\u0005\b\u0082\u0001\u0010L\"\u0005\b\u0083\u0001\u00108R\u0017\u0010\u0085\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010SR\u0019\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010<R\u0018\u0010\u0088\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010GR\u0018\u0010\u008a\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010SR\u0017\u0010\u008b\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010SR\u0017\u0010\u008c\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010SR\u0018\u0010\u008e\u0001\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010LR\u0018\u0010\u0090\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010SR\u0018\u0010\u0092\u0001\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010LR\u0018\u0010\u0094\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010SR\u0017\u0010\u0095\u0001\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010LR\u0018\u0010\u0097\u0001\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010LR\u0017\u0010\u0098\u0001\u001a\u00020\u00138B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010LR\u001b\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000b\u0010\u009a\u0001R\u0019\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010<¨\u0006\u009e\u0001"}, d2 = {"Lcom/obric/oui/swipeaction/a;", "Landroid/widget/FrameLayout;", "Lkotlin/f0;", "R", "()V", "", "left", "y", "(I)I", "z", "dx", "x", "(II)I", "", "xVel", "B", "(F)I", "C", "A", "", "G", "(F)Z", "F", "L", "K", "J", "Q", "Landroid/view/View;", "view", "Landroid/graphics/Point;", "point", "O", "(Landroid/view/View;Landroid/graphics/Point;)Z", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/ViewGroup;", "rootView", "D", "(Landroid/view/MotionEvent;Landroid/view/ViewGroup;)Landroid/view/View;", "N", "(Landroid/view/View;)Z", "M", "(Landroid/view/MotionEvent;)Z", WsConstants.KEY_CONNECTION_STATE, "H", "(I)Z", "P", "w", "h", "oldW", "oldH", "onSizeChanged", "(IIII)V", "onInterceptTouchEvent", "disallowIntercept", "requestDisallowInterceptTouchEvent", "(Z)V", "onFinishInflate", "onTouchEvent", "computeScroll", "Landroid/view/View;", "rightViewBg", "", "i", "autoOpenSpeed", "getPreviousPosition", "()I", "previousPosition", "E", "rightView", "k", "Z", "freeDrag", "getRViewWidth", "rViewWidth", "getRightOpenFinished", "()Z", "rightOpenFinished", "g", "getSwipeEnabled", "setSwipeEnabled", "swipeEnabled", "u", "I", "leftViewPadding", "n", "rightItemFirstExpendWidth", "Landroidx/core/view/GestureDetectorCompat;", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetector", "f", "getDirection", "setDirection", "(I)V", "direction", "q", "leftItemFirstExpendWidth", "Lcom/obric/oui/swipeaction/a$a;", "Lcom/obric/oui/swipeaction/a$a;", "getActionsListener", "()Lcom/obric/oui/swipeaction/a$a;", "setActionsListener", "(Lcom/obric/oui/swipeaction/a$a;)V", "actionsListener", "leftViewBg", "s", "previousUnprocessedPixel", "rightFullOpenPending", "leftFullOpenPending", "getRightViewOpened", "rightViewOpened", "rightOpen", "value", "t", "setRightViewPadding", "rightViewPadding", "getLViewWidth", "lViewWidth", "p", "leftViewBgId", BaseSwitches.V, "leftOpen", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "gestureDetectorCallBack", "l", "rightViewId", "Landroidx/customview/widget/ViewDragHelper$Callback;", "Landroidx/customview/widget/ViewDragHelper$Callback;", "dragHelperCallback", "getContinuousSwipe", "setContinuousSwipe", "continuousSwipe", "horizontalWidth", "leftView", "j", "dragAfterOpened", "m", "rightViewBgId", "curDraggingState", "draggingViewLeft", "getLeftViewOpened", "leftViewOpened", "r", "draggedViewId", "getRightViewEmpty", "rightViewEmpty", "o", "leftViewId", "isMoving", "getLeftOpenFinished", "leftOpenFinished", "isClosed", "Landroidx/customview/widget/ViewDragHelper;", "Landroidx/customview/widget/ViewDragHelper;", "dragHelper", "draggedView", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class a extends FrameLayout {
    private int A;
    private boolean B;
    private boolean C;
    private View D;
    private View E;
    private View F;
    private int G;
    private View H;
    private View I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f11438J;
    private InterfaceC0300a K;
    private final GestureDetector.OnGestureListener L;
    private final ViewDragHelper.Callback M;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final double f11442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f11445l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private int w;
    private ViewDragHelper x;
    private GestureDetectorCompat y;
    private int z;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.a$a, reason: collision with other inner class name */
    public interface InterfaceC0300a {
        void a();

        void b(int r1, boolean r2);

        void onClose();
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f11446f;

        b(a r1) {
            this.f11446f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = this.f11446f.getDirection();
            if (r0 != 1) goto L5;
            View r1 = a.q(this.f11446f);
            o.c(r1);
            float r2 = a.j(this.f11446f);
        L12:
            r1.setX(r2);
            return;
        L5:
            if (r0 != 2) goto L7;
        L10:
            r1 = a.l(this.f11446f);
            o.c(r1);
            View r3 = a.l(this.f11446f);
            o.c(r3);
            r2 = -r3.getWidth();
            goto L12
        L7:
            if (r0 != 3) goto L14;
            View r4 = a.q(this.f11446f);
            o.c(r4);
            r4.setX(a.j(this.f11446f));
            goto L10
        }
    }

    static {
    }

    private final int A(float r2) {
        if (K(r2) == false) goto L7;
        return getLViewWidth();
    L7:
        if (L(r2) == false) goto L11;
        return -getRViewWidth();
    L11:
        if (J(r2) == false) goto L14;
        return 0;
    L14:
        return -1;
    }

    private final int B(float r7) {
        if (this.f11441h == true) goto L5;
    L18:
        double r2 = r7;
        double r4 = this.f11442i;
        boolean r0 = true;
        if (r2 <= r4) goto L22;
    L20:
        r0 = false;
    L32:
        if (r0 == true) goto L34;
        return 0;
    L34:
        return -getRViewWidth();
    L22:
        if (r2 < (-r4)) goto L32;
        int r8 = this.z;
        if (r8 < 0) goto L27;
    L29:
        int r9 = this.z;
        if (r9 >= 0) goto L20;
        Math.abs(r9);
        int r1 = getRViewWidth() / 2;
        goto L20
    L27:
        if (Math.abs(r8) <= (getRViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r3 = this.z;
        if (r3 >= 0) goto L11;
        if (Math.abs(r3) <= (this.A / 2)) goto L11;
    L13:
        return (-this.A) + this.G;
    L11:
        if (r7 < (-this.f11442i)) goto L13;
        return 0;
    L15:
        if (F(r7) == false) goto L18;
        return (-this.A) + this.G;
    }

    private final int C(float r7) {
        if (this.f11441h == true) goto L5;
    L18:
        double r2 = r7;
        double r4 = this.f11442i;
        boolean r0 = true;
        if (r2 <= r4) goto L22;
    L32:
        if (r0 == true) goto L34;
        return 0;
    L34:
        return getLViewWidth();
    L22:
        if (r2 >= (-r4)) goto L24;
    L23:
        r0 = false;
        goto L32
    L24:
        int r8 = this.z;
        if (r8 > 0) goto L27;
    L29:
        int r9 = this.z;
        if (r9 <= 0) goto L23;
        Math.abs(r9);
        int r1 = getLViewWidth() / 2;
        goto L23
    L27:
        if (Math.abs(r8) <= (getLViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r3 = this.z;
        if (r3 <= 0) goto L11;
        if (Math.abs(r3) <= (this.A / 2)) goto L11;
    L13:
        return this.A - this.f11438J;
    L11:
        if (r7 > this.f11442i) goto L13;
        return 0;
    L15:
        if (G(r7) == false) goto L18;
        return this.A - this.f11438J;
    }

    private final View D(MotionEvent r5, ViewGroup r6) {
        o.c(r6);
        if (r6.onInterceptTouchEvent(r5) == false) goto L5;
        return r6;
    L5:
        int r0 = r6.getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L12;
        View r2 = r6.getChildAt(r1);
        o.e(r2, "rootView.getChildAt(i)");
        if (N(r2) == true) goto L10;
        r1 = r1 + 1;
        goto L6
    L10:
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.view.ViewGroup");
        return D(r5, (ViewGroup) r2);
    L12:
        return null;
    }

    private final boolean E() {
        if (this.z != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean F(float r5) {
        if (r5 < (-this.f11442i)) goto L5;
    L6:
        int r6 = this.z;
        if (r6 < 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r6) <= (this.A / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.z) > getRViewWidth()) goto L10;
        goto L6
    }

    private final boolean G(float r5) {
        if (r5 > this.f11442i) goto L5;
    L6:
        int r6 = this.z;
        if (r6 > 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r6) <= (this.A / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.z) > getLViewWidth()) goto L10;
        goto L6
    }

    private final boolean H(int r3) {
        int r2 = this.w;
        if (r2 != 1) goto L5;
    L6:
        if (r3 == 0) goto L10;
    L8:
        return false;
    L10:
        return true;
    L5:
        if (r2 != 2) goto L8;
        goto L6
    }

    private final boolean I() {
        int r2 = this.w;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private final boolean J(float r6) {
        int r0 = this.z;
        if (r0 >= 0) goto L5;
    L6:
        if (r0 <= 0) goto L8;
    L9:
        if (r0 >= 0) goto L11;
    L12:
        int r7 = this.z;
        if (r7 <= 0) goto L15;
    L17:
        return false;
    L15:
        if (Math.abs(r7) >= (getRViewWidth() / 2)) goto L17;
    L16:
        return true;
    L11:
        if (Math.abs(r0) < (getLViewWidth() / 2)) goto L16;
    L8:
        if (r6 > this.f11442i) goto L16;
    L5:
        if (r6 < (-this.f11442i)) goto L16;
        goto L6
    }

    private final boolean K(float r7) {
        if (r7 >= 0) goto L5;
        return false;
    L5:
        int r1 = this.z;
        if (r1 > 0) goto L8;
    L9:
        if (r1 > 0) goto L11;
        return false;
    L11:
        if (Math.abs(r1) <= (getLViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r7 > this.f11442i) goto L12;
        goto L9
    }

    private final boolean L(float r7) {
        if (r7 <= 0) goto L5;
        return false;
    L5:
        int r1 = this.z;
        if (r1 < 0) goto L8;
    L9:
        if (r1 < 0) goto L11;
        return false;
    L11:
        if (Math.abs(r1) <= (getRViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r7 < (-this.f11442i)) goto L12;
        goto L9
    }

    private final boolean M(MotionEvent r4) {
        int[] r0 = new int[2];
        View r1 = this.D;
        o.c(r1);
        r1.getLocationOnScreen(r0);
        int r2 = r0[1];
        View r3 = this.D;
        o.c(r3);
        int r5 = r2 + r3.getMeasuredHeight();
        int r6 = r0[1];
        int r7 = (int) r4.getRawY();
        if ((r6 + 1) > r7) goto L7;
        if (r5 <= r7) goto L7;
        return true;
    L7:
        return false;
    }

    private final boolean N(View r1) {
        return r1 instanceof ViewGroup;
    }

    private final boolean O(View r2, Point r3) {
        if (r3.y >= r2.getTop()) goto L5;
    L11:
        return false;
    L5:
        if (r3.y >= r2.getBottom()) goto L11;
        if (r3.x < r2.getLeft()) goto L11;
        if (r3.y >= r2.getRight()) goto L11;
        return true;
    }

    private final void P() {
        if (this.f11441h == false) goto L8;
        if (this.f11439f == 3) goto L8;
        this.f11443j = true;
    L8:
        if (this.f11439f != 3) goto L11;
        setRightViewPadding(0);
        this.u = 0;
        return;
    }

    private final void Q() {
        post(new b(this));
    }

    private final void R() {
        if (E() == false) goto L15;
        this.B = false;
        this.C = false;
        InterfaceC0300a r0 = this.K;
        if (r0 == null) goto L7;
        r0.onClose();
    L7:
        View r1 = this.E;
        if (r1 == null) goto L10;
        r1.layout(0, r1.getTop(), r1.getWidth(), r1.getBottom());
    L10:
        View r2 = this.H;
        if (r2 == null) goto L13;
        r2.layout(0, r2.getTop(), r2.getWidth(), r2.getBottom());
    L13:
        this.s = 0;
        return;
    L15:
        if (getLeftOpenFinished() == false) goto L17;
    L26:
        this.B = true;
        this.C = false;
        InterfaceC0300a r3 = this.K;
        if (r3 == null) goto L34;
        r3.b(2, getLeftOpenFinished());
        return;
    L34:
        return;
    L17:
        if (getLeftViewOpened() == true) goto L26;
        if (getRightOpenFinished() == false) goto L22;
    L23:
        this.B = false;
        this.C = true;
        InterfaceC0300a r4 = this.K;
        if (r4 == null) goto L32;
        r4.b(1, getRightOpenFinished());
        return;
    L32:
        return;
    L22:
        if (getRightViewOpened() == true) goto L23;
    }

    public static final /* synthetic */ int a(a r0, int r1, int r2) {
        return r0.x(r1, r2);
    }

    public static final /* synthetic */ int b(a r0, int r1) {
        return r0.y(r1);
    }

    public static final /* synthetic */ int c(a r0, int r1) {
        return r0.z(r1);
    }

    public static final /* synthetic */ int d(a r0) {
        return r0.w;
    }

    public static final /* synthetic */ ViewDragHelper e(a r0) {
        return r0.x;
    }

    public static final /* synthetic */ View f(a r0) {
        return r0.D;
    }

    public static final /* synthetic */ int g(a r0, float r1) {
        return r0.A(r1);
    }

    private final int getLViewWidth() {
        return this.q;
    }

    private final boolean getLeftOpenFinished() {
        if (this.z != (this.A - this.f11438J)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftViewOpened() {
        if (this.H != null) goto L5;
    L7:
        return false;
    L5:
        if (this.z != getLViewWidth()) goto L7;
        return true;
    }

    private final int getPreviousPosition() {
        if (this.B == false) goto L6;
        return getLViewWidth();
    L6:
        if (this.C == true) goto L11;
        return 0;
    L11:
        return -getRViewWidth();
    }

    private final int getRViewWidth() {
        return this.n;
    }

    private final boolean getRightOpenFinished() {
        if (this.z != ((-this.A) + this.G)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewEmpty() {
        if (this.E != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getRightViewOpened() {
        if (this.E != null) goto L5;
    L7:
        return false;
    L5:
        if (this.z != (-getRViewWidth())) goto L7;
        return true;
    }

    public static final /* synthetic */ int h(a r0, float r1) {
        return r0.B(r1);
    }

    public static final /* synthetic */ int i(a r0, float r1) {
        return r0.C(r1);
    }

    public static final /* synthetic */ int j(a r0) {
        return r0.A;
    }

    public static final /* synthetic */ boolean k(a r0) {
        return r0.B;
    }

    public static final /* synthetic */ View l(a r0) {
        return r0.H;
    }

    public static final /* synthetic */ View m(a r0) {
        return r0.I;
    }

    public static final /* synthetic */ int n(a r0) {
        return r0.getPreviousPosition();
    }

    public static final /* synthetic */ int o(a r0) {
        return r0.s;
    }

    public static final /* synthetic */ boolean p(a r0) {
        return r0.C;
    }

    public static final /* synthetic */ View q(a r0) {
        return r0.E;
    }

    public static final /* synthetic */ View r(a r0) {
        return r0.F;
    }

    public static final /* synthetic */ boolean s(a r0, int r1) {
        return r0.H(r1);
    }

    private final void setRightViewPadding(int r1) {
        this.t = r1;
        P();
    }

    public static final /* synthetic */ void t(a r0, int r1) {
        r0.w = r1;
    }

    public static final /* synthetic */ void u(a r0, int r1) {
        r0.z = r1;
    }

    public static final /* synthetic */ void v(a r0, int r1) {
        r0.s = r1;
    }

    public static final /* synthetic */ void w(a r0) {
        r0.R();
    }

    private final int x(int r4, int r5) {
        boolean r0 = this.f11444k;
        if (r0 == false) goto L5;
    L9:
        if (r0 == false) goto L11;
    L15:
        boolean r6 = this.f11443j;
        if (r6 == true) goto L20;
        if (r4 <= 0) goto L20;
        return e.f(r4, getLViewWidth());
    L20:
        if (r6 == true) goto L24;
        if (r4 >= 0) goto L24;
        return e.c(r4, -getRViewWidth());
    L24:
        if (r4 >= 0) goto L27;
        return e.c(r4, this.u - this.A);
    L27:
        return e.f(r4, this.A - this.t);
    L11:
        if (this.C == false) goto L15;
        if (r5 <= 0) goto L15;
        return e.f(r4, 0);
    L5:
        if (this.B == false) goto L9;
        if (r5 >= 0) goto L9;
        return e.c(r4, 0);
    }

    private final int y(int r3) {
        if (this.f11441h == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.f11444k == false) goto L11;
        int r2 = this.A;
        if (r3 <= r2) goto L15;
        return 0;
    L15:
        return e.c(r3, -r2);
    L11:
        if (r3 > 0) goto L41;
        r2 = this.A;
        goto L15
    L41:
        return 0;
    L17:
        if (this.f11443j == false) goto L30;
        if (this.f11444k == false) goto L25;
        int r0 = this.A;
        if (r3 <= r0) goto L24;
        return 0;
    L24:
        return e.c(r3, this.u - r0);
    L25:
        if (r3 <= 0) goto L28;
        return 0;
    L28:
        return e.c(r3, this.u - this.A);
    L30:
        if (this.f11444k == true) goto L32;
        if (r3 <= 0) goto L39;
        return 0;
    L39:
        return e.c(r3, -getRViewWidth());
    L32:
        if (r3 <= this.A) goto L35;
        return 0;
    L35:
        return e.c(r3, -getRViewWidth());
    }

    private final int z(int r3) {
        if (this.f11441h == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.f11444k == false) goto L11;
        int r2 = this.A;
        if (r3 >= (-r2)) goto L15;
        return -r2;
    L15:
        return e.f(r3, r2);
    L11:
        if (r3 < 0) goto L41;
        r2 = this.A;
        goto L15
    L41:
        return 0;
    L17:
        if (this.f11443j == false) goto L30;
        if (this.f11444k == false) goto L25;
        int r0 = this.A;
        if (r3 >= (-r0)) goto L24;
        return -r0;
    L24:
        return e.f(r3, r0 - this.t);
    L25:
        if (r3 >= 0) goto L28;
        return 0;
    L28:
        return e.f(r3, this.A - this.t);
    L30:
        if (this.f11444k == false) goto L36;
        int r1 = this.A;
        if (r3 >= (-r1)) goto L35;
        return -r1;
    L35:
        return e.f(r3, getLViewWidth());
    L36:
        if (r3 >= 0) goto L39;
        return 0;
    L39:
        return e.f(r3, getLViewWidth());
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper r0 = this.x;
        o.c(r0);
        if (r0.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public final InterfaceC0300a getActionsListener() {
        return this.K;
    }

    public final boolean getContinuousSwipe() {
        return this.f11441h;
    }

    public final int getDirection() {
        return this.f11439f;
    }

    public final boolean getSwipeEnabled() {
        return this.f11440g;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        int r0 = this.r;
        if (r0 == 0) goto L5;
        this.D = findViewById(r0);
    L5:
        int r1 = this.o;
        if (r1 == 0) goto L8;
        this.H = findViewById(r1);
    L8:
        int r2 = this.f11445l;
        if (r2 == 0) goto L11;
        this.E = findViewById(r2);
    L11:
        int r3 = this.m;
        if (r3 == 0) goto L14;
        this.F = findViewById(r3);
    L14:
        int r4 = this.p;
        if (r4 == 0) goto L18;
        this.I = findViewById(r4);
    L18:
        if (this.D == null) goto L61;
        int r5 = this.f11439f;
        if (r5 != 1) goto L27;
        if (this.E != null) goto L27;
        throw new RuntimeException("'oui_sal_rightItem' must be specified");
    L27:
        if (r5 == 2) goto L29;
    L33:
        if (r5 == 1) goto L35;
    L41:
        if (r5 != 2) goto L50;
        if (this.f11441h == true) goto L50;
        if (this.H != null) goto L50;
        throw new RuntimeException("Must be specified 'oui_sal_leftItem'  or flag oui_sal_continuousSwipe = true");
    L50:
        if (r5 == 3) goto L52;
    L58:
        this.x = ViewDragHelper.create(this, 1.0f, this.M);
        this.y = new GestureDetectorCompat(getContext(), this.L);
        Q();
        super.onFinishInflate();
        return;
    L52:
        if (this.E == null) goto L57;
        if (this.H != null) goto L58;
    L57:
        throw new RuntimeException("'oui_sal_leftItem' and 'oui_sal_rightItem' must be specified");
    L35:
        if (this.f11441h == true) goto L41;
        if (this.E != null) goto L41;
        throw new RuntimeException("Must be specified 'oui_sal_rightItem' or flag oui_sal_continuousSwipe = true");
    L29:
        if (this.H != null) goto L33;
        throw new RuntimeException("'oui_sal_leftItem' must be specified");
    L61:
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        o.f(r6, NotificationCompat.CATEGORY_EVENT);
        if (this.v == false) goto L12;
        if (N(this.D) == false) goto L12;
        View r0 = D(r6, (ViewGroup) this.D);
        Point r2 = new Point((int) r6.getX(), (int) r6.getY());
        if (r0 == null) goto L12;
        if (O(r0, r2) == false) goto L12;
        return false;
    L12:
        if (M(r6) == false) goto L17;
        ViewDragHelper r5 = this.x;
        o.c(r5);
        if (r5.shouldInterceptTouchEvent(r6) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.A = r1;
        super.onSizeChanged(r1, r2, r3, r4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        o.f(r2, NotificationCompat.CATEGORY_EVENT);
        if (M(r2) == false) goto L5;
    L8:
        GestureDetectorCompat r0 = this.y;
        o.c(r0);
        r0.onTouchEvent(r2);
        ViewDragHelper r1 = this.x;
        o.c(r1);
        r1.processTouchEvent(r2);
        return true;
    L5:
        if (I() == true) goto L8;
        return super.onTouchEvent(r2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        this.v = r1;
    }

    public final void setActionsListener(InterfaceC0300a r1) {
        this.K = r1;
    }

    public final void setContinuousSwipe(boolean r1) {
        this.f11441h = r1;
    }

    public final void setDirection(int r1) {
        this.f11439f = r1;
    }

    public final void setSwipeEnabled(boolean r1) {
        this.f11440g = r1;
    }
}
