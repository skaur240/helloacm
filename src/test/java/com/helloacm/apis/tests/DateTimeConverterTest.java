package com.helloacm.apis.tests;

import com.helloacm.apis.api.StatusCode;
import com.helloacm.apis.api.applicationApi.DateTimeApis;
import com.helloacm.apis.utils.ConfigLoader;
import com.helloacm.apis.utils.DataLoader;
import com.helloacm.apis.utils.DateUtils;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.helloacm.apis.api.Route.API_PATH;


@Epic("TimeStamp Date Converter Epic")
@Feature("TimeStamp Date Converter Feature")
public class DateTimeConverterTest extends BaseTest {

    private String FALSE="false";
    @Story("TimeStampConverter Test")
    @Description("Testcase-1 | positive | ")
    @Test(description = "Convert Date String to Unix timestamp  for past date")
    public void convert_StringDate_ToUnixTs_Tc01(){
        String s="2022-01-06 15:14:52";
        Response response = DateTimeApis.get(API_PATH,s);
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(1));
    }


    @Story("TimeStampConverter Test")
    @Description("Testcase-2 | positive | ")
    @Test(description = "Convert Date String to Unix timestamp  for future date")
    public void convert_StringDate_ToUnixTs_Tc02(){
        Response response = DateTimeApis.get(API_PATH,"2024-10-06 16:9:35");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(2));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-3 | positive | ")
    @Test(description = "Convert  Unix timestamp   to Date String for future date")
    public void convert_UnixTs_StringDate_Tc03(){
        Response response = DateTimeApis.get(API_PATH,"1704130801");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(3));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-4 | positive | ")
    @Test(description = "Convert  Unix timestamp   to Date String for past date")
    public void convert_UnixTs_StringDate_Tc04(){
        Response response = DateTimeApis.get(API_PATH,"1641472833");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(4));
    }

    @Story("TimeStampConverter Test")
    @Description("Testcase-5 | positive | ")
    @Test(description = "Convert Date String to Unix timestamp  with only time data  without date")
    public void convert_StringDate_ToUnixTs_Tc05(){
        Response response = DateTimeApis.get(API_PATH,"16:9:35");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(5));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-6 | negative | ")
    @Test(description = "Convert Date String to Unix timestamp   with invalid data")
    public void convert_StringDate_ToUnixTs_Tc06(){
        Response response = DateTimeApis.get(API_PATH,"abcd");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), FALSE);
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-7 | negative | ")
    @Test(description = "Convert Date String to Unix timestamp   with blank data")
    public void convert_StringDate_ToUnixTs_Tc07(){
        Response response = DateTimeApis.get(API_PATH,"");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), FALSE);
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-8 | negative | ")
    @Test(description = "Convert Date String to Unix timestamp   with wrong api method type")
    public void convert_StringDate_ToUnixTs_Tc08(){
        Response response = DateTimeApis.post(API_PATH,"");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_503.getCode());
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-9 | negative | ")
    @Test(description = "Convert Date String to Unix timestamp  without cached query param")
    public void convert_StringDate_ToUnixTs_Tc09(){
        Response response = DateTimeApis.get_withoutCached(API_PATH,"2023-10-06 16:9:35");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_503.getCode());
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-10 | positive | ")
    @Test(description = "Convert  Unix timestamp to  Date String   with s = 0")
    public void convert_StringDate_ToUnixTs_Tc10(){
        Response response = DateTimeApis.get(API_PATH,"0");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(10));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-11 | positive | ")
    @Test(description = "Convert Unix timestamp  to  Date String  with s = 1234 (integer)")
    public void convert_StringDate_ToUnixTs_Tc11(){
        Response response = DateTimeApis.get(API_PATH,"1234");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(11));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-12 | positive | ")
    @Test(description = "Convert  Unix timestamp to Date String   with s = 9999999999999")
    public void convert_StringDate_ToUnixTs_Tc12(){
        Response response = DateTimeApis.get(API_PATH,"1234");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(12));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-13 | positive | ")
    @Test(description = "Convert Date String to Unix timestamp  with date format yyyy-MM-dd")
    public void convert_StringDate_ToUnixTs_Tc13(){
        Response response = DateTimeApis.get(API_PATH,"2023-12-04");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(13));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-14 | positive | ")
    @Test(description = "Convert Date String to Unix timestamp with format yyyy:MM:dd ")
    public void convert_StringDate_ToUnixTs_Tc14(){
        Response response = DateTimeApis.get(API_PATH,"2023:12:04");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(14));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-15 | negative | ")
    @Test(description = "Convert Date String to Unix timestamp with format yyyy:MM ")
    public void convert_StringDate_ToUnixTs_Tc15(){
        Response response = DateTimeApis.get(API_PATH,"2024:12");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), FALSE);
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-16 | positive | ")
    @Test(description = "Convert Date String to Unix timestamp with format yyyy/MM/dd ")
    public void convert_StringDate_ToUnixTs_Tc16(){
        Response response = DateTimeApis.get(API_PATH,"2023/12/04");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(16));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-16 | positive | ")
    @Test(description = "Convert Date String to Unix timestamp with format hh:mm:ss yyyy/MM/dd ")

    public void convert_StringDate_ToUnixTs_Tc17(){
        Response response = DateTimeApis.get(API_PATH,"18:10:33 2023/12/04");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(17));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-17 | positive | ")
    @Test(description = "Convert  Unix timestamp   to Date String with negative unix value")
    public void convert_UnixTs_StringDate_Tc18(){
        Response response = DateTimeApis.get(API_PATH,"-1234");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(), DataLoader.getInstance().getTestData(18));
    }
    @Story("TimeStampConverter Test")
    @Description("Testcase-16 | positive | ")
    @Test(description = "Convert Date String to Unix timestamp with format hh:mm:ss yyyy/MM/dd  where month is invalid (13)")

    public void convert_StringDate_ToUnixTs_Tc19(){
        Response response = DateTimeApis.get(API_PATH,"18:10:33 2023/13/04");
        Assert.assertEquals(response.statusCode(),StatusCode.CODE_200.getCode());
        Assert.assertEquals(response.asString(),FALSE);
    }
}
