package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class Invokable<T, R> implements AnnotatedElement, Member {
    private final AccessibleObject accessibleObject;
    private final Member member;

    static class ConstructorInvokable<T> extends Invokable<T, T> {
        final Constructor<?> constructor;

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        ConstructorInvokable(Constructor<?> r1) {
            super(r1);
            this.constructor = r1;
        }

        @Override // com.google.common.reflect.Invokable
        final Object invokeInternal(@CheckForNull Object r3, Object[] r4) throws InvocationTargetException, IllegalAccessException {
            return this.constructor.newInstance(r4);
        L4:
            e = move-exception;
            String r2 = String.valueOf(this.constructor);
            throw new RuntimeException(new StringBuilder(String.valueOf(r2).length() + 8).append(r2).append(" failed.").toString(), e);
        }

        @Override // com.google.common.reflect.Invokable
        Type getGenericReturnType() {
            Class<? super T> r2 = getDeclaringClass();
            TypeVariable<Class<? super T>>[] r0 = r2.getTypeParameters();
            if (r0.length > 0) goto L5;
            return r2;
        L5:
            return Types.newParameterizedType(r2, r0);
        }

        @Override // com.google.common.reflect.Invokable
        Type[] getGenericParameterTypes() {
            Type[] r0 = this.constructor.getGenericParameterTypes();
            if (r0.length > 0) goto L5;
        L12:
            return r0;
        L5:
            if (mayNeedHiddenThis() == false) goto L12;
            Class<?>[] r1 = this.constructor.getParameterTypes();
            if (r0.length != r1.length) goto L12;
            if (r1[0] != getDeclaringClass().getEnclosingClass()) goto L12;
            return (Type[]) Arrays.copyOfRange(r0, 1, r0.length);
        }

        @Override // com.google.common.reflect.Invokable
        AnnotatedType[] getAnnotatedParameterTypes() {
            return this.constructor.getAnnotatedParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public AnnotatedType getAnnotatedReturnType() {
            return this.constructor.getAnnotatedReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] r0 = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] r4 = this.constructor.getTypeParameters();
            TypeVariable<?>[] r1 = new TypeVariable[r0.length + r4.length];
            System.arraycopy(r0, 0, r1, 0, r0.length);
            System.arraycopy(r4, 0, r1, r0.length, r4.length);
            return r1;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }

        private boolean mayNeedHiddenThis() {
            Class<?> r2 = this.constructor.getDeclaringClass();
            if (r2.getEnclosingConstructor() == null) goto L5;
            return true;
        L5:
            Method r0 = r2.getEnclosingMethod();
            if (r0 == null) goto L10;
            return !Modifier.isStatic(r0.getModifiers());
        L10:
            if (r2.getEnclosingClass() != null) goto L12;
        L14:
            return false;
        L12:
            if (Modifier.isStatic(r2.getModifiers()) == true) goto L14;
            return true;
        }
    }

    static class MethodInvokable<T> extends Invokable<T, Object> {
        final Method method;

        MethodInvokable(Method r1) {
            super(r1);
            this.method = r1;
        }

        @Override // com.google.common.reflect.Invokable
        @CheckForNull
        final Object invokeInternal(@CheckForNull Object r1, Object[] r2) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(r1, r2);
        }

        @Override // com.google.common.reflect.Invokable
        Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        AnnotatedType[] getAnnotatedParameterTypes() {
            return this.method.getAnnotatedParameterTypes();
        }

        @Override // com.google.common.reflect.Invokable
        public AnnotatedType getAnnotatedReturnType() {
            return this.method.getAnnotatedReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }

        @Override // com.google.common.reflect.Invokable
        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            if (isFinal() == false) goto L5;
        L11:
            return false;
        L5:
            if (isPrivate() == true) goto L11;
            if (isStatic() == true) goto L11;
            if (Modifier.isFinal(getDeclaringClass().getModifiers()) == true) goto L11;
            return true;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.method.isVarArgs();
        }
    }

    abstract AnnotatedType[] getAnnotatedParameterTypes();

    public abstract AnnotatedType getAnnotatedReturnType();

    abstract Type[] getGenericExceptionTypes();

    abstract Type[] getGenericParameterTypes();

    abstract Type getGenericReturnType();

    abstract Annotation[][] getParameterAnnotations();

    public abstract TypeVariable<?>[] getTypeParameters();

    @CheckForNull
    abstract Object invokeInternal(@CheckForNull Object r1, Object[] r2) throws InvocationTargetException, IllegalAccessException;

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    <M extends AccessibleObject & Member> Invokable(M r1) {
        Preconditions.checkNotNull(r1);
        this.accessibleObject = r1;
        this.member = r1;
    }

    public static Invokable<?, Object> from(Method r1) {
        return new MethodInvokable(r1);
    }

    public static <T> Invokable<T, T> from(Constructor<T> r1) {
        return new ConstructorInvokable(r1);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> r1) {
        return this.accessibleObject.isAnnotationPresent(r1);
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> r1) {
        return (A) this.accessibleObject.getAnnotation(r1);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.accessibleObject.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.accessibleObject.getDeclaredAnnotations();
    }

    public final void setAccessible(boolean r1) {
        this.accessibleObject.setAccessible(r1);
    }

    public final boolean trySetAccessible() {
        this.accessibleObject.setAccessible(true);     // Catch: RuntimeException -> L4
        return true;
    L4:
        return false;
    }

    public final boolean isAccessible() {
        return this.accessibleObject.isAccessible();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.member.getName();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.member.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.member.isSynthetic();
    }

    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean isProtected() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean isPackagePrivate() {
        if (isPrivate() == false) goto L5;
    L9:
        return false;
    L5:
        if (isPublic() == true) goto L9;
        if (isProtected() == true) goto L9;
        return true;
    }

    public final boolean isPrivate() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public final boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean isNative() {
        return Modifier.isNative(getModifiers());
    }

    public final boolean isSynchronized() {
        return Modifier.isSynchronized(getModifiers());
    }

    final boolean isVolatile() {
        return Modifier.isVolatile(getModifiers());
    }

    final boolean isTransient() {
        return Modifier.isTransient(getModifiers());
    }

    public boolean equals(@CheckForNull Object r4) {
        if ((r4 instanceof Invokable) == false) goto L10;
        Invokable r5 = (Invokable) r4;
        if (getOwnerType().equals(r5.getOwnerType()) == true) goto L7;
        return false;
    L7:
        if (this.member.equals(r5.member) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return this.member.hashCode();
    }

    public String toString() {
        return this.member.toString();
    }

    @CheckForNull
    public final R invoke(@CheckForNull T r1, Object... r2) throws InvocationTargetException, IllegalAccessException {
        return (R) invokeInternal(r1, (Object[]) Preconditions.checkNotNull(r2));
    }

    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.of(getGenericReturnType());
    }

    public final ImmutableList<Parameter> getParameters() {
        Type[] r0 = getGenericParameterTypes();
        Annotation[][] r1 = getParameterAnnotations();
        AnnotatedType[] r2 = getAnnotatedParameterTypes();
        ImmutableList.Builder r3 = ImmutableList.builder();
        int r4 = 0;
    L4:
        if (r4 >= r0.length) goto L7;
        int r7 = r4;
        r3.add(new Parameter(this, r7, TypeToken.of(r0[r4]), r1[r4], r2[r4]));
        r4 = r4 + 1;
        goto L4
    L7:
        return r3.build();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder r0 = ImmutableList.builder();
        Type[] r4 = getGenericExceptionTypes();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(TypeToken.of(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.build();
    }

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> r1) {
        return returning(TypeToken.of(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> r4) {
        if (r4.isSupertypeOf(getReturnType()) == false) goto L5;
        return this;
    L5:
        String r3 = String.valueOf(getReturnType());
        String r5 = String.valueOf(r4);
        throw new IllegalArgumentException(new StringBuilder((String.valueOf(r3).length() + 35) + String.valueOf(r5).length()).append("Invokable is known to return ").append(r3).append(", not ").append(r5).toString());
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.member.getDeclaringClass();
    }

    public TypeToken<T> getOwnerType() {
        return TypeToken.of(getDeclaringClass());
    }
}
