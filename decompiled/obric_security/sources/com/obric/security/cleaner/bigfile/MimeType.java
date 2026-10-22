package com.obric.security.cleaner.bigfile;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.security.safecheckapi.CheckResult;
import kotlin.Metadata;

/* JADX INFO: compiled from: MimeType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b)\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/security/cleaner/bigfile/MimeType;", "", "()V", CheckResult.TYPE_APK, "", "AUDIO_M3U8", "AUDIO_REG", "AVI", "CSV", "DOC", "DOCM", "DOCX", "EPUB", "EXCELM", "EXE", "GIF", "HTML", "IMG_REG", "JPEG", "MOBI", "MOV", "MP3", "MP4", "P7Z", "PDF", "PDFX", "PDF_REG", "PNG", "PPT", "PPTM", "PPTX", "RAR", "TEXT_REG", "TIFF", "TXT", NetworkStackConstant.UNKNOWN_TYPE, "VIDEO_M3U8", "VIDEO_REG", "WAV", "WAVX", "WEBP", "WMV", "XLS", "XLSX", "ZIP", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MimeType {
    public static final String APK = "application/vnd.android.package-archive";
    public static final String AUDIO_M3U8 = "audio/x-mpegurl";
    public static final String AUDIO_REG = "(audio/.+)|(application/ogg)";
    public static final String AVI = "video/x-msvideo";
    public static final String CSV = "text/comma-separated-values";
    public static final String DOC = "application/msword";
    public static final String DOCM = "application/vnd.ms-word.document.macroenabled.12";
    public static final String DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String EPUB = "application/epub+zip";
    public static final String EXCELM = "application/vnd.ms-excel.sheet.macroenabled.12";
    public static final String EXE = "application/vnd.microsoft.portable-executable";
    public static final String GIF = "image/gif";
    public static final String HTML = "text/html";
    public static final String IMG_REG = "image/.+";
    public static final MimeType INSTANCE = null;
    public static final String JPEG = "image/jpeg";
    public static final String MOBI = "application/x-mobipocket-ebook";
    public static final String MOV = "video/quicktime";
    public static final String MP3 = "audio/mpeg";
    public static final String MP4 = "video/mp4";
    public static final String P7Z = "application/x-7z-compressed";
    public static final String PDF = "application/pdf";
    public static final String PDFX = "application/((?i)x)-pdf";
    public static final String PDF_REG = "(application/pdf)|(application/((?i)x)-pdf)";
    public static final String PNG = "image/png";
    public static final String PPT = "application/vnd.ms-powerpoint";
    public static final String PPTM = "application/vnd.ms-powerpoint.presentation.macroenabled.12";
    public static final String PPTX = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    public static final String RAR = "application/x-rar-compressed";
    public static final String TEXT_REG = "text/.+";
    public static final String TIFF = "image/tiff";
    public static final String TXT = "text/plain";
    public static final String UNKNOWN = "application/octet-stream";
    public static final String VIDEO_M3U8 = "application/vnd.apple.mpegurl";
    public static final String VIDEO_REG = "video/.+";
    public static final String WAV = "audio/wav";
    public static final String WAVX = "audio/x-wav";
    public static final String WEBP = "image/webp";
    public static final String WMV = "video/x-ms-wmv";
    public static final String XLS = "application/vnd.ms-excel";
    public static final String XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String ZIP = "application/zip";

    static {
        INSTANCE = new MimeType();
    }

    private MimeType() {
    }
}
