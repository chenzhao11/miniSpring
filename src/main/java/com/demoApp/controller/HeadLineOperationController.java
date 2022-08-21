package com.demoApp.controller;

import com.demoApp.entity.HeadLine;
import com.demoApp.entity.Result;
import com.minispring.core.anotation.Controller;
import com.minispring.mvc.annotation.RequestMapping;
import com.minispring.mvc.annotation.RequestParam;
import com.minispring.mvc.type.ModelAndView;
import com.minispring.mvc.type.RequestMethod;

@Controller
@RequestMapping(value = "headline")
public class HeadLineOperationController {
    //添加
    @RequestMapping(value = "add",method = RequestMethod.POST)
  public ModelAndView addHeadLine(@RequestParam("lineName") String lineName,
                                  @RequestParam("lineLink") String lineLink,
                                  @RequestParam("lineImg") String lineImg,
                                  @RequestParam("priority") Integer priority){
        HeadLine headLine = new HeadLine();
        headLine.setLineName(lineName);
        headLine.setLineImg(lineImg);
        headLine.setLineLink(lineLink);
        headLine.setPriority(priority);
        //TODO
        Result<Boolean> result = new Result<>();
        result.setCode(200);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView("addHeadline.jsp").addViewData("result",result);
        return  modelAndView;
    }
    @RequestMapping(value = "toadd",method = RequestMethod.GET)
    public ModelAndView toAddPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView("addHeadline.jsp");
        return modelAndView;
    }
}
