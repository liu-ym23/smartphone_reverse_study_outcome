package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NextLiveData<T> extends MutableLiveData<T> {
    public static final Handler c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f317a;
    public final HashMap b;

    public class NextObserver<R> implements Observer<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f318a;
        public final Observer b;
        public final boolean c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NextLiveData f319d;

        public NextObserver(NextLiveData r1, int r2, Observer r3) {
            this.f319d = r1;
            this.f318a = r2;
            this.b = r3;
            this.c = false;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r3) {
            if (this.c == true) goto L7;
            int r0 = this.f319d.f317a;
            if (this.f318a < r0) goto L7;
            return;
        L7:
            this.b.onChanged(r3);
        }
    }

    static {
        c = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.f317a = -1;
        this.b = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r4, Observer r5) {
        HashMap r0 = this.b;
        if (r0.containsKey(r5) == true) goto L7;
        NextObserver r1 = new NextObserver(this, this.f317a, r5);
        r0.put(r5, r1);
        super.observe(r4, r1);
        return;
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer r4) {
        HashMap r0 = this.b;
        if (r0.containsKey(r4) == true) goto L7;
        NextObserver r1 = new NextObserver(this, this.f317a, r4);
        r0.put(r4, r1);
        super.observeForever(r1);
        return;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(final Object r3) {
        c.post(new AnonymousClass1(this, r3));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer r5) {
        HashMap r0 = this.b;
        NextObserver r1 = (NextObserver) r0.remove(r5);
        if (r1 == null) goto L7;
        super.removeObserver(r1);
        return;
    L7:
        if ((r5 instanceof NextObserver) == false) goto L21;
        Iterator r2 = r0.entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (r5.equals(r3.getValue()) == false) goto L10;
        Observer r4 = (Observer) r3.getKey();
        super.removeObserver(r5);
    L15:
        if (r4 == null) goto L22;
        r0.remove(r4);
        return;
    L22:
        return;
    L14:
        r4 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(Object r2) {
        this.f317a++;
        super.setValue(r2);
    }
}
