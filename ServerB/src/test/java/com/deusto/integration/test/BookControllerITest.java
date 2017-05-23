package com.deusto.integration.test;

import com.deusto.dtos.FilterDTO;
import com.deusto.integration.test.common.AbstractIT;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class BookControllerITest extends AbstractIT {

//    Logger logger = Logger.getLogger(BookControllerITest.class.getName());
    final static Logger logger = LoggerFactory.getLogger(BookControllerITest.class);
    @Test
    @UsingDataSet(locations = "/json/controllers/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    @WithUserDetails(value = "usermail@mail.com")
    public void getAllBooksFilter() throws Exception {
        FilterDTO filterDTO = new FilterDTO();

        filterDTO.setTitle("Test-book-1");
        filterDTO.setGenre("genre2");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(filterDTO);

        MvcResult result = mvc.perform(post("/book/filter")
                .contentType(APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andReturn();

        logger.info(result.getResponse().getContentAsString());
    }

    @Test
    @UsingDataSet(locations = "/json/controllers/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    @WithUserDetails(value = "usermail@mail.com")
    public void findAll() throws Exception {
        MvcResult result = mvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andReturn();
        logger.info(result.getResponse().getContentAsString());
    }
}
