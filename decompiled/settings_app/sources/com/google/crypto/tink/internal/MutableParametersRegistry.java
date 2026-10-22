package com.google.crypto.tink.internal;

import com.google.crypto.tink.Parameters;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class MutableParametersRegistry {
    private static final MutableParametersRegistry globalInstance = null;
    private final Map<String, Parameters> parametersMap;

    MutableParametersRegistry() {
        this.parametersMap = new HashMap();
    }

    static {
        globalInstance = new MutableParametersRegistry();
    }

    public static MutableParametersRegistry globalInstance() {
        return globalInstance;
    }

    public synchronized void put(String name, Parameters value) throws GeneralSecurityException {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.parametersMap.containsKey(name) == true) goto L7;
        this.parametersMap.put(name, value);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L7:
        if (this.parametersMap.get(name).equals(value) == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        throw new GeneralSecurityException("Parameters object with name " + name + " already exists (" + this.parametersMap.get(name) + "), cannot insert " + value);     // Catch: Throwable -> L15
    }

    public synchronized Parameters get(String name) throws GeneralSecurityException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.parametersMap.containsKey(name) == false) goto L10;
        Parameters r4 = this.parametersMap.get(name);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L10:
        throw new GeneralSecurityException("Name " + name + " does not exist");     // Catch: Throwable -> L11
    }

    public synchronized void putAll(Map<String, Parameters> values) throws GeneralSecurityException {
        monitor-enter(this);
        Iterator<Map.Entry<String, Parameters>> r3 = values.entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r3.hasNext() == false) goto L8;
        Map.Entry<String, Parameters> r0 = r3.next();     // Catch: Throwable -> L10
        put(r0.getKey(), r0.getValue());     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized List<String> getNames() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L6
        r0.addAll(this.parametersMap.keySet());     // Catch: Throwable -> L6
        List<String> r1 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }
}
