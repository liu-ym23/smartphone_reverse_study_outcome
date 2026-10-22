package com.obric.matrix.sdk.network;

import com.bytedance.retrofit2.mime.TypedInput;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HttpRequestManager {

    @NotNull
    private static final Scheduler DEFAULT_OBSERVE_SCHEDULER = null;

    @NotNull
    private static final Scheduler DEFAULT_SUBSCRIBE_SCHEDULER = null;

    @NotNull
    public static final HttpRequestManager INSTANCE = null;

    @Metadata
    public interface DownloadCallback {
        void onError(@NotNull Throwable r1);

        void onProgress(long r1, long r3);

        void onSuccess(@NotNull File r1);
    }

    @Metadata
    public interface HttpErrorCallback {
        void onError(@NotNull Throwable r1);
    }

    @Metadata
    public interface HttpSuccessCallback<T extends BaseResponseModel> {
        void onSuccess(@NotNull T r1);
    }

    /* JADX INFO: renamed from: com.obric.matrix.sdk.network.HttpRequestManager$downloadFile$3, reason: invalid class name */
    @Metadata
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
            return (Observable) this.$requestAction.invoke(r1);
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.sdk.network.HttpRequestManager$request$3, reason: invalid class name and case insensitive filesystem */
    @Metadata
    public static final class C00373<T, R> implements Function {
        final /* synthetic */ Function1<API, Observable<T>> $requestAction;

        /* JADX WARN: Multi-variable type inference failed */
        public C00373(Function1<? super API, ? extends Observable<T>> r1) {
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
            return (Observable) this.$requestAction.invoke(r1);
        }
    }

    static {
        INSTANCE = new HttpRequestManager();
        Scheduler r0 = Schedulers.io();
        Intrinsics.e(r0, "io()");
        DEFAULT_SUBSCRIBE_SCHEDULER = r0;
        Scheduler r1 = Schedulers.io();
        Intrinsics.e(r1, "io()");
        DEFAULT_OBSERVE_SCHEDULER = r1;
    }

    private HttpRequestManager() {
    }

    public static /* synthetic */ void a(HttpSuccessCallback r0, BaseResponseModel r1) {
        m38request$lambda0(r0, r1);
    }

    public static /* synthetic */ void b(File r0, DownloadCallback r1, TypedInput r2) {
        m36downloadFile$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void c(DownloadCallback r0, Throwable r1) {
        m37downloadFile$lambda5(r0, r1);
    }

    public static /* synthetic */ void d(HttpErrorCallback r0, Throwable r1) {
        m39request$lambda1(r0, r1);
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

    /* JADX INFO: renamed from: downloadFile$lambda-4, reason: not valid java name */
    private static final void m36downloadFile$lambda4(File r2, DownloadCallback r3, TypedInput r4) {
        Intrinsics.f(r2, "$saveFile");
        Intrinsics.f(r3, "$downloadCallback");
        DownloadFileUtils r0 = DownloadFileUtils.INSTANCE;
        Intrinsics.e(r4, "typedInput");
        r0.writeTypedInputToDisk(r4, r2, r3);
    }

    /* JADX INFO: renamed from: downloadFile$lambda-5, reason: not valid java name */
    private static final void m37downloadFile$lambda5(DownloadCallback r1, Throwable r2) {
        Intrinsics.f(r1, "$downloadCallback");
        Intrinsics.e(r2, "e");
        r1.onError(r2);
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

    /* JADX INFO: renamed from: request$lambda-0, reason: not valid java name */
    private static final void m38request$lambda0(HttpSuccessCallback r1, BaseResponseModel r2) {
        if (r1 == null) goto L5;
        Intrinsics.e(r2, "t");
        r1.onSuccess(r2);
        return;
    }

    /* JADX INFO: renamed from: request$lambda-1, reason: not valid java name */
    private static final void m39request$lambda1(HttpErrorCallback r1, Throwable r2) {
        if (r1 == null) goto L5;
        Intrinsics.e(r2, "e");
        r1.onError(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <API> void downloadFile(@NotNull Class<API> r1, @NotNull Function<API, Observable<TypedInput>> r2, @NotNull final File r3, @NotNull final DownloadCallback r4, @NotNull Scheduler r5, @NotNull Scheduler r6) {
        Intrinsics.f(r1, "apiClass");
        Intrinsics.f(r2, "requestAction");
        Intrinsics.f(r3, "saveFile");
        Intrinsics.f(r4, "downloadCallback");
        Intrinsics.f(r5, "subscribeScheduler");
        Intrinsics.f(r6, "observeScheduler");
    L6:
        e = move-exception;
        r4.onError(e);
        return;
    L4:
        if (r3.exists() == false) goto L8;
        r3.delete();     // Catch: Exception -> L6
    L8:
        MessageLoop.disableVaildThreadAssert(true);     // Catch: Exception -> L6
        Object r0 = OceanHttpUtil.INSTANCE.createDownloadService(r1);     // Catch: Exception -> L6
        Intrinsics.c(r0);     // Catch: Exception -> L6
        ((Observable) r2.apply(r0)).subscribeOn(r5).observeOn(r6).subscribe(new b(r3, r4), new a(2, r4));     // Catch: Exception -> L6
    }

    @NotNull
    public final Scheduler getDEFAULT_OBSERVE_SCHEDULER() {
        return DEFAULT_OBSERVE_SCHEDULER;
    }

    @NotNull
    public final Scheduler getDEFAULT_SUBSCRIBE_SCHEDULER() {
        return DEFAULT_SUBSCRIBE_SCHEDULER;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends BaseResponseModel, API> void request(@NotNull Class<API> r1, @NotNull Function<API, Observable<T>> r2, @Nullable HttpSuccessCallback<T> r3, @Nullable HttpErrorCallback r4, @NotNull Scheduler r5, @NotNull Scheduler r6) {
        Intrinsics.f(r1, "apiClass");
        Intrinsics.f(r2, "requestAction");
        Intrinsics.f(r5, "subscribeScheduler");
        Intrinsics.f(r6, "observeScheduler");
        Object r0 = OceanHttpUtil.INSTANCE.create(r1);     // Catch: Exception -> L5
        Intrinsics.c(r0);     // Catch: Exception -> L5
        ((Observable) r2.apply(r0)).subscribeOn(r5).observeOn(r6).subscribe(new a(0, r3), new a(1, r4));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (r4 == null) goto L11;
        r4.onError(e);
        return;
    }

    public static void downloadFile$default(HttpRequestManager r0, Function1 r1, File r2, DownloadCallback r3, Scheduler r4, Scheduler r5, int r6, Object r7) {
        if ((r6 & 8) == 0) goto L6;
        r4 = r0.getDEFAULT_SUBSCRIBE_SCHEDULER();
    L6:
        if ((r6 & 16) == 0) goto L8;
        r5 = r0.getDEFAULT_OBSERVE_SCHEDULER();
    L8:
        Intrinsics.f(r1, "requestAction");
        Intrinsics.f(r2, "saveFile");
        Intrinsics.f(r3, "downloadCallback");
        Intrinsics.f(r4, "subscribeScheduler");
        Intrinsics.f(r5, "observeScheduler");
        Intrinsics.l();
        throw null;
    }

    public static void request$default(HttpRequestManager r0, Function1 r1, Function1 r2, Function1 r3, Scheduler r4, Scheduler r5, int r6, Object r7) {
        if ((r6 & 8) == 0) goto L6;
        r4 = r0.getDEFAULT_SUBSCRIBE_SCHEDULER();
    L6:
        if ((r6 & 16) == 0) goto L8;
        r5 = r0.getDEFAULT_OBSERVE_SCHEDULER();
    L8:
        Intrinsics.f(r1, "requestAction");
        Intrinsics.f(r4, "subscribeScheduler");
        Intrinsics.f(r5, "observeScheduler");
        Intrinsics.l();
        throw null;
    }

    public final <T extends BaseResponseModel, API> void request(Function1<? super API, ? extends Observable<T>> r1, Function1<? super T, Unit> r2, Function1<? super Throwable, Unit> r3, Scheduler r4, Scheduler r5) {
        Intrinsics.f(r1, "requestAction");
        Intrinsics.f(r4, "subscribeScheduler");
        Intrinsics.f(r5, "observeScheduler");
        Intrinsics.l();
        throw null;
    }

    public final <API> void downloadFile(Function1<? super API, ? extends Observable<TypedInput>> r1, File r2, DownloadCallback r3, Scheduler r4, Scheduler r5) {
        Intrinsics.f(r1, "requestAction");
        Intrinsics.f(r2, "saveFile");
        Intrinsics.f(r3, "downloadCallback");
        Intrinsics.f(r4, "subscribeScheduler");
        Intrinsics.f(r5, "observeScheduler");
        Intrinsics.l();
        throw null;
    }
}
