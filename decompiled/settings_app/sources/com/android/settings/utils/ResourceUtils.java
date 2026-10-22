package com.android.settings.utils;

import android.content.res.Resources;
import com.android.settings.SettingsApplication;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResourceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J+\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/android/settings/utils/ResourceUtils;", "", "()V", "getResources", "Landroid/content/res/Resources;", "getString", "", "resId", "", "getStringFormat", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = null;

    static {
        INSTANCE = new ResourceUtils();
    }

    private ResourceUtils() {
    }

    @JvmStatic
    public static final String getString(int r1) {
        String r2 = SettingsApplication.getContext().getString(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        return r2;
    }

    @JvmStatic
    public static final String getStringFormat(int r2, Object... r3) {
        Intrinsics.checkNotNullParameter(r3, "formatArgs");
        String r4 = SettingsApplication.getContext().getString(r2, Arrays.copyOf(r3, r3.length));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        return r4;
    }

    @JvmStatic
    public static final Resources getResources() {
        Resources r0 = SettingsApplication.getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(r0, "getResources(...)");
        return r0;
    }
}
