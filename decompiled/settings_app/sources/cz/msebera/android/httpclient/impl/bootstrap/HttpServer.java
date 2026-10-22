package cz.msebera.android.httpclient.impl.bootstrap;

import cz.msebera.android.httpclient.ExceptionLogger;
import cz.msebera.android.httpclient.HttpConnectionFactory;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.impl.DefaultBHttpServerConnection;
import cz.msebera.android.httpclient.protocol.HttpService;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;

/* JADX INFO: loaded from: classes5.dex */
public class HttpServer {
    private final HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpService;
    private final InetAddress ifAddress;
    private final ThreadPoolExecutor listenerExecutorService;
    private final int port;
    private volatile RequestListener requestListener;
    private volatile ServerSocket serverSocket;
    private final ServerSocketFactory serverSocketFactory;
    private final SocketConfig socketConfig;
    private final SSLServerSetupHandler sslSetupHandler;
    private final AtomicReference<Status> status;
    private final WorkerPoolExecutor workerExecutorService;
    private final ThreadGroup workerThreads;

    static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ACTIVE = null;
        public static final Status READY = null;
        public static final Status STOPPING = null;

        static {
            Status r0 = new Status("READY", 0);
            READY = r0;
            Status r1 = new Status("ACTIVE", 1);
            ACTIVE = r1;
            Status r3 = new Status("STOPPING", 2);
            STOPPING = r3;
            $VALUES = new Status[]{r0, r1, r3};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r1) {
            return (Status) Enum.valueOf(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    HttpServer(int r13, InetAddress r14, SocketConfig r15, ServerSocketFactory r16, HttpService r17, HttpConnectionFactory<? extends DefaultBHttpServerConnection> r18, SSLServerSetupHandler r19, ExceptionLogger r20) {
        this.port = r13;
        this.ifAddress = r14;
        this.socketConfig = r15;
        this.serverSocketFactory = r16;
        this.httpService = r17;
        this.connectionFactory = r18;
        this.sslSetupHandler = r19;
        this.exceptionLogger = r20;
        this.listenerExecutorService = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-listener-" + r13));
        ThreadGroup r1 = new ThreadGroup("HTTP-workers");
        this.workerThreads = r1;
        this.workerExecutorService = new WorkerPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-worker", r1));
        this.status = new AtomicReference(Status.READY);
    }

    public InetAddress getInetAddress() {
        ServerSocket r0 = this.serverSocket;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getInetAddress();
    }

    public int getLocalPort() {
        ServerSocket r0 = this.serverSocket;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getLocalPort();
    }

    public void start() throws IOException {
        if (this.status.compareAndSet(Status.READY, Status.ACTIVE) == false) goto L14;
        this.serverSocket = this.serverSocketFactory.createServerSocket(this.port, this.socketConfig.getBacklogSize(), this.ifAddress);
        this.serverSocket.setReuseAddress(this.socketConfig.isSoReuseAddress());
        if (this.socketConfig.getRcvBufSize() <= 0) goto L8;
        this.serverSocket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
    L8:
        if (this.sslSetupHandler != null) goto L10;
    L12:
        this.requestListener = new RequestListener(this.socketConfig, this.serverSocket, this.httpService, this.connectionFactory, this.exceptionLogger, this.workerExecutorService);
        this.listenerExecutorService.execute(this.requestListener);
        return;
    L10:
        if ((this.serverSocket instanceof SSLServerSocket) == false) goto L12;
        this.sslSetupHandler.initialize((SSLServerSocket) this.serverSocket);
        goto L12
    }

    public void stop() {
        if (this.status.compareAndSet(Status.ACTIVE, Status.STOPPING) == false) goto L14;
        this.listenerExecutorService.shutdown();
        this.workerExecutorService.shutdown();
        RequestListener r0 = this.requestListener;
        if (r0 != null) goto L12;
    L10:
        this.workerThreads.interrupt();
        return;
    L12:
        r0.terminate();     // Catch: IOException -> L8
    L8:
        e = move-exception;
        this.exceptionLogger.log(e);
        goto L10
    }

    public void awaitTermination(long r1, TimeUnit r3) throws InterruptedException {
        this.workerExecutorService.awaitTermination(r1, r3);
    }

    public void shutdown(long r3, TimeUnit r5) {
        stop();
        if (r3 > 0) goto L18;
    L7:
        Iterator<Worker> r4 = this.workerExecutorService.getWorkers().iterator();
    L9:
        if (r4.hasNext() == false) goto L15;
        r4.next().getConnection().shutdown();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        this.exceptionLogger.log(e);
        goto L9
    L15:
        return;
    L18:
        awaitTermination(r3, r5);     // Catch: InterruptedException -> L6
    L6:
        Thread.currentThread().interrupt();
        goto L7
    }
}
