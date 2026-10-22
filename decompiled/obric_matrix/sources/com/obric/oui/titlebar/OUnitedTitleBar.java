package com.obric.oui.titlebar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.oui.titlebar.behavior.BaseBehavior;
import com.obric.oui.titlebar.behavior.HeaderBehavior;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0006\u008f\u0001\u0090\u0001\u0091\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b#\u0010\"J\r\u0010$\u001a\u00020\u000b¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u000b¢\u0006\u0004\b)\u0010%J\r\u0010*\u001a\u00020\u0003¢\u0006\u0004\b*\u0010\u0005J\r\u0010+\u001a\u00020\u0003¢\u0006\u0004\b+\u0010\u0005J\u0017\u0010,\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0003¢\u0006\u0004\b.\u0010\u0005J\r\u0010/\u001a\u00020\u0003¢\u0006\u0004\b/\u0010\u0005J\r\u00100\u001a\u00020\r¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u000b¢\u0006\u0004\b2\u0010%J\r\u00103\u001a\u00020\u0003¢\u0006\u0004\b3\u0010\u0005J\r\u00104\u001a\u00020\u0003¢\u0006\u0004\b4\u0010\u0005J\u0013\u00106\u001a\u0006\u0012\u0002\b\u000305H\u0016¢\u0006\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010D\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010@\u001a\u0004\bA\u0010B\"\u0004\b!\u0010CR\u0016\u0010F\u001a\u00020\u000b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001e\u0010ER$\u0010M\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010P\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010H\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR$\u0010W\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010\\\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\"R\u0016\u0010^\u001a\u00020\u000b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b]\u0010ER$\u0010`\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010@\u001a\u0004\b_\u0010B\"\u0004\b#\u0010CR$\u0010h\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010l\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010X\u001a\u0004\bj\u0010Z\"\u0004\bk\u0010\"R\u001e\u0010q\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u001c\u0010t\u001a\u00020\u00038\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\br\u0010=\u001a\u0004\bs\u0010\u0005R$\u0010y\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010\u0016R\"\u0010}\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010=\u001a\u0004\b{\u0010\u0005\"\u0004\b|\u0010\u0012R$\u0010\u0081\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b~\u0010E\u001a\u0004\b\u007f\u0010%\"\u0005\b\u0080\u0001\u0010\u000fR&\u0010\u0085\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010=\u001a\u0005\b\u0083\u0001\u0010\u0005\"\u0005\b\u0084\u0001\u0010\u0012R\u0018\u0010\u0087\u0001\u001a\u00020\u00038\u0002@\u0003X\u0083D¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010=R'\u0010\u008a\u0001\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b,\u0010c\u001a\u0005\b\u0088\u0001\u0010e\"\u0005\b\u0089\u0001\u0010gR\"\u0010\u008e\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroid/widget/FrameLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$AttachedBehavior;", "", "getSnapRange", "()I", "Landroid/view/View;", "defaultScrollingView", "e", "(Landroid/view/View;)Landroid/view/View;", "getScrollRange", "", "expanded", "Lkotlin/f0;", "setExpanded", "(Z)V", TypedValues.CycleType.S_WAVE_OFFSET, "d", "(I)V", "Lcom/obric/oui/titlebar/OUnitedTitleBar$a;", "onHeaderFlingUnConsumedListener", "setOnHeaderFlingUnConsumedListener", "(Lcom/obric/oui/titlebar/OUnitedTitleBar$a;)V", "Landroid/view/ViewGroup$LayoutParams;", "p", "Lcom/obric/oui/titlebar/behavior/BaseBehavior$h;", "g", "(Landroid/view/ViewGroup$LayoutParams;)Lcom/obric/oui/titlebar/behavior/BaseBehavior$h;", "Landroid/util/AttributeSet;", "attrs", "f", "(Landroid/util/AttributeSet;)Lcom/obric/oui/titlebar/behavior/BaseBehavior$h;", "view", "setLeftAction", "(Landroid/view/View;)V", "setRightAction", "j", "()Z", "lifted", "l", "(Z)Z", "i", "getDownNestedScrollRange", "getUpNestedPreScrollRange", "m", "(Landroid/view/View;)Z", "getTopInset", "getPendingAction", "k", "()V", "h", "getTotalScrollRange", "getDownNestedPreScrollRange", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "getBehavior", "()Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroidx/core/view/WindowInsetsCompat;", "y", "Landroidx/core/view/WindowInsetsCompat;", "lastInsets", "r", "I", "mPendingAction", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "getLeftAction", "()Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "leftAction", "Z", "liftOnScroll", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getMTvTitle", "()Landroid/widget/TextView;", "setMTvTitle", "(Landroid/widget/TextView;)V", "mTvTitle", "getMTvSubTitle", "setMTvSubTitle", "mTvSubTitle", "", "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "titleText", "Landroid/view/View;", "getBottomAction", "()Landroid/view/View;", "setBottomAction", "bottomAction", "z", "haveChildWithInterpolator", "getRightAction", "rightAction", "Landroid/graphics/drawable/Drawable;", "n", "Landroid/graphics/drawable/Drawable;", "getRightActionSrc", "()Landroid/graphics/drawable/Drawable;", "setRightActionSrc", "(Landroid/graphics/drawable/Drawable;)V", "rightActionSrc", "o", "getDivider", "setDivider", "divider", "", "Lcom/obric/oui/titlebar/OUnitedTitleBar$b;", "s", "Ljava/util/List;", "mOnOffsetChangeListeners", BaseSwitches.V, "getINVALID_SCROLL_RANGE", "INVALID_SCROLL_RANGE", "Lcom/obric/oui/titlebar/OUnitedTitleBar$a;", "getMOnHeaderFlingUnConsumedListener", "()Lcom/obric/oui/titlebar/OUnitedTitleBar$a;", "setMOnHeaderFlingUnConsumedListener", "mOnHeaderFlingUnConsumedListener", "q", "getMCollapsePosition", "setMCollapsePosition", "mCollapsePosition", "t", "getInDebug", "setInDebug", "inDebug", "u", "getTextInitPos", "setTextInitPos", "textInitPos", "w", "liftOnScrollTargetViewId", "getLeftActionSrc", "setLeftActionSrc", "leftActionSrc", "Ljava/lang/ref/WeakReference;", "x", "Ljava/lang/ref/WeakReference;", "liftOnScrollTargetView", "Behavior", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OUnitedTitleBar extends FrameLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int A = 0;
    private static final int B = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f11531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ViewGroup f11532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ViewGroup f11533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f11534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f11535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f11536k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f11537l;
    private Drawable m;
    private Drawable n;
    private View o;
    private a p;
    private int q;
    private int r;
    private List<b> s;
    private boolean t;
    private int u;
    private final int v;

    @IdRes
    private final int w;
    private WeakReference<View> x;
    private WindowInsetsCompat y;
    private final boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0016¢\u0006\u0004\bQ\u0010RB\u001d\b\u0016\u0012\b\u0010T\u001a\u0004\u0018\u00010S\u0012\b\u0010V\u001a\u0004\u0018\u00010U¢\u0006\u0004\bQ\u0010WJ3\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J;\u0010\u001d\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ9\u0010!\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\"J#\u0010#\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J'\u0010(\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010)J7\u0010-\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010\u000f\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010.J?\u00103\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104JG\u00109\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020*2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b9\u0010:J'\u0010;\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020*H\u0016¢\u0006\u0004\b;\u0010<J7\u0010>\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020*2\u0006\u0010=\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b>\u0010?J?\u0010@\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020*2\u0006\u0010=\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u00102\u001a\u00020\u0014H\u0016¢\u0006\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010ER\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010BR\u0016\u0010J\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010IR\u0016\u0010K\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010IR\u001e\u0010N\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010MR\u0016\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010BR\u0016\u0010P\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010I¨\u0006X"}, d2 = {"Lcom/obric/oui/titlebar/OUnitedTitleBar$Behavior;", "Lcom/obric/oui/titlebar/behavior/HeaderBehavior;", "Lcom/obric/oui/titlebar/OUnitedTitleBar;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "child", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "velocity", "Lkotlin/f0;", "b", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;IF)V", "parent", "header", TypedValues.AttributesType.S_TARGET, TypedValues.TransitionType.S_DURATION, "c", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;II)V", "view", "", "d", "(Lcom/obric/oui/titlebar/OUnitedTitleBar;)Z", "g", "(Lcom/obric/oui/titlebar/OUnitedTitleBar;)I", "h", "newOffset", "minOffset", "maxOffset", "q", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;III)I", "layout", "velocityY", "f", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;IIF)Z", "i", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;)V", "e", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;)Z", "layoutDirection", "j", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;I)Z", "Landroid/view/View;", "directTargetChild", "nestedScrollAxes", "o", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;Landroid/view/View;I)Z", "dx", "dy", "", "consumed", "m", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;II[I)V", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "n", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;IIII)V", "p", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;)V", "velocityX", "l", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;FF)Z", "k", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/obric/oui/titlebar/OUnitedTitleBar;Landroid/view/View;FFZ)Z", "I", "mTempFlingDispatchConsumed", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mOffsetAnimator", "r", "mTempFlingMaxOffset", "Z", "mWasFlung", "mSkipNestedPreScroll", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mLastNestedScrollingChildRef", "mTempFlingMinOffset", "mShouldDispatchFling", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
    public static final class Behavior extends HeaderBehavior<OUnitedTitleBar> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ValueAnimator f11538k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f11539l;
        private WeakReference<View> m;
        private boolean n;
        private boolean o;
        private int p;
        private int q;
        private int r;

        static final class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Behavior f11540a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f11541b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ OUnitedTitleBar f11542c;

            a(Behavior r1, CoordinatorLayout r2, OUnitedTitleBar r3) {
                this.f11540a = r1;
                this.f11541b = r2;
                this.f11542c = r3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r4) {
                o.f(r4, "animation");
                Behavior r0 = this.f11540a;
                CoordinatorLayout r1 = this.f11541b;
                OUnitedTitleBar r3 = this.f11542c;
                Object r5 = r4.getAnimatedValue();
                Objects.requireNonNull(r5, "null cannot be cast to non-null type kotlin.Int");
                r0.setHeaderTopBottomOffset(r1, r3, ((Integer) r5).intValue());
            }
        }

        public Behavior() {
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        private final void b(CoordinatorLayout r3, OUnitedTitleBar r4, int r5, float r6) {
            int r0 = Math.abs(getTopBottomOffsetForScrollingSibling() - r5);
            float r7 = Math.abs(r6);
            if (r7 <= 0) goto L5;
            int r8 = Math.round(1000 * (r0 / r7));
        L6:
            c(r3, r4, r5, r8);
            return;
        L5:
            o.c(r4);
            r8 = (int) (((r0 / r4.getHeight()) + 1) * 150);
            goto L6
        }

        private final void c(CoordinatorLayout r4, OUnitedTitleBar r5, int r6, int r7) {
            int r0 = getTopAndBottomOffset();
            if (r0 != r6) goto L7;
            ValueAnimator r1 = this.f11538k;
            if (r1 == null) goto L7;
            o.c(r1);
            r1.cancel();
        L7:
            ValueAnimator r2 = this.f11538k;
            if (r2 != null) goto L10;
            ValueAnimator r3 = new ValueAnimator();
            this.f11538k = r3;
            o.c(r3);
            r3.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator r8 = this.f11538k;
            o.c(r8);
            r8.addUpdateListener(new a(this, r4, r5));
        L11:
            ValueAnimator r9 = this.f11538k;
            o.c(r9);
            r9.setDuration(r7);
            ValueAnimator r10 = this.f11538k;
            o.c(r10);
            r10.setIntValues(new int[]{r0, r6});
            ValueAnimator r11 = this.f11538k;
            o.c(r11);
            r11.start();
            return;
        L10:
            o.c(r2);
            r2.cancel();
            goto L11
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r1) {
            return d((OUnitedTitleBar) r1);
        }

        public boolean d(OUnitedTitleBar r4) {
            WeakReference<View> r0 = this.m;
            if (r0 == null) goto L15;
            o.c(r0);
            View r1 = r0.get();
            if (r1 != null) goto L7;
        L13:
            return false;
        L7:
            if (r1.isShown() == false) goto L13;
            if (ViewCompat.canScrollVertically(r1, -1) == true) goto L13;
            int r3 = getTopAndBottomOffset();
            o.c(r4);
            if (r3 <= (-OUnitedTitleBar.b(r4))) goto L13;
            return true;
        L15:
            return true;
        }

        public final boolean e(CoordinatorLayout r5, OUnitedTitleBar r6) {
            int r0 = getTopAndBottomOffset();
            o.c(r6);
            int r1 = -OUnitedTitleBar.c(r6);
            if (r0 <= r1) goto L11;
            if (r0 >= 0) goto L11;
            if (r0 < ((r1 + 0) / 2)) goto L9;
            r1 = 0;
        L9:
            b(r5, r6, r1, 0.0f);
            return true;
        L11:
            return false;
        }

        public boolean f(CoordinatorLayout r7, OUnitedTitleBar r8, int r9, int r10, float r11) {
            o.f(r8, "layout");
            if (r11 >= 0) goto L6;
            this.o = true;
            this.p = 0;
            this.q = r9;
            this.r = r10;
            r9 = Integer.MIN_VALUE;
            r10 = Integer.MAX_VALUE;
        L6:
            return super.fling(r7, r8, r9, r10, r11);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean fling(CoordinatorLayout r1, View r2, int r3, int r4, float r5) {
            return f(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        public int g(OUnitedTitleBar r1) {
            o.f(r1, "view");
            return -OUnitedTitleBar.b(r1);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(View r1) {
            return g((OUnitedTitleBar) r1);
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r1) {
            return h((OUnitedTitleBar) r1);
        }

        public int h(OUnitedTitleBar r1) {
            o.f(r1, "view");
            return OUnitedTitleBar.b(r1);
        }

        public void i(CoordinatorLayout r2, OUnitedTitleBar r3) {
            this.o = false;
            e(r2, r3);
        }

        public boolean j(CoordinatorLayout r2, OUnitedTitleBar r3, int r4) {
            o.f(r2, "parent");
            o.f(r3, "child");
            boolean r5 = super.onLayoutChild(r2, r3, r4);
            if (OUnitedTitleBar.a(r3) != 0) goto L5;
        L11:
            r3.d(getTopAndBottomOffset());
            return r5;
        L5:
            if ((OUnitedTitleBar.a(r3) & 1) == 0) goto L9;
            int r0 = -OUnitedTitleBar.b(r3);
        L7:
            setHeaderTopBottomOffset(r2, r3, r0);
            goto L11
        L9:
            if ((OUnitedTitleBar.a(r3) & 16) == 0) goto L11;
            r0 = 0;
            goto L7
        }

        public boolean k(CoordinatorLayout r1, OUnitedTitleBar r2, View r3, float r4, float r5, boolean r6) {
            o.f(r1, "coordinatorLayout");
            o.f(r2, "child");
            o.f(r3, TypedValues.AttributesType.S_TARGET);
            this.n = true;
            return false;
        }

        public boolean l(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, float r10, float r11) {
            o.f(r7, "coordinatorLayout");
            o.f(r8, "child");
            o.f(r9, TypedValues.AttributesType.S_TARGET);
            if (r11 > 0) goto L5;
        L8:
            return false;
        L5:
            if (getTopAndBottomOffset() <= (-OUnitedTitleBar.b(r8))) goto L8;
            f(r7, r8, -OUnitedTitleBar.b(r8), 0, -r11);
            this.n = true;
            return true;
        }

        public void m(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, int r10, int r11, int[] r12) {
            o.f(r7, "coordinatorLayout");
            o.f(r8, "child");
            o.f(r9, TypedValues.AttributesType.S_TARGET);
            o.f(r12, "consumed");
            if (r11 > 0) goto L5;
            return;
        L5:
            if (this.f11539l == true) goto L9;
            r12[1] = scroll(r7, r8, r11, -OUnitedTitleBar.b(r8), 0);
            return;
        }

        public void n(CoordinatorLayout r7, OUnitedTitleBar r8, View r9, int r10, int r11, int r12, int r13) {
            o.f(r7, "coordinatorLayout");
            o.f(r8, "child");
            o.f(r9, TypedValues.AttributesType.S_TARGET);
            if (r13 >= 0) goto L5;
            scroll(r7, r8, r13, -OUnitedTitleBar.b(r8), 0);
            boolean r14 = true;
        L6:
            this.f11539l = r14;
            return;
        L5:
            r14 = false;
            goto L6
        }

        public boolean o(CoordinatorLayout r2, OUnitedTitleBar r3, View r4, View r5, int r6) {
            o.f(r2, "coordinatorLayout");
            o.f(r3, "child");
            o.f(r4, "directTargetChild");
            o.f(r5, TypedValues.AttributesType.S_TARGET);
            if ((r6 & 2) > 0) goto L5;
        L9:
            boolean r7 = false;
        L10:
            if (r7 == false) goto L14;
            ValueAnimator r8 = this.f11538k;
            if (r8 == null) goto L14;
            o.c(r8);
            r8.cancel();
        L14:
            this.m = null;
            this.n = false;
            this.o = false;
            a();
            return r7;
        L5:
            if (OUnitedTitleBar.b(r3) <= 0) goto L9;
            if ((r2.getHeight() - r4.getHeight()) > r3.getHeight()) goto L9;
            r7 = true;
            goto L10
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r1, View r2) {
            i(r1, (OUnitedTitleBar) r2);
        }

        @Override // com.obric.oui.titlebar.behavior.a, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            return j(r1, (OUnitedTitleBar) r2, r3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onNestedFling(CoordinatorLayout r1, View r2, View r3, float r4, float r5, boolean r6) {
            return k(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onNestedPreFling(CoordinatorLayout r1, View r2, View r3, float r4, float r5) {
            return l(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6) {
            m(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7) {
            n(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5) {
            return o(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, View r2, View r3) {
            p(r1, (OUnitedTitleBar) r2, r3);
        }

        public void p(CoordinatorLayout r2, OUnitedTitleBar r3, View r4) {
            o.f(r2, "coordinatorLayout");
            o.f(r3, "child");
            o.f(r4, TypedValues.AttributesType.S_TARGET);
            if (this.n == true) goto L5;
            e(r2, r3);
        L5:
            this.f11539l = false;
            this.m = new WeakReference(r4);
        }

        public int q(CoordinatorLayout r8, OUnitedTitleBar r9, int r10, int r11, int r12) {
            int r0 = getTopAndBottomOffset();
            if (this.o == false) goto L5;
            r11 = Math.max(this.q, r11);
            r12 = Math.min(this.r, r12);
        L5:
            int r13 = super.setHeaderTopBottomOffset(r8, r9, r10, r11, r12);
            if (r9 == null) goto L8;
            r9.d(getTopAndBottomOffset());
        L8:
            int r14 = 0;
            if (this.o == false) goto L19;
            if (r9 == null) goto L12;
            a r15 = r9.getMOnHeaderFlingUnConsumedListener();
        L13:
            if (r15 == null) goto L19;
            int r16 = ((r10 - r0) + r13) - this.p;
            if (r16 == 0) goto L17;
            o.c(r9);
            a r17 = r9.getMOnHeaderFlingUnConsumedListener();
            o.c(r17);
            r14 = r17.a(r9, r10, r16);
        L17:
            this.p += -r14;
            goto L19
        L12:
            r15 = null;
        L19:
            return r13 + r14;
        }

        @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r1, View r2, int r3, int r4, int r5) {
            return q(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }
    }

    public interface a {
        int a(OUnitedTitleBar r1, int r2, int r3);
    }

    public interface b {
        void a(OUnitedTitleBar r1, int r2);
    }

    static {
        Resources r1 = Resources.getSystem();
        o.e(r1, "Resources.getSystem()");
        A = kotlin.o0.a.a(TypedValue.applyDimension(1, 56, r1.getDisplayMetrics()));
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        B = kotlin.o0.a.a(TypedValue.applyDimension(1, 240, r2.getDisplayMetrics()));
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        kotlin.o0.a.a(TypedValue.applyDimension(1, 12, r3.getDisplayMetrics()));
        Resources r4 = Resources.getSystem();
        o.e(r4, "Resources.getSystem()");
        kotlin.o0.a.a(TypedValue.applyDimension(1, 92, r4.getDisplayMetrics()));
        Resources r5 = Resources.getSystem();
        o.e(r5, "Resources.getSystem()");
        kotlin.o0.a.a(TypedValue.applyDimension(1, 17, r5.getDisplayMetrics()));
        Resources r6 = Resources.getSystem();
        o.e(r6, "Resources.getSystem()");
        kotlin.o0.a.a(TypedValue.applyDimension(1, 14, r6.getDisplayMetrics()));
    }

    public static final /* synthetic */ int a(OUnitedTitleBar r0) {
        return r0.r;
    }

    public static final /* synthetic */ int b(OUnitedTitleBar r0) {
        return r0.getScrollRange();
    }

    public static final /* synthetic */ int c(OUnitedTitleBar r0) {
        return r0.getSnapRange();
    }

    private final View e(View r4) {
        if (this.x != null) goto L15;
        int r0 = this.w;
        if (r0 == (-1)) goto L15;
        if (r4 == null) goto L8;
        View r5 = r4.findViewById(r0);
    L9:
        if (r5 == null) goto L11;
    L13:
        if (r5 == null) goto L15;
        this.x = new WeakReference(r5);
        goto L15
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        ViewParent r6 = getParent();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.ViewGroup");
        r5 = ((ViewGroup) r6).findViewById(this.w);
        goto L13
    L8:
        r5 = null;
    L15:
        WeakReference<View> r3 = this.x;
        if (r3 != null) goto L18;
        return null;
    L18:
        return r3.get();
    }

    private final int getScrollRange() {
        return B - A;
    }

    private final int getSnapRange() {
        Resources r0 = Resources.getSystem();
        o.e(r0, "Resources.getSystem()");
        return kotlin.o0.a.a(TypedValue.applyDimension(1, 56, r0.getDisplayMetrics()));
    }

    public final void d(int r3) {
        List<b> r0 = this.s;
        if (r0 == null) goto L8;
        o.c(r0);
        Iterator<b> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().a(this, r3);
        goto L6
    L10:
        return;
    }

    public BaseBehavior.h f(AttributeSet r2) {
        return new BaseBehavior.h(getContext(), r2);
    }

    protected BaseBehavior.h g(ViewGroup.LayoutParams r1) {
        return new BaseBehavior.h(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return f(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return g(r1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return f(r1);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<?> getBehavior() {
        return new BaseBehavior.Behavior();
    }

    public final View getBottomAction() {
        return this.f11536k;
    }

    public final View getDivider() {
        return this.o;
    }

    public final int getDownNestedPreScrollRange() {
        return 0;
    }

    public final int getDownNestedScrollRange() {
        return getTotalScrollRange();
    }

    public final int getINVALID_SCROLL_RANGE() {
        return this.v;
    }

    public final boolean getInDebug() {
        return this.t;
    }

    public final ViewGroup getLeftAction() {
        return this.f11532g;
    }

    public final Drawable getLeftActionSrc() {
        return this.m;
    }

    public final int getMCollapsePosition() {
        return this.q;
    }

    public final a getMOnHeaderFlingUnConsumedListener() {
        return this.p;
    }

    public final TextView getMTvSubTitle() {
        return this.f11535j;
    }

    public final TextView getMTvTitle() {
        return this.f11534i;
    }

    public final int getPendingAction() {
        return this.r;
    }

    public final ViewGroup getRightAction() {
        return this.f11533h;
    }

    public final Drawable getRightActionSrc() {
        return this.n;
    }

    public final int getTextInitPos() {
        return this.u;
    }

    public final String getTitleText() {
        return this.f11537l;
    }

    public final int getTopInset() {
        WindowInsetsCompat r0 = this.y;
        if (r0 == null) goto L5;
        o.c(r0);
        return r0.getSystemWindowInsetTop();
    L5:
        return 0;
    }

    public final int getTotalScrollRange() {
        return B - A;
    }

    public final int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final boolean h() {
        return this.z;
    }

    public final boolean i() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean j() {
        return this.f11531f;
    }

    public final void k() {
        this.r = 0;
    }

    public final boolean l(boolean r1) {
        return false;
    }

    public final boolean m(View r1) {
        View r0 = e(r1);
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r1.getScrollY() <= 0) goto L12;
        goto L11
    }

    public final void setBottomAction(View r1) {
        this.f11536k = r1;
    }

    public final void setDivider(View r1) {
        this.o = r1;
    }

    public final void setExpanded(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 16;
    L5:
        this.r = r2;
        requestLayout();
        return;
    L4:
        r2 = 1;
        goto L5
    }

    public final void setInDebug(boolean r1) {
        this.t = r1;
    }

    public final void setLeftAction(View r2) {
        o.f(r2, "view");
        ViewGroup r0 = this.f11532g;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.f11532g;
        if (r1 == null) goto L9;
        r1.addView(r2);
        return;
    }

    public final void setLeftAction(ViewGroup r1) {
        this.f11532g = r1;
    }

    public final void setLeftActionSrc(Drawable r1) {
        this.m = r1;
    }

    public final void setMCollapsePosition(int r1) {
        this.q = r1;
    }

    public final void setMOnHeaderFlingUnConsumedListener(a r1) {
        this.p = r1;
    }

    public final void setMTvSubTitle(TextView r1) {
        this.f11535j = r1;
    }

    public final void setMTvTitle(TextView r1) {
        this.f11534i = r1;
    }

    public final void setOnHeaderFlingUnConsumedListener(a r2) {
        o.f(r2, "onHeaderFlingUnConsumedListener");
        this.p = r2;
    }

    public final void setRightAction(View r2) {
        o.f(r2, "view");
        ViewGroup r0 = this.f11533h;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.f11533h;
        if (r1 == null) goto L9;
        r1.addView(r2);
        return;
    }

    public final void setRightAction(ViewGroup r1) {
        this.f11533h = r1;
    }

    public final void setRightActionSrc(Drawable r1) {
        this.n = r1;
    }

    public final void setTextInitPos(int r1) {
        this.u = r1;
    }

    public final void setTitleText(String r1) {
        this.f11537l = r1;
    }
}
