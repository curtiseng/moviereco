package reco.service.Impl;

import org.junit.Test;
import reco.service.ListMovies;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * Created by yangzifeng on 2017/5/5.
 */
public class TestCase {

    @Test
    public void test1() {
        Properties p = new Properties();
        try {
            p.load(ListMovies.class.getClassLoader().getResourceAsStream("reco.properties"));
            System.out.println(p.getProperty("pageSize"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
