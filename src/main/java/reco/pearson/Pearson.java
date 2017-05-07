package reco.pearson;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * ND4J的皮尔逊算法实现
 * 将一个用户对所有电影的评分作为一个向量，然后两两用户计算他们之间的相似性（皮尔逊系数）
 * Created by yangzifeng on 2017/5/4.
 */
public class Pearson {
    private static PearsonsCorrelation pearsonsCorrelation;


    public INDArray createNDArray(){
        //只看4个电影的用户相似度，加上用户就是5
        int x = 5;
        //用户数，通过mysql查出来
        int y = 0;
        return Nd4j.create(new double[]{1,9.0,9.5,8.5,9.0,2,9.0,9.5,8.5,9.0},new int[]{5,2});
    }

    public static double excute(double[] x, double[] y) {
        if (pearsonsCorrelation == null){
            pearsonsCorrelation = new PearsonsCorrelation();
        }

        return pearsonsCorrelation.correlation(x, y);
    }

}
