package com.obric.matrix.location;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes2.dex */
public class i implements BDLocationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public String f9210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f9211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f9213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f9214i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    String f9215j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    String f9216k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f9217l;

    public i() {
        this.f9206a = false;
        this.f9207b = false;
        this.f9208c = false;
        this.f9209d = 0;
        this.f9210e = "";
        this.f9211f = 0;
        this.f9212g = 0;
        this.f9213h = false;
        this.f9214i = false;
        this.f9215j = "";
        this.f9216k = "";
        this.f9217l = 0;
    }

    public long a() {
        return this.f9212g - this.f9211f;
    }

    public void b() {
        this.f9211f = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public void onError(@Nullable BDLocationException r3) {
        this.f9212g = SystemClock.elapsedRealtime();
        this.f9215j = "onError";
        if (r3 == null) goto L6;
        this.f9216k = r3.toString();
        return;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public void onLocationChanged(@Nullable BDLocation r3) {
        this.f9212g = SystemClock.elapsedRealtime();
        this.f9215j = "onLocationChanged";
        this.f9213h = h.b(r3);
        this.f9214i = h.a(r3);
    }

    @NonNull
    public String toString() {
        return "RetryInfo{force=" + this.f9206a + ", needDelay=" + this.f9207b + ", mIgnoreCache=" + this.f9208c + ", retryCount=" + this.f9209d + ", triggerType=" + this.f9210e + "}";
    }
}
