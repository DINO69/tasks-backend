package br.ce.wcaquino.taskbackend.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
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
    public void deveRetornarTrueQuandoDataIgualSemPowerMockito(){
        LocalDate localDate = LocalDate.now();

        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(localDate);

        assertTrue(equalOrFutureDate);
    }

    @Test
    public void deveRetornarTrueQuandoDataMaior(){
        LocalDate localDate = LocalDate.of(2021,05,20);
        LocalDate mockDateMenor = LocalDate.of(2021,05,19);

        PowerMockito.mockStatic(LocalDate.class);

        Mockito.when(LocalDate.now()).thenReturn(mockDateMenor);

        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(localDate);

        assertTrue(equalOrFutureDate);
    }

    @Test
    public void deveRetornarTrueQuandoDataMaiorSemPowerMockito(){
        LocalDate localDateMaior = LocalDate.now().plus(1, DAYS);

        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(localDateMaior);

        assertTrue(equalOrFutureDate);
    }

    @Test
    public void deveRetornarFalseQuandoDataMenor() {
        LocalDate localDate = LocalDate.of(2021,05,20);
        LocalDate mockDateMaior = LocalDate.of(2021,05,21);

        PowerMockito.mockStatic(LocalDate.class);

        Mockito.when(LocalDate.now()).thenReturn(mockDateMaior);

        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(localDate);

        assertFalse(equalOrFutureDate);
    }

    @Test
    public void deveRetornarFalseQuandoDataMenoSemPowerMockito() {
        LocalDate localDateMenor = LocalDate.now().minus(1,DAYS);

        boolean equalOrFutureDate = DateUtils.isEqualOrFutureDate(localDateMenor);

        assertFalse(equalOrFutureDate);
    }

}