package kotlin.n0.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends c implements kotlin.s0.l {
    public z() {
    }

    public z(Object r8, Class r9, String r10, String r11, int r12) {
        boolean r0 = true;
        if ((r12 & 1) == 1) goto L6;
        r0 = false;
    L6:
        super(r8, r9, r10, r11, r0);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == false) goto L19;
        z r6 = (z) r5;
        if (getOwner().equals(r6.getOwner()) == false) goto L17;
        if (getName().equals(r6.getName()) == false) goto L17;
        if (getSignature().equals(r6.getSignature()) == false) goto L17;
        if (o.a(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        if ((r5 instanceof kotlin.s0.l) == true) goto L21;
        return false;
    L21:
        return r5.equals(compute());
    }

    @Override // kotlin.n0.d.c
    protected /* bridge */ /* synthetic */ kotlin.s0.c getReflected() {
        return m();
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    protected kotlin.s0.l m() {
        return (kotlin.s0.l) super.getReflected();
    }

    public String toString() {
        kotlin.s0.c r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
