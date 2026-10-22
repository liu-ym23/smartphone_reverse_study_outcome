package com.obric.common.oea.style.scene.qsanim.common;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import com.obric.common.oea.foundation.animation.engine.FloatPropertyCompat;
import com.obric.common.oea.foundation.animation.engine.SpringAnimation;
import com.obric.common.oea.foundation.animation.engine.SpringForce;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpringAnimUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "后续请使用动效曲线中的 api")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0012\u0010\u0012\u001a\u00020\t*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\tJ'\u0010\u0014\u001a\u00020\u000e\"\b\b\u0000\u0010\u0015*\u00020\u0001*\u0002H\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004¢\u0006\u0002\u0010\u0017J]\u0010\u0018\u001a\u0004\u0018\u00010\f\"\b\b\u0000\u0010\u0015*\u00020\u0001*\u0002H\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u0006\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils;", "", "()V", "PROPERTY_FLOAT", "Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;", "Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "getPROPERTY_FLOAT", "()Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;", "TAG", "", "springAnimCache", "", "Lcom/obric/common/oea/foundation/animation/engine/SpringAnimation;", "clearAnimCache", "", "responseToStiffness", "", ApmTrafficStats.TTNET_RESPONSE, "animKey", "tag", "cancelSpring", "K", "property", "(Ljava/lang/Object;Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;)V", "springTo", "targetValue", "dampingRatio", "stiffness", "updateListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "endListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;", "(Ljava/lang/Object;Lcom/obric/common/oea/foundation/animation/engine/FloatPropertyCompat;FFFLcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;)Lcom/obric/common/oea/foundation/animation/engine/SpringAnimation;", "CommonFloatProperty", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SpringAnimUtils {
    public static final SpringAnimUtils INSTANCE = null;
    private static final FloatPropertyCompat<CommonFloatProperty> PROPERTY_FLOAT = null;
    private static final String TAG = "SpringAnimUtils";
    private static final Map<String, SpringAnimation> springAnimCache = null;

    /* JADX INFO: compiled from: SpringAnimUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "", "value", "", "(F)V", "getValue", "()F", "setValue", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
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

    public final float responseToStiffness(float r1) {
        return (40.0f / r1) / r1;
    }

    static {
        INSTANCE = new SpringAnimUtils();
        springAnimCache = new LinkedHashMap();
        final String r1 = "v";
        PROPERTY_FLOAT = new SpringAnimUtils$PROPERTY_FLOAT$1(r1);
    }

    private SpringAnimUtils() {
    }

    public final void clearAnimCache() {
        springAnimCache.clear();
    }

    public final <K> void cancelSpring(K r3, FloatPropertyCompat<K> r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$cancelSpring");
        Intrinsics.checkNotNullParameter(r4, "property");
        String r2 = animKey(r3, "SPRING_ANIM_" + r4.hashCode());
        Map<String, SpringAnimation> r5 = springAnimCache;
        SpringAnimation r6 = r5.get(r2);
        if (r6 == null) goto L6;
        r6.cancel();
        r5.remove(r2);
        return;
    }

    public static /* synthetic */ SpringAnimation springTo$default(SpringAnimUtils r9, Object r10, FloatPropertyCompat r11, float r12, float r13, float r14, DynamicAnimation.OnAnimationUpdateListener r15, DynamicAnimation.OnAnimationEndListener r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        float r5 = 0.9f;
    L7:
        if ((r17 & 8) == 0) goto L9;
        float r6 = 250.0f;
    L11:
        if ((r17 & 16) == 0) goto L13;
        DynamicAnimation.OnAnimationUpdateListener r0 = (DynamicAnimation.OnAnimationUpdateListener) null;
        DynamicAnimation.OnAnimationUpdateListener r7 = null;
    L15:
        if ((r17 & 32) == 0) goto L17;
        DynamicAnimation.OnAnimationEndListener r1 = (DynamicAnimation.OnAnimationEndListener) null;
        DynamicAnimation.OnAnimationEndListener r8 = null;
    L19:
        return r9.springTo(r10, r11, r12, r5, r6, r7, r8);
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final <K> SpringAnimation springTo(K r3, FloatPropertyCompat<K> r4, float r5, float r6, float r7, DynamicAnimation.OnAnimationUpdateListener r8, DynamicAnimation.OnAnimationEndListener r9) {
        Intrinsics.checkNotNullParameter(r3, "$this$springTo");
        Intrinsics.checkNotNullParameter(r4, "property");
        String r2 = animKey(r3, "SPRING_ANIM_" + r4.hashCode());
        float r0 = r4.getValue(r3);
        if (r0 != r5) goto L11;
        OEALogger.INSTANCE.d(TAG, "springTo, no need! currentValue: " + r0 + ", targetValue: " + r5 + ", this: " + r3);
        SpringAnimation r10 = springAnimCache.get(r2);
        if (r10 == null) goto L8;
        r10.cancel();
    L8:
        if (r9 == null) goto L10;
        r9.onAnimationEnd(null, true, r5, 0.0f);
    L10:
        return null;
    L11:
        Map<String, SpringAnimation> r1 = springAnimCache;
        SpringAnimation r11 = r1.get(r2);
        if (r11 != null) goto L14;
        SpringAnimation r12 = new SpringAnimation(r3, r4);
        SpringForce r13 = new SpringForce(r5);
        r13.setDampingRatio(r6);
        r13.setStiffness(r7);
        r11 = r12.setSpring(r13);
        Intrinsics.checkNotNullExpressionValue(r11, "springAnim.setSpring(springForce)");
        r1.put(r2, r11);
    L14:
        SpringAnimation r14 = r11;
        if (r14.isRunning() == true) goto L20;
        if (r8 == null) goto L18;
        r14.addUpdateListener(r8);
    L18:
        if (r9 == null) goto L20;
        r14.addEndListener(r9);
    L20:
        r14.animateToFinalPosition(r5);
        return r14;
    }

    public final String animKey(Object r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$animKey");
        Intrinsics.checkNotNullParameter(r2, "tag");
        return r2 + '_' + r1.hashCode();
    }

    public final FloatPropertyCompat<CommonFloatProperty> getPROPERTY_FLOAT() {
        return PROPERTY_FLOAT;
    }
}
