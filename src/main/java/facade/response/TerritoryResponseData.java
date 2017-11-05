package facade.response;

import lombok.Getter;
import lombok.Setter;
import mapper.objetMetier.Territory;
import mapper.objetMetier.TypeTerritory;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
public class TerritoryResponseData {
    TypeTerritory typeTerritory;
    TerritoryContentResponseData territoryContent;

    public TerritoryResponseData(Territory territory){
        this.typeTerritory=territory.getType();
        this.territoryContent=new TerritoryContentResponseData(territory);
    }
}
