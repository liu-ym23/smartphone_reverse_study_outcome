package com.obric.oui.window.listener;

import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/window/listener/WindowConfigChangeListener;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class WindowConfigChangeListener extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, u<Configuration, Integer>> f11618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> f11619b;

    static {
        f11618a = new ConcurrentHashMap();
        f11619b = new ConcurrentHashMap();
    }

    public WindowConfigChangeListener() {
        new NextLiveData();
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f11618a;
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return f11619b;
    }
}
