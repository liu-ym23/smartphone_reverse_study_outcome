package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class ReflectionHelper {
    private static final RecordHelper RECORD_HELPER = null;

    /* JADX INFO: renamed from: com.google.gson.internal.reflect.ReflectionHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class RecordHelper {
        public abstract Method getAccessor(Class<?> r1, Field r2);

        abstract <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r1);

        abstract String[] getRecordComponentNames(Class<?> r1);

        abstract boolean isRecord(Class<?> r1);

        private RecordHelper() {
        }

        /* synthetic */ RecordHelper(AnonymousClass1 r1) {
            this();
        }
    }

    private static class RecordNotSupportedHelper extends RecordHelper {
        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        boolean isRecord(Class<?> r1) {
            return false;
        }

        private RecordNotSupportedHelper() {
            super(null);
        }

        /* synthetic */ RecordNotSupportedHelper(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        String[] getRecordComponentNames(Class<?> r1) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r1) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method getAccessor(Class<?> r1, Field r2) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }
    }

    private static class RecordSupportedHelper extends RecordHelper {
        private final Method getName;
        private final Method getRecordComponents;
        private final Method getType;
        private final Method isRecord;

        /* synthetic */ RecordSupportedHelper(AnonymousClass1 r1) throws NoSuchMethodException {
            this();
        }

        private RecordSupportedHelper() throws NoSuchMethodException {
            super(null);
            this.isRecord = Class.class.getMethod("isRecord", new Class[0]);
            Method r0 = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.getRecordComponents = r0;
            Class<?> r1 = r0.getReturnType().getComponentType();
            this.getName = r1.getMethod("getName", new Class[0]);
            this.getType = r1.getMethod("getType", new Class[0]);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        boolean isRecord(Class<?> r2) {
            return ((Boolean) this.isRecord.invoke(r2, new Object[0])).booleanValue();
        L4:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        String[] getRecordComponentNames(Class<?> r7) {
            Object[] r8 = (Object[]) this.getRecordComponents.invoke(r7, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            String[] r0 = new String[r8.length];     // Catch: ReflectiveOperationException -> L8
            int r2 = 0;
        L4:
            if (r2 >= r8.length) goto L7;
            r0[r2] = (String) this.getName.invoke(r8[r2], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r2 = r2 + 1;
            goto L4
        L7:
            return r0;
        L8:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r8) {
            Object[] r0 = (Object[]) this.getRecordComponents.invoke(r8, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            Class<?>[] r2 = new Class[r0.length];     // Catch: ReflectiveOperationException -> L8
            int r3 = 0;
        L4:
            if (r3 >= r0.length) goto L6;
            r2[r3] = (Class) this.getType.invoke(r0[r3], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r3 = r3 + 1;     // Catch: ReflectiveOperationException -> L8
            goto L4
        L6:
            return r8.getDeclaredConstructor(r2);
        L8:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method getAccessor(Class<?> r1, Field r2) {
            return r1.getMethod(r2.getName(), new Class[0]);
        L4:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }
    }

    static /* synthetic */ RuntimeException access$300(ReflectiveOperationException r0) {
        return createExceptionForRecordReflectionException(r0);
    }

    static {
        AnonymousClass1 r0 = null;
        RecordHelper r1 = new RecordSupportedHelper(r0);     // Catch: NoSuchMethodException -> L5
    L6:
        RECORD_HELPER = r1;
        return;
    L5:
        r1 = new RecordNotSupportedHelper(r0);
        goto L6
    }

    private ReflectionHelper() {
    }

    public static void makeAccessible(AccessibleObject r4) throws JsonIOException {
        r4.setAccessible(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new JsonIOException("Failed making " + getAccessibleObjectDescription(r4, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e);
    }

    public static String getAccessibleObjectDescription(AccessibleObject r4, boolean r5) {
        if ((r4 instanceof Field) == false) goto L6;
        String r6 = "field '" + fieldToString((Field) r4) + "'";
    L12:
        if (r5 == true) goto L14;
        return r6;
    L14:
        if (Character.isLowerCase(r6.charAt(0)) == true) goto L16;
        return r6;
    L16:
        return Character.toUpperCase(r6.charAt(0)) + r6.substring(1);
    L6:
        if ((r4 instanceof Method) == false) goto L9;
        Method r7 = (Method) r4;
        StringBuilder r0 = new StringBuilder(r7.getName());
        appendExecutableParameters(r7, r0);
        r6 = "method '" + r7.getDeclaringClass().getName() + "#" + r0.toString() + "'";
        goto L12
    L9:
        if ((r4 instanceof Constructor) == false) goto L11;
        r6 = "constructor '" + constructorToString((Constructor) r4) + "'";
        goto L12
    L11:
        r6 = "<unknown AccessibleObject> " + r4.toString();
        goto L12
    }

    public static String fieldToString(Field r2) {
        return r2.getDeclaringClass().getName() + "#" + r2.getName();
    }

    public static String constructorToString(Constructor<?> r2) {
        StringBuilder r0 = new StringBuilder(r2.getDeclaringClass().getName());
        appendExecutableParameters(r2, r0);
        return r0.toString();
    }

    private static void appendExecutableParameters(AccessibleObject r2, StringBuilder r3) {
        r3.append('(');
        if ((r2 instanceof Method) == false) goto L5;
        Class<?>[] r4 = ((Method) r2).getParameterTypes();
    L6:
        int r0 = 0;
    L8:
        if (r0 >= r4.length) goto L12;
        if (r0 <= 0) goto L11;
        r3.append(", ");
    L11:
        r3.append(r4[r0].getSimpleName());
        r0 = r0 + 1;
        goto L8
    L12:
        r3.append(')');
        return;
    L5:
        r4 = ((Constructor) r2).getParameterTypes();
        goto L6
    }

    public static String tryMakeAccessible(Constructor<?> r3) {
        r3.setAccessible(true);     // Catch: Exception -> L6
        return null;
    L6:
        e = move-exception;
        return "Failed making constructor '" + constructorToString(r3) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
    }

    public static boolean isRecord(Class<?> r1) {
        return RECORD_HELPER.isRecord(r1);
    }

    public static String[] getRecordComponentNames(Class<?> r1) {
        return RECORD_HELPER.getRecordComponentNames(r1);
    }

    public static Method getAccessor(Class<?> r1, Field r2) {
        return RECORD_HELPER.getAccessor(r1, r2);
    }

    public static <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r1) {
        return RECORD_HELPER.getCanonicalRecordConstructor(r1);
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException r2) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", r2);
    }

    private static RuntimeException createExceptionForRecordReflectionException(ReflectiveOperationException r2) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", r2);
    }
}
