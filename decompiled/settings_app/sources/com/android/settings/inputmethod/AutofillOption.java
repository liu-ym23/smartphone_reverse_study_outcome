package com.android.settings.inputmethod;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AutofillOption {
    private static final String AUTOFILL_ACTION = "android.service.autofill.AutofillService";
    private Context mContext;

    public static class ServiceApp {
        public ComponentName componentName;
        public String label;

        public ServiceApp() {
        }
    }

    public AutofillOption(Context r1) {
        this.mContext = r1;
    }

    public boolean isCurrentService(ServiceApp r2) {
        String r1 = getCurrentAutofillService(this.mContext);
        if (r1 == null) goto L5;
    L8:
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r2.componentName != null) goto L12;
        return false;
    L12:
        return r1.equals(r2.componentName.flattenToString());
    L5:
        if (r2.componentName != null) goto L8;
        return true;
    }

    public List<ServiceApp> fetchAutofillServices() {
        ArrayList r0 = new ArrayList();
        ServiceApp r1 = new ServiceApp();
        r1.label = this.mContext.getString(R.string.app_list_preference_none);
        r0.add(r1);
        PackageManager r7 = this.mContext.getPackageManager();
        List<ResolveInfo> r2 = r7.queryIntentServices(new Intent(AUTOFILL_ACTION), 128);
        if (r2 == null) goto L11;
        Iterator<ResolveInfo> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        ResolveInfo r4 = r3.next();
        if ("android.permission.BIND_AUTOFILL_SERVICE".equals(r4.serviceInfo.permission) == false) goto L6;
        ServiceApp r5 = new ServiceApp();
        r5.componentName = new ComponentName(r4.serviceInfo.packageName, r4.serviceInfo.name);
        r5.label = String.valueOf(r4.loadLabel(r7));
        r0.add(r5);
    L11:
        return r0;
    }

    public String getCurrentAutofillService(Context r1) {
        String r0 = Settings.Secure.getString(r1.getContentResolver(), "autofill_service");
        if (r0 == null) goto L8;
        ComponentName r2 = ComponentName.unflattenFromString(r0);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.flattenToString();
    L8:
        return null;
    }

    public void setAutofillService(ServiceApp r2) {
        ComponentName r3 = r2.componentName;
        if (r3 != null) goto L5;
        String r4 = null;
    L6:
        Settings.Secure.putString(this.mContext.getContentResolver(), "autofill_service", r4);
        return;
    L5:
        r4 = r3.flattenToString();
        goto L6
    }
}
