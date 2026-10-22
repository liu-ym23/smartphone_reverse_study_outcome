package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.obric.common.oui.R;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OSwipeActionLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "使用 OSwipeLayout")
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 \u0082\u00012\u00020\u0001:\u0004\u0082\u0001\u0083\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010U\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u0007H\u0002J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u0007H\u0002J\u0006\u0010Z\u001a\u00020[J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010a\u001a\u00020\u00072\u0006\u0010^\u001a\u00020_H\u0002J\u001c\u0010b\u001a\u0004\u0018\u00010$2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010fH\u0002J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010h\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010i\u001a\u00020\u00122\u0006\u0010j\u001a\u00020\u0007H\u0002J\u0010\u0010k\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010l\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010m\u001a\u00020\u00122\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010n\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0002J\u0012\u0010o\u001a\u00020\u00122\b\u0010p\u001a\u0004\u0018\u00010$H\u0002J\u0018\u0010q\u001a\u00020\u00122\u0006\u0010p\u001a\u00020$2\u0006\u0010r\u001a\u00020sH\u0002J\u0010\u0010t\u001a\u00020[2\u0006\u0010u\u001a\u00020\u0007H\u0002J\b\u0010v\u001a\u00020[H\u0014J\u0010\u0010w\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0016J(\u0010x\u001a\u00020[2\u0006\u0010y\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u0007H\u0014J\u0010\u0010}\u001a\u00020\u00122\u0006\u0010c\u001a\u00020dH\u0016J\b\u0010~\u001a\u00020[H\u0002J\u0010\u0010\u007f\u001a\u00020[2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\t\u0010\u0080\u0001\u001a\u00020[H\u0002J\t\u0010\u0081\u0001\u001a\u00020[H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0014R\u0014\u0010.\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0014R\u0014\u0010/\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u001aR\u000e\u00101\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0014R\u0010\u00106\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0014R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001aR\u000e\u0010?\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u001aR\u000e\u0010B\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0014R\u0010\u0010G\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0014R\u000e\u0010L\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u0014R\u001e\u0010P\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bQ\u0010\u001cR\u001a\u0010R\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0014\"\u0004\bT\u0010\u0016¨\u0006\u0084\u0001"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionsListener", "Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "getActionsListener", "()Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "setActionsListener", "(Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;)V", "autoOpenSpeed", "", "continuousSwipe", "", "getContinuousSwipe", "()Z", "setContinuousSwipe", "(Z)V", "curDraggingState", MaterialConfigFormatNames.DIRECTION, "getDirection", "()I", "setDirection", "(I)V", "disallowIntercept", "dragAfterOpened", "dragHelper", "Landroidx/customview/widget/ViewDragHelper;", "dragHelperCallback", "Landroidx/customview/widget/ViewDragHelper$Callback;", "draggedView", "Landroid/view/View;", "draggedViewId", "draggingViewLeft", "freeDrag", "gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetectorCallBack", "Landroid/view/GestureDetector$OnGestureListener;", "horizontalWidth", "isClosed", "isMoving", "lViewWidth", "getLViewWidth", "leftFullOpenPending", "leftItemFirstExpendWidth", "leftOpen", "leftOpenFinished", "getLeftOpenFinished", "leftView", "leftViewBg", "leftViewBgId", "leftViewId", "leftViewOpened", "getLeftViewOpened", "leftViewPadding", "previousPosition", "getPreviousPosition", "previousUnprocessedPixel", "rViewWidth", "getRViewWidth", "rightFullOpenPending", "rightItemFirstExpendWidth", "rightOpen", "rightOpenFinished", "getRightOpenFinished", "rightView", "rightViewBg", "rightViewBgId", "rightViewEmpty", "getRightViewEmpty", "rightViewId", "rightViewOpened", "getRightViewOpened", "value", "rightViewPadding", "setRightViewPadding", "swipeEnabled", "getSwipeEnabled", "setSwipeEnabled", "clampHorizontalViewPosition", "left", "dx", "clampLeftViewPosition", "clampRightViewPosition", "close", "", "computeScroll", "getFinalXHorizontalDirection", "xVel", "", "getFinalXLeftDirection", "getFinalXRightDirection", "getNeededTouchView", "event", "Landroid/view/MotionEvent;", "rootView", "Landroid/view/ViewGroup;", "isContinuousSwipeToLeft", "isContinuousSwipeToRight", "isIdleAfterMoving", "state", "isSwipeToClose", "isSwipeToOpenLeft", "isSwipeToOpenRight", "isSwipeViewTarget", "isViewGroup", "view", "isViewTouchTarget", "point", "Landroid/graphics/Point;", "moveTo", MaterialConfigFormatNames.X, "onFinishInflate", "onInterceptTouchEvent", "onSizeChanged", "w", "h", "oldW", "oldH", "onTouchEvent", "parametersAdjustment", "requestDisallowInterceptTouchEvent", "setupPost", "updateState", "Companion", "SwipeActionsListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwipeActionLayout extends FrameLayout {
    private static final int CLOSE_POSITION = 0;
    public static final Companion Companion = null;
    private static final int DEFAULT_AUTO_OPEN_SPEED = 1000;
    public static final int HORIZONTAL = 3;
    public static final int LEFT = 1;
    private static final int NO_POSITION = -1;
    public static final int RIGHT = 2;
    private SwipeActionsListener actionsListener;
    private final double autoOpenSpeed;
    private boolean continuousSwipe;
    private int curDraggingState;
    private int direction;
    private boolean disallowIntercept;
    private boolean dragAfterOpened;
    private ViewDragHelper dragHelper;
    private final ViewDragHelper.Callback dragHelperCallback;
    private View draggedView;
    private final int draggedViewId;
    private int draggingViewLeft;
    private boolean freeDrag;
    private GestureDetectorCompat gestureDetector;
    private final GestureDetector.OnGestureListener gestureDetectorCallBack;
    private int horizontalWidth;
    private int leftFullOpenPending;
    private final int leftItemFirstExpendWidth;
    private boolean leftOpen;
    private View leftView;
    private View leftViewBg;
    private final int leftViewBgId;
    private final int leftViewId;
    private int leftViewPadding;
    private int previousUnprocessedPixel;
    private int rightFullOpenPending;
    private final int rightItemFirstExpendWidth;
    private boolean rightOpen;
    private View rightView;
    private View rightViewBg;
    private final int rightViewBgId;
    private final int rightViewId;
    private int rightViewPadding;
    private boolean swipeEnabled;

    /* JADX INFO: compiled from: OSwipeActionLayout.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout$Companion;", "", "()V", "CLOSE_POSITION", "", "DEFAULT_AUTO_OPEN_SPEED", "HORIZONTAL", "LEFT", "NO_POSITION", "RIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: OSwipeActionLayout.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/obric/oui/swipeaction/OSwipeActionLayout$SwipeActionsListener;", "", "onClose", "", "onOpen", MaterialConfigFormatNames.DIRECTION, "", "isContinuous", "", "onToOpen", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SwipeActionsListener {
        void onClose();

        void onOpen(int r1, boolean r2);

        void onToOpen();
    }

    /* JADX INFO: renamed from: $r8$lambda$B3NJW7oNhCUgX-OLtjkyN7tYlEQ, reason: not valid java name */
    public static /* synthetic */ void m543$r8$lambda$B3NJW7oNhCUgXOLtjkyN7tYlEQ(OSwipeActionLayout r0) {
        m544setupPost$lambda2(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public OSwipeActionLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OSwipeActionLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public static final /* synthetic */ int access$clampHorizontalViewPosition(OSwipeActionLayout r0, int r1, int r2) {
        return r0.clampHorizontalViewPosition(r1, r2);
    }

    public static final /* synthetic */ int access$clampLeftViewPosition(OSwipeActionLayout r0, int r1) {
        return r0.clampLeftViewPosition(r1);
    }

    public static final /* synthetic */ int access$clampRightViewPosition(OSwipeActionLayout r0, int r1) {
        return r0.clampRightViewPosition(r1);
    }

    public static final /* synthetic */ int access$getCurDraggingState$p(OSwipeActionLayout r0) {
        return r0.curDraggingState;
    }

    public static final /* synthetic */ ViewDragHelper access$getDragHelper$p(OSwipeActionLayout r0) {
        return r0.dragHelper;
    }

    public static final /* synthetic */ View access$getDraggedView$p(OSwipeActionLayout r0) {
        return r0.draggedView;
    }

    public static final /* synthetic */ int access$getFinalXHorizontalDirection(OSwipeActionLayout r0, float r1) {
        return r0.getFinalXHorizontalDirection(r1);
    }

    public static final /* synthetic */ int access$getFinalXLeftDirection(OSwipeActionLayout r0, float r1) {
        return r0.getFinalXLeftDirection(r1);
    }

    public static final /* synthetic */ int access$getFinalXRightDirection(OSwipeActionLayout r0, float r1) {
        return r0.getFinalXRightDirection(r1);
    }

    public static final /* synthetic */ int access$getHorizontalWidth$p(OSwipeActionLayout r0) {
        return r0.horizontalWidth;
    }

    public static final /* synthetic */ boolean access$getLeftOpen$p(OSwipeActionLayout r0) {
        return r0.leftOpen;
    }

    public static final /* synthetic */ View access$getLeftView$p(OSwipeActionLayout r0) {
        return r0.leftView;
    }

    public static final /* synthetic */ View access$getLeftViewBg$p(OSwipeActionLayout r0) {
        return r0.leftViewBg;
    }

    public static final /* synthetic */ int access$getPreviousPosition(OSwipeActionLayout r0) {
        return r0.getPreviousPosition();
    }

    public static final /* synthetic */ int access$getPreviousUnprocessedPixel$p(OSwipeActionLayout r0) {
        return r0.previousUnprocessedPixel;
    }

    public static final /* synthetic */ boolean access$getRightOpen$p(OSwipeActionLayout r0) {
        return r0.rightOpen;
    }

    public static final /* synthetic */ View access$getRightView$p(OSwipeActionLayout r0) {
        return r0.rightView;
    }

    public static final /* synthetic */ View access$getRightViewBg$p(OSwipeActionLayout r0) {
        return r0.rightViewBg;
    }

    public static final /* synthetic */ boolean access$isIdleAfterMoving(OSwipeActionLayout r0, int r1) {
        return r0.isIdleAfterMoving(r1);
    }

    public static final /* synthetic */ void access$setCurDraggingState$p(OSwipeActionLayout r0, int r1) {
        r0.curDraggingState = r1;
    }

    public static final /* synthetic */ void access$setDraggingViewLeft$p(OSwipeActionLayout r0, int r1) {
        r0.draggingViewLeft = r1;
    }

    public static final /* synthetic */ void access$setPreviousUnprocessedPixel$p(OSwipeActionLayout r0, int r1) {
        r0.previousUnprocessedPixel = r1;
    }

    public static final /* synthetic */ void access$updateState(OSwipeActionLayout r0) {
        r0.updateState();
    }

    public /* synthetic */ OSwipeActionLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OSwipeActionLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.direction = 1;
        this.disallowIntercept = true;
        TypedArray r6 = getContext().obtainStyledAttributes(r4, R.styleable.OSwipeActionLayout);
        Intrinsics.checkNotNullExpressionValue(r6, "getContext().obtainStyle…eable.OSwipeActionLayout)");
        this.direction = 1;
        this.swipeEnabled = r6.getBoolean(R.styleable.OSwipeActionLayout_oui_sal_swipeEnabled, true);
        this.continuousSwipe = r6.getBoolean(R.styleable.OSwipeActionLayout_oui_sal_continuousSwipe, true);
        this.autoOpenSpeed = r6.getInt(R.styleable.OSwipeActionLayout_oui_sal_autoMovingSensitivity, 1000);
        this.dragAfterOpened = r6.getBoolean(R.styleable.OSwipeActionLayout_oui_sal_dragAfterOpened, false);
        this.freeDrag = r6.getBoolean(R.styleable.OSwipeActionLayout_oui_sal_freeDrag, true);
        this.rightViewId = r6.getResourceId(R.styleable.OSwipeActionLayout_oui_sal_rightItem, 0);
        this.rightViewBgId = r6.getResourceId(R.styleable.OSwipeActionLayout_oui_sal_rightItem_bg, 0);
        this.rightItemFirstExpendWidth = (int) r6.getDimension(R.styleable.OSwipeActionLayout_oui_sal_rightItem_first_expand_width, 0.0f);
        this.rightFullOpenPending = (int) r6.getDimension(R.styleable.OSwipeActionLayout_oui_sal_rightItem_full_open_pending, 0.0f);
        this.leftViewId = r6.getResourceId(R.styleable.OSwipeActionLayout_oui_sal_leftItem, 0);
        this.leftViewBgId = r6.getResourceId(R.styleable.OSwipeActionLayout_oui_sal_leftItem_bg, 0);
        this.leftItemFirstExpendWidth = (int) r6.getDimension(R.styleable.OSwipeActionLayout_oui_sal_leftItem_first_expand_width, 0.0f);
        this.leftFullOpenPending = (int) r6.getDimension(R.styleable.OSwipeActionLayout_oui_sal_leftItem_full_open_pending, 0.0f);
        this.draggedViewId = r6.getResourceId(R.styleable.OSwipeActionLayout_oui_sal_draggedItem, 0);
        setRightViewPadding((int) r6.getDimension(R.styleable.OSwipeActionLayout_oui_sal_rightViewPadding, 0.0f));
        this.leftViewPadding = (int) r6.getDimension(R.styleable.OSwipeActionLayout_oui_sal_leftViewPadding, 0.0f);
        parametersAdjustment();
        r6.recycle();
        this.gestureDetectorCallBack = new OSwipeActionLayout$gestureDetectorCallBack$1(this);
        this.dragHelperCallback = new OSwipeActionLayout$dragHelperCallback$1(this);
    }

    public final int getDirection() {
        return this.direction;
    }

    public final void setDirection(int r1) {
        this.direction = r1;
    }

    public final boolean getSwipeEnabled() {
        return this.swipeEnabled;
    }

    public final void setSwipeEnabled(boolean r1) {
        this.swipeEnabled = r1;
    }

    public final boolean getContinuousSwipe() {
        return this.continuousSwipe;
    }

    public final void setContinuousSwipe(boolean r1) {
        this.continuousSwipe = r1;
    }

    private final void setRightViewPadding(int r1) {
        this.rightViewPadding = r1;
        parametersAdjustment();
    }

    public final SwipeActionsListener getActionsListener() {
        return this.actionsListener;
    }

    public final void setActionsListener(SwipeActionsListener r1) {
        this.actionsListener = r1;
    }

    private final boolean isMoving() {
        int r2 = this.curDraggingState;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private final boolean isClosed() {
        if (this.draggingViewLeft != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.horizontalWidth = r1;
        super.onSizeChanged(r1, r2, r3, r4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.disallowIntercept == false) goto L12;
        if (isViewGroup(this.draggedView) == false) goto L12;
        View r0 = getNeededTouchView(r6, (ViewGroup) this.draggedView);
        Point r2 = new Point((int) r6.getX(), (int) r6.getY());
        if (r0 == null) goto L12;
        if (isViewTouchTarget(r0, r2) == false) goto L12;
        return false;
    L12:
        if (isSwipeViewTarget(r6) == false) goto L17;
        ViewDragHelper r5 = this.dragHelper;
        Intrinsics.checkNotNull(r5);
        if (r5.shouldInterceptTouchEvent(r6) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        this.disallowIntercept = r1;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        int r0 = this.draggedViewId;
        if (r0 == 0) goto L5;
        this.draggedView = findViewById(r0);
    L5:
        int r1 = this.leftViewId;
        if (r1 == 0) goto L8;
        this.leftView = findViewById(r1);
    L8:
        int r2 = this.rightViewId;
        if (r2 == 0) goto L11;
        this.rightView = findViewById(r2);
    L11:
        int r3 = this.rightViewBgId;
        if (r3 == 0) goto L14;
        this.rightViewBg = findViewById(r3);
    L14:
        int r4 = this.leftViewBgId;
        if (r4 == 0) goto L18;
        this.leftViewBg = findViewById(r4);
    L18:
        if (this.draggedView == null) goto L61;
        int r5 = this.direction;
        if (r5 != 1) goto L27;
        if (this.rightView != null) goto L27;
        throw new RuntimeException("'oui_sal_rightItem' must be specified");
    L27:
        if (r5 == 2) goto L29;
    L33:
        if (r5 == 1) goto L35;
    L41:
        if (r5 != 2) goto L50;
        if (this.continuousSwipe == true) goto L50;
        if (this.leftView != null) goto L50;
        throw new RuntimeException("Must be specified 'oui_sal_leftItem'  or flag oui_sal_continuousSwipe = true");
    L50:
        if (r5 == 3) goto L52;
    L58:
        this.dragHelper = ViewDragHelper.create(this, 1.0f, this.dragHelperCallback);
        this.gestureDetector = new GestureDetectorCompat(getContext(), this.gestureDetectorCallBack);
        setupPost();
        super.onFinishInflate();
        return;
    L52:
        if (this.rightView == null) goto L57;
        if (this.leftView != null) goto L58;
    L57:
        throw new RuntimeException("'oui_sal_leftItem' and 'oui_sal_rightItem' must be specified");
    L35:
        if (this.continuousSwipe == true) goto L41;
        if (this.rightView != null) goto L41;
        throw new RuntimeException("Must be specified 'oui_sal_rightItem' or flag oui_sal_continuousSwipe = true");
    L29:
        if (this.leftView != null) goto L33;
        throw new RuntimeException("'oui_sal_leftItem' must be specified");
    L61:
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (isSwipeViewTarget(r2) == false) goto L5;
    L8:
        GestureDetectorCompat r0 = this.gestureDetector;
        Intrinsics.checkNotNull(r0);
        r0.onTouchEvent(r2);
        ViewDragHelper r1 = this.dragHelper;
        Intrinsics.checkNotNull(r1);
        r1.processTouchEvent(r2);
        return true;
    L5:
        if (isMoving() == true) goto L8;
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper r0 = this.dragHelper;
        Intrinsics.checkNotNull(r0);
        if (r0.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public final void close() {
        moveTo(0);
    }

    private final void updateState() {
        if (isClosed() == false) goto L18;
        this.leftOpen = false;
        this.rightOpen = false;
        SwipeActionsListener r0 = this.actionsListener;
        if (r0 == null) goto L8;
        r0.onClose();
    L8:
        View r1 = this.rightView;
        if (r1 == null) goto L12;
        r1.layout(0, r1.getTop(), r1.getWidth(), r1.getBottom());
    L12:
        View r2 = this.leftView;
        if (r2 == null) goto L16;
        r2.layout(0, r2.getTop(), r2.getWidth(), r2.getBottom());
    L16:
        this.previousUnprocessedPixel = 0;
        return;
    L18:
        if (getLeftOpenFinished() == false) goto L20;
    L30:
        this.leftOpen = true;
        this.rightOpen = false;
        SwipeActionsListener r3 = this.actionsListener;
        if (r3 == null) goto L39;
        r3.onOpen(2, getLeftOpenFinished());
        return;
    L39:
        return;
    L20:
        if (getLeftViewOpened() == true) goto L30;
        if (getRightOpenFinished() == false) goto L25;
    L26:
        this.leftOpen = false;
        this.rightOpen = true;
        SwipeActionsListener r4 = this.actionsListener;
        if (r4 == null) goto L38;
        r4.onOpen(1, getRightOpenFinished());
        return;
    L38:
        return;
    L25:
        if (getRightViewOpened() == true) goto L26;
    }

    private final int clampLeftViewPosition(int r3) {
        if (this.continuousSwipe == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.freeDrag == false) goto L12;
        int r2 = this.horizontalWidth;
        if (r3 <= r2) goto L40;
        return 0;
    L40:
        return RangesKt.coerceAtLeast(r3, -r2);
    L12:
        if (r3 <= 0) goto L15;
        return 0;
    L15:
        return RangesKt.coerceAtLeast(r3, -this.horizontalWidth);
    L17:
        if (this.dragAfterOpened == false) goto L30;
        if (this.freeDrag == false) goto L25;
        int r0 = this.horizontalWidth;
        if (r3 <= r0) goto L24;
        return 0;
    L24:
        return RangesKt.coerceAtLeast(r3, this.leftViewPadding - r0);
    L25:
        if (r3 <= 0) goto L28;
        return 0;
    L28:
        return RangesKt.coerceAtLeast(r3, this.leftViewPadding - this.horizontalWidth);
    L30:
        if (this.freeDrag == true) goto L32;
        if (r3 <= 0) goto L39;
        return 0;
    L39:
        return RangesKt.coerceAtLeast(r3, -getRViewWidth());
    L32:
        if (r3 <= this.horizontalWidth) goto L35;
        return 0;
    L35:
        return RangesKt.coerceAtLeast(r3, -getRViewWidth());
    }

    private final int clampRightViewPosition(int r3) {
        if (this.continuousSwipe == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.freeDrag == false) goto L12;
        int r2 = this.horizontalWidth;
        if (r3 >= (-r2)) goto L41;
        return -r2;
    L41:
        return RangesKt.coerceAtMost(r3, r2);
    L12:
        if (r3 >= 0) goto L15;
        return 0;
    L15:
        return RangesKt.coerceAtMost(r3, this.horizontalWidth);
    L17:
        if (this.dragAfterOpened == false) goto L30;
        if (this.freeDrag == false) goto L25;
        int r0 = this.horizontalWidth;
        if (r3 >= (-r0)) goto L24;
        return -r0;
    L24:
        return RangesKt.coerceAtMost(r3, r0 - this.rightViewPadding);
    L25:
        if (r3 >= 0) goto L28;
        return 0;
    L28:
        return RangesKt.coerceAtMost(r3, this.horizontalWidth - this.rightViewPadding);
    L30:
        if (this.freeDrag == false) goto L36;
        int r1 = this.horizontalWidth;
        if (r3 >= (-r1)) goto L35;
        return -r1;
    L35:
        return RangesKt.coerceAtMost(r3, getLViewWidth());
    L36:
        if (r3 >= 0) goto L39;
        return 0;
    L39:
        return RangesKt.coerceAtMost(r3, getLViewWidth());
    }

    private final int clampHorizontalViewPosition(int r4, int r5) {
        boolean r0 = this.freeDrag;
        if (r0 == false) goto L5;
    L9:
        if (r0 == false) goto L11;
    L15:
        boolean r6 = this.dragAfterOpened;
        if (r6 == true) goto L20;
        if (r4 <= 0) goto L20;
        return RangesKt.coerceAtMost(r4, getLViewWidth());
    L20:
        if (r6 == true) goto L24;
        if (r4 >= 0) goto L24;
        return RangesKt.coerceAtLeast(r4, -getRViewWidth());
    L24:
        if (r4 >= 0) goto L27;
        return RangesKt.coerceAtLeast(r4, this.leftViewPadding - this.horizontalWidth);
    L27:
        return RangesKt.coerceAtMost(r4, this.horizontalWidth - this.rightViewPadding);
    L11:
        if (this.rightOpen == false) goto L15;
        if (r5 <= 0) goto L15;
        return RangesKt.coerceAtMost(r4, 0);
    L5:
        if (this.leftOpen == false) goto L9;
        if (r5 >= 0) goto L9;
        return RangesKt.coerceAtLeast(r4, 0);
    }

    private final int getPreviousPosition() {
        if (this.leftOpen == false) goto L6;
        return getLViewWidth();
    L6:
        if (this.rightOpen == true) goto L11;
        return 0;
    L11:
        return -getRViewWidth();
    }

    private final int getFinalXLeftDirection(float r7) {
        if (this.continuousSwipe == true) goto L5;
    L18:
        double r2 = r7;
        double r4 = this.autoOpenSpeed;
        if (r2 <= r4) goto L21;
    L20:
        boolean r0 = false;
    L32:
        if (r0 == true) goto L34;
        return 0;
    L34:
        return -getRViewWidth();
    L21:
        r0 = true;
        if (r2 < (-r4)) goto L32;
        int r8 = this.draggingViewLeft;
        if (r8 < 0) goto L27;
    L29:
        int r9 = this.draggingViewLeft;
        if (r9 >= 0) goto L20;
        Math.abs(r9);
        int r1 = getRViewWidth() / 2;
        goto L20
    L27:
        if (Math.abs(r8) <= (getRViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r3 = this.draggingViewLeft;
        if (r3 >= 0) goto L11;
        if (Math.abs(r3) <= (this.horizontalWidth / 2)) goto L11;
    L13:
        return (-this.horizontalWidth) + this.rightFullOpenPending;
    L11:
        if (r7 < (-this.autoOpenSpeed)) goto L13;
        return 0;
    L15:
        if (isContinuousSwipeToLeft(r7) == false) goto L18;
        return (-this.horizontalWidth) + this.rightFullOpenPending;
    }

    private final int getFinalXRightDirection(float r7) {
        if (this.continuousSwipe == true) goto L5;
    L18:
        double r2 = r7;
        double r4 = this.autoOpenSpeed;
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
        int r8 = this.draggingViewLeft;
        if (r8 > 0) goto L27;
    L29:
        int r9 = this.draggingViewLeft;
        if (r9 <= 0) goto L23;
        Math.abs(r9);
        int r1 = getLViewWidth() / 2;
        goto L23
    L27:
        if (Math.abs(r8) <= (getLViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r3 = this.draggingViewLeft;
        if (r3 <= 0) goto L11;
        if (Math.abs(r3) <= (this.horizontalWidth / 2)) goto L11;
    L13:
        return this.horizontalWidth - this.leftFullOpenPending;
    L11:
        if (r7 > this.autoOpenSpeed) goto L13;
        return 0;
    L15:
        if (isContinuousSwipeToRight(r7) == false) goto L18;
        return this.horizontalWidth - this.leftFullOpenPending;
    }

    private final int getFinalXHorizontalDirection(float r2) {
        if (isSwipeToOpenLeft(r2) == false) goto L7;
        return getLViewWidth();
    L7:
        if (isSwipeToOpenRight(r2) == false) goto L11;
        return -getRViewWidth();
    L11:
        if (isSwipeToClose(r2) == false) goto L14;
        return 0;
    L14:
        return -1;
    }

    private final boolean isContinuousSwipeToRight(float r5) {
        if (r5 > this.autoOpenSpeed) goto L5;
    L6:
        int r6 = this.draggingViewLeft;
        if (r6 > 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r6) <= (this.horizontalWidth / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.draggingViewLeft) > getLViewWidth()) goto L10;
        goto L6
    }

    private final boolean isContinuousSwipeToLeft(float r5) {
        if (r5 < (-this.autoOpenSpeed)) goto L5;
    L6:
        int r6 = this.draggingViewLeft;
        if (r6 < 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r6) <= (this.horizontalWidth / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.draggingViewLeft) > getRViewWidth()) goto L10;
        goto L6
    }

    private final boolean isSwipeToOpenRight(float r7) {
        if (r7 <= 0.0f) goto L5;
        return false;
    L5:
        int r0 = this.draggingViewLeft;
        if (r0 < 0) goto L8;
    L9:
        if (r0 < 0) goto L11;
        return false;
    L11:
        if (Math.abs(r0) <= (getRViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r7 < (-this.autoOpenSpeed)) goto L12;
        goto L9
    }

    private final boolean isSwipeToOpenLeft(float r7) {
        if (r7 >= 0.0f) goto L5;
        return false;
    L5:
        int r0 = this.draggingViewLeft;
        if (r0 > 0) goto L8;
    L9:
        if (r0 > 0) goto L11;
        return false;
    L11:
        if (Math.abs(r0) <= (getLViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r7 > this.autoOpenSpeed) goto L12;
        goto L9
    }

    private final boolean isSwipeToClose(float r6) {
        int r0 = this.draggingViewLeft;
        if (r0 >= 0) goto L5;
    L6:
        if (r0 <= 0) goto L8;
    L9:
        if (r0 >= 0) goto L11;
    L12:
        int r7 = this.draggingViewLeft;
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
        if (r6 > this.autoOpenSpeed) goto L16;
    L5:
        if (r6 < (-this.autoOpenSpeed)) goto L16;
        goto L6
    }

    private final void setupPost() {
        post(new OSwipeActionLayout$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: setupPost$lambda-2, reason: not valid java name */
    private static final void m544setupPost$lambda2(OSwipeActionLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        int r0 = r2.direction;
        if (r0 != 1) goto L5;
        View r1 = r2.rightView;
        Intrinsics.checkNotNull(r1);
        r1.setX(r2.horizontalWidth);
        return;
    L5:
        if (r0 != 2) goto L7;
        View r3 = r2.leftView;
        Intrinsics.checkNotNull(r3);
        View r4 = r2.leftView;
        Intrinsics.checkNotNull(r4);
        r3.setX(-r4.getWidth());
        return;
    L7:
        if (r0 != 3) goto L15;
        View r5 = r2.rightView;
        Intrinsics.checkNotNull(r5);
        r5.setX(r2.horizontalWidth);
        View r6 = r2.leftView;
        Intrinsics.checkNotNull(r6);
        View r7 = r2.leftView;
        Intrinsics.checkNotNull(r7);
        r6.setX(-r7.getWidth());
        return;
    }

    private final boolean isViewTouchTarget(View r2, Point r3) {
        if (r3.y >= r2.getTop()) goto L5;
    L11:
        return false;
    L5:
        if (r3.y >= r2.getBottom()) goto L11;
        if (r3.x < r2.getLeft()) goto L11;
        if (r3.y >= r2.getRight()) goto L11;
        return true;
    }

    private final View getNeededTouchView(MotionEvent r5, ViewGroup r6) {
        Intrinsics.checkNotNull(r6);
        if (r6.onInterceptTouchEvent(r5) == true) goto L5;
        int r0 = r6.getChildCount();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L13;
        int r2 = r1 + 1;
        View r3 = r6.getChildAt(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "rootView.getChildAt(i)");
        if (isViewGroup(r3) == true) goto L12;
        r1 = r2;
        goto L7
    L12:
        return getNeededTouchView(r5, (ViewGroup) r3);
    L13:
        return null;
    L5:
        return r6;
    }

    private final boolean isViewGroup(View r1) {
        return r1 instanceof ViewGroup;
    }

    private final boolean isSwipeViewTarget(MotionEvent r4) {
        int[] r0 = new int[2];
        View r1 = this.draggedView;
        Intrinsics.checkNotNull(r1);
        r1.getLocationOnScreen(r0);
        int r2 = r0[1];
        View r3 = this.draggedView;
        Intrinsics.checkNotNull(r3);
        int r5 = r2 + r3.getMeasuredHeight();
        int r6 = r0[1];
        int r7 = (int) r4.getRawY();
        if ((r6 + 1) > r7) goto L7;
        if (r7 >= r5) goto L7;
        return true;
    L7:
        return false;
    }

    private final boolean isIdleAfterMoving(int r3) {
        int r2 = this.curDraggingState;
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

    private final boolean getRightViewOpened() {
        if (this.rightView != null) goto L5;
    L7:
        return false;
    L5:
        if (this.draggingViewLeft != (-getRViewWidth())) goto L7;
        return true;
    }

    private final boolean getLeftViewOpened() {
        if (this.leftView != null) goto L5;
    L7:
        return false;
    L5:
        if (this.draggingViewLeft != getLViewWidth()) goto L7;
        return true;
    }

    private final boolean getRightOpenFinished() {
        if (this.draggingViewLeft != ((-this.horizontalWidth) + this.rightFullOpenPending)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftOpenFinished() {
        if (this.draggingViewLeft != (this.horizontalWidth - this.leftFullOpenPending)) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getLViewWidth() {
        return this.leftItemFirstExpendWidth;
    }

    private final int getRViewWidth() {
        return this.rightItemFirstExpendWidth;
    }

    private final boolean getRightViewEmpty() {
        if (this.rightView != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void parametersAdjustment() {
        if (this.continuousSwipe == false) goto L8;
        if (this.direction == 3) goto L8;
        this.dragAfterOpened = true;
    L8:
        if (this.direction != 3) goto L11;
        setRightViewPadding(0);
        this.leftViewPadding = 0;
        return;
    }

    private final void moveTo(int r4) {
        ViewDragHelper r0 = this.dragHelper;
        Intrinsics.checkNotNull(r0);
        View r1 = this.draggedView;
        Intrinsics.checkNotNull(r1);
        View r2 = this.draggedView;
        Intrinsics.checkNotNull(r2);
        r0.smoothSlideViewTo(r1, r4, r2.getTop());
        ViewCompat.postInvalidateOnAnimation(this);
    }
}
