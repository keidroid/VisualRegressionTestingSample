package red.torch.vrtsample.activity

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.screenshot.Screenshot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import red.torch.vrtsample.MainActivity
import red.torch.vrtsample.MyScreenCaptureProcessor

@RunWith(AndroidJUnit4::class)
class AndroidXScreenshotTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun basicProcessorScreenshotTest() {
        //Screenshot.setScreenshotProcessors(setOf(BasicScreenCaptureProcessor()))

        activityScenarioRule.scenario.onActivity {
        //    Screenshot.capture(it).setName("androidx-basic").process()
        }
    }

    @Test
    fun customProcessorScreenshotTest() {
        Screenshot.setScreenshotProcessors(setOf(MyScreenCaptureProcessor()))

        activityScenarioRule.scenario.onActivity {
            Screenshot.capture(it).setName("androidx-custom").process()
        }
    }
}