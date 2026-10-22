package com.bytedance.frameworks.baselib.network.http.io;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SafeObjectInputStream extends ObjectInputStream {
    private final Set<String> mSafeTypes;

    public SafeObjectInputStream(InputStream r1, Collection<String> r2) {
        super(r1);
        HashSet r3 = new HashSet();
        this.mSafeTypes = r3;
        if (r2 == null) goto L6;
        r3.addAll(r2);
        return;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass r3) {
        if (r3 == null) goto L13;
        if (r3.getName() == null) goto L13;
        String r0 = r3.getName();
        if (this.mSafeTypes.contains(r0) == false) goto L11;
        return super.resolveClass(r3);
    L11:
        return Class.forName(r0, true, ClassLoader.getSystemClassLoader().getParent());
    L13:
        return super.resolveClass(r3);
    }

    public SafeObjectInputStream(InputStream r1, String... r2) {
        super(r1);
        HashSet r3 = new HashSet();
        this.mSafeTypes = r3;
        if (r2 == null) goto L6;
        r3.addAll(Arrays.asList(r2));
        return;
    }

    public SafeObjectInputStream(InputStream r4, Class<?>... r5) {
        super(r4);
        this.mSafeTypes = new HashSet();
        if (r5 == null) goto L7;
        int r6 = r5.length;
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L9;
        Class<?> r1 = r5[r0];
        this.mSafeTypes.add(r1.getName());
        r0 = r0 + 1;
        goto L5
    L9:
        return;
    }
}
