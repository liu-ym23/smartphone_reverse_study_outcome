package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle {
    AtomicReference<Object> mInternalScopeRef;

    /* JADX INFO: renamed from: androidx.lifecycle.Lifecycle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State = null;

        static {
            int[] r0 = new int[Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = r0;
            r0[Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L41:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L55:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L37:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_RESUME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L45:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L47:
            $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_ANY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r5 = new int[State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = r5;
            r5[State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L39:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L43:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L53:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L33:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[State.INITIALIZED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
            return;
        }
    }

    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event ON_ANY = null;
        public static final Event ON_CREATE = null;
        public static final Event ON_DESTROY = null;
        public static final Event ON_PAUSE = null;
        public static final Event ON_RESUME = null;
        public static final Event ON_START = null;
        public static final Event ON_STOP = null;

        public static Event valueOf(String r1) {
            return (Event) Enum.valueOf(Event.class, r1);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        private Event(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Event r0 = new Event("ON_CREATE", 0);
            ON_CREATE = r0;
            Event r1 = new Event("ON_START", 1);
            ON_START = r1;
            Event r3 = new Event("ON_RESUME", 2);
            ON_RESUME = r3;
            Event r5 = new Event("ON_PAUSE", 3);
            ON_PAUSE = r5;
            Event r7 = new Event("ON_STOP", 4);
            ON_STOP = r7;
            Event r9 = new Event("ON_DESTROY", 5);
            ON_DESTROY = r9;
            Event r11 = new Event("ON_ANY", 6);
            ON_ANY = r11;
            $VALUES = new Event[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static Event downFrom(State r1) {
            int r2 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[r1.ordinal()];
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L13;
            if (r2 == 3) goto L11;
            return null;
        L11:
            return ON_PAUSE;
        L13:
            return ON_STOP;
        L15:
            return ON_DESTROY;
        }

        public static Event downTo(State r1) {
            int r2 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[r1.ordinal()];
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L13;
            if (r2 == 4) goto L11;
            return null;
        L11:
            return ON_DESTROY;
        L13:
            return ON_PAUSE;
        L15:
            return ON_STOP;
        }

        public static Event upFrom(State r1) {
            int r2 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[r1.ordinal()];
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L13;
            if (r2 == 5) goto L11;
            return null;
        L11:
            return ON_CREATE;
        L13:
            return ON_RESUME;
        L15:
            return ON_START;
        }

        public static Event upTo(State r1) {
            int r2 = AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$State[r1.ordinal()];
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L13;
            if (r2 == 3) goto L11;
            return null;
        L11:
            return ON_RESUME;
        L13:
            return ON_START;
        L15:
            return ON_CREATE;
        }

        public State getTargetState() {
            switch(AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[ordinal()]) {
                case 1: goto L13;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L11;
                case 5: goto L9;
                case 6: goto L7;
                default: goto L5;
            };
        L5:
            throw new IllegalArgumentException(this + " has no target state");
        L7:
            return State.DESTROYED;
        L9:
            return State.RESUMED;
        L11:
            return State.STARTED;
        L13:
            return State.CREATED;
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        static {
            State r0 = new State("DESTROYED", 0);
            DESTROYED = r0;
            State r1 = new State("INITIALIZED", 1);
            INITIALIZED = r1;
            State r3 = new State(DebugCoroutineInfoImplKt.CREATED, 2);
            CREATED = r3;
            State r5 = new State("STARTED", 3);
            STARTED = r5;
            State r7 = new State("RESUMED", 4);
            RESUMED = r7;
            $VALUES = new State[]{r0, r1, r3, r5, r7};
        }

        public boolean isAtLeast(State r1) {
            if (compareTo(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public abstract void addObserver(LifecycleObserver r1);

    public abstract State getCurrentState();

    public abstract void removeObserver(LifecycleObserver r1);

    public Lifecycle() {
        this.mInternalScopeRef = new AtomicReference();
    }
}
