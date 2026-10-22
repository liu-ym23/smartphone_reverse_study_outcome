package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    AtomicReference<Object> mInternalScopeRef;

    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event ON_ANY = null;
        public static final Event ON_CREATE = null;
        public static final Event ON_DESTROY = null;
        public static final Event ON_PAUSE = null;
        public static final Event ON_RESUME = null;
        public static final Event ON_START = null;
        public static final Event ON_STOP = null;

        static {
            Event r0 = new Event("ON_CREATE", 0);
            ON_CREATE = r0;
            Event r1 = new Event("ON_START", 1);
            ON_START = r1;
            Event r2 = new Event("ON_RESUME", 2);
            ON_RESUME = r2;
            Event r3 = new Event("ON_PAUSE", 3);
            ON_PAUSE = r3;
            Event r4 = new Event("ON_STOP", 4);
            ON_STOP = r4;
            Event r5 = new Event("ON_DESTROY", 5);
            ON_DESTROY = r5;
            Event r6 = new Event("ON_ANY", 6);
            ON_ANY = r6;
            $VALUES = new Event[]{r0, r1, r2, r3, r4, r5, r6};
        }

        private Event(String r1, int r2) {
            super(r1, r2);
        }

        public static Event valueOf(String r1) {
            return (Event) Enum.valueOf(Event.class, r1);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CREATED = null;
        public static final State DESTROYED = null;
        public static final State INITIALIZED = null;
        public static final State RESUMED = null;
        public static final State STARTED = null;

        static {
            State r0 = new State("DESTROYED", 0);
            DESTROYED = r0;
            State r1 = new State("INITIALIZED", 1);
            INITIALIZED = r1;
            State r2 = new State("CREATED", 2);
            CREATED = r2;
            State r3 = new State("STARTED", 3);
            STARTED = r3;
            State r4 = new State("RESUMED", 4);
            RESUMED = r4;
            $VALUES = new State[]{r0, r1, r2, r3, r4};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public boolean isAtLeast(@NonNull State r1) {
            if (compareTo(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Lifecycle() {
        this.mInternalScopeRef = new AtomicReference();
    }

    @MainThread
    public abstract void addObserver(@NonNull LifecycleObserver r1);

    @NonNull
    @MainThread
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(@NonNull LifecycleObserver r1);
}
