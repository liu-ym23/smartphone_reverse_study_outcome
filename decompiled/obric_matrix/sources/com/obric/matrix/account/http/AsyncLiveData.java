package com.obric.matrix.account.http;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0006R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcom/obric/matrix/account/http/AsyncLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "Lcom/obric/matrix/account/http/Async;", "()V", "asyncLiveData", "Landroidx/lifecycle/LiveData;", "getAsyncLiveData", "()Landroidx/lifecycle/LiveData;", "dataLiveData", "getDataLiveData", "toLiveData", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AsyncLiveData<T> extends MutableLiveData<b<? extends T>> {
    public AsyncLiveData() {
        super(m.f8530b);
        o.b(Transformations.distinctUntilChanged(this), "Transformations.distinctUntilChanged(this)");
        LiveData r2 = Transformations.map(this, new AsyncLiveData$special$$inlined$map$1());
        o.b(r2, "Transformations.map(this) { transform(it) }");
        o.b(Transformations.distinctUntilChanged(r2), "Transformations.distinctUntilChanged(this)");
    }
}
