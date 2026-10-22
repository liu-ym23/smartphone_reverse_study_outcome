package org.apache.commons.math3.ode;

import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public interface Parameterizable {
    Collection<String> getParametersNames();

    boolean isSupported(String r1);
}
