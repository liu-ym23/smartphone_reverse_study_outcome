package com.bytedance.common.util;

import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: classes3.dex */
public class GingerBreadV9Compat {
    static final BaseImpl IMPL = null;

    static class BaseImpl {
        public void requestSingleUpdate(LocationManager r1, Criteria r2, LocationListener r3, Looper r4) {
        }

        public void requestSingleUpdate(LocationManager r1, String r2, LocationListener r3, Looper r4) {
        }

        public void setListViewOverScrollHeader(ListView r1, Drawable r2) {
        }

        public void setViewOverScrollMode(View r1, int r2) {
        }

        BaseImpl() {
        }
    }

    static class V9Impl extends BaseImpl {
        V9Impl() {
        }

        @Override // com.bytedance.common.util.GingerBreadV9Compat.BaseImpl
        public void setListViewOverScrollHeader(ListView r1, Drawable r2) {
            r1.setOverscrollHeader(r2);
        }

        @Override // com.bytedance.common.util.GingerBreadV9Compat.BaseImpl
        public void setViewOverScrollMode(View r1, int r2) {
            r1.setOverScrollMode(r2);
        }

        @Override // com.bytedance.common.util.GingerBreadV9Compat.BaseImpl
        public void requestSingleUpdate(LocationManager r1, Criteria r2, LocationListener r3, Looper r4) {
            r1.requestSingleUpdate(r2, r3, r4);
        }

        @Override // com.bytedance.common.util.GingerBreadV9Compat.BaseImpl
        public void requestSingleUpdate(LocationManager r1, String r2, LocationListener r3, Looper r4) {
            r1.requestSingleUpdate(r2, r3, r4);
        }
    }

    public GingerBreadV9Compat() {
    }

    static {
        IMPL = new V9Impl();
    }

    public static void setListViewOverScrollHeader(ListView r1, Drawable r2) {
        IMPL.setListViewOverScrollHeader(r1, r2);
    }

    public static void setViewOverScrollMode(View r1, int r2) {
        IMPL.setViewOverScrollMode(r1, r2);
    }

    public static void requestSingleUpdate(LocationManager r1, Criteria r2, LocationListener r3, Looper r4) {
        IMPL.requestSingleUpdate(r1, r2, r3, r4);
    }

    public static void requestSingleUpdate(LocationManager r1, String r2, LocationListener r3, Looper r4) {
        IMPL.requestSingleUpdate(r1, r2, r3, r4);
    }
}
