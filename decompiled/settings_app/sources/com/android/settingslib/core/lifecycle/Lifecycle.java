package com.android.settingslib.core.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.core.lifecycle.events.OnAttach;
import com.android.settingslib.core.lifecycle.events.OnCreate;
import com.android.settingslib.core.lifecycle.events.OnCreateOptionsMenu;
import com.android.settingslib.core.lifecycle.events.OnDestroy;
import com.android.settingslib.core.lifecycle.events.OnOptionsItemSelected;
import com.android.settingslib.core.lifecycle.events.OnPause;
import com.android.settingslib.core.lifecycle.events.OnPrepareOptionsMenu;
import com.android.settingslib.core.lifecycle.events.OnResume;
import com.android.settingslib.core.lifecycle.events.OnSaveInstanceState;
import com.android.settingslib.core.lifecycle.events.OnStart;
import com.android.settingslib.core.lifecycle.events.OnStop;
import com.android.settingslib.core.lifecycle.events.SetPreferenceScreen;
import com.android.settingslib.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Lifecycle extends LifecycleRegistry {
    private static final String TAG = "LifecycleObserver";
    private final List<LifecycleObserver> mObservers;
    private final LifecycleProxy mProxy;

    /* JADX INFO: renamed from: com.android.settingslib.core.lifecycle.Lifecycle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event = null;

        static {
            int[] r0 = new int[androidx.lifecycle.Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = r0;
            r0[androidx.lifecycle.Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[androidx.lifecycle.Lifecycle.Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private class LifecycleProxy implements androidx.lifecycle.LifecycleObserver {
        final /* synthetic */ Lifecycle this$0;

        private LifecycleProxy(Lifecycle r1) {
            this.this$0 = r1;
        }

        /* synthetic */ LifecycleProxy(Lifecycle r1, AnonymousClass1 r2) {
            this(r1);
        }

        @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_ANY)
        public void onLifecycleEvent(LifecycleOwner r1, androidx.lifecycle.Lifecycle.Event r2) {
            switch(AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[r2.ordinal()]) {
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L17;
            };
        L5:
            Log.wtf(Lifecycle.TAG, "Should not receive an 'ANY' event!");
            return;
        L6:
            Lifecycle.access$500(this.this$0);
            return;
        L7:
            Lifecycle.access$400(this.this$0);
            return;
        L8:
            Lifecycle.access$300(this.this$0);
            return;
        L9:
            Lifecycle.access$200(this.this$0);
            return;
        L10:
            Lifecycle.access$100(this.this$0);
            return;
        }
    }

    static /* synthetic */ void access$100(Lifecycle r0) {
        r0.onStart();
    }

    static /* synthetic */ void access$200(Lifecycle r0) {
        r0.onResume();
    }

    static /* synthetic */ void access$300(Lifecycle r0) {
        r0.onPause();
    }

    static /* synthetic */ void access$400(Lifecycle r0) {
        r0.onStop();
    }

    static /* synthetic */ void access$500(Lifecycle r0) {
        r0.onDestroy();
    }

    public Lifecycle(LifecycleOwner r2) {
        super(r2);
        this.mObservers = new ArrayList();
        LifecycleProxy r3 = new LifecycleProxy(this, null);
        this.mProxy = r3;
        addObserver(r3);
    }

    @Override // androidx.lifecycle.LifecycleRegistry, androidx.lifecycle.Lifecycle
    public void addObserver(androidx.lifecycle.LifecycleObserver r2) {
        ThreadUtils.ensureMainThread();
        super.addObserver(r2);
        if ((r2 instanceof LifecycleObserver) == false) goto L6;
        this.mObservers.add((LifecycleObserver) r2);
        return;
    }

    @Override // androidx.lifecycle.LifecycleRegistry, androidx.lifecycle.Lifecycle
    public void removeObserver(androidx.lifecycle.LifecycleObserver r2) {
        ThreadUtils.ensureMainThread();
        super.removeObserver(r2);
        if ((r2 instanceof LifecycleObserver) == false) goto L6;
        this.mObservers.remove(r2);
        return;
    }

    public void onAttach(Context r4) {
        int r5 = this.mObservers.size();
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L8;
        LifecycleObserver r1 = this.mObservers.get(r0);
        if ((r1 instanceof OnAttach) == false) goto L7;
        ((OnAttach) r1).onAttach();
    L7:
        r0 = r0 + 1;
        goto L3
    }

    public void onCreate(Bundle r5) {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnCreate) == false) goto L7;
        ((OnCreate) r2).onCreate(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void onStart() {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnStart) == false) goto L7;
        ((OnStart) r2).onStart();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public void setPreferenceScreen(PreferenceScreen r5) {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof SetPreferenceScreen) == false) goto L7;
        ((SetPreferenceScreen) r2).setPreferenceScreen(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void onResume() {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnResume) == false) goto L7;
        ((OnResume) r2).onResume();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void onPause() {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnPause) == false) goto L7;
        ((OnPause) r2).onPause();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public void onSaveInstanceState(Bundle r5) {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnSaveInstanceState) == false) goto L7;
        ((OnSaveInstanceState) r2).onSaveInstanceState(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void onStop() {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnStop) == false) goto L7;
        ((OnStop) r2).onStop();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void onDestroy() {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnDestroy) == false) goto L7;
        ((OnDestroy) r2).onDestroy();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public void onCreateOptionsMenu(Menu r5, MenuInflater r6) {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnCreateOptionsMenu) == false) goto L7;
        ((OnCreateOptionsMenu) r2).onCreateOptionsMenu(r5, r6);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public void onPrepareOptionsMenu(Menu r5) {
        int r0 = this.mObservers.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        LifecycleObserver r2 = this.mObservers.get(r1);
        if ((r2 instanceof OnPrepareOptionsMenu) == false) goto L7;
        ((OnPrepareOptionsMenu) r2).onPrepareOptionsMenu(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public boolean onOptionsItemSelected(MenuItem r6) {
        int r0 = this.mObservers.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        LifecycleObserver r3 = this.mObservers.get(r2);
        if ((r3 instanceof OnOptionsItemSelected) == false) goto L10;
        if (((OnOptionsItemSelected) r3).onOptionsItemSelected(r6) == false) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }
}
