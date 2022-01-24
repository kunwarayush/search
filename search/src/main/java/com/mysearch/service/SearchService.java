package com.mysearch.service;

import com.mysearch.dto.LabelDTO;
import com.mysearch.dto.SearchDTO;

import java.util.List;

public interface SearchService {
    public List<LabelDTO>getTopKSearchLabelsFromString(String searchString);
    public List<SearchDTO>getTopKSearchDTOsFromString(String searchString);
}
