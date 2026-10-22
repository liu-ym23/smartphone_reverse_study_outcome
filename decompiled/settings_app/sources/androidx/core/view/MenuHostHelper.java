package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        LifecycleContainer(Lifecycle r1, LifecycleEventObserver r2) {
            this.mLifecycle = r1;
            this.mObserver = r2;
            r1.addObserver(r2);
        }

        void clearObservers() {
            this.mLifecycle.removeObserver(this.mObserver);
            this.mObserver = null;
        }
    }

    public MenuHostHelper(Runnable r2) {
        this.mMenuProviders = new CopyOnWriteArrayList();
        this.mProviderToLifecycleContainers = new HashMap();
        this.mOnInvalidateMenuCallback = r2;
    }

    public void onPrepareMenu(Menu r2) {
        Iterator<MenuProvider> r1 = this.mMenuProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onPrepareMenu(r2);
        goto L4
    }

    public void onCreateMenu(Menu r2, MenuInflater r3) {
        Iterator<MenuProvider> r1 = this.mMenuProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onCreateMenu(r2, r3);
        goto L4
    }

    public boolean onMenuItemSelected(MenuItem r2) {
        Iterator<MenuProvider> r1 = this.mMenuProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().onMenuItemSelected(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void onMenuClosed(Menu r2) {
        Iterator<MenuProvider> r1 = this.mMenuProviders.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onMenuClosed(r2);
        goto L4
    }

    public void addMenuProvider(MenuProvider r2) {
        this.mMenuProviders.add(r2);
        this.mOnInvalidateMenuCallback.run();
    }

    public void addMenuProvider(final MenuProvider r3, LifecycleOwner r4) {
        addMenuProvider(r3);
        Lifecycle r5 = r4.getLifecycle();
        LifecycleContainer r0 = this.mProviderToLifecycleContainers.remove(r3);
        if (r0 == null) goto L5;
        r0.clearObservers();
    L5:
        LifecycleEventObserver r1 = new MenuHostHelper$$ExternalSyntheticLambda0(this, r3);
        this.mProviderToLifecycleContainers.put(r3, new LifecycleContainer(r5, r1));
    }

    /* JADX INFO: renamed from: lambda$addMenuProvider$0$androidx-core-view-MenuHostHelper, reason: not valid java name */
    /* synthetic */ void m35lambda$addMenuProvider$0$androidxcoreviewMenuHostHelper(MenuProvider r1, LifecycleOwner r2, Lifecycle.Event r3) {
        if (r3 != Lifecycle.Event.ON_DESTROY) goto L6;
        removeMenuProvider(r1);
        return;
    }

    public void addMenuProvider(final MenuProvider r2, LifecycleOwner r3, final Lifecycle.State r4) {
        Lifecycle r5 = r3.getLifecycle();
        LifecycleContainer r0 = this.mProviderToLifecycleContainers.remove(r2);
        if (r0 == null) goto L5;
        r0.clearObservers();
    L5:
        LifecycleEventObserver r1 = new MenuHostHelper$$ExternalSyntheticLambda1(this, r4, r2);
        this.mProviderToLifecycleContainers.put(r2, new LifecycleContainer(r5, r1));
    }

    /* JADX INFO: renamed from: lambda$addMenuProvider$1$androidx-core-view-MenuHostHelper, reason: not valid java name */
    /* synthetic */ void m36lambda$addMenuProvider$1$androidxcoreviewMenuHostHelper(Lifecycle.State r1, MenuProvider r2, LifecycleOwner r3, Lifecycle.Event r4) {
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

    public void removeMenuProvider(MenuProvider r2) {
        this.mMenuProviders.remove(r2);
        LifecycleContainer r3 = this.mProviderToLifecycleContainers.remove(r2);
        if (r3 == null) goto L5;
        r3.clearObservers();
    L5:
        this.mOnInvalidateMenuCallback.run();
    }
}
