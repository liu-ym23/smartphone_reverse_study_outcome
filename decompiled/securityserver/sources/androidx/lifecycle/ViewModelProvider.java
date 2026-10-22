package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProvider {
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private final Factory mFactory;
    private final ViewModelStore mViewModelStore;

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        private static AndroidViewModelFactory sInstance;
        private Application mApplication;

        public AndroidViewModelFactory(@NonNull Application r1) {
            this.mApplication = r1;
        }

        @NonNull
        public static AndroidViewModelFactory getInstance(@NonNull Application r1) {
            if (sInstance != null) goto L6;
            sInstance = new AndroidViewModelFactory(r1);
        L6:
            return sInstance;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> r4) {
            if (AndroidViewModel.class.isAssignableFrom(r4) == false) goto L23;
            return r4.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.mApplication});
        L10:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r4, e);
        L8:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r4, e);
        L12:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r4, e);
        L6:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r4, e);
        L23:
            return (T) super.create(r4);
        }
    }

    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> r1);
    }

    public static abstract class KeyedFactory implements Factory {
        public KeyedFactory() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> r1) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        @NonNull
        public abstract <T extends ViewModel> T create(@NonNull String r1, @NonNull Class<T> r2);
    }

    public static class NewInstanceFactory implements Factory {
        public NewInstanceFactory() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> r4) {
            return r4.newInstance();
        L5:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r4, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r4, e);
        }
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner r1, @NonNull Factory r2) {
        this(r1.getViewModelStore(), r2);
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull Class<T> r3) {
        String r0 = r3.getCanonicalName();
        if (r0 == null) goto L7;
        return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(r0), r3);
    L7:
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public ViewModelProvider(@NonNull ViewModelStore r1, @NonNull Factory r2) {
        this.mFactory = r2;
        this.mViewModelStore = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull String r3, @NonNull Class<T> r4) {
        T r0 = (T) this.mViewModelStore.get(r3);
        if (r4.isInstance(r0) == false) goto L5;
        return r0;
    L5:
        Factory r1 = this.mFactory;
        if ((r1 instanceof KeyedFactory) == false) goto L8;
        T r5 = (T) ((KeyedFactory) r1).create(r3, r4);
    L9:
        this.mViewModelStore.put(r3, r5);
        return r5;
    L8:
        r5 = (T) r1.create(r4);
        goto L9
    }
}
