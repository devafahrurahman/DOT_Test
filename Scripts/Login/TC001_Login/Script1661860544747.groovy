import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.Base_url)

for (def index : (1..4)) {
    WebUI.setText(findTestObject('Login/Input_Email'), findTestData('LoginFacebook').getValue(2, index))

    WebUI.setText(findTestObject('Login/Input_Password'), findTestData('LoginFacebook').getValue(3, index))

    WebUI.click(findTestObject('Login/Btn_Login'))
	
	def keterangan = findTestData('LoginFacebook').getValue(4, index)
	
	if (keterangan == 'invalid') {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Verifyinvalid'), 30)
	} else {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login/VerifyValid'), 30)
	}
}

