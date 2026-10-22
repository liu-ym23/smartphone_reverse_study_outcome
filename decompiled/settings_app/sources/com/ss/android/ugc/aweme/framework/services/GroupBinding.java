package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class GroupBinding<T> {
    Map<Class<?>, Map<String, ServiceProvider<?>>> classProviderMaps;
    String groupName;
    Class<T> klass;
    ServiceProvider<T> serviceProvider;

    /* JADX WARN: Multi-variable type inference failed */
    GroupBinding(Map<Class<?>, Map<String, ServiceProvider<?>>> r1, Class<T> r2, String r3, ServiceProvider<T> r4) {
        this.classProviderMaps = r1;
        this.groupName = r3;
        this.klass = r2;
        this.serviceProvider = r4;
        Map<String, ServiceProvider<?>> r5 = r1.get(r2);
        if (r5 != null) goto L5;
        r5 = Collections.synchronizedMap(new HashMap());
        this.classProviderMaps.put(r2, r5);
    L5:
        r5.put(r3, r4);
    }

    public GroupBinding<T> asSingleton() {
        if ((this.serviceProvider instanceof SingletonProvider) == true) goto L5;
        Map r0 = this.classProviderMaps.get(this.klass);
        r0.remove(this.serviceProvider);
        SingletonProvider r1 = new SingletonProvider(this.serviceProvider);
        this.serviceProvider = r1;
        r0.put(this.groupName, r1);
    L5:
        return this;
    }
}
