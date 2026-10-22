package androidx.work;

import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public interface Operation {
    public static final State.IN_PROGRESS IN_PROGRESS = null;
    public static final State.SUCCESS SUCCESS = null;

    /* JADX INFO: renamed from: androidx.work.Operation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class State {

        public static final class FAILURE extends State {
            private final Throwable mThrowable;

            public FAILURE(Throwable exception) {
                this.mThrowable = exception;
            }

            public Throwable getThrowable() {
                return this.mThrowable;
            }

            public String toString() {
                return "FAILURE (" + this.mThrowable.getMessage() + ")";
            }
        }

        public static final class IN_PROGRESS extends State {
            public String toString() {
                return "IN_PROGRESS";
            }

            /* synthetic */ IN_PROGRESS(AnonymousClass1 r1) {
                this();
            }

            private IN_PROGRESS() {
            }
        }

        public static final class SUCCESS extends State {
            public String toString() {
                return "SUCCESS";
            }

            /* synthetic */ SUCCESS(AnonymousClass1 r1) {
                this();
            }

            private SUCCESS() {
            }
        }

        State() {
        }
    }

    ListenableFuture<State.SUCCESS> getResult();

    LiveData<State> getState();

    static {
        AnonymousClass1 r1 = null;
        SUCCESS = new State.SUCCESS(r1);
        IN_PROGRESS = new State.IN_PROGRESS(r1);
    }
}
