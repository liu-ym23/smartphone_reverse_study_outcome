package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NextLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f11609c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Observer<? super T>, NextLiveData<T>.b<? super T>> f11611b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f11612f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ NextLiveData f11613g;

        a(NextLiveData r1, Object r2) {
            this.f11613g = r1;
            this.f11612f = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f11613g.setValue(this.f11612f);
        }
    }

    private class b<R> implements Observer<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Observer<R> f11615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ NextLiveData f11617d;

        b(NextLiveData r1, int r2, Observer<R> r3, boolean r4) {
            this.f11617d = r1;
            this.f11614a = r2;
            this.f11615b = r3;
            this.f11616c = r4;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable R r3) {
            if (this.f11616c == false) goto L5;
        L7:
            this.f11615b.onChanged(r3);
            return;
        L5:
            if (this.f11614a < NextLiveData.a(this.f11617d)) goto L7;
        }
    }

    static {
        f11609c = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.f11610a = -1;
        this.f11611b = new HashMap();
    }

    static /* synthetic */ int a(NextLiveData r0) {
        return r0.f11610a;
    }

    @MainThread
    public void b(@NonNull LifecycleOwner r3, @NonNull Observer<? super T> r4, boolean r5) {
        if (this.f11611b.containsKey(r4) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.b<? super T> r0 = new b(this, this.f11610a, r4, r5);
        this.f11611b.put(r4, r0);
        super.observe(r3, r0);
    }

    @MainThread
    public void c(@NonNull Observer<? super T> r3, boolean r4) {
        if (this.f11611b.containsKey(r3) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.b<? super T> r0 = new b(this, this.f11610a, r3, r4);
        this.f11611b.put(r3, r0);
        super.observeForever(r0);
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observe(@NonNull LifecycleOwner r2, @NonNull Observer<? super T> r3) {
        b(r2, r3, false);
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observeForever(@NonNull Observer<? super T> r2) {
        c(r2, false);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(@Nullable T r3) {
        f11609c.post(new a(this, r3));
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@NonNull Observer<? super T> r5) {
        NextLiveData<T>.b<? super T> r0 = this.f11611b.remove(r5);
        if (r0 == null) goto L7;
        super.removeObserver(r0);
        return;
    L7:
        if ((r5 instanceof b) == false) goto L20;
        Observer<? super T> r1 = null;
        Iterator<Map.Entry<Observer<? super T>, NextLiveData<T>.b<? super T>>> r2 = this.f11611b.entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<Observer<? super T>, NextLiveData<T>.b<? super T>> r3 = r2.next();
        if (r5.equals(r3.getValue()) == false) goto L10;
        r1 = r3.getKey();
        super.removeObserver(r5);
    L14:
        if (r1 == null) goto L21;
        this.f11611b.remove(r1);
        return;
    L21:
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T r2) {
        this.f11610a++;
        super.setValue(r2);
    }
}
