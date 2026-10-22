package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CallableReference implements KCallable, Serializable {

    @SinceKotlin
    public static final Object NO_RECEIVER = null;

    @SinceKotlin
    private final boolean isTopLevel;

    @SinceKotlin
    private final String name;

    @SinceKotlin
    private final Class owner;

    @SinceKotlin
    protected final Object receiver;
    private transient KCallable reflected;

    @SinceKotlin
    private final String signature;

    @SinceKotlin
    public static class NoReceiver implements Serializable {
        public static final NoReceiver b = null;

        static {
            b = new NoReceiver();
        }
    }

    static {
        NO_RECEIVER = NoReceiver.b;
    }

    public CallableReference(Object r1, Class r2, String r3, String r4, boolean r5) {
        this.receiver = r1;
        this.owner = r2;
        this.name = r3;
        this.signature = r4;
        this.isTopLevel = r5;
    }

    @Override // kotlin.reflect.KCallable
    public Object call(Object... r1) {
        return getReflected().call(r1);
    }

    @Override // kotlin.reflect.KCallable
    public Object callBy(Map r1) {
        return getReflected().callBy(r1);
    }

    @SinceKotlin
    public KCallable compute() {
        KCallable r0 = this.reflected;
        if (r0 != null) goto L6;
        KCallable r1 = computeReflected();
        this.reflected = r1;
        return r1;
    L6:
        return r0;
    }

    public abstract KCallable computeReflected();

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @SinceKotlin
    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public KDeclarationContainer getOwner() {
        Class r0 = this.owner;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.isTopLevel == false) goto L9;
        Reflection.f343a.getClass();
        return new PackageReference(r0);
    L9:
        return Reflection.a(r0);
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    public KCallable getReflected() {
        KCallable r0 = compute();
        if (r0 == this) goto L6;
        return r0;
    L6:
        throw new KotlinReflectionNotSupportedError("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin
    public List<KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.KCallable
    @SinceKotlin
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
