package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes4.dex */
public class WrappedClassLoader extends ClassLoader {
    private ClassLoader mPrimaryClassLoader;
    private ClassLoader mSecondaryClassLoader;

    @Override // java.lang.ClassLoader
    public String findLibrary(String r1) {
        return null;
    }

    public WrappedClassLoader(ClassLoader r1, ClassLoader r2) {
        this.mPrimaryClassLoader = r1;
        this.mSecondaryClassLoader = r2;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String r2) throws ClassNotFoundException {
        return this.mPrimaryClassLoader.loadClass(r2);
    L5:
        return this.mSecondaryClassLoader.loadClass(r2);
    }
}
