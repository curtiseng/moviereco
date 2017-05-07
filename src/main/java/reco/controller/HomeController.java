package reco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reco.service.ListMovies;
import reco.util.ResultForJson;

import javax.annotation.Resource;

/**
 *
 * Created by yangzifeng on 2017/5/5.
 */
@RequestMapping("/movie")
@Controller
public class HomeController {
    @Resource(name = "listMoviesImpl")
    private ListMovies listMovies;

    @RequestMapping(value = {"/","/load"})
    public @ResponseBody ResultForJson loadMovies(String pageNo){
        int intPageNo = Integer.parseInt(pageNo);
        System.out.print(intPageNo);
        return listMovies.findAllMovie(intPageNo);
    }
}
