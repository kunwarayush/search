package com.mysearch.controller;


import com.mysearch.dto.LabelDTO;
import com.mysearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/SearchService")
public class SearchRestController {

    @Autowired
    SearchService searchService;

    @GetMapping("/searchTopKStrings")
    @ResponseBody
    public List<LabelDTO> getTop10SearchResultByString(@RequestParam("term") String searchString){
        List <LabelDTO>searchAutoSuggest = searchService.getTopKSearchLabelsFromString(searchString);
        return searchAutoSuggest;
    }


}
