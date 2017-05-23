package org.test.dtos;


import org.junit.Rule;
import org.junit.Test;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.dtos.AddressDTO;

public class AddressDTOUTest {

	@Rule
	public ContiPerfRule i = new ContiPerfRule();	
	@Test
	@PerfTest(invocations = 5)
	@Required(max = 120, average = 50)
    public void validBookDTO() {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCountry("Moldova");
        addressDTO.setStreet("Stephan the Great");
        addressDTO.setCity("Chisinau");
        addressDTO.setApartamentNumber(123);
        addressDTO.setHouseNumber(666);
        addressDTO.setPostalCode("4822");

        assertThat(addressDTO.getCity(), is("Chisinau"));
        assertThat(addressDTO.getStreet(), is("Stephan the Great"));
        assertThat(addressDTO.getCountry(), is("Moldova"));
        assertThat(addressDTO.getApartamentNumber(), is(123));
        assertThat(addressDTO.getHouseNumber(), is(666));
        assertThat(addressDTO.getPostalCode(), is("4822"));
        
    }
}
