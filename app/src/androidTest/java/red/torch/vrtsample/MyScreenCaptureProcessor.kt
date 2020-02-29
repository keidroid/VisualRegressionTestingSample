package red.torch.vrtsample

import android.os.Build
import android.util.Log
import androidx.test.runner.screenshot.ScreenCapture
import androidx.test.runner.screenshot.ScreenCaptureProcessor
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * @see androidx.test.runner.screenshot.BasicScreenCaptureProcessor
 */
open class MyScreenCaptureProcessor internal constructor(
    private var mDefaultScreenshotPath: File = File("/sdcard", "screenshots")
) : ScreenCaptureProcessor {
    private var mTag = "MyScreenCaptureProcessor"
    private var mFileNameDelimiter = "-"
    private var mDefaultFilenamePrefix = "screenshot"

    @Throws(IOException::class)
    override fun process(capture: ScreenCapture): String {
        var filename =
            if (capture.name == null) defaultFilename else capture.name
        filename += "." + capture.format.toString().toLowerCase()
        val imageFolder = mDefaultScreenshotPath
        imageFolder.mkdirs()
        if (!imageFolder.isDirectory && !imageFolder.canWrite()) {
            throw IOException(
                String.format(
                    "The directory %s does not exist and could not be created or is not " + "writable.",
                    imageFolder
                )
            )
        }
        val imageFile = File(imageFolder, filename)
        var out: BufferedOutputStream? = null
        try {
            out = BufferedOutputStream(FileOutputStream(imageFile))
            capture.bitmap.compress(capture.format, 100, out)
            out.flush()
        } finally {
            try {
                out?.close()
            } catch (e: IOException) {
                Log.e(mTag, "Could not close output steam.", e)
            }
        }
        return filename
    }

    /** Returns the default filename for this class suffixed with a UUID.  */
    private val defaultFilename: String
        get() = (mDefaultFilenamePrefix
                + mFileNameDelimiter
                + sAndroidDeviceName
                + mFileNameDelimiter
                + sAndroidRuntimeVersion)

    companion object {
        private var sAndroidRuntimeVersion = Build.VERSION.SDK_INT
        private var sAndroidDeviceName = Build.DEVICE
    }
}