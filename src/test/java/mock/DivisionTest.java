package mock;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

//mvn clean test -Dtest=mockito.DivisionTest -Dmaven.test.failure.ignore=true verify

public class DivisionTest {

    @Test
    public void dividTest() {
        Division division = new Division();
        division = mock(Division.class);
        when(division.divid(anyInt(), anyInt())).thenReturn(200);
        MatcherAssert.assertThat(division.divid(3, 2), equalTo(0));
        //assertThat(division.divid(3,0),equalTo(0));
        verify(division).divid(anyInt(), anyInt());
    }

}
