package com.android.settings.wifi.scanner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.icu.util.ULocale;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserManager;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.android.settings.databinding.ActivityQrScannerBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.olog.OLog;
import com.obric.oui.toast.OToast;
import com.obric.privacy.GrantUtil;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: QRScannerActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0010*\u0001\u001a\u0018\u0000 N2\u00020\u0001:\u0002NOB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J-\u0010&\u001a\u0004\u0018\u00010\u001d2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020#H\u0002J\u0015\u00101\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b2J\u0012\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020#H\u0014J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020#H\u0014J-\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020*2\u000e\u0010=\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0(2\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020#H\u0014J\b\u0010C\u001a\u00020#H\u0002J\b\u0010D\u001a\u00020#H\u0002J\u0010\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020*H\u0002J\b\u0010G\u001a\u00020#H\u0002J\b\u0010H\u001a\u00020#H\u0002J\b\u0010I\u001a\u00020#H\u0002J\b\u0010J\u001a\u00020#H\u0002J\b\u0010K\u001a\u00020#H\u0002J\b\u0010L\u001a\u00020#H\u0002J\b\u0010M\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/android/settings/wifi/scanner/QRScannerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/android/settings/databinding/ActivityQrScannerBinding;", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "canStartCapture", "", "captureRequestBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "captureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "isInSelectingPicture", "isTorchOn", "mWifiManager", "Landroid/net/wifi/WifiManager;", "motionDetector", "Lcom/android/settings/wifi/scanner/MotionDetector;", "permissionRequestState", "Lcom/android/settings/wifi/scanner/QRScannerActivity$PermissionRequestState;", "scannerManager", "Lcom/android/settings/wifi/scanner/ScannerManager;", "scannerMaskView", "Lcom/android/settings/wifi/scanner/ScannerMaskView;", "stateCallback", "com/android/settings/wifi/scanner/QRScannerActivity$stateCallback$1", "Lcom/android/settings/wifi/scanner/QRScannerActivity$stateCallback$1;", "surfaceSize", "Landroid/util/Size;", "surfaceView", "Lcom/android/settings/wifi/scanner/AutoFitSurfaceView;", "timer", "Ljava/util/Timer;", "activeScanner", "", "captureBitmapFromSurface", "closeAndFinish", "getOptimalPreviewSize", "sizes", "", "w", "", "h", "([Landroid/util/Size;II)Landroid/util/Size;", "getScreenSize", "context", "Landroid/content/Context;", "inactiveScanner", "isAddWifiConfigAllowed", "isAddWifiConfigAllowed$app_neridaCnRelease", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMotionStateChanged", "state", "Lcom/android/settings/wifi/scanner/MotionDetector$State;", "onPause", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "openCamera", "setStatusBarIconsForCurrentTheme", "showToast", "messageId", "startCaptureRequest", "startMotionDetector", "startPreview", "stopCameraDevice", "stopCaptureRequest", "stopMotionDetector", "updateCameraPreviewRatio", "Companion", "PermissionRequestState", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class QRScannerActivity extends AppCompatActivity {
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    public static final Companion Companion = null;
    public static final int DESIRED_IMAGE_SIZE = 1000000;
    public static final String TAG = "ScannerActivity";
    private ActivityQrScannerBinding binding;
    private CameraDevice cameraDevice;
    private volatile boolean canStartCapture;
    private CaptureRequest.Builder captureRequestBuilder;
    private CameraCaptureSession captureSession;
    private volatile boolean isInSelectingPicture;
    private boolean isTorchOn;
    private WifiManager mWifiManager;
    private MotionDetector motionDetector;
    private PermissionRequestState permissionRequestState;
    private final ScannerManager scannerManager;
    private ScannerMaskView scannerMaskView;
    private final QRScannerActivity$stateCallback$1 stateCallback;
    private Size surfaceSize;
    private AutoFitSurfaceView surfaceView;
    private Timer timer;

    /* JADX INFO: compiled from: QRScannerActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/settings/wifi/scanner/QRScannerActivity$Companion;", "", "()V", "CAMERA_PERMISSION_REQUEST_CODE", "", "DESIRED_IMAGE_SIZE", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: QRScannerActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/settings/wifi/scanner/QRScannerActivity$PermissionRequestState;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "STARTED", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum PermissionRequestState extends Enum<PermissionRequestState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PermissionRequestState[] $VALUES = null;
        public static final PermissionRequestState NOT_STARTED = null;
        public static final PermissionRequestState STARTED = null;

        private static final /* synthetic */ PermissionRequestState[] $values() {
            return new PermissionRequestState[]{NOT_STARTED, STARTED};
        }

        public static EnumEntries<PermissionRequestState> getEntries() {
            return $ENTRIES;
        }

        public static PermissionRequestState valueOf(String r1) {
            return (PermissionRequestState) Enum.valueOf(PermissionRequestState.class, r1);
        }

        public static PermissionRequestState[] values() {
            return (PermissionRequestState[]) $VALUES.clone();
        }

        private PermissionRequestState(String r1, int r2) {
            super(r1, r2);
        }

        static {
            NOT_STARTED = new PermissionRequestState("NOT_STARTED", 0);
            STARTED = new PermissionRequestState("STARTED", 1);
            PermissionRequestState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }
    }

    /* JADX INFO: renamed from: com.android.settings.wifi.scanner.QRScannerActivity$startMotionDetector$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: QRScannerActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* synthetic */ class C01581 extends FunctionReferenceImpl implements Function1<MotionDetector.State, Unit> {
        C01581(Object r8) {
            super(1, r8, QRScannerActivity.class, "onMotionStateChanged", "onMotionStateChanged(Lcom/android/settings/wifi/scanner/MotionDetector$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MotionDetector.State r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MotionDetector.State r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            QRScannerActivity.access$onMotionStateChanged((QRScannerActivity) this.receiver, r2);
        }
    }

    public static /* synthetic */ void $r8$lambda$0ihWae76Hz3eAxnvn8KzvEDN_t0(QRScannerActivity r0, View r1) {
        onCreate$lambda$6$lambda$5$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$1WnOwv1Vlx64-7td-tafnqzsC08, reason: not valid java name */
    public static /* synthetic */ void m729$r8$lambda$1WnOwv1Vlx647tdtafnqzsC08(QRScannerActivity r0, View r1) {
        onCreate$lambda$6$lambda$2$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$1p_-uy4Uurpnubj-53Rf_16m9t8, reason: not valid java name */
    public static /* synthetic */ void m730$r8$lambda$1p_uy4Uurpnubj53Rf_16m9t8(QRScannerActivity r0) {
        startCaptureRequest$lambda$10(r0);
    }

    public static /* synthetic */ void $r8$lambda$JRK076pAyjc_xK3dlVoqNDeVMwg(QRScannerActivity r0) {
        closeAndFinish$lambda$7(r0);
    }

    public static /* synthetic */ void $r8$lambda$Uujqx7bzHtL31aOLaBXFcvOcVks(QRScannerActivity r0, int r1) {
        showToast$lambda$14(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZhgU56ZwYZzp987DH95KZdBrtx4(QRScannerActivity r0) {
        stopCaptureRequest$lambda$11(r0);
    }

    public static /* synthetic */ void $r8$lambda$fRQ5CJNbB1MxLvpi8z_z1wq_wWY(QRScannerActivity r0, Bitmap r1, int r2) {
        captureBitmapFromSurface$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$vHVDm_ndFobgQDFj56ivByk61mg(QRScannerActivity r0) {
        activeScanner$lambda$8(r0);
    }

    public static /* synthetic */ void $r8$lambda$yNqFtAUfk8AzbKkOnsyT8Byvwjk(QRScannerActivity r0) {
        stopCameraDevice$lambda$12(r0);
    }

    public static /* synthetic */ void $r8$lambda$zJTEDrPpBTsM0SIjrCDh9ZhfrWc(QRScannerActivity r0) {
        inactiveScanner$lambda$9(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_settings_wifi_scanner_QRScannerActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_scanner_QRScannerActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.settings.wifi.scanner.QRScannerActivity$stateCallback$1] */
    public QRScannerActivity() {
        this.permissionRequestState = PermissionRequestState.NOT_STARTED;
        this.scannerManager = new ScannerManager(new QRScannerActivity$scannerManager$1(this));
        this.stateCallback = new QRScannerActivity$stateCallback$1(this);
    }

    public static final /* synthetic */ void access$captureBitmapFromSurface(QRScannerActivity r0) {
        r0.captureBitmapFromSurface();
    }

    public static final /* synthetic */ void access$closeAndFinish(QRScannerActivity r0) {
        r0.closeAndFinish();
    }

    public static final /* synthetic */ WifiManager access$getMWifiManager$p(QRScannerActivity r0) {
        return r0.mWifiManager;
    }

    public static final /* synthetic */ MotionDetector access$getMotionDetector$p(QRScannerActivity r0) {
        return r0.motionDetector;
    }

    public static final /* synthetic */ Timer access$getTimer$p(QRScannerActivity r0) {
        return r0.timer;
    }

    public static final /* synthetic */ void access$onMotionStateChanged(QRScannerActivity r0, MotionDetector.State r1) {
        r0.onMotionStateChanged(r1);
    }

    public static final /* synthetic */ void access$openCamera(QRScannerActivity r0) {
        r0.openCamera();
    }

    public static final /* synthetic */ void access$setCameraDevice$p(QRScannerActivity r0, CameraDevice r1) {
        r0.cameraDevice = r1;
    }

    public static final /* synthetic */ void access$setCanStartCapture$p(QRScannerActivity r0, boolean r1) {
        r0.canStartCapture = r1;
    }

    public static final /* synthetic */ void access$setCaptureSession$p(QRScannerActivity r0, CameraCaptureSession r1) {
        r0.captureSession = r1;
    }

    public static final /* synthetic */ void access$startCaptureRequest(QRScannerActivity r0) {
        r0.startCaptureRequest();
    }

    public static final /* synthetic */ void access$startPreview(QRScannerActivity r0) {
        r0.startPreview();
    }

    public static final /* synthetic */ void access$stopCameraDevice(QRScannerActivity r0) {
        r0.stopCameraDevice();
    }

    public void com_android_settings_wifi_scanner_QRScannerActivity__onCreate$___twin___(Bundle r14) {
        super.onCreate(r14);
        Context r15 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r15, "getApplicationContext(...)");
        if (isAddWifiConfigAllowed$app_neridaCnRelease(r15) == true) goto L6;
        finish();
        return;
    L6:
        Object r16 = getSystemService("wifi");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.mWifiManager = (WifiManager) r16;
        AutoFitSurfaceView r1 = null;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        setStatusBarIconsForCurrentTheme();
        this.surfaceSize = getScreenSize(this);
        WindowManager.LayoutParams r17 = getWindow().getAttributes();
        Intrinsics.checkNotNullExpressionValue(r17, "getAttributes(...)");
        TransitionAnimHelper.enableModalTransition$default(r17, false, 2, null);
        ActivityQrScannerBinding r18 = ActivityQrScannerBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r18, "inflate(...)");
        ScannerMaskView r0 = r18.scannerMask;
        Intrinsics.checkNotNullExpressionValue(r0, "scannerMask");
        this.scannerMaskView = r0;
        Size r2 = this.surfaceSize;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");
        r2 = null;
    L9:
        float r3 = r2.getWidth();
        Size r4 = this.surfaceSize;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");
        r4 = null;
    L12:
        float r5 = r3 / 360.0f;
        float r6 = r4.getHeight() / 800.0f;
        int r7 = (int) (56.0f * r5);
        int r8 = (int) (240.0f * r6);
        int r9 = (int) (248.0f * r5);
        int r10 = (int) (r5 * 0.0f);
        int r11 = (int) (180.0f * r6);
        int r12 = (int) (r5 * 360.0f);
        int r13 = r7 + r9;
        int r19 = r9 + r8;
        Rect r20 = new Rect(r7, r8, r13, r19);
        Rect r21 = new Rect(r10, r11, r10 + r12, r12 + r11);
        ScannerMaskView r22 = this.scannerMaskView;
        if (r22 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
        r22 = null;
    L15:
        r22.setCaptureRects(r20, r21);
        ViewGroup.LayoutParams r23 = r18.barcodeScanHint.getLayoutParams();
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r24 = (FrameLayout.LayoutParams) r23;
        r24.gravity = 49;
        r24.topMargin = r19 + ((int) (r6 * 12.0f));
        r24.bottomMargin = 0;
        r18.barcodeScanHint.setLayoutParams(r24);
        AutoFitSurfaceView r25 = r18.barcodeScanner;
        Intrinsics.checkNotNullExpressionValue(r25, "barcodeScanner");
        Size r26 = this.surfaceSize;
        if (r26 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");
        r26 = null;
    L18:
        int r27 = r26.getHeight();
        Size r28 = this.surfaceSize;
        if (r28 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");
        r28 = null;
    L21:
        r25.setAspectRatio(r27, r28.getWidth(), 0.0f, false);
        this.surfaceView = r25;
        updateCameraPreviewRatio();
        r18.exitBarcodeScan.setOnClickListener(new QRScannerActivity$$ExternalSyntheticLambda1(this));
        r18.scannerPage.setHandleInterceptEvent(new QRScannerActivity$onCreate$1$3$1(this));
        r18.inactivePage.setOnClickListener(new QRScannerActivity$$ExternalSyntheticLambda2(this));
        this.binding = r18;
        if (r18 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L24:
        setContentView(r18.getRoot());
        AutoFitSurfaceView r110 = this.surfaceView;
        if (r110 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
    L28:
        r1.getHolder().addCallback(new AnonymousClass2(this));
        return;
    L27:
        r1 = r110;
        goto L28
    }

    private static final void onCreate$lambda$6$lambda$2$lambda$1(QRScannerActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.closeAndFinish();
    }

    private static final void onCreate$lambda$6$lambda$5$lambda$4(QRScannerActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.activeScanner();
    }

    public final boolean isAddWifiConfigAllowed$app_neridaCnRelease(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        UserManager r2 = (UserManager) r3.getSystemService(UserManager.class);
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        OLog.e(TAG, "The user is not allowed to add Wi-Fi configuration.");
        return false;
    L11:
        return true;
    L5:
        if (r2.hasUserRestriction("no_add_wifi_config") != true) goto L7;
        r4 = true;
        goto L8
    }

    public void com_android_settings_wifi_scanner_QRScannerActivity__onResume$___twin___() {
        super.onResume();
        startMotionDetector();
        this.scannerManager.startScan();
        getWindow().addFlags(128);
    }

    public void com_android_settings_wifi_scanner_QRScannerActivity__onPause$___twin___() {
        super.onPause();
        stopMotionDetector();
        this.scannerManager.stopScan();
        getWindow().clearFlags(128);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        closeAndFinish();
        this.scannerManager.release();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        Intrinsics.checkNotNullParameter(r4, "grantResults");
        super.onRequestPermissionsResult(r2, r3, r4);
        if (r2 == 100) goto L5;
        return;
    L5:
        if (r4.length != 0) goto L7;
        boolean r5 = true;
    L9:
        if ((!r5) == true) goto L11;
    L13:
        OLog.e(TAG, "request camera permission denied!");
        return;
    L11:
        if (r4[0] != 0) goto L13;
        openCamera();
        return;
    L7:
        r5 = false;
        goto L9
    }

    private final void closeAndFinish() {
        runOnUiThread(new QRScannerActivity$$ExternalSyntheticLambda7(this));
    }

    private static final void closeAndFinish$lambda$7(QRScannerActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Timer r0 = r1.timer;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        r1.stopCameraDevice();
        r1.finish();
    }

    private final void activeScanner() {
        runOnUiThread(new QRScannerActivity$$ExternalSyntheticLambda4(this));
    }

    private static final void activeScanner$lambda$8(QRScannerActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        ActivityQrScannerBinding r0 = r4.binding;
        ActivityQrScannerBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.scannerPage.setVisibility(0);
        ActivityQrScannerBinding r2 = r4.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r1.inactivePage.setVisibility(8);
        r4.startCaptureRequest();
        MotionDetector r5 = r4.motionDetector;
        if (r5 == null) goto L13;
        r5.resetLastActiveTime();
        return;
    L13:
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void inactiveScanner() {
        runOnUiThread(new QRScannerActivity$$ExternalSyntheticLambda9(this));
    }

    private static final void inactiveScanner$lambda$9(QRScannerActivity r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        r4.stopCaptureRequest();
        ActivityQrScannerBinding r0 = r4.binding;
        ActivityQrScannerBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.scannerPage.setVisibility(8);
        ActivityQrScannerBinding r5 = r4.binding;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r1.inactivePage.setVisibility(0);
        return;
    L8:
        r1 = r5;
        goto L9
    }

    private final void onMotionStateChanged(MotionDetector.State r3) {
        OLog.d(TAG, "onMotionStateChanged, state = " + r3);
        if (this.isInSelectingPicture == false) goto L6;
        return;
    L6:
        if (r3 != MotionDetector.State.INACTIVE) goto L9;
        inactiveScanner();
        return;
    }

    private final void openCamera() {
        if (this.canStartCapture == true) goto L5;
        return;
    L5:
        Object r1 = getSystemService("camera");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager r2 = (CameraManager) r1;
        String r3 = r2.getCameraIdList()[0];     // Catch: CameraAccessException -> L12
        if (ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) goto L10;
        OLog.e(TAG, "permission is denied, can not open camera!");     // Catch: CameraAccessException -> L12
        return;
    L10:
        r2.openCamera(r3, this.stateCallback, null);     // Catch: CameraAccessException -> L12
        Timer r5 = new Timer();     // Catch: CameraAccessException -> L12
        this.timer = r5;     // Catch: CameraAccessException -> L12
        r5.schedule(new AnonymousClass1(this), 0, 50);     // Catch: CameraAccessException -> L12
        return;
    L12:
        e = move-exception;
        OLog.e(TAG, "open camera failed, exception: " + e);
    }

    private final void startPreview() {
        if (this.cameraDevice != null) goto L5;
        return;
    L5:
        if (this.canStartCapture == false) goto L24;
        AutoFitSurfaceView r0 = this.surfaceView;     // Catch: CameraAccessException -> L17
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");     // Catch: CameraAccessException -> L17
        r0 = null;
    L10:
        Surface r1 = r0.getHolder().getSurface();     // Catch: CameraAccessException -> L17
        if (r1.isValid() == true) goto L13;
        return;
    L13:
        CameraDevice r2 = this.cameraDevice;     // Catch: CameraAccessException -> L17
        Intrinsics.checkNotNull(r2);     // Catch: CameraAccessException -> L17
        CaptureRequest.Builder r3 = r2.createCaptureRequest(1);     // Catch: CameraAccessException -> L17
        this.captureRequestBuilder = r3;     // Catch: CameraAccessException -> L17
        Intrinsics.checkNotNull(r3);     // Catch: CameraAccessException -> L17
        r3.addTarget(r1);     // Catch: CameraAccessException -> L17
        SessionConfiguration r4 = new SessionConfiguration(0, CollectionsKt.listOf(new OutputConfiguration(r1)), getMainExecutor(), new QRScannerActivity$startPreview$sessionConfiguration$1(this));     // Catch: CameraAccessException -> L17
        CameraDevice r5 = this.cameraDevice;     // Catch: CameraAccessException -> L17
        if (r5 == null) goto L23;
        r5.createCaptureSession(r4);     // Catch: CameraAccessException -> L17
        return;
    L23:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private final void startCaptureRequest() {
        runOnUiThread(new QRScannerActivity$$ExternalSyntheticLambda0(this));
    }

    private static final void startCaptureRequest$lambda$10(QRScannerActivity r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        AutoFitSurfaceView r1 = r5.surfaceView;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r1 = null;
    L6:
        if (r1.getHolder().getSurface().isValid() == true) goto L9;
        return;
    L9:
        if (r5.canStartCapture == true) goto L11;
        return;
    L11:
        if (r5.cameraDevice != null) goto L14;
        return;
    L14:
        if (r5.captureSession == null) goto L36;
        CaptureRequest.Builder r2 = r5.captureRequestBuilder;
        if (r2 != null) goto L19;
        return;
    L19:
        if (r5.isTorchOn == false) goto L21;
        int r3 = 2;
    L32:
        Intrinsics.checkNotNull(r2);     // Catch: CameraAccessException -> L26 IllegalStateException -> L29
        r2.set(CaptureRequest.FLASH_MODE, Integer.valueOf(r3));     // Catch: CameraAccessException -> L26 IllegalStateException -> L29
        CameraCaptureSession r4 = r5.captureSession;     // Catch: CameraAccessException -> L26 IllegalStateException -> L29
        if (r4 == null) goto L34;
        CaptureRequest.Builder r6 = r5.captureRequestBuilder;     // Catch: CameraAccessException -> L26 IllegalStateException -> L29
        Intrinsics.checkNotNull(r6);     // Catch: CameraAccessException -> L26 IllegalStateException -> L29
        r4.setRepeatingRequest(r6.build(), null, null);     // Catch: CameraAccessException -> L26 IllegalStateException -> L29
        return;
    L34:
        return;
    L26:
        e = move-exception;
        OLog.e(TAG, "startCaptureRequest camera access failed: " + e);
        return;
    L29:
        e = move-exception;
        OLog.e(TAG, "startCaptureRequest failed: session is closed, " + e.getMessage());
        return;
    L21:
        r3 = 0;
        goto L32
    }

    private final void stopCaptureRequest() {
        runOnUiThread(new QRScannerActivity$$ExternalSyntheticLambda6(this));
    }

    private static final void stopCaptureRequest$lambda$11(QRScannerActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r3.canStartCapture == true) goto L5;
        return;
    L5:
        if (r3.cameraDevice == null) goto L20;
        CameraCaptureSession r4 = r3.captureSession;     // Catch: IllegalStateException -> L11 CameraAccessException -> L13
        if (r4 == null) goto L18;
        r4.stopRepeating();     // Catch: IllegalStateException -> L11 CameraAccessException -> L13
    L21:
        return;
    L18:
        return;
    L13:
        OLog.e(TAG, "stop camera session failed!");
        return;
    L11:
        e = move-exception;
        OLog.e(TAG, "stopCaptureRequest session closed: " + e.getMessage());
        return;
    }

    private final void stopCameraDevice() {
        runOnUiThread(new QRScannerActivity$$ExternalSyntheticLambda5(this));
    }

    private static final void stopCameraDevice$lambda$12(QRScannerActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        CameraCaptureSession r0 = r2.captureSession;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.close();
        r2.captureSession = null;
    L5:
        CameraDevice r1 = r2.cameraDevice;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r1);
        r1.close();
        r2.cameraDevice = null;
        return;
    }

    private final void startMotionDetector() {
        MotionDetector r0 = new MotionDetector(this, new C01581(this));
        this.motionDetector = r0;
        r0.start();
    }

    private final void stopMotionDetector() {
        MotionDetector r0 = this.motionDetector;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        this.motionDetector = null;
    }

    private final void captureBitmapFromSurface() {
        ActivityQrScannerBinding r0 = this.binding;
        ScannerMaskView r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L6:
        if (r0.scannerPage.getVisibility() == 0) goto L9;
        return;
    L9:
        if (this.isInSelectingPicture == false) goto L11;
        return;
    L11:
        if (this.canStartCapture == true) goto L13;
        return;
    L13:
        if (this.cameraDevice != null) goto L16;
        return;
    L16:
        if (isFinishing() == false) goto L18;
        return;
    L18:
        AutoFitSurfaceView r2 = this.surfaceView;
        if (r2 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");
        r2 = null;
    L21:
        Surface r3 = r2.getHolder().getSurface();
        if (r3.isValid() == true) goto L24;
        return;
    L24:
        ScannerMaskView r4 = this.scannerMaskView;
        if (r4 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
        r4 = null;
    L27:
        int r5 = r4.getRealCaptureRect().width();
        ScannerMaskView r6 = this.scannerMaskView;
        if (r6 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
        r6 = null;
    L30:
        final Bitmap r7 = Bitmap.createBitmap(r5, r6.getRealCaptureRect().height(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(r7, "createBitmap(width, height, config)");
        ScannerMaskView r8 = this.scannerMaskView;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("scannerMaskView");
    L34:
        PixelCopy.request(r3, r1.getRealCaptureRect(), r7, new QRScannerActivity$$ExternalSyntheticLambda8(this, r7), new Handler(Looper.getMainLooper()));
        return;
    L33:
        r1 = r8;
        goto L34
    }

    private static final void captureBitmapFromSurface$lambda$13(QRScannerActivity r1, Bitmap r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$bitmap");
        if (r3 != 0) goto L5;
        r1.scannerManager.addSource(new SourceData(SourceData.Type.FROM_CAMERA, r2));
        return;
    L5:
        OLog.e(TAG, "Failed to copy bitmap: " + r3);
    }

    private final void showToast(final int r2) {
        runOnUiThread(new QRScannerActivity$$ExternalSyntheticLambda3(this, r2));
    }

    private static final void showToast$lambda$14(QRScannerActivity r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        if (r9.isFinishing() == false) goto L6;
        OLog.e(TAG, "activity is finishing.");
        return;
    L6:
        String r2 = r9.getString(r10);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        new OToast(r9, r2, 80, false, null, 0, 56, null).show();
    }

    private final void updateCameraPreviewRatio() {
        Object r2 = getSystemService("camera");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager r3 = (CameraManager) r2;
        String[] r4 = r3.getCameraIdList();     // Catch: Exception -> L43
        Intrinsics.checkNotNullExpressionValue(r4, "getCameraIdList(...)");     // Catch: Exception -> L43
        boolean r5 = true;
        if (r4.length != 0) goto L6;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L9;
        return;
    L9:
        CameraCharacteristics r7 = r3.getCameraCharacteristics(r4[0]);     // Catch: Exception -> L43
        Intrinsics.checkNotNullExpressionValue(r7, "getCameraCharacteristics(...)");     // Catch: Exception -> L43
        StreamConfigurationMap r8 = (StreamConfigurationMap) r7.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: Exception -> L43
        if (r8 != null) goto L12;
        return;
    L12:
        Size[] r9 = r8.getOutputSizes(SurfaceHolder.class);     // Catch: Exception -> L43
        if (r9 != null) goto L15;
    L21:
        if (r5 == true) goto L48;
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L43
        Size r10 = this.surfaceSize;     // Catch: Exception -> L43
        AutoFitSurfaceView r11 = null;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");     // Catch: Exception -> L43
        r10 = null;
    L26:
        int r12 = r10.getHeight();     // Catch: Exception -> L43
        Size r13 = this.surfaceSize;     // Catch: Exception -> L43
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");     // Catch: Exception -> L43
        r13 = null;
    L29:
        Size r14 = getOptimalPreviewSize(r9, r12, r13.getWidth());     // Catch: Exception -> L43
        if (r14 == null) goto L49;
        StringBuilder r1 = new StringBuilder("Selected optimal preview size: ").append(r14.getWidth()).append(ULocale.PRIVATE_USE_EXTENSION).append(r14.getHeight()).append(" for screen ");     // Catch: Exception -> L43
        Size r15 = this.surfaceSize;     // Catch: Exception -> L43
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");     // Catch: Exception -> L43
        r15 = null;
    L34:
        StringBuilder r16 = r1.append(r15.getWidth()).append(ULocale.PRIVATE_USE_EXTENSION);     // Catch: Exception -> L43
        Size r17 = this.surfaceSize;     // Catch: Exception -> L43
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceSize");     // Catch: Exception -> L43
        r17 = null;
    L37:
        OLog.i(TAG, r16.append(r17.getHeight()).toString());     // Catch: Exception -> L43
        AutoFitSurfaceView r18 = this.surfaceView;     // Catch: Exception -> L43
        if (r18 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceView");     // Catch: Exception -> L43
    L41:
        r11.setAspectRatio(r14.getWidth(), r14.getHeight(), 0.0f, false);     // Catch: Exception -> L43
        return;
    L40:
        r11 = r18;
        goto L41
    L49:
        return;
    L48:
        return;
    L15:
        if (r9.length != 0) goto L17;
        boolean r19 = true;
    L18:
        if (r19 == true) goto L21;
        r5 = false;
        goto L21
    L17:
        r19 = false;
        goto L18
    L6:
        r6 = false;
    L43:
        e = move-exception;
        OLog.e(TAG, "Failed to update camera preview ratio: " + e.getMessage());
    }

    private final Size getOptimalPreviewSize(Size[] r17, int r18, int r19) {
        double r3 = ((double) r18) / ((double) r19);
        int r5 = 0;
        if (r17.length != 0) goto L5;
        boolean r1 = true;
    L6:
        Size r6 = null;
        if (r1 == false) goto L9;
        return null;
    L9:
        int r2 = r17.length;
        int r9 = 0;
        double r10 = Double.MAX_VALUE;
    L10:
        if (r9 >= r2) goto L17;
        Size r12 = r17[r9];
        if (Math.abs((((double) r12.getWidth()) / ((double) r12.getHeight())) - r3) > 0.1d) goto L16;
        if (Math.abs(r12.getHeight() - r19) >= r10) goto L16;
        r10 = Math.abs(r12.getHeight() - r19);
        r6 = r12;
    L16:
        r9 = r9 + 1;
        goto L10
    L17:
        if (r6 != null) goto L24;
        int r4 = r17.length;
        double r7 = Double.MAX_VALUE;
    L19:
        if (r5 >= r4) goto L24;
        Size r8 = r17[r5];
        double r11 = Math.abs((((double) r8.getWidth()) / ((double) r8.getHeight())) - r3);
        if (r11 >= r7) goto L23;
        r6 = r8;
        r7 = r11;
    L23:
        r5 = r5 + 1;
    L24:
        return r6;
    L5:
        r1 = false;
        goto L6
    }

    private final void setStatusBarIconsForCurrentTheme() {
        WindowInsetsControllerCompat r1 = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(r1, "getInsetsController(...)");
        r1.setAppearanceLightStatusBars(false);
    }

    public final Size getScreenSize(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r1 = r2.getSystemService("window");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        WindowMetrics r3 = ((WindowManager) r1).getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(r3, "getCurrentWindowMetrics(...)");
        return new Size(r3.getBounds().width(), r3.getBounds().height());
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_scanner_QRScannerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(QRScannerActivity r1) {
        r1.com_android_settings_wifi_scanner_QRScannerActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(QRScannerActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(QRScannerActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_wifi_scanner_QRScannerActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        QRScannerActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(QRScannerActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_scanner_QRScannerActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(QRScannerActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_scanner_QRScannerActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(QRScannerActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_wifi_scanner_QRScannerActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_scanner_QRScannerActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(QRScannerActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_wifi_scanner_QRScannerActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        QRScannerActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
