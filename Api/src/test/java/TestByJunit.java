import com.emp.service.activemq.ProduceService;
import com.emp.vo.QueryEmpParams;
import com.limovue.common.myEnum.MQSendType;
import com.limovue.common.util.JsonUtils;
import com.limovue.main.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestByJunit {

    @Autowired
    private ProduceService produceService;

    private Logger logger = LoggerFactory.getLogger(TestByJunit.class);

    private String[] emailParams = {"0","1","2","3","4","5","6","7","8","9"};

    @Test
    public void contextLoads() {
        logger.info("队列<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        String[] first = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨"};
        String[] second = {"", "彦", "浩", "章", "子", "法", "晨", "奕", "玉", "昕", "洋", "恒", "思", "海"};
        String[] thired = {"", "龙", "鹏", "洪", "晨", "敏", "熙", "东", "南", "西", "北", "中", "杰"};
        for (int i = 1; i <= 10; i++) {
            QueryEmpParams param = new QueryEmpParams();
            Random ran = new Random();
            param.setId(ran.nextInt(500));
            param.setBirthday("1988-05-06");
            param.setEmail("aaa@qq.com");
            param.setGender(String.valueOf(ran.nextInt(2)));
            String name = first[ran.nextInt(first.length)] + second[ran.nextInt(second.length)] + thired[ran.nextInt(thired.length)];
            param.setName(name);
            String memberInfo = JsonUtils.object2JsonString(param);
            produceService.sendMessage("queue.member", memberInfo, MQSendType.QUEUE);

        }
    }

    @Test
    public void contextTopicLoads() {
        logger.info("广播<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        String[] first = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨"};
        String[] second = {"", "彦", "浩", "章", "子", "法", "晨", "奕", "玉", "昕", "洋", "恒", "思", "海"};
        String[] thired = {"", "龙", "鹏", "洪", "晨", "敏", "熙", "东", "南", "西", "北", "中", "杰"};

        for (int i = 1; i <= 6; i++) {
            QueryEmpParams param = new QueryEmpParams();
            Random ran = new Random();
            param.setId(ran.nextInt(50));
            param.setBirthday("1988-05-06");
            param.setEmail(getEmail());
            param.setGender(String.valueOf(ran.nextInt(2)));
            String name = first[ran.nextInt(first.length)] + second[ran.nextInt(second.length)] + thired[ran.nextInt(thired.length)];
            param.setName(name);
            String memberInfo = JsonUtils.object2JsonString(param);
            logger.info(memberInfo);
            produceService.sendMessage("topic.member", memberInfo, MQSendType.TOPIC);

        }
    }

    private String getEmail(){
        String email = null;
        Random ran = new Random();
        int emailLength = ran.nextInt(10)+1;
        int firstIndex = ran.nextInt(emailParams.length-1)+1;
        StringBuffer sb = new StringBuffer(emailParams[firstIndex]);
        for(int i = 0; i < emailLength; i++){
            sb.append(emailParams[ran.nextInt(emailParams.length-1)]);
        }
        sb.append("@qq.com");
        email = sb.toString();
        return email;
    }
}
