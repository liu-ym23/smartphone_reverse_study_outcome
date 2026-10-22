package kotlin.n0.d;

/* JADX INFO: loaded from: classes2.dex */
public class l extends c implements k, kotlin.s0.g {
    private final int arity;
    private final int flags;

    public l(int r8) {
        this(r8, c.NO_RECEIVER, null, null, null, 0);
    }

    public l(int r8, Object r9) {
        this(r8, r9, null, null, null, 0);
    }

    public l(int r9, Object r10, Class r11, String r12, String r13, int r14) {
        if ((r14 & 1) != 1) goto L5;
        boolean r7 = true;
    L6:
        super(r10, r11, r12, r13, r7);
        this.arity = r9;
        this.flags = r14 >> 1;
        return;
    L5:
        r7 = false;
        goto L6
    }

    @Override // kotlin.n0.d.c
    protected kotlin.s0.c computeReflected() {
        return e0.a(this);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == false) goto L23;
        l r6 = (l) r5;
        if (getName().equals(r6.getName()) == false) goto L21;
        if (getSignature().equals(r6.getSignature()) == false) goto L21;
        if (this.flags != r6.flags) goto L21;
        if (this.arity != r6.arity) goto L21;
        if (o.a(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L21;
        if (o.a(getOwner(), r6.getOwner()) == false) goto L21;
        return true;
    L21:
        return false;
    L23:
        if ((r5 instanceof kotlin.s0.g) == true) goto L25;
        return false;
    L25:
        return r5.equals(compute());
    }

    @Override // kotlin.n0.d.k
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.n0.d.c
    protected /* bridge */ /* synthetic */ kotlin.s0.c getReflected() {
        return getReflected();
    }

    @Override // kotlin.n0.d.c
    protected kotlin.s0.g getReflected() {
        return (kotlin.s0.g) super.getReflected();
    }

    public int hashCode() {
        if (getOwner() != null) goto L5;
        int r0 = 0;
    L7:
        return ((r0 + getName().hashCode()) * 31) + getSignature().hashCode();
    L5:
        r0 = getOwner().hashCode() * 31;
        goto L7
    }

    @Override // kotlin.s0.g
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.s0.g
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.s0.g
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.s0.g
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.n0.d.c, kotlin.s0.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        kotlin.s0.c r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        if ("<init>".equals(getName()) == false) goto L10;
        return "constructor (Kotlin reflection is not available)";
    L10:
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
