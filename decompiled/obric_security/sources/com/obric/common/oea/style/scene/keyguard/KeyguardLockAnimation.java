package com.obric.common.oea.style.scene.keyguard;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.obric.common.oea.foundation.animation.easy.ViewPropertySpringAnimator;
import com.obric.common.oea.foundation.animation.easy.ViewPropertySpringAnimatorExtKt;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: KeyguardLockAnimation.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/keyguard/KeyguardLockAnimation;", "", "()V", "Companion", "KeyguardPosition", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class KeyguardLockAnimation {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: KeyguardLockAnimation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\tJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\tJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\t¨\u0006\u0011"}, d2 = {"Lcom/obric/common/oea/style/scene/keyguard/KeyguardLockAnimation$Companion;", "", "()V", "calculateExitScreenY", "", MaterialConfigFormatNames.Y, "calculateInitY", "calculateStiffness", "getKeyguardPosition", "Lcom/obric/common/oea/style/scene/keyguard/KeyguardLockAnimation$KeyguardPosition;", "view", "Landroid/view/View;", "passExit", "Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", "keyguardPosition", "passIn", "passOut", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final KeyguardPosition getKeyguardPosition(View r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            return new KeyguardPosition(calculateInitY(r5.getY()), r5.getY(), calculateExitScreenY(r5.getY()), r5);
        }

        private final float calculateStiffness(float r3) {
            return TokenUtil.INSTANCE.durationToStiffness((float) ((((double) ((r3 - 300) / 2400)) * 0.4d) + 0.3d));
        }

        public final ViewPropertySpringAnimator<View> passIn(KeyguardPosition r3) {
            Intrinsics.checkNotNullParameter(r3, "keyguardPosition");
            if (r3.getView().getY() != r3.getOnScreenPosition()) goto L5;
        L6:
            r3.getView().setY(r3.getInitPosition());
        L7:
            ViewPropertySpringAnimator r0 = ViewPropertySpringAnimatorExtKt.spring(r3.getView());
            if (r0.isRunning() == false) goto L10;
            r0.cancel();
        L10:
            r0.getAnimatorMap().clear();
            return ViewPropertySpringAnimator.alpha$default(ViewPropertySpringAnimator.y$default(r0.defaultDampingRatio(0.9f).defaultStiffness(calculateStiffness(r3.getOnScreenPosition())), r3.getOnScreenPosition(), null, 2, null), 1.0f, null, 2, null);
        L5:
            if (r3.getView().getY() != r3.getExitScreenPostPosition()) goto L7;
            goto L6
        }

        public final ViewPropertySpringAnimator<View> passOut(KeyguardPosition r3) {
            Intrinsics.checkNotNullParameter(r3, "keyguardPosition");
            ViewPropertySpringAnimator r2 = ViewPropertySpringAnimatorExtKt.spring(r3.getView());
            if (r2.isRunning() == false) goto L5;
            r2.cancel();
        L5:
            r2.getAnimatorMap().clear();
            return ViewPropertySpringAnimator.alpha$default(ViewPropertySpringAnimator.y$default(r2.defaultDampingRatio(0.9f).defaultStiffness(TokenUtil.INSTANCE.durationToStiffness(0.2f)), r3.getInitPosition(), null, 2, null), 0.0f, null, 2, null);
        }

        public final ViewPropertySpringAnimator<View> passExit(KeyguardPosition r3) {
            Intrinsics.checkNotNullParameter(r3, "keyguardPosition");
            ViewPropertySpringAnimator r2 = ViewPropertySpringAnimatorExtKt.spring(r3.getView());
            if (r2.isRunning() == false) goto L5;
            r2.cancel();
        L5:
            r2.getAnimatorMap().clear();
            return ViewPropertySpringAnimator.y$default(r2.defaultDampingRatio(0.9f).defaultStiffness(TokenUtil.INSTANCE.durationToStiffness(0.2f)), r3.getExitScreenPostPosition(), null, 2, null).alpha(0.0f, KeyguardLockAnimation$Companion$passExit$1.INSTANCE);
        }

        private final float calculateInitY(float r5) {
            Resources r0 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
            return (float) (((double) TypedValue.applyDimension(1, 100, r0.getDisplayMetrics())) + (((double) r5) * 1.2d));
        }

        private final float calculateExitScreenY(float r3) {
            Resources r0 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
            return r3 - MathKt.roundToInt(TypedValue.applyDimension(1, 200, r0.getDisplayMetrics()));
        }
    }

    /* JADX INFO: compiled from: KeyguardLockAnimation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/obric/common/oea/style/scene/keyguard/KeyguardLockAnimation$KeyguardPosition;", "", "initPosition", "", "onScreenPosition", "exitScreenPostPosition", "view", "Landroid/view/View;", "(FFFLandroid/view/View;)V", "getExitScreenPostPosition", "()F", "setExitScreenPostPosition", "(F)V", "getInitPosition", "setInitPosition", "getOnScreenPosition", "setOnScreenPosition", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class KeyguardPosition {
        private float exitScreenPostPosition;
        private float initPosition;
        private float onScreenPosition;
        private View view;

        public static /* synthetic */ KeyguardPosition copy$default(KeyguardPosition r0, float r1, float r2, float r3, View r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.initPosition;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.onScreenPosition;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.exitScreenPostPosition;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.view;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final float component1() {
            return this.initPosition;
        }

        public final float component2() {
            return this.onScreenPosition;
        }

        public final float component3() {
            return this.exitScreenPostPosition;
        }

        public final View component4() {
            return this.view;
        }

        public final KeyguardPosition copy(float r1, float r2, float r3, View r4) {
            Intrinsics.checkNotNullParameter(r4, "view");
            return new KeyguardPosition(r1, r2, r3, r4);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof KeyguardPosition) == false) goto L14;
            KeyguardPosition r4 = (KeyguardPosition) r3;
            if (Float.compare(this.initPosition, r4.initPosition) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.onScreenPosition, r4.onScreenPosition) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.exitScreenPostPosition, r4.exitScreenPostPosition) == 0) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.view, r4.view) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            int r0 = ((((Float.hashCode(this.initPosition) * 31) + Float.hashCode(this.onScreenPosition)) * 31) + Float.hashCode(this.exitScreenPostPosition)) * 31;
            View r2 = this.view;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r0 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public String toString() {
            return "KeyguardPosition(initPosition=" + this.initPosition + ", onScreenPosition=" + this.onScreenPosition + ", exitScreenPostPosition=" + this.exitScreenPostPosition + ", view=" + this.view + ")";
        }

        public KeyguardPosition(float r2, float r3, float r4, View r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            this.initPosition = r2;
            this.onScreenPosition = r3;
            this.exitScreenPostPosition = r4;
            this.view = r5;
        }

        public final float getInitPosition() {
            return this.initPosition;
        }

        public final void setInitPosition(float r1) {
            this.initPosition = r1;
        }

        public final float getOnScreenPosition() {
            return this.onScreenPosition;
        }

        public final void setOnScreenPosition(float r1) {
            this.onScreenPosition = r1;
        }

        public /* synthetic */ KeyguardPosition(float r2, float r3, float r4, View r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0.0f;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0.0f;
        L9:
            if ((r6 & 4) == 0) goto L11;
            r4 = 0.0f;
        L11:
            this(r2, r3, r4, r5);
        }

        public final float getExitScreenPostPosition() {
            return this.exitScreenPostPosition;
        }

        public final void setExitScreenPostPosition(float r1) {
            this.exitScreenPostPosition = r1;
        }

        public final View getView() {
            return this.view;
        }

        public final void setView(View r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.view = r2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KeyguardLockAnimation() {
    }
}
