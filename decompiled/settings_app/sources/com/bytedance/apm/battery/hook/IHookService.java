package com.bytedance.apm.battery.hook;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public interface IHookService {
    String getInterfaceName();

    void invoke(Object r1, Method r2, Object[] r3);
}
