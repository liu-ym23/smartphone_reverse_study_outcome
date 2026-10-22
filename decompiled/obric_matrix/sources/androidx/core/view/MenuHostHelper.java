package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MenuHostHelper {
    private final CopyOnWriteArrayList<MenuProvider> mMenuProviders;
    private final Runnable mOnInvalidateMenuCallback;
    private final Map<MenuProvider, LifecycleContainer> mProviderToLifecycleContainers;

    private static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private LifecycleEventObserver mObserver;

        LifecycleContainer(@NonNull Lifecycle r1, @NonNull LifecycleEventObserver r2) {
            this.mLifecycle = r1;
            this.mObserver = r2;
            r1.addObserver(r2);
        }

        void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }
    }

    public MenuHostHelper(@NonNull Runnable r2) {
        this.mMenuProviders = new CopyOnWriteArrayList();
        this.mProviderToLifecycleContainers = new HashMap();
        this.mOnInvalidateMenuCallback = r2;
    }

    private /* synthetic */ void a(MenuProvider r1, LifecycleOwner r2, Lifecycle.Event r3) {
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L6;
        removeMenuProvider(r1);
        return;
    }

    private /* synthetic */ void c(Lifecycle.State r1, MenuProvider r2, LifecycleOwner r3, Lifecycle.Event r4) {
        if (r4 != Lifecycle.Event.upTo(r1)) goto L6;
        addMenuProvider(r2);
        return;
    L6:
        if (r4 != Lifecycle.Event.ON_DESTROY) goto L9;
        removeMenuProvider(r2);
        return;
    L9:
        if (r4 != Lifecycle.Event.downFrom(r1)) goto L14;
        this.mMenuProviders.remove(r2);
        this.mOnInvalidateMenuCallback.run();
        return;
    }

    public void addMenuProvider(@NonNull MenuProvider r2) {
        this.mMenuProviders.add(r2);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(@NonNull final MenuProvider r3, @NonNull LifecycleOwner r4) {
        addMenuProvider(r3);
        Lifecycle r5 = r4.getLifecycle();
        LifecycleContainer r0 = this.mProviderToLifecycleContainers.remove(r3);
        if (r0 == null) goto L5;
        r0.clearObservers();
    L5:
        LifecycleEventObserver r1 = new c(this, r3);
        this.mProviderToLifecycleContainers.put(r3, new LifecycleContainer(r5, r1));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NonNull final MenuProvider r2, @NonNull LifecycleOwner r3, @NonNull final Lifecycle.State r4) {
        Lifecycle r5 = r3.getLifecycle();
        LifecycleContainer r0 = this.mProviderToLifecycleContainers.remove(r2);
        if (r0 == null) goto L5;
        r0.clearObservers();
    L5:
        LifecycleEventObserver r1 = new b(this, r4, r2);
        this.mProviderToLifecycleContainers.put(r2, new LifecycleContainer(r5, r1));
    }

    public /* synthetic */ void b(MenuProvider r1, LifecycleOwner r2, Lifecycle.Event r3) {
        a(r1, r2, r3);
    }

    public /* synthetic */ void d(Lifecycle.State r1, MenuProvider r2, LifecycleOwner r3, Lifecycle.Event r4) {
        c(r1, r2, r3, r4);
    }

    public void onCreateMenu(@NonNull Menu r2, @NonNull MenuInflater r3) {
        Iterator<MenuProvider> r1 = this.mMenuProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onCreateMenu(r2, r3);
        goto L4
    }

    public void onMenuClosed(@NonNull Menu r2) {
        Iterator<MenuProvider> r1 = this.mMenuProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onMenuClosed(r2);
        goto L4
    }

    public boolean onMenuItemSelected(@NonNull MenuItem r2) {
        Iterator<MenuProvider> r1 = this.mMenuProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().onMenuItemSelected(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void onPrepareMenu(@NonNull Menu r2) {
        Iterator<MenuProvider> r1 = this.mMenuProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onPrepareMenu(r2);
        goto L4
    }

    public void removeMenuProvider(@NonNull MenuProvider r2) {
        this.mMenuProviders.remove(r2);
        LifecycleContainer r3 = this.mProviderToLifecycleContainers.remove(r2);
        if (r3 == null) goto L5;
        r3.clearObservers();
    L5:
        this.mOnInvalidateMenuCallback.run();
    }
}
