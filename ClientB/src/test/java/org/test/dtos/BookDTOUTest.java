package org.test.dtos;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.BookDTO;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BookDTOUTest {
	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
    public void validBookDTO() {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setAgeLimit(18);
        bookDTO.setAuthorFirstName("AuthorFirstName");
        bookDTO.setAuthorLastName("AuthorLastName");
        bookDTO.setCount(3);
        bookDTO.setDescription("Description");
        bookDTO.setGenre("Genre");
        bookDTO.setPages(401);
        bookDTO.setPublishDate(1492676887470L);
        bookDTO.setTags(Arrays.asList("tag1", "tag2"));
        bookDTO.setTitle("Title");

        assertThat(bookDTO.getAgeLimit(), is(18));
    }
}
