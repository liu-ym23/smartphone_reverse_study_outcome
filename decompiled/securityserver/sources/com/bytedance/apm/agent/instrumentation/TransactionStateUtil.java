package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.transaction.TransactionState;
import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class TransactionStateUtil {
    private static final AgentLog log = null;

    static {
        log = AgentLogManager.getAgentLog();
    }

    public TransactionStateUtil() {
    }

    public static void inspectAndInstrument(TransactionState r2, HttpURLConnection r3) {
        r2.setUrl(r3.getURL().toString());
        r2.setStartTime(System.currentTimeMillis());
        r2.setCarrier("");
    }

    public static void inspectAndInstrumentResponse(TransactionState r2, HttpURLConnection r3) {
        int r0 = r3.getContentLength();
        if (r0 < 0) goto L10;
        r2.setBytesReceived(r0);
    L10:
        int r4 = r3.getResponseCode();     // Catch: Throwable -> L7
    L8:
        r2.setStatusCode(r4);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public static void setErrorCodeFromException(TransactionState r1, Exception r2) {
        if ((r2 instanceof UnknownHostException) == false) goto L6;
        r1.setErrorCode(-10);
        return;
    L6:
        if ((r2 instanceof SocketTimeoutException) == false) goto L8;
    L20:
        r1.setErrorCode(-11);
        return;
    L8:
        if ((r2 instanceof ConnectTimeoutException) == true) goto L20;
        if ((r2 instanceof ConnectException) == false) goto L14;
        r1.setErrorCode(-12);
        return;
    L14:
        if ((r2 instanceof MalformedURLException) == false) goto L17;
        r1.setErrorCode(-13);
        return;
    L17:
        if ((r2 instanceof SSLException) == false) goto L19;
        r1.setErrorCode(-14);
        return;
    L19:
        r1.setErrorCode(-1);
    }
}
