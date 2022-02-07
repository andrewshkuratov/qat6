package edu.sumdu.tss.unit.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import edu.sumdu.tss.elephant.helper.Hmac;
import org.junit.jupiter.api.Test;

public class HMacTest {

    @Test
    void calculate() {
        try {
            String result = "c5f97ad9fd1020c174d7dc02cf83c4c1bf15ee20ec555b690ad58e62da8a00ee44ccdb65cb8c80acfd127ebee568958a";
            String testData = "data";
            String testKey = "key";
            assertEquals(result, Hmac.calculate(testData, testKey));
        } catch(Throwable error) {
            fail();
        }
    }
}
