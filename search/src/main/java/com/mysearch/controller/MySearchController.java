package com.mysearch.controller;


import com.mysearch.dto.LabelDTO;
import com.mysearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MySearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }
    @GetMapping("/searchTopK")
    @ResponseBody
    public List<LabelDTO> getTop10SearchResultByString(@RequestParam("term") String searchString){
        List <LabelDTO>searchAutoSuggest = searchService.getTopKSearchLabelsFromString(searchString);
        return searchAutoSuggest;
    }


}
