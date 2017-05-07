package reco.dao;

import org.springframework.stereotype.Repository;
import reco.entity.Rating;

import java.util.List;

/**
 *
 * Created by yangzifeng on 2017/5/4.
 */
@Repository
public interface RecoDao {

    List<Rating> findRating();

}
