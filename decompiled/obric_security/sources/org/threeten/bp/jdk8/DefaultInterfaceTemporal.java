package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    public DefaultInterfaceTemporal() {
    }

    public Temporal with(TemporalAdjuster r1) {
        return r1.adjustInto(this);
    }

    public Temporal plus(TemporalAmount r1) {
        return r1.addTo(this);
    }

    public Temporal minus(TemporalAmount r1) {
        return r1.subtractFrom(this);
    }

    public Temporal minus(long r3, TemporalUnit r5) {
        if (r3 != Long.MIN_VALUE) goto L6;
        return plus(Long.MAX_VALUE, r5).plus(1, r5);
    L6:
        return plus(-r3, r5);
    }
}
