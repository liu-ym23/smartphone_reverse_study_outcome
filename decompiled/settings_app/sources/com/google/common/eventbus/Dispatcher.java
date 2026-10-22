package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class Dispatcher {

    /* JADX INFO: renamed from: com.google.common.eventbus.Dispatcher$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = null;

        private ImmediateDispatcher() {
        }

        static /* synthetic */ ImmediateDispatcher access$200() {
            return INSTANCE;
        }

        static {
            INSTANCE = new ImmediateDispatcher();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object r1, Iterator<Subscriber> r2) {
            Preconditions.checkNotNull(r1);
        L4:
            if (r2.hasNext() == false) goto L6;
            r2.next().dispatchEvent(r1);
            goto L4
        }
    }

    private static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        private static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            /* synthetic */ EventWithSubscriber(Object r1, Subscriber r2, AnonymousClass1 r3) {
                this(r1, r2);
            }

            static /* synthetic */ Object access$700(EventWithSubscriber r0) {
                return r0.event;
            }

            static /* synthetic */ Subscriber access$800(EventWithSubscriber r0) {
                return r0.subscriber;
            }

            private EventWithSubscriber(Object r1, Subscriber r2) {
                this.event = r1;
                this.subscriber = r2;
            }
        }

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        /* synthetic */ LegacyAsyncDispatcher(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object r5, Iterator<Subscriber> r6) {
            Preconditions.checkNotNull(r5);
        L4:
            if (r6.hasNext() == false) goto L6;
            this.queue.add(new EventWithSubscriber(r5, r6.next(), null));
        L6:
            EventWithSubscriber r7 = this.queue.poll();
            if (r7 == null) goto L9;
            EventWithSubscriber.access$800(r7).dispatchEvent(EventWithSubscriber.access$700(r7));
            goto L6
        }
    }

    private static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        private static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            /* synthetic */ Event(Object r1, Iterator r2, AnonymousClass1 r3) {
                this(r1, r2);
            }

            static /* synthetic */ Iterator access$400(Event r0) {
                return r0.subscribers;
            }

            static /* synthetic */ Object access$500(Event r0) {
                return r0.event;
            }

            private Event(Object r1, Iterator<Subscriber> r2) {
                this.event = r1;
                this.subscribers = r2;
            }
        }

        private PerThreadQueuedDispatcher() {
            this.queue = new AnonymousClass1(this);
            this.dispatching = new AnonymousClass2(this);
        }

        /* synthetic */ PerThreadQueuedDispatcher(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object r4, Iterator<Subscriber> r5) {
            Preconditions.checkNotNull(r4);
            Preconditions.checkNotNull(r5);
            Queue<Event> r0 = this.queue.get();
            r0.offer(new Event(r4, r5, null));
            if (this.dispatching.get().booleanValue() == true) goto L15;
            this.dispatching.set(true);
        L16:
            Event r6 = r0.poll();     // Catch: Throwable -> L12
            if (r6 == null) goto L11;
        L8:
            if (Event.access$400(r6).hasNext() == false) goto L16;
            ((Subscriber) Event.access$400(r6).next()).dispatchEvent(Event.access$500(r6));     // Catch: Throwable -> L12
            goto L8
        L11:
            this.dispatching.remove();
            this.queue.remove();
            return;
        L12:
            th = move-exception;
            this.dispatching.remove();
            this.queue.remove();
            throw th;
        }
    }

    abstract void dispatch(Object r1, Iterator<Subscriber> r2);

    Dispatcher() {
    }

    static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher(null);
    }

    static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher(null);
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.access$200();
    }
}
