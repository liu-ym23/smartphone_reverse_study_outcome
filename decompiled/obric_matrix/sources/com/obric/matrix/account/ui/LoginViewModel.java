package com.obric.matrix.account.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/account/ui/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "lastSendCodeRecord", "Landroidx/lifecycle/MutableLiveData;", "Lcom/obric/matrix/account/ui/SendCodeRecord;", "getLastSendCodeRecord", "()Landroidx/lifecycle/MutableLiveData;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableLiveData<p> f8767a;

    public LoginViewModel() {
        this.f8767a = new MutableLiveData();
    }

    public final MutableLiveData<p> a() {
        return this.f8767a;
    }
}
