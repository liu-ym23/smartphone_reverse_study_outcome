package com.obric.common.oea.style.scene.qsanim.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropertyAnimUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ.\u0010\f\u001a\u00020\t*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0014\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0004J0\u0010\u0015\u001a\u00020\t*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/PropertyAnimUtils;", "", "()V", "TAG", "", "cubicEaseOutInterpolator", "Lcom/obric/common/oea/style/scene/qsanim/common/CubicEaseOutInterpolator;", "propertyAnimCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/animation/Animator;", "clearAnimCache", "", "animTo", "propertyName", "toValue", "", "duration", "", "interpolator", "Landroid/animation/TimeInterpolator;", "cancelAnim", "newAnimTo", "withAnim", "Landroid/animation/AnimatorSet;", "target", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class PropertyAnimUtils {
    public static final PropertyAnimUtils INSTANCE = null;
    private static final String TAG = "PropertyAnimUtils";
    private static final CubicEaseOutInterpolator cubicEaseOutInterpolator = null;
    private static final ConcurrentHashMap<String, Animator> propertyAnimCache = null;

    static {
        INSTANCE = new PropertyAnimUtils();
        cubicEaseOutInterpolator = new CubicEaseOutInterpolator();
        propertyAnimCache = new ConcurrentHashMap();
    }

    private PropertyAnimUtils() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getPropertyAnimCache$p(PropertyAnimUtils r0) {
        return propertyAnimCache;
    }

    public final void clearAnimCache() {
        propertyAnimCache.clear();
    }

    public final void cancelAnim(Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$cancelAnim");
        Intrinsics.checkNotNullParameter(r4, "propertyName");
        String r2 = SpringAnimUtils.INSTANCE.animKey(r3, "PROPERTY_ANIM_" + r4);
        ConcurrentHashMap<String, Animator> r5 = propertyAnimCache;
        Animator r6 = r5.get(r2);
        if (r6 == null) goto L6;
        r6.cancel();
        r5.remove(r2);
        return;
    }

    public static /* synthetic */ Animator animTo$default(PropertyAnimUtils r7, Object r8, String r9, float r10, long r11, CubicEaseOutInterpolator r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = cubicEaseOutInterpolator;
    L6:
        return r7.animTo(r8, r9, r10, r11, r13);
    }

    public final Animator animTo(Object r15, String r16, float r17, long r18, TimeInterpolator r20) {
        Intrinsics.checkNotNullParameter(r15, "$this$animTo");
        Intrinsics.checkNotNullParameter(r16, "propertyName");
        final String r10 = SpringAnimUtils.INSTANCE.animKey(r15, "PROPERTY_ANIM_" + r16);
        ConcurrentHashMap<String, Animator> r11 = propertyAnimCache;
        ConcurrentHashMap<String, Animator> r12 = r11;
        Animator r0 = r12.get(r10);
        if (r0 != null) goto L8;
        r0 = INSTANCE.newAnimTo(r15, r16, r17, r18, r20);
        Animator r1 = r12.putIfAbsent(r10, r0);
        if (r1 == null) goto L8;
        r0 = r1;
    L8:
        Animator r2 = r0;
        Intrinsics.checkNotNullExpressionValue(r2, "anim");
        if (r2.isRunning() == true) goto L11;
        r2.addListener(new AnonymousClass1(r10));
        r2.start();
        OEALogger.INSTANCE.d(TAG, "animTo2: start, key: " + r10 + ", propertyName: " + r16 + ", toValue: " + r17 + ", obj: " + r15.getClass().getSimpleName() + ", size: " + r11.size());
    L12:
        return r2;
    L11:
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "animTo2: anim is running, key: " + r10 + ", propertyName: " + r16 + ", toValue: " + r17 + ", obj: " + r15.getClass().getSimpleName() + ", size: " + r11.size(), null, 4, null);
        goto L12
    }

    static /* synthetic */ Animator newAnimTo$default(PropertyAnimUtils r7, Object r8, String r9, float r10, long r11, CubicEaseOutInterpolator r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r13 = cubicEaseOutInterpolator;
    L6:
        return r7.newAnimTo(r8, r9, r10, r11, r13);
    }

    private final Animator newAnimTo(Object r2, String r3, float r4, long r5, TimeInterpolator r7) {
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r2, r3, new float[]{r4});
        Intrinsics.checkNotNullExpressionValue(r1, "it");
        r1.setDuration(r5);
        r1.setInterpolator(r7);
        Intrinsics.checkNotNullExpressionValue(r1, "ObjectAnimator.ofFloat(t… = interpolator\n        }");
        return r1;
    }

    public static /* synthetic */ AnimatorSet withAnim$default(PropertyAnimUtils r7, AnimatorSet r8, Object r9, String r10, float r11, long r12, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r12 = 0;
    L6:
        return r7.withAnim(r8, r9, r10, r11, r12);
    }

    public final AnimatorSet withAnim(AnimatorSet r2, Object r3, String r4, float r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "$this$withAnim");
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r4, "propertyName");
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r3, r4, new float[]{r5});
        if (r6 <= 0) goto L5;
        Intrinsics.checkNotNullExpressionValue(r1, "it");
        r1.setDuration(r6);
    L5:
        r2.play(r1);
        return r2;
    }
}
