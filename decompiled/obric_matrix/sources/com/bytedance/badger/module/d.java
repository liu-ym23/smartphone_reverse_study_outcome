package com.bytedance.badger.module;

import java.util.Iterator;
import kotlin.i0.r;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final void a() {
        Iterator r0 = r.j(new BadgerModuleBase[]{new BasicInfoModule(), new BatteryInfoProvider(), new NetworkInfoProvider(), new DeviceFingerprint1Provider(), new DeviceFingerprint2Provider()}).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        BadgerModuleBase r1 = (BadgerModuleBase) r0.next();
        if (com.bytedance.badger.h.a.t.o().contains(r1.getName()) == true) goto L7;
        BadgerModuleRegistry.registerProvider(r1);
        goto L4
    L7:
        com.bytedance.badger.d.g("BadgerModules", "registerModules: " + r1.getName() + " is disabled");
        goto L4
    }
}
