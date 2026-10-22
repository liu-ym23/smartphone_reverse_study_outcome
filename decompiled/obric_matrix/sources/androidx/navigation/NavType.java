package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.bytedance.common.wschannel.WsConstants;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u0019\u001a\u001b\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH¦\u0002¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType;", "T", "", "isNullableAllowed", "", "(Z)V", "()Z", "name", "", "getName", "()Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "parseAndPut", "value", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "toString", "Companion", "EnumType", "ParcelableArrayType", "ParcelableType", "SerializableArrayType", "SerializableType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NavType<T> {
    public static final NavType<boolean[]> BoolArrayType = null;
    public static final NavType<Boolean> BoolType = null;
    public static final Companion Companion = null;
    public static final NavType<float[]> FloatArrayType = null;
    public static final NavType<Float> FloatType = null;
    public static final NavType<int[]> IntArrayType = null;
    public static final NavType<Integer> IntType = null;
    public static final NavType<long[]> LongArrayType = null;
    public static final NavType<Long> LongType = null;
    public static final NavType<Integer> ReferenceType = null;
    public static final NavType<String[]> StringArrayType = null;
    public static final NavType<String> StringType = null;
    private final boolean isNullableAllowed;
    private final String name;

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0017J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType$Companion;", "", "()V", "BoolArrayType", "Landroidx/navigation/NavType;", "", "BoolType", "", "FloatArrayType", "", "FloatType", "", "IntArrayType", "", "IntType", "", "LongArrayType", "", "LongType", "", "ReferenceType", "StringArrayType", "", "", "StringType", "fromArgType", WsConstants.KEY_CONNECTION_TYPE, "packageName", "inferFromValue", "value", "inferFromValueType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public NavType<?> fromArgType(String r4, String r5) {
            NavType<Integer> r3 = NavType.IntType;
            if (o.a(r3.getName(), r4) == false) goto L5;
            return r3;
        L5:
            NavType r6 = NavType.IntArrayType;
            if (o.a(r6.getName(), r4) == false) goto L8;
            return r6;
        L8:
            NavType<Long> r7 = NavType.LongType;
            if (o.a(r7.getName(), r4) == false) goto L11;
            return r7;
        L11:
            NavType r8 = NavType.LongArrayType;
            if (o.a(r8.getName(), r4) == false) goto L14;
            return r8;
        L14:
            NavType<Boolean> r9 = NavType.BoolType;
            if (o.a(r9.getName(), r4) == false) goto L17;
            return r9;
        L17:
            NavType r10 = NavType.BoolArrayType;
            if (o.a(r10.getName(), r4) == false) goto L20;
            return r10;
        L20:
            NavType<String> r11 = NavType.StringType;
            if (o.a(r11.getName(), r4) == false) goto L23;
            return r11;
        L23:
            NavType r0 = NavType.StringArrayType;
            if (o.a(r0.getName(), r4) == false) goto L26;
            return r0;
        L26:
            NavType<Float> r1 = NavType.FloatType;
            if (o.a(r1.getName(), r4) == false) goto L29;
            return r1;
        L29:
            NavType r2 = NavType.FloatArrayType;
            if (o.a(r2.getName(), r4) == false) goto L32;
            return r2;
        L32:
            NavType<Integer> r12 = NavType.ReferenceType;
            if (o.a(r12.getName(), r4) == false) goto L36;
            return r12;
        L36:
            if (r4 != null) goto L38;
        L41:
            boolean r13 = true;
        L42:
            if (r13 == false) goto L97;
            return r11;
        L97:
        L93:
            e = move-exception;
            throw new RuntimeException(e);
        L44:
            if (k.A(r4, ".", false, 2, null) == false) goto L47;
            if (r5 == null) goto L47;
            String r14 = r5 + r4;     // Catch: ClassNotFoundException -> L93
        L50:
            if (k.n(r4, "[]", false, 2, null) == false) goto L67;
            r14 = r14.substring(0, r14.length() - 2);     // Catch: ClassNotFoundException -> L93
            o.e(r14, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: ClassNotFoundException -> L93
            Class<?> r15 = Class.forName(r14);     // Catch: ClassNotFoundException -> L93
            if (Parcelable.class.isAssignableFrom(r15) == false) goto L60;
            if (r15 == null) goto L58;
            return new ParcelableArrayType(r15);
        L58:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");     // Catch: ClassNotFoundException -> L93
        L60:
            if (Serializable.class.isAssignableFrom(r15) == false) goto L92;
            if (r15 == null) goto L66;
            return new SerializableArrayType(r15);
        L66:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");     // Catch: ClassNotFoundException -> L93
        L92:
            throw new IllegalArgumentException(r14 + " is not Serializable or Parcelable.");     // Catch: ClassNotFoundException -> L93
        L67:
            Class<?> r16 = Class.forName(r14);     // Catch: ClassNotFoundException -> L93
            if (Parcelable.class.isAssignableFrom(r16) == false) goto L76;
            if (r16 == null) goto L74;
            return new ParcelableType(r16);
        L74:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Any?>");     // Catch: ClassNotFoundException -> L93
        L76:
            if (Enum.class.isAssignableFrom(r16) == false) goto L84;
            if (r16 == null) goto L82;
            return new EnumType(r16);
        L82:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>>");     // Catch: ClassNotFoundException -> L93
        L84:
            if (Serializable.class.isAssignableFrom(r16) == false) goto L92;
            if (r16 == null) goto L90;
            return new SerializableType(r16);
        L90:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");     // Catch: ClassNotFoundException -> L93
        L47:
            r14 = r4;
            goto L50
        L38:
            if (r4.length() == 0) goto L41;
            r13 = false;
            goto L42
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final NavType<Object> inferFromValue(String r1) {
            o.f(r1, "value");
            NavType<Integer> r0 = NavType.IntType;     // Catch: IllegalArgumentException -> L5
            r0.parseValue(r1);     // Catch: IllegalArgumentException -> L5
            return r0;
        L5:
            NavType<Long> r2 = NavType.LongType;     // Catch: IllegalArgumentException -> L7
            r2.parseValue(r1);     // Catch: IllegalArgumentException -> L7
            return r2;
        L7:
            NavType<Float> r3 = NavType.FloatType;     // Catch: IllegalArgumentException -> L9
            r3.parseValue(r1);     // Catch: IllegalArgumentException -> L9
            return r3;
        L9:
            NavType<Boolean> r4 = NavType.BoolType;     // Catch: IllegalArgumentException -> L11
            r4.parseValue(r1);     // Catch: IllegalArgumentException -> L11
            return r4;
        L12:
            return NavType.StringType;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final NavType<Object> inferFromValueType(Object r3) {
            if ((r3 instanceof Integer) == false) goto L6;
            return NavType.IntType;
        L6:
            if ((r3 instanceof int[]) == false) goto L9;
            return NavType.IntArrayType;
        L9:
            if ((r3 instanceof Long) == false) goto L12;
            return NavType.LongType;
        L12:
            if ((r3 instanceof long[]) == false) goto L15;
            return NavType.LongArrayType;
        L15:
            if ((r3 instanceof Float) == false) goto L18;
            return NavType.FloatType;
        L18:
            if ((r3 instanceof float[]) == false) goto L21;
            return NavType.FloatArrayType;
        L21:
            if ((r3 instanceof Boolean) == false) goto L24;
            return NavType.BoolType;
        L24:
            if ((r3 instanceof boolean[]) == false) goto L27;
            return NavType.BoolArrayType;
        L27:
            if ((r3 instanceof String) == true) goto L57;
            if (r3 == null) goto L57;
            if ((r3 instanceof Object[]) == false) goto L36;
            if ((((Object[]) r3) instanceof String[]) == false) goto L36;
            return NavType.StringArrayType;
        L36:
            if (r3.getClass().isArray() == false) goto L41;
            Class<?> r0 = r3.getClass().getComponentType();
            o.c(r0);
            if (Parcelable.class.isAssignableFrom(r0) == false) goto L41;
            Class<?> r4 = r3.getClass().getComponentType();
            Objects.requireNonNull(r4, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
            return new ParcelableArrayType(r4);
        L41:
            if (r3.getClass().isArray() == false) goto L46;
            Class<?> r1 = r3.getClass().getComponentType();
            o.c(r1);
            if (Serializable.class.isAssignableFrom(r1) == false) goto L46;
            Class<?> r5 = r3.getClass().getComponentType();
            Objects.requireNonNull(r5, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
            return new SerializableArrayType(r5);
        L46:
            if ((r3 instanceof Parcelable) == false) goto L49;
            return new ParcelableType(r3.getClass());
        L49:
            if ((r3 instanceof Enum) == false) goto L52;
            return new EnumType(r3.getClass());
        L52:
            if ((r3 instanceof Serializable) == false) goto L55;
            return new SerializableType(r3.getClass());
        L55:
            throw new IllegalArgumentException("Object of type " + r3.getClass().getName() + " is not supported for navigation arguments.");
        L57:
            return NavType.StringType;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\f\b\u0001\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavType$EnumType;", "D", "", "Landroidx/navigation/NavType$SerializableType;", WsConstants.KEY_CONNECTION_TYPE, "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Enum;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {
        private final Class<D> type;

        public EnumType(Class<D> r2) {
            o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
            super(false, r2);
            if (r2.isEnum() == false) goto L7;
            this.type = r2;
            return;
        L7:
            throw new IllegalArgumentException((r2 + " is not an Enum type.").toString());
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public String getName() {
            String r1 = this.type.getName();
            o.e(r1, "type.name");
            return r1;
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Serializable parseValue(String r1) {
            return parseValue(r1);
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public D parseValue(String r7) {
            o.f(r7, "value");
            D[] r0 = this.type.getEnumConstants();
            o.e(r0, "type.enumConstants");
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            D r3 = r0[r2];
            if (k.o(r3.name(), r7, true) == true) goto L9;
            r2 = r2 + 1;
        L9:
            D r4 = r3;
            if (r4 == null) goto L13;
            return r4;
        L13:
            throw new IllegalArgumentException("Enum value " + r7 + " not found for type " + this.type.getName() + '.');
        L8:
            r3 = null;
            goto L9
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object parseValue(String r1) {
            return parseValue(r1);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$ParcelableArrayType;", "D", "Landroid/os/Parcelable;", "Landroidx/navigation/NavType;", "", WsConstants.KEY_CONNECTION_TYPE, "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Landroid/os/Parcelable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        public ParcelableArrayType(Class<D> r3) {
            o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
            super(true);
            if (Parcelable.class.isAssignableFrom(r3) == false) goto L14;
            Class<D[]> r4 = (Class<D[]>) Class.forName("[L" + r3.getName() + ';');
            if (r4 == null) goto L9;
            this.arrayType = r4;
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");     // Catch: ClassNotFoundException -> L10
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L14:
            throw new IllegalArgumentException((r3 + " does not implement Parcelable.").toString());
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (o.a(ParcelableArrayType.class, r3.getClass()) == true) goto L10;
            return false;
        L10:
            return o.a(this.arrayType, ((ParcelableArrayType) r3).arrayType);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object get(Bundle r1, String r2) {
            return get(r1, r2);
        }

        @Override // androidx.navigation.NavType
        public D[] get(Bundle r1, String r2) {
            o.f(r1, "bundle");
            o.f(r2, "key");
            return (D[]) ((Parcelable[]) r1.get(r2));
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            String r1 = this.arrayType.getName();
            o.e(r1, "arrayType.name");
            return r1;
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object parseValue(String r1) {
            return parseValue(r1);
        }

        @Override // androidx.navigation.NavType
        public D[] parseValue(String r1) {
            o.f(r1, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle r1, String r2, Object r3) {
            put(r1, r2, (Parcelable[]) r3);
        }

        public void put(Bundle r2, String r3, D[] r4) {
            o.f(r2, "bundle");
            o.f(r3, "key");
            this.arrayType.cast(r4);
            r2.putParcelableArray(r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J \u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0015\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavType$ParcelableType;", "D", "Landroidx/navigation/NavType;", WsConstants.KEY_CONNECTION_TYPE, "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParcelableType<D> extends NavType<D> {
        private final Class<D> type;

        public ParcelableType(Class<D> r3) {
            o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
            boolean r0 = true;
            super(true);
            if (Parcelable.class.isAssignableFrom(r3) == false) goto L5;
        L8:
            if (r0 == false) goto L12;
            this.type = r3;
            return;
        L12:
            throw new IllegalArgumentException((r3 + " does not implement Parcelable or Serializable.").toString());
        L5:
            if (Serializable.class.isAssignableFrom(r3) == true) goto L8;
            r0 = false;
            goto L8
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (o.a(ParcelableType.class, r3.getClass()) == true) goto L10;
            return false;
        L10:
            return o.a(this.type, ((ParcelableType) r3).type);
        }

        @Override // androidx.navigation.NavType
        public D get(Bundle r1, String r2) {
            o.f(r1, "bundle");
            o.f(r2, "key");
            return (D) r1.get(r2);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            String r1 = this.type.getName();
            o.e(r1, "type.name");
            return r1;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        public D parseValue(String r1) {
            o.f(r1, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public void put(Bundle r2, String r3, D r4) {
            o.f(r2, "bundle");
            o.f(r3, "key");
            this.type.cast(r4);
            if (r4 != null) goto L5;
        L10:
            r2.putParcelable(r3, (Parcelable) r4);
            return;
        L5:
            if ((r4 instanceof Parcelable) == true) goto L10;
            if ((r4 instanceof Serializable) == false) goto L12;
            r2.putSerializable(r3, (Serializable) r4);
            return;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$SerializableArrayType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "", WsConstants.KEY_CONNECTION_TYPE, "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        public SerializableArrayType(Class<D> r3) {
            o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
            super(true);
            if (Serializable.class.isAssignableFrom(r3) == false) goto L14;
            Class<D[]> r4 = (Class<D[]>) Class.forName("[L" + r3.getName() + ';');
            if (r4 == null) goto L9;
            this.arrayType = r4;
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");     // Catch: ClassNotFoundException -> L10
        L10:
            e = move-exception;
            throw new RuntimeException(e);
        L14:
            throw new IllegalArgumentException((r3 + " does not implement Serializable.").toString());
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (o.a(SerializableArrayType.class, r3.getClass()) == true) goto L10;
            return false;
        L10:
            return o.a(this.arrayType, ((SerializableArrayType) r3).arrayType);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object get(Bundle r1, String r2) {
            return get(r1, r2);
        }

        @Override // androidx.navigation.NavType
        public D[] get(Bundle r1, String r2) {
            o.f(r1, "bundle");
            o.f(r2, "key");
            return (D[]) ((Serializable[]) r1.get(r2));
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            String r1 = this.arrayType.getName();
            o.e(r1, "arrayType.name");
            return r1;
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object parseValue(String r1) {
            return parseValue(r1);
        }

        @Override // androidx.navigation.NavType
        public D[] parseValue(String r1) {
            o.f(r1, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle r1, String r2, Object r3) {
            put(r1, r2, (Serializable[]) r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void put(Bundle r2, String r3, D[] r4) {
            o.f(r2, "bundle");
            o.f(r3, "key");
            this.arrayType.cast(r4);
            r2.putSerializable(r3, (Serializable) r4);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J \u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0015\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$SerializableType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", WsConstants.KEY_CONNECTION_TYPE, "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "nullableAllowed", "", "(ZLjava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        private final Class<D> type;

        public SerializableType(Class<D> r3) {
            o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
            super(true);
            if (Serializable.class.isAssignableFrom(r3) == false) goto L11;
            if ((true ^ r3.isEnum()) == false) goto L9;
            this.type = r3;
            return;
        L9:
            throw new IllegalArgumentException((r3 + " is an Enum. You should use EnumType instead.").toString());
        L11:
            throw new IllegalArgumentException((r3 + " does not implement Serializable.").toString());
        }

        public SerializableType(boolean r2, Class<D> r3) {
            o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
            super(r2);
            if (Serializable.class.isAssignableFrom(r3) == false) goto L7;
            this.type = r3;
            return;
        L7:
            throw new IllegalArgumentException((r3 + " does not implement Serializable.").toString());
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof SerializableType) == true) goto L10;
            return false;
        L10:
            return o.a(this.type, ((SerializableType) r2).type);
        }

        @Override // androidx.navigation.NavType
        public D get(Bundle r1, String r2) {
            o.f(r1, "bundle");
            o.f(r2, "key");
            return (D) r1.get(r2);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object get(Bundle r1, String r2) {
            return get(r1, r2);
        }

        @Override // androidx.navigation.NavType
        public String getName() {
            String r1 = this.type.getName();
            o.e(r1, "type.name");
            return r1;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @Override // androidx.navigation.NavType
        public D parseValue(String r1) {
            o.f(r1, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ Object parseValue(String r1) {
            return parseValue(r1);
        }

        public void put(Bundle r2, String r3, D r4) {
            o.f(r2, "bundle");
            o.f(r3, "key");
            o.f(r4, "value");
            this.type.cast(r4);
            r2.putSerializable(r3, r4);
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void put(Bundle r1, String r2, Object r3) {
            put(r1, r2, (Serializable) r3);
        }
    }

    static {
        Companion = new Companion(null);
        IntType = new NavType$Companion$IntType$1();
        ReferenceType = new NavType$Companion$ReferenceType$1();
        IntArrayType = new NavType$Companion$IntArrayType$1();
        LongType = new NavType$Companion$LongType$1();
        LongArrayType = new NavType$Companion$LongArrayType$1();
        FloatType = new NavType$Companion$FloatType$1();
        FloatArrayType = new NavType$Companion$FloatArrayType$1();
        BoolType = new NavType$Companion$BoolType$1();
        BoolArrayType = new NavType$Companion$BoolArrayType$1();
        StringType = new NavType$Companion$StringType$1();
        StringArrayType = new NavType$Companion$StringArrayType$1();
    }

    public NavType(boolean r1) {
        this.isNullableAllowed = r1;
        this.name = "nav_type";
    }

    public static NavType<?> fromArgType(String r1, String r2) {
        return Companion.fromArgType(r1, r2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final NavType<Object> inferFromValue(String r1) {
        return Companion.inferFromValue(r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final NavType<Object> inferFromValueType(Object r1) {
        return Companion.inferFromValueType(r1);
    }

    public abstract T get(Bundle r1, String r2);

    public String getName() {
        return this.name;
    }

    public boolean isNullableAllowed() {
        return this.isNullableAllowed;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final T parseAndPut(Bundle r2, String r3, String r4) {
        o.f(r2, "bundle");
        o.f(r3, "key");
        o.f(r4, "value");
        T r5 = parseValue(r4);
        put(r2, r3, r5);
        return r5;
    }

    public abstract T parseValue(String r1);

    public abstract void put(Bundle r1, String r2, T r3);

    public String toString() {
        return getName();
    }
}
