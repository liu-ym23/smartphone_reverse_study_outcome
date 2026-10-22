package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractParameterizable implements Parameterizable {
    private final Collection<String> parametersNames;

    protected AbstractParameterizable(String... r5) {
        this.parametersNames = new ArrayList();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = r5[r1];
        this.parametersNames.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    protected AbstractParameterizable(Collection<String> r2) {
        ArrayList r0 = new ArrayList();
        this.parametersNames = r0;
        r0.addAll(r2);
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public Collection<String> getParametersNames() {
        return this.parametersNames;
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public boolean isSupported(String r2) {
        Iterator<String> r1 = this.parametersNames.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().equals(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void complainIfNotSupported(String r1) throws UnknownParameterException {
        if (isSupported(r1) == false) goto L6;
        return;
    L6:
        throw new UnknownParameterException(r1);
    }
}
