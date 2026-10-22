package com.obric.oui.dialog.anim;

import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oui.R;
import com.obric.oui.animation.easy.SpringAnimationConfig;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.style.UtilKt;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.AnimUtils;
import com.obric.oui.utils.KtExt;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DialogAnimStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0014\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J0\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001b*\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\rJ:\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001b*\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ+\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H 0\u001b\"\b\b\u0000\u0010 *\u00020\b*\u0002H 2\b\b\u0001\u0010!\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/oui/dialog/anim/DialogAnimStyle;", "", "()V", "TAG", "", "adjustDialogTopSpace", "", "container", "Landroid/view/View;", "decideSpringParams", "Lkotlin/Pair;", "", "useNewDialogAnim", "", "heightLevel", "Lcom/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel;", "isShow", "updateWindowDimWithAnim", "window", "Landroid/view/Window;", "animFraction", "startDim", "endDim", "decideHeightLevel", "screenHeight", "", "dialogBottomHide", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "withDimAnim", "dialogBottomShow", "targetDimAmount", "spring", ExifInterface.GPS_DIRECTION_TRUE, "animId", "(Landroid/view/View;I)Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "HeightLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogAnimStyle {
    public static final DialogAnimStyle INSTANCE = null;
    private static final String TAG = "DialogAnimStyle";

    /* JADX INFO: compiled from: DialogAnimStyle.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/dialog/anim/DialogAnimStyle$HeightLevel;", "", "maxRatio", "", "(Ljava/lang/String;IF)V", "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum HeightLevel extends Enum<HeightLevel> {
        private static final /* synthetic */ HeightLevel[] $VALUES = null;
        public static final HeightLevel LARGE = null;
        public static final HeightLevel MEDIUM = null;
        public static final HeightLevel SMALL = null;
        private final float maxRatio;

        private static final /* synthetic */ HeightLevel[] $values() {
            return new HeightLevel[]{SMALL, MEDIUM, LARGE};
        }

        public static HeightLevel valueOf(String r1) {
            return (HeightLevel) Enum.valueOf(HeightLevel.class, r1);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) $VALUES.clone();
        }

        private HeightLevel(String r1, int r2, float r3) {
            super(r1, r2);
            this.maxRatio = r3;
        }

        public final float getMaxRatio() {
            return this.maxRatio;
        }

        static {
            SMALL = new HeightLevel("SMALL", 0, 0.4f);
            MEDIUM = new HeightLevel("MEDIUM", 1, 0.8f);
            LARGE = new HeightLevel("LARGE", 2, 1.0f);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: DialogAnimStyle.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[HeightLevel.values().length];
            r0[HeightLevel.SMALL.ordinal()] = 1;
            r0[HeightLevel.MEDIUM.ordinal()] = 2;
            r0[HeightLevel.LARGE.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$5LAcn4bTplg9En951ukIFRXmqrM(Window r0, float r1, float r2, float r3, DynamicAnimation r4, float r5, float r6) {
        m267dialogBottomShow$lambda1$lambda0(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$E4_JjRGy3aAslIivo4gwMfYV2II(Window r0, float r1, float r2, float r3, float r4, Ref.BooleanRef r5, ViewPropertySpringAnimator r6, DynamicAnimation r7, float r8, float r9) {
        m266dialogBottomHide$lambda3$lambda2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static {
        INSTANCE = new DialogAnimStyle();
    }

    private DialogAnimStyle() {
    }

    public static /* synthetic */ ViewPropertySpringAnimator dialogBottomShow$default(DialogAnimStyle r6, View r7, Window r8, boolean r9, float r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r8 = null;
    L5:
        Window r2 = r8;
        if ((r12 & 2) == 0) goto L8;
        boolean r3 = true;
    L10:
        if ((r12 & 4) == 0) goto L12;
        r10 = 0.6f;
    L12:
        float r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        boolean r5 = true;
    L17:
        return r6.dialogBottomShow(r7, r2, r3, r4, r5);
    L15:
        r5 = r11;
        goto L17
    L8:
        r3 = r9;
        goto L10
    }

    public final ViewPropertySpringAnimator<View> dialogBottomShow(View r5, final Window r6, boolean r7, final float r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Size r0 = OWindowConfigController.getFullWindowSize(r5.getContext());
        int r1 = r5.getHeight();
        ViewGroup.LayoutParams r2 = r5.getLayoutParams();
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        if (r3 == null) goto L8;
        int r4 = r3.bottomMargin;
    L9:
        final int r10 = (r1 + r4) + OUnitExtensionKt.vdp(r5, 24);
        r5.setAlpha(1.0f);
        Pair<Float, Float> r11 = decideSpringParams(r9, decideHeightLevel(r5, r0.getHeight()), true);
        final float r12 = r11.component1().floatValue();
        final float r13 = r11.component2().floatValue();
        ViewPropertySpringAnimator r14 = spring(r5, R.id.o_dialog_anim_in);
        Function1<SpringAnimationConfig, Unit> r15 = new AnonymousClass1(r12, r13, r10);
        final float r16 = 0.0f;
        ViewPropertySpringAnimator<View> r17 = r14.translationY(0.0f, r15);
        if (r6 == null) goto L17;
        if (r7 == false) goto L17;
        r6.addFlags(2);     // Catch: Exception -> L15
        final float r18 = r10;
        r17.setUpdateListener(new DialogAnimStyle$$ExternalSyntheticLambda1(r6, r18, r16, r8));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L17:
        return r17;
    L8:
        r4 = 0;
        goto L9
    }

    /* JADX INFO: renamed from: dialogBottomShow$lambda-1$lambda-0, reason: not valid java name */
    private static final void m267dialogBottomShow$lambda1$lambda0(Window r0, float r1, float r2, float r3, DynamicAnimation r4, float r5, float r6) {
        INSTANCE.updateWindowDimWithAnim(r0, AnimUtils.getAnimFraction(r5, r1, r2), 0.0f, r3);
    }

    public static /* synthetic */ ViewPropertySpringAnimator dialogBottomHide$default(DialogAnimStyle r1, View r2, Window r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = true;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r5 = true;
    L12:
        return r1.dialogBottomHide(r2, r3, r4, r5);
    }

    public final ViewPropertySpringAnimator<View> dialogBottomHide(View r13, final Window r14, boolean r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Size r2 = OWindowConfigController.getFullWindowSize(r13.getContext());
        int r4 = r13.getHeight();
        ViewGroup.LayoutParams r5 = r13.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r5 = null;
    L5:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        if (r6 == null) goto L8;
        int r7 = r6.bottomMargin;
    L9:
        int r8 = r4 + r7;
        int r9 = OUnitExtensionKt.vdp(r13, 24) + r8;
        Pair<Float, Float> r3 = decideSpringParams(r16, decideHeightLevel(r13, r2.getHeight()), false);
        final float r10 = r3.component1().floatValue();
        final float r11 = r3.component2().floatValue();
        final ViewPropertySpringAnimator<View> r12 = spring(r13, R.id.o_dialog_anim_out).translationY(r9, new DialogAnimStyle$dialogBottomHide$spring$1(r10, r11));
        if (r14 == null) goto L17;
        if (r15 == false) goto L17;
        r14.addFlags(2);     // Catch: Exception -> L15
        final float r0 = 0.0f;
        final float r17 = r8;
        final float r18 = r14.getAttributes().dimAmount;     // Catch: Exception -> L15
        final float r19 = 0.0f;
        final Ref.BooleanRef r20 = new Ref.BooleanRef();     // Catch: Exception -> L15
        r12.setUpdateListener(new DialogAnimStyle$$ExternalSyntheticLambda0(r14, r0, r17, r18, r19, r20, r12));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L17:
        UtilKt.hideSoftKeyboard(r13);
        return r12;
    L8:
        r7 = 0;
        goto L9
    }

    /* JADX INFO: renamed from: dialogBottomHide$lambda-3$lambda-2, reason: not valid java name */
    private static final void m266dialogBottomHide$lambda3$lambda2(Window r0, float r1, float r2, float r3, float r4, Ref.BooleanRef r5, ViewPropertySpringAnimator r6, DynamicAnimation r7, float r8, float r9) {
        Intrinsics.checkNotNullParameter(r5, "$isEnd");
        Intrinsics.checkNotNullParameter(r6, "$this_apply");
        INSTANCE.updateWindowDimWithAnim(r0, AnimUtils.getAnimFraction(r8, r1, r2), r3, r4);
        if (r5.element == false) goto L5;
        return;
    L5:
        if (r8 < r2) goto L9;
        r5.element = true;
        r6.skipToEnd();
        return;
    }

    public final void adjustDialogTopSpace(View r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        int r3 = OUnitExtensionKt.vdp(r4, 10);
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1.topMargin >= r3) goto L7;
        r1.topMargin = r3;
    L7:
        r4.setLayoutParams(r0);
    }

    private final void updateWindowDimWithAnim(Window r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setDimAmount(r4 + (r6 * RangesKt.coerceIn(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("updateWindowDimWithAnim: ", e.getMessage()));
    }

    private final HeightLevel decideHeightLevel(View r1, int r2) {
        if (r2 <= 0) goto L4;
        float r0 = r1.getHeight() / r2;
        if (r0 >= HeightLevel.SMALL.getMaxRatio()) goto L9;
        return HeightLevel.SMALL;
    L9:
        if (r0 >= HeightLevel.MEDIUM.getMaxRatio()) goto L12;
        return HeightLevel.MEDIUM;
    L12:
        return HeightLevel.LARGE;
    L4:
        return HeightLevel.MEDIUM;
    }

    private final Pair<Float, Float> decideSpringParams(boolean r4, HeightLevel r5, boolean r6) {
        Float r3 = Float.valueOf(1.0f);
        if (r4 == true) goto L7;
        return new Pair(r3, Float.valueOf(480.0f));
    L7:
        if (r6 == false) goto L18;
        int r7 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r7 == 1) goto L31;
        if (r7 == 2) goto L30;
        if (r7 != 3) goto L15;
        return new Pair(r3, Float.valueOf(247.0f));
    L15:
        throw new NoWhenBranchMatchedException();
    L30:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L31:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L18:
        int r8 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L33;
        if (r8 != 3) goto L25;
        return new Pair(r3, Float.valueOf(322.0f));
    L25:
        throw new NoWhenBranchMatchedException();
    L33:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L28:
        return new Pair(Float.valueOf(0.85f), Float.valueOf(632.0f));
    }

    private final <T extends View> ViewPropertySpringAnimator<T> spring(T r3, int r4) {
        KtExt r2 = KtExt.INSTANCE;
        Object r5 = r3.getTag(r4);
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        ViewPropertySpringAnimator<T> r6 = (ViewPropertySpringAnimator) r5;
        if (r6 != null) goto L11;
        ViewPropertySpringAnimator<T> r7 = new ViewPropertySpringAnimator(r3);
        r3.setTag(r4, r7);
        return r7;
    L11:
        return r6;
    L6:
        if ((r5 instanceof ViewPropertySpringAnimator) == false) goto L4;
        goto L4
    }
}
