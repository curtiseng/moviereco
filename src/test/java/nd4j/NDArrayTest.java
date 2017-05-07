package nd4j;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * nd4j学习创建矩阵
 *
 * Created by yangzifeng on 2017/5/4.
 */

public class NDArrayTest {

    @Test
    public void createNDArray() {
        INDArray ndArray = Nd4j.zeros(5);
        System.out.println(ndArray);

        INDArray nd = Nd4j.create(new float[]{1, 2, 3, 4}, new int[]{2, 2});

        System.out.println(nd);
    }

    @Test
    public void createINDArray(){
        //用户数，通过mysql查出来
        int x = 2;
        //只看4个电影的用户相似度，加上用户的id就是5
        int y = 5;

        INDArray indArray =  Nd4j.create(new double[]{1,9.0,9.5,8.5,9.0,2,9.0,9.5,8.5,9.0},new int[]{x,y});
        System.out.println(indArray);
    }
}
