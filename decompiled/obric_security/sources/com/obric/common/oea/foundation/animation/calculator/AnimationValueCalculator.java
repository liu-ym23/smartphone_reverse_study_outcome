package com.obric.common.oea.foundation.animation.calculator;

import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimationValueCalculator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J;\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&¢\u0006\u0002\u0010\fJ;\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH&¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/foundation/animation/calculator/AnimationValueCalculator;", ExifInterface.GPS_DIRECTION_TRUE, "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "(JLjava/lang/Object;Ljava/lang/Object;FLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;)Ljava/lang/Object;", "getVelocityFromNanos", "(JLjava/lang/Object;Ljava/lang/Object;FLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;)F", "isFinishedFromNanos", "", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface AnimationValueCalculator<T> {
    T getValueFromNanos(long r1, T r3, T r4, float r5, AnimationSpec<T> r6);

    float getVelocityFromNanos(long r1, T r3, T r4, float r5, AnimationSpec<T> r6);

    boolean isFinishedFromNanos(long r1, long r3, AnimationSpec<T> r5);
}
