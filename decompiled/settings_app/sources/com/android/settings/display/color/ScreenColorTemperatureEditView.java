package com.android.settings.display.color;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.android.settings.R;
import com.android.settings.databinding.LayoutScreenTemperatureEditBinding;
import com.android.settings.utils.ResourceUtils;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ScreenColorTemperatureEditView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH\u0002J<\u0010#\u001a\u00020\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0%2\u0006\u0010&\u001a\u00020'2\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00160\u000fJ(\u0010(\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020\fH\u0002J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000RU\u0010\u000e\u001aI\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/android/settings/display/color/ScreenColorTemperatureEditView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "circleViewRadius", "", "pointViewRadius", "updateTemperature", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "radius", "radian", "", "saveToProvider", "", "viewBinding", "Lcom/android/settings/databinding/LayoutScreenTemperatureEditBinding;", "circleX", "circleY", "constraintPoint", "Landroid/graphics/PointF;", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "getCartesianCoordinate", "getPolarCoordinate", "point", "initView", "currPointPointPositionLv", "Landroidx/lifecycle/LiveData;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isTouchInCircle", "pointX", "pointY", "updatePointPosition", "translateX", "translateY", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScreenColorTemperatureEditView extends FrameLayout {
    private final String TAG;
    private final float circleViewRadius;
    private final float pointViewRadius;
    private Function3<? super Float, ? super Float, ? super Boolean, Unit> updateTemperature;
    private final LayoutScreenTemperatureEditBinding viewBinding;

    /* JADX INFO: renamed from: com.android.settings.display.color.ScreenColorTemperatureEditView$initView$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScreenColorTemperatureEditView.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/PointF;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<PointF, Unit> {
        final /* synthetic */ ScreenColorTemperatureEditView this$0;

        /* JADX INFO: renamed from: $r8$lambda$RLPT9USeT6RHI8lgOVNTCzeT-5s, reason: not valid java name */
        public static /* synthetic */ void m451$r8$lambda$RLPT9USeT6RHI8lgOVNTCzeT5s(ScreenColorTemperatureEditView r0, PointF r1) {
            invoke$lambda$0(r0, r1);
        }

        AnonymousClass1(ScreenColorTemperatureEditView r1) {
            this.this$0 = r1;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PointF r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final PointF r2) {
            final ScreenColorTemperatureEditView r1 = this.this$0;
            r1.post(new ScreenColorTemperatureEditView$initView$1$$ExternalSyntheticLambda0(r1, r2));
        }

        private static final void invoke$lambda$0(ScreenColorTemperatureEditView r2, PointF r3) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            PointF r4 = ScreenColorTemperatureEditView.access$getCartesianCoordinate(r2, r3.x, r3.y);
            ScreenColorTemperatureEditView.access$updatePointPosition(r2, r4.x - ScreenColorTemperatureEditView.access$circleX(r2), r4.y - ScreenColorTemperatureEditView.access$circleY(r2));
        }
    }

    public ScreenColorTemperatureEditView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public ScreenColorTemperatureEditView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ ScreenColorTemperatureEditView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ float access$circleX(ScreenColorTemperatureEditView r0) {
        return r0.circleX();
    }

    public static final /* synthetic */ float access$circleY(ScreenColorTemperatureEditView r0) {
        return r0.circleY();
    }

    public static final /* synthetic */ PointF access$getCartesianCoordinate(ScreenColorTemperatureEditView r0, float r1, float r2) {
        return r0.getCartesianCoordinate(r1, r2);
    }

    public static final /* synthetic */ void access$updatePointPosition(ScreenColorTemperatureEditView r0, float r1, float r2) {
        r0.updatePointPosition(r1, r2);
    }

    public ScreenColorTemperatureEditView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.TAG = "ScreenColorTemperatureE";
        float r5 = 2;
        this.circleViewRadius = ResourceUtils.getResources().getDimension(R.dimen.screen_temperature_edit_view_circle_diameter) / r5;
        this.pointViewRadius = ResourceUtils.getResources().getDimension(R.dimen.screen_temperature_edit_view_point_diameter) / r5;
        LayoutScreenTemperatureEditBinding r6 = LayoutScreenTemperatureEditBinding.bind(LayoutInflater.from(r2).inflate(R.layout.layout_screen_temperature_edit, this, true));
        Intrinsics.checkNotNullExpressionValue(r6, "bind(...)");
        this.viewBinding = r6;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setPadding(0, MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), 0, 0);
        setClipToPadding(false);
    }

    public final void initView(LiveData<PointF> r2, LifecycleOwner r3, Function3<? super Float, ? super Float, ? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "currPointPointPositionLv");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "updateTemperature");
        this.updateTemperature = r4;
        r2.observe(r3, new ScreenColorTemperatureEditView$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(this)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        boolean r1 = false;
        if (isEnabled() == true) goto L5;
        return false;
    L5:
        float r0 = circleX();
        float r2 = circleY();
        if (r7.getAction() != 0) goto L12;
        if (isTouchInCircle(r7, pointX(), pointY(), this.pointViewRadius) == true) goto L12;
        return super.dispatchTouchEvent(r7);
    L12:
        if (isTouchInCircle(r7, r0, r2, this.circleViewRadius) == false) goto L14;
        PointF r3 = new PointF(r7.getX(), r7.getY());
    L15:
        getParent().requestDisallowInterceptTouchEvent(true);
        updatePointPosition(r3.x - r0, r3.y - r2);
        PointF r4 = getPolarCoordinate(r3);
        OLog.d(this.TAG, "dispatchTouchEvent: r = " + r4.x + ", θ = " + r4.y);
        Function3<? super Float, ? super Float, ? super Boolean, Unit> r6 = this.updateTemperature;
        if (r6 == null) goto L23;
        Float r5 = Float.valueOf(r4.x);
        Float r8 = Float.valueOf(r4.y);
        if (r7.getAction() != 1) goto L20;
    L21:
        r1 = true;
    L22:
        r6.invoke(r5, r8, Boolean.valueOf(r1));
        goto L23
    L20:
        if (r7.getAction() != 3) goto L22;
    L23:
        return true;
    L14:
        r3 = constraintPoint(r7, r0, r2);
        goto L15
    }

    private final void updatePointPosition(float r2, float r3) {
        this.viewBinding.pointView.setTranslationX(r2);
        this.viewBinding.pointView.setTranslationY(r3);
    }

    private final PointF getPolarCoordinate(PointF r7) {
        float r0 = circleX();
        float r1 = circleY();
        float r2 = (r7.x - r0) / this.circleViewRadius;
        float r8 = (-(r7.y - r1)) / this.circleViewRadius;
        double r3 = r2;
        double r4 = 2.0f;
        double r5 = r8;
        float r6 = (float) Math.sqrt(((float) Math.pow(r3, r4)) + ((float) Math.pow(r5, r4)));
        double r9 = Math.atan2(r5, r3);
        if (r9 >= 0.0d) goto L6;
        r9 = r9 + 6.283185307179586d;
    L6:
        return new PointF(r6, (float) r9);
    }

    private final PointF getCartesianCoordinate(float r5, float r6) {
        double r0 = r6;
        float r7 = (((float) Math.cos(r0)) * r5) * this.circleViewRadius;
        float r8 = (r5 * ((float) Math.sin(r0))) * this.circleViewRadius;
        return new PointF(r7 + circleX(), -(r8 - circleY()));
    }

    private final PointF constraintPoint(MotionEvent r9, float r10, float r11) {
        float r0 = Math.abs(r9.getY() - r11);
        float r1 = Math.abs(r9.getX() - r10);
        double r4 = 2.0f;
        float r2 = (float) Math.sqrt(((float) Math.pow(r0, r4)) + ((float) Math.pow(r1, r4)));
        float r8 = this.circleViewRadius;
        float r3 = (r0 * r8) / r2;
        float r12 = (r8 * r1) / r2;
        if (r9.getX() <= r10) goto L9;
        if (r9.getY() > r11) goto L9;
        return new PointF(r10 + r12, r11 - r3);
    L9:
        if (r9.getX() > r10) goto L15;
        if (r9.getY() >= r11) goto L15;
        return new PointF(r10 - r12, r11 - r3);
    L15:
        if (r9.getX() >= r10) goto L21;
        if (r9.getY() < r11) goto L21;
        return new PointF(r10 - r12, r11 + r3);
    L21:
        return new PointF(r10 + r12, r11 + r3);
    }

    private final boolean isTouchInCircle(MotionEvent r5, float r6, float r7, float r8) {
        if ((Math.pow(r5.getX() - r6, 2.0d) + Math.pow(r5.getY() - r7, 2.0d)) > Math.pow(r8, 2.0d)) goto L5;
        return true;
    L5:
        return false;
    }

    private final float circleX() {
        return this.viewBinding.circleView.getX() + this.circleViewRadius;
    }

    private final float circleY() {
        return this.viewBinding.circleView.getY() + this.circleViewRadius;
    }

    private final float pointX() {
        return this.viewBinding.pointView.getX() + this.pointViewRadius;
    }

    private final float pointY() {
        return this.viewBinding.pointView.getY() + this.pointViewRadius;
    }
}
