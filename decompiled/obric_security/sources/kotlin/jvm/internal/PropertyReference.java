package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    @Override // kotlin.jvm.internal.CallableReference
    protected /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public PropertyReference() {
    }

    public PropertyReference(Object r1) {
        super(r1);
    }

    public PropertyReference(Object r8, Class r9, String r10, String r11, int r12) {
        boolean r0 = true;
        if ((r12 & 1) == 1) goto L6;
        r0 = false;
    L6:
        super(r8, r9, r10, r11, r0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KProperty getReflected() {
        return (KProperty) super.getReflected();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof PropertyReference) == false) goto L19;
        PropertyReference r6 = (PropertyReference) r5;
        if (getOwner().equals(r6.getOwner()) == false) goto L17;
        if (getName().equals(r6.getName()) == false) goto L17;
        if (getSignature().equals(r6.getSignature()) == false) goto L17;
        if (Intrinsics.areEqual(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        if ((r5 instanceof KProperty) == true) goto L21;
        return false;
    L21:
        return r5.equals(compute());
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        KCallable r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
