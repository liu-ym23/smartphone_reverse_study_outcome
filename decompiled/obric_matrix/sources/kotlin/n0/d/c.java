package kotlin.n0.d;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements kotlin.s0.c, Serializable {
    public static final Object NO_RECEIVER = null;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient kotlin.s0.c reflected;
    private final String signature;

    private static class a implements Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final a f18429f = null;

        static {
            f18429f = new a();
        }

        private a() {
        }

        static /* synthetic */ a a() {
            return f18429f;
        }
    }

    static {
        NO_RECEIVER = a.a();
    }

    public c() {
        this(NO_RECEIVER);
    }

    protected c(Object r7) {
        this(r7, null, null, null, false);
    }

    protected c(Object r1, Class r2, String r3, String r4, boolean r5) {
        this.receiver = r1;
        this.owner = r2;
        this.name = r3;
        this.signature = r4;
        this.isTopLevel = r5;
    }

    @Override // kotlin.s0.c
    public Object call(Object... r1) {
        return getReflected().call(r1);
    }

    @Override // kotlin.s0.c
    public Object callBy(Map r1) {
        return getReflected().callBy(r1);
    }

    public kotlin.s0.c compute() {
        kotlin.s0.c r0 = this.reflected;
        if (r0 != null) goto L6;
        kotlin.s0.c r1 = computeReflected();
        this.reflected = r1;
        return r1;
    L6:
        return r0;
    }

    protected abstract kotlin.s0.c computeReflected();

    @Override // kotlin.s0.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.s0.c
    public String getName() {
        return this.name;
    }

    public kotlin.s0.f getOwner() {
        Class r0 = this.owner;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.isTopLevel == false) goto L9;
        return e0.c(r0);
    L9:
        return e0.b(r0);
    }

    @Override // kotlin.s0.c
    public List<kotlin.s0.i> getParameters() {
        return getReflected().getParameters();
    }

    protected kotlin.s0.c getReflected() {
        kotlin.s0.c r0 = compute();
        if (r0 == this) goto L6;
        return r0;
    L6:
        throw new kotlin.n0.b();
    }

    @Override // kotlin.s0.c
    public kotlin.s0.m getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // kotlin.s0.c
    public List<kotlin.s0.n> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.s0.c
    public kotlin.s0.q getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.s0.c
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.s0.c
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.s0.c
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.s0.c
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
