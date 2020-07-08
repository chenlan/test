package junit;

import common.DataFileManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import service.ApiObjectModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.condition.OS.MAC;
public class AlluerTest {


    public void demo1() {
        String regString = "\\$\\{(.+?)\\}"; //   "\\$\\{([^}]*)\\}"
        Pattern pattern = Pattern.compile(regString);
        String dd = "${abcd}ddddd${55555}ggg";
            Matcher mc= pattern.matcher(dd);
            while(mc.find()){
                System.out.println(mc.group(1));
                //item.setValue(params.get(mc.group()));
            }

    }

    @BeforeEach
    public void beforeEach(TestInfo context){
        System.out.println("beforEach");
    }

//    @Test
//    public void ddd(){
//        ApiObjectModel model = DataFileManager.readValue("/service/user/api/User", ApiObjectModel.class);
//        ApiObjectModel d = model;
//    }

    @Test
    public void demoTest2(){
        Assert.assertEquals(1,1);
    }
}
