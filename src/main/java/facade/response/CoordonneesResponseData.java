package facade.response;

import lombok.*;
import mapper.objetMetier.Coordonnees;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoordonneesResponseData {
    int XAxis;
    int YAxis;

    public CoordonneesResponseData(Coordonnees coordonnees){
        this.XAxis=coordonnees.getXAxis();
        this.YAxis=coordonnees.getYAxis();
    }

}
