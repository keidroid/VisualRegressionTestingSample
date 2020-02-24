package red.torch.vrtsample.activity

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import com.jraska.falcon.Falcon
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import red.torch.vrtsample.MainActivity
import java.io.File

@RunWith(AndroidJUnit4::class)
class FalconScreenshotTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    private val directory = File("/sdcard", "screenshots")

    @Before
    fun setUp() {
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw IllegalAccessException("Unable to create screenshot directory " + directory.absolutePath)
            }
        }
    }

    @Test
    fun falconScreenshotTest() {
        activityScenarioRule.scenario.onActivity {
            // Saving screenshot to file
            Falcon.takeScreenshot(it, File(directory, "falcon_simple.png"))

            // Take bitmap and do whatever you want
            // var bitmap: Bitmap = Falcon.takeScreenshotBitmap(activity)
        }
    }
}