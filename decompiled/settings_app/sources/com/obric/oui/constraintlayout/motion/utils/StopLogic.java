package com.obric.oui.constraintlayout.motion.utils;

import com.obric.oui.constraintlayout.core.motion.utils.SpringStopEngine;
import com.obric.oui.constraintlayout.core.motion.utils.StopEngine;
import com.obric.oui.constraintlayout.core.motion.utils.StopLogicEngine;
import com.obric.oui.constraintlayout.motion.widget.MotionInterpolator;

/* JADX INFO: loaded from: classes4.dex */
public class StopLogic extends MotionInterpolator {
    private StopEngine mEngine;
    private SpringStopEngine mSpringStopEngine;
    private StopLogicEngine mStopLogicEngine;

    public StopLogic() {
        StopLogicEngine r0 = new StopLogicEngine();
        this.mStopLogicEngine = r0;
        this.mEngine = r0;
    }

    public String debug(String r1, float r2) {
        return this.mEngine.debug(r1, r2);
    }

    public float getVelocity(float r1) {
        return this.mEngine.getVelocity(r1);
    }

    public void config(float r8, float r9, float r10, float r11, float r12, float r13) {
        StopLogicEngine r0 = this.mStopLogicEngine;
        this.mEngine = r0;
        r0.config(r8, r9, r10, r11, r12, r13);
    }

    public void springConfig(float r12, float r13, float r14, float r15, float r16, float r17, float r18, int r19) {
        if (this.mSpringStopEngine != null) goto L5;
        this.mSpringStopEngine = new SpringStopEngine();
    L5:
        SpringStopEngine r2 = this.mSpringStopEngine;
        this.mEngine = r2;
        r2.springConfig(r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float r1) {
        return this.mEngine.getInterpolation(r1);
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mEngine.getVelocity();
    }

    public boolean isStopped() {
        return this.mEngine.isStopped();
    }
}
