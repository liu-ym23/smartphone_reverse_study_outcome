package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes5.dex */
public class ClassLoaderObjectInputStream extends ObjectInputStream {
    private ClassLoader classLoader;

    public ClassLoaderObjectInputStream(ClassLoader r1, InputStream r2) throws IOException, StreamCorruptedException {
        super(r2);
        this.classLoader = r1;
    }

    @Override // java.io.ObjectInputStream
    protected Class resolveClass(ObjectStreamClass r4) throws IOException, ClassNotFoundException {
        Class<?> r0 = Class.forName(r4.getName(), false, this.classLoader);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.resolveClass(r4);
    }
}
