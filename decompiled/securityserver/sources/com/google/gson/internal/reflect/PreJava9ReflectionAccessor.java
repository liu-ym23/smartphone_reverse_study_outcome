package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes.dex */
final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    public PreJava9ReflectionAccessor() {
    }

    @Override // com.google.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject r1) {
        r1.setAccessible(true);
    }
}
