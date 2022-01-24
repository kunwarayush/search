package com.mysearch.search.endpoints.unit.service;

import com.mysearch.entity.SearchEntity;
import com.mysearch.repository.SearchRepository;
import com.mysearch.service.SearchService;
import com.mysearch.service.impl.SearchServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

    @InjectMocks
    private SearchServiceImpl searchService;

    @Mock
    private SearchRepository searchRepository;

    @Test
    public void getTopKSearchLabelsTest(){
        String searchString = "Test";
        when(searchRepository.findTopKSearches(searchString)).thenReturn(Stream
                .of(new SearchEntity(1, "abcd", 31), new SearchEntity(2, "efgh", 35)).collect(Collectors.toList()));
        assertEquals(2, searchService.getTopKSearchLabelsFromString(searchString).size());
    }

    @Test
    public void getTopKSearchDTOsTest(){
        String searchString = "Test";
        when(searchRepository.findTopKSearches(searchString)).thenReturn(Stream
                .of(new SearchEntity(1, "abcd", 31), new SearchEntity(2, "efgh", 35)).collect(Collectors.toList()));
        assertEquals(2, searchService.getTopKSearchDTOsFromString(searchString).size());
    }
}
