package com.mysearch.repository;

import com.mysearch.Constants;
import com.mysearch.entity.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<SearchEntity,Integer>  {
    @Query(value = "SELECT * FROM search_data s where s.search_string like :searchKeyword% ORDER BY frequency DESC LIMIT " +  Constants.MAX_AUTOSUGGEST,nativeQuery = true)
    List<SearchEntity> findTopKSearches(@Param("searchKeyword") String searchString);

}
