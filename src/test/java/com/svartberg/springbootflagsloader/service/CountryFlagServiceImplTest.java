package com.svartberg.springbootflagsloader.service;

import com.svartberg.springbootflagsloader.client.CountryFlagClient;
import com.svartberg.springbootflagsloader.dto.CountryFlagDTO;
import com.svartberg.springbootflagsloader.exception.DirectoryDoesNotExist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CountryFlagServiceImplTest {

    private static final String RIGHT_PATH = "D:/tmp/countries/flags";

    private static final String WRONG_PATH = "somePath";

    @Mock
    CountryFlagServiceImpl countryFlagService;

    @Test
    public void whenSaveCountryFlagsCalledVerified() {
        CountryFlagDTO countryFlagDTO = new CountryFlagDTO();

        countryFlagService.saveCountryFlags(countryFlagDTO);

        verify(countryFlagService, times(1)).saveCountryFlags(countryFlagDTO);
    }

    @Test(expected = Exception.class)
    public void whenSaveCountryFlagsAddThrows() {
        doThrow().when(countryFlagService).saveCountryFlags(isNull());

        countryFlagService.saveCountryFlags(null);
    }

    @Test(expected = DirectoryDoesNotExist.class)
    public void whenSaveCountryFlagsShouldReturnValidateSavePathException() {
        CountryFlagDTO countryFlagDTO = new CountryFlagDTO();
        countryFlagDTO.setPath(WRONG_PATH);

        doThrow(DirectoryDoesNotExist.class)
                .when(countryFlagService)
                .saveCountryFlags(countryFlagDTO);

        countryFlagService.saveCountryFlags(countryFlagDTO);
    }
}