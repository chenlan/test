package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class TestParam {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, 4},
                {4, 4},
                {4, 4},
        });
    }


    @Parameterized.Parameter
    public int actual;

    @Parameterized.Parameter(1)
    public int expect;

    @Test
    public void testDemo() {
        assertThat("demoAssertThat", actual, equalTo(expect));
    }
}
