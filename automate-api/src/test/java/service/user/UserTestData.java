package service.user;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class UserTestData {
    static Stream<Arguments> get(){
        return Stream.of(
                arguments("标准UserID","Chenlan","ok",0),
                arguments("不区分大小写UserID","chenlan","ok",0),
                arguments("UserID为空"," ","userid not found,",60111),
                arguments("UserID为null","null","userid not found,",60111)
        );
    }
}
