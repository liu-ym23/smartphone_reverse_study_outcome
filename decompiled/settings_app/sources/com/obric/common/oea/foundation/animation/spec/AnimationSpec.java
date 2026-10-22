package com.obric.common.oea.foundation.animation.spec;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J%\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000bJ-\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000eJ-\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H&¨\u0006\u0014"}, d2 = {"Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", ExifInterface.GPS_DIRECTION_TRUE, "", "dump", "", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "", "(Ljava/lang/Object;Ljava/lang/Object;F)J", "getValueFromNanos", "playTimeNanos", "(JLjava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "getVelocityFromNanos", "(JLjava/lang/Object;Ljava/lang/Object;F)F", "isFinishedFromNanos", "", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface AnimationSpec<T> {
    String dump();

    long getDurationNanos(T r1, T r2, float r3);

    T getValueFromNanos(long r1, T r3, T r4, float r5);

    float getVelocityFromNanos(long r1, T r3, T r4, float r5);

    boolean isFinishedFromNanos(long r1, long r3);
}
