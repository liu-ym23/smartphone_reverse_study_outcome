package com.obric.matrix.account.r;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/account/util/DidViewModel;", "", "()V", "TAG", "", "did", "Landroidx/lifecycle/MutableLiveData;", "getDid", "()Landroidx/lifecycle/MutableLiveData;", "did$delegate", "Lkotlin/Lazy;", WsConstants.KEY_INSTALL_ID, "getIid", "iid$delegate", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f8618b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f8619c = null;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/account/util/DidViewModel$1", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", "installId", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.matrix.ostracker_api.a {
        a() {
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(String r2) {
            com.obric.matrix.r.c.c.b("DidViewModel", "the did from the onDeviceIdLoaded callback is " + r2);
            c.f8617a.a().postValue(r2);
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(String r2) {
            com.obric.matrix.r.c.c.b("DidViewModel", "the installId from the onInstallIdLoaded callback is " + r2);
            c.f8617a.b().postValue(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<MutableLiveData<String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f8620f = null;

        static {
            f8620f = new b();
        }

        b() {
            super(0);
        }

        public final MutableLiveData<String> a() {
            return new MutableLiveData();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ MutableLiveData<String> invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.account.r.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C0226c extends q implements kotlin.n0.c.a<MutableLiveData<String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0226c f8621f = null;

        static {
            f8621f = new C0226c();
        }

        C0226c() {
            super(0);
        }

        public final MutableLiveData<String> a() {
            return new MutableLiveData();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ MutableLiveData<String> invoke() {
            return a();
        }
    }

    static {
        c r0 = new c();
        f8617a = r0;
        f8618b = i.b(b.f8620f);
        f8619c = i.b(C0226c.f8621f);
        com.obric.matrix.ostracker_api.b.a(new a());
        r0.a().setValue(com.obric.matrix.ostracker_api.b.c());
        r0.b().setValue(com.obric.matrix.ostracker_api.b.e());
        com.obric.matrix.r.c.c.b("DidViewModel", "init: did " + r0.a().getValue());
        com.obric.matrix.r.c.c.b("DidViewModel", "init: iid " + r0.b().getValue());
    }

    private c() {
    }

    public final MutableLiveData<String> a() {
        return (MutableLiveData) f8618b.getValue();
    }

    public final MutableLiveData<String> b() {
        return (MutableLiveData) f8619c.getValue();
    }
}
