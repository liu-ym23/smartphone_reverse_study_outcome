package com.obric.oui.window.listener;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.obric.oui.window.OWindowConfigController;
import com.obric.oui.window.bean.WindowSizeWithPageSize;
import com.obric.oui.window.interfaces.OnWindowConfigChangeListener;
import com.obric.oui.window.model.AdaptedWindowSize;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: WindowConfigChangeListener.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/window/listener/WindowConfigChangeListener;", "Landroidx/lifecycle/ViewModel;", "()V", "mData", "Lcom/obric/oui/window/listener/NextLiveData;", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WindowConfigChangeListener extends ViewModel {
    private static final long CONFIG_REFRESH_DELAY_TIME = 100;
    public static final Companion Companion = null;
    private static final String TAG = "Window";
    private static ConcurrentHashMap<Integer, Pair<Configuration, Integer>> mConfigDiffMap;
    private static ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> mFragmentMap;
    private static Configuration mLastConfig;
    private NextLiveData<WindowSizeWithPageSize> mData;

    /* JADX INFO: compiled from: WindowConfigChangeListener.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010!\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0007J\u001e\u0010\"\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0007J2\u0010)\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020*2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\n0\bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/oui/window/listener/WindowConfigChangeListener$Companion;", "", "()V", "CONFIG_REFRESH_DELAY_TIME", "", "TAG", "", "mConfigDiffMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Landroid/content/res/Configuration;", "mFragmentMap", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "mLastConfig", "addListener", "Landroidx/lifecycle/Observer;", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "listener", "Lcom/obric/oui/window/interfaces/OnWindowConfigChangeListener;", "getCurrentConfigLiveData", "Lcom/obric/oui/window/listener/NextLiveData;", "lifecycleOwner", "isMainThread", "", "observeByObserverOnMainThread", "", "observer", "observeOnMainThread", "removeListenerByObserver", "removeObserverOnMainThread", "setConfig", "context", "Landroid/app/Activity;", "config", "currentWindowWidth", "currentWindowHeight", "setConfigInternal", "Landroidx/fragment/app/FragmentActivity;", "decorViewWidth", "decorViewHeight", "forceUseDecorSize", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public static /* synthetic */ void $r8$lambda$VUdD07buGrJ_1O4AgTc70d_1yAU(OnWindowConfigChangeListener r0, WindowSizeWithPageSize r1) {
            m589observeOnMainThread$lambda0(r0, r1);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ void access$setConfigInternal(Companion r0, FragmentActivity r1, Configuration r2, int r3, int r4, boolean r5) {
            r0.setConfigInternal(r1, r2, r3, r4, r5);
        }

        private final boolean isMainThread() {
            return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        }

        private final Observer<WindowSizeWithPageSize> observeOnMainThread(LifecycleOwner r2, final OnWindowConfigChangeListener r3) {
            Observer<WindowSizeWithPageSize> r0 = new WindowConfigChangeListener$Companion$$ExternalSyntheticLambda0(r3);
            observeByObserverOnMainThread(r2, r0);
            return r0;
        }

        /* JADX INFO: renamed from: observeOnMainThread$lambda-0, reason: not valid java name */
        private static final void m589observeOnMainThread$lambda0(OnWindowConfigChangeListener r1, WindowSizeWithPageSize r2) {
            Intrinsics.checkNotNullParameter(r1, "$listener");
            Intrinsics.checkNotNullExpressionValue(r2, "it");
            r1.onChange(r2);
        }

        private final void observeByObserverOnMainThread(LifecycleOwner r7, Observer<WindowSizeWithPageSize> r8) {
            if (isMainThread() == false) goto L8;
            NextLiveData<WindowSizeWithPageSize> r6 = getCurrentConfigLiveData(r7);
            if (r6 == null) goto L11;
            r6.observe(r7, r8);
            return;
        L11:
            return;
        L8:
            Lifecycle r9 = r7.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r9, "owner.lifecycle");
            BuildersKt.launch$default(LifecycleKt.getCoroutineScope(r9), Dispatchers.getMain(), null, new WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(r7, r8, null), 2, null);
        }

        private final void removeObserverOnMainThread(Observer<WindowSizeWithPageSize> r7, LifecycleOwner r8) {
            if (isMainThread() == false) goto L8;
            NextLiveData<WindowSizeWithPageSize> r6 = getCurrentConfigLiveData(r8);
            if (r6 == null) goto L11;
            r6.removeObserver(r7);
            return;
        L11:
            return;
        L8:
            Lifecycle r9 = r8.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r9, "owner.lifecycle");
            BuildersKt.launch$default(LifecycleKt.getCoroutineScope(r9), Dispatchers.getMain(), null, new WindowConfigChangeListener$Companion$removeObserverOnMainThread$1(r8, r7, null), 2, null);
        }

        @JvmStatic
        public final NextLiveData<WindowSizeWithPageSize> getCurrentConfigLiveData(LifecycleOwner r3) {
            Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
            if ((r3 instanceof Fragment) == false) goto L12;
            FragmentActivity r2 = ((Fragment) r3).getActivity();
            if (r2 == null) goto L20;
            Application r4 = r2.getApplication();
            if (r4 == null) goto L21;
            ViewModel r5 = new ViewModelProvider((ViewModelStoreOwner) r3, ViewModelProvider.AndroidViewModelFactory.getInstance(r4)).get(WindowConfigChangeListener.class);
            Intrinsics.checkNotNullExpressionValue(r5, "ViewModelProvider(\n     …angeListener::class.java]");
            return WindowConfigChangeListener.access$getMData$p((WindowConfigChangeListener) r5);
        L21:
            return null;
        L20:
            return null;
        L12:
            if ((r3 instanceof FragmentActivity) == false) goto L19;
            Application r6 = ((FragmentActivity) r3).getApplication();
            if (r6 == null) goto L22;
            ViewModel r7 = new ViewModelProvider((ViewModelStoreOwner) r3, ViewModelProvider.AndroidViewModelFactory.getInstance(r6)).get(WindowConfigChangeListener.class);
            Intrinsics.checkNotNullExpressionValue(r7, "ViewModelProvider(\n     …angeListener::class.java]");
            return WindowConfigChangeListener.access$getMData$p((WindowConfigChangeListener) r7);
        L22:
            return null;
        L19:
            return null;
        }

        @JvmStatic
        public final void setConfig(Activity r10, Configuration r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "config");
            if ((r10 instanceof FragmentActivity) == true) goto L6;
            Log.e(WindowConfigChangeListener.TAG, "current activity is not FragmentActivity:" + r10 + ",do not set config");
            return;
        L6:
            Lifecycle r9 = ((FragmentActivity) r10).getLifecycle();
            Intrinsics.checkNotNullExpressionValue(r9, "context.lifecycle");
            BuildersKt.launch$default(LifecycleKt.getCoroutineScope(r9), Dispatchers.getDefault(), null, new WindowConfigChangeListener$Companion$setConfig$1(r10, r11, r12, r13, null), 2, null);
        }

        static /* synthetic */ void setConfigInternal$default(Companion r6, FragmentActivity r7, Configuration r8, int r9, int r10, boolean r11, int r12, Object r13) {
            if ((r12 & 16) == 0) goto L5;
            r11 = false;
        L5:
            r6.setConfigInternal(r7, r8, r9, r10, r11);
        }

        private final void setConfigInternal(final FragmentActivity r4, Configuration r5, int r6, int r7, boolean r8) {
            int r3 = r4.hashCode();     // Catch: Exception -> L7
            if (WindowConfigChangeListener.access$getMConfigDiffMap$cp().containsKey(Integer.valueOf(r3)) == true) goto L5;
            r4.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$setConfigInternal$1(r4));     // Catch: Exception -> L7
        L5:
            WindowConfigChangeListener.access$getMConfigDiffMap$cp().put(Integer.valueOf(r3), new Pair(r5, Integer.valueOf(r6)));     // Catch: Exception -> L7
        L9:
            AdaptedWindowSize r9 = AdaptedWindowSize.INSTANCE;
            FragmentActivity r10 = r4;
            r9.setCurrentWindowSize(r10, r6, r7, r8);
            if ((r4 instanceof Activity) == true) goto L13;
            r10 = null;
        L13:
            if (r10 == null) goto L16;
            r9.changeScreenMode(r10, r6, r7);
        L16:
            r9.onWindowConfigChange();
            NextLiveData<WindowSizeWithPageSize> r11 = WindowConfigChangeListener.Companion.getCurrentConfigLiveData(r4);
            if (r11 == null) goto L20;
            r11.postValue(new WindowSizeWithPageSize(r9.getCurrentWindowSizeClass(), r9.getCurrentPageSize()));
        L20:
            ConcurrentLinkedQueue r12 = (ConcurrentLinkedQueue) WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r4.hashCode()));
            if (r12 == null) goto L33;
            Iterator r13 = r12.iterator();
        L25:
            if (r13.hasNext() == false) goto L33;
            Fragment r14 = (Fragment) ((WeakReference) r13.next()).get();
            if (r14 == null) goto L25;
            NextLiveData<WindowSizeWithPageSize> r15 = WindowConfigChangeListener.Companion.getCurrentConfigLiveData(r14);
            if (r15 == null) goto L25;
            r15.postValue(new WindowSizeWithPageSize(r9.getCurrentWindowSizeClass(), r9.getCurrentPageSize()));
        L33:
            OWindowConfigController.INSTANCE.setWindowConfigInitStatus(true);
            return;
        L7:
            e = move-exception;
            Log.e(WindowConfigChangeListener.TAG, Intrinsics.stringPlus("setToConfig error:", e.getMessage()));
            goto L9
        }

        @JvmStatic
        public final Observer<WindowSizeWithPageSize> addListener(final LifecycleOwner r6, OnWindowConfigChangeListener r7) {
            if (r6 == null) goto L27;
            if (r7 == null) goto L27;
            if ((r6 instanceof Fragment) == false) goto L26;
            Fragment r0 = (Fragment) r6;
            FragmentActivity r1 = r0.getActivity();
            if (r1 == null) goto L10;
            final int r2 = r1.hashCode();
        L12:
            if (WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r2)) != null) goto L20;
            WindowConfigChangeListener.access$getMFragmentMap$cp().put(Integer.valueOf(r2), new ConcurrentLinkedQueue());
            FragmentActivity r3 = r0.getActivity();
            if (r3 == null) goto L20;
            Lifecycle r4 = r3.getLifecycle();
            if (r4 == null) goto L20;
            r4.addObserver(new WindowConfigChangeListener$Companion$addListener$1(r2));
        L20:
            ConcurrentLinkedQueue r5 = (ConcurrentLinkedQueue) WindowConfigChangeListener.access$getMFragmentMap$cp().get(Integer.valueOf(r2));
            if (r5 == null) goto L24;
            r5.add(new WeakReference(r6));
        L24:
            r0.getLifecycle().addObserver(new WindowConfigChangeListener$Companion$addListener$2(r2, r6));
            goto L26
        L10:
            r2 = 0;
        L26:
            return observeOnMainThread(r6, r7);
        L27:
            Log.e(WindowConfigChangeListener.TAG, "cannot add WindowConfigChangeListener:context,owner or listener = nul");
            return null;
        }

        @JvmStatic
        public final void removeListenerByObserver(Observer<WindowSizeWithPageSize> r1, LifecycleOwner r2) {
            if (r2 == null) goto L7;
            if (r1 == null) goto L7;
            removeObserverOnMainThread(r1, r2);
            return;
        L7:
            Log.e(WindowConfigChangeListener.TAG, "cannot remove WindowConfigChangeListener:context or observer = nul");
        }
    }

    @JvmStatic
    public static final Observer<WindowSizeWithPageSize> addListener(LifecycleOwner r1, OnWindowConfigChangeListener r2) {
        return Companion.addListener(r1, r2);
    }

    @JvmStatic
    public static final NextLiveData<WindowSizeWithPageSize> getCurrentConfigLiveData(LifecycleOwner r1) {
        return Companion.getCurrentConfigLiveData(r1);
    }

    @JvmStatic
    public static final void removeListenerByObserver(Observer<WindowSizeWithPageSize> r1, LifecycleOwner r2) {
        Companion.removeListenerByObserver(r1, r2);
    }

    @JvmStatic
    public static final void setConfig(Activity r1, Configuration r2, int r3, int r4) {
        Companion.setConfig(r1, r2, r3, r4);
    }

    public WindowConfigChangeListener() {
        this.mData = new NextLiveData();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMConfigDiffMap$cp() {
        return mConfigDiffMap;
    }

    public static final /* synthetic */ NextLiveData access$getMData$p(WindowConfigChangeListener r0) {
        return r0.mData;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMFragmentMap$cp() {
        return mFragmentMap;
    }

    static {
        Companion = new Companion(null);
        mConfigDiffMap = new ConcurrentHashMap();
        mFragmentMap = new ConcurrentHashMap();
    }
}
