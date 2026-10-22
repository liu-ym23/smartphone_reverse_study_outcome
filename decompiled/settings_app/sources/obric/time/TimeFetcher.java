package obric.time;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
abstract class TimeFetcher implements Callable<ReferenceTime> {
    public static final String HTTP_RESPONSE_HEADER_DATE = "Date";
    private String mFetcherType;
    protected String mUrl;

    abstract ReferenceTime doTimeFetch();

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ ReferenceTime call() throws Exception {
        return call2();
    }

    public TimeFetcher(String r1, String r2) {
        this.mFetcherType = r1;
        this.mUrl = r2;
    }

    public String getFetcherType() {
        return this.mFetcherType;
    }

    public void setUrl(String r1) {
        this.mUrl = r1;
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public ReferenceTime call2() throws Exception {
        return doTimeFetch();
    }
}
