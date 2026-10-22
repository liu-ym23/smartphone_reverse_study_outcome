package okhttp3.internal.http;

import com.bytedance.retrofit2.HttpMethodContrants;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpMethod {
    public static boolean invalidatesCache(String r1) {
        if (r1.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals(HttpMethodContrants.PATCH) == true) goto L14;
        if (r1.equals(HttpMethodContrants.PUT) == true) goto L14;
        if (r1.equals(HttpMethodContrants.DELETE) == true) goto L14;
        if (r1.equals("MOVE") == true) goto L14;
        return false;
    }

    public static boolean requiresRequestBody(String r1) {
        if (r1.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals(HttpMethodContrants.PUT) == true) goto L14;
        if (r1.equals(HttpMethodContrants.PATCH) == true) goto L14;
        if (r1.equals("PROPPATCH") == true) goto L14;
        if (r1.equals("REPORT") == true) goto L14;
        return false;
    }

    public static boolean permitsRequestBody(String r1) {
        if (r1.equals(HttpMethodContrants.GET) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals(HttpMethodContrants.HEAD) == true) goto L7;
        return true;
    }

    public static boolean redirectsWithBody(String r1) {
        return r1.equals("PROPFIND");
    }

    public static boolean redirectsToGet(String r1) {
        return !r1.equals("PROPFIND");
    }

    private HttpMethod() {
    }
}
