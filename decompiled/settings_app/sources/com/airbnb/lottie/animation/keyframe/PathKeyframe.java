package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* JADX INFO: loaded from: classes.dex */
public class PathKeyframe extends Keyframe<PointF> {
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition r8, Keyframe<PointF> r9) {
        super(r8, r9.startValue, r9.endValue, r9.interpolator, r9.startFrame, r9.endFrame);
        this.pointKeyFrame = r9;
        createPath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void createPath() {
        if (this.endValue != 0) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (this.endValue == 0) goto L15;
        if (r0 == true) goto L16;
        this.path = Utils.createPath((PointF) this.startValue, (PointF) this.endValue, this.pointKeyFrame.pathCp1, this.pointKeyFrame.pathCp2);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (this.startValue == 0) goto L9;
        if (((PointF) this.startValue).equals(((PointF) this.endValue).x, ((PointF) this.endValue).y) == false) goto L9;
        r0 = true;
        goto L11
    }

    Path getPath() {
        return this.path;
    }
}
