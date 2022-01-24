package com.mysearch.search.endpoints.unit.controller;
import com.mysearch.controller.SearchRestController;
import com.mysearch.dto.LabelDTO;
import com.mysearch.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchRestController.class)
public class SearchControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SearchService searchService;

    @Test
    public void getTopKSearchRestAPITest() throws Exception {
        List<LabelDTO> labelDTOList = new ArrayList<>();
        LabelDTO  labelDTO = new LabelDTO();
        labelDTO.setLabel("Test");
        labelDTO.setValue("10");
        labelDTOList.add(labelDTO);
        given(searchService.getTopKSearchLabelsFromString("Test")).willReturn(labelDTOList);
        mockMvc.perform(get("/SearchService/searchTopK").
                contentType(MediaType.APPLICATION_JSON).
                param("term","Test")).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].label", is(labelDTO.getLabel())));
    }

}
