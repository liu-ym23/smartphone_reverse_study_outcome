package com.obric.matrix.account.ui;

import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/account/ui/LoginNavHostFragment;", "Landroidx/navigation/fragment/NavHostFragment;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginNavHostFragment extends NavHostFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Integer, View> f8766f;

    public LoginNavHostFragment() {
        this.f8766f = new LinkedHashMap();
    }

    public void b() {
        this.f8766f.clear();
    }

    @Override // androidx.navigation.fragment.NavHostFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        NavGraph r3 = getNavController().getNavInflater().inflate(com.obric.matrix.account.i.f8531a);
        r3.setStartDestination(com.obric.matrix.account.g.p);
        getNavController().setGraph(r3);
    }

    @Override // androidx.navigation.fragment.NavHostFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }
}
