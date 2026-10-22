package com.bumptech.glide.request;

import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: loaded from: classes.dex */
public interface RequestCoordinator {

    public static final enum RequestState extends Enum<RequestState> {
        private static final /* synthetic */ RequestState[] $VALUES = null;
        public static final RequestState CLEARED = null;
        public static final RequestState FAILED = null;
        public static final RequestState PAUSED = null;
        public static final RequestState RUNNING = null;
        public static final RequestState SUCCESS = null;
        private final boolean isComplete;

        private static /* synthetic */ RequestState[] $values() {
            return new RequestState[]{RUNNING, PAUSED, CLEARED, SUCCESS, FAILED};
        }

        public static RequestState valueOf(String r1) {
            return (RequestState) Enum.valueOf(RequestState.class, r1);
        }

        public static RequestState[] values() {
            return (RequestState[]) $VALUES.clone();
        }

        static {
            RUNNING = new RequestState(DebugCoroutineInfoImplKt.RUNNING, 0, false);
            PAUSED = new RequestState("PAUSED", 1, false);
            CLEARED = new RequestState("CLEARED", 2, false);
            SUCCESS = new RequestState("SUCCESS", 3, true);
            FAILED = new RequestState("FAILED", 4, true);
            $VALUES = $values();
        }

        private RequestState(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.isComplete = r3;
        }

        boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean canNotifyCleared(Request r1);

    boolean canNotifyStatusChanged(Request r1);

    boolean canSetImage(Request r1);

    RequestCoordinator getRoot();

    boolean isAnyResourceSet();

    void onRequestFailed(Request r1);

    void onRequestSuccess(Request r1);
}
