package com.fidelium.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;

/**
 * <pre>
 * 시스템	: ncms-app-server
 * TYPE	: util 
 * Desc.	: File 관련 유틸
 * </pre>
 * 
 * @author 1700082@partner.skcc.com
 * @since 2017. 7. 11.
 *
 * @see
 */
public class FileUtil {

    private static final List<String> RESTRICTED_FILE_EXTS = Arrays.asList("exe", "jsp", "class");

    /**
     * Default Constructor
     */
    private FileUtil() {
    }

    public static final String makeDirectory(String home, String path) {
        // make home directory
        File file = new File(home, path == null ? "." : path);
        if (!file.isDirectory())
            file.mkdirs();
        return file.getAbsolutePath();
    }

    public static final String getExtension(String filename, long size, Map<String, Boolean> excludes, String limitSize) throws FileUploadException {
        long limit = 0;
        try {
            if (limitSize != null && !"".equals(limitSize)) {
                limit = Long.parseLong(limitSize);
            }
        } catch (NumberFormatException e) {
            limit = 0;
        }
        String v = null;
        try {
            v = getExtension(filename, size, excludes, limit);
        } catch (FileUploadException e) {
            throw e;
        }
        return v;
    }

    public static final String getExtension(String filename, long size, Map<String, Boolean> excludes, long limitSize) throws FileUploadException {
        if (limitSize > 0 && size > limitSize)
            throw new FileUploadException("fail.file.limitSize");

        String ext = FilenameUtils.getExtension(filename);
        if (ext == null || "".equals(ext)) {
            return "";
        }
        ext = ext.toLowerCase();
        if (excludes.containsKey(ext) && excludes.get(ext))
            throw new FileUploadException("fail.file.excludes");
        return ext;
    }

    public static final String getUuid(String ext) {
        UUID uuid = UUID.randomUUID();
        if (uuid == null) {
            return null;
        }
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        byte[] buffer = new byte[16];
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) (msb >>> 8 * (7 - i));
        }
        for (int i = 8; i < 16; i++) {
            buffer[i] = (byte) (lsb >>> 8 * (7 - i));
        }

        String v = new String(Hex.encodeHex(buffer));
        String s = "".equals(ext) ? "" : "." + ext;
        return v + s;
    }

    /**
     * 파일 변경
     * 
     * @param beforeFilePath
     * @param currentFilePath
     */
    public static final void renameFile(String beforeFilePath, String currentFilePath) {
        File file = new File(currentFilePath);
        if (file.isFile()) {
            FileUtil.delete(file);
        }

        File beforeFile = new File(beforeFilePath);
        if (beforeFile.renameTo(file)) {
            FileUtil.delete(beforeFile);
        }
    }

    /**
     * 파일 삭제하기
     * 
     * @param filepath
     */
    public static final boolean delete(String filepath) {
        if (filepath == null || "".equals(filepath)) {
            return false;
        }

        File file = new File(filepath);
        if (file.isFile() && file.canWrite()) {
            return file.delete();
        } else {
            return false;
        }
    }

    /**
     * 파일 삭제
     * 
     * @param file
     *            삭제할 파일
     * @return
     */
    public static final boolean delete(File file) {
        if (file != null && file.isFile() && file.canWrite()) {
            return file.delete();
        } else {
            return false;
        }
    }

    public static final boolean isNotRestrictedFileTypes(String path) {
        if (StringUtils.hasText(path)) {
            String ext = FilenameUtils.getExtension(path);
            if (StringUtils.hasText(ext)) {
                if (RESTRICTED_FILE_EXTS != null)
                    return !RESTRICTED_FILE_EXTS.contains(ext);
                else
                    return false;
            }
        }

        return true;
    }

}
