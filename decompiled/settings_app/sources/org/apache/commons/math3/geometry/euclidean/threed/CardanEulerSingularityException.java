package org.apache.commons.math3.geometry.euclidean.threed;

import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class CardanEulerSingularityException extends MathIllegalStateException {
    private static final long serialVersionUID = -1360952845582206770L;

    public CardanEulerSingularityException(boolean r2) {
        if (r2 == false) goto L4;
        LocalizedFormats r3 = LocalizedFormats.CARDAN_ANGLES_SINGULARITY;
    L5:
        super(r3, new Object[0]);
        return;
    L4:
        r3 = LocalizedFormats.EULER_ANGLES_SINGULARITY;
        goto L5
    }
}
