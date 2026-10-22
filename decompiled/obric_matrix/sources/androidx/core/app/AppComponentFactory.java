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

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public class AppComponentFactory extends android.app.AppComponentFactory {
    public AppComponentFactory() {
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final Activity instantiateActivity(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (Activity) CoreComponentFactory.checkCompatWrapper(instantiateActivityCompat(r1, r2, r3));
    }

    @NonNull
    public Activity instantiateActivityCompat(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (Activity) Class.forName(r2, false, r1).asSubclass(Activity.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final Application instantiateApplication(@NonNull ClassLoader r1, @NonNull String r2) {
        return (Application) CoreComponentFactory.checkCompatWrapper(instantiateApplicationCompat(r1, r2));
    }

    @NonNull
    public Application instantiateApplicationCompat(@NonNull ClassLoader r1, @NonNull String r2) {
        return (Application) Class.forName(r2, false, r1).asSubclass(Application.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final ContentProvider instantiateProvider(@NonNull ClassLoader r1, @NonNull String r2) {
        return (ContentProvider) CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(r1, r2));
    }

    @NonNull
    public ContentProvider instantiateProviderCompat(@NonNull ClassLoader r1, @NonNull String r2) {
        return (ContentProvider) Class.forName(r2, false, r1).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final BroadcastReceiver instantiateReceiver(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (BroadcastReceiver) CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(r1, r2, r3));
    }

    @NonNull
    public BroadcastReceiver instantiateReceiverCompat(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (BroadcastReceiver) Class.forName(r2, false, r1).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }

    @Override // android.app.AppComponentFactory
    @NonNull
    public final Service instantiateService(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (Service) CoreComponentFactory.checkCompatWrapper(instantiateServiceCompat(r1, r2, r3));
    }

    @NonNull
    public Service instantiateServiceCompat(@NonNull ClassLoader r1, @NonNull String r2, @Nullable Intent r3) {
        return (Service) Class.forName(r2, false, r1).asSubclass(Service.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException("Couldn't call constructor", e);
    }
}
