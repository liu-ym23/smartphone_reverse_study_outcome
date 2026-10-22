package obric.time;

import android.os.SystemClock;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes5.dex */
class HttpHeadTimeFetcher extends TimeFetcher {
    public static final String FETCHER_TYPE = "https";
    private static final int MAX_NETWORK_INTERVAL = 5000;
    private static final int RESPONSE_STATUS_CODE = 204;
    private static final String SMT_TIME_URL = "https://connectivitycheck.oceancloudapi.com/generate_204";
    private static final int TIME_FETCH_TIMEOUT = 3000;

    /* JADX INFO: renamed from: obric.time.HttpHeadTimeFetcher$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class MyTrustManager implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] r1, String r2) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] r1, String r2) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        private MyTrustManager() {
        }

        /* synthetic */ MyTrustManager(AnonymousClass1 r1) {
            this();
        }
    }

    public HttpHeadTimeFetcher() {
        super(FETCHER_TYPE, SMT_TIME_URL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r12v13, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    @Override // obric.time.TimeFetcher
    public ReferenceTime doTimeFetch() {
        String r12 = getUrl();
        ?? r2 = 0;
        if (TextUtils.isEmpty(r12) == false) goto L44;
        return null;
    L44:
        URL r1 = new URL(r12);     // Catch: Throwable -> L28 Exception -> L30
        long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L28 Exception -> L30
        if (r1.getProtocol().toLowerCase().equals(FETCHER_TYPE) == false) goto L12;
        ?? r13 = (HttpsURLConnection) r1.openConnection();     // Catch: Throwable -> L28 Exception -> L30
        HttpsURLConnection r4 = (HttpsURLConnection) r13;     // Catch: Exception -> L10 Throwable -> L36
        trustAllHosts(r13);     // Catch: Exception -> L10 Throwable -> L36
        r13 = r13;
    L14:
        r13.setConnectTimeout(3000);     // Catch: Exception -> L10 Throwable -> L36
        r13.setReadTimeout(3000);     // Catch: Exception -> L10 Throwable -> L36
        r13.setDoInput(true);     // Catch: Exception -> L10 Throwable -> L36
        r13.setInstanceFollowRedirects(true);     // Catch: Exception -> L10 Throwable -> L36
        r13.setRequestMethod("GET");     // Catch: Exception -> L10 Throwable -> L36
        r13.setUseCaches(false);     // Catch: Exception -> L10 Throwable -> L36
        r13.setRequestProperty("Connection", "Close");     // Catch: Exception -> L10 Throwable -> L36
        r13.connect();     // Catch: Exception -> L10 Throwable -> L36
        long r5 = SystemClock.elapsedRealtime();     // Catch: Exception -> L10 Throwable -> L36
        if (r13.getResponseCode() != 204) goto L17;
        long r10 = r13.getHeaderFieldDate("Date", -1);     // Catch: Exception -> L10 Throwable -> L36
    L18:
        long r6 = r5 - r3;     // Catch: Exception -> L10 Throwable -> L36
        if (r10 != (-1)) goto L21;
    L26:
        if (r13 == 0) goto L35;
    L27:
        r13.disconnect();
    L35:
        return null;
    L21:
        if (r6 > 5000) goto L26;
        ReferenceTime r7 = new ReferenceTime(r10 + (r6 / 2), r5);     // Catch: Exception -> L10 Throwable -> L36
        if (r13 == 0) goto L25;
        r13.disconnect();
    L25:
        return r7;
    L17:
        r10 = -1;
    L10:
        e = e;
    L32:
        OLog.e("TimeProvider", "Failed to fetch server time with ex: " + e);     // Catch: Throwable -> L36
        e.printStackTrace();     // Catch: Throwable -> L36
        if (r13 == 0) goto L35;
    L12:
        r13 = (HttpURLConnection) r1.openConnection();     // Catch: Throwable -> L28 Exception -> L30
    L30:
        e = e;
        r13 = 0;
    L28:
        th = th;
    L38:
        if (r2 == 0) goto L40;
        r2.disconnect();
    L40:
        throw th;
    L36:
        th = th;
        r2 = r12;
        goto L38
    }

    private static void trustAllHosts(HttpsURLConnection r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        SSLContext r0 = SSLContext.getInstance("TLS");     // Catch: Exception -> L6
        r0.init(null, new X509TrustManager[]{new MyTrustManager(null)}, new SecureRandom());     // Catch: Exception -> L6
        r5.setSSLSocketFactory(r0.getSocketFactory());     // Catch: Exception -> L6
        r5.setHostnameVerifier(new DefaultHostNameVerify());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }
}
