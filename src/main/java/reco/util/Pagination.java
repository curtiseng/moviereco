package reco.util;

import org.springframework.stereotype.Component;
import reco.service.ListMovies;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 分页计算器
 * Created by yangzifeng on 2017/5/5.
 */
@Component
public class Pagination {
    // 每页显示条数
    private static int pageSize;


    static {
        //读取连接参数
        Properties p = new Properties();
        try {
            p.load(ListMovies.class.getClassLoader().getResourceAsStream("reco.properties"));
            pageSize = Integer.parseInt(p.getProperty("pageSize"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map<String,Integer> pageResult(int totalSize, int pageNo){

        Map<String, Integer> result = new HashMap<>();

        int offset = pageSize * pageNo;
        int limit = pageSize;
        int totalPage = totalSize / pageSize;
        if (totalSize > totalPage * pageSize){
            totalPage += 1;
        }

        result.put("offset",offset);
        result.put("limit",limit);
        result.put("totalPage",totalPage);

        return result;
    }

}
