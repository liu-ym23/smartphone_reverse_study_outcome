package com.android.settings.servicemanager;

import com.android.settings.service.ApiService;
import com.android.settings.service.bean.DeviceInfo;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.olog.OLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: IGuaranteeHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/android/settings/servicemanager/IGuaranteeHelp;", "", "getDeviceInfo", "Lcom/android/settings/service/bean/DeviceInfo;", "osLanguage", "", "model", "cert", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFistShowWarrantyCard", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IGuaranteeHelp {

    /* JADX INFO: compiled from: IGuaranteeHelp.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isFistShowWarrantyCard(IGuaranteeHelp r0) {
            return true;
        }

        public static Object getDeviceInfo(IGuaranteeHelp r6, String r7, String r8, String r9, Continuation<? super DeviceInfo> r10) {
            if ((r10 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r11 = (AnonymousClass1) r10;
            if ((r11.label & Integer.MIN_VALUE) == 0) goto L7;
            r11.label -= Integer.MIN_VALUE;
        L8:
            AnonymousClass1 r5 = r11;
            Object r12 = r5.result;
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = r5.label;
            if (r0 == 0) goto L15;
            if (r0 != 1) goto L14;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
        L19:
            Object r14 = Result.m1508constructorimpl((DeviceInfo) r12);     // Catch: Throwable -> L21
        L23:
            Throwable r15 = Result.m1511exceptionOrNullimpl(r14);
            if (r15 == null) goto L27;
            OLog.e("IGuaranteeHelp", "Request device info failed", r15);
        L27:
            if (Result.m1514isFailureimpl(r14) == false) goto L30;
            r14 = null;
        L30:
            return (DeviceInfo) r14;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r12);
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L21
            ApiService r1 = (ApiService) RetrofitUtils.getSsRetrofit("https://mtls-ota.obriccloud.com").create(ApiService.class);     // Catch: Throwable -> L21
            Map<String, String> r4 = MapsKt.mapOf(TuplesKt.to("x-att-certchain", r9));     // Catch: Throwable -> L21
            r5.label = 1;     // Catch: Throwable -> L21
            r12 = r1.getDeviceInfo(null, r7, r8, r4, r5);     // Catch: Throwable -> L21
            if (r12 != r13) goto L19;
            return r13;
        L21:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r14 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        L7:
            r11 = new AnonymousClass1(r10);
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.android.settings.servicemanager.IGuaranteeHelp$getDeviceInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: IGuaranteeHelp.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.servicemanager.IGuaranteeHelp$DefaultImpls", f = "IGuaranteeHelp.kt", i = {}, l = {24}, m = "getDeviceInfo", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DefaultImpls.getDeviceInfo(null, null, null, null, this);
        }
    }

    Object getDeviceInfo(String r1, String r2, String r3, Continuation<? super DeviceInfo> r4);

    boolean isFistShowWarrantyCard();
}
