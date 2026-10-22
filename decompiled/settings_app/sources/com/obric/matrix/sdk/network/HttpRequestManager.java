package com.obric.matrix.sdk.network;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.retrofit2.mime.TypedInput;
import com.obric.capabilitykit.common.Ext;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpRequestManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003!\"#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\t\u001a\u00020\n\"\u0006\b\u0000\u0010\u000b\u0018\u00012\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0086\bø\u0001\u0000JX\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004J~\u0010\u0019\u001a\u00020\n\"\b\b\u0000\u0010\u001a*\u00020\u001b\"\u0006\b\u0001\u0010\u000b\u0018\u00012\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u000e0\r2\u0016\b\n\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u00020\n\u0018\u00010\r2\u0016\b\n\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\n\u0018\u00010\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0086\bø\u0001\u0000Jl\u0010\u0019\u001a\u00020\n\"\b\b\u0000\u0010\u001a*\u00020\u001b\"\u0004\b\u0001\u0010\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u00172\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u000e0\u00182\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u001a\u0018\u00010\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"Lcom/obric/matrix/sdk/network/HttpRequestManager;", "", "()V", "DEFAULT_OBSERVE_SCHEDULER", "Lio/reactivex/Scheduler;", "getDEFAULT_OBSERVE_SCHEDULER", "()Lio/reactivex/Scheduler;", "DEFAULT_SUBSCRIBE_SCHEDULER", "getDEFAULT_SUBSCRIBE_SCHEDULER", "downloadFile", "", "API", "requestAction", "Lkotlin/Function1;", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "saveFile", "Ljava/io/File;", "downloadCallback", "Lcom/obric/matrix/sdk/network/HttpRequestManager$DownloadCallback;", "subscribeScheduler", "observeScheduler", "apiClass", "Ljava/lang/Class;", "Lio/reactivex/functions/Function;", Ext.KEY_REQUEST, ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/matrix/sdk/network/BaseResponseModel;", "successCallback", "errorCallback", "", "Lcom/obric/matrix/sdk/network/HttpRequestManager$HttpSuccessCallback;", "Lcom/obric/matrix/sdk/network/HttpRequestManager$HttpErrorCallback;", "DownloadCallback", "HttpErrorCallback", "HttpSuccessCallback", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HttpRequestManager {
    private static final Scheduler DEFAULT_OBSERVE_SCHEDULER = null;
    private static final Scheduler DEFAULT_SUBSCRIBE_SCHEDULER = null;
    public static final HttpRequestManager INSTANCE = null;

    /* JADX INFO: compiled from: HttpRequestManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/obric/matrix/sdk/network/HttpRequestManager$DownloadCallback;", "", "onError", "", "e", "", "onProgress", "progress", "", PerfConsts.PERF_DISK_TOTAL, "onSuccess", "file", "Ljava/io/File;", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DownloadCallback {
        void onError(Throwable r1);

        void onProgress(long r1, long r3);

        void onSuccess(File r1);
    }

    /* JADX INFO: compiled from: HttpRequestManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/matrix/sdk/network/HttpRequestManager$HttpErrorCallback;", "", "onError", "", "e", "", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface HttpErrorCallback {
        void onError(Throwable r1);
    }

    /* JADX INFO: compiled from: HttpRequestManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/sdk/network/HttpRequestManager$HttpSuccessCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/matrix/sdk/network/BaseResponseModel;", "", "onSuccess", "", "responseData", "(Lcom/obric/matrix/sdk/network/BaseResponseModel;)V", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface HttpSuccessCallback<T extends BaseResponseModel> {
        void onSuccess(T r1);
    }

    /* JADX INFO: renamed from: com.obric.matrix.sdk.network.HttpRequestManager$downloadFile$3, reason: invalid class name */
    /* JADX INFO: compiled from: HttpRequestManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004\u0018\u00012\u0006\u0010\u0005\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "kotlin.jvm.PlatformType", "API", "api", "apply", "(Ljava/lang/Object;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass3<T, R> implements Function {
        final /* synthetic */ Function1<API, Observable<TypedInput>> $requestAction;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function1<? super API, ? extends Observable<TypedInput>> r1) {
            this.$requestAction = r1;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Function
        public final Observable<TypedInput> apply(API r1) {
            return this.$requestAction.invoke(r1);
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.sdk.network.HttpRequestManager$request$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpRequestManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u00012\u0006\u0010\u0006\u001a\u0002H\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "Lcom/obric/matrix/sdk/network/BaseResponseModel;", "API", "api", "apply", "(Ljava/lang/Object;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class C02373<T, R> implements Function {
        final /* synthetic */ Function1<API, Observable<T>> $requestAction;

        /* JADX WARN: Multi-variable type inference failed */
        public C02373(Function1<? super API, ? extends Observable<T>> r1) {
            this.$requestAction = r1;
        }

        @Override // io.reactivex.functions.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Function
        public final Observable<T> apply(API r1) {
            return this.$requestAction.invoke(r1);
        }
    }

    public static /* synthetic */ void $r8$lambda$10NjoDNbQoGrb1P1JmVhzHNjKgg(HttpErrorCallback r0, Throwable r1) {
        m1043request$lambda1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$HHEDhKamZTVEa5A57EicjzSAqj4(File r0, DownloadCallback r1, TypedInput r2) {
        m1040downloadFile$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$gLaIEbbpz0vTzi8LtDjY_4Ma5fU(DownloadCallback r0, Throwable r1) {
        m1041downloadFile$lambda5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$llk83UbWDbW5QgGrsQ-mutcAdtE, reason: not valid java name */
    public static /* synthetic */ void m1039$r8$lambda$llk83UbWDbW5QgGrsQmutcAdtE(HttpSuccessCallback r0, BaseResponseModel r1) {
        m1042request$lambda0(r0, r1);
    }

    private HttpRequestManager() {
    }

    static {
        INSTANCE = new HttpRequestManager();
        Scheduler r0 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(r0, "io()");
        DEFAULT_SUBSCRIBE_SCHEDULER = r0;
        Scheduler r1 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(r1, "io()");
        DEFAULT_OBSERVE_SCHEDULER = r1;
    }

    public final Scheduler getDEFAULT_SUBSCRIBE_SCHEDULER() {
        return DEFAULT_SUBSCRIBE_SCHEDULER;
    }

    public final Scheduler getDEFAULT_OBSERVE_SCHEDULER() {
        return DEFAULT_OBSERVE_SCHEDULER;
    }

    public static /* synthetic */ void request$default(HttpRequestManager r7, Class r8, Function r9, HttpSuccessCallback r10, HttpErrorCallback r11, Scheduler r12, Scheduler r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = DEFAULT_SUBSCRIBE_SCHEDULER;
    L5:
        Scheduler r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        r13 = DEFAULT_OBSERVE_SCHEDULER;
    L8:
        r7.request(r8, r9, r10, r11, r5, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends BaseResponseModel, API> void request(Class<API> r1, Function<API, Observable<T>> r2, final HttpSuccessCallback<T> r3, final HttpErrorCallback r4, Scheduler r5, Scheduler r6) {
        Intrinsics.checkNotNullParameter(r1, "apiClass");
        Intrinsics.checkNotNullParameter(r2, "requestAction");
        Intrinsics.checkNotNullParameter(r5, "subscribeScheduler");
        Intrinsics.checkNotNullParameter(r6, "observeScheduler");
        Object r0 = OceanHttpUtil.INSTANCE.create(r1);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L5
        ((Observable) r2.apply(r0)).subscribeOn(r5).observeOn(r6).subscribe(new HttpRequestManager$$ExternalSyntheticLambda2(r3), new HttpRequestManager$$ExternalSyntheticLambda3(r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r4 == null) goto L11;
        r4.onError(e);
        return;
    }

    /* JADX INFO: renamed from: request$lambda-0, reason: not valid java name */
    private static final void m1042request$lambda0(HttpSuccessCallback r1, BaseResponseModel r2) {
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullExpressionValue(r2, "t");
        r1.onSuccess(r2);
        return;
    }

    /* JADX INFO: renamed from: request$lambda-1, reason: not valid java name */
    private static final void m1043request$lambda1(HttpErrorCallback r1, Throwable r2) {
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullExpressionValue(r2, "e");
        r1.onError(r2);
        return;
    }

    public static /* synthetic */ void request$default(HttpRequestManager r8, Function1 r9, Function1 r10, Function1 r11, Scheduler r12, Scheduler r13, int r14, Object r15) {
        HttpRequestManager$request$5$1 r0 = null;
        if ((r14 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r11 = null;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r12 = r8.getDEFAULT_SUBSCRIBE_SCHEDULER();
    L11:
        Scheduler r6 = r12;
        if ((r14 & 16) == 0) goto L14;
        r13 = r8.getDEFAULT_OBSERVE_SCHEDULER();
    L14:
        Scheduler r7 = r13;
        Intrinsics.checkNotNullParameter(r9, "requestAction");
        Intrinsics.checkNotNullParameter(r6, "subscribeScheduler");
        Intrinsics.checkNotNullParameter(r7, "observeScheduler");
        Intrinsics.reifiedOperationMarker(4, "API");
        C02373 r3 = new C02373(r9);
        if (r10 == null) goto L17;
        HttpRequestManager$request$4$1 r16 = new HttpRequestManager$request$4$1(r10);
    L18:
        HttpRequestManager$request$4$1 r4 = r16;
        if (r11 == null) goto L21;
        r0 = new HttpRequestManager$request$5$1(r11);
    L21:
        r8.request(Object.class, r3, r4, r0, r6, r7);
        return;
    L17:
        r16 = null;
        goto L18
    }

    public final /* synthetic */ <T extends BaseResponseModel, API> void request(Function1<? super API, ? extends Observable<T>> r10, Function1<? super T, Unit> r11, Function1<? super Throwable, Unit> r12, Scheduler r13, Scheduler r14) {
        Intrinsics.checkNotNullParameter(r10, "requestAction");
        Intrinsics.checkNotNullParameter(r13, "subscribeScheduler");
        Intrinsics.checkNotNullParameter(r14, "observeScheduler");
        Intrinsics.reifiedOperationMarker(4, "API");
        C02373 r4 = new C02373(r10);
        HttpRequestManager$request$5$1 r15 = null;
        if (r11 == null) goto L5;
        HttpRequestManager$request$4$1 r0 = new HttpRequestManager$request$4$1(r11);
    L6:
        HttpRequestManager$request$4$1 r5 = r0;
        if (r12 == null) goto L9;
        r15 = new HttpRequestManager$request$5$1(r12);
    L9:
        request(Object.class, r4, r5, r15, r13, r14);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static /* synthetic */ void downloadFile$default(HttpRequestManager r7, Class r8, Function r9, File r10, DownloadCallback r11, Scheduler r12, Scheduler r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = DEFAULT_SUBSCRIBE_SCHEDULER;
    L5:
        Scheduler r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        r13 = DEFAULT_OBSERVE_SCHEDULER;
    L8:
        r7.downloadFile(r8, r9, r10, r11, r5, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <API> void downloadFile(Class<API> r1, Function<API, Observable<TypedInput>> r2, final File r3, final DownloadCallback r4, Scheduler r5, Scheduler r6) {
        Intrinsics.checkNotNullParameter(r1, "apiClass");
        Intrinsics.checkNotNullParameter(r2, "requestAction");
        Intrinsics.checkNotNullParameter(r3, "saveFile");
        Intrinsics.checkNotNullParameter(r4, "downloadCallback");
        Intrinsics.checkNotNullParameter(r5, "subscribeScheduler");
        Intrinsics.checkNotNullParameter(r6, "observeScheduler");
    L8:
        e = move-exception;
        r4.onError(e);
        return;
    L4:
        if (r3.exists() == false) goto L6;
        r3.delete();     // Catch: Exception -> L8
    L6:
        MessageLoop.disableVaildThreadAssert(true);     // Catch: Exception -> L8
        Object r0 = OceanHttpUtil.INSTANCE.createDownloadService(r1);     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L8
        ((Observable) r2.apply(r0)).subscribeOn(r5).observeOn(r6).subscribe(new HttpRequestManager$$ExternalSyntheticLambda0(r3, r4), new HttpRequestManager$$ExternalSyntheticLambda1(r4));     // Catch: Exception -> L8
    }

    /* JADX INFO: renamed from: downloadFile$lambda-4, reason: not valid java name */
    private static final void m1040downloadFile$lambda4(File r2, DownloadCallback r3, TypedInput r4) {
        Intrinsics.checkNotNullParameter(r2, "$saveFile");
        Intrinsics.checkNotNullParameter(r3, "$downloadCallback");
        DownloadFileUtils r0 = DownloadFileUtils.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r4, "typedInput");
        r0.writeTypedInputToDisk(r4, r2, r3);
    }

    /* JADX INFO: renamed from: downloadFile$lambda-5, reason: not valid java name */
    private static final void m1041downloadFile$lambda5(DownloadCallback r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "$downloadCallback");
        Intrinsics.checkNotNullExpressionValue(r2, "e");
        r1.onError(r2);
    }

    public static /* synthetic */ void downloadFile$default(HttpRequestManager r7, Function1 r8, File r9, DownloadCallback r10, Scheduler r11, Scheduler r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        r11 = r7.getDEFAULT_SUBSCRIBE_SCHEDULER();
    L5:
        Scheduler r5 = r11;
        if ((r13 & 16) == 0) goto L8;
        r12 = r7.getDEFAULT_OBSERVE_SCHEDULER();
    L8:
        Scheduler r6 = r12;
        Intrinsics.checkNotNullParameter(r8, "requestAction");
        Intrinsics.checkNotNullParameter(r9, "saveFile");
        Intrinsics.checkNotNullParameter(r10, "downloadCallback");
        Intrinsics.checkNotNullParameter(r5, "subscribeScheduler");
        Intrinsics.checkNotNullParameter(r6, "observeScheduler");
        Intrinsics.reifiedOperationMarker(4, "API");
        r7.downloadFile(Object.class, new AnonymousClass3(r8), r9, r10, r5, r6);
    }

    public final /* synthetic */ <API> void downloadFile(Function1<? super API, ? extends Observable<TypedInput>> r10, File r11, DownloadCallback r12, Scheduler r13, Scheduler r14) {
        Intrinsics.checkNotNullParameter(r10, "requestAction");
        Intrinsics.checkNotNullParameter(r11, "saveFile");
        Intrinsics.checkNotNullParameter(r12, "downloadCallback");
        Intrinsics.checkNotNullParameter(r13, "subscribeScheduler");
        Intrinsics.checkNotNullParameter(r14, "observeScheduler");
        Intrinsics.reifiedOperationMarker(4, "API");
        downloadFile(Object.class, new AnonymousClass3(r10), r11, r12, r13, r14);
    }
}
