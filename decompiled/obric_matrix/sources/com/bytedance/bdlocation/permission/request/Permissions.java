package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class Permissions {
    static final Impl IMPL = null;

    static class BaseImpl implements Impl {
        final Handler mHandler;

        BaseImpl() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r2, final String[] r3, final Callback r4) {
            this.mHandler.post(new AnonymousClass1(this, r4, r3));
        }
    }

    public interface Callback {
        void onRequestPermissionResult(String[] r1, int[] r2);
    }

    interface Impl {
        void requestPermissions(Activity r1, String[] r2, Callback r3);
    }

    static class MarshmallowImpl implements Impl {
        MarshmallowImpl() {
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r3, String[] r4, Callback r5) {
            if (((PermissionFragment) r3.getFragmentManager().findFragmentByTag("permissions")) != null) goto L6;
            PermissionFragment r2 = new PermissionFragment();
            Bundle r1 = new Bundle();
            r1.putStringArray("permissions", r4);
            r2.setArguments(r1);
            r2.mCallback = r5;
            r3.getFragmentManager().beginTransaction().add(r2, "permissions").commitAllowingStateLoss();
            return;
        }
    }

    static {
        if (systemSupportsRuntimePermission() == false) goto L5;
        Impl r0 = new MarshmallowImpl();
    L6:
        IMPL = r0;
        return;
    L5:
        r0 = new BaseImpl();
        goto L6
    }

    public Permissions() {
    }

    public static void requestPermissions(Activity r1, String[] r2, Callback r3) {
        IMPL.requestPermissions(r1, r2, r3);
    }

    public static boolean systemSupportsRuntimePermission() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }
}
