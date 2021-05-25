package br.ce.wcaquino.taskbackend.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ DateUtils.class })
public class DateUtilsTest {

    @Test
    public void deveRetornarTrueQuandoDataIgual(){
        LocalDate localDate = LocalDate.of(2021,05,20);

        PowerMockito.mockStatic(LocalDate.class);

        Mockito.when(LocalDate.now()).thenReturn(localDate);

        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(localDate);

        assertTrue(equalOrFutureDate);
    }

    @Test
    public void deveRetornarTrueQuandoDataMaior(){
        LocalDate localDate      = LocalDate.of(2021,05,20);
        LocalDate localDateMenor = LocalDate.of(2021,05,19);

        PowerMockito.mockStatic(LocalDate.class);

        Mockito.when(LocalDate.now()).thenReturn(localDateMenor);

        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(localDate);

        assertTrue(equalOrFutureDate);
    }

    @Test
    public void deveRetornarFalseQuandoDataMenor() throws NoSuchMethodException {
        LocalDate localDate      = LocalDate.of(2021,05,20);
        LocalDate localDateMaior = LocalDate.of(2021,05,21);

        PowerMockito.mockStatic(LocalDate.class);

        Mockito.when(LocalDate.now()).thenReturn(localDateMaior);

        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(localDate);

        assertFalse(equalOrFutureDate);
    }

}