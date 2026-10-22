package com.obric.oui.sheet.v2;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oui.R;
import com.obric.oui.animation.style.UtilKt;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.AnimUtils;
import com.obric.oui.utils.KtExt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SheetAnimStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001:B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nJ$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\nJ(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J(\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J#\u0010\"\u001a\u00020\u0006\"\b\b\u0000\u0010#*\u00020\b*\u0002H#2\b\b\u0001\u0010$\u001a\u00020%¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020(*\u00020\b2\u0006\u0010)\u001a\u00020%H\u0002J%\u0010*\u001a\u00020+\"\b\b\u0000\u0010#*\u00020\b*\u0002H#2\b\b\u0001\u0010$\u001a\u00020%H\u0002¢\u0006\u0002\u0010,J]\u0010-\u001a\u00020+*\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00100\u001a\u00020\n2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00104J[\u00105\u001a\u00020+*\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00106\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020\n2\n\b\u0002\u00103\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00107JQ\u00108\u001a\u00020+*\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00106\u001a\u00020\n2\n\b\u0002\u00103\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00109R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetAnimStyle;", "", "()V", "TAG", "", "adjustSheetRootTopSpace", "", "container", "Landroid/view/View;", "calculateAndroidDecayTarget", "", "initValue", "initialVelocity", "frictionMultiplier", "", "absVelocityThreshold", "calculateStiffnessFromDuration", "durationMs", "decideSpringParams", "Lkotlin/Pair;", "heightRatio", "isShow", "", "shouldDismiss", "view", "dismissThreshold", "updateDimViewWithAnim", "dimView", "animFraction", "startDim", "endDim", "updateWindowDimWithAnim", "window", "Landroid/view/Window;", "clearSheetAnimator", ExifInterface.GPS_DIRECTION_TRUE, "animId", "", "(Landroid/view/View;I)V", "decideHeightLevel", "Lcom/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel;", "screenHeight", "getSheetAnimator", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "(Landroid/view/View;I)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "sheetHide", "enableDimAnim", "useWindowDim", "yVelocity", "endCallback", "Ljava/lang/Runnable;", "fullWindowHeight", "(Landroid/view/View;Landroid/view/Window;Landroid/view/View;ZZFLjava/lang/Runnable;Ljava/lang/Integer;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "sheetPositionSmoothReset", "targetDimAmount", "(Landroid/view/View;Landroid/view/Window;Landroid/view/View;ZZFFLjava/lang/Integer;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "sheetShow", "(Landroid/view/View;Landroid/view/Window;Landroid/view/View;ZZFLjava/lang/Integer;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "HeightLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SheetAnimStyle {
    public static final SheetAnimStyle INSTANCE = null;
    public static final String TAG = "SheetAnimStyle";

    /* JADX INFO: compiled from: SheetAnimStyle.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/SheetAnimStyle$HeightLevel;", "", "maxRatio", "", "(Ljava/lang/String;IF)V", "getMaxRatio", "()F", "SMALL", "MEDIUM", "LARGE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    static {
        INSTANCE = new SheetAnimStyle();
    }

    private SheetAnimStyle() {
    }

    public static final /* synthetic */ void access$updateDimViewWithAnim(SheetAnimStyle r0, View r1, float r2, float r3, float r4) {
        r0.updateDimViewWithAnim(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$updateWindowDimWithAnim(SheetAnimStyle r0, Window r1, float r2, float r3, float r4) {
        r0.updateWindowDimWithAnim(r1, r2, r3, r4);
    }

    public static /* synthetic */ PropertyAnimatable.Builder sheetShow$default(SheetAnimStyle r7, View r8, Window r9, View r10, boolean r11, boolean r12, float r13, Integer r14, int r15, Object r16) {
        Integer r1 = null;
        if ((r15 & 1) == 0) goto L5;
        Window r0 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        View r2 = null;
    L10:
        boolean r4 = true;
        if ((r15 & 4) == 0) goto L13;
        boolean r3 = true;
    L15:
        if ((r15 & 8) != 0) goto L19;
        r4 = r12;
    L19:
        if ((r15 & 16) == 0) goto L21;
        float r5 = 0.6f;
    L23:
        if ((r15 & 32) != 0) goto L27;
        r1 = r14;
    L27:
        return r7.sheetShow(r8, r0, r2, r3, r4, r5, r1);
    L21:
        r5 = r13;
        goto L23
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L10
    L5:
        r0 = r9;
        goto L7
    }

    public final PropertyAnimatable.Builder sheetShow(View r17, final Window r18, final View r19, final boolean r20, final boolean r21, final float r22, Integer r23) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        if (r23 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        int r3 = r0;
        if (r20 == false) goto L14;
        if (r21 == false) goto L14;
        if (r18 == null) goto L14;
        r18.addFlags(2);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L14:
        int r1 = r17.getHeight() + OUnitExtensionKt.vdp(r17, 32);
        r17.setAlpha(1.0f);
        final float r2 = r1;
        r17.setTranslationY(r2);
        Pair<Float, Float> r4 = decideSpringParams(r17.getHeight() / r3, true);
        float r7 = r4.component1().floatValue();
        float r5 = r4.component2().floatValue();
        final float r6 = OUnitExtensionKt.vdp(r17, 2);
        PropertyAnimatable.Builder r8 = getSheetAnimator(r17, R.id.o_dialog_anim_in);
        AnimationProperty.FloatProperty r9 = AnimationProperty.FloatProperty.TRANSLATION_Y;
        Float r10 = Float.valueOf(r2);
        FloatSpringSpec r11 = AnimationSpecKt.spring$default(r7, r5, 0, 4, null);
        r11.setAccuracy(1.0f);
        Unit r12 = Unit.INSTANCE;
        return PropertyAnimatable.Builder.of$default(r8, r9, r10, r6, r11, null, 16, null).onUpdate(new C02992(r20, r21, r18, r2, r6, r22, r19));
    L5:
        r0 = r23.intValue();
        goto L6
    }

    public static /* synthetic */ PropertyAnimatable.Builder sheetHide$default(SheetAnimStyle r8, View r9, Window r10, View r11, boolean r12, boolean r13, float r14, Runnable r15, Integer r16, int r17, Object r18) {
        Integer r1 = null;
        if ((r17 & 1) == 0) goto L5;
        Window r0 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        View r2 = null;
    L10:
        boolean r4 = true;
        if ((r17 & 4) == 0) goto L13;
        boolean r3 = true;
    L15:
        if ((r17 & 8) != 0) goto L19;
        r4 = r13;
    L19:
        if ((r17 & 16) == 0) goto L21;
        float r5 = 0.0f;
    L23:
        if ((r17 & 32) == 0) goto L25;
        Runnable r6 = null;
    L27:
        if ((r17 & 64) != 0) goto L31;
        r1 = r16;
    L31:
        return r8.sheetHide(r9, r0, r2, r3, r4, r5, r6, r1);
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r0 = r10;
        goto L7
    }

    public final PropertyAnimatable.Builder sheetHide(final View r20, final Window r21, final View r22, final boolean r23, final boolean r24, float r25, final Runnable r26, Integer r27) {
        Intrinsics.checkNotNullParameter(r20, "<this>");
        if (r27 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        int r2 = r0;
        if (r23 == false) goto L15;
        if (r24 == false) goto L15;
        if (r21 == null) goto L15;
        r21.addFlags(2);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("dialogBottomHide, can't show dim anim: ", e.getMessage()));
    L15:
        int r1 = r20.getHeight() + OUnitExtensionKt.vdp(r20, 32);
        Pair<Float, Float> r3 = decideSpringParams(r20.getHeight() / r2, false);
        float r5 = r3.component1().floatValue();
        float r4 = r3.component2().floatValue();
        final float r6 = r20.getTranslationY();
        final float r7 = r1;
        final float r8 = 0.0f;
        if (r24 == false) goto L23;
        if (r21 == null) goto L26;
        WindowManager.LayoutParams r9 = r21.getAttributes();
        if (r9 == null) goto L26;
        r8 = r9.dimAmount;
    L26:
        final float r10 = 0.0f;
        PropertyAnimatable.Builder r13 = getSheetAnimator(r20, R.id.o_dialog_anim_out);
        AnimationProperty.FloatProperty r14 = AnimationProperty.FloatProperty.TRANSLATION_Y;
        float r11 = r20.getTranslationY();
        FloatSpringSpec r12 = AnimationSpecKt.spring$default(r5, r4, 0, 4, null);
        r12.setAccuracy(1.0f);
        PropertyAnimatable.Builder r15 = r13.of(r14, Float.valueOf(r11), r7, r12, Float.valueOf(r25)).onUpdate(new SheetAnimStyle$sheetHide$animBuilder$2(r23, r24, r21, r6, r7, r8, r10, r22, r20, r26));
        UtilKt.hideSoftKeyboard(r20);
        return r15;
    L23:
        if (r22 == null) goto L26;
        r8 = r22.getAlpha();
        goto L26
    L5:
        r0 = r27.intValue();
        goto L6
    }

    public static /* synthetic */ PropertyAnimatable.Builder sheetPositionSmoothReset$default(SheetAnimStyle r8, View r9, Window r10, View r11, boolean r12, boolean r13, float r14, float r15, Integer r16, int r17, Object r18) {
        Integer r1 = null;
        if ((r17 & 1) == 0) goto L5;
        Window r0 = null;
    L7:
        if ((r17 & 2) == 0) goto L9;
        View r2 = null;
    L10:
        boolean r4 = true;
        if ((r17 & 4) == 0) goto L13;
        boolean r3 = true;
    L15:
        if ((r17 & 8) != 0) goto L19;
        r4 = r13;
    L19:
        if ((r17 & 16) == 0) goto L21;
        float r5 = 0.6f;
    L23:
        if ((r17 & 32) == 0) goto L25;
        float r6 = 0.0f;
    L27:
        if ((r17 & 64) != 0) goto L31;
        r1 = r16;
    L31:
        return r8.sheetPositionSmoothReset(r9, r0, r2, r3, r4, r5, r6, r1);
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r0 = r10;
        goto L7
    }

    public final PropertyAnimatable.Builder sheetPositionSmoothReset(View r17, final Window r18, final View r19, final boolean r20, final boolean r21, final float r22, float r23, Integer r24) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        if (r24 != null) goto L5;
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
    L6:
        r17.setAlpha(1.0f);
        float r5 = 0.0f;
        if (r21 == false) goto L14;
        if (r18 == null) goto L17;
        WindowManager.LayoutParams r6 = r18.getAttributes();
        if (r6 == null) goto L17;
        r5 = r6.dimAmount;
    L17:
        final float r7 = r5;
        Pair<Float, Float> r1 = decideSpringParams(r17.getHeight() / r0, true);
        float r8 = r1.component1().floatValue();
        float r9 = r1.component2().floatValue();
        if (r20 == false) goto L26;
        if (r21 == false) goto L26;
        if (r18 == null) goto L26;
        r18.addFlags(2);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("dialogBottomShow, can't show dim anim: ", e.getMessage()));
    L26:
        final float r2 = r17.getTranslationY();
        final float r10 = 0.0f;
        PropertyAnimatable.Builder r11 = getSheetAnimator(r17, R.id.o_dialog_anim_in);
        AnimationProperty.FloatProperty r12 = AnimationProperty.FloatProperty.TRANSLATION_Y;
        float r3 = r17.getTranslationY();
        FloatSpringSpec r4 = AnimationSpecKt.spring$default(r8, r9, 0, 4, null);
        r4.setAccuracy(1.0f);
        return r11.of(r12, Float.valueOf(r3), 0.0f, r4, Float.valueOf(r23)).onUpdate(new AnonymousClass2(r20, r21, r18, r2, r10, r7, r22, r19));
    L14:
        if (r19 == null) goto L17;
        r5 = r19.getAlpha();
        goto L17
    L5:
        r0 = r24.intValue();
        goto L6
    }

    public final void adjustSheetRootTopSpace(View r4) {
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

    private final void updateDimViewWithAnim(View r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setAlpha(r4 + (r6 * RangesKt.coerceIn(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("updateDimViewWithAnim: ", e.getMessage()));
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

    private final Pair<Float, Float> decideSpringParams(float r6, boolean r7) {
        float r1 = 1.0f - Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH.getBounce();
        if (r7 == false) goto L7;
        return new Pair(Float.valueOf(r1), Float.valueOf(calculateStiffnessFromDuration(AnimUtils.remap(r6, 0.3f, 0.6f, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1.getDuration() / 1000.0f, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3.getDuration() / 1000.0f))));
    L7:
        return new Pair(Float.valueOf(r1), Float.valueOf(calculateStiffnessFromDuration(AnimUtils.remap(r6, 0.3f, 0.6f, Token.Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration() / 1000.0f, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2.getDuration() / 1000.0f))));
    }

    public final float calculateStiffnessFromDuration(float r3) {
        return (float) Math.pow(6.283185307179586d / ((double) r3), 2.0d);
    }

    private final <T extends View> PropertyAnimatable.Builder getSheetAnimator(T r3, int r4) {
        KtExt r2 = KtExt.INSTANCE;
        Object r5 = r3.getTag(r4);
        if (r5 != null) goto L6;
    L4:
        r5 = null;
    L7:
        PropertyAnimatable.Builder r6 = (PropertyAnimatable.Builder) r5;
        if (r6 != null) goto L11;
        PropertyAnimatable.Builder r7 = new PropertyAnimatable.Builder(r3);
        r3.setTag(r4, r7);
        return r7;
    L11:
        return r6;
    L6:
        if ((r5 instanceof PropertyAnimatable.Builder) == false) goto L4;
        goto L4
    }

    public final <T extends View> void clearSheetAnimator(T r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setTag(r2, null);
    }

    public static /* synthetic */ boolean shouldDismiss$default(SheetAnimStyle r0, View r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 0.333333f;
    L6:
        return r0.shouldDismiss(r1, r2, r3);
    }

    public final boolean shouldDismiss(View r12, float r13, float r14) {
        Intrinsics.checkNotNullParameter(r12, "view");
        if ((r12.getTranslationY() / r12.getHeight()) <= r14) goto L6;
        return true;
    L6:
        if ((calculateAndroidDecayTarget$default(this, r12.getTranslationY(), r13, 0.0d, 0.0d, 12, null) / r12.getHeight()) > r14) goto L10;
        return false;
    L10:
        return true;
    }

    public static /* synthetic */ float calculateAndroidDecayTarget$default(SheetAnimStyle r7, float r8, float r9, double r10, double r12, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = 0.5d;
    L5:
        double r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        r12 = 0.1d;
    L9:
        return r7.calculateAndroidDecayTarget(r8, r9, r3, r12);
    }

    public final float calculateAndroidDecayTarget(float r3, float r4, double r5, double r7) {
        Ref.DoubleRef r2 = new Ref.DoubleRef();
        r2.element = RangesKt.coerceAtLeast(1.0E-7d, Math.abs(r7));
        return calculateAndroidDecayTarget$getTargetValue(r2, RangesKt.coerceAtLeast(1.0E-4d, r5) * (-4.2d), r3, r4);
    }

    private static final float calculateAndroidDecayTarget$getTargetValue(Ref.DoubleRef r6, double r7, float r9, float r10) {
        if (Math.abs(r10) > r6.element) goto L5;
        return r9;
    L5:
        double r2 = r10;
        double r4 = 1000;
        double r0 = (Math.log(Math.abs(r6.element / r2)) / r7) * r4;
        double r3 = r2 / r7;
        return (float) ((((double) r9) - r3) + (r3 * Math.exp((r7 * r0) / r4)));
    }
}
