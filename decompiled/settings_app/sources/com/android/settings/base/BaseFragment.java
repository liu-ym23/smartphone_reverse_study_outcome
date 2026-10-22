package com.android.settings.base;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.Utils;
import com.android.settings.core.CategoryMixin;
import com.android.settings.dashboard.DashboardFeatureProvider;
import com.android.settings.dashboard.DashboardFragmentRegistry;
import com.android.settings.dashboard.DynamicDataObserver;
import com.android.settings.overlay.FeatureFactory;
import com.android.settingslib.SliceBroadcastRelay;
import com.android.settingslib.drawer.DashboardCategory;
import com.android.settingslib.drawer.Tile;
import com.android.settingslib.widget.LottieColorUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ¿\u00012\u00020\u00012\u00020\u0002:\u0002¿\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0017\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0005H\u0002J\u0012\u0010G\u001a\u00020\u001f2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010J\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020EH\u0015J\u0012\u0010K\u001a\u0004\u0018\u00010C2\u0006\u0010L\u001a\u00020\bH\u0002J\u001f\u0010M\u001a\u0002HN\"\b\b\u0000\u0010N*\u00020\u000f2\b\b\u0001\u0010O\u001a\u00020\u0005¢\u0006\u0002\u0010PJ!\u0010Q\u001a\u0004\u0018\u0001HN\"\b\b\u0000\u0010N*\u00020\u000f2\b\b\u0001\u0010O\u001a\u00020\u0005¢\u0006\u0002\u0010PJ\b\u0010R\u001a\u00020?H\u0016J\b\u0010S\u001a\u0004\u0018\u00010TJ\b\u0010U\u001a\u0004\u0018\u00010\u0011J\u0016\u0010V\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0005J\b\u0010X\u001a\u00020YH\u0016J\u000e\u0010Z\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0016J\b\u0010[\u001a\u0004\u0018\u00010\\J\u0006\u0010]\u001a\u00020^J\b\u0010_\u001a\u00020\u0005H\u0016J\b\u0010`\u001a\u0004\u0018\u00010aJ\b\u0010b\u001a\u0004\u0018\u00010\bJ\n\u0010c\u001a\u0004\u0018\u00010\u0011H\u0014J\u001c\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010\b2\u0006\u0010g\u001a\u00020\u0005H\u0004J\u0010\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010f\u001a\u00020\bJ\b\u0010j\u001a\u00020\u0005H\u0016J\n\u0010k\u001a\u0004\u0018\u00010:H\u0016J\b\u0010l\u001a\u0004\u0018\u00010mJ\b\u0010n\u001a\u0004\u0018\u00010oJ\u0006\u0010p\u001a\u00020?J\u0010\u0010p\u001a\u00020?2\b\u0010q\u001a\u0004\u0018\u00010\u000fJ\b\u0010r\u001a\u00020?H\u0002J\b\u0010s\u001a\u00020?H\u0002J\b\u0010t\u001a\u00020?H\u0002J\b\u0010u\u001a\u00020?H\u0002J\b\u0010v\u001a\u00020?H\u0002J\u0010\u0010w\u001a\u00020?2\u0006\u0010x\u001a\u00020\u000fH\u0014J\u001a\u0010y\u001a\u00020?2\u0006\u0010q\u001a\u00020\u000f2\b\u0010z\u001a\u0004\u0018\u00010{H\u0016J\b\u0010|\u001a\u00020\u001fH\u0004J\b\u0010}\u001a\u00020?H\u0002J\u0010\u0010~\u001a\u00020?2\u0006\u0010\u007f\u001a\u00020\u0011H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u001fH\u0016J\u001d\u0010\u0081\u0001\u001a\u00020?2\u0012\u0010\u0082\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0083\u0001H\u0016J\u0013\u0010\u0084\u0001\u001a\u00020?2\b\u0010z\u001a\u0004\u0018\u00010{H\u0016J&\u0010\u0085\u0001\u001a\u00020?2\u0007\u0010\u0086\u0001\u001a\u00020\u00052\u0007\u0010\u0087\u0001\u001a\u00020\u00052\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\\H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020?2\u0007\u0010\u008a\u0001\u001a\u00020\u001fH\u0014J$\u0010\u008b\u0001\u001a\u00020?2\u0007\u0010\u008c\u0001\u001a\u00020\b2\u0007\u0010\u0087\u0001\u001a\u00020\u00052\u0007\u0010\u008d\u0001\u001a\u00020{H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020?2\u0007\u0010\u008f\u0001\u001a\u00020\u001fH\u0016J\u001b\u0010\u0090\u0001\u001a\u00020\u001f2\u0007\u0010\u0091\u0001\u001a\u00020\u00052\u0007\u0010H\u001a\u00030\u0092\u0001H\u0016J\t\u0010\u0093\u0001\u001a\u00020?H\u0016J\t\u0010\u0094\u0001\u001a\u00020?H\u0016J\t\u0010\u0095\u0001\u001a\u00020?H\u0016J\t\u0010\u0096\u0001\u001a\u00020?H\u0016J\t\u0010\u0097\u0001\u001a\u00020?H\u0016J\u001b\u0010\u0098\u0001\u001a\u00020?2\u0006\u0010q\u001a\u00020\u000f2\b\u0010z\u001a\u0004\u0018\u00010{H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020?2\u0007\u0010\u009a\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010\u009b\u0001\u001a\u00020?2\u0007\u0010\u009c\u0001\u001a\u00020\bH\u0002J\u001b\u0010\u009d\u0001\u001a\u00020?2\u0007\u0010\u009e\u0001\u001a\u00020Y2\u0007\u0010\u009f\u0001\u001a\u00020\u001bH\u0002J\u0018\u0010 \u0001\u001a\u00020?2\u000f\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aJ\u001d\u0010¢\u0001\u001a\u0004\u0018\u00010\\2\b\u0010£\u0001\u001a\u00030¤\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001J\u0011\u0010§\u0001\u001a\u00020?2\u0006\u0010L\u001a\u00020\bH\u0002J\u0010\u0010¨\u0001\u001a\u00020?2\u0007\u0010©\u0001\u001a\u00020\\J\u0010\u0010ª\u0001\u001a\u00020?2\u0007\u0010«\u0001\u001a\u00020\u001fJ\u0015\u0010¬\u0001\u001a\u00020?2\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001H\u0016J\u0012\u0010¬\u0001\u001a\u00020?2\t\b\u0001\u0010¯\u0001\u001a\u00020\u0005J\u0012\u0010¬\u0001\u001a\u00020?2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\bJ\t\u0010°\u0001\u001a\u00020\u001fH\u0014J\t\u0010±\u0001\u001a\u00020\u001fH\u0014J\u0011\u0010²\u0001\u001a\u00020?2\b\u0010q\u001a\u0004\u0018\u00010\u000fJ)\u0010³\u0001\u001a\u00020?2\u0007\u0010´\u0001\u001a\u00020\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010{2\n\b\u0002\u0010¶\u0001\u001a\u00030·\u0001H\u0007J\u001e\u0010³\u0001\u001a\u00020?2\u0007\u0010´\u0001\u001a\u00020\u00012\n\b\u0002\u0010¶\u0001\u001a\u00030·\u0001H\u0007J2\u0010³\u0001\u001a\u00020?2\u0010\u0010´\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00010¸\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010{2\n\b\u0002\u0010¶\u0001\u001a\u00030·\u0001H\u0007J'\u0010³\u0001\u001a\u00020?2\u0010\u0010´\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00010¸\u00012\n\b\u0002\u0010¶\u0001\u001a\u00030·\u0001H\u0007J\u001d\u0010¹\u0001\u001a\u00020?2\u0007\u0010©\u0001\u001a\u00020\\2\t\u0010º\u0001\u001a\u0004\u0018\u00010{H\u0016J\u001a\u0010»\u0001\u001a\u00020?2\u000f\u0010¡\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0002J\u0013\u0010¼\u0001\u001a\u00020?2\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001J\u0019\u0010½\u0001\u001a\u00030¾\u0001*\u00030¾\u00012\b\u0010¶\u0001\u001a\u00030·\u0001H\u0002R\u0012\u0010\u0007\u001a\u00020\b8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R#\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u001f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u001f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u001f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u001f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b04X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0085\u000e¢\u0006\u0004\n\u0002\u00108R\u0014\u00109\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0013\u0010;\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006À\u0001"}, d2 = {"Lcom/android/settings/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/android/settings/core/CategoryMixin$CategoryListener;", "()V", "layoutResID", "", "(I)V", "TAG", "", "_mActivity", "Landroid/app/Activity;", "categoryKey", "getCategoryKey", "()Ljava/lang/String;", "mBackView", "Landroid/view/View;", "mContext", "Landroid/content/Context;", "mDashboardFeatureProvider", "Lcom/android/settings/dashboard/DashboardFeatureProvider;", "getMDashboardFeatureProvider", "()Lcom/android/settings/dashboard/DashboardFeatureProvider;", "setMDashboardFeatureProvider", "(Lcom/android/settings/dashboard/DashboardFeatureProvider;)V", "mDashboardTilePrefKeys", "Landroid/util/ArrayMap;", "", "Lcom/android/settings/dashboard/DynamicDataObserver;", "getMDashboardTilePrefKeys", "()Landroid/util/ArrayMap;", "mFinishing", "", "mFromSecurityCenter", "mIsExtDisplayConnected", "mIsExtDisplaying", "mIsFirstOnResume", "mIsFragmentVisible", "mIsLandScreen", "mLayoutInflater", "Landroid/view/LayoutInflater;", "getMLayoutInflater", "()Landroid/view/LayoutInflater;", "setMLayoutInflater", "(Landroid/view/LayoutInflater;)V", "mListeningToCategoryChange", "mPcModeObserver", "Landroid/database/ContentObserver;", "getMPcModeObserver", "()Landroid/database/ContentObserver;", "setMPcModeObserver", "(Landroid/database/ContentObserver;)V", "mRegisteredObservers", "", "mRootView", "mSuppressInjectedTileKeys", "mTitleResId", "Ljava/lang/Integer;", "mTitleView", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "pageContainerView", "getPageContainerView", "()Landroid/view/View;", "awaitObserverLatch", "", "latch", "Ljava/util/concurrent/CountDownLatch;", "createCardListItem", "Lcom/obric/oui/lisitem/OCardListItem;", "tile", "Lcom/android/settingslib/drawer/Tile;", "position", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "displayTile", "findCardListItem", "key", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, "viewId", "(I)Landroid/view/View;", "findViewByIdNullable", "finish", "getApplication", "Landroid/app/Application;", "getApplicationContext", "getCardPosition", PerfConsts.PERF_DISK_FILE_SIZE, "getContentResolver", "Landroid/content/ContentResolver;", "getFragmentRequestKeys", "getIntent", "Landroid/content/Intent;", "getMainLooper", "Landroid/os/Looper;", "getMetricsCategory", "getPackageManager", "Landroid/content/pm/PackageManager;", "getPackageName", "getRealContext", "getSharedPreferences", "Landroid/content/SharedPreferences;", "name", "mode", "getSystemService", "", "getTitleResId", "getTitleView", "getWindow", "Landroid/view/Window;", "getWindowManager", "Landroid/view/WindowManager;", "hideSoftInput", "view", "initArguments", "initFragmentResultListener", "initKeyListener", "initStatusBar", "initTitleName", "initTitleView", "contentView", "initViews", "savedInstanceState", "Landroid/os/Bundle;", "isFragmentVisible", "monitorExtDisplayStatus", "onAttach", "context", "onBackPressedSupport", "onCategoriesChanged", "categories", "", "onCreate", "onCustomActivityResult", "requestCode", "resultCode", "data", "onExtDisplayChanged", "isExtDisplayConnected", "onFragmentResult", "requestKey", "result", "onHiddenChanged", "hidden", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onPause", "onResume", "onResumeNonInitial", "onStart", "onStop", "onViewCreated", "onWindowFocusChanged", "hasFocus", "refreshDashboardTiles", "tag", "registerDynamicDataObserver", "resolver", "observer", "registerDynamicDataObservers", "observers", "registerReceiver", SliceBroadcastRelay.EXTRA_RECEIVER, "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "removeCardListItem", "sendBroadcast", "intent", "setFinishing", "finishing", "setTitle", "title", "", "titleResId", "shouldForceRoundedIcon", "shouldMonitorExtDisplayStatus", "showSoftInput", "start", "fragment", "args", "transactionType", "Lcom/android/settings/base/TransactionType;", "Ljava/lang/Class;", "startActivity", "options", "unregisterDynamicDataObservers", "unregisterReceiver", "setCustomAnimations", "Landroidx/fragment/app/FragmentTransaction;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BaseFragment extends Fragment implements CategoryMixin.CategoryListener {
    public static final Companion Companion = null;
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_OK = 0;
    private static final long SHOW_SPACE = 200;
    private static final long TIMEOUT_MILLIS = 50;
    protected String TAG;
    public Activity _mActivity;
    protected View mBackView;
    public Context mContext;
    public DashboardFeatureProvider mDashboardFeatureProvider;
    private final ArrayMap<String, List<DynamicDataObserver>> mDashboardTilePrefKeys;
    private boolean mFinishing;
    public boolean mFromSecurityCenter;
    protected boolean mIsExtDisplayConnected;
    protected boolean mIsExtDisplaying;
    private boolean mIsFirstOnResume;
    protected boolean mIsFragmentVisible;
    protected boolean mIsLandScreen;
    protected LayoutInflater mLayoutInflater;
    private boolean mListeningToCategoryChange;
    private ContentObserver mPcModeObserver;
    private final List<DynamicDataObserver> mRegisteredObservers;
    protected View mRootView;
    private List<String> mSuppressInjectedTileKeys;
    protected Integer mTitleResId;
    public OFloatingTitleBar mTitleView;

    /* JADX INFO: compiled from: BaseFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/settings/base/BaseFragment$Companion;", "", "()V", "RESULT_CANCELED", "", "RESULT_OK", "SHOW_SPACE", "", "TIMEOUT_MILLIS", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: BaseFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[Tile.Type.values().length];
            r0[Tile.Type.EXTERNAL_ACTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Tile.Type.SWITCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L33:
            r0[Tile.Type.SWITCH_WITH_ACTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L25:
            r0[Tile.Type.GROUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[Tile.Type.ACTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L9:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[TransactionType.values().length];
            r1[TransactionType.SLIDE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L21:
            r1[TransactionType.POPUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L12:
            $EnumSwitchMapping$1 = r1;
        }
    }

    public static /* synthetic */ void $r8$lambda$2_18ABOK4uLl4r5aM4YjMDaupRk(BaseFragment r0, View r1) {
        initTitleView$lambda$6(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$9V7WdRM38jJ3L28PngIvfe27eiI(BaseFragment r0, View r1, int r2, KeyEvent r3) {
        return initKeyListener$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$MiGccM_gCCSLQseZcR3kLQye1Ss(Tile r0, Tile r1) {
        return refreshDashboardTiles$lambda$16(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Qvq937IYJhqMgZf2vQ3Uufwm-Lg, reason: not valid java name */
    public static /* synthetic */ void m332$r8$lambda$Qvq937IYJhqMgZf2vQ3UufwmLg(List r0, CountDownLatch r1, BaseFragment r2) {
        refreshDashboardTiles$lambda$19(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$R0Eg8KMHOYoC4g3whXl0qt4rUVE(BaseFragment r0, View r1) {
        createCardListItem$lambda$23(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$YsgIWJ6_QvcZbS4hxfhMDupDQ8k(InputMethodManager r0, View r1) {
        showSoftInput$lambda$15(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$omC5BudeItSadeVWXxqnOwY7Wk0(BaseFragment r0, String r1, Bundle r2) {
        initFragmentResultListener$lambda$3$lambda$2(r0, r1, r2);
    }

    public boolean dispatchTouchEvent(MotionEvent r1) {
        return false;
    }

    public final int getCardPosition(int r1, int r2) {
        if (r2 != 1) goto L5;
        return 0;
    L5:
        if (r1 != 0) goto L8;
        return 1;
    L8:
        if (r1 != (r2 - 1)) goto L10;
        return 3;
    L10:
        return 2;
    }

    public int getMetricsCategory() {
        return 0;
    }

    public boolean onBackPressedSupport() {
        return false;
    }

    protected void onExtDisplayChanged(boolean r1) {
    }

    public boolean onKeyDown(int r1, KeyEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return false;
    }

    public void onWindowFocusChanged(boolean r1) {
    }

    protected boolean shouldForceRoundedIcon() {
        return false;
    }

    protected boolean shouldMonitorExtDisplayStatus() {
        return false;
    }

    public final void start(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        start$default(this, r3, null, 2, null);
    }

    public final void start(Fragment r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        start$default(this, r8, r9, null, 4, null);
    }

    public final void start(Class<? extends Fragment> r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        start$default(this, r3, null, 2, null);
    }

    public final void start(Class<? extends Fragment> r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        start$default(this, r8, r9, null, 4, null);
    }

    static {
        Companion = new Companion(null);
        RESULT_OK = -1;
    }

    protected final LayoutInflater getMLayoutInflater() {
        LayoutInflater r0 = this.mLayoutInflater;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutInflater");
        return null;
    }

    protected final void setMLayoutInflater(LayoutInflater r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mLayoutInflater = r2;
    }

    protected final ContentObserver getMPcModeObserver() {
        return this.mPcModeObserver;
    }

    protected final void setMPcModeObserver(ContentObserver r1) {
        this.mPcModeObserver = r1;
    }

    public final ArrayMap<String, List<DynamicDataObserver>> getMDashboardTilePrefKeys() {
        return this.mDashboardTilePrefKeys;
    }

    public final DashboardFeatureProvider getMDashboardFeatureProvider() {
        DashboardFeatureProvider r0 = this.mDashboardFeatureProvider;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mDashboardFeatureProvider");
        return null;
    }

    public final void setMDashboardFeatureProvider(DashboardFeatureProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mDashboardFeatureProvider = r2;
    }

    protected String getCategoryKey() {
        return DashboardFragmentRegistry.PARENT_TO_CATEGORY_KEY_MAP.get(getClass().getName());
    }

    public final View getPageContainerView() {
        View r1 = this.mRootView;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.findViewById(R.id.page_container);
    }

    public BaseFragment() {
        String r0 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r0, "getSimpleName(...)");
        this.TAG = r0;
        Context r1 = SettingsApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        this.mContext = r1;
        this.mIsFirstOnResume = true;
        this.mIsFragmentVisible = true;
        this.mDashboardTilePrefKeys = new ArrayMap();
        this.mRegisteredObservers = new ArrayList();
    }

    public BaseFragment(int r2) {
        super(r2);
        String r3 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r3, "getSimpleName(...)");
        this.TAG = r3;
        Context r4 = SettingsApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "getContext(...)");
        this.mContext = r4;
        this.mIsFirstOnResume = true;
        this.mIsFragmentVisible = true;
        this.mDashboardTilePrefKeys = new ArrayMap();
        this.mRegisteredObservers = new ArrayList();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.onAttach(r5);
        initArguments();
        this.mContext = r5;
        this._mActivity = getActivity();
        LayoutInflater r0 = LayoutInflater.from(r5);
        Intrinsics.checkNotNullExpressionValue(r0, "from(...)");
        setMLayoutInflater(r0);
        boolean r2 = true;
        if (r5.getResources().getConfiguration().orientation != 2) goto L5;
        boolean r1 = true;
    L6:
        this.mIsLandScreen = r1;
        if (Settings.Global.getInt(r5.getContentResolver(), "global_pc_mode_settings", 0) == 1) goto L10;
        r2 = false;
    L10:
        this.mIsExtDisplayConnected = r2;
        String[] r6 = this.mContext.getResources().getStringArray(R.array.config_suppress_injected_tile_keys);
        Intrinsics.checkNotNullExpressionValue(r6, "getStringArray(...)");
        this.mSuppressInjectedTileKeys = ArraysKt.toList(r6);
        setMDashboardFeatureProvider(FeatureFactory.Companion.getFeatureFactory().getDashboardFeatureProvider());
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        FragmentActivity r3 = getActivity();
        if ((r3 instanceof BaseActivity) == false) goto L5;
        BaseActivity r4 = (BaseActivity) r3;
    L6:
        if (r4 == null) goto L8;
        boolean r5 = r4.mFromSecurityCenter;
    L9:
        this.mFromSecurityCenter = r5;
        initArguments();
        initStatusBar();
        initFragmentResultListener();
        if (shouldMonitorExtDisplayStatus() == false) goto L13;
        monitorExtDisplayStatus();
        return;
    L13:
        return;
    L8:
        r5 = false;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        OLog.d(this.TAG, "onStart");
        if (getMDashboardFeatureProvider().getTilesForCategory(getCategoryKey()) != null) goto L6;
        return;
    L6:
        if ((getActivity() instanceof CategoryMixin.CategoryHandler) == false) goto L8;
        this.mListeningToCategoryChange = true;
        KeyEventDispatcher.Component r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.android.settings.core.CategoryMixin.CategoryHandler");
        ((CategoryMixin.CategoryHandler) r0).getCategoryMixin().addCategoryListener(this);
    L8:
        ContentResolver r1 = getContentResolver();
        Collection<List<DynamicDataObserver>> r2 = this.mDashboardTilePrefKeys.values();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-values>(...)");
        Iterator r3 = CollectionsKt.flatten(CollectionsKt.filterNotNull(r2)).iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        DynamicDataObserver r4 = (DynamicDataObserver) r3.next();
        if (this.mRegisteredObservers.contains(r4) == true) goto L10;
        registerDynamicDataObserver(r1, r4);
        goto L10
    }

    private final void initArguments() {
        if (getArguments() != null) goto L12;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L10;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L10;
        Bundle r2 = r1.getExtras();
        if (r2 == null) goto L10;
    L11:
        setArguments(r2);
        return;
    L10:
        r2 = new Bundle();
        goto L11
    L12:
        Bundle r3 = getArguments();
        if (r3 == null) goto L24;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L20;
        Intent r5 = r4.getIntent();
        if (r5 == null) goto L20;
        Bundle r6 = r5.getExtras();
        if (r6 == null) goto L20;
    L21:
        r3.putAll(r6);
        return;
    L20:
        r6 = new Bundle();
        goto L21
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        initViews(r2, r3);
        initKeyListener();
        refreshDashboardTiles(this.TAG);
        if ((r2 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r2).setClipChildren(false);
        return;
    }

    @Override // com.android.settings.core.CategoryMixin.CategoryListener
    public void onCategoriesChanged(Set<String> r4) {
        String r0 = getCategoryKey();
        if (getMDashboardFeatureProvider().getTilesForCategory(r0) != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L8;
        refreshDashboardTiles(this.TAG);
        return;
    L8:
        if (r4.contains(r0) == false) goto L12;
        OLog.i(this.TAG, "refresh tiles for " + r0);
        refreshDashboardTiles(this.TAG);
        return;
    }

    private final void initStatusBar() {
        Window r0 = getWindow();
        if (r0 == null) goto L23;
        r0.getDecorView().setSystemUiVisibility(1792);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setStatusBarColor(0);
        if (Utils.isThreeButtonNavBarEnabled(getActivity()) == false) goto L9;
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L9;
        int r3 = r2.getColor(R.color.oui_bg_base_1);
    L10:
        r0.setNavigationBarColor(r3);
        r0.setNavigationBarContrastEnforced(false);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L13;
        Context r4 = r1.getApplicationContext();
    L14:
        if (r4 != null) goto L16;
        r4 = this.mContext;
    L17:
        boolean r5 = !LottieColorUtils.isDarkMode(r4);
        int r6 = r0.getDecorView().getSystemUiVisibility();
        if (r5 == false) goto L20;
        int r7 = (r6 | 8192) | 16;
    L21:
        r0.getDecorView().setSystemUiVisibility(r7);
        return;
    L20:
        r7 = (r6 & (-8193)) & (-17);
        goto L21
    L16:
        Intrinsics.checkNotNull(r4);
        goto L17
    L13:
        r4 = null;
    L9:
        r3 = 0;
        goto L10
    }

    public void onCustomActivityResult(int r2, int r3, Intent r4) {
        OLog.i(this.TAG, "onCustomActivityResult, request_code: " + r2 + ", result_code: " + r3);
    }

    private final void initFragmentResultListener() {
        Iterator<T> r0 = getFragmentRequestKeys().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        getParentFragmentManager().setFragmentResultListener(r1, this, new BaseFragment$$ExternalSyntheticLambda6(this));
        goto L4
    }

    private static final void initFragmentResultListener$lambda$3$lambda$2(BaseFragment r2, String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "requestKey");
        Intrinsics.checkNotNullParameter(r4, "result");
        r2.onFragmentResult(r3, r4.getInt("result_code", 0), r4);
    }

    public List<String> getFragmentRequestKeys() {
        return CollectionsKt.emptyList();
    }

    public void onFragmentResult(String r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "requestKey");
        Intrinsics.checkNotNullParameter(r4, "result");
        OLog.d(this.TAG, "onFragmentResult, requestKey: " + r2 + ", resultCode: " + r3);
    }

    private final void monitorExtDisplayStatus() {
        final Handler r0 = new Handler();
        ContentObserver r1 = new AnonymousClass1(this, r0);
        this.mPcModeObserver = r1;
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("global_pc_mode_settings"), false, r1);
    }

    public void initViews(View r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        this.mRootView = r1;
        initTitleView(r1);
    }

    private final void initKeyListener() {
        View r0 = this.mRootView;
        if (r0 == null) goto L6;
        r0.setOnKeyListener(new BaseFragment$$ExternalSyntheticLambda4(this));
        return;
    }

    private static final boolean initKeyListener$lambda$5(BaseFragment r0, View r1, int r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNull(r3);
        return r0.onKeyDown(r2, r3);
    }

    protected void initTitleView(View r9) {
        Intrinsics.checkNotNullParameter(r9, "contentView");
        View r10 = r9.findViewById(R.id.view_title);
        View r1 = null;
        if ((r10 instanceof OFloatingTitleBar) == false) goto L5;
        OFloatingTitleBar r2 = (OFloatingTitleBar) r10;
    L6:
        this.mTitleView = r2;
        if (r2 == null) goto L9;
        r1 = OFloatingTitleBar.addStartAction$default(r2, R.drawable.o_floating_title_bar_icon_back, 0, new BaseFragment$$ExternalSyntheticLambda0(this), 2, null);
    L9:
        this.mBackView = r1;
        initTitleName();
        WindowInsetsCompat r11 = ViewCompat.getRootWindowInsets(requireActivity().getWindow().getDecorView());
        if (r11 == null) goto L15;
        Insets r12 = r11.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r12, "getInsets(...)");
        OFloatingTitleBar r8 = this.mTitleView;
        if (r8 == null) goto L16;
        r8.updateLayoutForInsetTop(r12.top);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private static final void initTitleView$lambda$6(BaseFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final void initTitleName() {
        Integer r0 = this.mTitleResId;
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        Integer r2 = Integer.valueOf(r1);
        boolean r3 = true;
        if (r2.intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        Integer r5 = null;
        if (r4 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L18;
        int r6 = r2.intValue();
        OFloatingTitleBar r7 = this.mTitleView;
        if (r7 == null) goto L18;
        r7.setCenterTitle(r6);
    L18:
        Bundle r8 = getArguments();
        if (r8 == null) goto L28;
        String r9 = r8.getString("title");
        if (r9 == null) goto L28;
        if (r9.length() <= 0) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
    L29:
        if (r9 == null) goto L33;
        OFloatingTitleBar r11 = this.mTitleView;
        if (r11 == null) goto L46;
        r11.setCenterTitle(r9);
        return;
    L46:
        return;
    L33:
        Bundle r12 = getArguments();
        if (r12 == null) goto L48;
        Integer r13 = Integer.valueOf(r12.getInt("title_id", -1));
        if (r13.intValue() > 0) goto L39;
        r3 = false;
    L39:
        if (r3 == false) goto L41;
        r5 = r13;
    L41:
        if (r5 == null) goto L49;
        int r14 = r5.intValue();
        OFloatingTitleBar r15 = this.mTitleView;
        if (r15 == null) goto L50;
        r15.setCenterTitle(r14);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L25:
        r10 = false;
    L28:
        r9 = null;
        goto L29
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = getTitleResId();
        goto L6
    }

    public int getTitleResId() {
        Integer r0 = this.mTitleResId;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.intValue();
    }

    public OFloatingTitleBar getTitleView() {
        return this.mTitleView;
    }

    public final <T extends View> T findViewByIdNullable(int r2) {
        View r1 = this.mRootView;
        if (r1 == null) goto L8;
        T r3 = (T) r1.findViewById(r2);
        if ((r3 instanceof View) == true) goto L7;
        return null;
    L7:
        return r3;
    L8:
        return null;
    }

    public final <T extends View> T findViewById(int r1) {
        View r0 = this.mRootView;
        if (r0 == null) goto L7;
        T r2 = (T) r0.findViewById(r1);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type T of com.android.settings.base.BaseFragment.findViewById");
        return r2;
    L7:
        throw new RuntimeException("fragment must inflater layout in onCreateView firstly");
    }

    public ContentResolver getContentResolver() {
        ContentResolver r1 = this.mContext.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r1, "getContentResolver(...)");
        return r1;
    }

    public final Window getWindow() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWindow();
    }

    public final PackageManager getPackageManager() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPackageManager();
    }

    public final String getPackageName() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        String r1 = r0.getPackageName();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.mContext.getPackageName();
    }

    public final Intent getIntent() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getIntent();
    }

    public final Context getApplicationContext() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getApplicationContext();
    }

    public final Application getApplication() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getApplication();
    }

    public final Object getSystemService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return this.mContext.getSystemService(r2);
    }

    public final WindowManager getWindowManager() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWindowManager();
    }

    public final Intent registerReceiver(BroadcastReceiver r2, IntentFilter r3) {
        Intrinsics.checkNotNullParameter(r2, SliceBroadcastRelay.EXTRA_RECEIVER);
        Intrinsics.checkNotNullParameter(r3, "filter");
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L7;
        return null;
    L7:
        return GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r1, r2, r3, 2);
    }

    public final void unregisterReceiver(BroadcastReceiver r2) {
        if (r2 != null) goto L16;
        return;
    L16:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        FragmentActivity r1 = getActivity();     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.unregisterReceiver(r2);     // Catch: Throwable -> L10
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r4 = Result.m1508constructorimpl(r3);     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.m1511exceptionOrNullimpl(r4);
        if (r5 == null) goto L18;
        OLog.e(this.TAG, "unregisterReceiver failed", r5);
        return;
    L18:
        return;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void showSoftInput(final View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.getContext() == null) goto L9;
        Object r3 = r4.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        final InputMethodManager r5 = (InputMethodManager) r3;
        r4.requestFocus();
        r4.postDelayed(new BaseFragment$$ExternalSyntheticLambda5(r5, r4), 200);
        return;
    }

    private static final void showSoftInput$lambda$15(InputMethodManager r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "$imm");
        r1.showSoftInput(r2, 2);
    }

    public final void hideSoftInput(View r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getContext() == null) goto L9;
        Object r1 = r2.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r1).hideSoftInputFromWindow(r2.getWindowToken(), 0);
        return;
    }

    public final void hideSoftInput() {
        hideSoftInput(getView());
    }

    public final Looper getMainLooper() {
        Looper r1 = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(r1, "getMainLooper(...)");
        return r1;
    }

    protected Context getRealContext() {
        return this.mContext;
    }

    public final void setTitle(String r1) {
        OFloatingTitleBar r0 = this.mTitleView;
        if (r0 == null) goto L8;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0.setCenterTitle(r1);
        return;
    }

    public void setTitle(CharSequence r1) {
        if (r1 == null) goto L5;
        String r2 = r1.toString();
        if (r2 == null) goto L5;
    L6:
        setTitle(r2);
        return;
    L5:
        r2 = "";
        goto L6
    }

    public final void setTitle(int r2) {
        this.mTitleResId = Integer.valueOf(r2);
        OFloatingTitleBar r1 = this.mTitleView;
        if (r1 == null) goto L6;
        r1.setCenterTitle(r2);
        return;
    }

    protected final SharedPreferences getSharedPreferences(String r2, int r3) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
        OLog.e(this.TAG, "getSharedPreferences: fragmentActivity is null");
        return null;
    L7:
        return r0.getSharedPreferences(r2, r3);
    }

    public final void sendBroadcast(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L6;
        r1.sendBroadcast(r2);
        return;
    }

    private final void refreshDashboardTiles(String r15) {
        DashboardCategory r0 = getMDashboardFeatureProvider().getTilesForCategory(getCategoryKey());
        if (r0 != null) goto L6;
        OLog.d(r15, "NO dashboard tiles for " + r15);
        return;
    L6:
        List<Tile> r1 = r0.getTiles();
        if (r1 != null) goto L10;
        OLog.d(r15, "tile list is empty, skipping category " + r0.key);
        return;
    L10:
        ArrayMap r2 = new ArrayMap(this.mDashboardTilePrefKeys);
        boolean r10 = shouldForceRoundedIcon();
        final ArrayList r11 = new ArrayList();
        CollectionsKt.sortWith(r1, new BaseFragment$$ExternalSyntheticLambda2());
        Iterator<Tile> r12 = r1.iterator();
    L12:
        if (r12.hasNext() == false) goto L32;
        Tile r7 = r12.next();
        String r13 = getMDashboardFeatureProvider().getDashboardKeyForTile(r7);
        if (TextUtils.isEmpty(r13) == true) goto L15;
        Intrinsics.checkNotNull(r7);
        if (displayTile(r7) == false) goto L12;
        if (this.mDashboardTilePrefKeys.containsKey(r13) == true) goto L21;
        LinearLayout r3 = (LinearLayout) getPageContainerView();
        if (r3 == null) goto L12;
        OCardListItem r6 = createCardListItem(r7, getCardPosition(r1.indexOf(r7), r1.size()));
        r3.addView(r6);
        List<DynamicDataObserver> r4 = getMDashboardFeatureProvider().bindOUIToTileAndGetObservers(getActivity(), this, r10, r6, r7, r13, 0);
        registerDynamicDataObservers(r4);
        this.mDashboardTilePrefKeys.put(r13, r4);
    L29:
        if (r4 == null) goto L31;
        r11.addAll(r4);
    L31:
        r2.remove(r13);
        goto L12
    L21:
        Intrinsics.checkNotNull(r13);
        OCardListItem r8 = findCardListItem(r13);
        if (r8 == null) goto L12;
        r4 = getMDashboardFeatureProvider().bindOUIToTileAndGetObservers(getActivity(), this, r10, r8, r7, r13, 0);
        goto L29
    L15:
        OLog.d(r15, "tile does not contain a key, skipping " + r7);
        goto L12
    L32:
        Iterator r5 = r2.entrySet().iterator();
    L34:
        if (r5.hasNext() == false) goto L37;
        Map.Entry r9 = (Map.Entry) r5.next();
        String r14 = (String) r9.getKey();
        List<? extends DynamicDataObserver> r16 = (List) r9.getValue();
        this.mDashboardTilePrefKeys.remove(r14);
        removeCardListItem(r14);
        unregisterDynamicDataObservers(r16);
        goto L34
    L37:
        if ((!r11.isEmpty()) == false) goto L42;
        final CountDownLatch r17 = new CountDownLatch(1);
        new Thread(new BaseFragment$$ExternalSyntheticLambda3(r11, r17, this)).start();
        OLog.d(r15, "Start waiting observers");
        awaitObserverLatch(r17);
        OLog.d(r15, "Stop waiting observers");
        Iterator r18 = r11.iterator();
    L40:
        if (r18.hasNext() == false) goto L59;
        ((DynamicDataObserver) r18.next()).updateUi();
        goto L40
    L59:
        return;
    }

    private static final int refreshDashboardTiles$lambda$16(Tile r0, Tile r1) {
        if (r0.getType() != Tile.Type.GROUP) goto L5;
        return 0;
    L5:
        return 1;
    }

    private static final void refreshDashboardTiles$lambda$19(List r2, CountDownLatch r3, BaseFragment r4) {
        Intrinsics.checkNotNullParameter(r2, "$pendingObservers");
        Intrinsics.checkNotNullParameter(r3, "$mainLatch");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Iterator r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CountDownLatch r0 = ((DynamicDataObserver) r5.next()).getCountDownLatch();
        Intrinsics.checkNotNullExpressionValue(r0, "getCountDownLatch(...)");
        r4.awaitObserverLatch(r0);
        goto L4
    L6:
        r3.countDown();
    }

    protected boolean displayTile(Tile r3) {
        Intrinsics.checkNotNullParameter(r3, "tile");
        if (this.mSuppressInjectedTileKeys != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.hasKey() == false) goto L8;
        List<String> r0 = this.mSuppressInjectedTileKeys;
        Intrinsics.checkNotNull(r0);
        return !r0.contains(r3.getKey(getContext()));
    }

    public final void registerDynamicDataObservers(List<? extends DynamicDataObserver> r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isEmpty() == true) goto L12;
        ContentResolver r0 = getContentResolver();
        Iterator<T> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        registerDynamicDataObserver(r0, (DynamicDataObserver) r4.next());
        goto L8
    L13:
        return;
    }

    private final void registerDynamicDataObserver(ContentResolver r4, DynamicDataObserver r5) {
        OLog.d(this.TAG, "register observer: @" + Integer.toHexString(r5.hashCode()) + ", uri: " + r5.getUri());
        r4.registerContentObserver(r5.getUri(), false, r5);     // Catch: Exception -> L5
        this.mRegisteredObservers.add(r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.w(this.TAG, "Cannot register observer: " + r5.getUri(), e);
    }

    private final void unregisterDynamicDataObservers(List<? extends DynamicDataObserver> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.isEmpty() == true) goto L23;
        ContentResolver r0 = getContentResolver();
        Iterator<T> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L24;
        DynamicDataObserver r1 = (DynamicDataObserver) r8.next();
        OLog.d(this.TAG, "unregister observer: @" + Integer.toHexString(r1.hashCode()) + ", uri: " + r1.getUri());
        if (this.mRegisteredObservers.remove(r1) == false) goto L8;
        r0.unregisterContentObserver(r1);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        OLog.w(this.TAG, "Cannot unregister observer: " + r1.getUri(), e);
        goto L8
    L24:
        return;
    }

    private final void awaitObserverLatch(CountDownLatch r3) {
        r3.await(50, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L4
        return;
    }

    private final OCardListItem createCardListItem(Tile r8, int r9) {
        OCardListItem r6 = new OCardListItem(this.mContext, null, 0, 6, null);
        OCardListItem.setCardPosition$default(r6, r9, false, 2, null);
        r6.setOnContentClickListener(new BaseFragment$$ExternalSyntheticLambda1(this));
        Tile.Type r7 = r8.getType();
        if (r7 != null) goto L5;
        int r10 = -1;
    L7:
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L18;
        if (r10 != 3) goto L11;
        r6.showTailIcon(false);
        r6.setDefaultCustomEndView(1);
        r6.showCustomEnd(true);
    L20:
        return r6;
    L11:
        if (r10 != 4) goto L13;
        r6.setVisibility(8);
        goto L20
    L13:
        if (r10 != 5) goto L20;
        r6.showTailIcon(true);
        r6.setDefaultTailIcon(0);
        r6.setDefaultCustomEndView(3);
        r6.showCustomEnd(true);
        goto L20
    L18:
        r6.showTailIcon(false);
        r6.setDefaultCustomEndView(1);
        r6.showCustomEnd(true);
        goto L20
    L19:
        r6.showTailIcon(true);
        r6.setDefaultTailIcon(0);
        r6.setDefaultCustomEndView(3);
        r6.showCustomEnd(true);
        goto L20
    L5:
        r10 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        goto L7
    }

    private static final void createCardListItem$lambda$23(BaseFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        OLog.d(r2.TAG, "onClick: " + r3.getTag());
    }

    private final OCardListItem findCardListItem(String r6) {
        View r5 = getPageContainerView();
        if ((r5 instanceof LinearLayout) == false) goto L5;
        LinearLayout r7 = (LinearLayout) r5;
    L6:
        if (r7 != null) goto L8;
        return null;
    L8:
        int r0 = r7.getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L16;
        View r3 = r7.getChildAt(r2);
        if ((r3 instanceof OCardListItem) == false) goto L15;
        OCardListItem r4 = (OCardListItem) r3;
        if (Intrinsics.areEqual(r4.getTag(), r6) == false) goto L15;
        return r4;
    L15:
        r2 = r2 + 1;
        goto L9
    L16:
        return null;
    L5:
        r7 = null;
        goto L6
    }

    private final void removeCardListItem(String r5) {
        View r4 = getPageContainerView();
        if ((r4 instanceof LinearLayout) == false) goto L5;
        LinearLayout r6 = (LinearLayout) r4;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        int r0 = r6.getChildCount();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L21;
        View r2 = r6.getChildAt(r1);
        if ((r2 instanceof OCardListItem) == false) goto L15;
        if (Intrinsics.areEqual(((OCardListItem) r2).getTag(), r5) == false) goto L15;
        r6.removeView(r2);
        return;
    L15:
        r1 = r1 + 1;
        goto L9
    L21:
        return;
    L5:
        r6 = null;
        goto L6
    }

    protected final boolean isFragmentVisible() {
        return this.mIsFragmentVisible;
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(Intent r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        super.startActivity(r2, r3);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L6;
        TransitionAnimHelper.overrideEnterAnim(r1, TransitionAnimStyle.Standard);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r4) {
        super.onHiddenChanged(r4);
        OLog.d(this.TAG, "onHiddenChanged, hidden: " + r4 + ", mIsFragmentVisible: " + this.mIsFragmentVisible);
        if (r4 == true) goto L5;
    L7:
        if (r4 == false) goto L9;
        return;
    L9:
        if (this.mIsFragmentVisible == true) goto L14;
        onResume();
        return;
    L14:
        return;
    L5:
        if (this.mIsFragmentVisible == false) goto L7;
        onPause();
    }

    public void onResumeNonInitial() {
        OLog.d(this.TAG, "onResumeNonInitial");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsFirstOnResume == true) goto L5;
        onResumeNonInitial();
    L5:
        this.mIsFirstOnResume = false;
        this.mIsFragmentVisible = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsFragmentVisible = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        OLog.d(this.TAG, "onStop");
        if (this.mListeningToCategoryChange == false) goto L13;
        KeyEventDispatcher.Component r0 = getActivity();
        if ((r0 instanceof CategoryMixin.CategoryHandler) == false) goto L7;
        CategoryMixin.CategoryHandler r1 = (CategoryMixin.CategoryHandler) r0;
    L8:
        if (r1 == null) goto L12;
        CategoryMixin r2 = r1.getCategoryMixin();
        if (r2 == null) goto L12;
        r2.removeCategoryListener(this);
    L12:
        this.mListeningToCategoryChange = false;
        goto L13
    L7:
        r1 = null;
    L13:
        unregisterDynamicDataObservers(new ArrayList(this.mRegisteredObservers));
    }

    public void finish() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (this.mFinishing == true) goto L23;
        this.mFinishing = true;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        Utils.hideInputMethod(getActivity());     // Catch: Throwable -> L13
        FragmentActivity r1 = getActivity();     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        r1.onBackPressed();     // Catch: Throwable -> L13
    L11:
        OLog.d(this.TAG, "finish completed");     // Catch: Throwable -> L13
        Object r2 = Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r3 = Result.m1511exceptionOrNullimpl(r2);
        if (r3 == null) goto L22;
        OLog.e(this.TAG, "finish failed, error_msg: " + r3);
        return;
    L22:
        return;
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final void setFinishing(boolean r1) {
        this.mFinishing = r1;
    }

    private final FragmentTransaction setCustomAnimations(FragmentTransaction r3, TransactionType r4) {
        int r2 = WhenMappings.$EnumSwitchMapping$1[r4.ordinal()];
        if (r2 != 1) goto L5;
        r3.setCustomAnimations(R.animator.h_fragment_enter, R.animator.h_fragment_pop_exit, R.animator.h_fragment_pop_enter, R.animator.h_fragment_exit);
    L9:
        return r3;
    L5:
        if (r2 != 2) goto L9;
        r3.setCustomAnimations(R.animator.v_fragment_enter, R.animator.v_fragment_exit, R.animator.v_fragment_enter, R.animator.v_fragment_exit);
        goto L9
    }

    public static /* synthetic */ void start$default(BaseFragment r0, Fragment r1, TransactionType r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = TransactionType.SLIDE;
    L6:
        r0.start(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
    }

    public final void start(Fragment r4, TransactionType r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "transactionType");
        if (Utils.isFastDoubleClick(hashCode(), 300) == false) goto L5;
        return;
    L5:
        FragmentManager r0 = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r0, "getParentFragmentManager(...)");
        FragmentTransaction r1 = r0.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r1, "beginTransaction(...)");
        setCustomAnimations(r1, r5).add(R.id.fragment_container_view, r4, null).hide(this).setReorderingAllowed(true).addToBackStack(r4.getClass().getSimpleName()).commit();
    }

    public static /* synthetic */ void start$default(BaseFragment r0, Fragment r1, Bundle r2, TransactionType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = TransactionType.SLIDE;
    L6:
        r0.start(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
    }

    public final void start(Fragment r2, Bundle r3, TransactionType r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "transactionType");
        r2.setArguments(r3);
        start(r2, r4);
    }

    public static /* synthetic */ void start$default(BaseFragment r0, Class r1, TransactionType r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = TransactionType.SLIDE;
    L6:
        r0.start(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
    }

    public final void start(Class<? extends Fragment> r4, TransactionType r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "transactionType");
        if (Utils.isFastDoubleClick(hashCode(), 300) == false) goto L5;
        return;
    L5:
        FragmentManager r0 = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r0, "getParentFragmentManager(...)");
        FragmentTransaction r1 = r0.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r1, "beginTransaction(...)");
        setCustomAnimations(r1, r5).add(R.id.fragment_container_view, r4, null).hide(this).setReorderingAllowed(true).addToBackStack(r4.getSimpleName()).commit();
    }

    public static /* synthetic */ void start$default(BaseFragment r0, Class r1, Bundle r2, TransactionType r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = TransactionType.SLIDE;
    L6:
        r0.start(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
    }

    public final void start(Class<? extends Fragment> r4, Bundle r5, TransactionType r6) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r6, "transactionType");
        if (Utils.isFastDoubleClick(hashCode(), 300) == false) goto L5;
        return;
    L5:
        FragmentManager r0 = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r0, "getParentFragmentManager(...)");
        FragmentTransaction r1 = r0.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r1, "beginTransaction(...)");
        setCustomAnimations(r1, r6).add(R.id.fragment_container_view, r4, r5).hide(this).setReorderingAllowed(true).addToBackStack(r4.getSimpleName()).commit();
    }
}
