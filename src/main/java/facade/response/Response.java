package facade.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
@Builder
public class Response <T>{
    T dataResponse;

    StatutResponse statutResponse;
    String statutMessage;
}
