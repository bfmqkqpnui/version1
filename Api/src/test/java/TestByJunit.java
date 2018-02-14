import com.emp.dao.EmployeeDao;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestByJunit {

    @Autowired
    private ProduceService produceService;

    @Autowired
    private EmployeeDao employeeDao;

    private Logger logger = LoggerFactory.getLogger(TestByJunit.class);

    private String[] emailParams = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

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

    /**
     * 批量插入
     */
    @Test
    public void batchSave() {
        Random ran = new Random();
        int totalCount = ran.nextInt(20) + 1;
        List<QueryEmpParams> params = new ArrayList<QueryEmpParams>();
        for (int size = 0; size < totalCount; size++) {
            QueryEmpParams param = new QueryEmpParams();
            param.setBirthday(getBirthday());
            param.setEmail(getEmail());
            int sex = ran.nextInt();
            String gender = "女";
            if (sex % 2 == 0) {
                gender = "男";
            }
            param.setGender(gender);
            param.setName(getName());
            params.add(param);
            String memberInfo = JsonUtils.object2JsonString(param);
            logger.info(memberInfo);
        }

        if (params.size() > 0) {
            int result = employeeDao.batchSave(params);
            logger.info("总共添加了" + result + "条记录");
        }

    }

    private String getEmail() {
        String email = null;
        Random ran = new Random();
        String[] mailSuffix = {"@qq.com", "@139.com", "@126.com", "@gmail.com", "@yahoo.com", "@msn.com", "@hotmail.com", "@163.com", "@263.com", "@sina.com", "@sohu.com"};
        int emailLength = ran.nextInt(6) + 5;
        int firstIndex = ran.nextInt(emailParams.length - 1) + 1;
        StringBuffer sb = new StringBuffer(emailParams[firstIndex]);
        for (int i = 0; i < emailLength; i++) {
            sb.append(emailParams[ran.nextInt(emailParams.length - 1)]);
        }
        sb.append(mailSuffix[ran.nextInt(mailSuffix.length - 1)]);
        email = sb.toString();
        return email;
    }

    private String getName() {
        String name = null;
        Random ran = new Random();
        String[] first = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "诸葛", "欧阳", "司马", "太史", "南宫", "纳兰", "公孙"};
        String[] second = {"彦", "浩", "章", "子", "法", "晨", "奕", "玉", "昕", "洋", "恒", "思", "海", "言", "姿", "琼", "嫣", "蕾"};
        String[] thired = {"龙", "鹏", "洪", "晨", "敏", "熙", "东", "南", "西", "北", "中", "杰", "衡", "智", "卓", "涵", "豪", "嘉"};
        StringBuffer sb = new StringBuffer(first[ran.nextInt(first.length - 1)]);
        int num = ran.nextInt(2) % 2;
        if (num == 0) {
            sb.append(second[ran.nextInt(second.length - 1)]);
        } else {
            sb.append(second[ran.nextInt(second.length - 1)]).append(thired[ran.nextInt(thired.length - 1)]);
        }
        name = sb.toString();
        return name;
    }

    private String getBirthday() {
        String birthday = null;
        Random ran = new Random();
        List<String> years = getYears();
        List<String> months = getMonths();
        String year = years.get(ran.nextInt(years.size() - 1) + 1);
        String month = months.get(ran.nextInt(months.size() - 1) + 1);
        int maxDaysByMonth = getMonthLastDay(Integer.parseInt(year), Integer.parseInt(month));
        List<String> days = getDays(maxDaysByMonth);
        String day = days.get(ran.nextInt(days.size() - 1) + 1);
        StringBuffer sb = new StringBuffer();
        sb.append(year).append(month).append(day);
        birthday = sb.toString();
        return birthday;
    }

    private List<String> getYears() {
        List<String> years = new ArrayList<String>();
        for (int i = 1970; i < 2001; i++) {
            String year = String.valueOf(i);
            years.add(year);
        }
        return years;
    }

    private List<String> getMonths() {
        List<String> months = new ArrayList<String>();
        for (int i = 1; i < 13; i++) {
            String month = null;
            if (i < 10) {
                month = "0" + i;
            } else {
                month = String.valueOf(i);
            }
            months.add(month);
        }
        return months;
    }

    /**
     * 获取指定月份的天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMonthLastDay(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    private List<String> getDays(int max) {
        List<String> days = new ArrayList<String>();
        for (int i = 1; i <= max; i++) {
            String day = null;
            if (i < 10) {
                day = "0" + i;
            } else {
                day = String.valueOf(i);
            }
            days.add(day);
        }
        return days;
    }
}
