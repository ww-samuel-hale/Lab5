//Groovy or Java syntax
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.shino.de/parkcalc/')

//WebUI.click(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/td_Please input entry date and time'))
//WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/td_Please input entry date and time'),'Short-Term Parking')
//WebUI.selectOptionByValue(findTestObject('Object Repository/OR_Valet/ParkingLot'),findTestData('ParkingData').getValue(1, rowNum), true)
//TotalRow = 2
TotalRow = findTestData('ParkingData').getRowNumbers()

for (rowNum = 1; rowNum <= TotalRow; rowNum++) {
    EntryDate = findTestData('ParkingData').getValue(2, rowNum)

    EntryTime = findTestData('ParkingData').getValue(3, rowNum)

    ExitDate = findTestData('ParkingData').getValue(4, rowNum)

    ExitTime = findTestData('ParkingData').getValue(5, rowNum)

    ExpectedCost = findTestData('ParkingData').getValue(6, rowNum)

    ParkingLotName = findTestData('ParkingData').getValue(1, rowNum)

    //WebUI.selectOptionByValue(findTestObject('Object Repository/OR_Valet/ParkingLot'),findTestData('ParkingData').getValue(1, rowNum), true)
    WebUI.selectOptionByValue(findTestObject('Object Repository/OR_Valet/ParkingLot'), ParkingLotName, true)

    WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_AMPM_StartingDate'), EntryDate)

    //WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_AMPM_StartingDate'), findTestData('ParkingData').getValue(2, rowNum))
    WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_AMPM_StartingTime'), EntryTime)

    //WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_AMPM_StartingTime'), findTestData('ParkingData').getValue(3, rowNum))
    WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_AMPM_LeavingDate'), ExitDate)

    //WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_AMPM_LeavingDate'), findTestData('ParkingData').getValue(4, rowNum))
    WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_AMPM_LeavingTime'), ExitTime)

    //WebUI.setText(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_AMPM_LeavingTime'), findTestData('ParkingData').getValue(5, rowNum))
    WebUI.click(findTestObject('Object Repository/OR_Valet/Page_Parking Cost Calculator/input_0_Submit'))

    WebUI.verifyTextPresent(ExpectedCost, false, FailureHandling.CONTINUE_ON_FAILURE)

    //WebUI.verifyTextPresent(findTestData('ParkingData').getValue(6, rowNum), false, FailureHandling.CONTINUE_ON_FAILURE)
    WebUI.selectOptionByValue(findTestObject('Object Repository/OR_Valet/ParkingLot'), ParkingLotName, true)

    //WebUI.takeScreenshot()

    WebUI.delay(5)
}

WebUI.delay(10)

WebUI.closeBrowser()

