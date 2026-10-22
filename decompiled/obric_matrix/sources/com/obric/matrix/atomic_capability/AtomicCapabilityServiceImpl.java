package com.obric.matrix.atomic_capability;

import android.app.Application;
import com.obric.capabilitykit.f;
import com.obric.matrix.atomic_capability_api.IAtomicCapabilityService;
import com.obric.matrix.r.c.c;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/matrix/atomic_capability/AtomicCapabilityServiceImpl;", "Lcom/obric/matrix/atomic_capability_api/IAtomicCapabilityService;", "()V", "doInit", "", "application", "Landroid/app/Application;", "init", "Companion", "atomic_capability_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AtomicCapabilityServiceImpl implements IAtomicCapabilityService {
    public static final a Companion = null;
    private static final String TAG = "AtomicCapabilityServiceImpl";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/atomic_capability/AtomicCapabilityServiceImpl$Companion;", "", "()V", "TAG", "", "register", "", "Lcom/obric/matrix/atomic_capability/MatrixAtomicFunction;", "atomic_capability_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AtomicCapabilityServiceImpl() {
    }

    private final void doInit(Application r1) {
        f.f(new f.b(r1));
        c.b(TAG, "init complete");
    }

    @Override // com.obric.matrix.atomic_capability_api.IAtomicCapabilityService
    public void init(Application r1) {
        o.f(r1, "application");
    }
}
