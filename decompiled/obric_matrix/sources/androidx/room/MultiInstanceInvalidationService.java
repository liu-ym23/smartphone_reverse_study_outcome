package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MultiInstanceInvalidationService extends Service {
    private final IMultiInstanceInvalidationService.Stub mBinder;
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList;
    final HashMap<Integer, String> mClientNames;
    int mMaxClientId;

    public MultiInstanceInvalidationService() {
        this.mMaxClientId = 0;
        this.mClientNames = new HashMap();
        this.mCallbackList = new AnonymousClass1(this);
        this.mBinder = new AnonymousClass2(this);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent r1) {
        return this.mBinder;
    }
}
