package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.h;
import kotlin.n0.d.o;
import kotlin.s0.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Lkotlin/Lazy;", "navArgsClass", "Lkotlin/reflect/KClass;", "argumentProducer", "Lkotlin/Function0;", "Landroid/os/Bundle;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/navigation/NavArgs;", "value", "getValue", "()Landroidx/navigation/NavArgs;", "isInitialized", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavArgsLazy<Args extends NavArgs> implements h<Args> {
    private final kotlin.n0.c.a<Bundle> argumentProducer;
    private Args cached;
    private final d<Args> navArgsClass;

    public NavArgsLazy(d<Args> r2, kotlin.n0.c.a<Bundle> r3) {
        o.f(r2, "navArgsClass");
        o.f(r3, "argumentProducer");
        this.navArgsClass = r2;
        this.argumentProducer = r3;
    }

    @Override // kotlin.h
    public Args getValue() {
        Args r0 = this.cached;
        if (r0 != null) goto L9;
        Bundle r1 = this.argumentProducer.invoke();
        Method r2 = NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
        if (r2 != null) goto L7;
        Class r3 = kotlin.n0.a.b(this.navArgsClass);
        Class<Bundle>[] r4 = NavArgsLazyKt.getMethodSignature();
        r2 = r3.getMethod("fromBundle", (Class[]) Arrays.copyOf(r4, r4.length));
        NavArgsLazyKt.getMethodMap().put(this.navArgsClass, r2);
        o.e(r2, "navArgsClass.java.getMet…hod\n                    }");
    L7:
        Object r5 = r2.invoke(null, new Object[]{r1});
        Objects.requireNonNull(r5, "null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy");
        Args r6 = (Args) r5;
        this.cached = r6;
        return r6;
    L9:
        return r0;
    }

    @Override // kotlin.h
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    public boolean isInitialized() {
        if (this.cached == null) goto L5;
        return true;
    L5:
        return false;
    }
}
