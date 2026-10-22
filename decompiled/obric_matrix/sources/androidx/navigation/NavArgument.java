package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB1\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/navigation/NavArgument;", "", WsConstants.KEY_CONNECTION_TYPE, "Landroidx/navigation/NavType;", "isNullable", "", "defaultValue", "defaultValuePresent", "(Landroidx/navigation/NavType;ZLjava/lang/Object;Z)V", "getDefaultValue", "()Ljava/lang/Object;", "isDefaultValuePresent", "()Z", "getType", "()Landroidx/navigation/NavType;", "equals", "other", "hashCode", "", "putDefaultValue", "", "name", "", "bundle", "Landroid/os/Bundle;", "toString", "verify", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavArgument {
    private final Object defaultValue;
    private final boolean isDefaultValuePresent;
    private final boolean isNullable;
    private final NavType<Object> type;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\r\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u000e0\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavArgument$Builder;", "", "()V", "defaultValue", "defaultValuePresent", "", "isNullable", WsConstants.KEY_CONNECTION_TYPE, "Landroidx/navigation/NavType;", "build", "Landroidx/navigation/NavArgument;", "setDefaultValue", "setIsNullable", "setType", "T", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private Object defaultValue;
        private boolean defaultValuePresent;
        private boolean isNullable;
        private NavType<Object> type;

        public Builder() {
        }

        public final NavArgument build() {
            NavType<Object> r0 = this.type;
            if (r0 != null) goto L6;
            r0 = NavType.Companion.inferFromValueType(this.defaultValue);
        L6:
            return new NavArgument(r0, this.isNullable, this.defaultValue, this.defaultValuePresent);
        }

        public final Builder setDefaultValue(Object r1) {
            this.defaultValue = r1;
            this.defaultValuePresent = true;
            return this;
        }

        public final Builder setIsNullable(boolean r1) {
            this.isNullable = r1;
            return this;
        }

        public final <T> Builder setType(NavType<T> r2) {
            o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
            this.type = r2;
            return this;
        }
    }

    public NavArgument(NavType<Object> r4, boolean r5, Object r6, boolean r7) {
        o.f(r4, WsConstants.KEY_CONNECTION_TYPE);
        boolean r1 = false;
        if (r4.isNullableAllowed() == true) goto L7;
        if (r5 == false) goto L7;
        boolean r0 = false;
    L8:
        if (r0 == false) goto L19;
        if (r5 == true) goto L12;
        if (r7 == false) goto L12;
        if (r6 != null) goto L12;
    L13:
        if (r1 == false) goto L17;
        this.type = r4;
        this.isNullable = r5;
        this.defaultValue = r6;
        this.isDefaultValuePresent = r7;
        return;
    L17:
        throw new IllegalArgumentException(("Argument with type " + r4.getName() + " has null value but is not nullable.").toString());
    L12:
        r1 = true;
        goto L13
    L19:
        throw new IllegalArgumentException((r4.getName() + " does not allow nullable values").toString());
    L7:
        r0 = true;
        goto L8
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L27:
        return false;
    L8:
        if (o.a(NavArgument.class, r5.getClass()) == false) goto L27;
        NavArgument r6 = (NavArgument) r5;
        if (this.isNullable == r6.isNullable) goto L14;
        return false;
    L14:
        if (this.isDefaultValuePresent == r6.isDefaultValuePresent) goto L17;
        return false;
    L17:
        if (o.a(this.type, r6.type) == true) goto L19;
        return false;
    L19:
        Object r4 = this.defaultValue;
        if (r4 == null) goto L23;
        return o.a(r4, r6.defaultValue);
    L23:
        if (r6.defaultValue != null) goto L26;
        return true;
    L26:
        return false;
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final NavType<Object> getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((((this.type.hashCode() * 31) + (this.isNullable ? 1 : 0)) * 31) + (this.isDefaultValuePresent ? 1 : 0)) * 31;
        Object r2 = this.defaultValue;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r0 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final boolean isDefaultValuePresent() {
        return this.isDefaultValuePresent;
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void putDefaultValue(String r2, Bundle r3) {
        o.f(r2, "name");
        o.f(r3, "bundle");
        if (this.isDefaultValuePresent == false) goto L6;
        this.type.put(r3, r2, this.defaultValue);
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(NavArgument.class.getSimpleName());
        r0.append(" Type: " + this.type);
        r0.append(" Nullable: " + this.isNullable);
        if (this.isDefaultValuePresent == false) goto L5;
        r0.append(" DefaultValue: " + this.defaultValue);
    L5:
        String r3 = r0.toString();
        o.e(r3, "sb.toString()");
        return r3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean verify(String r3, Bundle r4) {
        o.f(r3, "name");
        o.f(r4, "bundle");
        if (this.isNullable == false) goto L5;
    L13:
        this.type.get(r4, r3);     // Catch: ClassCastException -> L12
        return true;
    L12:
        return false;
    L5:
        if (r4.containsKey(r3) == false) goto L13;
        if (r4.get(r3) != null) goto L13;
        return false;
    }
}
