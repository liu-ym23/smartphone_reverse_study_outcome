package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001<B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\"\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0014J \u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0017\u0010(\u001a\u0002H)\"\n\b\u0000\u0010)*\u0004\u0018\u00010*¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017J\b\u0010-\u001a\u00020\u0016H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0018\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016J\u0018\u00104\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0001J\u0012\u00106\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "applyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", "disappearingFragmentChildren", "", "Landroid/view/View;", "drawDisappearingViewsFirst", "", "transitioningFragmentViews", "addDisappearingFragmentView", "", BaseSwitches.V, "addView", "child", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "dispatchApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawChild", "drawingTime", "", "endViewTransition", "view", "getFragment", "F", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "onApplyWindowInsets", "removeAllViewsInLayout", "removeView", "removeViewAt", "removeViewInLayout", "removeViews", "start", "count", "removeViewsInLayout", "setDrawDisappearingViewsLast", "setLayoutTransition", "transition", "Landroid/animation/LayoutTransition;", "setOnApplyWindowInsetsListener", "listener", "startViewTransition", "Api20Impl", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FragmentContainerView extends FrameLayout {
    private View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    private final List<View> disappearingFragmentChildren;
    private boolean drawDisappearingViewsFirst;
    private final List<View> transitioningFragmentViews;

    @RequiresApi(20)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Landroidx/fragment/app/FragmentContainerView$Api20Impl;", "", "()V", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "onApplyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", BaseSwitches.V, "Landroid/view/View;", "insets", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Api20Impl {
        public static final Api20Impl INSTANCE = null;

        static {
            INSTANCE = new Api20Impl();
        }

        private Api20Impl() {
        }

        public final WindowInsets onApplyWindowInsets(View.OnApplyWindowInsetsListener r1, View r2, WindowInsets r3) {
            o.f(r1, "onApplyWindowInsetsListener");
            o.f(r2, BaseSwitches.V);
            o.f(r3, "insets");
            WindowInsets r0 = r1.onApplyWindowInsets(r2, r3);
            o.e(r0, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return r0;
        }
    }

    public FragmentContainerView(Context r2) {
        o.f(r2, "context");
        super(r2);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
    }

    public FragmentContainerView(Context r8, AttributeSet r9) {
        o.f(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public FragmentContainerView(Context r3, AttributeSet r4, int r5) {
        o.f(r3, "context");
        super(r3, r4, r5);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        if (r4 == null) goto L15;
        String r6 = r4.getClassAttribute();
        int[] r0 = R.styleable.FragmentContainerView;
        o.e(r0, "FragmentContainerView");
        TypedArray r7 = r3.obtainStyledAttributes(r4, r0, 0, 0);
        if (r6 != null) goto L7;
        r6 = r7.getString(R.styleable.FragmentContainerView_android_name);
        String r8 = "android:name";
    L8:
        r7.recycle();
        if (r6 != null) goto L11;
        return;
    L11:
        if (isInEditMode() == false) goto L14;
        return;
    L14:
        throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + r8 + "=\"" + r6 + '\"');
    L7:
        r8 = "class";
        goto L8
    }

    public /* synthetic */ FragmentContainerView(Context r1, AttributeSet r2, int r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 0;
    L5:
        this(r1, r2, r3);
    }

    public FragmentContainerView(Context r6, AttributeSet r7, FragmentManager r8) {
        o.f(r6, "context");
        o.f(r7, "attrs");
        o.f(r8, "fm");
        super(r6, r7);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String r1 = r7.getClassAttribute();
        int[] r2 = R.styleable.FragmentContainerView;
        o.e(r2, "FragmentContainerView");
        TypedArray r3 = r6.obtainStyledAttributes(r7, r2, 0, 0);
        if (r1 != null) goto L5;
        r1 = r3.getString(R.styleable.FragmentContainerView_android_name);
    L5:
        String r4 = r3.getString(R.styleable.FragmentContainerView_android_tag);
        r3.recycle();
        int r5 = getId();
        Fragment r9 = r8.findFragmentById(r5);
        if (r1 == null) goto L16;
        if (r9 != null) goto L16;
        if (r5 != (-1)) goto L15;
        if (r4 == null) goto L12;
        String r10 = " with tag " + r4;
    L14:
        throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + r1 + r10);
    L12:
        r10 = "";
        goto L14
    L15:
        Fragment r11 = r8.getFragmentFactory().instantiate(r6.getClassLoader(), r1);
        o.e(r11, "fm.fragmentFactory.insta…ontext.classLoader, name)");
        r11.onInflate(r6, r7, null);
        r8.beginTransaction().setReorderingAllowed(true).add(this, r11, r4).commitNowAllowingStateLoss();
    L16:
        r8.onContainerAvailable(this);
    }

    private final void addDisappearingFragmentView(View r2) {
        if (this.transitioningFragmentViews.contains(r2) == false) goto L6;
        this.disappearingFragmentChildren.add(r2);
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        o.f(r2, "child");
        if (FragmentManager.getViewFragment(r2) == null) goto L7;
        super.addView(r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + r2 + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(20)
    public WindowInsets dispatchApplyWindowInsets(WindowInsets r5) {
        o.f(r5, "insets");
        WindowInsetsCompat r0 = WindowInsetsCompat.toWindowInsetsCompat(r5);
        o.e(r0, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener r1 = this.applyWindowInsetsListener;
        if (r1 == null) goto L5;
        Api20Impl r2 = Api20Impl.INSTANCE;
        o.c(r1);
        WindowInsetsCompat r3 = WindowInsetsCompat.toWindowInsetsCompat(r2.onApplyWindowInsets(r1, this, r5));
    L6:
        o.e(r3, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (r3.isConsumed() == true) goto L11;
        int r4 = 0;
        int r6 = getChildCount();
    L9:
        if (r4 >= r6) goto L11;
        ViewCompat.dispatchApplyWindowInsets(getChildAt(r4), r3);
        r4 = r4 + 1;
    L11:
        return r5;
    L5:
        r3 = ViewCompat.onApplyWindowInsets(this, r0);
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r5) {
        o.f(r5, "canvas");
        if (this.drawDisappearingViewsFirst == false) goto L8;
        Iterator<T> r0 = this.disappearingFragmentChildren.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        super.drawChild(r5, (View) r0.next(), getDrawingTime());
    L8:
        super.dispatchDraw(r5);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas r2, View r3, long r4) {
        o.f(r2, "canvas");
        o.f(r3, "child");
        if (this.drawDisappearingViewsFirst == false) goto L11;
        if ((!this.disappearingFragmentChildren.isEmpty()) == false) goto L11;
        if (this.disappearingFragmentChildren.contains(r3) == false) goto L11;
        return false;
    L11:
        return super.drawChild(r2, r3, r4);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View r2) {
        o.f(r2, "view");
        this.transitioningFragmentViews.remove(r2);
        if (this.disappearingFragmentChildren.remove(r2) == false) goto L5;
        this.drawDisappearingViewsFirst = true;
    L5:
        super.endViewTransition(r2);
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.findFragmentManager(this).findFragmentById(getId());
    }

    @Override // android.view.View
    @RequiresApi(20)
    public WindowInsets onApplyWindowInsets(WindowInsets r1) {
        o.f(r1, "insets");
        return r1;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int r0 = getChildCount();
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L6;
        View r1 = getChildAt(r0);
        o.e(r1, "view");
        addDisappearingFragmentView(r1);
        goto L3
    L6:
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r2) {
        o.f(r2, "view");
        addDisappearingFragmentView(r2);
        super.removeView(r2);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r3) {
        View r0 = getChildAt(r3);
        o.e(r0, "view");
        addDisappearingFragmentView(r0);
        super.removeViewAt(r3);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View r2) {
        o.f(r2, "view");
        addDisappearingFragmentView(r2);
        super.removeViewInLayout(r2);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int r5, int r6) {
        int r0 = r5 + r6;
        int r1 = r5;
    L3:
        if (r1 >= r0) goto L5;
        View r2 = getChildAt(r1);
        o.e(r2, "view");
        addDisappearingFragmentView(r2);
        r1 = r1 + 1;
        goto L3
    L5:
        super.removeViews(r5, r6);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int r5, int r6) {
        int r0 = r5 + r6;
        int r1 = r5;
    L3:
        if (r1 >= r0) goto L5;
        View r2 = getChildAt(r1);
        o.e(r2, "view");
        addDisappearingFragmentView(r2);
        r1 = r1 + 1;
        goto L3
    L5:
        super.removeViewsInLayout(r5, r6);
    }

    public final void setDrawDisappearingViewsLast(boolean r1) {
        this.drawDisappearingViewsFirst = r1;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition r3) {
        if (Build.VERSION.SDK_INT >= 18) goto L7;
        super.setLayoutTransition(r3);
        return;
    L7:
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener r2) {
        o.f(r2, "listener");
        this.applyWindowInsetsListener = r2;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View r2) {
        o.f(r2, "view");
        if (r2.getParent() != this) goto L5;
        this.transitioningFragmentViews.add(r2);
    L5:
        super.startViewTransition(r2);
    }
}
