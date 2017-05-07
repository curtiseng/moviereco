package reco.service;

import reco.util.ResultForJson;

/**
 *
 * Created by yangzifeng on 2017/5/5.
 */
public interface ListMovies {

    ResultForJson findAllMovie(int pageNo);
}
