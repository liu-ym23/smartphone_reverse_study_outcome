package com.obric.oui.window.listener;

import androidx.lifecycle.ViewModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WindowConfigChangeListener extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f320a = null;
    public static final ConcurrentHashMap b = null;

    @Metadata
    public static final class Companion {
    }

    static {
        f320a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public WindowConfigChangeListener() {
        new NextLiveData();
    }
}
