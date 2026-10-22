package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof PropertyReference) == false) goto L19;
        PropertyReference r6 = (PropertyReference) r5;
        if (getOwner().equals(r6.getOwner()) == false) goto L17;
        if (getName().equals(r6.getName()) == false) goto L17;
        if (getSignature().equals(r6.getSignature()) == false) goto L17;
        if (Intrinsics.a(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        if ((r5 instanceof KProperty) == true) goto L21;
        return false;
    L21:
        return r5.equals(compute());
    }

    @Override // kotlin.jvm.internal.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public int hashCode() {
        int r0 = getOwner().hashCode() * 31;
        int r1 = (getName().hashCode() + r0) * 31;
        return getSignature().hashCode() + r1;
    }

    @Override // kotlin.reflect.KProperty
    @SinceKotlin
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.KProperty
    @SinceKotlin
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin
    public KProperty getReflected() {
        return (KProperty) super.getReflected();
    }
}
