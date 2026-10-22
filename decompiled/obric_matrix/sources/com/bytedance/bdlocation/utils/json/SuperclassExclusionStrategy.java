package com.bytedance.bdlocation.utils.json;

import com.google.gson.a;
import com.google.gson.b;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class SuperclassExclusionStrategy implements a {
    public SuperclassExclusionStrategy() {
    }

    private Field getField(Class<?> r1, String r2) {
        return r1.getDeclaredField(r2);
    L4:
        return null;
    }

    private boolean isFieldInSuperclass(Class<?> r2, String r3) {
    L2:
        r2 = r2.getSuperclass();
        if (r2 == null) goto L8;
        if (getField(r2, r3) == null) goto L2;
        return true;
    L8:
        return false;
    }

    @Override // com.google.gson.a
    public boolean shouldSkipClass(Class<?> r1) {
        return false;
    }

    @Override // com.google.gson.a
    public boolean shouldSkipField(b r2) {
        String r0 = r2.b();
        return isFieldInSuperclass(r2.a(), r0);
    }
}
