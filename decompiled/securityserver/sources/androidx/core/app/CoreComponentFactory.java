package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 28)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CoreComponentFactory extends android.app.AppComponentFactory {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface CompatWrapped {
        Object getWrapper();
    }

    public CoreComponentFactory() {
    }

    public static <T> T checkCompatWrapper(T r1) {
        if ((r1 instanceof CompatWrapped) == false) goto L7;
        T r0 = (T) ((CompatWrapped) r1).getWrapper();
        if (r0 == null) goto L7;
        return r0;
    L7:
        return r1;
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public Activity instantiateActivity(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (Activity) checkCompatWrapper(super.instantiateActivity(r1, r2, r3));
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public Application instantiateApplication(@NonNull ClassLoader r1, @NonNull String r2) {
        return (Application) checkCompatWrapper(super.instantiateApplication(r1, r2));
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public ContentProvider instantiateProvider(@NonNull ClassLoader r1, @NonNull String r2) {
        return (ContentProvider) checkCompatWrapper(super.instantiateProvider(r1, r2));
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public BroadcastReceiver instantiateReceiver(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (BroadcastReceiver) checkCompatWrapper(super.instantiateReceiver(r1, r2, r3));
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public Service instantiateService(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (Service) checkCompatWrapper(super.instantiateService(r1, r2, r3));
    }
}
