package com.obric.common.oea.style.scene.qsanim.common;

import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oea.foundation.util.OEALogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KtExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004J\u001e\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0006\b\u0000\u0010\t\u0018\u0001*\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/KtExt;", "", "()V", "dampedClamp", "", "input", "threshold", "factor", "safeCastTo", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Ljava/lang/Object;", "AutoExpireFlag", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class KtExt {
    public static final KtExt INSTANCE = null;

    /* JADX INFO: compiled from: KtExt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011R\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/KtExt$AutoExpireFlag;", ExifInterface.GPS_DIRECTION_TRUE, "", "defaultValue", "expireTime", "", "(Ljava/lang/Object;J)V", "Ljava/lang/Object;", "timeStamp", "value", "getValue", "()Ljava/lang/Object;", "isExpired", "", "setValue", "", "flag", "(Ljava/lang/Object;)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AutoExpireFlag<T> {
        private final T defaultValue;
        private final long expireTime;
        private long timeStamp;
        private T value;

        public AutoExpireFlag(T r1, long r2) {
            this.defaultValue = r1;
            this.expireTime = r2;
            this.value = r1;
        }

        public /* synthetic */ AutoExpireFlag(Object r1, long r2, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = 1000;
        L5:
            this(r1, r2);
        }

        public final T getValue() {
            if (isExpired() == false) goto L6;
            this.value = this.defaultValue;
        L6:
            return this.value;
        }

        public final void setValue(T r3) {
            this.value = r3;
            this.timeStamp = System.currentTimeMillis();
        }

        public final boolean isExpired() {
            long r0 = System.currentTimeMillis() - this.timeStamp;
            if (r0 >= 0) goto L7;
            OEALogger.e$default(OEALogger.INSTANCE, "AutoExpireFlag", "timeElapsed < 0", null, 4, null);
            this.timeStamp = System.currentTimeMillis();
            return false;
        L7:
            if (r0 <= this.expireTime) goto L10;
            return true;
        L10:
            return false;
        }
    }

    static {
        INSTANCE = new KtExt();
    }

    private KtExt() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> T safeCastTo(Object r3) {
        if (r3 != 0) goto L5;
        return null;
    L5:
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r3 instanceof Object) == false) goto L9;
        return r3;
    L9:
        return null;
    }

    public static /* synthetic */ float dampedClamp$default(KtExt r0, float r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 1.0f;
    L6:
        return r0.dampedClamp(r1, r2, r3);
    }

    public final float dampedClamp(float r4, float r5, float r6) {
        boolean r3 = false;
        float r0 = 0;
        if (r5 < r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L24;
        if (r6 >= r0) goto L10;
    L12:
        if (r3 == false) goto L22;
        if (r4 != 0.0f) goto L17;
        return 0.0f;
    L17:
        if (r5 != 0.0f) goto L20;
        return 0.0f;
    L20:
        return (1.0f - (1.0f / (((Math.abs(r4) * r6) / r5) + 1.0f))) * r5;
    L22:
        throw new IllegalArgumentException("factor must be in the range [0, 1]".toString());
    L10:
        if (r6 > 1.0f) goto L12;
        r3 = true;
        goto L12
    L24:
        throw new IllegalArgumentException("threshold must be non-negative".toString());
    L5:
        r1 = false;
        goto L6
    }
}
