package com.google.common.util.concurrent;

import com.android.settings.utils.HanziToPinyin;
import com.google.common.base.Supplier;
import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractIdleService implements Service {
    private final Service delegate;
    private final Supplier<String> threadNameSupplier;

    private final class DelegateService extends AbstractService {
        final /* synthetic */ AbstractIdleService this$0;

        private DelegateService(AbstractIdleService r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DelegateService(AbstractIdleService r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$200(this.this$0)).execute(new AnonymousClass1(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStop() {
            MoreExecutors.renamingDecorator(this.this$0.executor(), AbstractIdleService.access$200(this.this$0)).execute(new AnonymousClass2(this));
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return this.this$0.toString();
        }
    }

    private final class ThreadNameSupplier implements Supplier<String> {
        final /* synthetic */ AbstractIdleService this$0;

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        private ThreadNameSupplier(AbstractIdleService r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ThreadNameSupplier(AbstractIdleService r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.base.Supplier, java.util.function.Supplier
        public String get() {
            String r0 = this.this$0.serviceName();
            String r3 = String.valueOf(this.this$0.state());
            return new StringBuilder((String.valueOf(r0).length() + 1) + String.valueOf(r3).length()).append(r0).append(HanziToPinyin.Token.SEPARATOR).append(r3).toString();
        }
    }

    protected abstract void shutDown() throws Exception;

    protected abstract void startUp() throws Exception;

    static /* synthetic */ Supplier access$200(AbstractIdleService r0) {
        return r0.threadNameSupplier;
    }

    protected AbstractIdleService() {
        AnonymousClass1 r1 = null;
        this.threadNameSupplier = new ThreadNameSupplier(this, r1);
        this.delegate = new DelegateService(this, r1);
    }

    protected Executor executor() {
        return new AnonymousClass1(this);
    }

    public String toString() {
        String r0 = serviceName();
        String r3 = String.valueOf(state());
        return new StringBuilder((String.valueOf(r0).length() + 3) + String.valueOf(r3).length()).append(r0).append(" [").append(r3).append("]").toString();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener r1, Executor r2) {
        this.delegate.addListener(r1, r2);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(Duration r1) throws TimeoutException {
        super.awaitRunning(r1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long r1, TimeUnit r3) throws TimeoutException {
        this.delegate.awaitRunning(r1, r3);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(Duration r1) throws TimeoutException {
        super.awaitTerminated(r1);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long r1, TimeUnit r3) throws TimeoutException {
        this.delegate.awaitTerminated(r1, r3);
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }
}
