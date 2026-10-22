package com.bytedance.feedbackerlib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.m.t;

/* JADX INFO: loaded from: classes.dex */
public class FeedbackCommonInfo extends com.bytedance.feedbackerlib.service.a.AbstractBinderC0145a implements Parcelable {
    public static final Parcelable.Creator<FeedbackCommonInfo> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Feedbacker.IFeedbackCommonInfo f4469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Feedbacker.n f4470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Feedbacker.o f4471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bytedance.feedbackerlib.service.a f4472i;

    static class a implements Parcelable.Creator<FeedbackCommonInfo> {
        a() {
        }

        public FeedbackCommonInfo a(Parcel r1) {
            return new FeedbackCommonInfo(r1);
        }

        public FeedbackCommonInfo[] b(int r1) {
            return new FeedbackCommonInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeedbackCommonInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeedbackCommonInfo[] newArray(int r1) {
            return b(r1);
        }
    }

    class b implements Feedbacker.IFeedbackCommonInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f4476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f4477e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4478f;

        b(FeedbackCommonInfo r1, int r2, String r3, String r4, String r5, String r6, String r7) {
            this.f4473a = r2;
            this.f4474b = r3;
            this.f4475c = r4;
            this.f4476d = r5;
            this.f4477e = r6;
            this.f4478f = r7;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        @Nullable
        public String getALogFilesDir() {
            return this.f4478f;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        public int getAid() {
            return this.f4473a;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        @NonNull
        public String getAppId() {
            return this.f4474b;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        @NonNull
        public String getChannel() {
            return this.f4477e;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        @NonNull
        public String getDid() {
            return this.f4475c;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        @Nullable
        public Feedbacker.n getOnFeedbackClickListener() {
            return null;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        @Nullable
        public Feedbacker.o getOnMediasUploadFailedListener() {
            return null;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        @NonNull
        public String getUpdateVersionCode() {
            return this.f4476d;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.IFeedbackCommonInfo
        @Nullable
        public String getUserId() {
            return null;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackCommonInfo f4479f;

        c(FeedbackCommonInfo r1) {
            this.f4479f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedbackCommonInfo.l0(this.f4479f).b();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackCommonInfo f4480f;

        d(FeedbackCommonInfo r1) {
            this.f4480f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedbackCommonInfo.m0(this.f4480f).f();
        }
    }

    static {
        CREATOR = new a();
    }

    protected FeedbackCommonInfo(Parcel r1) {
        com.bytedance.feedbackerlib.service.a r2 = com.bytedance.feedbackerlib.service.a.AbstractBinderC0145a.j0(r1.readStrongBinder());
        this.f4472i = r2;
        this.f4469f = n0(r2);
        this.f4470g = null;
        this.f4471h = null;
    }

    public FeedbackCommonInfo(@NonNull Feedbacker.IFeedbackCommonInfo r2) {
        this.f4469f = r2;
        this.f4470g = r2.getOnFeedbackClickListener();
        this.f4471h = r2.getOnMediasUploadFailedListener();
        this.f4472i = null;
    }

    static /* synthetic */ Feedbacker.n l0(FeedbackCommonInfo r0) {
        return r0.f4470g;
    }

    static /* synthetic */ Feedbacker.o m0(FeedbackCommonInfo r0) {
        return r0.f4471h;
    }

    private Feedbacker.IFeedbackCommonInfo n0(com.bytedance.feedbackerlib.service.a r10) {
        if (r10 != null) goto L10;
        return null;
    L10:
        int r3 = r10.getAid();     // Catch: Throwable -> L7
        String r5 = r10.getDid();     // Catch: Throwable -> L7
        String r4 = r10.getAppId();     // Catch: Throwable -> L7
        String r8 = r10.getALogFilesDir();     // Catch: Throwable -> L7
        return new b(this, r3, r4, r5, r10.getUpdateVersionCode(), r10.getChannel(), r8);
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public void b() {
        if (this.f4470g == null) goto L5;
        t.a(new c(this));
        return;
    L5:
        com.bytedance.feedbackerlib.service.a r1 = this.f4472i;
        if (r1 == null) goto L10;
        r1.b();
        return;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public void f() {
        if (this.f4471h == null) goto L5;
        t.a(new d(this));
        return;
    L5:
        com.bytedance.feedbackerlib.service.a r1 = this.f4472i;
        if (r1 == null) goto L10;
        r1.f();
        return;
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public String getALogFilesDir() {
        Feedbacker.IFeedbackCommonInfo r0 = this.f4469f;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.feedbackerlib.service.a r2 = this.f4472i;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getALogFilesDir();
    L5:
        if (TextUtils.isEmpty(r0.getALogFilesDir()) == true) goto L8;
        Log.d("mIFeedbackCommonInfo", "aLogFilesDir: " + this.f4469f.getALogFilesDir());
        return this.f4469f.getALogFilesDir();
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public int getAid() {
        Feedbacker.IFeedbackCommonInfo r0 = this.f4469f;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.feedbackerlib.service.a r2 = this.f4472i;
        if (r2 != null) goto L11;
        return -1;
    L11:
        return r2.getAid();
    L5:
        if (r0.getAid() <= 0) goto L8;
        Log.d("mIFeedbackCommonInfo", "aid: " + this.f4469f.getAid());
        return this.f4469f.getAid();
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public String getAppId() {
        Feedbacker.IFeedbackCommonInfo r0 = this.f4469f;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.feedbackerlib.service.a r2 = this.f4472i;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getAppId();
    L5:
        if (TextUtils.isEmpty(r0.getAppId()) == true) goto L8;
        Log.d("mIFeedbackCommonInfo", "appId: " + this.f4469f.getAppId());
        return this.f4469f.getAppId();
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public String getChannel() {
        Feedbacker.IFeedbackCommonInfo r0 = this.f4469f;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.feedbackerlib.service.a r2 = this.f4472i;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getChannel();
    L5:
        if (TextUtils.isEmpty(r0.getChannel()) == true) goto L8;
        Log.d("mIFeedbackCommonInfo", "channel: " + this.f4469f.getChannel());
        return this.f4469f.getChannel();
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public String getDid() {
        Feedbacker.IFeedbackCommonInfo r0 = this.f4469f;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.feedbackerlib.service.a r2 = this.f4472i;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getDid();
    L5:
        if (TextUtils.isEmpty(r0.getDid()) == true) goto L8;
        Log.d("mIFeedbackCommonInfo", "did: " + this.f4469f.getDid());
        return this.f4469f.getDid();
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public String getUpdateVersionCode() {
        Feedbacker.IFeedbackCommonInfo r0 = this.f4469f;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.feedbackerlib.service.a r2 = this.f4472i;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getUpdateVersionCode();
    L5:
        if (TextUtils.isEmpty(r0.getUpdateVersionCode()) == true) goto L8;
        Log.d("mIFeedbackCommonInfo", "UpdateVersionCode: " + this.f4469f.getUpdateVersionCode());
        return this.f4469f.getUpdateVersionCode();
    }

    @Override // com.bytedance.feedbackerlib.service.a
    public String getUserId() {
        Feedbacker.IFeedbackCommonInfo r0 = this.f4469f;
        if (r0 != null) goto L5;
    L8:
        com.bytedance.feedbackerlib.service.a r2 = this.f4472i;
        if (r2 != null) goto L11;
        return null;
    L11:
        return r2.getUserId();
    L5:
        if (TextUtils.isEmpty(r0.getUserId()) == true) goto L8;
        Log.d("mIFeedbackCommonInfo", "userId: " + this.f4469f.getUserId());
        return this.f4469f.getUserId();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeStrongBinder(this);
    }
}
