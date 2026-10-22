package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.h;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BA\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewModelLazy<VM extends ViewModel> implements h<VM> {
    private VM cached;
    private final kotlin.n0.c.a<CreationExtras> extrasProducer;
    private final kotlin.n0.c.a<ViewModelProvider.Factory> factoryProducer;
    private final kotlin.n0.c.a<ViewModelStore> storeProducer;
    private final d<VM> viewModelClass;

    /* JADX INFO: renamed from: androidx.lifecycle.ViewModelLazy$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/viewmodel/CreationExtras$Empty;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends q implements kotlin.n0.c.a<CreationExtras.Empty> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ CreationExtras.Empty invoke() {
            return invoke();
        }
    }

    public ViewModelLazy(d<VM> r9, kotlin.n0.c.a<? extends ViewModelStore> r10, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r11) {
        o.f(r9, "viewModelClass");
        o.f(r10, "storeProducer");
        o.f(r11, "factoryProducer");
        this(r9, r10, r11, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(d<VM> r2, kotlin.n0.c.a<? extends ViewModelStore> r3, kotlin.n0.c.a<? extends ViewModelProvider.Factory> r4, kotlin.n0.c.a<? extends CreationExtras> r5) {
        o.f(r2, "viewModelClass");
        o.f(r3, "storeProducer");
        o.f(r4, "factoryProducer");
        o.f(r5, "extrasProducer");
        this.viewModelClass = r2;
        this.storeProducer = r3;
        this.factoryProducer = r4;
        this.extrasProducer = r5;
    }

    public /* synthetic */ ViewModelLazy(d r1, kotlin.n0.c.a r2, kotlin.n0.c.a r3, kotlin.n0.c.a r4, int r5, g r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = AnonymousClass1.INSTANCE;
    L5:
        this(r1, r2, r3, r4);
    }

    @Override // kotlin.h
    public VM getValue() {
        VM r0 = this.cached;
        if (r0 != null) goto L6;
        ViewModelProvider.Factory r1 = this.factoryProducer.invoke();
        VM r2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), r1, this.extrasProducer.invoke()).get(kotlin.n0.a.b(this.viewModelClass));
        this.cached = r2;
        return r2;
    L6:
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
