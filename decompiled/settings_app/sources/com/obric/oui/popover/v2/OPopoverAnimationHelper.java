package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.obric.common.oui.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.easy.ViewPropertySpringAnimatorExtKt;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.engine.FloatPropertyCompat;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.AnimUtils;
import com.obric.oui.utils.KtExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: OPopoverAnimationHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007Jj\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010!H\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverAnimationHelper;", "", "()V", "animFloatP", "Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "Landroid/view/View;", "getAnimFloatP", "()Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "springAnimatorTagKey", "", "getSpringAnimatorTagKey", "()I", "startStackTransitionAnimation", "", "popover", "Lcom/obric/oui/popover/v2/OPopoverBase;", "toTop", "", "targetContentAlpha", "", "targetScale", "startVisibilityAnimation", "Landroid/animation/AnimatorSet;", "view", "Landroid/view/ViewGroup;", "isWindowMode", "gravity", "pivotX", "pivotY", "isIn", "customAnimator", "Landroid/animation/Animator;", "onAnimationStart", "Lkotlin/Function0;", "onAnimationEnd", "CommonFloatProperty", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverAnimationHelper {
    public static final OPopoverAnimationHelper INSTANCE = null;
    private static final FloatPropertyCompat<View> animFloatP = null;
    private static final int springAnimatorTagKey = 0;

    /* JADX INFO: compiled from: OPopoverAnimationHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverAnimationHelper$CommonFloatProperty;", "", "value", "", "(F)V", "getValue", "()F", "setValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CommonFloatProperty {
        private float value;

        public CommonFloatProperty(float r1) {
            this.value = r1;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float r1) {
            this.value = r1;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$978ID-H9KuGcZIS55F9ldisQfRc, reason: not valid java name */
    public static /* synthetic */ void m1304$r8$lambda$978IDH9KuGcZIS55F9ldisQfRc(ViewGroup r0, float r1, float r2, float r3, float r4, View r5, float r6, float r7, DynamicAnimation r8, float r9, float r10) {
        m1305startStackTransitionAnimation$lambda4$lambda3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void $r8$lambda$JYRMEu7k78xzDoBIGAuThmD1GB4(ViewGroup r0, float r1, float r2, float r3, float r4, float r5, float r6, DynamicAnimation r7, float r8, float r9) {
        m1306startVisibilityAnimation$lambda2$lambda1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    private OPopoverAnimationHelper() {
    }

    static {
        INSTANCE = new OPopoverAnimationHelper();
        springAnimatorTagKey = R.id.o_popover_anim_p;
        animFloatP = new OPopoverAnimationHelper$animFloatP$1();
    }

    public final int getSpringAnimatorTagKey() {
        return springAnimatorTagKey;
    }

    public final FloatPropertyCompat<View> getAnimFloatP() {
        return animFloatP;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnimatorSet startVisibilityAnimation$default(OPopoverAnimationHelper r12, ViewGroup r13, boolean r14, int r15, float r16, float r17, boolean r18, Animator r19, Function0 r20, Function0 r21, int r22, Object r23) {
        if ((r22 & 2) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r22 & 64) == 0) goto L9;
        Animator r9 = null;
    L11:
        if ((r22 & 128) == 0) goto L13;
        Function0 r10 = null;
    L15:
        if ((r22 & 256) == 0) goto L17;
        Function0 r11 = null;
    L19:
        return r12.startVisibilityAnimation(r13, r4, r15, r16, r17, r18, r9, r10, r11);
    L17:
        r11 = r21;
        goto L19
    L13:
        r10 = r20;
        goto L15
    L9:
        r9 = r19;
        goto L11
    L5:
        r4 = r14;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [T, com.obric.oui.animation.easy.ViewPropertySpringAnimator] */
    public final AnimatorSet startVisibilityAnimation(final ViewGroup r19, boolean r20, int r21, float r22, float r23, final boolean r24, Animator r25, final Function0<Unit> r26, final Function0<Unit> r27) {
        Intrinsics.checkNotNullParameter(r19, "view");
        r19.setPivotX(r22);
        r19.setPivotY(r23);
        r19.setVisibility(0);
        AnimatorSet r9 = new AnimatorSet();
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        if (r25 == null) goto L5;
        r9.play(r25);
    L53:
        r9.addListener(new AnonymousClass2(r24, r19, r10, r26, r27));
        r9.start();
        return r9;
    L5:
        final float r5 = 1.0f;
        PathInterpolator r0 = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
        if (r24 == false) goto L8;
        float r3 = 0.0f;
    L9:
        if (r24 == false) goto L11;
        float r4 = 1.0f;
    L12:
        int r7 = 1;
        if (r19.getAlpha() != 0.0f) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L18;
    L23:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r19, "alpha", new float[]{r3, r4});
        r1.setInterpolator(r0);
        r1.setDuration(100);
        r9.play(r1);
        if (r24 == false) goto L26;
        final float r8 = 0.2f;
    L27:
        if (r24 == true) goto L31;
        r5 = 0.2f;
    L31:
        if (r21 != 48) goto L35;
        r7 = -1;
    L35:
        if (r24 == false) goto L37;
        float r2 = -OUnitExtensionKt.vdpFloat(r19, 10);
    L38:
        float r11 = r7;
        final float r12 = r2 * r11;
        if (r24 == false) goto L41;
        float r13 = 0.0f;
    L42:
        final float r14 = r13 * r11;
        if (r24 == false) goto L45;
        float r15 = 0.0f;
    L46:
        if (r24 == false) goto L48;
        float r17 = 10000.0f;
    L49:
        ViewGroup r16 = r19;
        if (ViewPropertySpringAnimatorExtKt.spring(r16).isRunning() == true) goto L52;
        r19.setScaleX(r8);
        r19.setScaleY(r8);
        r19.setTranslationY(r12);
        r19.setTag(springAnimatorTagKey, new CommonFloatProperty(r15));
    L52:
        ?? r18 = ViewPropertySpringAnimator.animateProperty$default(ViewPropertySpringAnimatorExtKt.spring(r16).defaultDampingRatio(0.85f).defaultStiffness(632.0f), animFloatP, r17, null, 4, null);
        final float r28 = r15;
        final float r29 = r17;
        r18.setUpdateListener(new OPopoverAnimationHelper$$ExternalSyntheticLambda1(r19, r28, r29, r8, r5, r12, r14));
        r10.element = r18;
        goto L53
    L48:
        r17 = 0.0f;
        goto L49
    L45:
        r15 = 10000.0f;
        goto L46
    L41:
        r13 = -OUnitExtensionKt.vdpFloat(r19, 10);
        goto L42
    L37:
        r2 = 0.0f;
        goto L38
    L26:
        r8 = 1.0f;
        goto L27
    L18:
        if (r19.getAlpha() != 1.0f) goto L20;
        boolean r30 = true;
    L21:
        if (r30 == true) goto L23;
        r3 = r19.getAlpha();
        goto L23
    L20:
        r30 = false;
        goto L21
    L15:
        r6 = false;
        goto L16
    L11:
        r4 = 0.0f;
        goto L12
    L8:
        r3 = 1.0f;
        goto L9
    }

    /* JADX INFO: renamed from: startVisibilityAnimation$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1306startVisibilityAnimation$lambda2$lambda1(ViewGroup r1, float r2, float r3, float r4, float r5, float r6, float r7, DynamicAnimation r8, float r9, float r10) {
        Intrinsics.checkNotNullParameter(r1, "$view");
        KtExt r11 = KtExt.INSTANCE;
        Object r12 = r1.getTag(springAnimatorTagKey);
        if (r12 != null) goto L6;
    L4:
        r12 = null;
    L8:
        if (((CommonFloatProperty) r12) == null) goto L11;
        float r13 = AnimUtils.getAnimFraction(r9, r2, r3);
        float r14 = r4 + ((r5 - r4) * r13);
        r1.setScaleX(r14);
        r1.setScaleY(r14);
        r1.setTranslationY(r6 + ((r7 - r6) * r13));
        return;
    L11:
        return;
    L6:
        if ((r12 instanceof CommonFloatProperty) == false) goto L4;
        goto L4
    }

    public final void startStackTransitionAnimation(OPopoverBase<?> r16, boolean r17, final float r18, final float r19) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        final ViewGroup r2 = r16.getPopoverWindowFrame();
        final View r7 = r16.getPopoverBubbleLayout().getChildAt(0);
        if (r17 == false) goto L5;
        float r0 = 0.8f;
    L7:
        if (r17 == false) goto L9;
        float r4 = 0.0f;
    L10:
        if (r17 == false) goto L12;
        float r5 = 10000.0f;
    L13:
        final float r6 = r2.getScaleX();
        final float r14 = r7.getAlpha();
        ViewPropertySpringAnimator r1 = ViewPropertySpringAnimator.animateProperty$default(ViewPropertySpringAnimatorExtKt.spring(r2).defaultDampingRatio(r0).defaultStiffness(439.0f), animFloatP, r5, null, 4, null);
        final float r3 = r4;
        final float r8 = r5;
        r1.setUpdateListener(new OPopoverAnimationHelper$$ExternalSyntheticLambda0(r2, r3, r8, r6, r19, r7, r14, r18));
        r1.start();
        return;
    L12:
        r5 = 0.0f;
        goto L13
    L9:
        r4 = 10000.0f;
        goto L10
    L5:
        r0 = 1.0f;
        goto L7
    }

    /* JADX INFO: renamed from: startStackTransitionAnimation$lambda-4$lambda-3, reason: not valid java name */
    private static final void m1305startStackTransitionAnimation$lambda4$lambda3(ViewGroup r1, float r2, float r3, float r4, float r5, View r6, float r7, float r8, DynamicAnimation r9, float r10, float r11) {
        Intrinsics.checkNotNullParameter(r1, "$view");
        KtExt r12 = KtExt.INSTANCE;
        Object r13 = r1.getTag(springAnimatorTagKey);
        if (r13 != null) goto L6;
    L4:
        r13 = null;
    L8:
        if (((CommonFloatProperty) r13) == null) goto L11;
        float r14 = AnimUtils.getAnimFraction(r10, r2, r3);
        float r15 = r4 + ((r5 - r4) * r14);
        r1.setScaleX(r15);
        r1.setScaleY(r15);
        r6.setAlpha(r7 + ((r8 - r7) * r14));
        return;
    L11:
        return;
    L6:
        if ((r13 instanceof CommonFloatProperty) == false) goto L4;
        goto L4
    }
}
