package com.obric.capabilitykit.entity.memory;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.obric.capabilitykit.common.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryServiceChecker;", "", "()V", "ACTION_GLOBAL_SEARCH_SERVICE", "", "ACTION_SEARCH_SERVICE", "ENTITY_PROVIDER_AUTHORITY", "TAG", "checkEntityProviderAvailable", "Lcom/obric/capabilitykit/entity/memory/MemoryServiceStatus;", "context", "Landroid/content/Context;", "checkGlobalSearchServiceAvailable", "checkSearchServiceAvailable", "checkServiceAvailableInternal", "action", "serviceName", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoryServiceChecker {
    public static final String ACTION_GLOBAL_SEARCH_SERVICE = "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE";
    public static final String ACTION_SEARCH_SERVICE = "com.obric.memorydata.action.SEARCH_SERVICE";
    public static final String ENTITY_PROVIDER_AUTHORITY = "com.obric.memorydata.personalcontext.EntityProvider";
    public static final MemoryServiceChecker INSTANCE = null;
    public static final String TAG = "MemoryServiceChecker";

    static {
        INSTANCE = new MemoryServiceChecker();
    }

    private MemoryServiceChecker() {
    }

    private final MemoryServiceStatus checkServiceAvailableInternal(Context r7, String r8, String r9) {
        List<ResolveInfo> r1 = r7.getPackageManager().queryIntentServices(new Intent(r8), 131072);     // Catch: RuntimeException -> L5 SecurityException -> L7
        Intrinsics.checkNotNullExpressionValue(r1, "{\n            if (Build.…)\n            }\n        }");     // Catch: RuntimeException -> L5 SecurityException -> L7
    L11:
        if (r1.isEmpty() == false) goto L14;
        Log.w(TAG, "No " + r9 + " services found for action: " + r8);
        return MemoryServiceStatus.UNAVAILABLE;
    L14:
        boolean r10 = false;
        if (r1.isEmpty() == true) goto L30;
        Iterator<T> r6 = r1.iterator();
    L19:
        if (r6.hasNext() == false) goto L30;
        ServiceInfo r2 = ((ResolveInfo) r6.next()).serviceInfo;
        if (r2 == null) goto L27;
        Intrinsics.checkNotNullExpressionValue(r2, "serviceInfo");
        boolean r3 = a.a.a(r7, new ComponentName(r2.packageName, r2.name));
        if (r3 == false) goto L25;
        StringBuilder r4 = new StringBuilder();
        StringBuilder r5 = r4.append(r9);
        String r11 = " service is available: ";
    L26:
        Log.d(TAG, r5.append(r11).append(r2.packageName).append(IOUtils.DIR_SEPARATOR_UNIX).append(r2.name).toString());
    L28:
        if (r3 == false) goto L19;
        r10 = true;
        goto L30
    L25:
        r4 = new StringBuilder();
        r5 = r4.append(r9);
        r11 = " service is disabled: ";
        goto L26
    L27:
        r3 = false;
    L30:
        if (r10 == false) goto L33;
        return MemoryServiceStatus.AVAILABLE;
    L33:
        return MemoryServiceStatus.UNAVAILABLE;
    L7:
        e = e;
        StringBuilder r12 = new StringBuilder("No permission to query ");
    L9:
        Log.w(TAG, r12.append(r9).append(" services").toString(), e);
        r1 = CollectionsKt.emptyList();
    L5:
        e = e;
        r12 = new StringBuilder("Failed to query ");
        goto L9
    }

    public final MemoryServiceStatus checkEntityProviderAvailable(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ProviderInfo r1 = null;
        r1 = r5.getPackageManager().resolveContentProvider(ENTITY_PROVIDER_AUTHORITY, 131072);     // Catch: RuntimeException -> L5 SecurityException -> L7
    L10:
        if (r1 != null) goto L14;
        Log.w(TAG, "No provider found for authority: com.obric.memorydata.personalcontext.EntityProvider");
        return MemoryServiceStatus.UNAVAILABLE;
    L14:
        if (a.a.a(r5, new ComponentName(r1.packageName, r1.name)) == false) goto L16;
        Log.i(TAG, "Provider is available: " + r1.packageName + IOUtils.DIR_SEPARATOR_UNIX + r1.name);
        return MemoryServiceStatus.AVAILABLE;
    L16:
        Log.w(TAG, "Provider is disabled: " + r1.packageName + IOUtils.DIR_SEPARATOR_UNIX + r1.name);
        return MemoryServiceStatus.UNAVAILABLE;
    L7:
        e = e;
        String r2 = "No permission to resolve provider";
    L9:
        Log.w(TAG, r2, e);
    L5:
        e = e;
        r2 = "Failed to resolve provider";
        goto L9
    }

    public final MemoryServiceStatus checkGlobalSearchServiceAvailable(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return checkServiceAvailableInternal(r3, ACTION_GLOBAL_SEARCH_SERVICE, "GlobalSearch");
    }

    public final MemoryServiceStatus checkSearchServiceAvailable(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return checkServiceAvailableInternal(r3, ACTION_SEARCH_SERVICE, "Search");
    }
}
