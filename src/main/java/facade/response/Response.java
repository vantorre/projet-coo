package facade.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Response <T>{
    T dataResponse;

    StatutResponse statutResponse;
    String statutMessage;

    public Response(T content,StatutResponse statutResponse){
        this.dataResponse=content;
        this.statutResponse=statutResponse;
    }

    public Response(StatutResponse statutResponse) {
        this.statutResponse=statutResponse;
    }
}
