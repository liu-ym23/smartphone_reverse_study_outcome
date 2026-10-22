package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        Reflection.f343a.getClass();
        return this;
    }

    @Override // kotlin.reflect.KProperty0
    @SinceKotlin
    public Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return mo43getGetter();
    }

    public /* bridge */ /* synthetic */ KMutableProperty.Setter getSetter() {
        return mo44getSetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    @Override // kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public KProperty0.Getter mo43getGetter() {
        return ((KMutableProperty0) getReflected()).mo43getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty0
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public KMutableProperty0.Setter mo44getSetter() {
        return ((KMutableProperty0) getReflected()).mo44getSetter();
    }
}
