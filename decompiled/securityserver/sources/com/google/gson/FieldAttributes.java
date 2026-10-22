package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class FieldAttributes {
    private final Field field;

    public FieldAttributes(Field r1) {
        C$Gson$Preconditions.checkNotNull(r1);
        this.field = r1;
    }

    public Object get(Object r1) {
        return this.field.get(r1);
    }

    public <T extends Annotation> T getAnnotation(Class<T> r1) {
        return (T) this.field.getAnnotation(r1);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }

    public Class<?> getDeclaredClass() {
        return this.field.getType();
    }

    public Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public String getName() {
        return this.field.getName();
    }

    public boolean hasModifier(int r1) {
        if ((this.field.getModifiers() & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}
