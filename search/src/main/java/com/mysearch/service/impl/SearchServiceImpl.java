package com.mysearch.service.impl;

import com.mysearch.dto.LabelDTO;
import com.mysearch.dto.SearchDTO;
import com.mysearch.entity.SearchEntity;
import com.mysearch.repository.SearchRepository;
import com.mysearch.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public List<LabelDTO>getTopKSearchLabelsFromString(String searchString){
        List<SearchDTO>searchDTOList = getTopKSearchDTOsFromString(searchString);
        List<LabelDTO>labelDTOList = getLabelDTOListFromSearchDTOs(searchDTOList);
        if(labelDTOList != null){
            return labelDTOList;
        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public List<SearchDTO> getTopKSearchDTOsFromString(String searchString){
        List<SearchEntity>searchList = searchRepository.findTopKSearches(searchString);
        if(searchList != null){
            return getSearchDTOListFromEntityList(searchList);
        }else {
            return new ArrayList<>();
        }
    }

    private List<SearchDTO>getSearchDTOListFromEntityList(List<SearchEntity>entityList){
        List<SearchDTO>dtoList = new ArrayList<>();
        for(int i = 0;i < entityList.size();i++){
            dtoList.add(getSearchDTOFromEntity(entityList.get(i)));
        }
        return dtoList;
    }
    private SearchDTO getSearchDTOFromEntity(SearchEntity searchEntity){
        SearchDTO searchDTO = new SearchDTO();
        searchDTO.setSearchString(searchEntity.getSearchString());
        searchDTO.setFrequency(searchEntity.getFrequency());
        searchDTO.setId(searchEntity.getId());
        return searchDTO;
    }
    private List<LabelDTO>getLabelDTOListFromSearchDTOs(List<SearchDTO>searchResults){
        List <LabelDTO>searchLabelDTOs = new ArrayList<>();
        for (SearchDTO searchDTO : searchResults) {
                LabelDTO labelDTO = new LabelDTO();
                labelDTO.setLabel(searchDTO.getSearchString());
                labelDTO.setValue(String.valueOf(searchDTO.getId()));
            searchLabelDTOs.add(labelDTO);
            }
        return searchLabelDTOs;
    }
}
