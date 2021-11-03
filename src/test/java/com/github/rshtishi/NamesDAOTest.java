package com.github.rshtishi;

import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NamesDAOTest {

    @Test
    public void shoudlTheCorrectOrderedContent() {
        NamesDAO namesDAO = new NamesDAO();
        List<String> result = namesDAO.getNames();
        List<String> expected = Arrays.asList("Rando", "Vjola", "Ema");
        ReflectionAssert.assertReflectionEquals(expected, result);
    }

    @Test
    public void shouldReturnTheCorrectContentIndeferentToOrdering() {
        NamesDAO namesDAO = new NamesDAO();
        List<String> result = namesDAO.getNames();
        List<String> expected = Arrays.asList("Rando", "Ema", "Vjola");
        ReflectionAssert.assertReflectionEquals(expected, result, ReflectionComparatorMode.LENIENT_ORDER);
    }


}