package org.apache.commons.math3.geometry;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;

/* JADX INFO: loaded from: classes6.dex */
public interface Space extends Serializable {
    int getDimension();

    Space getSubSpace() throws MathUnsupportedOperationException;
}
