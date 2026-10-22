package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class FullLifecycleObserverAdapter implements LifecycleEventObserver {
    private final FullLifecycleObserver mFullLifecycleObserver;
    private final LifecycleEventObserver mLifecycleEventObserver;

    /* JADX INFO: renamed from: androidx.lifecycle.FullLifecycleObserverAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = r0;
            r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public FullLifecycleObserverAdapter(FullLifecycleObserver r1, LifecycleEventObserver r2) {
        this.mFullLifecycleObserver = r1;
        this.mLifecycleEventObserver = r2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        switch(AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[r4.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L13;
        };
    L7:
        this.mFullLifecycleObserver.onDestroy(r3);
        goto L13
    L8:
        this.mFullLifecycleObserver.onStop(r3);
        goto L13
    L9:
        this.mFullLifecycleObserver.onPause(r3);
        goto L13
    L10:
        this.mFullLifecycleObserver.onResume(r3);
        goto L13
    L11:
        this.mFullLifecycleObserver.onStart(r3);
        goto L13
    L12:
        this.mFullLifecycleObserver.onCreate(r3);
    L13:
        LifecycleEventObserver r2 = this.mLifecycleEventObserver;
        if (r2 == null) goto L17;
        r2.onStateChanged(r3, r4);
        return;
    L17:
        return;
    L6:
        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    }
}
