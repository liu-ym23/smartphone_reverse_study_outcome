package org.apache.commons.math3.util;

import java.util.EventListener;

/* JADX INFO: loaded from: classes6.dex */
public interface IterationListener extends EventListener {
    void initializationPerformed(IterationEvent r1);

    void iterationPerformed(IterationEvent r1);

    void iterationStarted(IterationEvent r1);

    void terminationPerformed(IterationEvent r1);
}
