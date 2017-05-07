package reco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reco.service.UserBaseReco;
import reco.util.ResultForJson;

import javax.annotation.Resource;

/**
 *
 * Created by yangzifeng on 2017/5/6.
 */
@RequestMapping("/reco")
@Controller
public class RecoController {
    @Resource(name = "userBaseRecoImpl")
    private UserBaseReco userBaseReco;

    @RequestMapping("/cf")
    public @ResponseBody ResultForJson userReco(String userId){
        return userBaseReco.reco(userId);
    }
}
