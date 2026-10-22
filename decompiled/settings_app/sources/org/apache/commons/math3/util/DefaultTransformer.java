package org.apache.commons.math3.util;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultTransformer implements NumberTransformer, Serializable {
    private static final long serialVersionUID = 4019938025047800455L;

    public int hashCode() {
        return 401993047;
    }

    public DefaultTransformer() {
    }

    @Override // org.apache.commons.math3.util.NumberTransformer
    public double transform(Object r4) throws NullArgumentException, MathIllegalArgumentException {
        if (r4 == null) goto L13;
        if ((r4 instanceof Number) == true) goto L7;
        return Double.parseDouble(r4.toString());
    L11:
        throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_TRANSFORM_TO_DOUBLE, new Object[]{r4.toString()});
    L7:
        return ((Number) r4).doubleValue();
    L13:
        throw new NullArgumentException(LocalizedFormats.OBJECT_TRANSFORMATION, new Object[0]);
    }

    public boolean equals(Object r1) {
        if (this != r1) goto L6;
        return true;
    L6:
        return r1 instanceof DefaultTransformer;
    }
}
